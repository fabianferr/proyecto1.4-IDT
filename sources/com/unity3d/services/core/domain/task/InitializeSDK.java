package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.ErrorState;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.InitializeStateError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BU\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ+\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H\u0016J\u0019\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020(H@ø\u0001\u0000¢\u0006\u0002\u0010)R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/unity3d/services/core/domain/task/InitializeSDK;", "Lcom/unity3d/services/core/domain/task/MetricTask;", "Lcom/unity3d/services/core/domain/task/EmptyParams;", "", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "configFileFromLocalStorage", "Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;", "initializeStateReset", "Lcom/unity3d/services/core/domain/task/InitializeStateReset;", "initializeStateError", "Lcom/unity3d/services/core/domain/task/InitializeStateError;", "initializeStateConfig", "Lcom/unity3d/services/core/domain/task/InitializeStateConfig;", "initializeStateCreate", "Lcom/unity3d/services/core/domain/task/InitializeStateCreate;", "initializeStateLoadCache", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache;", "initializeStateCreateWithRemote", "Lcom/unity3d/services/core/domain/task/InitializeStateCreateWithRemote;", "initializeStateLoadWeb", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb;", "initializeStateComplete", "Lcom/unity3d/services/core/domain/task/InitializeStateComplete;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;Lcom/unity3d/services/core/domain/task/InitializeStateReset;Lcom/unity3d/services/core/domain/task/InitializeStateError;Lcom/unity3d/services/core/domain/task/InitializeStateConfig;Lcom/unity3d/services/core/domain/task/InitializeStateCreate;Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache;Lcom/unity3d/services/core/domain/task/InitializeStateCreateWithRemote;Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb;Lcom/unity3d/services/core/domain/task/InitializeStateComplete;)V", "doWork", "params", "(Lcom/unity3d/services/core/domain/task/EmptyParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeErrorState", "errorState", "Lcom/unity3d/services/core/configuration/ErrorState;", "taskException", "", "configuration", "Lcom/unity3d/services/core/configuration/Configuration;", "(Lcom/unity3d/services/core/configuration/ErrorState;Ljava/lang/Throwable;Lcom/unity3d/services/core/configuration/Configuration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMetricName", "", "handleInitializationException", "exception", "Lcom/unity3d/services/core/domain/task/InitializationException;", "(Lcom/unity3d/services/core/domain/task/InitializationException;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InitializeSDK.kt */
public final class InitializeSDK extends MetricTask<EmptyParams, Unit> {
    /* access modifiers changed from: private */
    public final ConfigFileFromLocalStorage configFileFromLocalStorage;
    private final ISDKDispatchers dispatchers;
    /* access modifiers changed from: private */
    public final InitializeStateComplete initializeStateComplete;
    /* access modifiers changed from: private */
    public final InitializeStateConfig initializeStateConfig;
    /* access modifiers changed from: private */
    public final InitializeStateCreate initializeStateCreate;
    /* access modifiers changed from: private */
    public final InitializeStateCreateWithRemote initializeStateCreateWithRemote;
    private final InitializeStateError initializeStateError;
    /* access modifiers changed from: private */
    public final InitializeStateLoadCache initializeStateLoadCache;
    /* access modifiers changed from: private */
    public final InitializeStateLoadWeb initializeStateLoadWeb;
    /* access modifiers changed from: private */
    public final InitializeStateReset initializeStateReset;

    public InitializeSDK(ISDKDispatchers iSDKDispatchers, ConfigFileFromLocalStorage configFileFromLocalStorage2, InitializeStateReset initializeStateReset2, InitializeStateError initializeStateError2, InitializeStateConfig initializeStateConfig2, InitializeStateCreate initializeStateCreate2, InitializeStateLoadCache initializeStateLoadCache2, InitializeStateCreateWithRemote initializeStateCreateWithRemote2, InitializeStateLoadWeb initializeStateLoadWeb2, InitializeStateComplete initializeStateComplete2) {
        Intrinsics.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(configFileFromLocalStorage2, "configFileFromLocalStorage");
        Intrinsics.checkNotNullParameter(initializeStateReset2, "initializeStateReset");
        Intrinsics.checkNotNullParameter(initializeStateError2, "initializeStateError");
        Intrinsics.checkNotNullParameter(initializeStateConfig2, "initializeStateConfig");
        Intrinsics.checkNotNullParameter(initializeStateCreate2, "initializeStateCreate");
        Intrinsics.checkNotNullParameter(initializeStateLoadCache2, "initializeStateLoadCache");
        Intrinsics.checkNotNullParameter(initializeStateCreateWithRemote2, "initializeStateCreateWithRemote");
        Intrinsics.checkNotNullParameter(initializeStateLoadWeb2, "initializeStateLoadWeb");
        Intrinsics.checkNotNullParameter(initializeStateComplete2, "initializeStateComplete");
        this.dispatchers = iSDKDispatchers;
        this.configFileFromLocalStorage = configFileFromLocalStorage2;
        this.initializeStateReset = initializeStateReset2;
        this.initializeStateError = initializeStateError2;
        this.initializeStateConfig = initializeStateConfig2;
        this.initializeStateCreate = initializeStateCreate2;
        this.initializeStateLoadCache = initializeStateLoadCache2;
        this.initializeStateCreateWithRemote = initializeStateCreateWithRemote2;
        this.initializeStateLoadWeb = initializeStateLoadWeb2;
        this.initializeStateComplete = initializeStateComplete2;
    }

    public String getMetricName() {
        return getMetricNameForInitializeTask(MobileAdsBridgeBase.initializeMethodName);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(com.unity3d.services.core.domain.task.EmptyParams r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r5 = r6 instanceof com.unity3d.services.core.domain.task.InitializeSDK$doWork$1
            if (r5 == 0) goto L_0x0014
            r5 = r6
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$1 r5 = (com.unity3d.services.core.domain.task.InitializeSDK$doWork$1) r5
            int r0 = r5.label
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0014
            int r6 = r5.label
            int r6 = r6 - r1
            r5.label = r6
            goto L_0x0019
        L_0x0014:
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$1 r5 = new com.unity3d.services.core.domain.task.InitializeSDK$doWork$1
            r5.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r5.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            if (r1 == 0) goto L_0x0032
            if (r1 != r2) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.unity3d.services.core.domain.ISDKDispatchers r6 = r4.dispatchers
            kotlinx.coroutines.CoroutineDispatcher r6 = r6.getDefault()
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$2 r1 = new com.unity3d.services.core.domain.task.InitializeSDK$doWork$2
            r3 = 0
            r1.<init>(r4, r3)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r5.label = r2
            java.lang.Object r5 = kotlinx.coroutines.BuildersKt.withContext(r6, r1, r5)
            if (r5 != r0) goto L_0x004e
            return r0
        L_0x004e:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK.doWork(com.unity3d.services.core.domain.task.EmptyParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handleInitializationException(com.unity3d.services.core.domain.task.InitializationException r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1 r0 = (com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1 r0 = new com.unity3d.services.core.domain.task.InitializeSDK$handleInitializationException$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 == r3) goto L_0x002e
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x002e:
            java.lang.Object r6 = r0.L$0
            com.unity3d.services.core.domain.task.InitializationException r6 = (com.unity3d.services.core.domain.task.InitializationException) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0052
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r7)
            com.unity3d.services.core.configuration.ErrorState r7 = r6.getErrorState()
            java.lang.Exception r2 = r6.getOriginalException()
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            com.unity3d.services.core.configuration.Configuration r4 = r6.getConfig()
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r7 = r5.executeErrorState(r7, r2, r4, r0)
            if (r7 != r1) goto L_0x0052
            return r1
        L_0x0052:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK.handleInitializationException(com.unity3d.services.core.domain.task.InitializationException, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object executeErrorState(ErrorState errorState, Throwable th, Configuration configuration, Continuation<? super Unit> continuation) {
        Object invoke = this.initializeStateError.invoke(new InitializeStateError.Params(errorState, new Exception(th != null ? th.getMessage() : null), configuration), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}
