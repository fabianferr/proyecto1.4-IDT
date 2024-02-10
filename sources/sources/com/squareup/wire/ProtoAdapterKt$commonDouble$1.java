package com.squareup.wire;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0015\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonDouble$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "(Lcom/squareup/wire/ProtoReader;)Ljava/lang/Double;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "", "redact", "(D)Ljava/lang/Double;", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonDouble$1 extends ProtoAdapter<Double> {
    public int encodedSize(double d) {
        return 8;
    }

    public /* bridge */ /* synthetic */ void encode(ProtoWriter protoWriter, Object obj) {
        encode(protoWriter, ((Number) obj).doubleValue());
    }

    public /* bridge */ /* synthetic */ void encode(ReverseProtoWriter reverseProtoWriter, Object obj) {
        encode(reverseProtoWriter, ((Number) obj).doubleValue());
    }

    public /* bridge */ /* synthetic */ int encodedSize(Object obj) {
        return encodedSize(((Number) obj).doubleValue());
    }

    public /* bridge */ /* synthetic */ Object redact(Object obj) {
        return redact(((Number) obj).doubleValue());
    }

    ProtoAdapterKt$commonDouble$1(FieldEncoding fieldEncoding, KClass<Double> kClass, Syntax syntax) {
        super(fieldEncoding, (KClass<?>) kClass, (String) null, syntax, Double.valueOf(0.0d));
    }

    public void encode(ProtoWriter protoWriter, double d) throws IOException {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        protoWriter.writeFixed64(Double.doubleToLongBits(d));
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, double d) throws IOException {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        reverseProtoWriter.writeFixed64(Double.doubleToLongBits(d));
    }

    public Double decode(ProtoReader protoReader) throws IOException {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        DoubleCompanionObject doubleCompanionObject = DoubleCompanionObject.INSTANCE;
        return Double.valueOf(Double.longBitsToDouble(protoReader.readFixed64()));
    }

    public Double redact(double d) {
        throw new UnsupportedOperationException();
    }
}
