package com.bytedance.sdk.openadsdk.api.banner;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;

public abstract class PAGBannerAdInteractionCallback implements PAGBannerAdInteractionListener {
    public void onAdClicked() {
    }

    public void onAdDismissed() {
    }

    public void onAdShowFailed(PAGErrorModel pAGErrorModel) {
    }

    public void onAdShowed() {
    }
}
