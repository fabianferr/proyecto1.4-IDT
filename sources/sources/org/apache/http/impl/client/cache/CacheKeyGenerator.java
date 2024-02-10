package org.apache.http.impl.client.cache;

import androidx.webkit.ProxyConfig;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.client.cache.HttpCacheEntry;
import org.java_websocket.WebSocketImpl;

class CacheKeyGenerator {
    CacheKeyGenerator() {
    }

    public String getURI(HttpHost httpHost, HttpRequest httpRequest) {
        if (!isRelativeRequest(httpRequest)) {
            return canonicalizeUri(httpRequest.getRequestLine().getUri());
        }
        return canonicalizeUri(String.format("%s%s", new Object[]{httpHost.toString(), httpRequest.getRequestLine().getUri()}));
    }

    public String canonicalizeUri(String str) {
        try {
            URL url = new URL(str);
            String lowerCase = url.getProtocol().toLowerCase();
            String lowerCase2 = url.getHost().toLowerCase();
            int canonicalizePort = canonicalizePort(url.getPort(), lowerCase);
            String canonicalizePath = canonicalizePath(url.getPath());
            if ("".equals(canonicalizePath)) {
                canonicalizePath = "/";
            }
            String query = url.getQuery();
            if (query != null) {
                canonicalizePath = canonicalizePath + "?" + query;
            }
            return new URL(lowerCase, lowerCase2, canonicalizePort, canonicalizePath).toString();
        } catch (MalformedURLException unused) {
            return str;
        }
    }

    private String canonicalizePath(String str) {
        try {
            return new URI(URLDecoder.decode(str, "UTF-8")).getPath();
        } catch (UnsupportedEncodingException | URISyntaxException unused) {
            return str;
        }
    }

    private int canonicalizePort(int i, String str) {
        if (i != -1 || !"http".equalsIgnoreCase(str)) {
            return (i != -1 || !ProxyConfig.MATCH_HTTPS.equalsIgnoreCase(str)) ? i : WebSocketImpl.DEFAULT_WSS_PORT;
        }
        return 80;
    }

    private boolean isRelativeRequest(HttpRequest httpRequest) {
        String uri = httpRequest.getRequestLine().getUri();
        return "*".equals(uri) || uri.startsWith("/");
    }

    /* access modifiers changed from: protected */
    public String getFullHeaderValue(Header[] headerArr) {
        if (headerArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder("");
        int length = headerArr.length;
        boolean z = true;
        int i = 0;
        while (i < length) {
            Header header = headerArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append(header.getValue().trim());
            i++;
            z = false;
        }
        return sb.toString();
    }

    public String getVariantURI(HttpHost httpHost, HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) {
        if (!httpCacheEntry.hasVariants()) {
            return getURI(httpHost, httpRequest);
        }
        return getVariantKey(httpRequest, httpCacheEntry) + getURI(httpHost, httpRequest);
    }

    public String getVariantKey(HttpRequest httpRequest, HttpCacheEntry httpCacheEntry) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (Header elements : httpCacheEntry.getHeaders("Vary")) {
            for (HeaderElement name : elements.getElements()) {
                arrayList.add(name.getName());
            }
        }
        Collections.sort(arrayList);
        try {
            StringBuilder sb = new StringBuilder("{");
            boolean z = true;
            for (String str : arrayList) {
                if (!z) {
                    sb.append("&");
                }
                sb.append(URLEncoder.encode(str, "UTF-8"));
                sb.append("=");
                sb.append(URLEncoder.encode(getFullHeaderValue(httpRequest.getHeaders(str)), "UTF-8"));
                z = false;
            }
            sb.append("}");
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("couldn't encode to UTF-8", e);
        }
    }
}
