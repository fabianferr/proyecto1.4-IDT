package com.squareup.wire.internal;

import java.time.Duration;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.http2.Http2Connection;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002j\u0002`\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0014\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0002j\u0002`\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/squareup/wire/internal/DurationJsonFormatter;", "Lcom/squareup/wire/internal/JsonFormatter;", "Ljava/time/Duration;", "Lcom/squareup/wire/Duration;", "()V", "fromString", "value", "", "toStringOrNumber", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DurationJsonFormatter.kt */
public final class DurationJsonFormatter implements JsonFormatter<Duration> {
    public static final DurationJsonFormatter INSTANCE = new DurationJsonFormatter();

    private DurationJsonFormatter() {
    }

    public String toStringOrNumber(Duration duration) {
        String str;
        Intrinsics.checkNotNullParameter(duration, "value");
        long seconds = duration.getSeconds();
        int nano = duration.getNano();
        if (seconds < 0) {
            if (seconds == Long.MIN_VALUE) {
                str = "-922337203685477580";
                seconds = 8;
            } else {
                seconds = -seconds;
                str = "-";
            }
            if (nano != 0) {
                seconds--;
                nano = Http2Connection.DEGRADED_PONG_TIMEOUT_NS - nano;
            }
        } else {
            str = "";
        }
        if (nano == 0) {
            String format = String.format("%s%ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            return format;
        } else if (nano % 1000000 == 0) {
            String format2 = String.format("%s%d.%03ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds), Long.valueOf(((long) nano) / 1000000)}, 3));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            return format2;
        } else if (nano % 1000 == 0) {
            String format3 = String.format("%s%d.%06ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds), Long.valueOf(((long) nano) / 1000)}, 3));
            Intrinsics.checkNotNullExpressionValue(format3, "format(this, *args)");
            return format3;
        } else {
            String format4 = String.format("%s%d.%09ds", Arrays.copyOf(new Object[]{str, Long.valueOf(seconds), Long.valueOf(((long) nano) / 1)}, 3));
            Intrinsics.checkNotNullExpressionValue(format4, "format(this, *args)");
            return format4;
        }
    }

    public Duration fromString(String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "value");
        CharSequence charSequence = str;
        int indexOf$default = StringsKt.indexOf$default(charSequence, 's', 0, false, 6, (Object) null);
        if (indexOf$default == str.length() - 1) {
            int indexOf$default2 = StringsKt.indexOf$default(charSequence, '.', 0, false, 6, (Object) null);
            if (indexOf$default2 == -1) {
                String substring = str.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                Duration ofSeconds = Duration.ofSeconds(Long.parseLong(substring));
                Intrinsics.checkNotNullExpressionValue(ofSeconds, "ofSeconds(seconds)");
                return ofSeconds;
            }
            String substring2 = str.substring(0, indexOf$default2);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            long parseLong = Long.parseLong(substring2);
            int i2 = indexOf$default2 + 1;
            String substring3 = str.substring(i2, indexOf$default);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
            long parseLong2 = Long.parseLong(substring3);
            if (StringsKt.startsWith$default(str, "-", false, 2, (Object) null)) {
                parseLong2 = -parseLong2;
            }
            int i3 = indexOf$default - i2;
            int i4 = i3;
            while (true) {
                i = 9;
                if (i4 >= 9) {
                    break;
                }
                i4++;
                parseLong2 *= (long) 10;
            }
            while (i < i3) {
                i++;
                parseLong2 /= (long) 10;
            }
            Duration ofSeconds2 = Duration.ofSeconds(parseLong, parseLong2);
            Intrinsics.checkNotNullExpressionValue(ofSeconds2, "ofSeconds(seconds, nanos)");
            return ofSeconds2;
        }
        throw new NumberFormatException();
    }
}
