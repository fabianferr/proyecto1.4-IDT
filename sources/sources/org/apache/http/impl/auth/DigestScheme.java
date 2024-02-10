package org.apache.http.impl.auth;

import com.applovin.sdk.AppLovinEventParameters;
import com.facebook.internal.ServerProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.common.base.Ascii;
import com.mbridge.msdk.foundation.tools.SameMD5;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Locale;
import java.util.StringTokenizer;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.MalformedChallengeException;
import org.apache.http.auth.params.AuthParams;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BufferedHeader;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EncodingUtils;

public class DigestScheme extends RFC2617Scheme {
    private static final char[] HEXADECIMAL = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final int QOP_AUTH = 2;
    private static final int QOP_AUTH_INT = 1;
    private static final int QOP_MISSING = 0;
    private String cnonce;
    private boolean complete = false;
    private String lastNonce;
    private String nc;
    private long nounceCount;
    private int qopVariant = 0;

    public String getSchemeName() {
        return "digest";
    }

    public boolean isConnectionBased() {
        return false;
    }

    public void processChallenge(Header header) throws MalformedChallengeException {
        super.processChallenge(header);
        if (getParameter("realm") == null) {
            throw new MalformedChallengeException("missing realm in challange");
        } else if (getParameter("nonce") != null) {
            String parameter = getParameter("qop");
            boolean z = false;
            if (parameter != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(parameter, ",");
                while (true) {
                    if (!stringTokenizer.hasMoreTokens()) {
                        break;
                    }
                    String trim = stringTokenizer.nextToken().trim();
                    if (trim.equals("auth")) {
                        this.qopVariant = 2;
                        break;
                    } else if (trim.equals("auth-int")) {
                        this.qopVariant = 1;
                    } else {
                        z = true;
                    }
                }
            }
            if (!z || this.qopVariant != 0) {
                this.complete = true;
                return;
            }
            throw new MalformedChallengeException("None of the qop methods is supported");
        } else {
            throw new MalformedChallengeException("missing nonce in challange");
        }
    }

