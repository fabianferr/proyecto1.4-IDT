package com.m2catalyst.m2sdk.logger.monitor_stats;

import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager", f = "MonitorStatsManager.kt", i = {0, 0}, l = {290, 291}, m = "buildPacketAndMarkTransmitted", n = {"this", "date"}, s = {"L$0", "L$1"})
/* compiled from: MonitorStatsManager.kt */
public final class MonitorStatsManager$buildPacketAndMarkTransmitted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MonitorStatsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitorStatsManager$buildPacketAndMarkTransmitted$1(MonitorStatsManager monitorStatsManager, Continuation<? super MonitorStatsManager$buildPacketAndMarkTransmitted$1> continuation) {
        super(continuation);
        this.this$0 = monitorStatsManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.buildPacketAndMarkTransmitted((ApiRequestMessage) null, (String) null, this);
    }
}