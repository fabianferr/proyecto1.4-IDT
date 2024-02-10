package com.bytedance.sdk.openadsdk.core.settings;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.google.android.gms.appset.AppSet;

/* compiled from: AppSetIdAndScope */
public class c {
    /* access modifiers changed from: private */
    public static volatile String a = "";
    /* access modifiers changed from: private */
    public static volatile String b = "";
    private static String c;
    /* access modifiers changed from: private */
    public static int d;

    public static void a() {
        if (w.a("androidx.appcompat.app.AppCompatActivity") != null) {
            try {
                Context a2 = o.a();
                Class.forName("com.google.android.gms.appset.AppSet");
                AppSet.getClient(a2).getAppSetIdInfo().addOnSuccessListener(new AppSetIdAndScope$1());
            } catch (Throwable unused) {
                l.b("AppSetIdAndScope", "if you want to use appSetId, you must add 'com.google.android.gms:play-services-appset:x.x.x' into your build.gradle ");
                d = 2;
            }
        } else {
            d = 2;
        }
    }

    public static String b() {
        if (d != 0) {
            return a;
        }
        a();
        return a;
    }

    public static String c() {
        if (d != 0) {
            return b;
        }
        a();
        return b;
    }

    public static String d() {
        if (TextUtils.isEmpty(c)) {
            c = o.a().getPackageManager().getInstallerPackageName(ac.e());
        }
        if (c == null) {
            c = "";
        }
        return c;
    }
}