    public boolean isComplete() {
        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(getParameter("stale"))) {
            return false;
        }
        return this.complete;
    }

    public void overrideParamter(String str, String str2) {
        getParameters().put(str, str2);
    }

    private String getCnonce() {
        if (this.cnonce == null) {
            this.cnonce = createCnonce();
        }
        return this.cnonce;
    }

    private String getNc() {
        if (this.nc == null) {
            StringBuilder sb = new StringBuilder();
            new Formatter(sb, Locale.US).format("%08x", new Object[]{Long.valueOf(this.nounceCount)});
            this.nc = sb.toString();
        }
        return this.nc;
    }

    public Header authenticate(Credentials credentials, HttpRequest httpRequest) throws AuthenticationException {
        if (credentials == null) {
            throw new IllegalArgumentException("Credentials may not be null");
        } else if (httpRequest != null) {
            getParameters().put("methodname", httpRequest.getRequestLine().getMethod());
            getParameters().put(ShareConstants.MEDIA_URI, httpRequest.getRequestLine().getUri());
            if (getParameter("charset") == null) {
                getParameters().put("charset", AuthParams.getCredentialCharset(httpRequest.getParams()));
            }
            return createDigestHeader(credentials, createDigest(credentials));
        } else {
            throw new IllegalArgumentException("HTTP request may not be null");
        }
    }

    private static MessageDigest createMessageDigest(String str) throws UnsupportedDigestAlgorithmException {
        try {
            return MessageDigest.getInstance(str);
        } catch (Exception unused) {
            throw new UnsupportedDigestAlgorithmException("Unsupported algorithm in HTTP Digest authentication: " + str);
        }
    }

    private String createDigest(Credentials credentials) throws AuthenticationException {
        String str;
        String parameter = getParameter(ShareConstants.MEDIA_URI);
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("methodname");
        String parameter5 = getParameter("algorithm");
        if (parameter == null) {
            throw new IllegalStateException("URI may not be null");
        } else if (parameter2 == null) {
            throw new IllegalStateException("Realm may not be null");
        } else if (parameter3 != null) {
            String str2 = null;
            this.cnonce = null;
            this.nc = null;
            String str3 = SameMD5.TAG;
            if (parameter5 == null) {
                parameter5 = str3;
            }
            String parameter6 = getParameter("charset");
            if (parameter6 == null) {
                parameter6 = "ISO-8859-1";
            }
            if (this.qopVariant != 1) {
                if (!parameter5.equalsIgnoreCase("MD5-sess")) {
                    str3 = parameter5;
                }
                if (parameter3.equals(this.lastNonce)) {
                    this.nounceCount++;
                } else {
                    this.nounceCount = 1;
                    this.lastNonce = parameter3;
                }
                MessageDigest createMessageDigest = createMessageDigest(str3);
                String name = credentials.getUserPrincipal().getName();
                String password = credentials.getPassword();
                StringBuilder sb = new StringBuilder(name.length() + parameter2.length() + password.length() + 2);
                sb.append(name);
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(parameter2);
                sb.append(AbstractJsonLexerKt.COLON);
                sb.append(password);
                String sb2 = sb.toString();
                if (parameter5.equalsIgnoreCase("MD5-sess")) {
                    String cnonce2 = getCnonce();
                    String encode = encode(createMessageDigest.digest(EncodingUtils.getBytes(sb2, parameter6)));
                    StringBuilder sb3 = new StringBuilder(encode.length() + parameter3.length() + cnonce2.length() + 2);
                    sb3.append(encode);
                    sb3.append(AbstractJsonLexerKt.COLON);
                    sb3.append(parameter3);
                    sb3.append(AbstractJsonLexerKt.COLON);
                    sb3.append(cnonce2);
                    sb2 = sb3.toString();
                }
                String encode2 = encode(createMessageDigest.digest(EncodingUtils.getBytes(sb2, parameter6)));
                if (this.qopVariant != 1) {
                    str2 = parameter4 + AbstractJsonLexerKt.COLON + parameter;
                }
                String encode3 = encode(createMessageDigest.digest(EncodingUtils.getAsciiBytes(str2)));
                if (this.qopVariant == 0) {
                    StringBuilder sb4 = new StringBuilder(encode2.length() + parameter3.length() + encode2.length());
                    sb4.append(encode2);
                    sb4.append(AbstractJsonLexerKt.COLON);
                    sb4.append(parameter3);
                    sb4.append(AbstractJsonLexerKt.COLON);
                    sb4.append(encode3);
                    str = sb4.toString();
                } else {
                    String qopVariantString = getQopVariantString();
                    String cnonce3 = getCnonce();
                    String nc2 = getNc();
                    StringBuilder sb5 = new StringBuilder(encode2.length() + parameter3.length() + nc2.length() + cnonce3.length() + qopVariantString.length() + encode3.length() + 5);
                    sb5.append(encode2);
                    sb5.append(AbstractJsonLexerKt.COLON);
                    sb5.append(parameter3);
                    sb5.append(AbstractJsonLexerKt.COLON);
                    sb5.append(nc2);
                    sb5.append(AbstractJsonLexerKt.COLON);
                    sb5.append(cnonce3);
                    sb5.append(AbstractJsonLexerKt.COLON);
                    sb5.append(qopVariantString);
                    sb5.append(AbstractJsonLexerKt.COLON);
                    sb5.append(encode3);
                    str = sb5.toString();
                }
                return encode(createMessageDigest.digest(EncodingUtils.getAsciiBytes(str)));
            }
            throw new AuthenticationException("Unsupported qop in HTTP Digest authentication");
        } else {
            throw new IllegalStateException("Nonce may not be null");
        }
    }

    private Header createDigestHeader(Credentials credentials, String str) {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(128);
        if (isProxy()) {
            charArrayBuffer.append("Proxy-Authorization");
        } else {
            charArrayBuffer.append("Authorization");
        }
        charArrayBuffer.append(": Digest ");
        String parameter = getParameter(ShareConstants.MEDIA_URI);
        String parameter2 = getParameter("realm");
        String parameter3 = getParameter("nonce");
        String parameter4 = getParameter("opaque");
        String parameter5 = getParameter("algorithm");
        String name = credentials.getUserPrincipal().getName();
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(new BasicNameValuePair(AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER, name));
        arrayList.add(new BasicNameValuePair("realm", parameter2));
        arrayList.add(new BasicNameValuePair("nonce", parameter3));
        arrayList.add(new BasicNameValuePair(ShareConstants.MEDIA_URI, parameter));
        arrayList.add(new BasicNameValuePair("response", str));
        if (this.qopVariant != 0) {
            arrayList.add(new BasicNameValuePair("qop", getQopVariantString()));
            arrayList.add(new BasicNameValuePair("nc", getNc()));
            arrayList.add(new BasicNameValuePair("cnonce", getCnonce()));
        }
        if (parameter5 != null) {
            arrayList.add(new BasicNameValuePair("algorithm", parameter5));
        }
        if (parameter4 != null) {
            arrayList.add(new BasicNameValuePair("opaque", parameter4));
        }
        for (int i = 0; i < arrayList.size(); i++) {
            BasicNameValuePair basicNameValuePair = (BasicNameValuePair) arrayList.get(i);
            if (i > 0) {
                charArrayBuffer.append(", ");
            }
            BasicHeaderValueFormatter.DEFAULT.formatNameValuePair(charArrayBuffer, (NameValuePair) basicNameValuePair, !("nc".equals(basicNameValuePair.getName()) || "qop".equals(basicNameValuePair.getName())));
        }
        return new BufferedHeader(charArrayBuffer);
    }

    private String getQopVariantString() {
        return this.qopVariant == 1 ? "auth-int" : "auth";
    }

    private static String encode(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            byte b2 = b & Ascii.SI;
            int i2 = i * 2;
            char[] cArr2 = HEXADECIMAL;
            cArr[i2] = cArr2[(b & 240) >> 4];
            cArr[i2 + 1] = cArr2[b2];
        }
        return new String(cArr);
    }

    public static String createCnonce() {
        return encode(createMessageDigest(SameMD5.TAG).digest(EncodingUtils.getAsciiBytes(Long.toString(System.currentTimeMillis()))));
    }
}
