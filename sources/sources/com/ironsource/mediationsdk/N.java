package com.ironsource.mediationsdk;

import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.bidding.c;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.events.e;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class N extends O implements c, InterstitialSmashListener {
    /* access modifiers changed from: package-private */
    public a a = a.NO_INIT;
    /* access modifiers changed from: private */
    public M b;
    private Timer i;
    private int j;
    private String k;
    private String l;
    /* access modifiers changed from: private */
    public long m;
    private JSONObject n;
    private final Object o = new Object();
    private boolean p;

    public enum a {
        NO_INIT,
        INIT_IN_PROGRESS,
        INIT_SUCCESS,
        LOAD_IN_PROGRESS,
        LOADED,
        f
    }

    public N(String str, String str2, NetworkSettings networkSettings, M m2, int i2, AbstractAdapter abstractAdapter) {
        super(new com.ironsource.mediationsdk.model.a(networkSettings, networkSettings.getInterstitialSettings(), IronSource.AD_UNIT.INTERSTITIAL), abstractAdapter);
        this.k = str;
        this.l = str2;
        this.b = m2;
        this.i = null;
        this.j = i2;
        this.n = null;
    }

    private void a(int i2, Object[][] objArr) {
        Map<String, Object> q = q();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    q.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                super.a("IS sendProviderEvent " + e.getMessage(), 3);
            }
        }
        e.d().a(new com.ironsource.environment.c.a(i2, new JSONObject(q)));
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        super.a("current state=" + this.a + ", new state=" + aVar, 0);
        this.a = aVar;
    }

    private void b(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.ADAPTER_CALLBACK, "ProgIsSmash " + n() + " : " + str, 0);
    }

    private void t() {
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (!TextUtils.isEmpty(pluginType)) {
                this.c.setPluginData(pluginType);
            }
        } catch (Throwable th) {
            super.a("setCustomParams() " + th.getMessage(), 0);
        }
    }

    private void u() {
        synchronized (this.o) {
            Timer timer = this.i;
            if (timer != null) {
                timer.cancel();
                this.i = null;
            }
        }
    }

    private void v() {
        synchronized (this.o) {
            super.a("start timer", 0);
            u();
            Timer timer = new Timer();
            this.i = timer;
            timer.schedule(new TimerTask() {
                public final void run() {
                    N n = N.this;
                    n.a("timed out state=" + N.this.a.name() + " isBidder=" + N.this.h(), 0);
                    if (N.this.a != a.INIT_IN_PROGRESS || !N.this.h()) {
                        N.this.a(a.f);
                        N.this.b.a(ErrorBuilder.buildLoadFailedError("timed out"), N.this, new Date().getTime() - N.this.m);
                        return;
                    }
                    N.this.a(a.NO_INIT);
                }
            }, (long) (this.j * 1000));
        }
    }

    public final Map<String, Object> a(AdData adData) {
        JSONObject a2 = adData != null ? com.ironsource.mediationsdk.d.c.a(adData.getAdUnitData()) : null;
        try {
            if (h()) {
                return this.c.getInterstitialBiddingData(this.f, a2);
            }
            return null;
        } catch (Throwable th) {
            super.a("getBiddingData exception: " + th.getLocalizedMessage(), 3);
            th.printStackTrace();
            return null;
        }
    }

    public final void a() {
        super.a("isBidder = " + h() + ", shouldEarlyInit = " + i(), 0);
        this.p = true;
        a(a.INIT_IN_PROGRESS);
        t();
        try {
            if (h()) {
                this.c.initInterstitialForBidding(this.k, this.l, this.f, this);
            } else {
                this.c.initInterstitial(this.k, this.l, this.f, this);
            }
        } catch (Throwable th) {
            super.a(n() + " initForBidding exception : " + th.getLocalizedMessage(), 3);
            th.printStackTrace();
            onInterstitialInitFailed(new IronSourceError(IronSourceError.ERROR_IS_INSTANCE_INIT_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    public final void a(AdData adData, BiddingDataCallback biddingDataCallback) {
        JSONObject jSONObject = null;
        a((int) IronSourceConstants.IS_INSTANCE_COLLECT_TOKEN, (Object[][]) null);
        if (adData != null) {
            jSONObject = com.ironsource.mediationsdk.d.c.a(adData.getAdUnitData());
        }
        try {
            this.c.collectInterstitialBiddingData(this.f, jSONObject, biddingDataCallback);
        } catch (Throwable th) {
            super.a("collectBiddingData exception: " + th.getLocalizedMessage(), 3);
            th.printStackTrace();
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        try {
            this.m = new Date().getTime();
            this.n = jSONObject;
            super.a("loadInterstitial", 0);
            this.e = false;
            if (h()) {
                v();
                a(a.LOAD_IN_PROGRESS);
                this.c.loadInterstitialForBidding(this.f, jSONObject, str, this);
            } else if (this.a == a.NO_INIT) {
                v();
                a(a.INIT_IN_PROGRESS);
                t();
                this.c.initInterstitial(this.k, this.l, this.f, this);
            } else {
                v();
                a(a.LOAD_IN_PROGRESS);
                this.c.loadInterstitial(this.f, jSONObject, this);
            }
        } catch (Throwable th) {
            super.a("loadInterstitial exception: " + th.getLocalizedMessage(), 3);
            th.printStackTrace();
            onInterstitialAdLoadFailed(new IronSourceError(IronSourceConstants.errorCode_loadException, th.getLocalizedMessage()));
        }
    }

    public final void b() {
        try {
            this.c.showInterstitial(this.f, this);
        } catch (Throwable th) {
            super.a(n() + "showInterstitial exception : " + th.getLocalizedMessage(), 3);
            th.printStackTrace();
            onInterstitialAdShowFailed(new IronSourceError(IronSourceError.ERROR_IS_SHOW_EXCEPTION, th.getLocalizedMessage()));
        }
    }

    public final IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.INTERSTITIAL;
    }

    public final String e() {
        return "ProgIsSmash";
    }

    public final boolean g() {
        if (this.a != a.LOADED) {
            return false;
        }
        try {
            return this.c.isInterstitialReady(this.f);
        } catch (Throwable th) {
            super.a("isReadyToShow exception: " + th.getLocalizedMessage(), 3);
            th.printStackTrace();
            a((int) IronSourceConstants.TROUBLESHOOTING_IS_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 5002}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            return false;
        }
    }

    public final void onInterstitialAdClicked() {
        b("onInterstitialAdClicked");
        this.b.d(this);
    }

    public final void onInterstitialAdClosed() {
        b("onInterstitialAdClosed");
        this.b.b(this);
    }

    public final void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        b("onInterstitialAdLoadFailed error=" + ironSourceError.getErrorMessage() + " state=" + this.a.name());
        u();
        if (this.a == a.LOAD_IN_PROGRESS) {
            a(a.f);
            this.b.a(ironSourceError, this, new Date().getTime() - this.m);
        }
    }

    public final void onInterstitialAdOpened() {
        b("onInterstitialAdOpened");
        this.b.a(this);
    }

    public final void onInterstitialAdReady() {
        b("onInterstitialAdReady state=" + this.a.name());
        u();
        if (this.a == a.LOAD_IN_PROGRESS) {
            a(a.LOADED);
            this.b.a(this, new Date().getTime() - this.m);
        }
    }

    public final void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        b("onInterstitialAdShowFailed error=" + ironSourceError.getErrorMessage());
        this.b.a(ironSourceError, this);
    }

    public final void onInterstitialAdShowSucceeded() {
        b("onInterstitialAdShowSucceeded");
        this.b.c(this);
    }

    public final void onInterstitialAdVisible() {
        b("onInterstitialAdVisible");
        this.b.e(this);
    }

    public final void onInterstitialInitFailed(IronSourceError ironSourceError) {
        b("onInterstitialInitFailed error" + ironSourceError.getErrorMessage() + " state=" + this.a.name());
        if (this.a == a.INIT_IN_PROGRESS) {
            u();
            a(a.NO_INIT);
            this.b.b(ironSourceError, this);
            if (!h()) {
                this.b.a(ironSourceError, this, new Date().getTime() - this.m);
            }
        }
    }

    public final void onInterstitialInitSuccess() {
        b("onInterstitialInitSuccess state=" + this.a.name());
        if (this.a == a.INIT_IN_PROGRESS) {
            u();
            if (h() || this.p) {
                this.p = false;
                a(a.INIT_SUCCESS);
            } else {
                a(a.LOAD_IN_PROGRESS);
                v();
                try {
                    this.c.loadInterstitial(this.f, this.n, this);
                } catch (Throwable th) {
                    super.a("onInterstitialInitSuccess exception: " + th.getLocalizedMessage(), 3);
                    th.printStackTrace();
                    onInterstitialAdLoadFailed(new IronSourceError(IronSourceConstants.errorCode_loadException, th.getLocalizedMessage()));
                }
            }
            this.b.f(this);
        }
    }
}
