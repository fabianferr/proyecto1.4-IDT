package com.ironsource.mediationsdk;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.bidding.c;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.events.i;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import org.json.JSONObject;

public final class B extends O implements c, RewardedVideoSmashListener {
    /* access modifiers changed from: package-private */
    public a a;
    String b;
    /* access modifiers changed from: private */
    public C i;
    private Timer j;
    private int k;
    private String l;
    private String m;
    private Placement n;
    private long o;
    private JSONObject p;
    private int q;
    private String r;
    private final Object s;
    private final Object t;
    private long u;
    private final a.C0114a v;

    public enum a {
        NO_INIT,
        INIT_IN_PROGRESS,
        NOT_LOADED,
        LOAD_IN_PROGRESS,
        LOADED,
        SHOW_IN_PROGRESS,
        ENDED
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public B(com.ironsource.mediationsdk.B r10, com.ironsource.mediationsdk.C r11, com.ironsource.mediationsdk.AbstractAdapter r12, int r13, java.lang.String r14, org.json.JSONObject r15, int r16, java.lang.String r17) {
        /*
            r9 = this;
            r8 = r9
            r0 = r10
            java.lang.String r1 = r0.l
            java.lang.String r2 = r0.m
            com.ironsource.mediationsdk.model.a r3 = r0.d
            com.ironsource.mediationsdk.model.NetworkSettings r3 = r3.a
            int r5 = r0.k
            r0 = r9
            r4 = r11
            r6 = r12
            r7 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = r14
            r8.b = r0
            r0 = r15
            r8.p = r0
            r0 = r16
            r8.q = r0
            r0 = r17
            r8.r = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.B.<init>(com.ironsource.mediationsdk.B, com.ironsource.mediationsdk.C, com.ironsource.mediationsdk.AbstractAdapter, int, java.lang.String, org.json.JSONObject, int, java.lang.String):void");
    }

    public B(String str, String str2, NetworkSettings networkSettings, C c, int i2, AbstractAdapter abstractAdapter, int i3) {
        super(new com.ironsource.mediationsdk.model.a(networkSettings, networkSettings.getRewardedVideoSettings(), IronSource.AD_UNIT.REWARDED_VIDEO), abstractAdapter);
        this.s = new Object();
        this.t = new Object();
        this.v = MediationServices.getEditor().getSessionDepthServiceEditor();
        this.l = str;
        this.m = str2;
        this.i = c;
        this.j = null;
        this.k = i2;
        this.g = i3;
        this.a = a.NO_INIT;
        this.u = 0;
        if (j()) {
            super.a("isBidder = " + h() + ", shouldEarlyInit = " + i(), 0);
            a(a.INIT_IN_PROGRESS);
            g();
            try {
                this.c.initRewardedVideoWithCallback(this.l, this.m, this.f, this);
            } catch (Throwable th) {
                super.a("initForBidding exception: " + th.getLocalizedMessage(), 3);
                th.printStackTrace();
                onRewardedVideoInitFailed(new IronSourceError(IronSourceError.ERROR_RV_INSTANCE_INIT_EXCEPTION, th.getLocalizedMessage()));
            }
        }
    }

    private void a(int i2, Object[][] objArr, boolean z) {
        Placement placement;
        Map<String, Object> q2 = q();
        if (!TextUtils.isEmpty(this.b)) {
            q2.put("auctionId", this.b);
        }
        JSONObject jSONObject = this.p;
        if (jSONObject != null && jSONObject.length() > 0) {
            q2.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.p);
        }
        if (z && (placement = this.n) != null && !TextUtils.isEmpty(placement.getPlacementName())) {
            q2.put("placement", this.n.getPlacementName());
        }
        if (b(i2)) {
            i.d();
            i.a(q2, this.q, this.r);
        }
        q2.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.g));
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    q2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, n() + " smash: RV sendProviderEvent " + Log.getStackTraceString(e), 3);
            }
        }
        i.d().a(new com.ironsource.environment.c.a(i2, new JSONObject(q2)));
        if (i2 == 1203) {
            this.v.b(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
    }

    /* access modifiers changed from: private */
    public void a(a aVar) {
        super.a("current state=" + this.a + ", new state=" + aVar, 0);
        synchronized (this.s) {
            this.a = aVar;
        }
    }

    private static boolean b(int i2) {
        return i2 == 1001 || i2 == 1002 || i2 == 1200 || i2 == 1212 || i2 == 1213 || i2 == 1005 || i2 == 1203 || i2 == 1201 || i2 == 1202 || i2 == 1006 || i2 == 1010;
    }

    private void g() {
        try {
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (!TextUtils.isEmpty(pluginType)) {
                this.c.setPluginData(pluginType);
            }
        } catch (Throwable th) {
            super.a("setCustomParams() " + th.getMessage(), 0);
        }
    }

    private void t() {
        synchronized (this.t) {
            Timer timer = this.j;
            if (timer != null) {
                timer.cancel();
                this.j = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public long u() {
        return new Date().getTime() - this.o;
    }

    public final Map<String, Object> a(AdData adData) {
        JSONObject a2 = adData != null ? com.ironsource.mediationsdk.d.c.a(adData.getAdUnitData()) : null;
        try {
            if (h()) {
                return this.c.getRewardedVideoBiddingData(this.f, a2);
            }
            return null;
        } catch (Throwable th) {
            super.a("getBiddingData exception: " + th.getLocalizedMessage(), 3);
            th.printStackTrace();
            b(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 5001}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            return null;
        }
    }

    public final void a(int i2) {
        a(i2, (Object[][]) null, false);
    }

    public final void a(int i2, Object[][] objArr) {
        a(i2, objArr, true);
    }

    public final void a(AdData adData, BiddingDataCallback biddingDataCallback) {
        JSONObject jSONObject = null;
        a(1020, (Object[][]) null, false);
        if (adData != null) {
            jSONObject = com.ironsource.mediationsdk.d.c.a(adData.getAdUnitData());
        }
        try {
            this.c.collectRewardedVideoBiddingData(this.f, jSONObject, biddingDataCallback);
        } catch (Throwable th) {
            super.a("collectBiddingData exception: " + th.getLocalizedMessage(), 3);
            th.printStackTrace();
        }
    }

    public final void a(Placement placement) {
        t();
        super.a("showVideo()", 0);
        this.n = placement;
        a(a.SHOW_IN_PROGRESS);
        a((int) IronSourceConstants.RV_INSTANCE_SHOW, (Object[][]) null);
        try {
            this.c.showRewardedVideo(this.f, this);
        } catch (Throwable th) {
            super.a("showVideo exception: " + th.getLocalizedMessage(), 3);
            th.printStackTrace();
            onRewardedVideoAdShowFailed(new IronSourceError(1038, th.getLocalizedMessage()));
        }
    }

    public final void a(String str, JSONObject jSONObject) {
        a aVar;
        super.a("loadVideo() auctionId: " + this.b + " state: " + this.a, 0);
        this.h = null;
        this.e = false;
        synchronized (this.s) {
            aVar = this.a;
            if (!(aVar == a.LOAD_IN_PROGRESS || this.a == a.SHOW_IN_PROGRESS)) {
                a(a.LOAD_IN_PROGRESS);
            }
        }
        if (aVar == a.LOAD_IN_PROGRESS) {
            b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_loadInProgress)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "load during load"}});
        } else if (aVar == a.SHOW_IN_PROGRESS) {
            b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_showInProgress)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "load during show"}});
        } else {
            synchronized (this.t) {
                Timer timer = new Timer();
                this.j = timer;
                timer.schedule(new TimerTask() {
                    public final void run() {
                        boolean z;
                        int i;
                        String str = "Rewarded Video - load instance time out";
                        if (B.this.a == a.LOAD_IN_PROGRESS || B.this.a == a.INIT_IN_PROGRESS) {
                            if (B.this.a == a.LOAD_IN_PROGRESS) {
                                i = 1025;
                            } else {
                                i = 1032;
                                str = "Rewarded Video - init instance time out";
                            }
                            B.this.a(a.NOT_LOADED);
                            z = true;
                        } else {
                            i = 0;
                            z = false;
                        }
                        B.this.a(str, 0);
                        if (z) {
                            B.this.b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{"duration", Long.valueOf(B.this.u())}});
                            B.this.b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, str}, new Object[]{"duration", Long.valueOf(B.this.u())}});
                            B.this.i.b(B.this);
                            return;
                        }
                        B.this.b(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1025}, new Object[]{"duration", Long.valueOf(B.this.u())}, new Object[]{IronSourceConstants.EVENTS_EXT1, B.this.a.name()}});
                    }
                }, (long) (this.k * 1000));
            }
            this.o = new Date().getTime();
            a(1001);
            try {
                if (h()) {
                    this.c.loadRewardedVideoForBidding(this.f, jSONObject, str, this);
                    return;
                }
                g();
                this.c.initAndLoadRewardedVideo(this.l, this.m, this.f, jSONObject, this);
            } catch (Throwable th) {
                super.a("loadVideo exception: " + th.getLocalizedMessage(), 3);
                th.printStackTrace();
                b(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(h() ? IronSourceConstants.errorCode_loadException : IronSourceConstants.errorCode_initFailed)}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            }
        }
    }

    public final void a(boolean z) {
        Object[][] objArr = new Object[1][];
        Object[] objArr2 = new Object[2];
        objArr2[0] = "status";
        objArr2[1] = z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
        objArr[0] = objArr2;
        a(IronSourceConstants.RV_INSTANCE_SHOW_CHANCE, objArr, true);
    }

    public final boolean a() {
        if (this.a != a.LOADED) {
            return false;
        }
        try {
            return this.c.isRewardedVideoAvailable(this.f);
        } catch (Throwable th) {
            super.a("isReadyToShow exception: " + th.getLocalizedMessage(), 3);
            th.printStackTrace();
            b(IronSourceConstants.TROUBLESHOOTING_RV_SMASH_UNEXPECTED_EXCEPTION, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 5002}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, th.getLocalizedMessage()}});
            return false;
        }
    }

    public final LoadWhileShowSupportState b() {
        try {
            return this.c.getLoadWhileShowSupportState(this.f);
        } catch (Throwable th) {
            super.a("Exception while calling adapter.getLoadWhileShowSupportState() - " + th.getLocalizedMessage(), 3);
            return LoadWhileShowSupportState.NONE;
        }
    }

    public final void b(int i2, Object[][] objArr) {
        a(i2, objArr, false);
    }

    public final int c() {
        return 2;
    }

    public final IronSource.AD_UNIT d() {
        return IronSource.AD_UNIT.REWARDED_VIDEO;
    }

    public final String e() {
        return "LWSProgRvSmash";
    }

    public final void onRewardedVideoAdClicked() {
        super.a("onRewardedVideoAdClicked", 0);
        this.i.b(this, this.n);
        a(1006, (Object[][]) null);
    }

    public final void onRewardedVideoAdClosed() {
        super.a("onRewardedVideoAdClosed", 0);
        synchronized (this.s) {
            if (this.a != a.SHOW_IN_PROGRESS) {
                a((int) IronSourceConstants.RV_INSTANCE_CLOSED, (Object[][]) null);
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_adClosed)};
                b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "adClosed: " + this.a}});
                return;
            }
            a(a.ENDED);
            this.u = new Date().getTime();
            this.i.d(this);
        }
    }

    public final void onRewardedVideoAdEnded() {
        super.a("onRewardedVideoAdEnded", 0);
        this.i.f(this);
        a((int) IronSourceConstants.RV_INSTANCE_ENDED, (Object[][]) null);
    }

    public final void onRewardedVideoAdOpened() {
        super.a("onRewardedVideoAdOpened", 0);
        this.i.c(this);
        a(1005, (Object[][]) null);
    }

    public final void onRewardedVideoAdRewarded() {
        super.a("onRewardedVideoAdRewarded", 0);
        long time = new Date().getTime();
        this.i.a(this, this.n);
        Map<String, Object> q2 = q();
        Placement placement = this.n;
        if (placement != null) {
            q2.put("placement", placement.getPlacementName());
            q2.put(IronSourceConstants.EVENTS_REWARD_NAME, this.n.getRewardName());
            q2.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(this.n.getRewardAmount()));
        }
        if (!TextUtils.isEmpty(z.a().i)) {
            q2.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, z.a().i);
        }
        if (z.a().j != null) {
            for (String next : z.a().j.keySet()) {
                q2.put("custom_" + next, z.a().j.get(next));
            }
        }
        if (!TextUtils.isEmpty(this.b)) {
            q2.put("auctionId", this.b);
        }
        JSONObject jSONObject = this.p;
        if (jSONObject != null && jSONObject.length() > 0) {
            q2.put(IronSourceConstants.EVENTS_GENERIC_PARAMS, this.p);
        }
        if (b(1010)) {
            i.d();
            i.a(q2, this.q, this.r);
        }
        q2.put(IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.g));
        com.ironsource.environment.c.a aVar = new com.ironsource.environment.c.a(1010, new JSONObject(q2));
        aVar.a(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId(aVar.b(), n()));
        long j2 = this.u;
        if (j2 != 0) {
            long j3 = time - j2;
            super.a("onRewardedVideoAdRewarded timeAfterClosed=" + j3, 0);
            aVar.a("duration", Long.valueOf(j3));
        }
        i.d().a(aVar);
    }

    public final void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        super.a("onRewardedVideoAdShowFailed error=" + ironSourceError.getErrorMessage(), 0);
        a((int) IronSourceConstants.RV_INSTANCE_SHOW_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}});
        synchronized (this.s) {
            if (this.a != a.SHOW_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_showFailed)};
                b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "showFailed: " + this.a}});
                return;
            }
            a(a.ENDED);
            this.i.a(ironSourceError, this);
        }
    }

    public final void onRewardedVideoAdStarted() {
        super.a("onRewardedVideoAdStarted", 0);
        this.i.e(this);
        a((int) IronSourceConstants.RV_INSTANCE_STARTED, (Object[][]) null);
    }

    public final void onRewardedVideoAdVisible() {
        super.a("onRewardedVideoAdVisible", 0);
        a((int) IronSourceConstants.RV_INSTANCE_VISIBLE, (Object[][]) null);
    }

    public final void onRewardedVideoAvailabilityChanged(boolean z) {
        boolean z2;
        super.a("onRewardedVideoAvailabilityChanged available=" + z + " state=" + this.a.name(), 0);
        synchronized (this.s) {
            if (this.a == a.LOAD_IN_PROGRESS) {
                a(z ? a.LOADED : a.NOT_LOADED);
                z2 = false;
            } else {
                z2 = true;
            }
        }
        if (!z2) {
            t();
            b(z ? 1002 : IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{"duration", Long.valueOf(u())}});
            if (z) {
                this.i.a(this);
            } else {
                this.i.b(this);
            }
        } else if (z) {
            b(IronSourceConstants.RV_INSTANCE_AVAILABILITY_TRUE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_EXT1, this.a.name()}});
        } else {
            b(IronSourceConstants.RV_INSTANCE_AVAILABILITY_FALSE, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1034}, new Object[]{"duration", Long.valueOf(u())}, new Object[]{IronSourceConstants.EVENTS_EXT1, this.a.name()}});
        }
    }

    public final void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        super.a("onRewardedVideoInitFailed error=" + ironSourceError.getErrorMessage(), 0);
        t();
        b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, 1033}, new Object[]{"duration", Long.valueOf(u())}});
        b(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(u())}});
        synchronized (this.s) {
            if (this.a != a.INIT_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initFailed)};
                b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "initFailed: " + this.a}});
                return;
            }
            a(a.NO_INIT);
            this.i.b(this);
        }
    }

    public final void onRewardedVideoInitSuccess() {
        super.a("onRewardedVideoInitSuccess", 0);
        synchronized (this.s) {
            if (this.a != a.INIT_IN_PROGRESS) {
                Object[] objArr = {IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(IronSourceConstants.errorCode_initSuccess)};
                b(IronSourceConstants.RV_SMASH_UNEXPECTED_STATE, new Object[][]{objArr, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, "initSuccess: " + this.a}});
                return;
            }
            a(a.NOT_LOADED);
        }
    }

    public final void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        if (ironSourceError.getErrorCode() == 1058) {
            a(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"duration", Long.valueOf(u())}}, false);
            return;
        }
        if (ironSourceError.getErrorCode() == 1057) {
            this.h = Long.valueOf(System.currentTimeMillis());
        }
        a(IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(u())}}, false);
    }

    public final void onRewardedVideoLoadSuccess() {
    }
}
