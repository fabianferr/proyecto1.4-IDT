package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import okio.Buffer;
import okio.ByteString;
import okio.DeflaterSink;
import okio.Sink;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0006J\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lokhttp3/internal/ws/MessageDeflater;", "Ljava/io/Closeable;", "noContextTakeover", "", "(Z)V", "deflatedBytes", "Lokio/Buffer;", "deflater", "Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "close", "", "deflate", "buffer", "endsWith", "suffix", "Lokio/ByteString;", "okhttp"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageDeflater.kt */
public final class MessageDeflater implements Closeable {
    private final Buffer deflatedBytes;
    private final Deflater deflater;
    private final DeflaterSink deflaterSink;
    private final boolean noContextTakeover;

    public MessageDeflater(boolean z) {
        this.noContextTakeover = z;
        Buffer buffer = new Buffer();
        this.deflatedBytes = buffer;
        Deflater deflater2 = new Deflater(-1, true);
        this.deflater = deflater2;
        this.deflaterSink = new DeflaterSink((Sink) buffer, deflater2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0059, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005d, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void deflate(okio.Buffer r8) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "buffer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            okio.Buffer r0 = r7.deflatedBytes
            long r0 = r0.size()
            r2 = 0
            r4 = 1
            r5 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            if (r0 == 0) goto L_0x006d
            boolean r0 = r7.noContextTakeover
            if (r0 == 0) goto L_0x0021
            java.util.zip.Deflater r0 = r7.deflater
            r0.reset()
        L_0x0021:
            okio.DeflaterSink r0 = r7.deflaterSink
            long r1 = r8.size()
            r0.write(r8, r1)
            okio.DeflaterSink r0 = r7.deflaterSink
            r0.flush()
            okio.Buffer r0 = r7.deflatedBytes
            okio.ByteString r1 = okhttp3.internal.ws.MessageDeflaterKt.EMPTY_DEFLATE_BLOCK
            boolean r0 = r7.endsWith(r0, r1)
            if (r0 == 0) goto L_0x005e
            okio.Buffer r0 = r7.deflatedBytes
            long r0 = r0.size()
            r2 = 4
            long r2 = (long) r2
            long r0 = r0 - r2
            okio.Buffer r2 = r7.deflatedBytes
            r3 = 0
            okio.Buffer$UnsafeCursor r2 = okio.Buffer.readAndWriteUnsafe$default(r2, r3, r4, r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r4 = r2
            okio.Buffer$UnsafeCursor r4 = (okio.Buffer.UnsafeCursor) r4     // Catch:{ all -> 0x0057 }
            r4.resizeBuffer(r0)     // Catch:{ all -> 0x0057 }
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            goto L_0x0063
        L_0x0057:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r8)
            throw r0
        L_0x005e:
            okio.Buffer r0 = r7.deflatedBytes
            r0.writeByte((int) r5)
        L_0x0063:
            okio.Buffer r0 = r7.deflatedBytes
            long r1 = r0.size()
            r8.write((okio.Buffer) r0, (long) r1)
            return
        L_0x006d:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Failed requirement."
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.MessageDeflater.deflate(okio.Buffer):void");
    }

    public void close() throws IOException {
        this.deflaterSink.close();
    }

    private final boolean endsWith(Buffer buffer, ByteString byteString) {
        return buffer.rangeEquals(buffer.size() - ((long) byteString.size()), byteString);
    }
}
