package org.apache.http.impl.client.cache;

import java.util.Date;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpRequest;
import org.apache.http.client.cache.HeaderConstants;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

class CacheValidityPolicy {
    public static final long MAX_AGE = 2147483648L;

    CacheValidityPolicy() {
    }

    public long getCurrentAgeSecs(HttpCacheEntry httpCacheEntry, Date date) {
        return getCorrectedInitialAgeSecs(httpCacheEntry) + getResidentTimeSecs(httpCacheEntry, date);
    }

    public long getFreshnessLifetimeSecs(HttpCacheEntry httpCacheEntry) {
        Date expirationDate;
        long maxAge = getMaxAge(httpCacheEntry);
        if (maxAge > -1) {
            return maxAge;
        }
        Date dateValue = getDateValue(httpCacheEntry);
        if (dateValue == null || (expirationDate = getExpirationDate(httpCacheEntry)) == null) {
            return 0;
        }
        return (expirationDate.getTime() - dateValue.getTime()) / 1000;
    }

    public boolean isResponseFresh(HttpCacheEntry httpCacheEntry, Date date) {
        return getCurrentAgeSecs(httpCacheEntry, date) < getFreshnessLifetimeSecs(httpCacheEntry);
    }

    public boolean isResponseHeuristicallyFresh(HttpCacheEntry httpCacheEntry, Date date, float f, long j) {
        return getCurrentAgeSecs(httpCacheEntry, date) < getHeuristicFreshnessLifetimeSecs(httpCacheEntry, f, j);
    }

    public long getHeuristicFreshnessLifetimeSecs(HttpCacheEntry httpCacheEntry, float f, long j) {
        Date dateValue = getDateValue(httpCacheEntry);
        Date lastModifiedValue = getLastModifiedValue(httpCacheEntry);
        if (dateValue == null || lastModifiedValue == null) {
            return j;
        }
        long time = dateValue.getTime() - lastModifiedValue.getTime();
        if (time < 0) {
            return 0;
        }
        return (long) (f * ((float) (time / 1000)));
    }

    public boolean isRevalidatable(HttpCacheEntry httpCacheEntry) {
        return (httpCacheEntry.getFirstHeader("ETag") == null && httpCacheEntry.getFirstHeader("Last-Modified") == null) ? false : true;
    }

    public boolean mustRevalidate(HttpCacheEntry httpCacheEntry) {
        return hasCacheControlDirective(httpCacheEntry, HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE);
    }

    public boolean proxyRevalidate(HttpCacheEntry httpCacheEntry) {
        return hasCacheControlDirective(httpCacheEntry, HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE);
    }

