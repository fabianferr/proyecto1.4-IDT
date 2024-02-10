package com.wortise.ads;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001\u001a\u0012\u0010\t\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0001\"\u0018\u0010\u000b\u001a\u00020\u0003*\u00020\u00008BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\n¨\u0006\f"}, d2 = {"Landroid/content/Context;", "", "dips", "", "a", "", "b", "pixels", "c", "d", "(Landroid/content/Context;)F", "density", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Dips.kt */
public final class r2 {
    private static final float a(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static final int b(Context context, Number number) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(number, "dips");
        return (int) (a(context, number) + 0.5f);
    }

    public static final float c(Context context, Number number) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(number, "pixels");
        return number.floatValue() / a(context);
    }

    public static final int d(Context context, Number number) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(number, "pixels");
        return (int) (c(context, number) + 0.5f);
    }

    public static final float a(Context context, Number number) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(number, "dips");
        return number.floatValue() * a(context);
    }
}
