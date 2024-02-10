package com.startapp.sdk.adsbase.cache;

import android.app.Activity;
import android.content.Context;
import com.startapp.h0;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.k1;
import com.startapp.k9;
import com.startapp.p0;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.h;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: Sta */
public class d {
    public static d h = new d();
    public final Map<CacheKey, h> a = new ConcurrentHashMap();
    public Map<String, String> b = new WeakHashMap();
    public boolean c = false;
    public boolean d = false;
    public Queue<e> e = new ConcurrentLinkedQueue();
    public h.b f;
    public Context g;

    /* renamed from: com.startapp.sdk.adsbase.cache.d$d  reason: collision with other inner class name */
    /* compiled from: Sta */
    public interface C0000d {
        void a(Ad ad, CacheKey cacheKey, boolean z);
    }

    /* compiled from: Sta */
    public class a implements AdEventListener {
        public final /* synthetic */ C0000d a;
        public final /* synthetic */ CacheKey b;

        public a(d dVar, C0000d dVar2, CacheKey cacheKey) {
            this.a = dVar2;
            this.b = cacheKey;
        }

        public void onFailedToReceiveAd(Ad ad) {
            C0000d dVar = this.a;
            if (dVar != null) {
                dVar.a(ad, this.b, false);
            }
        }

        public void onReceiveAd(Ad ad) {
            C0000d dVar = this.a;
            if (dVar != null) {
                dVar.a(ad, this.b, true);
            }
        }
    }

    /* compiled from: Sta */
    public class b implements AdEventListener {
        public final /* synthetic */ C0000d a;
        public final /* synthetic */ CacheKey b;

        public b(d dVar, C0000d dVar2, CacheKey cacheKey) {
            this.a = dVar2;
            this.b = cacheKey;
        }

        public void onFailedToReceiveAd(Ad ad) {
            C0000d dVar = this.a;
            if (dVar != null) {
                dVar.a(ad, this.b, false);
            }
        }

        public void onReceiveAd(Ad ad) {
            C0000d dVar = this.a;
            if (dVar != null) {
                dVar.a(ad, this.b, true);
            }
        }
    }

