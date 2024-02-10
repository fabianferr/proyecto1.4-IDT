package com.startapp.sdk.adsbase.cache;

import com.startapp.k;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.h;

/* compiled from: Sta */
public class f implements AdEventListener {
    public final /* synthetic */ h.a a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ h c;

    public f(h hVar, h.a aVar, boolean z) {
        this.c = hVar;
        this.a = aVar;
        this.b = z;
    }

    public void onFailedToReceiveAd(Ad ad) {
        h hVar = this.c;
        hVar.e = null;
        hVar.a(this.b);
    }

    public void onReceiveAd(Ad ad) {
        k.b(this.c.b, this.a, ad, true);
    }
}
