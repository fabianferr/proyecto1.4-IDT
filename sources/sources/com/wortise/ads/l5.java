package com.wortise.ads;

import android.content.pm.PackageInfo;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/l5;", "", "Landroid/content/pm/PackageInfo;", "info", "", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: PackageFilter.kt */
public final class l5 {
    public static final l5 a = new l5();
    private static final List<Regex> b = CollectionsKt.listOf(new Regex("android\\..+"), new Regex("com\\.amlogic\\..+"), new Regex("com\\.android\\..+"), new Regex("com\\.lge[0-9]+\\..+"), new Regex("com\\.mediatek\\..+"), new Regex("com\\.miui\\..+"), new Regex("com\\.qti\\..+"), new Regex("com\\.qualcomm\\..+"), new Regex("com\\.samsung\\.android\\..+"), new Regex("com\\.sonyericsson\\..+"), new Regex("com\\.sonymobile\\..+"), new Regex("com\\.tct\\..+"), new Regex("com\\.tencent\\..+"), new Regex("com\\.zte\\..+"), new Regex("huawei\\.android\\..+"), new Regex("themes\\.huawei\\..+"));

    private l5() {
    }

    public final boolean a(PackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "info");
        if ((packageInfo.applicationInfo.flags & 1) != 0) {
            return false;
        }
        List<Regex> list = b;
        if ((list instanceof Collection) && list.isEmpty()) {
            return true;
        }
        for (Regex matches : list) {
            String str = packageInfo.packageName;
            Intrinsics.checkNotNullExpressionValue(str, "info.packageName");
            if (matches.matches(str)) {
                return false;
            }
        }
        return true;
    }
}
