package com.wortise.ads.appopen;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.wortise.ads.AdError;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdResult;
import com.wortise.ads.RequestParameters;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.e;
import com.wortise.ads.g;
import com.wortise.ads.k3;
import com.wortise.ads.o3;
import java.util.Date;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u000e*\u0001M\b\u0007\u0018\u0000 V2\u00020\u0001:\u0003WXYB\u0017\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\bT\u0010UJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J%\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ%\u0010\b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\rJ\b\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\u001b\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0002H\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0014\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007J\u000e\u0010!\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u001fJ\u0010\u0010\"\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u001fR\u0014\u0010$\u001a\u00020#8\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u001e\u0010*\u001a\n\u0018\u00010\fj\u0004\u0018\u0001`)8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u001b\u00101\u001a\u00020,8BX\u0002¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0016\u00102\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00106R\"\u00107\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b7\u00103\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R$\u0010=\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e8\u0006@BX\u000e¢\u0006\f\n\u0004\b=\u00103\u001a\u0004\b=\u00109R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u00020\u000e2\u0006\u0010<\u001a\u00020\u000e8\u0006@BX\u000e¢\u0006\f\n\u0004\bE\u00103\u001a\u0004\bE\u00109R\"\u0010G\u001a\u00020F8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0014\u0010R\u001a\u0002048BX\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0011\u0010S\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\bS\u00109\u0002\u0004\n\u0002\b\u0019¨\u0006Z"}, d2 = {"Lcom/wortise/ads/appopen/AppOpenAd;", "", "", "invalidate", "", "adUnitId", "Lcom/wortise/ads/RequestParameters;", "parameters", "loadAd", "(Ljava/lang/String;Lcom/wortise/ads/RequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "adRequest", "Lcom/google/android/gms/ads/appopen/AppOpenAd;", "(Ljava/lang/String;Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "tryNext", "onAppOpenClicked", "onAppOpenDismissed", "Lcom/wortise/ads/AdError;", "error", "onAppOpenFailed", "Lcom/wortise/ads/AdResult;", "result", "onAppOpenFetched", "onAppOpenLoaded", "Lcom/wortise/ads/AdResponse;", "response", "onAppOpenSelected", "(Lcom/wortise/ads/AdResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAppOpenShown", "destroy", "Landroid/app/Activity;", "activity", "showAd", "tryToShowAd", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Ljava/lang/String;", "adResult", "Lcom/wortise/ads/AdResult;", "Lcom/wortise/ads/appopen/GoogleAppOpenAd;", "appOpenAd", "Lcom/google/android/gms/ads/appopen/AppOpenAd;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "isLoading", "Z", "", "loadTime", "J", "autoReload", "getAutoReload", "()Z", "setAutoReload", "(Z)V", "<set-?>", "isDestroyed", "Lcom/wortise/ads/appopen/AppOpenAd$Listener;", "listener", "Lcom/wortise/ads/appopen/AppOpenAd$Listener;", "getListener", "()Lcom/wortise/ads/appopen/AppOpenAd$Listener;", "setListener", "(Lcom/wortise/ads/appopen/AppOpenAd$Listener;)V", "isShowing", "Lcom/wortise/ads/appopen/AppOpenAd$Orientation;", "orientation", "Lcom/wortise/ads/appopen/AppOpenAd$Orientation;", "getOrientation", "()Lcom/wortise/ads/appopen/AppOpenAd$Orientation;", "setOrientation", "(Lcom/wortise/ads/appopen/AppOpenAd$Orientation;)V", "com/wortise/ads/appopen/AppOpenAd$c", "fullScreenContentCallback", "Lcom/wortise/ads/appopen/AppOpenAd$c;", "getElapsedTime", "()J", "elapsedTime", "isAvailable", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "Companion", "a", "Listener", "Orientation", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AppOpenAd.kt */
public final class AppOpenAd {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final long MAX_ELAPSED_TIME = 14400000;
    private static final long TIMEOUT = 10000;
    private AdResult adResult;
    /* access modifiers changed from: private */
    public final String adUnitId;
    private com.google.android.gms.ads.appopen.AppOpenAd appOpenAd;
    private boolean autoReload;
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy coroutineScope$delegate = LazyKt.lazy(b.a);
    private final c fullScreenContentCallback = new c(this);
    private boolean isDestroyed;
    /* access modifiers changed from: private */
    public boolean isLoading;
    private boolean isShowing;
    private Listener listener;
    private long loadTime;
    private Orientation orientation = Orientation.PORTRAIT;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/wortise/ads/appopen/AppOpenAd$Listener;", "", "onAppOpenClicked", "", "ad", "Lcom/wortise/ads/appopen/AppOpenAd;", "onAppOpenDismissed", "onAppOpenFailed", "error", "Lcom/wortise/ads/AdError;", "onAppOpenLoaded", "onAppOpenShown", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppOpenAd.kt */
    public interface Listener {
        void onAppOpenClicked(AppOpenAd appOpenAd);

        void onAppOpenDismissed(AppOpenAd appOpenAd);

        void onAppOpenFailed(AppOpenAd appOpenAd, AdError adError);

        void onAppOpenLoaded(AppOpenAd appOpenAd);

        void onAppOpenShown(AppOpenAd appOpenAd);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/wortise/ads/appopen/AppOpenAd$Orientation;", "", "value", "", "(Ljava/lang/String;II)V", "getValue$sdk_productionRelease", "()I", "LANDSCAPE", "PORTRAIT", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppOpenAd.kt */
    public enum Orientation {
        LANDSCAPE(2),
        PORTRAIT(1);
        
        private final int value;

        private Orientation(int i) {
            this.value = i;
        }

        public final int getValue$sdk_productionRelease() {
            return this.value;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/wortise/ads/appopen/AppOpenAd$a;", "", "", "MAX_ELAPSED_TIME", "J", "TIMEOUT", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AppOpenAd.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: AppOpenAd.kt */
    static final class b extends Lambda implements Function0<CoroutineScope> {
        public static final b a = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.MainScope();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0014\u0010\b\u001a\u00020\u00022\n\u0010\u0007\u001a\u00060\u0005j\u0002`\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/wortise/ads/appopen/AppOpenAd$c", "Lcom/google/android/gms/ads/FullScreenContentCallback;", "", "onAdClicked", "onAdDismissedFullScreenContent", "Lcom/google/android/gms/ads/AdError;", "Lcom/wortise/ads/appopen/GoogleAdError;", "error", "onAdFailedToShowFullScreenContent", "onAdShowedFullScreenContent", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AppOpenAd.kt */
    public static final class c extends FullScreenContentCallback {
        final /* synthetic */ AppOpenAd a;

        c(AppOpenAd appOpenAd) {
            this.a = appOpenAd;
        }

        public void onAdClicked() {
            this.a.onAppOpenClicked();
        }

        public void onAdDismissedFullScreenContent() {
            this.a.onAppOpenDismissed();
        }

        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
            Intrinsics.checkNotNullParameter(adError, "error");
            this.a.onAppOpenFailed(AdError.UNSPECIFIED);
        }

        public void onAdShowedFullScreenContent() {
            this.a.onAppOpenShown();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.appopen.AppOpenAd$loadAd$1", f = "AppOpenAd.kt", i = {}, l = {111, 113}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: AppOpenAd.kt */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ AppOpenAd b;
        final /* synthetic */ RequestParameters c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(AppOpenAd appOpenAd, RequestParameters requestParameters, Continuation<? super d> continuation) {
            super(2, continuation);
            this.b = appOpenAd;
            this.c = requestParameters;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new d(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                o3 o3Var = o3.a;
                Context access$getContext$p = this.b.context;
                this.a = 1;
                if (o3Var.b(access$getContext$p, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                this.b.isLoading = false;
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AppOpenAd appOpenAd = this.b;
            String access$getAdUnitId$p = appOpenAd.adUnitId;
            RequestParameters requestParameters = this.c;
            this.a = 2;
            if (appOpenAd.loadAd(access$getAdUnitId$p, requestParameters, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            this.b.isLoading = false;
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.appopen.AppOpenAd", f = "AppOpenAd.kt", i = {0}, l = {163}, m = "loadAd", n = {"this"}, s = {"L$0"})
    /* compiled from: AppOpenAd.kt */
    static final class e extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ AppOpenAd c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(AppOpenAd appOpenAd, Continuation<? super e> continuation) {
            super(continuation);
            this.c = appOpenAd;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.loadAd((String) null, (RequestParameters) null, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/g$a;", "Lcom/google/android/gms/ads/appopen/AppOpenAd;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.appopen.AppOpenAd$loadAd$4", f = "AppOpenAd.kt", i = {}, l = {179}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: AppOpenAd.kt */
    static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g.a<com.google.android.gms.ads.appopen.AppOpenAd>>, Object> {
        int a;
        final /* synthetic */ AppOpenAd b;
        final /* synthetic */ String c;
        final /* synthetic */ AdManagerAdRequest d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(AppOpenAd appOpenAd, String str, AdManagerAdRequest adManagerAdRequest, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = appOpenAd;
            this.c = str;
            this.d = adManagerAdRequest;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super g.a<com.google.android.gms.ads.appopen.AppOpenAd>> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new f(this.b, this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                com.wortise.ads.g gVar = com.wortise.ads.g.a;
                Context access$getContext$p = this.b.context;
                String str = this.c;
                AdManagerAdRequest adManagerAdRequest = this.d;
                int value$sdk_productionRelease = this.b.getOrientation().getValue$sdk_productionRelease();
                this.a = 1;
                obj = gVar.a(access$getContext$p, str, adManagerAdRequest, value$sdk_productionRelease, (Continuation<? super g.a<com.google.android.gms.ads.appopen.AppOpenAd>>) this);
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

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/e$b;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.appopen.AppOpenAd$loadAd$result$1", f = "AppOpenAd.kt", i = {}, l = {164}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: AppOpenAd.kt */
    static final class g extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e.b>, Object> {
        int a;
        final /* synthetic */ com.wortise.ads.e b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(com.wortise.ads.e eVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.b = eVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super e.b> continuation) {
            return ((g) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new g(this.b, continuation);
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

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J!\u0010\u0005\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
    /* compiled from: SafeCollector.common.kt */
    public static final class h implements Flow<com.google.android.gms.ads.appopen.AppOpenAd> {
        final /* synthetic */ Flow a;
        final /* synthetic */ AppOpenAd b;
        final /* synthetic */ AdManagerAdRequest c;

        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Collect.kt */
        public static final class a implements FlowCollector<String> {
            final /* synthetic */ FlowCollector a;
            final /* synthetic */ AppOpenAd b;
            final /* synthetic */ AdManagerAdRequest c;

            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
            @DebugMetadata(c = "com.wortise.ads.appopen.AppOpenAd$onAppOpenSelected$$inlined$firstNotNull$1$2", f = "AppOpenAd.kt", i = {0}, l = {138, 139}, m = "emit", n = {"$this$mapNotNull_u24lambda_u2d5"}, s = {"L$0"})
            /* renamed from: com.wortise.ads.appopen.AppOpenAd$h$a$a  reason: collision with other inner class name */
            public static final class C0178a extends ContinuationImpl {
                /* synthetic */ Object a;
                int b;
                Object c;
                final /* synthetic */ a d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0178a(a aVar, Continuation continuation) {
                    super(continuation);
                    this.d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return this.d.emit((Object) null, this);
                }
            }

            public a(FlowCollector flowCollector, AppOpenAd appOpenAd, AdManagerAdRequest adManagerAdRequest) {
                this.a = flowCollector;
                this.b = appOpenAd;
                this.c = adManagerAdRequest;
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.wortise.ads.appopen.AppOpenAd.h.a.C0178a
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    com.wortise.ads.appopen.AppOpenAd$h$a$a r0 = (com.wortise.ads.appopen.AppOpenAd.h.a.C0178a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    com.wortise.ads.appopen.AppOpenAd$h$a$a r0 = new com.wortise.ads.appopen.AppOpenAd$h$a$a
                    r0.<init>(r7, r9)
                L_0x0018:
                    java.lang.Object r9 = r0.a
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.b
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003c
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x0064
                L_0x002c:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0034:
                    java.lang.Object r8 = r0.c
                    kotlinx.coroutines.flow.FlowCollector r8 = (kotlinx.coroutines.flow.FlowCollector) r8
                    kotlin.ResultKt.throwOnFailure(r9)
                    goto L_0x0055
                L_0x003c:
                    kotlin.ResultKt.throwOnFailure(r9)
                    kotlinx.coroutines.flow.FlowCollector r9 = r7.a
                    java.lang.String r8 = (java.lang.String) r8
                    com.wortise.ads.appopen.AppOpenAd r2 = r7.b
                    com.google.android.gms.ads.admanager.AdManagerAdRequest r5 = r7.c
                    r0.c = r9
                    r0.b = r4
                    java.lang.Object r8 = r2.loadAd((java.lang.String) r8, (com.google.android.gms.ads.admanager.AdManagerAdRequest) r5, (kotlin.coroutines.Continuation<? super com.google.android.gms.ads.appopen.AppOpenAd>) r0)
                    if (r8 != r1) goto L_0x0052
                    return r1
                L_0x0052:
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L_0x0055:
                    if (r9 != 0) goto L_0x0058
                    goto L_0x0064
                L_0x0058:
                    r2 = 0
                    r0.c = r2
                    r0.b = r3
                    java.lang.Object r8 = r8.emit(r9, r0)
                    if (r8 != r1) goto L_0x0064
                    return r1
                L_0x0064:
                    kotlin.Unit r8 = kotlin.Unit.INSTANCE
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.appopen.AppOpenAd.h.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public h(Flow flow, AppOpenAd appOpenAd, AdManagerAdRequest adManagerAdRequest) {
            this.a = flow;
            this.b = appOpenAd;
            this.c = adManagerAdRequest;
        }

        public Object collect(FlowCollector flowCollector, Continuation continuation) {
            Object collect = this.a.collect(new a(flowCollector, this.b, this.c), continuation);
            if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return collect;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.appopen.AppOpenAd", f = "AppOpenAd.kt", i = {0, 0, 1}, l = {268, 324}, m = "onAppOpenSelected", n = {"this", "ids", "this"}, s = {"L$0", "L$1", "L$0"})
    /* compiled from: AppOpenAd.kt */
    static final class i extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ AppOpenAd d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(AppOpenAd appOpenAd, Continuation<? super i> continuation) {
            super(continuation);
            this.d = appOpenAd;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.onAppOpenSelected((AdResponse) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.appopen.AppOpenAd$tryNext$1", f = "AppOpenAd.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: AppOpenAd.kt */
    static final class j extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ AppOpenAd b;
        final /* synthetic */ AdResponse c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(AppOpenAd appOpenAd, AdResponse adResponse, Continuation<? super j> continuation) {
            super(2, continuation);
            this.b = appOpenAd;
            this.c = adResponse;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((j) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new j(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                AppOpenAd appOpenAd = this.b;
                AdResponse adResponse = this.c;
                this.a = 1;
                if (appOpenAd.onAppOpenSelected(adResponse, this) == coroutine_suspended) {
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

    public AppOpenAd(Context context2, String str) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        this.context = context2;
        this.adUnitId = str;
    }

    private final CoroutineScope getCoroutineScope() {
        return (CoroutineScope) this.coroutineScope$delegate.getValue();
    }

    private final long getElapsedTime() {
        return new Date().getTime() - this.loadTime;
    }

    private final void invalidate() {
        if (!this.isDestroyed) {
            this.appOpenAd = null;
        }
    }

    public static /* synthetic */ void loadAd$default(AppOpenAd appOpenAd2, RequestParameters requestParameters, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            requestParameters = null;
        }
        appOpenAd2.loadAd(requestParameters);
    }

    /* access modifiers changed from: private */
    public final void onAppOpenClicked() {
        if (!this.isDestroyed) {
            WortiseLog.i$default("App open ad clicked", (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAppOpenClicked(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onAppOpenDismissed() {
        if (!this.isDestroyed) {
            WortiseLog.i$default("App open ad dismissed", (Throwable) null, 2, (Object) null);
            invalidate();
            this.isShowing = false;
            if (this.autoReload) {
                loadAd$default(this, (RequestParameters) null, 1, (Object) null);
            }
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAppOpenDismissed(this);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onAppOpenFailed(AdError adError) {
        if (!this.isDestroyed) {
            WortiseLog.i$default("App open ad load failed for ad unit " + this.adUnitId + ": " + adError.name(), (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAppOpenFailed(this, adError);
            }
        }
    }

    private final void onAppOpenFetched(AdResult adResult2) {
        if (!this.isDestroyed) {
            this.adResult = adResult2;
            if (!tryNext()) {
                onAppOpenFailed(AdError.NO_FILL);
            }
        }
    }

    private final void onAppOpenLoaded() {
        if (!this.isDestroyed) {
            WortiseLog.i$default(Intrinsics.stringPlus("App open ad loaded for ad unit ", this.adUnitId), (Throwable) null, 2, (Object) null);
            this.loadTime = new Date().getTime();
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAppOpenLoaded(this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onAppOpenSelected(com.wortise.ads.AdResponse r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.wortise.ads.appopen.AppOpenAd.i
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.appopen.AppOpenAd$i r0 = (com.wortise.ads.appopen.AppOpenAd.i) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.appopen.AppOpenAd$i r0 = new com.wortise.ads.appopen.AppOpenAd$i
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r5) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            java.lang.Object r7 = r0.a
            com.wortise.ads.appopen.AppOpenAd r7 = (com.wortise.ads.appopen.AppOpenAd) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00b1
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003a:
            java.lang.Object r7 = r0.b
            java.util.List r7 = (java.util.List) r7
            java.lang.Object r2 = r0.a
            com.wortise.ads.appopen.AppOpenAd r2 = (com.wortise.ads.appopen.AppOpenAd) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0098
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r8)
            com.wortise.ads.AdType r8 = com.wortise.ads.AdType.APP_OPEN
            boolean r8 = r7.a((com.wortise.ads.AdType) r8)
            r2 = 0
            if (r8 == 0) goto L_0x005c
            com.wortise.ads.AdFormat r8 = com.wortise.ads.AdFormat.GOOGLE
            boolean r8 = r7.a((com.wortise.ads.AdFormat) r8)
            if (r8 == 0) goto L_0x005c
            r8 = 1
            goto L_0x005d
        L_0x005c:
            r8 = 0
        L_0x005d:
            if (r8 != 0) goto L_0x0067
            com.wortise.ads.AdError r7 = com.wortise.ads.AdError.INVALID_PARAMS
            r6.onAppOpenFailed(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0067:
            com.wortise.ads.google.models.GoogleParams r7 = r7.i()
            if (r7 != 0) goto L_0x006f
            r7 = r3
            goto L_0x0073
        L_0x006f:
            java.util.List r7 = r7.a()
        L_0x0073:
            if (r7 == 0) goto L_0x007b
            boolean r8 = r7.isEmpty()
            if (r8 == 0) goto L_0x007c
        L_0x007b:
            r2 = 1
        L_0x007c:
            if (r2 == 0) goto L_0x0086
            com.wortise.ads.AdError r7 = com.wortise.ads.AdError.NO_FILL
            r6.onAppOpenFailed(r7)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0086:
            com.wortise.ads.k r8 = com.wortise.ads.k.a
            android.content.Context r2 = r6.context
            r0.a = r6
            r0.b = r7
            r0.e = r5
            java.lang.Object r8 = r8.a((android.content.Context) r2, (kotlin.coroutines.Continuation<? super com.google.android.gms.ads.admanager.AdManagerAdRequest>) r0)
            if (r8 != r1) goto L_0x0097
            return r1
        L_0x0097:
            r2 = r6
        L_0x0098:
            com.google.android.gms.ads.admanager.AdManagerAdRequest r8 = (com.google.android.gms.ads.admanager.AdManagerAdRequest) r8
            kotlinx.coroutines.flow.Flow r7 = kotlinx.coroutines.flow.FlowKt.asFlow(r7)
            com.wortise.ads.appopen.AppOpenAd$h r5 = new com.wortise.ads.appopen.AppOpenAd$h
            r5.<init>(r7, r2, r8)
            r0.a = r2
            r0.b = r3
            r0.e = r4
            java.lang.Object r8 = kotlinx.coroutines.flow.FlowKt.firstOrNull(r5, r0)
            if (r8 != r1) goto L_0x00b0
            return r1
        L_0x00b0:
            r7 = r2
        L_0x00b1:
            com.google.android.gms.ads.appopen.AppOpenAd r8 = (com.google.android.gms.ads.appopen.AppOpenAd) r8
            if (r8 != 0) goto L_0x00bd
            com.wortise.ads.AdError r8 = com.wortise.ads.AdError.NO_FILL
            r7.onAppOpenFailed(r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00bd:
            com.wortise.ads.appopen.AppOpenAd$c r0 = r7.fullScreenContentCallback
            r8.setFullScreenContentCallback(r0)
            r7.appOpenAd = r8
            r7.onAppOpenLoaded()
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.appopen.AppOpenAd.onAppOpenSelected(com.wortise.ads.AdResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void onAppOpenShown() {
        if (!this.isDestroyed) {
            WortiseLog.i$default("App open ad shown", (Throwable) null, 2, (Object) null);
            this.isShowing = true;
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAppOpenShown(this);
            }
        }
    }

    private final boolean tryNext() {
        AdResult adResult2 = this.adResult;
        AdResponse nextAd = adResult2 == null ? null : adResult2.nextAd();
        if (nextAd == null) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new j(this, nextAd, (Continuation<? super j>) null), 3, (Object) null);
        return true;
    }

    public final void destroy() {
        if (!this.isDestroyed) {
            CoroutineScopeKt.cancel$default(getCoroutineScope(), (CancellationException) null, 1, (Object) null);
            invalidate();
            this.isDestroyed = true;
            this.isLoading = false;
        }
    }

    public final boolean getAutoReload() {
        return this.autoReload;
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final boolean isAvailable() {
        return !this.isDestroyed && this.appOpenAd != null && getElapsedTime() < MAX_ELAPSED_TIME;
    }

    public final boolean isDestroyed() {
        return this.isDestroyed;
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public final void loadAd() {
        loadAd$default(this, (RequestParameters) null, 1, (Object) null);
    }

    public final void loadAd(RequestParameters requestParameters) {
        if (!this.isDestroyed && !isAvailable() && !this.isLoading) {
            this.isLoading = true;
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new d(this, requestParameters, (Continuation<? super d>) null), 3, (Object) null);
        }
    }

    public final void setAutoReload(boolean z) {
        this.autoReload = z;
    }

    public final void setListener(Listener listener2) {
        this.listener = listener2;
    }

    public final void setOrientation(Orientation orientation2) {
        Intrinsics.checkNotNullParameter(orientation2, "<set-?>");
        this.orientation = orientation2;
    }

    public final boolean showAd(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        com.google.android.gms.ads.appopen.AppOpenAd appOpenAd2 = this.appOpenAd;
        if (appOpenAd2 == null) {
            WortiseLog.e$default("showAd() called with no ad available", (Throwable) null, 2, (Object) null);
            return false;
        } else if (this.isShowing) {
            WortiseLog.e$default("An ad is already showing", (Throwable) null, 2, (Object) null);
            return false;
        } else {
            appOpenAd2.show(activity);
            return true;
        }
    }

    public final boolean tryToShowAd(Activity activity) {
        if (!isAvailable()) {
            loadAd$default(this, (RequestParameters) null, 1, (Object) null);
            return false;
        } else if (activity != null && showAd(activity)) {
            return true;
        } else {
            return false;
        }
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
            boolean r0 = r15 instanceof com.wortise.ads.appopen.AppOpenAd.e
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.wortise.ads.appopen.AppOpenAd$e r0 = (com.wortise.ads.appopen.AppOpenAd.e) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.appopen.AppOpenAd$e r0 = new com.wortise.ads.appopen.AppOpenAd$e
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r13 = r0.a
            com.wortise.ads.appopen.AppOpenAd r13 = (com.wortise.ads.appopen.AppOpenAd) r13
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
            com.wortise.ads.AdType r9 = com.wortise.ads.AdType.APP_OPEN
            r8 = 0
            r10 = 8
            r11 = 0
            r4 = r15
            r6 = r13
            r7 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getIO()
            com.wortise.ads.appopen.AppOpenAd$g r14 = new com.wortise.ads.appopen.AppOpenAd$g
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
            r13.onAppOpenFailed(r14)
            goto L_0x007b
        L_0x006e:
            boolean r14 = r15 instanceof com.wortise.ads.e.b.C0001b
            if (r14 == 0) goto L_0x007b
            com.wortise.ads.e$b$b r15 = (com.wortise.ads.e.b.C0001b) r15
            com.wortise.ads.AdResult r14 = r15.a()
            r13.onAppOpenFetched(r14)
        L_0x007b:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.appopen.AppOpenAd.loadAd(java.lang.String, com.wortise.ads.RequestParameters, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object loadAd(String str, AdManagerAdRequest adManagerAdRequest, Continuation<? super com.google.android.gms.ads.appopen.AppOpenAd> continuation) {
        return new com.wortise.ads.f(k3.APP_OPEN, str).a(10000, new f(this, str, adManagerAdRequest, (Continuation<? super f>) null), continuation);
    }
}
