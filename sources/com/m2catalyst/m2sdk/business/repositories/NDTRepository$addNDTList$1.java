package com.m2catalyst.m2sdk.business.repositories;

import com.m2catalyst.m2sdk.ndt.models.DiagnosticsResults;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.business.repositories.NDTRepository", f = "NDTRepository.kt", i = {0, 0}, l = {132}, m = "addNDTList", n = {"this", "accepted"}, s = {"L$0", "L$1"})
/* compiled from: NDTRepository.kt */
public final class NDTRepository$addNDTList$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NDTRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NDTRepository$addNDTList$1(NDTRepository nDTRepository, Continuation<? super NDTRepository$addNDTList$1> continuation) {
        super(continuation);
        this.this$0 = nDTRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addNDTList((List<DiagnosticsResults>) null, this);
    }
}
