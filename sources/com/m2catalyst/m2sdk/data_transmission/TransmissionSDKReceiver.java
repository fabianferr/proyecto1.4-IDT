package com.m2catalyst.m2sdk.data_transmission;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.i3;
import com.m2catalyst.m2sdk.j3;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger;
import com.m2catalyst.m2sdk.w6;
import com.m2catalyst.m2sdk.x6;
import com.m2catalyst.m2sdk.y1;
import com.m2catalyst.m2sdk.y6;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\n\u001a\u00020\t8\u0002XD¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001b\u0010\u0011\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/m2catalyst/m2sdk/data_transmission/TransmissionSDKReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/koin/core/component/KoinComponent;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "", "TAG", "Ljava/lang/String;", "Lcom/m2catalyst/m2sdk/x6;", "transmissionManager$delegate", "Lkotlin/Lazy;", "getTransmissionManager", "()Lcom/m2catalyst/m2sdk/x6;", "transmissionManager", "<init>", "()V", "Companion", "a", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: TransmissionSDKReceiver.kt */
public final class TransmissionSDKReceiver extends BroadcastReceiver implements KoinComponent {
    public static final String BUILD_MONITOR_STATS = "BUILD_MONITOR_STATS";
    public static final a Companion = new a();
    public static final String TRANSMISSION_INGESTION_ALARM_ACTION = "TRANSMISSION_INGESTION_ALARM";
    /* access modifiers changed from: private */
    public static int count;
    private final String TAG = "TransmissionSDKReceiver";
    private final Lazy transmissionManager$delegate = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));

    /* compiled from: TransmissionSDKReceiver.kt */
    public static final class a {
    }

    /* compiled from: KoinComponent.kt */
    public static final class b extends Lambda implements Function0<x6> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.x6, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.x6, java.lang.Object] */
        public final x6 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(x6.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(x6.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    private final x6 getTransmissionManager() {
        return (x6) this.transmissionManager$delegate.getValue();
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public void onReceive(Context context, Intent intent) {
        Context context2 = context;
        if (context2 != null && M2SDK.INSTANCE.wakeUpSDK$m2sdk_release(context2) && intent != null) {
            String action = intent.getAction();
            if (action == null) {
                action = "";
            }
            if (Intrinsics.areEqual((Object) action, (Object) TRANSMISSION_INGESTION_ALARM_ACTION)) {
                M2SDKLogger.Companion.i(this.TAG, "Received - TRANSMISSION_INGESTION_ALARM", new String[0]);
                MonitorStatsLogger.increment$default(MonitorStatsLogger.INSTANCE, LoggingEvents.RECEIVER_INGESTION_TRANSMISSION_REQUESTED, 1, false, 4, (Object) null);
                x6 transmissionManager = getTransmissionManager();
                transmissionManager.getClass();
                Intrinsics.checkNotNullParameter(context2, "context");
                transmissionManager.c.d("TransmissionManager", "transmit()", new String[0]);
                Mutex mutex = transmissionManager.h;
                y6 y6Var = new y6(transmissionManager, false, context2, (Continuation<? super y6>) null);
                j3.b bVar = j3.a;
                Intrinsics.checkNotNullParameter(mutex, "<this>");
                Intrinsics.checkNotNullParameter(y6Var, "block");
                Job unused = BuildersKt__Builders_commonKt.launch$default(j3.b, (CoroutineContext) null, (CoroutineStart) null, new i3(mutex, y6Var, (Long) null, "Transmission", (Function1<? super Throwable, Unit>) null, (Continuation<? super i3>) null), 3, (Object) null);
                count++;
            } else if (Intrinsics.areEqual((Object) action, (Object) BUILD_MONITOR_STATS)) {
                M2SDKLogger.Companion.i(this.TAG, "Received - BUILD_MONITOR_STATS", new String[0]);
                MonitorStatsLogger.increment$default(MonitorStatsLogger.INSTANCE, LoggingEvents.RECEIVER_MONITOR_STATS_TRANSMISSION_REQUESTED, 1, false, 4, (Object) null);
                x6 transmissionManager2 = getTransmissionManager();
                transmissionManager2.getClass();
                Intrinsics.checkNotNullParameter(context2, "context");
                Mutex mutex2 = transmissionManager2.g;
                w6 w6Var = new w6(transmissionManager2, context2, (Continuation<? super w6>) null);
                j3.b bVar2 = j3.a;
                Intrinsics.checkNotNullParameter(mutex2, "<this>");
                Intrinsics.checkNotNullParameter(w6Var, "block");
                Job unused2 = BuildersKt__Builders_commonKt.launch$default(j3.b, (CoroutineContext) null, (CoroutineStart) null, new i3(mutex2, w6Var, (Long) null, "Transmission", (Function1<? super Throwable, Unit>) null, (Continuation<? super i3>) null), 3, (Object) null);
                count++;
            }
        }
    }
}
