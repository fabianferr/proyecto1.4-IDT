package com.wortise.ads;

import androidx.work.OneTimeWorkRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001a\u0010\u0005\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0006"}, d2 = {"Landroidx/work/OneTimeWorkRequest$Builder;", "", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: OneTimeWorkRequest.kt */
public final class k5 {
    public static final OneTimeWorkRequest.Builder a(OneTimeWorkRequest.Builder builder, long j, TimeUnit timeUnit) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "unit");
        try {
            Method method = builder.getClass().getMethod("setInitialDelay", new Class[]{Long.TYPE, TimeUnit.class});
            Intrinsics.checkNotNullExpressionValue(method, "this::class.java.getMeth…va, TimeUnit::class.java)");
            method.invoke(builder, new Object[]{Long.valueOf(j), timeUnit});
        } catch (Throwable th) {
            WortiseLog.e("Could not set initial delay to the work", th);
        }
        return builder;
    }
}
