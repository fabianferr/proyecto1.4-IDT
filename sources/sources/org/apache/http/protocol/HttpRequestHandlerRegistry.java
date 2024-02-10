package org.apache.http.protocol;

import java.util.Map;

public class HttpRequestHandlerRegistry implements HttpRequestHandlerResolver {
    private final UriPatternMatcher matcher = new UriPatternMatcher();

    public void register(String str, HttpRequestHandler httpRequestHandler) {
        if (str == null) {
            throw new IllegalArgumentException("URI request pattern may not be null");
        } else if (httpRequestHandler != null) {
            this.matcher.register(str, httpRequestHandler);
        } else {
            throw new IllegalArgumentException("Request handler may not be null");
        }
    }

    public void unregister(String str) {
        this.matcher.unregister(str);
    }

    public void setHandlers(Map map) {
        this.matcher.setObjects(map);
    }

    public HttpRequestHandler lookup(String str) {
        return (HttpRequestHandler) this.matcher.lookup(str);
    }

    /* access modifiers changed from: protected */
    public boolean matchUriRequestPattern(String str, String str2) {
        return this.matcher.matchUriRequestPattern(str, str2);
    }
}
