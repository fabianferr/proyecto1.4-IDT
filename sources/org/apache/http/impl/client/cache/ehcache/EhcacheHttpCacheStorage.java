package org.apache.http.impl.client.cache.ehcache;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.client.cache.HttpCacheEntrySerializer;
import org.apache.http.client.cache.HttpCacheStorage;
import org.apache.http.client.cache.HttpCacheUpdateCallback;
import org.apache.http.client.cache.HttpCacheUpdateException;
import org.apache.http.impl.client.cache.CacheConfig;
import org.apache.http.impl.client.cache.DefaultHttpCacheEntrySerializer;

public class EhcacheHttpCacheStorage implements HttpCacheStorage {
    private final Ehcache cache;
    private final int maxUpdateRetries;
    private final HttpCacheEntrySerializer serializer;

    public EhcacheHttpCacheStorage(Ehcache ehcache) {
        this(ehcache, new CacheConfig(), new DefaultHttpCacheEntrySerializer());
    }

    public EhcacheHttpCacheStorage(Ehcache ehcache, CacheConfig cacheConfig) {
        this(ehcache, cacheConfig, new DefaultHttpCacheEntrySerializer());
    }

    public EhcacheHttpCacheStorage(Ehcache ehcache, CacheConfig cacheConfig, HttpCacheEntrySerializer httpCacheEntrySerializer) {
        this.cache = ehcache;
        this.maxUpdateRetries = cacheConfig.getMaxUpdateRetries();
        this.serializer = httpCacheEntrySerializer;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [byte[], java.io.Serializable] */
    public synchronized void putEntry(String str, HttpCacheEntry httpCacheEntry) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.serializer.writeTo(httpCacheEntry, byteArrayOutputStream);
        this.cache.put(new Element(str, byteArrayOutputStream.toByteArray()));
    }

    public synchronized HttpCacheEntry getEntry(String str) throws IOException {
        Element element = this.cache.get(str);
        if (element == null) {
            return null;
        }
        return this.serializer.readFrom(new ByteArrayInputStream((byte[]) element.getValue()));
    }

    public synchronized void removeEntry(String str) {
        this.cache.remove(str);
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [byte[], java.io.Serializable] */
    public synchronized void updateEntry(String str, HttpCacheUpdateCallback httpCacheUpdateCallback) throws IOException, HttpCacheUpdateException {
        int i = 0;
        while (true) {
            Element element = this.cache.get(str);
            HttpCacheEntry readFrom = element != null ? this.serializer.readFrom(new ByteArrayInputStream((byte[]) element.getValue())) : null;
            HttpCacheEntry update = httpCacheUpdateCallback.update(readFrom);
            if (readFrom == null) {
                putEntry(str, update);
                return;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            this.serializer.writeTo(update, byteArrayOutputStream);
            if (!this.cache.replace(element, new Element(str, byteArrayOutputStream.toByteArray()))) {
                i++;
                if (i > this.maxUpdateRetries) {
                    throw new HttpCacheUpdateException("Failed to update");
                }
            } else {
                return;
            }
        }
    }
}
