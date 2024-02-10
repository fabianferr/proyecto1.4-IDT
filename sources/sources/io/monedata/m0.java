package io.monedata;

import android.content.Context;
import io.monedata.partners.PartnerAdapter;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u0007\u001a\u00020\u00062\u001c\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000fR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lio/monedata/m0;", "", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lio/monedata/o0;", "builder", "", "a", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lio/monedata/partners/PartnerAdapter;", "adapter", "", "error", "(Landroid/content/Context;Lio/monedata/partners/PartnerAdapter;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/monedata/n0;", "()Lio/monedata/n0;", "config", "b", "()Z", "enabled", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class m0 {
    public static final m0 a = new m0();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.error.ErrorCollector", f = "ErrorCollector.kt", i = {}, l = {33, 33}, m = "record", n = {}, s = {})
    static final class a extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ m0 c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(m0 m0Var, Continuation<? super a> continuation) {
            super(continuation);
            this.c = m0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Function1<? super Continuation<? super o0>, ? extends Object>) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lio/monedata/o0;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.error.ErrorCollector$record$4", f = "ErrorCollector.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
    static final class b extends SuspendLambda implements Function1<Continuation<? super o0>, Object> {
        int a;
        final /* synthetic */ Context b;
        final /* synthetic */ PartnerAdapter c;
        final /* synthetic */ Throwable d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, PartnerAdapter partnerAdapter, Throwable th, Continuation<? super b> continuation) {
            super(1, continuation);
            this.b = context;
            this.c = partnerAdapter;
            this.d = th;
        }

        /* renamed from: a */
        public final Object invoke(Continuation<? super o0> continuation) {
            return ((b) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new b(this.b, this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                p0 p0Var = p0.a;
                Context context = this.b;
                PartnerAdapter partnerAdapter = this.c;
                Throwable th = this.d;
                this.a = 1;
                obj = p0Var.a(context, partnerAdapter, th, this);
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

    private m0() {
    }

    private final n0 a() {
        s sVar = (s) u.a.getValue();
        if (sVar != null) {
            return sVar.a();
        }
        return null;
    }

    private final boolean b() {
        n0 a2 = a();
        if (a2 != null) {
            return Intrinsics.areEqual((Object) a2.a(), (Object) Boolean.TRUE);
        }
        return false;
    }

    public final Object a(Context context, PartnerAdapter partnerAdapter, Throwable th, Continuation<? super Boolean> continuation) {
        return a(new b(context, partnerAdapter, th, (Continuation<? super b>) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x006c A[Catch:{ all -> 0x007c }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super io.monedata.o0>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof io.monedata.m0.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            io.monedata.m0$a r0 = (io.monedata.m0.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.m0$a r0 = new io.monedata.m0$a
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r5) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x007c }
            goto L_0x006d
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            java.lang.Object r8 = r0.a
            io.monedata.k r8 = (io.monedata.k) r8
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x007c }
            goto L_0x005f
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r9)
            boolean r9 = r7.b()
            if (r9 != 0) goto L_0x004b
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            return r8
        L_0x004b:
            kotlin.Result$Companion r9 = kotlin.Result.Companion     // Catch:{ all -> 0x007c }
            io.monedata.k r9 = io.monedata.l.a()     // Catch:{ all -> 0x007c }
            r0.a = r9     // Catch:{ all -> 0x007c }
            r0.d = r5     // Catch:{ all -> 0x007c }
            java.lang.Object r8 = r8.invoke(r0)     // Catch:{ all -> 0x007c }
            if (r8 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x005f:
            io.monedata.o0 r9 = (io.monedata.o0) r9     // Catch:{ all -> 0x007c }
            r2 = 0
            r0.a = r2     // Catch:{ all -> 0x007c }
            r0.d = r3     // Catch:{ all -> 0x007c }
            java.lang.Object r9 = r8.a((io.monedata.o0) r9, (kotlin.coroutines.Continuation<? super io.monedata.o1<java.lang.Boolean>>) r0)     // Catch:{ all -> 0x007c }
            if (r9 != r1) goto L_0x006d
            return r1
        L_0x006d:
            io.monedata.o1 r9 = (io.monedata.o1) r9     // Catch:{ all -> 0x007c }
            boolean r8 = r9.c()     // Catch:{ all -> 0x007c }
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)     // Catch:{ all -> 0x007c }
            java.lang.Object r8 = kotlin.Result.m2344constructorimpl(r8)     // Catch:{ all -> 0x007c }
            goto L_0x0087
        L_0x007c:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m2344constructorimpl(r8)
        L_0x0087:
            java.lang.Throwable r9 = kotlin.Result.m2347exceptionOrNullimpl(r8)
            if (r9 == 0) goto L_0x0094
            io.monedata.MonedataLog r0 = io.monedata.MonedataLog.INSTANCE
            java.lang.String r1 = "Could not record error"
            r0.v((java.lang.String) r1, (java.lang.Throwable) r9)
        L_0x0094:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r4)
            boolean r0 = kotlin.Result.m2350isFailureimpl(r8)
            if (r0 == 0) goto L_0x009f
            r8 = r9
        L_0x009f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.m0.a(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
