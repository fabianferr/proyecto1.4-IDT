package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EntityTemplate extends AbstractHttpEntity {
    private final ContentProducer contentproducer;

    public long getContentLength() {
        return -1;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public EntityTemplate(ContentProducer contentProducer) {
        if (contentProducer != null) {
            this.contentproducer = contentProducer;
            return;
        }
        throw new IllegalArgumentException("Content producer may not be null");
    }

    public InputStream getContent() {
        throw new UnsupportedOperationException("Entity template does not implement getContent()");
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            this.contentproducer.writeTo(outputStream);
            return;
        }
        throw new IllegalArgumentException("Output stream may not be null");
    }
}
