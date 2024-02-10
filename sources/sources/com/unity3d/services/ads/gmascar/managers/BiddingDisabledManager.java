package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

public class BiddingDisabledManager extends BiddingBaseManager {
    public String getTokenIdentifier() {
        return null;
    }

    public void onUnityTokenSuccessfullyFetched() {
    }

    public void start() {
    }

    public BiddingDisabledManager(IUnityAdsTokenListener iUnityAdsTokenListener) {
        super(iUnityAdsTokenListener);
    }
}
