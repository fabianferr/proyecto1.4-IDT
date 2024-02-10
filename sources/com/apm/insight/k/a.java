package com.apm.insight.k;

import com.apm.insight.entity.b;
import com.apm.insight.i;
import com.apm.insight.l.p;
import com.apm.insight.l.q;
import com.apm.insight.runtime.u;
import java.util.Map;

public class a {
    /* access modifiers changed from: private */
    public static Runnable a = new Runnable() {
        public void run() {
            long j;
            Runnable runnable;
            u uVar;
            if (p.b(i.g())) {
                a.i();
            }
            if (a.b > 0) {
                if (com.apm.insight.l.a.b(i.g())) {
                    uVar = com.apm.insight.runtime.p.b();
                    runnable = a.a;
                    j = 15000;
                } else {
                    uVar = com.apm.insight.runtime.p.b();
                    runnable = a.a;
                    j = 60000;
                }
                uVar.a(runnable, j);
            }
        }
    };
    /* access modifiers changed from: private */
    public static int b = 0;

    public static void a() {
        b = 40;
        com.apm.insight.runtime.p.b().a(a);
    }

    public static void b() {
        if (!k.b()) {
            k.c();
        }
        if (p.b(i.g()) && k.a(false)) {
            i();
        }
    }

    public static boolean c() {
        return false;
    }

    public static void d() {
    }

    private static byte[] h() {
        try {
            return e.a(i.i().getConfigUrl(), (Map<String, String>) null, b.a().toString().getBytes());
        } catch (Throwable th) {
            q.a(th);
            return null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (com.apm.insight.k.k.a() != false) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void i() {
        /*
            java.lang.String r0 = "after fetchApmConfig net "
            java.lang.Class<com.apm.insight.k.a> r1 = com.apm.insight.k.a.class
            monitor-enter(r1)
            int r2 = b     // Catch:{ all -> 0x0065 }
            r3 = 1
            if (r2 <= 0) goto L_0x000d
            int r2 = r2 - r3
            b = r2     // Catch:{ all -> 0x0065 }
        L_0x000d:
            java.lang.String r2 = "try fetchApmConfig"
            com.apm.insight.l.q.a((java.lang.Object) r2)     // Catch:{ all -> 0x0065 }
            android.content.Context r2 = com.apm.insight.i.g()     // Catch:{ all -> 0x0065 }
            boolean r2 = com.apm.insight.l.a.b(r2)     // Catch:{ all -> 0x0065 }
            r4 = 0
            if (r2 == 0) goto L_0x0059
            r2 = 0
            byte[] r5 = h()     // Catch:{ all -> 0x0035 }
            if (r5 == 0) goto L_0x003b
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ all -> 0x0035 }
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0035 }
            r7.<init>(r5)     // Catch:{ all -> 0x0035 }
            r6.<init>(r7)     // Catch:{ all -> 0x0035 }
            java.lang.String r5 = "data"
            org.json.JSONArray r2 = r6.optJSONArray(r5)     // Catch:{ all -> 0x0035 }
            goto L_0x003b
        L_0x0035:
            r5 = move-exception
            java.lang.String r6 = "npth"
            com.apm.insight.l.q.a((java.lang.String) r6, (java.lang.Throwable) r5)     // Catch:{ all -> 0x0065 }
        L_0x003b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0065 }
            r5.<init>(r0)     // Catch:{ all -> 0x0065 }
            r5.append(r2)     // Catch:{ all -> 0x0065 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0065 }
            com.apm.insight.l.q.a((java.lang.Object) r0)     // Catch:{ all -> 0x0065 }
            if (r2 == 0) goto L_0x0052
            com.apm.insight.runtime.a.a((org.json.JSONArray) r2, (boolean) r3)     // Catch:{ all -> 0x0065 }
        L_0x004f:
            b = r4     // Catch:{ all -> 0x0065 }
            goto L_0x0063
        L_0x0052:
            int r0 = b     // Catch:{ all -> 0x0065 }
            int r0 = r0 + -10
            b = r0     // Catch:{ all -> 0x0065 }
            goto L_0x0063
        L_0x0059:
            com.apm.insight.k.k.c()     // Catch:{ all -> 0x0065 }
            boolean r0 = com.apm.insight.k.k.a()     // Catch:{ all -> 0x0065 }
            if (r0 == 0) goto L_0x0063
            goto L_0x004f
        L_0x0063:
            monitor-exit(r1)
            return
        L_0x0065:
            r0 = move-exception
            monitor-exit(r1)
            goto L_0x0069
        L_0x0068:
            throw r0
        L_0x0069:
            goto L_0x0068
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.k.a.i():void");
    }
}
