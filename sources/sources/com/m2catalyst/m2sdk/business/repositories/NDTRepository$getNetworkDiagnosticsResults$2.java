package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/m2catalyst/m2sdk/ndt/models/DiagnosticsResults;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.NDTRepository$getNetworkDiagnosticsResults$2", f = "NDTRepository.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NDTRepository.kt */
public final class NDTRepository$getNetworkDiagnosticsResults$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends DiagnosticsResults>>, Object> {
    final /* synthetic */ Long $endTime;
    final /* synthetic */ Integer $limit;
    final /* synthetic */ Long $startTime;
    final /* synthetic */ Integer $testTrigger;
    final /* synthetic */ Integer $testType;
    final /* synthetic */ Boolean $transmitted;
    int label;
    final /* synthetic */ NDTRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NDTRepository$getNetworkDiagnosticsResults$2(NDTRepository nDTRepository, Long l, Long l2, Integer num, Integer num2, Boolean bool, Integer num3, Continuation<? super NDTRepository$getNetworkDiagnosticsResults$2> continuation) {
        super(2, continuation);
        this.this$0 = nDTRepository;
        this.$startTime = l;
        this.$endTime = l2;
        this.$testTrigger = num;
        this.$testType = num2;
        this.$transmitted = bool;
        this.$limit = num3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NDTRepository$getNetworkDiagnosticsResults$2(this.this$0, this.$startTime, this.$endTime, this.$testTrigger, this.$testType, this.$transmitted, this.$limit, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<DiagnosticsResults>> continuation) {
        return ((NDTRepository$getNetworkDiagnosticsResults$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NDTRepository nDTRepository = this.this$0;
            Long l = this.$startTime;
            Long l2 = this.$endTime;
            Integer num = this.$testTrigger;
            Integer num2 = this.$testType;
            Boolean bool = this.$transmitted;
            Integer num3 = this.$limit;
            this.label = 1;
            obj = nDTRepository.getNDTResults(l, l2, num, num2, bool, num3, this);
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
