package com.bytedance.sdk.openadsdk.j.b;

import com.bytedance.sdk.component.g.c;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.j.b;

/* compiled from: ReportThreadLogServiceImp */
public class a implements c {
    public void a(final com.bytedance.sdk.component.g.b.a aVar) {
        b.a();
        b.a("stats_sdk_thread_num", false, (com.bytedance.sdk.openadsdk.j.a) new com.bytedance.sdk.openadsdk.j.a() {
            public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                com.bytedance.sdk.component.g.b.a aVar;
                if (!o.d().W() || (aVar = aVar) == null || aVar.a() == null) {
                    return null;
                }
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("stats_sdk_thread_num").b(aVar.a().toString());
            }
        });
    }
}
