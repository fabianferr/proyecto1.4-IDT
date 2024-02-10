package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;

@Deprecated
public interface RewardedVideoListener {
    @Deprecated
    void onRewardedVideoAdClicked(Placement placement);

    @Deprecated
    void onRewardedVideoAdClosed();

    @Deprecated
    void onRewardedVideoAdEnded();

    @Deprecated
    void onRewardedVideoAdOpened();

    @Deprecated
    void onRewardedVideoAdRewarded(Placement placement);

    @Deprecated
    void onRewardedVideoAdShowFailed(IronSourceError ironSourceError);

    @Deprecated
    void onRewardedVideoAdStarted();

    @Deprecated
    void onRewardedVideoAvailabilityChanged(boolean z);
}
