package com.m2catalyst.m2sdk.speed_test.legacy;

import android.location.Location;
import android.net.Network;
import com.m2catalyst.m2sdk.business.models.MNSI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil", f = "ThroughputConfigUtil.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {188, 190, 191}, m = "initiateTest", n = {"this", "networkDiagnosticTestConfig", "mnsi", "this", "networkDiagnosticTestConfig", "mnsi", "testNumber", "this", "networkDiagnosticTestConfig", "mnsi", "testNumber", "testShouldrRun"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "Z$0"})
/* compiled from: ThroughputConfigUtil.kt */
public final class ThroughputConfigUtil$initiateTest$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ThroughputConfigUtil this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThroughputConfigUtil$initiateTest$1(ThroughputConfigUtil throughputConfigUtil, Continuation<? super ThroughputConfigUtil$initiateTest$1> continuation) {
        super(continuation);
        this.this$0 = throughputConfigUtil;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initiateTest((NetworkDiagnosticTestConfig) null, (MNSI) null, (Location) null, (Network) null, (MNSI) null, this);
    }
}
