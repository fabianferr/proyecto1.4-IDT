package org.apache.http.impl.client;

import java.util.HashMap;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScheme;
import org.apache.http.client.AuthCache;

public class BasicAuthCache implements AuthCache {
    private final HashMap<HttpHost, AuthScheme> map = new HashMap<>();

    public void put(HttpHost httpHost, AuthScheme authScheme) {
        if (httpHost != null) {
            this.map.put(httpHost, authScheme);
            return;
        }
        throw new IllegalArgumentException("HTTP host may not be null");
    }

    public AuthScheme get(HttpHost httpHost) {
        if (httpHost != null) {
            return this.map.get(httpHost);
        }
        throw new IllegalArgumentException("HTTP host may not be null");
    }

    public void remove(HttpHost httpHost) {
        if (httpHost != null) {
            this.map.remove(httpHost);
            return;
        }
        throw new IllegalArgumentException("HTTP host may not be null");
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }
}
