package org.apache.http.impl.client.cache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpRequest;
import org.apache.http.HttpVersion;
import org.apache.http.client.cache.HeaderConstants;

class CacheableRequestPolicy {
    private final Log log = LogFactory.getLog(getClass());

    CacheableRequestPolicy() {
    }

    public boolean isServableFromCache(HttpRequest httpRequest) {
        String method = httpRequest.getRequestLine().getMethod();
        if (HttpVersion.HTTP_1_1.compareToVersion(httpRequest.getRequestLine().getProtocolVersion()) != 0) {
            this.log.debug("Request was not serveable from cache");
            return false;
        } else if (!method.equals("GET")) {
            this.log.debug("Request was not serveable from cache");
            return false;
        } else if (httpRequest.getHeaders("Pragma").length > 0) {
            this.log.debug("Request was not serveable from cache");
            return false;
        } else {
            for (Header elements : httpRequest.getHeaders("Cache-Control")) {
                HeaderElement[] elements2 = elements.getElements();
                int length = elements2.length;
                int i = 0;
                while (i < length) {
                    HeaderElement headerElement = elements2[i];
                    if (HeaderConstants.CACHE_CONTROL_NO_STORE.equalsIgnoreCase(headerElement.getName())) {
                        this.log.debug("Request was not serveable from Cache");
                        return false;
                    } else if (HeaderConstants.CACHE_CONTROL_NO_CACHE.equalsIgnoreCase(headerElement.getName())) {
                        this.log.debug("Request was not serveable from cache");
                        return false;
                    } else {
                        i++;
                    }
                }
            }
            this.log.debug("Request was serveable from cache");
            return true;
        }
    }
}
