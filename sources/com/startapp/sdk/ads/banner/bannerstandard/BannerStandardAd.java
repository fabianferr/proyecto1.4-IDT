package com.startapp.sdk.ads.banner.bannerstandard;

import android.content.Context;
import com.startapp.m2;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public class BannerStandardAd extends HtmlAd {
    private static final long serialVersionUID = -1808208904457696295L;
    private int bannerType;
    private boolean fixedSize;
    private int offset;

    public BannerStandardAd(Context context, int i) {
        super(context, AdPreferences.Placement.INAPP_BANNER);
        this.offset = i;
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new m2(this.a, this, this.offset, adPreferences, adEventListener).c();
        this.offset++;
    }

    public void b(boolean z) {
        this.fixedSize = z;
    }

    public void c(int i) {
        this.bannerType = i;
    }

    public int v() {
        return this.bannerType;
    }

    public int w() {
        return this.offset;
    }

    public boolean x() {
        return this.fixedSize;
    }
}
