package org.apache.http.impl.client.cache;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.client.cache.HttpCacheStorage;
import org.apache.http.client.cache.HttpCacheUpdateCallback;
import org.apache.http.client.cache.HttpCacheUpdateException;
import org.apache.http.client.cache.Resource;
import org.apache.http.client.cache.ResourceFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.message.BasicHttpResponse;

class BasicHttpCache implements HttpCache {
    private final CacheEntryUpdater cacheEntryUpdater;
    private final CacheInvalidator cacheInvalidator;
    private final Log log;
    private final int maxObjectSizeBytes;
    private final ResourceFactory resourceFactory;
    private final CachedHttpResponseGenerator responseGenerator;
    private final HttpCacheStorage storage;
    /* access modifiers changed from: private */
    public final CacheKeyGenerator uriExtractor;

    public BasicHttpCache(ResourceFactory resourceFactory2, HttpCacheStorage httpCacheStorage, CacheConfig cacheConfig) {
        this.log = LogFactory.getLog(getClass());
        this.resourceFactory = resourceFactory2;
        CacheKeyGenerator cacheKeyGenerator = new CacheKeyGenerator();
        this.uriExtractor = cacheKeyGenerator;
        this.cacheEntryUpdater = new CacheEntryUpdater(resourceFactory2);
        this.maxObjectSizeBytes = cacheConfig.getMaxObjectSizeBytes();
        this.responseGenerator = new CachedHttpResponseGenerator();
        this.storage = httpCacheStorage;
        this.cacheInvalidator = new CacheInvalidator(cacheKeyGenerator, httpCacheStorage);
    }

    public BasicHttpCache(CacheConfig cacheConfig) {
        this(new HeapResourceFactory(), new BasicHttpCacheStorage(cacheConfig), cacheConfig);
    }

    public BasicHttpCache() {
        this(new CacheConfig());
    }

    public void flushCacheEntriesFor(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        this.storage.removeEntry(this.uriExtractor.getURI(httpHost, httpRequest));
    }

    public void flushInvalidatedCacheEntriesFor(HttpHost httpHost, HttpRequest httpRequest, HttpResponse httpResponse) {
        this.cacheInvalidator.flushInvalidatedCacheEntries(httpHost, httpRequest, httpResponse);
    }

    /* access modifiers changed from: package-private */
    public void storeInCache(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) throws IOException {
        if (httpCacheEntry.hasVariants()) {
            storeVariantEntry(httpHost, httpRequest, httpCacheEntry);
        } else {
            storeNonVariantEntry(httpHost, httpRequest, httpCacheEntry);
        }
    }

    /* access modifiers changed from: package-private */
    public void storeNonVariantEntry(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) throws IOException {
        this.storage.putEntry(this.uriExtractor.getURI(httpHost, httpRequest), httpCacheEntry);
    }

    /* access modifiers changed from: package-private */
    public void storeVariantEntry(HttpHost httpHost, final HttpRequest httpRequest, final HttpCacheEntry httpCacheEntry) throws IOException {
        String uri = this.uriExtractor.getURI(httpHost, httpRequest);
        final String variantURI = this.uriExtractor.getVariantURI(httpHost, httpRequest, httpCacheEntry);
        this.storage.putEntry(variantURI, httpCacheEntry);
        try {
            this.storage.updateEntry(uri, new HttpCacheUpdateCallback() {
                public HttpCacheEntry update(HttpCacheEntry httpCacheEntry) throws IOException {
                    return BasicHttpCache.this.doGetUpdatedParentEntry(httpRequest.getRequestLine().getUri(), httpCacheEntry, httpCacheEntry, BasicHttpCache.this.uriExtractor.getVariantKey(httpRequest, httpCacheEntry), variantURI);
                }
            });
        } catch (HttpCacheUpdateException e) {
            Log log2 = this.log;
            log2.warn("Could not update key [" + uri + "]", e);
        }
    }

