package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.listener.RewardedVideoAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import org.json.JSONObject;

public final class Q extends C0211a<RewardedVideoAdListener> implements RewardedVideoSmashListener {
    public Q(AbstractAdapter abstractAdapter, NetworkSettings networkSettings) {
        super(abstractAdapter, networkSettings, IronSource.AD_UNIT.REWARDED_VIDEO);
    }

    /* access modifiers changed from: protected */
    public final IronSource.AD_UNIT a() {
        return IronSource.AD_UNIT.REWARDED_VIDEO;
    }

    /* access modifiers changed from: protected */
    public final void a(JSONObject jSONObject) {
        this.a.showRewardedVideo(jSONObject, this);
    }

    /* access modifiers changed from: protected */
    public final void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData) {
        Integer num = adData.getInt("instanceType");
        if (num == null || num.intValue() != 1) {
            this.a.loadRewardedVideoForBidding(jSONObject, jSONObject2, adData.getServerData(), this);
        } else {
            this.a.loadRewardedVideo(jSONObject, jSONObject2, this);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean b(JSONObject jSONObject) {
        return this.a.isRewardedVideoAvailable(jSONObject);
    }

    public final void onRewardedVideoAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdClicked();
        }
    }

    public final void onRewardedVideoAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdClosed();
        }
    }

    public final void onRewardedVideoAdEnded() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdEnded();
        }
    }

    public final void onRewardedVideoAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdOpened();
        }
    }

    public final void onRewardedVideoAdRewarded() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdRewarded();
        }
    }

    public final void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdShowFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onRewardedVideoAdStarted() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdStarted();
        }
    }

    public final void onRewardedVideoAdVisible() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdVisible();
        }
    }

    public final void onRewardedVideoAvailabilityChanged(boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("available = " + z));
        if (this.b.get() == null) {
            return;
        }
        if (z) {
            ((RewardedVideoAdListener) this.b.get()).onAdLoadSuccess();
        } else {
            ((RewardedVideoAdListener) this.b.get()).onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, "");
        }
    }

    public final void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }

    public final void onRewardedVideoInitSuccess() {
    }

    public final void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        AdapterErrorType adapterErrorType;
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        if (this.b.get() != null) {
            boolean z = true;
            if (ironSourceError.getErrorCode() == 1058) {
                adapterErrorType = AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL;
            } else {
                if (ironSourceError.getErrorCode() != 1057) {
                    z = false;
                }
                adapterErrorType = z ? AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL;
            }
            ((RewardedVideoAdListener) this.b.get()).onAdLoadFailed(adapterErrorType, ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onRewardedVideoLoadSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(b());
        if (this.b.get() != null) {
            ((RewardedVideoAdListener) this.b.get()).onAdLoadSuccess();
        }
    }
}
