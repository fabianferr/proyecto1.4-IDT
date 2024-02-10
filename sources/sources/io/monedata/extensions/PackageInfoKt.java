package io.monedata.extensions;

import android.content.pm.PackageInfo;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"compatVersionCode", "", "Landroid/content/pm/PackageInfo;", "getCompatVersionCode", "(Landroid/content/pm/PackageInfo;)J", "core_productionRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PackageInfoKt {
    public static final long getCompatVersionCode(PackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "<this>");
        return Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode;
    }
}
