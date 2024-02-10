package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Sta */
public class q2 extends s0 {
    public q2(Context context, OfferWall3DAd offerWall3DAd, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, offerWall3DAd, adPreferences, adEventListener, AdPreferences.Placement.INAPP_OFFER_WALL);
    }

    public void a(Ad ad) {
        OfferWall3DAd offerWall3DAd = (OfferWall3DAd) ad;
        List<AdDetails> g = offerWall3DAd.g();
        u4 a = v4.b.a(offerWall3DAd.h());
        a.getClass();
        a.b = new ArrayList();
        a.c = "";
        if (g != null) {
            for (AdDetails a2 : g) {
                a.a(a2);
            }
        }
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
