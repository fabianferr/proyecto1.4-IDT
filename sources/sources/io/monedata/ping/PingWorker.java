package io.monedata.ping;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.facebook.internal.NativeProtocol;
import com.google.common.util.concurrent.ListenableFuture;
import io.monedata.e0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lio/monedata/ping/PingWorker;", "Landroidx/work/CoroutineWorker;", "", "assetKey", "", "a", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/ListenableWorker$Result;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class PingWorker extends CoroutineWorker {
    public static final a a = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Constraints b = e0.a(new Constraints.Builder()).build();

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\r8\u0002XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lio/monedata/ping/PingWorker$a;", "", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "interval", "(Landroid/content/Context;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/Constraints;", "CONSTRAINTS", "Landroidx/work/Constraints;", "", "WORK_NAME", "Ljava/lang/String;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
    public static final class a {

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "R", "run", "androidx/work/ListenableFutureKt$await$2$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: io.monedata.ping.PingWorker$a$a  reason: collision with other inner class name */
        public static final class C0209a implements Runnable {
            final /* synthetic */ CancellableContinuation a;
            final /* synthetic */ ListenableFuture b;

            public C0209a(CancellableContinuation cancellableContinuation, ListenableFuture listenableFuture) {
                this.a = cancellableContinuation;
                this.b = listenableFuture;
            }

            public final void run() {
                try {
                    CancellableContinuation cancellableContinuation = this.a;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m2344constructorimpl(this.b.get()));
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

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"R", "", "it", "", "a", "(Ljava/lang/Throwable;)V", "androidx/work/ListenableFutureKt$await$2$2"}, k = 3, mv = {1, 7, 1})
        static final class b extends Lambda implements Function1<Throwable, Unit> {
            final /* synthetic */ ListenableFuture a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(ListenableFuture listenableFuture) {
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

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "io.monedata.ping.PingWorker$Companion", f = "PingWorker.kt", i = {0}, l = {103}, m = "cancel", n = {"$this$await$iv$iv"}, s = {"L$0"})
        static final class c extends ContinuationImpl {
            Object a;
            /* synthetic */ Object b;
            final /* synthetic */ a c;
            int d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(a aVar, Continuation<? super c> continuation) {
                super(continuation);
                this.c = aVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.d |= Integer.MIN_VALUE;
                return this.c.a((Context) null, this);
            }
        }

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "R", "run", "androidx/work/ListenableFutureKt$await$2$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class d implements Runnable {
            final /* synthetic */ CancellableContinuation a;
            final /* synthetic */ ListenableFuture b;

            public d(CancellableContinuation cancellableContinuation, ListenableFuture listenableFuture) {
                this.a = cancellableContinuation;
                this.b = listenableFuture;
            }

            public final void run() {
                try {
                    CancellableContinuation cancellableContinuation = this.a;
                    Result.Companion companion = Result.Companion;
                    cancellableContinuation.resumeWith(Result.m2344constructorimpl(this.b.get()));
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

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"R", "", "it", "", "a", "(Ljava/lang/Throwable;)V", "androidx/work/ListenableFutureKt$await$2$2"}, k = 3, mv = {1, 7, 1})
        static final class e extends Lambda implements Function1<Throwable, Unit> {
            final /* synthetic */ ListenableFuture a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(ListenableFuture listenableFuture) {
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

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        @DebugMetadata(c = "io.monedata.ping.PingWorker$Companion", f = "PingWorker.kt", i = {0}, l = {104}, m = "enqueue", n = {"$this$await$iv$iv"}, s = {"L$0"})
        static final class f extends ContinuationImpl {
            Object a;
            /* synthetic */ Object b;
            final /* synthetic */ a c;
            int d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(a aVar, Continuation<? super f> continuation) {
                super(continuation);
                this.c = aVar;
            }

            public final Object invokeSuspend(Object obj) {
                this.b = obj;
                this.d |= Integer.MIN_VALUE;
                return this.c.a((Context) null, 0, this);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: type inference failed for: r7v9, types: [java.lang.Throwable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(android.content.Context r6, long r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
            /*
                r5 = this;
                boolean r0 = r9 instanceof io.monedata.ping.PingWorker.a.f
                if (r0 == 0) goto L_0x0013
                r0 = r9
                io.monedata.ping.PingWorker$a$f r0 = (io.monedata.ping.PingWorker.a.f) r0
                int r1 = r0.d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.d = r1
                goto L_0x0018
            L_0x0013:
                io.monedata.ping.PingWorker$a$f r0 = new io.monedata.ping.PingWorker$a$f
                r0.<init>(r5, r9)
            L_0x0018:
                java.lang.Object r9 = r0.b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.d
                r3 = 1
                if (r2 == 0) goto L_0x0036
                if (r2 != r3) goto L_0x002e
                java.lang.Object r6 = r0.a
                com.google.common.util.concurrent.ListenableFuture r6 = (com.google.common.util.concurrent.ListenableFuture) r6
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x00b2
            L_0x002e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0036:
                kotlin.ResultKt.throwOnFailure(r9)
                java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MINUTES
                androidx.work.PeriodicWorkRequest$Builder r2 = new androidx.work.PeriodicWorkRequest$Builder
                java.lang.Class<io.monedata.ping.PingWorker> r4 = io.monedata.ping.PingWorker.class
                r2.<init>((java.lang.Class<? extends androidx.work.ListenableWorker>) r4, (long) r7, (java.util.concurrent.TimeUnit) r9)
                androidx.work.Constraints r7 = io.monedata.ping.PingWorker.b
                androidx.work.WorkRequest$Builder r7 = r2.setConstraints(r7)
                androidx.work.PeriodicWorkRequest$Builder r7 = (androidx.work.PeriodicWorkRequest.Builder) r7
                androidx.work.WorkRequest r7 = r7.build()
                androidx.work.PeriodicWorkRequest r7 = (androidx.work.PeriodicWorkRequest) r7
                androidx.work.WorkManager r6 = io.monedata.c2.a(r6)
                if (r6 == 0) goto L_0x00ba
                androidx.work.ExistingPeriodicWorkPolicy r8 = androidx.work.ExistingPeriodicWorkPolicy.CANCEL_AND_REENQUEUE
                java.lang.String r9 = "io.monedata.ping.PingWorker"
                androidx.work.Operation r6 = r6.enqueueUniquePeriodicWork(r9, r8, r7)
                if (r6 == 0) goto L_0x00ba
                com.google.common.util.concurrent.ListenableFuture r6 = r6.getResult()
                java.lang.String r7 = "result"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                boolean r7 = r6.isDone()
                if (r7 == 0) goto L_0x0080
                java.lang.Object r9 = r6.get()     // Catch:{ ExecutionException -> 0x0076 }
                goto L_0x00b2
            L_0x0076:
                r6 = move-exception
                java.lang.Throwable r7 = r6.getCause()
                if (r7 != 0) goto L_0x007e
                goto L_0x007f
            L_0x007e:
                r6 = r7
            L_0x007f:
                throw r6
            L_0x0080:
                r0.a = r6
                r0.d = r3
                kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
                kotlin.coroutines.Continuation r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
                r7.<init>(r8, r3)
                r7.initCancellability()
                io.monedata.ping.PingWorker$a$d r8 = new io.monedata.ping.PingWorker$a$d
                r8.<init>(r7, r6)
                androidx.work.DirectExecutor r9 = androidx.work.DirectExecutor.INSTANCE
                r6.addListener(r8, r9)
                io.monedata.ping.PingWorker$a$e r8 = new io.monedata.ping.PingWorker$a$e
                r8.<init>(r6)
                r7.invokeOnCancellation(r8)
                java.lang.Object r9 = r7.getResult()
                java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r9 != r6) goto L_0x00af
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
            L_0x00af:
                if (r9 != r1) goto L_0x00b2
                return r1
            L_0x00b2:
                java.lang.String r6 = "result.await()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            L_0x00ba:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: io.monedata.ping.PingWorker.a.a(android.content.Context, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: type inference failed for: r6v8, types: [java.lang.Throwable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(android.content.Context r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof io.monedata.ping.PingWorker.a.c
                if (r0 == 0) goto L_0x0013
                r0 = r6
                io.monedata.ping.PingWorker$a$c r0 = (io.monedata.ping.PingWorker.a.c) r0
                int r1 = r0.d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.d = r1
                goto L_0x0018
            L_0x0013:
                io.monedata.ping.PingWorker$a$c r0 = new io.monedata.ping.PingWorker$a$c
                r0.<init>(r4, r6)
            L_0x0018:
                java.lang.Object r6 = r0.b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.d
                r3 = 1
                if (r2 == 0) goto L_0x0035
                if (r2 != r3) goto L_0x002d
                java.lang.Object r5 = r0.a
                com.google.common.util.concurrent.ListenableFuture r5 = (com.google.common.util.concurrent.ListenableFuture) r5
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x0096
            L_0x002d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0035:
                kotlin.ResultKt.throwOnFailure(r6)
                androidx.work.WorkManager r5 = io.monedata.c2.a(r5)
                if (r5 == 0) goto L_0x009e
                java.lang.String r6 = "io.monedata.ping.PingWorker"
                androidx.work.Operation r5 = r5.cancelUniqueWork(r6)
                if (r5 == 0) goto L_0x009e
                com.google.common.util.concurrent.ListenableFuture r5 = r5.getResult()
                java.lang.String r6 = "result"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                boolean r6 = r5.isDone()
                if (r6 == 0) goto L_0x0064
                java.lang.Object r6 = r5.get()     // Catch:{ ExecutionException -> 0x005a }
                goto L_0x0096
            L_0x005a:
                r5 = move-exception
                java.lang.Throwable r6 = r5.getCause()
                if (r6 != 0) goto L_0x0062
                goto L_0x0063
            L_0x0062:
                r5 = r6
            L_0x0063:
                throw r5
            L_0x0064:
                r0.a = r5
                r0.d = r3
                kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl
                kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
                r6.<init>(r2, r3)
                r6.initCancellability()
                io.monedata.ping.PingWorker$a$a r2 = new io.monedata.ping.PingWorker$a$a
                r2.<init>(r6, r5)
                androidx.work.DirectExecutor r3 = androidx.work.DirectExecutor.INSTANCE
                r5.addListener(r2, r3)
                io.monedata.ping.PingWorker$a$b r2 = new io.monedata.ping.PingWorker$a$b
                r2.<init>(r5)
                r6.invokeOnCancellation(r2)
                java.lang.Object r6 = r6.getResult()
                java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r6 != r5) goto L_0x0093
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
            L_0x0093:
                if (r6 != r1) goto L_0x0096
                return r1
            L_0x0096:
                java.lang.String r5 = "result.await()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L_0x009e:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: io.monedata.ping.PingWorker.a.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.ping.PingWorker", f = "PingWorker.kt", i = {}, l = {35}, m = "doWork", n = {}, s = {})
    static final class b extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ PingWorker b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PingWorker pingWorker, Continuation<? super b> continuation) {
            super(continuation);
            this.b = pingWorker;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.doWork(this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroidx/work/ListenableWorker$Result;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.ping.PingWorker$doWork$2", f = "PingWorker.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ListenableWorker.Result>, Object> {
        int a;
        final /* synthetic */ PingWorker b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PingWorker pingWorker, String str, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = pingWorker;
            this.c = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ListenableWorker.Result> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                PingWorker pingWorker = this.b;
                String str = this.c;
                this.a = 1;
                if (pingWorker.a(str, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return ListenableWorker.Result.success();
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.ping.PingWorker", f = "PingWorker.kt", i = {}, l = {51, 54}, m = "record", n = {}, s = {})
    static final class d extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ PingWorker b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(PingWorker pingWorker, Continuation<? super d> continuation) {
            super(continuation);
            this.b = pingWorker;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((String) null, this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, NativeProtocol.WEB_DIALOG_PARAMS);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0063 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof io.monedata.ping.PingWorker.d
            if (r0 == 0) goto L_0x0013
            r0 = r12
            io.monedata.ping.PingWorker$d r0 = (io.monedata.ping.PingWorker.d) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.ping.PingWorker$d r0 = new io.monedata.ping.PingWorker$d
            r0.<init>(r10, r12)
        L_0x0018:
            java.lang.Object r12 = r0.a
            java.lang.Object r8 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.c
            r9 = 2
            r2 = 1
            if (r1 == 0) goto L_0x0038
            if (r1 == r2) goto L_0x0034
            if (r1 != r9) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0064
        L_0x002c:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0055
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r12)
            io.monedata.g0 r1 = io.monedata.g0.a
            android.content.Context r12 = r10.getApplicationContext()
            java.lang.String r3 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r3)
            r0.c = r2
            r4 = 0
            r6 = 4
            r7 = 0
            r2 = r12
            r3 = r11
            r5 = r0
            java.lang.Object r12 = io.monedata.g0.a(r1, r2, r3, r4, r5, r6, r7)
            if (r12 != r8) goto L_0x0055
            return r8
        L_0x0055:
            io.monedata.f0 r12 = (io.monedata.f0) r12
            io.monedata.k r11 = io.monedata.l.a()
            r0.c = r9
            java.lang.Object r12 = r11.a((io.monedata.f0) r12, (kotlin.coroutines.Continuation<? super io.monedata.o1<java.lang.Boolean>>) r0)
            if (r12 != r8) goto L_0x0064
            return r8
        L_0x0064:
            io.monedata.o1 r12 = (io.monedata.o1) r12
            io.monedata.p1.b(r12)
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.ping.PingWorker.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof io.monedata.ping.PingWorker.b
            if (r0 == 0) goto L_0x0013
            r0 = r8
            io.monedata.ping.PingWorker$b r0 = (io.monedata.ping.PingWorker.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.ping.PingWorker$b r0 = new io.monedata.ping.PingWorker$b
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006d
        L_0x0029:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r8)
            io.monedata.MonedataLog r8 = io.monedata.MonedataLog.INSTANCE
            java.lang.String r2 = "Sending ping event..."
            r4 = 2
            r5 = 0
            io.monedata.MonedataLog.d$default((io.monedata.MonedataLog) r8, (java.lang.String) r2, (java.lang.Throwable) r5, (int) r4, (java.lang.Object) r5)
            io.monedata.Settings r8 = io.monedata.Settings.INSTANCE
            android.content.Context r2 = r7.getApplicationContext()
            java.lang.String r4 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r8 = r8.requireAssetKey$core_productionRelease(r2)
            io.monedata.consent.ConsentManager r2 = io.monedata.consent.ConsentManager.INSTANCE
            android.content.Context r6 = r7.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            boolean r2 = r2.canCollectPersonalData(r6)
            if (r2 == 0) goto L_0x0073
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            io.monedata.ping.PingWorker$c r4 = new io.monedata.ping.PingWorker$c
            r4.<init>(r7, r8, r5)
            r0.c = r3
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r0)
            if (r8 != r1) goto L_0x006d
            return r1
        L_0x006d:
            java.lang.String r0 = "override suspend fun doW…success()\n        }\n    }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
            return r8
        L_0x0073:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Failed requirement."
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.ping.PingWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