    public boolean mayReturnStaleWhileRevalidating(HttpCacheEntry httpCacheEntry, Date date) {
        for (Header elements : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                if ("stale-while-revalidate".equalsIgnoreCase(headerElement.getName())) {
                    try {
                        if (getStalenessSecs(httpCacheEntry, date) <= ((long) Integer.parseInt(headerElement.getValue()))) {
                            return true;
                        }
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    public boolean mayReturnStaleIfError(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry, Date date) {
        long stalenessSecs = getStalenessSecs(httpCacheEntry, date);
        return mayReturnStaleIfError(httpRequest.getHeaders("Cache-Control"), stalenessSecs) || mayReturnStaleIfError(httpCacheEntry.getHeaders("Cache-Control"), stalenessSecs);
    }

    private boolean mayReturnStaleIfError(Header[] headerArr, long j) {
        boolean z = false;
        for (Header elements : headerArr) {
            HeaderElement[] elements2 = elements.getElements();
            int length = elements2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                HeaderElement headerElement = elements2[i];
                if ("stale-if-error".equals(headerElement.getName())) {
                    try {
                        if (j <= ((long) Integer.parseInt(headerElement.getValue()))) {
                            z = true;
                            break;
                        }
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
                i++;
            }
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public Date getDateValue(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Date");
        if (firstHeader == null) {
            return null;
        }
        try {
            return DateUtils.parseDate(firstHeader.getValue());
        } catch (DateParseException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public Date getLastModifiedValue(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Last-Modified");
        if (firstHeader == null) {
            return null;
        }
        try {
            return DateUtils.parseDate(firstHeader.getValue());
        } catch (DateParseException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public long getContentLengthValue(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Content-Length");
        if (firstHeader == null) {
            return -1;
        }
        try {
            return Long.parseLong(firstHeader.getValue());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* access modifiers changed from: protected */
    public boolean contentLengthHeaderMatchesActualLength(HttpCacheEntry httpCacheEntry) {
        return getContentLengthValue(httpCacheEntry) == httpCacheEntry.getResource().length();
    }

    /* access modifiers changed from: protected */
    public long getApparentAgeSecs(HttpCacheEntry httpCacheEntry) {
        Date dateValue = getDateValue(httpCacheEntry);
        if (dateValue == null) {
            return MAX_AGE;
        }
        long time = httpCacheEntry.getResponseDate().getTime() - dateValue.getTime();
        if (time < 0) {
            return 0;
        }
        return time / 1000;
    }

    /* access modifiers changed from: protected */
    public long getAgeValue(HttpCacheEntry httpCacheEntry) {
        long j = 0;
        for (Header header : httpCacheEntry.getHeaders("Age")) {
            long j2 = MAX_AGE;
            try {
                long parseLong = Long.parseLong(header.getValue());
                if (parseLong >= 0) {
                    j2 = parseLong;
                }
            } catch (NumberFormatException unused) {
            }
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }

    /* access modifiers changed from: protected */
    public long getCorrectedReceivedAgeSecs(HttpCacheEntry httpCacheEntry) {
        long apparentAgeSecs = getApparentAgeSecs(httpCacheEntry);
        long ageValue = getAgeValue(httpCacheEntry);
        return apparentAgeSecs > ageValue ? apparentAgeSecs : ageValue;
    }

    /* access modifiers changed from: protected */
    public long getResponseDelaySecs(HttpCacheEntry httpCacheEntry) {
        return (httpCacheEntry.getResponseDate().getTime() - httpCacheEntry.getRequestDate().getTime()) / 1000;
    }

    /* access modifiers changed from: protected */
    public long getCorrectedInitialAgeSecs(HttpCacheEntry httpCacheEntry) {
        return getCorrectedReceivedAgeSecs(httpCacheEntry) + getResponseDelaySecs(httpCacheEntry);
    }

    /* access modifiers changed from: protected */
    public Date getCurrentDate() {
        return new Date();
    }

    /* access modifiers changed from: protected */
    public long getResidentTimeSecs(HttpCacheEntry httpCacheEntry, Date date) {
        return (date.getTime() - httpCacheEntry.getResponseDate().getTime()) / 1000;
    }

    /* access modifiers changed from: protected */
    public long getMaxAge(HttpCacheEntry httpCacheEntry) {
        long j = -1;
        for (Header elements : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                if ("max-age".equals(headerElement.getName()) || "s-maxage".equals(headerElement.getName())) {
                    try {
                        long parseLong = Long.parseLong(headerElement.getValue());
                        if (j == -1 || parseLong < j) {
                            j = parseLong;
                        }
                    } catch (NumberFormatException unused) {
                        j = 0;
                    }
                }
            }
        }
        return j;
    }

    /* access modifiers changed from: protected */
    public Date getExpirationDate(HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Expires");
        if (firstHeader == null) {
            return null;
        }
        try {
            return DateUtils.parseDate(firstHeader.getValue());
        } catch (DateParseException unused) {
            return null;
        }
    }

    public boolean hasCacheControlDirective(HttpCacheEntry httpCacheEntry, String str) {
        for (Header elements : httpCacheEntry.getHeaders("Cache-Control")) {
            for (HeaderElement name : elements.getElements()) {
                if (str.equalsIgnoreCase(name.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public long getStalenessSecs(HttpCacheEntry httpCacheEntry, Date date) {
        long currentAgeSecs = getCurrentAgeSecs(httpCacheEntry, date);
        long freshnessLifetimeSecs = getFreshnessLifetimeSecs(httpCacheEntry);
        if (currentAgeSecs <= freshnessLifetimeSecs) {
            return 0;
        }
        return currentAgeSecs - freshnessLifetimeSecs;
    }
}
