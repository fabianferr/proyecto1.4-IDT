package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;

@Deprecated
public interface RewardedVideoManualListener extends RewardedVideoListener {
    @Deprecated
    void onRewardedVideoAdLoadFailed(IronSourceError ironSourceError);

    @Deprecated
    void onRewardedVideoAdReady();
}
