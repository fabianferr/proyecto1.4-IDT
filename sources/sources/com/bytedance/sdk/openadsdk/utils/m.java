package com.bytedance.sdk.openadsdk.utils;

import com.bytedance.sdk.openadsdk.multipro.d.d;

/* compiled from: LastShowAdSP */
public class m {
    public static String a() {
        return "sp_last_ad_show_cache_show_ad";
    }

    public static String b() {
        try {
            return d.b(a(), "material_data", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c() {
        try {
            return d.b(a(), "show_ad_tag", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long d() {
        try {
            return d.a(a(), "show_time", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static void a(String str, String str2) {
        try {
            d.a(a(), "show_time", Long.valueOf(System.currentTimeMillis()));
            d.a(a(), "material_data", str);
            d.a(a(), "show_ad_tag", str2);
        } catch (Throwable unused) {
        }
    }

    public static void e() {
        try {
            d.a(a());
        } catch (Throwable unused) {
        }
    }
}
