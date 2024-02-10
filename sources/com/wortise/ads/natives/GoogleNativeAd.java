package com.wortise.ads.natives;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.AdError;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdResult;
import com.wortise.ads.RequestParameters;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.e;
import com.wortise.ads.g;
import com.wortise.ads.k3;
import com.wortise.ads.o3;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(bv = {}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0002@AB\u001f\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b=\u0010>J%\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u0007\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\fJ)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\fJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u001b\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0006J\u0014\u0010!\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010$\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\"R\u0014\u0010&\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010,\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u001b\u00103\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102R\u0016\u00104\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u0018\u00107\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b7\u00108R(\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u00109\u001a\u0004\u0018\u00010\u000b8\u0006@BX\u000e¢\u0006\f\n\u0004\b\u001a\u0010:\u001a\u0004\b;\u0010<\u0002\u0004\n\u0002\b\u0019¨\u0006B"}, d2 = {"Lcom/wortise/ads/natives/GoogleNativeAd;", "", "", "adUnitId", "Lcom/wortise/ads/RequestParameters;", "parameters", "", "loadAd", "(Ljava/lang/String;Lcom/wortise/ads/RequestParameters;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "adRequest", "Lcom/google/android/gms/ads/nativead/NativeAd;", "(Ljava/lang/String;Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/wortise/ads/g$a;", "requestAd", "", "tryNext", "onNativeClicked", "Lcom/wortise/ads/AdError;", "error", "onNativeError", "onNativeFailed", "Lcom/wortise/ads/AdResult;", "result", "onNativeFetched", "onNativeImpression", "nativeAd", "onNativeLoaded", "Lcom/wortise/ads/AdResponse;", "response", "onNativeSelected", "(Lcom/wortise/ads/AdResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroy", "load", "Lcom/google/android/gms/ads/nativead/NativeAdOptions;", "options", "withNativeAdOptions", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Ljava/lang/String;", "Lcom/wortise/ads/natives/GoogleNativeAd$Listener;", "listener", "Lcom/wortise/ads/natives/GoogleNativeAd$Listener;", "adResult", "Lcom/wortise/ads/AdResult;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope$delegate", "Lkotlin/Lazy;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "isDestroyed", "Z", "isRequested", "nativeAdOptions", "Lcom/google/android/gms/ads/nativead/NativeAdOptions;", "<set-?>", "Lcom/google/android/gms/ads/nativead/NativeAd;", "getNativeAd", "()Lcom/google/android/gms/ads/nativead/NativeAd;", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lcom/wortise/ads/natives/GoogleNativeAd$Listener;)V", "Companion", "a", "Listener", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: GoogleNativeAd.kt */
public final class GoogleNativeAd {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private static final long TIMEOUT = 10000;
    private AdResult adResult;
    /* access modifiers changed from: private */
    public final String adUnitId;
    /* access modifiers changed from: private */
    public final Context context;
    private final Lazy coroutineScope$delegate = LazyKt.lazy(b.a);
    private boolean isDestroyed;
    private boolean isRequested;
    private final Listener listener;
    private NativeAd nativeAd;
    /* access modifiers changed from: private */
    public NativeAdOptions nativeAdOptions;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&¨\u0006\r"}, d2 = {"Lcom/wortise/ads/natives/GoogleNativeAd$Listener;", "", "onNativeClicked", "", "ad", "Lcom/wortise/ads/natives/GoogleNativeAd;", "onNativeFailed", "error", "Lcom/wortise/ads/AdError;", "onNativeImpression", "onNativeLoaded", "nativeAd", "Lcom/google/android/gms/ads/nativead/NativeAd;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: GoogleNativeAd.kt */
    public interface Listener {
        void onNativeClicked(GoogleNativeAd googleNativeAd);

        void onNativeFailed(GoogleNativeAd googleNativeAd, AdError adError);

        void onNativeImpression(GoogleNativeAd googleNativeAd);

        void onNativeLoaded(GoogleNativeAd googleNativeAd, NativeAd nativeAd);
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/wortise/ads/natives/GoogleNativeAd$a;", "", "", "TIMEOUT", "J", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GoogleNativeAd.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: GoogleNativeAd.kt */
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

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.natives.GoogleNativeAd$load$1", f = "GoogleNativeAd.kt", i = {}, l = {82, 84}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: GoogleNativeAd.kt */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ GoogleNativeAd b;
        final /* synthetic */ RequestParameters c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(GoogleNativeAd googleNativeAd, RequestParameters requestParameters, Continuation<? super c> continuation) {
            super(2, continuation);
            this.b = googleNativeAd;
            this.c = requestParameters;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.b, this.c, continuation);
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
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            GoogleNativeAd googleNativeAd = this.b;
            String access$getAdUnitId$p = googleNativeAd.adUnitId;
            RequestParameters requestParameters = this.c;
            this.a = 2;
            if (googleNativeAd.loadAd(access$getAdUnitId$p, requestParameters, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "com.wortise.ads.natives.GoogleNativeAd", f = "GoogleNativeAd.kt", i = {0}, l = {101}, m = "loadAd", n = {"this"}, s = {"L$0"})
    /* compiled from: GoogleNativeAd.kt */
    static final class d extends ContinuationImpl {
        Object a;
        /* synthetic */ Object b;
        final /* synthetic */ GoogleNativeAd c;
        int d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(GoogleNativeAd googleNativeAd, Continuation<? super d> continuation) {
            super(continuation);
            this.c = googleNativeAd;
        }

        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return this.c.loadAd((String) null, (RequestParameters) null, (Continuation<? super Unit>) this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/wortise/ads/g$a;", "Lcom/google/android/gms/ads/nativead/NativeAd;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.natives.GoogleNativeAd$loadAd$3", f = "GoogleNativeAd.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: GoogleNativeAd.kt */
    static final class e extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super g.a<NativeAd>>, Object> {
        int a;
        final /* synthetic */ GoogleNativeAd b;
        final /* synthetic */ String c;
        final /* synthetic */ AdManagerAdRequest d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(GoogleNativeAd googleNativeAd, String str, AdManagerAdRequest adManagerAdRequest, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = googleNativeAd;
            this.c = str;
            this.d = adManagerAdRequest;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super g.a<NativeAd>> continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                GoogleNativeAd googleNativeAd = this.b;
                String str = this.c;
                AdManagerAdRequest adManagerAdRequest = this.d;
                this.a = 1;
                obj = googleNativeAd.requestAd(str, adManagerAdRequest, this);
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
    @DebugMetadata(c = "com.wortise.ads.natives.GoogleNativeAd$loadAd$result$1", f = "GoogleNativeAd.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: GoogleNativeAd.kt */
    static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e.b>, Object> {
        int a;
        final /* synthetic */ com.wortise.ads.e b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(com.wortise.ads.e eVar, Continuation<? super f> continuation) {
            super(2, continuation);
            this.b = eVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super e.b> continuation) {
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
    public static final class g implements Flow<NativeAd> {
        final /* synthetic */ Flow a;
        final /* synthetic */ GoogleNativeAd b;
        final /* synthetic */ AdManagerAdRequest c;

        @Metadata(bv = {}, d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "value", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1})
        /* compiled from: Collect.kt */
        public static final class a implements FlowCollector<String> {
            final /* synthetic */ FlowCollector a;
            final /* synthetic */ GoogleNativeAd b;
            final /* synthetic */ AdManagerAdRequest c;

            @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
            @DebugMetadata(c = "com.wortise.ads.natives.GoogleNativeAd$onNativeSelected$$inlined$firstNotNull$1$2", f = "GoogleNativeAd.kt", i = {0}, l = {138, 139}, m = "emit", n = {"$this$mapNotNull_u24lambda_u2d5"}, s = {"L$0"})
            /* renamed from: com.wortise.ads.natives.GoogleNativeAd$g$a$a  reason: collision with other inner class name */
            public static final class C0190a extends ContinuationImpl {
                /* synthetic */ Object a;
                int b;
                Object c;
                final /* synthetic */ a d;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0190a(a aVar, Continuation continuation) {
                    super(continuation);
                    this.d = aVar;
                }

                public final Object invokeSuspend(Object obj) {
                    this.a = obj;
                    this.b |= Integer.MIN_VALUE;
                    return this.d.emit((Object) null, this);
                }
            }

            public a(FlowCollector flowCollector, GoogleNativeAd googleNativeAd, AdManagerAdRequest adManagerAdRequest) {
                this.a = flowCollector;
                this.b = googleNativeAd;
                this.c = adManagerAdRequest;
            }

            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x0058  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof com.wortise.ads.natives.GoogleNativeAd.g.a.C0190a
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    com.wortise.ads.natives.GoogleNativeAd$g$a$a r0 = (com.wortise.ads.natives.GoogleNativeAd.g.a.C0190a) r0
                    int r1 = r0.b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.b = r1
                    goto L_0x0018
                L_0x0013:
                    com.wortise.ads.natives.GoogleNativeAd$g$a$a r0 = new com.wortise.ads.natives.GoogleNativeAd$g$a$a
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
                    com.wortise.ads.natives.GoogleNativeAd r2 = r7.b
                    com.google.android.gms.ads.admanager.AdManagerAdRequest r5 = r7.c
                    r0.c = r9
                    r0.b = r4
                    java.lang.Object r8 = r2.loadAd((java.lang.String) r8, (com.google.android.gms.ads.admanager.AdManagerAdRequest) r5, (kotlin.coroutines.Continuation<? super com.google.android.gms.ads.nativead.NativeAd>) r0)
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
                throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.natives.GoogleNativeAd.g.a.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }

        public g(Flow flow, GoogleNativeAd googleNativeAd, AdManagerAdRequest adManagerAdRequest) {
            this.a = flow;
            this.b = googleNativeAd;
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
    @DebugMetadata(c = "com.wortise.ads.natives.GoogleNativeAd", f = "GoogleNativeAd.kt", i = {0, 0, 1}, l = {240, 261}, m = "onNativeSelected", n = {"this", "ids", "this"}, s = {"L$0", "L$1", "L$0"})
    /* compiled from: GoogleNativeAd.kt */
    static final class h extends ContinuationImpl {
        Object a;
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ GoogleNativeAd d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(GoogleNativeAd googleNativeAd, Continuation<? super h> continuation) {
            super(continuation);
            this.d = googleNativeAd;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.onNativeSelected((AdResponse) null, this);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"com/wortise/ads/natives/GoogleNativeAd$i", "Lcom/google/android/gms/ads/AdListener;", "", "onAdClicked", "Lcom/google/android/gms/ads/LoadAdError;", "error", "onAdFailedToLoad", "onAdImpression", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: GoogleNativeAd.kt */
    public static final class i extends AdListener {
        final /* synthetic */ GoogleNativeAd a;
        final /* synthetic */ CancellableContinuation<g.a<NativeAd>> b;

        i(GoogleNativeAd googleNativeAd, CancellableContinuation<? super g.a<NativeAd>> cancellableContinuation) {
            this.a = googleNativeAd;
            this.b = cancellableContinuation;
        }

        public void onAdClicked() {
            this.a.onNativeClicked();
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Intrinsics.checkNotNullParameter(loadAdError, "error");
            CancellableContinuation<g.a<NativeAd>> cancellableContinuation = this.b;
            g.a.C0184a aVar = new g.a.C0184a(loadAdError);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(aVar));
        }

        public void onAdImpression() {
            this.a.onNativeImpression();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/google/android/gms/ads/nativead/NativeAd;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: GoogleNativeAd.kt */
    static final class j implements NativeAd.OnNativeAdLoadedListener {
        final /* synthetic */ CancellableContinuation<g.a<NativeAd>> a;

        j(CancellableContinuation<? super g.a<NativeAd>> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        public final void onNativeAdLoaded(NativeAd nativeAd) {
            Intrinsics.checkNotNullParameter(nativeAd, "it");
            CancellableContinuation<g.a<NativeAd>> cancellableContinuation = this.a;
            g.a.b bVar = new g.a.b(nativeAd);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(bVar));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "com.wortise.ads.natives.GoogleNativeAd$tryNext$1", f = "GoogleNativeAd.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
    /* compiled from: GoogleNativeAd.kt */
    static final class k extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ GoogleNativeAd b;
        final /* synthetic */ AdResponse c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(GoogleNativeAd googleNativeAd, AdResponse adResponse, Continuation<? super k> continuation) {
            super(2, continuation);
            this.b = googleNativeAd;
            this.c = adResponse;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((k) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new k(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                GoogleNativeAd googleNativeAd = this.b;
                AdResponse adResponse = this.c;
                this.a = 1;
                if (googleNativeAd.onNativeSelected(adResponse, this) == coroutine_suspended) {
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

    public GoogleNativeAd(Context context2, String str, Listener listener2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(listener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.context = context2;
        this.adUnitId = str;
        this.listener = listener2;
    }

    private final CoroutineScope getCoroutineScope() {
        return (CoroutineScope) this.coroutineScope$delegate.getValue();
    }

    public static /* synthetic */ void load$default(GoogleNativeAd googleNativeAd, RequestParameters requestParameters, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            requestParameters = null;
        }
        googleNativeAd.load(requestParameters);
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
            boolean r0 = r15 instanceof com.wortise.ads.natives.GoogleNativeAd.d
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.wortise.ads.natives.GoogleNativeAd$d r0 = (com.wortise.ads.natives.GoogleNativeAd.d) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.d = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.natives.GoogleNativeAd$d r0 = new com.wortise.ads.natives.GoogleNativeAd$d
            r0.<init>(r12, r15)
        L_0x0018:
            java.lang.Object r15 = r0.b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r13 = r0.a
            com.wortise.ads.natives.GoogleNativeAd r13 = (com.wortise.ads.natives.GoogleNativeAd) r13
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
            com.wortise.ads.AdType r9 = com.wortise.ads.AdType.NATIVE
            r8 = 0
            r10 = 8
            r11 = 0
            r4 = r15
            r6 = r13
            r7 = r14
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            kotlinx.coroutines.CoroutineDispatcher r13 = kotlinx.coroutines.Dispatchers.getIO()
            com.wortise.ads.natives.GoogleNativeAd$f r14 = new com.wortise.ads.natives.GoogleNativeAd$f
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
            r13.onNativeFailed(r14)
            goto L_0x007b
        L_0x006e:
            boolean r14 = r15 instanceof com.wortise.ads.e.b.C0001b
            if (r14 == 0) goto L_0x007b
            com.wortise.ads.e$b$b r15 = (com.wortise.ads.e.b.C0001b) r15
            com.wortise.ads.AdResult r14 = r15.a()
            r13.onNativeFetched(r14)
        L_0x007b:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.natives.GoogleNativeAd.loadAd(java.lang.String, com.wortise.ads.RequestParameters, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void onNativeClicked() {
        if (!this.isDestroyed) {
            WortiseLog.i$default("Native ad clicked", (Throwable) null, 2, (Object) null);
            this.listener.onNativeClicked(this);
        }
    }

    private final void onNativeError(AdError adError) {
        if (!this.isDestroyed && !tryNext()) {
            onNativeFailed(adError);
        }
    }

    private final void onNativeFailed(AdError adError) {
        if (!this.isDestroyed) {
            WortiseLog.i$default("Native ad load failed for ad unit " + this.adUnitId + ": " + adError.name(), (Throwable) null, 2, (Object) null);
            this.listener.onNativeFailed(this, adError);
        }
    }

    private final void onNativeFetched(AdResult adResult2) {
        if (!this.isDestroyed) {
            this.adResult = adResult2;
            if (!tryNext()) {
                onNativeFailed(AdError.NO_FILL);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void onNativeImpression() {
        if (!this.isDestroyed) {
            WortiseLog.i$default("Native ad displayed", (Throwable) null, 2, (Object) null);
            this.listener.onNativeImpression(this);
        }
    }

    private final void onNativeLoaded(NativeAd nativeAd2) {
        if (!this.isDestroyed) {
            WortiseLog.i$default(Intrinsics.stringPlus("Native ad loaded for ad unit ", this.adUnitId), (Throwable) null, 2, (Object) null);
            this.listener.onNativeLoaded(this, nativeAd2);
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
    public final java.lang.Object onNativeSelected(com.wortise.ads.AdResponse r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.wortise.ads.natives.GoogleNativeAd.h
            if (r0 == 0) goto L_0x0013
            r0 = r8
            com.wortise.ads.natives.GoogleNativeAd$h r0 = (com.wortise.ads.natives.GoogleNativeAd.h) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            com.wortise.ads.natives.GoogleNativeAd$h r0 = new com.wortise.ads.natives.GoogleNativeAd$h
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
            com.wortise.ads.natives.GoogleNativeAd r7 = (com.wortise.ads.natives.GoogleNativeAd) r7
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
            com.wortise.ads.natives.GoogleNativeAd r2 = (com.wortise.ads.natives.GoogleNativeAd) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0098
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r8)
            com.wortise.ads.AdType r8 = com.wortise.ads.AdType.NATIVE
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
            r6.onNativeError(r7)
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
            r6.onNativeError(r7)
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
            com.wortise.ads.natives.GoogleNativeAd$g r5 = new com.wortise.ads.natives.GoogleNativeAd$g
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
            com.google.android.gms.ads.nativead.NativeAd r8 = (com.google.android.gms.ads.nativead.NativeAd) r8
            if (r8 != 0) goto L_0x00bd
            com.wortise.ads.AdError r8 = com.wortise.ads.AdError.NO_FILL
            r7.onNativeError(r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x00bd:
            r7.nativeAd = r8
            r7.onNativeLoaded(r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.natives.GoogleNativeAd.onNativeSelected(com.wortise.ads.AdResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object requestAd(String str, AdManagerAdRequest adManagerAdRequest, Continuation<? super g.a<NativeAd>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AdLoader.Builder withAdListener = new AdLoader.Builder(this.context, str).forNativeAd(new j(cancellableContinuationImpl)).withAdListener(new i(this, cancellableContinuationImpl));
        Intrinsics.checkNotNullExpressionValue(withAdListener, "Builder(context, adUnitI…ithAdListener(adListener)");
        NativeAdOptions access$getNativeAdOptions$p = this.nativeAdOptions;
        if (access$getNativeAdOptions$p != null) {
            withAdListener.withNativeAdOptions(access$getNativeAdOptions$p);
        }
        withAdListener.build().loadAd(adManagerAdRequest);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    private final boolean tryNext() {
        AdResult adResult2 = this.adResult;
        AdResponse nextAd = adResult2 == null ? null : adResult2.nextAd();
        if (nextAd == null) {
            return false;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new k(this, nextAd, (Continuation<? super k>) null), 3, (Object) null);
        return true;
    }

    public final void destroy() {
        if (!this.isDestroyed) {
            CoroutineScopeKt.cancel$default(getCoroutineScope(), (CancellationException) null, 1, (Object) null);
            NativeAd nativeAd2 = this.nativeAd;
            if (nativeAd2 != null) {
                nativeAd2.destroy();
            }
            this.isDestroyed = true;
        }
    }

    public final NativeAd getNativeAd() {
        return this.nativeAd;
    }

    public final void load() {
        load$default(this, (RequestParameters) null, 1, (Object) null);
    }

    public final void load(RequestParameters requestParameters) {
        if (!this.isDestroyed && !this.isRequested) {
            this.isRequested = true;
            Job unused = BuildersKt__Builders_commonKt.launch$default(getCoroutineScope(), (CoroutineContext) null, (CoroutineStart) null, new c(this, requestParameters, (Continuation<? super c>) null), 3, (Object) null);
        }
    }

    public final void withNativeAdOptions(NativeAdOptions nativeAdOptions2) {
        this.nativeAdOptions = nativeAdOptions2;
    }

    /* access modifiers changed from: private */
    public final Object loadAd(String str, AdManagerAdRequest adManagerAdRequest, Continuation<? super NativeAd> continuation) {
        return new com.wortise.ads.f(k3.NATIVE, str).a(10000, new e(this, str, adManagerAdRequest, (Continuation<? super e>) null), continuation);
    }
}
