package com.wortise.ads;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aA\u0010\u0007\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"T", "Lokhttp3/OkHttpClient;", "Lokhttp3/Request;", "request", "Lkotlin/Function1;", "Lokhttp3/ResponseBody;", "block", "a", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sdk_productionRelease"}, k = 2, mv = {1, 5, 1})
/* compiled from: OkHttpClient.kt */
public final class i5 {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.okhttp.extensions.OkHttpClientKt", f = "OkHttpClient.kt", i = {0, 0}, l = {12}, m = "fetch", n = {"block", "log$iv"}, s = {"L$0", "I$0"})
    /* compiled from: OkHttpClient.kt */
    static final class a<T> extends ContinuationImpl {
        Object a;
        int b;
        /* synthetic */ Object c;
        int d;

        a(Continuation<? super a> continuation) {
            super(continuation);
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.d |= Integer.MIN_VALUE;
            return i5.a((OkHttpClient) null, (Request) null, (Function1) null, this);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: kotlin.jvm.functions.Function1<? super okhttp3.ResponseBody, ? extends T>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x005c A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object a(okhttp3.OkHttpClient r5, okhttp3.Request r6, kotlin.jvm.functions.Function1<? super okhttp3.ResponseBody, ? extends T> r7, kotlin.coroutines.Continuation<? super T> r8) {
        /*
            boolean r0 = r8 instanceof com.wortise.ads.i5.a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.i5$a r0 = (com.wortise.ads.i5.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.i5$a r0 = new com.wortise.ads.i5$a
            r0.<init>(r8)
        L_0x0018:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            int r5 = r0.b
            java.lang.Object r6 = r0.a
            r7 = r6
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0031 }
            goto L_0x0057
        L_0x0031:
            r6 = move-exception
            goto L_0x006d
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            okhttp3.Call r5 = r5.newCall(r6)     // Catch:{ all -> 0x006b }
            java.lang.String r6 = "newCall(request)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ all -> 0x006b }
            r0.a = r7     // Catch:{ all -> 0x006b }
            r0.b = r8     // Catch:{ all -> 0x006b }
            r0.d = r4     // Catch:{ all -> 0x006b }
            java.lang.Object r5 = com.wortise.ads.y0.a(r5, r0)     // Catch:{ all -> 0x006b }
            if (r5 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r8 = r5
            r5 = 0
        L_0x0057:
            okhttp3.Response r8 = (okhttp3.Response) r8     // Catch:{ all -> 0x0031 }
            if (r8 != 0) goto L_0x005c
            goto L_0x007a
        L_0x005c:
            okhttp3.ResponseBody r6 = r8.body()     // Catch:{ all -> 0x0031 }
            if (r6 != 0) goto L_0x0063
            goto L_0x007a
        L_0x0063:
            if (r7 != 0) goto L_0x0066
            goto L_0x007a
        L_0x0066:
            java.lang.Object r3 = r7.invoke(r6)     // Catch:{ all -> 0x0031 }
            goto L_0x007a
        L_0x006b:
            r6 = move-exception
            r5 = 0
        L_0x006d:
            if (r5 == 0) goto L_0x007a
            java.lang.String r5 = r6.getMessage()
            if (r5 != 0) goto L_0x0077
            java.lang.String r5 = "Caught an exception"
        L_0x0077:
            com.wortise.ads.WortiseLog.e((java.lang.String) r5, (java.lang.Throwable) r6)
        L_0x007a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.i5.a(okhttp3.OkHttpClient, okhttp3.Request, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object a(OkHttpClient okHttpClient, Request request, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return a(okHttpClient, request, function1, continuation);
    }
}
