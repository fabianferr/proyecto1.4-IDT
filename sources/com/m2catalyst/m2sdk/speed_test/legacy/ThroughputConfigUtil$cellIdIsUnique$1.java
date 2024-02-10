package com.m2catalyst.m2sdk.speed_test.legacy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil", f = "ThroughputConfigUtil.kt", i = {}, l = {1217}, m = "cellIdIsUnique", n = {}, s = {})
/* compiled from: ThroughputConfigUtil.kt */
public final class ThroughputConfigUtil$cellIdIsUnique$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThroughputConfigUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThroughputConfigUtil$cellIdIsUnique$1(ThroughputConfigUtil throughputConfigUtil, Continuation<? super ThroughputConfigUtil$cellIdIsUnique$1> continuation) {
        super(continuation);
        this.this$0 = throughputConfigUtil;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.cellIdIsUnique(this);
    }
}
