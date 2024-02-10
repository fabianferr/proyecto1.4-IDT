package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BasicHttpEntity extends AbstractHttpEntity {
    private InputStream content;
    private long length = -1;

    public boolean isRepeatable() {
        return false;
    }

    public long getContentLength() {
        return this.length;
    }

    public InputStream getContent() throws IllegalStateException {
        InputStream inputStream = this.content;
        if (inputStream != null) {
            return inputStream;
        }
        throw new IllegalStateException("Content has not been provided");
    }

    public void setContentLength(long j) {
        this.length = j;
    }

    public void setContent(InputStream inputStream) {
        this.content = inputStream;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        if (outputStream != null) {
            InputStream content2 = getContent();
            try {
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = content2.read(bArr);
                    if (read != -1) {
                        outputStream.write(bArr, 0, read);
                    } else {
                        return;
                    }
                }
            } finally {
                content2.close();
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    public boolean isStreaming() {
        return this.content != null;
    }

    public void consumeContent() throws IOException {
        InputStream inputStream = this.content;
        if (inputStream != null) {
            inputStream.close();
        }
    }
}
