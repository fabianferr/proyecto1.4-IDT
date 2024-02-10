package com.mbridge.msdk.foundation.same.net.g;

import android.text.TextUtils;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.net.l;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: RequestControlUtil */
public final class c {
    private final String a;
    private int b;
    private ArrayList<Integer> c;
    private ConcurrentHashMap<String, a> d;

    /* compiled from: RequestControlUtil */
    private static class b {
        /* access modifiers changed from: private */
        public static final c a = new c();
    }

    private c() {
        this.a = "IDErrorUtil";
        this.c = new ArrayList<>();
        this.d = new ConcurrentHashMap<>();
        e b2 = f.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        b2 = b2 == null ? f.a().b() : b2;
        this.b = b2.aC() * 1000;
        if (b2.aD() == null || b2.aD().size() <= 0) {
            aa.d("IDErrorUtil", "Setting ercd is EMPTY and use default code list.");
            this.c.addAll(Arrays.asList(new Integer[]{-1, -10, -1201, -1202, -1203, -1205, -1206, -1208, -1301, -1302, -1305, -1306, -1307, -1915, 10602, 10603, 10604, 10609, 10610, 10616}));
            return;
        }
        aa.d("IDErrorUtil", "Setting ercd not EMPTY will use setting.");
        this.c.addAll(b2.aD());
    }

