package org.apache.http.impl.client.cache;

import java.util.Date;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.cache.HeaderConstants;
import org.apache.http.impl.cookie.DateParseException;
import org.apache.http.impl.cookie.DateUtils;

class ResponseCachingPolicy {
    private final Log log = LogFactory.getLog(getClass());
    private final int maxObjectSizeBytes;
    private final boolean sharedCache;

    public ResponseCachingPolicy(int i, boolean z) {
        this.maxObjectSizeBytes = i;
        this.sharedCache = z;
    }

    public boolean isResponseCacheable(String str, HttpResponse httpResponse) {
        if (!"GET".equals(str)) {
            this.log.debug("Response was not cacheable.");
            return false;
        }
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (!(statusCode == 200 || statusCode == 203)) {
            if (statusCode == 206) {
                this.log.debug("Response was not cacheable (Partial Content)");
                return false;
            } else if (!(statusCode == 410 || statusCode == 300 || statusCode == 301)) {
                this.log.debug("Response was not cacheable (Unknown Status code)");
                return false;
            }
        }
        this.log.debug("Response was cacheable");
        Header firstHeader = httpResponse.getFirstHeader("Content-Length");
        if ((firstHeader != null && Integer.parseInt(firstHeader.getValue()) > this.maxObjectSizeBytes) || httpResponse.getHeaders("Age").length > 1 || httpResponse.getHeaders("Expires").length > 1) {
            return false;
        }
        Header[] headers = httpResponse.getHeaders("Date");
        if (headers.length != 1) {
            return false;
        }
        try {
            DateUtils.parseDate(headers[0].getValue());
            for (Header elements : httpResponse.getHeaders("Vary")) {
                for (HeaderElement name : elements.getElements()) {
                    if ("*".equals(name.getName())) {
                        return false;
                    }
                }
            }
            if (isExplicitlyNonCacheable(httpResponse)) {
                return false;
            }
            return true;
        } catch (DateParseException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isExplicitlyNonCacheable(HttpResponse httpResponse) {
        for (Header elements : httpResponse.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                if (HeaderConstants.CACHE_CONTROL_NO_STORE.equals(headerElement.getName()) || HeaderConstants.CACHE_CONTROL_NO_CACHE.equals(headerElement.getName())) {
                    return true;
                }
                if (this.sharedCache && "private".equals(headerElement.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean hasCacheControlParameterFrom(HttpMessage httpMessage, String[] strArr) {
        for (Header elements : httpMessage.getHeaders("Cache-Control")) {
            for (HeaderElement headerElement : elements.getElements()) {
                for (String equalsIgnoreCase : strArr) {
                    if (equalsIgnoreCase.equalsIgnoreCase(headerElement.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean isExplicitlyCacheable(HttpResponse httpResponse) {
        if (httpResponse.getFirstHeader("Expires") != null) {
            return true;
        }
        return hasCacheControlParameterFrom(httpResponse, new String[]{"max-age", "s-maxage", HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE, "public"});
    }

    public boolean isResponseCacheable(HttpRequest httpRequest, HttpResponse httpResponse) {
        Header[] headers;
        if (requestProtocolGreaterThanAccepted(httpRequest)) {
            this.log.debug("Response was not cacheable.");
            return false;
        } else if (hasCacheControlParameterFrom(httpRequest, new String[]{HeaderConstants.CACHE_CONTROL_NO_STORE})) {
            return false;
        } else {
            if (httpRequest.getRequestLine().getUri().contains("?") && (!isExplicitlyCacheable(httpResponse) || from1_0Origin(httpResponse))) {
                this.log.debug("Response was not cacheable.");
                return false;
            } else if (expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(httpResponse)) {
                return false;
            } else {
                if (!this.sharedCache || (headers = httpRequest.getHeaders("Authorization")) == null || headers.length <= 0) {
                    return isResponseCacheable(httpRequest.getRequestLine().getMethod(), httpResponse);
                }
                return hasCacheControlParameterFrom(httpResponse, new String[]{"s-maxage", HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE, "public"});
            }
        }
    }

    private boolean expiresHeaderLessOrEqualToDateHeaderAndNoCacheControl(HttpResponse httpResponse) {
        if (httpResponse.getFirstHeader("Cache-Control") != null) {
            return false;
        }
        Header firstHeader = httpResponse.getFirstHeader("Expires");
        Header firstHeader2 = httpResponse.getFirstHeader("Date");
        if (firstHeader == null || firstHeader2 == null) {
            return false;
        }
        try {
            Date parseDate = DateUtils.parseDate(firstHeader.getValue());
            Date parseDate2 = DateUtils.parseDate(firstHeader2.getValue());
            if (parseDate.equals(parseDate2) || parseDate.before(parseDate2)) {
                return true;
            }
            return false;
        } catch (DateParseException unused) {
            return false;
        }
    }

    private boolean from1_0Origin(HttpResponse httpResponse) {
        Header firstHeader = httpResponse.getFirstHeader("Via");
        if (firstHeader != null) {
            HeaderElement[] elements = firstHeader.getElements();
            if (elements.length > 0) {
                String str = elements[0].toString().split("\\s")[0];
                if (str.contains("/")) {
                    return str.equals("HTTP/1.0");
                }
                return str.equals("1.0");
            }
        }
        return HttpVersion.HTTP_1_0.equals(httpResponse.getProtocolVersion());
    }

    private boolean requestProtocolGreaterThanAccepted(HttpRequest httpRequest) {
        return httpRequest.getProtocolVersion().compareToVersion(HttpVersion.HTTP_1_1) > 0;
    }
}
