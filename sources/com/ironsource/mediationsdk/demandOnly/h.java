package com.ironsource.mediationsdk.demandOnly;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.C0213c;
import com.ironsource.mediationsdk.C0215e;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.events.i;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.q;
import com.ironsource.mediationsdk.sdk.b;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.mediationsdk.z;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class h implements b {
    public ConcurrentHashMap<String, i> a;
    private String b;
    private c c;
    private final a d = MediationServices.getProvider().getSessionDepthService();
    private final a.C0114a e = MediationServices.getEditor().getSessionDepthServiceEditor();

    public h(List<NetworkSettings> list, q qVar, String str, String str2) {
        this.b = str;
        this.a = new ConcurrentHashMap<>();
        this.c = qVar.m;
        for (NetworkSettings next : list) {
            if (next.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME) || next.getProviderTypeForReflection().equalsIgnoreCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME)) {
                AbstractAdapter a2 = C0213c.a().a(next, next.getRewardedVideoSettings(), true, false);
                if (a2 != null) {
                    this.a.put(next.getSubProviderId(), new i(str, str2, next, this, (long) (qVar.e * 1000), a2));
                }
            } else {
                a("cannot load " + next.getProviderTypeForReflection());
            }
        }
    }

    public static void a(int i, i iVar, Object[][] objArr) {
        Map<String, Object> b2 = iVar.b();
        if (objArr != null) {
            try {
                for (Object[] objArr2 : objArr) {
                    b2.put(objArr2[0].toString(), objArr2[1]);
                }
            } catch (Exception e2) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "RV sendProviderEvent " + Log.getStackTraceString(e2), 3);
            }
        }
        i.d().a(new com.ironsource.environment.c.a(i, new JSONObject(b2)));
    }

    public static void a(int i, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        hashMap.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
        if (str == null) {
            str = "";
        }
        hashMap.put(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, str);
        i.d().a(new com.ironsource.environment.c.a(1500, new JSONObject(hashMap)));
    }

    private static void a(i iVar, String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "DemandOnlyRvManager " + iVar.e() + " : " + str, 0);
    }

    private static void a(String str) {
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
        logger.log(ironSourceTag, "DemandOnlyRvManager " + str, 0);
    }

    public void a(int i, i iVar) {
        a(i, iVar, (Object[][]) null);
    }

    public final void a(i iVar) {
        a(iVar, "onRewardedVideoAdOpened");
        a(1005, iVar, (Object[][]) null);
        r a2 = r.a();
        String g = iVar.g();
        if (a2.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(g) {
                private /* synthetic */ String a;

                {
                    this.a = r2;
                }

                public final void run() {
                    r.this.a.onRewardedVideoAdOpened(this.a);
                    r rVar = r.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdOpened() instanceId=" + this.a, 1);
                }
            });
        }
        if (iVar.k()) {
            for (String a3 : iVar.g) {
                C0215e.a();
                String a4 = C0215e.a(a3, iVar.e(), iVar.f(), iVar.h, "", "", "", "");
                C0215e.a();
                C0215e.a("onRewardedVideoAdOpened", iVar.e(), a4);
            }
        }
    }

    public final void a(i iVar, long j) {
        a(iVar, "onRewardedVideoLoadSuccess");
        a(1002, iVar, new Object[][]{new Object[]{"duration", Long.valueOf(j)}});
        r a2 = r.a();
        String g = iVar.g();
        if (a2.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(g) {
                private /* synthetic */ String a;

                {
                    this.a = r2;
                }

                public final void run() {
                    r.this.a.onRewardedVideoAdLoadSuccess(this.a);
                    r rVar = r.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdLoadSuccess() instanceId=" + this.a, 1);
                }
            });
        }
    }

    public final void a(IronSourceError ironSourceError, i iVar) {
        a(iVar, "onRewardedVideoAdShowFailed error=" + ironSourceError);
        a((int) IronSourceConstants.RV_INSTANCE_SHOW_FAILED, iVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}});
        r.a().b(iVar.g(), ironSourceError);
    }

    public final void a(IronSourceError ironSourceError, i iVar, long j) {
        a(iVar, "onRewardedVideoAdLoadFailed error=" + ironSourceError);
        a((int) IronSourceConstants.RV_INSTANCE_LOAD_FAILED, iVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(j)}});
        if (ironSourceError.getErrorCode() == 1058) {
            a((int) IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL, iVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{"duration", Long.valueOf(j)}});
        } else {
            a((int) IronSourceConstants.RV_INSTANCE_LOAD_FAILED_REASON, iVar, new Object[][]{new Object[]{IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(ironSourceError.getErrorCode())}, new Object[]{IronSourceConstants.EVENTS_ERROR_REASON, ironSourceError.getErrorMessage()}, new Object[]{"duration", Long.valueOf(j)}});
        }
        r.a().a(iVar.g(), ironSourceError);
    }

    public final void a(String str, String str2, boolean z) {
        IronSourceError buildLoadFailedError;
        r a2;
        try {
            if (!this.a.containsKey(str)) {
                a(1500, str);
                r.a().a(str, ErrorBuilder.buildNonExistentInstanceError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            i iVar = this.a.get(str);
            if (z) {
                if (!iVar.k()) {
                    buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm in IAB flow must be called by bidder instances");
                    a(buildLoadFailedError.getErrorMessage());
                    a((int) IronSourceConstants.RV_INSTANCE_LOAD_FAILED, iVar, (Object[][]) null);
                    a2 = r.a();
                } else {
                    C0215e.a();
                    JSONObject a3 = C0215e.a(str2);
                    C0215e.a();
                    C0215e.a a4 = C0215e.a(a3);
                    C0215e.a();
                    com.ironsource.mediationsdk.adunit.a.a a5 = C0215e.a(iVar.e(), a4.b);
                    if (a5 != null) {
                        iVar.a(a5.b());
                        iVar.b(a4.a);
                        iVar.a(a4.d);
                        a(1001, iVar, (Object[][]) null);
                        iVar.a(a5.b(), a4.a, a4.d, a5.g());
                        return;
                    }
                    buildLoadFailedError = ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm invalid enriched adm");
                    a(buildLoadFailedError.getErrorMessage());
                    a((int) IronSourceConstants.RV_INSTANCE_LOAD_FAILED, iVar, (Object[][]) null);
                    a2 = r.a();
                }
                a2.a(str, buildLoadFailedError);
            } else if (!iVar.k()) {
                a(1001, iVar, (Object[][]) null);
                iVar.a("", "", (JSONObject) null, (List<String>) null);
            } else {
                IronSourceError buildLoadFailedError2 = ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm in non IAB flow must be called by non bidder instances");
                a(buildLoadFailedError2.getErrorMessage());
                a((int) IronSourceConstants.RV_INSTANCE_LOAD_FAILED, iVar, (Object[][]) null);
                r.a().a(str, buildLoadFailedError2);
            }
        } catch (Exception e2) {
            a("loadRewardedVideoWithAdm exception " + e2.getMessage());
            r.a().a(str, ErrorBuilder.buildLoadFailedError("loadRewardedVideoWithAdm exception"));
        }
    }

    public final void b(i iVar) {
        a(iVar, "onRewardedVideoAdClosed");
        a((int) IronSourceConstants.RV_INSTANCE_CLOSED, iVar, new Object[][]{new Object[]{IronSourceConstants.KEY_SESSION_DEPTH, Integer.valueOf(this.d.a(IronSource.AD_UNIT.REWARDED_VIDEO))}});
        this.e.b(IronSource.AD_UNIT.REWARDED_VIDEO);
        r a2 = r.a();
        String g = iVar.g();
        if (a2.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(g) {
                private /* synthetic */ String a;

                {
                    this.a = r2;
                }

                public final void run() {
                    r.this.a.onRewardedVideoAdClosed(this.a);
                    r rVar = r.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClosed() instanceId=" + this.a, 1);
                }
            });
        }
    }

    public final void c(i iVar) {
        a(iVar, "onRewardedVideoAdClicked");
        a(1006, iVar, (Object[][]) null);
        r a2 = r.a();
        String g = iVar.g();
        if (a2.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(g) {
                private /* synthetic */ String a;

                {
                    this.a = r2;
                }

                public final void run() {
                    r.this.a.onRewardedVideoAdClicked(this.a);
                    r rVar = r.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdClicked() instanceId=" + this.a, 1);
                }
            });
        }
    }

    public final void d(i iVar) {
        a(iVar, "onRewardedVideoAdVisible");
        a((int) IronSourceConstants.RV_INSTANCE_VISIBLE, iVar, (Object[][]) null);
    }

    public final void e(i iVar) {
        a(iVar, "onRewardedVideoAdRewarded");
        Map<String, Object> b2 = iVar.b();
        if (!TextUtils.isEmpty(z.a().i)) {
            b2.put(IronSourceConstants.EVENTS_DYNAMIC_USER_ID, z.a().i);
        }
        if (z.a().j != null) {
            for (String next : z.a().j.keySet()) {
                b2.put("custom_" + next, z.a().j.get(next));
            }
        }
        Placement a2 = z.a().f.c.a().a();
        if (a2 != null) {
            b2.put("placement", a2.getPlacementName());
            b2.put(IronSourceConstants.EVENTS_REWARD_NAME, a2.getRewardName());
            b2.put(IronSourceConstants.EVENTS_REWARD_AMOUNT, Integer.valueOf(a2.getRewardAmount()));
        } else {
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "defaultPlacement is null", 3);
        }
        com.ironsource.environment.c.a aVar = new com.ironsource.environment.c.a(1010, new JSONObject(b2));
        aVar.a(IronSourceConstants.EVENTS_TRANS_ID, IronSourceUtils.getTransId(aVar.b(), iVar.e()));
        i.d().a(aVar);
        r a3 = r.a();
        String g = iVar.g();
        if (a3.a != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable(g) {
                private /* synthetic */ String a;

                {
                    this.a = r2;
                }

                public final void run() {
                    r.this.a.onRewardedVideoAdRewarded(this.a);
                    r rVar = r.this;
                    IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, "onRewardedVideoAdRewarded() instanceId=" + this.a, 1);
                }
            });
        }
    }
}
