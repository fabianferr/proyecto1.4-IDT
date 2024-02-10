package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Map;

public class l extends k {
    private final c c;

    public l(c cVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super(d.a("adtoken_zone"), appLovinAdLoadListener, "TaskFetchTokenAd", mVar);
        this.c = cVar;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        Map<String, String> map = CollectionUtils.map(2);
        map.put("adtoken", this.c.a());
        map.put("adtoken_prefix", this.c.c());
        return map;
    }

    /* access modifiers changed from: protected */
    public b h() {
        return b.REGULAR_AD_TOKEN;
    }
}
