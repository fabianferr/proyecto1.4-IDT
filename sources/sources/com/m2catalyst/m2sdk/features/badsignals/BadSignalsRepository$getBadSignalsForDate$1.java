package com.m2catalyst.m2sdk.features.badsignals;

import java.util.Date;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository", f = "BadSignalsRepository.kt", i = {}, l = {27}, m = "getBadSignalsForDate", n = {}, s = {})
/* compiled from: BadSignalsRepository.kt */
public final class BadSignalsRepository$getBadSignalsForDate$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BadSignalsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadSignalsRepository$getBadSignalsForDate$1(BadSignalsRepository badSignalsRepository, Continuation<? super BadSignalsRepository$getBadSignalsForDate$1> continuation) {
        super(continuation);
        this.this$0 = badSignalsRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getBadSignalsForDate((Date) null, this);
    }
}
