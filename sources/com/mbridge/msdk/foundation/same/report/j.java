package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.e.m;
import org.json.JSONObject;

/* compiled from: EventLibraryReport */
public final class j implements o {
    private m a;

    /* JADX WARNING: Can't wrap try/catch for region: R(10:11|12|(1:14)|15|16|17|18|(1:24)|25|(2:27|37)(1:35)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a0 A[Catch:{ Exception -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r7, com.mbridge.msdk.foundation.same.report.b.C0142b r8, com.mbridge.msdk.foundation.same.report.b r9, com.mbridge.msdk.foundation.same.net.h.d r10) throws java.lang.Exception {
        /*
            r6 = this;
            com.mbridge.msdk.e.m r7 = r6.a
            if (r7 != 0) goto L_0x000e
            com.mbridge.msdk.foundation.same.report.m r7 = com.mbridge.msdk.foundation.same.report.m.a()
            com.mbridge.msdk.e.m r7 = r7.d()
            r6.a = r7
        L_0x000e:
            com.mbridge.msdk.e.m r7 = r6.a
            if (r7 != 0) goto L_0x0013
            return
        L_0x0013:
            java.lang.String r7 = "EventLibraryReport"
            r10 = 0
            if (r9 != 0) goto L_0x0026
            java.lang.String r9 = "reportEvent is null, report failed"
            com.mbridge.msdk.foundation.tools.aa.d(r7, r9)
            if (r8 == 0) goto L_0x0025
            r7 = 0
            java.lang.String r9 = "reportEvent is null"
            r8.a(r7, r10, r9)
        L_0x0025:
            return
        L_0x0026:
            java.lang.String r0 = r9.p()     // Catch:{ Exception -> 0x00a4 }
            com.mbridge.msdk.e.e r1 = new com.mbridge.msdk.e.e     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r2 = r9.i()     // Catch:{ Exception -> 0x00a4 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00a4 }
            org.json.JSONObject r0 = a(r0)     // Catch:{ Exception -> 0x00a4 }
            if (r0 != 0) goto L_0x003e
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a4 }
            r0.<init>()     // Catch:{ Exception -> 0x00a4 }
        L_0x003e:
            com.mbridge.msdk.e.m r2 = r6.a     // Catch:{ Exception -> 0x0060 }
            long[] r2 = r2.f()     // Catch:{ Exception -> 0x0060 }
            java.lang.String r3 = "track_time"
            r4 = r2[r10]     // Catch:{ Exception -> 0x0060 }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r3 = "track_count"
            r4 = 1
            r4 = r2[r4]     // Catch:{ Exception -> 0x0060 }
            r0.put(r3, r4)     // Catch:{ Exception -> 0x0060 }
            java.lang.String r2 = "session_id"
            com.mbridge.msdk.e.m r3 = r6.a     // Catch:{ Exception -> 0x0060 }
            java.lang.String r3 = r3.b()     // Catch:{ Exception -> 0x0060 }
            r0.put(r2, r3)     // Catch:{ Exception -> 0x0060 }
        L_0x0060:
            java.lang.String r2 = r9.g()     // Catch:{ Exception -> 0x00a4 }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x00a4 }
            if (r3 != 0) goto L_0x0090
            com.mbridge.msdk.c.f r3 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x00a4 }
            com.mbridge.msdk.foundation.controller.b r4 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r4 = r4.h()     // Catch:{ Exception -> 0x00a4 }
            com.mbridge.msdk.c.h r2 = r3.e(r4, r2)     // Catch:{ Exception -> 0x00a4 }
            if (r2 == 0) goto L_0x0090
            java.lang.String r3 = r2.a()     // Catch:{ Exception -> 0x00a4 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x00a4 }
            if (r3 != 0) goto L_0x0090
            java.lang.String r3 = "u_stid"
            java.lang.String r2 = r2.a()     // Catch:{ Exception -> 0x00a4 }
            r0.put(r3, r2)     // Catch:{ Exception -> 0x00a4 }
        L_0x0090:
            r1.a((org.json.JSONObject) r0)     // Catch:{ Exception -> 0x00a4 }
            r1.b((int) r10)     // Catch:{ Exception -> 0x00a4 }
            r1.a((int) r10)     // Catch:{ Exception -> 0x00a4 }
            com.mbridge.msdk.e.m r0 = r6.a     // Catch:{ Exception -> 0x00a4 }
            r0.a((com.mbridge.msdk.e.e) r1)     // Catch:{ Exception -> 0x00a4 }
            if (r8 == 0) goto L_0x00c3
            r8.a(r9)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00c3
        L_0x00a4:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "report failed, exception: "
            r1.<init>(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.mbridge.msdk.foundation.tools.aa.d(r7, r1)
            if (r8 == 0) goto L_0x00c3
            java.lang.String r7 = r0.getMessage()
            r8.a(r9, r10, r7)
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.report.j.a(android.content.Context, com.mbridge.msdk.foundation.same.report.b$b, com.mbridge.msdk.foundation.same.report.b, com.mbridge.msdk.foundation.same.net.h.d):void");
    }

    private static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                if (split2.length == 2) {
                    jSONObject.put(split2[0], split2[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
