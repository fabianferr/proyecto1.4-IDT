package com.startapp.sdk.ads.interstitials;

import android.content.Context;
import com.startapp.s2;
import com.startapp.sdk.ads.video.VideoEnabledAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public class ReturnAd extends VideoEnabledAd {
    private static final long serialVersionUID = -4485796021684048466L;

    public ReturnAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_RETURN);
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new s2(this.a, this, adPreferences, adEventListener).c();
    }

    public long e() {
        return CacheMetaData.a.a().e();
    }
}
