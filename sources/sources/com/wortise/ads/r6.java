package com.wortise.ads;

import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.wortise.ads.api.submodels.UserAppCategory;
import com.wortise.ads.consent.ConsentManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0007¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/r6;", "", "Landroid/content/Context;", "context", "", "Lcom/wortise/ads/q6;", "a", "Landroid/content/pm/PackageInfo;", "info", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: UserAppFactory.kt */
public final class r6 {
    public static final r6 a = new r6();

    private r6() {
    }

    public final List<q6> a(Context context) {
        List<PackageInfo> list;
        q6 q6Var;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!ConsentManager.canCollectData(context)) {
            return null;
        }
        try {
            list = context.getPackageManager().getInstalledPackages(0);
        } catch (Throwable unused) {
            list = null;
        }
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        l5 l5Var = l5.a;
        ArrayList<PackageInfo> arrayList = new ArrayList<>();
        for (T next : list) {
            if (l5Var.a((PackageInfo) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (PackageInfo a2 : arrayList) {
            try {
                q6Var = a.a(context, a2);
            } catch (Throwable unused2) {
                q6Var = null;
            }
            if (q6Var != null) {
                arrayList2.add(q6Var);
            }
        }
        return arrayList2;
    }

    public final q6 a(Context context, PackageInfo packageInfo) {
        Boolean bool;
        UsageStatsManager usageStatsManager;
        Context context2 = context;
        PackageInfo packageInfo2 = packageInfo;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(packageInfo2, "info");
        int i = Build.VERSION.SDK_INT;
        boolean z = true;
        CharSequence charSequence = null;
        UserAppCategory a2 = i >= 26 ? UserAppCategory.Companion.a(packageInfo2.applicationInfo.category) : null;
        if (i >= 23) {
            if (i < 22) {
                z = false;
            }
            if (z) {
                Object systemService = context2.getSystemService("usagestats");
                if (!(systemService instanceof UsageStatsManager)) {
                    systemService = null;
                }
                usageStatsManager = (UsageStatsManager) systemService;
            } else {
                usageStatsManager = null;
            }
            if (usageStatsManager != null) {
                bool = Boolean.valueOf(usageStatsManager.isAppInactive(packageInfo2.packageName));
                charSequence = packageInfo2.applicationInfo.loadLabel(context.getPackageManager());
                String str = packageInfo2.packageName;
                Intrinsics.checkNotNullExpressionValue(str, "info.packageName");
                return new q6(str, a2, new Date(packageInfo2.firstInstallTime), bool, new Date(packageInfo2.lastUpdateTime), charSequence, Long.valueOf(m5.a(packageInfo)), packageInfo2.versionName);
            }
        }
        bool = null;
        try {
            charSequence = packageInfo2.applicationInfo.loadLabel(context.getPackageManager());
        } catch (Throwable unused) {
        }
        String str2 = packageInfo2.packageName;
        Intrinsics.checkNotNullExpressionValue(str2, "info.packageName");
        return new q6(str2, a2, new Date(packageInfo2.firstInstallTime), bool, new Date(packageInfo2.lastUpdateTime), charSequence, Long.valueOf(m5.a(packageInfo)), packageInfo2.versionName);
    }
}
