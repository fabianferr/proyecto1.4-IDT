package com.unity3d.services.ads.operation.show;

import com.unity3d.ads.UnityAds;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ShowOperationState$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ ShowOperationState f$0;
    public final /* synthetic */ UnityAds.UnityAdsShowError f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ ShowOperationState$$ExternalSyntheticLambda3(ShowOperationState showOperationState, UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        this.f$0 = showOperationState;
        this.f$1 = unityAdsShowError;
        this.f$2 = str;
    }

    public final void run() {
        this.f$0.m2241lambda$onUnityAdsShowFailure$0$comunity3dservicesadsoperationshowShowOperationState(this.f$1, this.f$2);
    }
}
