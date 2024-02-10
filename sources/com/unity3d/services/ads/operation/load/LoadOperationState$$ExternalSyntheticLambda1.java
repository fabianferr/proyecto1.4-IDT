package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.UnityAds;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LoadOperationState$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ LoadOperationState f$0;
    public final /* synthetic */ UnityAds.UnityAdsLoadError f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ LoadOperationState$$ExternalSyntheticLambda1(LoadOperationState loadOperationState, UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        this.f$0 = loadOperationState;
        this.f$1 = unityAdsLoadError;
        this.f$2 = str;
    }

    public final void run() {
        this.f$0.m2238lambda$onUnityAdsFailedToLoad$0$comunity3dservicesadsoperationloadLoadOperationState(this.f$1, this.f$2);
    }
}
