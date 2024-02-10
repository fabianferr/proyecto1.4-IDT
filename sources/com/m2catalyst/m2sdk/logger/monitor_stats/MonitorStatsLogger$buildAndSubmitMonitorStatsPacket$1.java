package com.m2catalyst.m2sdk.logger.monitor_stats;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger", f = "MonitorStatsLogger.kt", i = {0}, l = {63, 64}, m = "buildAndSubmitMonitorStatsPacket", n = {"this"}, s = {"L$0"})
/* compiled from: MonitorStatsLogger.kt */
public final class MonitorStatsLogger$buildAndSubmitMonitorStatsPacket$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MonitorStatsLogger this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitorStatsLogger$buildAndSubmitMonitorStatsPacket$1(MonitorStatsLogger monitorStatsLogger, Continuation<? super MonitorStatsLogger$buildAndSubmitMonitorStatsPacket$1> continuation) {
        super(continuation);
        this.this$0 = monitorStatsLogger;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.buildAndSubmitMonitorStatsPacket(this);
    }
}
