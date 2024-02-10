package org.apache.http.impl.client;

import java.security.Principal;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.client.UserTokenHandler;

public class DefaultUserTokenHandler implements UserTokenHandler {
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002e, code lost:
        r3 = r3.getSSLSession();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getUserToken(org.apache.http.protocol.HttpContext r3) {
        /*
            r2 = this;
            java.lang.String r0 = "http.auth.target-scope"
            java.lang.Object r0 = r3.getAttribute(r0)
            org.apache.http.auth.AuthState r0 = (org.apache.http.auth.AuthState) r0
            if (r0 == 0) goto L_0x001d
            java.security.Principal r0 = getAuthPrincipal(r0)
            if (r0 != 0) goto L_0x001e
            java.lang.String r0 = "http.auth.proxy-scope"
            java.lang.Object r0 = r3.getAttribute(r0)
            org.apache.http.auth.AuthState r0 = (org.apache.http.auth.AuthState) r0
            java.security.Principal r0 = getAuthPrincipal(r0)
            goto L_0x001e
        L_0x001d:
            r0 = 0
        L_0x001e:
            if (r0 != 0) goto L_0x0038
            java.lang.String r1 = "http.connection"
            java.lang.Object r3 = r3.getAttribute(r1)
            org.apache.http.conn.HttpRoutedConnection r3 = (org.apache.http.conn.HttpRoutedConnection) r3
            boolean r1 = r3.isOpen()
            if (r1 == 0) goto L_0x0038
            javax.net.ssl.SSLSession r3 = r3.getSSLSession()
            if (r3 == 0) goto L_0x0038
            java.security.Principal r0 = r3.getLocalPrincipal()
        L_0x0038:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.impl.client.DefaultUserTokenHandler.getUserToken(org.apache.http.protocol.HttpContext):java.lang.Object");
    }

    private static Principal getAuthPrincipal(AuthState authState) {
        Credentials credentials;
        AuthScheme authScheme = authState.getAuthScheme();
        if (authScheme == null || !authScheme.isComplete() || !authScheme.isConnectionBased() || (credentials = authState.getCredentials()) == null) {
            return null;
        }
        return credentials.getUserPrincipal();
    }
}
