package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.NDTRepository", f = "NDTRepository.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {52, 55, 58}, m = "getNDTResults", n = {"this", "startTime", "endTime", "testTrigger", "testType", "transmitted", "limit", "whereClause", "this", "startTime", "endTime", "testTrigger", "testType", "transmitted", "limit", "whereClause", "this", "startTime", "endTime", "testTrigger", "testType", "transmitted", "limit", "whereClause", "destination$iv$iv", "ndtResult"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10"})
/* compiled from: NDTRepository.kt */
public final class NDTRepository$getNDTResults$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NDTRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NDTRepository$getNDTResults$1(NDTRepository nDTRepository, Continuation<? super NDTRepository$getNDTResults$1> continuation) {
        super(continuation);
        this.this$0 = nDTRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getNDTResults((Long) null, (Long) null, (Integer) null, (Integer) null, (Boolean) null, (Integer) null, this);
    }
}
