package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNetworkDiagnosticCount$2", f = "NDTRepository.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NDTRepository.kt */
public final class NDTRepository$getNetworkDiagnosticCount$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;
    final /* synthetic */ NDTRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NDTRepository$getNetworkDiagnosticCount$2(NDTRepository nDTRepository, Continuation<? super NDTRepository$getNetworkDiagnosticCount$2> continuation) {
        super(2, continuation);
        this.this$0 = nDTRepository;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NDTRepository$getNetworkDiagnosticCount$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((NDTRepository$getNetworkDiagnosticCount$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NDTRepository nDTRepository = this.this$0;
            this.label = 1;
            obj = nDTRepository.getNDTCount(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
