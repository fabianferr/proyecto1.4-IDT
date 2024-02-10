package com.ironsource.mediationsdk.ads.nativead.interfaces;

import com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\u000b"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdLoadListener;", "", "onAdLoadFailed", "", "nativeAd", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd;", "error", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "onAdLoaded", "adInfo", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface NativeAdLoadListener {
    void onAdLoadFailed(LevelPlayNativeAd levelPlayNativeAd, IronSourceError ironSourceError);

    void onAdLoaded(LevelPlayNativeAd levelPlayNativeAd, AdInfo adInfo);
}
