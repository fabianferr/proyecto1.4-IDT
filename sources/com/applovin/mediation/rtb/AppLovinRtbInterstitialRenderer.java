package com.applovin.mediation.rtb;

import android.content.Context;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.ApplovinAdapter;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

public final class AppLovinRtbInterstitialRenderer implements MediationInterstitialAd, AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener {
    private AppLovinAd ad;
    private final MediationInterstitialAdConfiguration adConfiguration;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> callback;
    private AppLovinInterstitialAdDialog interstitialAd;
    private MediationInterstitialAdCallback mInterstitalAdCallback;
    private final AppLovinSdk sdk;

    public AppLovinRtbInterstitialRenderer(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationInterstitialAdConfiguration;
        this.callback = mediationAdLoadCallback;
        this.sdk = AppLovinUtils.retrieveSdk(mediationInterstitialAdConfiguration.getServerParameters(), mediationInterstitialAdConfiguration.getContext());
    }

    public void loadAd() {
        AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.sdk, this.adConfiguration.getContext());
        this.interstitialAd = create;
        create.setAdDisplayListener(this);
        this.interstitialAd.setAdClickListener(this);
        this.interstitialAd.setAdVideoPlaybackListener(this);
        this.sdk.getAdService().loadNextAdForAdToken(this.adConfiguration.getBidResponse(), this);
    }

    public void showAd(Context context) {
        this.sdk.getSettings().setMuted(AppLovinUtils.shouldMuteAudio(this.adConfiguration.getMediationExtras()));
        this.interstitialAd.showAndRender(this.ad);
    }

    public void adReceived(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial did load ad: " + appLovinAd.getAdIdNumber());
        this.ad = appLovinAd;
        this.mInterstitalAdCallback = this.callback.onSuccess(this);
    }

    public void failedToReceiveAd(int i) {
        AdError adError = AppLovinUtils.getAdError(i);
        ApplovinAdapter.log(5, adError.getMessage());
        this.callback.onFailure(adError);
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial displayed.");
        this.mInterstitalAdCallback.reportAdImpression();
        this.mInterstitalAdCallback.onAdOpened();
    }

    public void adHidden(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial hidden.");
        this.mInterstitalAdCallback.onAdClosed();
    }

    public void adClicked(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial clicked.");
        this.mInterstitalAdCallback.reportAdClicked();
        this.mInterstitalAdCallback.onAdLeftApplication();
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        ApplovinAdapter.log(3, "Interstitial video playback began.");
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        ApplovinAdapter.log(3, "Interstitial video playback ended at playback percent: " + d + "%.");
    }
}
