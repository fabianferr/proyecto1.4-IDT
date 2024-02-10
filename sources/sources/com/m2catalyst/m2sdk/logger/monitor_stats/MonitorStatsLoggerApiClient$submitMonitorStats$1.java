package com.m2catalyst.m2sdk.logger.monitor_stats;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient", f = "MonitorStatsLoggerApiClient.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "submitMonitorStats", n = {"this", "subFiles", "file", "successCount", "errorCount"}, s = {"L$0", "L$1", "L$3", "I$0", "I$1"})
/* compiled from: MonitorStatsLoggerApiClient.kt */
public final class MonitorStatsLoggerApiClient$submitMonitorStats$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MonitorStatsLoggerApiClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitorStatsLoggerApiClient$submitMonitorStats$1(MonitorStatsLoggerApiClient monitorStatsLoggerApiClient, Continuation<? super MonitorStatsLoggerApiClient$submitMonitorStats$1> continuation) {
        super(continuation);
        this.this$0 = monitorStatsLoggerApiClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.submitMonitorStats(this);
    }
}
