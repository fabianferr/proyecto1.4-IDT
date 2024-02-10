package com.unity3d.services.ads.operation.load;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;

public class LoadOperationState extends OperationState {
    public IUnityAdsLoadListener listener;
    public UnityAdsLoadOptions loadOptions;

    public LoadOperationState(String str, IUnityAdsLoadListener iUnityAdsLoadListener, UnityAdsLoadOptions unityAdsLoadOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsLoadListener;
        this.loadOptions = unityAdsLoadOptions;
    }

    public void onUnityAdsFailedToLoad(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new LoadOperationState$$ExternalSyntheticLambda1(this, unityAdsLoadError, str));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onUnityAdsFailedToLoad$0$com-unity3d-services-ads-operation-load-LoadOperationState  reason: not valid java name */
    public /* synthetic */ void m2238lambda$onUnityAdsFailedToLoad$0$comunity3dservicesadsoperationloadLoadOperationState(UnityAds.UnityAdsLoadError unityAdsLoadError, String str) {
        this.listener.onUnityAdsFailedToLoad(this.placementId, unityAdsLoadError, str);
    }

    public void onUnityAdsAdLoaded() {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new LoadOperationState$$ExternalSyntheticLambda0(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onUnityAdsAdLoaded$1$com-unity3d-services-ads-operation-load-LoadOperationState  reason: not valid java name */
    public /* synthetic */ void m2237lambda$onUnityAdsAdLoaded$1$comunity3dservicesadsoperationloadLoadOperationState() {
        this.listener.onUnityAdsAdLoaded(this.placementId);
    }

    public boolean isBanner() {
        return this instanceof LoadBannerOperationState;
    }
}
