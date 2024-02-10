package io.monedata.extensions;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"add", "Ljava/util/Date;", "value", "", "unit", "Ljava/util/concurrent/TimeUnit;", "subtract", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class DateKt {
    public static final Date add(Date date, Number number, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(number, "value");
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return new Date(date.getTime() + timeUnit.toMillis(number.longValue()));
    }

    public static final Date subtract(Date date, Number number, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(date, "<this>");
        Intrinsics.checkNotNullParameter(number, "value");
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        return new Date(date.getTime() - timeUnit.toMillis(number.longValue()));
    }
}
