package com.m2catalyst.m2sdk.logger.monitor_stats;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager", f = "MonitorStatsManager.kt", i = {0, 0, 1, 1, 1}, l = {270, 272}, m = "createApiRequestMessage", n = {"this", "date", "this", "date", "counterInts"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2"})
/* compiled from: MonitorStatsManager.kt */
public final class MonitorStatsManager$createApiRequestMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MonitorStatsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitorStatsManager$createApiRequestMessage$1(MonitorStatsManager monitorStatsManager, Continuation<? super MonitorStatsManager$createApiRequestMessage$1> continuation) {
        super(continuation);
        this.this$0 = monitorStatsManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createApiRequestMessage((String) null, this);
    }
}
