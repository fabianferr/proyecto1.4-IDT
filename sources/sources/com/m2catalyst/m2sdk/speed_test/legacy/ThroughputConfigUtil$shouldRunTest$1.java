package com.m2catalyst.m2sdk.speed_test.legacy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil", f = "ThroughputConfigUtil.kt", i = {0, 0, 0}, l = {1165}, m = "shouldRunTest", n = {"this", "indicator", "obj"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: ThroughputConfigUtil.kt */
public final class ThroughputConfigUtil$shouldRunTest$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThroughputConfigUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThroughputConfigUtil$shouldRunTest$1(ThroughputConfigUtil throughputConfigUtil, Continuation<? super ThroughputConfigUtil$shouldRunTest$1> continuation) {
        super(continuation);
        this.this$0 = throughputConfigUtil;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.shouldRunTest((String) null, (ThroughputConfigurationVO) null, this);
    }
}
