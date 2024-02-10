package com.m2catalyst.m2sdk.logger.monitor_stats;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$incrementIntCounter$1", f = "MonitorStatsManager.kt", i = {0, 0, 0, 1, 1, 1}, l = {62, 64, 70}, m = "invokeSuspend", n = {"$this$queueMNSIJob", "today", "id", "$this$queueMNSIJob", "today", "id"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "I$0"})
/* compiled from: MonitorStatsManager.kt */
public final class MonitorStatsManager$incrementIntCounter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoggingEvents $counter;
    final /* synthetic */ boolean $override;
    final /* synthetic */ int $value;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MonitorStatsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MonitorStatsManager$incrementIntCounter$1(LoggingEvents loggingEvents, int i, MonitorStatsManager monitorStatsManager, boolean z, Continuation<? super MonitorStatsManager$incrementIntCounter$1> continuation) {
        super(2, continuation);
        this.$counter = loggingEvents;
        this.$value = i;
        this.this$0 = monitorStatsManager;
        this.$override = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        MonitorStatsManager$incrementIntCounter$1 monitorStatsManager$incrementIntCounter$1 = new MonitorStatsManager$incrementIntCounter$1(this.$counter, this.$value, this.this$0, this.$override, continuation);
        monitorStatsManager$incrementIntCounter$1.L$0 = obj;
        return monitorStatsManager$incrementIntCounter$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MonitorStatsManager$incrementIntCounter$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0106  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) {
        /*
            r23 = this;
            r0 = r23
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            java.lang.String r7 = "MonitoringStats"
            r8 = 0
            java.lang.String r9 = " by "
            if (r2 == 0) goto L_0x0045
            if (r2 == r5) goto L_0x0034
            if (r2 == r4) goto L_0x0025
            if (r2 != r3) goto L_0x001d
            kotlin.ResultKt.throwOnFailure(r24)
            goto L_0x015a
        L_0x001d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0025:
            int r2 = r0.I$0
            java.lang.Object r4 = r0.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r0.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r24)
            goto L_0x00ff
        L_0x0034:
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            kotlin.ResultKt.throwOnFailure(r24)
            r11 = r5
            r5 = r24
            goto L_0x00ac
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r24)
            java.lang.Object r2 = r0.L$0
            r10 = r2
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            double r11 = java.lang.Math.random()
            r2 = 1000(0x3e8, float:1.401E-42)
            double r13 = (double) r2
            java.lang.Double.isNaN(r13)
            double r11 = r11 * r13
            int r2 = (int) r11
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r11 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r12 = r0.$counter
            java.lang.String r12 = r12.getEventName()
            int r13 = r0.$value
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r2)
            java.lang.String r15 = " - Incrementing counter "
            r14.append(r15)
            r14.append(r12)
            r14.append(r9)
            r14.append(r13)
            java.lang.String r12 = r14.toString()
            java.lang.String[] r13 = new java.lang.String[r8]
            r11.v(r7, r12, r13)
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r11 = r0.this$0
            com.m2catalyst.m2sdk.n1 r11 = r11.getDateProvider()
            java.util.Date r11 = r11.a()
            java.lang.String r11 = com.m2catalyst.m2sdk.o1.a((java.util.Date) r11)
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r12 = r0.this$0
            com.m2catalyst.m2sdk.database.daos.CounterDao r12 = r12.counterDao
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r13 = r0.$counter
            java.lang.String r13 = r13.getEventName()
            r0.L$0 = r10
            r0.L$1 = r11
            r0.I$0 = r2
            r0.label = r5
            java.lang.Object r5 = r12.getIntCounterById(r13, r11, r0)
            if (r5 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            com.m2catalyst.m2sdk.database.entities.CounterInt r5 = (com.m2catalyst.m2sdk.database.entities.CounterInt) r5
            if (r5 == 0) goto L_0x0102
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r12 = r0.$counter
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r13 = r0.this$0
            boolean r14 = r0.$override
            int r15 = r0.$value
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r6 = r12.getEventName()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            java.lang.String r8 = " - got counter "
            r4.append(r8)
            r4.append(r6)
            r4.append(r9)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            r6 = 0
            java.lang.String[] r8 = new java.lang.String[r6]
            r3.v(r7, r4, r8)
            com.m2catalyst.m2sdk.database.daos.CounterDao r3 = r13.counterDao
            java.lang.String r4 = r12.getEventName()
            if (r14 == 0) goto L_0x00e9
            goto L_0x00ee
        L_0x00e9:
            int r5 = r5.getCounterValue()
            int r15 = r15 + r5
        L_0x00ee:
            r0.L$0 = r10
            r0.L$1 = r11
            r0.I$0 = r2
            r5 = 2
            r0.label = r5
            java.lang.Object r3 = r3.incrementIntCounter(r4, r11, r15, r0)
            if (r3 != r1) goto L_0x00fe
            return r1
        L_0x00fe:
            r4 = r11
        L_0x00ff:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x0104
        L_0x0102:
            r4 = r11
            r3 = 0
        L_0x0104:
            if (r3 != 0) goto L_0x015a
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r3 = r0.$counter
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r5 = r0.this$0
            int r6 = r0.$value
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r8 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r10 = r3.getEventName()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r2)
            java.lang.String r2 = " - insertIntCounter "
            r11.append(r2)
            r11.append(r10)
            r11.append(r9)
            r11.append(r4)
            java.lang.String r2 = r11.toString()
            r9 = 0
            java.lang.String[] r9 = new java.lang.String[r9]
            r8.v(r7, r2, r9)
            com.m2catalyst.m2sdk.database.daos.CounterDao r2 = r5.counterDao
            com.m2catalyst.m2sdk.database.entities.CounterInt r5 = new com.m2catalyst.m2sdk.database.entities.CounterInt
            java.lang.String r17 = r3.getEventName()
            r20 = 0
            r21 = 8
            r22 = 0
            r16 = r5
            r18 = r6
            r19 = r4
            r16.<init>(r17, r18, r19, r20, r21, r22)
            r3 = 0
            r0.L$0 = r3
            r0.L$1 = r3
            r3 = 3
            r0.label = r3
            java.lang.Object r2 = r2.insertIntCounter(r5, r0)
            if (r2 != r1) goto L_0x015a
            return r1
        L_0x015a:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager$incrementIntCounter$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
