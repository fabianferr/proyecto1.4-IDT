package com.wortise.ads;

import java.lang.reflect.Type;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.CacheControl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

@Metadata(bv = {}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0002J1\u0010\u0004\u001a\u0004\u0018\u00010\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u001b\b\u0002\u0010\u000b\u001a\u0015\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0002\b\nH\u0002J\u001b\u0010\u0004\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u000eJ\u001d\u0010\u0004\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u000fJ%\u0010\u0004\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0010R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00118BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0004\u0010\u0014R\u001b\u0010\u001a\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lcom/wortise/ads/y3;", "", "body", "Lokhttp3/RequestBody;", "a", "", "url", "Lkotlin/Function1;", "Lokhttp3/Request$Builder;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lokhttp3/Request;", "request", "(Lokhttp3/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lokhttp3/MediaType;", "mediaJson$delegate", "Lkotlin/Lazy;", "()Lokhttp3/MediaType;", "mediaJson", "Lokhttp3/OkHttpClient;", "okHttpClient$delegate", "b", "()Lokhttp3/OkHttpClient;", "okHttpClient", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: HttpCall.kt */
public final class y3 {
    public static final y3 a = new y3();
    private static final Lazy b = LazyKt.lazy(c.a);
    private static final Lazy c = LazyKt.lazy(d.a);

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.network.http.HttpCall", f = "HttpCall.kt", i = {}, l = {32}, m = "get", n = {}, s = {})
    /* compiled from: HttpCall.kt */
    static final class a extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ y3 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(y3 y3Var, Continuation<? super a> continuation) {
            super(continuation);
            this.b = y3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((String) null, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Lokhttp3/Request$Builder;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HttpCall.kt */
    static final class b extends Lambda implements Function1<Request.Builder, Unit> {
        final /* synthetic */ Function1<Request.Builder, Unit> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Function1<? super Request.Builder, Unit> function1) {
            super(1);
            this.a = function1;
        }

        public final void a(Request.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "$this$getRequest");
            builder.cacheControl(CacheControl.FORCE_NETWORK);
            Function1<Request.Builder, Unit> function1 = this.a;
            if (function1 != null) {
                function1.invoke(builder);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Request.Builder) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n"}, d2 = {"Lokhttp3/MediaType;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HttpCall.kt */
    static final class c extends Lambda implements Function0<MediaType> {
        public static final c a = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final MediaType invoke() {
            return MediaType.parse("application/json; charset=utf-8");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lokhttp3/OkHttpClient;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HttpCall.kt */
    static final class d extends Lambda implements Function0<OkHttpClient> {
        public static final d a = new d();

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Lokhttp3/OkHttpClient$Builder;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        /* compiled from: HttpCall.kt */
        static final class a extends Lambda implements Function1<OkHttpClient.Builder, Unit> {
            public static final a a = new a();

            a() {
                super(1);
            }

            public final void a(OkHttpClient.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "$this$create");
                builder.addInterceptor(s3.a);
                builder.followRedirects(false);
                builder.followSslRedirects(false);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((OkHttpClient.Builder) obj);
                return Unit.INSTANCE;
            }
        }

        d() {
            super(0);
        }

        /* renamed from: a */
        public final OkHttpClient invoke() {
            return j5.a.a(a.a);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.network.http.HttpCall", f = "HttpCall.kt", i = {}, l = {40}, m = "post", n = {}, s = {})
    /* compiled from: HttpCall.kt */
    static final class e extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ y3 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(y3 y3Var, Continuation<? super e> continuation) {
            super(continuation);
            this.b = y3Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((String) null, (Object) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n"}, d2 = {"Lokhttp3/Request$Builder;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: HttpCall.kt */
    static final class f extends Lambda implements Function1<Request.Builder, Unit> {
        final /* synthetic */ Object a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Object obj) {
            super(1);
            this.a = obj;
        }

        public final void a(Request.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "$this$getRequest");
            builder.post(y3.a.a(this.a));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Request.Builder) obj);
            return Unit.INSTANCE;
        }
    }

    private y3() {
    }

    private final OkHttpClient b() {
        return (OkHttpClient) c.getValue();
    }

    private final MediaType a() {
        return (MediaType) b.getValue();
    }

    public final Object a(Request request, Continuation<? super Unit> continuation) {
        Object a2 = i5.a(b(), request, (Function1) null, continuation, 2, (Object) null);
        return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.wortise.ads.y3.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.wortise.ads.y3$a r0 = (com.wortise.ads.y3.a) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.y3$a r0 = new com.wortise.ads.y3$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0048
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = 2
            r2 = 0
            okhttp3.Request r5 = a(r4, r5, r2, r6, r2)
            if (r5 != 0) goto L_0x003d
            goto L_0x0048
        L_0x003d:
            com.wortise.ads.y3 r6 = a
            r0.c = r3
            java.lang.Object r5 = r6.a((okhttp3.Request) r5, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r5 != r1) goto L_0x0048
            return r1
        L_0x0048:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.y3.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r5, java.lang.Object r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.wortise.ads.y3.e
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.y3$e r0 = (com.wortise.ads.y3.e) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.y3$e r0 = new com.wortise.ads.y3$e
            r0.<init>(r4, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004b
        L_0x0029:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0031:
            kotlin.ResultKt.throwOnFailure(r7)
            com.wortise.ads.y3$f r7 = new com.wortise.ads.y3$f
            r7.<init>(r6)
            okhttp3.Request r5 = r4.a((java.lang.String) r5, (kotlin.jvm.functions.Function1<? super okhttp3.Request.Builder, kotlin.Unit>) r7)
            if (r5 != 0) goto L_0x0040
            goto L_0x004b
        L_0x0040:
            com.wortise.ads.y3 r6 = a
            r0.c = r3
            java.lang.Object r5 = r6.a((okhttp3.Request) r5, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0)
            if (r5 != r1) goto L_0x004b
            return r1
        L_0x004b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.y3.a(java.lang.String, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final RequestBody a(Object obj) {
        RequestBody create = RequestBody.create(a(), q4.a(q4.a, obj, (Type) null, 2, (Object) null));
        Intrinsics.checkNotNullExpressionValue(create, "create(mediaJson, JsonParser.toJson(body))");
        return create;
    }

    static /* synthetic */ Request a(y3 y3Var, String str, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        return y3Var.a(str, (Function1<? super Request.Builder, Unit>) function1);
    }

    private final Request a(String str, Function1<? super Request.Builder, Unit> function1) {
        try {
            return z3.a.a(str, new b(function1));
        } catch (Throwable unused) {
            return null;
        }
    }
}
