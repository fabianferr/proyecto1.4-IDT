package com.squareup.wire;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonFloat$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Float;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "", "redact", "(F)Ljava/lang/Float;", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonFloat$1 extends ProtoAdapter<Float> {
    public int encodedSize(float f) {
        return 4;
    }

    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) {
        encode(protoWriter, ((Number) obj).floatValue());
    }

    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        encode(reverseProtoWriter, ((Number) obj).floatValue());
    }

    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize(((Number) obj).floatValue());
    }

    public /* bridge */ /* synthetic */ Object redact(Object obj) {
        return redact(((Number) obj).floatValue());
    }

    ProtoAdapterKt$commonFloat$1(FieldEncoding fieldEncoding, KClass<Float> kClass, Syntax syntax) {
        super(fieldEncoding, (KClass<?>) kClass, (String) null, syntax, Float.valueOf(0.0f));
    }

    public void encode(ProtoWriter protoWriter, float f) throws IOException {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        protoWriter.writeFixed32(Float.floatToIntBits(f));
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, float f) throws IOException {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        reverseProtoWriter.writeFixed32(Float.floatToIntBits(f));
    }

    public Float decode(ProtoReader protoReader) throws IOException {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
        return Float.valueOf(Float.intBitsToFloat(protoReader.readFixed32()));
    }

    public Float redact(float f) {
        throw new UnsupportedOperationException();
    }
}
