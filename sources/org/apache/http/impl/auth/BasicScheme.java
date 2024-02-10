package org.apache.http.impl.auth;

import com.facebook.internal.security.CertificateUtil;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.params.AuthParams;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

public class BasicScheme extends RFC2617Scheme {
    private boolean complete = false;

    public String getSchemeName() {
        return "basic";
    }

    public boolean isConnectionBased() {
        return false;
    }

    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        this.complete = true;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        if (credentials == null) {
            throw new IllegalArgumentException("Credentials may not be null");
        } else if (httpRequest != null) {
            return authenticate(credentials, AuthParams.getCredentialCharset(httpRequest.getParams()), isProxy());
        } else {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
    }

    public static Header authenticate(Credentials credentials, String str, boolean z) {
        if (credentials == null) {
            throw new IllegalArgumentException("Credentials may not be null");
        } else if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(credentials.getUserPrincipal().getName());
            sb.append(CertificateUtil.DELIMITER);
            sb.append(credentials.getPassword() == null ? AbstractJsonLexerKt.NULL : credentials.getPassword());
            byte[] encodeBase64 = Base64.encodeBase64(EncodingUtils.getBytes(sb.toString(), str));
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
            if (z) {
                charArrayBuffer.append("Proxy-Authorization");
            } else {
                charArrayBuffer.append("Authorization");
            }
            charArrayBuffer.append(": Basic ");
            charArrayBuffer.append(encodeBase64, 0, encodeBase64.length);
            return new BufferedHeader(charArrayBuffer);
        } else {
            throw new IllegalArgumentException("charset may not be null");
        }
    }
}