package com.applovin.mediation;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;

class AppLovinBannerAdListener implements AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdViewEventListener {
    private final AppLovinAdView mAdView;
    /* access modifiers changed from: private */
    public final ApplovinAdapter mAdapter;
    /* access modifiers changed from: private */
    public final MediationBannerListener mMediationBannerListener;
    private final String mZoneId;

    AppLovinBannerAdListener(String str, AppLovinAdView appLovinAdView, ApplovinAdapter applovinAdapter, MediationBannerListener mediationBannerListener) {
        this.mAdapter = applovinAdapter;
        this.mMediationBannerListener = mediationBannerListener;
        this.mAdView = appLovinAdView;
        this.mZoneId = str;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Banner did load ad: " + appLovinAd.getAdIdNumber() + " for zone: " + this.mZoneId);
        this.mAdView.renderAd(appLovinAd);
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinBannerAdListener.this.mMediationBannerListener.onAdLoaded(AppLovinBannerAdListener.this.mAdapter);
            }
        });
    }

    public void failedToReceiveAd(int i) {
        final AdError adError = AppLovinUtils.getAdError(i);
        ApplovinAdapter.log(5, "Failed to load banner ad with error: " + i);
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AppLovinBannerAdListener.this.mMediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) AppLovinBannerAdListener.this.mAdapter, adError);
            }
        });
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Banner displayed.");
    }

    public void adHidden(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Banner dismissed.");
    }

    public void adClicked(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Banner clicked.");
        this.mMediationBannerListener.onAdClicked(this.mAdapter);
    }

    public void adOpenedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        ApplovinAdapter.log(3, "Banner opened fullscreen.");
        this.mMediationBannerListener.onAdOpened(this.mAdapter);
    }

    public void adClosedFullscreen(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        ApplovinAdapter.log(3, "Banner closed fullscreen.");
        this.mMediationBannerListener.onAdClosed(this.mAdapter);
    }

    public void adLeftApplication(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        ApplovinAdapter.log(3, "Banner left application.");
        this.mMediationBannerListener.onAdLeftApplication(this.mAdapter);
    }

    public void adFailedToDisplay(AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        ApplovinAdapter.log(5, "Banner failed to display: " + appLovinAdViewDisplayErrorCode);
    }
}
