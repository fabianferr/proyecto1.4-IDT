package com.bytedance.sdk.openadsdk.b.a;

import com.bytedance.sdk.openadsdk.j.b;

/* compiled from: ADEventMonitor */
public class a {
    public static final b a = new b(0);
    public static final b b = new b(1);
    public static final b c = new b(2);
    public static final b d = new b(0);
    public static final b e = new b(1);
    public static final b f = new b(2);

    public static void a(b bVar, boolean z, int i, long j) {
        try {
            bVar.g.getAndSet(true);
            if (z) {
                bVar.a.incrementAndGet();
                bVar.c.addAndGet(j);
                return;
            }
            bVar.b.incrementAndGet();
            if (bVar.f.containsKey(Integer.valueOf(i))) {
                bVar.f.put(Integer.valueOf(i), bVar.f.get(Integer.valueOf(i)));
            } else {
                bVar.f.put(Integer.valueOf(i), 1);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(b bVar, boolean z) {
        try {
            bVar.g.getAndSet(true);
            if (z) {
                bVar.a.incrementAndGet();
            } else {
                bVar.b.incrementAndGet();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(b bVar) {
        try {
            bVar.g.getAndSet(true);
            bVar.e.incrementAndGet();
        } catch (Throwable unused) {
        }
    }

    public static void a() {
        try {
            b bVar = a;
            if (bVar.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", bVar.a().toString());
            }
            b bVar2 = b;
            if (bVar2.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_state", "tt_sdk_event_net_state", bVar2.a().toString());
            }
            b bVar3 = c;
            if (bVar3.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", bVar3.a().toString());
            }
            b bVar4 = d;
            if (bVar4.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", bVar4.b().toString());
            }
            b bVar5 = e;
            if (bVar5.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_state", "tt_sdk_event_db_state", bVar5.b().toString());
            }
            b bVar6 = f;
            if (bVar6.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", bVar6.b().toString());
            }
        } catch (Throwable unused) {
        }
    }

    public static void b() {
        try {
            b.b("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_ad");
            b.b("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_net_state", "tt_sdk_event_net_state", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_state");
            b.b("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_trail");
            b.b("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_ad");
            b.b("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_db_state", "tt_sdk_event_db_state", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_state");
            b.b("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_trail");
        } catch (Throwable unused) {
        }
    }
}
