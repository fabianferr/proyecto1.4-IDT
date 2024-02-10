package com.startapp.sdk.ads.offerWall.offerWallJson;

import android.content.Context;
import android.content.Intent;
import com.startapp.i3;
import com.startapp.k9;
import com.startapp.p0;
import com.startapp.q2;
import com.startapp.sdk.ads.list3d.List3DActivity;
import com.startapp.sdk.adsbase.ActivityExtra;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.a;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import com.startapp.sdk.adsbase.d;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.u4;
import com.startapp.v4;
import java.util.UUID;

/* compiled from: Sta */
public class OfferWall3DAd extends JsonAd implements d {
    public static String c = null;
    private static final long serialVersionUID = -8943331518623080551L;
    private final String uuid = UUID.randomUUID().toString();

    public OfferWall3DAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_OFFER_WALL);
        if (c == null) {
            c = k9.a(context);
        }
    }

    @Deprecated
    public boolean a(String str) {
        u4 a = v4.b.a(this.uuid);
        StringBuilder a2 = p0.a("&position=");
        a2.append(a.a());
        a.c = a2.toString();
        ActivityExtra activityExtra = this.activityExtra;
        boolean a3 = activityExtra != null ? activityExtra.a() : false;
        if (super.d()) {
            a(NotDisplayedReason.AD_EXPIRED);
            return false;
        }
        Intent intent = new Intent(this.a, List3DActivity.class);
        intent.putExtra("adInfoOverride", getAdInfoOverride());
        intent.putExtra("fullscreen", a3);
        intent.putExtra("adTag", str);
        intent.putExtra("lastLoadTime", super.b());
        intent.putExtra("adCacheTtl", super.c());
        intent.putExtra("position", a.a());
        intent.putExtra("listModelUuid", this.uuid);
        intent.addFlags(343932928);
        try {
            this.a.startActivity(intent);
            if (AdsConstants.f.booleanValue()) {
                return true;
            }
            setState(Ad.AdState.UN_INITIALIZED);
            return true;
        } catch (Throwable th) {
            i3.a(th);
            return false;
        }
    }

    public Long b() {
        return super.b();
    }

    public Long c() {
        return super.c();
    }

    public boolean d() {
        return super.d();
    }

    public String h() {
        return this.uuid;
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
        new q2(this.a, this, adPreferences, adEventListener).c();
    }

    public boolean a() {
        return super.a();
    }

    public void a(boolean z) {
        super.a(z);
    }
}
