package org.apache.http.client.utils;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.Stack;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.HttpHost;

public class URIUtils {
    public static URI createURI(String str, String str2, int i, String str3, String str4, String str5) throws URISyntaxException {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i > 0) {
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(i);
            }
        }
        if (str3 == null || !str3.startsWith("/")) {
            sb.append('/');
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return new URI(sb.toString());
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost, boolean z) throws URISyntaxException {
        if (uri != null) {
            String str = null;
            if (httpHost != null) {
                String schemeName = httpHost.getSchemeName();
                String hostName = httpHost.getHostName();
                int port = httpHost.getPort();
                String normalizePath = normalizePath(uri.getRawPath());
                String rawQuery = uri.getRawQuery();
                if (!z) {
                    str = uri.getRawFragment();
                }
                return createURI(schemeName, hostName, port, normalizePath, rawQuery, str);
            }
            String normalizePath2 = normalizePath(uri.getRawPath());
            String rawQuery2 = uri.getRawQuery();
            if (!z) {
                str = uri.getRawFragment();
            }
            return createURI((String) null, (String) null, -1, normalizePath2, rawQuery2, str);
        }
        throw new IllegalArgumentException("URI may nor be null");
    }

    private static String normalizePath(String str) {
        if (str == null) {
            return null;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == '/') {
            i++;
        }
        return i > 1 ? str.substring(i - 1) : str;
    }

    public static URI rewriteURI(URI uri, HttpHost httpHost) throws URISyntaxException {
        return rewriteURI(uri, httpHost, false);
    }

    public static URI resolve(URI uri, String str) {
        return resolve(uri, URI.create(str));
    }

    public static URI resolve(URI uri, URI uri2) {
        if (uri == null) {
            throw new IllegalArgumentException("Base URI may nor be null");
        } else if (uri2 != null) {
            String uri3 = uri2.toString();
            if (uri3.startsWith("?")) {
                return resolveReferenceStartingWithQueryString(uri, uri2);
            }
            boolean z = uri3.length() == 0;
            if (z) {
                uri2 = URI.create("#");
            }
            URI resolve = uri.resolve(uri2);
            if (z) {
                String uri4 = resolve.toString();
                resolve = URI.create(uri4.substring(0, uri4.indexOf(35)));
            }
            return removeDotSegments(resolve);
        } else {
            throw new IllegalArgumentException("Reference URI may nor be null");
        }
    }

    private static URI resolveReferenceStartingWithQueryString(URI uri, URI uri2) {
        String uri3 = uri.toString();
        if (uri3.indexOf(63) > -1) {
            uri3 = uri3.substring(0, uri3.indexOf(63));
        }
        return URI.create(uri3 + uri2.toString());
    }

    private static URI removeDotSegments(URI uri) {
        String path = uri.getPath();
        if (path == null || path.indexOf("/.") == -1) {
            return uri;
        }
        String[] split = path.split("/");
        Stack stack = new Stack();
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() != 0 && !".".equals(split[i])) {
                if (!"..".equals(split[i])) {
                    stack.push(split[i]);
                } else if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = stack.iterator();
        while (it.hasNext()) {
            sb.append('/');
            sb.append((String) it.next());
        }
        try {
            return new URI(uri.getScheme(), uri.getAuthority(), sb.toString(), uri.getQuery(), uri.getFragment());
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static HttpHost extractHost(URI uri) {
        int indexOf;
        if (uri == null || !uri.isAbsolute()) {
            return null;
        }
        int port = uri.getPort();
        String host = uri.getHost();
        if (host == null && (host = uri.getAuthority()) != null) {
            int indexOf2 = host.indexOf(64);
            if (indexOf2 >= 0) {
                int i = indexOf2 + 1;
                host = host.length() > i ? host.substring(i) : null;
            }
            if (host != null && (indexOf = host.indexOf(58)) >= 0) {
                int i2 = indexOf + 1;
                if (i2 < host.length()) {
                    port = Integer.parseInt(host.substring(i2));
                }
                host = host.substring(0, indexOf);
            }
        }
        String scheme = uri.getScheme();
        if (host != null) {
            return new HttpHost(host, port, scheme);
        }
        return null;
    }

    private URIUtils() {
    }
}
