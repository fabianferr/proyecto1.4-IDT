package org.apache.http.auth;

import com.facebook.internal.ServerProtocol;

public class AuthState {
    private AuthScheme authScheme;
    private AuthScope authScope;
    private Credentials credentials;

    public void invalidate() {
        this.authScheme = null;
        this.authScope = null;
        this.credentials = null;
    }

    public boolean isValid() {
        return this.authScheme != null;
    }

    public void setAuthScheme(AuthScheme authScheme2) {
        if (authScheme2 == null) {
            invalidate();
        } else {
            this.authScheme = authScheme2;
        }
    }

    public AuthScheme getAuthScheme() {
        return this.authScheme;
    }

    public Credentials getCredentials() {
        return this.credentials;
    }

    public void setCredentials(Credentials credentials2) {
        this.credentials = credentials2;
    }

    public AuthScope getAuthScope() {
        return this.authScope;
    }

    public void setAuthScope(AuthScope authScope2) {
        this.authScope = authScope2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("auth scope [");
        sb.append(this.authScope);
        sb.append("]; credentials set [");
        sb.append(this.credentials != null ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        sb.append("]");
        return sb.toString();
    }
}
