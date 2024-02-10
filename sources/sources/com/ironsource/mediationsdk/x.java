package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.listener.InterstitialAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import org.json.JSONObject;

public final class x extends C0211a<InterstitialAdListener> implements InterstitialSmashListener {
    public x(AbstractAdapter abstractAdapter, NetworkSettings networkSettings) {
        super(abstractAdapter, networkSettings, IronSource.AD_UNIT.INTERSTITIAL);
    }

    /* access modifiers changed from: protected */
    public final IronSource.AD_UNIT a() {
        return IronSource.AD_UNIT.INTERSTITIAL;
    }

    /* access modifiers changed from: protected */
    public final void a(JSONObject jSONObject) {
        this.a.showInterstitial(jSONObject, this);
    }

    /* access modifiers changed from: protected */
    public final void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData) {
        Integer num = adData.getInt("instanceType");
        if (num == null || num.intValue() != 1) {
            this.a.loadInterstitialForBidding(jSONObject, jSONObject2, adData.getServerData(), this);
        } else {
            this.a.loadInterstitial(jSONObject, jSONObject2, this);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean b(JSONObject jSONObject) {
        return this.a.isInterstitialReady(jSONObject);
    }

    public final void onInterstitialAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdClicked();
        }
    }

    public final void onInterstitialAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdClosed();
        }
    }

    public final void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdLoadFailed(ironSourceError.getErrorCode() == 1158 ? AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onInterstitialAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdOpened();
        }
    }

    public final void onInterstitialAdReady() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdLoadSuccess();
        }
    }

    public final void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdShowFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onInterstitialAdShowSucceeded() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((InterstitialAdListener) this.b.get()).onAdShowSuccess();
        }
    }

    public final void onInterstitialAdVisible() {
    }

    public final void onInterstitialInitFailed(IronSourceError ironSourceError) {
    }

    public final void onInterstitialInitSuccess() {
    }
}
