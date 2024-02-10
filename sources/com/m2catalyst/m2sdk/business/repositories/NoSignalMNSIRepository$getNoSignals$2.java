package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.NoSignalData;
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

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/m2catalyst/m2sdk/business/models/NoSignalData;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository$getNoSignals$2", f = "NoSignalMNSIRepository.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: NoSignalMNSIRepository.kt */
public final class NoSignalMNSIRepository$getNoSignals$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends NoSignalData>>, Object> {
    final /* synthetic */ Long $endDate;
    final /* synthetic */ Integer $simSlot;
    final /* synthetic */ Long $startDate;
    int label;
    final /* synthetic */ NoSignalMNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoSignalMNSIRepository$getNoSignals$2(NoSignalMNSIRepository noSignalMNSIRepository, Long l, Long l2, Integer num, Continuation<? super NoSignalMNSIRepository$getNoSignals$2> continuation) {
        super(2, continuation);
        this.this$0 = noSignalMNSIRepository;
        this.$startDate = l;
        this.$endDate = l2;
        this.$simSlot = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NoSignalMNSIRepository$getNoSignals$2(this.this$0, this.$startDate, this.$endDate, this.$simSlot, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<NoSignalData>> continuation) {
        return ((NoSignalMNSIRepository$getNoSignals$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NoSignalMNSIRepository noSignalMNSIRepository = this.this$0;
            Long l = this.$startDate;
            Long l2 = this.$endDate;
            Integer num = this.$simSlot;
            this.label = 1;
            obj = noSignalMNSIRepository.getNoSignalRecords$m2sdk_release(l, l2, num, (Boolean) null, (Integer) null, this);
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
