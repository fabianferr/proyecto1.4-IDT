package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.f.g;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.m;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinPostbackService;

public class PostbackServiceImpl implements AppLovinPostbackService {
    private final m a;

    public PostbackServiceImpl(m mVar) {
        this.a = mVar;
    }

    public void dispatchPostbackAsync(String str, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(i.b(this.a).a(str).c(false).a(), appLovinPostbackListener);
    }

    public void dispatchPostbackRequest(i iVar, o.a aVar, AppLovinPostbackListener appLovinPostbackListener) {
        this.a.S().a((a) new g(iVar, aVar, this.a, appLovinPostbackListener), aVar);
    }

    public void dispatchPostbackRequest(i iVar, AppLovinPostbackListener appLovinPostbackListener) {
        dispatchPostbackRequest(iVar, o.a.POSTBACKS, appLovinPostbackListener);
    }

    public String toString() {
        return "PostbackService{}";
    }
}
