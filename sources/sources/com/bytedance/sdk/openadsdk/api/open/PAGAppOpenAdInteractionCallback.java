package com.bytedance.sdk.openadsdk.api.open;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;

public abstract class PAGAppOpenAdInteractionCallback implements PAGAppOpenAdInteractionListener {
    public void onAdClicked() {
    }

    public void onAdDismissed() {
    }

    public void onAdShowFailed(PAGErrorModel pAGErrorModel) {
    }

    public void onAdShowed() {
    }
}
