package io.monedata;

import android.content.Context;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000eJ\u001e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lio/monedata/u;", "Lio/monedata/utils/a;", "Lio/monedata/s;", "Lio/monedata/t;", "cache", "", "maxAge", "a", "(Lio/monedata/t;Ljava/lang/Number;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "", "assetKey", "b", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/Deferred;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class u extends io.monedata.utils.a<s> {
    public static final u a = new u();

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H@"}, d2 = {"Lio/monedata/s;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.config.ConfigManager$fetchAsync$1", f = "ConfigManager.kt", i = {0, 1}, l = {61, 62, 63}, m = "invokeSuspend", n = {"cache", "cache"}, s = {"L$0", "L$0"})
    static final class a extends SuspendLambda implements Function1<Continuation<? super s>, Object> {
        Object a;
        int b;
        final /* synthetic */ Context c;
        final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, String str, Continuation<? super a> continuation) {
            super(1, continuation);
            this.c = context;
            this.d = str;
        }

        /* renamed from: a */
        public final Object invoke(Continuation<? super s> continuation) {
            return ((a) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new a(this.c, this.d, continuation);
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x006a  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.b
                r2 = 3
                r3 = 1
                r4 = 2
                if (r1 == 0) goto L_0x002e
                if (r1 == r3) goto L_0x0026
                if (r1 == r4) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x0080
            L_0x0016:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001e:
                java.lang.Object r1 = r7.a
                io.monedata.t r1 = (io.monedata.t) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x0061
            L_0x0026:
                java.lang.Object r1 = r7.a
                io.monedata.t r1 = (io.monedata.t) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x004c
            L_0x002e:
                kotlin.ResultKt.throwOnFailure(r8)
                io.monedata.t r8 = new io.monedata.t
                android.content.Context r1 = r7.c
                r8.<init>(r1)
                io.monedata.u r1 = io.monedata.u.a
                java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
                r7.a = r8
                r7.b = r3
                java.lang.Object r1 = r1.a((io.monedata.t) r8, (java.lang.Number) r5, (kotlin.coroutines.Continuation<? super io.monedata.s>) r7)
                if (r1 != r0) goto L_0x0049
                return r0
            L_0x0049:
                r6 = r1
                r1 = r8
                r8 = r6
            L_0x004c:
                io.monedata.s r8 = (io.monedata.s) r8
                if (r8 != 0) goto L_0x0082
                io.monedata.u r8 = io.monedata.u.a
                android.content.Context r3 = r7.c
                java.lang.String r5 = r7.d
                r7.a = r1
                r7.b = r4
                java.lang.Object r8 = r8.b(r3, r5, r7)
                if (r8 != r0) goto L_0x0061
                return r0
            L_0x0061:
                io.monedata.s r8 = (io.monedata.s) r8
                r3 = 0
                if (r8 == 0) goto L_0x006a
                r1.a((io.monedata.s) r8)
                goto L_0x006b
            L_0x006a:
                r8 = r3
            L_0x006b:
                if (r8 != 0) goto L_0x0082
                io.monedata.u r8 = io.monedata.u.a
                r4 = 120(0x78, float:1.68E-43)
                java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
                r7.a = r3
                r7.b = r2
                java.lang.Object r8 = r8.a((io.monedata.t) r1, (java.lang.Number) r4, (kotlin.coroutines.Continuation<? super io.monedata.s>) r7)
                if (r8 != r0) goto L_0x0080
                return r0
            L_0x0080:
                io.monedata.s r8 = (io.monedata.s) r8
            L_0x0082:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: io.monedata.u.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/monedata/s;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.config.ConfigManager$fetchFromCache$2", f = "ConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super s>, Object> {
        int a;
        final /* synthetic */ t b;
        final /* synthetic */ Number c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(t tVar, Number number, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = tVar;
            this.c = number;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super s> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a == 0) {
                ResultKt.throwOnFailure(obj);
                s a2 = this.b.a(this.c, TimeUnit.HOURS);
                if (a2 == null) {
                    return null;
                }
                Number number = this.c;
                MonedataLog monedataLog = MonedataLog.INSTANCE;
                MonedataLog.d$default(monedataLog, "Remote config loaded from cache (maxAge = " + number + ')', (Throwable) null, 2, (Object) null);
                return a2;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.config.ConfigManager", f = "ConfigManager.kt", i = {}, l = {34}, m = "fetchFromNetwork", n = {}, s = {})
    static final class c extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ u b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(u uVar, Continuation<? super c> continuation) {
            super(continuation);
            this.b = uVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.b((Context) null, (String) null, this);
        }
    }

    private u() {
    }

    /* access modifiers changed from: private */
    public final Object a(t tVar, Number number, Continuation<? super s> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new b(tVar, number, (Continuation<? super b>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(android.content.Context r5, java.lang.String r6, kotlin.coroutines.Continuation<? super io.monedata.s> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof io.monedata.u.c
            if (r0 == 0) goto L_0x0013
            r0 = r7
            io.monedata.u$c r0 = (io.monedata.u.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.u$c r0 = new io.monedata.u$c
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.Result r7 = (kotlin.Result) r7
            java.lang.Object r5 = r7.m2353unboximpl()
            goto L_0x0047
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r7)
            io.monedata.k r7 = io.monedata.l.a()
            r0.c = r3
            java.lang.Object r5 = io.monedata.m.a(r7, r5, r6, r0)
            if (r5 != r1) goto L_0x0047
            return r1
        L_0x0047:
            java.lang.Throwable r6 = kotlin.Result.m2347exceptionOrNullimpl(r5)
            if (r6 == 0) goto L_0x0054
            io.monedata.MonedataLog r7 = io.monedata.MonedataLog.INSTANCE
            java.lang.String r0 = "Failed to fetch remote config"
            r7.e((java.lang.String) r0, (java.lang.Throwable) r6)
        L_0x0054:
            boolean r6 = kotlin.Result.m2351isSuccessimpl(r5)
            r7 = 0
            if (r6 == 0) goto L_0x0066
            r6 = r5
            io.monedata.s r6 = (io.monedata.s) r6
            io.monedata.MonedataLog r6 = io.monedata.MonedataLog.INSTANCE
            java.lang.String r0 = "Remote config successfully fetched"
            r1 = 2
            io.monedata.MonedataLog.v$default((io.monedata.MonedataLog) r6, (java.lang.String) r0, (java.lang.Throwable) r7, (int) r1, (java.lang.Object) r7)
        L_0x0066:
            boolean r6 = kotlin.Result.m2350isFailureimpl(r5)
            if (r6 == 0) goto L_0x006d
            r5 = r7
        L_0x006d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.u.b(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object a(Context context, String str, Continuation<? super s> continuation) {
        return a(context, str).await(continuation);
    }

    public final Deferred<s> a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "assetKey");
        return fetchAsync(new a(context, str, (Continuation<? super a>) null));
    }
}
