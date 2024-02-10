package com.unity3d.services.ads;

import com.unity3d.ads.IUnityAdsTokenListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UnityAdsImplementation$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ IUnityAdsTokenListener f$0;

    public /* synthetic */ UnityAdsImplementation$$ExternalSyntheticLambda0(IUnityAdsTokenListener iUnityAdsTokenListener) {
        this.f$0 = iUnityAdsTokenListener;
    }

    public final void run() {
        this.f$0.onUnityAdsTokenReady((String) null);
    }
}
