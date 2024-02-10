package org.apache.http.impl.client.cache;

import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpRequest;
import org.apache.http.ProtocolException;
import org.apache.http.client.cache.HeaderConstants;
import org.apache.http.client.cache.HttpCacheEntry;
import org.apache.http.impl.client.RequestWrapper;

class ConditionalRequestBuilder {
    private static final Log log = LogFactory.getLog(ConditionalRequestBuilder.class);

    ConditionalRequestBuilder() {
    }

    public HttpRequest buildConditionalRequest(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) throws ProtocolException {
        RequestWrapper requestWrapper = new RequestWrapper(httpRequest);
        requestWrapper.resetHeaders();
        Header firstHeader = httpCacheEntry.getFirstHeader("ETag");
        if (firstHeader != null) {
            requestWrapper.setHeader("If-None-Match", firstHeader.getValue());
        }
        Header firstHeader2 = httpCacheEntry.getFirstHeader("Last-Modified");
        if (firstHeader2 != null) {
            requestWrapper.setHeader("If-Modified-Since", firstHeader2.getValue());
        }
        boolean z = false;
        for (Header elements : httpCacheEntry.getHeaders("Cache-Control")) {
            HeaderElement[] elements2 = elements.getElements();
            int length = elements2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                HeaderElement headerElement = elements2[i];
                if (HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE.equalsIgnoreCase(headerElement.getName()) || HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE.equalsIgnoreCase(headerElement.getName())) {
                    z = true;
                } else {
                    i++;
                }
            }
        }
        if (z) {
            requestWrapper.addHeader("Cache-Control", "max-age=0");
        }
        return requestWrapper;
    }

    public HttpRequest buildConditionalRequestFromVariants(HttpRequest httpRequest, Map<String, Variant> map) {
        try {
            RequestWrapper requestWrapper = new RequestWrapper(httpRequest);
            requestWrapper.resetHeaders();
            StringBuilder sb = new StringBuilder();
            boolean z = true;
            for (String next : map.keySet()) {
                if (!z) {
                    sb.append(",");
                }
                sb.append(next);
                z = false;
            }
            requestWrapper.setHeader("If-None-Match", sb.toString());
            return requestWrapper;
        } catch (ProtocolException e) {
            log.warn("unable to build conditional request", e);
            return httpRequest;
        }
    }

    public HttpRequest buildUnconditionalRequest(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) {
        try {
            RequestWrapper requestWrapper = new RequestWrapper(httpRequest);
            requestWrapper.resetHeaders();
            requestWrapper.addHeader("Cache-Control", HeaderConstants.CACHE_CONTROL_NO_CACHE);
            requestWrapper.addHeader("Pragma", HeaderConstants.CACHE_CONTROL_NO_CACHE);
            requestWrapper.removeHeaders("If-Range");
            requestWrapper.removeHeaders("If-Match");
            requestWrapper.removeHeaders("If-None-Match");
            requestWrapper.removeHeaders("If-Unmodified-Since");
            requestWrapper.removeHeaders("If-Modified-Since");
            return requestWrapper;
        } catch (ProtocolException e) {
            log.warn("unable to build proper unconditional request", e);
            return httpRequest;
        }
    }
}
