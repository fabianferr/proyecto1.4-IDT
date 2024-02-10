package org.apache.http.client.protocol;

import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.ContextAwareAuthScheme;
import org.apache.http.auth.Credentials;
import org.apache.http.protocol.HttpContext;

public class RequestTargetAuthentication implements HttpRequestInterceptor {
    private final Log log = LogFactory.getLog(getClass());

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Header header;
        if (httpRequest == null) {
            throw new IllegalArgumentException("HTTP request may not be null");
        } else if (httpContext == null) {
            throw new IllegalArgumentException("HTTP context may not be null");
        } else if (!httpRequest.getRequestLine().getMethod().equalsIgnoreCase("CONNECT") && !httpRequest.containsHeader("Authorization")) {
            AuthState authState = (AuthState) httpContext.getAttribute(ClientContext.TARGET_AUTH_STATE);
            if (authState == null) {
                this.log.debug("Target auth state not set in the context");
                return;
            }
            AuthScheme authScheme = authState.getAuthScheme();
            if (authScheme != null) {
                Credentials credentials = authState.getCredentials();
                if (credentials == null) {
                    this.log.debug("User credentials not available");
                } else if (authState.getAuthScope() != null || !authScheme.isConnectionBased()) {
                    try {
                        if (authScheme instanceof ContextAwareAuthScheme) {
                            header = ((ContextAwareAuthScheme) authScheme).authenticate(credentials, httpRequest, httpContext);
                        } else {
                            header = authScheme.authenticate(credentials, httpRequest);
                        }
                        httpRequest.addHeader(header);
                    } catch (AuthenticationException e) {
                        if (this.log.isErrorEnabled()) {
                            Log log2 = this.log;
                            log2.error("Authentication error: " + e.getMessage());
                        }
                    }
                }
            }
        }
    }
}
