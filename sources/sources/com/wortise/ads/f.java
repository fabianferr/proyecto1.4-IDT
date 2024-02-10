package com.wortise.ads;

import com.google.android.gms.ads.AdError;
import com.wortise.ads.g;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¢\u0006\u0004\b\u0005\u0010\bJR\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\n\u001a\u00020\t2-\u0010\u0010\u001a)\b\u0001\u0012\u0004\u0012\u00020\f\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b¢\u0006\u0002\b\u000fH@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0011R\u0018\u0010\u0015\u001a\u00020\u0013*\u00020\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/wortise/ads/f;", "", "T", "Lcom/wortise/ads/g$a$a;", "result", "a", "(Lcom/wortise/ads/g$a$a;)Ljava/lang/Object;", "Lcom/wortise/ads/g$a$b;", "(Lcom/wortise/ads/g$a$b;)Ljava/lang/Object;", "", "timeout", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "Lcom/wortise/ads/g$a;", "Lkotlin/ExtensionFunctionType;", "block", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/ads/AdError;", "", "(Lcom/google/android/gms/ads/AdError;)Ljava/lang/String;", "line", "Lcom/wortise/ads/k3;", "type", "adUnitId", "<init>", "(Lcom/wortise/ads/k3;Ljava/lang/String;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdHelper.kt */
public final class f {
    private final String a;
    private final String b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.google.AdHelper", f = "AdHelper.kt", i = {0}, l = {22}, m = "load", n = {"this"}, s = {"L$0"})
    /* compiled from: AdHelper.kt */
    static final class a<T> extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ f c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(f fVar, Continuation<? super a> continuation) {
            super(continuation);
            this.c = fVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a(0, (Function2) null, this);
        }
    }

    public f(k3 k3Var, String str) {
        Intrinsics.checkNotNullParameter(k3Var, "type");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        this.a = str;
        this.b = k3Var.b();
    }

    /* JADX WARNING: type inference failed for: r9v3, types: [com.wortise.ads.g$a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object a(long r6, kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super com.wortise.ads.g.a<T>>, ? extends java.lang.Object> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.wortise.ads.f.a
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.wortise.ads.f$a r0 = (com.wortise.ads.f.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.f$a r0 = new com.wortise.ads.f$a
            r0.<init>(r5, r9)
        L_0x0018:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r6 = r0.a
            com.wortise.ads.f r6 = (com.wortise.ads.f) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0063
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r2 = "Loading Google "
            r9.<init>(r2)
            java.lang.String r2 = r5.b
            r9.append(r2)
            java.lang.String r2 = " ad with ad unit "
            r9.append(r2)
            java.lang.String r2 = r5.a
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            r2 = 2
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r9, (java.lang.Throwable) r4, (int) r2, (java.lang.Object) r4)
            r0.a = r5
            r0.d = r3
            java.lang.Object r9 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r6, r8, r0)
            if (r9 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r6 = r5
        L_0x0063:
            com.wortise.ads.g$a r9 = (com.wortise.ads.g.a) r9
            boolean r7 = r9 instanceof com.wortise.ads.g.a.b
            if (r7 == 0) goto L_0x0070
            com.wortise.ads.g$a$b r9 = (com.wortise.ads.g.a.b) r9
            java.lang.Object r6 = r6.a(r9)
            goto L_0x007b
        L_0x0070:
            boolean r7 = r9 instanceof com.wortise.ads.g.a.C0184a
            if (r7 == 0) goto L_0x0077
            r4 = r9
            com.wortise.ads.g$a$a r4 = (com.wortise.ads.g.a.C0184a) r4
        L_0x0077:
            java.lang.Object r6 = r6.a(r4)
        L_0x007b:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.f.a(long, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0003, code lost:
        r3 = r3.a();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T a(com.wortise.ads.g.a.C0184a<T> r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            goto L_0x0009
        L_0x0003:
            com.google.android.gms.ads.AdError r3 = r3.a()
            if (r3 != 0) goto L_0x000d
        L_0x0009:
            java.lang.String r3 = "timeout"
            goto L_0x0011
        L_0x000d:
            java.lang.String r3 = r2.a((com.google.android.gms.ads.AdError) r3)
        L_0x0011:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to load Google "
            r0.<init>(r1)
            java.lang.String r1 = r2.b
            r0.append(r1)
            java.lang.String r1 = " ad with ad unit "
            r0.append(r1)
            java.lang.String r1 = r2.a
            r0.append(r1)
            java.lang.String r1 = " ("
            r0.append(r1)
            r0.append(r3)
            r3 = 41
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r0 = 2
            r1 = 0
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r3, (java.lang.Throwable) r1, (int) r0, (java.lang.Object) r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.f.a(com.wortise.ads.g$a$a):java.lang.Object");
    }

    private final <T> T a(g.a.b<T> bVar) {
        WortiseLog.d$default("Loaded Google " + this.b + " ad with ad unit " + this.a, (Throwable) null, 2, (Object) null);
        return bVar.a();
    }

    private final String a(AdError adError) {
        return "code = " + adError.getCode() + ", message = " + adError.getMessage();
    }
}
