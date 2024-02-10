package com.wortise.ads;

import android.content.Context;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

@Metadata(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ9\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0011J1\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u0013J1\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Lcom/wortise/ads/g;", "", "Landroid/content/Context;", "context", "", "adUnitId", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "adRequest", "", "orientation", "Lcom/wortise/ads/g$a;", "Lcom/google/android/gms/ads/appopen/AppOpenAd;", "a", "(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/ads/AdSize;", "adSize", "Lcom/google/android/gms/ads/admanager/AdManagerAdView;", "(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;Lcom/google/android/gms/ads/AdSize;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/ads/admanager/AdManagerInterstitialAd;", "(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/google/android/gms/ads/rewarded/RewardedAd;", "b", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdLoader.kt */
public final class g {
    public static final g a = new g();

    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/wortise/ads/g$a;", "T", "", "<init>", "()V", "a", "b", "Lcom/wortise/ads/g$a$a;", "Lcom/wortise/ads/g$a$b;", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdLoader.kt */
    public static abstract class a<T> {

        @Metadata(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/wortise/ads/g$a$a;", "T", "Lcom/wortise/ads/g$a;", "Lcom/google/android/gms/ads/AdError;", "error", "Lcom/google/android/gms/ads/AdError;", "a", "()Lcom/google/android/gms/ads/AdError;", "<init>", "(Lcom/google/android/gms/ads/AdError;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* renamed from: com.wortise.ads.g$a$a  reason: collision with other inner class name */
        /* compiled from: AdLoader.kt */
        public static final class C0184a<T> extends a<T> {
            private final AdError a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0184a(AdError adError) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(adError, "error");
                this.a = adError;
            }

            public final AdError a() {
                return this.a;
            }
        }

        @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00028\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/wortise/ads/g$a$b;", "T", "Lcom/wortise/ads/g$a;", "value", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* compiled from: AdLoader.kt */
        public static final class b<T> extends a<T> {
            private final T a;

            public b(T t) {
                super((DefaultConstructorMarker) null);
                this.a = t;
            }

            public final T a() {
                return this.a;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/wortise/ads/g$b", "Lcom/google/android/gms/ads/appopen/AppOpenAd$AppOpenAdLoadCallback;", "Lcom/google/android/gms/ads/LoadAdError;", "error", "", "onAdFailedToLoad", "Lcom/google/android/gms/ads/appopen/AppOpenAd;", "ad", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdLoader.kt */
    public static final class b extends AppOpenAd.AppOpenAdLoadCallback {
        final /* synthetic */ CancellableContinuation<a<AppOpenAd>> a;

        b(CancellableContinuation<? super a<AppOpenAd>> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        /* renamed from: a */
        public void onAdLoaded(AppOpenAd appOpenAd) {
            Intrinsics.checkNotNullParameter(appOpenAd, "ad");
            CancellableContinuation<a<AppOpenAd>> cancellableContinuation = this.a;
            a.b bVar = new a.b(appOpenAd);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(bVar));
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Intrinsics.checkNotNullParameter(loadAdError, "error");
            CancellableContinuation<a<AppOpenAd>> cancellableContinuation = this.a;
            a.C0184a aVar = new a.C0184a(loadAdError);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(aVar));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016¨\u0006\u0007"}, d2 = {"com/wortise/ads/g$c", "Lcom/google/android/gms/ads/AdListener;", "Lcom/google/android/gms/ads/LoadAdError;", "error", "", "onAdFailedToLoad", "onAdLoaded", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdLoader.kt */
    public static final class c extends AdListener {
        final /* synthetic */ CancellableContinuation<a<AdManagerAdView>> a;
        final /* synthetic */ AdManagerAdView b;

        c(CancellableContinuation<? super a<AdManagerAdView>> cancellableContinuation, AdManagerAdView adManagerAdView) {
            this.a = cancellableContinuation;
            this.b = adManagerAdView;
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Intrinsics.checkNotNullParameter(loadAdError, "error");
            CancellableContinuation<a<AdManagerAdView>> cancellableContinuation = this.a;
            a.C0184a aVar = new a.C0184a(loadAdError);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(aVar));
        }

        public void onAdLoaded() {
            CancellableContinuation<a<AdManagerAdView>> cancellableContinuation = this.a;
            a.b bVar = new a.b(this.b);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(bVar));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/wortise/ads/g$d", "Lcom/google/android/gms/ads/admanager/AdManagerInterstitialAdLoadCallback;", "Lcom/google/android/gms/ads/LoadAdError;", "error", "", "onAdFailedToLoad", "Lcom/google/android/gms/ads/admanager/AdManagerInterstitialAd;", "ad", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdLoader.kt */
    public static final class d extends AdManagerInterstitialAdLoadCallback {
        final /* synthetic */ CancellableContinuation<a<AdManagerInterstitialAd>> a;

        d(CancellableContinuation<? super a<AdManagerInterstitialAd>> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        /* renamed from: a */
        public void onAdLoaded(AdManagerInterstitialAd adManagerInterstitialAd) {
            Intrinsics.checkNotNullParameter(adManagerInterstitialAd, "ad");
            CancellableContinuation<a<AdManagerInterstitialAd>> cancellableContinuation = this.a;
            a.b bVar = new a.b(adManagerInterstitialAd);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(bVar));
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Intrinsics.checkNotNullParameter(loadAdError, "error");
            CancellableContinuation<a<AdManagerInterstitialAd>> cancellableContinuation = this.a;
            a.C0184a aVar = new a.C0184a(loadAdError);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(aVar));
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\t"}, d2 = {"com/wortise/ads/g$e", "Lcom/google/android/gms/ads/rewarded/RewardedAdLoadCallback;", "Lcom/google/android/gms/ads/LoadAdError;", "error", "", "onAdFailedToLoad", "Lcom/google/android/gms/ads/rewarded/RewardedAd;", "ad", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: AdLoader.kt */
    public static final class e extends RewardedAdLoadCallback {
        final /* synthetic */ CancellableContinuation<a<RewardedAd>> a;

        e(CancellableContinuation<? super a<RewardedAd>> cancellableContinuation) {
            this.a = cancellableContinuation;
        }

        /* renamed from: a */
        public void onAdLoaded(RewardedAd rewardedAd) {
            Intrinsics.checkNotNullParameter(rewardedAd, "ad");
            CancellableContinuation<a<RewardedAd>> cancellableContinuation = this.a;
            a.b bVar = new a.b(rewardedAd);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(bVar));
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Intrinsics.checkNotNullParameter(loadAdError, "error");
            CancellableContinuation<a<RewardedAd>> cancellableContinuation = this.a;
            a.C0184a aVar = new a.C0184a(loadAdError);
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m2344constructorimpl(aVar));
        }
    }

    private g() {
    }

    public final Object a(Context context, String str, AdManagerAdRequest adManagerAdRequest, int i, Continuation<? super a<AppOpenAd>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AppOpenAd.load(context, str, adManagerAdRequest, i, (AppOpenAd.AppOpenAdLoadCallback) new b(cancellableContinuationImpl));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object b(Context context, String str, AdManagerAdRequest adManagerAdRequest, Continuation<? super a<RewardedAd>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        e eVar = new e(cancellableContinuationImpl);
        o3.a.b(context);
        RewardedAd.load(context, str, adManagerAdRequest, (RewardedAdLoadCallback) eVar);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object a(Context context, String str, AdManagerAdRequest adManagerAdRequest, AdSize adSize, Continuation<? super a<AdManagerAdView>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        AdManagerAdView adManagerAdView = new AdManagerAdView(context);
        c cVar = new c(cancellableContinuationImpl, adManagerAdView);
        o3.a.b(context);
        adManagerAdView.setAdListener(cVar);
        adManagerAdView.setAdUnitId(str);
        adManagerAdView.setAdSize(adSize);
        adManagerAdView.loadAd(adManagerAdRequest);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public final Object a(Context context, String str, AdManagerAdRequest adManagerAdRequest, Continuation<? super a<AdManagerInterstitialAd>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        d dVar = new d(cancellableContinuationImpl);
        o3.a.b(context);
        AdManagerInterstitialAd.load(context, str, adManagerAdRequest, dVar);
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
