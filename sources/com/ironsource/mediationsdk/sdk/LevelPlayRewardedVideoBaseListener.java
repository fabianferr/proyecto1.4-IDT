package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;

public interface LevelPlayRewardedVideoBaseListener {
    void onAdClicked(Placement placement, AdInfo adInfo);

    void onAdClosed(AdInfo adInfo);

    void onAdOpened(AdInfo adInfo);

    void onAdRewarded(Placement placement, AdInfo adInfo);

    void onAdShowFailed(IronSourceError ironSourceError, AdInfo adInfo);
}
