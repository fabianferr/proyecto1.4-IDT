package com.vungle.ads.internal.network;

import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class VungleApiClient$$ExternalSyntheticLambda0 implements Interceptor {
    public final /* synthetic */ VungleApiClient f$0;

    public /* synthetic */ VungleApiClient$$ExternalSyntheticLambda0(VungleApiClient vungleApiClient) {
        this.f$0 = vungleApiClient;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return VungleApiClient.m2307responseInterceptor$lambda0(this.f$0, chain);
    }
}
