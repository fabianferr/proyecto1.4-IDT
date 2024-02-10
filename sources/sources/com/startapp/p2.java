package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.offerWall.offerWallHtml.OfferWallAd;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: Sta */
public class p2 extends r0 {
    public p2(Context context, OfferWallAd offerWallAd, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, offerWallAd, adPreferences, adEventListener, AdPreferences.Placement.INAPP_OFFER_WALL, true);
    }

    public void a(boolean z) {
        super.a(z);
        c(z);
    }

    public GetAdRequest d() {
        GetAdRequest d = super.d();
        if (d == null) {
            return null;
        }
        d.s0 = AdsCommonMetaData.h.t();
        return d;
    }
}
