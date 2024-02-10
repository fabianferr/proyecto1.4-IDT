package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

class s extends a {
    private final JSONObject a;
    private final JSONObject c;
    private final AppLovinAdLoadListener d;
    private final b e;

    s(JSONObject jSONObject, JSONObject jSONObject2, b bVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskRenderAppLovinAd", mVar);
        this.a = jSONObject;
        this.c = jSONObject2;
        this.e = bVar;
        this.d = appLovinAdLoadListener;
    }

    public void run() {
        if (u.a()) {
            a("Rendering ad...");
        }
        a aVar = new a(this.a, this.c, this.e, this.b);
        boolean booleanValue = JsonUtils.getBoolean(this.a, "gs_load_immediately", false).booleanValue();
        boolean booleanValue2 = JsonUtils.getBoolean(this.a, "vs_load_immediately", true).booleanValue();
        d dVar = new d(aVar, this.b, this.d);
        dVar.a(booleanValue2);
        dVar.b(booleanValue);
        o.a aVar2 = o.a.CACHING_OTHER;
        if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.bk)).booleanValue()) {
            if (aVar.getSize() == AppLovinAdSize.INTERSTITIAL && aVar.getType() == AppLovinAdType.REGULAR) {
                aVar2 = o.a.CACHING_INTERSTITIAL;
            } else if (aVar.getSize() == AppLovinAdSize.INTERSTITIAL && aVar.getType() == AppLovinAdType.INCENTIVIZED) {
                aVar2 = o.a.CACHING_INCENTIVIZED;
            }
        }
        this.b.S().a((a) dVar, aVar2);
    }
}
