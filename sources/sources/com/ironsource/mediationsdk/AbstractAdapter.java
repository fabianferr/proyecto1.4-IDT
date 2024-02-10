package com.ironsource.mediationsdk;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdAdapterInterface;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.AdUnitAdapterInterface;
import com.ironsource.mediationsdk.sdk.BannerAdapterInterface;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface;
import com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class AbstractAdapter implements NativeAdAdapterInterface, BannerAdapterInterface, InterstitialAdapterInterface, RewardedVideoAdapterInterface {
    private static Boolean mAdapterDebug;
    private final Map<IronSource.AD_UNIT, AdUnitAdapterInterface> mAdUnitAdapters = new HashMap();
    protected LoadWhileShowSupportState mLWSSupportState = LoadWhileShowSupportState.NONE;
    private String mPluginType;
    private final String mProviderName;

    public AbstractAdapter(String str) {
        this.mProviderName = str;
    }

    private BannerAdapterInterface getBannerAdapter() {
        return (BannerAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.BANNER);
    }

    private InterstitialAdapterInterface getInterstitialAdapter() {
        return (InterstitialAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.INTERSTITIAL);
    }

    private NativeAdAdapterInterface getNativeAdAdapter() {
        return (NativeAdAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.NATIVE_AD);
    }

    private RewardedVideoAdapterInterface getRewardedVideoAdapter() {
        return (RewardedVideoAdapterInterface) this.mAdUnitAdapters.get(IronSource.AD_UNIT.REWARDED_VIDEO);
    }

    public static void postBackgroundThread(Runnable runnable) {
        IronSourceThreadManager.INSTANCE.postAdapterBackgroundTask(runnable);
    }

    public static void postOnUIThread(Runnable runnable) {
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(runnable);
    }

    public void collectBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.collectBannerBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> bannerBiddingData = getBannerBiddingData(jSONObject, jSONObject2);
        if (bannerBiddingData != null) {
            biddingDataCallback.onSuccess(bannerBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void collectInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            interstitialAdapter.collectInterstitialBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> interstitialBiddingData = getInterstitialBiddingData(jSONObject, jSONObject2);
        if (interstitialBiddingData != null) {
            biddingDataCallback.onSuccess(interstitialBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void collectNativeAdBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.collectNativeAdBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> nativeAdBiddingData = getNativeAdBiddingData(jSONObject, jSONObject2);
        if (nativeAdBiddingData != null) {
            biddingDataCallback.onSuccess(nativeAdBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void collectRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.collectRewardedVideoBiddingData(jSONObject, jSONObject2, biddingDataCallback);
            return;
        }
        Map<String, Object> rewardedVideoBiddingData = getRewardedVideoBiddingData(jSONObject, jSONObject2);
        if (rewardedVideoBiddingData != null) {
            biddingDataCallback.onSuccess(rewardedVideoBiddingData);
        } else {
            biddingDataCallback.onFailure("bidding data map is null");
        }
    }

    public void destroyBanner(JSONObject jSONObject) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.destroyBanner(jSONObject);
        }
    }

    public void destroyNativeAd(JSONObject jSONObject) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.destroyNativeAd(jSONObject);
        }
    }

    public void earlyInit(String str, String str2, JSONObject jSONObject) {
    }

    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            return bannerAdapter.getBannerBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public abstract String getCoreSDKVersion();

    public String getDynamicUserId() {
        return z.a().i;
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            return interstitialAdapter.getInterstitialBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject jSONObject) {
        return this.mLWSSupportState;
    }

    public Map<String, Object> getNativeAdBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            return nativeAdAdapter.getNativeAdBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public JSONObject getPlayerBiddingData() {
        return null;
    }

    public String getPluginType() {
        return this.mPluginType;
    }

    public String getProviderName() {
        return this.mProviderName;
    }

    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            return rewardedVideoAdapter.getRewardedVideoBiddingData(jSONObject, jSONObject2);
        }
        return null;
    }

    public abstract String getVersion();

    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.initAndLoadRewardedVideo(str, str2, jSONObject, jSONObject2, rewardedVideoSmashListener);
        } else if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.initBannerForBidding(str, str2, jSONObject, bannerSmashListener);
        } else if (bannerSmashListener != null) {
            bannerSmashListener.onBannerInitFailed(new IronSourceError(510, "method not implemented"));
        }
    }

    public void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.initBanners(str, str2, jSONObject, bannerSmashListener);
        } else if (bannerSmashListener != null) {
            bannerSmashListener.onBannerInitFailed(new IronSourceError(510, "method not implemented"));
        }
    }

    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            interstitialAdapter.initInterstitial(str, str2, jSONObject, interstitialSmashListener);
        } else if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialInitFailed(new IronSourceError(510, "method not implemented"));
        }
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            interstitialAdapter.initInterstitialForBidding(str, str2, jSONObject, interstitialSmashListener);
        } else if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialInitFailed(new IronSourceError(510, "method not implemented"));
        }
    }

    public void initNativeAdForBidding(String str, String str2, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.initNativeAdForBidding(str, str2, jSONObject, nativeAdSmashListener);
        }
    }

    public void initNativeAds(String str, String str2, JSONObject jSONObject, NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.initNativeAds(str, str2, jSONObject, nativeAdSmashListener);
        }
    }

    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.initRewardedVideoForDemandOnly(str, str2, jSONObject, rewardedVideoSmashListener);
        }
    }

    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.initRewardedVideoWithCallback(str, str2, jSONObject, rewardedVideoSmashListener);
        } else if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoInitFailed(new IronSourceError(510, "method not implemented"));
        }
    }

    /* access modifiers changed from: protected */
    public boolean isAdaptersDebugEnabled() {
        Boolean bool = mAdapterDebug;
        return bool != null && bool.booleanValue();
    }

    public boolean isInterstitialReady(JSONObject jSONObject) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            return interstitialAdapter.isInterstitialReady(jSONObject);
        }
        return false;
    }

    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            return rewardedVideoAdapter.isRewardedVideoAvailable(jSONObject);
        }
        return false;
    }

    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return true;
    }

    public void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.loadBanner(jSONObject, jSONObject2, ironSourceBannerLayout, bannerSmashListener);
        }
    }

    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.loadBannerForBidding(jSONObject, jSONObject2, str, ironSourceBannerLayout, bannerSmashListener);
        }
    }

    public void loadBannerForDemandOnlyForBidding(JSONObject jSONObject, String str, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, BannerSmashListener bannerSmashListener) {
        BannerAdapterInterface bannerAdapter = getBannerAdapter();
        if (bannerAdapter != null) {
            bannerAdapter.loadBannerForDemandOnlyForBidding(jSONObject, str, iSDemandOnlyBannerLayout, bannerSmashListener);
        }
    }

    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            interstitialAdapter.loadInterstitial(jSONObject, jSONObject2, interstitialSmashListener);
        }
    }

    public void loadInterstitialForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            interstitialAdapter.loadInterstitialForBidding(jSONObject, jSONObject2, str, interstitialSmashListener);
        }
    }

    public void loadNativeAd(JSONObject jSONObject, JSONObject jSONObject2, NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.loadNativeAd(jSONObject, jSONObject2, nativeAdSmashListener);
        }
    }

    public void loadNativeAdForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, NativeAdSmashListener nativeAdSmashListener) {
        NativeAdAdapterInterface nativeAdAdapter = getNativeAdAdapter();
        if (nativeAdAdapter != null) {
            nativeAdAdapter.loadNativeAdForBidding(jSONObject, jSONObject2, str, nativeAdSmashListener);
        }
    }

    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.loadRewardedVideo(jSONObject, jSONObject2, rewardedVideoSmashListener);
        }
    }

    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.loadRewardedVideoForBidding(jSONObject, jSONObject2, str, rewardedVideoSmashListener);
        }
    }

    public void loadRewardedVideoForDemandOnly(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.loadRewardedVideoForDemandOnly(jSONObject, rewardedVideoSmashListener);
        }
    }

    public void loadRewardedVideoForDemandOnlyForBidding(JSONObject jSONObject, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.loadRewardedVideoForDemandOnlyForBidding(jSONObject, str, rewardedVideoSmashListener);
        }
    }

    public void onNetworkInitCallbackFailed(String str) {
        for (AdUnitAdapterInterface onNetworkInitCallbackFailed : this.mAdUnitAdapters.values()) {
            onNetworkInitCallbackFailed.onNetworkInitCallbackFailed(str);
        }
    }

    public void onNetworkInitCallbackSuccess() {
        for (AdUnitAdapterInterface onNetworkInitCallbackSuccess : this.mAdUnitAdapters.values()) {
            onNetworkInitCallbackSuccess.onNetworkInitCallbackSuccess();
        }
    }

    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + ad_unit);
        ReleaseMemoryAdapterInterface releaseMemoryAdapterInterface = this.mAdUnitAdapters.get(ad_unit);
        if (releaseMemoryAdapterInterface == null) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.verbose(ad_unit + " adapter is null");
            return;
        }
        releaseMemoryAdapterInterface.releaseMemory(ad_unit, jSONObject);
    }

    /* access modifiers changed from: protected */
    public void setAdapterDebug(Boolean bool) {
        mAdapterDebug = bool;
    }

    /* access modifiers changed from: protected */
    public void setBannerAdapter(BannerAdapterInterface bannerAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.BANNER, bannerAdapterInterface);
    }

    /* access modifiers changed from: protected */
    public void setConsent(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void setInterstitialAdapter(InterstitialAdapterInterface interstitialAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.INTERSTITIAL, interstitialAdapterInterface);
    }

    /* access modifiers changed from: protected */
    public void setMetaData(String str, List<String> list) {
    }

    /* access modifiers changed from: protected */
    public void setNativeAdAdapter(NativeAdAdapterInterface nativeAdAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.NATIVE_AD, nativeAdAdapterInterface);
    }

    public void setPluginData(String str) {
        this.mPluginType = str;
    }

    /* access modifiers changed from: protected */
    public void setRewardedVideoAdapter(RewardedVideoAdapterInterface rewardedVideoAdapterInterface) {
        this.mAdUnitAdapters.put(IronSource.AD_UNIT.REWARDED_VIDEO, rewardedVideoAdapterInterface);
    }

    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        InterstitialAdapterInterface interstitialAdapter = getInterstitialAdapter();
        if (interstitialAdapter != null) {
            interstitialAdapter.showInterstitial(jSONObject, interstitialSmashListener);
        }
    }

    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        RewardedVideoAdapterInterface rewardedVideoAdapter = getRewardedVideoAdapter();
        if (rewardedVideoAdapter != null) {
            rewardedVideoAdapter.showRewardedVideo(jSONObject, rewardedVideoSmashListener);
        }
    }
}
