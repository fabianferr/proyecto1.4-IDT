package com.ironsource.adapters.facebook.interstitial;

import android.text.TextUtils;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class FacebookInterstitialAdapter extends AbstractInterstitialAdapter<FacebookAdapter> {
    protected ConcurrentHashMap<String, Boolean> mAdsAvailability = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, InterstitialAd> mPlacementIdToAd = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, FacebookInterstitialAdListener> mPlacementIdToFacebookAdListener = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, Boolean> mPlacementIdToShowAttempts = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, InterstitialSmashListener> mPlacementIdToSmashListener = new ConcurrentHashMap<>();

    public FacebookInterstitialAdapter(FacebookAdapter facebookAdapter) {
        super(facebookAdapter);
    }

    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        initInterstitialInternal(jSONObject, interstitialSmashListener);
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        initInterstitialInternal(jSONObject, interstitialSmashListener);
    }

    private void initInterstitialInternal(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String placementIdKey = ((FacebookAdapter) getAdapter()).getPlacementIdKey();
        String allPlacementIdsKey = ((FacebookAdapter) getAdapter()).getAllPlacementIdsKey();
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, placementIdKey);
        String configStringValueFromKey2 = getConfigStringValueFromKey(jSONObject, allPlacementIdsKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(placementIdKey));
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementIdKey), IronSourceConstants.INTERSTITIAL_AD_UNIT));
        } else if (TextUtils.isEmpty(configStringValueFromKey2)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(allPlacementIdsKey));
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(allPlacementIdsKey), IronSourceConstants.INTERSTITIAL_AD_UNIT));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("placementId = " + configStringValueFromKey);
            this.mPlacementIdToSmashListener.put(configStringValueFromKey, interstitialSmashListener);
            if (((FacebookAdapter) getAdapter()).getInitState() == FacebookAdapter.InitState.INIT_STATE_SUCCESS) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("onInterstitialInitSuccess - placementId = " + configStringValueFromKey);
                interstitialSmashListener.onInterstitialInitSuccess();
            } else if (((FacebookAdapter) getAdapter()).getInitState() == FacebookAdapter.InitState.INIT_STATE_FAILED) {
                IronLog ironLog3 = IronLog.INTERNAL;
                ironLog3.verbose("onInterstitialInitFailed - placementId = " + configStringValueFromKey);
                interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Meta SDK init failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
            } else {
                ((FacebookAdapter) getAdapter()).initSDK(configStringValueFromKey2);
            }
        }
    }

    public void onNetworkInitCallbackSuccess() {
        for (InterstitialSmashListener onInterstitialInitSuccess : this.mPlacementIdToSmashListener.values()) {
            onInterstitialInitSuccess.onInterstitialInitSuccess();
        }
    }

    public void onNetworkInitCallbackFailed(String str) {
        for (InterstitialSmashListener onInterstitialInitFailed : this.mPlacementIdToSmashListener.values()) {
            onInterstitialInitFailed.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.INTERSTITIAL_AD_UNIT));
        }
    }

    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        loadInterstitialInternal(jSONObject, (String) null, interstitialSmashListener);
    }

    public void loadInterstitialForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, InterstitialSmashListener interstitialSmashListener) {
        loadInterstitialInternal(jSONObject, str, interstitialSmashListener);
    }

    private void loadInterstitialInternal(JSONObject jSONObject, final String str, final InterstitialSmashListener interstitialSmashListener) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, ((FacebookAdapter) getAdapter()).getPlacementIdKey());
        this.mPlacementIdToShowAttempts.put(configStringValueFromKey, false);
        this.mAdsAvailability.put(configStringValueFromKey, false);
        postOnUIThread(new Runnable() {
            public void run() {
                try {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("placementId = " + configStringValueFromKey);
                    if (FacebookInterstitialAdapter.this.mPlacementIdToAd.containsKey(configStringValueFromKey)) {
                        IronLog ironLog2 = IronLog.ADAPTER_API;
                        ironLog2.verbose("destroying previous ad with placementId " + configStringValueFromKey);
                        ((InterstitialAd) FacebookInterstitialAdapter.this.mPlacementIdToAd.get(configStringValueFromKey)).destroy();
                        FacebookInterstitialAdapter.this.mPlacementIdToAd.remove(configStringValueFromKey);
                    }
                    InterstitialAd interstitialAd = new InterstitialAd(ContextProvider.getInstance().getApplicationContext(), configStringValueFromKey);
                    FacebookInterstitialAdListener facebookInterstitialAdListener = new FacebookInterstitialAdListener(FacebookInterstitialAdapter.this, configStringValueFromKey, interstitialSmashListener);
                    FacebookInterstitialAdapter.this.mPlacementIdToFacebookAdListener.put(configStringValueFromKey, facebookInterstitialAdListener);
                    InterstitialAd.InterstitialAdLoadConfigBuilder buildLoadAdConfig = interstitialAd.buildLoadAdConfig();
                    EnumSet<CacheFlag> cacheFlags = ((FacebookAdapter) FacebookInterstitialAdapter.this.getAdapter()).getCacheFlags();
                    buildLoadAdConfig.withCacheFlags(cacheFlags);
                    buildLoadAdConfig.withAdListener(facebookInterstitialAdListener);
                    if (!TextUtils.isEmpty(str)) {
                        buildLoadAdConfig.withBid(str);
                    }
                    IronLog ironLog3 = IronLog.ADAPTER_API;
                    ironLog3.verbose("loading placementId = " + configStringValueFromKey + " with facebook cache flags = " + cacheFlags.toString());
                    interstitialAd.loadAd(buildLoadAdConfig.build());
                    FacebookInterstitialAdapter.this.mPlacementIdToAd.put(configStringValueFromKey, interstitialAd);
                } catch (Exception e) {
                    interstitialSmashListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError(e.getLocalizedMessage()));
                }
            }
        });
    }

    public void showInterstitial(JSONObject jSONObject, final InterstitialSmashListener interstitialSmashListener) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, ((FacebookAdapter) getAdapter()).getPlacementIdKey());
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + configStringValueFromKey);
        this.mAdsAvailability.put(configStringValueFromKey, false);
        postOnUIThread(new Runnable() {
            public void run() {
                try {
                    InterstitialAd interstitialAd = (InterstitialAd) FacebookInterstitialAdapter.this.mPlacementIdToAd.get(configStringValueFromKey);
                    if (interstitialAd == null || !interstitialAd.isAdLoaded() || interstitialAd.isAdInvalidated()) {
                        interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.INTERSTITIAL_AD_UNIT));
                        return;
                    }
                    FacebookInterstitialAdapter.this.mPlacementIdToShowAttempts.put(configStringValueFromKey, true);
                    interstitialAd.show();
                } catch (Exception e) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.error("ex.getMessage() = " + e.getMessage());
                    interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.INTERSTITIAL_AD_UNIT, e.getMessage()));
                }
            }
        });
    }

    public final boolean isInterstitialReady(JSONObject jSONObject) {
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, ((FacebookAdapter) getAdapter()).getPlacementIdKey());
        return this.mAdsAvailability.containsKey(configStringValueFromKey) && Boolean.TRUE.equals(this.mAdsAvailability.get(configStringValueFromKey));
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return ((FacebookAdapter) getAdapter()).getBiddingData();
    }

    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        for (InterstitialAd destroy : this.mPlacementIdToAd.values()) {
            destroy.destroy();
        }
        this.mPlacementIdToAd.clear();
        this.mPlacementIdToFacebookAdListener.clear();
        this.mPlacementIdToSmashListener.clear();
        this.mAdsAvailability.clear();
        this.mPlacementIdToShowAttempts.clear();
    }
}
