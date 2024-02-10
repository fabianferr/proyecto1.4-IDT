package io.monedata.identifier;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.monedata.b1;
import io.monedata.r0;
import io.monedata.s0;
import io.monedata.w0;
import io.monedata.x0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006J\u001b\u0010\b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0006J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0003J$\u0010\n\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00032\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\f0\u000bR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lio/monedata/identifier/IdentifierManager;", "Lio/monedata/utils/a;", "Lio/monedata/identifier/Identifier;", "Landroid/content/Context;", "context", "doFetch", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "fetch", "Lkotlinx/coroutines/Deferred;", "fetchAsync", "Lkotlin/Function1;", "", "listener", "", "Lio/monedata/x0;", "IMPLEMENTATIONS", "Ljava/util/List;", "", "getId", "()Ljava/lang/String;", "id", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class IdentifierManager extends io.monedata.utils.a<Identifier> {
    private static final List<x0> IMPLEMENTATIONS = CollectionsKt.listOf(r0.a, w0.a, io.monedata.e.a, s0.a, b1.a);
    public static final IdentifierManager INSTANCE = new IdentifierManager();

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 7, 1})
    public static final class a implements Flow<Identifier> {
        final /* synthetic */ Flow a;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: io.monedata.identifier.IdentifierManager$a$a  reason: collision with other inner class name */
        public static final class C0205a<T> implements FlowCollector {
            final /* synthetic */ FlowCollector a;

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            @DebugMetadata(c = "io.monedata.identifier.IdentifierManager$doFetch$$inlined$filterNot$1$2", f = "IdentifierManager.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
            /* renamed from: io.monedata.identifier.IdentifierManager$a$a$a  reason: collision with other inner class name */
            public static final class C0206a extends ContinuationImpl {
                /* synthetic */ Object a;
                int b;
                final /* synthetic */ C0205a c;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0206a(C0205a aVar, Continuation continuation) {
                    super(continuation);
                    this.c = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return this.c.emit((Object) null, this);
                }
            }

            public C0205a(FlowCollector flowCollector) {
                this.a = flowCollector;
            }

            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof io.monedata.identifier.IdentifierManager.a.C0205a.C0206a
                    if (r0 == 0) goto L_0x0013
                    r0 = r6
                    io.monedata.identifier.IdentifierManager$a$a$a r0 = (io.monedata.identifier.IdentifierManager.a.C0205a.C0206a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    io.monedata.identifier.IdentifierManager$a$a$a r0 = new io.monedata.identifier.IdentifierManager$a$a$a
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
                    io.monedata.identifier.Identifier r2 = (io.monedata.identifier.Identifier) r2
                    boolean r2 = r2.isLimitAdTrackingEnabled()
                    if (r2 != 0) goto L_0x0048
                    r0.b = r3
                    java.lang.Object r5 = r6.emit(r5, r0)
                    if (r5 != r1) goto L_0x0048
                    return r1
                L_0x0048:
                    kotlin.Unit r5 = kotlin.Unit.INSTANCE
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: io.monedata.identifier.IdentifierManager.a.C0205a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public a(Flow flow) {
            this.a = flow;
        }

        public Object collect(FlowCollector flowCollector, Continuation continuation) {
            Object collect = this.a.collect(new C0205a(flowCollector), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "io/monedata/extensions/SafeMapKt$mapTry$$inlined$mapNotNull$1"}, k = 1, mv = {1, 7, 1})
    public static final class b implements Flow<Identifier> {
        final /* synthetic */ Flow a;
        final /* synthetic */ Context b;

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1$2", "io/monedata/extensions/SafeMapKt$mapTry$$inlined$mapNotNull$1$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class a<T> implements FlowCollector {
            final /* synthetic */ FlowCollector a;
            final /* synthetic */ Context b;

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            @DebugMetadata(c = "io.monedata.identifier.IdentifierManager$doFetch$$inlined$mapTry$1$2", f = "IdentifierManager.kt", i = {0}, l = {227, 228}, m = "emit", n = {"$this$mapNotNull_u24lambda_u2d5"}, s = {"L$0"})
            /* renamed from: io.monedata.identifier.IdentifierManager$b$a$a  reason: collision with other inner class name */
            public static final class C0207a extends ContinuationImpl {
                /* synthetic */ Object a;
                int b;
                Object c;
                final /* synthetic */ a d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0207a(a aVar, Continuation continuation) {
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

            /* JADX WARNING: Removed duplicated region for block: B:17:0x003e  */
            /* JADX WARNING: Removed duplicated region for block: B:30:0x0071  */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x0074  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r7, kotlin.coroutines.Continuation r8) {
                /*
                    r6 = this;
                    boolean r0 = r8 instanceof io.monedata.identifier.IdentifierManager.b.a.C0207a
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    io.monedata.identifier.IdentifierManager$b$a$a r0 = (io.monedata.identifier.IdentifierManager.b.a.C0207a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    io.monedata.identifier.IdentifierManager$b$a$a r0 = new io.monedata.identifier.IdentifierManager$b$a$a
                    r0.<init>(r6, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003e
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r8)
                    goto L_0x007f
                L_0x002c:
                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                    java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                    r7.<init>(r8)
                    throw r7
                L_0x0034:
                    java.lang.Object r7 = r0.c
                    kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
                    kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x003c }
                    goto L_0x0057
                L_0x003c:
                    r8 = move-exception
                    goto L_0x0060
                L_0x003e:
                    kotlin.ResultKt.throwOnFailure(r8)
                    kotlinx.coroutines.flow.FlowCollector r8 = r6.a
                    kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x005c }
                    io.monedata.x0 r7 = (io.monedata.x0) r7     // Catch:{ all -> 0x005c }
                    android.content.Context r2 = r6.b     // Catch:{ all -> 0x005c }
                    r0.c = r8     // Catch:{ all -> 0x005c }
                    r0.b = r4     // Catch:{ all -> 0x005c }
                    java.lang.Object r7 = r7.a(r2, r0)     // Catch:{ all -> 0x005c }
                    if (r7 != r1) goto L_0x0054
                    return r1
                L_0x0054:
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L_0x0057:
                    java.lang.Object r8 = kotlin.Result.m2344constructorimpl(r8)     // Catch:{ all -> 0x003c }
                    goto L_0x006a
                L_0x005c:
                    r7 = move-exception
                    r5 = r8
                    r8 = r7
                    r7 = r5
                L_0x0060:
                    kotlin.Result$Companion r2 = kotlin.Result.Companion
                    java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
                    java.lang.Object r8 = kotlin.Result.m2344constructorimpl(r8)
                L_0x006a:
                    boolean r2 = kotlin.Result.m2350isFailureimpl(r8)
                    r4 = 0
                    if (r2 == 0) goto L_0x0072
                    r8 = r4
                L_0x0072:
                    if (r8 == 0) goto L_0x007f
                    r0.c = r4
                    r0.b = r3
                    java.lang.Object r7 = r7.emit(r8, r0)
                    if (r7 != r1) goto L_0x007f
                    return r1
                L_0x007f:
                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                    return r7
                */
                throw new UnsupportedOperationException("Method not decompiled: io.monedata.identifier.IdentifierManager.b.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public b(Flow flow, Context context) {
            this.a = flow;
            this.b = context;
        }

        public Object collect(FlowCollector flowCollector, Continuation continuation) {
            Object collect = this.a.collect(new a(flowCollector, this.b), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lio/monedata/identifier/Identifier;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.identifier.IdentifierManager$fetchAsync$1", f = "IdentifierManager.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function1<Continuation<? super Identifier>, Object> {
        int a;
        final /* synthetic */ Context b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Context context, Continuation<? super c> continuation) {
            super(1, continuation);
            this.b = context;
        }

        /* renamed from: a */
        public final Object invoke(Continuation<? super Identifier> continuation) {
            return ((c) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new c(this.b, continuation);
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

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "it", "", "a", "(Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 7, 1})
    static final class d extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ Function1<Identifier, Unit> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Function1<? super Identifier, Unit> function1) {
            super(1);
            this.a = function1;
        }

        public final void a(Throwable th) {
            this.a.invoke(IdentifierManager.INSTANCE.getValue());
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.identifier.IdentifierManager", f = "IdentifierManager.kt", i = {}, l = {41}, m = "load", n = {}, s = {})
    static final class e extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ IdentifierManager b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(IdentifierManager identifierManager, Continuation<? super e> continuation) {
            super(continuation);
            this.b = identifierManager;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.load((Context) null, this);
        }
    }

    private IdentifierManager() {
    }

    /* access modifiers changed from: private */
    public final Object doFetch(Context context, Continuation<? super Identifier> continuation) {
        return FlowKt.first(new a(new b(FlowKt.asFlow(IMPLEMENTATIONS), context)), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object load(android.content.Context r5, kotlin.coroutines.Continuation<? super io.monedata.identifier.Identifier> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.monedata.identifier.IdentifierManager.e
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.monedata.identifier.IdentifierManager$e r0 = (io.monedata.identifier.IdentifierManager.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.identifier.IdentifierManager$e r0 = new io.monedata.identifier.IdentifierManager$e
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x003d
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.c = r3
            java.lang.Object r6 = r4.doFetch(r5, r0)
            if (r6 != r1) goto L_0x003d
            return r1
        L_0x003d:
            r5 = r6
            io.monedata.identifier.Identifier r5 = (io.monedata.identifier.Identifier) r5
            io.monedata.MonedataLog r0 = io.monedata.MonedataLog.INSTANCE
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Fetched identifier: "
            r1.<init>(r2)
            java.lang.String r5 = r5.getId()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r1 = 2
            r2 = 0
            io.monedata.MonedataLog.d$default((io.monedata.MonedataLog) r0, (java.lang.String) r5, (java.lang.Throwable) r2, (int) r1, (java.lang.Object) r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.identifier.IdentifierManager.load(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object fetch(Context context, Continuation<? super Identifier> continuation) {
        return fetchAsync(context).await(continuation);
    }

    public final Deferred<Identifier> fetchAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return fetchAsync(new c(context, (Continuation<? super c>) null));
    }

    public final void fetchAsync(Context context, Function1<? super Identifier, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        fetchAsync(context).invokeOnCompletion(new d(function1));
    }

    public final String getId() {
        Identifier identifier = (Identifier) getValue();
        if (identifier != null) {
            return identifier.getId();
        }
        return null;
    }
}
