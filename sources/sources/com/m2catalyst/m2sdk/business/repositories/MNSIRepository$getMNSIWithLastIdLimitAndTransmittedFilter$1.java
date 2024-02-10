package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.MNSIRepository", f = "MNSIRepository.kt", i = {0, 0, 0, 0, 1, 1, 1, 1}, l = {367, 370}, m = "getMNSIWithLastIdLimitAndTransmittedFilter", n = {"startDate", "transmitted", "lastId", "limit", "startDate", "transmitted", "lastId", "limit"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: MNSIRepository.kt */
public final class MNSIRepository$getMNSIWithLastIdLimitAndTransmittedFilter$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MNSIRepository$getMNSIWithLastIdLimitAndTransmittedFilter$1(MNSIRepository mNSIRepository, Continuation<? super MNSIRepository$getMNSIWithLastIdLimitAndTransmittedFilter$1> continuation) {
        super(continuation);
        this.this$0 = mNSIRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getMNSIWithLastIdLimitAndTransmittedFilter((Long) null, (Boolean) null, (Integer) null, (Integer) null, (Integer) null, this);
    }
}
