package com.m2catalyst.m2sdk.business.repositories;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.MNSIRepository", f = "MNSIRepository.kt", i = {0}, l = {183}, m = "handleWifiLogs", n = {"this"}, s = {"L$0"})
/* compiled from: MNSIRepository.kt */
public final class MNSIRepository$handleWifiLogs$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MNSIRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MNSIRepository$handleWifiLogs$1(MNSIRepository mNSIRepository, Continuation<? super MNSIRepository$handleWifiLogs$1> continuation) {
        super(continuation);
        this.this$0 = mNSIRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleWifiLogs(this);
    }
}
