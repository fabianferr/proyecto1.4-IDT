package com.facebook.ads;

import android.content.Context;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.facebook.ads.Ad;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.internal.api.AdCompanionView;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;

public class RewardedVideoAd implements FullScreenAd {
    public static final int UNSET_VIDEO_DURATION = -1;
    private final RewardedVideoAdApi mRewardedVideoAdApi;

    public interface RewardedVideoAdLoadConfigBuilder extends Ad.LoadConfigBuilder {

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: com.facebook.ads.RewardedVideoAd$RewardedVideoAdLoadConfigBuilder$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        RewardedVideoLoadAdConfig build();

        RewardedVideoAdLoadConfigBuilder withAdCompanionView(boolean z);

        RewardedVideoAdLoadConfigBuilder withAdExperience(AdExperienceType adExperienceType);

        RewardedVideoAdLoadConfigBuilder withAdListener(RewardedVideoAdListener rewardedVideoAdListener);

        RewardedVideoAdLoadConfigBuilder withBid(String str);

        RewardedVideoAdLoadConfigBuilder withFailOnCacheFailureEnabled(boolean z);

        RewardedVideoAdLoadConfigBuilder withRewardData(RewardData rewardData);
    }

    public interface RewardedVideoAdShowConfigBuilder extends FullScreenAd.ShowConfigBuilder {

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: com.facebook.ads.RewardedVideoAd$RewardedVideoAdShowConfigBuilder$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        RewardedVideoShowAdConfig build();

        RewardedVideoAdShowConfigBuilder withAppOrientation(int i);
    }

    public interface RewardedVideoLoadAdConfig extends Ad.LoadAdConfig {
    }

    public interface RewardedVideoShowAdConfig extends FullScreenAd.ShowAdConfig {
    }

    public RewardedVideoAd(Context context, String str) {
        this.mRewardedVideoAdApi = DynamicLoaderFactory.makeLoader(context).createRewardedVideoAd(context, str, this);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mRewardedVideoAdApi.setExtraHints(extraHints);
    }

    public void loadAd() {
        this.mRewardedVideoAdApi.loadAd();
    }

    public void loadAd(RewardedVideoLoadAdConfig rewardedVideoLoadAdConfig) {
        this.mRewardedVideoAdApi.loadAd(rewardedVideoLoadAdConfig);
    }

    public boolean isAdInvalidated() {
        return this.mRewardedVideoAdApi.isAdInvalidated();
    }

    public boolean show() {
        return this.mRewardedVideoAdApi.show();
    }

    public boolean show(RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        return this.mRewardedVideoAdApi.show(rewardedVideoShowAdConfig);
    }

    public void destroy() {
        this.mRewardedVideoAdApi.destroy();
    }

    public boolean isAdLoaded() {
        return this.mRewardedVideoAdApi.isAdLoaded();
    }

    public String getPlacementId() {
        return this.mRewardedVideoAdApi.getPlacementId();
    }

    public int getVideoDuration() {
        return this.mRewardedVideoAdApi.getVideoDuration();
    }

    public RewardedVideoAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mRewardedVideoAdApi.buildLoadAdConfig();
    }

    public RewardedVideoAdShowConfigBuilder buildShowAdConfig() {
        return this.mRewardedVideoAdApi.buildShowAdConfig();
    }

    public void registerAdCompanionView(AdCompanionView adCompanionView) {
        Preconditions.checkIsOnMainThread();
        this.mRewardedVideoAdApi.registerAdCompanionView(adCompanionView);
    }

    public void unregisterAdCompanionView() {
        Preconditions.checkIsOnMainThread();
        this.mRewardedVideoAdApi.unregisterAdCompanionView();
    }
}
