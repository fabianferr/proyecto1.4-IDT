package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.NoSignalMNSIRepository", f = "NoSignalMNSIRepository.kt", i = {}, l = {46, 49}, m = "getNoSignalRecords$m2sdk_release", n = {}, s = {})
/* compiled from: NoSignalMNSIRepository.kt */
public final class NoSignalMNSIRepository$getNoSignalRecords$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NoSignalMNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NoSignalMNSIRepository$getNoSignalRecords$1(NoSignalMNSIRepository noSignalMNSIRepository, Continuation<? super NoSignalMNSIRepository$getNoSignalRecords$1> continuation) {
        super(continuation);
        this.this$0 = noSignalMNSIRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getNoSignalRecords$m2sdk_release((Long) null, (Long) null, (Integer) null, (Boolean) null, (Integer) null, this);
    }
}
