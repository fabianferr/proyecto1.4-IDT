package com.m2catalyst.m2sdk.features.badsignals;

import com.m2catalyst.m2sdk.business.models.MNSI;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.features.badsignals.BadSignalsRepository", f = "BadSignalsRepository.kt", i = {0, 0, 0}, l = {74, 82}, m = "addBadSignalCount", n = {"this", "values", "today"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: BadSignalsRepository.kt */
public final class BadSignalsRepository$addBadSignalCount$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ BadSignalsRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadSignalsRepository$addBadSignalCount$1(BadSignalsRepository badSignalsRepository, Continuation<? super BadSignalsRepository$addBadSignalCount$1> continuation) {
        super(continuation);
        this.this$0 = badSignalsRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addBadSignalCount((List<MNSI>) null, 0, this);
    }
}
