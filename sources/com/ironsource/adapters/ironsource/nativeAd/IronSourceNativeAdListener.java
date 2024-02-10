package com.ironsource.adapters.ironsource.nativeAd;

import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.k.c;
import com.ironsource.sdk.k.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/ironsource/adapters/ironsource/nativeAd/IronSourceNativeAdListener;", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdInterface$Listener;", "binder", "Lcom/ironsource/adapters/ironsource/nativeAd/IronSourceNativeAdViewBinder;", "smashListener", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdSmashListener;", "(Lcom/ironsource/adapters/ironsource/nativeAd/IronSourceNativeAdViewBinder;Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdSmashListener;)V", "onNativeAdClicked", "", "onNativeAdLoadFailed", "reason", "", "onNativeAdLoadSuccess", "adData", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdData;", "onNativeAdShown", "ironsourceadapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IronSourceNativeAdListener implements d.a {
    private final IronSourceNativeAdViewBinder binder;
    private final NativeAdSmashListener smashListener;

    public IronSourceNativeAdListener(IronSourceNativeAdViewBinder ironSourceNativeAdViewBinder, NativeAdSmashListener nativeAdSmashListener) {
        Intrinsics.checkNotNullParameter(ironSourceNativeAdViewBinder, "binder");
        Intrinsics.checkNotNullParameter(nativeAdSmashListener, "smashListener");
        this.binder = ironSourceNativeAdViewBinder;
        this.smashListener = nativeAdSmashListener;
    }

    public final void onNativeAdClicked() {
        this.smashListener.onNativeAdClicked();
    }

    public final void onNativeAdLoadFailed(String str) {
        Intrinsics.checkNotNullParameter(str, IronSourceConstants.EVENTS_ERROR_REASON);
        this.smashListener.onNativeAdLoadFailed(new IronSourceError(510, "Load failed - " + str));
    }

    public final void onNativeAdLoadSuccess(c cVar) {
        Intrinsics.checkNotNullParameter(cVar, "adData");
        this.smashListener.onNativeAdLoaded(new IronSourceNativeAdData(cVar), this.binder);
    }

    public final void onNativeAdShown() {
        this.smashListener.onNativeAdShown();
    }
}
