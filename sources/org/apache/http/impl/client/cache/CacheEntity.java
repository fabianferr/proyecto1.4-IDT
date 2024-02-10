package org.apache.http.impl.client.cache;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.cache.HttpCacheEntry;

class CacheEntity implements HttpEntity, Serializable {
    private static final long serialVersionUID = -3467082284120936233L;
    private final HttpCacheEntry cacheEntry;

    public void consumeContent() throws IOException {
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public CacheEntity(HttpCacheEntry httpCacheEntry) {
        this.cacheEntry = httpCacheEntry;
    }

    public Header getContentType() {
        return this.cacheEntry.getFirstHeader("Content-Type");
    }

    public Header getContentEncoding() {
        return this.cacheEntry.getFirstHeader("Content-Encoding");
    }

    public long getContentLength() {
        return this.cacheEntry.getResource().length();
    }

    public InputStream getContent() throws IOException {
        return this.cacheEntry.getResource().getInputStream();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            InputStream inputStream = this.cacheEntry.getResource().getInputStream();
            try {
                IOUtils.copy(inputStream, outputStream);
            } finally {
                inputStream.close();
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
