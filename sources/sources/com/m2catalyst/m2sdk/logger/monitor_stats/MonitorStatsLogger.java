package com.m2catalyst.m2sdk.logger.monitor_stats;

import android.os.SystemClock;
import com.m2catalyst.m2sdk.a6;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.o1;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.z5;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0013J\"\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJ\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aJ\u0011\u0010\u001e\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsLogger;", "Lorg/koin/core/component/KoinComponent;", "()V", "MONITOR_STATS_TAG", "", "helper", "Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsManager;", "getHelper", "()Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsManager;", "helper$delegate", "Lkotlin/Lazy;", "lastUptimeRecorded", "", "monitorStatsLoggerApiClient", "Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsLoggerApiClient;", "getMonitorStatsLoggerApiClient", "()Lcom/m2catalyst/m2sdk/logger/monitor_stats/MonitorStatsLoggerApiClient;", "monitorStatsLoggerApiClient$delegate", "buildAndSubmitMonitorStatsPacket", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleDeviceUptime", "increment", "counter", "Lcom/m2catalyst/m2sdk/logger/monitor_stats/LoggingEvents;", "value", "", "override", "", "resetCounter", "submit", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MonitorStatsLogger.kt */
public final class MonitorStatsLogger implements KoinComponent {
    public static final MonitorStatsLogger INSTANCE;
    public static final String MONITOR_STATS_TAG = "monitor_stats_v2";
    private static final Lazy helper$delegate;
    private static long lastUptimeRecorded;
    private static final Lazy monitorStatsLoggerApiClient$delegate;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MonitorStatsLogger.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoggingEventMonitorStatsType.values().length];
            try {
                iArr[LoggingEventMonitorStatsType.LONG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    static {
        MonitorStatsLogger monitorStatsLogger = new MonitorStatsLogger();
        INSTANCE = monitorStatsLogger;
        monitorStatsLoggerApiClient$delegate = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new MonitorStatsLogger$special$$inlined$inject$default$1(monitorStatsLogger, (Qualifier) null, (Function0) null));
        helper$delegate = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new MonitorStatsLogger$special$$inlined$inject$default$2(monitorStatsLogger, (Qualifier) null, (Function0) null));
    }

    private MonitorStatsLogger() {
    }

    private final MonitorStatsManager getHelper() {
        return (MonitorStatsManager) helper$delegate.getValue();
    }

    private final MonitorStatsLoggerApiClient getMonitorStatsLoggerApiClient() {
        return (MonitorStatsLoggerApiClient) monitorStatsLoggerApiClient$delegate.getValue();
    }

    public static /* synthetic */ void increment$default(MonitorStatsLogger monitorStatsLogger, LoggingEvents loggingEvents, Object obj, boolean z, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = 1;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        monitorStatsLogger.increment(loggingEvents, obj, z);
    }

    public static /* synthetic */ void resetCounter$default(MonitorStatsLogger monitorStatsLogger, LoggingEvents loggingEvents, Object obj, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = 0;
        }
        monitorStatsLogger.resetCounter(loggingEvents, obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object buildAndSubmitMonitorStatsPacket(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger$buildAndSubmitMonitorStatsPacket$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger$buildAndSubmitMonitorStatsPacket$1 r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger$buildAndSubmitMonitorStatsPacket$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger$buildAndSubmitMonitorStatsPacket$1 r0 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger$buildAndSubmitMonitorStatsPacket$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005b
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.lang.Object r2 = r0.L$0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r2 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004f
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r6)
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsManager r6 = r5.getHelper()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.createAndSavePackets(r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r2 = r5
        L_0x004f:
            r6 = 0
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r6 = r2.submit(r0)
            if (r6 != r1) goto L_0x005b
            return r1
        L_0x005b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.buildAndSubmitMonitorStatsPacket(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final void handleDeviceUptime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - lastUptimeRecorded > o1.b(5)) {
            if (r2.j == null) {
                r2.j = new r2();
            }
            r2 r2Var = r2.j;
            Intrinsics.checkNotNull(r2Var);
            z5 a = r2Var.a();
            a6 a6Var = a6.SDK_UPTIME;
            long j = -1;
            long j2 = -1L;
            String str = a6Var.a;
            if (a.a.getAll().containsKey(str)) {
                j2 = a.a.getAll().get(str);
            }
            Long l = (Long) j2;
            if (l != null) {
                j = l.longValue();
            }
            long j3 = 0;
            if (j > 0) {
                long j4 = elapsedRealtime - j;
                j3 = j4 < 0 ? elapsedRealtime : j4;
            }
            a.a(a6Var, Long.valueOf(elapsedRealtime));
            increment$default(this, LoggingEvents.SDK_SYSTEM_UPTIME, Long.valueOf(j3), false, 4, (Object) null);
            lastUptimeRecorded = elapsedRealtime;
        }
    }

    public final void increment(LoggingEvents loggingEvents, Object obj, boolean z) {
        Intrinsics.checkNotNullParameter(loggingEvents, "counter");
        Intrinsics.checkNotNullParameter(obj, "value");
        try {
            LoggingEventMonitorStatsType type = loggingEvents.getType();
            if ((type == null ? -1 : WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) != 1) {
                getHelper().incrementIntCounter(loggingEvents, ((Integer) obj).intValue(), z);
            } else if (obj instanceof Long) {
                getHelper().incrementLongCounter(loggingEvents, ((Long) obj).longValue(), z);
            }
            M2SDKLogger.Companion companion = M2SDKLogger.Companion;
            String eventName = loggingEvents.getEventName();
            int a = o1.a(z);
            M2SDKLogger.Companion.log$default(companion, MONITOR_STATS_TAG, "increment_key: " + eventName + " with value " + obj + " and override " + a, (Map) null, false, 12, (Object) null);
        } catch (Exception e) {
            M2SDKLogger.Companion companion2 = M2SDKLogger.Companion;
            String message = e.getMessage();
            M2SDKLogger.Companion.logError$default(companion2, MONITOR_STATS_TAG, "increment error: " + message, (Exception) null, false, 12, (Object) null);
        }
    }

    public final void resetCounter(LoggingEvents loggingEvents, Object obj) {
        Intrinsics.checkNotNullParameter(loggingEvents, "counter");
        Intrinsics.checkNotNullParameter(obj, "value");
        increment(loggingEvents, obj, true);
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        String eventName = loggingEvents.getEventName();
        M2SDKLogger.Companion.log$default(companion, "counter reset", "counter reset with name " + eventName + " to value " + obj, (Map) null, false, 12, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        r10 = r10.getGeneralConfig();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object submit(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger$submit$1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger$submit$1 r0 = (com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger$submit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger$submit$1 r0 = new com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger$submit$1
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0069
        L_0x0029:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r10)
            com.m2catalyst.m2sdk.r2 r10 = com.m2catalyst.m2sdk.r2.j
            if (r10 != 0) goto L_0x003f
            com.m2catalyst.m2sdk.r2 r10 = new com.m2catalyst.m2sdk.r2
            r10.<init>()
            com.m2catalyst.m2sdk.r2.j = r10
        L_0x003f:
            com.m2catalyst.m2sdk.r2 r10 = com.m2catalyst.m2sdk.r2.j
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            com.m2catalyst.m2sdk.configuration.M2Configuration r10 = r10.g
            if (r10 == 0) goto L_0x0059
            com.m2catalyst.m2sdk.p2 r10 = r10.getGeneralConfig()
            if (r10 == 0) goto L_0x0059
            java.lang.Boolean r10 = r10.b
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r2)
            goto L_0x005a
        L_0x0059:
            r10 = 0
        L_0x005a:
            if (r10 == 0) goto L_0x0078
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLoggerApiClient r10 = r9.getMonitorStatsLoggerApiClient()
            r0.label = r3
            java.lang.Object r10 = r10.submitMonitorStats(r0)
            if (r10 != r1) goto L_0x0069
            return r1
        L_0x0069:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r3 = "monitor_stats_v2"
            java.lang.String r4 = "submit process started"
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r2, r3, r4, r5, r6, r7, r8)
        L_0x0078:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.submit(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
