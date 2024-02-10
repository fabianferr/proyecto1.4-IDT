package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "Lcom/unity3d/services/core/configuration/Configuration;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2", f = "InitializeStateReset.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InitializeStateReset.kt */
final class InitializeStateReset$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Configuration>, Object> {
    final /* synthetic */ InitializeStateReset.Params $params;
    int label;
    final /* synthetic */ InitializeStateReset this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateReset$doWork$2(InitializeStateReset.Params params, InitializeStateReset initializeStateReset, Continuation<? super InitializeStateReset$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateReset;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateReset$doWork$2(this.$params, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Configuration> continuation) {
        return ((InitializeStateReset$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0018
            if (r1 != r3) goto L_0x0010
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0052
        L_0x0010:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0018:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.String r8 = "Unity Ads init: starting init"
            com.unity3d.services.core.log.DeviceLog.debug(r8)
            com.unity3d.services.core.webview.WebViewApp r8 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()
            if (r8 == 0) goto L_0x0029
            r8.resetWebViewAppInitialization()
        L_0x0029:
            if (r8 == 0) goto L_0x0030
            com.unity3d.services.core.webview.WebView r1 = r8.getWebView()
            goto L_0x0031
        L_0x0030:
            r1 = r2
        L_0x0031:
            if (r1 == 0) goto L_0x005f
            com.unity3d.services.core.domain.task.InitializeStateReset$Params r1 = r7.$params
            com.unity3d.services.core.configuration.Configuration r1 = r1.getConfig()
            long r4 = r1.getWebViewAppCreateTimeout()
            com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$success$1 r1 = new com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$success$1
            com.unity3d.services.core.domain.task.InitializeStateReset r6 = r7.this$0
            r1.<init>(r6, r8, r2)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r8 = r7
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r7.label = r3
            java.lang.Object r8 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r4, r1, r8)
            if (r8 != r0) goto L_0x0052
            return r0
        L_0x0052:
            kotlin.Unit r8 = (kotlin.Unit) r8
            if (r8 == 0) goto L_0x0057
            goto L_0x005f
        L_0x0057:
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r0 = "Reset failed on opening ConditionVariable"
            r8.<init>(r0)
            throw r8
        L_0x005f:
            com.unity3d.services.core.domain.task.InitializeStateReset r8 = r7.this$0
            r8.unregisterLifecycleCallbacks()
            com.unity3d.services.core.properties.SdkProperties.setCacheDirectory(r2)
            java.io.File r8 = com.unity3d.services.core.properties.SdkProperties.getCacheDirectory()
            if (r8 == 0) goto L_0x00a7
            r8 = 0
            com.unity3d.services.core.properties.SdkProperties.setInitialized(r8)
            com.unity3d.services.core.domain.task.InitializeStateReset$Params r0 = r7.$params
            com.unity3d.services.core.configuration.Configuration r0 = r0.getConfig()
            java.lang.Class[] r0 = r0.getModuleConfigurationList()
            if (r0 != 0) goto L_0x007f
            java.lang.Class[] r0 = new java.lang.Class[r8]
        L_0x007f:
            int r1 = r0.length
        L_0x0080:
            if (r8 >= r1) goto L_0x00a0
            r2 = r0[r8]
            com.unity3d.services.core.domain.task.InitializeStateReset$Params r3 = r7.$params
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
            com.unity3d.services.core.configuration.IModuleConfiguration r2 = r3.getModuleConfiguration(r2)
            if (r2 == 0) goto L_0x009d
            com.unity3d.services.core.domain.task.InitializeStateReset$Params r3 = r7.$params
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()
            boolean r2 = r2.resetState(r3)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
        L_0x009d:
            int r8 = r8 + 1
            goto L_0x0080
        L_0x00a0:
            com.unity3d.services.core.domain.task.InitializeStateReset$Params r8 = r7.$params
            com.unity3d.services.core.configuration.Configuration r8 = r8.getConfig()
            return r8
        L_0x00a7:
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r0 = "Cache directory is NULL"
            r8.<init>(r0)
            goto L_0x00b0
        L_0x00af:
            throw r8
        L_0x00b0:
            goto L_0x00af
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
