package com.wortise.ads;

import android.content.Context;
import androidx.work.Data;
import androidx.work.WorkManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0001\u001a\u00020\u0000\u001a\u001c\u0010\u0003\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t¨\u0006\u000b"}, d2 = {"Landroid/content/Context;", "context", "", "a", "Landroidx/work/WorkManager;", "b", "Landroidx/work/Data$Builder;", "", "key", "", "value", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: WorkManager.kt */
public final class e7 {
    public static final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return n5.a.a(context, "androidx.work.impl.background.systemalarm.ConstraintProxy$NetworkStateProxy", false);
    }

    public static final WorkManager b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            return WorkManager.getInstance(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Data.Builder a(Data.Builder builder, String str, Object obj) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(str, "key");
        Data.Builder putString = builder.putString(str, obj == null ? null : p4.a(obj));
        Intrinsics.checkNotNullExpressionValue(putString, "putString(key, value?.toJson())");
        return putString;
    }
}
