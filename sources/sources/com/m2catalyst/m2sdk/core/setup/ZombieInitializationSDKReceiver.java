package com.m2catalyst.m2sdk.core.setup;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.m2catalyst.m2sdk.a6;
import com.m2catalyst.m2sdk.b6;
import com.m2catalyst.m2sdk.external.M2SDK;
import com.m2catalyst.m2sdk.j3;
import com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents;
import com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger;
import com.m2catalyst.m2sdk.o1;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.r5;
import com.m2catalyst.m2sdk.y1;
import com.m2catalyst.m2sdk.z5;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016R\u001b\u0010\u000e\u001a\u00020\t8BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/m2catalyst/m2sdk/core/setup/ZombieInitializationSDKReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/koin/core/component/KoinComponent;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "Lcom/m2catalyst/m2sdk/b6;", "zombieManager$delegate", "Lkotlin/Lazy;", "getZombieManager", "()Lcom/m2catalyst/m2sdk/b6;", "zombieManager", "Lcom/m2catalyst/m2sdk/r2;", "configuration", "Lcom/m2catalyst/m2sdk/r2;", "<init>", "()V", "Companion", "a", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: ZombieInitializationSDKReceiver.kt */
public final class ZombieInitializationSDKReceiver extends BroadcastReceiver implements KoinComponent {
    public static final String AUTOCHECK_ACTION = "SDK_AUTOCHECK_ACTION";
    public static final a Companion = new a();
    public static final String INITIALIZE_ACTION = "INITIALIZE_ACTION";
    /* access modifiers changed from: private */
    public static int count;
    /* access modifiers changed from: private */
    public final r2 configuration = r2.a.a();
    private final Lazy zombieManager$delegate = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new d(this));

    /* compiled from: ZombieInitializationSDKReceiver.kt */
    public static final class a {
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.core.setup.ZombieInitializationSDKReceiver$onReceive$1$1", f = "ZombieInitializationSDKReceiver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: ZombieInitializationSDKReceiver.kt */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ ZombieInitializationSDKReceiver a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ Intent c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ZombieInitializationSDKReceiver zombieInitializationSDKReceiver, Context context, Intent intent, Continuation<? super b> continuation) {
            super(2, continuation);
            this.a = zombieInitializationSDKReceiver;
            this.b = context;
            this.c = intent;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.a, this.b, this.c, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            z5 a2 = this.a.configuration.a();
            Object obj2 = a6.SDK_PERSISTENT_DATA_COLLECTION_ON.b;
            if (a2.a.getAll().containsKey("sdkPersistentDataCollectionOn")) {
                obj2 = a2.a.getAll().get("sdkPersistentDataCollectionOn");
            }
            if (Intrinsics.areEqual((Object) obj2, (Object) Boxing.boxBoolean(true))) {
                this.a.configuration.a(r5.e, true);
                MonitorStatsLogger.increment$default(MonitorStatsLogger.INSTANCE, LoggingEvents.RECEIVER_REINITIALIZE, Boxing.boxInt(1), false, 4, (Object) null);
                b6 access$getZombieManager = this.a.getZombieManager();
                Context context = this.b;
                long longExtra = this.c.getLongExtra("REPEATING_ALARM_INTERVAL", o1.a(6));
                access$getZombieManager.getClass();
                Intrinsics.checkNotNullParameter(context, "context");
                b6.a(context, System.currentTimeMillis() + longExtra, longExtra);
                M2SDK.INSTANCE.turnOnDataCollection(context);
                Intrinsics.checkNotNullParameter("Trying to revive SDK", "<this>");
            } else {
                Intrinsics.checkNotNullParameter("Zombie run, user opt-out from re-starting collection", "<this>");
            }
            MonitorStatsLogger.increment$default(MonitorStatsLogger.INSTANCE, LoggingEvents.RECEIVER_AUTOCHECK, Boxing.boxInt(1), false, 4, (Object) null);
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.core.setup.ZombieInitializationSDKReceiver$onReceive$1$2", f = "ZombieInitializationSDKReceiver.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: ZombieInitializationSDKReceiver.kt */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Context context, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = context;
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
                M2SDK m2sdk = M2SDK.INSTANCE;
                Context applicationContext = this.b.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                this.a = 1;
                if (m2sdk.initialize$m2sdk_release(applicationContext, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (r2.j == null) {
                r2.j = new r2();
            }
            r2 r2Var = r2.j;
            Intrinsics.checkNotNull(r2Var);
            z5 a2 = r2Var.a();
            a6 a6Var = a6.API_KEY;
            Object obj2 = Boolean.FALSE;
            if (a2.a.getAll().containsKey("sdkPersistentDataCollectionOn")) {
                obj2 = a2.a.getAll().get("sdkPersistentDataCollectionOn");
            }
            Boolean bool = (Boolean) obj2;
            if (bool != null ? bool.booleanValue() : false) {
                M2SDK m2sdk2 = M2SDK.INSTANCE;
                Context applicationContext2 = this.b.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "context.applicationContext");
                m2sdk2.turnOnDataCollection(applicationContext2);
            }
            return Unit.INSTANCE;
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class d extends Lambda implements Function0<b6> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.b6, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.b6, java.lang.Object] */
        public final b6 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(b6.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(b6.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* access modifiers changed from: private */
    public final b6 getZombieManager() {
        return (b6) this.zombieManager$delegate.getValue();
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null) {
            M2SDK.INSTANCE.wakeUpSDK$m2sdk_release(context);
            if (intent != null) {
                String action = intent.getAction();
                if (action == null) {
                    action = "";
                }
                if (Intrinsics.areEqual((Object) action, (Object) AUTOCHECK_ACTION)) {
                    j3.a(new b(this, context, intent, (Continuation<? super b>) null));
                    count++;
                } else if (Intrinsics.areEqual((Object) action, (Object) INITIALIZE_ACTION)) {
                    if (r2.j == null) {
                        r2.j = new r2();
                    }
                    r2 r2Var = r2.j;
                    Intrinsics.checkNotNull(r2Var);
                    z5 a2 = r2Var.a();
                    a6 a6Var = a6.SDK_INITIALIZATION_ALARM_TRIES;
                    int i = 0;
                    int i2 = 0;
                    String str = a6Var.a;
                    if (a2.a.getAll().containsKey(str)) {
                        i2 = a2.a.getAll().get(str);
                    }
                    Integer num = (Integer) i2;
                    if (num != null) {
                        i = num.intValue();
                    }
                    if (r2.j == null) {
                        r2.j = new r2();
                    }
                    r2 r2Var2 = r2.j;
                    Intrinsics.checkNotNull(r2Var2);
                    r2Var2.a().a(a6Var, Integer.valueOf(i + 1));
                    j3.a(new c(context, (Continuation<? super c>) null));
                }
            }
        }
    }
}
