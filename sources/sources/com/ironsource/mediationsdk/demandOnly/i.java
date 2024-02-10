package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.j;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.a;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.sdk.b;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import org.json.JSONObject;

public final class i extends j implements RewardedVideoSmashListener {
    /* access modifiers changed from: private */
    public b i;
    /* access modifiers changed from: private */
    public long j;

    i(String str, String str2, NetworkSettings networkSettings, b bVar, long j2, AbstractAdapter abstractAdapter) {
        super(new a(networkSettings, networkSettings.getInterstitialSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), abstractAdapter);
        this.b = new a(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO);
        this.c = this.b.b;
        this.a = abstractAdapter;
        this.i = bVar;
        this.d = j2;
        this.a.initRewardedVideoForDemandOnly(str, str2, this.c, this);
    }

    private void c(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "DemandOnlyRewardedVideoSmash " + this.b.a.getProviderName() + " : " + str, 0);
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyRewardedVideoSmash " + this.b.a.getProviderName() + " : " + str, 0);
    }

    public final void a() {
        d("showRewardedVideo state=" + i());
        if (a(j.a.LOADED, j.a.SHOW_IN_PROGRESS)) {
            this.a.showRewardedVideo(this.c, this);
        } else {
            this.i.a(b(j.a.SHOW_IN_PROGRESS) ? new IronSourceError(IronSourceError.ERROR_DO_RV_SHOW_DURING_SHOW, "showRewardedVideo error: can't show ad while an ad is already showing") : b(j.a.LOAD_IN_PROGRESS) ? new IronSourceError(IronSourceError.ERROR_DO_RV_SHOW_DURING_LOAD, "showRewardedVideo error: can't show ad while an ad is loading") : new IronSourceError(IronSourceError.ERROR_DO_RV_SHOW_NO_AVAILABLE_ADS, "showRewardedVideo error: no available ads to show"), this);
        }
    }

    public final void a(String str, String str2, JSONObject jSONObject, List<String> list) {
        d("loadRewardedVideo state=" + i());
        j.a a = a(new j.a[]{j.a.NOT_LOADED, j.a.LOADED}, j.a.LOAD_IN_PROGRESS);
        if (a == j.a.NOT_LOADED || a == j.a.LOADED) {
            this.j = new Date().getTime();
            d("start timer");
            a((TimerTask) new TimerTask() {
                public final void run() {
                    i iVar = i.this;
                    iVar.d("load timed out state=" + i.this.i());
                    if (i.this.a(j.a.LOAD_IN_PROGRESS, j.a.NOT_LOADED)) {
                        i.this.i.a(new IronSourceError(IronSourceError.ERROR_DO_RV_LOAD_TIMED_OUT, "load timed out"), i.this, new Date().getTime() - i.this.j);
                    }
                }
            });
            if (k()) {
                this.e = str2;
                this.f = jSONObject;
                this.g = list;
                this.a.loadRewardedVideoForDemandOnlyForBidding(this.c, str, this);
                return;
            }
            this.a.loadRewardedVideoForDemandOnly(this.c, this);
        } else if (a == j.a.LOAD_IN_PROGRESS) {
            this.i.a(new IronSourceError(IronSourceError.ERROR_DO_RV_LOAD_ALREADY_IN_PROGRESS, "load already in progress"), this, 0);
        } else {
            this.i.a(new IronSourceError(IronSourceError.ERROR_DO_RV_LOAD_DURING_SHOW, "cannot load because show is in progress"), this, 0);
        }
    }

    public final boolean c() {
        if (!b(j.a.LOADED)) {
            return false;
        }
        try {
            return this.a.isRewardedVideoAvailable(this.c);
        } catch (Exception e) {
            d("isRewardedVideoAvailable exception: " + e.getLocalizedMessage());
            return false;
        }
    }

    public final void onRewardedVideoAdClicked() {
        c("onRewardedVideoAdClicked");
        this.i.c(this);
    }

    public final void onRewardedVideoAdClosed() {
        a(j.a.NOT_LOADED);
        c("onRewardedVideoAdClosed");
        this.i.b(this);
    }

    public final void onRewardedVideoAdEnded() {
    }

    public final void onRewardedVideoAdOpened() {
        c("onRewardedVideoAdOpened");
        this.i.a(this);
    }

    public final void onRewardedVideoAdRewarded() {
        c("onRewardedVideoAdRewarded");
        this.i.e(this);
    }

    public final void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        a(j.a.NOT_LOADED);
        c("onRewardedVideoAdClosed error=" + ironSourceError);
        this.i.a(ironSourceError, this);
    }

    public final void onRewardedVideoAdStarted() {
    }

    public final void onRewardedVideoAdVisible() {
        c("onRewardedVideoAdVisible");
        this.i.d(this);
    }

    public final void onRewardedVideoAvailabilityChanged(boolean z) {
    }

    public final void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
    }

    public final void onRewardedVideoInitSuccess() {
    }

    public final void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        c("onRewardedVideoLoadFailed error=" + ironSourceError.getErrorMessage() + " state=" + i());
        j();
        if (a(j.a.LOAD_IN_PROGRESS, j.a.NOT_LOADED)) {
            this.i.a(ironSourceError, this, new Date().getTime() - this.j);
        }
    }

    public final void onRewardedVideoLoadSuccess() {
        c("onRewardedVideoLoadSuccess state=" + i());
        j();
        if (a(j.a.LOAD_IN_PROGRESS, j.a.LOADED)) {
            this.i.a(this, new Date().getTime() - this.j);
        }
    }
}
