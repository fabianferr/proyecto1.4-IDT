package com.wortise.ads;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0006"}, d2 = {"Ljava/util/Date;", "", "value", "Ljava/util/concurrent/TimeUnit;", "unit", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Date.kt */
public final class g2 {
    public static final Date a(Date date, Number number, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(number, "value");
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return new Date(date.getTime() + timeUnit.toMillis(number.longValue()));
    }
}
