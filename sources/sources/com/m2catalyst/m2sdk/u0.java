package com.m2catalyst.m2sdk;

import android.content.Context;
import com.m2catalyst.m2sdk.r2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: CollectionOrchestrator.kt */
public final class u0 implements KoinComponent {
    public static u0 e;
    public final Lazy a = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new a(this));
    public final Lazy b = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new b(this));
    public final Lazy c = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new c(this));
    public final r2 d = r2.a.a();

    /* compiled from: KoinComponent.kt */
    public static final class a extends Lambda implements Function0<v3> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.v3, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.v3, java.lang.Object] */
        public final v3 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(v3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(v3.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class b extends Lambda implements Function0<e2> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.e2, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.e2, java.lang.Object] */
        public final e2 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(e2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(e2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class c extends Lambda implements Function0<d7> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [com.m2catalyst.m2sdk.d7, java.lang.Object] */
        /* JADX WARNING: type inference failed for: r0v5, types: [com.m2catalyst.m2sdk.d7, java.lang.Object] */
        public final d7 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(d7.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(d7.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.data_collection.CollectionOrchestrator", f = "CollectionOrchestrator.kt", i = {0, 0}, l = {55}, m = "startCollecting", n = {"this", "context"}, s = {"L$0", "L$1"})
    /* compiled from: CollectionOrchestrator.kt */
    public static final class d extends ContinuationImpl {
        public u0 a;
        public Context b;
        public /* synthetic */ Object c;
        public final /* synthetic */ u0 d;
        public int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(u0 u0Var, Continuation<? super d> continuation) {
            super(continuation);
            this.d = u0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a((Context) null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r12, kotlin.coroutines.Continuation<? super java.lang.Boolean> r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof com.m2catalyst.m2sdk.u0.d
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.m2catalyst.m2sdk.u0$d r0 = (com.m2catalyst.m2sdk.u0.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.u0$d r0 = new com.m2catalyst.m2sdk.u0$d
            r0.<init>(r11, r13)
        L_0x0018:
            java.lang.Object r13 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            android.content.Context r12 = r0.b
            com.m2catalyst.m2sdk.u0 r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r13)
            kotlin.Lazy r13 = r11.a
            java.lang.Object r13 = r13.getValue()
            com.m2catalyst.m2sdk.v3 r13 = (com.m2catalyst.m2sdk.v3) r13
            r0.a = r11
            r0.b = r12
            r0.e = r3
            java.lang.Object r13 = r13.a((kotlin.coroutines.Continuation<? super java.lang.Boolean>) r0)
            if (r13 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r0 = r11
        L_0x004e:
            r4 = r12
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r12 = r13.booleanValue()
            r13 = 0
            if (r12 == 0) goto L_0x00c8
            kotlin.Lazy r12 = r0.b
            java.lang.Object r12 = r12.getValue()
            com.m2catalyst.m2sdk.e2 r12 = (com.m2catalyst.m2sdk.e2) r12
            r12.getClass()
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            kotlin.Lazy r12 = r12.a
            java.lang.Object r12 = r12.getValue()
            com.m2catalyst.m2sdk.g2 r12 = (com.m2catalyst.m2sdk.g2) r12
            r12.getClass()
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r2 = r12.a
            java.lang.String[] r13 = new java.lang.String[r13]
            java.lang.String r5 = "start()"
            r1.d(r2, r5, r13)
            r12.h = r3
            r12.d()
            long r7 = java.lang.System.currentTimeMillis()
            com.m2catalyst.m2sdk.r2 r12 = com.m2catalyst.m2sdk.r2.j
            if (r12 != 0) goto L_0x0093
            com.m2catalyst.m2sdk.r2 r12 = new com.m2catalyst.m2sdk.r2
            r12.<init>()
            com.m2catalyst.m2sdk.r2.j = r12
        L_0x0093:
            com.m2catalyst.m2sdk.r2 r12 = com.m2catalyst.m2sdk.r2.j
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            com.m2catalyst.m2sdk.configuration.M2Configuration r12 = r12.g
            if (r12 == 0) goto L_0x00af
            com.m2catalyst.m2sdk.h2 r12 = r12.getLocationConfiguration()
            if (r12 == 0) goto L_0x00af
            java.lang.Integer r12 = r12.b
            if (r12 == 0) goto L_0x00af
            int r12 = r12.intValue()
            long r12 = com.m2catalyst.m2sdk.o1.b(r12)
            goto L_0x00b4
        L_0x00af:
            r12 = 5
            long r12 = com.m2catalyst.m2sdk.o1.b(r12)
        L_0x00b4:
            r9 = r12
            java.lang.Class<com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver> r5 = com.m2catalyst.m2sdk.data_collection.location.LocationSDKReceiver.class
            java.lang.String r6 = "RECURRENT_LOCATION_COLLECTION"
            com.m2catalyst.m2sdk.a.a(r4, r5, r6, r7, r9, 0, 0, true)
            kotlin.Lazy r12 = r0.c
            java.lang.Object r12 = r12.getValue()
            com.m2catalyst.m2sdk.d7 r12 = (com.m2catalyst.m2sdk.d7) r12
            r12.a()
            r13 = 1
        L_0x00c8:
            com.m2catalyst.m2sdk.r2 r12 = r0.d
            com.m2catalyst.m2sdk.r5 r0 = com.m2catalyst.m2sdk.r5.f
            r12.a(r0, r13)
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger r4 = com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.INSTANCE
            com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents r5 = com.m2catalyst.m2sdk.logger.monitor_stats.LoggingEvents.SDK_COLLECTION_STARTED
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            r7 = 0
            r8 = 4
            r9 = 0
            com.m2catalyst.m2sdk.logger.monitor_stats.MonitorStatsLogger.increment$default(r4, r5, r6, r7, r8, r9)
            java.lang.Boolean r12 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r13)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.u0.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }
}
