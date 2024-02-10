package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.device.Dimensions;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 *2\u00020\u0001:\u0002\f\u0005B7\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010#\u001a\u00020\u001f¢\u0006\u0004\b(\u0010)J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0013\u0010\u0005\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0006J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\bH\u0002J\u0013\u0010\f\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\f\u0010\u000e\u001a\u0004\b\t\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\f\u0010\u0013R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u001a8\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010#\u001a\u00020\u001f8\u0006¢\u0006\f\n\u0004\b\u001c\u0010 \u001a\u0004\b!\u0010\"R\u001b\u0010'\u001a\u00020$8BX\u0002¢\u0006\f\n\u0004\b!\u0010%\u001a\u0004\b\u0005\u0010&\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/wortise/ads/e;", "", "Lcom/wortise/ads/e$b$b;", "g", "Lcom/wortise/ads/e$b;", "b", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/wortise/ads/w5;", "Lcom/wortise/ads/AdResult;", "c", "adResult", "", "a", "Landroid/content/Context;", "Landroid/content/Context;", "()Landroid/content/Context;", "context", "", "Ljava/lang/String;", "()Ljava/lang/String;", "adUnitId", "Lcom/wortise/ads/RequestParameters;", "Lcom/wortise/ads/RequestParameters;", "d", "()Lcom/wortise/ads/RequestParameters;", "parameters", "Lcom/wortise/ads/device/Dimensions;", "Lcom/wortise/ads/device/Dimensions;", "e", "()Lcom/wortise/ads/device/Dimensions;", "size", "Lcom/wortise/ads/AdType;", "Lcom/wortise/ads/AdType;", "f", "()Lcom/wortise/ads/AdType;", "type", "Lcom/wortise/ads/m;", "Lkotlin/Lazy;", "()Lcom/wortise/ads/m;", "cacheDao", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/wortise/ads/RequestParameters;Lcom/wortise/ads/device/Dimensions;Lcom/wortise/ads/AdType;)V", "Companion", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdFetcher.kt */
public final class e {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final List<AdFormat> g = CollectionsKt.listOf(AdFormat.GOOGLE);
    private static final b.a h = new b.a(AdError.UNSPECIFIED, (AdResult) null, 2, (DefaultConstructorMarker) null);
    private final Context a;
    private final String b;
    private final RequestParameters c;
    private final Dimensions d;
    private final AdType e;
    private final Lazy f;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/wortise/ads/e$b;", "", "<init>", "()V", "a", "b", "Lcom/wortise/ads/e$b$a;", "Lcom/wortise/ads/e$b$b;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdFetcher.kt */
    public static abstract class b {

