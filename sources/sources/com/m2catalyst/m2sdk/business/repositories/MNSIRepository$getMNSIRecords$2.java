package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.MNSI;
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

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lcom/m2catalyst/m2sdk/business/models/MNSI;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.MNSIRepository$getMNSIRecords$2", f = "MNSIRepository.kt", i = {}, l = {451}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: MNSIRepository.kt */
public final class MNSIRepository$getMNSIRecords$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends MNSI>>, Object> {
    final /* synthetic */ Integer $simSlot;
    final /* synthetic */ Long $startDate;
    final /* synthetic */ Long $stopDate;
    int label;
    final /* synthetic */ MNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MNSIRepository$getMNSIRecords$2(MNSIRepository mNSIRepository, Long l, Long l2, Integer num, Continuation<? super MNSIRepository$getMNSIRecords$2> continuation) {
        super(2, continuation);
        this.this$0 = mNSIRepository;
        this.$startDate = l;
        this.$stopDate = l2;
        this.$simSlot = num;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MNSIRepository$getMNSIRecords$2(this.this$0, this.$startDate, this.$stopDate, this.$simSlot, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<? extends MNSI>> continuation) {
        return ((MNSIRepository$getMNSIRecords$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            MNSIRepository mNSIRepository = this.this$0;
            Long l = this.$startDate;
            Long l2 = this.$stopDate;
            Integer num = this.$simSlot;
            this.label = 1;
            obj = mNSIRepository.getMNSI(l, l2, num, this);
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
