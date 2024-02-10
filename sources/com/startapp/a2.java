package com.startapp;

import android.content.Context;
import com.startapp.k9;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;

/* compiled from: Sta */
public class a2 implements k9.b {
    public final /* synthetic */ Context a;
    public final /* synthetic */ AdEventListener b;
    public final /* synthetic */ InterstitialAd c;

    public a2(Context context, AdEventListener adEventListener, InterstitialAd interstitialAd) {
        this.a = context;
        this.b = adEventListener;
        this.c = interstitialAd;
    }

    public void a(boolean z, long j, long j2, boolean z2) {
        k.b(this.a, this.b, this.c, true);
    }

    public void a(int i, String str) {
        k.b(this.a, this.b, this.c, true);
    }
}
