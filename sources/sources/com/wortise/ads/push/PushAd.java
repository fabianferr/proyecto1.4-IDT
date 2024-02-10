package com.wortise.ads.push;

import android.content.Context;
import com.wortise.ads.AdError;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdResult;
import com.wortise.ads.RequestParameters;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.e;
import com.wortise.ads.e5;
import com.wortise.ads.k0;
import com.wortise.ads.u5;
import com.wortise.ads.z2;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u00014B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b2\u00103J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\u0016\u001a\u00020\u0006J\u0006\u0010\u0017\u001a\u00020\u0006J\u0014\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R$\u0010%\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b%\u0010'R$\u0010(\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b(\u0010&\u001a\u0004\b(\u0010'R$\u0010)\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b)\u0010&\u001a\u0004\b)\u0010'R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0011\u00101\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b1\u0010'\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/wortise/ads/push/PushAd;", "", "", "adUnitId", "Lcom/wortise/ads/RequestParameters;", "parameters", "", "loadAd", "(Ljava/lang/String;Lcom/wortise/ads/RequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/wortise/ads/AdResponse;", "response", "", "prepare", "tryNext", "Lcom/wortise/ads/AdError;", "error", "onPushError", "onPushFailed", "Lcom/wortise/ads/AdResult;", "result", "onPushFetched", "onPushSelected", "cancel", "destroy", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Ljava/lang/String;", "adResult", "Lcom/wortise/ads/AdResult;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<set-?>", "isDestroyed", "Z", "()Z", "isLoaded", "isLoading", "Lcom/wortise/ads/push/PushAd$Listener;", "listener", "Lcom/wortise/ads/push/PushAd$Listener;", "getListener", "()Lcom/wortise/ads/push/PushAd$Listener;", "setListener", "(Lcom/wortise/ads/push/PushAd$Listener;)V", "isAvailable", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Listener", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: PushAd.kt */
public final class PushAd {
    private AdResult adResult;
    /* access modifiers changed from: private */
    public final String adUnitId;
    private final Context context;
    private final Lazy coroutineScope$delegate = LazyKt.lazy(a.a);
    private boolean isDestroyed;
    private boolean isLoaded;
    private boolean isLoading;
    private Listener listener;
    private k0 pushImpl;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/wortise/ads/push/PushAd$Listener;", "", "onPushFailed", "", "ad", "Lcom/wortise/ads/push/PushAd;", "error", "Lcom/wortise/ads/AdError;", "onPushLoaded", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: PushAd.kt */
    public interface Listener {
        void onPushFailed(PushAd pushAd, AdError adError);

        void onPushLoaded(PushAd pushAd);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: PushAd.kt */
    static final class a extends Lambda implements Function0<CoroutineScope> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.MainScope();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.push.PushAd$loadAd$1", f = "PushAd.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: PushAd.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ PushAd b;
        final /* synthetic */ RequestParameters c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(PushAd pushAd, RequestParameters requestParameters, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = pushAd;
            this.c = requestParameters;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
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
                PushAd pushAd = this.b;
                String access$getAdUnitId$p = pushAd.adUnitId;
                RequestParameters requestParameters = this.c;
                this.a = 1;
                if (pushAd.loadAd(access$getAdUnitId$p, requestParameters, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.push.PushAd", f = "PushAd.kt", i = {0}, l = {103}, m = "loadAd", n = {"this"}, s = {"L$0"})
    /* compiled from: PushAd.kt */
    static final class c extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ PushAd c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(PushAd pushAd, Continuation<? super c> continuation) {
            super(continuation);
            this.c = pushAd;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.loadAd((String) null, (RequestParameters) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/e$b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.push.PushAd$loadAd$result$1", f = "PushAd.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: PushAd.kt */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e.b>, Object> {
        int a;
        final /* synthetic */ e b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(e eVar, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = eVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super e.b> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                e eVar = this.b;
                this.a = 1;
                obj = eVar.a((Continuation<? super e.b>) this);
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

    public PushAd(Context context2, String str) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        this.context = context2;
        this.adUnitId = str;
    }

    private final CoroutineScope getCoroutineScope() {
        return (CoroutineScope) this.coroutineScope$delegate.getValue();
    }

    public static /* synthetic */ void loadAd$default(PushAd pushAd, RequestParameters requestParameters, int i, Object obj) {
        if ((i & 1) != 0) {
            requestParameters = null;
        }
        pushAd.loadAd(requestParameters);
    }

    private final void onPushError(AdError adError) {
        if (!this.isDestroyed && !tryNext()) {
            onPushFailed(adError);
        }
    }

    private final void onPushFailed(AdError adError) {
        if (!this.isDestroyed) {
            WortiseLog.i$default("Push ad load failed for ad unit " + this.adUnitId + ": " + adError.name(), (Throwable) null, 2, (Object) null);
            this.isLoading = false;
            this.isLoaded = false;
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onPushFailed(this, adError);
            }
        }
    }

    private final void onPushFetched(AdResult adResult2) {
        if (!this.isDestroyed) {
            this.adResult = adResult2;
            tryNext();
        }
    }

    private final void onPushSelected(AdResponse adResponse) {
        if (!this.isDestroyed) {
            this.isLoading = false;
            this.isLoaded = true;
            if (!prepare(adResponse)) {
                onPushError(AdError.INVALID_PARAMS);
                return;
            }
            WortiseLog.i$default(Intrinsics.stringPlus("Push ad loaded for ad unit ", this.adUnitId), (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onPushLoaded(this);
            }
        }
    }

    private final boolean prepare(AdResponse adResponse) {
        if (this.isDestroyed) {
            return false;
        }
        try {
            this.pushImpl = u5.a.a(this.context, adResponse);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private final boolean tryNext() {
        AdResult adResult2 = this.adResult;
        AdResponse nextAd = adResult2 == null ? null : adResult2.nextAd();
        if (nextAd == null) {
            return false;
        }
        onPushSelected(nextAd);
        return true;
    }

    public final void cancel() {
        k0 k0Var = this.pushImpl;
        if (k0Var != null) {
            k0Var.a();
        }
    }

    public final void destroy() {
        if (!this.isDestroyed) {
            CoroutineScopeKt.cancel$default(getCoroutineScope(), (CancellationException) null, 1, (Object) null);
            this.pushImpl = null;
            this.isDestroyed = true;
            this.isLoaded = false;
            this.isLoading = false;
        }
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final boolean isAvailable() {
        return !this.isDestroyed && this.isLoaded;
    }

    public final boolean isDestroyed() {
        return this.isDestroyed;
    }

    public final boolean isLoaded() {
        return this.isLoaded;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public final void loadAd() {
        loadAd$default(this, (RequestParameters) null, 1, (Object) null);
    }

    public final void loadAd(RequestParameters requestParameters) {
        if (!this.isDestroyed && !this.isLoading) {
            if (!e5.Companion.a(this.context)) {
                onPushFailed(AdError.NOTIFICATIONS_DISABLED);
                return;
            }
            WortiseLog.i$default("Loading push ad for ad unit " + this.adUnitId + "...", (Throwable) null, 2, (Object) null);
            z2.a.a(this.context);
            this.isLoading = true;
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new b(this, requestParameters, (Continuation<? super b>) null), 3, (Object) null);
        }
    }

    public final void setListener(Listener listener2) {
        this.listener = listener2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadAd(java.lang.String r13, com.wortise.ads.RequestParameters r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.wortise.ads.push.PushAd.c
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.wortise.ads.push.PushAd$c r0 = (com.wortise.ads.push.PushAd.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.push.PushAd$c r0 = new com.wortise.ads.push.PushAd$c
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r13 = r0.a
            com.wortise.ads.push.PushAd r13 = (com.wortise.ads.push.PushAd) r13
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x005e
        L_0x002d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r15)
            com.wortise.ads.e r15 = new com.wortise.ads.e
            android.content.Context r5 = r12.context
            com.wortise.ads.AdType r9 = com.wortise.ads.AdType.PUSH
            r8 = 0
            r10 = 8
            r11 = 0
            r4 = r15
            r6 = r13
            r7 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getIO()
            com.wortise.ads.push.PushAd$d r14 = new com.wortise.ads.push.PushAd$d
            r2 = 0
            r14.<init>(r15, r2)
            r0.a = r12
            r0.d = r3
            java.lang.Object r15 = kotlinx.coroutines.BuildersKt.withContext(r13, r14, r0)
            if (r15 != r1) goto L_0x005d
            return r1
        L_0x005d:
            r13 = r12
        L_0x005e:
            com.wortise.ads.e$b r15 = (com.wortise.ads.e.b) r15
            boolean r14 = r15 instanceof com.wortise.ads.e.b.a
            if (r14 == 0) goto L_0x006e
            com.wortise.ads.e$b$a r15 = (com.wortise.ads.e.b.a) r15
            com.wortise.ads.AdError r14 = r15.b()
            r13.onPushFailed(r14)
            goto L_0x007b
        L_0x006e:
            boolean r14 = r15 instanceof com.wortise.ads.e.b.C0001b
            if (r14 == 0) goto L_0x007b
            com.wortise.ads.e$b$b r15 = (com.wortise.ads.e.b.C0001b) r15
            com.wortise.ads.AdResult r14 = r15.a()
            r13.onPushFetched(r14)
        L_0x007b:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.push.PushAd.loadAd(java.lang.String, com.wortise.ads.RequestParameters, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
