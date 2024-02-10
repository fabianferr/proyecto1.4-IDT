package androidx.media3.datasource.cache;

public final class NoOpCacheEvictor implements CacheEvictor {
    public void onCacheInitialized() {
    }

    public void onSpanAdded(Cache cache, CacheSpan cacheSpan) {
    }

    public void onSpanRemoved(Cache cache, CacheSpan cacheSpan) {
    }

    public void onSpanTouched(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
    }

    public void onStartFile(Cache cache, String str, long j, long j2) {
    }

    public boolean requiresCacheSpanTouches() {
        return false;
    }
}
