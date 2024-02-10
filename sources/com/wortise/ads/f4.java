package com.wortise.ads;

import android.content.Context;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"", "Lcom/wortise/ads/e4;", "Landroid/content/Context;", "context", "Lcom/wortise/ads/l1;", "config", "", "a", "(Ljava/util/Collection;Landroid/content/Context;Lcom/wortise/ads/l1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/util/Collection;Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: IJobManager.kt */
public final class f4 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.jobs.extensions.IJobManagerKt", f = "IJobManager.kt", i = {0, 0}, l = {7}, m = "start", n = {"context", "config"}, s = {"L$0", "L$1"})
    /* compiled from: IJobManager.kt */
    static final class a extends ContinuationImpl {
        Object a;
        Object b;
        Object c;
        /* synthetic */ Object d;
        int e;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return f4.a((Collection<? extends e4>) null, (Context) null, (l1) null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.jobs.extensions.IJobManagerKt", f = "IJobManager.kt", i = {0}, l = {9}, m = "stop", n = {"context"}, s = {"L$0"})
    /* compiled from: IJobManager.kt */
    static final class b extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        int d;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return f4.a((Collection<? extends e4>) null, (Context) null, this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.wortise.ads.l1} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(java.util.Collection<? extends com.wortise.ads.e4> r4, android.content.Context r5, com.wortise.ads.l1 r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            boolean r0 = r7 instanceof com.wortise.ads.f4.a
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.f4$a r0 = (com.wortise.ads.f4.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.f4$a r0 = new com.wortise.ads.f4$a
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r4 = r0.c
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r0.b
            r6 = r5
            com.wortise.ads.l1 r6 = (com.wortise.ads.l1) r6
            java.lang.Object r5 = r0.a
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0045
        L_0x0036:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r7)
            java.util.Iterator r4 = r4.iterator()
        L_0x0045:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x0060
            java.lang.Object r7 = r4.next()
            com.wortise.ads.e4 r7 = (com.wortise.ads.e4) r7
            r0.a = r5
            r0.b = r6
            r0.c = r4
            r0.e = r3
            java.lang.Object r7 = r7.a(r5, r6, r0)
            if (r7 != r1) goto L_0x0045
            return r1
        L_0x0060:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.f4.a(java.util.Collection, android.content.Context, com.wortise.ads.l1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(java.util.Collection<? extends com.wortise.ads.e4> r4, android.content.Context r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            boolean r0 = r6 instanceof com.wortise.ads.f4.b
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.wortise.ads.f4$b r0 = (com.wortise.ads.f4.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.f4$b r0 = new com.wortise.ads.f4$b
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r4 = r0.b
            java.util.Iterator r4 = (java.util.Iterator) r4
            java.lang.Object r5 = r0.a
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0040
        L_0x0031:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            java.util.Iterator r4 = r4.iterator()
        L_0x0040:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L_0x0059
            java.lang.Object r6 = r4.next()
            com.wortise.ads.e4 r6 = (com.wortise.ads.e4) r6
            r0.a = r5
            r0.b = r4
            r0.d = r3
            java.lang.Object r6 = r6.a(r5, r0)
            if (r6 != r1) goto L_0x0040
            return r1
        L_0x0059:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.f4.a(java.util.Collection, android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
