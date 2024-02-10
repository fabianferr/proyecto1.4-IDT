package com.wortise.ads;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.consent.ConsentManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0010\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001*B\t\b\u0002¢\u0006\u0004\b)\u0010\"J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J:\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000ej\u0004\u0018\u0001`\u000fH\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001a\u0010\u0013\u001a\u00020\u00062\u0010\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u00060\u000ej\u0002`\u000fH\u0007R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010\u001c\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00060\u000ej\u0002`\u000f0\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0017R*\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t8\u0006@BX\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b!\u0010\"\u001a\u0004\b\u001e\u0010 R\u001a\u0010#\u001a\u00020\t8FX\u0004¢\u0006\f\u0012\u0004\b$\u0010\"\u001a\u0004\b#\u0010 R\u001a\u0010(\u001a\u00020\f8FX\u0004¢\u0006\f\u0012\u0004\b'\u0010\"\u001a\u0004\b%\u0010&\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/wortise/ads/WortiseSdk;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/l1;", "config", "", "onConfigFetched", "(Landroid/content/Context;Lcom/wortise/ads/l1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "start", "onSdkInitialized", "", "assetKey", "Lkotlin/Function0;", "Lcom/wortise/ads/SdkInitializationListener;", "listener", "initialize", "stop", "wait", "", "Lcom/wortise/ads/g3;", "JOBS", "Ljava/util/List;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "", "listeners", "<set-?>", "isReady", "Z", "()Z", "isReady$annotations", "()V", "isInitialized", "isInitialized$annotations", "getVersion", "()Ljava/lang/String;", "getVersion$annotations", "version", "<init>", "Coroutines", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: WortiseSdk.kt */
public final class WortiseSdk {
    public static final WortiseSdk INSTANCE = new WortiseSdk();
    /* access modifiers changed from: private */
    public static final List<g3> JOBS = CollectionsKt.listOf(g3.a);
    /* access modifiers changed from: private */
    public static final AtomicBoolean initialized = new AtomicBoolean(false);
    private static boolean isReady;
    private static final List<Function0<Unit>> listeners = new ArrayList();

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ+\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0011\u0010\u0011\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/wortise/ads/WortiseSdk$Coroutines;", "", "()V", "doInitialize", "", "context", "Landroid/content/Context;", "start", "", "doInitialize$sdk_productionRelease", "(Landroid/content/Context;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initialize", "assetKey", "", "(Landroid/content/Context;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stop", "wait", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WortiseSdk.kt */
    public static final class Coroutines {
        public static final Coroutines INSTANCE = new Coroutines();

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.wortise.ads.WortiseSdk$Coroutines", f = "WortiseSdk.kt", i = {0, 0}, l = {127, 136}, m = "doInitialize$sdk_productionRelease", n = {"context", "start"}, s = {"L$0", "Z$0"})
        /* compiled from: WortiseSdk.kt */
        static final class a extends ContinuationImpl {
            Object a;
            boolean b;
            /* synthetic */ Object c;
            final /* synthetic */ Coroutines d;
            int e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Coroutines coroutines, Continuation<? super a> continuation) {
                super(continuation);
                this.d = coroutines;
            }

            public final Object invokeSuspend(Object obj) {
                this.c = obj;
                this.e |= Integer.MIN_VALUE;
                return this.d.doInitialize$sdk_productionRelease((Context) null, false, this);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.wortise.ads.WortiseSdk$Coroutines$doInitialize$2", f = "WortiseSdk.kt", i = {}, l = {129, 131, 131}, m = "invokeSuspend", n = {}, s = {})
        /* compiled from: WortiseSdk.kt */
        static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
            int a;
            final /* synthetic */ Context b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Context context, Continuation<? super b> continuation) {
                super(2, continuation);
                this.b = context;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new b(this.b, continuation);
            }

            /* JADX WARNING: Removed duplicated region for block: B:18:0x0047  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r5.a
                    r2 = 3
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L_0x0025
                    if (r1 == r4) goto L_0x0021
                    if (r1 == r3) goto L_0x001d
                    if (r1 != r2) goto L_0x0015
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L_0x0054
                L_0x0015:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L_0x001d:
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L_0x0042
                L_0x0021:
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L_0x0035
                L_0x0025:
                    kotlin.ResultKt.throwOnFailure(r6)
                    com.wortise.ads.identifier.IdentifierManager r6 = com.wortise.ads.identifier.IdentifierManager.INSTANCE
                    android.content.Context r1 = r5.b
                    r5.a = r4
                    java.lang.Object r6 = r6.fetch(r1, r5)
                    if (r6 != r0) goto L_0x0035
                    return r0
                L_0x0035:
                    com.wortise.ads.o1 r6 = com.wortise.ads.o1.a
                    android.content.Context r1 = r5.b
                    r5.a = r3
                    java.lang.Object r6 = r6.fetch(r1, r5)
                    if (r6 != r0) goto L_0x0042
                    return r0
                L_0x0042:
                    com.wortise.ads.l1 r6 = (com.wortise.ads.l1) r6
                    if (r6 != 0) goto L_0x0047
                    goto L_0x0054
                L_0x0047:
                    android.content.Context r1 = r5.b
                    com.wortise.ads.WortiseSdk r3 = com.wortise.ads.WortiseSdk.INSTANCE
                    r5.a = r2
                    java.lang.Object r6 = r3.onConfigFetched(r1, r6, r5)
                    if (r6 != r0) goto L_0x0054
                    return r0
                L_0x0054:
                    com.wortise.ads.p2 r6 = com.wortise.ads.p2.a
                    android.content.Context r0 = r5.b
                    java.lang.String r6 = r6.a((android.content.Context) r0)
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.WortiseSdk.Coroutines.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.wortise.ads.WortiseSdk$Coroutines$doInitialize$3", f = "WortiseSdk.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* compiled from: WortiseSdk.kt */
        static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int a;
            final /* synthetic */ Context b;
            final /* synthetic */ boolean c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(Context context, boolean z, Continuation<? super c> continuation) {
                super(2, continuation);
                this.b = context;
                this.c = z;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new c(this.b, this.c, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.a == 0) {
                    ResultKt.throwOnFailure(obj);
                    WortiseSdk.INSTANCE.onSdkInitialized(this.b, this.c);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.wortise.ads.WortiseSdk$Coroutines$start$2", f = "WortiseSdk.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
        /* compiled from: WortiseSdk.kt */
        static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int a;
            final /* synthetic */ Context b;
            final /* synthetic */ l1 c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(Context context, l1 l1Var, Continuation<? super d> continuation) {
                super(2, continuation);
                this.b = context;
                this.c = l1Var;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new d(this.b, this.c, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List access$getJOBS$p = WortiseSdk.JOBS;
                    Context context = this.b;
                    l1 l1Var = this.c;
                    this.a = 1;
                    if (f4.a(access$getJOBS$p, context, l1Var, this) == coroutine_suspended) {
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

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.wortise.ads.WortiseSdk$Coroutines$stop$2", f = "WortiseSdk.kt", i = {}, l = {168}, m = "invokeSuspend", n = {}, s = {})
        /* compiled from: WortiseSdk.kt */
        static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int a;
            final /* synthetic */ Context b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            e(Context context, Continuation<? super e> continuation) {
                super(2, continuation);
                this.b = context;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new e(this.b, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    List access$getJOBS$p = WortiseSdk.JOBS;
                    Context context = this.b;
                    this.a = 1;
                    if (f4.a(access$getJOBS$p, context, this) == coroutine_suspended) {
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

        @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* compiled from: WortiseSdk.kt */
        static final class f extends Lambda implements Function0<Unit> {
            final /* synthetic */ CancellableContinuation<Unit> a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(CancellableContinuation<? super Unit> cancellableContinuation) {
                super(0);
                this.a = cancellableContinuation;
            }

            public final void a() {
                CancellableContinuation<Unit> cancellableContinuation = this.a;
                Unit unit = Unit.INSTANCE;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m2344constructorimpl(unit));
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return Unit.INSTANCE;
            }
        }

        private Coroutines() {
        }

        public static /* synthetic */ Object initialize$default(Coroutines coroutines, Context context, String str, boolean z, Continuation continuation, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return coroutines.initialize(context, str, z, continuation);
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x003f  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x007d A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object doInitialize$sdk_productionRelease(android.content.Context r7, boolean r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
            /*
                r6 = this;
                boolean r0 = r9 instanceof com.wortise.ads.WortiseSdk.Coroutines.a
                if (r0 == 0) goto L_0x0013
                r0 = r9
                com.wortise.ads.WortiseSdk$Coroutines$a r0 = (com.wortise.ads.WortiseSdk.Coroutines.a) r0
                int r1 = r0.e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.e = r1
                goto L_0x0018
            L_0x0013:
                com.wortise.ads.WortiseSdk$Coroutines$a r0 = new com.wortise.ads.WortiseSdk$Coroutines$a
                r0.<init>(r6, r9)
            L_0x0018:
                java.lang.Object r9 = r0.c
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.e
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L_0x003f
                if (r2 == r4) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x007e
            L_0x002d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0035:
                boolean r8 = r0.b
                java.lang.Object r7 = r0.a
                android.content.Context r7 = (android.content.Context) r7
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x006a
            L_0x003f:
                kotlin.ResultKt.throwOnFailure(r9)
                int r9 = android.os.Build.VERSION.SDK_INT
                r2 = 22
                if (r9 > r2) goto L_0x004b
                com.wortise.ads.e7.a(r7)
            L_0x004b:
                com.wortise.ads.o3 r9 = com.wortise.ads.o3.a
                kotlinx.coroutines.Deferred r9 = r9.a((android.content.Context) r7)
                r9.start()
                kotlinx.coroutines.CoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getIO()
                com.wortise.ads.WortiseSdk$Coroutines$b r2 = new com.wortise.ads.WortiseSdk$Coroutines$b
                r2.<init>(r7, r5)
                r0.a = r7
                r0.b = r8
                r0.e = r4
                java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r9, r2, r0)
                if (r9 != r1) goto L_0x006a
                return r1
            L_0x006a:
                kotlinx.coroutines.MainCoroutineDispatcher r9 = kotlinx.coroutines.Dispatchers.getMain()
                com.wortise.ads.WortiseSdk$Coroutines$c r2 = new com.wortise.ads.WortiseSdk$Coroutines$c
                r2.<init>(r7, r8, r5)
                r0.a = r5
                r0.e = r3
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r9, r2, r0)
                if (r7 != r1) goto L_0x007e
                return r1
            L_0x007e:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.WortiseSdk.Coroutines.doInitialize$sdk_productionRelease(android.content.Context, boolean, kotlin.coroutines.Continuation):java.lang.Object");
        }

        public final Object initialize(Context context, String str, boolean z, Continuation<? super Unit> continuation) {
            if (!s5.a.b(context)) {
                return Unit.INSTANCE;
            }
            if (!WortiseSdk.initialized.compareAndSet(false, true)) {
                Object wait = wait(continuation);
                return wait == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? wait : Unit.INSTANCE;
            }
            AdSettings.INSTANCE.setAssetKey$sdk_productionRelease(context, str);
            Object doInitialize$sdk_productionRelease = doInitialize$sdk_productionRelease(context, z, continuation);
            return doInitialize$sdk_productionRelease == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? doInitialize$sdk_productionRelease : Unit.INSTANCE;
        }

        public final Object start(Context context, Continuation<? super Unit> continuation) {
            if (!WortiseSdk.isReady()) {
                return Unit.INSTANCE;
            }
            l1 l1Var = (l1) o1.a.getValue();
            if (l1Var == null) {
                return Unit.INSTANCE;
            }
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new d(context, l1Var, (Continuation<? super d>) null), continuation);
            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }

        public final Object stop(Context context, Continuation<? super Unit> continuation) {
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new e(context, (Continuation<? super e>) null), continuation);
            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }

        public final Object wait(Continuation<? super Unit> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            WortiseSdk.wait(new f(cancellableContinuationImpl));
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WortiseSdk.kt */
    /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Function0<? extends Unit>, Unit> {
        a(Object obj) {
            super(1, obj, WortiseSdk.class, "wait", "wait(Lkotlin/jvm/functions/Function0;)V", 0);
        }

        public final void a(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "p0");
            WortiseSdk.wait(function0);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Function0) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.WortiseSdk$initialize$2", f = "WortiseSdk.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: WortiseSdk.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ boolean c;
        final /* synthetic */ Function0<Unit> d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, boolean z, Function0<Unit> function0, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = context;
            this.c = z;
            this.d = function0;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Coroutines coroutines = Coroutines.INSTANCE;
                Context context = this.b;
                boolean z = this.c;
                this.a = 1;
                if (coroutines.doInitialize$sdk_productionRelease(context, z, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Function0<Unit> function0 = this.d;
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.WortiseSdk$start$1", f = "WortiseSdk.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: WortiseSdk.kt */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
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
                Coroutines coroutines = Coroutines.INSTANCE;
                Context context = this.b;
                this.a = 1;
                if (coroutines.start(context, this) == coroutine_suspended) {
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

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.WortiseSdk$stop$1", f = "WortiseSdk.kt", i = {}, l = {101}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: WortiseSdk.kt */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Context context, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Coroutines coroutines = Coroutines.INSTANCE;
                Context context = this.b;
                this.a = 1;
                if (coroutines.stop(context, this) == coroutine_suspended) {
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

    private WortiseSdk() {
    }

    public static final String getVersion() {
        return "1.4.1";
    }

    @JvmStatic
    public static /* synthetic */ void getVersion$annotations() {
    }

    @JvmStatic
    public static final void initialize(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "assetKey");
        initialize$default(context, str, false, (Function0) null, 12, (Object) null);
    }

    @JvmStatic
    public static final void initialize(Context context, String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "assetKey");
        initialize$default(context, str, z, (Function0) null, 8, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002f, code lost:
        return;
     */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized void initialize(android.content.Context r8, java.lang.String r9, boolean r10, kotlin.jvm.functions.Function0<kotlin.Unit> r11) {
        /*
            java.lang.Class<com.wortise.ads.WortiseSdk> r0 = com.wortise.ads.WortiseSdk.class
            monitor-enter(r0)
            java.lang.String r1 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = "assetKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)     // Catch:{ all -> 0x0048 }
            com.wortise.ads.s5 r1 = com.wortise.ads.s5.a     // Catch:{ all -> 0x0048 }
            boolean r1 = r1.b(r8)     // Catch:{ all -> 0x0048 }
            if (r1 != 0) goto L_0x0017
            monitor-exit(r0)
            return
        L_0x0017:
            java.util.concurrent.atomic.AtomicBoolean r1 = initialized     // Catch:{ all -> 0x0048 }
            r2 = 0
            r3 = 1
            boolean r1 = r1.compareAndSet(r2, r3)     // Catch:{ all -> 0x0048 }
            if (r1 != 0) goto L_0x0030
            if (r11 != 0) goto L_0x0024
            goto L_0x002e
        L_0x0024:
            com.wortise.ads.WortiseSdk r8 = INSTANCE     // Catch:{ all -> 0x0048 }
            com.wortise.ads.WortiseSdk$a r9 = new com.wortise.ads.WortiseSdk$a     // Catch:{ all -> 0x0048 }
            r9.<init>(r8)     // Catch:{ all -> 0x0048 }
            r9.invoke(r11)     // Catch:{ all -> 0x0048 }
        L_0x002e:
            monitor-exit(r0)
            return
        L_0x0030:
            com.wortise.ads.AdSettings r1 = com.wortise.ads.AdSettings.INSTANCE     // Catch:{ all -> 0x0048 }
            r1.setAssetKey$sdk_productionRelease(r8, r9)     // Catch:{ all -> 0x0048 }
            kotlinx.coroutines.CoroutineScope r2 = com.wortise.ads.c2.c()     // Catch:{ all -> 0x0048 }
            com.wortise.ads.WortiseSdk$b r5 = new com.wortise.ads.WortiseSdk$b     // Catch:{ all -> 0x0048 }
            r9 = 0
            r5.<init>(r8, r10, r11, r9)     // Catch:{ all -> 0x0048 }
            r3 = 0
            r4 = 0
            r6 = 3
            r7 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0048 }
            monitor-exit(r0)
            return
        L_0x0048:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.WortiseSdk.initialize(android.content.Context, java.lang.String, boolean, kotlin.jvm.functions.Function0):void");
    }

    public static /* synthetic */ void initialize$default(Context context, String str, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        if ((i & 8) != 0) {
            function0 = null;
        }
        initialize(context, str, z, function0);
    }

    public static final boolean isInitialized() {
        return initialized.get();
    }

    @JvmStatic
    public static /* synthetic */ void isInitialized$annotations() {
    }

    public static final boolean isReady() {
        return isReady;
    }

    @JvmStatic
    public static /* synthetic */ void isReady$annotations() {
    }

    /* access modifiers changed from: private */
    public final Object onConfigFetched(Context context, l1 l1Var, Continuation<? super Unit> continuation) {
        Object sync$sdk_productionRelease = ConsentManager.INSTANCE.sync$sdk_productionRelease(context, l1Var.a(), continuation);
        return sync$sdk_productionRelease == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sync$sdk_productionRelease : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void onSdkInitialized(Context context, boolean z) {
        isReady = true;
        if (z) {
            start(context);
        }
        for (Function0 invoke : listeners) {
            invoke.invoke();
        }
    }

    @JvmStatic
    public static final void start(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Job unused = BuildersKt__Builders_commonKt.launch$default(c2.c(), (CoroutineContext) null, (CoroutineStart) null, new c(context, (Continuation<? super c>) null), 3, (Object) null);
    }

    @JvmStatic
    public static final void stop(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Job unused = BuildersKt__Builders_commonKt.launch$default(c2.c(), (CoroutineContext) null, (CoroutineStart) null, new d(context, (Continuation<? super d>) null), 3, (Object) null);
    }

    @JvmStatic
    public static final synchronized void wait(Function0<Unit> function0) {
        synchronized (WortiseSdk.class) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            if (isReady) {
                function0.invoke();
            } else {
                listeners.add(function0);
            }
        }
    }
}