    public void reuseVariantEntryFor(HttpHost httpHost, HttpRequest httpRequest, Variant variant) throws IOException {
        String uri = this.uriExtractor.getURI(httpHost, httpRequest);
        final HttpCacheEntry entry = variant.getEntry();
        final String variantKey = this.uriExtractor.getVariantKey(httpRequest, entry);
        final String cacheKey = variant.getCacheKey();
        final HttpRequest httpRequest2 = httpRequest;
        try {
            this.storage.updateEntry(uri, new HttpCacheUpdateCallback() {
                public HttpCacheEntry update(HttpCacheEntry httpCacheEntry) throws IOException {
                    return BasicHttpCache.this.doGetUpdatedParentEntry(httpRequest2.getRequestLine().getUri(), httpCacheEntry, entry, variantKey, cacheKey);
                }
            });
        } catch (HttpCacheUpdateException e) {
            Log log2 = this.log;
            log2.warn("Could not update key [" + uri + "]", e);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean isIncompleteResponse(HttpResponse httpResponse, Resource resource) {
        Header firstHeader;
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if ((statusCode != 200 && statusCode != 206) || (firstHeader = httpResponse.getFirstHeader("Content-Length")) == null) {
            return false;
        }
        try {
            if (resource.length() < ((long) Integer.parseInt(firstHeader.getValue()))) {
                return true;
            }
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public HttpResponse generateIncompleteResponseError(HttpResponse httpResponse, Resource resource) {
        int parseInt = Integer.parseInt(httpResponse.getFirstHeader("Content-Length").getValue());
        BasicHttpResponse basicHttpResponse = new BasicHttpResponse((ProtocolVersion) HttpVersion.HTTP_1_1, 502, "Bad Gateway");
        basicHttpResponse.setHeader("Content-Type", "text/plain;charset=UTF-8");
        byte[] bytes = String.format("Received incomplete response with Content-Length %d but actual body length %d", new Object[]{Integer.valueOf(parseInt), Long.valueOf(resource.length())}).getBytes();
        basicHttpResponse.setHeader("Content-Length", Integer.toString(bytes.length));
        basicHttpResponse.setEntity(new ByteArrayEntity(bytes));
        return basicHttpResponse;
    }

    /* access modifiers changed from: package-private */
    public HttpCacheEntry doGetUpdatedParentEntry(String str, HttpCacheEntry httpCacheEntry, HttpCacheEntry httpCacheEntry2, String str2, String str3) throws IOException {
        if (httpCacheEntry == null) {
            httpCacheEntry = httpCacheEntry2;
        }
        Resource copy = this.resourceFactory.copy(str, httpCacheEntry.getResource());
        HashMap hashMap = new HashMap(httpCacheEntry.getVariantMap());
        hashMap.put(str2, str3);
        return new HttpCacheEntry(httpCacheEntry.getRequestDate(), httpCacheEntry.getResponseDate(), httpCacheEntry.getStatusLine(), httpCacheEntry.getAllHeaders(), copy, hashMap);
    }

    public HttpCacheEntry updateCacheEntry(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, HttpResponse httpResponse, Date date, Date date2) throws IOException {
        HttpCacheEntry updateCacheEntry = this.cacheEntryUpdater.updateCacheEntry(httpRequest.getRequestLine().getUri(), httpCacheEntry, date, date2, httpResponse);
        storeInCache(httpHost, httpRequest, updateCacheEntry);
        return updateCacheEntry;
    }

    public HttpCacheEntry updateVariantCacheEntry(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, HttpResponse httpResponse, Date date, Date date2, String str) throws IOException {
        HttpCacheEntry updateCacheEntry = this.cacheEntryUpdater.updateCacheEntry(httpRequest.getRequestLine().getUri(), httpCacheEntry, date, date2, httpResponse);
        this.storage.putEntry(str, updateCacheEntry);
        return updateCacheEntry;
    }

    public HttpResponse cacheAndReturnResponse(HttpHost httpHost, HttpRequest httpRequest, HttpResponse httpResponse, Date date, Date date2) throws IOException {
        SizeLimitedResponseReader responseReader = getResponseReader(httpRequest, httpResponse);
        responseReader.readResponse();
        if (responseReader.isLimitReached()) {
            return responseReader.getReconstructedResponse();
        }
        Resource resource = responseReader.getResource();
        if (isIncompleteResponse(httpResponse, resource)) {
            return generateIncompleteResponseError(httpResponse, resource);
        }
        HttpCacheEntry httpCacheEntry = new HttpCacheEntry(date, date2, httpResponse.getStatusLine(), httpResponse.getAllHeaders(), resource);
        storeInCache(httpHost, httpRequest, httpCacheEntry);
        return this.responseGenerator.generateResponse(httpCacheEntry);
    }

    /* access modifiers changed from: package-private */
    public SizeLimitedResponseReader getResponseReader(HttpRequest httpRequest, HttpResponse httpResponse) {
        return new SizeLimitedResponseReader(this.resourceFactory, (long) this.maxObjectSizeBytes, httpRequest, httpResponse);
    }

    public HttpCacheEntry getCacheEntry(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        HttpCacheEntry entry = this.storage.getEntry(this.uriExtractor.getURI(httpHost, httpRequest));
        if (entry == null) {
            return null;
        }
        if (!entry.hasVariants()) {
            return entry;
        }
        String str = entry.getVariantMap().get(this.uriExtractor.getVariantKey(httpRequest, entry));
        if (str == null) {
            return null;
        }
        return this.storage.getEntry(str);
    }

    public void flushInvalidatedCacheEntriesFor(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        this.cacheInvalidator.flushInvalidatedCacheEntries(httpHost, httpRequest);
    }

    public Map<String, Variant> getVariantCacheEntriesWithEtags(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        HashMap hashMap = new HashMap();
        HttpCacheEntry entry = this.storage.getEntry(this.uriExtractor.getURI(httpHost, httpRequest));
        if (entry != null && entry.hasVariants()) {
            for (Map.Entry next : entry.getVariantMap().entrySet()) {
                addVariantWithEtag((String) next.getKey(), (String) next.getValue(), hashMap);
            }
        }
        return hashMap;
    }

    private void addVariantWithEtag(String str, String str2, Map<String, Variant> map) throws IOException {
        Header firstHeader;
        HttpCacheEntry entry = this.storage.getEntry(str2);
        if (entry != null && (firstHeader = entry.getFirstHeader("ETag")) != null) {
            map.put(firstHeader.getValue(), new Variant(str, str2, entry));
        }
    }
}
