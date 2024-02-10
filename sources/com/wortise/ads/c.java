package com.wortise.ads;

import android.app.ActivityManager;
import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0005"}, d2 = {"Landroid/app/ActivityManager$RunningAppProcessInfo;", "Landroid/content/Context;", "context", "", "a", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: ActivityManager.kt */
public final class c {
    public static final boolean a(ActivityManager.RunningAppProcessInfo runningAppProcessInfo, Context context) {
        Intrinsics.checkNotNullParameter(runningAppProcessInfo, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String str = runningAppProcessInfo.processName;
        return (str == null || str.length() == 0) || Intrinsics.areEqual((Object) str, (Object) context.getPackageName());
    }
}
