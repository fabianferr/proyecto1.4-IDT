package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.c;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.facebook.internal.security.CertificateUtil;

/* compiled from: AppInfo */
public class a {
    private static String a;

    public static String a() {
        return "open_news";
    }

    public static String b() {
        return "1371";
    }

    public static String c() {
        return BuildConfig.VERSION_NAME;
    }

    public static String d() {
        return ac.g();
    }

    public static String e() {
        return h.b().e();
    }

    public static String f() {
        return o.g(com.bytedance.sdk.openadsdk.core.o.a());
    }

    public static String a(Context context) {
        return j.a(context);
    }

    public static String g() {
        try {
            if (!TextUtils.isEmpty(a)) {
                return a;
            }
            String a2 = h.a("sdk_app_sha1", 259200000);
            a = a2;
            if (a(a2)) {
                return a;
            }
            String a3 = c.a(com.bytedance.sdk.openadsdk.core.o.a());
            a = a3;
            if (a(a3)) {
                String upperCase = a.toUpperCase();
                a = upperCase;
                h.a("sdk_app_sha1", upperCase);
                return a;
            }
            return "";
        } catch (Exception unused) {
        }
    }

    private static boolean a(String str) {
        String[] split;
        if (TextUtils.isEmpty(str) || (split = str.split(CertificateUtil.DELIMITER)) == null || split.length < 20) {
            return false;
        }
        for (String equals : split) {
            if (!"00".equals(equals)) {
                return true;
            }
        }
        return false;
    }
}
