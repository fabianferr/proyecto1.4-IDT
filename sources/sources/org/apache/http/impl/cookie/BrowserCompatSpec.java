package org.apache.http.impl.cookie;

import java.util.ArrayList;
import java.util.List;
import org.apache.http.FormattedHeader;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.message.BufferedHeader;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;

public class BrowserCompatSpec extends CookieSpecBase {
    @Deprecated
    protected static final String[] DATE_PATTERNS = {"EEE, dd MMM yyyy HH:mm:ss zzz", DateUtils.PATTERN_RFC1036, DateUtils.PATTERN_ASCTIME, "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};
    private static final String[] DEFAULT_DATE_PATTERNS = {"EEE, dd MMM yyyy HH:mm:ss zzz", DateUtils.PATTERN_RFC1036, DateUtils.PATTERN_ASCTIME, "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};
    private final String[] datepatterns;

    public int getVersion() {
        return 0;
    }

    public Header getVersionHeader() {
        return null;
    }

    public String toString() {
        return CookiePolicy.BROWSER_COMPATIBILITY;
    }

    public BrowserCompatSpec(String[] strArr) {
        if (strArr != null) {
            this.datepatterns = (String[]) strArr.clone();
        } else {
            this.datepatterns = DEFAULT_DATE_PATTERNS;
        }
        registerAttribHandler("path", new BasicPathHandler());
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new BasicDomainHandler());
        registerAttribHandler("max-age", new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(this.datepatterns));
    }

    public BrowserCompatSpec() {
        this((String[]) null);
    }

    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        ParserCursor parserCursor;
        CharArrayBuffer charArrayBuffer;
        if (header == null) {
            throw new IllegalArgumentException("Header may not be null");
        } else if (cookieOrigin == null) {
            throw new IllegalArgumentException("Cookie origin may not be null");
        } else if (header.getName().equalsIgnoreCase("Set-Cookie")) {
            HeaderElement[] elements = header.getElements();
            boolean z = false;
            boolean z2 = false;
            for (HeaderElement headerElement : elements) {
                if (headerElement.getParameterByName("version") != null) {
                    z2 = true;
                }
                if (headerElement.getParameterByName(ClientCookie.EXPIRES_ATTR) != null) {
                    z = true;
                }
            }
            if (z || !z2) {
                NetscapeDraftHeaderParser netscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
                if (header instanceof FormattedHeader) {
                    FormattedHeader formattedHeader = (FormattedHeader) header;
                    charArrayBuffer = formattedHeader.getBuffer();
                    parserCursor = new ParserCursor(formattedHeader.getValuePos(), charArrayBuffer.length());
                } else {
                    String value = header.getValue();
                    if (value != null) {
                        charArrayBuffer = new CharArrayBuffer(value.length());
                        charArrayBuffer.append(value);
                        parserCursor = new ParserCursor(0, charArrayBuffer.length());
                    } else {
                        throw new MalformedCookieException("Header value is null");
                    }
                }
                elements = new HeaderElement[]{netscapeDraftHeaderParser.parseHeader(charArrayBuffer, parserCursor)};
            }
            return parse(elements, cookieOrigin);
        } else {
            throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
        }
    }

    public List<Header> formatCookies(List<Cookie> list) {
        if (list == null) {
            throw new IllegalArgumentException("List of cookies may not be null");
        } else if (!list.isEmpty()) {
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(list.size() * 20);
            charArrayBuffer.append("Cookie");
            charArrayBuffer.append(": ");
            for (int i = 0; i < list.size(); i++) {
                Cookie cookie = list.get(i);
                if (i > 0) {
                    charArrayBuffer.append("; ");
                }
                charArrayBuffer.append(cookie.getName());
                charArrayBuffer.append("=");
                String value = cookie.getValue();
                if (value != null) {
                    charArrayBuffer.append(value);
                }
            }
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(new BufferedHeader(charArrayBuffer));
            return arrayList;
        } else {
            throw new IllegalArgumentException("List of cookies may not be empty");
        }
    }
}
