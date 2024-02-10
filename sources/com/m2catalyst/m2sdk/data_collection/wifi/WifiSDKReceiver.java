package com.m2catalyst.m2sdk.data_collection.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.m2catalyst.m2sdk.c7;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.j3;
import com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger;
import com.m2catalyst.m2sdk.y1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u000f\u0010\u0010J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"Lcom/m2catalyst/m2sdk/data_collection/wifi/WifiSDKReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/koin/core/component/KoinComponent;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/m2catalyst/m2sdk/c7;", "wifiCollectionManager$delegate", "Lkotlin/Lazy;", "getWifiCollectionManager", "()Lcom/m2catalyst/m2sdk/c7;", "wifiCollectionManager", "<init>", "()V", "Companion", "a", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: WifiSDKReceiver.kt */
public final class WifiSDKReceiver extends BroadcastReceiver implements KoinComponent {
    public static final a Companion = new a();
    public static final String WIFI_CONNECTIVITY_ENTRY_CREATION = "WIFI_CONNECTIVITY_ENTRY_CREATION";
    private final Lazy wifiCollectionManager$delegate = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new d(this));

    /* compiled from: WifiSDKReceiver.kt */
    public static final class a {
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.wifi.WifiSDKReceiver$onReceive$1$1$1", f = "WifiSDKReceiver.kt", i = {}, l = {46}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: WifiSDKReceiver.kt */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ WifiSDKReceiver b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(WifiSDKReceiver wifiSDKReceiver, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = wifiSDKReceiver;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                c7 access$getWifiCollectionManager = this.b.getWifiCollectionManager();
                this.a = 1;
                if (access$getWifiCollectionManager.a(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.wifi.WifiSDKReceiver$onReceive$1$1$2", f = "WifiSDKReceiver.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: WifiSDKReceiver.kt */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ WifiSDKReceiver b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(WifiSDKReceiver wifiSDKReceiver, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = wifiSDKReceiver;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                c7 access$getWifiCollectionManager = this.b.getWifiCollectionManager();
                this.a = 1;
                if (access$getWifiCollectionManager.a(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class d extends Lambda implements Function0<c7> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.c7, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.c7, java.lang.Object] */
        public final c7 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(c7.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(c7.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* access modifiers changed from: private */
    public final c7 getWifiCollectionManager() {
        return (c7) this.wifiCollectionManager$delegate.getValue();
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null && M2SDK.INSTANCE.wakeUpSDK$m2sdk_release(context) && intent != null) {
            String action = intent.getAction();
            if (action == null) {
                action = "";
            }
            if (Intrinsics.areEqual((Object) action, (Object) "android.net.wifi.STATE_CHANGE")) {
                MonitorStatsLogger.increment$default(MonitorStatsLogger.INSTANCE, LoggingEvents.RECEIVER_WIFI_ON_RECEIVE, 1, false, 4, (Object) null);
                j3.b(new b(this, (Continuation<? super b>) null));
            } else if (Intrinsics.areEqual((Object) action, (Object) "android.net.wifi.RSSI_CHANGED")) {
                MonitorStatsLogger.increment$default(MonitorStatsLogger.INSTANCE, LoggingEvents.RECEIVER_WIFI_ON_RECEIVE, 1, false, 4, (Object) null);
                j3.b(new c(this, (Continuation<? super c>) null));
            }
        }
    }
}
