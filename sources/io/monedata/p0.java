package io.monedata;

import android.content.Context;
import io.monedata.partners.PartnerAdapter;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lio/monedata/p0;", "", "Landroid/content/Context;", "context", "Lio/monedata/partners/PartnerAdapter;", "adapter", "", "error", "Lio/monedata/o0;", "a", "(Landroid/content/Context;Lio/monedata/partners/PartnerAdapter;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class p0 {
    public static final p0 a = new p0();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.error.factories.ErrorRequestFactory", f = "ErrorRequestFactory.kt", i = {0, 0, 0, 1, 1}, l = {27, 28}, m = "create", n = {"context", "error", "assetKey", "error", "assetKey"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1"})
    static final class a extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        final /* synthetic */ p0 e;
        int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(p0 p0Var, Continuation<? super a> continuation) {
            super(continuation);
            this.e = p0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.a((Context) null, (PartnerAdapter) null, (Throwable) null, this);
        }
    }

    private p0() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v3, resolved type: java.lang.Throwable} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r11, io.monedata.partners.PartnerAdapter r12, java.lang.Throwable r13, kotlin.coroutines.Continuation<? super io.monedata.o0> r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof io.monedata.p0.a
            if (r0 == 0) goto L_0x0013
            r0 = r14
            io.monedata.p0$a r0 = (io.monedata.p0.a) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.p0$a r0 = new io.monedata.p0$a
            r0.<init>(r10, r14)
        L_0x0018:
            java.lang.Object r14 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r4) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r11 = r0.c
            io.monedata.b r11 = (io.monedata.b) r11
            java.lang.Object r12 = r0.b
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r13 = r0.a
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            kotlin.ResultKt.throwOnFailure(r14)
            r3 = r11
            r4 = r12
            goto L_0x0089
        L_0x003a:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0042:
            java.lang.Object r11 = r0.c
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r0.b
            r13 = r12
            java.lang.Throwable r13 = (java.lang.Throwable) r13
            java.lang.Object r12 = r0.a
            android.content.Context r12 = (android.content.Context) r12
            kotlin.ResultKt.throwOnFailure(r14)
            r9 = r12
            r12 = r11
            r11 = r9
            goto L_0x0073
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r14)
            io.monedata.Settings r14 = io.monedata.Settings.INSTANCE
            java.lang.String r14 = r14.getAssetKey$core_productionRelease(r11)
            io.monedata.c r2 = io.monedata.c.a
            r0.a = r11
            r0.b = r13
            r0.c = r14
            r0.f = r4
            java.lang.Object r12 = r2.a(r11, r12, r0)
            if (r12 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r9 = r14
            r14 = r12
            r12 = r9
        L_0x0073:
            io.monedata.b r14 = (io.monedata.b) r14
            io.monedata.r r2 = io.monedata.C0242r.a
            r0.a = r13
            r0.b = r12
            r0.c = r14
            r0.f = r3
            java.lang.Object r11 = r2.a(r11, r0)
            if (r11 != r1) goto L_0x0086
            return r1
        L_0x0086:
            r4 = r12
            r3 = r14
            r14 = r11
        L_0x0089:
            r5 = r14
            io.monedata.q r5 = (io.monedata.q) r5
            io.monedata.i0 r11 = io.monedata.i0.a
            io.monedata.h0 r6 = r11.a()
            java.lang.String r7 = kotlin.ExceptionsKt.stackTraceToString(r13)
            io.monedata.o0 r11 = new io.monedata.o0
            java.lang.String r8 = "1.7.1"
            r2 = r11
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.p0.a(android.content.Context, io.monedata.partners.PartnerAdapter, java.lang.Throwable, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
