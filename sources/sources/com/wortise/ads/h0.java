package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.n4;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00018\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\bJ\u0019\u0010\t\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0014¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\t\u001a\u00020\u000b2\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H¤@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007J\u0013\u0010\t\u001a\u00020\u000bH¤@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\bR\u001a\u0010\r\u001a\u00020\f8\u0004X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0011\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0006\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lcom/wortise/ads/h0;", "Lcom/wortise/ads/n4;", "T", "", "config", "", "b", "(Lcom/wortise/ads/n4;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "(Lcom/wortise/ads/n4;)Z", "", "Landroid/content/Context;", "context", "Landroid/content/Context;", "()Landroid/content/Context;", "", "name", "Ljava/lang/String;", "()Ljava/lang/String;", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: BaseJob.kt */
public abstract class h0<T extends n4> {
    private final Context a;
    private final String b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.jobs.bases.BaseJob", f = "BaseJob.kt", i = {0, 1}, l = {12, 16}, m = "start", n = {"this", "this"}, s = {"L$0", "L$0"})
    /* compiled from: BaseJob.kt */
    static final class a extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ h0<T> c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(h0<T> h0Var, Continuation<? super a> continuation) {
            super(continuation);
            this.c = h0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.b(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.jobs.bases.BaseJob", f = "BaseJob.kt", i = {0}, l = {31}, m = "stop", n = {"this"}, s = {"L$0"})
    /* compiled from: BaseJob.kt */
    static final class b extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ h0<T> c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(h0<T> h0Var, Continuation<? super b> continuation) {
            super(continuation);
            this.c = h0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.b(this);
        }
    }

    public h0(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = context;
        this.b = str;
    }

    /* access modifiers changed from: protected */
    public final Context a() {
        return this.a;
    }

    /* access modifiers changed from: protected */
    public abstract Object a(T t, Continuation<? super Unit> continuation);

    /* access modifiers changed from: protected */
    public abstract Object a(Continuation<? super Unit> continuation);

    public final String b() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public boolean a(T t) {
        return !(t != null && !t.a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:27:0x0058=Splitter:B:27:0x0058, B:35:0x0069=Splitter:B:35:0x0069} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(T r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.wortise.ads.h0.a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.h0$a r0 = (com.wortise.ads.h0.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.h0$a r0 = new com.wortise.ads.h0$a
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 == r5) goto L_0x0039
            if (r2 != r4) goto L_0x0031
            java.lang.Object r7 = r0.a
            com.wortise.ads.h0 r7 = (com.wortise.ads.h0) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0041 }
            goto L_0x0069
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0039:
            java.lang.Object r7 = r0.a
            com.wortise.ads.h0 r7 = (com.wortise.ads.h0) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0041 }
            goto L_0x0058
        L_0x0041:
            r8 = move-exception
            goto L_0x007b
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r8)
            boolean r8 = r6.a(r7)     // Catch:{ all -> 0x0079 }
            if (r8 != 0) goto L_0x005d
            r0.a = r6     // Catch:{ all -> 0x0079 }
            r0.d = r5     // Catch:{ all -> 0x0079 }
            java.lang.Object r7 = r6.b(r0)     // Catch:{ all -> 0x0079 }
            if (r7 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r7 = r6
        L_0x0058:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch:{ all -> 0x0041 }
            return r7
        L_0x005d:
            r0.a = r6     // Catch:{ all -> 0x0079 }
            r0.d = r4     // Catch:{ all -> 0x0079 }
            java.lang.Object r7 = r6.a(r7, r0)     // Catch:{ all -> 0x0079 }
            if (r7 != r1) goto L_0x0068
            return r1
        L_0x0068:
            r7 = r6
        L_0x0069:
            java.lang.String r8 = r7.b()     // Catch:{ all -> 0x0041 }
            java.lang.String r0 = " job started"
            java.lang.String r8 = kotlin.jvm.internal.Intrinsics.stringPlus(r8, r0)     // Catch:{ all -> 0x0041 }
            r0 = 0
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r8, (java.lang.Throwable) r0, (int) r4, (java.lang.Object) r0)     // Catch:{ all -> 0x0041 }
            r3 = 1
            goto L_0x0088
        L_0x0079:
            r8 = move-exception
            r7 = r6
        L_0x007b:
            java.lang.String r7 = r7.b()
            java.lang.String r0 = "Failed to start job "
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r7)
            com.wortise.ads.WortiseLog.e((java.lang.String) r7, (java.lang.Throwable) r8)
        L_0x0088:
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.h0.b(com.wortise.ads.n4, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super java.lang.Boolean> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.wortise.ads.h0.b
            if (r0 == 0) goto L_0x0013
            r0 = r5
            com.wortise.ads.h0$b r0 = (com.wortise.ads.h0.b) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.h0$b r0 = new com.wortise.ads.h0$b
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r0 = r0.a
            com.wortise.ads.h0 r0 = (com.wortise.ads.h0) r0
            kotlin.ResultKt.throwOnFailure(r5)     // Catch:{ all -> 0x002d }
            goto L_0x0046
        L_0x002d:
            r5 = move-exception
            goto L_0x0058
        L_0x002f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.a = r4     // Catch:{ all -> 0x0056 }
            r0.d = r3     // Catch:{ all -> 0x0056 }
            java.lang.Object r5 = r4.a((kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)     // Catch:{ all -> 0x0056 }
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r4
        L_0x0046:
            java.lang.String r5 = r0.b()     // Catch:{ all -> 0x002d }
            java.lang.String r1 = " job stopped"
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r5, r1)     // Catch:{ all -> 0x002d }
            r1 = 2
            r2 = 0
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r5, (java.lang.Throwable) r2, (int) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x002d }
            goto L_0x0066
        L_0x0056:
            r5 = move-exception
            r0 = r4
        L_0x0058:
            java.lang.String r0 = r0.b()
            java.lang.String r1 = "Failed to stop job "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r0)
            com.wortise.ads.WortiseLog.e((java.lang.String) r0, (java.lang.Throwable) r5)
            r3 = 0
        L_0x0066:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.h0.b(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
