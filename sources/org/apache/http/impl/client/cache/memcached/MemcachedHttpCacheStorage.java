package org.apache.http.impl.client.cache.memcached;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.MemcachedClientIF;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.client.cache.HttpCacheEntrySerializer;
import org.apache.http.client.cache.HttpCacheStorage;
import org.apache.http.client.cache.HttpCacheUpdateCallback;
import org.apache.http.client.cache.HttpCacheUpdateException;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.DefaultHttpCacheEntrySerializer;

public class MemcachedHttpCacheStorage implements HttpCacheStorage {
    private final MemcachedClientIF client;
    private final int maxUpdateRetries;
    private final HttpCacheEntrySerializer serializer;

    public MemcachedHttpCacheStorage(InetSocketAddress inetSocketAddress) throws IOException {
        this((MemcachedClientIF) new MemcachedClient(new InetSocketAddress[]{inetSocketAddress}));
    }

    public MemcachedHttpCacheStorage(MemcachedClientIF memcachedClientIF) {
        this(memcachedClientIF, new CacheConfig(), new DefaultHttpCacheEntrySerializer());
    }

    public MemcachedHttpCacheStorage(MemcachedClientIF memcachedClientIF, CacheConfig cacheConfig, HttpCacheEntrySerializer httpCacheEntrySerializer) {
        this.client = memcachedClientIF;
        this.maxUpdateRetries = cacheConfig.getMaxUpdateRetries();
        this.serializer = httpCacheEntrySerializer;
    }

    public void putEntry(String str, HttpCacheEntry httpCacheEntry) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.serializer.writeTo(httpCacheEntry, byteArrayOutputStream);
        this.client.set(str, 0, byteArrayOutputStream.toByteArray());
    }

    public HttpCacheEntry getEntry(String str) throws IOException {
        byte[] bArr = (byte[]) this.client.get(str);
        if (bArr == null) {
            return null;
        }
        return this.serializer.readFrom(new ByteArrayInputStream(bArr));
    }

    public void removeEntry(String str) throws IOException {
        this.client.delete(str);
    }

    public void updateEntry(String str, HttpCacheUpdateCallback httpCacheUpdateCallback) throws HttpCacheUpdateException, IOException {
        int i = 0;
        do {
            CASValue sVar = this.client.gets(str);
            HttpCacheEntry httpCacheEntry = null;
            byte[] bArr = sVar != null ? (byte[]) sVar.getValue() : null;
            if (bArr != null) {
                httpCacheEntry = this.serializer.readFrom(new ByteArrayInputStream(bArr));
            }
            HttpCacheEntry update = httpCacheUpdateCallback.update(httpCacheEntry);
            if (sVar == null) {
                putEntry(str, update);
                return;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.serializer.writeTo(update, byteArrayOutputStream);
            if (this.client.cas(str, sVar.getCas(), byteArrayOutputStream.toByteArray()) != CASResponse.OK) {
                i++;
            } else {
                return;
            }
        } while (i <= this.maxUpdateRetries);
        throw new HttpCacheUpdateException("Failed to update");
    }
}
