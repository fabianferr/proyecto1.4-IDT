package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.cache.CacheKey;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager;
import com.startapp.sdk.adsbase.cache.d;
import com.startapp.sdk.adsbase.cache.h;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Sta */
public class c implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ d b;

    public c(d dVar, Context context) {
        this.b = dVar;
        this.a = context;
    }

    public void run() {
        try {
            f2.a(this.a, DiskAdCacheManager.b());
            f2.a(this.a, DiskAdCacheManager.a());
            CacheKey cacheKey = null;
            for (Map.Entry next : this.b.a.entrySet()) {
                CacheKey cacheKey2 = (CacheKey) next.getKey();
                if (cacheKey2.a() == AdPreferences.Placement.INAPP_SPLASH) {
                    cacheKey = cacheKey2;
                } else {
                    h hVar = (h) next.getValue();
                    Context context = this.a;
                    AdPreferences.Placement a2 = cacheKey2.a();
                    AdPreferences adPreferences = hVar.d;
                    String b2 = this.b.b(cacheKey2);
                    int i = hVar.m;
                    DiskAdCacheManager.DiskCacheKey diskCacheKey = new DiskAdCacheManager.DiskCacheKey(a2, adPreferences);
                    diskCacheKey.a(i);
                    String b3 = DiskAdCacheManager.b();
                    if (b2 != null) {
                        f2.a(f2.b(context, b3), b2, (Serializable) diskCacheKey);
                    }
                    Context context2 = this.a;
                    String b4 = this.b.b(cacheKey2);
                    DiskAdCacheManager.DiskCachedAd diskCachedAd = new DiskAdCacheManager.DiskCachedAd(hVar.e);
                    String a3 = DiskAdCacheManager.a();
                    if (b4 != null) {
                        try {
                            f2.a(f2.b(context2, a3), b4, (Serializable) diskCachedAd);
                        } catch (Throwable th) {
                            if (f2.a(4)) {
                                i3.a(th);
                            }
                        }
                    }
                }
            }
            if (cacheKey != null) {
                this.b.a.remove(cacheKey);
            }
        } catch (Throwable th2) {
            i3.a(th2);
        }
    }
}
