package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.multipro.d.d;

/* compiled from: ExternalSpUtils */
public class g {
    public static void a(String str) {
        a("any_door_id", str);
    }

    public static String a() {
        return b("any_door_id", (String) null);
    }

    private static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            try {
                d.a((String) null, str, str2);
            } catch (Throwable unused) {
            }
        }
    }

    private static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return d.b((String) null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }
}
