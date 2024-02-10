package com.m2catalyst.m2sdk;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import androidx.media3.common.C;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.m2catalyst.m2sdk.business.models.M2Location;
import com.m2catalyst.m2sdk.business.repositories.LocationRepository;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.r2;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: LocationCollectorManager.kt */
public final class g2 implements KoinComponent {
    public final String a = "LocationCollectorManager";
    public final Lazy b = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new g(this));
    public final Lazy c = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new h(this));
    public final Lazy d = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new i(this));
    public M2Location e;
    public final LocationManager f = ((LocationManager) a().getSystemService(FirebaseAnalytics.Param.LOCATION));
    public final SensorManager g = ((SensorManager) a().getSystemService("sensor"));
    public boolean h = true;
    public final CopyOnWriteArrayList<M2Location> i = new CopyOnWriteArrayList<>();
    public final long j = 300000;
    public final long k = 60000;
    public final long l = 600000;

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.location.LocationCollectorManager", f = "LocationCollectorManager.kt", i = {0}, l = {290}, m = "getBestLocation", n = {"loc"}, s = {"L$0"})
    /* compiled from: LocationCollectorManager.kt */
    public static final class a extends ContinuationImpl {
        public M2Location a;
        public /* synthetic */ Object b;
        public final /* synthetic */ g2 c;
        public int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g2 g2Var, Continuation<? super a> continuation) {
            super(continuation);
            this.c = g2Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Continuation<? super M2Location>) this);
        }
    }

    /* compiled from: LocationCollectorManager.kt */
    public static final class b extends Lambda implements Function0<Location> {
        public final /* synthetic */ g2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g2 g2Var) {
            super(0);
            this.a = g2Var;
        }

        public final Object invoke() {
            LocationManager locationManager = this.a.f;
            if (locationManager != null) {
                return locationManager.getLastKnownLocation("fused");
            }
            return null;
        }
    }

    /* compiled from: LocationCollectorManager.kt */
    public static final class c extends Lambda implements Function0<Location> {
        public final /* synthetic */ g2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(g2 g2Var) {
            super(0);
            this.a = g2Var;
        }

        public final Object invoke() {
            LocationManager locationManager = this.a.f;
            if (locationManager != null) {
                return locationManager.getLastKnownLocation("gps");
            }
            return null;
        }
    }

    /* compiled from: LocationCollectorManager.kt */
    public static final class d extends Lambda implements Function0<Location> {
        public final /* synthetic */ g2 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(g2 g2Var) {
            super(0);
            this.a = g2Var;
        }

        public final Object invoke() {
            LocationManager locationManager = this.a.f;
            if (locationManager != null) {
                return locationManager.getLastKnownLocation("network");
            }
            return null;
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.location.LocationCollectorManager", f = "LocationCollectorManager.kt", i = {0}, l = {133}, m = "obtainBestPossibleLocation", n = {"this"}, s = {"L$0"})
    /* compiled from: LocationCollectorManager.kt */
    public static final class e extends ContinuationImpl {
        public g2 a;
        public /* synthetic */ Object b;
        public final /* synthetic */ g2 c;
        public int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(g2 g2Var, Continuation<? super e> continuation) {
            super(continuation);
            this.c = g2Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.b(this);
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.location.LocationCollectorManager", f = "LocationCollectorManager.kt", i = {0, 0, 0, 1, 1, 1}, l = {107, 113, 118}, m = "saveLocation", n = {"this", "location", "triggerLocationCollectedCallback", "this", "it", "triggerLocationCollectedCallback"}, s = {"L$0", "L$1", "Z$0", "L$0", "L$1", "Z$0"})
    /* compiled from: LocationCollectorManager.kt */
    public static final class f extends ContinuationImpl {
        public g2 a;
        public M2Location b;
        public boolean c;
        public /* synthetic */ Object d;
        public final /* synthetic */ g2 e;
        public int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(g2 g2Var, Continuation<? super f> continuation) {
            super(continuation);
            this.e = g2Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.a((M2Location) null, false, false, (Continuation<? super Unit>) this);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class g extends Lambda implements Function0<Context> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [android.content.Context, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [android.content.Context, java.lang.Object] */
        public final Context invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(Context.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class h extends Lambda implements Function0<LocationRepository> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.business.repositories.LocationRepository] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.business.repositories.LocationRepository] */
        public final LocationRepository invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(LocationRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(LocationRepository.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class i extends Lambda implements Function0<c2> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.c2, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.c2, java.lang.Object] */
        public final c2 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(c2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(c2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.m2catalyst.m2sdk.g2.e
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.m2catalyst.m2sdk.g2$e r0 = (com.m2catalyst.m2sdk.g2.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.g2$e r0 = new com.m2catalyst.m2sdk.g2$e
            r0.<init>(r9, r10)
        L_0x0018:
            java.lang.Object r10 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r4) goto L_0x002c
            com.m2catalyst.m2sdk.g2 r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0069
        L_0x002c:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r10)
            boolean r10 = r9.h
            if (r10 != 0) goto L_0x003c
            goto L_0x009e
        L_0x003c:
            com.m2catalyst.m2sdk.business.models.M2Location r10 = r9.b()
            if (r10 == 0) goto L_0x009e
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r5 = r9.a
            java.lang.String r6 = r10.getProvider()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "location obtained "
            r7.<init>(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String[] r7 = new java.lang.String[r3]
            r2.d(r5, r6, r7)
            r0.a = r9
            r0.d = r4
            java.lang.Object r10 = r9.a((com.m2catalyst.m2sdk.business.models.M2Location) r10, (boolean) r3, (boolean) r4, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r10 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r0 = r9
        L_0x0069:
            r0.getClass()
            int r10 = android.os.Build.VERSION.SDK_INT
            r1 = 31
            if (r10 < r1) goto L_0x007d
            android.content.Context r10 = r0.a()
            r1 = 167772160(0xa000000, float:6.162976E-33)
            android.app.PendingIntent r10 = com.m2catalyst.m2sdk.a.a((android.content.Context) r10, (int) r1)
            goto L_0x0087
        L_0x007d:
            android.content.Context r10 = r0.a()
            r1 = 134217728(0x8000000, float:3.85186E-34)
            android.app.PendingIntent r10 = com.m2catalyst.m2sdk.a.a((android.content.Context) r10, (int) r1)
        L_0x0087:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r2 = r0.a
            java.lang.String[] r3 = new java.lang.String[r3]
            java.lang.String r4 = "requestASingleLocationUpdate()"
            r1.d(r2, r4, r3)
            android.location.LocationManager r0 = r0.f
            if (r0 == 0) goto L_0x009e
            android.location.Criteria r1 = new android.location.Criteria
            r1.<init>()
            r0.requestSingleUpdate(r1, r10)
        L_0x009e:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.g2.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final PendingIntent c() {
        M2SDKLogger.Companion.d(this.a, "getLocationPendingIntent()", new String[0]);
        Intent intent = new Intent(a(), LocationSDKReceiver.class);
        intent.setAction(LocationSDKReceiver.LOCATION_COLLECTION_UPDATE);
        if (Build.VERSION.SDK_INT >= 31) {
            PendingIntent broadcast = PendingIntent.getBroadcast(a(), 0, intent, 167772160);
            Intrinsics.checkNotNullExpressionValue(broadcast, "{\n            PendingInt…E\n            )\n        }");
            return broadcast;
        }
        PendingIntent broadcast2 = PendingIntent.getBroadcast(a(), 0, intent, C.BUFFER_FLAG_FIRST_SAMPLE);
        Intrinsics.checkNotNullExpressionValue(broadcast2, "{\n            PendingInt…T\n            )\n        }");
        return broadcast2;
    }

    public final void d() {
        long j2;
        h2 locationConfiguration;
        Integer a2;
        if (o4.c(a())) {
            M2Configuration c2 = r2.a.a().c();
            if (c2 == null || (locationConfiguration = c2.getLocationConfiguration()) == null || (a2 = locationConfiguration.a()) == null) {
                j2 = o1.b(3);
            } else {
                j2 = o1.b(a2.intValue());
            }
            long j3 = j2;
            LocationManager locationManager = this.f;
            if (locationManager != null) {
                locationManager.removeUpdates(c());
                M2SDKLogger.Companion companion = M2SDKLogger.Companion;
                String str = this.a;
                companion.v(str, "Request Location Updates every " + j3, new String[0]);
                locationManager.requestLocationUpdates("fused", j3, 0.0f, c());
            }
        }
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final Context a() {
        return (Context) this.b.getValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0080, code lost:
        r12 = r12.getLocationConfiguration();
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0130 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.m2catalyst.m2sdk.business.models.M2Location r11, boolean r12, boolean r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof com.m2catalyst.m2sdk.g2.f
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.m2catalyst.m2sdk.g2$f r0 = (com.m2catalyst.m2sdk.g2.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.g2$f r0 = new com.m2catalyst.m2sdk.g2$f
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0052
            if (r2 == r5) goto L_0x0044
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x016a
        L_0x0031:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0039:
            boolean r11 = r0.c
            com.m2catalyst.m2sdk.business.models.M2Location r12 = r0.b
            com.m2catalyst.m2sdk.g2 r13 = r0.a
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0135
        L_0x0044:
            boolean r13 = r0.c
            com.m2catalyst.m2sdk.business.models.M2Location r11 = r0.b
            com.m2catalyst.m2sdk.g2 r12 = r0.a
            kotlin.ResultKt.throwOnFailure(r14)
            r9 = r13
            r13 = r12
            r12 = r9
            goto L_0x00f8
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r14)
            boolean r14 = r10.h
            if (r14 != 0) goto L_0x005d
            if (r12 != 0) goto L_0x005d
            goto L_0x016a
        L_0x005d:
            android.content.Context r12 = r10.a()
            r10.a(r12, r11)
            r0.a = r10
            r0.b = r11
            r0.c = r13
            r0.f = r5
            com.m2catalyst.m2sdk.r2 r12 = com.m2catalyst.m2sdk.r2.j
            if (r12 != 0) goto L_0x0077
            com.m2catalyst.m2sdk.r2 r12 = new com.m2catalyst.m2sdk.r2
            r12.<init>()
            com.m2catalyst.m2sdk.r2.j = r12
        L_0x0077:
            com.m2catalyst.m2sdk.r2 r12 = com.m2catalyst.m2sdk.r2.j
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            com.m2catalyst.m2sdk.configuration.M2Configuration r12 = r12.g
            if (r12 == 0) goto L_0x0091
            com.m2catalyst.m2sdk.h2 r12 = r12.getLocationConfiguration()
            if (r12 == 0) goto L_0x0091
            java.lang.Boolean r12 = r12.d
            java.lang.Boolean r14 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r14)
            goto L_0x0092
        L_0x0091:
            r12 = 0
        L_0x0092:
            if (r12 == 0) goto L_0x00f2
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r12 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r14 = r10.a
            java.lang.String[] r2 = new java.lang.String[r6]
            java.lang.String r7 = "addBarometric()"
            r12.d(r14, r7, r2)
            kotlin.coroutines.SafeContinuation r12 = new kotlin.coroutines.SafeContinuation
            kotlin.coroutines.Continuation r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r12.<init>(r14)
            kotlin.jvm.internal.Ref$ObjectRef r14 = new kotlin.jvm.internal.Ref$ObjectRef
            r14.<init>()
            com.m2catalyst.m2sdk.f2 r2 = new com.m2catalyst.m2sdk.f2
            r2.<init>(r10, r14, r12, r11)
            r14.element = r2
            android.hardware.SensorManager r2 = r10.g
            if (r2 == 0) goto L_0x00da
            r7 = 6
            android.hardware.Sensor r7 = r2.getDefaultSensor(r7)
            if (r7 == 0) goto L_0x00d0
            java.lang.String r8 = "getDefaultSensor(Sensor.TYPE_PRESSURE)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            T r14 = r14.element
            android.hardware.SensorEventListener r14 = (android.hardware.SensorEventListener) r14
            boolean r14 = r2.registerListener(r14, r7, r6)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r14)
            goto L_0x00e3
        L_0x00d0:
            kotlin.Result$Companion r14 = kotlin.Result.Companion
            java.lang.Object r14 = kotlin.Result.m2344constructorimpl(r11)
            r12.resumeWith(r14)
            goto L_0x00e3
        L_0x00da:
            kotlin.Result$Companion r14 = kotlin.Result.Companion
            java.lang.Object r14 = kotlin.Result.m2344constructorimpl(r11)
            r12.resumeWith(r14)
        L_0x00e3:
            java.lang.Object r12 = r12.getOrThrow()
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r12 != r14) goto L_0x00f0
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x00f0:
            r14 = r12
            goto L_0x00f3
        L_0x00f2:
            r14 = r11
        L_0x00f3:
            if (r14 != r1) goto L_0x00f6
            return r1
        L_0x00f6:
            r12 = r13
            r13 = r10
        L_0x00f8:
            com.m2catalyst.m2sdk.business.models.M2Location r14 = (com.m2catalyst.m2sdk.business.models.M2Location) r14
            android.content.Context r2 = r13.a()
            r14.addPermissionValues(r2)
            r13.e = r14
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r2 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r7 = r13.a
            java.lang.String[] r5 = new java.lang.String[r5]
            com.m2catalyst.m2sdk.logger.LoggerUtils r8 = com.m2catalyst.m2sdk.logger.LoggerUtils.INSTANCE
            java.lang.String r11 = r8.m2LocationToString(r11)
            r5[r6] = r11
            java.lang.String r11 = "Save Location"
            r2.d(r7, r11, r5)
            kotlin.Lazy r11 = r13.c
            java.lang.Object r11 = r11.getValue()
            com.m2catalyst.m2sdk.business.repositories.LocationRepository r11 = (com.m2catalyst.m2sdk.business.repositories.LocationRepository) r11
            com.m2catalyst.m2sdk.database.entities.LocationEntity r2 = r14.toEntity$m2sdk_release()
            r0.a = r13
            r0.b = r14
            r0.c = r12
            r0.f = r4
            java.lang.Object r11 = r11.addLocationEntry(r2, r0)
            if (r11 != r1) goto L_0x0131
            return r1
        L_0x0131:
            r9 = r14
            r14 = r11
            r11 = r12
            r12 = r9
        L_0x0135:
            java.lang.Number r14 = (java.lang.Number) r14
            long r4 = r14.longValue()
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r14 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r2 = r13.a
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Saved Location ID = "
            r7.<init>(r8)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            java.lang.String[] r5 = new java.lang.String[r6]
            r14.d(r2, r4, r5)
            if (r11 == 0) goto L_0x016a
            kotlin.Lazy r11 = r13.d
            java.lang.Object r11 = r11.getValue()
            com.m2catalyst.m2sdk.c2 r11 = (com.m2catalyst.m2sdk.c2) r11
            r13 = 0
            r0.a = r13
            r0.b = r13
            r0.f = r3
            kotlin.Unit r11 = r11.a(r12)
            if (r11 != r1) goto L_0x016a
            return r1
        L_0x016a:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.g2.a(com.m2catalyst.m2sdk.business.models.M2Location, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.m2catalyst.m2sdk.business.models.M2Location} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.m2catalyst.m2sdk.business.models.M2Location b() {
        /*
            r8 = this;
            com.m2catalyst.m2sdk.g2$c r0 = new com.m2catalyst.m2sdk.g2$c
            r0.<init>(r8)
            java.lang.String r1 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r2 = 0
            java.lang.Object r0 = r0.invoke()     // Catch:{ Exception -> 0x0010 }
            goto L_0x0012
        L_0x0010:
            r0 = r2
        L_0x0012:
            android.location.Location r0 = (android.location.Location) r0
            if (r0 == 0) goto L_0x001c
            com.m2catalyst.m2sdk.business.models.M2Location r3 = new com.m2catalyst.m2sdk.business.models.M2Location
            r3.<init>((android.location.Location) r0)
            goto L_0x001d
        L_0x001c:
            r3 = r2
        L_0x001d:
            com.m2catalyst.m2sdk.g2$d r0 = new com.m2catalyst.m2sdk.g2$d
            r0.<init>(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.Object r0 = r0.invoke()     // Catch:{ Exception -> 0x002a }
            goto L_0x002c
        L_0x002a:
            r0 = r2
        L_0x002c:
            android.location.Location r0 = (android.location.Location) r0
            if (r0 == 0) goto L_0x0036
            com.m2catalyst.m2sdk.business.models.M2Location r4 = new com.m2catalyst.m2sdk.business.models.M2Location
            r4.<init>((android.location.Location) r0)
            goto L_0x0037
        L_0x0036:
            r4 = r2
        L_0x0037:
            com.m2catalyst.m2sdk.g2$b r0 = new com.m2catalyst.m2sdk.g2$b
            r0.<init>(r8)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.lang.Object r0 = r0.invoke()     // Catch:{ Exception -> 0x0044 }
            goto L_0x0046
        L_0x0044:
            r0 = r2
        L_0x0046:
            android.location.Location r0 = (android.location.Location) r0
            if (r0 == 0) goto L_0x0050
            com.m2catalyst.m2sdk.business.models.M2Location r1 = new com.m2catalyst.m2sdk.business.models.M2Location
            r1.<init>((android.location.Location) r0)
            goto L_0x0051
        L_0x0050:
            r1 = r2
        L_0x0051:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            if (r3 == 0) goto L_0x005b
            r0.add(r3)
        L_0x005b:
            if (r1 == 0) goto L_0x0060
            r0.add(r1)
        L_0x0060:
            if (r4 == 0) goto L_0x0065
            r0.add(r4)
        L_0x0065:
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r3 = r8.a
            r4 = 0
            java.lang.String[] r4 = new java.lang.String[r4]
            java.lang.String r5 = "getLastBestLocation()"
            r1.d(r3, r5, r4)
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 != 0) goto L_0x007c
            goto L_0x00a7
        L_0x007c:
            java.lang.Object r1 = r0.next()
            boolean r2 = r0.hasNext()
            if (r2 != 0) goto L_0x0088
        L_0x0086:
            r2 = r1
            goto L_0x00a7
        L_0x0088:
            r2 = r1
            com.m2catalyst.m2sdk.business.models.M2Location r2 = (com.m2catalyst.m2sdk.business.models.M2Location) r2
            long r2 = r2.getTimeStamp()
        L_0x008f:
            java.lang.Object r4 = r0.next()
            r5 = r4
            com.m2catalyst.m2sdk.business.models.M2Location r5 = (com.m2catalyst.m2sdk.business.models.M2Location) r5
            long r5 = r5.getTimeStamp()
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a0
            r1 = r4
            r2 = r5
        L_0x00a0:
            boolean r4 = r0.hasNext()
            if (r4 != 0) goto L_0x008f
            goto L_0x0086
        L_0x00a7:
            com.m2catalyst.m2sdk.business.models.M2Location r2 = (com.m2catalyst.m2sdk.business.models.M2Location) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.g2.b():com.m2catalyst.m2sdk.business.models.M2Location");
    }

    public final boolean a(M2Location m2Location, M2Location m2Location2, float f2, long j2) {
        boolean z = s1.a(Float.valueOf(m2Location.distanceTo(m2Location2))) > f2;
        boolean z2 = m2Location2.getTimeStamp() - m2Location.getTimeStamp() > j2;
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        String str = this.a;
        boolean z3 = z || (z2 && m2Location2.getTimeStamp() > m2Location.getTimeStamp());
        companion.d(str, "shouldUseNewLocation " + z3, new String[0]);
        String str2 = this.a;
        long timeStamp = m2Location2.getTimeStamp();
        long timeStamp2 = m2Location.getTimeStamp();
        boolean z4 = m2Location2.getTimeStamp() > m2Location.getTimeStamp();
        companion.d(str2, " movementDetected=" + z + " outdatedLocation=" + z2 + " newLocation.timeStamp=" + timeStamp + " oldLocation.timeStamp=" + timeStamp2 + "  new > old =" + z4, new String[0]);
        if (z) {
            return true;
        }
        if (!z2 || m2Location2.getTimeStamp() <= m2Location.getTimeStamp()) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.business.models.M2Location> r14) {
        /*
            r13 = this;
            boolean r0 = r14 instanceof com.m2catalyst.m2sdk.g2.a
            if (r0 == 0) goto L_0x0013
            r0 = r14
            com.m2catalyst.m2sdk.g2$a r0 = (com.m2catalyst.m2sdk.g2.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.g2$a r0 = new com.m2catalyst.m2sdk.g2$a
            r0.<init>(r13, r14)
        L_0x0018:
            java.lang.Object r14 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            com.m2catalyst.m2sdk.business.models.M2Location r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00e4
        L_0x002c:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r14)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r14 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r2 = r13.a
            r4 = 0
            java.lang.String[] r5 = new java.lang.String[r4]
            java.lang.String r6 = "getBestLocation()"
            r14.d(r2, r6, r5)
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.j
            if (r2 != 0) goto L_0x004e
            com.m2catalyst.m2sdk.r2 r2 = new com.m2catalyst.m2sdk.r2
            r2.<init>()
            com.m2catalyst.m2sdk.r2.j = r2
        L_0x004e:
            com.m2catalyst.m2sdk.r2 r2 = com.m2catalyst.m2sdk.r2.j
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r2.g
            if (r2 == 0) goto L_0x006a
            com.m2catalyst.m2sdk.h2 r2 = r2.getLocationConfiguration()
            if (r2 == 0) goto L_0x006a
            java.lang.Integer r2 = r2.f
            if (r2 == 0) goto L_0x006a
            int r2 = r2.intValue()
            long r5 = com.m2catalyst.m2sdk.o1.b(r2)
            goto L_0x006f
        L_0x006a:
            r2 = 2
            long r5 = com.m2catalyst.m2sdk.o1.b(r2)
        L_0x006f:
            r11 = r5
            com.m2catalyst.m2sdk.business.models.M2Location r2 = r13.b()
            if (r2 != 0) goto L_0x0082
            java.lang.String r2 = r13.a
            java.lang.String[] r5 = new java.lang.String[r4]
            java.lang.String r6 = "getBestLocation use newestLocation"
            r14.d(r2, r6, r5)
            com.m2catalyst.m2sdk.business.models.M2Location r2 = r13.e
            goto L_0x00b2
        L_0x0082:
            com.m2catalyst.m2sdk.business.models.M2Location r8 = r13.e
            if (r8 != 0) goto L_0x0090
            java.lang.String r5 = r13.a
            java.lang.String[] r6 = new java.lang.String[r4]
            java.lang.String r7 = "getBestLocation use bestLocation"
            r14.d(r5, r7, r6)
            goto L_0x00b2
        L_0x0090:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r10 = 1065353216(0x3f800000, float:1.0)
            r7 = r13
            r9 = r2
            boolean r5 = r7.a((com.m2catalyst.m2sdk.business.models.M2Location) r8, (com.m2catalyst.m2sdk.business.models.M2Location) r9, (float) r10, (long) r11)
            if (r5 == 0) goto L_0x00a7
            java.lang.String r5 = r13.a
            java.lang.String[] r6 = new java.lang.String[r4]
            java.lang.String r7 = "getBestLocation else use bestLocation"
            r14.d(r5, r7, r6)
            goto L_0x00b2
        L_0x00a7:
            java.lang.String r2 = r13.a
            java.lang.String[] r5 = new java.lang.String[r4]
            java.lang.String r6 = "getBestLocation els use newestLocation"
            r14.d(r2, r6, r5)
            com.m2catalyst.m2sdk.business.models.M2Location r2 = r13.e
        L_0x00b2:
            if (r2 == 0) goto L_0x00c1
            java.lang.Float r5 = r2.getIndoorOutdoorWeight()
            if (r5 != 0) goto L_0x00c1
            android.content.Context r5 = r13.a()
            r13.a(r5, r2)
        L_0x00c1:
            com.m2catalyst.m2sdk.business.models.M2Location r5 = r13.e
            if (r5 == 0) goto L_0x00cd
            if (r2 == 0) goto L_0x00e3
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)
            if (r5 != 0) goto L_0x00e3
        L_0x00cd:
            java.lang.String r5 = r13.a
            java.lang.String[] r6 = new java.lang.String[r4]
            java.lang.String r7 = "getBestLocation save new location"
            r14.d(r5, r7, r6)
            if (r2 == 0) goto L_0x00e3
            r0.a = r2
            r0.d = r3
            java.lang.Object r14 = r13.a((com.m2catalyst.m2sdk.business.models.M2Location) r2, (boolean) r3, (boolean) r4, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r14 != r1) goto L_0x00e3
            return r1
        L_0x00e3:
            r0 = r2
        L_0x00e4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.g2.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0390  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0417  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x041a  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x041f  */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0431  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e7  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0210  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r61, com.m2catalyst.m2sdk.business.models.M2Location r62) {
        /*
            r60 = this;
            r0 = r60
            r1 = r61
            r2 = r62
            java.lang.String r3 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "currentLocation"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r4 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r5 = r0.a
            r6 = 0
            java.lang.String[] r7 = new java.lang.String[r6]
            java.lang.String r8 = "addIndoorOutdoorDetection()"
            r4.d(r5, r8, r7)
            com.m2catalyst.m2sdk.speed_test.legacy.NDTMigrationUtilsWrapper r5 = com.m2catalyst.m2sdk.speed_test.legacy.NDTMigrationUtilsWrapper.INSTANCE
            int r5 = r5.getActiveDataNetworkType(r1)
            java.lang.String r7 = r0.a
            java.lang.String[] r8 = new java.lang.String[r6]
            java.lang.String r9 = "getWifiInfo()"
            r4.d(r7, r9, r8)
            android.content.Context r1 = r61.getApplicationContext()
            java.lang.String r4 = "wifi"
            java.lang.Object r1 = r1.getSystemService(r4)
            java.lang.String r4 = "null cannot be cast to non-null type android.net.wifi.WifiManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
            android.net.wifi.WifiManager r1 = (android.net.wifi.WifiManager) r1
            android.net.wifi.WifiInfo r1 = r1.getConnectionInfo()
            long r7 = r62.getTime()
            long r9 = r0.l
            long r7 = r7 - r9
            java.util.concurrent.CopyOnWriteArrayList<com.m2catalyst.m2sdk.business.models.M2Location> r4 = r0.i
            java.util.Iterator r4 = r4.iterator()
            java.lang.String r9 = "indoorDetectionLocations.iterator()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            android.util.ArraySet r9 = new android.util.ArraySet
            r9.<init>()
        L_0x0058:
            boolean r10 = r4.hasNext()
            if (r10 == 0) goto L_0x0070
            java.lang.Object r10 = r4.next()
            com.m2catalyst.m2sdk.business.models.M2Location r10 = (com.m2catalyst.m2sdk.business.models.M2Location) r10
            long r11 = r10.getTime()
            int r13 = (r11 > r7 ? 1 : (r11 == r7 ? 0 : -1))
            if (r13 >= 0) goto L_0x0058
            r9.add(r10)
            goto L_0x0058
        L_0x0070:
            java.util.concurrent.CopyOnWriteArrayList<com.m2catalyst.m2sdk.business.models.M2Location> r4 = r0.i
            r4.removeAll(r9)
            java.util.concurrent.CopyOnWriteArrayList<com.m2catalyst.m2sdk.business.models.M2Location> r4 = r0.i
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            java.lang.String r3 = "previousLocations"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r3 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r7 = r0.a
            java.lang.String[] r8 = new java.lang.String[r6]
            java.lang.String r9 = "calculateIndoorOutdoorWeight()"
            r3.d(r7, r9, r8)
            boolean r3 = r62.hasSpeed()
            if (r3 == 0) goto L_0x009e
            float r3 = r62.getSpeed()
            r8 = 1077936128(0x40400000, float:3.0)
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x009e
            r7 = -1062207488(0xffffffffc0b00000, float:-5.5)
            goto L_0x043f
        L_0x009e:
            java.lang.String r3 = r62.getProvider()
            java.lang.String r8 = "gps"
            r9 = 1
            boolean r3 = kotlin.text.StringsKt.equals(r3, r8, r9)
            if (r3 == 0) goto L_0x00ae
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            goto L_0x00af
        L_0x00ae:
            r3 = 0
        L_0x00af:
            r2.setDataConnectionType(r5)
            r11 = 1048576000(0x3e800000, float:0.25)
            r12 = 1056964608(0x3f000000, float:0.5)
            if (r5 != r9) goto L_0x00d9
            if (r1 == 0) goto L_0x00d9
            java.lang.String r5 = r1.getSSID()
            int r1 = r1.getRssi()
            double r13 = (double) r1
            r2.setRssi(r13)
            if (r5 == 0) goto L_0x00d4
            java.lang.String r13 = ""
            boolean r5 = kotlin.text.StringsKt.equals(r5, r13, r9)
            if (r5 != 0) goto L_0x00d4
            r2.setHasSSID(r9)
            float r3 = r3 + r12
        L_0x00d4:
            r5 = -80
            if (r1 <= r5) goto L_0x00d9
            float r3 = r3 + r11
        L_0x00d9:
            boolean r1 = r4.isEmpty()
            r1 = r1 ^ r9
            if (r1 == 0) goto L_0x043e
            double r13 = r62.getLatitude()
            double r15 = r62.getLongitude()
            double r17 = r62.getLatitude()
            double r19 = r62.getLongitude()
            java.util.Iterator r1 = r4.iterator()
            r4 = 0
            r21 = 0
            r25 = r13
            r27 = r15
            r29 = r17
            r31 = r19
            r33 = r21
            r35 = r33
            r37 = r35
            r39 = r37
            r41 = r39
            r43 = r41
            r45 = r43
            r47 = r45
            r7 = 0
            r10 = 1
            r11 = 0
            r12 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r24 = 0
            r49 = 1
            r13 = r4
            r15 = r13
        L_0x0124:
            boolean r50 = r1.hasNext()
            r51 = 1
            if (r50 == 0) goto L_0x02cf
            java.lang.Object r50 = r1.next()
            com.m2catalyst.m2sdk.business.models.M2Location r50 = (com.m2catalyst.m2sdk.business.models.M2Location) r50
            long r53 = r50.getTime()
            long r55 = r62.getTime()
            r57 = r10
            long r9 = r0.j
            long r55 = r55 - r9
            int r9 = (r53 > r55 ? 1 : (r53 == r55 ? 0 : -1))
            if (r9 < 0) goto L_0x01a1
            int r10 = r57 + 1
            double r53 = r50.getLatitude()
            double r53 = r53 + r29
            double r29 = r50.getLongitude()
            double r29 = r29 + r31
            if (r17 != 0) goto L_0x0167
            java.lang.String r9 = r50.getProvider()
            r55 = r1
            r1 = 1
            boolean r9 = kotlin.text.StringsKt.equals(r9, r8, r1)
            if (r9 == 0) goto L_0x0169
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r3 = r3 + r1
            r17 = 1
            goto L_0x0169
        L_0x0167:
            r55 = r1
        L_0x0169:
            boolean r1 = r50.hasSpeed()
            if (r1 == 0) goto L_0x017e
            int r7 = r7 + 1
            float r1 = r50.getSpeed()
            r56 = r10
            double r9 = (double) r1
            java.lang.Double.isNaN(r9)
            double r35 = r35 + r9
            goto L_0x0180
        L_0x017e:
            r56 = r10
        L_0x0180:
            if (r19 != 0) goto L_0x018a
            boolean r1 = r50.getHasSSID()
            if (r1 == 0) goto L_0x018a
            r19 = 1
        L_0x018a:
            boolean r1 = r50.getHasSSID()
            if (r1 == 0) goto L_0x019a
            int r12 = r12 + 1
            double r9 = r50.getRssi()
            double r9 = r9 + r41
            r41 = r9
        L_0x019a:
            r31 = r29
            r29 = r53
            r10 = r56
            goto L_0x01a5
        L_0x01a1:
            r55 = r1
            r10 = r57
        L_0x01a5:
            long r53 = r50.getTime()
            long r56 = r62.getTime()
            r1 = r10
            long r9 = r0.k
            long r56 = r56 - r9
            int r9 = (r53 > r56 ? 1 : (r53 == r56 ? 0 : -1))
            if (r9 < 0) goto L_0x0217
            r9 = r49
            int r49 = r9 + 1
            double r9 = r50.getLatitude()
            double r9 = r9 + r25
            double r25 = r50.getLongitude()
            double r25 = r25 + r27
            r53 = r1
            if (r20 != 0) goto L_0x01dd
            java.lang.String r1 = r50.getProvider()
            r54 = r7
            r7 = 1
            boolean r1 = kotlin.text.StringsKt.equals(r1, r8, r7)
            if (r1 == 0) goto L_0x01df
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r3 = r3 + r1
            r20 = 1
            goto L_0x01e1
        L_0x01dd:
            r54 = r7
        L_0x01df:
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x01e1:
            boolean r7 = r50.hasSpeed()
            if (r7 == 0) goto L_0x01f3
            int r6 = r6 + 1
            float r7 = r50.getSpeed()
            double r1 = (double) r7
            java.lang.Double.isNaN(r1)
            double r33 = r33 + r1
        L_0x01f3:
            if (r21 != 0) goto L_0x01fd
            boolean r1 = r50.getHasSSID()
            if (r1 == 0) goto L_0x01fd
            r21 = 1
        L_0x01fd:
            boolean r1 = r50.getHasSSID()
            if (r1 == 0) goto L_0x0210
            r1 = r23
            int r23 = r1 + 1
            double r1 = r50.getRssi()
            double r1 = r1 + r43
            r43 = r1
            goto L_0x0212
        L_0x0210:
            r1 = r23
        L_0x0212:
            r27 = r25
            r25 = r9
            goto L_0x021f
        L_0x0217:
            r53 = r1
            r54 = r7
            r1 = r23
            r9 = r49
        L_0x021f:
            long r1 = r50.getTime()
            long r9 = r62.getTime()
            r56 = r6
            long r6 = r0.k
            r57 = r3
            r58 = r4
            r3 = 2
            long r3 = (long) r3
            long r6 = r6 * r3
            long r9 = r9 - r6
            r3 = 1112014848(0x42480000, float:50.0)
            int r4 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r4 < 0) goto L_0x0276
            long r1 = r50.getTime()
            long r4 = r62.getTime()
            long r6 = r0.k
            long r4 = r4 - r6
            int r6 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0276
            float r1 = r50.getAccuracy()
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x025f
            int r11 = r11 + 1
            double r1 = r50.getLatitude()
            double r37 = r1 + r37
            double r1 = r50.getLongitude()
            double r39 = r1 + r39
        L_0x025f:
            int r1 = r50.getDataConnectionType()
            r2 = 1
            if (r1 != r2) goto L_0x0268
            long r13 = r13 + r51
        L_0x0268:
            int r1 = r50.getDataConnectionType()
            if (r1 != 0) goto L_0x0276
            long r1 = r50.getMobileData()
            long r1 = r1 + r58
            r4 = r1
            goto L_0x0278
        L_0x0276:
            r4 = r58
        L_0x0278:
            long r1 = r50.getTime()
            long r6 = r62.getTime()
            long r9 = r0.j
            long r6 = r6 - r9
            int r9 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r9 >= 0) goto L_0x02be
            float r1 = r50.getAccuracy()
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x02a4
            r2 = r24
            int r24 = r2 + 1
            double r1 = r50.getLatitude()
            double r1 = r1 + r45
            double r6 = r50.getLongitude()
            double r6 = r6 + r47
            r45 = r1
            r47 = r6
            goto L_0x02a6
        L_0x02a4:
            r2 = r24
        L_0x02a6:
            int r1 = r50.getDataConnectionType()
            r10 = 1
            if (r1 != r10) goto L_0x02af
            long r15 = r15 + r51
        L_0x02af:
            r2 = r62
            r10 = r53
            r7 = r54
            r1 = r55
            r6 = r56
            r3 = r57
            r9 = 1
            goto L_0x0124
        L_0x02be:
            r2 = r24
            r10 = r53
            r7 = r54
            r1 = r55
            r6 = r56
            r3 = r57
            r9 = 1
            r2 = r62
            goto L_0x0124
        L_0x02cf:
            r58 = r4
            r57 = r10
            r1 = r23
            r2 = r24
            r9 = r49
            r4 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            r10 = r9
            if (r6 == 0) goto L_0x02ef
            double r8 = (double) r6
            java.lang.Double.isNaN(r8)
            double r33 = r33 / r8
            int r6 = (r33 > r4 ? 1 : (r33 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x02ef
            r6 = -1090519040(0xffffffffbf000000, float:-0.5)
            float r3 = r3 + r6
            goto L_0x02f1
        L_0x02ef:
            r6 = -1090519040(0xffffffffbf000000, float:-0.5)
        L_0x02f1:
            if (r7 == 0) goto L_0x02fe
            double r7 = (double) r7
            java.lang.Double.isNaN(r7)
            double r35 = r35 / r7
            int r7 = (r35 > r4 ? 1 : (r35 == r4 ? 0 : -1))
            if (r7 <= 0) goto L_0x02fe
            float r3 = r3 + r6
        L_0x02fe:
            if (r11 == 0) goto L_0x038b
            double r4 = (double) r11
            java.lang.Double.isNaN(r4)
            double r37 = r37 / r4
            java.lang.Double.isNaN(r4)
            double r39 = r39 / r4
            double r4 = (double) r10
            java.lang.Double.isNaN(r4)
            double r25 = r25 / r4
            java.lang.Double.isNaN(r4)
            double r27 = r27 / r4
            double r4 = r25 - r37
            double r4 = java.lang.Math.toRadians(r4)
            double r27 = r27 - r39
            double r9 = java.lang.Math.toRadians(r27)
            r6 = 2
            double r7 = (double) r6
            java.lang.Double.isNaN(r7)
            double r4 = r4 / r7
            double r4 = java.lang.Math.sin(r4)
            r6 = r1
            r0 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = java.lang.Math.pow(r4, r0)
            java.lang.Double.isNaN(r7)
            double r9 = r9 / r7
            double r9 = java.lang.Math.sin(r9)
            double r9 = java.lang.Math.pow(r9, r0)
            double r0 = java.lang.Math.toRadians(r37)
            double r0 = java.lang.Math.cos(r0)
            double r0 = r0 * r9
            double r9 = java.lang.Math.toRadians(r25)
            double r9 = java.lang.Math.cos(r9)
            double r9 = r9 * r0
            double r9 = r9 + r4
            double r0 = java.lang.Math.sqrt(r9)
            double r0 = java.lang.Math.asin(r0)
            java.lang.Double.isNaN(r7)
            double r0 = r0 * r7
            r4 = 6371(0x18e3, float:8.928E-42)
            double r7 = (double) r4
            java.lang.Double.isNaN(r7)
            double r7 = r7 * r0
            r0 = 4581421828931458171(0x3f947ae147ae147b, double:0.02)
            int r4 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0375
            r7 = -1062207488(0xffffffffc0b00000, float:-5.5)
            goto L_0x0377
        L_0x0375:
            r7 = 1065353216(0x3f800000, float:1.0)
        L_0x0377:
            float r3 = r3 + r7
            long r0 = (long) r11
            long r4 = r58 / r0
            int r7 = (r4 > r51 ? 1 : (r4 == r51 ? 0 : -1))
            r4 = -1090519040(0xffffffffbf000000, float:-0.5)
            if (r7 <= 0) goto L_0x0382
            float r3 = r3 + r4
        L_0x0382:
            long r13 = r13 / r0
            int r0 = (r13 > r51 ? 1 : (r13 == r51 ? 0 : -1))
            if (r0 <= 0) goto L_0x038e
            r0 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r0
            goto L_0x038e
        L_0x038b:
            r6 = r1
            r4 = -1090519040(0xffffffffbf000000, float:-0.5)
        L_0x038e:
            if (r2 == 0) goto L_0x0413
            double r0 = (double) r2
            java.lang.Double.isNaN(r0)
            double r45 = r45 / r0
            java.lang.Double.isNaN(r0)
            double r47 = r47 / r0
            r9 = r57
            double r0 = (double) r9
            java.lang.Double.isNaN(r0)
            double r29 = r29 / r0
            java.lang.Double.isNaN(r0)
            double r31 = r31 / r0
            double r0 = r29 - r45
            double r0 = java.lang.Math.toRadians(r0)
            double r31 = r31 - r47
            double r7 = java.lang.Math.toRadians(r31)
            r5 = 2
            double r9 = (double) r5
            java.lang.Double.isNaN(r9)
            double r0 = r0 / r9
            double r0 = java.lang.Math.sin(r0)
            r13 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = java.lang.Math.pow(r0, r13)
            java.lang.Double.isNaN(r9)
            double r7 = r7 / r9
            double r7 = java.lang.Math.sin(r7)
            double r7 = java.lang.Math.pow(r7, r13)
            double r13 = java.lang.Math.toRadians(r45)
            double r13 = java.lang.Math.cos(r13)
            double r13 = r13 * r7
            double r7 = java.lang.Math.toRadians(r29)
            double r7 = java.lang.Math.cos(r7)
            double r7 = r7 * r13
            double r7 = r7 + r0
            double r0 = java.lang.Math.sqrt(r7)
            double r0 = java.lang.Math.asin(r0)
            java.lang.Double.isNaN(r9)
            double r0 = r0 * r9
            r5 = 6371(0x18e3, float:8.928E-42)
            double r7 = (double) r5
            java.lang.Double.isNaN(r7)
            double r7 = r7 * r0
            r0 = 4581421828931458171(0x3f947ae147ae147b, double:0.02)
            int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r5 <= 0) goto L_0x0406
            r8 = -1090519040(0xffffffffbf000000, float:-0.5)
            goto L_0x0408
        L_0x0406:
            r8 = 1056964608(0x3f000000, float:0.5)
        L_0x0408:
            float r3 = r3 + r8
            long r0 = (long) r2
            long r15 = r15 / r0
            int r0 = (r15 > r51 ? 1 : (r15 == r51 ? 0 : -1))
            if (r0 <= 0) goto L_0x0413
            r0 = 1056964608(0x3f000000, float:0.5)
            float r3 = r3 + r0
            goto L_0x0415
        L_0x0413:
            r0 = 1056964608(0x3f000000, float:0.5)
        L_0x0415:
            if (r21 == 0) goto L_0x0418
            float r3 = r3 + r0
        L_0x0418:
            if (r19 == 0) goto L_0x041b
            float r3 = r3 + r0
        L_0x041b:
            r0 = -4588042120383692800(0xc054000000000000, double:-80.0)
            if (r6 == 0) goto L_0x042d
            double r4 = (double) r6
            java.lang.Double.isNaN(r4)
            double r43 = r43 / r4
            int r2 = (r43 > r0 ? 1 : (r43 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x042d
            r2 = 1048576000(0x3e800000, float:0.25)
            float r3 = r3 + r2
            goto L_0x042f
        L_0x042d:
            r2 = 1048576000(0x3e800000, float:0.25)
        L_0x042f:
            if (r12 == 0) goto L_0x043e
            double r4 = (double) r12
            java.lang.Double.isNaN(r4)
            double r41 = r41 / r4
            int r4 = (r41 > r0 ? 1 : (r41 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x043e
            float r7 = r3 + r2
            goto L_0x043f
        L_0x043e:
            r7 = r3
        L_0x043f:
            java.lang.Float r0 = java.lang.Float.valueOf(r7)
            r1 = r62
            r1.setIndoorOutdoorWeight(r0)
            r0 = r60
            java.util.concurrent.CopyOnWriteArrayList<com.m2catalyst.m2sdk.business.models.M2Location> r2 = r0.i
            r2.add(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.g2.a(android.content.Context, com.m2catalyst.m2sdk.business.models.M2Location):void");
    }
}
