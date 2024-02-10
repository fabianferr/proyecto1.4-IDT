package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.C0224n;
import com.ironsource.mediationsdk.E;
import com.ironsource.mediationsdk.I;
import com.ironsource.mediationsdk.d.b;
import com.ironsource.mediationsdk.d.c;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.events.e;
import com.ironsource.mediationsdk.events.h;
import com.ironsource.mediationsdk.events.i;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.l;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.OfferwallListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.testSuite.b.a;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class IronSource {

    public enum AD_UNIT {
        REWARDED_VIDEO("rewardedVideo"),
        INTERSTITIAL(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE),
        OFFERWALL("offerwall"),
        BANNER("banner"),
        NATIVE_AD("nativeAd");
        
        private String a;

        private AD_UNIT(String str) {
            this.a = str;
        }

        public final String toString() {
            return this.a;
        }
    }

    public static void addImpressionDataListener(ImpressionDataListener impressionDataListener) {
        z a = z.a();
        if (b.a((Object) impressionDataListener, "addImpressionDataListener - listener is null")) {
            c.a().a(impressionDataListener);
            if (a.x != null) {
                a.x.a(impressionDataListener);
            }
            if (a.y != null) {
                a.y.a(impressionDataListener);
            }
            if (a.z != null) {
                a.z.a(impressionDataListener);
            }
            IronLog ironLog = IronLog.API;
            ironLog.info("add impression data listener to " + impressionDataListener.getClass().getSimpleName());
        }
    }

    public static void clearRewardedVideoServerParameters() {
        z.a().j = null;
    }

    public static IronSourceBannerLayout createBanner(Activity activity, ISBannerSize iSBannerSize) {
        return z.a().a(activity, iSBannerSize);
    }

    public static ISDemandOnlyBannerLayout createBannerForDemandOnly(Activity activity, ISBannerSize iSBannerSize) {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, "createBannerForDemandOnly()", 1);
        if (activity == null) {
            a.c.log(IronSourceLogger.IronSourceTag.API, "createBannerForDemandOnly() : Activity cannot be null", 3);
            return null;
        }
        ContextProvider.getInstance().updateActivity(activity);
        return new ISDemandOnlyBannerLayout(activity, iSBannerSize);
    }

    public static void destroyBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            if (a.I && a.C != null) {
                a.C.a(ironSourceBannerLayout);
            } else if (a.z != null) {
                I i = a.z;
                IronLog.INTERNAL.verbose();
                I.AnonymousClass2 r2 = new C0224n.a(ironSourceBannerLayout) {
                    private /* synthetic */ IronSourceBannerLayout a;

                    {
                        this.a = r2;
                    }

                    public final void a() {
                        IronLog.INTERNAL.verbose("destroying banner");
                        I.this.e.a();
                        I.this.a((int) IronSourceConstants.BN_DESTROY, (Object[][]) null, I.this.h != null ? I.this.h.p() : I.this.i);
                        I i = I.this;
                        if (i.h != null) {
                            IronLog ironLog = IronLog.INTERNAL;
                            ironLog.verbose("mActiveSmash = " + i.h.s());
                            i.h.a();
                            i.h = null;
                        }
                        this.a.a();
                        I.this.f = null;
                        I.this.g = null;
                        I.this.a(a.READY_TO_LOAD);
                    }

                    public final void a(String str) {
                        IronLog ironLog = IronLog.API;
                        ironLog.error("destroy banner failed - errorMessage = " + str);
                    }
                };
                if (ironSourceBannerLayout != null) {
                    if (!ironSourceBannerLayout.isDestroyed()) {
                        r2.a();
                        return;
                    }
                }
                Object[] objArr = new Object[1];
                objArr[0] = ironSourceBannerLayout == null ? "banner is null" : "banner is destroyed";
                r2.a(String.format("can't destroy banner - %s", objArr));
            }
        } catch (Throwable th) {
            a.c.logException(IronSourceLogger.IronSourceTag.API, "destroyBanner()", th);
        }
    }

    public static void destroyISDemandOnlyBanner(String str) {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, "destroyBanner()", 1);
        try {
            if (a.L != null) {
                a.L.a(str);
            }
        } catch (Throwable th) {
            a.c.logException(IronSourceLogger.IronSourceTag.API, "destroyISDemandOnlyBanner()", th);
        }
    }

    public static String getAdvertiserId(Context context) {
        z.a();
        return z.a(context);
    }

    public static synchronized String getISDemandOnlyBiddingData(Context context) {
        String b;
        synchronized (IronSource.class) {
            b = z.a().b(context);
        }
        return b;
    }

    public static InterstitialPlacement getInterstitialPlacementInfo(String str) {
        return z.a().i(str);
    }

    @Deprecated
    public static void getOfferwallCredits() {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, "getOfferwallCredits()", 1);
        try {
            H h = a.b;
            if (h.a != null) {
                h.a.getOfferwallCredits();
            }
        } catch (Throwable th) {
            a.c.logException(IronSourceLogger.IronSourceTag.API, "getOfferwallCredits()", th);
        }
    }

    public static Placement getRewardedVideoPlacementInfo(String str) {
        return z.a().j(str);
    }

    public static void init(Context context, String str) {
        init(context, str, (AD_UNIT[]) null);
    }

    public static void init(Context context, String str, InitializationListener initializationListener) {
        init(context, str, initializationListener, (AD_UNIT[]) null);
    }

    public static void init(Context context, String str, InitializationListener initializationListener, AD_UNIT... ad_unitArr) {
        z.a().a(context, str, false, initializationListener, ad_unitArr);
    }

    public static void init(Context context, String str, AD_UNIT... ad_unitArr) {
        z.a().a(context, str, false, (InitializationListener) null, ad_unitArr);
    }

    public static void initISDemandOnly(Context context, String str, AD_UNIT... ad_unitArr) {
        z.a().a(context, str, ad_unitArr);
    }

    public static boolean isBannerPlacementCapped(String str) {
        return z.a().l(str);
    }

    public static boolean isISDemandOnlyInterstitialReady(String str) {
        return z.a().g(str);
    }

    public static boolean isISDemandOnlyRewardedVideoAvailable(String str) {
        return z.a().f(str);
    }

    public static boolean isInterstitialPlacementCapped(String str) {
        return z.a().k(str);
    }

    public static boolean isInterstitialReady() {
        return z.a().f();
    }

    @Deprecated
    public static boolean isOfferwallAvailable() {
        return z.a().i();
    }

    public static boolean isRewardedVideoAvailable() {
        return z.a().d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.ironsource.mediationsdk.z.AnonymousClass2.c[r1 - 1];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isRewardedVideoPlacementCapped(java.lang.String r7) {
        /*
            com.ironsource.mediationsdk.z r0 = com.ironsource.mediationsdk.z.a()
            int r1 = r0.m(r7)
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x001c
            int[] r5 = com.ironsource.mediationsdk.z.AnonymousClass2.c
            int r1 = r1 - r3
            r1 = r5[r1]
            if (r1 == r3) goto L_0x001a
            if (r1 == r2) goto L_0x001a
            r5 = 3
            if (r1 == r5) goto L_0x001a
            goto L_0x001c
        L_0x001a:
            r1 = 1
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            if (r1 == 0) goto L_0x003d
            boolean r5 = r0.r
            int r0 = r0.J
            org.json.JSONObject r0 = com.ironsource.mediationsdk.utils.IronSourceUtils.getMediationAdditionalData(r5, r3, r0)
            if (r7 == 0) goto L_0x0038
            java.lang.Object[][] r5 = new java.lang.Object[r3][]
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r6 = "placement"
            r2[r4] = r6
            r2[r3] = r7
            r5[r4] = r2
            com.ironsource.mediationsdk.z.a((org.json.JSONObject) r0, (java.lang.Object[][]) r5)
        L_0x0038:
            r7 = 1110(0x456, float:1.555E-42)
            com.ironsource.mediationsdk.z.a((int) r7, (org.json.JSONObject) r0)
        L_0x003d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.IronSource.isRewardedVideoPlacementCapped(java.lang.String):boolean");
    }

    public static void launchTestSuite(Context context) {
        z a = z.a();
        a.a.a();
        if (!a.l) {
            a.a.a(IronSourceConstants.errorCode_TEST_SUITE_SDK_NOT_INITIALIZED);
            IronLog.API.error("TestSuite cannot be launched, SDK not initialized");
        } else if (!z.a(a.f)) {
            a.a.a(IronSourceConstants.errorCode_TEST_SUITE_DISABLED);
            IronLog.API.error("TestSuite cannot be launched, Please contact your account manager to enable it");
        } else if (!IronSourceUtils.isNetworkConnected(context)) {
            a.a.a(IronSourceConstants.errorCode_TEST_SUITE_NO_NETWORK_CONNECTIVITY);
            IronLog.API.error("TestSuite cannot be launched, No network connectivity");
        } else {
            if (a.A != null) {
                a.A.o();
            }
            if (a.B != null) {
                a.B.o();
            }
            if (a.C != null) {
                a.C.o();
                com.ironsource.mediationsdk.adunit.c.b bVar = a.C;
                if (bVar.a != null) {
                    bVar.a(bVar.a);
                }
            }
            new com.ironsource.mediationsdk.testSuite.b().a(context, a.g, a.f.d, IronSourceUtils.getSDKVersion(), a.f.c.g().a(), a.w, a.D);
            a.O = true;
            a.a.b();
        }
    }

    public static void loadBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        z.a().a(ironSourceBannerLayout, "");
    }

    public static void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        z.a().a(ironSourceBannerLayout, str);
    }

    public static void loadISDemandOnlyBanner(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        z.a().a(activity, iSDemandOnlyBannerLayout, str);
    }

    public static void loadISDemandOnlyBannerWithAdm(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str, String str2) {
        z.a().a(activity, iSDemandOnlyBannerLayout, str, str2);
    }

    public static void loadISDemandOnlyInterstitial(Activity activity, String str) {
        z.a().c(activity, str);
    }

    public static void loadISDemandOnlyInterstitialWithAdm(Activity activity, String str, String str2) {
        z.a().c(activity, str, str2);
    }

    public static void loadISDemandOnlyRewardedVideo(Activity activity, String str) {
        z.a().b(activity, str, (String) null);
    }

    public static void loadISDemandOnlyRewardedVideoWithAdm(Activity activity, String str, String str2) {
        z.a().a(activity, str, str2);
    }

    public static void loadInterstitial() {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", 1);
        try {
            if (a.s) {
                a.c.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", 3);
                C0227q.a().a(AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("Interstitial was initialized in demand only mode. Use loadISDemandOnlyInterstitial instead", IronSourceConstants.INTERSTITIAL_AD_UNIT));
            } else if (!a.u) {
                a.c.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadInterstitial()", 3);
                C0227q.a().a(AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() must be called before loadInterstitial()", IronSourceConstants.INTERSTITIAL_AD_UNIT));
            } else {
                E.a b = E.a().b();
                if (b == E.a.INIT_FAILED) {
                    a.c.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    C0227q.a().a(AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
                } else if (b == E.a.INIT_IN_PROGRESS) {
                    if (E.a().c()) {
                        a.c.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                        C0227q.a().a(AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.INTERSTITIAL_AD_UNIT));
                        return;
                    }
                    a.H = true;
                } else if (!a.g()) {
                    a.c.log(IronSourceLogger.IronSourceTag.API, "No interstitial configurations found", 3);
                    C0227q.a().a(AD_UNIT.INTERSTITIAL, ErrorBuilder.buildInitFailedError("the server response does not contain interstitial data", IronSourceConstants.INTERSTITIAL_AD_UNIT));
                } else {
                    if (a.G) {
                        if (a.A != null) {
                            a.A.i();
                            return;
                        }
                    } else if (a.y != null) {
                        a.y.d();
                        return;
                    }
                    a.H = true;
                }
            }
        } catch (Throwable th) {
            a.c.logException(IronSourceLogger.IronSourceTag.API, "loadInterstitial()", th);
            C0227q.a().a(AD_UNIT.INTERSTITIAL, new IronSourceError(510, th.getMessage()));
        }
    }

    public static void loadRewardedVideo() {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, "loadRewardedVideo()", 1);
        try {
            if (a.r) {
                a.c.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", 3);
                C0227q.a().a(AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("Rewarded Video was initialized in demand only mode. Use loadISDemandOnlyRewardedVideo instead", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else if (!a.D && !a.O) {
                a.c.log(IronSourceLogger.IronSourceTag.API, "Rewarded Video is not initiated with manual load", 3);
            } else if (!a.t) {
                a.c.log(IronSourceLogger.IronSourceTag.API, "init() must be called before loadRewardedVideo()", 3);
                C0227q.a().a(AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() must be called before loadRewardedVideo()", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                E.a b = E.a().b();
                if (b == E.a.INIT_FAILED) {
                    a.c.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                    C0227q.a().a(AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                } else if (b == E.a.INIT_IN_PROGRESS) {
                    if (E.a().c()) {
                        a.c.log(IronSourceLogger.IronSourceTag.API, "init() had failed", 3);
                        C0227q.a().a(AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("init() had failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                        return;
                    }
                    a.E = true;
                } else if (!a.e()) {
                    a.c.log(IronSourceLogger.IronSourceTag.API, "No rewarded video configurations found", 3);
                    C0227q.a().a(AD_UNIT.REWARDED_VIDEO, ErrorBuilder.buildInitFailedError("the server response does not contain rewarded video data", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                } else if (a.B == null) {
                    a.E = true;
                } else {
                    a.B.i();
                }
            }
        } catch (Throwable th) {
            a.c.logException(IronSourceLogger.IronSourceTag.API, "loadRewardedVideo()", th);
            C0227q.a().a(AD_UNIT.REWARDED_VIDEO, new IronSourceError(510, th.getMessage()));
        }
    }

    public static void onPause(Activity activity) {
        z a = z.a();
        try {
            a.c.log(IronSourceLogger.IronSourceTag.API, "onPause()", 1);
            ContextProvider.getInstance().onPause(activity);
        } catch (Throwable th) {
            a.c.logException(IronSourceLogger.IronSourceTag.API, "onPause()", th);
        }
    }

    public static void onResume(Activity activity) {
        z a = z.a();
        try {
            a.c.log(IronSourceLogger.IronSourceTag.API, "onResume()", 1);
            ContextProvider.getInstance().onResume(activity);
        } catch (Throwable th) {
            a.c.logException(IronSourceLogger.IronSourceTag.API, "onResume()", th);
        }
    }

    public static void removeImpressionDataListener(ImpressionDataListener impressionDataListener) {
        z a = z.a();
        if (b.a((Object) impressionDataListener, "removeImpressionDataListener - listener is null")) {
            c.a().b(impressionDataListener);
            if (a.x != null) {
                a.x.b(impressionDataListener);
            }
            if (a.y != null) {
                a.y.b(impressionDataListener);
            }
            if (a.z != null) {
                a.z.b(impressionDataListener);
            }
            IronLog ironLog = IronLog.API;
            ironLog.info("remove impression data listener from " + impressionDataListener.getClass().getSimpleName());
        }
    }

    public static void removeInterstitialListener() {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, "removeInterstitialListener()", 1);
        a.d.b = null;
        C0231u.a().a((InterstitialListener) null);
        C0231u.a().a((LevelPlayInterstitialListener) null);
    }

    @Deprecated
    public static void removeOfferwallListener() {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, "removeOfferwallListener()", 1);
        a.d.c = null;
    }

    public static void removeRewardedVideoListener() {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, "removeRewardedVideoListener()", 1);
        a.d.a = null;
        P.a().a = null;
        P.a().b = null;
    }

    public static void setAdRevenueData(String str, JSONObject jSONObject) {
        z a = z.a();
        if (b.a((Object) jSONObject, "setAdRevenueData - impressionData is null") && b.a((Object) str, "setAdRevenueData - dataSource is null")) {
            a.M.a(str, jSONObject);
        }
    }

    public static void setAdaptersDebug(boolean z) {
        z.a();
        z.a(z);
    }

    public static void setConsent(boolean z) {
        z.a().b(z);
    }

    public static boolean setDynamicUserId(String str) {
        return z.a().c(str);
    }

    public static void setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        z.a().Q.a(iSDemandOnlyInterstitialListener);
    }

    public static void setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        z.a();
        z.a(iSDemandOnlyRewardedVideoListener);
    }

    @Deprecated
    public static void setInterstitialListener(InterstitialListener interstitialListener) {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, interstitialListener == null ? "setInterstitialListener(ISListener:null)" : "setInterstitialListener(ISListener)", 1);
        a.d.b = interstitialListener;
        C0231u.a().a(interstitialListener);
    }

    public static void setLevelPlayInterstitialListener(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        z.a();
        z.a(levelPlayInterstitialListener);
    }

    public static void setLevelPlayRewardedVideoListener(LevelPlayRewardedVideoListener levelPlayRewardedVideoListener) {
        z.a();
        z.a(levelPlayRewardedVideoListener);
    }

    public static void setLevelPlayRewardedVideoManualListener(LevelPlayRewardedVideoManualListener levelPlayRewardedVideoManualListener) {
        z.a().a(levelPlayRewardedVideoManualListener);
    }

    public static void setLogListener(LogListener logListener) {
        z a = z.a();
        if (logListener == null) {
            a.c.log(IronSourceLogger.IronSourceTag.API, "setLogListener(LogListener:null)", 1);
            return;
        }
        a.e.c = logListener;
        IronSourceLoggerManager ironSourceLoggerManager = a.c;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "setLogListener(LogListener:" + logListener.getClass().getSimpleName() + ")", 1);
    }

    public static void setManualLoadRewardedVideo(RewardedVideoManualListener rewardedVideoManualListener) {
        z.a().a(rewardedVideoManualListener);
    }

    public static void setMediationType(String str) {
        z.a().d(str);
    }

    public static void setMetaData(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        z.a().a(str, (List<String>) arrayList);
    }

    public static void setMetaData(String str, List<String> list) {
        z.a().a(str, list);
    }

    public static void setNetworkData(String str, JSONObject jSONObject) {
        z.a();
        z.a(str, jSONObject);
    }

    @Deprecated
    public static void setOfferwallListener(OfferwallListener offerwallListener) {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, offerwallListener == null ? "setOfferwallListener(OWListener:null)" : "setOfferwallListener(OWListener)", 1);
        a.d.c = offerwallListener;
    }

    @Deprecated
    public static void setRewardedVideoListener(RewardedVideoListener rewardedVideoListener) {
        z a = z.a();
        a.c.log(IronSourceLogger.IronSourceTag.API, rewardedVideoListener == null ? "setRewardedVideoListener(RVListener:null)" : "setRewardedVideoListener(RVListener)", 1);
        a.d.a = rewardedVideoListener;
        P.a().a = rewardedVideoListener;
    }

    public static void setRewardedVideoServerParameters(Map<String, String> map) {
        z a = z.a();
        if (map != null) {
            try {
                if (map.size() != 0) {
                    a.c.log(IronSourceLogger.IronSourceTag.API, a.a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", 1);
                    a.j = new HashMap(map);
                }
            } catch (Exception e) {
                IronSourceLoggerManager ironSourceLoggerManager = a.c;
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
                ironSourceLoggerManager.logException(ironSourceTag, a.a + ":setRewardedVideoServerParameters(params:" + map.toString() + ")", e);
            }
        }
    }

    public static void setSegment(IronSourceSegment ironSourceSegment) {
        z a = z.a();
        a.p = ironSourceSegment;
        if (a.B != null) {
            a.B.a(ironSourceSegment);
        }
        if (a.x != null) {
            a.x.a(ironSourceSegment);
        }
        if (a.A != null) {
            a.A.a(ironSourceSegment);
        }
        if (a.y != null) {
            a.y.a(ironSourceSegment);
        }
        if (a.z != null) {
            a.z.a(ironSourceSegment);
        }
        if (a.C != null) {
            a.C.a(ironSourceSegment);
        }
        if (a.P != null) {
            a.P.setSegment(ironSourceSegment);
        }
        e.d().w = a.p;
        i.d().w = a.p;
        h.x.w = a.p;
    }

    public static void setSegmentListener(SegmentListener segmentListener) {
        z a = z.a();
        if (a.d != null) {
            a.d.d = segmentListener;
            E.a().o = a.d;
        }
    }

    public static void setUserId(String str) {
        z a = z.a();
        IronLog ironLog = IronLog.API;
        ironLog.verbose("userId = " + str);
        a.h = str;
        i.d().a(new com.ironsource.environment.c.a(52, IronSourceUtils.getJsonForUserId(false)));
        if (a.P != null) {
            a.P.changeUserId(str);
        }
    }

    public static void setWaterfallConfiguration(WaterfallConfiguration waterfallConfiguration, AD_UNIT ad_unit) {
        z a = z.a();
        if (ad_unit == null) {
            IronLog.API.error("AdUnit should not be null.");
            return;
        }
        IronLog ironLog = IronLog.API;
        Object[] objArr = new Object[2];
        objArr[0] = ad_unit.name();
        objArr[1] = waterfallConfiguration == null ? "NULL" : waterfallConfiguration.toString();
        ironLog.info(String.format("(%s, %s)", objArr));
        com.ironsource.environment.c.a aVar = new com.ironsource.environment.c.a(53, IronSourceUtils.getMediationAdditionalData(false));
        aVar.a(IronSourceConstants.EVENTS_EXT1, waterfallConfiguration == null ? "" : waterfallConfiguration.toJsonString());
        i.d().a(aVar, ad_unit);
        a.N.a(ad_unit, waterfallConfiguration);
    }

    public static void shouldTrackNetworkState(Context context, boolean z) {
        z a = z.a();
        a.n = context;
        a.o = Boolean.valueOf(z);
        if (a.G) {
            if (a.A != null) {
                a.A.a(context, z);
            }
        } else if (a.y != null) {
            a.y.a(z);
        }
        if (a.F) {
            if (a.B != null) {
                a.B.a(context, z);
            }
        } else if (a.x != null) {
            a.x.a(context, z);
        }
    }

    public static void showISDemandOnlyInterstitial(String str) {
        z a = z.a();
        IronSourceLoggerManager ironSourceLoggerManager = a.c;
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.API;
        ironSourceLoggerManager.log(ironSourceTag, "showISDemandOnlyInterstitial() instanceId=" + str, 1);
        try {
            if (!a.s) {
                a.c.log(IronSourceLogger.IronSourceTag.API, "Interstitial was initialized in mediation mode. Use showInterstitial instead", 3);
            } else if (a.K == null) {
                a.c.log(IronSourceLogger.IronSourceTag.API, "Interstitial video was not initiated", 3);
                a.Q.a(str).onInterstitialAdShowFailed(str, new IronSourceError(508, "Interstitial video was not initiated"));
            } else {
                a.K.a(str);
            }
        } catch (Exception e) {
            a.c.logException(IronSourceLogger.IronSourceTag.API, "showISDemandOnlyInterstitial", e);
            a.Q.a(str).onInterstitialAdShowFailed(str, ErrorBuilder.buildInitFailedError("showISDemandOnlyInterstitial can't be called before the Interstitial ad unit initialization completed successfully", IronSourceConstants.INTERSTITIAL_AD_UNIT));
        }
    }

    public static void showISDemandOnlyRewardedVideo(String str) {
        z.a().e(str);
    }

    public static void showInterstitial() {
        z.a().b((Activity) null);
    }

    public static void showInterstitial(Activity activity) {
        z.a().b(activity);
    }

    public static void showInterstitial(Activity activity, String str) {
        z.a().b(activity, str);
    }

    public static void showInterstitial(String str) {
        z.a().b((Activity) null, str);
    }

    @Deprecated
    public static void showOfferwall() {
        z a = z.a();
        try {
            a.c.log(IronSourceLogger.IronSourceTag.API, "showOfferwall()", 1);
            if (!a.h()) {
                a.d.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
                return;
            }
            l a2 = a.f.c.c().a();
            if (a2 != null) {
                a.h(a2.getPlacementName());
            }
        } catch (Exception e) {
            a.c.logException(IronSourceLogger.IronSourceTag.API, "showOfferwall()", e);
            a.d.onOfferwallShowFailed(ErrorBuilder.buildInitFailedError("showOfferwall can't be called before the Offerwall ad unit initialization completed successfully", IronSourceConstants.OFFERWALL_AD_UNIT));
        }
    }

    @Deprecated
    public static void showOfferwall(String str) {
        z.a().h(str);
    }

    public static void showRewardedVideo() {
        z.a().a((Activity) null);
    }

    public static void showRewardedVideo(Activity activity) {
        z.a().a(activity);
    }

    public static void showRewardedVideo(Activity activity, String str) {
        z.a().a(activity, str);
    }

    public static void showRewardedVideo(String str) {
        z.a().a((Activity) null, str);
    }
}
