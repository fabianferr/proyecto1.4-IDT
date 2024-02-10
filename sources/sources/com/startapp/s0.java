package com.startapp;

import android.content.Context;
import android.content.Intent;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.JsonAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.b;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.adsbase.model.GetAdResponse;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.z5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: Sta */
public abstract class s0 extends b {
    public int g = 0;
    public Set<String> h = new HashSet();

    /* compiled from: Sta */
    public class a implements g2<Throwable, Void> {
        public a() {
        }

        public Object a(Object obj) {
            Throwable th = (Throwable) obj;
            s0.this.f = th != null ? th.getMessage() : null;
            return null;
        }
    }

    public s0(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, AdPreferences.Placement placement) {
        super(context, ad, adPreferences, adEventListener, placement);
    }

    public abstract void a(Ad ad);

    public boolean a(Object obj) {
        int i;
        GetAdResponse getAdResponse = (GetAdResponse) obj;
        boolean z = false;
        if (obj == null) {
            this.f = "Empty Response";
            return false;
        } else if (!getAdResponse.b()) {
            this.f = getAdResponse.a();
            return false;
        } else {
            JsonAd jsonAd = (JsonAd) this.b;
            List<AdDetails> a2 = d0.a(this.a, getAdResponse.d(), this.g, this.h, true);
            jsonAd.a(a2);
            jsonAd.setAdInfoOverride(getAdResponse.c());
            if (getAdResponse.d() != null && getAdResponse.d().size() > 0) {
                z = true;
            }
            if (!z) {
                this.f = "Empty Response";
            } else if (((ArrayList) a2).size() == 0 && (i = this.g) == 0) {
                this.g = i + 1;
                return b();
            }
            return z;
        }
    }

    public Object e() {
        z5.a aVar;
        GetAdRequest d = d();
        if (d == null) {
            return null;
        }
        if (this.h.size() == 0) {
            this.h.add(this.a.getPackageName());
        }
        int i = this.g;
        boolean z = false;
        if (i > 0) {
            d.J0 = false;
        }
        d.F0 = this.h;
        if (i == 0) {
            z = true;
        }
        d.J0 = z;
        a3 m = ComponentLocator.a(this.a).m();
        Class cls = GetAdResponse.class;
        try {
            aVar = m.a(AdsConstants.a(AdsConstants.AdApiType.JSON, this.e), d, new a());
        } catch (Throwable th) {
            if (m.a(1)) {
                i3.a(th);
            }
            aVar = null;
        }
        if (aVar == null) {
            return null;
        }
        try {
            return g4.a(aVar.b, cls);
        } catch (Throwable th2) {
            i3.a(th2);
            return null;
        }
    }

    public void a(boolean z) {
        super.a(z);
        Intent intent = new Intent("com.startapp.android.OnReceiveResponseBroadcastListener");
        intent.putExtra("adHashcode", this.b.hashCode());
        intent.putExtra("adResult", z);
        w4.a(this.a).a(intent);
        if (z) {
            a((Ad) (JsonAd) this.b);
            k.b(this.a, a(), this.b, false);
        }
    }
}
