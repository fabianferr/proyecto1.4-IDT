package com.ironsource.mediationsdk.adunit.c.d;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.internal.InternalNativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\"\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/manager/wrappers/NativeAdListenerWrapper;", "Lcom/ironsource/mediationsdk/adunit/manager/wrappers/AdUnitListenerWrapper;", "mNativeAdListener", "Lcom/ironsource/mediationsdk/ads/nativead/internal/InternalNativeAdListener;", "(Lcom/ironsource/mediationsdk/ads/nativead/internal/InternalNativeAdListener;)V", "onClicked", "", "placement", "Lcom/ironsource/mediationsdk/model/Placement;", "adInfo", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "onLoadFailed", "error", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "onLoadSuccess", "adapterNativeAdData", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "nativeAdViewBinder", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "onOpened", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class e extends a {
    private final InternalNativeAdListener a;

    public e(InternalNativeAdListener internalNativeAdListener) {
        Intrinsics.checkNotNullParameter(internalNativeAdListener, "mNativeAdListener");
        this.a = internalNativeAdListener;
    }

    public final void a(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(adapterNativeAdViewBinder, "nativeAdViewBinder");
        this.a.onNativeAdLoaded(adInfo, adapterNativeAdData, adapterNativeAdViewBinder);
    }

    public final void a(IronSourceError ironSourceError) {
        this.a.onNativeAdLoadFailed(ironSourceError);
    }

    public final void a(Placement placement, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.a.onNativeAdClicked(adInfo);
    }

    public final void c(AdInfo adInfo) {
        this.a.onNativeAdImpression(adInfo);
    }
}
