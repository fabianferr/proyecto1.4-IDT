package org.apache.http.impl.client.cache;

public class CacheConfig {
    public static final int DEFAULT_ASYNCHRONOUS_WORKERS_CORE = 1;
    public static final int DEFAULT_ASYNCHRONOUS_WORKERS_MAX = 1;
    public static final int DEFAULT_ASYNCHRONOUS_WORKER_IDLE_LIFETIME_SECS = 60;
    public static final boolean DEFAULT_HEURISTIC_CACHING_ENABLED = false;
    public static final float DEFAULT_HEURISTIC_COEFFICIENT = 0.1f;
    public static final long DEFAULT_HEURISTIC_LIFETIME = 0;
    public static final int DEFAULT_MAX_CACHE_ENTRIES = 1000;
    public static final int DEFAULT_MAX_OBJECT_SIZE_BYTES = 8192;
    public static final int DEFAULT_MAX_UPDATE_RETRIES = 1;
    public static final int DEFAULT_REVALIDATION_QUEUE_SIZE = 100;
    private int asynchronousWorkerIdleLifetimeSecs = 60;
    private int asynchronousWorkersCore = 1;
    private int asynchronousWorkersMax = 1;
    private boolean heuristicCachingEnabled = false;
    private float heuristicCoefficient = 0.1f;
    private long heuristicDefaultLifetime = 0;
    private boolean isSharedCache = true;
    private int maxCacheEntries = 1000;
    private int maxObjectSizeBytes = 8192;
    private int maxUpdateRetries = 1;
    private int revalidationQueueSize = 100;

    public int getMaxObjectSizeBytes() {
        return this.maxObjectSizeBytes;
    }

    public void setMaxObjectSizeBytes(int i) {
        this.maxObjectSizeBytes = i;
    }

    public boolean isSharedCache() {
        return this.isSharedCache;
    }

    public void setSharedCache(boolean z) {
        this.isSharedCache = z;
    }

    public int getMaxCacheEntries() {
        return this.maxCacheEntries;
    }

    public void setMaxCacheEntries(int i) {
        this.maxCacheEntries = i;
    }

    public int getMaxUpdateRetries() {
        return this.maxUpdateRetries;
    }

    public void setMaxUpdateRetries(int i) {
        this.maxUpdateRetries = i;
    }

    public boolean isHeuristicCachingEnabled() {
        return this.heuristicCachingEnabled;
    }

    public void setHeuristicCachingEnabled(boolean z) {
        this.heuristicCachingEnabled = z;
    }

    public float getHeuristicCoefficient() {
        return this.heuristicCoefficient;
    }

    public void setHeuristicCoefficient(float f) {
        this.heuristicCoefficient = f;
    }

    public long getHeuristicDefaultLifetime() {
        return this.heuristicDefaultLifetime;
    }

    public void setHeuristicDefaultLifetime(long j) {
        this.heuristicDefaultLifetime = j;
    }

    public int getAsynchronousWorkersMax() {
        return this.asynchronousWorkersMax;
    }

    public void setAsynchronousWorkersMax(int i) {
        this.asynchronousWorkersMax = i;
    }

    public int getAsynchronousWorkersCore() {
        return this.asynchronousWorkersCore;
    }

    public void setAsynchronousWorkersCore(int i) {
        this.asynchronousWorkersCore = i;
    }

    public int getAsynchronousWorkerIdleLifetimeSecs() {
        return this.asynchronousWorkerIdleLifetimeSecs;
    }

    public void setAsynchronousWorkerIdleLifetimeSecs(int i) {
        this.asynchronousWorkerIdleLifetimeSecs = i;
    }

    public int getRevalidationQueueSize() {
        return this.revalidationQueueSize;
    }

    public void setRevalidationQueueSize(int i) {
        this.revalidationQueueSize = i;
    }
}
