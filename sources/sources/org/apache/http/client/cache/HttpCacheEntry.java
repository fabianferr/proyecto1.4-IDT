package org.apache.http.client.cache;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.message.HeaderGroup;

public class HttpCacheEntry implements Serializable {
    private static final long serialVersionUID = -6300496422359477413L;
    private final Date requestDate;
    private final Resource resource;
    private final Date responseDate;
    private final HeaderGroup responseHeaders;
    private final StatusLine statusLine;
    private final Map<String, String> variantMap;

    public HttpCacheEntry(Date date, Date date2, StatusLine statusLine2, Header[] headerArr, Resource resource2, Map<String, String> map) {
        if (date == null) {
            throw new IllegalArgumentException("Request date may not be null");
        } else if (date2 == null) {
            throw new IllegalArgumentException("Response date may not be null");
        } else if (statusLine2 == null) {
            throw new IllegalArgumentException("Status line may not be null");
        } else if (headerArr == null) {
            throw new IllegalArgumentException("Response headers may not be null");
        } else if (resource2 != null) {
            this.requestDate = date;
            this.responseDate = date2;
            this.statusLine = statusLine2;
            HeaderGroup headerGroup = new HeaderGroup();
            this.responseHeaders = headerGroup;
            headerGroup.setHeaders(headerArr);
            this.resource = resource2;
            this.variantMap = map != null ? new HashMap(map) : null;
        } else {
            throw new IllegalArgumentException("Resource may not be null");
        }
    }

    public HttpCacheEntry(Date date, Date date2, StatusLine statusLine2, Header[] headerArr, Resource resource2) {
        this(date, date2, statusLine2, headerArr, resource2, new HashMap());
    }

    public StatusLine getStatusLine() {
        return this.statusLine;
    }

    public ProtocolVersion getProtocolVersion() {
        return this.statusLine.getProtocolVersion();
    }

    public String getReasonPhrase() {
        return this.statusLine.getReasonPhrase();
    }

    public int getStatusCode() {
        return this.statusLine.getStatusCode();
    }

    public Date getRequestDate() {
        return this.requestDate;
    }

    public Date getResponseDate() {
        return this.responseDate;
    }

    public Header[] getAllHeaders() {
        return this.responseHeaders.getAllHeaders();
    }

    public Header getFirstHeader(String str) {
        return this.responseHeaders.getFirstHeader(str);
    }

    public Header[] getHeaders(String str) {
        return this.responseHeaders.getHeaders(str);
    }

    public Resource getResource() {
        return this.resource;
    }

    public boolean hasVariants() {
        return getFirstHeader("Vary") != null;
    }

    public Map<String, String> getVariantMap() {
        return Collections.unmodifiableMap(this.variantMap);
    }

    public String toString() {
        return "[request date=" + this.requestDate + "; response date=" + this.responseDate + "; statusLine=" + this.statusLine + "]";
    }
}
