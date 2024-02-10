package com.startapp.sdk.adsbase.cache;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.startapp.h0;
import com.startapp.i1;
import com.startapp.i3;
import com.startapp.k;
import com.startapp.k1;
import com.startapp.k9;
import com.startapp.p0;
import com.startapp.sdk.ads.interstitials.OverlayAd;
import com.startapp.sdk.ads.interstitials.ReturnAd;
import com.startapp.sdk.ads.offerWall.offerWallHtml.OfferWallAd;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.ads.splash.SplashAd;
import com.startapp.sdk.ads.video.VideoEnabledAd;
import com.startapp.sdk.adsbase.ActivityExtra;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.d;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.components.ComponentLocator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Sta */
public class h {
    public final AdPreferences.Placement a;
    public Context b;
    public ActivityExtra c;
    public AdPreferences d;
    public d e = null;
    public AtomicBoolean f = new AtomicBoolean(false);
    public long g;
    public String h = null;
    public boolean i = false;
    public k1 j = null;
    public i1 k = null;
    public final Map<AdEventListener, List<StartAppAd>> l = new ConcurrentHashMap();
    public int m;
    public boolean n = true;
    public Long o;
    public b p;

    /* compiled from: Sta */
    public class a implements AdEventListener {
        public boolean a = false;
        public boolean b = false;

        public a() {
        }

        public void onFailedToReceiveAd(Ad ad) {
            List<StartAppAd> a2;
            ConcurrentHashMap concurrentHashMap;
            ConcurrentHashMap concurrentHashMap2 = null;
            if (!this.b) {
                synchronized (h.this.l) {
                    concurrentHashMap = new ConcurrentHashMap(h.this.l);
                    h hVar = h.this;
                    hVar.e = null;
                    hVar.l.clear();
                }
                concurrentHashMap2 = concurrentHashMap;
            }
            if (concurrentHashMap2 != null) {
                for (AdEventListener adEventListener : concurrentHashMap2.keySet()) {
                    if (!(adEventListener == null || (a2 = h.this.a(concurrentHashMap2, adEventListener)) == null)) {
                        for (StartAppAd next : a2) {
                            if (ad != null) {
                                next.setErrorMessage(ad.getErrorMessage());
                            }
                            k.a(h.this.b, adEventListener, next, true);
                        }
                    }
                }
            }
            this.b = true;
            h.this.k.d();
            h.this.j.e();
            h.this.f.set(false);
        }

        public void onReceiveAd(Ad ad) {
            d dVar = h.this.e;
            boolean z = dVar != null && dVar.a();
            if (!this.a && !z) {
                this.a = true;
                synchronized (h.this.l) {
                    for (AdEventListener next : h.this.l.keySet()) {
                        if (next != null) {
                            h hVar = h.this;
                            List<StartAppAd> a2 = hVar.a(hVar.l, next);
                            if (a2 != null) {
                                for (StartAppAd errorMessage : a2) {
                                    errorMessage.setErrorMessage(ad.getErrorMessage());
                                    k.b(h.this.b, next, ad, true);
                                }
                            }
                        }
                    }
                    h.this.l.clear();
                }
            }
            h.this.j.d();
            h.this.k.f();
            h.this.f.set(false);
        }
    }

    /* compiled from: Sta */
    public interface b {
    }

    public h(Context context, AdPreferences.Placement placement, AdPreferences adPreferences) {
        this.a = placement;
        this.d = adPreferences;
        a(context);
        a();
    }

