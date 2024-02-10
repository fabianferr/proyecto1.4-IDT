package com.m2catalyst.m2sdk.logger.monitor_stats;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$incrementLongCounter$1", f = "MonitorStatsManager.kt", i = {0, 0, 1, 1}, l = {108, 113, 118}, m = "invokeSuspend", n = {"$this$queueMNSIJob", "today", "$this$queueMNSIJob", "today"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: MonitorStatsManager.kt */
public final class MonitorStatsManager$incrementLongCounter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoggingEvents $counter;
    final /* synthetic */ boolean $override;
    final /* synthetic */ long $value;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MonitorStatsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitorStatsManager$incrementLongCounter$1(MonitorStatsManager monitorStatsManager, LoggingEvents loggingEvents, long j, boolean z, Continuation<? super MonitorStatsManager$incrementLongCounter$1> continuation) {
        super(2, continuation);
        this.this$0 = monitorStatsManager;
        this.$counter = loggingEvents;
        this.$value = j;
        this.$override = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MonitorStatsManager$incrementLongCounter$1 monitorStatsManager$incrementLongCounter$1 = new MonitorStatsManager$incrementLongCounter$1(this.this$0, this.$counter, this.$value, this.$override, continuation);
        monitorStatsManager$incrementLongCounter$1.L$0 = obj;
        return monitorStatsManager$incrementLongCounter$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MonitorStatsManager$incrementLongCounter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) {
        /*
            r16 = this;
            r6 = r16
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r6.label
            r8 = 3
            r1 = 2
            r2 = 1
            if (r0 == 0) goto L_0x003d
            if (r0 == r2) goto L_0x002d
            if (r0 == r1) goto L_0x0020
            if (r0 != r8) goto L_0x0018
            kotlin.ResultKt.throwOnFailure(r17)
            goto L_0x0103
        L_0x0018:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0020:
            java.lang.Object r0 = r6.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r1 = r6.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.throwOnFailure(r17)
            goto L_0x00d4
        L_0x002d:
            java.lang.Object r0 = r6.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r6.L$0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            kotlin.ResultKt.throwOnFailure(r17)
            r10 = r0
            r0 = r2
            r2 = r17
            goto L_0x006c
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r17)
            java.lang.Object r0 = r6.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r3 = r6.this$0
            com.m2catalyst.m2sdk.n1 r3 = r3.getDateProvider()
            java.util.Date r3 = r3.a()
            java.lang.String r3 = com.m2catalyst.m2sdk.o1.a((java.util.Date) r3)
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r4 = r6.this$0
            com.m2catalyst.m2sdk.database.daos.CounterDao r4 = r4.counterDao
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r5 = r6.$counter
            java.lang.String r5 = r5.getEventName()
            r6.L$0 = r0
            r6.L$1 = r3
            r6.label = r2
            java.lang.Object r2 = r4.getLongCounterById(r5, r3, r6)
            if (r2 != r7) goto L_0x006b
            return r7
        L_0x006b:
            r10 = r3
        L_0x006c:
            com.m2catalyst.m2sdk.database.entities.CounterLong r2 = (com.m2catalyst.m2sdk.database.entities.CounterLong) r2
            if (r2 == 0) goto L_0x00d8
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r3 = r6.$counter
            long r4 = r6.$value
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r11 = r6.this$0
            boolean r12 = r6.$override
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r13 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r14 = r3.getEventName()
            long r8 = r2.getCounterValue()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r1 = "got counter "
            r15.<init>(r1)
            r15.append(r14)
            java.lang.String r1 = " by "
            r15.append(r1)
            r15.append(r10)
            java.lang.String r14 = " - increment "
            r15.append(r14)
            r15.append(r8)
            r15.append(r1)
            r15.append(r4)
            java.lang.String r1 = r15.toString()
            r8 = 0
            java.lang.String[] r8 = new java.lang.String[r8]
            java.lang.String r9 = "MonitoringStats"
            r13.d(r9, r1, r8)
            com.m2catalyst.m2sdk.database.daos.CounterDao r1 = r11.counterDao
            java.lang.String r3 = r3.getEventName()
            if (r12 == 0) goto L_0x00b9
            goto L_0x00bf
        L_0x00b9:
            long r8 = r2.getCounterValue()
            long r8 = r8 + r4
            r4 = r8
        L_0x00bf:
            r6.L$0 = r0
            r6.L$1 = r10
            r0 = 2
            r6.label = r0
            r0 = r1
            r1 = r3
            r2 = r10
            r3 = r4
            r5 = r16
            java.lang.Object r0 = r0.incrementLongCounter(r1, r2, r3, r5)
            if (r0 != r7) goto L_0x00d3
            return r7
        L_0x00d3:
            r0 = r10
        L_0x00d4:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r12 = r0
            goto L_0x00da
        L_0x00d8:
            r12 = r10
            r1 = 0
        L_0x00da:
            if (r1 != 0) goto L_0x0103
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r0 = r6.this$0
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r1 = r6.$counter
            long r10 = r6.$value
            com.m2catalyst.m2sdk.database.daos.CounterDao r0 = r0.counterDao
            com.m2catalyst.m2sdk.database.entities.CounterLong r2 = new com.m2catalyst.m2sdk.database.entities.CounterLong
            java.lang.String r9 = r1.getEventName()
            r13 = 0
            r14 = 8
            r15 = 0
            r8 = r2
            r8.<init>(r9, r10, r12, r13, r14, r15)
            r1 = 0
            r6.L$0 = r1
            r6.L$1 = r1
            r1 = 3
            r6.label = r1
            java.lang.Object r0 = r0.insertLongCounter(r2, r6)
            if (r0 != r7) goto L_0x0103
            return r7
        L_0x0103:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$incrementLongCounter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
