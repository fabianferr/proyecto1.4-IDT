package com.ironsource.adapters.facebook.banner;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adapter.AbstractBannerAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class FacebookBannerAdapter extends AbstractBannerAdapter<FacebookAdapter> {
    protected ConcurrentHashMap<String, AdView> mPlacementIdToAd = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, BannerSmashListener> mPlacementIdToSmashListener = new ConcurrentHashMap<>();

    public FacebookBannerAdapter(FacebookAdapter facebookAdapter) {
        super(facebookAdapter);
    }

    public void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        initBannersInternal(jSONObject, bannerSmashListener);
    }

    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        initBannersInternal(jSONObject, bannerSmashListener);
    }

    private void initBannersInternal(JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String placementIdKey = ((FacebookAdapter) getAdapter()).getPlacementIdKey();
        String allPlacementIdsKey = ((FacebookAdapter) getAdapter()).getAllPlacementIdsKey();
        String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, placementIdKey);
        String configStringValueFromKey2 = getConfigStringValueFromKey(jSONObject, allPlacementIdsKey);
        if (TextUtils.isEmpty(configStringValueFromKey)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(placementIdKey));
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(placementIdKey), IronSourceConstants.BANNER_AD_UNIT));
        } else if (TextUtils.isEmpty(configStringValueFromKey2)) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(allPlacementIdsKey));
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(allPlacementIdsKey), IronSourceConstants.BANNER_AD_UNIT));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("placementId = " + configStringValueFromKey);
            this.mPlacementIdToSmashListener.put(configStringValueFromKey, bannerSmashListener);
            if (((FacebookAdapter) getAdapter()).getInitState() == FacebookAdapter.InitState.INIT_STATE_SUCCESS) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("onBannerInitSuccess - placementId = " + configStringValueFromKey);
                bannerSmashListener.onBannerInitSuccess();
            } else if (((FacebookAdapter) getAdapter()).getInitState() == FacebookAdapter.InitState.INIT_STATE_FAILED) {
                IronLog ironLog3 = IronLog.INTERNAL;
                ironLog3.verbose("onBannerInitFailed - placementId = " + configStringValueFromKey);
                bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Meta SDK init failed", IronSourceConstants.BANNER_AD_UNIT));
            } else {
                ((FacebookAdapter) getAdapter()).initSDK(configStringValueFromKey2);
            }
        }
    }

    public void onNetworkInitCallbackSuccess() {
        for (BannerSmashListener onBannerInitSuccess : this.mPlacementIdToSmashListener.values()) {
            onBannerInitSuccess.onBannerInitSuccess();
        }
    }

    public void onNetworkInitCallbackFailed(String str) {
        for (BannerSmashListener onBannerInitFailed : this.mPlacementIdToSmashListener.values()) {
            onBannerInitFailed.onBannerInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.BANNER_AD_UNIT));
        }
    }

    public void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        loadBannerInternal(jSONObject, (String) null, ironSourceBannerLayout, bannerSmashListener);
    }

    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        loadBannerInternal(jSONObject, str, ironSourceBannerLayout, bannerSmashListener);
    }

    private void loadBannerInternal(JSONObject jSONObject, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, ((FacebookAdapter) getAdapter()).getPlacementIdKey());
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + configStringValueFromKey);
        if (ironSourceBannerLayout == null) {
            IronLog.INTERNAL.error("banner is null");
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildNoConfigurationAvailableError("banner is null"));
            return;
        }
        final Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        final AdSize calculateBannerSize = calculateBannerSize(ironSourceBannerLayout.getSize(), applicationContext);
        if (calculateBannerSize == null) {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("size not supported, size = " + ironSourceBannerLayout.getSize().getDescription());
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(((FacebookAdapter) getAdapter()).getProviderName()));
            return;
        }
        final IronSourceBannerLayout ironSourceBannerLayout2 = ironSourceBannerLayout;
        final BannerSmashListener bannerSmashListener2 = bannerSmashListener;
        final String str2 = str;
        postOnUIThread(new Runnable() {
            public void run() {
                try {
                    AdView adView = new AdView(applicationContext, configStringValueFromKey, calculateBannerSize);
                    FacebookBannerAdListener facebookBannerAdListener = new FacebookBannerAdListener(FacebookBannerAdapter.this, FacebookBannerAdapter.this.calcLayoutParams(ironSourceBannerLayout2.getSize(), applicationContext), configStringValueFromKey, bannerSmashListener2);
                    AdView.AdViewLoadConfigBuilder buildLoadAdConfig = adView.buildLoadAdConfig();
                    buildLoadAdConfig.withAdListener(facebookBannerAdListener);
                    String str = str2;
                    if (str != null) {
                        buildLoadAdConfig.withBid(str);
                    }
                    FacebookBannerAdapter.this.mPlacementIdToAd.put(configStringValueFromKey, adView);
                    adView.loadAd(buildLoadAdConfig.build());
                } catch (Exception e) {
                    bannerSmashListener2.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Meta loadBanner exception " + e.getMessage()));
                }
            }
        });
    }

    public void destroyBanner(JSONObject jSONObject) {
        final String configStringValueFromKey = getConfigStringValueFromKey(jSONObject, ((FacebookAdapter) getAdapter()).getPlacementIdKey());
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + configStringValueFromKey);
        postOnUIThread(new Runnable() {
            public void run() {
                try {
                    if (FacebookBannerAdapter.this.mPlacementIdToAd.containsKey(configStringValueFromKey)) {
                        FacebookBannerAdapter.this.mPlacementIdToAd.get(configStringValueFromKey).destroy();
                        FacebookBannerAdapter.this.mPlacementIdToAd.remove(configStringValueFromKey);
                    }
                } catch (Exception e) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.error("destroyBanner failed for placementId - " + configStringValueFromKey + " with an exception = " + e);
                }
            }
        });
    }

    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        for (AdView destroy : this.mPlacementIdToAd.values()) {
            destroy.destroy();
        }
        this.mPlacementIdToAd.clear();
        this.mPlacementIdToSmashListener.clear();
    }

    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return ((FacebookAdapter) getAdapter()).getBiddingData();
    }

    private AdSize calculateBannerSize(ISBannerSize iSBannerSize, Context context) {
        String description = iSBannerSize.getDescription();
        description.hashCode();
        char c = 65535;
        switch (description.hashCode()) {
            case -387072689:
                if (description.equals("RECTANGLE")) {
                    c = 0;
                    break;
                }
                break;
            case 72205083:
                if (description.equals("LARGE")) {
                    c = 1;
                    break;
                }
                break;
            case 79011241:
                if (description.equals("SMART")) {
                    c = 2;
                    break;
                }
                break;
            case 1951953708:
                if (description.equals(AdPreferences.TYPE_BANNER)) {
                    c = 3;
                    break;
                }
                break;
            case 1999208305:
                if (description.equals("CUSTOM")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return AdSize.RECTANGLE_HEIGHT_250;
            case 1:
                return AdSize.BANNER_HEIGHT_90;
            case 2:
                return AdapterUtils.isLargeScreen(context) ? AdSize.BANNER_HEIGHT_90 : AdSize.BANNER_HEIGHT_50;
            case 3:
                return AdSize.BANNER_HEIGHT_50;
            case 4:
                if (iSBannerSize.getHeight() == 50) {
                    return AdSize.BANNER_HEIGHT_50;
                }
                if (iSBannerSize.getHeight() == 90) {
                    return AdSize.BANNER_HEIGHT_90;
                }
                if (iSBannerSize.getHeight() == 250) {
                    return AdSize.RECTANGLE_HEIGHT_250;
                }
                return null;
            default:
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams calcLayoutParams(ISBannerSize iSBannerSize, Context context) {
        int i;
        if (iSBannerSize.getDescription().equals("RECTANGLE")) {
            i = 300;
        } else {
            i = (!iSBannerSize.getDescription().equals("SMART") || !AdapterUtils.isLargeScreen(context)) ? 320 : 728;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, i), -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }
}
