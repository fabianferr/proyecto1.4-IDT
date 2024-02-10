package io.monedata;

import android.content.Context;
import io.monedata.models.Extras;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lio/monedata/g0;", "", "Landroid/content/Context;", "context", "", "assetKey", "Lio/monedata/models/Extras;", "extras", "Lio/monedata/f0;", "a", "(Landroid/content/Context;Ljava/lang/String;Lio/monedata/models/Extras;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class g0 {
    public static final g0 a = new g0();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.api.factories.DataRequestFactory", f = "DataRequestFactory.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2}, l = {27, 34, 38}, m = "create", n = {"context", "assetKey", "extras", "destination$iv$iv", "context", "assetKey", "extras", "adapters", "consent", "context", "assetKey", "extras", "adapters", "consent", "identifier"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    static final class a extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        /* synthetic */ Object g;
        final /* synthetic */ g0 h;
        int i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g0 g0Var, Continuation<? super a> continuation) {
            super(continuation);
            this.h = g0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.g = obj;
            this.i |= Integer.MIN_VALUE;
            return this.h.a((Context) null, (String) null, (Extras) null, this);
        }
    }

    private g0() {
    }

    public static /* synthetic */ Object a(g0 g0Var, Context context, String str, Extras extras, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            extras = null;
        }
        return g0Var.a(context, str, extras, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0114 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0137 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r18, java.lang.String r19, io.monedata.models.Extras r20, kotlin.coroutines.Continuation<? super io.monedata.f0> r21) {
        /*
            r17 = this;
            r0 = r21
            boolean r1 = r0 instanceof io.monedata.g0.a
            if (r1 == 0) goto L_0x0017
            r1 = r0
            io.monedata.g0$a r1 = (io.monedata.g0.a) r1
            int r2 = r1.i
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.i = r2
            r2 = r17
            goto L_0x001e
        L_0x0017:
            io.monedata.g0$a r1 = new io.monedata.g0$a
            r2 = r17
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.g
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.i
            r5 = 3
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x009e
            if (r4 == r7) goto L_0x0078
            if (r4 == r6) goto L_0x0059
            if (r4 != r5) goto L_0x0051
            java.lang.Object r3 = r1.f
            io.monedata.identifier.Identifier r3 = (io.monedata.identifier.Identifier) r3
            java.lang.Object r4 = r1.e
            io.monedata.consent.models.ConsentData r4 = (io.monedata.consent.models.ConsentData) r4
            java.lang.Object r5 = r1.d
            java.util.List r5 = (java.util.List) r5
            java.lang.Object r6 = r1.c
            io.monedata.models.Extras r6 = (io.monedata.models.Extras) r6
            java.lang.Object r7 = r1.b
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r1 = r1.a
            android.content.Context r1 = (android.content.Context) r1
            kotlin.ResultKt.throwOnFailure(r0)
            r8 = r4
            r10 = r6
            r6 = r7
            goto L_0x013e
        L_0x0051:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0059:
            java.lang.Object r4 = r1.e
            io.monedata.consent.models.ConsentData r4 = (io.monedata.consent.models.ConsentData) r4
            java.lang.Object r6 = r1.d
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r1.c
            io.monedata.models.Extras r7 = (io.monedata.models.Extras) r7
            java.lang.Object r8 = r1.b
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r1.a
            android.content.Context r9 = (android.content.Context) r9
            kotlin.ResultKt.throwOnFailure(r0)
            r15 = r4
            r4 = r1
            r1 = r9
            r9 = r8
            r8 = r7
            r7 = r15
            goto L_0x011f
        L_0x0078:
            java.lang.Object r4 = r1.f
            java.util.Collection r4 = (java.util.Collection) r4
            java.lang.Object r8 = r1.e
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r1.d
            java.util.Collection r9 = (java.util.Collection) r9
            java.lang.Object r10 = r1.c
            io.monedata.models.Extras r10 = (io.monedata.models.Extras) r10
            java.lang.Object r11 = r1.b
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r12 = r1.a
            android.content.Context r12 = (android.content.Context) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r15 = r8
            r8 = r1
            r1 = r11
            r11 = r15
            r16 = r9
            r9 = r3
            r3 = r10
            r10 = r16
            goto L_0x00ea
        L_0x009e:
            kotlin.ResultKt.throwOnFailure(r0)
            io.monedata.j1 r0 = io.monedata.j1.a
            java.util.List r0 = r0.a()
            java.util.ArrayList r4 = new java.util.ArrayList
            r8 = 10
            int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r8)
            r4.<init>(r8)
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
            r8 = r3
            r9 = r4
            r0 = r18
            r3 = r20
            r4 = r1
            r1 = r19
        L_0x00c0:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00f5
            java.lang.Object r11 = r10.next()
            io.monedata.partners.PartnerAdapter r11 = (io.monedata.partners.PartnerAdapter) r11
            io.monedata.c r12 = io.monedata.c.a
            r4.a = r0
            r4.b = r1
            r4.c = r3
            r4.d = r9
            r4.e = r10
            r4.f = r9
            r4.i = r7
            java.lang.Object r11 = r12.a(r0, r11, r4)
            if (r11 != r8) goto L_0x00e3
            return r8
        L_0x00e3:
            r12 = r0
            r0 = r11
            r11 = r10
            r10 = r9
            r9 = r8
            r8 = r4
            r4 = r10
        L_0x00ea:
            io.monedata.b r0 = (io.monedata.b) r0
            r4.add(r0)
            r4 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r0 = r12
            goto L_0x00c0
        L_0x00f5:
            java.util.List r9 = (java.util.List) r9
            io.monedata.consent.ConsentManager r7 = io.monedata.consent.ConsentManager.INSTANCE
            io.monedata.consent.models.ConsentData r7 = r7.get(r0)
            io.monedata.identifier.IdentifierManager r10 = io.monedata.identifier.IdentifierManager.INSTANCE
            r4.a = r0
            r4.b = r1
            r4.c = r3
            r4.d = r9
            r4.e = r7
            r11 = 0
            r4.f = r11
            r4.i = r6
            java.lang.Object r6 = r10.fetch(r0, r4)
            if (r6 != r8) goto L_0x0115
            return r8
        L_0x0115:
            r15 = r1
            r1 = r0
            r0 = r6
            r6 = r9
            r9 = r15
            r16 = r8
            r8 = r3
            r3 = r16
        L_0x011f:
            io.monedata.identifier.Identifier r0 = (io.monedata.identifier.Identifier) r0
            io.monedata.r r10 = io.monedata.C0242r.a
            r4.a = r1
            r4.b = r9
            r4.c = r8
            r4.d = r6
            r4.e = r7
            r4.f = r0
            r4.i = r5
            java.lang.Object r4 = r10.a(r1, r4)
            if (r4 != r3) goto L_0x0138
            return r3
        L_0x0138:
            r3 = r0
            r0 = r4
            r5 = r6
            r10 = r8
            r6 = r9
            r8 = r7
        L_0x013e:
            r7 = r0
            io.monedata.q r7 = (io.monedata.q) r7
            io.monedata.i0 r0 = io.monedata.i0.a
            io.monedata.h0 r9 = r0.a()
            io.monedata.k0 r0 = io.monedata.k0.a
            io.monedata.j0 r11 = r0.a(r1)
            java.lang.String r12 = r3.getId()
            io.monedata.identifier.IdentifierType r13 = r3.getType()
            io.monedata.f0 r0 = new io.monedata.f0
            java.lang.String r14 = "1.7.1"
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.g0.a(android.content.Context, java.lang.String, io.monedata.models.Extras, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
