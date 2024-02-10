package com.unity3d.services.ads.gmascar.managers;

import com.unity3d.ads.IUnityAdsTokenListener;

public class BiddingEagerManager extends BiddingBaseManager {
    public void onUnityTokenSuccessfullyFetched() {
    }

    public BiddingEagerManager(IUnityAdsTokenListener iUnityAdsTokenListener) {
        super(iUnityAdsTokenListener);
    }

    public void start() {
        permitSignalsUpload();
        fetchSignals();
    }
}
