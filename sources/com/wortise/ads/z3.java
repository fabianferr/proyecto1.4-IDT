package com.wortise.ads;

import android.content.Context;
import java.io.File;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002JE\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J/\u0010\u0005\u001a\u0004\u0018\u00010\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u001b\b\u0002\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000b¢\u0006\u0002\b\u0014J#\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0016J%\u0010\u0005\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0018J%\u0010\u0007\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0018\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/wortise/ads/z3;", "", "Landroid/content/Context;", "context", "Lokhttp3/Cache;", "a", "Lokhttp3/OkHttpClient;", "b", "T", "Lokhttp3/Request;", "request", "Lkotlin/Function1;", "Lokhttp3/ResponseBody;", "block", "(Landroid/content/Context;Lokhttp3/Request;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "", "url", "Lokhttp3/Request$Builder;", "", "Lkotlin/ExtensionFunctionType;", "", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Landroid/content/Context;Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/io/InputStream;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: HttpClient.kt */
public final class z3 {
    public static final z3 a = new z3();
    private static OkHttpClient b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.network.http.HttpClient", f = "HttpClient.kt", i = {}, l = {35}, m = "cache", n = {}, s = {})
    /* compiled from: HttpClient.kt */
    static final class a extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ z3 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(z3 z3Var, Continuation<? super a> continuation) {
            super(continuation);
            this.b = z3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((Context) null, (String) null, (Continuation<? super Boolean>) this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: HttpClient.kt */
    /* synthetic */ class b extends FunctionReferenceImpl implements Function1<ResponseBody, Long> {
        public static final b a = new b();

        b() {
            super(1, x5.class, "consume", "consume(Lokhttp3/ResponseBody;)J", 1);
        }

        /* renamed from: a */
        public final Long invoke(ResponseBody responseBody) {
            Intrinsics.checkNotNullParameter(responseBody, "p0");
            return Long.valueOf(x5.a(responseBody));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Lokhttp3/OkHttpClient$Builder;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HttpClient.kt */
    static final class c extends Lambda implements Function1<OkHttpClient.Builder, Unit> {
        final /* synthetic */ Cache a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Cache cache) {
            super(1);
            this.a = cache;
        }

        public final void a(OkHttpClient.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "$this$create");
            builder.cache(this.a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((OkHttpClient.Builder) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.network.http.HttpClient", f = "HttpClient.kt", i = {0}, l = {71}, m = "fetch", n = {"log$iv"}, s = {"I$0"})
    /* compiled from: HttpClient.kt */
    static final class d<T> extends ContinuationImpl {
        int a;
        /* synthetic */ Object b;
        final /* synthetic */ z3 c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(z3 z3Var, Continuation<? super d> continuation) {
            super(continuation);
            this.c = z3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Context) null, (Request) null, (Function1) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lokhttp3/ResponseBody;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HttpClient.kt */
    static final class e extends Lambda implements Function1<ResponseBody, byte[]> {
        public static final e a = new e();

        e() {
            super(1);
        }

        /* renamed from: a */
        public final byte[] invoke(ResponseBody responseBody) {
            Intrinsics.checkNotNullParameter(responseBody, "it");
            return responseBody.bytes();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lokhttp3/ResponseBody;", "it", "Ljava/io/InputStream;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HttpClient.kt */
    static final class f extends Lambda implements Function1<ResponseBody, InputStream> {
        public static final f a = new f();

        f() {
            super(1);
        }

        /* renamed from: a */
        public final InputStream invoke(ResponseBody responseBody) {
            Intrinsics.checkNotNullParameter(responseBody, "it");
            return responseBody.byteStream();
        }
    }

    private z3() {
    }

    private final synchronized OkHttpClient c(Context context) {
        OkHttpClient okHttpClient;
        okHttpClient = b;
        if (okHttpClient == null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            okHttpClient = b(applicationContext);
            b = okHttpClient;
        }
        return okHttpClient;
    }

    public final Object b(Context context, Request request, Continuation<? super InputStream> continuation) {
        return a(context, request, f.a, continuation);
    }

    public static /* synthetic */ Request a(z3 z3Var, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return z3Var.a(str, function1);
    }

    private final OkHttpClient b(Context context) {
        return j5.a.a(new c(a(context)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0010 A[Catch:{ all -> 0x0028 }] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x000f A[Catch:{ all -> 0x0028 }, RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okhttp3.Request a(java.lang.String r3, kotlin.jvm.functions.Function1<? super okhttp3.Request.Builder, kotlin.Unit> r4) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x000c
            int r1 = r3.length()     // Catch:{ all -> 0x0028 }
            if (r1 != 0) goto L_0x000a
            goto L_0x000c
        L_0x000a:
            r1 = 0
            goto L_0x000d
        L_0x000c:
            r1 = 1
        L_0x000d:
            if (r1 == 0) goto L_0x0010
            return r0
        L_0x0010:
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder     // Catch:{ all -> 0x0028 }
            r1.<init>()     // Catch:{ all -> 0x0028 }
            okhttp3.Request$Builder r3 = r1.url((java.lang.String) r3)     // Catch:{ all -> 0x0028 }
            if (r4 != 0) goto L_0x001c
            goto L_0x0024
        L_0x001c:
            java.lang.String r1 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)     // Catch:{ all -> 0x0028 }
            r4.invoke(r3)     // Catch:{ all -> 0x0028 }
        L_0x0024:
            okhttp3.Request r0 = r3.build()     // Catch:{ all -> 0x0028 }
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.z3.a(java.lang.String, kotlin.jvm.functions.Function1):okhttp3.Request");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r6, java.lang.String r7, kotlin.coroutines.Continuation<? super java.lang.Boolean> r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.wortise.ads.z3.a
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.z3$a r0 = (com.wortise.ads.z3.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.z3$a r0 = new com.wortise.ads.z3$a
            r0.<init>(r5, r8)
        L_0x0018:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r4) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004d
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 2
            r2 = 0
            okhttp3.Request r7 = a((com.wortise.ads.z3) r5, (java.lang.String) r7, (kotlin.jvm.functions.Function1) r2, (int) r8, (java.lang.Object) r2)
            if (r7 != 0) goto L_0x0042
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        L_0x0042:
            com.wortise.ads.z3$b r8 = com.wortise.ads.z3.b.a
            r0.c = r4
            java.lang.Object r8 = r5.a(r6, r7, r8, r0)
            if (r8 != r1) goto L_0x004d
            return r1
        L_0x004d:
            if (r8 == 0) goto L_0x0050
            r3 = 1
        L_0x0050:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.z3.a(android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object a(Context context, Request request, Continuation<? super byte[]> continuation) {
        return a(context, request, e.a, continuation);
    }

    private final Cache a(Context context) {
        x0 x0Var = x0.a;
        File a2 = x0Var.a(context);
        return new Cache(a2, x0.a(x0Var, a2, 0, 2, (Object) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object a(android.content.Context r5, okhttp3.Request r6, kotlin.jvm.functions.Function1<? super okhttp3.ResponseBody, ? extends T> r7, kotlin.coroutines.Continuation<? super T> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.wortise.ads.z3.d
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.z3$d r0 = (com.wortise.ads.z3.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.z3$d r0 = new com.wortise.ads.z3$d
            r0.<init>(r4, r8)
        L_0x0018:
            java.lang.Object r8 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            int r5 = r0.a
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x002b }
            goto L_0x004a
        L_0x002b:
            r6 = move-exception
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            com.wortise.ads.z3 r2 = a     // Catch:{ all -> 0x004b }
            okhttp3.OkHttpClient r5 = r2.c(r5)     // Catch:{ all -> 0x004b }
            r0.a = r8     // Catch:{ all -> 0x004b }
            r0.d = r3     // Catch:{ all -> 0x004b }
            java.lang.Object r8 = com.wortise.ads.i5.a(r5, r6, r7, r0)     // Catch:{ all -> 0x004b }
            if (r8 != r1) goto L_0x004a
            return r1
        L_0x004a:
            return r8
        L_0x004b:
            r5 = move-exception
            r6 = r5
            r5 = 0
        L_0x004e:
            if (r5 == 0) goto L_0x005b
            java.lang.String r5 = r6.getMessage()
            if (r5 != 0) goto L_0x0058
            java.lang.String r5 = "Caught an exception"
        L_0x0058:
            com.wortise.ads.WortiseLog.e((java.lang.String) r5, (java.lang.Throwable) r6)
        L_0x005b:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.z3.a(android.content.Context, okhttp3.Request, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
