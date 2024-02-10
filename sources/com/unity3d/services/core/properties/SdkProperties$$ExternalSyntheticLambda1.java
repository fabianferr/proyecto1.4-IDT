package com.unity3d.services.core.properties;

import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.UnityAds;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SdkProperties$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ IUnityAdsInitializationListener f$0;
    public final /* synthetic */ UnityAds.UnityAdsInitializationError f$1;
    public final /* synthetic */ String f$2;

    public /* synthetic */ SdkProperties$$ExternalSyntheticLambda1(IUnityAdsInitializationListener iUnityAdsInitializationListener, UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
        this.f$0 = iUnityAdsInitializationListener;
        this.f$1 = unityAdsInitializationError;
        this.f$2 = str;
    }

    public final void run() {
        this.f$0.onInitializationFailed(this.f$1, this.f$2);
    }
}
