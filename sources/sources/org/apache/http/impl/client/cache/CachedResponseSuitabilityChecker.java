package org.apache.http.impl.client.cache;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.cache.HeaderConstants;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

class CachedResponseSuitabilityChecker {
    private final float heuristicCoefficient;
    private final long heuristicDefaultLifetime;
    private final Log log;
    private final boolean sharedCache;
    private final boolean useHeuristicCaching;
    private final CacheValidityPolicy validityStrategy;

    CachedResponseSuitabilityChecker(CacheValidityPolicy cacheValidityPolicy, CacheConfig cacheConfig) {
        this.log = LogFactory.getLog(getClass());
        this.validityStrategy = cacheValidityPolicy;
        this.sharedCache = cacheConfig.isSharedCache();
        this.useHeuristicCaching = cacheConfig.isHeuristicCachingEnabled();
        this.heuristicCoefficient = cacheConfig.getHeuristicCoefficient();
        this.heuristicDefaultLifetime = cacheConfig.getHeuristicDefaultLifetime();
    }

    CachedResponseSuitabilityChecker(CacheConfig cacheConfig) {
        this(new CacheValidityPolicy(), cacheConfig);
    }

    private boolean isFreshEnough(HttpCacheEntry httpCacheEntry, HttpRequest httpRequest, Date date) {
        if (this.validityStrategy.isResponseFresh(httpCacheEntry, date)) {
            return true;
        }
        if (this.useHeuristicCaching) {
            if (this.validityStrategy.isResponseHeuristicallyFresh(httpCacheEntry, date, this.heuristicCoefficient, this.heuristicDefaultLifetime)) {
                return true;
            }
        }
        if (originInsistsOnFreshness(httpCacheEntry)) {
            return false;
        }
        long maxStale = getMaxStale(httpRequest);
        if (maxStale != -1 && maxStale > this.validityStrategy.getStalenessSecs(httpCacheEntry, date)) {
            return true;
        }
        return false;
    }

    private boolean originInsistsOnFreshness(HttpCacheEntry httpCacheEntry) {
        if (this.validityStrategy.mustRevalidate(httpCacheEntry)) {
            return true;
        }
        if (!this.sharedCache) {
            return false;
        }
        if (this.validityStrategy.proxyRevalidate(httpCacheEntry) || this.validityStrategy.hasCacheControlDirective(httpCacheEntry, "s-maxage")) {
            return true;
        }
        return false;
    }

