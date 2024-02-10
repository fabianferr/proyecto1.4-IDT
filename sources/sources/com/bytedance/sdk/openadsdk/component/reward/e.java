package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.component.reward.d;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.s;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.b.a;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.ac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: FullScreenVideoLoadManager */
public class e {
    private static volatile e a;
    /* access modifiers changed from: private */
    public final Context b;
    private final AtomicBoolean c = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final List<b> d = Collections.synchronizedList(new ArrayList());
    /* access modifiers changed from: private */
    public h e;
    private final v.a f = new v.a() {
        public void a(Context context, Intent intent, boolean z, int i) {
            if (z) {
                if (e.this.e == null) {
                    e eVar = e.this;
                    h unused = eVar.e = new b("fsv net connect task", eVar.d);
                }
                com.bytedance.sdk.component.utils.h.a().post(e.this.e);
            }
        }
    };

    public static e a(Context context) {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e(context);
                }
            }
        }
        return a;
    }

    private e(Context context) {
        this.b = context == null ? o.a() : context.getApplicationContext();
        b();
    }

    public void a() {
        try {
            d.a(this.b).a();
        } catch (Throwable unused) {
        }
    }

    public void a(AdSlot adSlot) {
        if (adSlot != null && !TextUtils.isEmpty(adSlot.getCodeId()) && d.a(this.b).b(adSlot.getCodeId()) == null) {
            b(adSlot);
        }
    }

    public void a(AdSlot adSlot, com.bytedance.sdk.openadsdk.common.b bVar) {
        a(adSlot, false, bVar);
    }

    public void b(AdSlot adSlot) {
        if (adSlot == null || TextUtils.isEmpty(adSlot.getBidAdm())) {
            a(adSlot, true, (com.bytedance.sdk.openadsdk.common.b) null);
        }
    }

    private void a(final AdSlot adSlot, boolean z, com.bytedance.sdk.openadsdk.common.b bVar) {
        final ab a2 = ab.a();
        if (z) {
            a(adSlot, true, a2, bVar);
            return;
        }
        com.bytedance.sdk.openadsdk.core.model.a b2 = d.a(this.b).b(adSlot.getCodeId());
        if (b2 == null || !b2.d()) {
            a(adSlot, false, a2, bVar);
            return;
        }
        n nVar = new n(this.b, b2);
        if (!b2.f() && !t.k(b2.e())) {
            nVar.b();
        }
        if (bVar != null) {
            if (!b2.f() && (bVar instanceof PAGInterstitialAdLoadListener) && o.d().s() == 0) {
                ((PAGInterstitialAdLoadListener) bVar).onAdLoaded(nVar.a());
            }
            a aVar = new a(bVar, b2);
            for (int i = 0; i < b2.c().size(); i++) {
                a(b2.c().get(i), adSlot, aVar, a2, nVar, b2.f());
            }
        }
        for (int i2 = 0; i2 < b2.c().size(); i2++) {
            final q qVar = b2.c().get(i2);
            com.bytedance.sdk.openadsdk.core.video.b.a.a().a(qVar, (a.C0069a) new a.C0069a() {
                public void a(boolean z) {
                    if (t.k(qVar)) {
                        c.b(qVar, ac.c(adSlot.getDurationSlotType()), a2);
                    }
                }
            });
        }
        l.b("ScreenVideoLoadM", "get cache data success");
        l.b("bidding", "full video get cache data success");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
        if (com.bytedance.sdk.openadsdk.core.o.d().s() != 1) goto L_0x0014;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bytedance.sdk.openadsdk.core.model.q r14, com.bytedance.sdk.openadsdk.AdSlot r15, com.bytedance.sdk.openadsdk.component.reward.e.a r16, com.bytedance.sdk.openadsdk.utils.ab r17, com.bytedance.sdk.openadsdk.component.reward.n r18, boolean r19) {
        /*
            r13 = this;
            r2 = r14
            r9 = r16
            r10 = 0
            if (r9 == 0) goto L_0x0014
            r0 = 1
            if (r19 != 0) goto L_0x0015
            com.bytedance.sdk.openadsdk.core.settings.e r1 = com.bytedance.sdk.openadsdk.core.o.d()
            int r1 = r1.s()
            if (r1 != r0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r0 = 0
        L_0x0015:
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.t.k(r14)
            if (r1 != 0) goto L_0x0068
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.q.c((com.bytedance.sdk.openadsdk.core.model.q) r14)
            if (r1 == 0) goto L_0x0068
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 23
            if (r1 < r3) goto L_0x005a
            com.bykv.vk.openvk.component.video.api.c.b r8 = r14.K()
            int r0 = r14.aK()
            com.bykv.vk.openvk.component.video.api.a.b r0 = com.bytedance.sdk.openadsdk.CacheDirFactory.getICacheDir(r0)
            java.lang.String r0 = r0.a()
            com.bytedance.sdk.openadsdk.core.video.a.b r11 = com.bytedance.sdk.openadsdk.core.model.q.a((java.lang.String) r0, (com.bytedance.sdk.openadsdk.core.model.q) r14)
            java.lang.String r0 = "material_meta"
            r11.a(r0, r14)
            java.lang.String r0 = "ad_slot"
            r3 = r15
            r11.a(r0, r15)
            com.bytedance.sdk.openadsdk.component.reward.e$2 r12 = new com.bytedance.sdk.openadsdk.component.reward.e$2
            r0 = r12
            r1 = r13
            r2 = r14
            r4 = r17
            r5 = r16
            r6 = r19
            r7 = r18
            r0.<init>(r2, r3, r4, r5, r6, r7, r8)
            com.bytedance.sdk.openadsdk.core.video.d.a.a(r11, r12)
            goto L_0x0069
        L_0x005a:
            r3 = r15
            int r1 = r15.getDurationSlotType()
            java.lang.String r1 = com.bytedance.sdk.openadsdk.utils.ac.c((int) r1)
            r3 = r17
            com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r14, (java.lang.String) r1, (com.bytedance.sdk.openadsdk.utils.ab) r3)
        L_0x0068:
            r10 = r0
        L_0x0069:
            if (r10 == 0) goto L_0x0072
            com.bytedance.sdk.openadsdk.component.reward.f r0 = r18.a()
            r9.onAdLoaded(r0)
        L_0x0072:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.e.a(com.bytedance.sdk.openadsdk.core.model.q, com.bytedance.sdk.openadsdk.AdSlot, com.bytedance.sdk.openadsdk.component.reward.e$a, com.bytedance.sdk.openadsdk.utils.ab, com.bytedance.sdk.openadsdk.component.reward.n, boolean):void");
    }

    private void a(AdSlot adSlot, boolean z, ab abVar, com.bytedance.sdk.openadsdk.common.b bVar) {
        final long currentTimeMillis = System.currentTimeMillis();
        s sVar = new s();
        sVar.c = z ? 2 : 1;
        if (o.d().k(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f || adSlot.isExpressAd()) {
            sVar.f = 2;
        }
        final boolean z2 = z;
        final com.bytedance.sdk.openadsdk.common.b bVar2 = bVar;
        final AdSlot adSlot2 = adSlot;
        final ab abVar2 = abVar;
        o.c().a(adSlot, sVar, 8, (p.a) new p.a() {
            public void a(int i, String str) {
                com.bytedance.sdk.openadsdk.common.b bVar;
                if (!z2 && (bVar = bVar2) != null) {
                    bVar.onError(i, str);
                }
            }

            public void a(com.bytedance.sdk.openadsdk.core.model.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
                com.bytedance.sdk.openadsdk.common.b bVar2;
                if (aVar.c() != null && !aVar.c().isEmpty()) {
                    l.b("ScreenVideoLoadM", "get material data success isPreload=" + z2);
                    n nVar = new n(e.this.b, aVar);
                    if (!z2) {
                        if (!TextUtils.isEmpty(adSlot2.getBidAdm())) {
                            c.c(aVar.e(), "fullscreen_interstitial_ad", System.currentTimeMillis() - currentTimeMillis);
                        }
                        if (!aVar.f() && (bVar2 instanceof PAGInterstitialAdLoadListener) && o.d().s() == 0) {
                            ((PAGInterstitialAdLoadListener) bVar2).onAdLoaded(nVar.a());
                        }
                    }
                    a aVar2 = new a(bVar2, aVar);
                    for (int i = 0; i < aVar.c().size(); i++) {
                        e.this.a(aVar, aVar.c().get(i), nVar, adSlot2, z2, abVar2, aVar2, aVar.f());
                    }
                } else if (!z2 && (bVar2 = bVar2) != null) {
                    bVar2.onError(-3, g.a(-3));
                    bVar.a(-3);
                    com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bytedance.sdk.openadsdk.core.model.a r17, com.bytedance.sdk.openadsdk.core.model.q r18, com.bytedance.sdk.openadsdk.component.reward.n r19, com.bytedance.sdk.openadsdk.AdSlot r20, boolean r21, com.bytedance.sdk.openadsdk.utils.ab r22, com.bytedance.sdk.openadsdk.component.reward.e.a r23, boolean r24) {
        /*
            r16 = this;
            r11 = r16
            r10 = r18
            r6 = r20
            r12 = r23
            com.bytedance.sdk.openadsdk.core.video.b.a r7 = com.bytedance.sdk.openadsdk.core.video.b.a.a()
            com.bytedance.sdk.openadsdk.component.reward.e$4 r8 = new com.bytedance.sdk.openadsdk.component.reward.e$4
            r0 = r8
            r1 = r16
            r2 = r21
            r3 = r18
            r4 = r20
            r5 = r22
            r0.<init>(r2, r3, r4, r5)
            r7.a((com.bytedance.sdk.openadsdk.core.model.q) r10, (com.bytedance.sdk.openadsdk.core.video.b.a.C0069a) r8)
            r0 = 1
            if (r21 == 0) goto L_0x004f
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.t.k(r18)
            if (r1 != 0) goto L_0x004f
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.q.c((com.bytedance.sdk.openadsdk.core.model.q) r18)
            if (r1 == 0) goto L_0x004f
            com.bytedance.sdk.openadsdk.core.settings.e r1 = com.bytedance.sdk.openadsdk.core.o.d()
            java.lang.String r2 = r20.getCodeId()
            com.bytedance.sdk.openadsdk.core.settings.a r1 = r1.z(r2)
            int r1 = r1.d
            if (r1 != r0) goto L_0x004f
            android.content.Context r1 = r11.b
            boolean r1 = com.bytedance.sdk.component.utils.o.d(r1)
            if (r1 != 0) goto L_0x004f
            com.bytedance.sdk.openadsdk.component.reward.e$b r0 = new com.bytedance.sdk.openadsdk.component.reward.e$b
            r0.<init>(r10, r6)
            r11.a((com.bytedance.sdk.openadsdk.component.reward.e.b) r0)
            return
        L_0x004f:
            if (r12 == 0) goto L_0x005e
            if (r24 != 0) goto L_0x005f
            com.bytedance.sdk.openadsdk.core.settings.e r1 = com.bytedance.sdk.openadsdk.core.o.d()
            int r1 = r1.s()
            if (r1 != r0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r0 = 0
        L_0x005f:
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.t.k(r18)
            if (r1 != 0) goto L_0x00da
            boolean r1 = com.bytedance.sdk.openadsdk.core.model.q.c((com.bytedance.sdk.openadsdk.core.model.q) r18)
            if (r1 == 0) goto L_0x00da
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 23
            if (r1 < r2) goto L_0x00b7
            com.bykv.vk.openvk.component.video.api.c.b r14 = r18.K()
            if (r14 == 0) goto L_0x00e5
            int r0 = r18.aK()
            com.bykv.vk.openvk.component.video.api.a.b r0 = com.bytedance.sdk.openadsdk.CacheDirFactory.getICacheDir(r0)
            java.lang.String r0 = r0.a()
            com.bytedance.sdk.openadsdk.core.video.a.b r15 = com.bytedance.sdk.openadsdk.core.model.q.a((java.lang.String) r0, (com.bytedance.sdk.openadsdk.core.model.q) r10)
            java.lang.String r0 = "material_meta"
            r15.a(r0, r10)
            java.lang.String r0 = "ad_slot"
            r15.a(r0, r6)
            java.lang.String r0 = "ScreenVideoLoadM"
            java.lang.String r1 = "FullScreenLog: preload video "
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r0, (java.lang.String) r1)
            com.bytedance.sdk.openadsdk.component.reward.e$5 r9 = new com.bytedance.sdk.openadsdk.component.reward.e$5
            r0 = r9
            r1 = r16
            r2 = r21
            r3 = r18
            r4 = r20
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r19
            r10 = r9
            r9 = r17
            r13 = r10
            r10 = r14
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.bytedance.sdk.openadsdk.core.video.d.a.a(r15, r13)
            goto L_0x00d8
        L_0x00b7:
            android.content.Context r0 = r11.b
            com.bytedance.sdk.openadsdk.component.reward.d r13 = com.bytedance.sdk.openadsdk.component.reward.d.a((android.content.Context) r0)
            com.bytedance.sdk.openadsdk.component.reward.e$6 r14 = new com.bytedance.sdk.openadsdk.component.reward.e$6
            r0 = r14
            r1 = r16
            r2 = r21
            r3 = r19
            r4 = r18
            r5 = r20
            r6 = r22
            r7 = r23
            r8 = r24
            r9 = r17
            r0.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r13.a((com.bytedance.sdk.openadsdk.core.model.q) r10, (com.bytedance.sdk.openadsdk.component.reward.d.a<java.lang.Object>) r14)
        L_0x00d8:
            r13 = 0
            goto L_0x00e6
        L_0x00da:
            android.content.Context r1 = r11.b
            com.bytedance.sdk.openadsdk.component.reward.d r1 = com.bytedance.sdk.openadsdk.component.reward.d.a((android.content.Context) r1)
            r2 = r17
            r1.a((com.bytedance.sdk.openadsdk.AdSlot) r6, (com.bytedance.sdk.openadsdk.core.model.a) r2)
        L_0x00e5:
            r13 = r0
        L_0x00e6:
            if (r13 == 0) goto L_0x00ef
            com.bytedance.sdk.openadsdk.component.reward.f r0 = r19.a()
            r12.onAdLoaded(r0)
        L_0x00ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.e.a(com.bytedance.sdk.openadsdk.core.model.a, com.bytedance.sdk.openadsdk.core.model.q, com.bytedance.sdk.openadsdk.component.reward.n, com.bytedance.sdk.openadsdk.AdSlot, boolean, com.bytedance.sdk.openadsdk.utils.ab, com.bytedance.sdk.openadsdk.component.reward.e$a, boolean):void");
    }

    public void a(String str) {
        d.a(this.b).a(str);
    }

    private void a(b bVar) {
        if (bVar != null) {
            if (this.d.size() >= 1) {
                this.d.remove(0);
            }
            this.d.add(bVar);
        }
    }

    private void b() {
        if (!this.c.get()) {
            this.c.set(true);
            v.a(this.f, this.b);
        }
    }

    private void c() {
        if (this.c.get()) {
            this.c.set(false);
            try {
                v.a(this.f);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.e != null) {
            try {
                com.bytedance.sdk.component.utils.h.a().removeCallbacks(this.e);
            } catch (Exception unused) {
            }
            this.e = null;
        }
        c();
    }

    /* compiled from: FullScreenVideoLoadManager */
    private static class b extends h {
        q a;
        AdSlot b;
        com.bytedance.sdk.openadsdk.core.model.a c;

        b(q qVar, AdSlot adSlot) {
            super("Fullscreen Task");
            this.a = qVar;
            this.b = adSlot;
        }

        public void run() {
            if (this.a != null) {
                if (Build.VERSION.SDK_INT < 23) {
                    d.a(o.a()).a(this.a, (d.a<Object>) new d.a<Object>() {
                        public void a(boolean z, Object obj) {
                            if (z) {
                                d.a(o.a()).a(b.this.b, b.this.c);
                                l.c("ScreenVideoLoadM", "FullScreenLog: preload video success with net change ");
                                return;
                            }
                            l.c("ScreenVideoLoadM", "FullScreenLog: preload video success with net fail ");
                        }
                    });
                } else if (this.a.K() != null) {
                    com.bytedance.sdk.openadsdk.core.video.a.b a2 = q.a(CacheDirFactory.getICacheDir(this.a.aK()).a(), this.a);
                    a2.a("material_meta", this.a);
                    a2.a("ad_slot", this.b);
                    l.c("ScreenVideoLoadM", "FullScreenLog: preload video ");
                    com.bytedance.sdk.openadsdk.core.video.d.a.a(a2, new com.bykv.vk.openvk.component.video.api.e.b() {
                        public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i) {
                            d.a(o.a()).a(b.this.b, b.this.c);
                            l.c("ScreenVideoLoadM", "FullScreenLog: preload video success with net change ");
                        }

                        public void a(com.bykv.vk.openvk.component.video.api.c.c cVar, int i, String str) {
                            l.c("ScreenVideoLoadM", "FullScreenLog: preload video success with net fail with net change ");
                        }
                    });
                }
            }
        }
    }

    /* compiled from: FullScreenVideoLoadManager */
    private static class a implements PAGInterstitialAdLoadListener {
        private final com.bytedance.sdk.openadsdk.common.b a;
        private final AtomicBoolean b;
        private final AtomicInteger c;
        /* access modifiers changed from: private */
        public final com.bytedance.sdk.openadsdk.core.model.a d;

        private a(com.bytedance.sdk.openadsdk.common.b bVar, com.bytedance.sdk.openadsdk.core.model.a aVar) {
            this.b = new AtomicBoolean(false);
            this.a = bVar;
            this.d = aVar;
            this.c = new AtomicInteger(a());
        }

        private int a() {
            if (!this.d.d()) {
                return 0;
            }
            int i = 0;
            for (int i2 = 0; i2 < this.d.c().size(); i2++) {
                q qVar = this.d.c().get(i2);
                if (!(qVar == null || t.k(qVar) || qVar.K() == null)) {
                    i++;
                }
            }
            return i;
        }

        public void onError(int i, String str) {
            if (this.c.decrementAndGet() <= 0 && this.b.compareAndSet(false, true)) {
                this.a.onError(i, str);
                com.bytedance.sdk.openadsdk.j.b.a("choose_ad_load_error", false, (com.bytedance.sdk.openadsdk.j.a) new com.bytedance.sdk.openadsdk.j.a() {
                    public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("req_id", a.this.d.a());
                        return com.bytedance.sdk.openadsdk.j.a.b.b().a("choose_ad_load_error").b(jSONObject.toString());
                    }
                });
            }
        }

        /* renamed from: a */
        public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
            this.c.decrementAndGet();
            if ((this.a instanceof PAGInterstitialAdLoadListener) && this.b.compareAndSet(false, true)) {
                ((PAGInterstitialAdLoadListener) this.a).onAdLoaded(pAGInterstitialAd);
            }
        }
    }
}
