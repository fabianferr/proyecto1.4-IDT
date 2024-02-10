package com.bytedance.sdk.openadsdk.core.f;

import android.content.Context;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.k.b;
import com.bytedance.sdk.openadsdk.k.c;

/* compiled from: TncHelper */
public class a {
    public static boolean a = false;
    private static final int b = Integer.parseInt("1371");

    public static void a() {
        Context a2;
        if (o.d().i() && !a && (a2 = o.a()) != null) {
            try {
                l.c("TncHelper", "initTTAdNet: support TNC");
                c.a().b().a(a2, true, new b(a2));
                c.a().b().a(a2, com.bytedance.sdk.openadsdk.multipro.b.c());
                a = true;
            } catch (Exception e) {
                l.d("TncHelper", "initTTAdNet: ", e.getMessage());
            }
        }
    }

    public static void b() {
        Context a2;
        if (a && o.d().i() && (a2 = o.a()) != null) {
            com.bytedance.sdk.component.f.c.a.a(a2, b);
        }
    }
}
