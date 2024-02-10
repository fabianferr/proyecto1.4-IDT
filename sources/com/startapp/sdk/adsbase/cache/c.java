package com.startapp.sdk.adsbase.cache;

import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.d;

/* compiled from: Sta */
public class c implements d.C0000d {
    public final /* synthetic */ d.e a;

    public c(d dVar, d.e eVar) {
        this.a = eVar;
    }

    public void a(Ad ad, CacheKey cacheKey, boolean z) {
        AdEventListener adEventListener = this.a.d;
        if (adEventListener == null) {
            return;
        }
        if (!z || ad == null) {
            adEventListener.onFailedToReceiveAd(ad);
        } else {
            adEventListener.onReceiveAd(ad);
        }
    }
}
