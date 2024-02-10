package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.startapp.c4;
import com.startapp.e;
import com.startapp.f;
import com.startapp.k9;
import com.startapp.sdk.ads.interstitials.ReturnAd;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.ads.splash.SplashHideListener;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.adrules.AdRules;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.c;
import com.startapp.sdk.adsbase.cache.d;
import com.startapp.sdk.adsbase.cache.h;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.x1;
import java.util.Map;

/* compiled from: Sta */
public class g extends x1 {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        boolean z;
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        startAppSDKInternal.getClass();
        boolean z2 = true;
        if (activity.getClass().getName().equals(k9.c((Context) activity))) {
            startAppSDKInternal.z = true;
        }
        startAppSDKInternal.r = bundle;
        Map<Activity, Integer> map = k9.a;
        c cVar = c.a.a;
        boolean equals = activity.getClass().getName().equals(k9.c((Context) activity));
        if (bundle == null) {
            String[] split = c.class.getName().split("\\.");
            if (split.length < 3) {
                z = false;
            } else {
                z = activity.getClass().getName().startsWith(split[0] + "." + split[1] + "." + split[2]);
            }
            if (!z && !equals) {
                cVar.d++;
                if (cVar.a && AdsCommonMetaData.h.I()) {
                    if (cVar.b == null) {
                        cVar.b = new AutoInterstitialPreferences();
                    }
                    boolean z3 = cVar.c <= 0 || System.currentTimeMillis() >= cVar.c + ((long) (cVar.b.getSecondsBetweenAds() * 1000));
                    int i = cVar.d;
                    boolean z4 = i <= 0 || i >= cVar.b.getActivitiesBetweenAds();
                    if (!z3 || !z4) {
                        z2 = false;
                    }
                    if (z2) {
                        if (cVar.e == null) {
                            cVar.e = new StartAppAd(activity);
                        }
                        cVar.e.loadAd(StartAppAd.AdMode.AUTOMATIC, new AdPreferences().setAi(Boolean.TRUE), new c4(cVar));
                    }
                }
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        if (startAppSDKInternal.a(activity)) {
            startAppSDKInternal.y = false;
        }
        if (startAppSDKInternal.i.size() == 0) {
            startAppSDKInternal.d = false;
        }
    }

    public void onActivityPaused(Activity activity) {
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        startAppSDKInternal.getClass();
        startAppSDKInternal.g = System.currentTimeMillis();
        startAppSDKInternal.l = null;
    }

    public void onActivityResumed(Activity activity) {
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        if (startAppSDKInternal.b && startAppSDKInternal.e) {
            startAppSDKInternal.e = false;
            d dVar = d.h;
            if (!dVar.d) {
                synchronized (dVar.a) {
                    for (h b : dVar.a.values()) {
                        b.b();
                    }
                }
            }
        }
        if (startAppSDKInternal.m) {
            startAppSDKInternal.m = false;
            SimpleTokenUtils.f(activity);
        }
        startAppSDKInternal.l = activity;
    }

    public void onActivityStarted(Activity activity) {
        StartAppSDKInternal startAppSDKInternal = StartAppSDKInternal.d.a;
        boolean a = startAppSDKInternal.a(activity);
        boolean z = !startAppSDKInternal.y && a && startAppSDKInternal.r == null && startAppSDKInternal.i.size() == 0 && StartAppSDKInternal.F == StartAppSDKInternal.InitState.EXPLICIT;
        if (z) {
            ComponentLocator.a((Context) activity).g().a(false, (String) null, (String) null, (String) null);
        }
        Map<Activity, Integer> map = k9.a;
        if (!ComponentLocator.a((Context) activity).g().d && !AdsCommonMetaData.h.L() && !startAppSDKInternal.x && !startAppSDKInternal.a("MoPub") && !startAppSDKInternal.a("AdMob") && !startAppSDKInternal.w && z) {
            StartAppAd.a(activity, startAppSDKInternal.r, new SplashConfig(), new AdPreferences(), (SplashHideListener) null, false);
        }
        if (a) {
            startAppSDKInternal.z = false;
            startAppSDKInternal.y = true;
        }
        if (startAppSDKInternal.d) {
            if (MetaData.k.b() && startAppSDKInternal.u && !AdsCommonMetaData.h.K() && !startAppSDKInternal.o) {
                if (System.currentTimeMillis() - startAppSDKInternal.g > AdsCommonMetaData.h.x()) {
                    d c = d.h.c(startAppSDKInternal.t);
                    startAppSDKInternal.A = c;
                    if (c != null && c.isReady()) {
                        AdRules b = AdsCommonMetaData.h.b();
                        AdPreferences.Placement placement = AdPreferences.Placement.INAPP_RETURN;
                        AdRulesResult a2 = b.a(placement, (String) null);
                        if (!a2.b()) {
                            a.a(((ReturnAd) startAppSDKInternal.A).trackingUrls, (String) null, 0, a2.a());
                        } else if (startAppSDKInternal.A.a((String) null)) {
                            f.d.a(new e(placement, (String) null));
                        }
                    }
                }
            }
            if (System.currentTimeMillis() - startAppSDKInternal.g > MetaData.k.J()) {
                startAppSDKInternal.b(activity, MetaDataRequest.RequestReason.APP_IDLE);
            }
        }
        startAppSDKInternal.f = false;
        startAppSDKInternal.d = false;
        if (startAppSDKInternal.i.get(Integer.valueOf(activity.hashCode())) == null) {
            startAppSDKInternal.i.put(Integer.valueOf(activity.hashCode()), Integer.valueOf(new Integer(0).intValue() + 1));
        }
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=android.app.Activity, code=android.content.Context, for r7v0, types: [android.content.Context, java.lang.Object, android.app.Activity] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityStopped(android.content.Context r7) {
        /*
            r6 = this;
            com.startapp.sdk.adsbase.StartAppSDKInternal r0 = com.startapp.sdk.adsbase.StartAppSDKInternal.d.a
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r1 = r0.i
            int r2 = r7.hashCode()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r1 = r1.get(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 == 0) goto L_0x0091
            int r1 = r1.intValue()
            r2 = 1
            int r1 = r1 - r2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            int r3 = r1.intValue()
            if (r3 != 0) goto L_0x0032
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r1 = r0.i
            int r3 = r7.hashCode()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r1.remove(r3)
            goto L_0x003f
        L_0x0032:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r3 = r0.i
            int r4 = r7.hashCode()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3.put(r4, r1)
        L_0x003f:
            java.util.HashMap<java.lang.Integer, java.lang.Integer> r1 = r0.i
            int r1 = r1.size()
            if (r1 != 0) goto L_0x0091
            boolean r1 = r0.f
            if (r1 != 0) goto L_0x0050
            r0.d = r2
            r0.f(r7)
        L_0x0050:
            boolean r1 = r0.b
            if (r1 == 0) goto L_0x0091
            android.content.Context r1 = com.startapp.h0.a(r7)
            if (r1 == 0) goto L_0x005b
            r7 = r1
        L_0x005b:
            com.startapp.sdk.adsbase.cache.d r1 = com.startapp.sdk.adsbase.cache.d.h
            boolean r3 = r0.f
            r1.getClass()
            boolean r4 = r1.c     // Catch:{ all -> 0x008b }
            if (r4 != 0) goto L_0x0074
            com.startapp.sdk.adsbase.cache.CacheMetaData r4 = com.startapp.sdk.adsbase.cache.CacheMetaData.a     // Catch:{ all -> 0x008b }
            com.startapp.sdk.adsbase.cache.ACMConfig r4 = r4.a()     // Catch:{ all -> 0x008b }
            boolean r4 = r4.f()     // Catch:{ all -> 0x008b }
            if (r4 == 0) goto L_0x0074
            r4 = 1
            goto L_0x0075
        L_0x0074:
            r4 = 0
        L_0x0075:
            if (r4 == 0) goto L_0x0087
            com.startapp.sdk.components.ComponentLocator r4 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r7)     // Catch:{ all -> 0x008b }
            java.util.concurrent.Executor r4 = r4.j()     // Catch:{ all -> 0x008b }
            com.startapp.c r5 = new com.startapp.c     // Catch:{ all -> 0x008b }
            r5.<init>(r1, r7)     // Catch:{ all -> 0x008b }
            r4.execute(r5)     // Catch:{ all -> 0x008b }
        L_0x0087:
            r1.a((boolean) r3)     // Catch:{ all -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r7 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r7)
        L_0x008f:
            r0.e = r2
        L_0x0091:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.g.onActivityStopped(android.app.Activity):void");
    }
}
