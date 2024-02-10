package org.apache.http.impl.client.cache;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.client.cache.HttpCacheStorage;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

class CacheInvalidator {
    private final CacheKeyGenerator cacheKeyGenerator;
    private final Log log = LogFactory.getLog(getClass());
    private final HttpCacheStorage storage;

    public CacheInvalidator(CacheKeyGenerator cacheKeyGenerator2, HttpCacheStorage httpCacheStorage) {
        this.cacheKeyGenerator = cacheKeyGenerator2;
        this.storage = httpCacheStorage;
    }

    public void flushInvalidatedCacheEntries(HttpHost httpHost, HttpRequest httpRequest) {
        if (requestShouldNotBeCached(httpRequest)) {
            this.log.debug("Request should not be cached");
            String uri = this.cacheKeyGenerator.getURI(httpHost, httpRequest);
            HttpCacheEntry entry = getEntry(uri);
            Log log2 = this.log;
            log2.debug("parent entry: " + entry);
            if (entry != null) {
                for (String flushEntry : entry.getVariantMap().values()) {
                    flushEntry(flushEntry);
                }
                flushEntry(uri);
            }
            URL absoluteURL = getAbsoluteURL(uri);
            if (absoluteURL == null) {
                this.log.error("Couldn't transform request into valid URL");
                return;
            }
            Header firstHeader = httpRequest.getFirstHeader("Content-Location");
            if (firstHeader != null) {
                String value = firstHeader.getValue();
                if (!flushAbsoluteUriFromSameHost(absoluteURL, value)) {
                    flushRelativeUriFromSameHost(absoluteURL, value);
                }
            }
            Header firstHeader2 = httpRequest.getFirstHeader("Location");
            if (firstHeader2 != null) {
                flushAbsoluteUriFromSameHost(absoluteURL, firstHeader2.getValue());
            }
        }
    }

    private void flushEntry(String str) {
        try {
            this.storage.removeEntry(str);
        } catch (IOException e) {
            this.log.warn("unable to flush cache entry", e);
        }
    }

    private HttpCacheEntry getEntry(String str) {
        try {
            return this.storage.getEntry(str);
        } catch (IOException e) {
            this.log.warn("could not retrieve entry from storage", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void flushUriIfSameHost(URL url, URL url2) {
        URL absoluteURL = getAbsoluteURL(this.cacheKeyGenerator.canonicalizeUri(url2.toString()));
        if (absoluteURL != null && absoluteURL.getAuthority().equalsIgnoreCase(url.getAuthority())) {
            flushEntry(absoluteURL.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void flushRelativeUriFromSameHost(URL url, String str) {
        URL relativeURL = getRelativeURL(url, str);
        if (relativeURL != null) {
            flushUriIfSameHost(url, relativeURL);
        }
    }

    /* access modifiers changed from: protected */
    public boolean flushAbsoluteUriFromSameHost(URL url, String str) {
        URL absoluteURL = getAbsoluteURL(str);
        if (absoluteURL == null) {
            return false;
        }
        flushUriIfSameHost(url, absoluteURL);
        return true;
    }

    private URL getAbsoluteURL(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    private URL getRelativeURL(URL url, String str) {
        try {
            return new URL(url, str);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public boolean requestShouldNotBeCached(HttpRequest httpRequest) {
        return notGetOrHeadRequest(httpRequest.getRequestLine().getMethod());
    }

    private boolean notGetOrHeadRequest(String str) {
        return !"GET".equals(str) && !"HEAD".equals(str);
    }

    public void flushInvalidatedCacheEntries(HttpHost httpHost, HttpRequest httpRequest, HttpResponse httpResponse) {
        URL absoluteURL;
        URL contentLocationURL;
        HttpCacheEntry entry;
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode >= 200 && statusCode <= 299 && (absoluteURL = getAbsoluteURL(this.cacheKeyGenerator.getURI(httpHost, httpRequest))) != null && (contentLocationURL = getContentLocationURL(absoluteURL, httpResponse)) != null && (entry = getEntry(this.cacheKeyGenerator.canonicalizeUri(contentLocationURL.toString()))) != null && responseDateNewerThanEntryDate(httpResponse, entry) && responseAndEntryEtagsDiffer(httpResponse, entry)) {
            flushUriIfSameHost(absoluteURL, contentLocationURL);
        }
    }

    private URL getContentLocationURL(URL url, HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Content-Location");
        if (firstHeader == null) {
            return null;
        }
        String value = firstHeader.getValue();
        URL absoluteURL = getAbsoluteURL(value);
        if (absoluteURL != null) {
            return absoluteURL;
        }
        return getRelativeURL(url, value);
    }

    private boolean responseAndEntryEtagsDiffer(HttpResponse httpResponse, HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("ETag");
        Header firstHeader2 = httpResponse.getFirstHeader("ETag");
        if (firstHeader == null || firstHeader2 == null) {
            return false;
        }
        return !firstHeader.getValue().equals(firstHeader2.getValue());
    }

    private boolean responseDateNewerThanEntryDate(HttpResponse httpResponse, HttpCacheEntry httpCacheEntry) {
        Header firstHeader = httpCacheEntry.getFirstHeader("Date");
        Header firstHeader2 = httpResponse.getFirstHeader("Date");
        if (!(firstHeader == null || firstHeader2 == null)) {
            try {
                return DateUtils.parseDate(firstHeader2.getValue()).after(DateUtils.parseDate(firstHeader.getValue()));
            } catch (DateParseException unused) {
            }
        }
        return false;
    }
}
