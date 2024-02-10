package com.bytedance.sdk.openadsdk.api.interstitial;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;

public abstract class PAGInterstitialAdInteractionCallback implements PAGInterstitialAdInteractionListener {
    public void onAdClicked() {
    }

    public void onAdDismissed() {
    }

    public void onAdShowFailed(PAGErrorModel pAGErrorModel) {
    }

    public void onAdShowed() {
    }
}
