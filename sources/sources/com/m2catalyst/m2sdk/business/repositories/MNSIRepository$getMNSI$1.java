package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.MNSIRepository", f = "MNSIRepository.kt", i = {0, 0, 0, 1, 1, 1}, l = {430, 433}, m = "getMNSI", n = {"startDate", "stopDate", "simSlot", "startDate", "stopDate", "simSlot"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
/* compiled from: MNSIRepository.kt */
public final class MNSIRepository$getMNSI$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MNSIRepository$getMNSI$1(MNSIRepository mNSIRepository, Continuation<? super MNSIRepository$getMNSI$1> continuation) {
        super(continuation);
        this.this$0 = mNSIRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMNSI((Long) null, (Long) null, (Integer) null, this);
    }
}
