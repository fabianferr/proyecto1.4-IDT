package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$LoadWebResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2", f = "InitializeStateLoadWeb.kt", i = {0, 0, 1}, l = {42, 59, 61}, m = "invokeSuspend", n = {"$this$withContext", "request", "request"}, s = {"L$0", "L$1", "L$0"})
/* compiled from: InitializeStateLoadWeb.kt */
final class InitializeStateLoadWeb$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InitializeStateLoadWeb.LoadWebResult>, Object> {
    final /* synthetic */ InitializeStateLoadWeb.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2(InitializeStateLoadWeb.Params params, InitializeStateLoadWeb initializeStateLoadWeb, Continuation<? super InitializeStateLoadWeb$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateLoadWeb;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateLoadWeb$doWork$2 initializeStateLoadWeb$doWork$2 = new InitializeStateLoadWeb$doWork$2(this.$params, this.this$0, continuation);
        initializeStateLoadWeb$doWork$2.L$0 = obj;
        return initializeStateLoadWeb$doWork$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InitializeStateLoadWeb.LoadWebResult> continuation) {
        return ((InitializeStateLoadWeb$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: com.unity3d.services.core.network.model.HttpRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: com.unity3d.services.core.network.model.HttpRequest} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) {
        /*
            r30 = this;
            r9 = r30
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r9.label
            r11 = 3
            r12 = 2
            r1 = 1
            r13 = 0
            if (r0 == 0) goto L_0x0043
            if (r0 == r1) goto L_0x0030
            if (r0 == r12) goto L_0x0023
            if (r0 != r11) goto L_0x001b
            kotlin.ResultKt.throwOnFailure(r31)
            r0 = r31
            goto L_0x0160
        L_0x001b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0023:
            java.lang.Object r0 = r9.L$0
            r1 = r0
            com.unity3d.services.core.network.model.HttpRequest r1 = (com.unity3d.services.core.network.model.HttpRequest) r1
            kotlin.ResultKt.throwOnFailure(r31)     // Catch:{ all -> 0x002d }
            goto L_0x0123
        L_0x002d:
            r0 = move-exception
            goto L_0x012a
        L_0x0030:
            java.lang.Object r0 = r9.L$1
            r1 = r0
            com.unity3d.services.core.network.model.HttpRequest r1 = (com.unity3d.services.core.network.model.HttpRequest) r1
            java.lang.Object r0 = r9.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r31)     // Catch:{ all -> 0x0040 }
            r0 = r31
            goto L_0x00e4
        L_0x0040:
            r0 = move-exception
            goto L_0x00f0
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r31)
            java.lang.Object r0 = r9.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unity Ads init: loading webapp from "
            r2.<init>(r3)
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r3 = r9.$params
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
            java.lang.String r3 = r3.getWebViewUrl()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.unity3d.services.core.log.DeviceLog.info(r2)
            com.unity3d.services.core.network.model.HttpRequest r8 = new com.unity3d.services.core.network.model.HttpRequest
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r2 = r9.$params
            com.unity3d.services.core.configuration.Configuration r2 = r2.getConfig()
            java.lang.String r15 = r2.getWebViewUrl()
            java.lang.String r2 = "params.config.webViewUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r2)
            r16 = 0
            com.unity3d.services.core.network.model.RequestType r17 = com.unity3d.services.core.network.model.RequestType.GET
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 8186(0x1ffa, float:1.1471E-41)
            r29 = 0
            r14 = r8
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r2 = r9.$params
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb r3 = r9.this$0
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x00ed }
            com.unity3d.services.core.configuration.Configuration r4 = r2.getConfig()     // Catch:{ all -> 0x00ed }
            int r4 = r4.getMaxRetries()     // Catch:{ all -> 0x00ed }
            com.unity3d.services.core.configuration.Configuration r5 = r2.getConfig()     // Catch:{ all -> 0x00ed }
            double r5 = r5.getRetryScalingFactor()     // Catch:{ all -> 0x00ed }
            com.unity3d.services.core.configuration.Configuration r7 = r2.getConfig()     // Catch:{ all -> 0x00ed }
            long r14 = r7.getRetryDelay()     // Catch:{ all -> 0x00ed }
            com.unity3d.services.core.domain.task.InitializationException r7 = new com.unity3d.services.core.domain.task.InitializationException     // Catch:{ all -> 0x00ed }
            com.unity3d.services.core.configuration.ErrorState r11 = com.unity3d.services.core.configuration.ErrorState.NetworkWebviewRequest     // Catch:{ all -> 0x00ed }
            java.lang.Exception r12 = new java.lang.Exception     // Catch:{ all -> 0x00ed }
            r12.<init>()     // Catch:{ all -> 0x00ed }
            com.unity3d.services.core.configuration.Configuration r2 = r2.getConfig()     // Catch:{ all -> 0x00ed }
            r7.<init>(r11, r12, r2)     // Catch:{ all -> 0x00ed }
            java.lang.Exception r7 = (java.lang.Exception) r7     // Catch:{ all -> 0x00ed }
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1 r2 = new com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewDataResult$1$1     // Catch:{ all -> 0x00ed }
            r2.<init>(r3, r8, r13)     // Catch:{ all -> 0x00ed }
            r11 = r2
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ all -> 0x00ed }
            r9.L$0 = r0     // Catch:{ all -> 0x00ed }
            r9.L$1 = r8     // Catch:{ all -> 0x00ed }
            r9.label = r1     // Catch:{ all -> 0x00ed }
            r1 = r14
            r3 = r4
            r4 = r5
            r6 = r7
            r7 = r11
            r11 = r8
            r8 = r30
            java.lang.Object r0 = com.unity3d.services.core.extensions.TaskExtensionsKt.withRetry(r1, r3, r4, r6, r7, r8)     // Catch:{ all -> 0x00eb }
            if (r0 != r10) goto L_0x00e3
            return r10
        L_0x00e3:
            r1 = r11
        L_0x00e4:
            com.unity3d.services.core.network.model.HttpResponse r0 = (com.unity3d.services.core.network.model.HttpResponse) r0     // Catch:{ all -> 0x0040 }
            java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)     // Catch:{ all -> 0x0040 }
            goto L_0x00fa
        L_0x00eb:
            r0 = move-exception
            goto L_0x00ef
        L_0x00ed:
            r0 = move-exception
            r11 = r8
        L_0x00ef:
            r1 = r11
        L_0x00f0:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)
        L_0x00fa:
            boolean r2 = kotlin.Result.m2350isFailureimpl(r0)
            if (r2 == 0) goto L_0x0178
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb r0 = r9.this$0
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r2 = r9.$params
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x002d }
            com.unity3d.services.core.domain.task.InitializeStateNetworkError r0 = r0.initializeStateNetworkError     // Catch:{ all -> 0x002d }
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params r3 = new com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params     // Catch:{ all -> 0x002d }
            com.unity3d.services.core.configuration.Configuration r2 = r2.getConfig()     // Catch:{ all -> 0x002d }
            r3.<init>(r2)     // Catch:{ all -> 0x002d }
            com.unity3d.services.core.domain.task.BaseParams r3 = (com.unity3d.services.core.domain.task.BaseParams) r3     // Catch:{ all -> 0x002d }
            r9.L$0 = r1     // Catch:{ all -> 0x002d }
            r9.L$1 = r13     // Catch:{ all -> 0x002d }
            r2 = 2
            r9.label = r2     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.invoke(r3, r9)     // Catch:{ all -> 0x002d }
            if (r0 != r10) goto L_0x0123
            return r10
        L_0x0123:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)     // Catch:{ all -> 0x002d }
            goto L_0x0134
        L_0x012a:
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)
        L_0x0134:
            boolean r0 = kotlin.Result.m2351isSuccessimpl(r0)
            if (r0 == 0) goto L_0x0163
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb r0 = r9.this$0
            com.unity3d.services.core.domain.ISDKDispatchers r0 = r0.dispatchers
            kotlinx.coroutines.CoroutineDispatcher r0 = r0.getIo()
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewData$1 r2 = new com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$webViewData$1
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb r3 = r9.this$0
            r2.<init>(r3, r1, r13)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r1 = r9
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r9.L$0 = r13
            r9.L$1 = r13
            r3 = 3
            r9.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r2, r1)
            if (r0 != r10) goto L_0x0160
            return r10
        L_0x0160:
            java.lang.String r0 = (java.lang.String) r0
            goto L_0x0185
        L_0x0163:
            com.unity3d.services.core.domain.task.InitializationException r0 = new com.unity3d.services.core.domain.task.InitializationException
            com.unity3d.services.core.configuration.ErrorState r1 = com.unity3d.services.core.configuration.ErrorState.NetworkWebviewRequest
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.String r3 = "No connected events within the timeout!"
            r2.<init>(r3)
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r3 = r9.$params
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
            r0.<init>(r1, r2, r3)
            throw r0
        L_0x0178:
            kotlin.ResultKt.throwOnFailure(r0)
            com.unity3d.services.core.network.model.HttpResponse r0 = (com.unity3d.services.core.network.model.HttpResponse) r0
            java.lang.Object r0 = r0.getBody()
            java.lang.String r0 = r0.toString()
        L_0x0185:
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r1 = r9.$params
            com.unity3d.services.core.configuration.Configuration r1 = r1.getConfig()
            java.lang.String r1 = r1.getWebViewHash()
            if (r1 == 0) goto L_0x01b1
            java.lang.String r2 = com.unity3d.services.core.misc.Utilities.Sha256((java.lang.String) r0)
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x019c
            goto L_0x01b1
        L_0x019c:
            com.unity3d.services.core.domain.task.InitializationException r0 = new com.unity3d.services.core.domain.task.InitializationException
            com.unity3d.services.core.configuration.ErrorState r1 = com.unity3d.services.core.configuration.ErrorState.InvalidHash
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.String r3 = "Invalid webViewHash"
            r2.<init>(r3)
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r3 = r9.$params
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
            r0.<init>(r1, r2, r3)
            throw r0
        L_0x01b1:
            if (r1 == 0) goto L_0x01bf
            java.io.File r1 = new java.io.File
            java.lang.String r2 = com.unity3d.services.core.properties.SdkProperties.getLocalWebViewFile()
            r1.<init>(r2)
            com.unity3d.services.core.misc.Utilities.writeFile(r1, r0)
        L_0x01bf:
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$LoadWebResult r1 = new com.unity3d.services.core.domain.task.InitializeStateLoadWeb$LoadWebResult
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r2 = r9.$params
            com.unity3d.services.core.configuration.Configuration r2 = r2.getConfig()
            r1.<init>(r2, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
