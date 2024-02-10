package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

@Deprecated
public interface InterstitialListener {
    @Deprecated
    void onInterstitialAdClicked();

    @Deprecated
    void onInterstitialAdClosed();

    @Deprecated
    void onInterstitialAdLoadFailed(IronSourceError ironSourceError);

    @Deprecated
    void onInterstitialAdOpened();

    @Deprecated
    void onInterstitialAdReady();

    @Deprecated
    void onInterstitialAdShowFailed(IronSourceError ironSourceError);

    @Deprecated
    void onInterstitialAdShowSucceeded();
}
