package com.m2catalyst.m2sdk.business.repositories;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.MNSIRepository", f = "MNSIRepository.kt", i = {0, 0}, l = {463}, m = "markMNSITransmitted", n = {"this", "entriesIds"}, s = {"L$0", "L$1"})
/* compiled from: MNSIRepository.kt */
public final class MNSIRepository$markMNSITransmitted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MNSIRepository$markMNSITransmitted$1(MNSIRepository mNSIRepository, Continuation<? super MNSIRepository$markMNSITransmitted$1> continuation) {
        super(continuation);
        this.this$0 = mNSIRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.markMNSITransmitted((List<Integer>) null, this);
    }
}
