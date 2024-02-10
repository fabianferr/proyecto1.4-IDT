package com.ironsource.adapters.ironsource;

import android.app.Activity;
import android.text.TextUtils;
import com.facebook.internal.ServerProtocol;
import com.ironsource.adapters.ironsource.nativeAd.IronSourceNativeAdAdapter;
import com.ironsource.adapters.supersonicads.SupersonicConfig;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.C0215e;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.sdk.d;
import com.ironsource.mediationsdk.sdk.f;
import com.ironsource.mediationsdk.services.MediationServices;
import com.ironsource.mediationsdk.services.a;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.z;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.b;
import com.ironsource.sdk.c;
import com.ironsource.sdk.j.e;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class IronSourceAdapter extends AbstractAdapter implements ContextProvider.a, f, e {
    public static final String IRONSOURCE_BIDDING_TOKEN_KEY = "token";
    public static final String IRONSOURCE_ONE_FLOW_KEY = "isOneFlow";
    private static final int IS_LOAD_EXCEPTION = 1000;
    private static final int IS_SHOW_EXCEPTION = 1001;
    private static final int RV_LOAD_EXCEPTION = 1002;
    private static final int RV_SHOW_EXCEPTION = 1003;
    private static final String VERSION = "7.5.1";
    private static AtomicBoolean mDidInitSdk = new AtomicBoolean(false);
    public final String ADM_KEY = "adm";
    private final String DEMAND_SOURCE_NAME = "demandSourceName";
    private final String DYNAMIC_CONTROLLER_CONFIG = "controllerConfig";
    private final String DYNAMIC_CONTROLLER_DEBUG_MODE = "debugMode";
    private final String DYNAMIC_CONTROLLER_URL = "controllerUrl";
    private final String LWS_SUPPORT_STATE = "isSupportedLWS";
    private final String OW_CLIENT_SIDE_CALLBACKS = "useClientSideCallbacks";
    private final String OW_PLACEMENT_ID = "placementId";
    private final String SDK_PLUGIN_TYPE = "SDKPluginType";
    private final String SESSION_ID = "sessionid";
    final ConcurrentHashMap<String, BannerSmashListener> mDemandSourceToBNSmash = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, ArrayList<b>> mDemandSourceToBnAd = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, b> mDemandSourceToISAd = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, InterstitialSmashListener> mDemandSourceToISSmash = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, b> mDemandSourceToRvAd = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, RewardedVideoSmashListener> mDemandSourceToRvSmash = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public d mOfferwallListener;
    private final a sessionDepthService = MediationServices.getProvider().getSessionDepthService();

    private IronSourceAdapter(String str) {
        super(str);
        setNativeAdAdapter(new IronSourceNativeAdAdapter(this));
        ContextProvider.getInstance().registerLifeCycleListener(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0069, code lost:
        if (r8 != false) goto L_0x0070;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.ironsource.sdk.a convertBannerSize(android.content.Context r7, com.ironsource.mediationsdk.ISBannerSize r8) {
        /*
            r6 = this;
            java.lang.String r0 = r8.getDescription()
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = -1
            switch(r1) {
                case -387072689: goto L_0x003c;
                case 72205083: goto L_0x0031;
                case 79011241: goto L_0x0026;
                case 1951953708: goto L_0x001b;
                case 1999208305: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x0046
        L_0x0010:
            java.lang.String r1 = "CUSTOM"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0019
            goto L_0x0046
        L_0x0019:
            r2 = 4
            goto L_0x0046
        L_0x001b:
            java.lang.String r1 = "BANNER"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0024
            goto L_0x0046
        L_0x0024:
            r2 = 3
            goto L_0x0046
        L_0x0026:
            java.lang.String r1 = "SMART"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x002f
            goto L_0x0046
        L_0x002f:
            r2 = 2
            goto L_0x0046
        L_0x0031:
            java.lang.String r1 = "LARGE"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x003a
            goto L_0x0046
        L_0x003a:
            r2 = 1
            goto L_0x0046
        L_0x003c:
            java.lang.String r1 = "RECTANGLE"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0045
            goto L_0x0046
        L_0x0045:
            r2 = 0
        L_0x0046:
            r1 = 0
            r3 = 90
            r4 = 50
            r5 = 320(0x140, float:4.48E-43)
            switch(r2) {
                case 0: goto L_0x006c;
                case 1: goto L_0x0070;
                case 2: goto L_0x005f;
                case 3: goto L_0x005c;
                case 4: goto L_0x0051;
                default: goto L_0x0050;
            }
        L_0x0050:
            return r1
        L_0x0051:
            int r8 = r8.getHeight()
            if (r8 == r4) goto L_0x005a
            if (r8 == r3) goto L_0x005a
            return r1
        L_0x005a:
            r3 = r8
            goto L_0x0070
        L_0x005c:
            r3 = 50
            goto L_0x0070
        L_0x005f:
            boolean r8 = com.ironsource.mediationsdk.AdapterUtils.isLargeScreen(r7)
            if (r8 == 0) goto L_0x0069
            r1 = 728(0x2d8, float:1.02E-42)
            r5 = 728(0x2d8, float:1.02E-42)
        L_0x0069:
            if (r8 == 0) goto L_0x005c
            goto L_0x0070
        L_0x006c:
            r5 = 300(0x12c, float:4.2E-43)
            r3 = 250(0xfa, float:3.5E-43)
        L_0x0070:
            int r8 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r7, r5)
            int r7 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r7, r3)
            com.ironsource.sdk.a r1 = new com.ironsource.sdk.a
            r1.<init>(r8, r7, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.ironsource.IronSourceAdapter.convertBannerSize(android.content.Context, com.ironsource.mediationsdk.ISBannerSize):com.ironsource.sdk.a");
    }

    private b createBannerAdInstance(String str, com.ironsource.sdk.a aVar, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("creating banner ad instance for " + str);
        IronSourceBannerListener ironSourceBannerListener = new IronSourceBannerListener(this, bannerSmashListener, str);
        boolean optBoolean = jSONObject.optBoolean("isOneFlow");
        boolean z = jSONObject.optInt("instanceType", 2) == 2;
        c cVar = new c(str, ironSourceBannerListener);
        cVar.d = getInitParams();
        cVar.b = z;
        cVar.e = optBoolean;
        cVar.c = aVar;
        return cVar.a();
    }

    private HashMap<String, String> createBannerLoadParams(JSONObject jSONObject, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (str != null) {
            C0215e.a();
            hashMap.put("adm", C0215e.c(str));
            hashMap.put("isOneFlow", String.valueOf(jSONObject.optBoolean("isOneFlow")));
            C0215e.a();
            hashMap.putAll(C0215e.b(str));
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public HashMap<String, String> getOfferwallExtraParams() {
        HashMap<String, String> initParams = getInitParams();
        initParams.put("useClientSideCallbacks", String.valueOf(SupersonicConfig.getConfigObj().getClientSideCallbacks()));
        Map<String, String> offerwallCustomParams = SupersonicConfig.getConfigObj().getOfferwallCustomParams();
        if (offerwallCustomParams != null && !offerwallCustomParams.isEmpty()) {
            initParams.putAll(offerwallCustomParams);
        }
        return initParams;
    }

    private b getRewardedVideoAdInstance(String str, boolean z, boolean z2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        b bVar = this.mDemandSourceToRvAd.get(str);
        if (bVar != null) {
            return bVar;
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("creating ad instance for " + str + " isDemandOnly=" + z + " isBidder=" + z2);
        c cVar = new c(str, new IronSourceRewardedVideoListener(rewardedVideoSmashListener, str, z));
        cVar.d = getInitParams();
        cVar.a = true;
        cVar.b = z2;
        b a = cVar.a();
        this.mDemandSourceToRvAd.put(str, a);
        return a;
    }

    private void initInterstitialInternal(String str, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener, String str2) {
        initSDK(str, jSONObject);
        this.mDemandSourceToISSmash.put(str2, interstitialSmashListener);
        interstitialSmashListener.onInterstitialInitSuccess();
    }

    private void initRewardedVideoInternal(String str, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener, String str2) {
        initSDK(str, jSONObject);
        this.mDemandSourceToRvSmash.put(str2, rewardedVideoSmashListener);
    }

    private void loadBannerInternal(Activity activity, ISBannerSize iSBannerSize, JSONObject jSONObject, BannerSmashListener bannerSmashListener, String str) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("demandSourceName: " + demandSourceName);
        try {
            com.ironsource.sdk.a convertBannerSize = convertBannerSize(ContextProvider.getInstance().getApplicationContext(), iSBannerSize);
            if (convertBannerSize == null) {
                bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getProviderName()));
                return;
            }
            HashMap<String, String> createBannerLoadParams = createBannerLoadParams(jSONObject, str);
            printInstanceExtraParams(createBannerLoadParams);
            IronSourceNetwork.loadAdView(activity, createBannerAdInstance(demandSourceName, convertBannerSize, jSONObject, bannerSmashListener), createBannerLoadParams);
        } catch (Exception e) {
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + getProviderName() + " - " + e.getMessage()));
        }
    }

    private void loadInterstitialAdInternal(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        HashMap hashMap = new HashMap();
        if (str2 != null) {
            C0215e.a();
            hashMap.put("adm", C0215e.c(str2));
            C0215e.a();
            hashMap.putAll(C0215e.b(str2));
        }
        b bVar = this.mDemandSourceToISAd.get(str);
        if (bVar == null) {
            boolean optBoolean = jSONObject.optBoolean("isOneFlow");
            boolean z = jSONObject.optInt("instanceType", 2) == 2;
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("creating ad instance for " + str + " isBidder=" + z);
            c cVar = new c(str, new IronSourceInterstitialListener(interstitialSmashListener, str));
            cVar.d = getInitParams();
            cVar.e = optBoolean;
            cVar.b = z;
            bVar = cVar.a();
            this.mDemandSourceToISAd.put(str, bVar);
        }
        printInstanceExtraParams(hashMap);
        IronLog ironLog2 = IronLog.ADAPTER_API;
        ironLog2.verbose("demandSourceName=" + bVar.c);
        IronSourceNetwork.loadAd(bVar, hashMap);
    }

    private void loadRewardedVideoAdInternal(String str, String str2, boolean z, boolean z2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        HashMap hashMap = new HashMap();
        if (str2 != null) {
            C0215e.a();
            hashMap.put("adm", C0215e.c(str2));
            C0215e.a();
            hashMap.putAll(C0215e.b(str2));
        }
        b rewardedVideoAdInstance = getRewardedVideoAdInstance(str, z, z2, rewardedVideoSmashListener);
        printInstanceExtraParams(hashMap);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("demandSourceName=" + rewardedVideoAdInstance.c);
        IronSourceNetwork.loadAd(rewardedVideoAdInstance, hashMap);
    }

    private void printInstanceExtraParams(Map<String, String> map) {
        if (map != null && map.size() > 0) {
            IronLog.ADAPTER_API.verbose("instance extra params:");
            for (String next : map.keySet()) {
                IronLog ironLog = IronLog.ADAPTER_API;
                ironLog.verbose(next + "=" + map.get(next));
            }
        }
    }

    private void showAdInternal(b bVar, IronSource.AD_UNIT ad_unit) {
        int a = this.sessionDepthService.a(ad_unit);
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceConstants.KEY_SESSION_DEPTH, String.valueOf(a));
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("demandSourceName=" + bVar.c + " showParams=" + hashMap);
        IronSourceNetwork.showAd(ContextProvider.getInstance().getCurrentActiveActivity(), bVar, hashMap);
    }

    public static IronSourceAdapter startAdapter(String str) {
        return new IronSourceAdapter(str);
    }

    public void destroyBanner(JSONObject jSONObject) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(demandSourceName + ": destroyBanner()");
        ArrayList arrayList = this.mDemandSourceToBnAd.get(demandSourceName);
        if (arrayList != null) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    IronSourceNetwork.destroyAd((b) it.next());
                }
                this.mDemandSourceToBnAd.remove(demandSourceName);
            } catch (Exception e) {
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.verbose("destroyBanner failed: " + e.getMessage());
            }
        }
    }

    public void earlyInit(String str, String str2, JSONObject jSONObject) {
        if (z.a().g != null) {
            IronSourceUtils.sendAutomationLog(getDemandSourceName(jSONObject) + ": earlyInit");
            initSDK(z.a().g, jSONObject);
            return;
        }
        IronLog.ADAPTER_API.error("Appkey is null for early init");
    }

    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    public Map<String, Object> getBiddingData() {
        IronLog.ADAPTER_API.verbose();
        HashMap hashMap = new HashMap();
        String token = IronSourceNetwork.getToken(ContextProvider.getInstance().getApplicationContext());
        if (token == null) {
            IronLog.ADAPTER_API.error("bidding token is null");
            token = "";
        }
        hashMap.put(IRONSOURCE_BIDDING_TOKEN_KEY, token);
        return hashMap;
    }

    public String getCoreSDKVersion() {
        return SDKUtils.getSDKVersion();
    }

    public String getDemandSourceName(JSONObject jSONObject) {
        return !TextUtils.isEmpty(jSONObject.optString("demandSourceName")) ? jSONObject.optString("demandSourceName") : getProviderName();
    }

    public HashMap<String, String> getInitParams() {
        HashMap<String, String> hashMap = new HashMap<>();
        String pluginType = getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            hashMap.put("SDKPluginType", pluginType);
        }
        if (!TextUtils.isEmpty(z.a().m)) {
            hashMap.put("sessionid", z.a().m);
        }
        return hashMap;
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject jSONObject) {
        LoadWhileShowSupportState loadWhileShowSupportState = this.mLWSSupportState;
        return (jSONObject == null || !jSONObject.optBoolean("isSupportedLWS")) ? loadWhileShowSupportState : LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public void getOfferwallCredits() {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " getOfferwallCredits");
        try {
            IronSourceNetwork.getOfferWallCredits(this);
        } catch (Exception e) {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.error("exception " + e.getMessage());
        }
    }

    public JSONObject getPlayerBiddingData() {
        JSONObject jSONObject;
        IronLog.ADAPTER_API.verbose();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject = IronSourceNetwork.getRawToken(ContextProvider.getInstance().getApplicationContext());
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("getRawToken exception: " + e.getLocalizedMessage());
            jSONObject = null;
        }
        if (jSONObject != null) {
            return jSONObject;
        }
        IronLog.ADAPTER_API.error("Player's bidding token is null");
        return jSONObject2;
    }

    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    public String getVersion() {
        return "7.5.1";
    }

    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, rewardedVideoSmashListener, demandSourceName);
        loadRewardedVideo(jSONObject, jSONObject2, rewardedVideoSmashListener);
    }

    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("demandSourceName: " + demandSourceName);
        initSDK(str, jSONObject);
        this.mDemandSourceToBNSmash.put(demandSourceName, bannerSmashListener);
        bannerSmashListener.onBannerInitSuccess();
    }

    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initInterstitialInternal(str, jSONObject, interstitialSmashListener, demandSourceName);
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initInterstitialInternal(str, jSONObject, interstitialSmashListener, demandSourceName);
    }

    public void initOfferwall(String str, String str2, JSONObject jSONObject) {
        initSDK(str, jSONObject);
        IronLog.ADAPTER_API.verbose(":initOfferwall");
        postOnUIThread(new Runnable() {
            public void run() {
                try {
                    IronSourceNetwork.initOfferWall(IronSourceAdapter.this.getOfferwallExtraParams(), IronSourceAdapter.this);
                } catch (Exception e) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.error(IronSourceAdapter.this.getProviderName() + ":initOfferwall " + e);
                    d access$100 = IronSourceAdapter.this.mOfferwallListener;
                    access$100.a(false, ErrorBuilder.buildInitFailedError("Adapter initialization failure - " + IronSourceAdapter.this.getProviderName() + " - " + e.getMessage(), IronSourceConstants.OFFERWALL_AD_UNIT));
                }
            }
        });
    }

    public void initRewardedVideoForDemandOnly(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, rewardedVideoSmashListener, demandSourceName);
    }

    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(demandSourceName + ": demandSourceName=" + demandSourceName);
        initRewardedVideoInternal(str, jSONObject, rewardedVideoSmashListener, demandSourceName);
        rewardedVideoSmashListener.onRewardedVideoInitSuccess();
    }

    public void initSDK(String str, JSONObject jSONObject) {
        if (mDidInitSdk.compareAndSet(false, true)) {
            String mediationUserId = IronSourceUtils.getMediationUserId();
            int optInt = jSONObject.optInt("debugMode", 0);
            if (isAdaptersDebugEnabled()) {
                optInt = 3;
            }
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("setting debug mode to " + optInt);
            SDKUtils.setDebugMode(optInt);
            SDKUtils.setControllerUrl(jSONObject.optString("controllerUrl"));
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.verbose("IronSourceNetwork setting controller url to " + jSONObject.optString("controllerUrl"));
            JSONObject optJSONObject = jSONObject.optJSONObject("controllerConfig");
            String jSONObject2 = optJSONObject != null ? optJSONObject.toString() : "";
            SDKUtils.setControllerConfig(jSONObject2);
            IronLog ironLog3 = IronLog.ADAPTER_API;
            ironLog3.verbose("IronSourceNetwork setting controller config to " + jSONObject2);
            HashMap<String, String> initParams = getInitParams();
            String str2 = z.a().g;
            IronLog ironLog4 = IronLog.ADAPTER_API;
            ironLog4.verbose("with appKey=" + str2 + " userId=" + mediationUserId + " parameters " + initParams);
            IronSourceNetwork.setInitListener(new com.ironsource.sdk.j.d() {
                public void onFail(com.ironsource.sdk.g.e eVar) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("OnNetworkSDKInitListener fail - code:" + eVar.b + " message:" + eVar.a);
                }

                public void onSuccess() {
                    IronLog.ADAPTER_API.verbose("OnNetworkSDKInitListener success");
                }
            });
            IronSourceNetwork.initSDK(ContextProvider.getInstance().getApplicationContext(), str2, mediationUserId, initParams);
        }
    }

    public boolean isInterstitialReady(JSONObject jSONObject) {
        b bVar = this.mDemandSourceToISAd.get(getDemandSourceName(jSONObject));
        return bVar != null && IronSourceNetwork.isAdAvailableForInstance(bVar);
    }

    public boolean isOfferwallAvailable() {
        return true;
    }

    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        b bVar = this.mDemandSourceToRvAd.get(getDemandSourceName(jSONObject));
        return bVar != null && IronSourceNetwork.isAdAvailableForInstance(bVar);
    }

    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return false;
    }

    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        if (ironSourceBannerLayout != null) {
            loadBannerInternal(ironSourceBannerLayout.getActivity(), ironSourceBannerLayout.getSize(), jSONObject, bannerSmashListener, str);
            return;
        }
        bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + getProviderName() + " - banner is null"));
    }

    public void loadBannerForDemandOnlyForBidding(JSONObject jSONObject, String str, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, BannerSmashListener bannerSmashListener) {
        if (iSDemandOnlyBannerLayout != null) {
            loadBannerInternal(iSDemandOnlyBannerLayout.getActivity(), iSDemandOnlyBannerLayout.getSize(), jSONObject, bannerSmashListener, str);
            return;
        }
        bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner Load Fail, " + getProviderName() + " - banner is null"));
    }

    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName);
        try {
            loadInterstitialAdInternal(demandSourceName, (String) null, jSONObject, interstitialSmashListener);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(1000, e.getMessage()));
        }
    }

    public void loadInterstitialForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, InterstitialSmashListener interstitialSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName);
        try {
            loadInterstitialAdInternal(demandSourceName, str, jSONObject, interstitialSmashListener);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("for bidding exception " + e.getMessage());
            interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(1000, e.getMessage()));
        }
    }

    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName);
        try {
            loadRewardedVideoAdInternal(demandSourceName, (String) null, false, false, rewardedVideoSmashListener);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mDemandSourceToRvSmash.get(demandSourceName);
            if (rewardedVideoSmashListener2 != null) {
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.error("exception " + e.getMessage());
                rewardedVideoSmashListener2.onRewardedVideoLoadFailed(new IronSourceError(1002, e.getMessage()));
                rewardedVideoSmashListener2.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName);
        try {
            loadRewardedVideoAdInternal(demandSourceName, str, false, true, rewardedVideoSmashListener);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            rewardedVideoSmashListener.onRewardedVideoLoadFailed(new IronSourceError(1002, e.getMessage()));
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    public void loadRewardedVideoForDemandOnly(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName);
        try {
            loadRewardedVideoAdInternal(demandSourceName, (String) null, true, false, rewardedVideoSmashListener);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            rewardedVideoSmashListener.onRewardedVideoLoadFailed(new IronSourceError(1002, e.getMessage()));
        }
    }

    public void loadRewardedVideoForDemandOnlyForBidding(JSONObject jSONObject, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName);
        try {
            loadRewardedVideoAdInternal(demandSourceName, str, true, true, rewardedVideoSmashListener);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            rewardedVideoSmashListener.onRewardedVideoLoadFailed(new IronSourceError(1002, e.getMessage()));
        }
    }

    public void onGetOWCreditsFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.onGetOfferwallCreditsFailed(ErrorBuilder.buildGenericError(str));
        }
    }

    public void onOWAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        d dVar = this.mOfferwallListener;
        if (dVar != null) {
            dVar.onOfferwallClosed();
        }
    }

    public boolean onOWAdCredited(int i, int i2, boolean z) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        d dVar = this.mOfferwallListener;
        return dVar != null && dVar.onOfferwallAdCredited(i, i2, z);
    }

    public void onOWShowFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.onOfferwallShowFailed(ErrorBuilder.buildGenericError(str));
        }
    }

    public void onOWShowSuccess(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("onOWShowSuccess(placementId:" + str + ")");
        d dVar = this.mOfferwallListener;
        if (dVar != null) {
            dVar.onOfferwallOpened();
        }
    }

    public void onOfferwallEventNotificationReceived(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        }
    }

    public void onOfferwallInitFail(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        if (this.mOfferwallListener != null) {
            this.mOfferwallListener.a(false, ErrorBuilder.buildGenericError(str));
        }
    }

    public void onOfferwallInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(getProviderName());
        d dVar = this.mOfferwallListener;
        if (dVar != null) {
            dVar.onOfferwallAvailable(true);
        }
    }

    public void onPause(Activity activity) {
        IronLog.ADAPTER_API.verbose("IronSourceNetwork.onPause");
        IronSourceNetwork.onPause(activity);
    }

    public void onResume(Activity activity) {
        IronLog.ADAPTER_API.verbose("IronSourceNetwork.onResume");
        IronSourceNetwork.onResume(activity);
    }

    public void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        StringBuilder sb = new StringBuilder("(");
        sb.append(z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false");
        sb.append(")");
        ironLog.verbose(sb.toString());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consent", z ? "1" : "0");
            IronSourceNetwork.updateMetadata(jSONObject);
        } catch (JSONException e) {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.error("exception " + e.getMessage());
        }
    }

    public void setInternalOfferwallListener(d dVar) {
        this.mOfferwallListener = dVar;
    }

    public void setMetaData(String str, List<String> list) {
        if (!list.isEmpty()) {
            String str2 = list.get(0);
            if (!mDidInitSdk.get()) {
                IronLog ironLog = IronLog.ADAPTER_API;
                ironLog.verbose("key=" + str + ", value=" + str2);
                if (!MetaDataUtils.isValidCCPAMetaData(str, str2)) {
                    IronLog.ADAPTER_API.verbose("MetaData not valid");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(str, str2);
                    IronSourceNetwork.updateMetadata(jSONObject);
                } catch (JSONException e) {
                    IronLog ironLog2 = IronLog.ADAPTER_API;
                    ironLog2.error("error - " + e);
                    e.printStackTrace();
                }
            }
        }
    }

    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String demandSourceName = getDemandSourceName(jSONObject);
        IronLog.ADAPTER_API.verbose(demandSourceName);
        try {
            showAdInternal(this.mDemandSourceToISAd.get(demandSourceName), IronSource.AD_UNIT.INTERSTITIAL);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            interstitialSmashListener.onInterstitialAdShowFailed(new IronSourceError(1001, e.getMessage()));
        }
    }

    public void showOfferwall(String str, JSONObject jSONObject) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose(getProviderName() + " showOfferWall");
        try {
            HashMap<String, String> offerwallExtraParams = getOfferwallExtraParams();
            offerwallExtraParams.put("placementId", str);
            IronSourceNetwork.showOfferWall(ContextProvider.getInstance().getCurrentActiveActivity(), offerwallExtraParams);
        } catch (Exception e) {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.error("exception " + e.getMessage());
        }
    }

    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        try {
            showAdInternal(this.mDemandSourceToRvAd.get(getDemandSourceName(jSONObject)), IronSource.AD_UNIT.REWARDED_VIDEO);
        } catch (Exception e) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error("exception " + e.getMessage());
            rewardedVideoSmashListener.onRewardedVideoAdShowFailed(new IronSourceError(1003, e.getMessage()));
        }
    }
}
