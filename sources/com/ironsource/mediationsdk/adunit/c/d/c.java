package com.ironsource.mediationsdk.adunit.c.d;

import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016¨\u0006\u001c"}, d2 = {"Lcom/ironsource/mediationsdk/adunit/manager/wrappers/EmptyAdUnitListenerWrapper;", "Lcom/ironsource/mediationsdk/adunit/manager/wrappers/AdUnitListenerWrapper;", "()V", "onAvailabilityChanged", "", "adAvailable", "", "adInfo", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdInfo;", "onClicked", "placement", "Lcom/ironsource/mediationsdk/model/Placement;", "onClosed", "onEnded", "onLoadFailed", "error", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "onLoadSuccess", "adapterNativeAdData", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "nativeAdViewBinder", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "isReload", "onOpened", "onRewarded", "onShowFailed", "onShowSuccess", "onStarted", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class c extends a {
    public final void a() {
    }

    public final void a(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(adapterNativeAdViewBinder, "nativeAdViewBinder");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }

    public final void a(AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }

    public final void a(AdInfo adInfo, boolean z) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }

    public final void a(IronSourceError ironSourceError) {
    }

    public final void a(IronSourceError ironSourceError, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(ironSourceError, "error");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }

    public final void a(Placement placement, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }

    public final void a(boolean z, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }

    public final void b() {
    }

    public final void b(AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }

    public final void b(Placement placement, AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }

    public final void c(AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }

    public final void g(AdInfo adInfo) {
        Intrinsics.checkNotNullParameter(adInfo, "adInfo");
    }
}
