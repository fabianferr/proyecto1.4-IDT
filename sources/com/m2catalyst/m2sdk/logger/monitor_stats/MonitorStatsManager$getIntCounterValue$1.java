package com.m2catalyst.m2sdk.logger.monitor_stats;

import java.util.Date;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager", f = "MonitorStatsManager.kt", i = {}, l = {90}, m = "getIntCounterValue", n = {}, s = {})
/* compiled from: MonitorStatsManager.kt */
public final class MonitorStatsManager$getIntCounterValue$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MonitorStatsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitorStatsManager$getIntCounterValue$1(MonitorStatsManager monitorStatsManager, Continuation<? super MonitorStatsManager$getIntCounterValue$1> continuation) {
        super(continuation);
        this.this$0 = monitorStatsManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getIntCounterValue((LoggingEvents) null, (Date) null, this);
    }
}
