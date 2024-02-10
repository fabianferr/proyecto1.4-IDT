package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.business.models.NoSignalData;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository", f = "NoSignalMNSIRepository.kt", i = {0, 0, 0}, l = {70}, m = "addNoSignalRecord", n = {"this", "accepted", "$this$forEach$iv"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: NoSignalMNSIRepository.kt */
public final class NoSignalMNSIRepository$addNoSignalRecord$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NoSignalMNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoSignalMNSIRepository$addNoSignalRecord$1(NoSignalMNSIRepository noSignalMNSIRepository, Continuation<? super NoSignalMNSIRepository$addNoSignalRecord$1> continuation) {
        super(continuation);
        this.this$0 = noSignalMNSIRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addNoSignalRecord((NoSignalData[]) null, this);
    }
}
