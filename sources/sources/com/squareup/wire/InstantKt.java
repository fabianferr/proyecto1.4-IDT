package com.squareup.wire;

import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\b*\n\u0010\u0006\"\u00020\u00012\u00020\u0001¨\u0006\u0007"}, d2 = {"ofEpochSecond", "Ljava/time/Instant;", "Lcom/squareup/wire/Instant;", "epochSecond", "", "nano", "Instant", "wire-runtime"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Instant.kt */
public final class InstantKt {
    public static final Instant ofEpochSecond(long j, long j2) {
        Instant ofEpochSecond = Instant.ofEpochSecond(j, j2);
        Intrinsics.checkNotNullExpressionValue(ofEpochSecond, "ofEpochSecond(epochSecond, nano)");
        return ofEpochSecond;
    }
}