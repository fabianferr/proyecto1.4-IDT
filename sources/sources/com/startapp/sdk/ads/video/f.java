package com.startapp.sdk.ads.video;

import android.content.Context;
import com.startapp.f2;
import com.startapp.sdk.ads.video.j;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.cache.CachedVideoAd;

/* compiled from: Sta */
public class f implements j.b {
    public final /* synthetic */ j.b a;
    public final /* synthetic */ CachedVideoAd b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ h d;

    public f(h hVar, j.b bVar, CachedVideoAd cachedVideoAd, Context context) {
        this.d = hVar;
        this.a = bVar;
        this.b = cachedVideoAd;
        this.c = context;
    }

    public void a(String str) {
        j.b bVar = this.a;
        if (bVar != null) {
            bVar.a(str);
        }
        if (str != null) {
            this.b.a(System.currentTimeMillis());
            this.b.a(str);
            h hVar = this.d;
            Context context = this.c;
            CachedVideoAd cachedVideoAd = this.b;
            hVar.a.remove(cachedVideoAd);
            hVar.a(AdsCommonMetaData.h.G().b() - 1);
            hVar.a.add(cachedVideoAd);
            f2.b(context, "CachedAds", hVar.a);
        }
    }
}
