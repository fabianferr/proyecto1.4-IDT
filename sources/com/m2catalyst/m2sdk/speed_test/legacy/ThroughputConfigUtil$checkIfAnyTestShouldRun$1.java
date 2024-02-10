package com.m2catalyst.m2sdk.speed_test.legacy;

import com.m2catalyst.m2sdk.business.models.MNSI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil", f = "ThroughputConfigUtil.kt", i = {0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {1039, 1053, 1070, 1085, 1098}, m = "checkIfAnyTestShouldRun", n = {"this", "this", "runAnyTest", "this", "runAnyTest", "this", "runAnyTest", "this", "runAnyTest"}, s = {"L$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
/* compiled from: ThroughputConfigUtil.kt */
public final class ThroughputConfigUtil$checkIfAnyTestShouldRun$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThroughputConfigUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThroughputConfigUtil$checkIfAnyTestShouldRun$1(ThroughputConfigUtil throughputConfigUtil, Continuation<? super ThroughputConfigUtil$checkIfAnyTestShouldRun$1> continuation) {
        super(continuation);
        this.this$0 = throughputConfigUtil;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.checkIfAnyTestShouldRun((MNSI) null, this);
    }
}
