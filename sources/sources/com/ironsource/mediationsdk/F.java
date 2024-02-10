package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NativeAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u0003B\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\b\u0010\u0017\u001a\u00020\nH\u0016J\u0012\u0010\u0018\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0012\u0010\u001a\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\nH\u0016¨\u0006!"}, d2 = {"Lcom/ironsource/mediationsdk/NativeAdAdapterBridge;", "Lcom/ironsource/mediationsdk/AdAdapterBridge;", "Lcom/ironsource/mediationsdk/adunit/adapter/listener/NativeAdListener;", "Lcom/ironsource/mediationsdk/ads/nativead/interfaces/NativeAdSmashListener;", "adapter", "Lcom/ironsource/mediationsdk/AbstractAdapter;", "providerSettings", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "(Lcom/ironsource/mediationsdk/AbstractAdapter;Lcom/ironsource/mediationsdk/model/NetworkSettings;)V", "destroyAd", "", "config", "Lorg/json/JSONObject;", "getAdUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "isNoFill", "", "error", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "loadAdInternal", "adUnitData", "adData", "Lcom/ironsource/mediationsdk/adunit/adapter/utility/AdData;", "onNativeAdClicked", "onNativeAdInitFailed", "onNativeAdInitSuccess", "onNativeAdLoadFailed", "onNativeAdLoaded", "adapterNativeAdData", "Lcom/ironsource/mediationsdk/ads/nativead/AdapterNativeAdData;", "nativeAdViewBinder", "Lcom/ironsource/mediationsdk/adunit/adapter/internal/nativead/AdapterNativeAdViewBinder;", "onNativeAdShown", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class F extends C0211a<NativeAdListener> implements NativeAdSmashListener {
    public F(AbstractAdapter abstractAdapter, NetworkSettings networkSettings) {
        super(abstractAdapter, networkSettings, IronSource.AD_UNIT.NATIVE_AD);
    }

    /* access modifiers changed from: protected */
    public final IronSource.AD_UNIT a() {
        return IronSource.AD_UNIT.NATIVE_AD;
    }

    /* access modifiers changed from: protected */
    public final void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        Intrinsics.checkNotNullParameter(jSONObject2, "adUnitData");
        Intrinsics.checkNotNullParameter(adData, "adData");
        Integer num = adData.getInt("instanceType");
        if (num == null || num.intValue() != 1) {
            this.a.loadNativeAdForBidding(jSONObject, jSONObject2, adData.getServerData(), this);
        } else {
            this.a.loadNativeAd(jSONObject, jSONObject2, this);
        }
    }

    /* access modifiers changed from: protected */
    public final void c(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "config");
        this.a.destroyNativeAd(jSONObject);
    }

    public final void onNativeAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        NativeAdListener nativeAdListener = (NativeAdListener) this.b.get();
        if (nativeAdListener != null) {
            nativeAdListener.onAdClicked();
        }
    }

    public final void onNativeAdInitFailed(IronSourceError ironSourceError) {
    }

    public final void onNativeAdInitSuccess() {
    }

    public final void onNativeAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        int errorCode = ironSourceError != null ? ironSourceError.getErrorCode() : 1000;
        String errorMessage = ironSourceError != null ? ironSourceError.getErrorMessage() : null;
        if (errorMessage == null) {
            errorMessage = "";
        }
        if (this.b.get() != null) {
            boolean z = false;
            if (ironSourceError != null && ironSourceError.getErrorCode() == 706) {
                z = true;
            }
            AdapterErrorType adapterErrorType = z ? AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL;
            NativeAdListener nativeAdListener = (NativeAdListener) this.b.get();
            if (nativeAdListener != null) {
                nativeAdListener.onAdLoadFailed(adapterErrorType, errorCode, errorMessage);
            }
        }
    }

    public final void onNativeAdLoaded(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
        Intrinsics.checkNotNullParameter(adapterNativeAdData, "adapterNativeAdData");
        Intrinsics.checkNotNullParameter(adapterNativeAdViewBinder, "nativeAdViewBinder");
        IronLog.ADAPTER_CALLBACK.verbose(b());
        NativeAdListener nativeAdListener = (NativeAdListener) this.b.get();
        if (nativeAdListener != null) {
            nativeAdListener.onAdLoadSuccess(adapterNativeAdData, adapterNativeAdViewBinder);
        }
    }

    public final void onNativeAdShown() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        NativeAdListener nativeAdListener = (NativeAdListener) this.b.get();
        if (nativeAdListener != null) {
            nativeAdListener.onAdOpened();
        }
    }
}