        @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\t\u001a\u0004\b\u0003\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/wortise/ads/e$b$a;", "Lcom/wortise/ads/e$b;", "Lcom/wortise/ads/AdError;", "a", "Lcom/wortise/ads/AdError;", "b", "()Lcom/wortise/ads/AdError;", "error", "Lcom/wortise/ads/AdResult;", "Lcom/wortise/ads/AdResult;", "()Lcom/wortise/ads/AdResult;", "data", "<init>", "(Lcom/wortise/ads/AdError;Lcom/wortise/ads/AdResult;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* compiled from: AdFetcher.kt */
        public static final class a extends b {
            private final AdError a;
            private final AdResult b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(AdError adError, AdResult adResult) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(adError, "error");
                this.a = adError;
                this.b = adResult;
            }

            public final AdResult a() {
                return this.b;
            }

            public final AdError b() {
                return this.a;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ a(AdError adError, AdResult adResult, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(adError, (i & 2) != 0 ? null : adResult);
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/wortise/ads/e$b$b;", "Lcom/wortise/ads/e$b;", "Lcom/wortise/ads/AdResult;", "a", "Lcom/wortise/ads/AdResult;", "()Lcom/wortise/ads/AdResult;", "data", "<init>", "(Lcom/wortise/ads/AdResult;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.wortise.ads.e$b$b  reason: collision with other inner class name */
        /* compiled from: AdFetcher.kt */
        public static final class C0001b extends b {
            private final AdResult a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0001b(AdResult adResult) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(adResult, "data");
                this.a = adResult;
            }

            public final AdResult a() {
                return this.a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/e$a;", "", "", "Lcom/wortise/ads/AdFormat;", "CACHE_FORMATS", "Ljava/util/List;", "Lcom/wortise/ads/e$b$a;", "RESULT_ERROR", "Lcom/wortise/ads/e$b$a;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdFetcher.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/m;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AdFetcher.kt */
    static final class c extends Lambda implements Function0<m> {
        final /* synthetic */ e a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(e eVar) {
            super(0);
            this.a = eVar;
        }

        /* renamed from: a */
        public final m invoke() {
            return f6.a.b(this.a.c()).a();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.AdFetcher", f = "AdFetcher.kt", i = {0}, l = {44}, m = "load", n = {"this"}, s = {"L$0"})
    /* compiled from: AdFetcher.kt */
    static final class d extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ e c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar, Continuation<? super d> continuation) {
            super(continuation);
            this.c = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Continuation<? super b>) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.wortise.ads.e$e  reason: collision with other inner class name */
    /* compiled from: AdFetcher.kt */
    static final class C0181e extends Lambda implements Function0<String> {
        final /* synthetic */ AdResult a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0181e(AdResult adResult) {
            super(0);
            this.a = adResult;
        }

        /* renamed from: a */
        public final String invoke() {
            return p4.a(this.a);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.AdFetcher", f = "AdFetcher.kt", i = {0, 0, 0}, l = {71}, m = "loadFromNetwork", n = {"this", "defaultValue$iv", "log$iv"}, s = {"L$0", "L$1", "I$0"})
    /* compiled from: AdFetcher.kt */
    static final class f extends ContinuationImpl {
        Object a;
        Object b;
        int c;
        /* synthetic */ Object d;
        final /* synthetic */ e e;
        int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(e eVar, Continuation<? super f> continuation) {
            super(continuation);
            this.e = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.f |= Integer.MIN_VALUE;
            return this.e.b(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.AdFetcher", f = "AdFetcher.kt", i = {0}, l = {94}, m = "requestAd", n = {"log$iv"}, s = {"I$0"})
    /* compiled from: AdFetcher.kt */
    static final class g extends ContinuationImpl {
        int a;
        /* synthetic */ Object b;
        final /* synthetic */ e c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(e eVar, Continuation<? super g> continuation) {
            super(continuation);
            this.c = eVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.c(this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AdFetcher.kt */
    static final class h extends Lambda implements Function0<String> {
        final /* synthetic */ AdResult a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(AdResult adResult) {
            super(0);
            this.a = adResult;
        }

        /* renamed from: a */
        public final String invoke() {
            return p4.a(this.a);
        }
    }

    public e(Context context, String str, RequestParameters requestParameters, Dimensions dimensions, AdType adType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(adType, "type");
        this.a = context;
        this.b = str;
        this.c = requestParameters;
        this.d = dimensions;
        this.e = adType;
        this.f = LazyKt.lazy(new c(this));
    }

    private final b.C0001b g() {
        try {
            l a2 = b().a(a());
            if (a2 == null) {
                return null;
            }
            if (!a2.a(14, TimeUnit.DAYS)) {
                AdResult a3 = a2.a();
                WortiseLog.v$default("Loaded ad result for ad unit " + a() + " from cache", (Throwable) null, 2, (Object) null);
                WortiseLog.v$default((Throwable) null, (Function0) new C0181e(a3), 1, (Object) null);
                return new b.C0001b(a3);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Context c() {
        return this.a;
    }

    public final RequestParameters d() {
        return this.c;
    }

    public final Dimensions e() {
        return this.d;
    }

    public final AdType f() {
        return this.e;
    }

    private final m b() {
        return (m) this.f.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(kotlin.coroutines.Continuation<? super com.wortise.ads.w5<com.wortise.ads.AdResult>> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.wortise.ads.e.g
            if (r0 == 0) goto L_0x0013
            r0 = r9
            com.wortise.ads.e$g r0 = (com.wortise.ads.e.g) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.e$g r0 = new com.wortise.ads.e$g
            r0.<init>(r8, r9)
        L_0x0018:
            java.lang.Object r9 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r4) goto L_0x002e
            int r4 = r0.a
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x002c }
            goto L_0x0070
        L_0x002c:
            r9 = move-exception
            goto L_0x0074
        L_0x002e:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r9)
            com.wortise.ads.j r9 = new com.wortise.ads.j     // Catch:{ all -> 0x002c }
            android.content.Context r2 = r8.c()     // Catch:{ all -> 0x002c }
            java.lang.String r5 = r8.a()     // Catch:{ all -> 0x002c }
            com.wortise.ads.RequestParameters r6 = r8.d()     // Catch:{ all -> 0x002c }
            if (r6 != 0) goto L_0x004b
            r6 = r3
            goto L_0x004f
        L_0x004b:
            java.lang.String r6 = r6.getAgent()     // Catch:{ all -> 0x002c }
        L_0x004f:
            com.wortise.ads.AdType r7 = r8.f()     // Catch:{ all -> 0x002c }
            r9.<init>(r2, r5, r6, r7)     // Catch:{ all -> 0x002c }
            android.content.Context r2 = r8.c()     // Catch:{ all -> 0x002c }
            com.wortise.ads.device.Dimensions r5 = r8.e()     // Catch:{ all -> 0x002c }
            r9.a(r2, r5)     // Catch:{ all -> 0x002c }
            com.wortise.ads.w r2 = com.wortise.ads.x.a()     // Catch:{ all -> 0x002c }
            r0.a = r4     // Catch:{ all -> 0x002c }
            r0.d = r4     // Catch:{ all -> 0x002c }
            java.lang.Object r9 = r2.a((com.wortise.ads.j) r9, (kotlin.coroutines.Continuation<? super com.wortise.ads.w5<com.wortise.ads.AdResult>>) r0)     // Catch:{ all -> 0x002c }
            if (r9 != r1) goto L_0x0070
            return r1
        L_0x0070:
            com.wortise.ads.w5 r9 = (com.wortise.ads.w5) r9     // Catch:{ all -> 0x002c }
            r3 = r9
            goto L_0x0081
        L_0x0074:
            if (r4 == 0) goto L_0x0081
            java.lang.String r0 = r9.getMessage()
            if (r0 != 0) goto L_0x007e
            java.lang.String r0 = "Caught an exception"
        L_0x007e:
            com.wortise.ads.WortiseLog.e((java.lang.String) r0, (java.lang.Throwable) r9)
        L_0x0081:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.e.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String a() {
        return this.b;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059 A[Catch:{ all -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0062 A[Catch:{ all -> 0x0033 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(kotlin.coroutines.Continuation<? super com.wortise.ads.e.b> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.wortise.ads.e.f
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.e$f r0 = (com.wortise.ads.e.f) r0
            int r1 = r0.f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.e$f r0 = new com.wortise.ads.e$f
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            int r3 = r0.c
            java.lang.Object r1 = r0.b
            com.wortise.ads.e$b$a r1 = (com.wortise.ads.e.b.a) r1
            java.lang.Object r0 = r0.a
            com.wortise.ads.e r0 = (com.wortise.ads.e) r0
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0033 }
            goto L_0x0054
        L_0x0033:
            r7 = move-exception
            goto L_0x0094
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.wortise.ads.e$b$a r7 = h
            r0.a = r6     // Catch:{ all -> 0x0091 }
            r0.b = r7     // Catch:{ all -> 0x0091 }
            r0.c = r3     // Catch:{ all -> 0x0091 }
            r0.f = r3     // Catch:{ all -> 0x0091 }
            java.lang.Object r0 = r6.c(r0)     // Catch:{ all -> 0x0091 }
            if (r0 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r1 = r7
            r7 = r0
            r0 = r6
        L_0x0054:
            com.wortise.ads.w5 r7 = (com.wortise.ads.w5) r7     // Catch:{ all -> 0x0033 }
            r2 = 0
            if (r7 != 0) goto L_0x0062
            com.wortise.ads.e$b$a r7 = new com.wortise.ads.e$b$a     // Catch:{ all -> 0x0033 }
            com.wortise.ads.AdError r0 = com.wortise.ads.AdError.SERVER_ERROR     // Catch:{ all -> 0x0033 }
            r4 = 2
            r7.<init>(r0, r2, r4, r2)     // Catch:{ all -> 0x0033 }
            return r7
        L_0x0062:
            java.lang.Object r4 = r7.b()     // Catch:{ all -> 0x0033 }
            com.wortise.ads.AdResult r4 = (com.wortise.ads.AdResult) r4     // Catch:{ all -> 0x0033 }
            boolean r5 = r7.c()     // Catch:{ all -> 0x0033 }
            if (r5 == 0) goto L_0x007a
            if (r4 != 0) goto L_0x0071
            goto L_0x007a
        L_0x0071:
            r0.a((com.wortise.ads.AdResult) r4)     // Catch:{ all -> 0x0033 }
            com.wortise.ads.e$b$b r7 = new com.wortise.ads.e$b$b     // Catch:{ all -> 0x0033 }
            r7.<init>(r4)     // Catch:{ all -> 0x0033 }
            goto L_0x00a2
        L_0x007a:
            com.wortise.ads.e$b$a r0 = new com.wortise.ads.e$b$a     // Catch:{ all -> 0x0033 }
            com.wortise.ads.AdError$a r5 = com.wortise.ads.AdError.Companion     // Catch:{ all -> 0x0033 }
            com.wortise.ads.y5 r7 = r7.a()     // Catch:{ all -> 0x0033 }
            if (r7 != 0) goto L_0x0085
            goto L_0x0089
        L_0x0085:
            java.lang.String r2 = r7.a()     // Catch:{ all -> 0x0033 }
        L_0x0089:
            com.wortise.ads.AdError r7 = r5.a(r2)     // Catch:{ all -> 0x0033 }
            r0.<init>(r7, r4)     // Catch:{ all -> 0x0033 }
            return r0
        L_0x0091:
            r0 = move-exception
            r1 = r7
            r7 = r0
        L_0x0094:
            if (r3 == 0) goto L_0x00a1
            java.lang.String r0 = r7.getMessage()
            if (r0 != 0) goto L_0x009e
            java.lang.String r0 = "Caught an exception"
        L_0x009e:
            com.wortise.ads.WortiseLog.e((java.lang.String) r0, (java.lang.Throwable) r7)
        L_0x00a1:
            r7 = r1
        L_0x00a2:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.e.b(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0078, code lost:
        r0 = r0.g();
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation<? super com.wortise.ads.e.b> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.wortise.ads.e.d
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.e$d r0 = (com.wortise.ads.e.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.e$d r0 = new com.wortise.ads.e$d
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.a
            com.wortise.ads.e r0 = (com.wortise.ads.e) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0067
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = r6.a()
            java.lang.String r2 = "Loading ad unit: "
            java.lang.String r7 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r7)
            r2 = 0
            r4 = 2
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r7, (java.lang.Throwable) r2, (int) r4, (java.lang.Object) r2)
            com.wortise.ads.d5 r7 = com.wortise.ads.d5.a
            android.content.Context r5 = r6.c()
            boolean r7 = r7.b(r5)
            if (r7 != 0) goto L_0x005b
            com.wortise.ads.e$b$a r7 = new com.wortise.ads.e$b$a
            com.wortise.ads.AdError r0 = com.wortise.ads.AdError.NO_NETWORK
            r7.<init>(r0, r2, r4, r2)
            return r7
        L_0x005b:
            r0.a = r6
            r0.d = r3
            java.lang.Object r7 = r6.b(r0)
            if (r7 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r0 = r6
        L_0x0067:
            com.wortise.ads.e$b r7 = (com.wortise.ads.e.b) r7
            boolean r1 = r7 instanceof com.wortise.ads.e.b.a
            if (r1 == 0) goto L_0x0080
            r1 = r7
            com.wortise.ads.e$b$a r1 = (com.wortise.ads.e.b.a) r1
            com.wortise.ads.AdError r1 = r1.b()
            com.wortise.ads.AdError r2 = com.wortise.ads.AdError.NO_FILL
            if (r1 == r2) goto L_0x0080
            com.wortise.ads.e$b$b r0 = r0.g()
            if (r0 != 0) goto L_0x007f
            goto L_0x0080
        L_0x007f:
            r7 = r0
        L_0x0080:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.e.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(Context context, String str, RequestParameters requestParameters, Dimensions dimensions, AdType adType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? null : requestParameters, (i & 8) != 0 ? null : dimensions, adType);
    }

    private final boolean a(AdResult adResult) {
        try {
            List<AdResponse> ads = adResult.getAds();
            ArrayList arrayList = new ArrayList();
            for (T next : ads) {
                if (CollectionsKt.contains(g, ((AdResponse) next).g())) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                AdResult copy$default = AdResult.copy$default(adResult, arrayList, (Long) null, 2, (Object) null);
                WortiseLog.v$default("Saving ad result for ad unit " + a() + " into cache...", (Throwable) null, 2, (Object) null);
                WortiseLog.v$default((Throwable) null, (Function0) new h(adResult), 1, (Object) null);
                l lVar = new l(a(), copy$default, (Date) null, 4, (DefaultConstructorMarker) null);
                b().a(lVar);
                return true;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (Throwable unused) {
            return false;
        }
    }
}
