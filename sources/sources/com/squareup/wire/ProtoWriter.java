package com.squareup.wire;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.BufferedSink;
import okio.ByteString;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000eJ\u000e\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/squareup/wire/ProtoWriter;", "", "sink", "Lokio/BufferedSink;", "(Lokio/BufferedSink;)V", "writeBytes", "", "value", "Lokio/ByteString;", "writeFixed32", "", "writeFixed64", "", "writeSignedVarint32", "writeSignedVarint32$wire_runtime", "writeString", "", "writeTag", "fieldNumber", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "writeVarint32", "writeVarint64", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoWriter.kt */
public final class ProtoWriter {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final BufferedSink sink;

    public ProtoWriter(BufferedSink bufferedSink) {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        this.sink = bufferedSink;
    }

    public final void writeBytes(ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(byteString, "value");
        this.sink.write(byteString);
    }

    public final void writeString(String str) throws IOException {
        Intrinsics.checkNotNullParameter(str, "value");
        this.sink.writeUtf8(str);
    }

    public final void writeTag(int i, FieldEncoding fieldEncoding) throws IOException {
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        writeVarint32(Companion.makeTag$wire_runtime(i, fieldEncoding));
    }

    public final void writeSignedVarint32$wire_runtime(int i) throws IOException {
        if (i >= 0) {
            writeVarint32(i);
        } else {
            writeVarint64((long) i);
        }
    }

    public final void writeVarint32(int i) throws IOException {
        while ((i & -128) != 0) {
            this.sink.writeByte((i & 127) | 128);
            i >>>= 7;
        }
        this.sink.writeByte(i);
    }

    public final void writeVarint64(long j) throws IOException {
        while ((-128 & j) != 0) {
            this.sink.writeByte((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.sink.writeByte((int) j);
    }

    public final void writeFixed32(int i) throws IOException {
        this.sink.writeIntLe(i);
    }

    public final void writeFixed64(long j) throws IOException {
        this.sink.writeLongLe(j);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u0015\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0000¢\u0006\u0002\b\rJ\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0010J\u001d\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u0015J\u0015\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0018J\u0015\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0000¢\u0006\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/squareup/wire/ProtoWriter$Companion;", "", "()V", "decodeZigZag32", "", "n", "decodeZigZag32$wire_runtime", "decodeZigZag64", "", "decodeZigZag64$wire_runtime", "encodeZigZag32", "encodeZigZag32$wire_runtime", "encodeZigZag64", "encodeZigZag64$wire_runtime", "int32Size", "value", "int32Size$wire_runtime", "makeTag", "fieldNumber", "fieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "makeTag$wire_runtime", "tagSize", "tag", "tagSize$wire_runtime", "varint32Size", "varint32Size$wire_runtime", "varint64Size", "varint64Size$wire_runtime", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProtoWriter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int decodeZigZag32$wire_runtime(int i) {
            return (-(i & 1)) ^ (i >>> 1);
        }

        public final long decodeZigZag64$wire_runtime(long j) {
            return (-(j & 1)) ^ (j >>> 1);
        }

        public final int encodeZigZag32$wire_runtime(int i) {
            return (i >> 31) ^ (i << 1);
        }

        public final long encodeZigZag64$wire_runtime(long j) {
            return (j >> 63) ^ (j << 1);
        }

        public final int varint32Size$wire_runtime(int i) {
            if ((i & -128) == 0) {
                return 1;
            }
            if ((i & -16384) == 0) {
                return 2;
            }
            if ((-2097152 & i) == 0) {
                return 3;
            }
            return (i & -268435456) == 0 ? 4 : 5;
        }

        public final int varint64Size$wire_runtime(long j) {
            if ((-128 & j) == 0) {
                return 1;
            }
            if ((-16384 & j) == 0) {
                return 2;
            }
            if ((-2097152 & j) == 0) {
                return 3;
            }
            if ((-268435456 & j) == 0) {
                return 4;
            }
            if ((-34359738368L & j) == 0) {
                return 5;
            }
            if ((-4398046511104L & j) == 0) {
                return 6;
            }
            if ((-562949953421312L & j) == 0) {
                return 7;
            }
            if ((-72057594037927936L & j) == 0) {
                return 8;
            }
            return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
        }

        private Companion() {
        }

        public final int makeTag$wire_runtime(int i, FieldEncoding fieldEncoding) {
            Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
            return (i << 3) | fieldEncoding.getValue$wire_runtime();
        }

        public final int tagSize$wire_runtime(int i) {
            return varint32Size$wire_runtime(makeTag$wire_runtime(i, FieldEncoding.VARINT));
        }

        public final int int32Size$wire_runtime(int i) {
            if (i >= 0) {
                return varint32Size$wire_runtime(i);
            }
            return 10;
        }
    }
}
