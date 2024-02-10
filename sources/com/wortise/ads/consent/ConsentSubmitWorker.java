package com.wortise.ads.consent;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.facebook.internal.NativeProtocol;
import com.google.common.util.concurrent.ListenableFuture;
import com.wortise.ads.AdSettings;
import com.wortise.ads.consent.models.ConsentData;
import com.wortise.ads.k5;
import com.wortise.ads.z1;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
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

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/wortise/ads/consent/ConsentSubmitWorker;", "Landroidx/work/Worker;", "Landroid/content/Context;", "context", "Lcom/wortise/ads/consent/models/ConsentData;", "data", "", "a", "(Landroid/content/Context;Lcom/wortise/ads/consent/models/ConsentData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/ListenableWorker$Result;", "doWork", "", "b", "()Ljava/lang/String;", "assetKey", "c", "()Lcom/wortise/ads/consent/models/ConsentData;", "consent", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "Companion", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ConsentSubmitWorker.kt */
public final class ConsentSubmitWorker extends Worker {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final Constraints a;
    /* access modifiers changed from: private */
    public static final OneTimeWorkRequest b;

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/wortise/ads/consent/ConsentSubmitWorker$a;", "", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "b", "Landroidx/work/Constraints;", "CONSTRAINTS", "Landroidx/work/Constraints;", "Landroidx/work/OneTimeWorkRequest;", "REQUEST", "Landroidx/work/OneTimeWorkRequest;", "", "WORK_NAME", "Ljava/lang/String;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: ConsentSubmitWorker.kt */
    public static final class a {

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¨\u0006\u0002"}, d2 = {"R", "", "androidx/work/ListenableFutureKt$await$2$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* renamed from: com.wortise.ads.consent.ConsentSubmitWorker$a$a  reason: collision with other inner class name */
        /* compiled from: ListenableFuture.kt */
        public static final class C0180a implements Runnable {
            final /* synthetic */ CancellableContinuation a;
            final /* synthetic */ ListenableFuture b;

            public C0180a(CancellableContinuation cancellableContinuation, ListenableFuture listenableFuture) {
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

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.wortise.ads.consent.ConsentSubmitWorker$Companion", f = "ConsentSubmitWorker.kt", i = {0}, l = {91}, m = "cancel", n = {"$this$await$iv$iv"}, s = {"L$0"})
        /* compiled from: ConsentSubmitWorker.kt */
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

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H\n¨\u0006\u0002"}, d2 = {"R", "", "androidx/work/ListenableFutureKt$await$2$1", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* compiled from: ListenableFuture.kt */
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

        @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
        @DebugMetadata(c = "com.wortise.ads.consent.ConsentSubmitWorker$Companion", f = "ConsentSubmitWorker.kt", i = {0}, l = {91}, m = "enqueue", n = {"$this$await$iv$iv"}, s = {"L$0"})
        /* compiled from: ConsentSubmitWorker.kt */
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
                return this.c.b((Context) null, this);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
                boolean r0 = r6 instanceof com.wortise.ads.consent.ConsentSubmitWorker.a.c
                if (r0 == 0) goto L_0x0013
                r0 = r6
                com.wortise.ads.consent.ConsentSubmitWorker$a$c r0 = (com.wortise.ads.consent.ConsentSubmitWorker.a.c) r0
                int r1 = r0.d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.d = r1
                goto L_0x0018
            L_0x0013:
                com.wortise.ads.consent.ConsentSubmitWorker$a$c r0 = new com.wortise.ads.consent.ConsentSubmitWorker$a$c
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
                goto L_0x009a
            L_0x002d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L_0x0035:
                kotlin.ResultKt.throwOnFailure(r6)
                androidx.work.WorkManager r5 = com.wortise.ads.e7.b(r5)
                if (r5 != 0) goto L_0x003f
                goto L_0x0047
            L_0x003f:
                java.lang.String r6 = "com.wortise.ads.consent.ConsentSubmitWorker"
                androidx.work.Operation r5 = r5.cancelUniqueWork(r6)
                if (r5 != 0) goto L_0x004a
            L_0x0047:
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            L_0x004a:
                com.google.common.util.concurrent.ListenableFuture r5 = r5.getResult()
                java.lang.String r6 = "result"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
                boolean r6 = r5.isDone()
                if (r6 == 0) goto L_0x0068
                java.lang.Object r6 = r5.get()     // Catch:{ ExecutionException -> 0x005e }
                goto L_0x009a
            L_0x005e:
                r5 = move-exception
                java.lang.Throwable r6 = r5.getCause()
                if (r6 != 0) goto L_0x0066
                goto L_0x0067
            L_0x0066:
                r5 = r6
            L_0x0067:
                throw r5
            L_0x0068:
                r0.a = r5
                r0.d = r3
                kotlinx.coroutines.CancellableContinuationImpl r6 = new kotlinx.coroutines.CancellableContinuationImpl
                kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
                r6.<init>(r2, r3)
                r6.initCancellability()
                com.wortise.ads.consent.ConsentSubmitWorker$a$a r2 = new com.wortise.ads.consent.ConsentSubmitWorker$a$a
                r2.<init>(r6, r5)
                androidx.work.DirectExecutor r3 = androidx.work.DirectExecutor.INSTANCE
                r5.addListener(r2, r3)
                com.wortise.ads.consent.ConsentSubmitWorker$a$b r2 = new com.wortise.ads.consent.ConsentSubmitWorker$a$b
                r2.<init>(r5)
                r6.invokeOnCancellation(r2)
                java.lang.Object r6 = r6.getResult()
                java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r6 != r5) goto L_0x0097
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
            L_0x0097:
                if (r6 != r1) goto L_0x009a
                return r1
            L_0x009a:
                java.lang.String r5 = "result.await()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r5)
                kotlin.Unit r5 = kotlin.Unit.INSTANCE
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.consent.ConsentSubmitWorker.a.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: type inference failed for: r7v8, types: [java.lang.Throwable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object b(android.content.Context r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof com.wortise.ads.consent.ConsentSubmitWorker.a.f
                if (r0 == 0) goto L_0x0013
                r0 = r7
                com.wortise.ads.consent.ConsentSubmitWorker$a$f r0 = (com.wortise.ads.consent.ConsentSubmitWorker.a.f) r0
                int r1 = r0.d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.d = r1
                goto L_0x0018
            L_0x0013:
                com.wortise.ads.consent.ConsentSubmitWorker$a$f r0 = new com.wortise.ads.consent.ConsentSubmitWorker$a$f
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.d
                r3 = 1
                if (r2 == 0) goto L_0x0036
                if (r2 != r3) goto L_0x002e
                java.lang.Object r6 = r0.a
                com.google.common.util.concurrent.ListenableFuture r6 = (com.google.common.util.concurrent.ListenableFuture) r6
                kotlin.ResultKt.throwOnFailure(r7)
                goto L_0x00a1
            L_0x002e:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0036:
                kotlin.ResultKt.throwOnFailure(r7)
                androidx.work.WorkManager r6 = com.wortise.ads.e7.b(r6)
                if (r6 != 0) goto L_0x0040
                goto L_0x004e
            L_0x0040:
                androidx.work.ExistingWorkPolicy r7 = androidx.work.ExistingWorkPolicy.REPLACE
                androidx.work.OneTimeWorkRequest r2 = com.wortise.ads.consent.ConsentSubmitWorker.b
                java.lang.String r4 = "com.wortise.ads.consent.ConsentSubmitWorker"
                androidx.work.Operation r6 = r6.enqueueUniqueWork((java.lang.String) r4, (androidx.work.ExistingWorkPolicy) r7, (androidx.work.OneTimeWorkRequest) r2)
                if (r6 != 0) goto L_0x0051
            L_0x004e:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            L_0x0051:
                com.google.common.util.concurrent.ListenableFuture r6 = r6.getResult()
                java.lang.String r7 = "result"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                boolean r7 = r6.isDone()
                if (r7 == 0) goto L_0x006f
                java.lang.Object r7 = r6.get()     // Catch:{ ExecutionException -> 0x0065 }
                goto L_0x00a1
            L_0x0065:
                r6 = move-exception
                java.lang.Throwable r7 = r6.getCause()
                if (r7 != 0) goto L_0x006d
                goto L_0x006e
            L_0x006d:
                r6 = r7
            L_0x006e:
                throw r6
            L_0x006f:
                r0.a = r6
                r0.d = r3
                kotlinx.coroutines.CancellableContinuationImpl r7 = new kotlinx.coroutines.CancellableContinuationImpl
                kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
                r7.<init>(r2, r3)
                r7.initCancellability()
                com.wortise.ads.consent.ConsentSubmitWorker$a$d r2 = new com.wortise.ads.consent.ConsentSubmitWorker$a$d
                r2.<init>(r7, r6)
                androidx.work.DirectExecutor r3 = androidx.work.DirectExecutor.INSTANCE
                r6.addListener(r2, r3)
                com.wortise.ads.consent.ConsentSubmitWorker$a$e r2 = new com.wortise.ads.consent.ConsentSubmitWorker$a$e
                r2.<init>(r6)
                r7.invokeOnCancellation(r2)
                java.lang.Object r7 = r7.getResult()
                java.lang.Object r6 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r7 != r6) goto L_0x009e
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
            L_0x009e:
                if (r7 != r1) goto L_0x00a1
                return r1
            L_0x00a1:
                java.lang.String r6 = "result.await()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.consent.ConsentSubmitWorker.a.b(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.consent.ConsentSubmitWorker$doWork$1", f = "ConsentSubmitWorker.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: ConsentSubmitWorker.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ ConsentSubmitWorker b;
        final /* synthetic */ ConsentData c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ConsentSubmitWorker consentSubmitWorker, ConsentData consentData, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = consentSubmitWorker;
            this.c = consentData;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConsentSubmitWorker consentSubmitWorker = this.b;
                Context applicationContext = consentSubmitWorker.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                ConsentData consentData = this.c;
                this.a = 1;
                if (consentSubmitWorker.a(applicationContext, consentData, this) == coroutine_suspended) {
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

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.consent.ConsentSubmitWorker", f = "ConsentSubmitWorker.kt", i = {0, 0, 0, 1}, l = {37, 46}, m = "submit", n = {"this", "context", "data", "context"}, s = {"L$0", "L$1", "L$2", "L$0"})
    /* compiled from: ConsentSubmitWorker.kt */
    static final class c extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        final /* synthetic */ ConsentSubmitWorker e;
        int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ConsentSubmitWorker consentSubmitWorker, Continuation<? super c> continuation) {
            super(continuation);
            this.e = consentSubmitWorker;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.a((Context) null, (ConsentData) null, this);
        }
    }

    static {
        Constraints build = z1.a(new Constraints.Builder()).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…ed()\n            .build()");
        a = build;
        WorkRequest.Builder constraints = new OneTimeWorkRequest.Builder(ConsentSubmitWorker.class).setConstraints(build);
        Intrinsics.checkNotNullExpressionValue(constraints, "OneTimeWorkRequestBuilde…aints       (CONSTRAINTS)");
        WorkRequest build2 = k5.a((OneTimeWorkRequest.Builder) constraints, 30, TimeUnit.SECONDS).build();
        Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequestBuilde…NDS)\n            .build()");
        b = (OneTimeWorkRequest) build2;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConsentSubmitWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, NativeProtocol.WEB_DIALOG_PARAMS);
    }

    private final String b() {
        AdSettings adSettings = AdSettings.INSTANCE;
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        return adSettings.requireAssetKey$sdk_productionRelease(applicationContext);
    }

    private final ConsentData c() {
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
        return ConsentManager.get(applicationContext);
    }

    public ListenableWorker.Result doWork() {
        ConsentData c2 = c();
        if (c2 == null) {
            ListenableWorker.Result success = ListenableWorker.Result.success();
            Intrinsics.checkNotNullExpressionValue(success, "success()");
            return success;
        }
        Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new b(this, c2, (Continuation<? super b>) null), 1, (Object) null);
        ListenableWorker.Result success2 = ListenableWorker.Result.success();
        Intrinsics.checkNotNullExpressionValue(success2, "success()");
        return success2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v5, resolved type: com.wortise.ads.consent.models.ConsentData} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r8, com.wortise.ads.consent.models.ConsentData r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.wortise.ads.consent.ConsentSubmitWorker.c
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.wortise.ads.consent.ConsentSubmitWorker$c r0 = (com.wortise.ads.consent.ConsentSubmitWorker.c) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.consent.ConsentSubmitWorker$c r0 = new com.wortise.ads.consent.ConsentSubmitWorker$c
            r0.<init>(r7, r10)
        L_0x0018:
            java.lang.Object r10 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r8 = r0.a
            android.content.Context r8 = (android.content.Context) r8
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x008b
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            java.lang.Object r8 = r0.c
            r9 = r8
            com.wortise.ads.consent.models.ConsentData r9 = (com.wortise.ads.consent.models.ConsentData) r9
            java.lang.Object r8 = r0.b
            android.content.Context r8 = (android.content.Context) r8
            java.lang.Object r2 = r0.a
            com.wortise.ads.consent.ConsentSubmitWorker r2 = (com.wortise.ads.consent.ConsentSubmitWorker) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x005e
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r10)
            com.wortise.ads.identifier.IdentifierManager r10 = com.wortise.ads.identifier.IdentifierManager.INSTANCE
            r0.a = r7
            r0.b = r8
            r0.c = r9
            r0.f = r4
            java.lang.Object r10 = r10.fetch(r8, r0)
            if (r10 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r2 = r7
        L_0x005e:
            com.wortise.ads.identifier.Identifier r10 = (com.wortise.ads.identifier.Identifier) r10
            r4 = 0
            if (r10 != 0) goto L_0x0065
            r10 = r4
            goto L_0x0069
        L_0x0065:
            java.lang.String r10 = r10.getId()
        L_0x0069:
            com.wortise.ads.x1 r5 = new com.wortise.ads.x1
            java.lang.String r2 = r2.b()
            com.wortise.ads.h7 r6 = com.wortise.ads.h7.a
            java.lang.String r6 = r6.a(r8)
            r5.<init>(r2, r6, r9, r10)
            com.wortise.ads.u1 r9 = com.wortise.ads.v1.a()
            r0.a = r8
            r0.b = r4
            r0.c = r4
            r0.f = r3
            java.lang.Object r10 = r9.a(r5, r0)
            if (r10 != r1) goto L_0x008b
            return r1
        L_0x008b:
            com.wortise.ads.w5 r10 = (com.wortise.ads.w5) r10
            boolean r9 = r10.c()
            if (r9 == 0) goto L_0x009b
            com.wortise.ads.m1 r9 = new com.wortise.ads.m1
            r9.<init>(r8)
            r9.e()
        L_0x009b:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.consent.ConsentSubmitWorker.a(android.content.Context, com.wortise.ads.consent.models.ConsentData, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
