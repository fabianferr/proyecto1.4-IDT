package io.monedata;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lio/monedata/p;", "", "Landroid/content/Context;", "context", "Lio/monedata/o;", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class p {
    public static final p a = new p();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.models.factories.ClientFeaturesFactory", f = "ClientFeaturesFactory.kt", i = {}, l = {22}, m = "create", n = {}, s = {})
    static final class a extends ContinuationImpl {
        boolean a;
        boolean b;
        boolean c;
        boolean d;
        /* synthetic */ Object e;
        final /* synthetic */ p f;
        int g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(p pVar, Continuation<? super a> continuation) {
            super(continuation);
            this.f = pVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.e = obj;
            this.g |= Integer.MIN_VALUE;
            return this.f.a((Context) null, this);
        }
    }

    private p() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r13, kotlin.coroutines.Continuation<? super io.monedata.o> r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof io.monedata.p.a
            if (r0 == 0) goto L_0x0013
            r0 = r14
            io.monedata.p$a r0 = (io.monedata.p.a) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.p$a r0 = new io.monedata.p$a
            r0.<init>(r12, r14)
        L_0x0018:
            java.lang.Object r14 = r0.e
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            boolean r13 = r0.d
            boolean r1 = r0.c
            boolean r2 = r0.b
            boolean r0 = r0.a
            kotlin.ResultKt.throwOnFailure(r14)
            r10 = r13
            r7 = r0
            r9 = r1
            r8 = r2
            goto L_0x006c
        L_0x0035:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r14)
            io.monedata.q0 r14 = new io.monedata.q0
            r14.<init>(r13)
            io.monedata.f r13 = io.monedata.f.a
            boolean r13 = r13.a()
            boolean r2 = r14.a()
            boolean r4 = r14.b()
            boolean r5 = r14.c()
            r0.a = r13
            r0.b = r2
            r0.c = r4
            r0.d = r5
            r0.g = r3
            java.lang.Object r14 = r14.a(r0)
            if (r14 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r7 = r13
            r8 = r2
            r9 = r4
            r10 = r5
        L_0x006c:
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r11 = r14.booleanValue()
            io.monedata.o r13 = new io.monedata.o
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.p.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
