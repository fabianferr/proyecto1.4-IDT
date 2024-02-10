package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.ad.c;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import java.util.Map;

public class b extends c {
    private final c c;

    public b(c cVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, m mVar) {
        super(d.a("adtoken_zone"), "TaskFetchNativeTokenAd", appLovinNativeAdLoadListener, mVar);
        this.c = cVar;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        Map<String, String> map = CollectionUtils.map(2);
        map.put("adtoken", this.c.a());
        map.put("adtoken_prefix", this.c.c());
        return map;
    }
}
