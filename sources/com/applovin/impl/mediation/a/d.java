package com.applovin.impl.mediation.a;

import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class d extends e {
    private final AtomicBoolean c = new AtomicBoolean();
    private final AtomicBoolean d = new AtomicBoolean();

    private d(d dVar, g gVar) {
        super(dVar.V(), dVar.L(), dVar.K(), gVar, dVar.b);
    }

    public d(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, m mVar) {
        super(map, jSONObject, jSONObject2, (g) null, mVar);
    }

    public a a(g gVar) {
        return new d(this, gVar);
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.a.a(maxNativeAdView);
    }

    public MaxNativeAd getNativeAd() {
        if (this.a == null) {
            return null;
        }
        return this.a.b();
    }

    public MaxNativeAdView u() {
        return this.a.c();
    }

    public String v() {
        return BundleUtils.getString("template", "", W());
    }

    public boolean w() {
        return this.a == null;
    }

    public AtomicBoolean x() {
        return this.c;
    }

    public AtomicBoolean y() {
        return this.d;
    }
}
