package com.wortise.ads;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.google.common.util.concurrent.ListenableFuture;
import com.wortise.ads.o5;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(bv = {}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B7\u0012\u000e\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010+\u001a\u00020*¢\u0006\u0004\b,\u0010-J!\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000bJ\u001d\u0010\b\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\rJ\u0013\u0010\b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u000eJ\u001b\u0010\b\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0014¢\u0006\u0004\b\b\u0010\u0010J!\u0010\b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0012\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\b\u0010\u0013R\u001b\u0010\u0018\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001a\u001a\u00020\u00198\u0014X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0014X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u0002\u0004\n\u0002\b\u0019¨\u0006."}, d2 = {"Lcom/wortise/ads/j0;", "Lcom/wortise/ads/o5;", "T", "Lcom/wortise/ads/p0;", "config", "Lcom/wortise/ads/p5;", "info", "Landroidx/work/PeriodicWorkRequest;", "a", "(Lcom/wortise/ads/o5;Lcom/wortise/ads/p5;)Landroidx/work/PeriodicWorkRequest;", "", "(Lcom/wortise/ads/p5;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lcom/wortise/ads/o5;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/Data;", "(Lcom/wortise/ads/o5;)Landroidx/work/Data;", "", "interval", "(Lcom/wortise/ads/o5;J)Lcom/wortise/ads/p5;", "defaultInterval$delegate", "Lkotlin/Lazy;", "f", "()J", "defaultInterval", "Landroidx/work/Constraints;", "constraints", "Landroidx/work/Constraints;", "e", "()Landroidx/work/Constraints;", "Landroidx/work/ExistingPeriodicWorkPolicy;", "existingWorkPolicy", "Landroidx/work/ExistingPeriodicWorkPolicy;", "g", "()Landroidx/work/ExistingPeriodicWorkPolicy;", "Lkotlin/reflect/KClass;", "Landroidx/work/ListenableWorker;", "clazz", "Landroid/content/Context;", "context", "", "name", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "<init>", "(Lkotlin/reflect/KClass;Landroid/content/Context;Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BasePeriodicWorkerJob.kt */
public abstract class j0<T extends o5> extends p0<T> {
    private final Lazy d;
    private final Constraints e;
    private final ExistingPeriodicWorkPolicy f = ExistingPeriodicWorkPolicy.KEEP;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0003\u001a\u00020\u0002\"\b\b\u0000\u0010\u0001*\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/o5;", "T", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: BasePeriodicWorkerJob.kt */
    static final class a extends Lambda implements Function0<Long> {
        final /* synthetic */ TimeUnit a;
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(TimeUnit timeUnit, long j) {
            super(0);
            this.a = timeUnit;
            this.b = j;
        }

        /* renamed from: a */
        public final Long invoke() {
            return Long.valueOf(this.a.toMinutes(this.b));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¨\u0006\u0002"}, d2 = {"R", "", "androidx/work/ListenableFutureKt$await$2$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ListenableFuture.kt */
    public static final class b implements Runnable {
        final /* synthetic */ CancellableContinuation a;
        final /* synthetic */ ListenableFuture b;

        public b(CancellableContinuation cancellableContinuation, ListenableFuture listenableFuture) {
            this.a = cancellableContinuation;
            this.b = listenableFuture;
        }

        public final void run() {
            try {
                CancellableContinuation cancellableContinuation = this.a;
                Object obj = this.b.get();
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m2344constructorimpl(obj));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    cause = th;
                }
                if (th instanceof CancellationException) {
                    this.a.cancel(cause);
                    return;
                }
                CancellableContinuation cancellableContinuation2 = this.a;
                Result.Companion companion2 = Result.Companion;
                cancellableContinuation2.resumeWith(Result.m2344constructorimpl(ResultKt.createFailure(cause)));
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¨\u0006\u0004"}, d2 = {"R", "", "it", "", "androidx/work/ListenableFutureKt$await$2$2", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ListenableFuture.kt */
    static final class c extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ ListenableFuture a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ListenableFuture listenableFuture) {
            super(1);
            this.a = listenableFuture;
        }

        public final void a(Throwable th) {
            this.a.cancel(false);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.jobs.bases.BasePeriodicWorkerJob", f = "BasePeriodicWorkerJob.kt", i = {0, 0}, l = {82}, m = "isScheduled", n = {"info", "$this$await$iv"}, s = {"L$0", "L$1"})
    /* compiled from: BasePeriodicWorkerJob.kt */
    static final class d extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ j0<T> d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(j0<T> j0Var, Continuation<? super d> continuation) {
            super(continuation);
            this.d = j0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a((p5) null, (Continuation<? super Boolean>) this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.jobs.bases.BasePeriodicWorkerJob", f = "BasePeriodicWorkerJob.kt", i = {0, 0, 0, 1}, l = {35, 83}, m = "onStart$suspendImpl", n = {"this", "config", "info", "$this$await$iv$iv"}, s = {"L$0", "L$1", "L$2", "L$0"})
    /* compiled from: BasePeriodicWorkerJob.kt */
    static final class e extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        final /* synthetic */ j0<T> e;
        int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(j0<T> j0Var, Continuation<? super e> continuation) {
            super(continuation);
            this.e = j0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return j0.a((j0) this.e, (o5) null, (Continuation) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¨\u0006\u0002"}, d2 = {"R", "", "androidx/work/ListenableFutureKt$await$2$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ListenableFuture.kt */
    public static final class f implements Runnable {
        final /* synthetic */ CancellableContinuation a;
        final /* synthetic */ ListenableFuture b;

        public f(CancellableContinuation cancellableContinuation, ListenableFuture listenableFuture) {
            this.a = cancellableContinuation;
            this.b = listenableFuture;
        }

        public final void run() {
            try {
                CancellableContinuation cancellableContinuation = this.a;
                Object obj = this.b.get();
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m2344constructorimpl(obj));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    cause = th;
                }
                if (th instanceof CancellationException) {
                    this.a.cancel(cause);
                    return;
                }
                CancellableContinuation cancellableContinuation2 = this.a;
                Result.Companion companion2 = Result.Companion;
                cancellableContinuation2.resumeWith(Result.m2344constructorimpl(ResultKt.createFailure(cause)));
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¨\u0006\u0004"}, d2 = {"R", "", "it", "", "androidx/work/ListenableFutureKt$await$2$2", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ListenableFuture.kt */
    static final class g extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ ListenableFuture a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(ListenableFuture listenableFuture) {
            super(1);
            this.a = listenableFuture;
        }

        public final void a(Throwable th) {
            this.a.cancel(false);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.jobs.bases.BasePeriodicWorkerJob", f = "BasePeriodicWorkerJob.kt", i = {0}, l = {83}, m = "onStop$suspendImpl", n = {"$this$await$iv$iv"}, s = {"L$0"})
    /* compiled from: BasePeriodicWorkerJob.kt */
    static final class h extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ j0<T> c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(j0<T> j0Var, Continuation<? super h> continuation) {
            super(continuation);
            this.c = j0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return j0.a((j0) this.c, (Continuation) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¨\u0006\u0002"}, d2 = {"R", "", "androidx/work/ListenableFutureKt$await$2$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ListenableFuture.kt */
    public static final class i implements Runnable {
        final /* synthetic */ CancellableContinuation a;
        final /* synthetic */ ListenableFuture b;

        public i(CancellableContinuation cancellableContinuation, ListenableFuture listenableFuture) {
            this.a = cancellableContinuation;
            this.b = listenableFuture;
        }

        public final void run() {
            try {
                CancellableContinuation cancellableContinuation = this.a;
                Object obj = this.b.get();
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m2344constructorimpl(obj));
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    cause = th;
                }
                if (th instanceof CancellationException) {
                    this.a.cancel(cause);
                    return;
                }
                CancellableContinuation cancellableContinuation2 = this.a;
                Result.Companion companion2 = Result.Companion;
                cancellableContinuation2.resumeWith(Result.m2344constructorimpl(ResultKt.createFailure(cause)));
            }
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¨\u0006\u0004"}, d2 = {"R", "", "it", "", "androidx/work/ListenableFutureKt$await$2$2", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ListenableFuture.kt */
    static final class j extends Lambda implements Function1<Throwable, Unit> {
        final /* synthetic */ ListenableFuture a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(ListenableFuture listenableFuture) {
            super(1);
            this.a = listenableFuture;
        }

        public final void a(Throwable th) {
            this.a.cancel(false);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j0(KClass<? extends ListenableWorker> kClass, Context context, String str, long j2, TimeUnit timeUnit) {
        super(context, str, kClass);
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        this.d = LazyKt.lazy(new a(timeUnit, j2));
        Constraints build = new Constraints.Builder().build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder().build()");
        this.e = build;
    }

    private final long f() {
        return ((Number) this.d.getValue()).longValue();
    }

    /* access modifiers changed from: protected */
    public Data a(T t) {
        return null;
    }

    /* access modifiers changed from: protected */
    public Object a(T t, Continuation<? super Unit> continuation) {
        return a(this, (o5) t, (Continuation) continuation);
    }

    /* access modifiers changed from: protected */
    public Object a(Continuation<? super Unit> continuation) {
        return a(this, (Continuation) continuation);
    }

    /* access modifiers changed from: protected */
    public Constraints e() {
        return this.e;
    }

    /* access modifiers changed from: protected */
    public ExistingPeriodicWorkPolicy g() {
        return this.f;
    }

    /* JADX WARNING: type inference failed for: r10v7, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0 A[SYNTHETIC, Splitter:B:34:0x00c0] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object a(com.wortise.ads.j0 r9, com.wortise.ads.o5 r10, kotlin.coroutines.Continuation r11) {
        /*
            boolean r0 = r11 instanceof com.wortise.ads.j0.e
            if (r0 == 0) goto L_0x0013
            r0 = r11
            com.wortise.ads.j0$e r0 = (com.wortise.ads.j0.e) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.j0$e r0 = new com.wortise.ads.j0$e
            r0.<init>(r9, r11)
        L_0x0018:
            java.lang.Object r11 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x004a
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r9 = r0.a
            com.google.common.util.concurrent.ListenableFuture r9 = (com.google.common.util.concurrent.ListenableFuture) r9
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0105
        L_0x0032:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003a:
            java.lang.Object r9 = r0.c
            com.wortise.ads.p5 r9 = (com.wortise.ads.p5) r9
            java.lang.Object r10 = r0.b
            com.wortise.ads.o5 r10 = (com.wortise.ads.o5) r10
            java.lang.Object r2 = r0.a
            com.wortise.ads.j0 r2 = (com.wortise.ads.j0) r2
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x007f
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r11)
            if (r10 != 0) goto L_0x0051
            r11 = r5
            goto L_0x0055
        L_0x0051:
            java.lang.Long r11 = r10.b()
        L_0x0055:
            if (r11 != 0) goto L_0x005c
            long r6 = r9.f()
            goto L_0x0060
        L_0x005c:
            long r6 = r11.longValue()
        L_0x0060:
            com.wortise.ads.p5 r11 = r9.a(r10, (long) r6)
            androidx.work.ExistingPeriodicWorkPolicy r2 = r9.g()
            androidx.work.ExistingPeriodicWorkPolicy r6 = androidx.work.ExistingPeriodicWorkPolicy.KEEP
            if (r2 != r6) goto L_0x0099
            r0.a = r9
            r0.b = r10
            r0.c = r11
            r0.f = r4
            java.lang.Object r2 = r9.a((com.wortise.ads.p5) r11, (kotlin.coroutines.Continuation<? super java.lang.Boolean>) r0)
            if (r2 != r1) goto L_0x007b
            return r1
        L_0x007b:
            r8 = r2
            r2 = r9
            r9 = r11
            r11 = r8
        L_0x007f:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L_0x0097
            java.lang.String r9 = r2.b()
            java.lang.String r10 = " periodic job is already scheduled"
            java.lang.String r9 = kotlin.jvm.internal.Intrinsics.stringPlus(r9, r10)
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r9, (java.lang.Throwable) r5, (int) r3, (java.lang.Object) r5)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0097:
            r11 = r9
            r9 = r2
        L_0x0099:
            androidx.work.PeriodicWorkRequest r10 = r9.a(r10, (com.wortise.ads.p5) r11)
            androidx.work.WorkManager r11 = r9.d()
            java.lang.String r9 = r9.b()
            androidx.work.ExistingPeriodicWorkPolicy r2 = androidx.work.ExistingPeriodicWorkPolicy.REPLACE
            androidx.work.Operation r9 = r11.enqueueUniquePeriodicWork(r9, r2, r10)
            java.lang.String r10 = "workManager.enqueueUniqu…k(name, REPLACE, request)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            com.google.common.util.concurrent.ListenableFuture r9 = r9.getResult()
            java.lang.String r10 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
            boolean r10 = r9.isDone()
            if (r10 == 0) goto L_0x00cf
            java.lang.Object r11 = r9.get()     // Catch:{ ExecutionException -> 0x00c5 }
            goto L_0x0105
        L_0x00c5:
            r9 = move-exception
            java.lang.Throwable r10 = r9.getCause()
            if (r10 != 0) goto L_0x00cd
            goto L_0x00ce
        L_0x00cd:
            r9 = r10
        L_0x00ce:
            throw r9
        L_0x00cf:
            r0.a = r9
            r0.b = r5
            r0.c = r5
            r0.f = r3
            kotlinx.coroutines.CancellableContinuationImpl r10 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r11 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r10.<init>(r11, r4)
            r10.initCancellability()
            com.wortise.ads.j0$f r11 = new com.wortise.ads.j0$f
            r11.<init>(r10, r9)
            androidx.work.DirectExecutor r2 = androidx.work.DirectExecutor.INSTANCE
            r9.addListener(r11, r2)
            com.wortise.ads.j0$g r11 = new com.wortise.ads.j0$g
            r11.<init>(r9)
            r10.invokeOnCancellation(r11)
            java.lang.Object r11 = r10.getResult()
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r11 != r9) goto L_0x0102
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0102:
            if (r11 != r1) goto L_0x0105
            return r1
        L_0x0105:
            java.lang.String r9 = "result.await()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r9)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.j0.a(com.wortise.ads.j0, com.wortise.ads.o5, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r5v9, types: [java.lang.Throwable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object a(com.wortise.ads.j0 r4, kotlin.coroutines.Continuation r5) {
        /*
            boolean r0 = r5 instanceof com.wortise.ads.j0.h
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.wortise.ads.j0$h r0 = (com.wortise.ads.j0.h) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.j0$h r0 = new com.wortise.ads.j0$h
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.a
            com.google.common.util.concurrent.ListenableFuture r4 = (com.google.common.util.concurrent.ListenableFuture) r4
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x009a
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.work.WorkManager r5 = r4.d()
            java.lang.String r4 = r4.b()
            androidx.work.Operation r4 = r5.cancelUniqueWork(r4)
            java.lang.String r5 = "workManager.cancelUniqueWork(name)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.google.common.util.concurrent.ListenableFuture r4 = r4.getResult()
            java.lang.String r5 = "result"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            boolean r5 = r4.isDone()
            if (r5 == 0) goto L_0x0068
            java.lang.Object r5 = r4.get()     // Catch:{ ExecutionException -> 0x005e }
            goto L_0x009a
        L_0x005e:
            r4 = move-exception
            java.lang.Throwable r5 = r4.getCause()
            if (r5 != 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r4 = r5
        L_0x0067:
            throw r4
        L_0x0068:
            r0.a = r4
            r0.d = r3
            kotlinx.coroutines.CancellableContinuationImpl r5 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r5.<init>(r2, r3)
            r5.initCancellability()
            com.wortise.ads.j0$i r2 = new com.wortise.ads.j0$i
            r2.<init>(r5, r4)
            androidx.work.DirectExecutor r3 = androidx.work.DirectExecutor.INSTANCE
            r4.addListener(r2, r3)
            com.wortise.ads.j0$j r2 = new com.wortise.ads.j0$j
            r2.<init>(r4)
            r5.invokeOnCancellation(r2)
            java.lang.Object r5 = r5.getResult()
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r5 != r4) goto L_0x0097
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0097:
            if (r5 != r1) goto L_0x009a
            return r1
        L_0x009a:
            java.lang.String r4 = "result.await()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.j0.a(com.wortise.ads.j0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final PeriodicWorkRequest a(T t, p5 p5Var) {
        WorkRequest.Builder constraints = ((PeriodicWorkRequest.Builder) ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(JvmClassMappingKt.getJavaClass(c()), p5Var.a(), TimeUnit.MINUTES).addTag(b())).addTag(p5Var.b())).setConstraints(e());
        Intrinsics.checkNotNullExpressionValue(constraints, "Builder(clazz.java, info…tConstraints(constraints)");
        PeriodicWorkRequest.Builder builder = (PeriodicWorkRequest.Builder) constraints;
        Data a2 = a(t);
        if (a2 != null) {
            PeriodicWorkRequest.Builder builder2 = (PeriodicWorkRequest.Builder) builder.setInputData(a2);
        }
        WorkRequest build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return (PeriodicWorkRequest) build;
    }

    /* JADX WARNING: type inference failed for: r7v8, types: [java.lang.Throwable] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ae A[LOOP:0: B:27:0x00a8->B:29:0x00ae, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(com.wortise.ads.p5 r6, kotlin.coroutines.Continuation<? super java.lang.Boolean> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.wortise.ads.j0.d
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.j0$d r0 = (com.wortise.ads.j0.d) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.j0$d r0 = new com.wortise.ads.j0$d
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r6 = r0.b
            com.google.common.util.concurrent.ListenableFuture r6 = (com.google.common.util.concurrent.ListenableFuture) r6
            java.lang.Object r6 = r0.a
            com.wortise.ads.p5 r6 = (com.wortise.ads.p5) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0097
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            androidx.work.WorkManager r7 = r5.d()
            java.lang.String r2 = r5.b()
            com.google.common.util.concurrent.ListenableFuture r7 = r7.getWorkInfosForUniqueWork(r2)
            java.lang.String r2 = "workManager.getWorkInfosForUniqueWork(name)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            boolean r2 = r7.isDone()
            if (r2 == 0) goto L_0x0063
            java.lang.Object r7 = r7.get()     // Catch:{ ExecutionException -> 0x0059 }
            goto L_0x0097
        L_0x0059:
            r6 = move-exception
            java.lang.Throwable r7 = r6.getCause()
            if (r7 != 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r6 = r7
        L_0x0062:
            throw r6
        L_0x0063:
            r0.a = r6
            r0.b = r7
            r0.e = r3
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
            r2.<init>(r4, r3)
            r2.initCancellability()
            com.wortise.ads.j0$b r3 = new com.wortise.ads.j0$b
            r3.<init>(r2, r7)
            androidx.work.DirectExecutor r4 = androidx.work.DirectExecutor.INSTANCE
            r7.addListener(r3, r4)
            com.wortise.ads.j0$c r3 = new com.wortise.ads.j0$c
            r3.<init>(r7)
            r2.invokeOnCancellation(r3)
            java.lang.Object r7 = r2.getResult()
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r7 != r2) goto L_0x0094
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x0094:
            if (r7 != r1) goto L_0x0097
            return r1
        L_0x0097:
            java.lang.String r0 = "workManager.getWorkInfos…\n                .await()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x00a8:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00c1
            java.lang.Object r1 = r7.next()
            androidx.work.WorkInfo r1 = (androidx.work.WorkInfo) r1
            java.util.Set r1 = r1.getTags()
            java.lang.String r2 = "it.tags"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            kotlin.collections.CollectionsKt.addAll(r0, r1)
            goto L_0x00a8
        L_0x00c1:
            java.lang.String r6 = r6.b()
            boolean r6 = r0.contains(r6)
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.j0.a(com.wortise.ads.p5, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public p5 a(T t, long j2) {
        return new p5(j2);
    }
}
