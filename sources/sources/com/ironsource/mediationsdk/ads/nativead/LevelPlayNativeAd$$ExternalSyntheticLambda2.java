package com.ironsource.mediationsdk.ads.nativead;

import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LevelPlayNativeAd$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ LevelPlayNativeAd f$0;
    public final /* synthetic */ AdapterNativeAdData f$1;
    public final /* synthetic */ AdapterNativeAdViewBinder f$2;
    public final /* synthetic */ AdInfo f$3;

    public /* synthetic */ LevelPlayNativeAd$$ExternalSyntheticLambda2(LevelPlayNativeAd levelPlayNativeAd, AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder, AdInfo adInfo) {
        this.f$0 = levelPlayNativeAd;
        this.f$1 = adapterNativeAdData;
        this.f$2 = adapterNativeAdViewBinder;
        this.f$3 = adInfo;
    }

    public final void run() {
        LevelPlayNativeAd.a(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
