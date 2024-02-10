package com.ironsource.mediationsdk.ads.nativead.interfaces;

import com.ironsource.mediationsdk.ads.nativead.LevelPlayNativeAd;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\t"}, d2 = {"Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdInteractionListener;", "", "onAdClicked", "", "nativeAd", "Lcom/ironsource/mediationsdk/ads/nativead/LevelPlayNativeAd;", "adInfo", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "onAdImpression", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface NativeAdInteractionListener {
    void onAdClicked(LevelPlayNativeAd levelPlayNativeAd, AdInfo adInfo);

    void onAdImpression(LevelPlayNativeAd levelPlayNativeAd, AdInfo adInfo);
}
