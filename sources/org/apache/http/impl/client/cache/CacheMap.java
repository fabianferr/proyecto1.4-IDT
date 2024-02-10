package org.apache.http.impl.client.cache;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.http.client.cache.HttpCacheEntry;

final class CacheMap extends LinkedHashMap<String, HttpCacheEntry> {
    private static final long serialVersionUID = -7750025207539768511L;
    private final int maxEntries;

    CacheMap(int i) {
        super(20, 0.75f, true);
        this.maxEntries = i;
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<String, HttpCacheEntry> entry) {
        return size() > this.maxEntries;
    }
}
