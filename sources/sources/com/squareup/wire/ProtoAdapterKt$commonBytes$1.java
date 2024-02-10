package com.squareup.wire;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonBytes$1", "Lcom/squareup/wire/ProtoAdapter;", "Lokio/ByteString;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "", "redact", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonBytes$1 extends ProtoAdapter<ByteString> {
    ProtoAdapterKt$commonBytes$1(FieldEncoding fieldEncoding, KClass<ByteString> kClass, Syntax syntax, ByteString byteString) {
        super(fieldEncoding, (KClass<?>) kClass, (String) null, syntax, byteString);
    }

    public int encodedSize(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "value");
        return byteString.size();
    }

    public void encode(ProtoWriter protoWriter, ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        Intrinsics.checkNotNullParameter(byteString, "value");
        protoWriter.writeBytes(byteString);
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, ByteString byteString) throws IOException {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Intrinsics.checkNotNullParameter(byteString, "value");
        reverseProtoWriter.writeBytes(byteString);
    }

    public ByteString decode(ProtoReader protoReader) throws IOException {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        return protoReader.readBytes();
    }

    public ByteString redact(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "value");
        throw new UnsupportedOperationException();
    }
}
