package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2", f = "InitializeStateConfigWithLoader.kt", i = {0, 0, 0, 1, 1, 2}, l = {52, 94, 97}, m = "invokeSuspend", n = {"$this$withContext", "configurationLoader", "config", "configurationLoader", "config", "config"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0"})
/* compiled from: InitializeStateConfigWithLoader.kt */
final class InitializeStateConfigWithLoader$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Configuration>, Object> {
    final /* synthetic */ InitializeStateConfigWithLoader.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2(InitializeStateConfigWithLoader.Params params, InitializeStateConfigWithLoader initializeStateConfigWithLoader, Continuation<? super InitializeStateConfigWithLoader$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateConfigWithLoader;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateConfigWithLoader$doWork$2 initializeStateConfigWithLoader$doWork$2 = new InitializeStateConfigWithLoader$doWork$2(this.$params, this.this$0, continuation);
        initializeStateConfigWithLoader$doWork$2.L$0 = obj;
        return initializeStateConfigWithLoader$doWork$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Configuration> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v20, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v45, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v33, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v47, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01de  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r9 = r17
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r9.label
            r11 = 0
            r12 = 3
            r13 = 2
            r1 = 1
            if (r0 == 0) goto L_0x0056
            if (r0 == r1) goto L_0x0040
            if (r0 == r13) goto L_0x0029
            if (r0 != r12) goto L_0x0021
            java.lang.Object r0 = r9.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r9.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x01af
        L_0x0021:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0029:
            java.lang.Object r0 = r9.L$2
            r1 = r0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r9.L$1
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r9.L$0
            r3 = r0
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x003d }
            goto L_0x015f
        L_0x003d:
            r0 = move-exception
            goto L_0x0168
        L_0x0040:
            java.lang.Object r0 = r9.L$2
            r1 = r0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r9.L$1
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r9.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r18)     // Catch:{ all -> 0x0053 }
            goto L_0x0116
        L_0x0053:
            r0 = move-exception
            goto L_0x0120
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r0 = r9.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.unity3d.services.core.configuration.PrivacyConfigStorage r2 = com.unity3d.services.core.configuration.PrivacyConfigStorage.getInstance()
            com.unity3d.services.core.device.reader.DeviceInfoDataFactory r3 = new com.unity3d.services.core.device.reader.DeviceInfoDataFactory
            r3.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            com.unity3d.services.core.configuration.ConfigurationLoader r4 = new com.unity3d.services.core.configuration.ConfigurationLoader
            com.unity3d.services.core.configuration.ConfigurationRequestFactory r5 = new com.unity3d.services.core.configuration.ConfigurationRequestFactory
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r6 = r9.$params
            com.unity3d.services.core.configuration.Configuration r6 = r6.getConfig()
            com.unity3d.services.core.configuration.InitRequestType r7 = com.unity3d.services.core.configuration.InitRequestType.TOKEN
            com.unity3d.services.core.device.reader.IDeviceInfoDataContainer r7 = r3.getDeviceInfoData(r7)
            r5.<init>(r6, r7)
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r6 = r9.this$0
            com.unity3d.services.core.di.IServiceComponent r6 = (com.unity3d.services.core.di.IServiceComponent) r6
            com.unity3d.services.core.di.IServiceProvider r6 = r6.getServiceProvider()
            com.unity3d.services.core.di.IServicesRegistry r6 = r6.getRegistry()
            java.lang.Class<com.unity3d.services.core.request.metrics.SDKMetricsSender> r7 = com.unity3d.services.core.request.metrics.SDKMetricsSender.class
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r7)
            java.lang.String r8 = ""
            java.lang.Object r6 = r6.getService(r8, r7)
            com.unity3d.services.core.request.metrics.SDKMetricsSender r6 = (com.unity3d.services.core.request.metrics.SDKMetricsSender) r6
            r4.<init>(r5, r6)
            r14.element = r4
            com.unity3d.services.core.configuration.PrivacyConfigurationLoader r4 = new com.unity3d.services.core.configuration.PrivacyConfigurationLoader
            T r5 = r14.element
            com.unity3d.services.core.configuration.IConfigurationLoader r5 = (com.unity3d.services.core.configuration.IConfigurationLoader) r5
            com.unity3d.services.core.configuration.ConfigurationRequestFactory r6 = new com.unity3d.services.core.configuration.ConfigurationRequestFactory
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r7 = r9.$params
            com.unity3d.services.core.configuration.Configuration r7 = r7.getConfig()
            com.unity3d.services.core.configuration.InitRequestType r8 = com.unity3d.services.core.configuration.InitRequestType.PRIVACY
            com.unity3d.services.core.device.reader.IDeviceInfoDataContainer r3 = r3.getDeviceInfoData(r8)
            r6.<init>(r7, r3)
            r4.<init>(r5, r6, r2)
            r14.element = r4
            kotlin.jvm.internal.Ref$ObjectRef r15 = new kotlin.jvm.internal.Ref$ObjectRef
            r15.<init>()
            com.unity3d.services.core.configuration.Configuration r2 = new com.unity3d.services.core.configuration.Configuration
            r2.<init>()
            r15.element = r2
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r2 = r9.$params
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r3 = r9.this$0
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x011d }
            com.unity3d.services.core.configuration.Configuration r4 = r2.getConfig()     // Catch:{ all -> 0x011d }
            int r4 = r4.getMaxRetries()     // Catch:{ all -> 0x011d }
            com.unity3d.services.core.configuration.Configuration r5 = r2.getConfig()     // Catch:{ all -> 0x011d }
            double r5 = r5.getRetryScalingFactor()     // Catch:{ all -> 0x011d }
            com.unity3d.services.core.configuration.Configuration r7 = r2.getConfig()     // Catch:{ all -> 0x011d }
            long r7 = r7.getRetryDelay()     // Catch:{ all -> 0x011d }
            com.unity3d.services.core.domain.task.InitializationException r12 = new com.unity3d.services.core.domain.task.InitializationException     // Catch:{ all -> 0x011d }
            com.unity3d.services.core.configuration.ErrorState r13 = com.unity3d.services.core.configuration.ErrorState.NetworkConfigRequest     // Catch:{ all -> 0x011d }
            java.lang.Exception r1 = new java.lang.Exception     // Catch:{ all -> 0x011d }
            r1.<init>()     // Catch:{ all -> 0x011d }
            com.unity3d.services.core.configuration.Configuration r2 = r2.getConfig()     // Catch:{ all -> 0x011d }
            r12.<init>(r13, r1, r2)     // Catch:{ all -> 0x011d }
            java.lang.Exception r12 = (java.lang.Exception) r12     // Catch:{ all -> 0x011d }
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1 r1 = new com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$configResult$1$1     // Catch:{ all -> 0x011d }
            r1.<init>(r3, r14, r15, r11)     // Catch:{ all -> 0x011d }
            r13 = r1
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch:{ all -> 0x011d }
            r9.L$0 = r0     // Catch:{ all -> 0x011d }
            r9.L$1 = r14     // Catch:{ all -> 0x011d }
            r9.L$2 = r15     // Catch:{ all -> 0x011d }
            r0 = 1
            r9.label = r0     // Catch:{ all -> 0x011d }
            r1 = r7
            r3 = r4
            r4 = r5
            r6 = r12
            r7 = r13
            r8 = r17
            java.lang.Object r0 = com.unity3d.services.core.extensions.TaskExtensionsKt.withRetry(r1, r3, r4, r6, r7, r8)     // Catch:{ all -> 0x011d }
            if (r0 != r10) goto L_0x0114
            return r10
        L_0x0114:
            r2 = r14
            r1 = r15
        L_0x0116:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0053 }
            java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)     // Catch:{ all -> 0x0053 }
            goto L_0x012a
        L_0x011d:
            r0 = move-exception
            r2 = r14
            r1 = r15
        L_0x0120:
            kotlin.Result$Companion r3 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)
        L_0x012a:
            r3 = r2
            boolean r2 = kotlin.Result.m2350isFailureimpl(r0)
            if (r2 == 0) goto L_0x01de
            java.lang.Throwable r0 = kotlin.Result.m2347exceptionOrNullimpl(r0)
            boolean r2 = r0 instanceof com.unity3d.services.core.extensions.AbortRetryException
            if (r2 != 0) goto L_0x01ce
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r0 = r9.this$0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r2 = r9.$params
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x0166 }
            com.unity3d.services.core.domain.task.InitializeStateNetworkError r0 = r0.initializeStateNetworkError     // Catch:{ all -> 0x0166 }
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params r4 = new com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params     // Catch:{ all -> 0x0166 }
            com.unity3d.services.core.configuration.Configuration r2 = r2.getConfig()     // Catch:{ all -> 0x0166 }
            r4.<init>(r2)     // Catch:{ all -> 0x0166 }
            com.unity3d.services.core.domain.task.BaseParams r4 = (com.unity3d.services.core.domain.task.BaseParams) r4     // Catch:{ all -> 0x0166 }
            r9.L$0 = r3     // Catch:{ all -> 0x0166 }
            r9.L$1 = r1     // Catch:{ all -> 0x0166 }
            r9.L$2 = r1     // Catch:{ all -> 0x0166 }
            r2 = 2
            r9.label = r2     // Catch:{ all -> 0x0166 }
            java.lang.Object r0 = r0.invoke(r4, r9)     // Catch:{ all -> 0x0166 }
            if (r0 != r10) goto L_0x015e
            return r10
        L_0x015e:
            r2 = r1
        L_0x015f:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003d }
            java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)     // Catch:{ all -> 0x003d }
            goto L_0x0172
        L_0x0166:
            r0 = move-exception
            r2 = r1
        L_0x0168:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m2344constructorimpl(r0)
        L_0x0172:
            r8 = r2
            boolean r0 = kotlin.Result.m2351isSuccessimpl(r0)
            if (r0 == 0) goto L_0x01b9
            com.unity3d.services.core.configuration.IInitializeEventsMetricSender r0 = com.unity3d.services.core.configuration.InitializeEventsMetricSender.getInstance()
            r0.onRetryConfig()
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r0 = r9.this$0
            com.unity3d.services.core.domain.ISDKDispatchers r0 = r0.dispatchers
            kotlinx.coroutines.CoroutineDispatcher r0 = r0.getIo()
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1 r12 = new com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r5 = r9.this$0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r6 = r9.$params
            r7 = 0
            r2 = r12
            r4 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12
            r2 = r9
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r9.L$0 = r8
            r9.L$1 = r1
            r9.L$2 = r11
            r3 = 3
            r9.label = r3
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r12, r2)
            if (r0 != r10) goto L_0x01ad
            return r10
        L_0x01ad:
            r0 = r1
            r1 = r8
        L_0x01af:
            T r2 = r1.element
            com.unity3d.services.core.configuration.Configuration r2 = (com.unity3d.services.core.configuration.Configuration) r2
            r16 = r1
            r1 = r0
            r0 = r16
            goto L_0x01e4
        L_0x01b9:
            com.unity3d.services.core.domain.task.InitializationException r0 = new com.unity3d.services.core.domain.task.InitializationException
            com.unity3d.services.core.configuration.ErrorState r1 = com.unity3d.services.core.configuration.ErrorState.NetworkConfigRequest
            java.lang.Exception r2 = new java.lang.Exception
            java.lang.String r3 = "No connected events within the timeout!"
            r2.<init>(r3)
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r3 = r9.$params
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
            r0.<init>(r1, r2, r3)
            throw r0
        L_0x01ce:
            com.unity3d.services.core.domain.task.InitializationException r1 = new com.unity3d.services.core.domain.task.InitializationException
            com.unity3d.services.core.configuration.ErrorState r2 = com.unity3d.services.core.configuration.ErrorState.NetworkConfigRequest
            java.lang.Exception r0 = (java.lang.Exception) r0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r3 = r9.$params
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
            r1.<init>(r2, r0, r3)
            throw r1
        L_0x01de:
            T r0 = r1.element
            r2 = r0
            com.unity3d.services.core.configuration.Configuration r2 = (com.unity3d.services.core.configuration.Configuration) r2
            r0 = r1
        L_0x01e4:
            r1.element = r2
            T r0 = r0.element
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
