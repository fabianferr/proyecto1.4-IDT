package com.wortise.ads;

import android.content.Context;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.TimeoutKt;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u001d\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006J\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/wortise/ads/o3;", "", "Landroid/content/Context;", "context", "Lcom/google/android/gms/ads/initialization/InitializationStatus;", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "adapter", "Lcom/google/android/gms/ads/initialization/AdapterStatus;", "status", "", "b", "Lkotlinx/coroutines/Deferred;", "()Lcom/google/android/gms/ads/initialization/InitializationStatus;", "initializationStatus", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GoogleSdk.kt */
public final class o3 {
    public static final o3 a = new o3();
    private static Deferred<? extends InitializationStatus> b;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/google/android/gms/ads/initialization/InitializationStatus;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: GoogleSdk.kt */
    static final class a implements OnInitializationCompleteListener {
        final /* synthetic */ CancellableContinuation<InitializationStatus> a;

        a(CancellableContinuation<? super InitializationStatus> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        public final void onInitializationComplete(InitializationStatus initializationStatus) {
            Intrinsics.checkNotNullParameter(initializationStatus, "it");
            WortiseLog.d$default("Google Mobile Ads initialized", (Throwable) null, 2, (Object) null);
            Map<String, AdapterStatus> adapterStatusMap = initializationStatus.getAdapterStatusMap();
            Intrinsics.checkNotNullExpressionValue(adapterStatusMap, "it.adapterStatusMap");
            for (Map.Entry next : adapterStatusMap.entrySet()) {
                o3 o3Var = o3.a;
                Object key = next.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "p.key");
                Object value = next.getValue();
                Intrinsics.checkNotNullExpressionValue(value, "p.value");
                o3Var.a((String) key, (AdapterStatus) value);
            }
            CancellableContinuation<InitializationStatus> cancellableContinuation = this.a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(initializationStatus));
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.google.GoogleSdk", f = "GoogleSdk.kt", i = {0}, l = {30}, m = "initialize", n = {"log$iv"}, s = {"I$0"})
    /* compiled from: GoogleSdk.kt */
    static final class b extends ContinuationImpl {
        int a;
        /* synthetic */ Object b;
        final /* synthetic */ o3 c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(o3 o3Var, Continuation<? super b> continuation) {
            super(continuation);
            this.c = o3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.b((Context) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/google/android/gms/ads/initialization/InitializationStatus;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.google.GoogleSdk$initializeAsync$1", f = "GoogleSdk.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: GoogleSdk.kt */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InitializationStatus>, Object> {
        int a;
        final /* synthetic */ Context b;

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/google/android/gms/ads/initialization/InitializationStatus;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.wortise.ads.google.GoogleSdk$initializeAsync$1$1", f = "GoogleSdk.kt", i = {}, l = {34}, m = "invokeSuspend", n = {}, s = {})
        /* compiled from: GoogleSdk.kt */
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super InitializationStatus>, Object> {
            int a;
            final /* synthetic */ Context b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Context context, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = context;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InitializationStatus> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    o3 o3Var = o3.a;
                    Context context = this.b;
                    this.a = 1;
                    obj = o3Var.a(context, (Continuation<? super InitializationStatus>) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super InitializationStatus> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                a aVar = new a(this.b, (Continuation<? super a>) null);
                this.a = 1;
                obj = TimeoutKt.withTimeoutOrNull(5000, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    private o3() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(android.content.Context r6, kotlin.coroutines.Continuation<? super com.google.android.gms.ads.initialization.InitializationStatus> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.wortise.ads.o3.b
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.o3$b r0 = (com.wortise.ads.o3.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.o3$b r0 = new com.wortise.ads.o3$b
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            int r6 = r0.a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x002b }
            goto L_0x004c
        L_0x002b:
            r7 = move-exception
            goto L_0x004f
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            r7 = 0
            com.wortise.ads.o3 r2 = a     // Catch:{ all -> 0x0053 }
            kotlinx.coroutines.Deferred r6 = r2.a((android.content.Context) r6)     // Catch:{ all -> 0x0053 }
            r0.a = r7     // Catch:{ all -> 0x0053 }
            r0.d = r3     // Catch:{ all -> 0x0053 }
            java.lang.Object r6 = r6.await(r0)     // Catch:{ all -> 0x0053 }
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            r7 = r6
            r6 = 0
        L_0x004c:
            com.google.android.gms.ads.initialization.InitializationStatus r7 = (com.google.android.gms.ads.initialization.InitializationStatus) r7     // Catch:{ all -> 0x002b }
            goto L_0x0062
        L_0x004f:
            r4 = r7
            r7 = r6
            r6 = r4
            goto L_0x0054
        L_0x0053:
            r6 = move-exception
        L_0x0054:
            if (r7 == 0) goto L_0x0061
            java.lang.String r7 = r6.getMessage()
            if (r7 != 0) goto L_0x005e
            java.lang.String r7 = "Caught an exception"
        L_0x005e:
            com.wortise.ads.WortiseLog.e((java.lang.String) r7, (java.lang.Throwable) r6)
        L_0x0061:
            r7 = 0
        L_0x0062:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.o3.b(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final InitializationStatus a() {
        try {
            return MobileAds.getInitializationStatus();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Deferred<InitializationStatus> a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Deferred<? extends InitializationStatus> deferred = b;
        if (deferred != null) {
            return deferred;
        }
        Deferred<? extends InitializationStatus> async$default = BuildersKt__Builders_commonKt.async$default(c2.c(), (CoroutineContext) null, (CoroutineStart) null, new c(context, (Continuation<? super c>) null), 3, (Object) null);
        b = async$default;
        return async$default;
    }

    /* access modifiers changed from: private */
    public final void a(String str, AdapterStatus adapterStatus) {
        WortiseLog.v$default("- Adapter " + str + " with status " + adapterStatus.getInitializationState().name(), (Throwable) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object a(Context context, Continuation<? super InitializationStatus> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        a aVar = new a(cancellableContinuationImpl);
        Unit unit = null;
        WortiseLog.d$default("Initializing Google Mobile Ads...", (Throwable) null, 2, (Object) null);
        o3 o3Var = a;
        o3Var.b(context);
        InitializationStatus a2 = o3Var.a();
        if (a2 != null) {
            aVar.onInitializationComplete(a2);
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            MobileAds.initialize(context, aVar);
        }
        n3.a.a(context);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final void b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        MobileAds.setRequestConfiguration(v5.a.a(context));
    }
}
