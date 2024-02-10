package com.wortise.ads;

import android.content.pm.PackageInfo;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008G¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroid/content/pm/PackageInfo;", "", "a", "(Landroid/content/pm/PackageInfo;)J", "compatVersionCode", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: PackageInfo.kt */
public final class m5 {
    public static final long a(PackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "<this>");
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode;
    }
}
