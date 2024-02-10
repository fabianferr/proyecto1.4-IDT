package com.startapp;

import android.content.Context;
import com.startapp.sdk.ads.banner.BannerMetaData;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: Sta */
public class m2 extends r0 {
    public int m;

    public m2(Context context, HtmlAd htmlAd, int i, AdPreferences adPreferences, AdEventListener adEventListener) {
        super(context, htmlAd, adPreferences, adEventListener, AdPreferences.Placement.INAPP_BANNER, false);
        this.m = i;
    }

    public void a(boolean z) {
        super.a(z);
        c(z);
    }

    public GetAdRequest d() {
        BannerStandardAd bannerStandardAd = (BannerStandardAd) this.b;
        k0 k0Var = new k0();
        a((GetAdRequest) k0Var);
        k0Var.L = bannerStandardAd.q();
        k0Var.M = bannerStandardAd.j();
        k0Var.C0 = this.m;
        k0Var.s0 = BannerMetaData.b.a().f();
        k0Var.U0 = bannerStandardAd.x();
        k0Var.V0 = bannerStandardAd.v();
        k0Var.f(this.a);
        return k0Var;
    }
}
