package com.bytedance.sdk.openadsdk.core.video.d;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.c.c;
import com.bykv.vk.openvk.component.video.api.e.a;
import com.bytedance.sdk.component.b.a.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.b.d.b.i;
import com.bytedance.sdk.openadsdk.b.d.b.j;
import com.bytedance.sdk.openadsdk.b.d.b.k;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import org.json.JSONObject;

/* compiled from: VideoPreloadFactory */
public class a {
    public static final com.bykv.vk.openvk.component.video.api.e.a a = new com.bykv.vk.openvk.component.video.a.a.b.a();

    public static void a(c cVar, a.C0036a aVar) {
        AdSlot adSlot;
        q qVar;
        if ((cVar.c() > 0 || cVar.j()) && cVar.o() != -2) {
            boolean z = true;
            if (cVar.o() != 1) {
                cVar.d(6000);
                cVar.e(6000);
                cVar.f(6000);
                boolean z2 = cVar.e("material_meta") != null && (cVar.e("material_meta") instanceof q);
                if (cVar.e("ad_slot") == null || !(cVar.e("ad_slot") instanceof AdSlot)) {
                    z = false;
                }
                if (!z2 || !z) {
                    qVar = null;
                    adSlot = null;
                } else {
                    qVar = (q) cVar.e("material_meta");
                    AdSlot adSlot2 = (AdSlot) cVar.e("ad_slot");
                    b(cVar, qVar, adSlot2);
                    adSlot = adSlot2;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                final a.C0036a aVar2 = aVar;
                final q qVar2 = qVar;
                final AdSlot adSlot3 = adSlot;
                final long j = elapsedRealtime;
                final c cVar2 = cVar;
                AnonymousClass1 r1 = new a.C0036a() {
                    public void a(c cVar, int i) {
                        a.C0036a aVar = aVar2;
                        if (aVar != null) {
                            aVar.a(cVar, i);
                        }
                        if (qVar2 != null && adSlot3 != null) {
                            a.b(cVar2, qVar2, adSlot3, SystemClock.elapsedRealtime() - j);
                        }
                    }

                    public void a(c cVar, int i, String str) {
                        a.C0036a aVar = aVar2;
                        if (aVar != null) {
                            aVar.a(cVar, i, str);
                        }
                        if (qVar2 != null && adSlot3 != null) {
                            a.b(cVar2, qVar2, adSlot3, SystemClock.elapsedRealtime() - j, i, str);
                        }
                    }

                    public void b(c cVar, int i) {
                        AdSlot adSlot;
                        a.C0036a aVar = aVar2;
                        if (aVar != null) {
                            aVar.a(cVar, i);
                        }
                        q qVar = qVar2;
                        if (!(qVar == null || (adSlot = adSlot3) == null)) {
                            a.c(cVar2, qVar, adSlot);
                        }
                        l.b("VideoPreloadUtils", "cancel: ", cVar2.n());
                    }
                };
                if (!a(cVar.m())) {
                    if (aVar != null) {
                        aVar.a(cVar, 404, "unexpected url: " + cVar.m());
                    }
                    b(cVar, qVar, adSlot, SystemClock.elapsedRealtime() - elapsedRealtime, -1, "video url is invalid");
                    return;
                } else if (Build.VERSION.SDK_INT >= 23) {
                    try {
                        a.a(o.a(), cVar, r1);
                        return;
                    } catch (Exception e) {
                        l.d("VideoPreloadUtils", e.getMessage());
                        return;
                    }
                } else {
                    com.bykv.vk.openvk.component.video.a.b.f.a.a().a(cVar);
                    return;
                }
            }
        }
        if (aVar != null) {
            aVar.a(cVar, 100);
        }
    }

    private static boolean a(c cVar) {
        return Build.VERSION.SDK_INT >= 23 || cVar.o() != 0;
    }

    private static void b(c cVar, q qVar, AdSlot adSlot) {
        if (a(cVar)) {
            com.bytedance.sdk.openadsdk.b.d.a.a.a((com.bytedance.sdk.openadsdk.b.d.b.a<k>) new com.bytedance.sdk.openadsdk.b.d.b.a(qVar, ac.c(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.b.d.a.a.a(qVar, (String) null, -1, cVar), new k(cVar.m(), cVar.j() ? cVar.i() : (long) cVar.c())));
        }
    }

    /* access modifiers changed from: private */
    public static void b(c cVar, q qVar, AdSlot adSlot, long j, int i, String str) {
        if (a(cVar)) {
            String c = ac.c(adSlot.getDurationSlotType());
            JSONObject a2 = com.bytedance.sdk.openadsdk.b.d.a.a.a(qVar, (String) null, -1, cVar);
            j jVar = new j();
            jVar.a(cVar.m());
            jVar.a((long) cVar.c());
            jVar.b(j);
            jVar.a(i);
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jVar.b(str);
            jVar.c("");
            com.bytedance.sdk.openadsdk.b.d.a.a.c((com.bytedance.sdk.openadsdk.b.d.b.a<j>) new com.bytedance.sdk.openadsdk.b.d.b.a(qVar, c, a2, jVar));
        }
    }

    /* access modifiers changed from: private */
    public static void b(c cVar, q qVar, AdSlot adSlot, long j) {
        if (a(cVar)) {
            String c = ac.c(adSlot.getDurationSlotType());
            JSONObject a2 = com.bytedance.sdk.openadsdk.b.d.a.a.a(qVar, (String) null, -1, cVar);
            com.bytedance.sdk.openadsdk.b.d.b.l lVar = new com.bytedance.sdk.openadsdk.b.d.b.l();
            lVar.a(cVar.m());
            lVar.a((long) cVar.c());
            lVar.b(j);
            if (cVar.s() == 1) {
                lVar.c(1);
            } else {
                lVar.c(0);
            }
            com.bytedance.sdk.openadsdk.b.d.a.a.b((com.bytedance.sdk.openadsdk.b.d.b.a<com.bytedance.sdk.openadsdk.b.d.b.l>) new com.bytedance.sdk.openadsdk.b.d.b.a(qVar, c, a2, lVar));
        }
    }

    /* access modifiers changed from: private */
    public static void c(c cVar, q qVar, AdSlot adSlot) {
        if (a(cVar)) {
            com.bytedance.sdk.openadsdk.b.d.a.a.d((com.bytedance.sdk.openadsdk.b.d.b.a<i>) new com.bytedance.sdk.openadsdk.b.d.b.a(qVar, ac.c(adSlot.getDurationSlotType()), com.bytedance.sdk.openadsdk.b.d.a.a.a(qVar, (String) null, -1, cVar), new i(cVar.m(), (long) cVar.c())));
        }
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.regionMatches(true, 0, "ws:", 0, 3)) {
            str = "http:" + str.substring(3);
        } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
            str = "https:" + str.substring(4);
        }
        if (g.c(str) != null) {
            return true;
        }
        return false;
    }
}
