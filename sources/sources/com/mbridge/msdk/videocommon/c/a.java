package com.mbridge.msdk.videocommon.c;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.cast.MediaTrack;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import org.json.JSONObject;

/* compiled from: RewardSettingController */
public class a {
    /* access modifiers changed from: private */
    public static final String a = "com.mbridge.msdk.videocommon.c.a";

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005b A[SYNTHETIC, Splitter:B:10:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f A[Catch:{ all -> 0x006f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r5, final java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            java.lang.String r0 = "reward_"
            com.mbridge.msdk.foundation.same.net.h.d r1 = new com.mbridge.msdk.foundation.same.net.h.d
            r1.<init>()
            java.lang.String r2 = "app_id"
            r1.a(r2, r6)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r6)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            java.lang.String r7 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r7)
            java.lang.String r2 = "sign"
            r1.a(r2, r7)
            com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ all -> 0x006f }
            com.mbridge.msdk.videocommon.d.a r7 = com.mbridge.msdk.videocommon.d.b.a     // Catch:{ all -> 0x006f }
            if (r7 != 0) goto L_0x0052
            com.mbridge.msdk.foundation.a.a.a r7 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ all -> 0x006f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            r2.<init>(r0)     // Catch:{ all -> 0x006f }
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x006f }
            java.lang.String r0 = r0.h()     // Catch:{ all -> 0x006f }
            r2.append(r0)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x006f }
            java.lang.String r7 = r7.b(r0)     // Catch:{ all -> 0x006f }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0052
            com.mbridge.msdk.videocommon.d.a r7 = com.mbridge.msdk.videocommon.d.a.a((java.lang.String) r7)     // Catch:{ all -> 0x006f }
            goto L_0x0054
        L_0x0052:
            com.mbridge.msdk.videocommon.d.a r7 = com.mbridge.msdk.videocommon.d.b.a     // Catch:{ all -> 0x006f }
        L_0x0054:
            java.lang.String r0 = ""
            java.lang.String r2 = "vtag"
            if (r7 != 0) goto L_0x005f
            r1.a(r2, r0)     // Catch:{ all -> 0x006f }
            goto L_0x0079
        L_0x005f:
            java.lang.String r7 = r7.a()     // Catch:{ all -> 0x006f }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x006f }
            if (r3 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r0 = r7
        L_0x006b:
            r1.a(r2, r0)     // Catch:{ all -> 0x006f }
            goto L_0x0079
        L_0x006f:
            r7 = move-exception
            java.lang.String r0 = a
            java.lang.String r7 = r7.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r0, r7)
        L_0x0079:
            com.mbridge.msdk.videocommon.c.a$1 r7 = new com.mbridge.msdk.videocommon.c.a$1
            r7.<init>(r6)
            com.mbridge.msdk.videocommon.c.b r6 = new com.mbridge.msdk.videocommon.c.b
            r6.<init>(r5)
            com.mbridge.msdk.foundation.same.net.g.d r5 = com.mbridge.msdk.foundation.same.net.g.d.a()
            java.lang.String r5 = r5.z
            r0 = 1
            r6.get(r0, r5, r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.c.a.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public final void a(Context context, final String str, String str2, String str3, final c cVar) {
        d dVar = new d();
        dVar.a("app_id", str);
        dVar.a(MediaTrack.ROLE_SIGN, SameMD5.getMD5(str + str2));
        dVar.a("unit_ids", "[" + str3 + "]");
        try {
            c c = b.a().c(str, str3);
            String str4 = "";
            if (c == null) {
                dVar.a("vtag", str4);
            } else {
                String j = c.j();
                if (!TextUtils.isEmpty(j)) {
                    str4 = j;
                }
                dVar.a("vtag", str4);
            }
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
        AnonymousClass2 r7 = new com.mbridge.msdk.foundation.same.net.h.c() {
            public final void a(final JSONObject jSONObject) {
                try {
                    b.a().a(this.unitId);
                } catch (Exception e) {
                    aa.d(a.a, e.getMessage());
                } catch (Throwable th) {
                    aa.d(a.a, th.getMessage());
                    return;
                }
                if (af.a(jSONObject)) {
                    if (jSONObject.optInt("vtag_status", 0) == 1) {
                        b.a();
                        String str = str;
                        String str2 = this.unitId;
                        String b2 = com.mbridge.msdk.foundation.a.a.a.a().b("reward_" + str + "_" + str2);
                        if (!TextUtils.isEmpty(b2)) {
                            try {
                                jSONObject = f.a().a(new JSONObject(b2), jSONObject);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (b.c(jSONObject.toString())) {
                        jSONObject.put("current_time", System.currentTimeMillis());
                        AnonymousClass1 r0 = new Runnable() {
                            public final void run() {
                                b.a().a(str, AnonymousClass2.this.unitId, jSONObject.toString());
                            }
                        };
                        com.mbridge.msdk.foundation.controller.c.a();
                        com.mbridge.msdk.foundation.same.f.b.a().execute(r0);
                        c cVar = cVar;
                        if (cVar != null) {
                            cVar.a("request success");
                        }
                    } else {
                        c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.b("data error");
                        }
                    }
                } else {
                    b a2 = b.a();
                    String str3 = str;
                    String str4 = this.unitId;
                    try {
                        String b3 = com.mbridge.msdk.foundation.a.a.a.a().b("reward_" + str3 + "_" + str4);
                        if (!TextUtils.isEmpty(b3)) {
                            JSONObject jSONObject2 = new JSONObject(b3);
                            jSONObject2.put("current_time", System.currentTimeMillis());
                            a2.a(str3, str4, jSONObject2.toString());
                        }
                    } catch (Throwable th2) {
                        aa.d("RewardSettingManager", th2.getMessage());
                    }
                }
                a.a(a.this, 1, 3, "");
            }

            public final void a(String str) {
                try {
                    b.a().a(this.unitId);
                } catch (Exception e) {
                    aa.d(a.a, e.getMessage());
                }
                if (!TextUtils.isEmpty(str)) {
                    c cVar = cVar;
                    if (cVar != null) {
                        cVar.b(str);
                    }
                } else {
                    c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.b("request error");
                    }
                }
                a.a(a.this, 2, 3, str);
            }
        };
        r7.setUnitId(str3);
        new b(context).get(1, com.mbridge.msdk.foundation.same.net.g.d.a().z, dVar, r7);
    }

    static /* synthetic */ void a(a aVar, int i, int i2, String str) {
        try {
            new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(i, com.mbridge.msdk.foundation.same.net.g.d.a().q, i2, str, com.mbridge.msdk.foundation.same.net.g.d.a().p ? com.mbridge.msdk.foundation.same.net.g.d.a().E : com.mbridge.msdk.foundation.same.net.g.d.a().z);
        } catch (Throwable th) {
            aa.d(a, th.getMessage());
        }
    }
}
