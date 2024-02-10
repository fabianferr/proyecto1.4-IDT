package io.monedata.extensions;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001a\u0010\u0007\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\t"}, d2 = {"getCompatApplicationInfo", "Landroid/content/pm/ApplicationInfo;", "Landroid/content/pm/PackageManager;", "packageName", "", "flags", "", "getCompatPackageInfo", "Landroid/content/pm/PackageInfo;", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PackageManagerKt {
    public static final ApplicationInfo getCompatApplicationInfo(PackageManager packageManager, String str, Number number) {
        String str2;
        ApplicationInfo applicationInfo;
        Intrinsics.checkNotNullParameter(packageManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "packageName");
        Intrinsics.checkNotNullParameter(number, "flags");
        if (Build.VERSION.SDK_INT >= 33) {
            applicationInfo = packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(number.longValue()));
            str2 = "getApplicationInfo(packa…Flags.of(flags.toLong()))";
        } else {
            applicationInfo = packageManager.getApplicationInfo(str, number.intValue());
            str2 = "getApplicationInfo(packageName, flags.toInt())";
        }
        Intrinsics.checkNotNullExpressionValue(applicationInfo, str2);
        return applicationInfo;
    }

    public static final PackageInfo getCompatPackageInfo(PackageManager packageManager, String str, Number number) {
        String str2;
        PackageInfo packageInfo;
        Intrinsics.checkNotNullParameter(packageManager, "<this>");
        Intrinsics.checkNotNullParameter(str, "packageName");
        Intrinsics.checkNotNullParameter(number, "flags");
        if (Build.VERSION.SDK_INT >= 33) {
            packageInfo = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(number.longValue()));
            str2 = "getPackageInfo(packageNa…Flags.of(flags.toLong()))";
        } else {
            packageInfo = packageManager.getPackageInfo(str, number.intValue());
            str2 = "getPackageInfo(packageName, flags.toInt())";
        }
        Intrinsics.checkNotNullExpressionValue(packageInfo, str2);
        return packageInfo;
    }
}