    /* compiled from: Sta */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|19|20|21|22|24) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        static {
            /*
                com.startapp.sdk.adsbase.StartAppAd$AdMode[] r0 = com.startapp.sdk.adsbase.StartAppAd.AdMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                b = r0
                r1 = 1
                com.startapp.sdk.adsbase.StartAppAd$AdMode r2 = com.startapp.sdk.adsbase.StartAppAd.AdMode.OFFERWALL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.startapp.sdk.adsbase.StartAppAd$AdMode r3 = com.startapp.sdk.adsbase.StartAppAd.AdMode.OVERLAY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.startapp.sdk.adsbase.StartAppAd$AdMode r4 = com.startapp.sdk.adsbase.StartAppAd.AdMode.FULLPAGE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.startapp.sdk.adsbase.StartAppAd$AdMode r4 = com.startapp.sdk.adsbase.StartAppAd.AdMode.VIDEO     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.startapp.sdk.adsbase.StartAppAd$AdMode r4 = com.startapp.sdk.adsbase.StartAppAd.AdMode.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.startapp.sdk.adsbase.StartAppAd$AdMode r4 = com.startapp.sdk.adsbase.StartAppAd.AdMode.AUTOMATIC     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.startapp.sdk.adsbase.model.AdPreferences$Placement[] r3 = com.startapp.sdk.adsbase.model.AdPreferences.Placement.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                a = r3
                r3[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x0059 }
                r2 = 7
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.cache.d.c.<clinit>():void");
        }
    }

    /* compiled from: Sta */
    public class e {
        public StartAppAd a;
        public AdPreferences.Placement b;
        public AdPreferences c;
        public AdEventListener d;

        public e(d dVar, StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, AdEventListener adEventListener) {
            this.a = startAppAd;
            this.b = placement;
            this.c = adPreferences;
            this.d = adEventListener;
        }
    }

    public void a(Context context, StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, C0000d dVar, boolean z, int i) {
        h hVar;
        Context a2 = h0.a(context);
        if (a2 != null) {
            context = a2;
        }
        this.g = context;
        if (adPreferences == null) {
            adPreferences = new AdPreferences();
        }
        AdPreferences adPreferences2 = adPreferences;
        CacheKey cacheKey = new CacheKey(placement, adPreferences2);
        if (!this.d || z) {
            AdPreferences adPreferences3 = new AdPreferences(adPreferences2);
            synchronized (this.a) {
                hVar = this.a.get(cacheKey);
                if (hVar == null) {
                    if (placement.ordinal() != 3) {
                        hVar = new h(this.g, placement, adPreferences3);
                    } else {
                        hVar = new h(this.g, placement, adPreferences3);
                        hVar.n = false;
                    }
                    if (this.f == null) {
                        this.f = new e(this);
                    }
                    hVar.p = this.f;
                    if (z) {
                        hVar.h = b(cacheKey);
                        hVar.i = true;
                        hVar.m = i;
                    }
                    a(cacheKey, hVar);
                } else {
                    hVar.d = adPreferences3;
                }
            }
            hVar.a(startAppAd, new b(this, dVar, cacheKey), false, true);
            return;
        }
        this.e.add(new e(this, startAppAd, placement, adPreferences2, new a(this, dVar, cacheKey)));
    }

    public String b(CacheKey cacheKey) {
        return String.valueOf(cacheKey.hashCode()).replace('-', '_');
    }

    public com.startapp.sdk.adsbase.d c(CacheKey cacheKey) {
        h hVar;
        if (cacheKey == null || (hVar = this.a.get(cacheKey)) == null || !hVar.c()) {
            return null;
        }
        com.startapp.sdk.adsbase.d dVar = hVar.e;
        hVar.m = 0;
        hVar.o = null;
        if (!AdsConstants.f.booleanValue() && hVar.n && CacheMetaData.d()) {
            hVar.a((StartAppAd) null, (AdEventListener) null, true, true);
        } else if (!hVar.n) {
            h.b bVar = hVar.p;
            if (bVar != null) {
                ((e) bVar).a(hVar);
            }
            k1 k1Var = hVar.j;
            if (k1Var != null) {
                k1Var.e();
            }
        }
        return dVar;
    }

    public void b(AdPreferences.Placement placement) {
        synchronized (this.a) {
            Iterator<Map.Entry<CacheKey, h>> it = this.a.entrySet().iterator();
            while (it.hasNext()) {
                if (((CacheKey) it.next().getKey()).a() == placement) {
                    it.remove();
                }
            }
        }
    }

    public com.startapp.sdk.adsbase.d a(CacheKey cacheKey) {
        h hVar = cacheKey != null ? this.a.get(cacheKey) : null;
        if (hVar != null) {
            return hVar.e;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0050 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r7) {
        /*
            r6 = this;
            java.util.Map<com.startapp.sdk.adsbase.cache.CacheKey, com.startapp.sdk.adsbase.cache.h> r0 = r6.a
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0053
            java.lang.Object r1 = r0.next()
            com.startapp.sdk.adsbase.cache.h r1 = (com.startapp.sdk.adsbase.cache.h) r1
            com.startapp.sdk.adsbase.d r2 = r1.e
            r3 = 0
            r4 = 0
            if (r2 == 0) goto L_0x003c
            java.util.Map<android.app.Activity, java.lang.Integer> r5 = com.startapp.k9.a
            boolean r2 = r2 instanceof com.startapp.sdk.ads.interstitials.ReturnAd
            if (r2 == 0) goto L_0x003c
            if (r7 != 0) goto L_0x003c
            com.startapp.sdk.adsbase.cache.CacheMetaData r2 = com.startapp.sdk.adsbase.cache.CacheMetaData.a
            com.startapp.sdk.adsbase.cache.ACMConfig r2 = r2.a()
            boolean r2 = r2.g()
            if (r2 != 0) goto L_0x0047
            com.startapp.k1 r2 = r1.j
            android.os.Handler r5 = r2.b
            if (r5 == 0) goto L_0x0039
            r5.removeCallbacksAndMessages(r3)
        L_0x0039:
            r2.d = r4
            goto L_0x0047
        L_0x003c:
            com.startapp.k1 r2 = r1.j
            android.os.Handler r5 = r2.b
            if (r5 == 0) goto L_0x0045
            r5.removeCallbacksAndMessages(r3)
        L_0x0045:
            r2.d = r4
        L_0x0047:
            com.startapp.i1 r1 = r1.k
            android.os.Handler r2 = r1.b
            if (r2 == 0) goto L_0x0050
            r2.removeCallbacksAndMessages(r3)
        L_0x0050:
            r1.d = r4
            goto L_0x000a
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.cache.d.a(boolean):void");
    }

    public void a(Context context, StartAppAd startAppAd, AdPreferences.Placement placement, AdPreferences adPreferences, C0000d dVar) {
        a(context, (StartAppAd) null, placement, adPreferences, dVar, false, 0);
    }

    public final void a(CacheKey cacheKey, h hVar) {
        synchronized (this.a) {
            int d2 = CacheMetaData.a.a().d();
            if (d2 != 0 && this.a.size() >= d2) {
                long j = Long.MAX_VALUE;
                CacheKey cacheKey2 = null;
                for (CacheKey next : this.a.keySet()) {
                    h hVar2 = this.a.get(next);
                    if (hVar2.a == hVar.a) {
                        long j2 = hVar2.g;
                        if (j2 < j) {
                            cacheKey2 = next;
                            j = j2;
                        }
                    }
                }
                if (cacheKey2 != null) {
                    this.a.remove(cacheKey2);
                }
            }
            this.a.put(cacheKey, hVar);
            if (Math.random() * 100.0d < ((double) CacheMetaData.a.c())) {
                i3 i3Var = new i3(j3.d);
                i3Var.d = "Cache Size";
                i3Var.e = String.valueOf(this.a.size());
                i3Var.a();
            }
        }
    }

    public void a(Context context, StartAppAd startAppAd, StartAppAd.AdMode adMode, AdPreferences adPreferences, C0000d dVar) {
        AdPreferences.Placement placement;
        switch (c.b[adMode.ordinal()]) {
            case 1:
                Map<Activity, Integer> map = k9.a;
                placement = AdPreferences.Placement.INAPP_OFFER_WALL;
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                placement = AdPreferences.Placement.INAPP_OVERLAY;
                break;
            case 6:
                Map<Activity, Integer> map2 = k9.a;
                if (new Random().nextInt(100) >= AdsCommonMetaData.h.i()) {
                    placement = AdPreferences.Placement.INAPP_FULL_SCREEN;
                    break;
                } else {
                    if ((new Random().nextInt(100) >= AdsCommonMetaData.h.j() && !adPreferences.isForceFullpage()) || adPreferences.isForceOverlay()) {
                        placement = AdPreferences.Placement.INAPP_OVERLAY;
                        break;
                    } else {
                        placement = AdPreferences.Placement.INAPP_FULL_SCREEN;
                        break;
                    }
                }
                break;
            default:
                placement = AdPreferences.Placement.INAPP_FULL_SCREEN;
                break;
        }
        AdPreferences.Placement placement2 = placement;
        if (adMode.equals(StartAppAd.AdMode.REWARDED_VIDEO)) {
            adPreferences.setType(Ad.AdType.REWARDED_VIDEO);
        } else if (adMode.equals(StartAppAd.AdMode.VIDEO)) {
            adPreferences.setType(Ad.AdType.VIDEO);
        }
        a(context, startAppAd, placement2, adPreferences, dVar, false, 0);
    }

    public boolean a(AdPreferences.Placement placement) {
        int ordinal = placement.ordinal();
        if (ordinal == 3) {
            Object obj = StartAppSDKInternal.E;
            if (!(!StartAppSDKInternal.d.a.x) || AdsCommonMetaData.h.L()) {
                return false;
            }
            return true;
        } else if (ordinal != 7) {
            return true;
        } else {
            Object obj2 = StartAppSDKInternal.E;
            if (!StartAppSDKInternal.d.a.u || AdsCommonMetaData.h.K()) {
                return false;
            }
            return true;
        }
    }

    public static String a(StartAppAd.AdMode adMode) {
        StringBuilder a2 = p0.a("autoLoadNotShownAdPrefix");
        a2.append(adMode.name());
        return a2.toString();
    }
}
