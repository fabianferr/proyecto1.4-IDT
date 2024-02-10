package com.ironsource.mediationsdk.demandOnly;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.C0214d;
import com.ironsource.mediationsdk.C0215e;
import com.ironsource.mediationsdk.C0216f;
import com.ironsource.mediationsdk.C0219i;
import com.ironsource.mediationsdk.C0220j;
import com.ironsource.mediationsdk.C0221k;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.demandOnly.b;
import com.ironsource.mediationsdk.demandOnly.j;
import com.ironsource.mediationsdk.demandOnly.q;
import com.ironsource.mediationsdk.events.e;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.d;
import com.ironsource.sdk.controller.h;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import org.json.JSONObject;

public final class g extends j implements InterstitialSmashListener, h {
    private d i;
    private d j;
    private ISDemandOnlyInterstitialListener k;
    private C0220j l;
    private C0216f m;
    private q n = new q.b();
    private final a o = MediationServices.getProvider().getSessionDepthService();
    private final a.C0114a p = MediationServices.getEditor().getSessionDepthServiceEditor();

    public g(String str, String str2, NetworkSettings networkSettings, ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener, long j2, AbstractAdapter abstractAdapter, C0216f fVar) {
        super(new com.ironsource.mediationsdk.model.a(networkSettings, networkSettings.getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), abstractAdapter);
        this.k = iSDemandOnlyInterstitialListener;
        this.d = j2;
        this.a.initInterstitial(str, str2, this.c, this);
        this.m = fVar;
    }

