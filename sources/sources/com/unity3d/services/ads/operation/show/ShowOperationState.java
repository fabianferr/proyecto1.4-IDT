package com.unity3d.services.ads.operation.show;

import android.app.Activity;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.services.ads.operation.OperationState;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.misc.Utilities;
import java.lang.ref.WeakReference;

public class ShowOperationState extends OperationState {
    public WeakReference<Activity> activity;
    public IUnityAdsShowListener listener;
    public UnityAdsShowOptions showOptions;

    public ShowOperationState(String str, IUnityAdsShowListener iUnityAdsShowListener, Activity activity2, UnityAdsShowOptions unityAdsShowOptions, Configuration configuration) {
        super(str, configuration);
        this.listener = iUnityAdsShowListener;
        this.activity = new WeakReference<>(activity2);
        this.showOptions = unityAdsShowOptions;
    }

    public void onUnityAdsShowFailure(UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new ShowOperationState$$ExternalSyntheticLambda3(this, unityAdsShowError, str));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onUnityAdsShowFailure$0$com-unity3d-services-ads-operation-show-ShowOperationState  reason: not valid java name */
    public /* synthetic */ void m2241lambda$onUnityAdsShowFailure$0$comunity3dservicesadsoperationshowShowOperationState(UnityAds.UnityAdsShowError unityAdsShowError, String str) {
        this.listener.onUnityAdsShowFailure(this.placementId, unityAdsShowError, str);
    }

    public void onUnityAdsShowClick() {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new ShowOperationState$$ExternalSyntheticLambda1(this));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onUnityAdsShowClick$1$com-unity3d-services-ads-operation-show-ShowOperationState  reason: not valid java name */
    public /* synthetic */ void m2239lambda$onUnityAdsShowClick$1$comunity3dservicesadsoperationshowShowOperationState() {
        this.listener.onUnityAdsShowClick(this.placementId);
    }

    public void onUnityAdsShowStart(String str) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new ShowOperationState$$ExternalSyntheticLambda2(this, str));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onUnityAdsShowStart$2$com-unity3d-services-ads-operation-show-ShowOperationState  reason: not valid java name */
    public /* synthetic */ void m2242lambda$onUnityAdsShowStart$2$comunity3dservicesadsoperationshowShowOperationState(String str) {
        this.listener.onUnityAdsShowStart(str);
    }

    public void onUnityAdsShowComplete(UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        if (this.listener != null) {
            Utilities.wrapCustomerListener(new ShowOperationState$$ExternalSyntheticLambda0(this, unityAdsShowCompletionState));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onUnityAdsShowComplete$3$com-unity3d-services-ads-operation-show-ShowOperationState  reason: not valid java name */
    public /* synthetic */ void m2240lambda$onUnityAdsShowComplete$3$comunity3dservicesadsoperationshowShowOperationState(UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        this.listener.onUnityAdsShowComplete(this.placementId, unityAdsShowCompletionState);
    }
}
