package com.wortise.ads;

import android.content.Context;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/wortise/ads/m3;", "Lcom/wortise/ads/s;", "Landroid/content/Context;", "context", "Lcom/wortise/ads/identifier/Identifier;", "a", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GoogleAppSet.kt */
public final class m3 extends s {
    public static final m3 a = new m3();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.identifier.modules.GoogleAppSet", f = "GoogleAppSet.kt", i = {}, l = {18}, m = "fetch", n = {}, s = {})
    /* compiled from: GoogleAppSet.kt */
    static final class a extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ m3 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(m3 m3Var, Continuation<? super a> continuation) {
            super(continuation);
            this.b = m3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((Context) null, this);
        }
    }

    private m3() {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
        if (r6.a(r2) == false) goto L_0x007f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(android.content.Context r6, kotlin.coroutines.Continuation<? super com.wortise.ads.identifier.Identifier> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.wortise.ads.m3.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.m3$a r0 = (com.wortise.ads.m3.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.m3$a r0 = new com.wortise.ads.m3$a
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            java.lang.String r3 = "Failed requirement."
            r4 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r4) goto L_0x002b
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0057
        L_0x002b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = com.wortise.ads.AdSettings.isChildDirected(r6)
            if (r7 == 0) goto L_0x009a
            com.google.android.gms.appset.AppSetIdClient r6 = com.google.android.gms.appset.AppSet.getClient(r6)
            java.lang.String r7 = "getClient(context)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            com.google.android.gms.tasks.Task r6 = r6.getAppSetIdInfo()
            java.lang.String r7 = "client.appSetIdInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            r0.c = r4
            java.lang.Object r7 = kotlinx.coroutines.tasks.TasksKt.await(r6, r0)
            if (r7 != r1) goto L_0x0057
            return r1
        L_0x0057:
            com.google.android.gms.appset.AppSetIdInfo r7 = (com.google.android.gms.appset.AppSetIdInfo) r7
            java.lang.String r6 = r7.getId()
            java.lang.String r0 = "info.id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            int r6 = r6.length()
            r1 = 0
            if (r6 <= 0) goto L_0x006b
            r6 = 1
            goto L_0x006c
        L_0x006b:
            r6 = 0
        L_0x006c:
            if (r6 == 0) goto L_0x007e
            com.wortise.ads.w6 r6 = com.wortise.ads.w6.a
            java.lang.String r2 = r7.getId()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            boolean r6 = r6.a(r2)
            if (r6 != 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r4 = 0
        L_0x007f:
            if (r4 == 0) goto L_0x0090
            com.wortise.ads.identifier.Identifier r6 = new com.wortise.ads.identifier.Identifier
            java.lang.String r7 = r7.getId()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            com.wortise.ads.identifier.IdentifierType r0 = com.wortise.ads.identifier.IdentifierType.GOOGLE_APP_SET
            r6.<init>(r7, r1, r0)
            return r6
        L_0x0090:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r3.toString()
            r6.<init>(r7)
            throw r6
        L_0x009a:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = r3.toString()
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.m3.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
