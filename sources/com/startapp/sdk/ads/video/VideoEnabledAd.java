package com.startapp.sdk.ads.video;

import android.content.Context;
import com.startapp.g4;
import com.startapp.k9;
import com.startapp.m9;
import com.startapp.r9;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.ads.splash.SplashConfig;
import com.startapp.sdk.adsbase.VideoConfig;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public class VideoEnabledAd extends InterstitialAd {
    private static final long serialVersionUID = -1663785294768983014L;
    private VideoAdDetails videoAdDetails = null;

    public VideoEnabledAd(Context context, AdPreferences.Placement placement) {
        super(context, placement);
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new b(this.a, this, adPreferences, adEventListener, this.placement).c();
    }

    public void c(String str) {
        super.c(str);
        String a = k9.a(str, "@videoJson@", "@videoJson@");
        if (a != null) {
            VideoAdDetails videoAdDetails2 = (VideoAdDetails) g4.a(a, VideoAdDetails.class);
            this.videoAdDetails = videoAdDetails2;
            if (videoAdDetails2 != null) {
                videoAdDetails2.p();
            }
        }
    }

    public boolean v() {
        return this.videoAdDetails != null;
    }

    public void w() {
        this.videoAdDetails = null;
    }

    public VideoAdDetails x() {
        return this.videoAdDetails;
    }

    public void a(m9 m9Var, VideoConfig videoConfig, r9 r9Var) {
        this.videoAdDetails = new VideoAdDetails(m9Var, videoConfig, r9Var);
        Integer num = m9Var.q;
        if (num != null && m9Var.r != null) {
            if (num.intValue() > m9Var.r.intValue()) {
                a(SplashConfig.Orientation.LANDSCAPE);
            } else {
                a(SplashConfig.Orientation.PORTRAIT);
            }
        }
    }
}
