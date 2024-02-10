package com.m2catalyst.m2sdk.data_collection.location;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.m2catalyst.m2sdk.g2;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.o1;
import com.m2catalyst.m2sdk.y1;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\u001cB\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u001c\u0010\u000f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0011\u001a\u00020\u00108\u0002XD¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0018\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/m2catalyst/m2sdk/data_collection/location/LocationSDKReceiver;", "Landroid/content/BroadcastReceiver;", "Lorg/koin/core/component/KoinComponent;", "Landroid/location/Location;", "location", "", "storeLocation", "(Landroid/location/Location;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "", "nextAlarm", "setupRecurrentLocationAlarm", "Landroid/content/Intent;", "intent", "onReceive", "", "TAG", "Ljava/lang/String;", "Lcom/m2catalyst/m2sdk/g2;", "locationCollectorManager$delegate", "Lkotlin/Lazy;", "getLocationCollectorManager", "()Lcom/m2catalyst/m2sdk/g2;", "locationCollectorManager", "<init>", "()V", "Companion", "a", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: LocationSDKReceiver.kt */
public final class LocationSDKReceiver extends BroadcastReceiver implements KoinComponent {
    public static final a Companion = new a();
    public static final String LOCATION_COLLECTION_UPDATE = "LOCATION_COLLECTION_UPDATE";
    public static final String RECURRENT_LOCATION_COLLECTION = "RECURRENT_LOCATION_COLLECTION";
    private final String TAG = "LocationSDKReceiver";
    private final Lazy locationCollectorManager$delegate = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new d(this));

    /* compiled from: LocationSDKReceiver.kt */
    public static final class a {
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver$onReceive$1$1$1", f = "LocationSDKReceiver.kt", i = {}, l = {68}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: LocationSDKReceiver.kt */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ LocationSDKReceiver b;
        public final /* synthetic */ Location c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(LocationSDKReceiver locationSDKReceiver, Location location, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = locationSDKReceiver;
            this.c = location;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LocationSDKReceiver locationSDKReceiver = this.b;
                Location location = this.c;
                this.a = 1;
                if (locationSDKReceiver.storeLocation(location, this) == coroutine_suspended) {
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

    /* compiled from: LocationSDKReceiver.kt */
    public static final class c extends Lambda implements Function0<Location> {
        public final /* synthetic */ Intent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Intent intent) {
            super(0);
            this.a = intent;
        }

        public final Object invoke() {
            Bundle extras = this.a.getExtras();
            return (Location) (extras != null ? extras.get(FirebaseAnalytics.Param.LOCATION) : null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class d extends Lambda implements Function0<g2> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.g2] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.g2] */
        public final g2 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(g2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(g2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver", f = "LocationSDKReceiver.kt", i = {0}, l = {89, 91}, m = "storeLocation", n = {"this"}, s = {"L$0"})
    /* compiled from: LocationSDKReceiver.kt */
    public static final class e extends ContinuationImpl {
        public LocationSDKReceiver a;
        public /* synthetic */ Object b;
        public final /* synthetic */ LocationSDKReceiver c;
        public int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(LocationSDKReceiver locationSDKReceiver, Continuation<? super e> continuation) {
            super(continuation);
            this.c = locationSDKReceiver;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.storeLocation((Location) null, this);
        }
    }

    private final g2 getLocationCollectorManager() {
        return (g2) this.locationCollectorManager$delegate.getValue();
    }

    private final void setupRecurrentLocationAlarm(Context context, long j) {
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        String str = this.TAG;
        String a2 = o1.a(System.currentTimeMillis() + j);
        companion.d(str, "setupRecurrentLocationAlarm " + a2, new String[0]);
        getLocationCollectorManager().d();
        Context context2 = context;
        com.m2catalyst.m2sdk.a.a(context2, LocationSDKReceiver.class, RECURRENT_LOCATION_COLLECTION, System.currentTimeMillis() + j, j, 0, 0, true);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object storeLocation(android.location.Location r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver.e
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver$e r0 = (com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver$e r0 = new com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver$e
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 == r5) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006c
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0035:
            com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver r7 = r0.a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0056
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r8)
            if (r7 == 0) goto L_0x0059
            com.m2catalyst.m2sdk.g2 r8 = r6.getLocationCollectorManager()
            com.m2catalyst.m2sdk.business.models.M2Location r2 = new com.m2catalyst.m2sdk.business.models.M2Location
            r2.<init>((android.location.Location) r7)
            r0.a = r6
            r0.d = r5
            r7 = 0
            java.lang.Object r7 = r8.a((com.m2catalyst.m2sdk.business.models.M2Location) r2, (boolean) r7, (boolean) r5, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r7 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r7 = r6
        L_0x0056:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            goto L_0x005b
        L_0x0059:
            r7 = r6
            r8 = r4
        L_0x005b:
            if (r8 != 0) goto L_0x006c
            com.m2catalyst.m2sdk.g2 r7 = r7.getLocationCollectorManager()
            r0.a = r4
            r0.d = r3
            java.lang.Object r7 = r7.b(r0)
            if (r7 != r1) goto L_0x006c
            return r1
        L_0x006c:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver.storeLocation(android.location.Location, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0044, code lost:
        r0 = (r0 = r0.getLocationConfiguration()).b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(android.content.Context r11, android.content.Intent r12) {
        /*
            r10 = this;
            if (r11 == 0) goto L_0x00ae
            com.m2catalyst.m2sdk.external.M2SDK r0 = com.m2catalyst.m2sdk.external.M2SDK.INSTANCE
            boolean r0 = r0.wakeUpSDK$m2sdk_release(r11)
            if (r0 != 0) goto L_0x000b
            return
        L_0x000b:
            if (r12 == 0) goto L_0x00ae
            java.lang.String r0 = r12.getAction()
            if (r0 != 0) goto L_0x0015
            java.lang.String r0 = ""
        L_0x0015:
            java.lang.String r1 = "RECURRENT_LOCATION_COLLECTION"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x006a
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r1 = r10.TAG
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.String r4 = "onReceive RECURRENT_LOCATION_COLLECTION"
            r0.d(r1, r4, r2)
            com.m2catalyst.m2sdk.r2 r0 = com.m2catalyst.m2sdk.r2.j
            if (r0 != 0) goto L_0x0035
            com.m2catalyst.m2sdk.r2 r0 = new com.m2catalyst.m2sdk.r2
            r0.<init>()
            com.m2catalyst.m2sdk.r2.j = r0
        L_0x0035:
            com.m2catalyst.m2sdk.r2 r0 = com.m2catalyst.m2sdk.r2.j
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.m2catalyst.m2sdk.configuration.M2Configuration r0 = r0.g
            if (r0 == 0) goto L_0x004d
            com.m2catalyst.m2sdk.h2 r0 = r0.getLocationConfiguration()
            if (r0 == 0) goto L_0x004d
            java.lang.Integer r0 = r0.b
            if (r0 == 0) goto L_0x004d
            int r0 = r0.intValue()
            goto L_0x004e
        L_0x004d:
            r0 = 5
        L_0x004e:
            long r0 = com.m2catalyst.m2sdk.o1.b(r0)
            java.lang.String r2 = "REPEATING_ALARM_INTERVAL"
            long r0 = r12.getLongExtra(r2, r0)
            r10.setupRecurrentLocationAlarm(r11, r0)
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r4 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r5 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.RECEIVER_LOCATION_RECURRENT_COLLECTION_REQUESTED
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            r7 = 0
            r8 = 4
            r9 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r4, r5, r6, r7, r8, r9)
            goto L_0x00ae
        L_0x006a:
            java.lang.String r11 = "LOCATION_COLLECTION_UPDATE"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x00ae
            com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver$c r11 = new com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver$c
            r11.<init>(r12)
            java.lang.String r12 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r12)
            r12 = 0
            java.lang.Object r11 = r11.invoke()     // Catch:{ Exception -> 0x0082 }
            goto L_0x0083
        L_0x0082:
            r11 = r12
        L_0x0083:
            android.location.Location r11 = (android.location.Location) r11
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r0 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r1 = r10.TAG
            java.lang.String[] r4 = new java.lang.String[r3]
            com.m2catalyst.m2sdk.logger.LoggerUtils r5 = com.m2catalyst.m2sdk.logger.LoggerUtils.INSTANCE
            java.lang.String r5 = r5.locationToString(r11)
            r4[r2] = r5
            java.lang.String r2 = "onReceive Location Collection Update"
            r0.d(r1, r2, r4)
            com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver$b r0 = new com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver$b
            r0.<init>(r10, r11, r12)
            com.m2catalyst.m2sdk.j3.a(r0)
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r4 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r5 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.RECEIVER_LOCATION_COLLECTION_UPDATED
            java.lang.Integer r6 = java.lang.Integer.valueOf(r3)
            r7 = 0
            r8 = 4
            r9 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r4, r5, r6, r7, r8, r9)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
