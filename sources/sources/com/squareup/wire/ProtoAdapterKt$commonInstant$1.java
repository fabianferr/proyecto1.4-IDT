package com.squareup.wire;

import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001J\u0014\u0010\u0004\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0014\u0010\r\u001a\u00020\u000e2\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0018\u0010\u000f\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u000b\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\u0010"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonInstant$1", "Lcom/squareup/wire/ProtoAdapter;", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "", "redact", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonInstant$1 extends ProtoAdapter<Instant> {
    public Instant redact(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "value");
        return instant;
    }

    ProtoAdapterKt$commonInstant$1(FieldEncoding fieldEncoding, KClass<Instant> kClass, Syntax syntax) {
        super(fieldEncoding, (KClass<?>) kClass, "type.googleapis.com/google.protobuf.Timestamp", syntax);
    }

    public int encodedSize(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "value");
        long epochSecond = instant.getEpochSecond();
        int i = 0;
        if (epochSecond != 0) {
            i = 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(epochSecond));
        }
        int nano = instant.getNano();
        return nano != 0 ? i + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(nano)) : i;
    }

    public void encode(ProtoWriter protoWriter, Instant instant) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        Intrinsics.checkNotNullParameter(instant, "value");
        long epochSecond = instant.getEpochSecond();
        if (epochSecond != 0) {
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, Long.valueOf(epochSecond));
        }
        int nano = instant.getNano();
        if (nano != 0) {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(nano));
        }
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, Instant instant) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Intrinsics.checkNotNullParameter(instant, "value");
        int nano = instant.getNano();
        if (nano != 0) {
            ProtoAdapter.INT32.encodeWithTag(reverseProtoWriter, 2, Integer.valueOf(nano));
        }
        long epochSecond = instant.getEpochSecond();
        if (epochSecond != 0) {
            ProtoAdapter.INT64.encodeWithTag(reverseProtoWriter, 1, Long.valueOf(epochSecond));
        }
    }

    public Instant decode(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        long beginMessage = protoReader.beginMessage();
        long j = 0;
        int i = 0;
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessageAndGetUnknownFields(beginMessage);
                Instant ofEpochSecond = Instant.ofEpochSecond(j, (long) i);
                Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(epochSecond, nano)");
                return ofEpochSecond;
            } else if (nextTag == 1) {
                j = ProtoAdapter.INT64.decode(protoReader).longValue();
            } else if (nextTag != 2) {
                protoReader.readUnknownField(nextTag);
            } else {
                i = ProtoAdapter.INT32.decode(protoReader).intValue();
            }
        }
    }
}