    public final void a(Context context) {
        if (context instanceof Activity) {
            Context a2 = h0.a(context);
            if (a2 == null) {
                a2 = context;
            }
            this.b = a2;
            this.c = new ActivityExtra((Activity) context);
            return;
        }
        this.b = context;
        this.c = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r6 = this;
            boolean r0 = r6.c()
            if (r0 == 0) goto L_0x006c
            android.content.Context r0 = r6.b
            com.startapp.sdk.adsbase.d r1 = r6.e
            com.startapp.sdk.adsbase.Ad r1 = (com.startapp.sdk.adsbase.Ad) r1
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0049
            java.util.HashSet r4 = new java.util.HashSet
            r4.<init>()
            boolean r5 = r1 instanceof com.startapp.sdk.adsbase.HtmlAd
            if (r5 == 0) goto L_0x0031
            com.startapp.sdk.adsbase.HtmlAd r1 = (com.startapp.sdk.adsbase.HtmlAd) r1
            java.lang.String r1 = r1.k()
            java.util.List r1 = com.startapp.d0.a(r1, r3)
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.lang.Boolean r0 = com.startapp.d0.a((android.content.Context) r0, (java.util.List<com.startapp.sdk.adsbase.apppresence.AppPresenceDetails>) r1, (int) r3, (java.util.Set<java.lang.String>) r4, (java.util.List<com.startapp.sdk.adsbase.apppresence.AppPresenceDetails>) r5)
            boolean r0 = r0.booleanValue()
            goto L_0x004a
        L_0x0031:
            boolean r5 = r1 instanceof com.startapp.sdk.adsbase.JsonAd
            if (r5 == 0) goto L_0x0049
            com.startapp.sdk.adsbase.JsonAd r1 = (com.startapp.sdk.adsbase.JsonAd) r1
            java.util.List r1 = r1.g()
            java.util.List r0 = com.startapp.d0.a((android.content.Context) r0, (java.util.List<com.startapp.sdk.adsbase.model.AdDetails>) r1, (int) r3, (java.util.Set<java.lang.String>) r4, (boolean) r3)
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0049
            r0 = 1
            goto L_0x004a
        L_0x0049:
            r0 = 0
        L_0x004a:
            if (r0 != 0) goto L_0x0067
            com.startapp.sdk.adsbase.d r0 = r6.e
            if (r0 != 0) goto L_0x0052
            r0 = 0
            goto L_0x0056
        L_0x0052:
            boolean r0 = r0.d()
        L_0x0056:
            if (r0 == 0) goto L_0x0059
            goto L_0x0067
        L_0x0059:
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.f
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0079
            com.startapp.k1 r0 = r6.j
            r0.d()
            goto L_0x0079
        L_0x0067:
            r0 = 0
            r6.a(r0, r0, r2, r3)
            goto L_0x0079
        L_0x006c:
            java.util.concurrent.atomic.AtomicBoolean r0 = r6.f
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0079
            com.startapp.i1 r0 = r6.k
            r0.d()
        L_0x0079:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.cache.h.b():void");
    }

    public boolean c() {
        d dVar = this.e;
        return dVar != null && dVar.isReady();
    }

    public final void a(boolean z) {
        d dVar;
        boolean z2;
        boolean z3 = false;
        if (z) {
            Long h2 = AdsCommonMetaData.h.h();
            if (h2 == null || this.o == null || SystemClock.elapsedRealtime() - this.o.longValue() >= h2.longValue()) {
                this.o = Long.valueOf(SystemClock.elapsedRealtime());
                z2 = false;
            } else {
                k.a(this.b, new a(), new CachedAd$3(this, this.b, this.a), true);
                Context context = this.b;
                StringBuilder a2 = p0.a("Failed to load ");
                a2.append(this.a.name());
                a2.append(" ad: NO FILL");
                k9.a(context, 6, a2.toString(), true);
                z2 = true;
            }
            if (z2) {
                return;
            }
        }
        int ordinal = this.a.ordinal();
        if (ordinal == 0) {
            dVar = new OverlayAd(this.b);
        } else if (ordinal == 7) {
            dVar = new ReturnAd(this.b);
        } else if (ordinal == 2) {
            if (new Random().nextInt(100) < AdsCommonMetaData.h.w()) {
                z3 = true;
            }
            boolean isForceOfferWall3D = this.d.isForceOfferWall3D();
            boolean isForceOfferWall2D = true ^ this.d.isForceOfferWall2D();
            Map<Activity, Integer> map = k9.a;
            dVar = ((z3 || isForceOfferWall3D) && isForceOfferWall2D) ? new OfferWall3DAd(this.b) : new OfferWallAd(this.b);
        } else if (ordinal == 3) {
            dVar = new SplashAd(this.b);
        } else if (ordinal != 4) {
            dVar = new OverlayAd(this.b);
        } else {
            Map<Activity, Integer> map2 = k9.a;
            dVar = new VideoEnabledAd(this.b, AdPreferences.Placement.INAPP_OVERLAY);
        }
        this.e = dVar;
        dVar.setActivityExtra(this.c);
        this.d.setAutoLoadAmount(this.m);
        this.e.load(this.d, new a());
        this.g = System.currentTimeMillis();
    }

