package com.ironsource.sdk.d;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.config.VersionInfo;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.a.h;
import com.ironsource.sdk.controller.C0236c;
import com.ironsource.sdk.controller.FeaturesManager;
import com.ironsource.sdk.controller.g;
import com.ironsource.sdk.controller.k;
import com.ironsource.sdk.e;
import com.ironsource.sdk.f;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.j.a.a;
import com.ironsource.sdk.j.a.c;
import com.ironsource.sdk.j.a.d;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements c, e, f, a, com.ironsource.sdk.j.a.b, c, d {
    private static b g;
    public g a;
    com.ironsource.sdk.j.e b;
    String c;
    String d;
    k e;
    private final String f = IronSourceConstants.SUPERSONIC_CONFIG_NAME;
    private long h;
    private com.ironsource.sdk.service.d i;
    private com.ironsource.sdk.service.c j;
    private boolean k = false;
    private C0236c l;
    private FeaturesManager m = FeaturesManager.getInstance();

    private b(Context context) {
        b(context);
    }

    private b(String str, String str2, Context context) {
        this.c = str;
        this.d = str2;
        b(context);
    }

    public static synchronized b a(Context context) {
        b a2;
        synchronized (b.class) {
            a2 = a(context, 0);
        }
        return a2;
    }

    public static synchronized b a(Context context, int i2) {
        b bVar;
        synchronized (b.class) {
            Logger.i("IronSourceAdsPublisherAgent", "getInstance()");
            if (g == null) {
                g = new b(context);
            }
            bVar = g;
        }
        return bVar;
    }

    public static synchronized e a(String str, String str2, Context context) {
        b bVar;
        synchronized (b.class) {
            if (g == null) {
                com.ironsource.sdk.a.f.a(h.a);
                g = new b(str, str2, context);
            } else {
                com.ironsource.sdk.service.d.a().b(str);
                com.ironsource.sdk.service.d.a().a(str2);
            }
            bVar = g;
        }
        return bVar;
    }

    private static com.ironsource.sdk.j.c a(com.ironsource.sdk.g.c cVar) {
        if (cVar == null) {
            return null;
        }
        return (com.ironsource.sdk.j.c) cVar.g;
    }

    private void a(Context context, JSONObject jSONObject) {
        boolean optBoolean = jSONObject.optBoolean("enableLifeCycleListeners", false);
        this.k = optBoolean;
        if (optBoolean) {
            try {
                ((Application) context).registerActivityLifecycleCallbacks(new a(this));
            } catch (Throwable th) {
                com.ironsource.sdk.a.a aVar = new com.ironsource.sdk.a.a();
                aVar.a("generalmessage", th.getMessage());
                com.ironsource.sdk.a.f.a(h.t, (Map<String, Object>) aVar.a);
            }
        }
    }

    private static com.ironsource.sdk.j.b b(com.ironsource.sdk.g.c cVar) {
        if (cVar == null) {
            return null;
        }
        return (com.ironsource.sdk.j.b) cVar.g;
    }

    private void b(Context context) {
        try {
            JSONObject networkConfiguration = SDKUtils.getNetworkConfiguration();
            com.ironsource.sdk.utils.b.a(context);
            IronSourceStorageUtils.initializeCacheDirectory(context, new com.ironsource.sdk.h.e(SDKUtils.getNetworkConfiguration().optJSONObject("storage")));
            com.ironsource.sdk.utils.b.a().a(SDKUtils.getSDKVersion());
            this.i = c(context);
            this.e = new k();
            C0236c cVar = new C0236c();
            this.l = cVar;
            if (context instanceof Activity) {
                cVar.a((Activity) context);
            }
            int debugMode = this.m.getDebugMode();
            this.a = new g(context, this.l, this.i, this.e, com.ironsource.environment.thread.a.a, debugMode, this.m.getDataManagerConfig(), this.c, this.d);
            Logger.enableLogging(debugMode);
            Logger.i("IronSourceAdsPublisherAgent", "C'tor");
            a(context, networkConfiguration);
            this.j = new com.ironsource.sdk.service.c();
            com.ironsource.environment.c.e.a("sdkv", (Object) VersionInfo.VERSION);
            this.j.a();
            this.j.a(context);
            this.j.b();
            this.j.c();
            this.j.b(context);
            this.j.d();
            this.h = 0;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void b(final com.ironsource.sdk.b bVar, final Map<String, String> map) {
        Logger.d("IronSourceAdsPublisherAgent", "loadOnNewInstance " + bVar.b);
        this.a.a((Runnable) new Runnable() {
            public final void run() {
                d.e eVar = bVar.a() ? d.e.a : d.e.c;
                com.ironsource.sdk.g.c a2 = b.this.e.a(eVar, bVar);
                com.ironsource.sdk.a.a aVar = new com.ironsource.sdk.a.a();
                com.ironsource.sdk.a.a a3 = aVar.a("isbiddinginstance", Boolean.valueOf(bVar.d)).a("isoneflow", Boolean.valueOf(bVar.h)).a("demandsourcename", bVar.c).a("producttype", com.ironsource.sdk.d.a(bVar));
                com.ironsource.sdk.service.a aVar2 = com.ironsource.sdk.service.a.a;
                a3.a("custom_c", Long.valueOf(com.ironsource.sdk.service.a.c(bVar.b)));
                com.ironsource.sdk.a.f.a(h.h, (Map<String, Object>) aVar.a);
                if (eVar == d.e.a) {
                    b.this.a.a(b.this.c, b.this.d, a2, (com.ironsource.sdk.j.a.b) b.this);
                    b.this.a.a(a2, (Map<String, String>) map, (com.ironsource.sdk.j.a.b) b.this);
                    return;
                }
                b.this.a.a(b.this.c, b.this.d, a2, (c) b.this);
                b.this.a.a(a2, (Map<String, String>) map, (c) b.this);
            }
        });
    }

    private com.ironsource.sdk.service.d c(Context context) {
        com.ironsource.sdk.service.d a2 = com.ironsource.sdk.service.d.a();
        a2.b();
        a2.a(context, this.c, this.d);
        return a2;
    }

    private com.ironsource.sdk.g.c d(d.e eVar, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.e.a(eVar, str);
    }

    public final g a() {
        return this.a;
    }

    public final void a(Activity activity) {
        try {
            Logger.i("IronSourceAdsPublisherAgent", "release()");
            com.ironsource.sdk.utils.a.a();
            this.l.b();
            this.a.b((Context) activity);
            this.a.destroy();
            this.a = null;
        } catch (Exception unused) {
        }
        g = null;
    }

    public final void a(Activity activity, com.ironsource.sdk.b bVar, Map<String, String> map) {
        this.l.a(activity);
        a(bVar, map);
    }

    public final void a(Activity activity, final Map<String, String> map) {
        if (activity != null) {
            this.l.a(activity);
        }
        this.a.a((Runnable) new Runnable() {
            public final void run() {
                b.this.a.a((Map<String, String>) map, b.this.b);
            }
        });
    }

    public final void a(final com.ironsource.sdk.b bVar) {
        Logger.d("IronSourceAdsPublisherAgent", "destroyInstance " + bVar.b);
        this.a.a((Runnable) new Runnable() {
            public final void run() {
                com.ironsource.sdk.g.c a2 = b.this.e.a(d.e.a, bVar);
                com.ironsource.sdk.a.a aVar = new com.ironsource.sdk.a.a();
                aVar.a("isbiddinginstance", Boolean.valueOf(bVar.d)).a("demandsourcename", bVar.c).a("producttype", com.ironsource.sdk.d.a(bVar));
                com.ironsource.sdk.a.f.a(h.m, (Map<String, Object>) aVar.a);
                b.this.a.a(a2);
            }
        });
    }

    public final void a(com.ironsource.sdk.b bVar, Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis();
        map.put("loadStartTime", String.valueOf(currentTimeMillis));
        com.ironsource.sdk.service.a aVar = com.ironsource.sdk.service.a.a;
        com.ironsource.sdk.service.a.a(bVar.b, currentTimeMillis);
        com.ironsource.sdk.a.a aVar2 = new com.ironsource.sdk.a.a();
        aVar2.a("isbiddinginstance", Boolean.valueOf(bVar.d)).a("isoneflow", Boolean.valueOf(bVar.h)).a("demandsourcename", bVar.c).a("producttype", com.ironsource.sdk.d.a(bVar)).a("custom_c", Long.valueOf(currentTimeMillis));
        com.ironsource.sdk.a.f.a(h.f, (Map<String, Object>) aVar2.a);
        Logger.d("IronSourceAdsPublisherAgent", "loadAd " + bVar.b);
        if (bVar.d || bVar.h) {
            try {
                map.put("adm", SDKUtils.decodeString(map.get("adm")));
            } catch (Exception e2) {
                com.ironsource.sdk.a.a a2 = new com.ironsource.sdk.a.a().a("callfailreason", e2.getMessage()).a("isbiddinginstance", Boolean.valueOf(bVar.d)).a("isoneflow", Boolean.valueOf(bVar.h)).a("demandsourcename", bVar.c).a("producttype", com.ironsource.sdk.d.a(bVar));
                com.ironsource.sdk.service.a aVar3 = com.ironsource.sdk.service.a.a;
                com.ironsource.sdk.a.a a3 = a2.a("custom_c", Long.valueOf(com.ironsource.sdk.service.a.c(bVar.b)));
                com.ironsource.sdk.service.a aVar4 = com.ironsource.sdk.service.a.a;
                com.ironsource.sdk.service.a.b(bVar.b);
                com.ironsource.sdk.a.f.a(h.k, (Map<String, Object>) a3.a);
                e2.printStackTrace();
                Logger.d("IronSourceAdsPublisherAgent", "loadInAppBiddingAd failed decoding  ADM " + e2.getMessage());
            }
            b(bVar, map);
            return;
        }
        b(bVar, map);
    }

    public final void a(d.e eVar, String str) {
        com.ironsource.sdk.j.c a2;
        com.ironsource.sdk.g.c d2 = d(eVar, str);
        if (d2 != null && eVar != d.e.RewardedVideo && eVar == d.e.c && (a2 = a(d2)) != null) {
            a2.onInterstitialClose();
        }
    }

    public final void a(d.e eVar, String str, com.ironsource.sdk.g.a aVar) {
        com.ironsource.sdk.j.b b2;
        com.ironsource.sdk.g.c d2 = d(eVar, str);
        if (d2 != null) {
            d2.a(2);
            if (eVar == d.e.RewardedVideo) {
                return;
            }
            if (eVar == d.e.c) {
                com.ironsource.sdk.j.c a2 = a(d2);
                if (a2 != null) {
                    a2.onInterstitialInitSuccess();
                }
            } else if (eVar == d.e.a && (b2 = b(d2)) != null) {
                b2.onBannerInitSuccess();
            }
        }
    }

    public final void a(d.e eVar, String str, String str2) {
        com.ironsource.sdk.j.b b2;
        com.ironsource.sdk.g.c d2 = d(eVar, str);
        com.ironsource.sdk.a.a a2 = new com.ironsource.sdk.a.a().a("demandsourcename", str).a("producttype", eVar).a("callfailreason", str2);
        if (d2 != null) {
            com.ironsource.sdk.service.a aVar = com.ironsource.sdk.service.a.a;
            a2.a("custom_c", Long.valueOf(com.ironsource.sdk.service.a.c(d2.b)));
            a2.a("isbiddinginstance", Boolean.valueOf(com.ironsource.sdk.a.g.a(d2)));
            com.ironsource.sdk.service.a aVar2 = com.ironsource.sdk.service.a.a;
            com.ironsource.sdk.service.a.b(d2.b);
            d2.a(3);
            if (eVar != d.e.RewardedVideo) {
                if (eVar == d.e.c) {
                    com.ironsource.sdk.j.c a3 = a(d2);
                    if (a3 != null) {
                        a3.onInterstitialInitFailed(str2);
                    }
                } else if (eVar == d.e.a && (b2 = b(d2)) != null) {
                    b2.onBannerLoadFail(str2);
                }
            }
        }
        com.ironsource.sdk.a.f.a(h.i, (Map<String, Object>) a2.a);
    }

    public final void a(d.e eVar, String str, String str2, JSONObject jSONObject) {
        com.ironsource.sdk.j.b b2;
        com.ironsource.sdk.g.c d2 = d(eVar, str);
        if (d2 != null && !TextUtils.isEmpty(str2)) {
            try {
                Logger.i("IronSourceAdsPublisherAgent", "Received Event Notification: " + str2 + " for demand source: " + d2.a);
                if (eVar == d.e.c) {
                    com.ironsource.sdk.j.c a2 = a(d2);
                    if (a2 != null) {
                        jSONObject.put("demandSourceName", str);
                        a2.onInterstitialEventNotificationReceived(str2, jSONObject);
                    }
                } else if (eVar == d.e.RewardedVideo) {
                    if ((d2 == null ? null : (IronSourceBannerLayout.a) d2.g) != null) {
                        jSONObject.put("demandSourceName", str);
                    }
                } else if (eVar == d.e.a && (b2 = b(d2)) != null) {
                    jSONObject.put("demandSourceName", str);
                    if (str2.equalsIgnoreCase("impressions")) {
                        b2.onBannerShowSuccess();
                    }
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void a(final com.ironsource.sdk.j.e eVar) {
        this.a.a((Runnable) new Runnable() {
            public final void run() {
                b.this.a.a(b.this.c, b.this.d, eVar);
            }
        });
    }

    public final void a(String str) {
        d(d.e.RewardedVideo, str);
    }

    public final void a(String str, int i2) {
        d(d.e.RewardedVideo, str);
    }

    public final void a(String str, com.ironsource.sdk.c.b bVar) {
        com.ironsource.sdk.j.b b2;
        com.ironsource.sdk.g.c d2 = d(d.e.a, str);
        if (d2 != null && (b2 = b(d2)) != null) {
            b2.onBannerLoadSuccess(d2.h, bVar);
        }
    }

    public final void a(String str, String str2) {
        d(d.e.RewardedVideo, str);
    }

    public final void a(final String str, final String str2, final com.ironsource.sdk.j.e eVar) {
        this.c = str;
        this.d = str2;
        this.a.a((Runnable) new Runnable() {
            public final void run() {
                b.this.a.a(str, str2, eVar);
            }
        });
    }

    public final void a(String str, String str2, Map<String, String> map, com.ironsource.sdk.j.e eVar) {
        this.c = str;
        this.d = str2;
        this.b = eVar;
        final String str3 = str;
        final String str4 = str2;
        final Map<String, String> map2 = map;
        final com.ironsource.sdk.j.e eVar2 = eVar;
        this.a.a((Runnable) new Runnable() {
            public final void run() {
                b.this.a.a(str3, str4, (Map<String, String>) map2, eVar2);
            }
        });
    }

    public final void a(final Map<String, String> map, final com.ironsource.sdk.j.e eVar) {
        this.b = eVar;
        this.a.a((Runnable) new Runnable() {
            public final void run() {
                b.this.a.a(b.this.c, b.this.d, (Map<String, String>) map, eVar);
            }
        });
    }

    public final void a(final JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("gdprConsentStatus")) {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("consent", Boolean.parseBoolean(jSONObject.getString("gdprConsentStatus")));
                this.i.a(jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        this.a.a((Runnable) new Runnable() {
            public final void run() {
                b.this.a.a(jSONObject);
            }
        });
    }

    public final void b(Activity activity) {
        if (!this.k) {
            d(activity);
        }
    }

    public final void b(Activity activity, com.ironsource.sdk.b bVar, final Map<String, String> map) {
        this.l.a(activity);
        Logger.i("IronSourceAdsPublisherAgent", "showAd " + bVar.b);
        final com.ironsource.sdk.g.c a2 = this.e.a(d.e.c, bVar.b);
        if (a2 != null) {
            this.a.a((Runnable) new Runnable() {
                public final void run() {
                    b.this.a.b(a2, map, b.this);
                }
            });
        }
    }

    public final void b(d.e eVar, String str) {
        com.ironsource.sdk.j.b b2;
        com.ironsource.sdk.g.c d2 = d(eVar, str);
        if (d2 != null && eVar != d.e.RewardedVideo) {
            if (eVar == d.e.c) {
                com.ironsource.sdk.j.c a2 = a(d2);
                if (a2 != null) {
                    a2.onInterstitialClick();
                }
            } else if (eVar == d.e.a && (b2 = b(d2)) != null) {
                b2.onBannerClick();
            }
        }
    }

    public final void b(String str) {
        com.ironsource.sdk.g.c d2 = d(d.e.c, str);
        com.ironsource.sdk.a.a a2 = new com.ironsource.sdk.a.a().a("demandsourcename", str);
        if (d2 != null) {
            com.ironsource.sdk.a.a a3 = a2.a("producttype", com.ironsource.sdk.a.g.a(d2, d.e.c)).a("isbiddinginstance", Boolean.valueOf(com.ironsource.sdk.a.g.a(d2)));
            com.ironsource.sdk.service.a aVar = com.ironsource.sdk.service.a.a;
            a3.a("custom_c", Long.valueOf(com.ironsource.sdk.service.a.c(d2.b)));
            com.ironsource.sdk.service.a aVar2 = com.ironsource.sdk.service.a.a;
            com.ironsource.sdk.service.a.b(d2.b);
            com.ironsource.sdk.j.c a4 = a(d2);
            if (a4 != null) {
                a4.onInterstitialLoadSuccess();
            }
        }
        com.ironsource.sdk.a.f.a(h.l, (Map<String, Object>) a2.a);
    }

    public final void b(String str, int i2) {
        com.ironsource.sdk.g.c d2 = d(d.e.c, str);
        com.ironsource.sdk.j.c a2 = a(d2);
        if (d2 != null && a2 != null) {
            a2.onInterstitialAdRewarded(str, i2);
        }
    }

    public final void b(String str, String str2) {
        com.ironsource.sdk.g.c d2 = d(d.e.c, str);
        com.ironsource.sdk.a.a aVar = new com.ironsource.sdk.a.a();
        aVar.a("callfailreason", str2).a("demandsourcename", str);
        if (d2 != null) {
            com.ironsource.sdk.a.a a2 = aVar.a("producttype", com.ironsource.sdk.a.g.a(d2, d.e.c)).a("generalmessage", d2.e == 2 ? com.ironsource.sdk.f.b.a : com.ironsource.sdk.f.b.b).a("isbiddinginstance", Boolean.valueOf(com.ironsource.sdk.a.g.a(d2)));
            com.ironsource.sdk.service.a aVar2 = com.ironsource.sdk.service.a.a;
            a2.a("custom_c", Long.valueOf(com.ironsource.sdk.service.a.c(d2.b)));
            com.ironsource.sdk.service.a aVar3 = com.ironsource.sdk.service.a.a;
            com.ironsource.sdk.service.a.b(d2.b);
            com.ironsource.sdk.j.c a3 = a(d2);
            if (a3 != null) {
                a3.onInterstitialLoadFailed(str2);
            }
        }
        com.ironsource.sdk.a.f.a(h.g, (Map<String, Object>) aVar.a);
    }

    public final boolean b(com.ironsource.sdk.b bVar) {
        Logger.d("IronSourceAdsPublisherAgent", "isAdAvailable " + bVar.b);
        com.ironsource.sdk.g.c a2 = this.e.a(d.e.c, bVar.b);
        if (a2 == null) {
            return false;
        }
        return a2.f;
    }

    public final void c(Activity activity) {
        if (!this.k) {
            e(activity);
        }
    }

    public final void c(d.e eVar, String str) {
        com.ironsource.sdk.g.c d2 = d(eVar, str);
        if (d2 == null) {
            return;
        }
        if (eVar == d.e.c) {
            com.ironsource.sdk.j.c a2 = a(d2);
            if (a2 != null) {
                a2.onInterstitialOpen();
                return;
            }
            return;
        }
        d.e eVar2 = d.e.RewardedVideo;
    }

    public final void c(String str) {
        com.ironsource.sdk.j.c a2;
        com.ironsource.sdk.g.c d2 = d(d.e.c, str);
        if (d2 != null && (a2 = a(d2)) != null) {
            a2.onInterstitialShowSuccess();
        }
    }

    public final void c(String str, String str2) {
        com.ironsource.sdk.j.c a2;
        com.ironsource.sdk.g.c d2 = d(d.e.c, str);
        if (d2 != null && (a2 = a(d2)) != null) {
            a2.onInterstitialShowFailed(str2);
        }
    }

    public final void d(Activity activity) {
        try {
            this.a.e();
            this.a.b((Context) activity);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void d(String str, String str2) {
        com.ironsource.sdk.j.b b2;
        com.ironsource.sdk.g.c d2 = d(d.e.a, str);
        if (d2 != null && (b2 = b(d2)) != null) {
            b2.onBannerLoadFail(str2);
        }
    }

    public final void e(Activity activity) {
        this.l.a(activity);
        this.a.d();
        this.a.a((Context) activity);
    }
}
