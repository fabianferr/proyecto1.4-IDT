package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import com.startapp.a3;
import com.startapp.g2;
import com.startapp.i3;
import com.startapp.p0;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.splash.SplashMetaData;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.adinformation.AdInformationMetaData;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.z5;
import java.util.Collections;
import java.util.List;

/* compiled from: Sta */
public class a {
    public final Context a;
    public final AdPreferences b;
    public final MetaDataRequest.RequestReason c;
    public MetaData d = null;
    public BannerMetaData e = null;
    public SplashMetaData f;
    public CacheMetaData g = null;
    public AdInformationMetaData h = null;
    public AdsCommonMetaData i = null;
    public boolean j = false;
    public boolean k = false;

    public a(Context context, AdPreferences adPreferences, MetaDataRequest.RequestReason requestReason) {
        this.a = context;
        this.b = adPreferences;
        this.c = requestReason;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:31|32|(24:38|39|40|(1:42)|46|47|48|(1:50)|54|55|56|(1:58)|59|(1:61)|65|66|67|(1:69)|73|74|75|(1:77)|81|82)|83|84) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x0155 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Boolean a() {
        /*
            r5 = this;
            android.content.Context r0 = r5.a     // Catch:{ all -> 0x015c }
            com.startapp.sdk.components.ComponentLocator r0 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r0)     // Catch:{ all -> 0x015c }
            com.startapp.sdk.adsbase.e r0 = r0.e()     // Catch:{ all -> 0x015c }
            com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest r1 = new com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest     // Catch:{ all -> 0x015c }
            android.content.Context r2 = r5.a     // Catch:{ all -> 0x015c }
            com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest$RequestReason r3 = r5.c     // Catch:{ all -> 0x015c }
            r1.<init>(r2, r0, r3)     // Catch:{ all -> 0x015c }
            android.content.Context r0 = r5.a     // Catch:{ all -> 0x015c }
            com.startapp.sdk.adsbase.model.AdPreferences r2 = r5.b     // Catch:{ all -> 0x015c }
            r1.a(r0, r2)     // Catch:{ all -> 0x015c }
            android.content.Context r0 = r5.a     // Catch:{ all -> 0x015c }
            com.startapp.z5$a r0 = a(r0, r1)     // Catch:{ all -> 0x015c }
            if (r0 != 0) goto L_0x0025
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x015c }
            return r0
        L_0x0025:
            java.lang.String r0 = r0.b     // Catch:{ all -> 0x015c }
            if (r0 != 0) goto L_0x002c
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x015c }
            return r0
        L_0x002c:
            java.lang.Class<com.startapp.sdk.adsbase.remoteconfig.MetaData> r1 = com.startapp.sdk.adsbase.remoteconfig.MetaData.class
            java.lang.Object r1 = com.startapp.g4.a(r0, r1)     // Catch:{ all -> 0x015c }
            com.startapp.sdk.adsbase.remoteconfig.MetaData r1 = (com.startapp.sdk.adsbase.remoteconfig.MetaData) r1     // Catch:{ all -> 0x015c }
            r5.d = r1     // Catch:{ all -> 0x015c }
            if (r1 != 0) goto L_0x003b
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x015c }
            return r0
        L_0x003b:
            java.lang.String r1 = r1.j()     // Catch:{ all -> 0x015c }
            if (r1 == 0) goto L_0x006e
            android.content.Context r1 = r5.a     // Catch:{ all -> 0x015c }
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r1)     // Catch:{ all -> 0x015c }
            com.startapp.b0 r1 = r1.c()     // Catch:{ all -> 0x015c }
            com.startapp.sdk.adsbase.remoteconfig.MetaData r2 = r5.d     // Catch:{ all -> 0x015c }
            java.lang.String r2 = r2.j()     // Catch:{ all -> 0x015c }
            if (r2 == 0) goto L_0x0057
            java.lang.String r2 = r2.trim()     // Catch:{ all -> 0x015c }
        L_0x0057:
            java.lang.Object r3 = r1.a     // Catch:{ all -> 0x015c }
            monitor-enter(r3)     // Catch:{ all -> 0x015c }
            android.content.SharedPreferences r1 = r1.b     // Catch:{ all -> 0x006b }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ all -> 0x006b }
            java.lang.String r4 = "31721150b470a3b9"
            android.content.SharedPreferences$Editor r1 = r1.putString(r4, r2)     // Catch:{ all -> 0x006b }
            r1.commit()     // Catch:{ all -> 0x006b }
            monitor-exit(r3)     // Catch:{ all -> 0x006b }
            goto L_0x006e
        L_0x006b:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x006b }
            throw r0     // Catch:{ all -> 0x015c }
        L_0x006e:
            java.util.Map<android.app.Activity, java.lang.Integer> r1 = com.startapp.k9.a     // Catch:{ all -> 0x015c }
            java.lang.Class<com.startapp.sdk.adsbase.AdsCommonMetaData> r1 = com.startapp.sdk.adsbase.AdsCommonMetaData.class
            java.lang.Object r1 = com.startapp.g4.a(r0, r1)     // Catch:{ all -> 0x015c }
            com.startapp.sdk.adsbase.AdsCommonMetaData r1 = (com.startapp.sdk.adsbase.AdsCommonMetaData) r1     // Catch:{ all -> 0x015c }
            r5.i = r1     // Catch:{ all -> 0x015c }
            java.lang.Class<com.startapp.sdk.ads.banner.BannerMetaData> r1 = com.startapp.sdk.ads.banner.BannerMetaData.class
            java.lang.Object r1 = com.startapp.g4.a(r0, r1)     // Catch:{ all -> 0x015c }
            com.startapp.sdk.ads.banner.BannerMetaData r1 = (com.startapp.sdk.ads.banner.BannerMetaData) r1     // Catch:{ all -> 0x015c }
            r5.e = r1     // Catch:{ all -> 0x015c }
            java.lang.Class<com.startapp.sdk.ads.splash.SplashMetaData> r1 = com.startapp.sdk.ads.splash.SplashMetaData.class
            java.lang.Object r1 = com.startapp.g4.a(r0, r1)     // Catch:{ all -> 0x015c }
            com.startapp.sdk.ads.splash.SplashMetaData r1 = (com.startapp.sdk.ads.splash.SplashMetaData) r1     // Catch:{ all -> 0x015c }
            r5.f = r1     // Catch:{ all -> 0x015c }
            java.lang.Class<com.startapp.sdk.adsbase.cache.CacheMetaData> r1 = com.startapp.sdk.adsbase.cache.CacheMetaData.class
            java.lang.Object r1 = com.startapp.g4.a(r0, r1)     // Catch:{ all -> 0x015c }
            com.startapp.sdk.adsbase.cache.CacheMetaData r1 = (com.startapp.sdk.adsbase.cache.CacheMetaData) r1     // Catch:{ all -> 0x015c }
            r5.g = r1     // Catch:{ all -> 0x015c }
            java.lang.Class<com.startapp.sdk.adsbase.adinformation.AdInformationMetaData> r1 = com.startapp.sdk.adsbase.adinformation.AdInformationMetaData.class
            java.lang.Object r0 = com.startapp.g4.a(r0, r1)     // Catch:{ all -> 0x015c }
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData r0 = (com.startapp.sdk.adsbase.adinformation.AdInformationMetaData) r0     // Catch:{ all -> 0x015c }
            r5.h = r0     // Catch:{ all -> 0x015c }
            java.lang.Object r0 = com.startapp.sdk.adsbase.remoteconfig.MetaData.d
            java.lang.Object r0 = com.startapp.sdk.adsbase.remoteconfig.MetaData.d
            monitor-enter(r0)
            boolean r1 = r5.j     // Catch:{ all -> 0x0159 }
            if (r1 != 0) goto L_0x0155
            com.startapp.sdk.adsbase.remoteconfig.MetaData r1 = r5.d     // Catch:{ all -> 0x0159 }
            if (r1 == 0) goto L_0x0155
            android.content.Context r1 = r5.a     // Catch:{ all -> 0x0159 }
            if (r1 == 0) goto L_0x0155
            r1 = 1
            com.startapp.sdk.adsbase.AdsCommonMetaData r2 = com.startapp.sdk.adsbase.AdsCommonMetaData.h     // Catch:{ all -> 0x00c8 }
            com.startapp.sdk.adsbase.AdsCommonMetaData r3 = r5.i     // Catch:{ all -> 0x00c8 }
            boolean r2 = com.startapp.k9.a(r2, r3)     // Catch:{ all -> 0x00c8 }
            if (r2 != 0) goto L_0x00cc
            r5.k = r1     // Catch:{ all -> 0x00c8 }
            android.content.Context r2 = r5.a     // Catch:{ all -> 0x00c8 }
            com.startapp.sdk.adsbase.AdsCommonMetaData r3 = r5.i     // Catch:{ all -> 0x00c8 }
            com.startapp.sdk.adsbase.AdsCommonMetaData.a(r2, r3)     // Catch:{ all -> 0x00c8 }
            goto L_0x00cc
        L_0x00c8:
            r2 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x0159 }
        L_0x00cc:
            java.util.Map<android.app.Activity, java.lang.Integer> r2 = com.startapp.k9.a     // Catch:{ all -> 0x0159 }
            com.startapp.sdk.ads.banner.BannerMetaData r2 = com.startapp.sdk.ads.banner.BannerMetaData.b     // Catch:{ all -> 0x00e2 }
            com.startapp.sdk.ads.banner.BannerMetaData r3 = r5.e     // Catch:{ all -> 0x00e2 }
            boolean r2 = com.startapp.k9.a(r2, r3)     // Catch:{ all -> 0x00e2 }
            if (r2 != 0) goto L_0x00e6
            r5.k = r1     // Catch:{ all -> 0x00e2 }
            android.content.Context r2 = r5.a     // Catch:{ all -> 0x00e2 }
            com.startapp.sdk.ads.banner.BannerMetaData r3 = r5.e     // Catch:{ all -> 0x00e2 }
            com.startapp.sdk.ads.banner.BannerMetaData.a(r2, r3)     // Catch:{ all -> 0x00e2 }
            goto L_0x00e6
        L_0x00e2:
            r2 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x0159 }
        L_0x00e6:
            java.util.Map<android.app.Activity, java.lang.Integer> r2 = com.startapp.k9.a     // Catch:{ all -> 0x0159 }
            com.startapp.sdk.ads.splash.SplashMetaData r2 = r5.f     // Catch:{ all -> 0x0112 }
            if (r2 != 0) goto L_0x00f3
            com.startapp.sdk.ads.splash.SplashMetaData r2 = new com.startapp.sdk.ads.splash.SplashMetaData     // Catch:{ all -> 0x0112 }
            r2.<init>()     // Catch:{ all -> 0x0112 }
            r5.f = r2     // Catch:{ all -> 0x0112 }
        L_0x00f3:
            com.startapp.sdk.ads.splash.SplashMetaData r2 = r5.f     // Catch:{ all -> 0x0112 }
            com.startapp.sdk.ads.splash.SplashConfig r2 = r2.a()     // Catch:{ all -> 0x0112 }
            android.content.Context r3 = r5.a     // Catch:{ all -> 0x0112 }
            r2.setDefaults(r3)     // Catch:{ all -> 0x0112 }
            com.startapp.sdk.ads.splash.SplashMetaData r2 = com.startapp.sdk.ads.splash.SplashMetaData.a     // Catch:{ all -> 0x0112 }
            com.startapp.sdk.ads.splash.SplashMetaData r3 = r5.f     // Catch:{ all -> 0x0112 }
            boolean r2 = com.startapp.k9.a(r2, r3)     // Catch:{ all -> 0x0112 }
            if (r2 != 0) goto L_0x0116
            r5.k = r1     // Catch:{ all -> 0x0112 }
            android.content.Context r2 = r5.a     // Catch:{ all -> 0x0112 }
            com.startapp.sdk.ads.splash.SplashMetaData r3 = r5.f     // Catch:{ all -> 0x0112 }
            com.startapp.sdk.ads.splash.SplashMetaData.a(r2, r3)     // Catch:{ all -> 0x0112 }
            goto L_0x0116
        L_0x0112:
            r2 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x0159 }
        L_0x0116:
            java.util.Map<android.app.Activity, java.lang.Integer> r2 = com.startapp.k9.a     // Catch:{ all -> 0x0159 }
            com.startapp.sdk.adsbase.cache.CacheMetaData r2 = com.startapp.sdk.adsbase.cache.CacheMetaData.a     // Catch:{ all -> 0x012c }
            com.startapp.sdk.adsbase.cache.CacheMetaData r3 = r5.g     // Catch:{ all -> 0x012c }
            boolean r2 = com.startapp.k9.a(r2, r3)     // Catch:{ all -> 0x012c }
            if (r2 != 0) goto L_0x0130
            r5.k = r1     // Catch:{ all -> 0x012c }
            android.content.Context r2 = r5.a     // Catch:{ all -> 0x012c }
            com.startapp.sdk.adsbase.cache.CacheMetaData r3 = r5.g     // Catch:{ all -> 0x012c }
            com.startapp.sdk.adsbase.cache.CacheMetaData.a(r2, r3)     // Catch:{ all -> 0x012c }
            goto L_0x0130
        L_0x012c:
            r2 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r2)     // Catch:{ all -> 0x0159 }
        L_0x0130:
            java.util.Map<android.app.Activity, java.lang.Integer> r2 = com.startapp.k9.a     // Catch:{ all -> 0x0159 }
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData r2 = com.startapp.sdk.adsbase.adinformation.AdInformationMetaData.a     // Catch:{ all -> 0x0146 }
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData r3 = r5.h     // Catch:{ all -> 0x0146 }
            boolean r2 = com.startapp.k9.a(r2, r3)     // Catch:{ all -> 0x0146 }
            if (r2 != 0) goto L_0x014a
            r5.k = r1     // Catch:{ all -> 0x0146 }
            android.content.Context r1 = r5.a     // Catch:{ all -> 0x0146 }
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData r2 = r5.h     // Catch:{ all -> 0x0146 }
            com.startapp.sdk.adsbase.adinformation.AdInformationMetaData.a(r1, r2)     // Catch:{ all -> 0x0146 }
            goto L_0x014a
        L_0x0146:
            r1 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0159 }
        L_0x014a:
            android.content.Context r1 = r5.a     // Catch:{ Exception -> 0x0155 }
            com.startapp.sdk.adsbase.remoteconfig.MetaData r2 = r5.d     // Catch:{ Exception -> 0x0155 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x0155 }
            com.startapp.sdk.adsbase.remoteconfig.MetaData.a((android.content.Context) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x0155 }
        L_0x0155:
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            return r0
        L_0x0159:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            throw r1
        L_0x015c:
            r0 = move-exception
            com.startapp.i3.a((java.lang.Throwable) r0)
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.adsbase.remoteconfig.a.a():java.lang.Boolean");
    }

    public void a(Boolean bool) {
        MetaData metaData;
        Context context;
        Object obj = MetaData.d;
        synchronized (MetaData.d) {
            if (!this.j) {
                if (!bool.booleanValue() || (metaData = this.d) == null || (context = this.a) == null) {
                    MetaData.a(this.c);
                } else {
                    try {
                        MetaData.a(context, metaData, this.c, this.k);
                    } catch (Throwable th) {
                        i3.a(th);
                    }
                }
            }
        }
    }

    public static z5.a a(Context context, MetaDataRequest metaDataRequest) {
        z5.a aVar;
        List<String> list = MetaData.k.metaDataHosts;
        if (list == null || list.size() < 1) {
            list = MetaData.g;
        }
        for (T a2 : Collections.unmodifiableList(list)) {
            a3 m = ComponentLocator.a(context).m();
            StringBuilder a3 = p0.a(a2);
            a3.append(AdsConstants.d);
            try {
                aVar = m.a(a3.toString(), metaDataRequest, (g2<Throwable, Void>) null);
            } catch (Throwable th) {
                if (m.a(1)) {
                    i3.a(th);
                }
                aVar = null;
            }
            if (aVar == null) {
                if (!ComponentLocator.a(context).f().a()) {
                    break;
                }
            } else {
                return aVar;
            }
        }
        return null;
    }
}
