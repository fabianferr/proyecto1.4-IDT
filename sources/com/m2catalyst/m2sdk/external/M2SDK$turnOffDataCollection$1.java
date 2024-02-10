package com.m2catalyst.m2sdk.external;

import android.content.Context;
import com.m2catalyst.m2sdk.a6;
import com.m2catalyst.m2sdk.d7;
import com.m2catalyst.m2sdk.data_collection.wifi.WifiSDKReceiver;
import com.m2catalyst.m2sdk.e2;
import com.m2catalyst.m2sdk.g2;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.r5;
import com.m2catalyst.m2sdk.s5;
import com.m2catalyst.m2sdk.u0;
import com.m2catalyst.m2sdk.v3;
import kotlin.Metadata;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.m2catalyst.m2sdk.external.M2SDK$turnOffDataCollection$1", f = "M2SDK.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: M2SDK.kt */
public final class M2SDK$turnOffDataCollection$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public M2SDK$turnOffDataCollection$1(Continuation<? super M2SDK$turnOffDataCollection$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new M2SDK$turnOffDataCollection$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((M2SDK$turnOffDataCollection$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            M2SDKLogger.Companion.i("M2SDK", "stop()", new String[0]);
            MonitorStatsLogger monitorStatsLogger = MonitorStatsLogger.INSTANCE;
            MonitorStatsLogger.increment$default(monitorStatsLogger, LoggingEvents.SDK_STOP, Boxing.boxInt(1), false, 4, (Object) null);
            if (s5.i == null) {
                s5.i = new s5();
            }
            s5 s5Var = s5.i;
            Intrinsics.checkNotNull(s5Var);
            if (s5Var.a.e() && M2SDK.INSTANCE.isMonitoring()) {
                if (r2.j == null) {
                    r2.j = new r2();
                }
                r2 r2Var = r2.j;
                Intrinsics.checkNotNull(r2Var);
                r2Var.a().a(a6.SDK_PERSISTENT_DATA_COLLECTION_ON, Boolean.FALSE);
                if (u0.e == null) {
                    u0.e = new u0();
                }
                u0 u0Var = u0.e;
                Intrinsics.checkNotNull(u0Var);
                ((v3) u0Var.a.getValue()).e();
                d7 d7Var = (d7) u0Var.c.getValue();
                d7Var.a.b();
                if (d7Var.d) {
                    d7Var.d = false;
                    try {
                        ((Context) d7Var.b.getValue()).getApplicationContext().unregisterReceiver((WifiSDKReceiver) d7Var.c.getValue());
                    } catch (IllegalArgumentException unused) {
                        M2SDKLogger.Companion.e("WifiCollectionOrchestrator", "wifi receiver is not registered to be unregistered", new String[0]);
                    }
                }
                g2 g2Var = (g2) ((e2) u0Var.b.getValue()).a.getValue();
                g2Var.getClass();
                M2SDKLogger.Companion.d(g2Var.a, "stop()", new String[0]);
                g2Var.h = false;
                u0Var.d.a(r5.f, false);
                MonitorStatsLogger.increment$default(monitorStatsLogger, LoggingEvents.SDK_COLLECTION_STOPPED, 1, false, 4, (Object) null);
                for (M2LifecycleListener onSDKCollectionStopped : M2SDK.lifecycleListeners) {
                    onSDKCollectionStopped.onSDKCollectionStopped();
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
