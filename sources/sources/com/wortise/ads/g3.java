package com.wortise.ads;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/wortise/ads/g3;", "Lcom/wortise/ads/e4;", "Landroid/content/Context;", "context", "Lcom/wortise/ads/l1;", "config", "", "a", "(Landroid/content/Context;Lcom/wortise/ads/l1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GeosmartManager.kt */
public final class g3 implements e4 {
    public static final g3 a = new g3();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.geofencing.GeosmartManager", f = "GeosmartManager.kt", i = {0}, l = {14}, m = "start", n = {"params"}, s = {"L$0"})
    /* compiled from: GeosmartManager.kt */
    static final class a extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ g3 c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(g3 g3Var, Continuation<? super a> continuation) {
            super(continuation);
            this.c = g3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Context) null, (l1) null, this);
        }
    }

    private g3() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(android.content.Context r5, com.wortise.ads.l1 r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.wortise.ads.g3.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.g3$a r0 = (com.wortise.ads.g3.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.g3$a r0 = new com.wortise.ads.g3$a
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.a
            com.wortise.ads.e3 r5 = (com.wortise.ads.e3) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004d
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            com.wortise.ads.e3 r6 = r6.b()
            com.wortise.ads.h3 r7 = new com.wortise.ads.h3
            r7.<init>(r5)
            r0.a = r6
            r0.d = r3
            java.lang.Object r7 = r7.b(r6, r0)
            if (r7 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r5 = r6
        L_0x004d:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r6 = r7.booleanValue()
            if (r6 != 0) goto L_0x0058
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0058:
            r6 = 0
            if (r5 != 0) goto L_0x005d
            r5 = r6
            goto L_0x0061
        L_0x005d:
            java.lang.String r5 = r5.c()
        L_0x0061:
            java.lang.String r7 = "Geosmart initialized for ad unit "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r7, r5)
            r7 = 2
            com.wortise.ads.WortiseLog.i$default((java.lang.String) r5, (java.lang.Throwable) r6, (int) r7, (java.lang.Object) r6)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.g3.a(android.content.Context, com.wortise.ads.l1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object a(Context context, Continuation<? super Unit> continuation) {
        Object b = new h3(context).b(continuation);
        return b == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? b : Unit.INSTANCE;
    }
}
