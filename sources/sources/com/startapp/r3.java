package com.startapp;

import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.common.utils.Pair;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.Map;

/* compiled from: Sta */
public class r3 extends w0 {
    public final i3 j0;
    public String k0;
    public String l0;
    public String m0;
    public String n0;
    public String o0;
    public String p0;
    public String q0;
    public Map<String, String> r0;

    public r3(i3 i3Var) {
        super(8);
        this.j0 = i3Var;
    }

    public void a(r6 r6Var) throws SDKException {
        super.a(r6Var);
        i3 i3Var = this.j0;
        Long l = i3Var.h;
        String l2 = l != null ? l.toString() : a.a();
        r6Var.a(a.b, (Object) l2, true, true);
        r6Var.a(a.c, (Object) a.a(l2), true, true);
        r6Var.a("category", (Object) i3Var.a.a, true, true);
        r6Var.a("value", (Object) i3Var.d, false, true);
        r6Var.a("d", (Object) i3Var.g, false, true);
        r6Var.a("appActivity", (Object) i3Var.i, false, true);
        r6Var.a("details", (Object) i3Var.e, false, true);
        r6Var.a("details_json", i3Var.f, false, true);
        r6Var.a("isService", (Object) Boolean.valueOf(i3Var.j), false, true);
        r6Var.a(AdUnitActivity.EXTRA_ORIENTATION, (Object) this.k0, false, true);
        r6Var.a("usedRam", (Object) this.l0, false, true);
        r6Var.a("freeRam", (Object) this.m0, false, true);
        r6Var.a("sessionTime", (Object) null, false, true);
        r6Var.a("cellScanRes", (Object) this.n0, false, true);
        r6Var.a("sens", (Object) this.o0, false, true);
        r6Var.a("bt", (Object) this.p0, false, true);
        r6Var.a("packagingType", (Object) this.q0, false, true);
        Pair<String, String> a = SimpleTokenUtils.a();
        Pair<String, String> b = SimpleTokenUtils.b();
        r6Var.a((String) a.first, (Object) a.second, false, true);
        r6Var.a((String) b.first, (Object) b.second, false, true);
        Map<String, String> map = this.r0;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                r6Var.a((String) next.getKey(), next.getValue(), false, true);
            }
        }
        r6Var.a("rcd", (Object) null, false, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032 A[Catch:{ all -> 0x005f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(android.content.Context r10, com.startapp.sdk.adsbase.model.AdPreferences r11) {
        /*
            r9 = this;
            super.b(r10, r11)
            android.content.res.Resources r11 = r10.getResources()
            r0 = 1
            if (r11 == 0) goto L_0x001d
            android.content.res.Configuration r11 = r11.getConfiguration()
            if (r11 == 0) goto L_0x001d
            int r11 = r11.orientation
            r1 = 2
            if (r11 != r1) goto L_0x0018
            java.lang.String r11 = "landscape"
            goto L_0x0020
        L_0x0018:
            if (r11 != r0) goto L_0x001d
            java.lang.String r11 = "portrait"
            goto L_0x0020
        L_0x001d:
            java.lang.String r11 = "undefined"
        L_0x0020:
            r9.k0 = r11
            r11 = 0
            java.lang.String[] r11 = new java.lang.String[]{r11, r11}
            r1 = 0
            java.lang.String r2 = "activity"
            java.lang.Object r10 = r10.getSystemService(r2)     // Catch:{ all -> 0x005f }
            android.app.ActivityManager r10 = (android.app.ActivityManager) r10     // Catch:{ all -> 0x005f }
            if (r10 == 0) goto L_0x0074
            android.app.ActivityManager$MemoryInfo r2 = new android.app.ActivityManager$MemoryInfo     // Catch:{ all -> 0x005f }
            r2.<init>()     // Catch:{ all -> 0x005f }
            r10.getMemoryInfo(r2)     // Catch:{ all -> 0x005f }
            long r3 = r2.availMem     // Catch:{ all -> 0x005f }
            r5 = 1048576(0x100000, double:5.180654E-318)
            long r3 = r3 / r5
            java.lang.String r10 = java.lang.Long.toString(r3)     // Catch:{ all -> 0x005f }
            r11[r1] = r10     // Catch:{ all -> 0x005f }
            int r10 = com.startapp.a0.a     // Catch:{ all -> 0x005f }
            long r3 = r2.totalMem     // Catch:{ all -> 0x005f }
            java.lang.Long r10 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x005f }
            if (r10 == 0) goto L_0x0074
            long r3 = r10.longValue()     // Catch:{ all -> 0x005f }
            long r7 = r2.availMem     // Catch:{ all -> 0x005f }
            long r3 = r3 - r7
            long r3 = r3 / r5
            java.lang.String r10 = java.lang.Long.toString(r3)     // Catch:{ all -> 0x005f }
            r11[r0] = r10     // Catch:{ all -> 0x005f }
            goto L_0x0074
        L_0x005f:
            r10 = move-exception
            java.lang.Class<java.lang.SecurityException> r2 = java.lang.SecurityException.class
            boolean r2 = com.startapp.k9.a((java.lang.Throwable) r10, (java.lang.Class<? extends java.lang.Throwable>) r2)
            if (r2 != 0) goto L_0x0074
            java.lang.Class<android.os.RemoteException> r2 = android.os.RemoteException.class
            boolean r2 = com.startapp.k9.a((java.lang.Throwable) r10, (java.lang.Class<? extends java.lang.Throwable>) r2)
            if (r2 == 0) goto L_0x0071
            goto L_0x0074
        L_0x0071:
            com.startapp.i3.a((java.lang.Throwable) r10)
        L_0x0074:
            r10 = r11[r1]
            r9.m0 = r10
            r10 = r11[r0]
            r9.l0 = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.r3.b(android.content.Context, com.startapp.sdk.adsbase.model.AdPreferences):void");
    }

    public String toString() {
        return this.j0.toString();
    }
}
