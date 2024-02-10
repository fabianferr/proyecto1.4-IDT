package com.mbridge.msdk.videocommon.d;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.videocommon.c.a;
import com.mbridge.msdk.videocommon.c.c;
import com.mbridge.msdk.videocommon.download.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RewardSettingManager */
public class b {
    public static a a = null;
    private static ConcurrentHashMap<String, c> b = new ConcurrentHashMap<>();
    private static volatile b d;
    private volatile boolean c = false;
    private CopyOnWriteArrayList<String> e = new CopyOnWriteArrayList<>();

    private b() {
    }

    public static b a() {
        if (d == null) {
            synchronized (b.class) {
                if (d == null) {
                    d = new b();
                }
            }
        }
        return d;
    }

    public final void a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                this.e.remove(str);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0044 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.videocommon.d.a b() {
        /*
            r7 = this;
            com.mbridge.msdk.videocommon.d.a r0 = a
            if (r0 != 0) goto L_0x0074
            com.mbridge.msdk.foundation.a.a.a r0 = com.mbridge.msdk.foundation.a.a.a.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "reward_"
            r1.<init>(r2)
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r2 = r2.h()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = r0.b(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x005d
            com.mbridge.msdk.videocommon.d.a r0 = com.mbridge.msdk.videocommon.d.a.a((java.lang.String) r0)
            if (r0 == 0) goto L_0x0041
            long r1 = r0.d()
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = r0.i()
            long r5 = r5 + r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0041
            r1 = 0
            goto L_0x0042
        L_0x0041:
            r1 = 1
        L_0x0042:
            if (r1 != 0) goto L_0x0045
            return r0
        L_0x0045:
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r0 = r0.h()
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r1 = r1.j()
            r7.d(r0, r1)
            com.mbridge.msdk.videocommon.d.a r0 = r7.c()
            return r0
        L_0x005d:
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r0 = r0.h()
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r1 = r1.j()
            r7.d(r0, r1)
            com.mbridge.msdk.videocommon.d.a r0 = r7.c()
        L_0x0074:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.d.b.b():com.mbridge.msdk.videocommon.d.a");
    }

    private void d(String str, String str2) {
        if (!this.c) {
            this.c = true;
            new a().a(com.mbridge.msdk.foundation.controller.b.d().g(), str, str2);
        }
    }

    public final void a(String str, String str2, String str3, c cVar) {
        try {
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            if (!this.e.contains(str3)) {
                if (!TextUtils.isEmpty(str3)) {
                    this.e.add(str3);
                }
                new a().a(com.mbridge.msdk.foundation.controller.b.d().g(), str, str2, str3, cVar);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.videocommon.d.c a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "reward_"
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r1 = "_"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r1 = b
            boolean r1 = r1.containsKey(r0)
            r2 = 0
            if (r1 == 0) goto L_0x003c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r1 = b     // Catch:{ Exception -> 0x002c }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ Exception -> 0x002c }
            com.mbridge.msdk.videocommon.d.c r0 = (com.mbridge.msdk.videocommon.d.c) r0     // Catch:{ Exception -> 0x002c }
            boolean r1 = r4.a((com.mbridge.msdk.videocommon.d.c) r0)     // Catch:{ Exception -> 0x002d }
            goto L_0x002e
        L_0x002c:
            r0 = r2
        L_0x002d:
            r1 = 0
        L_0x002e:
            if (r1 == 0) goto L_0x003b
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r1 = r1.j()
            r4.a(r5, r1, r6, r2)
        L_0x003b:
            return r0
        L_0x003c:
            com.mbridge.msdk.foundation.a.a.a r1 = com.mbridge.msdk.foundation.a.a.a.a()
            java.lang.String r1 = r1.b(r0)
            com.mbridge.msdk.videocommon.d.c r1 = com.mbridge.msdk.videocommon.d.c.c((java.lang.String) r1)
            boolean r3 = r4.a((com.mbridge.msdk.videocommon.d.c) r1)
            if (r3 == 0) goto L_0x005a
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r0 = r0.j()
            r4.a(r5, r0, r6, r2)
            return r2
        L_0x005a:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r5 = b
            r5.put(r0, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.d.b.a(java.lang.String, java.lang.String):com.mbridge.msdk.videocommon.d.c");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.videocommon.d.c a(java.lang.String r5, java.lang.String r6, boolean r7) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "reward_"
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r1 = "_"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r1 = b
            boolean r1 = r1.containsKey(r0)
            r2 = 0
            if (r1 == 0) goto L_0x003c
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r7 = b     // Catch:{ Exception -> 0x002c }
            java.lang.Object r7 = r7.get(r0)     // Catch:{ Exception -> 0x002c }
            com.mbridge.msdk.videocommon.d.c r7 = (com.mbridge.msdk.videocommon.d.c) r7     // Catch:{ Exception -> 0x002c }
            boolean r0 = r4.a((com.mbridge.msdk.videocommon.d.c) r7)     // Catch:{ Exception -> 0x002d }
            goto L_0x002e
        L_0x002c:
            r7 = r2
        L_0x002d:
            r0 = 0
        L_0x002e:
            if (r0 == 0) goto L_0x003b
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r0 = r0.j()
            r4.a(r5, r0, r6, r2)
        L_0x003b:
            return r7
        L_0x003c:
            com.mbridge.msdk.foundation.a.a.a r1 = com.mbridge.msdk.foundation.a.a.a.a()
            java.lang.String r1 = r1.b(r0)
            com.mbridge.msdk.videocommon.d.c r1 = com.mbridge.msdk.videocommon.d.c.c((java.lang.String) r1)
            boolean r3 = r4.a((com.mbridge.msdk.videocommon.d.c) r1)
            if (r3 == 0) goto L_0x0061
            if (r1 != 0) goto L_0x0060
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r0 = r0.j()
            r4.a(r5, r0, r6, r2)
            com.mbridge.msdk.videocommon.d.c r5 = b((boolean) r7)
            return r5
        L_0x0060:
            return r1
        L_0x0061:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.d.c> r5 = b
            r5.put(r0, r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.d.b.a(java.lang.String, java.lang.String, boolean):com.mbridge.msdk.videocommon.d.c");
    }

    public final a c() {
        a aVar = new a();
        HashMap hashMap = new HashMap(5);
        hashMap.put("1", 1000);
        hashMap.put("9", 1000);
        hashMap.put("8", 1000);
        HashMap hashMap2 = new HashMap(3);
        hashMap2.put("1", new com.mbridge.msdk.videocommon.b.c("Virtual Item", 1));
        aVar.a((Map<String, Integer>) hashMap);
        aVar.b((Map<String, com.mbridge.msdk.videocommon.b.c>) hashMap2);
        aVar.a(43200);
        aVar.b(5400);
        aVar.c(3600);
        aVar.d(3600);
        aVar.e(5);
        aVar.a(1);
        return aVar;
    }

    private final boolean a(c cVar) {
        a b2 = b();
        if (b2 == null || cVar == null) {
            return true;
        }
        return cVar.x() + b2.e() <= System.currentTimeMillis();
    }

    public final void a(String str, String str2, String str3) {
        String str4 = "reward_" + str + "_" + str2;
        com.mbridge.msdk.foundation.a.a.a.a().a(str4, str3);
        b.put(str4, c.c(str3));
        if (!TextUtils.isEmpty(c.a)) {
            e(c.a, str2);
        }
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            a().a(com.mbridge.msdk.foundation.controller.b.d().h(), str, false);
            String str2 = c.a;
            if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(g.a().b(str2))) {
                e(str2, str);
            }
        }
    }

    private void e(final String str, final String str2) {
        if (TextUtils.isEmpty(str)) {
            Context g = com.mbridge.msdk.foundation.controller.b.d().g();
            q.a(g, str, str2, 2, "alert url is exception ,url:" + str);
            return;
        }
        g.a().a(new HashMap(), str, new g.d() {
            public final void a(String str, String str2, boolean z) {
                q.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, str2, 1, "");
            }

            public final void a(String str, String str2) {
                q.a(com.mbridge.msdk.foundation.controller.b.d().g(), str, str2, 2, str2);
            }
        });
    }

    public final void b(String str, String str2) {
        com.mbridge.msdk.foundation.a.a.a.a().a("reward_" + str, str2);
        a = a.a(str2);
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public static boolean c(String str) {
        JSONArray optJSONArray;
        try {
            if (!TextUtils.isEmpty(str) && (optJSONArray = new JSONObject(str).optJSONArray("unitSetting")) != null) {
                String optString = optJSONArray.optJSONObject(0).optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
                if (optJSONArray == null || optJSONArray.length() <= 0 || TextUtils.isEmpty(optString)) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final c c(String str, String str2) {
        String str3 = "reward_" + str + "_" + str2;
        if (b.containsKey(str3)) {
            return b.get(str3);
        }
        return c.c(com.mbridge.msdk.foundation.a.a.a.a().b(str3));
    }

    private static c b(boolean z) {
        c cVar = new c();
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new com.mbridge.msdk.videocommon.b.b(1, 60, (com.mbridge.msdk.videocommon.b.a) null));
            cVar.a((List<com.mbridge.msdk.videocommon.b.b>) arrayList);
            cVar.m(1);
            cVar.l(1);
            cVar.n(1);
            cVar.q(1);
            cVar.o(1);
            cVar.p(1);
            cVar.h(3);
            cVar.i(80);
            cVar.j(100);
            cVar.k(0);
            cVar.g(2);
            cVar.e(-1);
            cVar.x(70);
            cVar.d(2);
            if (z) {
                cVar.c(5);
            } else {
                cVar.c(-1);
            }
            cVar.b(0);
            cVar.a(0);
            cVar.f(1);
            cVar.r(1);
            cVar.t(3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(4);
            arrayList2.add(6);
            cVar.a((ArrayList<Integer>) arrayList2);
            cVar.u(1);
            cVar.v(1);
            cVar.w(60);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return cVar;
    }
}
