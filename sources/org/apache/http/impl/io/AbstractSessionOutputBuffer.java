package org.apache.http.impl.io;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.http.io.BufferInfo;
import org.apache.http.io.HttpTransportMetrics;
import org.apache.http.io.SessionOutputBuffer;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.ByteArrayBuffer;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractSessionOutputBuffer implements SessionOutputBuffer, BufferInfo {
    private static final byte[] CRLF = {Ascii.CR, 10};
    private boolean ascii = true;
    private ByteArrayBuffer buffer;
    private String charset = "US-ASCII";
    private HttpTransportMetricsImpl metrics;
    private int minChunkLimit = 512;
    private OutputStream outstream;

    /* access modifiers changed from: protected */
    public void init(OutputStream outputStream, int i, HttpParams httpParams) {
        if (outputStream == null) {
            throw new IllegalArgumentException("Input stream may not be null");
        } else if (i <= 0) {
            throw new IllegalArgumentException("Buffer size may not be negative or zero");
        } else if (httpParams != null) {
            this.outstream = outputStream;
            this.buffer = new ByteArrayBuffer(i);
            String httpElementCharset = HttpProtocolParams.getHttpElementCharset(httpParams);
            this.charset = httpElementCharset;
            this.ascii = httpElementCharset.equalsIgnoreCase("US-ASCII") || this.charset.equalsIgnoreCase(HTTP.ASCII);
            this.minChunkLimit = httpParams.getIntParameter(CoreConnectionPNames.MIN_CHUNK_LIMIT, 512);
            this.metrics = createTransportMetrics();
        } else {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }

    /* access modifiers changed from: protected */
    public HttpTransportMetricsImpl createTransportMetrics() {
        return new HttpTransportMetricsImpl();
    }

    public int capacity() {
        return this.buffer.capacity();
    }

    public int length() {
        return this.buffer.length();
    }

    public int available() {
        return capacity() - length();
    }

    /* access modifiers changed from: protected */
    public void flushBuffer() throws IOException {
        int length = this.buffer.length();
        if (length > 0) {
            this.outstream.write(this.buffer.buffer(), 0, length);
            this.buffer.clear();
            this.metrics.incrementBytesTransferred((long) length);
        }
    }

    public void flush() throws IOException {
        flushBuffer();
        this.outstream.flush();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (bArr != null) {
            if (i2 > this.minChunkLimit || i2 > this.buffer.capacity()) {
                flushBuffer();
                this.outstream.write(bArr, i, i2);
                this.metrics.incrementBytesTransferred((long) i2);
                return;
            }
            if (i2 > this.buffer.capacity() - this.buffer.length()) {
                flushBuffer();
            }
            this.buffer.append(bArr, i, i2);
        }
    }

    public void write(byte[] bArr) throws IOException {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
        }
    }

    public void write(int i) throws IOException {
        if (this.buffer.isFull()) {
            flushBuffer();
        }
        this.buffer.append(i);
    }

    public void writeLine(String str) throws IOException {
        if (str != null) {
            if (str.length() > 0) {
                write(str.getBytes(this.charset));
            }
            write(CRLF);
        }
    }

    public void writeLine(CharArrayBuffer charArrayBuffer) throws IOException {
        if (charArrayBuffer != null) {
            if (this.ascii) {
                int length = charArrayBuffer.length();
                int i = 0;
                while (length > 0) {
                    int min = Math.min(this.buffer.capacity() - this.buffer.length(), length);
                    if (min > 0) {
                        this.buffer.append(charArrayBuffer, i, min);
                    }
                    if (this.buffer.isFull()) {
                        flushBuffer();
                    }
                    i += min;
                    length -= min;
                }
            } else {
                write(charArrayBuffer.toString().getBytes(this.charset));
            }
            write(CRLF);
        }
    }

    public HttpTransportMetrics getMetrics() {
        return this.metrics;
    }
}
