package org.apache.http.impl.client.cache;

import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpHost;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.cache.CacheResponseStatus;
import org.apache.http.client.cache.HeaderConstants;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.client.cache.HttpCacheStorage;
import org.apache.http.client.cache.ResourceFactory;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.VersionInfo;

public class CachingHttpClient implements HttpClient {
    public static final String CACHE_RESPONSE_STATUS = "http.cache.response.status";
    private static final boolean SUPPORTS_RANGE_AND_CONTENT_RANGE_HEADERS = false;
    private final AsynchronousValidator asynchRevalidator;
    private final HttpClient backend;
    private final AtomicLong cacheHits;
    private final AtomicLong cacheMisses;
    private final AtomicLong cacheUpdates;
    private final CacheableRequestPolicy cacheableRequestPolicy;
    private final ConditionalRequestBuilder conditionalRequestBuilder;
    private final Log log;
    private final int maxObjectSizeBytes;
    private final RequestProtocolCompliance requestCompliance;
    private final HttpCache responseCache;
    private final ResponseCachingPolicy responseCachingPolicy;
    private final ResponseProtocolCompliance responseCompliance;
    private final CachedHttpResponseGenerator responseGenerator;
    private final boolean sharedCache;
    private final CachedResponseSuitabilityChecker suitabilityChecker;
    private final CacheValidityPolicy validityPolicy;

    private boolean staleIfErrorAppliesTo(int i) {
        return i == 500 || i == 502 || i == 503 || i == 504;
    }

    public boolean supportsRangeAndContentRangeHeaders() {
        return false;
    }

    CachingHttpClient(HttpClient httpClient, HttpCache httpCache, CacheConfig cacheConfig) {
        this.cacheHits = new AtomicLong();
        this.cacheMisses = new AtomicLong();
        this.cacheUpdates = new AtomicLong();
        this.log = LogFactory.getLog(getClass());
        if (httpClient == null) {
            throw new IllegalArgumentException("HttpClient may not be null");
        } else if (httpCache == null) {
            throw new IllegalArgumentException("HttpCache may not be null");
        } else if (cacheConfig != null) {
            int maxObjectSizeBytes2 = cacheConfig.getMaxObjectSizeBytes();
            this.maxObjectSizeBytes = maxObjectSizeBytes2;
            boolean isSharedCache = cacheConfig.isSharedCache();
            this.sharedCache = isSharedCache;
            this.backend = httpClient;
            this.responseCache = httpCache;
            CacheValidityPolicy cacheValidityPolicy = new CacheValidityPolicy();
            this.validityPolicy = cacheValidityPolicy;
            this.responseCachingPolicy = new ResponseCachingPolicy(maxObjectSizeBytes2, isSharedCache);
            this.responseGenerator = new CachedHttpResponseGenerator(cacheValidityPolicy);
            this.cacheableRequestPolicy = new CacheableRequestPolicy();
            this.suitabilityChecker = new CachedResponseSuitabilityChecker(cacheValidityPolicy, cacheConfig);
            this.conditionalRequestBuilder = new ConditionalRequestBuilder();
            this.responseCompliance = new ResponseProtocolCompliance();
            this.requestCompliance = new RequestProtocolCompliance();
            this.asynchRevalidator = makeAsynchronousValidator(cacheConfig);
        } else {
            throw new IllegalArgumentException("CacheConfig may not be null");
        }
    }

    public CachingHttpClient() {
        this((HttpClient) new DefaultHttpClient(), (HttpCache) new BasicHttpCache(), new CacheConfig());
    }

    public CachingHttpClient(CacheConfig cacheConfig) {
        this((HttpClient) new DefaultHttpClient(), (HttpCache) new BasicHttpCache(cacheConfig), cacheConfig);
    }

    public CachingHttpClient(HttpClient httpClient) {
        this(httpClient, (HttpCache) new BasicHttpCache(), new CacheConfig());
    }

