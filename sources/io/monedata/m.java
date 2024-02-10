package io.monedata;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lio/monedata/k;", "Landroid/content/Context;", "context", "", "assetKey", "Lkotlin/Result;", "Lio/monedata/s;", "a", "(Lio/monedata/k;Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_productionRelease"}, k = 2, mv = {1, 7, 1})
public final class m {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.monedata.api.extensions.ApiServiceKt", f = "ApiService.kt", i = {}, l = {10, 13}, m = "getConfig", n = {}, s = {})
    static final class a extends ContinuationImpl {
        /* synthetic */ Object a;
        int b;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            Object a2 = m.a((k) null, (Context) null, (String) null, this);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m2343boximpl(a2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x005c A[Catch:{ all -> 0x006a }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object a(io.monedata.k r9, android.content.Context r10, java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Result<io.monedata.s>> r12) {
        /*
            boolean r9 = r12 instanceof io.monedata.m.a
            if (r9 == 0) goto L_0x0013
            r9 = r12
            io.monedata.m$a r9 = (io.monedata.m.a) r9
            int r0 = r9.b
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L_0x0013
            int r0 = r0 - r1
            r9.b = r0
            goto L_0x0018
        L_0x0013:
            io.monedata.m$a r9 = new io.monedata.m$a
            r9.<init>(r12)
        L_0x0018:
            java.lang.Object r12 = r9.a
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r9.b
            r8 = 2
            r1 = 1
            if (r0 == 0) goto L_0x0038
            if (r0 == r1) goto L_0x0034
            if (r0 != r8) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x006a }
            goto L_0x005d
        L_0x002c:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x006a }
            goto L_0x004e
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlin.Result$Companion r12 = kotlin.Result.Companion     // Catch:{ all -> 0x006a }
            io.monedata.g0 r0 = io.monedata.g0.a     // Catch:{ all -> 0x006a }
            r3 = 0
            r5 = 4
            r6 = 0
            r9.b = r1     // Catch:{ all -> 0x006a }
            r1 = r10
            r2 = r11
            r4 = r9
            java.lang.Object r12 = io.monedata.g0.a(r0, r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x006a }
            if (r12 != r7) goto L_0x004e
            return r7
        L_0x004e:
            io.monedata.f0 r12 = (io.monedata.f0) r12     // Catch:{ all -> 0x006a }
            io.monedata.k r10 = io.monedata.l.a()     // Catch:{ all -> 0x006a }
            r9.b = r8     // Catch:{ all -> 0x006a }
            java.lang.Object r12 = r10.c(r12, r9)     // Catch:{ all -> 0x006a }
            if (r12 != r7) goto L_0x005d
            return r7
        L_0x005d:
            io.monedata.o1 r12 = (io.monedata.o1) r12     // Catch:{ all -> 0x006a }
            java.lang.Object r9 = io.monedata.p1.a(r12)     // Catch:{ all -> 0x006a }
            io.monedata.s r9 = (io.monedata.s) r9     // Catch:{ all -> 0x006a }
            java.lang.Object r9 = kotlin.Result.m2344constructorimpl(r9)     // Catch:{ all -> 0x006a }
            goto L_0x0075
        L_0x006a:
            r9 = move-exception
            kotlin.Result$Companion r10 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m2344constructorimpl(r9)
        L_0x0075:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.m.a(io.monedata.k, android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
