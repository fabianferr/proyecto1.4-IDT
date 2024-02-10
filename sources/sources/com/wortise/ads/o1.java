package com.wortise.ads;

import android.content.Context;
import com.wortise.ads.utils.AsyncManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000bJ\u001d\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJ\u0016\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r2\u0006\u0010\n\u001a\u00020\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/wortise/ads/o1;", "Lcom/wortise/ads/utils/AsyncManager;", "Lcom/wortise/ads/l1;", "Lcom/wortise/ads/m1;", "cache", "", "expired", "a", "(Lcom/wortise/ads/m1;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetch", "Lkotlinx/coroutines/Deferred;", "fetchAsync", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ConfigManager.kt */
public final class o1 extends AsyncManager<l1> {
    public static final o1 a = new o1();

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u0004\u0018\u00010\u0000H@"}, d2 = {"Lcom/wortise/ads/l1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.config.ConfigManager$fetchAsync$1", f = "ConfigManager.kt", i = {0, 1}, l = {20, 21, 22}, m = "invokeSuspend", n = {"cache", "cache"}, s = {"L$0", "L$0"})
    /* compiled from: ConfigManager.kt */
    static final class a extends SuspendLambda implements Function1<Continuation<? super l1>, Object> {
        Object a;
        int b;
        final /* synthetic */ Context c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context, Continuation<? super a> continuation) {
            super(1, continuation);
            this.c = context;
        }

        /* renamed from: a */
        public final Object invoke(Continuation<? super l1> continuation) {
            return ((a) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new a(this.c, continuation);
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0060  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0067  */
        /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L_0x002d
                if (r1 == r4) goto L_0x0025
                if (r1 == r3) goto L_0x001d
                if (r1 != r2) goto L_0x0015
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x0074
            L_0x0015:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x001d:
                java.lang.Object r1 = r7.a
                com.wortise.ads.m1 r1 = (com.wortise.ads.m1) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x005b
            L_0x0025:
                java.lang.Object r1 = r7.a
                com.wortise.ads.m1 r1 = (com.wortise.ads.m1) r1
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x0048
            L_0x002d:
                kotlin.ResultKt.throwOnFailure(r8)
                com.wortise.ads.m1 r8 = new com.wortise.ads.m1
                android.content.Context r1 = r7.c
                r8.<init>(r1)
                com.wortise.ads.o1 r1 = com.wortise.ads.o1.a
                r7.a = r8
                r7.b = r4
                r5 = 0
                java.lang.Object r1 = r1.a((com.wortise.ads.m1) r8, (boolean) r5, (kotlin.coroutines.Continuation<? super com.wortise.ads.l1>) r7)
                if (r1 != r0) goto L_0x0045
                return r0
            L_0x0045:
                r6 = r1
                r1 = r8
                r8 = r6
            L_0x0048:
                com.wortise.ads.l1 r8 = (com.wortise.ads.l1) r8
                if (r8 != 0) goto L_0x0076
                com.wortise.ads.o1 r8 = com.wortise.ads.o1.a
                android.content.Context r5 = r7.c
                r7.a = r1
                r7.b = r3
                java.lang.Object r8 = r8.a(r5, r7)
                if (r8 != r0) goto L_0x005b
                return r0
            L_0x005b:
                com.wortise.ads.l1 r8 = (com.wortise.ads.l1) r8
                r3 = 0
                if (r8 != 0) goto L_0x0062
                r8 = r3
                goto L_0x0065
            L_0x0062:
                r1.a((com.wortise.ads.l1) r8)
            L_0x0065:
                if (r8 != 0) goto L_0x0076
                com.wortise.ads.o1 r8 = com.wortise.ads.o1.a
                r7.a = r3
                r7.b = r2
                java.lang.Object r8 = r8.a((com.wortise.ads.m1) r1, (boolean) r4, (kotlin.coroutines.Continuation<? super com.wortise.ads.l1>) r7)
                if (r8 != r0) goto L_0x0074
                return r0
            L_0x0074:
                com.wortise.ads.l1 r8 = (com.wortise.ads.l1) r8
            L_0x0076:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.o1.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/l1;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.config.ConfigManager$loadFromCache$2", f = "ConfigManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: ConfigManager.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super l1>, Object> {
        int a;
        final /* synthetic */ m1 b;
        final /* synthetic */ boolean c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(m1 m1Var, boolean z, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = m1Var;
            this.c = z;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super l1> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.a == 0) {
                ResultKt.throwOnFailure(obj);
                l1 a2 = this.b.a(this.c);
                if (a2 != null) {
                    WortiseLog.d$default("Config loaded from cache (expired = " + this.c + ')', (Throwable) null, 2, (Object) null);
                }
                return a2;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.config.ConfigManager", f = "ConfigManager.kt", i = {}, l = {39}, m = "loadFromNetwork", n = {}, s = {})
    /* compiled from: ConfigManager.kt */
    static final class c extends ContinuationImpl {
        /* synthetic */ Object a;
        final /* synthetic */ o1 b;
        int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(o1 o1Var, Continuation<? super c> continuation) {
            super(continuation);
            this.b = o1Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.c |= Integer.MIN_VALUE;
            return this.b.a((Context) null, this);
        }
    }

    private o1() {
    }

    public final Object fetch(Context context, Continuation<? super l1> continuation) {
        return fetchAsync(context).await(continuation);
    }

    public final Deferred<l1> fetchAsync(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return fetchAsync(new a(context, (Continuation<? super a>) null));
    }

    /* access modifiers changed from: private */
    public final Object a(m1 m1Var, boolean z, Continuation<? super l1> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new b(m1Var, z, (Continuation<? super b>) null), continuation);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r6, kotlin.coroutines.Continuation<? super com.wortise.ads.l1> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.wortise.ads.o1.c
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.wortise.ads.o1$c r0 = (com.wortise.ads.o1.c) r0
            int r1 = r0.c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.c = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.o1$c r0 = new com.wortise.ads.o1$c
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.c
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0057 }
            goto L_0x0047
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            com.wortise.ads.p1 r7 = new com.wortise.ads.p1     // Catch:{ all -> 0x0057 }
            r7.<init>(r6)     // Catch:{ all -> 0x0057 }
            com.wortise.ads.w r6 = com.wortise.ads.x.a()     // Catch:{ all -> 0x0057 }
            r0.c = r3     // Catch:{ all -> 0x0057 }
            java.lang.Object r7 = r6.a((com.wortise.ads.p1) r7, (kotlin.coroutines.Continuation<? super com.wortise.ads.w5<com.wortise.ads.l1>>) r0)     // Catch:{ all -> 0x0057 }
            if (r7 != r1) goto L_0x0047
            return r1
        L_0x0047:
            com.wortise.ads.w5 r7 = (com.wortise.ads.w5) r7     // Catch:{ all -> 0x0057 }
            java.lang.Object r6 = com.wortise.ads.z5.a(r7)     // Catch:{ all -> 0x0057 }
            com.wortise.ads.l1 r6 = (com.wortise.ads.l1) r6     // Catch:{ all -> 0x0057 }
            java.lang.String r7 = "Config fetched successfully"
            r0 = 2
            com.wortise.ads.WortiseLog.d$default((java.lang.String) r7, (java.lang.Throwable) r4, (int) r0, (java.lang.Object) r4)     // Catch:{ all -> 0x0057 }
            r4 = r6
            goto L_0x005d
        L_0x0057:
            r6 = move-exception
            java.lang.String r7 = "Config could not be fetched"
            com.wortise.ads.WortiseLog.e((java.lang.String) r7, (java.lang.Throwable) r6)
        L_0x005d:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.o1.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
