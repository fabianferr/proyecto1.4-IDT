package com.bytedance.sdk.openadsdk.b.a;

import android.content.Context;
import com.bytedance.sdk.component.e.a.a;
import com.bytedance.sdk.component.e.a.a.e;
import com.bytedance.sdk.component.e.a.b;
import com.bytedance.sdk.component.e.a.b.c;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.j;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: AdLogSwitchUtils */
public class d {
    public static AtomicInteger a = new AtomicInteger(0);
    public static final AtomicBoolean b = new AtomicBoolean(false);

    public static void a(Context context, boolean z) {
        if (b.compareAndSet(false, true)) {
            b.a(new a.C0051a().a((c) new j()).b(com.bytedance.sdk.component.e.a.d.b.a.c()).c(com.bytedance.sdk.component.e.a.d.b.a.e()).a(com.bytedance.sdk.component.e.a.d.b.a.d()).a(z).a((f) new k()).a((e) h.a).b(o.d().n()).a(o.d().o()).a(), context);
            b();
        }
    }

    public static void a(com.bytedance.sdk.openadsdk.b.a aVar) {
        com.bytedance.sdk.component.e.a.d.a.a aVar2 = new com.bytedance.sdk.component.e.a.d.a.a(aVar.d(), (com.bytedance.sdk.component.e.a.d.a.b) aVar);
        aVar2.b(aVar.e() ? (byte) 1 : 2);
        aVar2.a((byte) 0);
        if (b.b()) {
            a(o.a(), com.bytedance.sdk.openadsdk.multipro.b.c());
        }
        b.a((com.bytedance.sdk.component.e.a.d.a) aVar2);
    }

    public static com.bytedance.sdk.openadsdk.j.c.a a() {
        return l.a;
    }

    public static void a(final List<String> list) {
        if (list != null) {
            com.bytedance.sdk.openadsdk.b.c.a((h) new h("track") {
                public void run() {
                    if (b.b()) {
                        d.a(o.a(), com.bytedance.sdk.openadsdk.multipro.b.c());
                    }
                    b.a(j.a(o.a()), list, true);
                }
            });
        }
    }

    public static void a(String str) {
        if (b.b()) {
            a(o.a(), com.bytedance.sdk.openadsdk.multipro.b.c());
        }
        b.a(str);
    }

    public static void b() {
        b.c();
    }

    public static void c() {
        try {
            b.d();
            b.e();
        } catch (Throwable th) {
            l.e("AdLogSwitchUtils", th.getMessage());
        }
    }
}
