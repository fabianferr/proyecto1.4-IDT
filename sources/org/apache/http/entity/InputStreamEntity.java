package org.apache.http.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InputStreamEntity extends AbstractHttpEntity {
    private static final int BUFFER_SIZE = 2048;
    private final InputStream content;
    private final long length;

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return true;
    }

    public InputStreamEntity(InputStream inputStream, long j) {
        if (inputStream != null) {
            this.content = inputStream;
            this.length = j;
            return;
        }
        throw new IllegalArgumentException("Source input stream may not be null");
    }

    public long getContentLength() {
        return this.length;
    }

    public InputStream getContent() throws IOException {
        return this.content;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        int read;
        if (outputStream != null) {
            InputStream inputStream = this.content;
            byte[] bArr = new byte[2048];
            long j = this.length;
            if (j < 0) {
                while (true) {
                    int read2 = inputStream.read(bArr);
                    if (read2 != -1) {
                        outputStream.write(bArr, 0, read2);
                    } else {
                        return;
                    }
                }
            } else {
                while (j > 0 && (read = inputStream.read(bArr, 0, (int) Math.min(2048, j))) != -1) {
                    outputStream.write(bArr, 0, read);
                    j -= (long) read;
                }
            }
        } else {
            throw new IllegalArgumentException("Output stream may not be null");
        }
    }

    public void consumeContent() throws IOException {
        this.content.close();
    }
}