    public CachingHttpClient(HttpClient httpClient, CacheConfig cacheConfig) {
        this(httpClient, (HttpCache) new BasicHttpCache(cacheConfig), cacheConfig);
    }

    public CachingHttpClient(HttpClient httpClient, ResourceFactory resourceFactory, HttpCacheStorage httpCacheStorage, CacheConfig cacheConfig) {
        this(httpClient, (HttpCache) new BasicHttpCache(resourceFactory, httpCacheStorage, cacheConfig), cacheConfig);
    }

    public CachingHttpClient(HttpClient httpClient, HttpCacheStorage httpCacheStorage, CacheConfig cacheConfig) {
        this(httpClient, (HttpCache) new BasicHttpCache(new HeapResourceFactory(), httpCacheStorage, cacheConfig), cacheConfig);
    }

    CachingHttpClient(HttpClient httpClient, CacheValidityPolicy cacheValidityPolicy, ResponseCachingPolicy responseCachingPolicy2, HttpCache httpCache, CachedHttpResponseGenerator cachedHttpResponseGenerator, CacheableRequestPolicy cacheableRequestPolicy2, CachedResponseSuitabilityChecker cachedResponseSuitabilityChecker, ConditionalRequestBuilder conditionalRequestBuilder2, ResponseProtocolCompliance responseProtocolCompliance, RequestProtocolCompliance requestProtocolCompliance) {
        this.cacheHits = new AtomicLong();
        this.cacheMisses = new AtomicLong();
        this.cacheUpdates = new AtomicLong();
        this.log = LogFactory.getLog(getClass());
        CacheConfig cacheConfig = new CacheConfig();
        this.maxObjectSizeBytes = cacheConfig.getMaxObjectSizeBytes();
        this.sharedCache = cacheConfig.isSharedCache();
        this.backend = httpClient;
        this.validityPolicy = cacheValidityPolicy;
        this.responseCachingPolicy = responseCachingPolicy2;
        this.responseCache = httpCache;
        this.responseGenerator = cachedHttpResponseGenerator;
        this.cacheableRequestPolicy = cacheableRequestPolicy2;
        this.suitabilityChecker = cachedResponseSuitabilityChecker;
        this.conditionalRequestBuilder = conditionalRequestBuilder2;
        this.responseCompliance = responseProtocolCompliance;
        this.requestCompliance = requestProtocolCompliance;
        this.asynchRevalidator = makeAsynchronousValidator(cacheConfig);
    }

    private AsynchronousValidator makeAsynchronousValidator(CacheConfig cacheConfig) {
        if (cacheConfig.getAsynchronousWorkersMax() > 0) {
            return new AsynchronousValidator(this, cacheConfig);
        }
        return null;
    }

    public long getCacheHits() {
        return this.cacheHits.get();
    }

    public long getCacheMisses() {
        return this.cacheMisses.get();
    }

    public long getCacheUpdates() {
        return this.cacheUpdates.get();
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest) throws IOException {
        return execute(httpHost, httpRequest, (HttpContext) null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return execute(httpHost, httpRequest, responseHandler, (HttpContext) null);
    }

    public <T> T execute(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return responseHandler.handleResponse(execute(httpHost, httpRequest, httpContext));
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest) throws IOException {
        return execute(httpUriRequest, (HttpContext) null);
    }

    public HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) throws IOException {
        URI uri = httpUriRequest.getURI();
        return execute(new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme()), (HttpRequest) httpUriRequest, httpContext);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws IOException {
        return execute(httpUriRequest, responseHandler, (HttpContext) null);
    }

    public <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws IOException {
        return responseHandler.handleResponse(execute(httpUriRequest, httpContext));
    }

    public ClientConnectionManager getConnectionManager() {
        return this.backend.getConnectionManager();
    }

    public HttpParams getParams() {
        return this.backend.getParams();
    }

