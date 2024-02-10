package com.wortise.ads.interstitial.modules;

import android.content.Context;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.wortise.ads.AdError;
import com.wortise.ads.AdFormat;
import com.wortise.ads.AdResponse;
import com.wortise.ads.interstitial.InterstitialActivity;
import com.wortise.ads.interstitial.modules.BaseInterstitialModule;
import com.wortise.ads.v2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(bv = {}, d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u000e\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u001f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0013\u0010\u0004\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0007\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0005R\u001b\u0010\r\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/wortise/ads/interstitial/modules/a;", "Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule;", "", "onDestroy", "onLoad", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "onShow", "Lcom/wortise/ads/v2;", "ad$delegate", "Lkotlin/Lazy;", "getAd", "()Lcom/wortise/ads/v2;", "ad", "com/wortise/ads/interstitial/modules/a$c", "adListener", "Lcom/wortise/ads/interstitial/modules/a$c;", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "adResponse", "Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule$Listener;", "listener", "<init>", "(Landroid/content/Context;Lcom/wortise/ads/AdResponse;Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule$Listener;)V", "Companion", "a", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DefaultInterstitialModule.kt */
public final class a extends BaseInterstitialModule {
    public static final C0187a Companion = new C0187a((DefaultConstructorMarker) null);
    private final Lazy ad$delegate;
    /* access modifiers changed from: private */
    public final c adListener = new c(this);

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lcom/wortise/ads/interstitial/modules/a$a;", "", "Lcom/wortise/ads/AdResponse;", "response", "", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.wortise.ads.interstitial.modules.a$a  reason: collision with other inner class name */
    /* compiled from: DefaultInterstitialModule.kt */
    public static final class C0187a {
        private C0187a() {
        }

        public /* synthetic */ C0187a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final boolean a(AdResponse adResponse) {
            Intrinsics.checkNotNullParameter(adResponse, "response");
            AdFormat g = adResponse.g();
            return g != null && !g.isThirdParty();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"Lcom/wortise/ads/v2;", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: DefaultInterstitialModule.kt */
    static final class b extends Lambda implements Function0<v2> {
        final /* synthetic */ Context a;
        final /* synthetic */ AdResponse b;
        final /* synthetic */ a c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Context context, AdResponse adResponse, a aVar) {
            super(0);
            this.a = context;
            this.b = adResponse;
            this.c = aVar;
        }

        /* renamed from: a */
        public final v2 invoke() {
            return new v2(this.a, Reflection.getOrCreateKotlinClass(InterstitialActivity.class), this.b, this.c.adListener);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016¨\u0006\n"}, d2 = {"com/wortise/ads/interstitial/modules/a$c", "Lcom/wortise/ads/v2$a;", "", "onAdClicked", "a", "onAdDismissed", "Lcom/wortise/ads/AdError;", "error", "onAdLoaded", "onAdShown", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: DefaultInterstitialModule.kt */
    public static final class c implements v2.a {
        final /* synthetic */ a a;

        c(a aVar) {
            this.a = aVar;
        }

        public void a() {
        }

        public void a(AdError adError) {
            Intrinsics.checkNotNullParameter(adError, "error");
            this.a.deliverError(adError);
        }

        public void onAdClicked() {
            this.a.deliverClick();
        }

        public void onAdDismissed() {
            this.a.deliverDismiss();
        }

        public void onAdLoaded() {
            this.a.deliverLoad();
        }

        public void onAdShown() {
            this.a.deliverShow();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(Context context, AdResponse adResponse, BaseInterstitialModule.Listener listener) {
        super(context, adResponse, listener);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
        Intrinsics.checkNotNullParameter(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.ad$delegate = LazyKt.lazy(new b(context, adResponse, this));
    }

    @JvmStatic
    public static final boolean canParse(AdResponse adResponse) {
        return Companion.a(adResponse);
    }

    private final v2 getAd() {
        return (v2) this.ad$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        getAd().a();
    }

    /* access modifiers changed from: protected */
    public Object onLoad(Continuation<? super Unit> continuation) {
        Object a = getAd().a(continuation);
        return a == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a : Unit.INSTANCE;
    }

    /* access modifiers changed from: protected */
    public Object onShow(Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(getAd().f());
    }
}