    private long getMaxStale(HttpRequest httpRequest) {
        long j = -1;
        for (Header elements : httpRequest.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(headerElement.getName())) {
                    if ((headerElement.getValue() == null || "".equals(headerElement.getValue().trim())) && j == -1) {
                        j = Long.MAX_VALUE;
                    } else {
                        long j2 = 0;
                        try {
                            long parseLong = Long.parseLong(headerElement.getValue());
                            if (parseLong >= 0) {
                                j2 = parseLong;
                            }
                            if (j != -1 && j2 >= j) {
                            }
                        } catch (NumberFormatException unused) {
                        }
                        j = j2;
                    }
                }
            }
        }
        return j;
    }

    public boolean canCachedResponseBeUsed(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        int i;
        HttpRequest httpRequest2 = httpRequest;
        HttpCacheEntry httpCacheEntry2 = httpCacheEntry;
        Date date2 = date;
        boolean z = false;
        if (!isFreshEnough(httpCacheEntry2, httpRequest2, date2)) {
            this.log.debug("Cache entry was not fresh enough");
            return false;
        } else if (!this.validityStrategy.contentLengthHeaderMatchesActualLength(httpCacheEntry2)) {
            this.log.debug("Cache entry Content-Length and header information do not match");
            return false;
        } else if (hasUnsupportedConditionalHeaders(httpRequest2)) {
            this.log.debug("Request contained conditional headers we don't handle");
            return false;
        } else if (isConditional(httpRequest2) && !allConditionalsMatch(httpRequest2, httpCacheEntry2, date2)) {
            return false;
        } else {
            Header[] headers = httpRequest2.getHeaders("Cache-Control");
            int length = headers.length;
            int i2 = 0;
            while (i2 < length) {
                HeaderElement[] elements = headers[i2].getElements();
                int length2 = elements.length;
                int i3 = 0;
                while (i3 < length2) {
                    HeaderElement headerElement = elements[i3];
                    if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(headerElement.getName())) {
                        this.log.debug("Response contained NO CACHE directive, cache was not suitable");
                        return z;
                    } else if (HeaderConstants.CACHE_CONTROL_NO_STORE.equals(headerElement.getName())) {
                        this.log.debug("Response contained NO STORE directive, cache was not suitable");
                        return z;
                    } else {
                        if ("max-age".equals(headerElement.getName())) {
                            try {
                                i = i2;
                                if (this.validityStrategy.getCurrentAgeSecs(httpCacheEntry2, date2) > ((long) Integer.parseInt(headerElement.getValue()))) {
                                    this.log.debug("Response from cache was NOT suitable due to max age");
                                    return false;
                                }
                            } catch (NumberFormatException e) {
                                Log log2 = this.log;
                                log2.debug("Response from cache was malformed: " + e.getMessage());
                                return false;
                            }
                        } else {
                            i = i2;
                        }
                        if (HeaderConstants.CACHE_CONTROL_MAX_STALE.equals(headerElement.getName())) {
                            try {
                                if (this.validityStrategy.getFreshnessLifetimeSecs(httpCacheEntry2) > ((long) Integer.parseInt(headerElement.getValue()))) {
                                    this.log.debug("Response from cache was not suitable due to Max stale freshness");
                                    return false;
                                }
                            } catch (NumberFormatException e2) {
                                Log log3 = this.log;
                                log3.debug("Response from cache was malformed: " + e2.getMessage());
                                return false;
                            }
                        }
                        if (HeaderConstants.CACHE_CONTROL_MIN_FRESH.equals(headerElement.getName())) {
                            try {
                                long parseLong = Long.parseLong(headerElement.getValue());
                                if (parseLong < 0) {
                                    return false;
                                }
                                if (this.validityStrategy.getFreshnessLifetimeSecs(httpCacheEntry2) - this.validityStrategy.getCurrentAgeSecs(httpCacheEntry2, date2) < parseLong) {
                                    this.log.debug("Response from cache was not suitable due to min fresh freshness requirement");
                                    return false;
                                }
                            } catch (NumberFormatException e3) {
                                Log log4 = this.log;
                                log4.debug("Response from cache was malformed: " + e3.getMessage());
                                return false;
                            }
                        }
                        z = false;
                        i3++;
                        i2 = i;
                    }
                }
                i2++;
            }
            this.log.debug("Response from cache was suitable");
            return true;
        }
    }

    public boolean isConditional(HttpRequest httpRequest) {
        return hasSupportedEtagVadlidator(httpRequest) || hasSupportedLastModifiedValidator(httpRequest);
    }

    public boolean allConditionalsMatch(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        boolean hasSupportedEtagVadlidator = hasSupportedEtagVadlidator(httpRequest);
        boolean hasSupportedLastModifiedValidator = hasSupportedLastModifiedValidator(httpRequest);
        boolean etagValidtorMatches = hasSupportedEtagVadlidator ? etagValidtorMatches(httpRequest, httpCacheEntry) : false;
        boolean lastModifiedValidatorMatches = hasSupportedLastModifiedValidator ? lastModifiedValidatorMatches(httpRequest, httpCacheEntry, date) : false;
        if (hasSupportedEtagVadlidator && hasSupportedLastModifiedValidator && (!etagValidtorMatches || !lastModifiedValidatorMatches)) {
            return false;
        }
        if (hasSupportedEtagVadlidator && !etagValidtorMatches) {
            return false;
        }
        if (!hasSupportedLastModifiedValidator || lastModifiedValidatorMatches) {
            return true;
        }
        return false;
    }

    private boolean hasUnsupportedConditionalHeaders(HttpRequest httpRequest) {
        return (httpRequest.getFirstHeader("If-Range") == null && httpRequest.getFirstHeader("If-Match") == null && !hasValidDateField(httpRequest, "If-Unmodified-Since")) ? false : true;
    }

    private boolean hasSupportedEtagVadlidator(HttpRequest httpRequest) {
        return httpRequest.containsHeader("If-None-Match");
    }

    private boolean hasSupportedLastModifiedValidator(HttpRequest httpRequest) {
        return hasValidDateField(httpRequest, "If-Modified-Since");
    }

    private boolean etagValidtorMatches(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("ETag");
        String value = firstHeader != null ? firstHeader.getValue() : null;
        Header[] headers = httpRequest.getHeaders("If-None-Match");
        if (headers != null) {
            for (Header elements : headers) {
                for (HeaderElement obj : elements.getElements()) {
                    String obj2 = obj.toString();
                    if (("*".equals(obj2) && value != null) || obj2.equals(value)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean lastModifiedValidatorMatches(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Last-Modified");
        Date date2 = null;
        if (firstHeader != null) {
            try {
                date2 = DateUtils.parseDate(firstHeader.getValue());
            } catch (DateParseException unused) {
            }
        }
        if (date2 == null) {
            return false;
        }
        Header[] headers = httpRequest.getHeaders("If-Modified-Since");
        int length = headers.length;
        int i = 0;
        while (i < length) {
            try {
                Date parseDate = DateUtils.parseDate(headers[i].getValue());
                if (parseDate.after(date) || date2.after(parseDate)) {
                    return false;
                }
                i++;
            } catch (DateParseException unused2) {
            }
        }
        return true;
    }

    private boolean hasValidDateField(HttpRequest httpRequest, String str) {
        Header[] headers = httpRequest.getHeaders(str);
        int length = headers.length;
        int i = 0;
        while (i < length) {
            try {
                DateUtils.parseDate(headers[i].getValue());
                return true;
            } catch (DateParseException unused) {
                i++;
            }
        }
        return false;
    }
}
