package io.monedata.consent;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.facebook.internal.NativeProtocol;
import com.google.common.util.concurrent.ListenableFuture;
import io.monedata.consent.models.ConsentData;
import io.monedata.e0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\t\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lio/monedata/consent/ConsentSubmitWorker;", "Landroidx/work/CoroutineWorker;", "", "assetKey", "Lio/monedata/consent/models/ConsentData;", "consent", "Landroidx/work/ListenableWorker$Result;", "a", "(Ljava/lang/String;Lio/monedata/consent/models/ConsentData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doWork", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class ConsentSubmitWorker extends CoroutineWorker {
    public static final a a = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Constraints b = e0.a(new Constraints.Builder()).build();

    @Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002XT¢\u0006\u0006\n\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lio/monedata/consent/ConsentSubmitWorker$a;", "", "Landroid/content/Context;", "context", "", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/work/Constraints;", "CONSTRAINTS", "Landroidx/work/Constraints;", "", "WORK_NAME", "Ljava/lang/String;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
    public static final class a {

        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, d2 = {"<anonymous>", "", "R", "run", "androidx/work/ListenableFutureKt$await$2$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: io.monedata.consent.ConsentSubmitWorker$a$a  reason: collision with other inner class name */
        public static final class C0204a implements Runnable {
            final /* synthetic */ CancellableContinuation a;
            final /* synthetic */ ListenableFuture b;

            public C0204a(CancellableContinuation cancellableContinuation, ListenableFuture listenableFuture) {
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
        @DebugMetadata(c = "io.monedata.consent.ConsentSubmitWorker$Companion", f = "ConsentSubmitWorker.kt", i = {0}, l = {106}, m = "enqueue", n = {"$this$await$iv$iv"}, s = {"L$0"})
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

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARNING: type inference failed for: r8v14, types: [java.lang.Throwable] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object a(android.content.Context r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof io.monedata.consent.ConsentSubmitWorker.a.c
                if (r0 == 0) goto L_0x0013
                r0 = r8
                io.monedata.consent.ConsentSubmitWorker$a$c r0 = (io.monedata.consent.ConsentSubmitWorker.a.c) r0
                int r1 = r0.d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.d = r1
                goto L_0x0018
            L_0x0013:
                io.monedata.consent.ConsentSubmitWorker$a$c r0 = new io.monedata.consent.ConsentSubmitWorker$a$c
                r0.<init>(r6, r8)
            L_0x0018:
                java.lang.Object r8 = r0.b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.d
                r3 = 1
                if (r2 == 0) goto L_0x0036
                if (r2 != r3) goto L_0x002e
                java.lang.Object r7 = r0.a
                com.google.common.util.concurrent.ListenableFuture r7 = (com.google.common.util.concurrent.ListenableFuture) r7
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x00ba
            L_0x002e:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L_0x0036:
                kotlin.ResultKt.throwOnFailure(r8)
                androidx.work.OneTimeWorkRequest$Builder r8 = new androidx.work.OneTimeWorkRequest$Builder
                java.lang.Class<io.monedata.consent.ConsentSubmitWorker> r2 = io.monedata.consent.ConsentSubmitWorker.class
                r8.<init>(r2)
                androidx.work.Constraints r2 = io.monedata.consent.ConsentSubmitWorker.b
                androidx.work.WorkRequest$Builder r8 = r8.setConstraints(r2)
                androidx.work.OneTimeWorkRequest$Builder r8 = (androidx.work.OneTimeWorkRequest.Builder) r8
                java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS
                r4 = 30
                androidx.work.WorkRequest$Builder r8 = r8.setInitialDelay(r4, r2)
                androidx.work.OneTimeWorkRequest$Builder r8 = (androidx.work.OneTimeWorkRequest.Builder) r8
                androidx.work.WorkRequest r8 = r8.build()
                androidx.work.OneTimeWorkRequest r8 = (androidx.work.OneTimeWorkRequest) r8
                androidx.work.WorkManager r7 = io.monedata.c2.a(r7)
                if (r7 == 0) goto L_0x00c2
                androidx.work.ExistingWorkPolicy r2 = androidx.work.ExistingWorkPolicy.REPLACE
                java.lang.String r4 = "io.monedata.consent.ConsentSubmitWorker"
                androidx.work.Operation r7 = r7.enqueueUniqueWork((java.lang.String) r4, (androidx.work.ExistingWorkPolicy) r2, (androidx.work.OneTimeWorkRequest) r8)
                if (r7 == 0) goto L_0x00c2
                com.google.common.util.concurrent.ListenableFuture r7 = r7.getResult()
                java.lang.String r8 = "result"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
                boolean r8 = r7.isDone()
                if (r8 == 0) goto L_0x0088
                java.lang.Object r8 = r7.get()     // Catch:{ ExecutionException -> 0x007e }
                goto L_0x00ba
            L_0x007e:
                r7 = move-exception
                java.lang.Throwable r8 = r7.getCause()
                if (r8 != 0) goto L_0x0086
                goto L_0x0087
            L_0x0086:
                r7 = r8
            L_0x0087:
                throw r7
            L_0x0088:
                r0.a = r7
                r0.d = r3
                kotlinx.coroutines.CancellableContinuationImpl r8 = new kotlinx.coroutines.CancellableContinuationImpl
                kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.intercepted(r0)
                r8.<init>(r2, r3)
                r8.initCancellability()
                io.monedata.consent.ConsentSubmitWorker$a$a r2 = new io.monedata.consent.ConsentSubmitWorker$a$a
                r2.<init>(r8, r7)
                androidx.work.DirectExecutor r3 = androidx.work.DirectExecutor.INSTANCE
                r7.addListener(r2, r3)
                io.monedata.consent.ConsentSubmitWorker$a$b r2 = new io.monedata.consent.ConsentSubmitWorker$a$b
                r2.<init>(r7)
                r8.invokeOnCancellation(r2)
                java.lang.Object r8 = r8.getResult()
                java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                if (r8 != r7) goto L_0x00b7
                kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
            L_0x00b7:
                if (r8 != r1) goto L_0x00ba
                return r1
            L_0x00ba:
                java.lang.String r7 = "result.await()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r7)
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            L_0x00c2:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: io.monedata.consent.ConsentSubmitWorker.a.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.consent.ConsentSubmitWorker", f = "ConsentSubmitWorker.kt", i = {}, l = {35}, m = "doWork", n = {}, s = {})
    static final class b extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ ConsentSubmitWorker b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ConsentSubmitWorker consentSubmitWorker, Continuation<? super b> continuation) {
            super(continuation);
            this.b = consentSubmitWorker;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.doWork(this);
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.consent.ConsentSubmitWorker", f = "ConsentSubmitWorker.kt", i = {}, l = {48, 51}, m = "submit", n = {}, s = {})
    static final class c extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ ConsentSubmitWorker b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ConsentSubmitWorker consentSubmitWorker, Continuation<? super c> continuation) {
            super(continuation);
            this.b = consentSubmitWorker;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((String) null, (ConsentData) null, this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConsentSubmitWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, NativeProtocol.WEB_DIALOG_PARAMS);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r7, io.monedata.consent.models.ConsentData r8, kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof io.monedata.consent.ConsentSubmitWorker.c
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.monedata.consent.ConsentSubmitWorker$c r0 = (io.monedata.consent.ConsentSubmitWorker.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.consent.ConsentSubmitWorker$c r0 = new io.monedata.consent.ConsentSubmitWorker$c
            r0.<init>(r6, r9)
        L_0x0018:
            java.lang.Object r9 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x005e
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004f
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r9)
            io.monedata.a0 r9 = io.monedata.a0.a
            android.content.Context r2 = r6.getApplicationContext()
            java.lang.String r5 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            r0.c = r4
            java.lang.Object r9 = r9.a(r2, r7, r8, r0)
            if (r9 != r1) goto L_0x004f
            return r1
        L_0x004f:
            io.monedata.z r9 = (io.monedata.z) r9
            io.monedata.b0 r7 = io.monedata.c0.a()
            r0.c = r3
            java.lang.Object r9 = r7.a(r9, r0)
            if (r9 != r1) goto L_0x005e
            return r1
        L_0x005e:
            io.monedata.o1 r9 = (io.monedata.o1) r9
            io.monedata.MonedataLog r7 = io.monedata.MonedataLog.INSTANCE
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "Consent data submission result: "
            r8.<init>(r0)
            if (r9 == 0) goto L_0x0072
            boolean r0 = r9.c()
            if (r0 != r4) goto L_0x0072
            goto L_0x0073
        L_0x0072:
            r4 = 0
        L_0x0073:
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            r0 = 0
            io.monedata.MonedataLog.v$default((io.monedata.MonedataLog) r7, (java.lang.String) r8, (java.lang.Throwable) r0, (int) r3, (java.lang.Object) r0)
            boolean r7 = r9.c()
            if (r7 == 0) goto L_0x008c
            androidx.work.ListenableWorker$Result r7 = androidx.work.ListenableWorker.Result.success()
            java.lang.String r8 = "success()"
            goto L_0x0092
        L_0x008c:
            androidx.work.ListenableWorker$Result r7 = androidx.work.ListenableWorker.Result.failure()
            java.lang.String r8 = "failure()"
        L_0x0092:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.consent.ConsentSubmitWorker.a(java.lang.String, io.monedata.consent.models.ConsentData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof io.monedata.consent.ConsentSubmitWorker.b
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.monedata.consent.ConsentSubmitWorker$b r0 = (io.monedata.consent.ConsentSubmitWorker.b) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.consent.ConsentSubmitWorker$b r0 = new io.monedata.consent.ConsentSubmitWorker$b
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x006b }
            goto L_0x0064
        L_0x0029:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            io.monedata.MonedataLog r7 = io.monedata.MonedataLog.INSTANCE
            java.lang.String r2 = "Submitting consent data..."
            r4 = 2
            r5 = 0
            io.monedata.MonedataLog.v$default((io.monedata.MonedataLog) r7, (java.lang.String) r2, (java.lang.Throwable) r5, (int) r4, (java.lang.Object) r5)
            io.monedata.Settings r7 = io.monedata.Settings.INSTANCE
            android.content.Context r2 = r6.getApplicationContext()
            java.lang.String r4 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            java.lang.String r7 = r7.requireAssetKey$core_productionRelease(r2)
            io.monedata.consent.ConsentManager r2 = io.monedata.consent.ConsentManager.INSTANCE
            android.content.Context r5 = r6.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            io.monedata.consent.models.ConsentData r2 = io.monedata.y.a(r2, r5)
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ all -> 0x006b }
            r0.c = r3     // Catch:{ all -> 0x006b }
            java.lang.Object r7 = r6.a(r7, r2, r0)     // Catch:{ all -> 0x006b }
            if (r7 != r1) goto L_0x0064
            return r1
        L_0x0064:
            androidx.work.ListenableWorker$Result r7 = (androidx.work.ListenableWorker.Result) r7     // Catch:{ all -> 0x006b }
            java.lang.Object r7 = kotlin.Result.m2344constructorimpl(r7)     // Catch:{ all -> 0x006b }
            goto L_0x0076
        L_0x006b:
            r7 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r7 = kotlin.ResultKt.createFailure(r7)
            java.lang.Object r7 = kotlin.Result.m2344constructorimpl(r7)
        L_0x0076:
            java.lang.Throwable r0 = kotlin.Result.m2347exceptionOrNullimpl(r7)
            if (r0 != 0) goto L_0x007d
            goto L_0x0086
        L_0x007d:
            androidx.work.ListenableWorker$Result r7 = androidx.work.ListenableWorker.Result.retry()
            java.lang.String r0 = "retry()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
        L_0x0086:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.consent.ConsentSubmitWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
