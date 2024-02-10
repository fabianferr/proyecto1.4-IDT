package com.wortise.ads.identifier;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.reflect.TypeToken;
import com.wortise.ads.c4;
import com.wortise.ads.g6;
import com.wortise.ads.j3;
import com.wortise.ads.m3;
import com.wortise.ads.q4;
import com.wortise.ads.r5;
import com.wortise.ads.s;
import com.wortise.ads.t;
import com.wortise.ads.utils.AsyncManager;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0002J\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\u0006J\u001d\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003J\u0016\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u0003R\u0014\u0010\u0015\u001a\u00020\u00148\u0002XT¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u00178\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/wortise/ads/identifier/IdentifierManager;", "Lcom/wortise/ads/utils/AsyncManager;", "Lcom/wortise/ads/identifier/Identifier;", "Landroid/content/Context;", "context", "load", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readFromCache", "identifier", "", "writeToCache", "fetch", "refresh", "", "clear", "Lkotlinx/coroutines/Deferred;", "fetchAsync", "fetchSync", "get", "refreshAsync", "", "KEY", "Ljava/lang/String;", "", "Lcom/wortise/ads/s;", "MODULES", "Ljava/util/List;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: IdentifierManager.kt */
public final class IdentifierManager extends AsyncManager<Identifier> {
    public static final IdentifierManager INSTANCE = new IdentifierManager();
    private static final String KEY = "userIdentifier";
    private static final List<s> MODULES = CollectionsKt.listOf(j3.a, c4.a, t.a, m3.a);

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H@"}, d2 = {"Lcom/wortise/ads/identifier/Identifier;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.identifier.IdentifierManager$fetchAsync$1", f = "IdentifierManager.kt", i = {}, l = {37}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: IdentifierManager.kt */
    static final class a extends SuspendLambda implements Function1<Continuation<? super Identifier>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Continuation<? super a> continuation) {
            super(1, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(Continuation<? super Identifier> continuation) {
            return ((a) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new a(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IdentifierManager identifierManager = IdentifierManager.INSTANCE;
                Context context = this.b;
                this.a = 1;
                obj = identifierManager.load(context, this);
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

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/identifier/Identifier;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.identifier.IdentifierManager$fetchSync$1", f = "IdentifierManager.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: IdentifierManager.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Identifier>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Identifier> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                IdentifierManager identifierManager = IdentifierManager.INSTANCE;
                Context context = this.b;
                this.a = 1;
                obj = identifierManager.fetch(context, this);
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

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 5, 1})
    /* compiled from: SafeCollector.common.kt */
    public static final class c implements Flow<Identifier> {
        final /* synthetic */ Flow a;

        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Collect.kt */
        public static final class a implements FlowCollector<Identifier> {
            final /* synthetic */ FlowCollector a;

            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
            @DebugMetadata(c = "com.wortise.ads.identifier.IdentifierManager$load$$inlined$filterNot$1$2", f = "IdentifierManager.kt", i = {}, l = {137}, m = "emit", n = {}, s = {})
            /* renamed from: com.wortise.ads.identifier.IdentifierManager$c$a$a  reason: collision with other inner class name */
            public static final class C0185a extends ContinuationImpl {
                /* synthetic */ Object a;
                int b;
                final /* synthetic */ a c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0185a(a aVar, Continuation continuation) {
                    super(continuation);
                    this.c = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return this.c.emit((Object) null, this);
                }
            }

            public a(FlowCollector flowCollector) {
                this.a = flowCollector;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof com.wortise.ads.identifier.IdentifierManager.c.a.C0185a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    com.wortise.ads.identifier.IdentifierManager$c$a$a r0 = (com.wortise.ads.identifier.IdentifierManager.c.a.C0185a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    com.wortise.ads.identifier.IdentifierManager$c$a$a r0 = new com.wortise.ads.identifier.IdentifierManager$c$a$a
                    r0.<init>(r4, r6)
                L_0x0018:
                    java.lang.Object r6 = r0.a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L_0x0048
                L_0x0029:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x0031:
                    kotlin.ResultKt.throwOnFailure(r6)
                    kotlinx.coroutines.flow.FlowCollector r6 = r4.a
                    r2 = r5
                    com.wortise.ads.identifier.Identifier r2 = (com.wortise.ads.identifier.Identifier) r2
                    boolean r2 = r2.getLimitAdTracking()
                    if (r2 != 0) goto L_0x0048
                    r0.b = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x0048
                    return r1
                L_0x0048:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.identifier.IdentifierManager.c.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public c(Flow flow) {
            this.a = flow;
        }

        public Object collect(FlowCollector flowCollector, Continuation continuation) {
            Object collect = this.a.collect(new a(flowCollector), continuation);
            if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return collect;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: SafeCollector.common.kt */
    public static final class d implements Flow<Identifier> {
        final /* synthetic */ Flow a;
        final /* synthetic */ Context b;

        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Collect.kt */
        public static final class a implements FlowCollector<s> {
            final /* synthetic */ FlowCollector a;
            final /* synthetic */ Context b;

            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
            @DebugMetadata(c = "com.wortise.ads.identifier.IdentifierManager$load$$inlined$mapTry$1$2", f = "IdentifierManager.kt", i = {0}, l = {142, 148}, m = "emit", n = {"$this$mapNotNull_u24lambda_u2d5"}, s = {"L$0"})
            /* renamed from: com.wortise.ads.identifier.IdentifierManager$d$a$a  reason: collision with other inner class name */
            public static final class C0186a extends ContinuationImpl {
                /* synthetic */ Object a;
                int b;
                Object c;
                final /* synthetic */ a d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0186a(a aVar, Continuation continuation) {
                    super(continuation);
                    this.d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return this.d.emit((Object) null, this);
                }
            }

            public a(FlowCollector flowCollector, Context context) {
                this.a = flowCollector;
                this.b = context;
            }

            /* JADX WARNING: Removed duplicated region for block: B:17:0x003f  */
            /* JADX WARNING: Removed duplicated region for block: B:27:0x005d  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.wortise.ads.identifier.IdentifierManager.d.a.C0186a
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    com.wortise.ads.identifier.IdentifierManager$d$a$a r0 = (com.wortise.ads.identifier.IdentifierManager.d.a.C0186a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    com.wortise.ads.identifier.IdentifierManager$d$a$a r0 = new com.wortise.ads.identifier.IdentifierManager$d$a$a
                    r0.<init>(r7, r9)
                L_0x0018:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 0
                    r4 = 2
                    r5 = 1
                    if (r2 == 0) goto L_0x003f
                    if (r2 == r5) goto L_0x0035
                    if (r2 != r4) goto L_0x002d
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x0068
                L_0x002d:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0035:
                    java.lang.Object r8 = r0.c
                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                    kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x003d }
                    goto L_0x005a
                L_0x003d:
                    goto L_0x0059
                L_0x003f:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlinx.coroutines.flow.FlowCollector r9 = r7.a
                    com.wortise.ads.s r8 = (com.wortise.ads.s) r8     // Catch:{ all -> 0x0057 }
                    android.content.Context r2 = r7.b     // Catch:{ all -> 0x0057 }
                    r0.c = r9     // Catch:{ all -> 0x0057 }
                    r0.b = r5     // Catch:{ all -> 0x0057 }
                    java.lang.Object r8 = r8.b(r2, r0)     // Catch:{ all -> 0x0057 }
                    if (r8 != r1) goto L_0x0053
                    return r1
                L_0x0053:
                    r6 = r9
                    r9 = r8
                    r8 = r6
                    goto L_0x005a
                L_0x0057:
                    r8 = r9
                L_0x0059:
                    r9 = r3
                L_0x005a:
                    if (r9 != 0) goto L_0x005d
                    goto L_0x0068
                L_0x005d:
                    r0.c = r3
                    r0.b = r4
                    java.lang.Object r8 = r8.emit(r9, r0)
                    if (r8 != r1) goto L_0x0068
                    return r1
                L_0x0068:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.identifier.IdentifierManager.d.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public d(Flow flow, Context context) {
            this.a = flow;
            this.b = context;
        }

        public Object collect(FlowCollector flowCollector, Continuation continuation) {
            Object collect = this.a.collect(new a(flowCollector, this.b), continuation);
            if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return collect;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.identifier.IdentifierManager", f = "IdentifierManager.kt", i = {0}, l = {57}, m = "load", n = {"context"}, s = {"L$0"})
    /* compiled from: IdentifierManager.kt */
    static final class e extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ IdentifierManager c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(IdentifierManager identifierManager, Continuation<? super e> continuation) {
            super(continuation);
            this.c = identifierManager;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.load((Context) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u0002"}, d2 = {"com/wortise/ads/utils/JsonParser$fromJson$1", "Lcom/google/gson/reflect/TypeToken;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: JsonParser.kt */
    public static final class f extends TypeToken<Identifier> {
    }

    private IdentifierManager() {
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object load(android.content.Context r5, kotlin.coroutines.Continuation<? super com.wortise.ads.identifier.Identifier> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.wortise.ads.identifier.IdentifierManager.e
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.wortise.ads.identifier.IdentifierManager$e r0 = (com.wortise.ads.identifier.IdentifierManager.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.identifier.IdentifierManager$e r0 = new com.wortise.ads.identifier.IdentifierManager$e
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.a
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005b
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = com.wortise.ads.AdSettings.isChildDirected(r5)
            if (r6 == 0) goto L_0x0040
            r5 = 0
            return r5
        L_0x0040:
            java.util.List<com.wortise.ads.s> r6 = MODULES
            kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.asFlow(r6)
            com.wortise.ads.identifier.IdentifierManager$d r2 = new com.wortise.ads.identifier.IdentifierManager$d
            r2.<init>(r6, r5)
            com.wortise.ads.identifier.IdentifierManager$c r6 = new com.wortise.ads.identifier.IdentifierManager$c
            r6.<init>(r2)
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r6, r0)
            if (r6 != r1) goto L_0x005b
            return r1
        L_0x005b:
            r0 = r6
            com.wortise.ads.identifier.Identifier r0 = (com.wortise.ads.identifier.Identifier) r0
            com.wortise.ads.identifier.IdentifierManager r1 = INSTANCE
            r1.writeToCache(r5, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.identifier.IdentifierManager.load(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final synchronized Identifier readFromCache(Context context) {
        Identifier identifier;
        Object obj;
        identifier = null;
        try {
            try {
                String string = r5.a.a(context).getString(KEY, (String) null);
                if (string == null) {
                    obj = null;
                    identifier = (Identifier) obj;
                } else {
                    q4 q4Var = q4.a;
                    Type type = new f().getType();
                    Intrinsics.checkNotNullExpressionValue(type, "object: TypeToken<T>() {}.type");
                    obj = q4Var.a(string, type);
                    identifier = (Identifier) obj;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        return identifier;
    }

    private final synchronized boolean writeToCache(Context context, Identifier identifier) {
        boolean z;
        try {
            SharedPreferences.Editor edit = r5.a.a(context).edit();
            g6.a(edit, KEY, identifier, (Type) null, 4, (Object) null);
            edit.apply();
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        return z;
    }

    public final void clear(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        clear();
        writeToCache(context, (Identifier) null);
    }

    public final Object fetch(Context context, Continuation<? super Identifier> continuation) {
        Identifier identifier = (Identifier) getValue();
        return identifier == null ? fetchAsync(context).await(continuation) : identifier;
    }

    public final Deferred<Identifier> fetchAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return fetchAsync(new a(context, (Continuation<? super a>) null));
    }

    public final Identifier fetchSync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (Identifier) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new b(context, (Continuation<? super b>) null), 1, (Object) null);
    }

    public final Identifier get(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Identifier identifier = (Identifier) getValue();
        if (identifier != null) {
            return identifier;
        }
        Identifier readFromCache = readFromCache(context);
        if (readFromCache != null && !readFromCache.getLimitAdTracking()) {
            return readFromCache;
        }
        return null;
    }

    public final Object refresh(Context context, Continuation<? super Identifier> continuation) {
        return refreshAsync(context).await(continuation);
    }

    public final Deferred<Identifier> refreshAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IdentifierManager identifierManager = INSTANCE;
        identifierManager.clear(context);
        return identifierManager.fetchAsync(context);
    }
}
