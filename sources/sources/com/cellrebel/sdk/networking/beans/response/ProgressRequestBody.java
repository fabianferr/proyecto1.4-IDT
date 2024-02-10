package com.cellrebel.sdk.networking.beans.response;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

public class ProgressRequestBody extends RequestBody {
    protected CountingSink countingSink;
    public long firstByteTime = 0;
    private RequestBody mRequestBody;

    protected final class CountingSink extends ForwardingSink {
        private long bytesWritten = 0;

        public CountingSink(Sink sink) {
            super(sink);
        }

        public void write(Buffer buffer, long j) {
            super.write(buffer, j);
            this.bytesWritten += j;
        }
    }

    public ProgressRequestBody(RequestBody requestBody) {
        this.mRequestBody = requestBody;
    }

    public long contentLength() {
        return this.mRequestBody.contentLength();
    }

    public MediaType contentType() {
        return this.mRequestBody.contentType();
    }

    public void writeTo(BufferedSink bufferedSink) {
        CountingSink countingSink2 = new CountingSink(bufferedSink);
        this.countingSink = countingSink2;
        BufferedSink buffer = Okio.buffer((Sink) countingSink2);
        this.mRequestBody.writeTo(buffer);
        if (this.firstByteTime == 0) {
            this.firstByteTime = System.currentTimeMillis();
        }
        buffer.flush();
    }
}
