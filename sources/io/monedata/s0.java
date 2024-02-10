package io.monedata;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lio/monedata/s0;", "Lio/monedata/x0;", "Landroid/content/Context;", "context", "Lio/monedata/identifier/Identifier;", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class s0 implements x0 {
    public static final s0 a = new s0();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.identifier.impl.GoogleAppSet", f = "GoogleAppSet.kt", i = {}, l = {18}, m = "fetch", n = {}, s = {})
    static final class a extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ s0 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(s0 s0Var, Continuation<? super a> continuation) {
            super(continuation);
            this.b = s0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((Context) null, this);
        }
    }

    private s0() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0073, code lost:
        if (r5.a(r2) == false) goto L_0x0077;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(android.content.Context r5, kotlin.coroutines.Continuation<? super io.monedata.identifier.Identifier> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.monedata.s0.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            io.monedata.s0$a r0 = (io.monedata.s0.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            io.monedata.s0$a r0 = new io.monedata.s0$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004f
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            com.google.android.gms.appset.AppSetIdClient r5 = com.google.android.gms.appset.AppSet.getClient(r5)
            java.lang.String r6 = "getClient(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            com.google.android.gms.tasks.Task r5 = r5.getAppSetIdInfo()
            java.lang.String r6 = "client.appSetIdInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r0.c = r3
            java.lang.Object r6 = kotlinx.coroutines.tasks.TasksKt.await(r5, r0)
            if (r6 != r1) goto L_0x004f
            return r1
        L_0x004f:
            com.google.android.gms.appset.AppSetIdInfo r6 = (com.google.android.gms.appset.AppSetIdInfo) r6
            java.lang.String r5 = r6.getId()
            java.lang.String r0 = "info.id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            int r5 = r5.length()
            r1 = 0
            if (r5 <= 0) goto L_0x0063
            r5 = 1
            goto L_0x0064
        L_0x0063:
            r5 = 0
        L_0x0064:
            if (r5 == 0) goto L_0x0076
            io.monedata.z1 r5 = io.monedata.z1.a
            java.lang.String r2 = r6.getId()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            boolean r5 = r5.a(r2)
            if (r5 != 0) goto L_0x0076
            goto L_0x0077
        L_0x0076:
            r3 = 0
        L_0x0077:
            if (r3 == 0) goto L_0x0088
            io.monedata.identifier.Identifier r5 = new io.monedata.identifier.Identifier
            java.lang.String r6 = r6.getId()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            io.monedata.identifier.IdentifierType r0 = io.monedata.identifier.IdentifierType.GOOGLE_APP_SET
            r5.<init>(r6, r1, r0)
            return r5
        L_0x0088:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Failed requirement."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.s0.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
