package com.cellrebel.sdk.networking.beans.response;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class ProgressResponseBody extends ResponseBody {
    private BufferedSource bufferedSource;
    public long firstByteTime = 0;
    /* access modifiers changed from: private */
    public final ProgressListener progressListener;
    /* access modifiers changed from: private */
    public final ResponseBody responseBody;

    interface ProgressListener {
        void update(long j, long j2, boolean z);
    }

    public ProgressResponseBody(ResponseBody responseBody2, ProgressListener progressListener2) {
        this.responseBody = responseBody2;
        this.progressListener = progressListener2;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) {
            long totalBytesRead = 0;

            public long read(Buffer buffer, long j) {
                long read = super.read(buffer, j);
                int i = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                this.totalBytesRead += i != 0 ? read : 0;
                ProgressResponseBody progressResponseBody = ProgressResponseBody.this;
                if (progressResponseBody.firstByteTime == 0) {
                    progressResponseBody.firstByteTime = System.currentTimeMillis();
                }
                if (ProgressResponseBody.this.progressListener != null) {
                    ProgressResponseBody.this.progressListener.update(this.totalBytesRead, ProgressResponseBody.this.responseBody.contentLength(), i == 0);
                }
                return read;
            }
        };
    }

    public long contentLength() {
        return this.responseBody.contentLength();
    }

    public MediaType contentType() {
        return this.responseBody.contentType();
    }

    public ResponseBody responseBody() {
        return this.responseBody;
    }

    public BufferedSource source() {
        if (this.bufferedSource == null) {
            this.bufferedSource = Okio.buffer(source(this.responseBody.source()));
        }
        return this.bufferedSource;
    }
}
