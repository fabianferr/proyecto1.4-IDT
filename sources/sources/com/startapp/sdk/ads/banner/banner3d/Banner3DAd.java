package com.startapp.sdk.ads.banner.banner3d;

import android.content.Context;
import com.startapp.l2;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public class Banner3DAd extends JsonAd {
    private static final long serialVersionUID = -3073776063544193196L;
    private boolean fixedSize;
    private int offset;

    public Banner3DAd(Context context, int i) {
        super(context, AdPreferences.Placement.INAPP_BANNER);
        this.offset = i;
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new l2(this.a, this, this.offset, adPreferences, adEventListener).c();
        this.offset++;
    }

    public void b(boolean z) {
        this.fixedSize = z;
    }

    public int h() {
        return this.offset;
    }

    public boolean i() {
        return this.fixedSize;
    }
}
