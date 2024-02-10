package com.squareup.wire;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0012"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonStructNull$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodeWithTag", "tag", "", "encodedSize", "encodedSizeWithTag", "redact", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonStructNull$1 extends ProtoAdapter {
    public Void redact(Void voidR) {
        return null;
    }

    ProtoAdapterKt$commonStructNull$1(FieldEncoding fieldEncoding, KClass kClass, Syntax syntax) {
        super(fieldEncoding, (KClass<?>) kClass, "type.googleapis.com/google.protobuf.NullValue", syntax);
    }

    public int encodedSize(Void voidR) {
        return ProtoWriter.Companion.varint32Size$wire_runtime(0);
    }

    public int encodedSizeWithTag(int i, Void voidR) {
        return ProtoWriter.Companion.tagSize$wire_runtime(i) + ProtoWriter.Companion.varint32Size$wire_runtime(encodedSize(voidR));
    }

    public void encode(ProtoWriter protoWriter, Void voidR) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        protoWriter.writeVarint32(0);
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, Void voidR) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        reverseProtoWriter.writeVarint32(0);
    }

    public void encodeWithTag(ProtoWriter protoWriter, int i, Void voidR) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        protoWriter.writeTag(i, getFieldEncoding$wire_runtime());
        encode(protoWriter, voidR);
    }

    public void encodeWithTag(ReverseProtoWriter reverseProtoWriter, int i, Void voidR) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        encode(reverseProtoWriter, voidR);
        reverseProtoWriter.writeTag(i, getFieldEncoding$wire_runtime());
    }

    public Void decode(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        int readVarint32 = protoReader.readVarint32();
        if (readVarint32 == 0) {
            return null;
        }
        throw new IOException(Intrinsics.stringPlus("expected 0 but was ", Integer.valueOf(readVarint32)));
    }
}
