package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.h;
import com.applovin.sdk.AppLovinAdLoadListener;
import org.json.JSONObject;

public class k extends h {
    private final AppLovinAdLoadListener c;

    public k(d dVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        this(dVar, appLovinAdLoadListener, "TaskFetchNextAd", mVar);
    }

    public k(d dVar, AppLovinAdLoadListener appLovinAdLoadListener, String str, m mVar) {
        super(dVar, str, mVar);
        this.c = appLovinAdLoadListener;
    }

    /* access modifiers changed from: protected */
    public a a(JSONObject jSONObject) {
        return new p(jSONObject, this.a, h(), this.c, this.b);
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        super.a(i);
        this.c.failedToReceiveAd(i);
    }

    /* access modifiers changed from: protected */
    public String b() {
        return h.g(this.b);
    }

    /* access modifiers changed from: protected */
    public String c() {
        return h.h(this.b);
    }
}
