package com.wortise.ads;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001d\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\nJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u001d\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/wortise/ads/t4;", "", "Landroid/content/Context;", "context", "", "Lcom/wortise/ads/i0;", "b", "Landroid/location/Location;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "", "timeout", "", "c", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: LocationManager.kt */
public final class t4 {
    public static final t4 a = new t4();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.location.LocationManager", f = "LocationManager.kt", i = {0}, l = {45}, m = "getLastLocation", n = {"context"}, s = {"L$0"})
    /* compiled from: LocationManager.kt */
    static final class a extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ t4 c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(t4 t4Var, Continuation<? super a> continuation) {
            super(continuation);
            this.c = t4Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.a((Context) null, (Continuation<? super Location>) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/location/Location;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.location.LocationManager$getLastLocationSync$1", f = "LocationManager.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: LocationManager.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Location>, Object> {
        int a;
        final /* synthetic */ long b;
        final /* synthetic */ Context c;

        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/location/Location;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
        @DebugMetadata(c = "com.wortise.ads.location.LocationManager$getLastLocationSync$1$1", f = "LocationManager.kt", i = {}, l = {27}, m = "invokeSuspend", n = {}, s = {})
        /* compiled from: LocationManager.kt */
        static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Location>, Object> {
            int a;
            final /* synthetic */ Context b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Context context, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = context;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Location> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    t4 t4Var = t4.a;
                    Context context = this.b;
                    this.a = 1;
                    obj = t4Var.a(context, (Continuation<? super Location>) this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return obj;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(long j, Context context, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = j;
            this.c = context;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Location> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.b;
                a aVar = new a(this.c, (Continuation<? super a>) null);
                this.a = 1;
                obj = TimeoutKt.withTimeoutOrNull(j, aVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.location.LocationManager", f = "LocationManager.kt", i = {0, 0}, l = {59}, m = "safeLastLocation", n = {"context", "log$iv"}, s = {"L$0", "I$0"})
    /* compiled from: LocationManager.kt */
    static final class c extends ContinuationImpl {
        Object a;
        int b;
        /* synthetic */ Object c;
        final /* synthetic */ t4 d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(t4 t4Var, Continuation<? super c> continuation) {
            super(continuation);
            this.d = t4Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.b((Context) null, this);
        }
    }

    private t4() {
    }

    private final List<i0> b(Context context) {
        return CollectionsKt.listOf(new x2(context), new x6(context));
    }

    public final boolean c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!b2.a(context, "android.permission.ACCESS_FINE_LOCATION")) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 29 || b2.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return true;
        }
        return false;
    }

    public final i0 a(Context context) {
        T t;
        Intrinsics.checkNotNullParameter(context, "context");
        Iterator<T> it = b(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (((i0) t).a()) {
                break;
            }
        }
        return (i0) t;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c A[Catch:{ all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A[Catch:{ all -> 0x0064 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object b(android.content.Context r7, kotlin.coroutines.Continuation<? super android.location.Location> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.wortise.ads.t4.c
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.t4$c r0 = (com.wortise.ads.t4.c) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.t4$c r0 = new com.wortise.ads.t4$c
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003e
            if (r2 != r4) goto L_0x0036
            int r7 = r0.b
            java.lang.Object r0 = r0.a
            android.content.Context r0 = (android.content.Context) r0
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0034 }
            r5 = r8
            r8 = r7
            r7 = r0
            r0 = r5
            goto L_0x0058
        L_0x0034:
            r8 = move-exception
            goto L_0x006c
        L_0x0036:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            com.wortise.ads.t4 r2 = a     // Catch:{ all -> 0x0069 }
            com.wortise.ads.i0 r2 = r2.a(r7)     // Catch:{ all -> 0x0069 }
            if (r2 != 0) goto L_0x004b
            goto L_0x0079
        L_0x004b:
            r0.a = r7     // Catch:{ all -> 0x0069 }
            r0.b = r8     // Catch:{ all -> 0x0069 }
            r0.e = r4     // Catch:{ all -> 0x0069 }
            java.lang.Object r0 = r2.a(r0)     // Catch:{ all -> 0x0069 }
            if (r0 != r1) goto L_0x0058
            return r1
        L_0x0058:
            android.location.Location r0 = (android.location.Location) r0     // Catch:{ all -> 0x0064 }
            if (r0 != 0) goto L_0x005d
            goto L_0x0079
        L_0x005d:
            com.wortise.ads.u4 r1 = com.wortise.ads.u4.a     // Catch:{ all -> 0x0064 }
            r1.a(r7, r0)     // Catch:{ all -> 0x0064 }
            r3 = r0
            goto L_0x0079
        L_0x0064:
            r7 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
            goto L_0x006c
        L_0x0069:
            r7 = move-exception
            r8 = r7
            r7 = 0
        L_0x006c:
            if (r7 == 0) goto L_0x0079
            java.lang.String r7 = r8.getMessage()
            if (r7 != 0) goto L_0x0076
            java.lang.String r7 = "Caught an exception"
        L_0x0076:
            com.wortise.ads.WortiseLog.e((java.lang.String) r7, (java.lang.Throwable) r8)
        L_0x0079:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.t4.b(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Location a(Context context, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (Location) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new b(j, context, (Continuation<? super b>) null), 1, (Object) null);
    }

    public static /* synthetic */ Location a(t4 t4Var, Context context, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 1000;
        }
        return t4Var.a(context, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(android.content.Context r5, kotlin.coroutines.Continuation<? super android.location.Location> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.wortise.ads.t4.a
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.wortise.ads.t4$a r0 = (com.wortise.ads.t4.a) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.t4$a r0 = new com.wortise.ads.t4$a
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.a
            android.content.Context r5 = (android.content.Context) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0043
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.a = r5
            r0.d = r3
            java.lang.Object r6 = r4.b(r5, r0)
            if (r6 != r1) goto L_0x0043
            return r1
        L_0x0043:
            android.location.Location r6 = (android.location.Location) r6
            if (r6 != 0) goto L_0x004d
            com.wortise.ads.u4 r6 = com.wortise.ads.u4.a
            android.location.Location r6 = r6.a(r5)
        L_0x004d:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.t4.a(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
