package com.facebook.ads;

import android.content.Context;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.facebook.ads.Ad;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.internal.api.AdCompanionView;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;
import com.facebook.ads.internal.util.common.Preconditions;
import java.util.EnumSet;

public class InterstitialAd implements FullScreenAd {
    private final InterstitialAdApi mInterstitialAdApi;

    public interface InterstitialAdLoadConfigBuilder extends Ad.LoadConfigBuilder {

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: com.facebook.ads.InterstitialAd$InterstitialAdLoadConfigBuilder$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        InterstitialLoadAdConfig build();

        InterstitialAdLoadConfigBuilder withAdCompanionView(boolean z);

        InterstitialAdLoadConfigBuilder withAdListener(InterstitialAdListener interstitialAdListener);

        InterstitialAdLoadConfigBuilder withBid(String str);

        InterstitialAdLoadConfigBuilder withCacheFlags(EnumSet<CacheFlag> enumSet);

        InterstitialAdLoadConfigBuilder withRewardData(RewardData rewardData);

        InterstitialAdLoadConfigBuilder withRewardedAdListener(RewardedAdListener rewardedAdListener);
    }

    public interface InterstitialAdShowConfigBuilder extends FullScreenAd.ShowConfigBuilder {

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: com.facebook.ads.InterstitialAd$InterstitialAdShowConfigBuilder$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        InterstitialShowAdConfig build();
    }

    public interface InterstitialLoadAdConfig extends Ad.LoadAdConfig {
    }

    public interface InterstitialShowAdConfig extends FullScreenAd.ShowAdConfig {
    }

    public InterstitialAd(Context context, String str) {
        this.mInterstitialAdApi = DynamicLoaderFactory.makeLoader(context).createInterstitialAd(context, str, this);
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mInterstitialAdApi.setExtraHints(extraHints);
    }

    public void loadAd() {
        this.mInterstitialAdApi.loadAd();
    }

    public void loadAd(InterstitialLoadAdConfig interstitialLoadAdConfig) {
        this.mInterstitialAdApi.loadAd(interstitialLoadAdConfig);
    }

    public boolean isAdInvalidated() {
        return this.mInterstitialAdApi.isAdInvalidated();
    }

    public void destroy() {
        this.mInterstitialAdApi.destroy();
    }

    public String getPlacementId() {
        return this.mInterstitialAdApi.getPlacementId();
    }

    public boolean isAdLoaded() {
        return this.mInterstitialAdApi.isAdLoaded();
    }

    public boolean show() {
        return this.mInterstitialAdApi.show();
    }

    public boolean show(InterstitialShowAdConfig interstitialShowAdConfig) {
        return this.mInterstitialAdApi.show(interstitialShowAdConfig);
    }

    public InterstitialAdLoadConfigBuilder buildLoadAdConfig() {
        return this.mInterstitialAdApi.buildLoadAdConfig();
    }

    public InterstitialAdShowConfigBuilder buildShowAdConfig() {
        return this.mInterstitialAdApi.buildShowAdConfig();
    }

    public void registerAdCompanionView(AdCompanionView adCompanionView) {
        Preconditions.checkIsOnMainThread();
        this.mInterstitialAdApi.registerAdCompanionView(adCompanionView);
    }

    public void unregisterAdCompanionView() {
        Preconditions.checkIsOnMainThread();
        this.mInterstitialAdApi.unregisterAdCompanionView();
    }
}
