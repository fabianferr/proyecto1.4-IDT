package com.wortise.ads.interstitial;

import android.content.Context;
import com.wortise.ads.AdError;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdType;
import com.wortise.ads.WortiseLog;
import com.wortise.ads.fullscreen.FullscreenAd;
import com.wortise.ads.interstitial.modules.BaseInterstitialModule;
import com.wortise.ads.m4;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u001aB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0016R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/wortise/ads/interstitial/InterstitialAd;", "Lcom/wortise/ads/fullscreen/FullscreenAd;", "Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule;", "Lcom/wortise/ads/interstitial/modules/BaseInterstitialModule$Listener;", "context", "Landroid/content/Context;", "adUnitId", "", "(Landroid/content/Context;Ljava/lang/String;)V", "listener", "Lcom/wortise/ads/interstitial/InterstitialAd$Listener;", "getListener", "()Lcom/wortise/ads/interstitial/InterstitialAd$Listener;", "setListener", "(Lcom/wortise/ads/interstitial/InterstitialAd$Listener;)V", "createModule", "response", "Lcom/wortise/ads/AdResponse;", "onAdClicked", "", "onAdDismissed", "onAdFailed", "error", "Lcom/wortise/ads/AdError;", "onAdLoaded", "onAdShown", "Listener", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InterstitialAd.kt */
public final class InterstitialAd extends FullscreenAd<BaseInterstitialModule> implements BaseInterstitialModule.Listener {
    private Listener listener;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/wortise/ads/interstitial/InterstitialAd$Listener;", "", "onInterstitialClicked", "", "ad", "Lcom/wortise/ads/interstitial/InterstitialAd;", "onInterstitialDismissed", "onInterstitialFailed", "error", "Lcom/wortise/ads/AdError;", "onInterstitialLoaded", "onInterstitialShown", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: InterstitialAd.kt */
    public interface Listener {
        void onInterstitialClicked(InterstitialAd interstitialAd);

        void onInterstitialDismissed(InterstitialAd interstitialAd);

        void onInterstitialFailed(InterstitialAd interstitialAd, AdError adError);

        void onInterstitialLoaded(InterstitialAd interstitialAd);

        void onInterstitialShown(InterstitialAd interstitialAd);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InterstitialAd(Context context, String str) {
        super(context, str, AdType.INTERSTITIAL);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
    }

    public final Listener getListener() {
        return this.listener;
    }

    public void onAdClicked() {
        super.onAdClicked();
        if (!isDestroyed()) {
            WortiseLog.i$default("Interstitial ad clicked", (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onInterstitialClicked(this);
            }
        }
    }

    public void onAdDismissed() {
        super.onAdDismissed();
        if (!isDestroyed()) {
            WortiseLog.i$default("Interstitial ad dismissed", (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onInterstitialDismissed(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAdFailed(AdError adError) {
        Intrinsics.checkNotNullParameter(adError, "error");
        super.onAdFailed(adError);
        if (!isDestroyed()) {
            WortiseLog.i$default("Interstitial ad load failed for ad unit " + getAdUnitId() + ": " + adError.name(), (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onInterstitialFailed(this, adError);
            }
        }
    }

    public void onAdLoaded() {
        super.onAdLoaded();
        if (!isDestroyed()) {
            WortiseLog.i$default(Intrinsics.stringPlus("Interstitial ad loaded for ad unit ", getAdUnitId()), (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onInterstitialLoaded(this);
            }
        }
    }

    public void onAdShown() {
        super.onAdShown();
        if (!isDestroyed()) {
            WortiseLog.i$default("Interstitial ad shown", (Throwable) null, 2, (Object) null);
            Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onInterstitialShown(this);
            }
        }
    }

    public final void setListener(Listener listener2) {
        this.listener = listener2;
    }

    /* access modifiers changed from: protected */
    public BaseInterstitialModule createModule(AdResponse adResponse) {
        Intrinsics.checkNotNullParameter(adResponse, "response");
        return m4.a.a(getContext(), adResponse, this);
    }
}
