package com.unity3d.services;

import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.task.InitializeSDK;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/unity3d/services/UnityAdsSDK;", "Lcom/unity3d/services/core/di/IServiceComponent;", "()V", "initializeSDK", "Lcom/unity3d/services/core/domain/task/InitializeSDK;", "getInitializeSDK", "()Lcom/unity3d/services/core/domain/task/InitializeSDK;", "initializeSDK$delegate", "Lkotlin/Lazy;", "sdkScope", "Lkotlinx/coroutines/CoroutineScope;", "getSdkScope", "()Lkotlinx/coroutines/CoroutineScope;", "sdkScope$delegate", "initialize", "Lkotlinx/coroutines/Job;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UnityAdsSDK.kt */
public final class UnityAdsSDK implements IServiceComponent {
    public static final UnityAdsSDK INSTANCE;
    private static final Lazy initializeSDK$delegate;
    private static final Lazy sdkScope$delegate;

    private UnityAdsSDK() {
    }

    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    static {
        UnityAdsSDK unityAdsSDK = new UnityAdsSDK();
        INSTANCE = unityAdsSDK;
        sdkScope$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$special$$inlined$inject$default$1(unityAdsSDK, "sdk"));
        initializeSDK$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$special$$inlined$inject$default$2(unityAdsSDK, ""));
    }

    private final CoroutineScope getSdkScope() {
        return (CoroutineScope) sdkScope$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final InitializeSDK getInitializeSDK() {
        return (InitializeSDK) initializeSDK$delegate.getValue();
    }

    public final Job initialize() {
        return BuildersKt__Builders_commonKt.launch$default(getSdkScope(), (CoroutineContext) null, (CoroutineStart) null, new UnityAdsSDK$initialize$1((Continuation<? super UnityAdsSDK$initialize$1>) null), 3, (Object) null);
    }
}
