package com.startapp.sdk.ads.offerWall.offerWallHtml;

import android.content.Context;
import com.startapp.p2;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public class OfferWallAd extends InterstitialAd {
    private static final long serialVersionUID = 491706973253326971L;

    public OfferWallAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OFFER_WALL);
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new p2(this.a, this, adPreferences, adEventListener).c();
    }
}
