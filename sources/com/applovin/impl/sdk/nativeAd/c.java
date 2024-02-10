package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.f.h;
import com.applovin.impl.sdk.m;
import org.json.JSONObject;

public class c extends h {
    private final AppLovinNativeAdLoadListener c;

    public c(d dVar, String str, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, m mVar) {
        super(dVar, str, mVar);
        this.c = appLovinNativeAdLoadListener;
    }

    /* access modifiers changed from: protected */
    public a a(JSONObject jSONObject) {
        return new d(jSONObject, this.c, this.b);
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        super.a(i);
        this.c.onNativeAdLoadFailed(i);
    }

    /* access modifiers changed from: protected */
    public String b() {
        return com.applovin.impl.sdk.utils.h.i(this.b);
    }

    /* access modifiers changed from: protected */
    public String c() {
        return com.applovin.impl.sdk.utils.h.j(this.b);
    }
}
