package org.apache.http;

import com.facebook.internal.security.CertificateUtil;
import java.io.Serializable;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.LangUtils;

public final class HttpHost implements Cloneable, Serializable {
    public static final String DEFAULT_SCHEME_NAME = "http";
    private static final long serialVersionUID = -7529410654042457626L;
    protected final String hostname;
    protected final String lcHostname;
    protected final int port;
    protected final String schemeName;

    public HttpHost(String str, int i, String str2) {
        if (str != null) {
            this.hostname = str;
            this.lcHostname = str.toLowerCase(Locale.ENGLISH);
            if (str2 != null) {
                this.schemeName = str2.toLowerCase(Locale.ENGLISH);
            } else {
                this.schemeName = "http";
            }
            this.port = i;
            return;
        }
        throw new IllegalArgumentException("Host name may not be null");
    }

    public HttpHost(String str, int i) {
        this(str, i, (String) null);
    }

    public HttpHost(String str) {
        this(str, -1, (String) null);
    }

    public HttpHost(HttpHost httpHost) {
        this(httpHost.hostname, httpHost.port, httpHost.schemeName);
    }

    public String getHostName() {
        return this.hostname;
    }

    public int getPort() {
        return this.port;
    }

    public String getSchemeName() {
        return this.schemeName;
    }

    public String toURI() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(32);
        charArrayBuffer.append(this.schemeName);
        charArrayBuffer.append("://");
        charArrayBuffer.append(this.hostname);
        if (this.port != -1) {
            charArrayBuffer.append((char) AbstractJsonLexerKt.COLON);
            charArrayBuffer.append(Integer.toString(this.port));
        }
        return charArrayBuffer.toString();
    }

    public String toHostString() {
        if (this.port == -1) {
            return this.hostname;
        }
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(this.hostname.length() + 6);
        charArrayBuffer.append(this.hostname);
        charArrayBuffer.append(CertificateUtil.DELIMITER);
        charArrayBuffer.append(Integer.toString(this.port));
        return charArrayBuffer.toString();
    }

    public String toString() {
        return toURI();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HttpHost)) {
            return false;
        }
        HttpHost httpHost = (HttpHost) obj;
        if (!this.lcHostname.equals(httpHost.lcHostname) || this.port != httpHost.port || !this.schemeName.equals(httpHost.schemeName)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return LangUtils.hashCode(LangUtils.hashCode(LangUtils.hashCode(17, (Object) this.lcHostname), this.port), (Object) this.schemeName);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
