package org.apache.http.impl.client.cache;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.protocol.HttpContext;

class AsynchronousValidator {
    private final CacheKeyGenerator cacheKeyGenerator;
    private final CachingHttpClient cachingClient;
    private final ExecutorService executor;
    private final Log log;
    private final Set<String> queued;

    public AsynchronousValidator(CachingHttpClient cachingHttpClient, CacheConfig cacheConfig) {
        this(cachingHttpClient, (ExecutorService) new ThreadPoolExecutor(cacheConfig.getAsynchronousWorkersCore(), cacheConfig.getAsynchronousWorkersMax(), (long) cacheConfig.getAsynchronousWorkerIdleLifetimeSecs(), TimeUnit.SECONDS, new ArrayBlockingQueue(cacheConfig.getRevalidationQueueSize())));
    }

    AsynchronousValidator(CachingHttpClient cachingHttpClient, ExecutorService executorService) {
        this.log = LogFactory.getLog(getClass());
        this.cachingClient = cachingHttpClient;
        this.executor = executorService;
        this.queued = new HashSet();
        this.cacheKeyGenerator = new CacheKeyGenerator();
    }

    public synchronized void revalidateCacheEntry(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, HttpCacheEntry httpCacheEntry) {
        String variantURI = this.cacheKeyGenerator.getVariantURI(httpHost, httpRequest, httpCacheEntry);
        if (!this.queued.contains(variantURI)) {
            try {
                this.executor.execute(new AsynchronousValidationRequest(this, this.cachingClient, httpHost, httpRequest, httpContext, httpCacheEntry, variantURI));
                this.queued.add(variantURI);
            } catch (RejectedExecutionException e) {
                Log log2 = this.log;
                log2.debug("Revalidation for [" + variantURI + "] not scheduled: " + e);
            }
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public synchronized void markComplete(String str) {
        this.queued.remove(str);
    }

    /* access modifiers changed from: package-private */
    public Set<String> getScheduledIdentifiers() {
        return Collections.unmodifiableSet(this.queued);
    }

    /* access modifiers changed from: package-private */
    public ExecutorService getExecutor() {
        return this.executor;
    }
}
