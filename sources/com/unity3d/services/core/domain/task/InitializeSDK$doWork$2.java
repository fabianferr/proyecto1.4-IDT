package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2", f = "InitializeSDK.kt", i = {0, 1, 1, 2, 3, 3, 4, 4, 4, 5, 5, 5, 7, 7, 7, 8, 8, 8, 9, 10, 10, 11, 11, 11, 12, 13}, l = {41, 46, 48, 53, 55, 61, 66, 69, 75, 77, 90, 92, 101, 103, 106}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "configuration", "resetResult", "$this$withContext", "configuration", "$this$withContext", "configuration", "configResult", "$this$withContext", "configuration", "configResult", "$this$withContext", "configuration", "configResult", "$this$withContext", "configuration", "configResult", "loadCacheResult", "$this$withContext", "configResult", "$this$withContext", "configResult", "loadWebResult", "configResult", "configResult"}, s = {"L$0", "L$0", "L$1", "L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$0"})
/* compiled from: InitializeSDK.kt */
final class InitializeSDK$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this.this$0, continuation);
        initializeSDK$doWork$2.L$0 = obj;
        return initializeSDK$doWork$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeSDK$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v89, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v43, resolved type: kotlinx.coroutines.CoroutineScope} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00f2, code lost:
        r12 = kotlin.Result.m2344constructorimpl((com.unity3d.services.core.configuration.Configuration) r12);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x028e A[Catch:{ all -> 0x0059 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x02d7  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0355  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03a9 A[Catch:{ all -> 0x0025 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x03c1  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0400 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01eb  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x024f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 0
            switch(r1) {
                case 0: goto L_0x00c0;
                case 1: goto L_0x00b8;
                case 2: goto L_0x00a8;
                case 3: goto L_0x00a1;
                case 4: goto L_0x0091;
                case 5: goto L_0x0082;
                case 6: goto L_0x0070;
                case 7: goto L_0x006b;
                case 8: goto L_0x005c;
                case 9: goto L_0x004a;
                case 10: goto L_0x0043;
                case 11: goto L_0x0035;
                case 12: goto L_0x0028;
                case 13: goto L_0x001e;
                case 14: goto L_0x0017;
                case 15: goto L_0x0012;
                default: goto L_0x000a;
            }
        L_0x000a:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0012:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0401
        L_0x0017:
            java.lang.Object r1 = r11.L$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x03db
        L_0x001e:
            java.lang.Object r1 = r11.L$0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0025 }
            goto L_0x03aa
        L_0x0025:
            r12 = move-exception
            goto L_0x03b1
        L_0x0028:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r3 = r11.L$1
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0370
        L_0x0035:
            java.lang.Object r1 = r11.L$1
            java.lang.Object r3 = r11.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0040 }
            goto L_0x0339
        L_0x0040:
            r12 = move-exception
            goto L_0x0342
        L_0x0043:
            java.lang.Object r0 = r11.L$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x02c3
        L_0x004a:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r3 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r3 = (com.unity3d.services.core.configuration.Configuration) r3
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x0059 }
            goto L_0x028f
        L_0x0059:
            r12 = move-exception
            goto L_0x0296
        L_0x005c:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r3 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r3 = (com.unity3d.services.core.configuration.Configuration) r3
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0269
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x024c
        L_0x0070:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r3 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r3 = (com.unity3d.services.core.configuration.Configuration) r3
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x007f }
            goto L_0x0210
        L_0x007f:
            r12 = move-exception
            goto L_0x0217
        L_0x0082:
            java.lang.Object r1 = r11.L$2
            java.lang.Object r3 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r3 = (com.unity3d.services.core.configuration.Configuration) r3
            java.lang.Object r4 = r11.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x01e1
        L_0x0091:
            java.lang.Object r1 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r1 = (com.unity3d.services.core.configuration.Configuration) r1
            java.lang.Object r3 = r11.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x009e }
            goto L_0x01ae
        L_0x009e:
            r12 = move-exception
            goto L_0x01b5
        L_0x00a1:
            java.lang.Object r0 = r11.L$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x017d
        L_0x00a8:
            java.lang.Object r1 = r11.L$1
            com.unity3d.services.core.configuration.Configuration r1 = (com.unity3d.services.core.configuration.Configuration) r1
            java.lang.Object r3 = r11.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x00b5 }
            goto L_0x014c
        L_0x00b5:
            r12 = move-exception
            goto L_0x0153
        L_0x00b8:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x00f9 }
            goto L_0x00f2
        L_0x00c0:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r1 = r12
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.unity3d.services.core.configuration.IInitializeEventsMetricSender r12 = com.unity3d.services.core.configuration.InitializeEventsMetricSender.getInstance()
            r12.didInitStart()
            com.unity3d.services.core.lifecycle.CachedLifecycle.register()
            java.lang.String r12 = "Unity Ads Init: Loading Config File From Local Storage"
            com.unity3d.services.core.log.DeviceLog.debug(r12)
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x00f9 }
            com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage r12 = r12.configFileFromLocalStorage     // Catch:{ all -> 0x00f9 }
            com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$Params r3 = new com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$Params     // Catch:{ all -> 0x00f9 }
            r3.<init>()     // Catch:{ all -> 0x00f9 }
            com.unity3d.services.core.domain.task.BaseParams r3 = (com.unity3d.services.core.domain.task.BaseParams) r3     // Catch:{ all -> 0x00f9 }
            r11.L$0 = r1     // Catch:{ all -> 0x00f9 }
            r4 = 1
            r11.label = r4     // Catch:{ all -> 0x00f9 }
            java.lang.Object r12 = r12.invoke(r3, r11)     // Catch:{ all -> 0x00f9 }
            if (r12 != r0) goto L_0x00f2
            return r0
        L_0x00f2:
            com.unity3d.services.core.configuration.Configuration r12 = (com.unity3d.services.core.configuration.Configuration) r12     // Catch:{ all -> 0x00f9 }
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)     // Catch:{ all -> 0x00f9 }
            goto L_0x0104
        L_0x00f9:
            r12 = move-exception
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)
        L_0x0104:
            r3 = r1
            java.lang.Throwable r1 = kotlin.Result.m2347exceptionOrNullimpl(r12)
            if (r1 == 0) goto L_0x0120
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Unity Ads Init: Could not load config file from local storage: "
            r4.<init>(r5)
            java.lang.String r1 = r1.getMessage()
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r1)
        L_0x0120:
            com.unity3d.services.core.configuration.Configuration r1 = new com.unity3d.services.core.configuration.Configuration
            r1.<init>()
            boolean r4 = kotlin.Result.m2350isFailureimpl(r12)
            if (r4 == 0) goto L_0x012c
            r12 = r1
        L_0x012c:
            r1 = r12
            com.unity3d.services.core.configuration.Configuration r1 = (com.unity3d.services.core.configuration.Configuration) r1
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x00b5 }
            com.unity3d.services.core.domain.task.InitializeStateReset r12 = r12.initializeStateReset     // Catch:{ all -> 0x00b5 }
            com.unity3d.services.core.domain.task.InitializeStateReset$Params r4 = new com.unity3d.services.core.domain.task.InitializeStateReset$Params     // Catch:{ all -> 0x00b5 }
            r4.<init>(r1)     // Catch:{ all -> 0x00b5 }
            com.unity3d.services.core.domain.task.BaseParams r4 = (com.unity3d.services.core.domain.task.BaseParams) r4     // Catch:{ all -> 0x00b5 }
            r11.L$0 = r3     // Catch:{ all -> 0x00b5 }
            r11.L$1 = r1     // Catch:{ all -> 0x00b5 }
            r5 = 2
            r11.label = r5     // Catch:{ all -> 0x00b5 }
            java.lang.Object r12 = r12.invoke(r4, r11)     // Catch:{ all -> 0x00b5 }
            if (r12 != r0) goto L_0x014c
            return r0
        L_0x014c:
            com.unity3d.services.core.configuration.Configuration r12 = (com.unity3d.services.core.configuration.Configuration) r12     // Catch:{ all -> 0x00b5 }
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)     // Catch:{ all -> 0x00b5 }
            goto L_0x015d
        L_0x0153:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)
        L_0x015d:
            boolean r4 = kotlin.Result.m2350isFailureimpl(r12)
            if (r4 == 0) goto L_0x0191
            com.unity3d.services.core.domain.task.InitializeSDK r3 = r11.this$0
            com.unity3d.services.core.configuration.ErrorState r4 = com.unity3d.services.core.configuration.ErrorState.ResetWebApp
            java.lang.Throwable r5 = kotlin.Result.m2347exceptionOrNullimpl(r12)
            r6 = r11
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r11.L$0 = r12
            r11.L$1 = r2
            r2 = 3
            r11.label = r2
            java.lang.Object r1 = r3.executeErrorState(r4, r5, r1, r6)
            if (r1 != r0) goto L_0x017c
            return r0
        L_0x017c:
            r0 = r12
        L_0x017d:
            java.lang.Throwable r12 = kotlin.Result.m2347exceptionOrNullimpl(r0)
            if (r12 != 0) goto L_0x0190
            java.lang.Exception r12 = new java.lang.Exception
            com.unity3d.services.core.configuration.ErrorState r0 = com.unity3d.services.core.configuration.ErrorState.ResetWebApp
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            java.lang.Throwable r12 = (java.lang.Throwable) r12
        L_0x0190:
            throw r12
        L_0x0191:
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x009e }
            com.unity3d.services.core.domain.task.InitializeStateConfig r12 = r12.initializeStateConfig     // Catch:{ all -> 0x009e }
            com.unity3d.services.core.domain.task.InitializeStateConfig$Params r4 = new com.unity3d.services.core.domain.task.InitializeStateConfig$Params     // Catch:{ all -> 0x009e }
            r4.<init>(r1)     // Catch:{ all -> 0x009e }
            com.unity3d.services.core.domain.task.BaseParams r4 = (com.unity3d.services.core.domain.task.BaseParams) r4     // Catch:{ all -> 0x009e }
            r11.L$0 = r3     // Catch:{ all -> 0x009e }
            r11.L$1 = r1     // Catch:{ all -> 0x009e }
            r5 = 4
            r11.label = r5     // Catch:{ all -> 0x009e }
            java.lang.Object r12 = r12.invoke(r4, r11)     // Catch:{ all -> 0x009e }
            if (r12 != r0) goto L_0x01ae
            return r0
        L_0x01ae:
            com.unity3d.services.core.configuration.Configuration r12 = (com.unity3d.services.core.configuration.Configuration) r12     // Catch:{ all -> 0x009e }
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)     // Catch:{ all -> 0x009e }
            goto L_0x01bf
        L_0x01b5:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)
        L_0x01bf:
            r4 = r3
            r3 = r1
            r1 = r12
            boolean r12 = kotlin.Result.m2350isFailureimpl(r1)
            if (r12 == 0) goto L_0x01e1
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            com.unity3d.services.core.domain.task.InitializationException r5 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r1)
            r6 = r11
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r11.L$0 = r4
            r11.L$1 = r3
            r11.L$2 = r1
            r7 = 5
            r11.label = r7
            java.lang.Object r12 = r12.handleInitializationException(r5, r6)
            if (r12 != r0) goto L_0x01e1
            return r0
        L_0x01e1:
            com.unity3d.services.core.configuration.IExperiments r12 = r3.getExperiments()
            boolean r12 = r12.isNativeWebViewCacheEnabled()
            if (r12 == 0) goto L_0x0269
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x007f }
            com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote r12 = r12.initializeStateCreateWithRemote     // Catch:{ all -> 0x007f }
            com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote$Params r5 = new com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote$Params     // Catch:{ all -> 0x007f }
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x007f }
            r6 = r1
            com.unity3d.services.core.configuration.Configuration r6 = (com.unity3d.services.core.configuration.Configuration) r6     // Catch:{ all -> 0x007f }
            r5.<init>(r6)     // Catch:{ all -> 0x007f }
            com.unity3d.services.core.domain.task.BaseParams r5 = (com.unity3d.services.core.domain.task.BaseParams) r5     // Catch:{ all -> 0x007f }
            r11.L$0 = r4     // Catch:{ all -> 0x007f }
            r11.L$1 = r3     // Catch:{ all -> 0x007f }
            r11.L$2 = r1     // Catch:{ all -> 0x007f }
            r6 = 6
            r11.label = r6     // Catch:{ all -> 0x007f }
            java.lang.Object r12 = r12.invoke(r5, r11)     // Catch:{ all -> 0x007f }
            if (r12 != r0) goto L_0x0210
            return r0
        L_0x0210:
            com.unity3d.services.core.configuration.Configuration r12 = (com.unity3d.services.core.configuration.Configuration) r12     // Catch:{ all -> 0x007f }
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)     // Catch:{ all -> 0x007f }
            goto L_0x0221
        L_0x0217:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)
        L_0x0221:
            boolean r5 = kotlin.Result.m2351isSuccessimpl(r12)
            if (r5 == 0) goto L_0x024f
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            com.unity3d.services.core.domain.task.InitializeStateComplete r12 = r12.initializeStateComplete
            com.unity3d.services.core.domain.task.InitializeStateComplete$Params r3 = new com.unity3d.services.core.domain.task.InitializeStateComplete$Params
            kotlin.ResultKt.throwOnFailure(r1)
            com.unity3d.services.core.configuration.Configuration r1 = (com.unity3d.services.core.configuration.Configuration) r1
            r3.<init>(r1)
            com.unity3d.services.core.domain.task.BaseParams r3 = (com.unity3d.services.core.domain.task.BaseParams) r3
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.L$0 = r2
            r11.L$1 = r2
            r11.L$2 = r2
            r2 = 7
            r11.label = r2
            java.lang.Object r12 = r12.invoke(r3, r1)
            if (r12 != r0) goto L_0x024c
            return r0
        L_0x024c:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x024f:
            com.unity3d.services.core.domain.task.InitializeSDK r5 = r11.this$0
            com.unity3d.services.core.domain.task.InitializationException r12 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r12)
            r6 = r11
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r11.L$0 = r4
            r11.L$1 = r3
            r11.L$2 = r1
            r7 = 8
            r11.label = r7
            java.lang.Object r12 = r5.handleInitializationException(r12, r6)
            if (r12 != r0) goto L_0x0269
            return r0
        L_0x0269:
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0059 }
            com.unity3d.services.core.domain.task.InitializeStateLoadCache r12 = r12.initializeStateLoadCache     // Catch:{ all -> 0x0059 }
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$Params r5 = new com.unity3d.services.core.domain.task.InitializeStateLoadCache$Params     // Catch:{ all -> 0x0059 }
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x0059 }
            r6 = r1
            com.unity3d.services.core.configuration.Configuration r6 = (com.unity3d.services.core.configuration.Configuration) r6     // Catch:{ all -> 0x0059 }
            r5.<init>(r6)     // Catch:{ all -> 0x0059 }
            com.unity3d.services.core.domain.task.BaseParams r5 = (com.unity3d.services.core.domain.task.BaseParams) r5     // Catch:{ all -> 0x0059 }
            r11.L$0 = r4     // Catch:{ all -> 0x0059 }
            r11.L$1 = r3     // Catch:{ all -> 0x0059 }
            r11.L$2 = r1     // Catch:{ all -> 0x0059 }
            r6 = 9
            r11.label = r6     // Catch:{ all -> 0x0059 }
            java.lang.Object r12 = r12.invoke(r5, r11)     // Catch:{ all -> 0x0059 }
            if (r12 != r0) goto L_0x028f
            return r0
        L_0x028f:
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$LoadCacheResult r12 = (com.unity3d.services.core.domain.task.InitializeStateLoadCache.LoadCacheResult) r12     // Catch:{ all -> 0x0059 }
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)     // Catch:{ all -> 0x0059 }
            goto L_0x02a0
        L_0x0296:
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)
        L_0x02a0:
            boolean r5 = kotlin.Result.m2350isFailureimpl(r12)
            if (r5 == 0) goto L_0x02d7
            com.unity3d.services.core.domain.task.InitializeSDK r1 = r11.this$0
            com.unity3d.services.core.configuration.ErrorState r4 = com.unity3d.services.core.configuration.ErrorState.LoadCache
            java.lang.Throwable r5 = kotlin.Result.m2347exceptionOrNullimpl(r12)
            r6 = r11
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r11.L$0 = r12
            r11.L$1 = r2
            r11.L$2 = r2
            r2 = 10
            r11.label = r2
            java.lang.Object r1 = r1.executeErrorState(r4, r5, r3, r6)
            if (r1 != r0) goto L_0x02c2
            return r0
        L_0x02c2:
            r0 = r12
        L_0x02c3:
            java.lang.Throwable r12 = kotlin.Result.m2347exceptionOrNullimpl(r0)
            if (r12 != 0) goto L_0x02d6
            java.lang.Exception r12 = new java.lang.Exception
            com.unity3d.services.core.configuration.ErrorState r0 = com.unity3d.services.core.configuration.ErrorState.LoadCache
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            java.lang.Throwable r12 = (java.lang.Throwable) r12
        L_0x02d6:
            throw r12
        L_0x02d7:
            kotlin.ResultKt.throwOnFailure(r12)
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$LoadCacheResult r12 = (com.unity3d.services.core.domain.task.InitializeStateLoadCache.LoadCacheResult) r12
            boolean r5 = r12.getHasHashMismatch()
            if (r5 == 0) goto L_0x037e
            com.unity3d.services.core.configuration.IExperiments r3 = r3.getExperiments()
            boolean r3 = r3.isWebViewAsyncDownloadEnabled()
            if (r3 == 0) goto L_0x0312
            java.lang.String r3 = r12.getWebViewData()
            if (r3 == 0) goto L_0x0312
            kotlinx.coroutines.CoroutineName r3 = new kotlinx.coroutines.CoroutineName
            java.lang.String r5 = "LaunchLoadWeb"
            r3.<init>(r5)
            r5 = r3
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            r6 = 0
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$webViewData$1 r3 = new com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$webViewData$1
            com.unity3d.services.core.domain.task.InitializeSDK r7 = r11.this$0
            r3.<init>(r7, r1, r2)
            r7 = r3
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 2
            r9 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r4, r5, r6, r7, r8, r9)
            java.lang.String r12 = r12.getWebViewData()
            goto L_0x0384
        L_0x0312:
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x0340 }
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb r12 = r12.initializeStateLoadWeb     // Catch:{ all -> 0x0340 }
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r3 = new com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params     // Catch:{ all -> 0x0340 }
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x0340 }
            r5 = r1
            com.unity3d.services.core.configuration.Configuration r5 = (com.unity3d.services.core.configuration.Configuration) r5     // Catch:{ all -> 0x0340 }
            r3.<init>(r5)     // Catch:{ all -> 0x0340 }
            com.unity3d.services.core.domain.task.BaseParams r3 = (com.unity3d.services.core.domain.task.BaseParams) r3     // Catch:{ all -> 0x0340 }
            r11.L$0 = r4     // Catch:{ all -> 0x0340 }
            r11.L$1 = r1     // Catch:{ all -> 0x0340 }
            r11.L$2 = r2     // Catch:{ all -> 0x0340 }
            r5 = 11
            r11.label = r5     // Catch:{ all -> 0x0340 }
            java.lang.Object r12 = r12.invoke(r3, r11)     // Catch:{ all -> 0x0340 }
            if (r12 != r0) goto L_0x0338
            return r0
        L_0x0338:
            r3 = r4
        L_0x0339:
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$LoadWebResult r12 = (com.unity3d.services.core.domain.task.InitializeStateLoadWeb.LoadWebResult) r12     // Catch:{ all -> 0x0040 }
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)     // Catch:{ all -> 0x0040 }
            goto L_0x034c
        L_0x0340:
            r12 = move-exception
            r3 = r4
        L_0x0342:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)
        L_0x034c:
            r10 = r1
            r1 = r12
            r12 = r10
            boolean r4 = kotlin.Result.m2350isFailureimpl(r1)
            if (r4 == 0) goto L_0x0371
            com.unity3d.services.core.domain.task.InitializeSDK r4 = r11.this$0
            com.unity3d.services.core.domain.task.InitializationException r5 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r1)
            r6 = r11
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r11.L$0 = r3
            r11.L$1 = r12
            r11.L$2 = r1
            r3 = 12
            r11.label = r3
            java.lang.Object r3 = r4.handleInitializationException(r5, r6)
            if (r3 != r0) goto L_0x036f
            return r0
        L_0x036f:
            r3 = r12
        L_0x0370:
            r12 = r3
        L_0x0371:
            kotlin.ResultKt.throwOnFailure(r1)
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$LoadWebResult r1 = (com.unity3d.services.core.domain.task.InitializeStateLoadWeb.LoadWebResult) r1
            java.lang.String r1 = r1.getWebViewDataString()
            r10 = r1
            r1 = r12
            r12 = r10
            goto L_0x0384
        L_0x037e:
            java.lang.String r12 = r12.getWebViewData()
            if (r12 == 0) goto L_0x0404
        L_0x0384:
            com.unity3d.services.core.domain.task.InitializeSDK r3 = r11.this$0
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0025 }
            com.unity3d.services.core.domain.task.InitializeStateCreate r3 = r3.initializeStateCreate     // Catch:{ all -> 0x0025 }
            com.unity3d.services.core.domain.task.InitializeStateCreate$Params r4 = new com.unity3d.services.core.domain.task.InitializeStateCreate$Params     // Catch:{ all -> 0x0025 }
            kotlin.ResultKt.throwOnFailure(r1)     // Catch:{ all -> 0x0025 }
            r5 = r1
            com.unity3d.services.core.configuration.Configuration r5 = (com.unity3d.services.core.configuration.Configuration) r5     // Catch:{ all -> 0x0025 }
            r4.<init>(r5, r12)     // Catch:{ all -> 0x0025 }
            com.unity3d.services.core.domain.task.BaseParams r4 = (com.unity3d.services.core.domain.task.BaseParams) r4     // Catch:{ all -> 0x0025 }
            r11.L$0 = r1     // Catch:{ all -> 0x0025 }
            r11.L$1 = r2     // Catch:{ all -> 0x0025 }
            r11.L$2 = r2     // Catch:{ all -> 0x0025 }
            r12 = 13
            r11.label = r12     // Catch:{ all -> 0x0025 }
            java.lang.Object r12 = r3.invoke(r4, r11)     // Catch:{ all -> 0x0025 }
            if (r12 != r0) goto L_0x03aa
            return r0
        L_0x03aa:
            com.unity3d.services.core.configuration.Configuration r12 = (com.unity3d.services.core.configuration.Configuration) r12     // Catch:{ all -> 0x0025 }
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)     // Catch:{ all -> 0x0025 }
            goto L_0x03bb
        L_0x03b1:
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r12 = kotlin.ResultKt.createFailure(r12)
            java.lang.Object r12 = kotlin.Result.m2344constructorimpl(r12)
        L_0x03bb:
            boolean r3 = kotlin.Result.m2350isFailureimpl(r12)
            if (r3 == 0) goto L_0x03db
            com.unity3d.services.core.domain.task.InitializeSDK r3 = r11.this$0
            com.unity3d.services.core.domain.task.InitializationException r12 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r12)
            r4 = r11
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r11.L$0 = r1
            r11.L$1 = r2
            r11.L$2 = r2
            r5 = 14
            r11.label = r5
            java.lang.Object r12 = r3.handleInitializationException(r12, r4)
            if (r12 != r0) goto L_0x03db
            return r0
        L_0x03db:
            com.unity3d.services.core.domain.task.InitializeSDK r12 = r11.this$0
            com.unity3d.services.core.domain.task.InitializeStateComplete r12 = r12.initializeStateComplete
            com.unity3d.services.core.domain.task.InitializeStateComplete$Params r3 = new com.unity3d.services.core.domain.task.InitializeStateComplete$Params
            kotlin.ResultKt.throwOnFailure(r1)
            com.unity3d.services.core.configuration.Configuration r1 = (com.unity3d.services.core.configuration.Configuration) r1
            r3.<init>(r1)
            com.unity3d.services.core.domain.task.BaseParams r3 = (com.unity3d.services.core.domain.task.BaseParams) r3
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.L$0 = r2
            r11.L$1 = r2
            r11.L$2 = r2
            r2 = 15
            r11.label = r2
            java.lang.Object r12 = r12.invoke(r3, r1)
            if (r12 != r0) goto L_0x0401
            return r0
        L_0x0401:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0404:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "WebView is missing."
            java.lang.String r0 = r0.toString()
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
