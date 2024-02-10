package com.squareup.wire;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okio.ByteString;

@Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"com/squareup/wire/AnyMessage$Companion$ADAPTER$1", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/squareup/wire/AnyMessage;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "", "redact", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AnyMessage.kt */
public final class AnyMessage$Companion$ADAPTER$1 extends ProtoAdapter<AnyMessage> {
    AnyMessage$Companion$ADAPTER$1(FieldEncoding fieldEncoding, KClass<AnyMessage> kClass, Syntax syntax) {
        super(fieldEncoding, (KClass<?>) kClass, "type.googleapis.com/google.protobuf.Any", syntax);
    }

    public int encodedSize(AnyMessage anyMessage) {
        Intrinsics.checkNotNullParameter(anyMessage, "value");
        return ProtoAdapter.STRING.encodedSizeWithTag(1, anyMessage.getTypeUrl()) + ProtoAdapter.BYTES.encodedSizeWithTag(2, anyMessage.getValue());
    }

    public void encode(ProtoWriter protoWriter, AnyMessage anyMessage) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        Intrinsics.checkNotNullParameter(anyMessage, "value");
        ProtoAdapter.STRING.encodeWithTag(protoWriter, 1, anyMessage.getTypeUrl());
        ProtoAdapter.BYTES.encodeWithTag(protoWriter, 2, anyMessage.getValue());
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, AnyMessage anyMessage) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Intrinsics.checkNotNullParameter(anyMessage, "value");
        ProtoAdapter.BYTES.encodeWithTag(reverseProtoWriter, 2, anyMessage.getValue());
        ProtoAdapter.STRING.encodeWithTag(reverseProtoWriter, 1, anyMessage.getTypeUrl());
    }

    public AnyMessage decode(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        ByteString byteString = ByteString.EMPTY;
        long beginMessage = protoReader.beginMessage();
        String str = "";
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessageAndGetUnknownFields(beginMessage);
                return new AnyMessage(str, byteString);
            } else if (nextTag == 1) {
                str = ProtoAdapter.STRING.decode(protoReader);
            } else if (nextTag != 2) {
                protoReader.readUnknownField(nextTag);
            } else {
                byteString = ProtoAdapter.BYTES.decode(protoReader);
            }
        }
    }

    public AnyMessage redact(AnyMessage anyMessage) {
        Intrinsics.checkNotNullParameter(anyMessage, "value");
        return new AnyMessage("square.github.io/wire/redacted", ByteString.EMPTY);
    }
}
