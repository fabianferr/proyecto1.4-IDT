package org.apache.http.impl.client.cache;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import org.apache.http.client.cache.Resource;
import org.apache.http.entity.AbstractHttpEntity;

class CombinedEntity extends AbstractHttpEntity {
    private final InputStream combinedStream;
    private final Resource resource;

    public long getContentLength() {
        return -1;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return true;
    }

    CombinedEntity(Resource resource2, InputStream inputStream) throws IOException {
        this.resource = resource2;
        this.combinedStream = new SequenceInputStream(new ResourceStream(resource2.getInputStream()), inputStream);
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        return this.combinedStream;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            InputStream content = getContent();
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = content.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                }
            } finally {
                content.close();
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    /* access modifiers changed from: private */
    public void dispose() {
        this.resource.dispose();
    }

    class ResourceStream extends FilterInputStream {
        protected ResourceStream(InputStream inputStream) {
            super(inputStream);
        }

        public void close() throws IOException {
            try {
                super.close();
            } finally {
                CombinedEntity.this.dispose();
            }
        }
    }
}
