package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.data_transmission.TransmissionSDKReceiver;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@DebugMetadata(c = "com.m2catalyst.m2sdk.data_transmission.TransmissionManager$buildAndSubmitMonitorStats$1", f = "TransmissionManager.kt", i = {}, l = {137}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TransmissionManager.kt */
public final class w6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ x6 b;
    public final /* synthetic */ Context c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w6(x6 x6Var, Context context, Continuation<? super w6> continuation) {
        super(2, continuation);
        this.b = x6Var;
        this.c = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new w6(this.b, this.c, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((w6) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.a;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.b.a.a().a(a6.LAST_TIME_MONITOR_STATS_TRANSMITTED, Boxing.boxLong(System.currentTimeMillis()));
            z5 a2 = this.b.a.a();
            a6 a6Var = a6.NEXT_TIME_MONITOR_STATS_TRANSMISSION;
            long j = 0;
            Object boxLong = Boxing.boxLong(0);
            if (a2.a.getAll().containsKey("nextTimeMonitorStatsTransmission")) {
                boxLong = a2.a.getAll().get("nextTimeMonitorStatsTransmission");
            }
            Long l = (Long) boxLong;
            if (l != null) {
                j = l.longValue();
            }
            long a3 = o1.a(24);
            if (j < System.currentTimeMillis()) {
                j = o1.b(1) + System.currentTimeMillis() + a3;
                this.b.a.a().a(a6Var, Boxing.boxLong(j));
            }
            x6 x6Var = this.b;
            Context context = this.c;
            x6Var.getClass();
            x6.a(context, TransmissionSDKReceiver.BUILD_MONITOR_STATS, j, a3);
            z5 a4 = this.b.a.a();
            Object boxBoolean = Boxing.boxBoolean(true);
            if (a4.a.getAll().containsKey("crowdsourceSharingEnable")) {
                boxBoolean = a4.a.getAll().get("crowdsourceSharingEnable");
            }
            Intrinsics.checkNotNull(boxBoolean);
            if (((Boolean) boxBoolean).booleanValue()) {
                MonitorStatsLogger monitorStatsLogger = MonitorStatsLogger.INSTANCE;
                this.a = 1;
                if (monitorStatsLogger.buildAndSubmitMonitorStatsPacket(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.b.i.incrementAndGet();
        return Unit.INSTANCE;
    }
}
