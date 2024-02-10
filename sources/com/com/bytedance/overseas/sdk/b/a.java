package com.com.bytedance.overseas.sdk.b;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.c;
import com.bytedance.sdk.openadsdk.core.o;

/* compiled from: AdvertisingIdHelper */
public class a {
    private static volatile a b;
    private String a = "";

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    private a() {
    }

    public String b() {
        if (!o.d().A("gaid")) {
            return "";
        }
        if (!TextUtils.isEmpty(this.a)) {
            return this.a;
        }
        String b2 = c.a(o.a()).b("gaid", "");
        this.a = b2;
        return b2;
    }

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            c.a(o.a()).a("gaid", str);
        }
    }

    public void b(String str) {
        this.a = str;
    }
}
