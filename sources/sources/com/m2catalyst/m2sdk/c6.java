package com.m2catalyst.m2sdk;

import java.util.List;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SQLUtils.kt */
public final class c6 {

    @DebugMetadata(c = "com.m2catalyst.m2sdk.utils.SQLUtilsKt", f = "SQLUtils.kt", i = {0, 0, 0, 0, 0}, l = {23}, m = "executeDBOperations", n = {"$this$executeDBOperations", "block", "operations", "next", "i"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2"})
    /* compiled from: SQLUtils.kt */
    public static final class a<T> extends ContinuationImpl {
        public List a;
        public Function2 b;
        public int c;
        public int d;
        public int e;
        public /* synthetic */ Object f;
        public int g;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.g |= Integer.MIN_VALUE;
            return c6.a((List) null, (Function2) null, (Continuation<? super Integer>) this);
        }
    }

    public static final String a(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(str2, "str");
        boolean z = false;
        if (str3 == null || str3.length() == 0) {
            return str;
        }
        if (!(str2.length() > 0)) {
            return str;
        }
        if (str.length() > 0) {
            z = true;
        }
        if (z) {
            str = str + " AND ";
        }
        return str + str2 + " " + str3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object a(java.util.List<? extends T> r8, kotlin.jvm.functions.Function2<? super java.util.List<? extends T>, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r9, kotlin.coroutines.Continuation<? super java.lang.Integer> r10) {
        /*
            boolean r0 = r10 instanceof com.m2catalyst.m2sdk.c6.a
            if (r0 == 0) goto L_0x0013
            r0 = r10
            com.m2catalyst.m2sdk.c6$a r0 = (com.m2catalyst.m2sdk.c6.a) r0
            int r1 = r0.g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.g = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.c6$a r0 = new com.m2catalyst.m2sdk.c6$a
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.f
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.g
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r8 = r0.e
            int r9 = r0.d
            int r2 = r0.c
            kotlin.jvm.functions.Function2 r4 = r0.b
            java.util.List r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = r4
            goto L_0x007a
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r10)
            int r10 = r8.size()
            r2 = 0
            r4 = 900(0x384, float:1.261E-42)
            if (r10 != 0) goto L_0x004a
            r10 = 0
            goto L_0x004c
        L_0x004a:
            int r10 = r10 / r4
            int r10 = r10 + r3
        L_0x004c:
            if (r10 <= 0) goto L_0x0086
            if (r3 > r10) goto L_0x0086
            r2 = r10
            r5 = 0
            r10 = r9
            r9 = 1
        L_0x0054:
            int r6 = r8.size()
            if (r6 >= r4) goto L_0x005f
            int r6 = r8.size()
            goto L_0x0060
        L_0x005f:
            r6 = r4
        L_0x0060:
            java.util.List r5 = r8.subList(r5, r6)
            r0.a = r8
            r0.b = r10
            r0.c = r2
            r0.d = r4
            r0.e = r9
            r0.g = r3
            java.lang.Object r5 = r10.invoke(r5, r0)
            if (r5 != r1) goto L_0x0077
            return r1
        L_0x0077:
            r5 = r8
            r8 = r9
            r9 = r4
        L_0x007a:
            int r4 = r9 + 900
            if (r8 == r2) goto L_0x0085
            int r8 = r8 + 1
            r7 = r9
            r9 = r8
            r8 = r5
            r5 = r7
            goto L_0x0054
        L_0x0085:
            r10 = r2
        L_0x0086:
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.c6.a(java.util.List, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
