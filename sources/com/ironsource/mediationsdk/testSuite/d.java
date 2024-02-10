package com.ironsource.mediationsdk.testSuite;

import android.app.Activity;
import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import com.ironsource.environment.c.a;
import com.ironsource.environment.h;
import com.ironsource.mediationsdk.C0213c;
import com.ironsource.mediationsdk.C0222l;
import com.ironsource.mediationsdk.C0231u;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.P;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.events.i;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.c;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020 J\u0018\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060#0\"J\u0010\u0010$\u001a\u00020\u00062\b\u0010%\u001a\u0004\u0018\u00010&J\u000e\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)J\u0016\u0010*\u001a\u00020 2\u0006\u0010(\u001a\u00020)2\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020 J\u0006\u0010.\u001a\u00020 J\u0010\u0010/\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\tJ\u0006\u00100\u001a\u00020\u0014J\u0006\u00101\u001a\u00020\u0014J\u000e\u00102\u001a\u00020\u00142\u0006\u00103\u001a\u00020\u0006J\u0016\u00104\u001a\u00020\u00142\u0006\u00105\u001a\u00020\u00112\u0006\u00106\u001a\u00020\u0004J\u0006\u00107\u001a\u00020\u0014J\u0016\u00108\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,2\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010=J\u0010\u0010>\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010?J\u0010\u0010@\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010AJ\u0010\u0010B\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010C\u001a\u00020\u00142\b\u0010\n\u001a\u0004\u0018\u00010\u000b¨\u0006D"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/TestSuiteMediationSdkProxy;", "", "()V", "createAdapterJson", "Lorg/json/JSONObject;", "adapterVersion", "", "sdkVersion", "createBanner", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", "activity", "Landroid/app/Activity;", "size", "Lcom/ironsource/mediationsdk/ISBannerSize;", "createISBannerSize", "description", "width", "", "height", "destroyBanner", "", "banner", "getAppName", "context", "Landroid/content/Context;", "getAppVersion", "getBundleId", "getDeviceDisplayHeight", "getGeneralProperties", "getInstalledAdaptersData", "getMediationAdditionalData", "isDemandOnlyMode", "", "getMetaDataJson", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getPlacementName", "placement", "Lcom/ironsource/mediationsdk/model/Placement;", "getProviderDefaultInstance", "networkSettings", "Lcom/ironsource/mediationsdk/model/NetworkSettings;", "isBidder", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "isInterstitialReady", "isRewardedVideoReady", "loadBanner", "loadInterstitial", "loadRewardedVideo", "logInternalError", "message", "logMediaitonEvent", "eventId", "data", "onTestSuiteClosed", "setTestSuiteAdLoadConfig", "loadAdConfig", "Lcom/ironsource/mediationsdk/testSuite/TestSuiteLoadAdConfig;", "setTestSuiteBannerLevelPlayListener", "listener", "Lcom/ironsource/mediationsdk/sdk/LevelPlayBannerListener;", "setTestSuiteInterstitialLevelPlayListener", "Lcom/ironsource/mediationsdk/sdk/LevelPlayInterstitialListener;", "setTestSuiteRewardedVideoLevelPlayListener", "Lcom/ironsource/mediationsdk/sdk/LevelPlayRewardedVideoBaseListener;", "showInterstitial", "showRewardedVideoAd", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {
    public static final d a = new d();

    private d() {
    }

    public static ISBannerSize a(String str, int i, int i2) {
        return new ISBannerSize(str, i, i2);
    }

    public static IronSourceBannerLayout a(Activity activity, ISBannerSize iSBannerSize) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iSBannerSize, "size");
        IronSourceBannerLayout a2 = z.a().a(activity, iSBannerSize);
        Intrinsics.checkNotNullExpressionValue(a2, "getInstance().createBanner(activity, size)");
        return a2;
    }

    public static String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getPackageName();
    }

    public static String a(NetworkSettings networkSettings) {
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
        String providerDefaultInstance = networkSettings.getProviderDefaultInstance();
        return providerDefaultInstance == null ? new String() : providerDefaultInstance;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r0.getPlacementName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(com.ironsource.mediationsdk.model.Placement r0) {
        /*
            if (r0 == 0) goto L_0x0008
            java.lang.String r0 = r0.getPlacementName()
            if (r0 != 0) goto L_0x000d
        L_0x0008:
            java.lang.String r0 = new java.lang.String
            r0.<init>()
        L_0x000d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.testSuite.d.a(com.ironsource.mediationsdk.model.Placement):java.lang.String");
    }

    public static JSONObject a() {
        JSONObject b = c.a().b();
        Intrinsics.checkNotNullExpressionValue(b, "getProperties().toJSON()");
        return b;
    }

    public static JSONObject a(boolean z) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(false);
        Intrinsics.checkNotNullExpressionValue(mediationAdditionalData, "getMediationAdditionalData(isDemandOnlyMode)");
        return mediationAdditionalData;
    }

    public static void a(int i, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "data");
        i.d().a(new a(i, jSONObject));
    }

    public static void a(Activity activity) {
        if (activity != null) {
            IronSource.showInterstitial(activity);
        } else {
            IronSource.showInterstitial();
        }
    }

    public static void a(IronSource.AD_UNIT ad_unit, c cVar) {
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        Intrinsics.checkNotNullParameter(cVar, "loadAdConfig");
        z a2 = z.a();
        if (a2.O) {
            if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL && a2.A != null) {
                a2.A.a(cVar);
            }
            if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO && a2.B != null) {
                a2.B.a(cVar);
            }
            if (ad_unit == IronSource.AD_UNIT.BANNER && a2.C != null) {
                a2.C.a(cVar);
            }
        }
    }

    public static void a(IronSourceBannerLayout ironSourceBannerLayout) {
        IronSource.loadBanner(ironSourceBannerLayout);
    }

    public static void a(LevelPlayBannerListener levelPlayBannerListener) {
        C0222l.a().c = levelPlayBannerListener;
    }

    public static void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        C0231u.a().b(levelPlayInterstitialListener);
    }

    public static void a(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        P.a().c = levelPlayRewardedVideoBaseListener;
    }

    public static void a(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        IronLog.INTERNAL.error(str);
    }

    public static boolean a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        Intrinsics.checkNotNullParameter(networkSettings, "networkSettings");
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        return networkSettings.isBidder(ad_unit);
    }

    public static ConcurrentHashMap<String, List<String>> b() {
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.putAll(C0213c.a().d);
        concurrentHashMap.putAll(com.ironsource.mediationsdk.d.c.a().c());
        return concurrentHashMap;
    }

    public static void b(Activity activity) {
        if (activity != null) {
            IronSource.showRewardedVideo(activity);
        } else {
            IronSource.showRewardedVideo();
        }
    }

    public static void b(IronSourceBannerLayout ironSourceBannerLayout) {
        IronSource.destroyBanner(ironSourceBannerLayout);
    }

    public static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            ConcurrentHashMap<String, AdapterBaseWrapper> concurrentHashMap = C0213c.a().a;
            Intrinsics.checkNotNullExpressionValue(concurrentHashMap, "networkAdaptersMap");
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (((AdapterBaseWrapper) entry.getValue()).getAdapterBaseInterface() != null) {
                    AdapterBaseInterface adapterBaseInterface = ((AdapterBaseWrapper) entry.getValue()).getAdapterBaseInterface();
                    Intrinsics.checkNotNullExpressionValue(adapterBaseInterface, "entry.value.adapterBaseInterface");
                    String adapterVersion = adapterBaseInterface.getAdapterVersion();
                    Intrinsics.checkNotNullExpressionValue(adapterVersion, "adapterBaseInterface.adapterVersion");
                    jSONObject.putOpt((String) entry.getKey(), new JSONObject(MapsKt.mapOf(TuplesKt.to("adapterVersion", adapterVersion), TuplesKt.to("sdkVersion", adapterBaseInterface.getNetworkSDKVersion()))));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static int d() {
        return h.l();
    }

    public static void e() {
        z a2 = z.a();
        if (a2.A != null) {
            a2.A.a((c) null);
        }
        if (a2.B != null) {
            a2.B.a((c) null);
        }
        if (a2.C != null) {
            a2.C.a((c) null);
        }
        a2.O = false;
    }

    public static void f() {
        IronSource.loadInterstitial();
    }

    public static boolean g() {
        return IronSource.isInterstitialReady();
    }

    public static void h() {
        IronSource.loadRewardedVideo();
    }

    public static boolean i() {
        return IronSource.isRewardedVideoAvailable();
    }
}
