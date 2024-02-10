package com.ironsource.adapters.facebook.rewardedvideo;

import android.text.TextUtils;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractRewardedVideoAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

public class FacebookRewardedVideoAdapter extends AbstractRewardedVideoAdapter<FacebookAdapter> {
    protected ConcurrentHashMap<String, Boolean> mAdsAvailability = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, RewardedVideoAd> mPlacementIdToAd = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final ConcurrentHashMap<String, FacebookRewardedVideoAdListener> mPlacementIdToFacebookAdListener = new ConcurrentHashMap<>();
    protected ConcurrentHashMap<String, Boolean> mPlacementIdToShowAttempts = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, RewardedVideoSmashListener> mPlacementIdToSmashListener = new ConcurrentHashMap<>();
    private final CopyOnWriteArraySet<String> mPlacementIdsForInitCallbacks = new CopyOnWriteArraySet<>();

    public FacebookRewardedVideoAdapter(FacebookAdapter facebookAdapter) {
        super(facebookAdapter);
    }

    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        String placementIdKey = ((FacebookAdapter) getAdapter()).getPlacementIdKey();
        String allPlacementIdsKey = ((FacebookAdapter) getAdapter()).getAllPlacementIdsKey();
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, placementIdKey);
        final String configStringValueFromKey2 = getConfigStringValueFromKey(jSONObject, allPlacementIdsKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(placementIdKey));
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        } else if (TextUtils.isEmpty(configStringValueFromKey2)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(allPlacementIdsKey));
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("placementId = " + configStringValueFromKey);
            this.mPlacementIdToSmashListener.put(configStringValueFromKey, rewardedVideoSmashListener);
            postOnUIThread(new Runnable() {
                public void run() {
                    if (((FacebookAdapter) FacebookRewardedVideoAdapter.this.getAdapter()).getInitState() == FacebookAdapter.InitState.INIT_STATE_SUCCESS) {
                        FacebookRewardedVideoAdapter.this.loadRewardedVideoInternal(configStringValueFromKey, (String) null, rewardedVideoSmashListener);
                    } else if (((FacebookAdapter) FacebookRewardedVideoAdapter.this.getAdapter()).getInitState() == FacebookAdapter.InitState.INIT_STATE_FAILED) {
                        IronLog ironLog = IronLog.INTERNAL;
                        ironLog.verbose("onRewardedVideoAvailabilityChanged(false) - placementId = " + configStringValueFromKey);
                        rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                    } else {
                        ((FacebookAdapter) FacebookRewardedVideoAdapter.this.getAdapter()).initSDK(configStringValueFromKey2);
                    }
                }
            });
        }
    }

    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String placementIdKey = ((FacebookAdapter) getAdapter()).getPlacementIdKey();
        String allPlacementIdsKey = ((FacebookAdapter) getAdapter()).getAllPlacementIdsKey();
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, placementIdKey);
        String configStringValueFromKey2 = getConfigStringValueFromKey(jSONObject, allPlacementIdsKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(placementIdKey));
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementIdKey), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else if (TextUtils.isEmpty(configStringValueFromKey2)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(allPlacementIdsKey));
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(allPlacementIdsKey), IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("placementId = " + configStringValueFromKey);
            this.mPlacementIdToSmashListener.put(configStringValueFromKey, rewardedVideoSmashListener);
            this.mPlacementIdsForInitCallbacks.add(configStringValueFromKey);
            if (((FacebookAdapter) getAdapter()).getInitState() == FacebookAdapter.InitState.INIT_STATE_SUCCESS) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("onRewardedVideoInitSuccess - placementId = " + configStringValueFromKey);
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else if (((FacebookAdapter) getAdapter()).getInitState() == FacebookAdapter.InitState.INIT_STATE_FAILED) {
                IronLog ironLog3 = IronLog.INTERNAL;
                ironLog3.verbose("onRewardedVideoInitFailed - placementId = " + configStringValueFromKey);
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Meta SDK init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                ((FacebookAdapter) getAdapter()).initSDK(configStringValueFromKey2);
            }
        }
    }

    public void onNetworkInitCallbackSuccess() {
        for (String next : this.mPlacementIdToSmashListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mPlacementIdToSmashListener.get(next);
            if (this.mPlacementIdsForInitCallbacks.contains(next)) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else {
                loadRewardedVideoInternal(next, (String) null, rewardedVideoSmashListener);
            }
        }
    }

    public void onNetworkInitCallbackFailed(String str) {
        for (String next : this.mPlacementIdToSmashListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mPlacementIdToSmashListener.get(next);
            if (this.mPlacementIdsForInitCallbacks.contains(next)) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        loadRewardedVideoInternal(getConfigStringValueFromKey(jSONObject, ((FacebookAdapter) getAdapter()).getPlacementIdKey()), (String) null, rewardedVideoSmashListener);
    }

    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        loadRewardedVideoInternal(getConfigStringValueFromKey(jSONObject, ((FacebookAdapter) getAdapter()).getPlacementIdKey()), str, rewardedVideoSmashListener);
    }

    /* access modifiers changed from: private */
    public void loadRewardedVideoInternal(final String str, final String str2, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + str);
        this.mAdsAvailability.put(str, false);
        this.mPlacementIdToShowAttempts.put(str, false);
        postOnUIThread(new Runnable() {
            public void run() {
                try {
                    if (FacebookRewardedVideoAdapter.this.mPlacementIdToAd.containsKey(str)) {
                        IronLog ironLog = IronLog.ADAPTER_API;
                        ironLog.verbose("destroying previous ad with placementId " + str);
                        ((RewardedVideoAd) FacebookRewardedVideoAdapter.this.mPlacementIdToAd.get(str)).destroy();
                        FacebookRewardedVideoAdapter.this.mPlacementIdToAd.remove(str);
                    }
                    RewardedVideoAd rewardedVideoAd = new RewardedVideoAd(ContextProvider.getInstance().getApplicationContext(), str);
                    FacebookRewardedVideoAdListener facebookRewardedVideoAdListener = new FacebookRewardedVideoAdListener(FacebookRewardedVideoAdapter.this, str, rewardedVideoSmashListener);
                    FacebookRewardedVideoAdapter.this.mPlacementIdToFacebookAdListener.put(str, facebookRewardedVideoAdListener);
                    RewardedVideoAd.RewardedVideoAdLoadConfigBuilder buildLoadAdConfig = rewardedVideoAd.buildLoadAdConfig();
                    buildLoadAdConfig.withAdListener(facebookRewardedVideoAdListener);
                    if (!TextUtils.isEmpty(str2)) {
                        buildLoadAdConfig.withBid(str2);
                    }
                    if (!TextUtils.isEmpty(((FacebookAdapter) FacebookRewardedVideoAdapter.this.getAdapter()).getDynamicUserId())) {
                        buildLoadAdConfig.withRewardData(new RewardData(((FacebookAdapter) FacebookRewardedVideoAdapter.this.getAdapter()).getDynamicUserId(), ""));
                    }
                    FacebookRewardedVideoAdapter.this.mPlacementIdToAd.put(str, rewardedVideoAd);
                    rewardedVideoAd.loadAd(buildLoadAdConfig.build());
                } catch (Exception unused) {
                    rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
                }
            }
        });
    }

    public void showRewardedVideo(JSONObject jSONObject, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, ((FacebookAdapter) getAdapter()).getPlacementIdKey());
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + configStringValueFromKey);
        postOnUIThread(new Runnable() {
            public void run() {
                RewardedVideoAd rewardedVideoAd = (RewardedVideoAd) FacebookRewardedVideoAdapter.this.mPlacementIdToAd.get(configStringValueFromKey);
                if (rewardedVideoAd == null || !rewardedVideoAd.isAdLoaded() || rewardedVideoAd.isAdInvalidated()) {
                    rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                } else {
                    FacebookRewardedVideoAdapter.this.mPlacementIdToShowAttempts.put(configStringValueFromKey, true);
                    rewardedVideoAd.show();
                }
                FacebookRewardedVideoAdapter.this.mAdsAvailability.put(configStringValueFromKey, false);
            }
        });
    }

    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, ((FacebookAdapter) getAdapter()).getPlacementIdKey());
        return this.mAdsAvailability.containsKey(configStringValueFromKey) && Boolean.TRUE.equals(this.mAdsAvailability.get(configStringValueFromKey));
    }

    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        for (RewardedVideoAd destroy : this.mPlacementIdToAd.values()) {
            destroy.destroy();
        }
        this.mPlacementIdToAd.clear();
        this.mPlacementIdToFacebookAdListener.clear();
        this.mPlacementIdToSmashListener.clear();
        this.mAdsAvailability.clear();
        this.mPlacementIdsForInitCallbacks.clear();
        this.mPlacementIdToShowAttempts.clear();
    }

    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return ((FacebookAdapter) getAdapter()).getBiddingData();
    }
}
