package com.vungle.ads.internal.network;

import com.vungle.ads.internal.network.converters.Converter;
import java.io.IOException;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u0018*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0003\u0018\u0019\u001aB%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0010\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\nH\u0016J\u0016\u0010\u0015\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/vungle/ads/internal/network/OkHttpCall;", "T", "Lcom/vungle/ads/internal/network/Call;", "rawCall", "Lokhttp3/Call;", "responseConverter", "Lcom/vungle/ads/internal/network/converters/Converter;", "Lokhttp3/ResponseBody;", "(Lokhttp3/Call;Lcom/vungle/ads/internal/network/converters/Converter;)V", "canceled", "", "buffer", "body", "cancel", "", "enqueue", "callback", "Lcom/vungle/ads/internal/network/Callback;", "execute", "Lcom/vungle/ads/internal/network/Response;", "isCanceled", "parseResponse", "rawResp", "Lokhttp3/Response;", "Companion", "ExceptionCatchingResponseBody", "NoContentResponseBody", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OkHttpCall.kt */
public final class OkHttpCall<T> implements Call<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private volatile boolean canceled;
    private final Call rawCall;
    private final Converter<ResponseBody, T> responseConverter;

    public OkHttpCall(Call call, Converter<ResponseBody, T> converter) {
        Intrinsics.checkNotNullParameter(call, "rawCall");
        Intrinsics.checkNotNullParameter(converter, "responseConverter");
        this.rawCall = call;
        this.responseConverter = converter;
    }

    public void enqueue(Callback<T> callback) {
        Call call;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            call = this.rawCall;
            Unit unit = Unit.INSTANCE;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new OkHttpCall$enqueue$2(this, callback));
    }

    public Response<T> execute() throws IOException {
        Call call;
        synchronized (this) {
            call = this.rawCall;
            Unit unit = Unit.INSTANCE;
        }
        if (this.canceled) {
            call.cancel();
        }
        return parseResponse(call.execute());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0074, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0077, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.vungle.ads.internal.network.Response<T> parseResponse(okhttp3.Response r7) throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "rawResp"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            okhttp3.ResponseBody r0 = r7.body()
            r1 = 0
            if (r0 != 0) goto L_0x000d
            return r1
        L_0x000d:
            okhttp3.Response$Builder r7 = r7.newBuilder()
            com.vungle.ads.internal.network.OkHttpCall$NoContentResponseBody r2 = new com.vungle.ads.internal.network.OkHttpCall$NoContentResponseBody
            okhttp3.MediaType r3 = r0.contentType()
            long r4 = r0.contentLength()
            r2.<init>(r3, r4)
            okhttp3.ResponseBody r2 = (okhttp3.ResponseBody) r2
            okhttp3.Response$Builder r7 = r7.body(r2)
            okhttp3.Response r7 = r7.build()
            int r2 = r7.code()
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 < r3) goto L_0x005e
            r3 = 300(0x12c, float:4.2E-43)
            if (r2 < r3) goto L_0x0035
            goto L_0x005e
        L_0x0035:
            r3 = 204(0xcc, float:2.86E-43)
            if (r2 == r3) goto L_0x0054
            r3 = 205(0xcd, float:2.87E-43)
            if (r2 == r3) goto L_0x0054
            com.vungle.ads.internal.network.OkHttpCall$ExceptionCatchingResponseBody r1 = new com.vungle.ads.internal.network.OkHttpCall$ExceptionCatchingResponseBody
            r1.<init>(r0)
            com.vungle.ads.internal.network.converters.Converter<okhttp3.ResponseBody, T> r0 = r6.responseConverter     // Catch:{ RuntimeException -> 0x004f }
            java.lang.Object r0 = r0.convert(r1)     // Catch:{ RuntimeException -> 0x004f }
            com.vungle.ads.internal.network.Response$Companion r2 = com.vungle.ads.internal.network.Response.Companion     // Catch:{ RuntimeException -> 0x004f }
            com.vungle.ads.internal.network.Response r7 = r2.success(r0, r7)     // Catch:{ RuntimeException -> 0x004f }
            return r7
        L_0x004f:
            r7 = move-exception
            r1.throwIfCaught()
            throw r7
        L_0x0054:
            r0.close()
            com.vungle.ads.internal.network.Response$Companion r0 = com.vungle.ads.internal.network.Response.Companion
            com.vungle.ads.internal.network.Response r7 = r0.success(r1, r7)
            return r7
        L_0x005e:
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = r0
            okhttp3.ResponseBody r2 = (okhttp3.ResponseBody) r2     // Catch:{ all -> 0x0071 }
            okhttp3.ResponseBody r2 = r6.buffer(r2)     // Catch:{ all -> 0x0071 }
            com.vungle.ads.internal.network.Response$Companion r3 = com.vungle.ads.internal.network.Response.Companion     // Catch:{ all -> 0x0071 }
            com.vungle.ads.internal.network.Response r7 = r3.error(r2, r7)     // Catch:{ all -> 0x0071 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r7
        L_0x0071:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0073 }
        L_0x0073:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.OkHttpCall.parseResponse(okhttp3.Response):com.vungle.ads.internal.network.Response");
    }

    private final ResponseBody buffer(ResponseBody responseBody) throws IOException {
        Buffer buffer = new Buffer();
        responseBody.source().readAll(buffer);
        return ResponseBody.Companion.create((BufferedSource) buffer, responseBody.contentType(), responseBody.contentLength());
    }

    public void cancel() {
        Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
            Unit unit = Unit.INSTANCE;
        }
        call.cancel();
    }

    public boolean isCanceled() {
        boolean isCanceled;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            isCanceled = this.rawCall.isCanceled();
        }
        return isCanceled;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/vungle/ads/internal/network/OkHttpCall$NoContentResponseBody;", "Lokhttp3/ResponseBody;", "contentType", "Lokhttp3/MediaType;", "contentLength", "", "(Lokhttp3/MediaType;J)V", "source", "Lokio/BufferedSource;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OkHttpCall.kt */
    public static final class NoContentResponseBody extends ResponseBody {
        private final long contentLength;
        private final MediaType contentType;

        public NoContentResponseBody(MediaType mediaType, long j) {
            this.contentType = mediaType;
            this.contentLength = j;
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0006\u0010\u0013\u001a\u00020\rR\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/vungle/ads/internal/network/OkHttpCall$ExceptionCatchingResponseBody;", "Lokhttp3/ResponseBody;", "delegate", "(Lokhttp3/ResponseBody;)V", "delegateSource", "Lokio/BufferedSource;", "thrownException", "Ljava/io/IOException;", "getThrownException", "()Ljava/io/IOException;", "setThrownException", "(Ljava/io/IOException;)V", "close", "", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "source", "throwIfCaught", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OkHttpCall.kt */
    public static final class ExceptionCatchingResponseBody extends ResponseBody {
        private final ResponseBody delegate;
        private final BufferedSource delegateSource;
        private IOException thrownException;

        public ExceptionCatchingResponseBody(ResponseBody responseBody) {
            Intrinsics.checkNotNullParameter(responseBody, "delegate");
            this.delegate = responseBody;
            this.delegateSource = Okio.buffer((Source) new ForwardingSource(this, responseBody.source()) {
                final /* synthetic */ ExceptionCatchingResponseBody this$0;

                {
                    this.this$0 = r1;
                }

                public long read(Buffer buffer, long j) throws IOException {
                    Intrinsics.checkNotNullParameter(buffer, "sink");
                    try {
                        return super.read(buffer, j);
                    } catch (IOException e) {
                        this.this$0.setThrownException(e);
                        throw e;
                    }
                }
            });
        }

        public final IOException getThrownException() {
            return this.thrownException;
        }

        public final void setThrownException(IOException iOException) {
            this.thrownException = iOException;
        }

        public MediaType contentType() {
            return this.delegate.contentType();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public BufferedSource source() {
            return this.delegateSource;
        }

        public void close() {
            this.delegate.close();
        }

        public final void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, d2 = {"Lcom/vungle/ads/internal/network/OkHttpCall$Companion;", "", "()V", "throwIfFatal", "", "t", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OkHttpCall.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final void throwIfFatal(Throwable th) {
            if (th instanceof VirtualMachineError) {
                throw th;
            } else if (th instanceof ThreadDeath) {
                throw th;
            } else if (th instanceof LinkageError) {
                throw th;
            }
        }
    }
}