    public HttpResponse execute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        setResponseStatus(httpContext, CacheResponseStatus.CACHE_MISS);
        String generateViaHeader = generateViaHeader(httpRequest);
        if (clientRequestsOurOptions(httpRequest)) {
            setResponseStatus(httpContext, CacheResponseStatus.CACHE_MODULE_RESPONSE);
            return new OptionsHttp11Response();
        }
        HttpResponse fatallyNoncompliantResponse = getFatallyNoncompliantResponse(httpRequest, httpContext);
        if (fatallyNoncompliantResponse != null) {
            return fatallyNoncompliantResponse;
        }
        HttpRequest makeRequestCompliant = this.requestCompliance.makeRequestCompliant(httpRequest);
        makeRequestCompliant.addHeader("Via", generateViaHeader);
        flushEntriesInvalidatedByRequest(httpHost, makeRequestCompliant);
        if (!this.cacheableRequestPolicy.isServableFromCache(makeRequestCompliant)) {
            return callBackend(httpHost, makeRequestCompliant, httpContext);
        }
        HttpCacheEntry satisfyFromCache = satisfyFromCache(httpHost, makeRequestCompliant);
        if (satisfyFromCache == null) {
            return handleCacheMiss(httpHost, makeRequestCompliant, httpContext);
        }
        return handleCacheHit(httpHost, makeRequestCompliant, httpContext, satisfyFromCache);
    }

    private HttpResponse handleCacheHit(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, HttpCacheEntry httpCacheEntry) throws ClientProtocolException, IOException {
        recordCacheHit(httpHost, httpRequest);
        Date currentDate = getCurrentDate();
        if (this.suitabilityChecker.canCachedResponseBeUsed(httpHost, httpRequest, httpCacheEntry, currentDate)) {
            return generateCachedResponse(httpRequest, httpContext, httpCacheEntry, currentDate);
        }
        if (!mayCallBackend(httpRequest)) {
            return generateGatewayTimeout(httpContext);
        }
        if (this.validityPolicy.isRevalidatable(httpCacheEntry)) {
            return revalidateCacheEntry(httpHost, httpRequest, httpContext, httpCacheEntry, currentDate);
        }
        return callBackend(httpHost, httpRequest, httpContext);
    }

    private HttpResponse revalidateCacheEntry(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, HttpCacheEntry httpCacheEntry, Date date) throws ClientProtocolException {
        this.log.debug("Revalidating the cache entry");
        try {
            if (this.asynchRevalidator == null || staleResponseNotAllowed(httpRequest, httpCacheEntry, date) || !this.validityPolicy.mayReturnStaleWhileRevalidating(httpCacheEntry, date)) {
                return revalidateCacheEntry(httpHost, httpRequest, httpContext, httpCacheEntry);
            }
            HttpResponse generateResponse = this.responseGenerator.generateResponse(httpCacheEntry);
            generateResponse.addHeader("Warning", "110 localhost \"Response is stale\"");
            this.asynchRevalidator.revalidateCacheEntry(httpHost, httpRequest, httpContext, httpCacheEntry);
            return generateResponse;
        } catch (IOException unused) {
            return handleRevalidationFailure(httpRequest, httpContext, httpCacheEntry, date);
        } catch (ProtocolException e) {
            throw new ClientProtocolException((Throwable) e);
        }
    }

    private HttpResponse handleCacheMiss(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        recordCacheMiss(httpHost, httpRequest);
        if (!mayCallBackend(httpRequest)) {
            return new BasicHttpResponse((ProtocolVersion) HttpVersion.HTTP_1_1, 504, "Gateway Timeout");
        }
        Map<String, Variant> existingCacheVariants = getExistingCacheVariants(httpHost, httpRequest);
        if (existingCacheVariants == null || existingCacheVariants.size() <= 0) {
            return callBackend(httpHost, httpRequest, httpContext);
        }
        return negotiateResponseFromVariants(httpHost, httpRequest, httpContext, existingCacheVariants);
    }

    private HttpCacheEntry satisfyFromCache(HttpHost httpHost, HttpRequest httpRequest) {
        try {
            return this.responseCache.getCacheEntry(httpHost, httpRequest);
        } catch (IOException e) {
            this.log.warn("Unable to retrieve entries from cache", e);
            return null;
        }
    }

    private HttpResponse getFatallyNoncompliantResponse(HttpRequest httpRequest, HttpContext httpContext) {
        HttpResponse httpResponse = null;
        for (RequestProtocolError errorForRequest : this.requestCompliance.requestIsFatallyNonCompliant(httpRequest)) {
            setResponseStatus(httpContext, CacheResponseStatus.CACHE_MODULE_RESPONSE);
            httpResponse = this.requestCompliance.getErrorForRequest(errorForRequest);
        }
        return httpResponse;
    }

    private Map<String, Variant> getExistingCacheVariants(HttpHost httpHost, HttpRequest httpRequest) {
        try {
            return this.responseCache.getVariantCacheEntriesWithEtags(httpHost, httpRequest);
        } catch (IOException e) {
            this.log.warn("Unable to retrieve variant entries from cache", e);
            return null;
        }
    }

    private void recordCacheMiss(HttpHost httpHost, HttpRequest httpRequest) {
        this.cacheMisses.getAndIncrement();
        if (this.log.isDebugEnabled()) {
            RequestLine requestLine = httpRequest.getRequestLine();
            Log log2 = this.log;
            log2.debug("Cache miss [host: " + httpHost + "; uri: " + requestLine.getUri() + "]");
        }
    }

    private void recordCacheHit(HttpHost httpHost, HttpRequest httpRequest) {
        this.cacheHits.getAndIncrement();
        if (this.log.isDebugEnabled()) {
            RequestLine requestLine = httpRequest.getRequestLine();
            Log log2 = this.log;
            log2.debug("Cache hit [host: " + httpHost + "; uri: " + requestLine.getUri() + "]");
        }
    }

    private void recordCacheUpdate(HttpContext httpContext) {
        this.cacheUpdates.getAndIncrement();
        setResponseStatus(httpContext, CacheResponseStatus.VALIDATED);
    }

    private void flushEntriesInvalidatedByRequest(HttpHost httpHost, HttpRequest httpRequest) {
        try {
            this.responseCache.flushInvalidatedCacheEntriesFor(httpHost, httpRequest);
        } catch (IOException e) {
            this.log.warn("Unable to flush invalidated entries from cache", e);
        }
    }

    private HttpResponse generateCachedResponse(HttpRequest httpRequest, HttpContext httpContext, HttpCacheEntry httpCacheEntry, Date date) {
        HttpResponse httpResponse;
        if (httpRequest.containsHeader("If-None-Match") || httpRequest.containsHeader("If-Modified-Since")) {
            httpResponse = this.responseGenerator.generateNotModifiedResponse(httpCacheEntry);
        } else {
            httpResponse = this.responseGenerator.generateResponse(httpCacheEntry);
        }
        setResponseStatus(httpContext, CacheResponseStatus.CACHE_HIT);
        if (this.validityPolicy.getStalenessSecs(httpCacheEntry, date) > 0) {
            httpResponse.addHeader("Warning", "110 localhost \"Response is stale\"");
        }
        return httpResponse;
    }

    private HttpResponse handleRevalidationFailure(HttpRequest httpRequest, HttpContext httpContext, HttpCacheEntry httpCacheEntry, Date date) {
        if (staleResponseNotAllowed(httpRequest, httpCacheEntry, date)) {
            return generateGatewayTimeout(httpContext);
        }
        return unvalidatedCacheHit(httpContext, httpCacheEntry);
    }

    private HttpResponse generateGatewayTimeout(HttpContext httpContext) {
        setResponseStatus(httpContext, CacheResponseStatus.CACHE_MODULE_RESPONSE);
        return new BasicHttpResponse((ProtocolVersion) HttpVersion.HTTP_1_1, 504, "Gateway Timeout");
    }

    private HttpResponse unvalidatedCacheHit(HttpContext httpContext, HttpCacheEntry httpCacheEntry) {
        HttpResponse generateResponse = this.responseGenerator.generateResponse(httpCacheEntry);
        setResponseStatus(httpContext, CacheResponseStatus.CACHE_HIT);
        generateResponse.addHeader("Warning", "111 localhost \"Revalidation failed\"");
        return generateResponse;
    }

    private boolean staleResponseNotAllowed(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        return this.validityPolicy.mustRevalidate(httpCacheEntry) || (isSharedCache() && this.validityPolicy.proxyRevalidate(httpCacheEntry)) || explicitFreshnessRequest(httpRequest, httpCacheEntry, date);
    }

    private boolean mayCallBackend(HttpRequest httpRequest) {
        for (Header elements : httpRequest.getHeaders("Cache-Control")) {
            for (HeaderElement name : elements.getElements()) {
                if ("only-if-cached".equals(name.getName())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean explicitFreshnessRequest(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        HttpCacheEntry httpCacheEntry2 = httpCacheEntry;
        for (Header elements : httpRequest.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(headerElement.getName())) {
                    try {
                        if (this.validityPolicy.getCurrentAgeSecs(httpCacheEntry2, date) - this.validityPolicy.getFreshnessLifetimeSecs(httpCacheEntry2) > ((long) Integer.parseInt(headerElement.getValue()))) {
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                    }
                } else {
                    Date date2 = date;
                    if (HeaderConstants.CACHE_CONTROL_MIN_FRESH.equals(headerElement.getName()) || "max-age".equals(headerElement.getName())) {
                        return true;
                    }
                }
            }
            Date date3 = date;
        }
        return false;
    }

    private String generateViaHeader(HttpMessage httpMessage) {
        VersionInfo loadVersionInfo = VersionInfo.loadVersionInfo("org.apache.http.client", getClass().getClassLoader());
        String release = loadVersionInfo != null ? loadVersionInfo.getRelease() : VersionInfo.UNAVAILABLE;
        ProtocolVersion protocolVersion = httpMessage.getProtocolVersion();
        if ("http".equalsIgnoreCase(protocolVersion.getProtocol())) {
            return String.format("%d.%d localhost (Apache-HttpClient/%s (cache))", new Object[]{Integer.valueOf(protocolVersion.getMajor()), Integer.valueOf(protocolVersion.getMinor()), release});
        }
        return String.format("%s/%d.%d localhost (Apache-HttpClient/%s (cache))", new Object[]{protocolVersion.getProtocol(), Integer.valueOf(protocolVersion.getMajor()), Integer.valueOf(protocolVersion.getMinor()), release});
    }

    private void setResponseStatus(HttpContext httpContext, CacheResponseStatus cacheResponseStatus) {
        if (httpContext != null) {
            httpContext.setAttribute(CACHE_RESPONSE_STATUS, cacheResponseStatus);
        }
    }

    public boolean isSharedCache() {
        return this.sharedCache;
    }

    /* access modifiers changed from: package-private */
    public Date getCurrentDate() {
        return new Date();
    }

    /* access modifiers changed from: package-private */
    public boolean clientRequestsOurOptions(HttpRequest httpRequest) {
        RequestLine requestLine = httpRequest.getRequestLine();
        if ("OPTIONS".equals(requestLine.getMethod()) && "*".equals(requestLine.getUri()) && "0".equals(httpRequest.getFirstHeader("Max-Forwards").getValue())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public HttpResponse callBackend(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws IOException {
        Date currentDate = getCurrentDate();
        this.log.debug("Calling the backend");
        HttpResponse execute = this.backend.execute(httpHost, httpRequest, httpContext);
        execute.addHeader("Via", generateViaHeader(execute));
        return handleBackendResponse(httpHost, httpRequest, currentDate, getCurrentDate(), execute);
    }

    private boolean revalidationResponseIsTooOld(HttpResponse httpResponse, HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Date");
        Header firstHeader2 = httpResponse.getFirstHeader("Date");
        if (firstHeader == null || firstHeader2 == null) {
            return false;
        }
        try {
            return DateUtils.parseDate(firstHeader2.getValue()).before(DateUtils.parseDate(firstHeader.getValue()));
        } catch (DateParseException unused) {
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public HttpResponse negotiateResponseFromVariants(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, Map<String, Variant> map) throws IOException {
        HttpRequest buildConditionalRequestFromVariants = this.conditionalRequestBuilder.buildConditionalRequestFromVariants(httpRequest, map);
        Date currentDate = getCurrentDate();
        HttpResponse execute = this.backend.execute(httpHost, buildConditionalRequestFromVariants, httpContext);
        Date currentDate2 = getCurrentDate();
        execute.addHeader("Via", generateViaHeader(execute));
        if (execute.getStatusLine().getStatusCode() != 304) {
            return handleBackendResponse(httpHost, httpRequest, currentDate, currentDate2, execute);
        }
        Header firstHeader = execute.getFirstHeader("ETag");
        if (firstHeader == null) {
            this.log.warn("304 response did not contain ETag");
            return callBackend(httpHost, httpRequest, httpContext);
        }
        Variant variant = map.get(firstHeader.getValue());
        if (variant == null) {
            this.log.debug("304 response did not contain ETag matching one sent in If-None-Match");
            return callBackend(httpHost, httpRequest, httpContext);
        }
        HttpCacheEntry entry = variant.getEntry();
        if (revalidationResponseIsTooOld(execute, entry)) {
            return retryRequestUnconditionally(httpHost, httpRequest, httpContext, entry);
        }
        recordCacheUpdate(httpContext);
        HttpCacheEntry updatedVariantEntry = getUpdatedVariantEntry(httpHost, buildConditionalRequestFromVariants, currentDate, currentDate2, execute, variant, entry);
        HttpResponse generateResponse = this.responseGenerator.generateResponse(updatedVariantEntry);
        tryToUpdateVariantMap(httpHost, httpRequest, variant);
        return shouldSendNotModifiedResponse(httpRequest, updatedVariantEntry) ? this.responseGenerator.generateNotModifiedResponse(updatedVariantEntry) : generateResponse;
    }

    private HttpResponse retryRequestUnconditionally(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, HttpCacheEntry httpCacheEntry) throws IOException {
        return callBackend(httpHost, this.conditionalRequestBuilder.buildUnconditionalRequest(httpRequest, httpCacheEntry), httpContext);
    }

    private HttpCacheEntry getUpdatedVariantEntry(HttpHost httpHost, HttpRequest httpRequest, Date date, Date date2, HttpResponse httpResponse, Variant variant, HttpCacheEntry httpCacheEntry) {
        try {
            return this.responseCache.updateVariantCacheEntry(httpHost, httpRequest, httpCacheEntry, httpResponse, date, date2, variant.getCacheKey());
        } catch (IOException e) {
            this.log.warn("Could not update cache entry", e);
            return httpCacheEntry;
        }
    }

    private void tryToUpdateVariantMap(HttpHost httpHost, HttpRequest httpRequest, Variant variant) {
        try {
            this.responseCache.reuseVariantEntryFor(httpHost, httpRequest, variant);
        } catch (IOException e) {
            this.log.warn("Could not update cache entry to reuse variant", e);
        }
    }

    private boolean shouldSendNotModifiedResponse(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) {
        return this.suitabilityChecker.isConditional(httpRequest) && this.suitabilityChecker.allConditionalsMatch(httpRequest, httpCacheEntry, new Date());
    }

    /* access modifiers changed from: package-private */
    public HttpResponse revalidateCacheEntry(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext, HttpCacheEntry httpCacheEntry) throws IOException, ProtocolException {
        Date date;
        HttpResponse httpResponse;
        HttpRequest buildConditionalRequest = this.conditionalRequestBuilder.buildConditionalRequest(httpRequest, httpCacheEntry);
        Date currentDate = getCurrentDate();
        HttpResponse execute = this.backend.execute(httpHost, buildConditionalRequest, httpContext);
        Date currentDate2 = getCurrentDate();
        if (revalidationResponseIsTooOld(execute, httpCacheEntry)) {
            HttpRequest buildUnconditionalRequest = this.conditionalRequestBuilder.buildUnconditionalRequest(httpRequest, httpCacheEntry);
            Date currentDate3 = getCurrentDate();
            HttpResponse execute2 = this.backend.execute(httpHost, buildUnconditionalRequest, httpContext);
            currentDate2 = getCurrentDate();
            httpResponse = execute2;
            date = currentDate3;
        } else {
            date = currentDate;
            httpResponse = execute;
        }
        Date date2 = currentDate2;
        httpResponse.addHeader("Via", generateViaHeader(httpResponse));
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 304 || statusCode == 200) {
            recordCacheUpdate(httpContext);
        }
        if (statusCode == 304) {
            HttpCacheEntry updateCacheEntry = this.responseCache.updateCacheEntry(httpHost, httpRequest, httpCacheEntry, httpResponse, date, date2);
            if (!this.suitabilityChecker.isConditional(httpRequest) || !this.suitabilityChecker.allConditionalsMatch(httpRequest, updateCacheEntry, new Date())) {
                return this.responseGenerator.generateResponse(updateCacheEntry);
            }
            return this.responseGenerator.generateNotModifiedResponse(updateCacheEntry);
        } else if (!staleIfErrorAppliesTo(statusCode) || staleResponseNotAllowed(httpRequest, httpCacheEntry, getCurrentDate()) || !this.validityPolicy.mayReturnStaleIfError(httpRequest, httpCacheEntry, date2)) {
            return handleBackendResponse(httpHost, buildConditionalRequest, date, date2, httpResponse);
        } else {
            HttpResponse generateResponse = this.responseGenerator.generateResponse(httpCacheEntry);
            generateResponse.addHeader("Warning", "110 localhost \"Response is stale\"");
            return generateResponse;
        }
    }

    /* access modifiers changed from: package-private */
    public HttpResponse handleBackendResponse(HttpHost httpHost, HttpRequest httpRequest, Date date, Date date2, HttpResponse httpResponse) throws IOException {
        this.log.debug("Handling Backend response");
        this.responseCompliance.ensureProtocolCompliance(httpRequest, httpResponse);
        boolean isResponseCacheable = this.responseCachingPolicy.isResponseCacheable(httpRequest, httpResponse);
        this.responseCache.flushInvalidatedCacheEntriesFor(httpHost, httpRequest, httpResponse);
        if (isResponseCacheable && !alreadyHaveNewerCacheEntry(httpHost, httpRequest, httpResponse)) {
            try {
                return this.responseCache.cacheAndReturnResponse(httpHost, httpRequest, httpResponse, date, date2);
            } catch (IOException e) {
                this.log.warn("Unable to store entries in cache", e);
            }
        }
        if (!isResponseCacheable) {
            try {
                this.responseCache.flushCacheEntriesFor(httpHost, httpRequest);
            } catch (IOException e2) {
                this.log.warn("Unable to flush invalid cache entries", e2);
            }
        }
        return httpResponse;
    }

    private boolean alreadyHaveNewerCacheEntry(HttpHost httpHost, HttpRequest httpRequest, HttpResponse httpResponse) {
        HttpCacheEntry httpCacheEntry;
        Header firstHeader;
        Header firstHeader2;
        try {
            httpCacheEntry = this.responseCache.getCacheEntry(httpHost, httpRequest);
        } catch (IOException unused) {
            httpCacheEntry = null;
        }
        if (httpCacheEntry == null || (firstHeader = httpCacheEntry.getFirstHeader("Date")) == null || (firstHeader2 = httpResponse.getFirstHeader("Date")) == null) {
            return false;
        }
        try {
            return DateUtils.parseDate(firstHeader2.getValue()).before(DateUtils.parseDate(firstHeader.getValue()));
        } catch (DateParseException unused2) {
            return false;
        }
    }
}
