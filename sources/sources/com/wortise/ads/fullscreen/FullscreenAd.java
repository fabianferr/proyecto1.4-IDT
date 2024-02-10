package com.wortise.ads.fullscreen;

import android.content.Context;
import com.wortise.ads.AdError;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdResult;
import com.wortise.ads.AdType;
import com.wortise.ads.RequestParameters;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.device.Dimensions;
import com.wortise.ads.e;
import com.wortise.ads.fullscreen.modules.BaseFullscreenModule;
import com.wortise.ads.o2;
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

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0017\u0010%\u001a\u0004\u0018\u00018\u00002\u0006\u0010&\u001a\u00020\fH$¢\u0006\u0002\u0010'J\u0006\u0010(\u001a\u00020)J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0014J\b\u0010-\u001a\u00020)H\u0002J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\fH\u0014J\u0014\u0010/\u001a\u00020)2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0007J#\u0010/\u001a\u00020)2\u0006\u0010\u0006\u001a\u00020\u00072\b\u00100\u001a\u0004\u0018\u000101H@ø\u0001\u0000¢\u0006\u0002\u00102J\b\u00103\u001a\u00020)H\u0016J\b\u00104\u001a\u00020)H\u0016J\u0010\u00105\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0016J\u0010\u00106\u001a\u00020)2\u0006\u0010+\u001a\u00020,H\u0014J\u0010\u00107\u001a\u00020)2\u0006\u00108\u001a\u00020\u000eH\u0002J\b\u00109\u001a\u00020)H\u0016J\u0019\u0010:\u001a\u00020)2\u0006\u0010&\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010;J\b\u0010<\u001a\u00020)H\u0016J\n\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0006\u0010?\u001a\u00020\u001aJ\b\u0010@\u001a\u00020\u001aH\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u000e\u0010\u001e\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0012\u0010!\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$\u0002\u0004\n\u0002\b\u0019¨\u0006A"}, d2 = {"Lcom/wortise/ads/fullscreen/FullscreenAd;", "T", "Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule$Listener;", "context", "Landroid/content/Context;", "adUnitId", "", "type", "Lcom/wortise/ads/AdType;", "(Landroid/content/Context;Ljava/lang/String;Lcom/wortise/ads/AdType;)V", "adResponse", "Lcom/wortise/ads/AdResponse;", "adResult", "Lcom/wortise/ads/AdResult;", "getAdUnitId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "isAvailable", "", "()Z", "<set-?>", "isDestroyed", "isLoaded", "isLoading", "isShowing", "module", "Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "getType", "()Lcom/wortise/ads/AdType;", "createModule", "response", "(Lcom/wortise/ads/AdResponse;)Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "destroy", "", "handleError", "error", "Lcom/wortise/ads/AdError;", "invalidate", "isValid", "loadAd", "parameters", "Lcom/wortise/ads/RequestParameters;", "(Ljava/lang/String;Lcom/wortise/ads/RequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAdClicked", "onAdDismissed", "onAdError", "onAdFailed", "onAdFetched", "result", "onAdLoaded", "onAdSelected", "(Lcom/wortise/ads/AdResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAdShown", "resolveAdSize", "Lcom/wortise/ads/device/Dimensions;", "showAd", "tryNext", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FullscreenAd.kt */
public abstract class FullscreenAd<T extends BaseFullscreenModule<?>> implements BaseFullscreenModule.Listener {
    private AdResponse adResponse;
    private AdResult adResult;
    private final String adUnitId;
    private final Context context;
    private final Lazy coroutineScope$delegate = LazyKt.lazy(a.a);
    private boolean isDestroyed;
    private boolean isLoaded;
    private boolean isLoading;
    private boolean isShowing;
    private T module;
    private final AdType type;

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000H\n"}, d2 = {"Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: FullscreenAd.kt */
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

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\u00020\u0002H@"}, d2 = {"Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.fullscreen.FullscreenAd$loadAd$1", f = "FullscreenAd.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: FullscreenAd.kt */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ FullscreenAd<T> b;
        final /* synthetic */ RequestParameters c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FullscreenAd<T> fullscreenAd, RequestParameters requestParameters, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = fullscreenAd;
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
                FullscreenAd<T> fullscreenAd = this.b;
                String adUnitId = fullscreenAd.getAdUnitId();
                RequestParameters requestParameters = this.c;
                this.a = 1;
                if (fullscreenAd.loadAd(adUnitId, requestParameters, this) == coroutine_suspended) {
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
    @DebugMetadata(c = "com.wortise.ads.fullscreen.FullscreenAd", f = "FullscreenAd.kt", i = {0}, l = {126}, m = "loadAd", n = {"this"}, s = {"L$0"})
    /* compiled from: FullscreenAd.kt */
    static final class c extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ FullscreenAd<T> c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FullscreenAd<T> fullscreenAd, Continuation<? super c> continuation) {
            super(continuation);
            this.c = fullscreenAd;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.loadAd((String) null, (RequestParameters) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\u00020\u0002H@"}, d2 = {"Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "T", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/e$b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.fullscreen.FullscreenAd$loadAd$result$1", f = "FullscreenAd.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: FullscreenAd.kt */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e.b>, Object> {
        int a;
        final /* synthetic */ com.wortise.ads.e b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(com.wortise.ads.e eVar, Continuation<? super d> continuation) {
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
                com.wortise.ads.e eVar = this.b;
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

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.fullscreen.FullscreenAd", f = "FullscreenAd.kt", i = {}, l = {222}, m = "onAdSelected", n = {}, s = {})
    /* compiled from: FullscreenAd.kt */
    static final class e extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ FullscreenAd<T> c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(FullscreenAd<T> fullscreenAd, Continuation<? super e> continuation) {
            super(continuation);
            this.c = fullscreenAd;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.onAdSelected((AdResponse) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\u00020\u0002H@"}, d2 = {"Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.fullscreen.FullscreenAd$showAd$1", f = "FullscreenAd.kt", i = {}, l = {91}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: FullscreenAd.kt */
    static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ T b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(T t, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = t;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.b, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                T t = this.b;
                this.a = 1;
                if (t.show(this) == coroutine_suspended) {
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

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0000*\u00020\u0002H@"}, d2 = {"Lcom/wortise/ads/fullscreen/modules/BaseFullscreenModule;", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.fullscreen.FullscreenAd$tryNext$1", f = "FullscreenAd.kt", i = {}, l = {145}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: FullscreenAd.kt */
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ FullscreenAd<T> b;
        final /* synthetic */ AdResponse c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(FullscreenAd<T> fullscreenAd, AdResponse adResponse, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = fullscreenAd;
            this.c = adResponse;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FullscreenAd<T> fullscreenAd = this.b;
                AdResponse adResponse = this.c;
                this.a = 1;
                if (fullscreenAd.onAdSelected(adResponse, this) == coroutine_suspended) {
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

    public FullscreenAd(Context context2, String str, AdType adType) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(adType, "type");
        this.context = context2;
        this.adUnitId = str;
        this.type = adType;
    }

    private final CoroutineScope getCoroutineScope() {
        return (CoroutineScope) this.coroutineScope$delegate.getValue();
    }

    private final void invalidate() {
        if (!this.isDestroyed) {
            T t = this.module;
            if (t != null) {
                t.destroy();
            }
            this.module = null;
            this.isLoaded = false;
            this.isShowing = false;
        }
    }

    public static /* synthetic */ void loadAd$default(FullscreenAd fullscreenAd, RequestParameters requestParameters, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                requestParameters = null;
            }
            fullscreenAd.loadAd(requestParameters);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAd");
    }

    private final void onAdFetched(AdResult adResult2) {
        if (!this.isDestroyed) {
            this.adResult = adResult2;
            if (!tryNext()) {
                onAdError(AdError.NO_FILL);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onAdSelected(com.wortise.ads.AdResponse r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.wortise.ads.fullscreen.FullscreenAd.e
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.wortise.ads.fullscreen.FullscreenAd$e r0 = (com.wortise.ads.fullscreen.FullscreenAd.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.fullscreen.FullscreenAd$e r0 = new com.wortise.ads.fullscreen.FullscreenAd$e
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.a
            com.wortise.ads.fullscreen.modules.BaseFullscreenModule r5 = (com.wortise.ads.fullscreen.modules.BaseFullscreenModule) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0063
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            r4.adResponse = r5
            boolean r6 = r4.isValid(r5)
            if (r6 != 0) goto L_0x0048
            com.wortise.ads.AdError r5 = com.wortise.ads.AdError.INVALID_PARAMS
            r4.onAdError(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0048:
            com.wortise.ads.fullscreen.modules.BaseFullscreenModule r5 = r4.createModule(r5)
            if (r5 != 0) goto L_0x0056
            com.wortise.ads.AdError r5 = com.wortise.ads.AdError.NO_FILL
            r4.onAdError(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0056:
            r4.module = r5
            r0.a = r5
            r0.d = r3
            java.lang.Object r5 = r5.load(r0)
            if (r5 != r1) goto L_0x0063
            return r1
        L_0x0063:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.fullscreen.FullscreenAd.onAdSelected(com.wortise.ads.AdResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Dimensions resolveAdSize() {
        return o2.a.a(this.context);
    }

    private final boolean tryNext() {
        AdResult adResult2 = this.adResult;
        AdResponse nextAd = adResult2 == null ? null : adResult2.nextAd();
        if (nextAd == null) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new g(this, nextAd, (Continuation<? super g>) null), 3, (Object) null);
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract T createModule(AdResponse adResponse2);

    public final void destroy() {
        if (!this.isDestroyed) {
            CoroutineScopeKt.cancel$default(getCoroutineScope(), (CancellationException) null, 1, (Object) null);
            invalidate();
            this.isDestroyed = true;
            this.isLoaded = false;
            this.isLoading = false;
        }
    }

    /* access modifiers changed from: protected */
    public final String getAdUnitId() {
        return this.adUnitId;
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        return this.context;
    }

    /* access modifiers changed from: protected */
    public final AdType getType() {
        return this.type;
    }

    /* access modifiers changed from: protected */
    public boolean handleError(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        boolean tryNext = tryNext();
        if (!tryNext) {
            this.isLoading = false;
        }
        return tryNext;
    }

    public boolean isAvailable() {
        if (this.isDestroyed || !this.isLoaded) {
            return false;
        }
        T t = this.module;
        return t != null && !t.isDestroyed();
    }

    public final boolean isDestroyed() {
        return this.isDestroyed;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    /* access modifiers changed from: protected */
    public boolean isValid(AdResponse adResponse2) {
        Intrinsics.checkNotNullParameter(adResponse2, "response");
        return adResponse2.a(this.type);
    }

    public final void loadAd() {
        loadAd$default(this, (RequestParameters) null, 1, (Object) null);
    }

    public final void loadAd(RequestParameters requestParameters) {
        if (!this.isDestroyed && !this.isLoading) {
            invalidate();
            this.isLoading = true;
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new b(this, requestParameters, (Continuation<? super b>) null), 3, (Object) null);
        }
    }

    public void onAdClicked() {
    }

    public void onAdDismissed() {
        if (!this.isDestroyed) {
            invalidate();
        }
    }

    public void onAdError(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        if (!this.isDestroyed && !tryNext()) {
            onAdFailed(adError);
        }
    }

    /* access modifiers changed from: protected */
    public void onAdFailed(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        this.isLoading = false;
    }

    public void onAdLoaded() {
        if (!this.isDestroyed) {
            this.isLoaded = true;
            this.isLoading = false;
        }
    }

    public void onAdShown() {
        if (!this.isDestroyed) {
            this.isShowing = true;
        }
    }

    public final boolean showAd() {
        if (!isAvailable()) {
            WortiseLog.e$default("showAd() called with no ad available", (Throwable) null, 2, (Object) null);
            return false;
        } else if (this.isShowing) {
            WortiseLog.e$default("An ad is already showing", (Throwable) null, 2, (Object) null);
            return false;
        } else {
            T t = this.module;
            if (t == null) {
                return false;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new f(t, (Continuation<? super f>) null), 3, (Object) null);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadAd(java.lang.String r11, com.wortise.ads.RequestParameters r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.wortise.ads.fullscreen.FullscreenAd.c
            if (r0 == 0) goto L_0x0013
            r0 = r13
            com.wortise.ads.fullscreen.FullscreenAd$c r0 = (com.wortise.ads.fullscreen.FullscreenAd.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.fullscreen.FullscreenAd$c r0 = new com.wortise.ads.fullscreen.FullscreenAd$c
            r0.<init>(r10, r13)
        L_0x0018:
            java.lang.Object r13 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r11 = r0.a
            com.wortise.ads.fullscreen.FullscreenAd r11 = (com.wortise.ads.fullscreen.FullscreenAd) r11
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0062
        L_0x002d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r13)
            com.wortise.ads.e r13 = new com.wortise.ads.e
            android.content.Context r5 = r10.getContext()
            com.wortise.ads.device.Dimensions r8 = r10.resolveAdSize()
            com.wortise.ads.AdType r9 = r10.getType()
            r4 = r13
            r6 = r11
            r7 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            kotlinx.coroutines.CoroutineDispatcher r11 = kotlinx.coroutines.Dispatchers.getIO()
            com.wortise.ads.fullscreen.FullscreenAd$d r12 = new com.wortise.ads.fullscreen.FullscreenAd$d
            r2 = 0
            r12.<init>(r13, r2)
            r0.a = r10
            r0.d = r3
            java.lang.Object r13 = kotlinx.coroutines.BuildersKt.withContext(r11, r12, r0)
            if (r13 != r1) goto L_0x0061
            return r1
        L_0x0061:
            r11 = r10
        L_0x0062:
            com.wortise.ads.e$b r13 = (com.wortise.ads.e.b) r13
            boolean r12 = r13 instanceof com.wortise.ads.e.b.a
            if (r12 == 0) goto L_0x0072
            com.wortise.ads.e$b$a r13 = (com.wortise.ads.e.b.a) r13
            com.wortise.ads.AdError r12 = r13.b()
            r11.onAdFailed(r12)
            goto L_0x007f
        L_0x0072:
            boolean r12 = r13 instanceof com.wortise.ads.e.b.C0001b
            if (r12 == 0) goto L_0x007f
            com.wortise.ads.e$b$b r13 = (com.wortise.ads.e.b.C0001b) r13
            com.wortise.ads.AdResult r12 = r13.a()
            r11.onAdFetched(r12)
        L_0x007f:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.fullscreen.FullscreenAd.loadAd(java.lang.String, com.wortise.ads.RequestParameters, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
