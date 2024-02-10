package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.MNSIRepository", f = "MNSIRepository.kt", i = {}, l = {610}, m = "clearMNSIEntries", n = {}, s = {})
/* compiled from: MNSIRepository.kt */
public final class MNSIRepository$clearMNSIEntries$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MNSIRepository$clearMNSIEntries$1(MNSIRepository mNSIRepository, Continuation<? super MNSIRepository$clearMNSIEntries$1> continuation) {
        super(continuation);
        this.this$0 = mNSIRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.clearMNSIEntries(this);
    }
}
