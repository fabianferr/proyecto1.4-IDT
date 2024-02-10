package com.bytedance.sdk.openadsdk.component.reward;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.multipro.d.d;

/* compiled from: SpCache */
class m {
    private final String a;

    m(String str) {
        this.a = TextUtils.isEmpty(str) ? "" : str;
    }

    private String e(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return this.a + "_cache_" + str;
    }

    /* access modifiers changed from: package-private */
    public String a(String str) {
        try {
            return d.b(e(str), "material_data", (String) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public long b(String str) {
        try {
            return d.a(e(str), "create_time", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(String str) {
        try {
            return d.a(e(str), "has_played", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            d.a(e(str), "has_played", (Boolean) false);
            d.a(e(str), "create_time", Long.valueOf(System.currentTimeMillis()));
            d.a(e(str), "material_data", str2);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public void d(String str) {
        try {
            d.a(e(str));
        } catch (Throwable unused) {
        }
    }
}
