package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.banner.banner3d.Banner3DAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: Sta */
public class l2 extends s0 {
    public int i;

    public l2(Context context, Banner3DAd banner3DAd, int i2, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, banner3DAd, adPreferences, adEventListener, AdPreferences.Placement.INAPP_BANNER);
        this.i = i2;
    }

    public void a(Ad ad) {
    }

    public GetAdRequest d() {
        k0 k0Var = new k0();
        a((GetAdRequest) k0Var);
        k0Var.s0 = BannerMetaData.b.a().a();
        k0Var.C0 = this.i;
        k0Var.U0 = ((Banner3DAd) this.b).i();
        k0Var.f(this.a);
        return k0Var;
    }
}
