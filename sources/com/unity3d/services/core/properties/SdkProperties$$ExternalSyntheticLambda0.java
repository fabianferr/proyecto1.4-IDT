package com.unity3d.services.core.properties;

import com.unity3d.ads.IUnityAdsInitializationListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SdkProperties$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ IUnityAdsInitializationListener f$0;

    public /* synthetic */ SdkProperties$$ExternalSyntheticLambda0(IUnityAdsInitializationListener iUnityAdsInitializationListener) {
        this.f$0 = iUnityAdsInitializationListener;
    }

    public final void run() {
        this.f$0.onInitializationComplete();
    }
}
