package com.wortise.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/z;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/y;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AppFactory.kt */
public final class z {
    public static final z a = new z();

    private z() {
    }

    public final y a(Context context) {
        Long l;
        Intrinsics.checkNotNullParameter(context, "context");
        y4 a2 = y4.Companion.a(context);
        PackageInfo a3 = b2.a(context, 0);
        String packageName = context.getPackageName();
        String d = a2.d();
        String str = null;
        if (a3 == null) {
            l = null;
        } else {
            l = Long.valueOf(m5.a(a3));
        }
        if (a3 != null) {
            str = a3.versionName;
        }
        String str2 = str;
        z0 a4 = a1.a.a(context);
        boolean a5 = e5.Companion.a(context);
        List<String> a6 = q5.a.a(context);
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        return new y(packageName, a4, a5, a6, "android", "1.4.1", d, l, str2);
    }
}