    public static c a() {
        return b.a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0045, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r4, int r5, java.lang.String r6, long r7) {
        /*
            r3 = this;
            java.lang.String r0 = "addErrorInfo : "
            monitor-enter(r3)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r1 = r3.d     // Catch:{ all -> 0x0046 }
            boolean r1 = r1.containsKey(r4)     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r3)
            return
        L_0x000d:
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0015
            monitor-exit(r3)
            return
        L_0x0015:
            java.util.ArrayList<java.lang.Integer> r1 = r3.c     // Catch:{ all -> 0x0046 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0046 }
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0044
            java.lang.String r1 = "IDErrorUtil"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0046 }
            r2.<init>(r0)     // Catch:{ all -> 0x0046 }
            r2.append(r4)     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = " "
            r2.append(r0)     // Catch:{ all -> 0x0046 }
            r2.append(r6)     // Catch:{ all -> 0x0046 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0046 }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)     // Catch:{ all -> 0x0046 }
            com.mbridge.msdk.foundation.same.net.g.c$a r0 = new com.mbridge.msdk.foundation.same.net.g.c$a     // Catch:{ all -> 0x0046 }
            r0.<init>(r7, r5, r6)     // Catch:{ all -> 0x0046 }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r5 = r3.d     // Catch:{ all -> 0x0046 }
            r5.put(r4, r0)     // Catch:{ all -> 0x0046 }
        L_0x0044:
            monitor-exit(r3)
            return
        L_0x0046:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.g.c.a(java.lang.String, int, java.lang.String, long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0087, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.mbridge.msdk.foundation.same.net.g.c.a a(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r0 = "getErrorInfo : "
            java.lang.String r1 = "getErrorInfo : "
            monitor-enter(r8)
            java.lang.String r2 = "IDErrorUtil"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r3.<init>(r1)     // Catch:{ all -> 0x009f }
            r3.append(r9)     // Catch:{ all -> 0x009f }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x009f }
            com.mbridge.msdk.foundation.tools.aa.d(r2, r1)     // Catch:{ all -> 0x009f }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r1 = r8.d     // Catch:{ all -> 0x009f }
            boolean r1 = r1.containsKey(r9)     // Catch:{ all -> 0x009f }
            r2 = 0
            if (r1 == 0) goto L_0x009d
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r1 = r8.d     // Catch:{ all -> 0x009f }
            java.lang.Object r1 = r1.get(r9)     // Catch:{ all -> 0x009f }
            com.mbridge.msdk.foundation.same.net.g.c$a r1 = (com.mbridge.msdk.foundation.same.net.g.c.a) r1     // Catch:{ all -> 0x009f }
            if (r1 == 0) goto L_0x009d
            int r3 = r1.b     // Catch:{ all -> 0x009f }
            r4 = -1
            if (r3 != r4) goto L_0x0030
            monitor-exit(r8)
            return r1
        L_0x0030:
            long r3 = r1.a     // Catch:{ all -> 0x009f }
            int r5 = r8.b     // Catch:{ all -> 0x009f }
            long r5 = (long) r5     // Catch:{ all -> 0x009f }
            long r3 = r3 + r5
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009f }
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 <= 0) goto L_0x0088
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r0 = r8.d     // Catch:{ all -> 0x009f }
            r0.remove(r9)     // Catch:{ all -> 0x009f }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r9 = r8.d     // Catch:{ all -> 0x009f }
            int r9 = r9.size()     // Catch:{ all -> 0x009f }
            if (r9 <= 0) goto L_0x0086
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r9 = r8.d     // Catch:{ all -> 0x009f }
            java.util.Set r9 = r9.entrySet()     // Catch:{ all -> 0x009f }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x009f }
        L_0x0055:
            boolean r0 = r9.hasNext()     // Catch:{ all -> 0x009f }
            if (r0 == 0) goto L_0x0086
            java.lang.String r0 = "IDErrorUtil"
            java.lang.String r1 = "getErrorInfo : delete timeout entry"
            com.mbridge.msdk.foundation.tools.aa.d(r0, r1)     // Catch:{ all -> 0x009f }
            java.lang.Object r0 = r9.next()     // Catch:{ all -> 0x009f }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x009f }
            java.lang.Object r1 = r0.getValue()     // Catch:{ all -> 0x009f }
            com.mbridge.msdk.foundation.same.net.g.c$a r1 = (com.mbridge.msdk.foundation.same.net.g.c.a) r1     // Catch:{ all -> 0x009f }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009f }
            long r5 = r1.a     // Catch:{ all -> 0x009f }
            long r3 = r3 - r5
            int r1 = r8.b     // Catch:{ all -> 0x009f }
            long r5 = (long) r1     // Catch:{ all -> 0x009f }
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0055
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.foundation.same.net.g.c$a> r1 = r8.d     // Catch:{ all -> 0x009f }
            java.lang.Object r0 = r0.getKey()     // Catch:{ all -> 0x009f }
            r1.remove(r0)     // Catch:{ all -> 0x009f }
            goto L_0x0055
        L_0x0086:
            monitor-exit(r8)
            return r2
        L_0x0088:
            java.lang.String r9 = "IDErrorUtil"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x009f }
            r2.<init>(r0)     // Catch:{ all -> 0x009f }
            java.lang.String r0 = r1.c     // Catch:{ all -> 0x009f }
            r2.append(r0)     // Catch:{ all -> 0x009f }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x009f }
            com.mbridge.msdk.foundation.tools.aa.d(r9, r0)     // Catch:{ all -> 0x009f }
            monitor-exit(r8)
            return r1
        L_0x009d:
            monitor-exit(r8)
            return r2
        L_0x009f:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x00a3
        L_0x00a2:
            throw r9
        L_0x00a3:
            goto L_0x00a2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.net.g.c.a(java.lang.String):com.mbridge.msdk.foundation.same.net.g.c$a");
    }

    public final l a(d dVar) {
        int parseInt;
        String str = dVar.c().get("app_id");
        String str2 = dVar.c().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        String str3 = dVar.c().get("ad_type");
        String str4 = dVar.c().get(IronSourceAdapter.IRONSOURCE_BIDDING_TOKEN_KEY);
        String str5 = str + "_" + dVar.c().get(FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER) + "_" + str2 + "_" + str3;
        a a2 = a(str5);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.mbridge.msdk.foundation.same.net.d.b("data_res_type", "1"));
        if (a2 != null && !TextUtils.isEmpty(a2.c)) {
            try {
                if (a2.b != -1) {
                    return l.a(new JSONObject(a2.c), new com.mbridge.msdk.foundation.same.net.f.c(200, a2.c.getBytes(), arrayList));
                }
                if (!TextUtils.isEmpty(str4)) {
                    return null;
                }
                if (!(str3 == null || TextUtils.isEmpty(str3) || (parseInt = Integer.parseInt(str3)) == 287 || parseInt == 94)) {
                    if (System.currentTimeMillis() < ((long) (f.a().d(str, str2).w() * 1000)) + a2.a) {
                        return l.a(new JSONObject(a2.c), new com.mbridge.msdk.foundation.same.net.f.c(200, a2.c.getBytes(), arrayList));
                    }
                    this.d.remove(str5);
                    return null;
                }
            } catch (Exception e) {
                aa.d("IDErrorUtil", e.getMessage());
            }
        }
        aa.d("IDErrorUtil", "getErrorInfo RETURN NULL");
        return null;
    }

    /* compiled from: RequestControlUtil */
    private static class a {
        public long a;
        public int b;
        public String c;

        public a(long j, int i, String str) {
            this.a = j;
            this.b = i;
            this.c = str;
        }
    }
}
