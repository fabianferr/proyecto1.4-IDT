package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import com.bytedance.sdk.openadsdk.multipro.d.d;

/* compiled from: AdPreference */
public class c {
    private static volatile c a;

    private c() {
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public void a(String str, String str2) {
        d.a("ttopenadsdk", str, str2);
    }

    public String b(String str, String str2) {
        return d.b("ttopenadsdk", str, str2);
    }

    public void a(String str, int i) {
        d.a("ttopenadsdk", str, Integer.valueOf(i));
    }

    public int b(String str, int i) {
        return d.a("ttopenadsdk", str, i);
    }

    public void a(String str, long j) {
        d.a("ttopenadsdk", str, Long.valueOf(j));
    }

    public Long b(String str, long j) {
        return Long.valueOf(d.a("ttopenadsdk", str, j));
    }
}
