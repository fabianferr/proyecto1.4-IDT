package com.m2catalyst.m2sdk;

import android.content.Context;
import com.google.gson.Gson;
import com.m2catalyst.m2sdk.core.setup.M2SDKOpsReceiver;
import com.m2catalyst.m2sdk.external.M2SDKConfiguration;
import com.m2catalyst.m2sdk.r2;
import kotlin.Lazy;
import kotlin.LazyKt;
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

/* compiled from: SDKInitializer.kt */
public final class s5 implements KoinComponent {
    public static final a h = new a();
    public static s5 i;
    public final r2 a = r2.a.a();
    public final Lazy b = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new e(this));
    public final Lazy c = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new f(this));
    public final Lazy d = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new g(this));
    public final Lazy e = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new h(this));
    public final Lazy f = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new i(this));
    public final Gson g = new Gson();

    /* compiled from: SDKInitializer.kt */
    public static final class a {
        public static s5 a() {
            if (s5.i == null) {
                s5.i = new s5();
            }
            s5 s5Var = s5.i;
            Intrinsics.checkNotNull(s5Var);
            return s5Var;
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.core.setup.SDKInitializer", f = "SDKInitializer.kt", i = {0, 0, 1, 1}, l = {58, 62}, m = "initializeInternalComponents", n = {"this", "context", "this", "context"}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* compiled from: SDKInitializer.kt */
    public static final class b extends ContinuationImpl {
        public s5 a;
        public Context b;
        public /* synthetic */ Object c;
        public final /* synthetic */ s5 d;
        public int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(s5 s5Var, Continuation<? super b> continuation) {
            super(continuation);
            this.d = s5Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a((Context) null, false, this);
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.core.setup.SDKInitializer", f = "SDKInitializer.kt", i = {0}, l = {91}, m = "resolveRemoteConfig", n = {"this"}, s = {"L$0"})
    /* compiled from: SDKInitializer.kt */
    public static final class c extends ContinuationImpl {
        public s5 a;
        public r2 b;
        public /* synthetic */ Object c;
        public final /* synthetic */ s5 d;
        public int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(s5 s5Var, Continuation<? super c> continuation) {
            super(continuation);
            this.d = s5Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a(false, this);
        }
    }

    @DebugMetadata(c = "com.m2catalyst.m2sdk.core.setup.SDKInitializer", f = "SDKInitializer.kt", i = {0}, l = {125}, m = "setupIngestion", n = {"this"}, s = {"L$0"})
    /* compiled from: SDKInitializer.kt */
    public static final class d extends ContinuationImpl {
        public s5 a;
        public /* synthetic */ Object b;
        public final /* synthetic */ s5 c;
        public int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(s5 s5Var, Continuation<? super d> continuation) {
            super(continuation);
            this.c = s5Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a(this);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class e extends Lambda implements Function0<x6> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(KoinComponent koinComponent) {
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

    /* compiled from: KoinComponent.kt */
    public static final class f extends Lambda implements Function0<b6> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(KoinComponent koinComponent) {
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

    /* compiled from: KoinComponent.kt */
    public static final class g extends Lambda implements Function0<x1> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.x1] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.x1] */
        public final x1 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(x1.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(x1.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class h extends Lambda implements Function0<y2> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.y2] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.y2] */
        public final y2 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(y2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(y2.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class i extends Lambda implements Function0<M2SDKOpsReceiver> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.core.setup.M2SDKOpsReceiver] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.core.setup.M2SDKOpsReceiver] */
        public final M2SDKOpsReceiver invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(M2SDKOpsReceiver.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(M2SDKOpsReceiver.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0144 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0192  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r18, boolean r19, kotlin.coroutines.Continuation<? super java.lang.Boolean> r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r20
            boolean r2 = r1 instanceof com.m2catalyst.m2sdk.s5.b
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.m2catalyst.m2sdk.s5$b r2 = (com.m2catalyst.m2sdk.s5.b) r2
            int r3 = r2.e
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.e = r3
            goto L_0x001c
        L_0x0017:
            com.m2catalyst.m2sdk.s5$b r2 = new com.m2catalyst.m2sdk.s5$b
            r2.<init>(r0, r1)
        L_0x001c:
            java.lang.Object r1 = r2.c
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.e
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x0047
            if (r4 == r6) goto L_0x003d
            if (r4 != r5) goto L_0x0035
            android.content.Context r3 = r2.b
            com.m2catalyst.m2sdk.s5 r2 = r2.a
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0147
        L_0x0035:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003d:
            android.content.Context r4 = r2.b
            com.m2catalyst.m2sdk.s5 r7 = r2.a
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r4
            r4 = r7
            goto L_0x0069
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r1)
            com.m2catalyst.m2sdk.r2 r1 = r0.a
            boolean r1 = r1.e()
            if (r1 == 0) goto L_0x0057
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r1
        L_0x0057:
            r2.a = r0
            r1 = r18
            r2.b = r1
            r2.e = r6
            r4 = r19
            java.lang.Object r4 = r0.a(r4, r2)
            if (r4 != r3) goto L_0x0068
            return r3
        L_0x0068:
            r4 = r0
        L_0x0069:
            com.m2catalyst.m2sdk.r2 r7 = r4.a
            com.m2catalyst.m2sdk.r5 r8 = com.m2catalyst.m2sdk.r5.b
            boolean r7 = r7.a((com.m2catalyst.m2sdk.r5) r8)
            if (r7 != 0) goto L_0x007f
            com.m2catalyst.m2sdk.database.V8MigrationHelper r7 = com.m2catalyst.m2sdk.database.V8MigrationHelper.INSTANCE
            com.m2catalyst.m2sdk.r2 r9 = r4.a
            r7.migrate(r9)
            com.m2catalyst.m2sdk.r2 r7 = r4.a
            r7.a(r8, r6)
        L_0x007f:
            com.m2catalyst.m2sdk.r2 r7 = r4.a
            com.m2catalyst.m2sdk.r5 r8 = com.m2catalyst.m2sdk.r5.a
            boolean r7 = r7.a((com.m2catalyst.m2sdk.r5) r8)
            if (r7 != 0) goto L_0x008e
            com.m2catalyst.m2sdk.r2 r7 = r4.a
            r7.a(r8, r6)
        L_0x008e:
            com.m2catalyst.m2sdk.r2 r7 = r4.a
            com.m2catalyst.m2sdk.r5 r13 = com.m2catalyst.m2sdk.r5.d
            boolean r7 = r7.a((com.m2catalyst.m2sdk.r5) r13)
            if (r7 != 0) goto L_0x0138
            kotlin.Lazy r7 = r4.b
            java.lang.Object r7 = r7.getValue()
            com.m2catalyst.m2sdk.x6 r7 = (com.m2catalyst.m2sdk.x6) r7
            r7.getClass()
            java.lang.String r14 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r14)
            com.m2catalyst.m2sdk.r2 r8 = r7.a
            com.m2catalyst.m2sdk.z5 r8 = r8.a()
            com.m2catalyst.m2sdk.a6 r9 = com.m2catalyst.m2sdk.a6.API_KEY
            r15 = 0
            java.lang.Long r9 = java.lang.Long.valueOf(r15)
            android.content.SharedPreferences r10 = r8.a
            java.util.Map r10 = r10.getAll()
            java.lang.String r11 = "nextTimeDataTransmission"
            boolean r10 = r10.containsKey(r11)
            if (r10 != 0) goto L_0x00c5
            goto L_0x00cf
        L_0x00c5:
            android.content.SharedPreferences r8 = r8.a
            java.util.Map r8 = r8.getAll()
            java.lang.Object r9 = r8.get(r11)
        L_0x00cf:
            java.lang.Long r9 = (java.lang.Long) r9
            if (r9 == 0) goto L_0x00d9
            long r8 = r9.longValue()
            r9 = r8
            goto L_0x00da
        L_0x00d9:
            r9 = r15
        L_0x00da:
            com.m2catalyst.m2sdk.r2 r8 = r7.a
            r11 = 0
            com.m2catalyst.m2sdk.configuration.M2Configuration r8 = r8.a((boolean) r11)
            long r11 = r7.a(r8, r1)
            java.lang.String r8 = "TRANSMISSION_INGESTION_ALARM"
            r7 = r1
            com.m2catalyst.m2sdk.x6.a(r7, r8, r9, r11)
            kotlin.Lazy r7 = r4.b
            java.lang.Object r7 = r7.getValue()
            com.m2catalyst.m2sdk.x6 r7 = (com.m2catalyst.m2sdk.x6) r7
            r7.getClass()
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r14)
            com.m2catalyst.m2sdk.r2 r7 = r7.a
            com.m2catalyst.m2sdk.z5 r7 = r7.a()
            java.lang.Long r8 = java.lang.Long.valueOf(r15)
            android.content.SharedPreferences r9 = r7.a
            java.util.Map r9 = r9.getAll()
            java.lang.String r10 = "nextTimeMonitorStatsTransmission"
            boolean r9 = r9.containsKey(r10)
            if (r9 != 0) goto L_0x0112
            goto L_0x011c
        L_0x0112:
            android.content.SharedPreferences r7 = r7.a
            java.util.Map r7 = r7.getAll()
            java.lang.Object r8 = r7.get(r10)
        L_0x011c:
            java.lang.Long r8 = (java.lang.Long) r8
            if (r8 == 0) goto L_0x0126
            long r7 = r8.longValue()
            r9 = r7
            goto L_0x0127
        L_0x0126:
            r9 = r15
        L_0x0127:
            r7 = 24
            long r11 = com.m2catalyst.m2sdk.o1.a((int) r7)
            java.lang.String r8 = "BUILD_MONITOR_STATS"
            r7 = r1
            com.m2catalyst.m2sdk.x6.a(r7, r8, r9, r11)
            com.m2catalyst.m2sdk.r2 r7 = r4.a
            r7.a(r13, r6)
        L_0x0138:
            r2.a = r4
            r2.b = r1
            r2.e = r5
            java.lang.Object r2 = r4.a(r2)
            if (r2 != r3) goto L_0x0145
            return r3
        L_0x0145:
            r3 = r1
            r2 = r4
        L_0x0147:
            com.m2catalyst.m2sdk.r2 r1 = r2.a
            com.m2catalyst.m2sdk.r5 r4 = com.m2catalyst.m2sdk.r5.e
            boolean r1 = r1.a((com.m2catalyst.m2sdk.r5) r4)
            if (r1 != 0) goto L_0x0172
            long r7 = java.lang.System.currentTimeMillis()
            kotlin.Lazy r1 = r2.c
            java.lang.Object r1 = r1.getValue()
            com.m2catalyst.m2sdk.b6 r1 = (com.m2catalyst.m2sdk.b6) r1
            r9 = 6
            long r10 = com.m2catalyst.m2sdk.o1.a((int) r9)
            long r10 = r10 + r7
            long r7 = com.m2catalyst.m2sdk.o1.a((int) r9)
            r1.getClass()
            com.m2catalyst.m2sdk.b6.a(r3, r10, r7)
            com.m2catalyst.m2sdk.r2 r1 = r2.a
            r1.a(r4, r6)
        L_0x0172:
            android.content.IntentFilter r1 = new android.content.IntentFilter
            r1.<init>()
            java.lang.String r4 = "EXPORT_DB"
            r1.addAction(r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r6 = 33
            if (r4 < r6) goto L_0x0192
            android.content.Context r4 = r3.getApplicationContext()
            kotlin.Lazy r6 = r2.f
            java.lang.Object r6 = r6.getValue()
            com.m2catalyst.m2sdk.core.setup.M2SDKOpsReceiver r6 = (com.m2catalyst.m2sdk.core.setup.M2SDKOpsReceiver) r6
            r4.registerReceiver(r6, r1, r5)
            goto L_0x01a1
        L_0x0192:
            android.content.Context r4 = r3.getApplicationContext()
            kotlin.Lazy r5 = r2.f
            java.lang.Object r5 = r5.getValue()
            com.m2catalyst.m2sdk.core.setup.M2SDKOpsReceiver r5 = (com.m2catalyst.m2sdk.core.setup.M2SDKOpsReceiver) r5
            r4.registerReceiver(r5, r1)
        L_0x01a1:
            com.m2catalyst.m2sdk.r2 r1 = r2.a
            boolean r1 = r1.e()
            if (r1 != 0) goto L_0x01b7
            kotlin.Lazy r1 = r2.c
            java.lang.Object r1 = r1.getValue()
            com.m2catalyst.m2sdk.b6 r1 = (com.m2catalyst.m2sdk.b6) r1
            r1.getClass()
            com.m2catalyst.m2sdk.b6.a(r3)
        L_0x01b7:
            com.m2catalyst.m2sdk.r2 r1 = r2.a
            boolean r1 = r1.e()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.s5.a(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean b() {
        return this.a.d();
    }

    public final boolean c() {
        return this.a.e();
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final M2SDKConfiguration a() {
        z5 a2 = this.a.a();
        a6 a6Var = a6.M2_SDK_CONFIG;
        Object obj = a6Var.b;
        String str = a6Var.a;
        if (a2.a.getAll().containsKey(str)) {
            obj = a2.a.getAll().get(str);
        }
        String str2 = (String) obj;
        if (str2 == null) {
            str2 = "";
        }
        if (str2.length() > 0) {
            try {
                return (M2SDKConfiguration) this.g.fromJson(str2, M2SDKConfiguration.class);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(boolean r8, kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.configuration.M2Configuration> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.m2catalyst.m2sdk.s5.c
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.m2catalyst.m2sdk.s5$c r0 = (com.m2catalyst.m2sdk.s5.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.s5$c r0 = new com.m2catalyst.m2sdk.s5$c
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            com.m2catalyst.m2sdk.r2 r8 = r0.b
            com.m2catalyst.m2sdk.s5 r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00a6
        L_0x002e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
            com.m2catalyst.m2sdk.r2 r9 = r7.a
            com.m2catalyst.m2sdk.a6 r2 = com.m2catalyst.m2sdk.a6.REMOTE_SDK_GENERAL_CONFIGURATION
            com.m2catalyst.m2sdk.s2 r4 = new com.m2catalyst.m2sdk.s2
            r4.<init>(r9, r2)
            java.lang.String r9 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r9)
            java.lang.Object r9 = r4.invoke()     // Catch:{ Exception -> 0x004c }
            goto L_0x004e
        L_0x004c:
            java.lang.String r9 = ""
        L_0x004e:
            java.lang.String r9 = (java.lang.String) r9
            int r2 = r9.length()
            r4 = 0
            if (r2 != 0) goto L_0x0059
            r2 = 1
            goto L_0x005a
        L_0x0059:
            r2 = 0
        L_0x005a:
            if (r2 == 0) goto L_0x005d
            goto L_0x0069
        L_0x005d:
            com.google.gson.Gson r2 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0069 }
            r2.<init>()     // Catch:{ Exception -> 0x0069 }
            java.lang.Class<com.m2catalyst.m2sdk.p2> r5 = com.m2catalyst.m2sdk.p2.class
            java.lang.Object r9 = r2.fromJson((java.lang.String) r9, r5)     // Catch:{ Exception -> 0x0069 }
            goto L_0x006a
        L_0x0069:
            r9 = 0
        L_0x006a:
            com.m2catalyst.m2sdk.p2 r9 = (com.m2catalyst.m2sdk.p2) r9
            if (r9 == 0) goto L_0x007d
            java.lang.Integer r9 = r9.a
            if (r9 == 0) goto L_0x007d
            int r9 = r9.intValue()
            int r9 = r9 * 24
            long r5 = com.m2catalyst.m2sdk.o1.a((int) r9)
            goto L_0x007f
        L_0x007d:
            r5 = 0
        L_0x007f:
            if (r8 != 0) goto L_0x0089
            long r8 = java.lang.System.currentTimeMillis()
            int r2 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r2 < 0) goto L_0x008a
        L_0x0089:
            r4 = 1
        L_0x008a:
            if (r4 == 0) goto L_0x00b4
            com.m2catalyst.m2sdk.r2 r8 = r7.a
            kotlin.Lazy r9 = r7.e
            java.lang.Object r9 = r9.getValue()
            com.m2catalyst.m2sdk.y2 r9 = (com.m2catalyst.m2sdk.y2) r9
            r0.a = r7
            r0.b = r8
            r0.e = r3
            com.m2catalyst.m2sdk.r2 r9 = r9.a
            com.m2catalyst.m2sdk.x2 r9 = com.m2catalyst.m2sdk.y2.a.a(r9)
            if (r9 != r1) goto L_0x00a5
            return r1
        L_0x00a5:
            r0 = r7
        L_0x00a6:
            com.m2catalyst.m2sdk.x2 r9 = (com.m2catalyst.m2sdk.x2) r9
            r8.getClass()
            java.lang.String r1 = "configuration"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            r8.a((java.lang.Object) r9)
            goto L_0x00b5
        L_0x00b4:
            r0 = r7
        L_0x00b5:
            com.m2catalyst.m2sdk.r2 r8 = r0.a
            com.m2catalyst.m2sdk.configuration.M2Configuration r8 = r8.a((boolean) r3)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.s5.a(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.m2catalyst.m2sdk.s5.d
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.m2catalyst.m2sdk.s5$d r0 = (com.m2catalyst.m2sdk.s5.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.s5$d r0 = new com.m2catalyst.m2sdk.s5$d
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            com.m2catalyst.m2sdk.s5 r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0054
        L_0x002b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r5)
            com.m2catalyst.m2sdk.r2 r5 = r4.a
            com.m2catalyst.m2sdk.r5 r2 = com.m2catalyst.m2sdk.r5.c
            boolean r5 = r5.a((com.m2catalyst.m2sdk.r5) r2)
            if (r5 != 0) goto L_0x0061
            kotlin.Lazy r5 = r4.d
            java.lang.Object r5 = r5.getValue()
            com.m2catalyst.m2sdk.x1 r5 = (com.m2catalyst.m2sdk.x1) r5
            r0.a = r4
            r0.d = r3
            java.lang.Object r5 = r5.a(r0)
            if (r5 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r0 = r4
        L_0x0054:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            com.m2catalyst.m2sdk.r2 r0 = r0.a
            com.m2catalyst.m2sdk.r5 r1 = com.m2catalyst.m2sdk.r5.c
            r0.a(r1, r5)
        L_0x0061:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.s5.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