    private void a(int i2, Object[][] objArr) {
        Map<String, Object> b = b();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    b.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronLog.INTERNAL.error("Exception: " + Log.getStackTraceString(e));
            }
        }
        e.d().a(new com.ironsource.environment.c.a(i2, new JSONObject(b)));
    }

    private void a(IronSourceError ironSourceError, long j2) {
        if (ironSourceError.getErrorCode() == 1158) {
            a((int) IronSourceConstants.IS_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{"duration", Long.valueOf(j2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}});
        } else {
            a(2200, new Object[][]{new Object[]{"duration", Long.valueOf(j2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
        }
    }

    private void a(List<String> list, String str) {
        a(list, e(), f(), this.h, str);
    }

    private void l() {
        this.j = new d();
        this.a.loadInterstitial(this.c, (JSONObject) null, this);
    }

    private void m() {
        if (!this.m.a.a()) {
            IronLog.INTERNAL.verbose("can't load the interstitial the auction isn't enabled");
            a(new IronSourceError(IronSourceError.ERROR_CODE_MISSING_CONFIGURATION, "Missing server configuration"));
            return;
        }
        a(82500, (Object[][]) null);
        C0221k n2 = n();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("auction waterfallString = " + n2.j());
        a(82510, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, n2.j()}});
        this.m.a(ContextProvider.getInstance().getApplicationContext(), n2, (C0214d) this);
    }

    private C0221k n() {
        C0221k kVar = new C0221k(IronSource.AD_UNIT.INTERSTITIAL);
        kVar.b(IronSourceUtils.isEncryptedResponse());
        kVar.c(true);
        kVar.a(true);
        kVar.b(f() + e());
        kVar.a(g());
        kVar.a(this.o.a(IronSource.AD_UNIT.INTERSTITIAL));
        C0219i iVar = new C0219i(e(), false);
        iVar.a(this.n.a());
        Map<String, Object> interstitialBiddingData = this.a.getInterstitialBiddingData(this.c, new JSONObject());
        if (interstitialBiddingData != null) {
            iVar.a((Map<String, ? extends Object>) interstitialBiddingData);
        }
        kVar.a(iVar);
        return kVar;
    }

    private void o() {
        this.e = null;
        this.f = null;
        this.h = null;
        this.l = new C0220j();
    }

    public final void a() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + i());
        j.a a = a(new j.a[]{j.a.NOT_LOADED, j.a.LOADED}, j.a.LOAD_IN_PROGRESS);
        if (a == j.a.NOT_LOADED || a == j.a.LOADED) {
            o();
            a(2002, (Object[][]) null);
            this.i = new d();
            a((TimerTask) new TimerTask() {
                public final void run() {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("load timed out state=" + g.this.i());
                    g.this.a(new IronSourceError(IronSourceError.ERROR_DO_IS_LOAD_TIMED_OUT, "load timed out"));
                }
            });
            if (k()) {
                IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitial must be called by non bidder instances");
                a((int) IronSourceConstants.IS_AD_UNIT_CAPPED, (Object[][]) null);
                a(buildLoadFailedError);
            } else if (h()) {
                m();
            } else {
                l();
            }
        } else {
            a(new IronSourceError(IronSourceError.ERROR_DO_IS_LOAD_ALREADY_IN_PROGRESS, a == j.a.LOAD_IN_PROGRESS ? "load already in progress" : "cannot load because show is in progress"));
        }
    }

    public final void a(int i2, String str, int i3, String str2, long j2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("error " + i2 + " - " + str);
        this.e = null;
        this.f = null;
        a(82300, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{"duration", Long.valueOf(j2)}, new Object[]{IronSourceConstants.EVENTS_EXT1, i()}});
        if (b(j.a.LOAD_IN_PROGRESS)) {
            a(new IronSourceError(1164, "No available ad to load"));
        }
    }

    public final void a(o oVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("state=" + i());
        j.a a = a(new j.a[]{j.a.NOT_LOADED, j.a.LOADED}, j.a.LOAD_IN_PROGRESS);
        if (a == j.a.NOT_LOADED || a == j.a.LOADED) {
            o();
            a(2002, (Object[][]) null);
            this.i = new d();
            a((TimerTask) new TimerTask() {
                public final void run() {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("load timed out state=" + g.this.i());
                    g.this.a(new IronSourceError(IronSourceError.ERROR_DO_IS_LOAD_TIMED_OUT, "load timed out"));
                }
            });
            if (!k()) {
                a(new IronSourceError(IronSourceConstants.IS_AD_UNIT_CAPPED, "loadInterstitialWithAdm: must be called by bidder instance"));
                return;
            }
            try {
                C0215e.a aVar = (C0215e.a) oVar.a(new k());
                com.ironsource.mediationsdk.adunit.a.a a2 = new b.a(aVar.b).a(e());
                if (a2 == null) {
                    IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm invalid enriched adm");
                    a((int) IronSourceConstants.IS_AD_UNIT_CAPPED, (Object[][]) null);
                    a(buildLoadFailedError);
                    return;
                }
                String b = a2.b();
                if (b == null) {
                    IronLog.INTERNAL.error("serverData is null");
                    a(new IronSourceError(1162, "No available ad to load"));
                    return;
                }
                a(b);
                b(aVar.a);
                a(aVar.d);
                a(82002, (Object[][]) null);
                this.l.c(a2.g());
                this.j = new d();
                this.a.loadInterstitialForBidding(this.c, (JSONObject) null, b, this);
            } catch (Exception e) {
                a(ErrorBuilder.buildLoadFailedError("loadInterstitialWithAdm: Exception= " + e.getMessage()));
            }
        } else {
            a(new IronSourceError(IronSourceError.ERROR_DO_IS_LOAD_ALREADY_IN_PROGRESS, a == j.a.LOAD_IN_PROGRESS ? "load already in progress" : "cannot load because show is in progress"));
        }
    }

    public final void a(C0215e.a aVar, long j2, int i2, String str) {
        String str2;
        IronSourceError ironSourceError;
        IronLog.INTERNAL.verbose();
        this.e = aVar.a;
        this.f = aVar.d;
        b.a aVar2 = new b.a(aVar.b);
        if (!aVar2.b()) {
            com.ironsource.mediationsdk.a.a aVar3 = aVar.h;
            if (aVar3 != null) {
                this.n = aVar3.a(g());
            }
            com.ironsource.mediationsdk.adunit.a.a a = aVar2.a(0);
            this.l.c(a.g());
            this.l.a(a.i());
            this.l.b(a.h());
            str2 = a.b();
            a(str2);
        } else {
            str2 = "";
        }
        if (!TextUtils.isEmpty(str)) {
            a((int) IronSourceConstants.TROUBLESHOOTING_AUCTION_SUCCESSFUL_RECOVERY_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i2)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}});
        }
        a(82301, new Object[][]{new Object[]{"duration", Long.valueOf(j2)}});
        a(82302, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, aVar2.a()}});
        if (b(j.a.LOAD_IN_PROGRESS)) {
            if (aVar2.b()) {
                ironSourceError = new IronSourceError(IronSourceConstants.IS_INSTANCE_LOAD_NO_FILL, "There is no available ad to load");
                IronLog.INTERNAL.error("interstitial - empty waterfall");
            } else {
                IronLog.INTERNAL.verbose();
                if (!b(j.a.LOAD_IN_PROGRESS)) {
                    return;
                }
                if (str2 == null) {
                    IronLog.INTERNAL.verbose("serverData is null");
                    ironSourceError = new IronSourceError(1162, "No available ad to load");
                } else {
                    a(82002, (Object[][]) null);
                    this.a.loadInterstitialForBidding(this.c, (JSONObject) null, str2, this);
                    return;
                }
            }
            a(ironSourceError);
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("instanceName = " + e() + ", error = " + ironSourceError.getErrorMessage());
        j();
        if (a(j.a.LOAD_IN_PROGRESS, j.a.NOT_LOADED)) {
            a(ironSourceError, d.a(this.i));
            a(this.l.b(), IronSourceUtils.getCurrentMethodName());
            this.k.onInterstitialAdLoadFailed(g(), ironSourceError);
        }
    }

    public final void a(List<com.ironsource.mediationsdk.adunit.a.a> list, String str, com.ironsource.mediationsdk.adunit.a.a aVar, JSONObject jSONObject, JSONObject jSONObject2, int i2, long j2, int i3, String str2) {
        IronLog.INTERNAL.error("Deprecated: Please use onAuctionSuccess(AuctionDataUtils.AuctionData auctionData, int auctionTrial, long elapsedTime, int troubleshootingErrorCode, String troubleshootingErrorMessage)");
    }

    public final void c() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("instanceName = " + e() + ", state=" + i());
        a(2201, (Object[][]) null);
        if (a(j.a.LOADED, j.a.SHOW_IN_PROGRESS)) {
            this.a.showInterstitial(this.c, this);
        } else {
            this.k.onInterstitialAdShowFailed(g(), b(j.a.SHOW_IN_PROGRESS) ? new IronSourceError(IronSourceError.ERROR_DO_IS_SHOW_DURING_SHOW, "showInterstitial error: can't show ad while an ad is already showing") : b(j.a.LOAD_IN_PROGRESS) ? new IronSourceError(IronSourceError.ERROR_DO_IS_SHOW_DURING_LOAD, "showInterstitial error: can't show ad while an ad is loading") : new IronSourceError(IronSourceError.ERROR_DO_IS_SHOW_NO_AVAILABLE_ADS, "showInterstitial error: no available ads to show"));
        }
    }

    public final boolean d() {
        boolean z = false;
        if (!b(j.a.LOADED)) {
            return false;
        }
        try {
            z = this.a.isInterstitialReady(this.c);
            a(z ? IronSourceConstants.IS_INSTANCE_READY_TRUE : IronSourceConstants.IS_INSTANCE_READY_FALSE, (Object[][]) null);
        } catch (Exception e) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception=" + e.getMessage());
        }
        return z;
    }

    public final void onInterstitialAdClicked() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + e());
        a(2006, new Object[0][]);
        this.k.onInterstitialAdClicked(g());
    }

    public final void onInterstitialAdClosed() {
        a(j.a.NOT_LOADED);
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + e());
        a((int) IronSourceConstants.IS_INSTANCE_CLOSED, new Object[][]{new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.o.a(IronSource.AD_UNIT.INTERSTITIAL))}});
        this.p.b(IronSource.AD_UNIT.INTERSTITIAL);
        this.k.onInterstitialAdClosed(g());
    }

    public final void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("error=" + ironSourceError.getErrorMessage() + " instance name= " + e() + " state=" + i());
        long a = d.a(this.j);
        a(82110, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(a)}});
        a(ironSourceError);
    }

    public final void onInterstitialAdOpened() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + e());
        a(2005, new Object[0][]);
        a(this.l.c(), IronSourceUtils.getCurrentMethodName());
        this.k.onInterstitialAdOpened(g());
    }

    public final void onInterstitialAdReady() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + e() + " state=" + i());
        j();
        a(82003, new Object[][]{new Object[]{"duration", Long.valueOf(d.a(this.j))}});
        if (a(j.a.LOAD_IN_PROGRESS, j.a.LOADED)) {
            a(2003, new Object[][]{new Object[]{"duration", Long.valueOf(d.a(this.i))}});
            a(this.l.a(), IronSourceUtils.getCurrentMethodName());
            this.k.onInterstitialAdReady(g());
        }
    }

    public final void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("error=" + ironSourceError.toString() + " instance name= " + e() + " state=" + i());
        a(j.a.NOT_LOADED);
        a((int) IronSourceConstants.IS_INSTANCE_SHOW_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
        this.k.onInterstitialAdShowFailed(g(), ironSourceError);
    }

    public final void onInterstitialAdShowSucceeded() {
    }

    public final void onInterstitialAdVisible() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("instance name= " + e());
        a((int) IronSourceConstants.IS_INSTANCE_VISIBLE, new Object[0][]);
    }

    public final void onInterstitialInitFailed(IronSourceError ironSourceError) {
    }

    public final void onInterstitialInitSuccess() {
    }
}
