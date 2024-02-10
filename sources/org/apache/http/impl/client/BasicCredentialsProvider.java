package org.apache.http.impl.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.client.CredentialsProvider;

public class BasicCredentialsProvider implements CredentialsProvider {
    private final ConcurrentHashMap<AuthScope, Credentials> credMap = new ConcurrentHashMap<>();

    public void setCredentials(AuthScope authScope, Credentials credentials) {
        if (authScope != null) {
            this.credMap.put(authScope, credentials);
            return;
        }
        throw new IllegalArgumentException("Authentication scope may not be null");
    }

    private static Credentials matchCredentials(Map<AuthScope, Credentials> map, AuthScope authScope) {
        Credentials credentials = map.get(authScope);
        if (credentials != null) {
            return credentials;
        }
        int i = -1;
        AuthScope authScope2 = null;
        for (AuthScope next : map.keySet()) {
            int match = authScope.match(next);
            if (match > i) {
                authScope2 = next;
                i = match;
            }
        }
        return authScope2 != null ? map.get(authScope2) : credentials;
    }

    public Credentials getCredentials(AuthScope authScope) {
        if (authScope != null) {
            return matchCredentials(this.credMap, authScope);
        }
        throw new IllegalArgumentException("Authentication scope may not be null");
    }

    public void clear() {
        this.credMap.clear();
    }

    public String toString() {
        return this.credMap.toString();
    }
}
