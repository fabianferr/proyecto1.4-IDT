package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$webViewData$1", f = "InitializeSDK.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InitializeSDK.kt */
final class InitializeSDK$doWork$2$webViewData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $configResult;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2$webViewData$1(InitializeSDK initializeSDK, Object obj, Continuation<? super InitializeSDK$doWork$2$webViewData$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
        this.$configResult = obj;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeSDK$doWork$2$webViewData$1 initializeSDK$doWork$2$webViewData$1 = new InitializeSDK$doWork$2$webViewData$1(this.this$0, this.$configResult, continuation);
        initializeSDK$doWork$2$webViewData$1.L$0 = obj;
        return initializeSDK$doWork$2$webViewData$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeSDK$doWork$2$webViewData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            InitializeSDK initializeSDK = this.this$0;
            Object obj2 = this.$configResult;
            Result.Companion companion = Result.Companion;
            InitializeStateLoadWeb access$getInitializeStateLoadWeb$p = initializeSDK.initializeStateLoadWeb;
            ResultKt.throwOnFailure(obj2);
            this.label = 1;
            obj = access$getInitializeStateLoadWeb$p.invoke(new InitializeStateLoadWeb.Params((Configuration) obj2), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                Result.m2344constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Result.m2344constructorimpl((InitializeStateLoadWeb.LoadWebResult) obj);
        return Unit.INSTANCE;
    }
}
