package com.squareup.wire;

import java.time.Duration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import okhttp3.internal.http2.Http2Connection;

@Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001J\u0014\u0010\f\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00142\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0014\u0010\u0015\u001a\u00020\u00052\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0016J\u0018\u0010\u0016\u001a\u00060\u0002j\u0002`\u00032\n\u0010\u0013\u001a\u00060\u0002j\u0002`\u0003H\u0016R\u001c\u0010\u0004\u001a\u00020\u0005*\u00060\u0002j\u0002`\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t*\u00060\u0002j\u0002`\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"com/squareup/wire/ProtoAdapterKt$commonDuration$1", "Lcom/squareup/wire/ProtoAdapter;", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "sameSignNanos", "", "getSameSignNanos", "(Ljava/time/Duration;)I", "sameSignSeconds", "", "getSameSignSeconds", "(Ljava/time/Duration;)J", "decode", "reader", "Lcom/squareup/wire/ProtoReader;", "encode", "", "writer", "Lcom/squareup/wire/ProtoWriter;", "value", "Lcom/squareup/wire/ReverseProtoWriter;", "encodedSize", "redact", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoAdapter.kt */
public final class ProtoAdapterKt$commonDuration$1 extends ProtoAdapter<Duration> {
    public Duration redact(Duration duration) {
        Intrinsics.checkNotNullParameter(duration, "value");
        return duration;
    }

    ProtoAdapterKt$commonDuration$1(FieldEncoding fieldEncoding, KClass<Duration> kClass, Syntax syntax) {
        super(fieldEncoding, (KClass<?>) kClass, "type.googleapis.com/google.protobuf.Duration", syntax);
    }

    public int encodedSize(Duration duration) {
        Intrinsics.checkNotNullParameter(duration, "value");
        long sameSignSeconds = getSameSignSeconds(duration);
        int i = 0;
        if (sameSignSeconds != 0) {
            i = 0 + ProtoAdapter.INT64.encodedSizeWithTag(1, Long.valueOf(sameSignSeconds));
        }
        int sameSignNanos = getSameSignNanos(duration);
        return sameSignNanos != 0 ? i + ProtoAdapter.INT32.encodedSizeWithTag(2, Integer.valueOf(sameSignNanos)) : i;
    }

    public void encode(ProtoWriter protoWriter, Duration duration) {
        Intrinsics.checkNotNullParameter(protoWriter, "writer");
        Intrinsics.checkNotNullParameter(duration, "value");
        long sameSignSeconds = getSameSignSeconds(duration);
        if (sameSignSeconds != 0) {
            ProtoAdapter.INT64.encodeWithTag(protoWriter, 1, Long.valueOf(sameSignSeconds));
        }
        int sameSignNanos = getSameSignNanos(duration);
        if (sameSignNanos != 0) {
            ProtoAdapter.INT32.encodeWithTag(protoWriter, 2, Integer.valueOf(sameSignNanos));
        }
    }

    public void encode(ReverseProtoWriter reverseProtoWriter, Duration duration) {
        Intrinsics.checkNotNullParameter(reverseProtoWriter, "writer");
        Intrinsics.checkNotNullParameter(duration, "value");
        int sameSignNanos = getSameSignNanos(duration);
        if (sameSignNanos != 0) {
            ProtoAdapter.INT32.encodeWithTag(reverseProtoWriter, 2, Integer.valueOf(sameSignNanos));
        }
        long sameSignSeconds = getSameSignSeconds(duration);
        if (sameSignSeconds != 0) {
            ProtoAdapter.INT64.encodeWithTag(reverseProtoWriter, 1, Long.valueOf(sameSignSeconds));
        }
    }

    private final long getSameSignSeconds(Duration duration) {
        if (duration.getSeconds() >= 0 || duration.getNano() == 0) {
            return duration.getSeconds();
        }
        return duration.getSeconds() + 1;
    }

    private final int getSameSignNanos(Duration duration) {
        if (duration.getSeconds() >= 0 || duration.getNano() == 0) {
            return duration.getNano();
        }
        return duration.getNano() - Http2Connection.DEGRADED_PONG_TIMEOUT_NS;
    }

    public Duration decode(ProtoReader protoReader) {
        Intrinsics.checkNotNullParameter(protoReader, "reader");
        long beginMessage = protoReader.beginMessage();
        long j = 0;
        int i = 0;
        while (true) {
            int nextTag = protoReader.nextTag();
            if (nextTag == -1) {
                protoReader.endMessageAndGetUnknownFields(beginMessage);
                Duration ofSeconds = Duration.ofSeconds(j, (long) i);
                Intrinsics.checkNotNullExpressionValue(ofSeconds, "ofSeconds(seconds, nano)");
                return ofSeconds;
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
