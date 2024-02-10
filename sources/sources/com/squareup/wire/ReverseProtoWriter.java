package com.squareup.wire;

import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CharCompanionObject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Utf8;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001fJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\"J0\u0010#\u001a\u00020\u001a2!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u001a0%H\u0000¢\u0006\u0002\b(J\u0015\u0010)\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0006H\u0000¢\u0006\u0002\b*J\u000e\u0010+\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020,J\u0016\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020\u001a2\u0006\u00102\u001a\u000203J\u000e\u00104\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0006J\u000e\u00105\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\"R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/squareup/wire/ReverseProtoWriter;", "", "()V", "array", "", "arrayLimit", "", "byteCount", "getByteCount", "()I", "cursor", "Lokio/Buffer$UnsafeCursor;", "forwardBuffer", "Lokio/Buffer;", "getForwardBuffer", "()Lokio/Buffer;", "forwardBuffer$delegate", "Lkotlin/Lazy;", "forwardWriter", "Lcom/squareup/wire/ProtoWriter;", "getForwardWriter", "()Lcom/squareup/wire/ProtoWriter;", "forwardWriter$delegate", "head", "tail", "emitCurrentSegment", "", "require", "minByteCount", "writeBytes", "value", "Lokio/ByteString;", "writeFixed32", "writeFixed64", "", "writeForward", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "writeForward$wire_runtime", "writeSignedVarint32", "writeSignedVarint32$wire_runtime", "writeString", "", "writeTag", "fieldNumber", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "writeTo", "sink", "Lokio/BufferedSink;", "writeVarint32", "writeVarint64", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReverseProtoWriter.kt */
public final class ReverseProtoWriter {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final byte[] EMPTY_ARRAY = new byte[0];
    private byte[] array = EMPTY_ARRAY;
    private int arrayLimit;
    private final Buffer.UnsafeCursor cursor = new Buffer.UnsafeCursor();
    private final Lazy forwardBuffer$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, ReverseProtoWriter$forwardBuffer$2.INSTANCE);
    private final Lazy forwardWriter$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new ReverseProtoWriter$forwardWriter$2(this));
    private Buffer head = new Buffer();
    private Buffer tail = new Buffer();

    /* access modifiers changed from: private */
    public final Buffer getForwardBuffer() {
        return (Buffer) this.forwardBuffer$delegate.getValue();
    }

    private final ProtoWriter getForwardWriter() {
        return (ProtoWriter) this.forwardWriter$delegate.getValue();
    }

    public final int getByteCount() {
        return ((int) this.tail.size()) + (this.array.length - this.arrayLimit);
    }

    public final void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        emitCurrentSegment();
        bufferedSink.writeAll(this.tail);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void require(int r5) {
        /*
            r4 = this;
            int r0 = r4.arrayLimit
            if (r0 < r5) goto L_0x0005
            return
        L_0x0005:
            r4.emitCurrentSegment()
            okio.Buffer r0 = r4.head
            okio.Buffer$UnsafeCursor r1 = r4.cursor
            r0.readAndWriteUnsafe(r1)
            okio.Buffer$UnsafeCursor r0 = r4.cursor
            r0.expandBuffer(r5)
            okio.Buffer$UnsafeCursor r5 = r4.cursor
            long r0 = r5.offset
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L_0x002e
            okio.Buffer$UnsafeCursor r5 = r4.cursor
            int r5 = r5.end
            okio.Buffer$UnsafeCursor r0 = r4.cursor
            byte[] r0 = r0.data
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.length
            if (r5 != r0) goto L_0x002e
            r5 = 1
            goto L_0x002f
        L_0x002e:
            r5 = 0
        L_0x002f:
            if (r5 == 0) goto L_0x0041
            okio.Buffer$UnsafeCursor r5 = r4.cursor
            byte[] r5 = r5.data
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            r4.array = r5
            okio.Buffer$UnsafeCursor r5 = r4.cursor
            int r5 = r5.end
            r4.arrayLimit = r5
            return
        L_0x0041:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "Check failed."
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.wire.ReverseProtoWriter.require(int):void");
    }

    private final void emitCurrentSegment() {
        byte[] bArr = this.array;
        byte[] bArr2 = EMPTY_ARRAY;
        if (bArr != bArr2) {
            this.cursor.close();
            this.head.skip((long) this.arrayLimit);
            this.head.writeAll(this.tail);
            Buffer buffer = this.tail;
            this.tail = this.head;
            this.head = buffer;
            this.array = bArr2;
            this.arrayLimit = 0;
        }
    }

    public final void writeForward$wire_runtime(Function1<? super ProtoWriter, Unit> function1) throws IOException {
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(getForwardWriter());
        writeBytes(getForwardBuffer().readByteString());
    }

    public final void writeBytes(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "value");
        int size = byteString.size();
        while (size != 0) {
            require(1);
            int min = Math.min(this.arrayLimit, size);
            int i = this.arrayLimit - min;
            this.arrayLimit = i;
            size -= min;
            byteString.copyInto(size, this.array, i, min);
        }
    }

    public final void writeString(String str) {
        char c;
        Intrinsics.checkNotNullParameter(str, "value");
        int length = str.length() - 1;
        while (length >= 0) {
            int i = length - 1;
            char charAt = str.charAt(length);
            if (charAt < 128) {
                require(1);
                int i2 = this.arrayLimit;
                byte[] bArr = this.array;
                int i3 = i2 - 1;
                bArr[i3] = (byte) charAt;
                int max = Math.max(-1, i - i3);
                while (i > max) {
                    char charAt2 = str.charAt(i);
                    if (charAt2 >= 128) {
                        break;
                    }
                    i--;
                    i3--;
                    bArr[i3] = (byte) charAt2;
                }
                this.arrayLimit = i3;
            } else if (charAt < 2048) {
                require(2);
                byte[] bArr2 = this.array;
                int i4 = this.arrayLimit - 1;
                bArr2[i4] = (byte) (128 | (charAt & '?'));
                int i5 = i4 - 1;
                this.arrayLimit = i5;
                bArr2[i5] = (byte) ((charAt >> 6) | 192);
            } else if (charAt < 55296 || charAt > 57343) {
                require(3);
                byte[] bArr3 = this.array;
                int i6 = this.arrayLimit - 1;
                bArr3[i6] = (byte) ((charAt & '?') | 128);
                int i7 = i6 - 1;
                bArr3[i7] = (byte) (128 | (63 & (charAt >> 6)));
                int i8 = i7 - 1;
                this.arrayLimit = i8;
                bArr3[i8] = (byte) ((charAt >> 12) | 224);
            } else {
                if (i >= 0) {
                    c = str.charAt(i);
                } else {
                    c = CharCompanionObject.MAX_VALUE;
                }
                if (c <= 56319) {
                    boolean z = false;
                    if (56320 <= charAt && charAt < 57344) {
                        z = true;
                    }
                    if (z) {
                        i--;
                        int i9 = ((charAt & 1023) | ((c & 1023) << 10)) + 0;
                        require(4);
                        byte[] bArr4 = this.array;
                        int i10 = this.arrayLimit - 1;
                        bArr4[i10] = (byte) ((i9 & 63) | 128);
                        int i11 = i10 - 1;
                        bArr4[i11] = (byte) (((i9 >> 6) & 63) | 128);
                        int i12 = i11 - 1;
                        bArr4[i12] = (byte) (128 | (63 & (i9 >> 12)));
                        int i13 = i12 - 1;
                        this.arrayLimit = i13;
                        bArr4[i13] = (byte) ((i9 >> 18) | 240);
                    }
                }
                require(1);
                byte[] bArr5 = this.array;
                int i14 = this.arrayLimit - 1;
                this.arrayLimit = i14;
                bArr5[i14] = Utf8.REPLACEMENT_BYTE;
            }
            length = i;
        }
    }

    public final void writeTag(int i, FieldEncoding fieldEncoding) {
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        writeVarint32(ProtoWriter.Companion.makeTag$wire_runtime(i, fieldEncoding));
    }

    public final void writeSignedVarint32$wire_runtime(int i) {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64((long) i);
        }
    }

    public final void writeVarint32(int i) {
        int varint32Size$wire_runtime = ProtoWriter.Companion.varint32Size$wire_runtime(i);
        require(varint32Size$wire_runtime);
        int i2 = this.arrayLimit - varint32Size$wire_runtime;
        this.arrayLimit = i2;
        while ((i & -128) != 0) {
            this.array[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
            i2++;
        }
        this.array[i2] = (byte) i;
    }

    public final void writeVarint64(long j) {
        int varint64Size$wire_runtime = ProtoWriter.Companion.varint64Size$wire_runtime(j);
        require(varint64Size$wire_runtime);
        int i = this.arrayLimit - varint64Size$wire_runtime;
        this.arrayLimit = i;
        while ((-128 & j) != 0) {
            this.array[i] = (byte) ((int) ((127 & j) | 128));
            j >>>= 7;
            i++;
        }
        this.array[i] = (byte) ((int) j);
    }

    public final void writeFixed32(int i) {
        require(4);
        int i2 = this.arrayLimit - 4;
        this.arrayLimit = i2;
        byte[] bArr = this.array;
        int i3 = i2 + 1;
        bArr[i2] = (byte) (i & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 8) & 255);
        bArr[i4] = (byte) ((i >>> 16) & 255);
        bArr[i4 + 1] = (byte) ((i >>> 24) & 255);
    }

    public final void writeFixed64(long j) {
        require(8);
        int i = this.arrayLimit - 8;
        this.arrayLimit = i;
        byte[] bArr = this.array;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) (j & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 8) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 16) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 24) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 32) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 40) & 255));
        bArr[i7] = (byte) ((int) ((j >>> 48) & 255));
        bArr[i7 + 1] = (byte) ((int) ((j >>> 56) & 255));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/squareup/wire/ReverseProtoWriter$Companion;", "", "()V", "EMPTY_ARRAY", "", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ReverseProtoWriter.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
