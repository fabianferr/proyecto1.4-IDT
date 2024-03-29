package com.facebook.ads.internal.api;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.RewardedVideoAd;

public interface RewardedVideoAdApi extends FullScreenAd {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.facebook.ads.internal.api.RewardedVideoAdApi$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    RewardedVideoAd.RewardedVideoAdLoadConfigBuilder buildLoadAdConfig();

    RewardedVideoAd.RewardedVideoAdShowConfigBuilder buildShowAdConfig();

    void destroy();

    String getPlacementId();

    int getVideoDuration();

    boolean isAdLoaded();

    void loadAd();

    void loadAd(RewardedVideoAd.RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig);

    void registerAdCompanionView(AdCompanionView adCompanionView);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);

    boolean show();

    boolean show(RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig);

    void unregisterAdCompanionView();
}
