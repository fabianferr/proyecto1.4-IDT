package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import com.bykv.vk.openvk.component.video.api.e.a;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.common.b;
import com.bytedance.sdk.openadsdk.core.bannerexpress.c;
import com.bytedance.sdk.openadsdk.core.g;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.s;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: ExpressAdLoadManager */
public class e {
    private static final Set<e> j = Collections.synchronizedSet(new HashSet());
    private AdSlot a;
    private final p b = o.c();
    private final Context c;
    private PAGBannerAdLoadListener d;
    private final AtomicBoolean e = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public List<q> f;
    /* access modifiers changed from: private */
    public List<q> g;
    /* access modifiers changed from: private */
    public a h;
    private int i = 5;
    private final ScheduledFuture<?> k = null;
    private ScheduledFuture<?> l = null;
    private ScheduledFuture<?> m = null;
    /* access modifiers changed from: private */
    public final ab n = ab.b();

    /* compiled from: ExpressAdLoadManager */
    public interface a {
        void a();

        void a(List<q> list);
    }

    private e(Context context) {
        if (context != null) {
            this.c = context.getApplicationContext();
        } else {
            this.c = o.a();
        }
        j.add(this);
    }

    public static e a(Context context) {
        return new e(context);
    }

    public void a(AdSlot adSlot, int i2, b bVar, int i3) {
        a(adSlot, i2, bVar, (a) null, i3);
    }

    public void a(AdSlot adSlot, int i2, b bVar, a aVar, int i3) {
        this.n.d();
        if (this.e.get()) {
            l.e("ExpressAdLoadManager", "express ad is loading...");
            return;
        }
        this.i = i2;
        this.e.set(true);
        this.a = adSlot;
        if (bVar instanceof PAGBannerAdLoadListener) {
            this.d = (PAGBannerAdLoadListener) bVar;
        }
        this.h = aVar;
        a(adSlot, bVar);
    }

