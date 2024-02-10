package com.startapp.sdk.ads.nativead;

import android.content.Context;
import com.startapp.s0;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;

/* compiled from: Sta */
public class a extends s0 {
    public NativeAdPreferences i;

    public a(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, NativeAdPreferences nativeAdPreferences) {
        super(context, ad, adPreferences, adEventListener, AdPreferences.Placement.INAPP_NATIVE);
        this.i = nativeAdPreferences;
    }

    public void a(Ad ad) {
    }

    public GetAdRequest d() {
        GetAdRequest d = super.d();
        if (d == null) {
            return null;
        }
        d.s0 = this.i.getAdsNumber();
        if (this.i.getImageSize() != null) {
            d.L = this.i.getImageSize().getWidth();
            d.M = this.i.getImageSize().getHeight();
        } else {
            int primaryImageSize = this.i.getPrimaryImageSize();
            int i2 = 2;
            if (primaryImageSize == -1) {
                primaryImageSize = 2;
            }
            d.N0 = Integer.toString(primaryImageSize);
            int secondaryImageSize = this.i.getSecondaryImageSize();
            if (secondaryImageSize != -1) {
                i2 = secondaryImageSize;
            }
            d.O0 = Integer.toString(i2);
        }
        if (this.i.isContentAd()) {
            d.P0 = this.i.isContentAd();
        }
        return d;
    }
}
