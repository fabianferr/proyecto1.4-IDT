package com.startapp.sdk.ads.nativead;

import android.content.Context;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public class NativeAd extends JsonAd {
    private static final long serialVersionUID = 7310462914813630357L;
    private NativeAdPreferences config;

    public NativeAd(Context context, NativeAdPreferences nativeAdPreferences) {
        super(context, AdPreferences.Placement.INAPP_NATIVE);
        this.config = nativeAdPreferences;
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new a(this.a, this, adPreferences, adEventListener, this.config).c();
    }
}
