package com.startapp;

import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.c;

/* compiled from: Sta */
public class c4 implements AdEventListener {
    public final /* synthetic */ c a;

    public c4(c cVar) {
        this.a = cVar;
    }

    public void onFailedToReceiveAd(Ad ad) {
    }

    public void onReceiveAd(Ad ad) {
        if (this.a.e.showAd()) {
            c cVar = this.a;
            cVar.getClass();
            cVar.c = System.currentTimeMillis();
            cVar.d = 0;
        }
    }
}
