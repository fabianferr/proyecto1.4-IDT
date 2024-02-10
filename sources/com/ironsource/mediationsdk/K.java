package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.bidding.c;
import com.ironsource.mediationsdk.c.b;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.events.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.e;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import org.json.JSONObject;

public final class K extends O implements c, b.a, BannerSmashListener {
    String a;
    private d b;
    private b i;
    private a j;
    private J k;
    private IronSourceBannerLayout l;
    private JSONObject m;
    private int n;
    private String o;
    private e p;
    private final Object q;
    private com.ironsource.mediationsdk.utils.d r;
    private boolean s;
    private boolean t;
    private JSONObject u;

    public enum a {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        f,
        DESTROYED
    }

    K(d dVar, J j2, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i2, String str, JSONObject jSONObject, int i3, String str2, boolean z) {
        super(new com.ironsource.mediationsdk.model.a(networkSettings, networkSettings.getBannerSettings(), IronSource.AD_UNIT.BANNER), abstractAdapter);
        this.q = new Object();
        this.j = a.NONE;
        this.b = dVar;
        this.i = new b(dVar.f());
        this.k = j2;
        this.g = i2;
        this.a = str;
        this.n = i3;
        this.o = str2;
        this.m = jSONObject;
        this.s = z;
        this.u = null;
        if (j()) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("isBidder = " + h() + ", shouldEarlyInit = " + i());
            this.t = true;
            g();
        }
    }

    K(d dVar, J j2, NetworkSettings networkSettings, AbstractAdapter abstractAdapter, int i2, boolean z) {
        this(dVar, j2, networkSettings, abstractAdapter, i2, "", (JSONObject) null, 0, "", z);
    }

    private void a(a aVar) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(v() + "state = " + aVar.name());
        synchronized (this.q) {
            this.j = aVar;
        }
    }

    private void a(IronSourceError ironSourceError) {
        if (ironSourceError.getErrorCode() == 606) {
            a(this.s ? IronSourceConstants.BN_INSTANCE_RELOAD_NO_FILL : IronSourceConstants.BN_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{"duration", Long.valueOf(com.ironsource.mediationsdk.utils.d.a(this.r))}});
        } else {
            a(this.s ? IronSourceConstants.BN_INSTANCE_RELOAD_ERROR : IronSourceConstants.BN_INSTANCE_LOAD_ERROR, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(com.ironsource.mediationsdk.utils.d.a(this.r))}});
        }
        J j2 = this.k;
        if (j2 != null) {
            j2.a(ironSourceError, this);
        }
    }

    private static boolean a(int i2) {
        return i2 == 3005 || i2 == 3002 || i2 == 3012 || i2 == 3015 || i2 == 3008 || i2 == 3305 || i2 == 3300 || i2 == 3306 || i2 == 3307 || i2 == 3302 || i2 == 3303 || i2 == 3304 || i2 == 3009;
    }

    private boolean a(a aVar, a aVar2) {
        boolean z;
        synchronized (this.q) {
            if (this.j == aVar) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose(v() + "set state from '" + this.j + "' to '" + aVar2 + "'");
                this.j = aVar2;
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private void b(String str) {
        IronLog.INTERNAL.verbose(s());
        if (a(a.READY_TO_LOAD, a.LOADING)) {
            this.r = new com.ironsource.mediationsdk.utils.d();
            a(this.s ? IronSourceConstants.BN_INSTANCE_RELOAD : 3002, (Object[][]) null);
            if (this.c != null) {
                try {
                    if (h()) {
                        this.c.loadBannerForBidding(this.f, this.u, str, this.l, this);
                    } else {
                        this.c.loadBanner(this.f, this.u, this.l, this);
                    }
                } catch (Throwable th) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.error("Exception while trying to load banner from " + this.c.getProviderName() + ", exception =  " + th.getLocalizedMessage());
                    th.printStackTrace();
                    onBannerAdLoadFailed(new IronSourceError(605, th.getLocalizedMessage()));
                    a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_loadException)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
                }
            }
        } else {
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.error("wrong state - state = " + this.j);
        }
    }

    private void g() {
        IronLog.INTERNAL.verbose();
        a(a.INIT_IN_PROGRESS);
        t();
        try {
            if (this.c == null) {
                return;
            }
            if (h()) {
                this.c.initBannerForBidding(this.b.a(), this.b.b(), this.f, this);
            } else {
                this.c.initBanners(this.b.a(), this.b.b(), this.f, this);
            }
        } catch (Throwable th) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Exception while trying to init banner from " + this.c.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            th.printStackTrace();
            onBannerInitFailed(new IronSourceError(612, th.getLocalizedMessage()));
            a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
        }
    }

    private void t() {
        if (this.c != null) {
            try {
                String pluginType = ConfigFile.getConfigFile().getPluginType();
                if (!TextUtils.isEmpty(pluginType)) {
                    this.c.setPluginData(pluginType);
                }
            } catch (Throwable th) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("Exception while trying to set custom params from " + this.c.getProviderName() + ", exception =  " + th.getLocalizedMessage());
                th.printStackTrace();
                a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_internal)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            }
        }
    }

    private boolean u() {
        boolean z;
        synchronized (this.q) {
            z = this.j == a.LOADED;
        }
        return z;
    }

    private String v() {
        return String.format("%s - ", new Object[]{s()});
    }

    private boolean w() {
        boolean z;
        synchronized (this.q) {
            z = this.j == a.DESTROYED;
        }
        return z;
    }

    public final Map<String, Object> a(AdData adData) {
        JSONObject a2 = adData != null ? com.ironsource.mediationsdk.d.c.a(adData.getAdUnitData()) : null;
        try {
            if (!h() || this.c == null) {
                return null;
            }
            return this.c.getBannerBiddingData(this.f, a2);
        } catch (Throwable th) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Exception while trying to getBannerBiddingData from " + this.c.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            th.printStackTrace();
            a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 5001}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            return null;
        }
    }

    public final void a() {
        IronLog.INTERNAL.verbose(s());
        a((int) IronSourceConstants.BN_INSTANCE_DESTROY, (Object[][]) null);
        a(a.DESTROYED);
        if (this.c == null) {
            IronLog.INTERNAL.warning("mAdapter == null");
            return;
        }
        try {
            this.c.destroyBanner(this.d.a.getBannerSettings());
        } catch (Throwable th) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Exception while trying to destroy banner from " + this.c.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            th.printStackTrace();
            a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_destroy)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
        }
    }

    public final void a(int i2, Object[][] objArr) {
        Map<String, Object> q2 = q();
        if (w()) {
            q2.put(IronSourceConstants.EVENTS_ERROR_REASON, "banner is destroyed");
        } else {
            IronSourceBannerLayout ironSourceBannerLayout = this.l;
            if (ironSourceBannerLayout != null) {
                C0224n.a(q2, ironSourceBannerLayout.getSize());
            }
        }
        if (!TextUtils.isEmpty(this.a)) {
            q2.put("auctionId", this.a);
        }
        JSONObject jSONObject = this.m;
        if (jSONObject != null && jSONObject.length() > 0) {
            q2.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.m);
        }
        e eVar = this.p;
        if (eVar != null) {
            q2.put("placement", eVar.getPlacementName());
        }
        if (a(i2)) {
            com.ironsource.mediationsdk.events.e.d();
            com.ironsource.mediationsdk.events.e.a(q2, this.n, this.o);
        }
        q2.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.g));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    q2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronLog.INTERNAL.error(n() + " smash: BN sendMediationEvent " + Log.getStackTraceString(e));
            }
        }
        com.ironsource.mediationsdk.events.e.d().a(new com.ironsource.environment.c.a(i2, new JSONObject(q2)));
    }

    public final void a(IronSourceBannerLayout ironSourceBannerLayout, e eVar, String str, JSONObject jSONObject) {
        IronLog.INTERNAL.verbose(s());
        this.p = eVar;
        this.u = jSONObject;
        if (!C0224n.a(ironSourceBannerLayout)) {
            String str2 = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
            IronLog.INTERNAL.verbose(str2);
            this.k.a(new IronSourceError(610, str2), this);
        } else if (this.c == null) {
            IronLog.INTERNAL.verbose("mAdapter is null");
            this.k.a(new IronSourceError(611, "mAdapter is null"), this);
        } else {
            this.l = ironSourceBannerLayout;
            this.i.a(this);
            try {
                if (h()) {
                    b(str);
                } else {
                    g();
                }
            } catch (Throwable th) {
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("exception = " + th.getLocalizedMessage());
                th.printStackTrace();
                onBannerAdLoadFailed(new IronSourceError(605, th.getLocalizedMessage()));
            }
        }
    }

    public final void a(AdData adData, BiddingDataCallback biddingDataCallback) {
        JSONObject jSONObject = null;
        a((int) IronSourceConstants.BN_INSTANCE_COLLECT_TOKEN, (Object[][]) null);
        if (adData != null) {
            jSONObject = com.ironsource.mediationsdk.d.c.a(adData.getAdUnitData());
        }
        try {
            this.c.collectBannerBiddingData(this.f, jSONObject, biddingDataCallback);
        } catch (Throwable th) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("Exception while trying to collectBannerBiddingData from " + this.c.getProviderName() + ", exception =  " + th.getLocalizedMessage());
            th.printStackTrace();
        }
    }

    public final void b() {
        IronSourceError ironSourceError;
        IronLog.INTERNAL.verbose(s());
        if (a(a.INIT_IN_PROGRESS, a.f)) {
            IronLog.INTERNAL.verbose("init timed out");
            ironSourceError = new IronSourceError(607, "Timed out");
        } else if (a(a.LOADING, a.f)) {
            IronLog.INTERNAL.verbose("load timed out");
            ironSourceError = new IronSourceError(608, "Timed out");
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("unexpected state - " + this.j);
            return;
        }
        a(ironSourceError);
    }

    public final IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.BANNER;
    }

    public final String e() {
        return "ProgBannerSmash";
    }

    public final void f() {
        this.i.c();
        super.f();
    }

    public final void onBannerAdClicked() {
        IronLog.INTERNAL.verbose(s());
        a((int) IronSourceConstants.BN_INSTANCE_CLICK, (Object[][]) null);
        J j2 = this.k;
        if (j2 != null) {
            j2.a(this);
        }
    }

    public final void onBannerAdLeftApplication() {
        IronLog.INTERNAL.verbose(s());
        a((int) IronSourceConstants.BN_INSTANCE_LEAVE_APP, (Object[][]) null);
        J j2 = this.k;
        if (j2 != null) {
            j2.d(this);
        }
    }

    public final void onBannerAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(v() + "error = " + ironSourceError);
        this.i.d();
        if (a(a.LOADING, a.f)) {
            a(ironSourceError);
        }
    }

    public final void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
        IronLog.INTERNAL.verbose(s());
        this.i.d();
        if (a(a.LOADING, a.LOADED)) {
            a(this.s ? IronSourceConstants.BN_INSTANCE_RELOAD_SUCCESS : 3005, new Object[][]{new Object[]{"duration", Long.valueOf(com.ironsource.mediationsdk.utils.d.a(this.r))}});
            J j2 = this.k;
            if (j2 != null) {
                j2.a(this, view, layoutParams);
                return;
            }
            return;
        }
        a(this.s ? IronSourceConstants.BN_INSTANCE_UNEXPECTED_RELOAD_SUCCESS : IronSourceConstants.BN_INSTANCE_UNEXPECTED_LOAD_SUCCESS, (Object[][]) null);
    }

    public final void onBannerAdScreenDismissed() {
        IronLog.INTERNAL.verbose(s());
        a((int) IronSourceConstants.BN_INSTANCE_DISMISS_SCREEN, (Object[][]) null);
        J j2 = this.k;
        if (j2 != null) {
            j2.b(this);
        }
    }

    public final void onBannerAdScreenPresented() {
        IronLog.INTERNAL.verbose(s());
        a((int) IronSourceConstants.BN_INSTANCE_PRESENT_SCREEN, (Object[][]) null);
        J j2 = this.k;
        if (j2 != null) {
            j2.c(this);
        }
    }

    public final void onBannerAdShown() {
        IronLog.INTERNAL.verbose(s());
        if (u()) {
            a((int) IronSourceConstants.BN_INSTANCE_SHOW, (Object[][]) null);
            J j2 = this.k;
            if (j2 != null) {
                j2.e(this);
                return;
            }
            return;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("wrong state - mState = " + this.j);
        Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, 1};
        a((int) IronSourceConstants.TROUBLESHOOTING_BN_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "Wrong State - " + this.j}, new Object[]{IronSourceConstants.EVENTS_EXT1, n()}});
    }

    public final void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(v() + "error = " + ironSourceError);
        this.i.d();
        if (a(a.INIT_IN_PROGRESS, a.NONE)) {
            J j2 = this.k;
            if (j2 != null) {
                j2.a(ironSourceError, this);
                return;
            }
            return;
        }
        IronLog ironLog2 = IronLog.INTERNAL;
        ironLog2.warning("wrong state - mState = " + this.j);
    }

    public final void onBannerInitSuccess() {
        IronLog.INTERNAL.verbose(s());
        if (!a(a.INIT_IN_PROGRESS, a.READY_TO_LOAD)) {
            return;
        }
        if (this.t) {
            this.t = false;
        } else if (h()) {
        } else {
            if (!C0224n.a(this.l)) {
                this.k.a(new IronSourceError(605, this.l == null ? "banner is null" : "banner is destroyed"), this);
            } else {
                b((String) null);
            }
        }
    }
}
