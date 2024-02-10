package com.squareup.wire;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001d\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\nJ\u001d\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonEmpty$1", "Lcom/squareup/wire/ProtoAdapter;", "", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "(Lcom/squareup/wire/ProtoWriter;Lkotlin/Unit;)V", "Lcom/squareup/wire/ReverseProtoWriter;", "(Lcom/squareup/wire/ReverseProtoWriter;Lkotlin/Unit;)V", "encodedSize", "", "(Lkotlin/Unit;)I", "redact", "(Lkotlin/Unit;)V", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonEmpty$1 extends ProtoAdapter<Unit> {
    public void encode(ProtoWriter protoWriter, Unit unit) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        Intrinsics.checkNotNullParameter(unit, "value");
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, Unit unit) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Intrinsics.checkNotNullParameter(unit, "value");
    }

    public int encodedSize(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "value");
        return 0;
    }

    public void redact(Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "value");
    }

    ProtoAdapterKt$commonEmpty$1(FieldEncoding fieldEncoding, KClass<Unit> kClass, Syntax syntax) {
        super(fieldEncoding, (KClass<?>) kClass, "type.googleapis.com/google.protobuf.Empty", syntax);
    }

    public /* bridge */ /* synthetic */ Object redact(Object obj) {
        redact((Unit) obj);
        return Unit.INSTANCE;
    }

    public void decode(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        long beginMessage = protoReader.beginMessage();
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessageAndGetUnknownFields(beginMessage);
                return;
            }
            protoReader.readUnknownField(nextTag);
        }
    }
}