    private void a(final AdSlot adSlot, b bVar) {
        if (adSlot != null) {
            s sVar = new s();
            sVar.f = 2;
            this.b.a(adSlot, sVar, this.i, (p.a) new p.a() {
                public void a(int i, String str) {
                    e.this.a(i, str);
                }

                public void a(com.bytedance.sdk.openadsdk.core.model.a aVar, com.bytedance.sdk.openadsdk.core.model.b bVar) {
                    if (aVar.c() == null || aVar.c().isEmpty()) {
                        e.this.a(-3, g.a(-3));
                        bVar.a(-3);
                        com.bytedance.sdk.openadsdk.core.model.b.a(bVar);
                        return;
                    }
                    List unused = e.this.f = aVar.c();
                    List unused2 = e.this.g = aVar.c();
                    e.this.a(adSlot);
                    e eVar = e.this;
                    eVar.a(eVar.n);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        List<q> list = this.f;
        if (list != null) {
            for (q next : list) {
                if (!(!q.c(next) || next.K() == null || next.K().k() == null)) {
                    if (o.d().e(String.valueOf(next.aZ())) && o.d().X()) {
                        com.bytedance.sdk.openadsdk.core.video.a.b a2 = q.a(CacheDirFactory.getICacheDir(next.aK()).c(), next);
                        a2.a("material_meta", next);
                        a2.a("ad_slot", adSlot);
                        com.bytedance.sdk.openadsdk.core.video.d.a.a(a2, (a.C0036a) null);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(final ab abVar) {
        if (this.e.getAndSet(false)) {
            aa.a((Runnable) new Runnable() {
                public void run() {
                    if (e.this.g != null && e.this.g.size() > 0) {
                        e.this.b(abVar);
                        if (e.this.h != null) {
                            e.this.h.a(e.this.g);
                        }
                    } else if (e.this.h != null) {
                        e.this.h.a();
                    }
                    e.this.a();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x000b A[LOOP:0: B:3:0x000b->B:6:0x001b, LOOP_START, PHI: r1 
      PHI: (r1v1 com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd) = (r1v0 com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd), (r1v6 com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd) binds: [B:2:0x0004, B:6:0x001b] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(com.bytedance.sdk.openadsdk.utils.ab r6) {
        /*
            r5 = this;
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener r0 = r5.d
            if (r0 == 0) goto L_0x006d
            java.util.List<com.bytedance.sdk.openadsdk.core.model.q> r0 = r5.g
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x000b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001d
            java.lang.Object r1 = r0.next()
            com.bytedance.sdk.openadsdk.core.model.q r1 = (com.bytedance.sdk.openadsdk.core.model.q) r1
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd r1 = r5.a((com.bytedance.sdk.openadsdk.core.model.q) r1)
            if (r1 == 0) goto L_0x000b
        L_0x001d:
            if (r1 == 0) goto L_0x005f
            com.bytedance.sdk.openadsdk.AdSlot r0 = r5.a
            java.lang.String r0 = r0.getBidAdm()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r2 = 0
            if (r0 != 0) goto L_0x0044
            com.bytedance.sdk.openadsdk.utils.ab r6 = r5.n
            long r3 = r6.c()
            java.util.List<com.bytedance.sdk.openadsdk.core.model.q> r6 = r5.g
            java.lang.Object r6 = r6.get(r2)
            com.bytedance.sdk.openadsdk.core.model.q r6 = (com.bytedance.sdk.openadsdk.core.model.q) r6
            int r0 = r5.i
            java.lang.String r0 = com.bytedance.sdk.openadsdk.utils.ac.c((int) r0)
            com.bytedance.sdk.openadsdk.b.c.c(r6, r0, r3)
            goto L_0x0059
        L_0x0044:
            java.util.List<com.bytedance.sdk.openadsdk.core.model.q> r0 = r5.g
            java.lang.Object r0 = r0.get(r2)
            com.bytedance.sdk.openadsdk.core.model.q r0 = (com.bytedance.sdk.openadsdk.core.model.q) r0
            com.bytedance.sdk.openadsdk.AdSlot r2 = r5.a
            int r2 = r2.getDurationSlotType()
            java.lang.String r2 = com.bytedance.sdk.openadsdk.utils.ac.c((int) r2)
            com.bytedance.sdk.openadsdk.b.c.b((com.bytedance.sdk.openadsdk.core.model.q) r0, (java.lang.String) r2, (com.bytedance.sdk.openadsdk.utils.ab) r6)
        L_0x0059:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener r6 = r5.d
            r6.onAdLoaded(r1)
            goto L_0x006d
        L_0x005f:
            com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener r6 = r5.d
            r0 = 103(0x67, float:1.44E-43)
            java.lang.String r1 = com.bytedance.sdk.openadsdk.core.g.a(r0)
            r6.onError(r0, r1)
            r5.a((int) r0)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.nativeexpress.e.b(com.bytedance.sdk.openadsdk.utils.ab):void");
    }

    private void a(int i2) {
        List<q> list = this.f;
        com.bytedance.sdk.openadsdk.j.a.b e2 = com.bytedance.sdk.openadsdk.j.a.b.b().a(this.i).c(this.a.getCodeId()).e((list == null || list.size() <= 0) ? "" : this.f.get(0).bc());
        e2.b(i2).f(g.a(i2));
        com.bytedance.sdk.openadsdk.j.b.a().a(e2);
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str) {
        if (this.e.getAndSet(false)) {
            PAGBannerAdLoadListener pAGBannerAdLoadListener = this.d;
            if (pAGBannerAdLoadListener != null) {
                pAGBannerAdLoadListener.onError(i2, str);
            }
            a aVar = this.h;
            if (aVar != null) {
                aVar.a();
            }
            a();
        }
    }

    private PAGBannerAd a(q qVar) {
        if (this.i != 1) {
            return null;
        }
        if (qVar.K() != null) {
            return new c(this.c, qVar, this.a);
        }
        return new com.bytedance.sdk.openadsdk.core.bannerexpress.a(this.c, qVar, this.a);
    }

    /* access modifiers changed from: private */
    public void a() {
        List<q> list = this.f;
        if (list != null) {
            list.clear();
        }
        List<q> list2 = this.g;
        if (list2 != null) {
            list2.clear();
        }
        a(true);
        b(true);
        c(true);
        b();
    }

    private void a(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.l;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                boolean cancel = this.l.cancel(z);
                l.e("ExpressAdLoadManager", "CheckValidFutureTask-->cancel......success=" + cancel);
            }
        } catch (Throwable unused) {
        }
    }

    private void b(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.m;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                boolean cancel = this.m.cancel(z);
                l.b("ExpressAdLoadManager", "CheckValidDoneFutureTask-->cancel.....success=" + cancel);
            }
        } catch (Throwable unused) {
        }
    }

    private void c(boolean z) {
        try {
            ScheduledFuture<?> scheduledFuture = this.k;
            if (scheduledFuture != null && !scheduledFuture.isCancelled()) {
                boolean cancel = this.k.cancel(z);
                l.e("ExpressAdLoadManager", "TimeOutFutureTask-->cancel......success=" + cancel);
            }
        } catch (Throwable unused) {
        }
    }

    private void b() {
        j.remove(this);
    }
}
