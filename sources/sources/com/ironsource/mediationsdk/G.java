package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.data.DataKeys;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.bidding.c;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class G implements NativeAdSmashListener, AdapterDebugInterface, AdapterAPSDataInterface, AdapterBaseInterface, AdapterConsentInterface, AdapterMetaDataInterface, AdapterSettingsInterface, c, BannerSmashListener, InterstitialSmashListener, RewardedVideoSmashListener {
    private final AbstractAdapter a;
    private NetworkInitializationListener b;

    public G(AbstractAdapter abstractAdapter) {
        this.a = abstractAdapter;
    }

    public final Map<String, Object> a(AdData adData) {
        JSONObject a2 = com.ironsource.mediationsdk.d.c.a(adData.getConfiguration());
        JSONObject a3 = com.ironsource.mediationsdk.d.c.a(adData.getAdUnitData());
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return this.a.getRewardedVideoBiddingData(a2, a3);
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return this.a.getInterstitialBiddingData(a2, a3);
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return this.a.getBannerBiddingData(a2, a3);
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return this.a.getNativeAdBiddingData(a2, a3);
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error("ad unit not supported - " + ad_unit);
        return null;
    }

    public final void a(AdData adData, BiddingDataCallback biddingDataCallback) {
        JSONObject a2 = com.ironsource.mediationsdk.d.c.a(adData.getConfiguration());
        JSONObject a3 = com.ironsource.mediationsdk.d.c.a(adData.getAdUnitData());
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.a.collectRewardedVideoBiddingData(a2, a3, biddingDataCallback);
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.a.collectInterstitialBiddingData(a2, a3, biddingDataCallback);
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            this.a.collectBannerBiddingData(a2, a3, biddingDataCallback);
        } else if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            this.a.collectNativeAdBiddingData(a2, a3, biddingDataCallback);
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("ad unit not supported - " + ad_unit);
        }
    }

    public final String getAdapterVersion() {
        return this.a.getVersion();
    }

    public final LoadWhileShowSupportState getLoadWhileShowSupportedState(NetworkSettings networkSettings) {
        return this.a.getLoadWhileShowSupportState(networkSettings.getRewardedVideoSettings());
    }

    public final String getNetworkSDKVersion() {
        return this.a.getCoreSDKVersion();
    }

    public final void init(AdData adData, Context context, NetworkInitializationListener networkInitializationListener) {
        this.b = networkInitializationListener;
        String str = (String) adData.getAdUnitData().get(DataKeys.USER_ID);
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        String pluginType = ConfigFile.getConfigFile().getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            this.a.setPluginData(pluginType);
        }
        JSONObject a2 = com.ironsource.mediationsdk.d.c.a(adData.getConfiguration());
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.a.initRewardedVideoWithCallback("", str, a2, this);
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            Integer num = adData.getInt("instanceType");
            if (num == null || num.intValue() != 1) {
                this.a.initInterstitialForBidding("", str, a2, this);
            } else {
                this.a.initInterstitial("", str, a2, this);
            }
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            Integer num2 = adData.getInt("instanceType");
            if (num2 == null || num2.intValue() != 1) {
                this.a.initBannerForBidding("", str, a2, this);
            } else {
                this.a.initBanners("", str, a2, this);
            }
        } else if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            Integer num3 = adData.getInt("instanceType");
            if (num3 == null || num3.intValue() != 1) {
                this.a.initNativeAdForBidding("", str, a2, this);
            } else {
                this.a.initNativeAds("", str, a2, this);
            }
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("ad unit not supported - " + ad_unit);
        }
    }

    public final boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return this.a.isUsingActivityBeforeImpression(ad_unit);
    }

    public final void onBannerAdClicked() {
    }

    public final void onBannerAdLeftApplication() {
    }

    public final void onBannerAdLoadFailed(IronSourceError ironSourceError) {
    }

    public final void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
    }

    public final void onBannerAdScreenDismissed() {
    }

    public final void onBannerAdScreenPresented() {
    }

    public final void onBannerAdShown() {
    }

    public final void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onBannerInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    public final void onInterstitialAdClicked() {
    }

    public final void onInterstitialAdClosed() {
    }

    public final void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
    }

    public final void onInterstitialAdOpened() {
    }

    public final void onInterstitialAdReady() {
    }

    public final void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
    }

    public final void onInterstitialAdShowSucceeded() {
    }

    public final void onInterstitialAdVisible() {
    }

    public final void onInterstitialInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onInterstitialInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    public final void onNativeAdClicked() {
    }

    public final void onNativeAdInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onNativeAdInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    public final void onNativeAdLoadFailed(IronSourceError ironSourceError) {
    }

    public final void onNativeAdLoaded(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
    }

    public final void onNativeAdShown() {
    }

    public final void onRewardedVideoAdClicked() {
    }

    public final void onRewardedVideoAdClosed() {
    }

    public final void onRewardedVideoAdEnded() {
    }

    public final void onRewardedVideoAdOpened() {
    }

    public final void onRewardedVideoAdRewarded() {
    }

    public final void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
    }

    public final void onRewardedVideoAdStarted() {
    }

    public final void onRewardedVideoAdVisible() {
    }

    public final void onRewardedVideoAvailabilityChanged(boolean z) {
    }

    public final void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onRewardedVideoInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    public final void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
    }

    public final void onRewardedVideoLoadSuccess() {
    }

    public final void setAPSData(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        AbstractAdapter abstractAdapter = this.a;
        if (abstractAdapter instanceof SetAPSInterface) {
            ((SetAPSInterface) abstractAdapter).setAPSData(ad_unit, jSONObject);
        }
    }

    public final void setAdapterDebug(boolean z) {
        this.a.setAdapterDebug(Boolean.valueOf(z));
    }

    public final void setConsent(boolean z) {
        this.a.setConsent(z);
    }

    public final void setMetaData(String str, List<String> list) {
        this.a.setMetaData(str, list);
    }
}
