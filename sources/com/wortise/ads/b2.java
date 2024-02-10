package com.wortise.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Process;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\b"}, d2 = {"Landroid/content/Context;", "", "flags", "Landroid/content/pm/PackageInfo;", "a", "", "name", "", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: Context.kt */
public final class b2 {
    public static final PackageInfo a(Context context, int i) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), i);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final boolean a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
    }
}
