package org.apache.http.impl.client.cache;

import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.message.BasicStatusLine;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

final class OptionsHttp11Response extends AbstractHttpMessage implements HttpResponse {
    private final StatusLine statusLine = new BasicStatusLine(HttpVersion.HTTP_1_1, 501, "");
    private final ProtocolVersion version = HttpVersion.HTTP_1_1;

    public void addHeader(String str, String str2) {
    }

    public void addHeader(Header header) {
    }

    public HttpEntity getEntity() {
        return null;
    }

    public Locale getLocale() {
        return null;
    }

    public void removeHeader(Header header) {
    }

    public void removeHeaders(String str) {
    }

    public void setEntity(HttpEntity httpEntity) {
    }

    public void setHeader(String str, String str2) {
    }

    public void setHeader(Header header) {
    }

    public void setHeaders(Header[] headerArr) {
    }

    public void setLocale(Locale locale) {
    }

    public void setParams(HttpParams httpParams) {
    }

    public void setReasonPhrase(String str) throws IllegalStateException {
    }

    public void setStatusCode(int i) throws IllegalStateException {
    }

    public void setStatusLine(ProtocolVersion protocolVersion, int i) {
    }

    public void setStatusLine(ProtocolVersion protocolVersion, int i, String str) {
    }

    public void setStatusLine(StatusLine statusLine2) {
    }

    OptionsHttp11Response() {
    }

    public StatusLine getStatusLine() {
        return this.statusLine;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.version;
    }

    public boolean containsHeader(String str) {
        return this.headergroup.containsHeader(str);
    }

    public Header[] getHeaders(String str) {
        return this.headergroup.getHeaders(str);
    }

    public Header getFirstHeader(String str) {
        return this.headergroup.getFirstHeader(str);
    }

    public Header getLastHeader(String str) {
        return this.headergroup.getLastHeader(str);
    }

    public Header[] getAllHeaders() {
        return this.headergroup.getAllHeaders();
    }

    public HeaderIterator headerIterator() {
        return this.headergroup.iterator();
    }

    public HeaderIterator headerIterator(String str) {
        return this.headergroup.iterator(str);
    }

    public HttpParams getParams() {
        if (this.params == null) {
            this.params = new BasicHttpParams();
        }
        return this.params;
    }
}