    public final void b(boolean z) {
        d dVar = this.e;
        if (dVar != null) {
            dVar.a(false);
        }
        if (this.i && this.h != null) {
            this.i = false;
            f fVar = new f(this, new a(), z);
            Context context = this.b;
            ComponentLocator.a(context).j().execute(new k(context, this.h, fVar, new g(this)));
            return;
        }
        a(z);
    }

    public final void a() {
        this.j = new k1(this);
        this.k = new i1(this);
    }

    public List<StartAppAd> a(Map<AdEventListener, List<StartAppAd>> map, AdEventListener adEventListener) {
        try {
            return map.get(adEventListener);
        } catch (Throwable th) {
            i3.a(th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x001f A[ADDED_TO_REGION, Catch:{ all -> 0x0036 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0053 A[ADDED_TO_REGION, Catch:{ all -> 0x0036 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.startapp.sdk.adsbase.StartAppAd r5, com.startapp.sdk.adsbase.adlisteners.AdEventListener r6, boolean r7, boolean r8) {
        /*
            r4 = this;
            java.util.Map<com.startapp.sdk.adsbase.adlisteners.AdEventListener, java.util.List<com.startapp.sdk.adsbase.StartAppAd>> r0 = r4.l
            monitor-enter(r0)
            boolean r1 = r4.c()     // Catch:{ all -> 0x005e }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x001c
            com.startapp.sdk.adsbase.d r1 = r4.e     // Catch:{ all -> 0x005e }
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0015
        L_0x0011:
            boolean r1 = r1.d()     // Catch:{ all -> 0x005e }
        L_0x0015:
            if (r1 != 0) goto L_0x001c
            if (r7 == 0) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r7 = 0
            goto L_0x001d
        L_0x001c:
            r7 = 1
        L_0x001d:
            if (r7 == 0) goto L_0x0053
            if (r5 == 0) goto L_0x003d
            if (r6 == 0) goto L_0x003d
            java.util.Map<com.startapp.sdk.adsbase.adlisteners.AdEventListener, java.util.List<com.startapp.sdk.adsbase.StartAppAd>> r7 = r4.l     // Catch:{ all -> 0x005e }
            java.util.List r7 = r4.a(r7, r6)     // Catch:{ all -> 0x005e }
            if (r7 != 0) goto L_0x003a
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x005e }
            r7.<init>()     // Catch:{ all -> 0x005e }
            java.util.Map<com.startapp.sdk.adsbase.adlisteners.AdEventListener, java.util.List<com.startapp.sdk.adsbase.StartAppAd>> r1 = r4.l     // Catch:{ all -> 0x005e }
            r1.put(r6, r7)     // Catch:{ all -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r6 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r6)     // Catch:{ all -> 0x005e }
        L_0x003a:
            r7.add(r5)     // Catch:{ all -> 0x005e }
        L_0x003d:
            java.util.concurrent.atomic.AtomicBoolean r5 = r4.f     // Catch:{ all -> 0x005e }
            boolean r5 = r5.compareAndSet(r2, r3)     // Catch:{ all -> 0x005e }
            if (r5 == 0) goto L_0x005c
            com.startapp.k1 r5 = r4.j     // Catch:{ all -> 0x005e }
            r5.e()     // Catch:{ all -> 0x005e }
            com.startapp.i1 r5 = r4.k     // Catch:{ all -> 0x005e }
            r5.e()     // Catch:{ all -> 0x005e }
            r4.b(r8)     // Catch:{ all -> 0x005e }
            goto L_0x005c
        L_0x0053:
            if (r5 == 0) goto L_0x005c
            if (r6 == 0) goto L_0x005c
            android.content.Context r7 = r4.b     // Catch:{ all -> 0x005e }
            com.startapp.k.b(r7, r6, r5, r3)     // Catch:{ all -> 0x005e }
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            return
        L_0x005e:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005e }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.cache.h.a(com.startapp.sdk.adsbase.StartAppAd, com.startapp.sdk.adsbase.adlisteners.AdEventListener, boolean, boolean):void");
    }
}
