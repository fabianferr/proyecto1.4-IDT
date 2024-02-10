package com.bytedance.sdk.openadsdk.b.a;

import com.bytedance.sdk.component.e.a.b;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.j.c.a;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.r;

/* compiled from: StatsLogAdLogImpl */
class l implements a {
    public static final l a = new l();

    public void a() {
    }

    private l() {
    }

    public void a(com.bytedance.sdk.openadsdk.j.a aVar) {
        a(aVar, false);
    }

    public void a(final com.bytedance.sdk.openadsdk.j.a aVar, final boolean z) {
        a((h) new h("uploadLogEvent") {
            public void run() {
                try {
                    com.bytedance.sdk.openadsdk.j.a.a logStats = aVar.getLogStats();
                    if (logStats != null) {
                        com.bytedance.sdk.component.e.a.d.a.a aVar = new com.bytedance.sdk.component.e.a.d.a.a(r.a(), logStats.a());
                        aVar.c((byte) 0);
                        aVar.b(z ? (byte) 2 : 3);
                        aVar.a((byte) 1);
                        if (b.b()) {
                            d.a(o.a(), com.bytedance.sdk.openadsdk.multipro.b.c());
                        }
                        b.a((com.bytedance.sdk.component.e.a.d.a) aVar);
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    private void a(h hVar) {
        if (hVar != null) {
            if (!aa.f()) {
                aa.b(hVar, 5);
            } else {
                hVar.run();
            }
        }
    }
}
