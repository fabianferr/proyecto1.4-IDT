package com.bytedance.sdk.openadsdk.api.reward;

import com.bytedance.sdk.openadsdk.api.model.PAGErrorModel;

public abstract class PAGRewardedAdInteractionCallback {
    public void onAdClicked() {
    }

    public void onAdDismissed() {
    }

    public void onAdShowFailed(PAGErrorModel pAGErrorModel) {
    }

    public void onAdShowed() {
    }

    public void onUserEarnedReward(PAGRewardItem pAGRewardItem) {
    }

    public void onUserEarnedRewardFail(PAGErrorModel pAGErrorModel) {
    }
}
