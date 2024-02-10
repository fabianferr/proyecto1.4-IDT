package org.apache.http.impl.client.cache;

import java.io.IOException;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.client.cache.HttpCacheStorage;
import org.apache.http.client.cache.HttpCacheUpdateCallback;

public class BasicHttpCacheStorage implements HttpCacheStorage {
    private final CacheMap entries;

    public BasicHttpCacheStorage(CacheConfig cacheConfig) {
        this.entries = new CacheMap(cacheConfig.getMaxCacheEntries());
    }

    public synchronized void putEntry(String str, HttpCacheEntry httpCacheEntry) throws IOException {
        this.entries.put(str, httpCacheEntry);
    }

    public synchronized HttpCacheEntry getEntry(String str) throws IOException {
        return (HttpCacheEntry) this.entries.get(str);
    }

    public synchronized void removeEntry(String str) throws IOException {
        this.entries.remove(str);
    }

    public synchronized void updateEntry(String str, HttpCacheUpdateCallback httpCacheUpdateCallback) throws IOException {
        this.entries.put(str, httpCacheUpdateCallback.update((HttpCacheEntry) this.entries.get(str)));
    }
}
