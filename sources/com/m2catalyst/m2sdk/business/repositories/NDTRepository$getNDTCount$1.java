package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.NDTRepository", f = "NDTRepository.kt", i = {}, l = {93}, m = "getNDTCount", n = {}, s = {})
/* compiled from: NDTRepository.kt */
public final class NDTRepository$getNDTCount$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NDTRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NDTRepository$getNDTCount$1(NDTRepository nDTRepository, Continuation<? super NDTRepository$getNDTCount$1> continuation) {
        super(continuation);
        this.this$0 = nDTRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getNDTCount(this);
    }
}