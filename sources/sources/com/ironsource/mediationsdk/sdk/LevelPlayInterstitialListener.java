package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;

public interface LevelPlayInterstitialListener {
    void onAdClicked(AdInfo adInfo);

    void onAdClosed(AdInfo adInfo);

    void onAdLoadFailed(IronSourceError ironSourceError);

    void onAdOpened(AdInfo adInfo);

    void onAdReady(AdInfo adInfo);

    void onAdShowFailed(IronSourceError ironSourceError, AdInfo adInfo);

    void onAdShowSucceeded(AdInfo adInfo);
}
