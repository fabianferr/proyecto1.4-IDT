package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.media3.common.C;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.C0232v;
import com.ironsource.mediationsdk.adunit.data.DataKeys;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.f;
import com.ironsource.mediationsdk.model.m;
import com.ironsource.mediationsdk.model.n;
import com.ironsource.mediationsdk.model.o;
import com.ironsource.mediationsdk.model.p;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
    private final boolean A = false;
    private final int B = 30000;
    private final int C = -1;
    private final int D = 5000;
    private final int E = 1;
    private final boolean F = false;
    private final String G = "providerOrder";
    private final String H = "providerSettings";
    private final String I = "configurations";
    private final String J = IronSourceConstants.EVENTS_GENERIC_PARAMS;
    private final String K = "adUnits";
    private final String L = "providerLoadName";
    private final String M = "application";
    private final String N = "rewardedVideo";
    private final String O = IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE;
    private final String P = "offerwall";
    private final String Q = "banner";
    private final String R = "nativeAd";
    private final String S = "integration";
    private final String T = "loggers";
    private final String U = "segment";
    private final String V = "events";
    private final String W = "crashReporter";
    private final String X = IronSourceAdapter.IRONSOURCE_BIDDING_TOKEN_KEY;
    private final String Y = "external";
    private final String Z = "mediationTypes";
    public o a;
    private final String aA = "serverEventsURL";
    private final String aB = "serverEventsType";
    private final String aC = "backupThreshold";
    private final String aD = "maxNumberOfEvents";
    private final String aE = "maxEventsPerBatch";
    private final String aF = "optOut";
    private final String aG = "optIn";
    private final String aH = "triggerEvents";
    private final String aI = "nonConnectivityEvents";
    private final String aJ = "shouldSendPublisherLogsOnUIThread";
    private final String aK = "pixel";
    private final String aL = "pixelEventsUrl";
    private final String aM = "pixelEventsEnabled";
    private final String aN = "placements";
    private final String aO = "placementId";
    private final String aP = "placementName";
    private final String aQ = "delivery";
    private final String aR = "isDefault";
    private final String aS = "capping";
    private final String aT = "pacing";
    private final String aU = "enabled";
    private final String aV = "maxImpressions";
    private final String aW = "numOfSeconds";
    private final String aX = "unit";
    private final String aY = "virtualItemName";
    private final String aZ = "virtualItemCount";
    private final String aa = "providerDefaultInstance";
    private final String ab = "testSuite";
    private final String ac = "controllerUrl";
    private final String ad = "AdQuality";
    private final String ae = "initSDK";
    private final String af = "settings";
    private final String ag = "collectBiddingDataTimeout";
    private final String ah = "collectBiddingDataAsyncEnabled";
    private final String ai = "providers";
    private final String aj = "parallelInit";
    private final String ak = "waitUntilAllProvidersFinishInit";
    private final String al = "maxNumOfAdaptersToLoadOnStart";
    private final String am = "advancedLoading";
    private final String an = "adapterTimeOutInSeconds";
    private final String ao = "atim";
    private final String ap = "bannerInterval";
    private final String aq = "isOneFlow";
    private final String ar = "loadRVInterval";
    private final String as = "expiredDurationInMinutes";
    private final String at = "server";
    private final String au = "publisher";
    private final String av = "console";
    private final String aw = "sendUltraEvents";
    private final String ax = "sendEventsToggle";
    private final String ay = "eventsCompression";
    private final String az = "eventsCompressionLevel";
    public p b;
    private final String bA = "disableLoadWhileShowSupportFor";
    private final String bB = "timeToDeleteOldWaterfallAfterAuction";
    private final String bC = "compressAuctionRequest";
    private final String bD = "compressAuctionResponse";
    private final String bE = "encryptionVersion";
    private final String bF = "shouldSendBannerBURLFromImpression";
    private final String bG = "optInKeys";
    private final String bH = "tokenGenericParams";
    private final String bI = "oneToken";
    private final String bJ = "compressToken";
    private final String bK = "compressExternalToken";
    private String bL;
    private String bM;
    private Context bN;
    private final String ba = "uuidEnabled";
    private final String bb = "abt";
    private final String bc = "delayLoadFailure";
    private final String bd = "keysToInclude";
    private final String be = "reporterURL";
    private final String bf = "reporterKeyword";
    private final String bg = "includeANR";
    private final String bh = "timeout";
    private final String bi = "setIgnoreDebugger";
    private final String bj = "adSourceName";
    private final String bk = IronSourceConstants.EVENTS_SUB_PROVIDER_ID;
    private final String bl = "mpis";
    private final String bm = "auction";
    private final String bn = "auctionData";
    private final String bo = "auctioneerURL";
    private final String bp = "extAuctioneerURL";
    private final String bq = IronSourceConstants.EVENTS_PROGRAMMATIC;
    private final String br = "objectPerWaterfall";
    private final String bs = "minTimeBeforeFirstAuction";
    private final String bt = "timeToWaitBeforeAuction";
    private final String bu = "timeToWaitBeforeLoad";
    private final String bv = "auctionRetryInterval";
    private final String bw = "isLoadWhileShow";
    private final String bx = IronSourceConstants.AUCTION_TRIALS;
    private final String by = "auctionTimeout";
    private final String bz = "auctionSavedHistory";
    public f c;
    public JSONObject d;
    public int e = a.a;
    private final String f = "error";
    private final int g = 3;
    private final int h = 2;
    private final int i = 60;
    private final int j = 10000;
    private final int k = 10000;
    private final int l = -1;
    private final int m = 5000;
    private final int n = 300;
    private final int o = 3;
    private final int p = 3;
    private final int q = 3;
    private final int r = 0;
    private final int s = 2;
    private final int t = 15;
    private final long u = 10000;
    private final int v = 0;
    private final boolean w = false;
    private final boolean x = false;
    private final long y = C.DEFAULT_MAX_SEEK_TO_PREVIOUS_POSITION_MS;
    private final boolean z = false;

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;

        static {
            d = new int[]{1, 2, 3};
        }
    }

    public k(Context context, String str, String str2, String str3) {
        this.bN = context;
        try {
            this.d = TextUtils.isEmpty(str3) ? new JSONObject() : new JSONObject(str3);
            h();
            i();
            g();
            this.bL = TextUtils.isEmpty(str) ? "" : str;
            this.bM = TextUtils.isEmpty(str2) ? "" : str2;
        } catch (JSONException e2) {
            e2.printStackTrace();
            e();
        }
    }

    public k(k kVar) {
        try {
            this.bN = kVar.bN;
            this.d = new JSONObject(kVar.d.toString());
            this.bL = kVar.bL;
            this.bM = kVar.bM;
            this.a = kVar.a;
            this.b = kVar.b;
            this.c = kVar.c;
            this.e = kVar.e;
        } catch (Exception unused) {
            e();
        }
    }

    private static int a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i2) {
        int i3 = 0;
        if (jSONObject.has(str)) {
            i3 = jSONObject.optInt(str, 0);
        } else if (jSONObject2.has(str)) {
            i3 = jSONObject2.optInt(str, 0);
        }
        return i3 == 0 ? i2 : i3;
    }

    private static long a(JSONObject jSONObject, JSONObject jSONObject2, String str, long j2) {
        long optLong = jSONObject.has(str) ? jSONObject.optLong(str, 0) : jSONObject2.has(str) ? jSONObject2.optLong(str, 0) : 0;
        if (optLong == 0) {
            return 10000;
        }
        return optLong;
    }

    private static m a(JSONObject jSONObject) {
        n nVar = null;
        if (jSONObject == null) {
            return null;
        }
        m.a aVar = new m.a();
        boolean z2 = true;
        aVar.a = jSONObject.optBoolean("delivery", true);
        JSONObject optJSONObject = jSONObject.optJSONObject("capping");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString("unit");
            if (!TextUtils.isEmpty(optString)) {
                if (n.PER_DAY.toString().equals(optString)) {
                    nVar = n.PER_DAY;
                } else if (n.PER_HOUR.toString().equals(optString)) {
                    nVar = n.PER_HOUR;
                }
            }
            int optInt = optJSONObject.optInt("maxImpressions", 0);
            aVar.a(optJSONObject.optBoolean("enabled", false) && optInt > 0, nVar, optInt);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pacing");
        if (optJSONObject2 != null) {
            int optInt2 = optJSONObject2.optInt("numOfSeconds", 0);
            if (!optJSONObject2.optBoolean("enabled", false) || optInt2 <= 0) {
                z2 = false;
            }
            aVar.a(z2, optInt2);
        }
        return aVar.a();
    }

    private static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str, boolean z2) {
        if (jSONObject.has(str)) {
            return jSONObject.optBoolean(str, false);
        }
        if (jSONObject2.has(str)) {
            return jSONObject2.optBoolean(str, false);
        }
        return false;
    }

    private static int[] a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        int[] iArr = new int[optJSONArray.length()];
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            iArr[i2] = optJSONArray.optInt(i2);
        }
        return iArr;
    }

    private static JSONObject b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    private JSONObject c(JSONObject jSONObject, String str) {
        JSONObject b2 = b(jSONObject, str);
        return b2 != null ? b2 : new JSONObject();
    }

    private void e() {
        this.d = new JSONObject();
        this.bL = "";
        this.bM = "";
        this.a = new o();
        this.b = p.a();
        this.c = new f.a().a();
    }

    private boolean f() {
        JSONObject b2;
        JSONArray optJSONArray;
        JSONObject b3 = b(this.d, "providerOrder");
        JSONArray names = b3.names();
        if (names == null) {
            return true;
        }
        JSONObject b4 = b(b(this.d, "configurations"), "adUnits");
        for (int i2 = 0; i2 < names.length(); i2++) {
            String optString = names.optString(i2);
            JSONArray optJSONArray2 = b3.optJSONArray(optString);
            if (optJSONArray2 != null && optJSONArray2.length() != 0 && (b2 = b(b4, optString)) != null && ((optJSONArray = b2.optJSONArray("placements")) == null || optJSONArray.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private void g() {
        f fVar;
        f fVar2;
        try {
            JSONObject b2 = b(this.d, "providerOrder");
            JSONArray optJSONArray = b2.optJSONArray("rewardedVideo");
            JSONArray optJSONArray2 = b2.optJSONArray(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
            JSONArray optJSONArray3 = b2.optJSONArray("banner");
            JSONArray optJSONArray4 = b2.optJSONArray("nativeAd");
            this.a = new o();
            if (!(optJSONArray == null || (fVar2 = this.c) == null || fVar2.a() == null)) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String optString = optJSONArray.optString(i2);
                    o oVar = this.a;
                    if (!TextUtils.isEmpty(optString)) {
                        oVar.a.add(optString);
                    }
                    NetworkSettings a2 = p.a().a(optString);
                    if (a2 != null) {
                        a2.setRewardedVideoPriority(i2);
                    }
                }
            }
            if (!(optJSONArray2 == null || (fVar = this.c) == null || fVar.b() == null)) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    String optString2 = optJSONArray2.optString(i3);
                    o oVar2 = this.a;
                    if (!TextUtils.isEmpty(optString2)) {
                        oVar2.b.add(optString2);
                    }
                    NetworkSettings a3 = p.a().a(optString2);
                    if (a3 != null) {
                        a3.setInterstitialPriority(i3);
                    }
                }
            }
            if (optJSONArray3 != null) {
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    String optString3 = optJSONArray3.optString(i4);
                    o oVar3 = this.a;
                    if (!TextUtils.isEmpty(optString3)) {
                        oVar3.c.add(optString3);
                    }
                    NetworkSettings a4 = p.a().a(optString3);
                    if (a4 != null) {
                        a4.setBannerPriority(i4);
                    }
                }
            }
            if (optJSONArray4 != null) {
                for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                    String optString4 = optJSONArray4.optString(i5);
                    o oVar4 = this.a;
                    if (!TextUtils.isEmpty(optString4)) {
                        oVar4.d.add(optString4);
                    }
                    NetworkSettings a5 = p.a().a(optString4);
                    if (a5 != null) {
                        a5.setNativeAdPriority(i5);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h() {
        Iterator<String> it;
        String str;
        JSONObject jSONObject;
        p pVar;
        NetworkSettings networkSettings;
        String str2 = "Mediation";
        try {
            this.b = p.a();
            JSONObject b2 = b(this.d, "providerSettings");
            Iterator<String> keys = b2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = b2.optJSONObject(next);
                if (optJSONObject != null) {
                    boolean optBoolean = optJSONObject.optBoolean("mpis", false);
                    String optString = optJSONObject.optString(IronSourceConstants.EVENTS_SUB_PROVIDER_ID, "0");
                    String optString2 = optJSONObject.optString("adSourceName", (String) null);
                    String optString3 = optJSONObject.optString("providerLoadName", next);
                    String optString4 = optJSONObject.optString("providerDefaultInstance", optString3);
                    JSONObject b3 = b(optJSONObject, "adUnits");
                    JSONObject b4 = b(optJSONObject, "application");
                    JSONObject b5 = b(b3, "rewardedVideo");
                    JSONObject b6 = b(b3, IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE);
                    JSONObject b7 = b(b3, "banner");
                    JSONObject b8 = b(b3, "nativeAd");
                    JSONObject mergeJsons = IronSourceUtils.mergeJsons(b5, b4);
                    JSONObject mergeJsons2 = IronSourceUtils.mergeJsons(b6, b4);
                    JSONObject mergeJsons3 = IronSourceUtils.mergeJsons(b7, b4);
                    JSONObject mergeJsons4 = IronSourceUtils.mergeJsons(b8, b4);
                    if (this.b.b(next)) {
                        NetworkSettings a2 = this.b.a(next);
                        JSONObject rewardedVideoSettings = a2.getRewardedVideoSettings();
                        JSONObject interstitialSettings = a2.getInterstitialSettings();
                        JSONObject bannerSettings = a2.getBannerSettings();
                        JSONObject nativeAdSettings = a2.getNativeAdSettings();
                        a2.setRewardedVideoSettings(IronSourceUtils.mergeJsons(rewardedVideoSettings, mergeJsons));
                        a2.setInterstitialSettings(IronSourceUtils.mergeJsons(interstitialSettings, mergeJsons2));
                        a2.setBannerSettings(IronSourceUtils.mergeJsons(bannerSettings, mergeJsons3));
                        a2.setNativeAdSettings(IronSourceUtils.mergeJsons(nativeAdSettings, mergeJsons4));
                        a2.setIsMultipleInstances(optBoolean);
                        a2.setSubProviderId(optString);
                        a2.setAdSourceNameForEvents(optString2);
                    } else {
                        String lowerCase = StringUtils.toLowerCase(optString3);
                        jSONObject = b2;
                        if (this.b.b(str2) && (StringUtils.toLowerCase(IronSourceConstants.SUPERSONIC_CONFIG_NAME).equals(lowerCase) || StringUtils.toLowerCase(IronSourceConstants.IRONSOURCE_CONFIG_NAME).equals(lowerCase))) {
                            NetworkSettings a3 = this.b.a(str2);
                            JSONObject rewardedVideoSettings2 = a3.getRewardedVideoSettings();
                            JSONObject interstitialSettings2 = a3.getInterstitialSettings();
                            JSONObject bannerSettings2 = a3.getBannerSettings();
                            JSONObject nativeAdSettings2 = a3.getNativeAdSettings();
                            str = str2;
                            JSONObject jSONObject2 = new JSONObject(rewardedVideoSettings2.toString());
                            it = keys;
                            JSONObject jSONObject3 = new JSONObject(interstitialSettings2.toString());
                            String str3 = optString2;
                            networkSettings = new NetworkSettings(next, optString3, optString4, b4, IronSourceUtils.mergeJsons(jSONObject2, mergeJsons), IronSourceUtils.mergeJsons(jSONObject3, mergeJsons2), IronSourceUtils.mergeJsons(new JSONObject(bannerSettings2.toString()), mergeJsons3), IronSourceUtils.mergeJsons(new JSONObject(nativeAdSettings2.toString()), mergeJsons4));
                            networkSettings.setIsMultipleInstances(optBoolean);
                            networkSettings.setSubProviderId(optString);
                            networkSettings.setAdSourceNameForEvents(str3);
                            pVar = this.b;
                        } else {
                            str = str2;
                            it = keys;
                            networkSettings = new NetworkSettings(next, optString3, optString4, b4, mergeJsons, mergeJsons2, mergeJsons3, mergeJsons4);
                            networkSettings.setIsMultipleInstances(optBoolean);
                            networkSettings.setSubProviderId(optString);
                            networkSettings.setAdSourceNameForEvents(optString2);
                            pVar = this.b;
                        }
                        pVar.a(networkSettings);
                    }
                } else {
                    str = str2;
                    jSONObject = b2;
                    it = keys;
                }
                b2 = jSONObject;
                str2 = str;
                keys = it;
            }
            this.b.b();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0d8a: MOVE  (r2v8 java.lang.String) = (r35v3 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x05ae A[Catch:{ Exception -> 0x05c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:240:0x0815 A[Catch:{ Exception -> 0x05c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:293:0x09fe A[Catch:{ Exception -> 0x05c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:308:0x0a46 A[Catch:{ Exception -> 0x05c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:364:0x0b86 A[Catch:{ Exception -> 0x05c4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:470:0x0a49 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0366 A[Catch:{ Exception -> 0x05c4 }] */
    private void i() {
        /*
            r101 = this;
            r1 = r101
            java.lang.String r2 = "events"
            org.json.JSONObject r3 = r1.d     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r4 = "configurations"
            org.json.JSONObject r3 = b(r3, r4)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r4 = "adUnits"
            org.json.JSONObject r4 = b(r3, r4)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r5 = "application"
            org.json.JSONObject r5 = b(r3, r5)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r6 = "rewardedVideo"
            org.json.JSONObject r6 = b(r4, r6)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r7 = "interstitial"
            org.json.JSONObject r7 = b(r4, r7)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r8 = "offerwall"
            org.json.JSONObject r8 = b(r4, r8)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r9 = "banner"
            org.json.JSONObject r9 = b(r4, r9)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r10 = "nativeAd"
            org.json.JSONObject r4 = b(r4, r10)     // Catch:{ Exception -> 0x0dbc }
            org.json.JSONObject r10 = b(r5, r2)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r11 = "loggers"
            org.json.JSONObject r11 = b(r5, r11)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r12 = "token"
            org.json.JSONObject r12 = b(r5, r12)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r13 = "segment"
            org.json.JSONObject r13 = b(r5, r13)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r14 = "auction"
            org.json.JSONObject r14 = b(r5, r14)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r15 = "crashReporter"
            org.json.JSONObject r15 = b(r5, r15)     // Catch:{ Exception -> 0x0dbc }
            r16 = r3
            java.lang.String r3 = "settings"
            org.json.JSONObject r3 = b(r5, r3)     // Catch:{ Exception -> 0x0dbc }
            r17 = r3
            java.lang.String r3 = "external"
            org.json.JSONObject r3 = b(r5, r3)     // Catch:{ Exception -> 0x0dbc }
            r18 = r3
            java.lang.String r3 = "pixel"
            org.json.JSONObject r3 = b(r10, r3)     // Catch:{ Exception -> 0x0dbc }
            r19 = r13
            r13 = 1
            if (r5 == 0) goto L_0x008a
            r20 = r15
            java.lang.String r15 = "uuidEnabled"
            boolean r15 = r5.optBoolean(r15, r13)     // Catch:{ Exception -> 0x0dbc }
            android.content.Context r13 = r1.bN     // Catch:{ Exception -> 0x0dbc }
            r21 = r11
            java.lang.String r11 = "uuidEnabled"
            com.ironsource.mediationsdk.utils.IronSourceUtils.saveBooleanToSharedPrefs(r13, r11, r15)     // Catch:{ Exception -> 0x0dbc }
            goto L_0x008e
        L_0x008a:
            r21 = r11
            r20 = r15
        L_0x008e:
            if (r10 == 0) goto L_0x00a8
            java.lang.String r11 = "abt"
            java.lang.String r11 = r10.optString(r11)     // Catch:{ Exception -> 0x0dbc }
            boolean r13 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x0dbc }
            if (r13 != 0) goto L_0x00a8
            com.ironsource.mediationsdk.events.e r13 = com.ironsource.mediationsdk.events.e.d()     // Catch:{ Exception -> 0x0dbc }
            r13.q = r11     // Catch:{ Exception -> 0x0dbc }
            com.ironsource.mediationsdk.events.i r13 = com.ironsource.mediationsdk.events.i.d()     // Catch:{ Exception -> 0x0dbc }
            r13.q = r11     // Catch:{ Exception -> 0x0dbc }
        L_0x00a8:
            java.lang.String r11 = "triggerEvents"
            java.lang.String r13 = "maxEventsPerBatch"
            java.lang.String r15 = "maxNumberOfEvents"
            r22 = r3
            java.lang.String r3 = "backupThreshold"
            r23 = r12
            java.lang.String r12 = "serverEventsType"
            r24 = r8
            java.lang.String r8 = "serverEventsURL"
            r25 = r4
            java.lang.String r4 = "sendEventsToggle"
            r26 = r9
            java.lang.String r9 = "placements"
            r27 = r7
            java.lang.String r7 = "optIn"
            r28 = r14
            java.lang.String r14 = "optOut"
            r29 = r13
            r30 = r14
            java.lang.String r13 = "eventsCompressionLevel"
            java.lang.String r14 = "eventsCompression"
            r31 = r11
            java.lang.String r11 = ""
            r32 = 0
            r33 = r7
            if (r6 == 0) goto L_0x037b
            org.json.JSONArray r7 = r6.optJSONArray(r9)     // Catch:{ Exception -> 0x0dbc }
            r34 = r9
            org.json.JSONObject r9 = b(r6, r2)     // Catch:{ Exception -> 0x0dbc }
            r35 = r2
            java.lang.String r2 = "providers"
            org.json.JSONObject r2 = r1.c(r6, r2)     // Catch:{ Exception -> 0x0dbc }
            java.lang.String r1 = "collectBiddingDataAsyncEnabled"
            r36 = r7
            r7 = 0
            boolean r46 = r6.optBoolean(r1, r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "collectBiddingDataTimeout"
            r51 = r8
            r7 = 3000(0xbb8, double:1.482E-320)
            long r47 = r6.optLong(r1, r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "parallelInit"
            r7 = 0
            boolean r49 = r2.optBoolean(r1, r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "waitUntilAllProvidersFinishInit"
            boolean r50 = r2.optBoolean(r1, r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "maxNumOfAdaptersToLoadOnStart"
            r2 = 2
            int r1 = a((org.json.JSONObject) r6, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r2)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r2 = "advancedLoading"
            int r2 = a((org.json.JSONObject) r6, (org.json.JSONObject) r5, (java.lang.String) r2, (int) r7)     // Catch:{ Exception -> 0x0376 }
            if (r2 <= 0) goto L_0x0124
            r38 = r2
            r39 = 1
            goto L_0x0128
        L_0x0124:
            r38 = r1
            r39 = 0
        L_0x0128:
            java.lang.String r1 = "adapterTimeOutInSeconds"
            r2 = 60
            int r40 = a((org.json.JSONObject) r6, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r2)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "loadRVInterval"
            r2 = 300(0x12c, float:4.2E-43)
            int r41 = a((org.json.JSONObject) r6, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r2)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "expiredDurationInMinutes"
            r2 = -1
            int r42 = a((org.json.JSONObject) r6, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r2)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "delayLoadFailure"
            r2 = 3
            int r45 = a((org.json.JSONObject) r6, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r2)     // Catch:{ Exception -> 0x0376 }
            org.json.JSONObject r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r9, r10)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r2 = "sendUltraEvents"
            r6 = 0
            boolean r53 = r1.optBoolean(r2, r6)     // Catch:{ Exception -> 0x0376 }
            boolean r54 = r1.optBoolean(r4, r6)     // Catch:{ Exception -> 0x0376 }
            boolean r55 = r1.optBoolean(r14, r6)     // Catch:{ Exception -> 0x0376 }
            r2 = -1
            int r56 = r1.optInt(r13, r2)     // Catch:{ Exception -> 0x0376 }
            r6 = r51
            java.lang.String r57 = r1.optString(r6, r11)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r58 = r1.optString(r12, r11)     // Catch:{ Exception -> 0x0376 }
            int r59 = r1.optInt(r3, r2)     // Catch:{ Exception -> 0x0376 }
            int r60 = r1.optInt(r15, r2)     // Catch:{ Exception -> 0x0376 }
            r2 = r29
            r7 = 5000(0x1388, float:7.006E-42)
            int r61 = r1.optInt(r2, r7)     // Catch:{ Exception -> 0x0376 }
            r7 = r30
            org.json.JSONArray r8 = r1.optJSONArray(r7)     // Catch:{ Exception -> 0x0376 }
            if (r8 == 0) goto L_0x019d
            int r9 = r8.length()     // Catch:{ Exception -> 0x0376 }
            int[] r9 = new int[r9]     // Catch:{ Exception -> 0x0376 }
            r29 = r2
            r30 = r7
            r7 = 0
        L_0x018b:
            int r2 = r8.length()     // Catch:{ Exception -> 0x0376 }
            if (r7 >= r2) goto L_0x019a
            int r2 = r8.optInt(r7)     // Catch:{ Exception -> 0x0376 }
            r9[r7] = r2     // Catch:{ Exception -> 0x0376 }
            int r7 = r7 + 1
            goto L_0x018b
        L_0x019a:
            r62 = r9
            goto L_0x01a3
        L_0x019d:
            r29 = r2
            r30 = r7
            r62 = r32
        L_0x01a3:
            r2 = r33
            org.json.JSONArray r7 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0376 }
            if (r7 == 0) goto L_0x01c6
            int r8 = r7.length()     // Catch:{ Exception -> 0x0376 }
            int[] r8 = new int[r8]     // Catch:{ Exception -> 0x0376 }
            r33 = r2
            r9 = 0
        L_0x01b4:
            int r2 = r7.length()     // Catch:{ Exception -> 0x0376 }
            if (r9 >= r2) goto L_0x01c3
            int r2 = r7.optInt(r9)     // Catch:{ Exception -> 0x0376 }
            r8[r9] = r2     // Catch:{ Exception -> 0x0376 }
            int r9 = r9 + 1
            goto L_0x01b4
        L_0x01c3:
            r63 = r8
            goto L_0x01ca
        L_0x01c6:
            r33 = r2
            r63 = r32
        L_0x01ca:
            r2 = r31
            org.json.JSONArray r7 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0376 }
            if (r7 == 0) goto L_0x01ed
            int r8 = r7.length()     // Catch:{ Exception -> 0x0376 }
            int[] r8 = new int[r8]     // Catch:{ Exception -> 0x0376 }
            r31 = r2
            r9 = 0
        L_0x01db:
            int r2 = r7.length()     // Catch:{ Exception -> 0x0376 }
            if (r9 >= r2) goto L_0x01ea
            int r2 = r7.optInt(r9)     // Catch:{ Exception -> 0x0376 }
            r8[r9] = r2     // Catch:{ Exception -> 0x0376 }
            int r9 = r9 + 1
            goto L_0x01db
        L_0x01ea:
            r64 = r8
            goto L_0x01f1
        L_0x01ed:
            r31 = r2
            r64 = r32
        L_0x01f1:
            java.lang.String r2 = "nonConnectivityEvents"
            org.json.JSONArray r1 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0376 }
            if (r1 == 0) goto L_0x0212
            int r2 = r1.length()     // Catch:{ Exception -> 0x0376 }
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x0376 }
            r7 = 0
        L_0x0200:
            int r8 = r1.length()     // Catch:{ Exception -> 0x0376 }
            if (r7 >= r8) goto L_0x020f
            int r8 = r1.optInt(r7)     // Catch:{ Exception -> 0x0376 }
            r2[r7] = r8     // Catch:{ Exception -> 0x0376 }
            int r7 = r7 + 1
            goto L_0x0200
        L_0x020f:
            r65 = r2
            goto L_0x0214
        L_0x0212:
            r65 = r32
        L_0x0214:
            com.ironsource.sdk.controller.x r43 = new com.ironsource.sdk.controller.x     // Catch:{ Exception -> 0x0376 }
            r52 = r43
            r52.<init>(r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65)     // Catch:{ Exception -> 0x0376 }
            if (r28 == 0) goto L_0x02e1
            java.lang.String r1 = "rewardedVideo"
            r2 = r28
            org.json.JSONObject r1 = b(r2, r1)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "auctionData"
            java.lang.String r52 = r2.optString(r7, r11)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "auctioneerURL"
            java.lang.String r53 = r2.optString(r7, r11)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "extAuctioneerURL"
            java.lang.String r54 = r2.optString(r7, r11)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "auctionTrials"
            r8 = 2
            int r55 = r2.optInt(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "auctionTimeout"
            r8 = 10000(0x2710, double:4.9407E-320)
            long r57 = r2.optLong(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "auctionSavedHistory"
            r8 = 15
            int r56 = r2.optInt(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "compressAuctionRequest"
            r8 = 0
            boolean r70 = r2.optBoolean(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "compressAuctionResponse"
            boolean r71 = r2.optBoolean(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "encryptionVersion"
            r9 = 1
            int r73 = r2.optInt(r7, r9)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "programmatic"
            boolean r59 = r1.optBoolean(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "minTimeBeforeFirstAuction"
            r8 = 2000(0x7d0, float:2.803E-42)
            int r7 = r1.optInt(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r8 = "auctionRetryInterval"
            r9 = 30000(0x7530, float:4.2039E-41)
            int r8 = r1.optInt(r8, r9)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r9 = "timeToWaitBeforeAuction"
            r28 = r2
            r2 = 5000(0x1388, float:7.006E-42)
            int r9 = r1.optInt(r9, r2)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r2 = "timeToWaitBeforeLoad"
            r75 = r15
            r15 = 50
            int r2 = r1.optInt(r2, r15)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r15 = "objectPerWaterfall"
            r76 = r3
            r3 = 0
            boolean r72 = r1.optBoolean(r15, r3)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r3 = "isLoadWhileShow"
            r15 = 1
            boolean r68 = r1.optBoolean(r3, r15)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r3 = "timeToDeleteOldWaterfallAfterAuction"
            r15 = 30000(0x7530, float:4.2039E-41)
            int r69 = r1.optInt(r3, r15)     // Catch:{ Exception -> 0x0376 }
            com.ironsource.mediationsdk.utils.c r3 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0376 }
            r15 = r6
            long r6 = (long) r7     // Catch:{ Exception -> 0x0376 }
            r60 = r6
            long r6 = (long) r8     // Catch:{ Exception -> 0x0376 }
            r62 = r6
            long r6 = (long) r9     // Catch:{ Exception -> 0x0376 }
            r64 = r6
            long r6 = (long) r2     // Catch:{ Exception -> 0x0376 }
            r66 = r6
            r74 = 0
            r51 = r3
            r51.<init>(r52, r53, r54, r55, r56, r57, r59, r60, r62, r64, r66, r68, r69, r70, r71, r72, r73, r74)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r2 = "disableLoadWhileShowSupportFor"
            org.json.JSONArray r1 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x0376 }
            if (r1 == 0) goto L_0x02de
            r2 = 0
        L_0x02c6:
            int r6 = r1.length()     // Catch:{ Exception -> 0x0376 }
            if (r2 >= r6) goto L_0x02de
            java.lang.String r6 = r1.optString(r2)     // Catch:{ Exception -> 0x0376 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x0376 }
            if (r7 != 0) goto L_0x02db
            java.util.ArrayList<java.lang.String> r7 = r3.k     // Catch:{ Exception -> 0x0376 }
            r7.add(r6)     // Catch:{ Exception -> 0x0376 }
        L_0x02db:
            int r2 = r2 + 1
            goto L_0x02c6
        L_0x02de:
            r44 = r3
            goto L_0x02ed
        L_0x02e1:
            r76 = r3
            r75 = r15
            r15 = r6
            com.ironsource.mediationsdk.utils.c r1 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0376 }
            r1.<init>()     // Catch:{ Exception -> 0x0376 }
            r44 = r1
        L_0x02ed:
            com.ironsource.mediationsdk.model.q r1 = new com.ironsource.mediationsdk.model.q     // Catch:{ Exception -> 0x0376 }
            r37 = r1
            r37.<init>(r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r49, r50)     // Catch:{ Exception -> 0x0376 }
            if (r36 == 0) goto L_0x0373
            r2 = 0
        L_0x02f7:
            int r3 = r36.length()     // Catch:{ Exception -> 0x0376 }
            if (r2 >= r3) goto L_0x0373
            r3 = r36
            org.json.JSONObject r6 = r3.optJSONObject(r2)     // Catch:{ Exception -> 0x0376 }
            if (r6 == 0) goto L_0x0352
            java.lang.String r7 = "placementId"
            r8 = -1
            int r37 = r6.optInt(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "placementName"
            java.lang.String r38 = r6.optString(r7, r11)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "isDefault"
            r8 = 0
            boolean r39 = r6.optBoolean(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "virtualItemName"
            java.lang.String r40 = r6.optString(r7, r11)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "virtualItemCount"
            r8 = -1
            int r41 = r6.optInt(r7, r8)     // Catch:{ Exception -> 0x0376 }
            com.ironsource.mediationsdk.model.m r6 = a(r6)     // Catch:{ Exception -> 0x0376 }
            if (r37 < 0) goto L_0x0352
            boolean r7 = android.text.TextUtils.isEmpty(r38)     // Catch:{ Exception -> 0x0376 }
            if (r7 != 0) goto L_0x0352
            boolean r7 = android.text.TextUtils.isEmpty(r40)     // Catch:{ Exception -> 0x0376 }
            if (r7 != 0) goto L_0x0352
            if (r41 <= 0) goto L_0x0352
            com.ironsource.mediationsdk.model.Placement r7 = new com.ironsource.mediationsdk.model.Placement     // Catch:{ Exception -> 0x0376 }
            r36 = r7
            r42 = r6
            r36.<init>(r37, r38, r39, r40, r41, r42)     // Catch:{ Exception -> 0x0376 }
            if (r6 == 0) goto L_0x034f
            r6 = r101
            android.content.Context r8 = r6.bN     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.utils.j.a((android.content.Context) r8, (com.ironsource.mediationsdk.model.Placement) r7)     // Catch:{ Exception -> 0x05c4 }
            goto L_0x0356
        L_0x034f:
            r6 = r101
            goto L_0x0356
        L_0x0352:
            r6 = r101
            r7 = r32
        L_0x0356:
            if (r7 == 0) goto L_0x036e
            if (r7 == 0) goto L_0x036e
            java.util.ArrayList<com.ironsource.mediationsdk.model.Placement> r8 = r1.a     // Catch:{ Exception -> 0x05c4 }
            r8.add(r7)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.Placement r8 = r1.l     // Catch:{ Exception -> 0x05c4 }
            if (r8 != 0) goto L_0x0366
        L_0x0363:
            r1.l = r7     // Catch:{ Exception -> 0x05c4 }
            goto L_0x036e
        L_0x0366:
            r8 = 0
            boolean r9 = r7.isPlacementId(r8)     // Catch:{ Exception -> 0x05c4 }
            if (r9 == 0) goto L_0x036e
            goto L_0x0363
        L_0x036e:
            int r2 = r2 + 1
            r36 = r3
            goto L_0x02f7
        L_0x0373:
            r6 = r101
            goto L_0x0387
        L_0x0376:
            r0 = move-exception
            r6 = r101
            goto L_0x0dbe
        L_0x037b:
            r6 = r1
            r35 = r2
            r76 = r3
            r34 = r9
            r75 = r15
            r15 = r8
            r1 = r32
        L_0x0387:
            if (r27 == 0) goto L_0x05c7
            r2 = r27
            r3 = r34
            org.json.JSONArray r7 = r2.optJSONArray(r3)     // Catch:{ Exception -> 0x05c4 }
            r8 = r35
            org.json.JSONObject r9 = b(r2, r8)     // Catch:{ Exception -> 0x05c4 }
            r51 = r15
            java.lang.String r15 = "providers"
            org.json.JSONObject r15 = r6.c(r2, r15)     // Catch:{ Exception -> 0x05c4 }
            r27 = r1
            java.lang.String r1 = "collectBiddingDataAsyncEnabled"
            r35 = r8
            r8 = 0
            boolean r44 = r2.optBoolean(r1, r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "collectBiddingDataTimeout"
            r34 = r9
            r8 = 3000(0xbb8, double:1.482E-320)
            long r45 = r2.optLong(r1, r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "parallelInit"
            r8 = 0
            boolean r47 = r15.optBoolean(r1, r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "waitUntilAllProvidersFinishInit"
            boolean r48 = r15.optBoolean(r1, r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "maxNumOfAdaptersToLoadOnStart"
            r9 = 2
            int r1 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r9)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "advancedLoading"
            int r9 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r9, (int) r8)     // Catch:{ Exception -> 0x05c4 }
            if (r9 <= 0) goto L_0x03d6
            r37 = r9
            r38 = 1
            goto L_0x03da
        L_0x03d6:
            r37 = r1
            r38 = 0
        L_0x03da:
            java.lang.String r1 = "adapterTimeOutInSeconds"
            r8 = 60
            int r39 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "delayLoadFailure"
            r8 = 3
            int r42 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "isOneFlow"
            r8 = 0
            boolean r43 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r1, (boolean) r8)     // Catch:{ Exception -> 0x05c4 }
            r1 = r34
            org.json.JSONObject r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r1, r10)     // Catch:{ Exception -> 0x05c4 }
            boolean r54 = r1.optBoolean(r4, r8)     // Catch:{ Exception -> 0x05c4 }
            boolean r55 = r1.optBoolean(r14, r8)     // Catch:{ Exception -> 0x05c4 }
            r2 = -1
            int r56 = r1.optInt(r13, r2)     // Catch:{ Exception -> 0x05c4 }
            r8 = r51
            java.lang.String r57 = r1.optString(r8, r11)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r58 = r1.optString(r12, r11)     // Catch:{ Exception -> 0x05c4 }
            r9 = r76
            int r59 = r1.optInt(r9, r2)     // Catch:{ Exception -> 0x05c4 }
            r15 = r75
            int r60 = r1.optInt(r15, r2)     // Catch:{ Exception -> 0x05c4 }
            r75 = r15
            r2 = r29
            r15 = 5000(0x1388, float:7.006E-42)
            int r61 = r1.optInt(r2, r15)     // Catch:{ Exception -> 0x05c4 }
            r29 = r2
            r15 = r30
            org.json.JSONArray r2 = r1.optJSONArray(r15)     // Catch:{ Exception -> 0x05c4 }
            if (r2 == 0) goto L_0x044c
            r30 = r15
            int r15 = r2.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r15 = new int[r15]     // Catch:{ Exception -> 0x05c4 }
            r76 = r9
            r34 = r12
            r9 = 0
        L_0x043a:
            int r12 = r2.length()     // Catch:{ Exception -> 0x05c4 }
            if (r9 >= r12) goto L_0x0449
            int r12 = r2.optInt(r9)     // Catch:{ Exception -> 0x05c4 }
            r15[r9] = r12     // Catch:{ Exception -> 0x05c4 }
            int r9 = r9 + 1
            goto L_0x043a
        L_0x0449:
            r62 = r15
            goto L_0x0454
        L_0x044c:
            r76 = r9
            r34 = r12
            r30 = r15
            r62 = r32
        L_0x0454:
            r2 = r33
            org.json.JSONArray r9 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x05c4 }
            if (r9 == 0) goto L_0x0477
            int r12 = r9.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r12 = new int[r12]     // Catch:{ Exception -> 0x05c4 }
            r33 = r2
            r15 = 0
        L_0x0465:
            int r2 = r9.length()     // Catch:{ Exception -> 0x05c4 }
            if (r15 >= r2) goto L_0x0474
            int r2 = r9.optInt(r15)     // Catch:{ Exception -> 0x05c4 }
            r12[r15] = r2     // Catch:{ Exception -> 0x05c4 }
            int r15 = r15 + 1
            goto L_0x0465
        L_0x0474:
            r63 = r12
            goto L_0x047b
        L_0x0477:
            r33 = r2
            r63 = r32
        L_0x047b:
            r2 = r31
            org.json.JSONArray r9 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x05c4 }
            if (r9 == 0) goto L_0x049e
            int r12 = r9.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r12 = new int[r12]     // Catch:{ Exception -> 0x05c4 }
            r31 = r2
            r15 = 0
        L_0x048c:
            int r2 = r9.length()     // Catch:{ Exception -> 0x05c4 }
            if (r15 >= r2) goto L_0x049b
            int r2 = r9.optInt(r15)     // Catch:{ Exception -> 0x05c4 }
            r12[r15] = r2     // Catch:{ Exception -> 0x05c4 }
            int r15 = r15 + 1
            goto L_0x048c
        L_0x049b:
            r64 = r12
            goto L_0x04a2
        L_0x049e:
            r31 = r2
            r64 = r32
        L_0x04a2:
            java.lang.String r2 = "nonConnectivityEvents"
            org.json.JSONArray r1 = r1.optJSONArray(r2)     // Catch:{ Exception -> 0x05c4 }
            if (r1 == 0) goto L_0x04c3
            int r2 = r1.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r2 = new int[r2]     // Catch:{ Exception -> 0x05c4 }
            r9 = 0
        L_0x04b1:
            int r12 = r1.length()     // Catch:{ Exception -> 0x05c4 }
            if (r9 >= r12) goto L_0x04c0
            int r12 = r1.optInt(r9)     // Catch:{ Exception -> 0x05c4 }
            r2[r9] = r12     // Catch:{ Exception -> 0x05c4 }
            int r9 = r9 + 1
            goto L_0x04b1
        L_0x04c0:
            r65 = r2
            goto L_0x04c5
        L_0x04c3:
            r65 = r32
        L_0x04c5:
            com.ironsource.sdk.controller.x r40 = new com.ironsource.sdk.controller.x     // Catch:{ Exception -> 0x05c4 }
            r53 = 0
            r52 = r40
            r52.<init>(r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65)     // Catch:{ Exception -> 0x05c4 }
            if (r28 == 0) goto L_0x0543
            java.lang.String r1 = "interstitial"
            r2 = r28
            org.json.JSONObject r1 = b(r2, r1)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "auctionData"
            java.lang.String r50 = r2.optString(r9, r11)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "auctioneerURL"
            java.lang.String r51 = r2.optString(r9, r11)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "extAuctioneerURL"
            java.lang.String r52 = r2.optString(r9, r11)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "auctionTrials"
            r12 = 2
            int r53 = r2.optInt(r9, r12)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "auctionSavedHistory"
            r12 = 15
            int r54 = r2.optInt(r9, r12)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "auctionTimeout"
            r15 = r13
            r12 = 10000(0x2710, double:4.9407E-320)
            long r55 = r2.optLong(r9, r12)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "compressAuctionRequest"
            r12 = 0
            boolean r68 = r2.optBoolean(r9, r12)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "compressAuctionResponse"
            boolean r69 = r2.optBoolean(r9, r12)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "encryptionVersion"
            r13 = 1
            int r71 = r2.optInt(r9, r13)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "programmatic"
            boolean r57 = r1.optBoolean(r9, r12)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "objectPerWaterfall"
            boolean r70 = r1.optBoolean(r9, r12)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r9 = "minTimeBeforeFirstAuction"
            r12 = 2000(0x7d0, float:2.803E-42)
            int r1 = r1.optInt(r9, r12)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.utils.c r9 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x05c4 }
            long r12 = (long) r1     // Catch:{ Exception -> 0x05c4 }
            r58 = r12
            r60 = 0
            r62 = 0
            r64 = 0
            r66 = 1
            r67 = 0
            r72 = 0
            r49 = r9
            r49.<init>(r50, r51, r52, r53, r54, r55, r57, r58, r60, r62, r64, r66, r67, r68, r69, r70, r71, r72)     // Catch:{ Exception -> 0x05c4 }
            r41 = r9
            goto L_0x054d
        L_0x0543:
            r15 = r13
            r2 = r28
            com.ironsource.mediationsdk.utils.c r1 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x05c4 }
            r1.<init>()     // Catch:{ Exception -> 0x05c4 }
            r41 = r1
        L_0x054d:
            com.ironsource.mediationsdk.model.h r1 = new com.ironsource.mediationsdk.model.h     // Catch:{ Exception -> 0x05c4 }
            r36 = r1
            r36.<init>(r37, r38, r39, r40, r41, r42, r43, r44, r45, r47, r48)     // Catch:{ Exception -> 0x05c4 }
            if (r7 == 0) goto L_0x05bf
            r9 = 0
        L_0x0557:
            int r12 = r7.length()     // Catch:{ Exception -> 0x05c4 }
            if (r9 >= r12) goto L_0x05bf
            org.json.JSONObject r12 = r7.optJSONObject(r9)     // Catch:{ Exception -> 0x05c4 }
            if (r12 == 0) goto L_0x0596
            java.lang.String r13 = "placementId"
            r28 = r7
            r7 = -1
            int r13 = r12.optInt(r13, r7)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r7 = "placementName"
            java.lang.String r7 = r12.optString(r7, r11)     // Catch:{ Exception -> 0x05c4 }
            r36 = r15
            java.lang.String r15 = "isDefault"
            r37 = r2
            r2 = 0
            boolean r15 = r12.optBoolean(r15, r2)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.m r2 = a(r12)     // Catch:{ Exception -> 0x05c4 }
            if (r13 < 0) goto L_0x059c
            boolean r12 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x05c4 }
            if (r12 != 0) goto L_0x059c
            com.ironsource.mediationsdk.model.InterstitialPlacement r12 = new com.ironsource.mediationsdk.model.InterstitialPlacement     // Catch:{ Exception -> 0x05c4 }
            r12.<init>(r13, r7, r15, r2)     // Catch:{ Exception -> 0x05c4 }
            if (r2 == 0) goto L_0x059e
            android.content.Context r2 = r6.bN     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.utils.j.a((android.content.Context) r2, (com.ironsource.mediationsdk.model.InterstitialPlacement) r12)     // Catch:{ Exception -> 0x05c4 }
            goto L_0x059e
        L_0x0596:
            r37 = r2
            r28 = r7
            r36 = r15
        L_0x059c:
            r12 = r32
        L_0x059e:
            if (r12 == 0) goto L_0x05b6
            if (r12 == 0) goto L_0x05b6
            java.util.ArrayList<com.ironsource.mediationsdk.model.InterstitialPlacement> r2 = r1.a     // Catch:{ Exception -> 0x05c4 }
            r2.add(r12)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.InterstitialPlacement r2 = r1.m     // Catch:{ Exception -> 0x05c4 }
            if (r2 != 0) goto L_0x05ae
        L_0x05ab:
            r1.m = r12     // Catch:{ Exception -> 0x05c4 }
            goto L_0x05b6
        L_0x05ae:
            r2 = 0
            boolean r7 = r12.isPlacementId(r2)     // Catch:{ Exception -> 0x05c4 }
            if (r7 == 0) goto L_0x05b6
            goto L_0x05ab
        L_0x05b6:
            int r9 = r9 + 1
            r7 = r28
            r15 = r36
            r2 = r37
            goto L_0x0557
        L_0x05bf:
            r37 = r2
            r36 = r15
            goto L_0x05d4
        L_0x05c4:
            r0 = move-exception
            goto L_0x0dbe
        L_0x05c7:
            r27 = r1
            r36 = r13
            r8 = r15
            r37 = r28
            r3 = r34
            r34 = r12
            r1 = r32
        L_0x05d4:
            if (r26 == 0) goto L_0x082b
            r2 = r26
            org.json.JSONArray r7 = r2.optJSONArray(r3)     // Catch:{ Exception -> 0x05c4 }
            r9 = r35
            org.json.JSONObject r12 = b(r2, r9)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r13 = "providers"
            org.json.JSONObject r13 = r6.c(r2, r13)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r15 = "maxNumOfAdaptersToLoadOnStart"
            r26 = r1
            r1 = 1
            int r15 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r15, (int) r1)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "atim"
            r28 = r7
            r6 = 10000(0x2710, double:4.9407E-320)
            long r40 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r1, (long) r6)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "delayLoadFailure"
            r6 = 3
            int r46 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r6)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "bannerInterval"
            r6 = 60
            int r44 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r6)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "isOneFlow"
            r6 = 0
            boolean r47 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r1, (boolean) r6)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "collectBiddingDataAsyncEnabled"
            boolean r48 = r2.optBoolean(r1, r6)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "collectBiddingDataTimeout"
            r6 = 3000(0xbb8, double:1.482E-320)
            long r49 = r2.optLong(r1, r6)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "parallelInit"
            r6 = 0
            boolean r51 = r13.optBoolean(r1, r6)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "waitUntilAllProvidersFinishInit"
            boolean r52 = r13.optBoolean(r1, r6)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r1 = "advancedLoading"
            int r1 = a((org.json.JSONObject) r2, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r6)     // Catch:{ Exception -> 0x0376 }
            if (r1 <= 0) goto L_0x063a
            r39 = r1
            r42 = 1
            goto L_0x063e
        L_0x063a:
            r39 = r15
            r42 = 0
        L_0x063e:
            org.json.JSONObject r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r12, r10)     // Catch:{ Exception -> 0x0376 }
            boolean r55 = r1.optBoolean(r4, r6)     // Catch:{ Exception -> 0x0376 }
            boolean r56 = r1.optBoolean(r14, r6)     // Catch:{ Exception -> 0x0376 }
            r2 = r36
            r6 = -1
            int r57 = r1.optInt(r2, r6)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r58 = r1.optString(r8, r11)     // Catch:{ Exception -> 0x0376 }
            r7 = r34
            java.lang.String r59 = r1.optString(r7, r11)     // Catch:{ Exception -> 0x0376 }
            r12 = r76
            int r60 = r1.optInt(r12, r6)     // Catch:{ Exception -> 0x0376 }
            r13 = r75
            int r61 = r1.optInt(r13, r6)     // Catch:{ Exception -> 0x0376 }
            r6 = r29
            r15 = 5000(0x1388, float:7.006E-42)
            int r62 = r1.optInt(r6, r15)     // Catch:{ Exception -> 0x0376 }
            r29 = r6
            r15 = r30
            org.json.JSONArray r6 = r1.optJSONArray(r15)     // Catch:{ Exception -> 0x0376 }
            if (r6 == 0) goto L_0x0698
            r30 = r15
            int r15 = r6.length()     // Catch:{ Exception -> 0x0376 }
            int[] r15 = new int[r15]     // Catch:{ Exception -> 0x0376 }
            r76 = r12
            r75 = r13
            r13 = 0
        L_0x0686:
            int r12 = r6.length()     // Catch:{ Exception -> 0x0376 }
            if (r13 >= r12) goto L_0x0695
            int r12 = r6.optInt(r13)     // Catch:{ Exception -> 0x0376 }
            r15[r13] = r12     // Catch:{ Exception -> 0x0376 }
            int r13 = r13 + 1
            goto L_0x0686
        L_0x0695:
            r63 = r15
            goto L_0x06a0
        L_0x0698:
            r76 = r12
            r75 = r13
            r30 = r15
            r63 = r32
        L_0x06a0:
            r6 = r33
            org.json.JSONArray r12 = r1.optJSONArray(r6)     // Catch:{ Exception -> 0x0376 }
            if (r12 == 0) goto L_0x06c3
            int r13 = r12.length()     // Catch:{ Exception -> 0x0376 }
            int[] r13 = new int[r13]     // Catch:{ Exception -> 0x0376 }
            r33 = r6
            r15 = 0
        L_0x06b1:
            int r6 = r12.length()     // Catch:{ Exception -> 0x0376 }
            if (r15 >= r6) goto L_0x06c0
            int r6 = r12.optInt(r15)     // Catch:{ Exception -> 0x0376 }
            r13[r15] = r6     // Catch:{ Exception -> 0x0376 }
            int r15 = r15 + 1
            goto L_0x06b1
        L_0x06c0:
            r64 = r13
            goto L_0x06c7
        L_0x06c3:
            r33 = r6
            r64 = r32
        L_0x06c7:
            r6 = r31
            org.json.JSONArray r12 = r1.optJSONArray(r6)     // Catch:{ Exception -> 0x0376 }
            if (r12 == 0) goto L_0x06ea
            int r13 = r12.length()     // Catch:{ Exception -> 0x0376 }
            int[] r13 = new int[r13]     // Catch:{ Exception -> 0x0376 }
            r31 = r6
            r15 = 0
        L_0x06d8:
            int r6 = r12.length()     // Catch:{ Exception -> 0x0376 }
            if (r15 >= r6) goto L_0x06e7
            int r6 = r12.optInt(r15)     // Catch:{ Exception -> 0x0376 }
            r13[r15] = r6     // Catch:{ Exception -> 0x0376 }
            int r15 = r15 + 1
            goto L_0x06d8
        L_0x06e7:
            r65 = r13
            goto L_0x06ee
        L_0x06ea:
            r31 = r6
            r65 = r32
        L_0x06ee:
            java.lang.String r6 = "nonConnectivityEvents"
            org.json.JSONArray r1 = r1.optJSONArray(r6)     // Catch:{ Exception -> 0x0376 }
            if (r1 == 0) goto L_0x070f
            int r6 = r1.length()     // Catch:{ Exception -> 0x0376 }
            int[] r6 = new int[r6]     // Catch:{ Exception -> 0x0376 }
            r12 = 0
        L_0x06fd:
            int r13 = r1.length()     // Catch:{ Exception -> 0x0376 }
            if (r12 >= r13) goto L_0x070c
            int r13 = r1.optInt(r12)     // Catch:{ Exception -> 0x0376 }
            r6[r12] = r13     // Catch:{ Exception -> 0x0376 }
            int r12 = r12 + 1
            goto L_0x06fd
        L_0x070c:
            r66 = r6
            goto L_0x0711
        L_0x070f:
            r66 = r32
        L_0x0711:
            com.ironsource.sdk.controller.x r43 = new com.ironsource.sdk.controller.x     // Catch:{ Exception -> 0x0376 }
            r54 = 0
            r53 = r43
            r53.<init>(r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65, r66)     // Catch:{ Exception -> 0x0376 }
            if (r37 == 0) goto L_0x079f
            java.lang.String r1 = "banner"
            r6 = r37
            org.json.JSONObject r1 = b(r6, r1)     // Catch:{ Exception -> 0x0376 }
            if (r1 == 0) goto L_0x0796
            java.lang.String r12 = "auctionData"
            java.lang.String r78 = r6.optString(r12, r11)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r12 = "auctioneerURL"
            java.lang.String r79 = r6.optString(r12, r11)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r12 = "extAuctioneerURL"
            java.lang.String r80 = r6.optString(r12, r11)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r12 = "auctionTrials"
            r13 = 2
            int r81 = r6.optInt(r12, r13)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r12 = "auctionSavedHistory"
            r13 = 15
            int r82 = r6.optInt(r12, r13)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r12 = "auctionTimeout"
            r34 = r7
            r15 = r8
            r7 = 10000(0x2710, double:4.9407E-320)
            long r83 = r6.optLong(r12, r7)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "compressAuctionRequest"
            r8 = 0
            boolean r96 = r6.optBoolean(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "compressAuctionResponse"
            boolean r97 = r6.optBoolean(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "encryptionVersion"
            r12 = 1
            int r99 = r6.optInt(r7, r12)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "programmatic"
            boolean r85 = r1.optBoolean(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "objectPerWaterfall"
            boolean r98 = r1.optBoolean(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r7 = "minTimeBeforeFirstAuction"
            r8 = 2000(0x7d0, float:2.803E-42)
            int r7 = r1.optInt(r7, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r8 = "shouldSendBannerBURLFromImpression"
            r12 = 1
            boolean r100 = r1.optBoolean(r8, r12)     // Catch:{ Exception -> 0x0376 }
            com.ironsource.mediationsdk.utils.c r1 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0376 }
            long r7 = (long) r7     // Catch:{ Exception -> 0x0376 }
            r86 = r7
            r88 = 0
            r90 = 0
            r92 = 0
            r94 = 1
            r95 = 0
            r77 = r1
            r77.<init>(r78, r79, r80, r81, r82, r83, r85, r86, r88, r90, r92, r94, r95, r96, r97, r98, r99, r100)     // Catch:{ Exception -> 0x0376 }
            goto L_0x07a9
        L_0x0796:
            r34 = r7
            r15 = r8
            com.ironsource.mediationsdk.utils.c r1 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0376 }
            r1.<init>()     // Catch:{ Exception -> 0x0376 }
            goto L_0x07a9
        L_0x079f:
            r34 = r7
            r15 = r8
            r6 = r37
            com.ironsource.mediationsdk.utils.c r1 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x0376 }
            r1.<init>()     // Catch:{ Exception -> 0x0376 }
        L_0x07a9:
            r45 = r1
            com.ironsource.mediationsdk.model.d r1 = new com.ironsource.mediationsdk.model.d     // Catch:{ Exception -> 0x0376 }
            r38 = r1
            r38.<init>(r39, r40, r42, r43, r44, r45, r46, r47, r48, r49, r51, r52)     // Catch:{ Exception -> 0x0376 }
            if (r28 == 0) goto L_0x0824
            r7 = 0
        L_0x07b5:
            int r8 = r28.length()     // Catch:{ Exception -> 0x0376 }
            if (r7 >= r8) goto L_0x0824
            r8 = r28
            org.json.JSONObject r12 = r8.optJSONObject(r7)     // Catch:{ Exception -> 0x0376 }
            if (r12 == 0) goto L_0x07fb
            java.lang.String r13 = "placementId"
            r28 = r8
            r8 = -1
            int r13 = r12.optInt(r13, r8)     // Catch:{ Exception -> 0x0376 }
            java.lang.String r8 = "placementName"
            java.lang.String r8 = r12.optString(r8, r11)     // Catch:{ Exception -> 0x0376 }
            r51 = r15
            java.lang.String r15 = "isDefault"
            r37 = r6
            r6 = 0
            boolean r15 = r12.optBoolean(r15, r6)     // Catch:{ Exception -> 0x0376 }
            com.ironsource.mediationsdk.model.m r6 = a(r12)     // Catch:{ Exception -> 0x0376 }
            if (r13 < 0) goto L_0x0801
            boolean r12 = android.text.TextUtils.isEmpty(r8)     // Catch:{ Exception -> 0x0376 }
            if (r12 != 0) goto L_0x0801
            com.ironsource.mediationsdk.model.e r12 = new com.ironsource.mediationsdk.model.e     // Catch:{ Exception -> 0x0376 }
            r12.<init>(r13, r8, r15, r6)     // Catch:{ Exception -> 0x0376 }
            if (r6 == 0) goto L_0x07f8
            r6 = r101
            android.content.Context r8 = r6.bN     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.utils.j.a((android.content.Context) r8, (com.ironsource.mediationsdk.model.e) r12)     // Catch:{ Exception -> 0x05c4 }
            goto L_0x0805
        L_0x07f8:
            r6 = r101
            goto L_0x0805
        L_0x07fb:
            r37 = r6
            r28 = r8
            r51 = r15
        L_0x0801:
            r6 = r101
            r12 = r32
        L_0x0805:
            if (r12 == 0) goto L_0x081d
            if (r12 == 0) goto L_0x081d
            java.util.ArrayList<com.ironsource.mediationsdk.model.e> r8 = r1.e     // Catch:{ Exception -> 0x05c4 }
            r8.add(r12)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.e r8 = r1.f     // Catch:{ Exception -> 0x05c4 }
            if (r8 != 0) goto L_0x0815
        L_0x0812:
            r1.f = r12     // Catch:{ Exception -> 0x05c4 }
            goto L_0x081d
        L_0x0815:
            r8 = 0
            boolean r13 = r12.isPlacementId(r8)     // Catch:{ Exception -> 0x05c4 }
            if (r13 == 0) goto L_0x081d
            goto L_0x0812
        L_0x081d:
            int r7 = r7 + 1
            r6 = r37
            r15 = r51
            goto L_0x07b5
        L_0x0824:
            r37 = r6
            r51 = r15
            r6 = r101
            goto L_0x0835
        L_0x082b:
            r26 = r1
            r51 = r8
            r9 = r35
            r2 = r36
            r1 = r32
        L_0x0835:
            if (r25 == 0) goto L_0x0a51
            r7 = r25
            org.json.JSONArray r8 = r7.optJSONArray(r3)     // Catch:{ Exception -> 0x05c4 }
            org.json.JSONObject r12 = b(r7, r9)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r13 = "providers"
            org.json.JSONObject r13 = r6.c(r7, r13)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r15 = "maxNumOfAdaptersToLoadOnStart"
            r25 = r1
            r1 = 1
            int r15 = a((org.json.JSONObject) r7, (org.json.JSONObject) r5, (java.lang.String) r15, (int) r1)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "atim"
            r28 = r8
            r35 = r9
            r8 = 10000(0x2710, double:4.9407E-320)
            long r40 = a((org.json.JSONObject) r7, (org.json.JSONObject) r5, (java.lang.String) r1, (long) r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "delayLoadFailure"
            r8 = 0
            int r45 = a((org.json.JSONObject) r7, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "collectBiddingDataAsyncEnabled"
            boolean r46 = r7.optBoolean(r1, r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "collectBiddingDataTimeout"
            r8 = 3000(0xbb8, double:1.482E-320)
            long r47 = r7.optLong(r1, r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "parallelInit"
            r8 = 0
            boolean r49 = r13.optBoolean(r1, r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "waitUntilAllProvidersFinishInit"
            boolean r50 = r13.optBoolean(r1, r8)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "advancedLoading"
            int r1 = a((org.json.JSONObject) r7, (org.json.JSONObject) r5, (java.lang.String) r1, (int) r8)     // Catch:{ Exception -> 0x05c4 }
            if (r1 <= 0) goto L_0x088c
            r39 = r1
            r42 = 1
            goto L_0x0890
        L_0x088c:
            r39 = r15
            r42 = 0
        L_0x0890:
            org.json.JSONObject r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r12, r10)     // Catch:{ Exception -> 0x05c4 }
            boolean r54 = r1.optBoolean(r4, r8)     // Catch:{ Exception -> 0x05c4 }
            boolean r55 = r1.optBoolean(r14, r8)     // Catch:{ Exception -> 0x05c4 }
            r7 = -1
            int r56 = r1.optInt(r2, r7)     // Catch:{ Exception -> 0x05c4 }
            r8 = r51
            java.lang.String r57 = r1.optString(r8, r11)     // Catch:{ Exception -> 0x05c4 }
            r9 = r34
            java.lang.String r58 = r1.optString(r9, r11)     // Catch:{ Exception -> 0x05c4 }
            r12 = r76
            int r59 = r1.optInt(r12, r7)     // Catch:{ Exception -> 0x05c4 }
            r13 = r75
            int r60 = r1.optInt(r13, r7)     // Catch:{ Exception -> 0x05c4 }
            r7 = r29
            r15 = 5000(0x1388, float:7.006E-42)
            int r61 = r1.optInt(r7, r15)     // Catch:{ Exception -> 0x05c4 }
            r29 = r5
            r15 = r30
            org.json.JSONArray r5 = r1.optJSONArray(r15)     // Catch:{ Exception -> 0x05c4 }
            if (r5 == 0) goto L_0x08ea
            r34 = r3
            int r3 = r5.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r3 = new int[r3]     // Catch:{ Exception -> 0x05c4 }
            r36 = r7
            r30 = r15
            r15 = 0
        L_0x08d8:
            int r7 = r5.length()     // Catch:{ Exception -> 0x05c4 }
            if (r15 >= r7) goto L_0x08e7
            int r7 = r5.optInt(r15)     // Catch:{ Exception -> 0x05c4 }
            r3[r15] = r7     // Catch:{ Exception -> 0x05c4 }
            int r15 = r15 + 1
            goto L_0x08d8
        L_0x08e7:
            r62 = r3
            goto L_0x08f2
        L_0x08ea:
            r34 = r3
            r36 = r7
            r30 = r15
            r62 = r32
        L_0x08f2:
            r3 = r33
            org.json.JSONArray r5 = r1.optJSONArray(r3)     // Catch:{ Exception -> 0x05c4 }
            if (r5 == 0) goto L_0x0915
            int r7 = r5.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r7 = new int[r7]     // Catch:{ Exception -> 0x05c4 }
            r33 = r3
            r15 = 0
        L_0x0903:
            int r3 = r5.length()     // Catch:{ Exception -> 0x05c4 }
            if (r15 >= r3) goto L_0x0912
            int r3 = r5.optInt(r15)     // Catch:{ Exception -> 0x05c4 }
            r7[r15] = r3     // Catch:{ Exception -> 0x05c4 }
            int r15 = r15 + 1
            goto L_0x0903
        L_0x0912:
            r63 = r7
            goto L_0x0919
        L_0x0915:
            r33 = r3
            r63 = r32
        L_0x0919:
            r3 = r31
            org.json.JSONArray r5 = r1.optJSONArray(r3)     // Catch:{ Exception -> 0x05c4 }
            if (r5 == 0) goto L_0x093c
            int r7 = r5.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r7 = new int[r7]     // Catch:{ Exception -> 0x05c4 }
            r31 = r3
            r15 = 0
        L_0x092a:
            int r3 = r5.length()     // Catch:{ Exception -> 0x05c4 }
            if (r15 >= r3) goto L_0x0939
            int r3 = r5.optInt(r15)     // Catch:{ Exception -> 0x05c4 }
            r7[r15] = r3     // Catch:{ Exception -> 0x05c4 }
            int r15 = r15 + 1
            goto L_0x092a
        L_0x0939:
            r64 = r7
            goto L_0x0940
        L_0x093c:
            r31 = r3
            r64 = r32
        L_0x0940:
            java.lang.String r3 = "nonConnectivityEvents"
            org.json.JSONArray r1 = r1.optJSONArray(r3)     // Catch:{ Exception -> 0x05c4 }
            if (r1 == 0) goto L_0x0961
            int r3 = r1.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r3 = new int[r3]     // Catch:{ Exception -> 0x05c4 }
            r5 = 0
        L_0x094f:
            int r7 = r1.length()     // Catch:{ Exception -> 0x05c4 }
            if (r5 >= r7) goto L_0x095e
            int r7 = r1.optInt(r5)     // Catch:{ Exception -> 0x05c4 }
            r3[r5] = r7     // Catch:{ Exception -> 0x05c4 }
            int r5 = r5 + 1
            goto L_0x094f
        L_0x095e:
            r65 = r3
            goto L_0x0963
        L_0x0961:
            r65 = r32
        L_0x0963:
            com.ironsource.sdk.controller.x r43 = new com.ironsource.sdk.controller.x     // Catch:{ Exception -> 0x05c4 }
            r53 = 0
            r52 = r43
            r52.<init>(r53, r54, r55, r56, r57, r58, r59, r60, r61, r62, r63, r64, r65)     // Catch:{ Exception -> 0x05c4 }
            if (r37 == 0) goto L_0x09e8
            java.lang.String r1 = "nativeAd"
            r3 = r37
            org.json.JSONObject r1 = b(r3, r1)     // Catch:{ Exception -> 0x05c4 }
            if (r1 == 0) goto L_0x09de
            java.lang.String r5 = "auctionData"
            java.lang.String r52 = r3.optString(r5, r11)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "auctioneerURL"
            java.lang.String r53 = r3.optString(r5, r11)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "extAuctioneerURL"
            java.lang.String r54 = r3.optString(r5, r11)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "auctionTrials"
            r7 = 2
            int r55 = r3.optInt(r5, r7)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "auctionSavedHistory"
            r7 = 15
            int r56 = r3.optInt(r5, r7)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "auctionTimeout"
            r76 = r12
            r75 = r13
            r12 = 10000(0x2710, double:4.9407E-320)
            long r57 = r3.optLong(r5, r12)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "compressAuctionRequest"
            r7 = 0
            boolean r70 = r3.optBoolean(r5, r7)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "compressAuctionResponse"
            boolean r71 = r3.optBoolean(r5, r7)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "encryptionVersion"
            r7 = 1
            int r73 = r3.optInt(r5, r7)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "minTimeBeforeFirstAuction"
            r7 = 2000(0x7d0, float:2.803E-42)
            int r1 = r1.optInt(r5, r7)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.utils.c r5 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x05c4 }
            r59 = 1
            long r12 = (long) r1     // Catch:{ Exception -> 0x05c4 }
            r60 = r12
            r62 = 0
            r64 = 0
            r66 = 0
            r68 = 1
            r69 = 0
            r72 = 1
            r74 = 0
            r51 = r5
            r51.<init>(r52, r53, r54, r55, r56, r57, r59, r60, r62, r64, r66, r68, r69, r70, r71, r72, r73, r74)     // Catch:{ Exception -> 0x05c4 }
            r44 = r5
            goto L_0x09f5
        L_0x09de:
            r76 = r12
            r75 = r13
            com.ironsource.mediationsdk.utils.c r1 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x05c4 }
            r1.<init>()     // Catch:{ Exception -> 0x05c4 }
            goto L_0x09f3
        L_0x09e8:
            r76 = r12
            r75 = r13
            r3 = r37
            com.ironsource.mediationsdk.utils.c r1 = new com.ironsource.mediationsdk.utils.c     // Catch:{ Exception -> 0x05c4 }
            r1.<init>()     // Catch:{ Exception -> 0x05c4 }
        L_0x09f3:
            r44 = r1
        L_0x09f5:
            com.ironsource.mediationsdk.model.i r1 = new com.ironsource.mediationsdk.model.i     // Catch:{ Exception -> 0x05c4 }
            r38 = r1
            r38.<init>(r39, r40, r42, r43, r44, r45, r46, r47, r49, r50)     // Catch:{ Exception -> 0x05c4 }
            if (r28 == 0) goto L_0x0a4e
            r5 = 0
        L_0x09ff:
            int r7 = r28.length()     // Catch:{ Exception -> 0x05c4 }
            if (r5 >= r7) goto L_0x0a4e
            r7 = r28
            org.json.JSONObject r12 = r7.optJSONObject(r5)     // Catch:{ Exception -> 0x05c4 }
            if (r12 == 0) goto L_0x0a3e
            java.lang.String r13 = "placementId"
            r15 = -1
            int r13 = r12.optInt(r13, r15)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r15 = "placementName"
            java.lang.String r15 = r12.optString(r15, r11)     // Catch:{ Exception -> 0x05c4 }
            r28 = r7
            java.lang.String r7 = "isDefault"
            r37 = r3
            r3 = 0
            boolean r7 = r12.optBoolean(r7, r3)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.m r3 = a(r12)     // Catch:{ Exception -> 0x05c4 }
            if (r13 < 0) goto L_0x0a42
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x05c4 }
            if (r12 != 0) goto L_0x0a42
            com.ironsource.mediationsdk.model.j r12 = new com.ironsource.mediationsdk.model.j     // Catch:{ Exception -> 0x05c4 }
            r12.<init>(r13, r15, r7, r3)     // Catch:{ Exception -> 0x05c4 }
            if (r3 == 0) goto L_0x0a44
            android.content.Context r3 = r6.bN     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.utils.j.a((android.content.Context) r3, (com.ironsource.mediationsdk.model.j) r12)     // Catch:{ Exception -> 0x05c4 }
            goto L_0x0a44
        L_0x0a3e:
            r37 = r3
            r28 = r7
        L_0x0a42:
            r12 = r32
        L_0x0a44:
            if (r12 == 0) goto L_0x0a49
            r1.a((com.ironsource.mediationsdk.model.j) r12)     // Catch:{ Exception -> 0x05c4 }
        L_0x0a49:
            int r5 = r5 + 1
            r3 = r37
            goto L_0x09ff
        L_0x0a4e:
            r37 = r3
            goto L_0x0a61
        L_0x0a51:
            r25 = r1
            r35 = r9
            r36 = r29
            r9 = r34
            r8 = r51
            r34 = r3
            r29 = r5
            r1 = r32
        L_0x0a61:
            if (r24 == 0) goto L_0x0b98
            r3 = r24
            r5 = r35
            org.json.JSONObject r7 = b(r3, r5)     // Catch:{ Exception -> 0x05c4 }
            org.json.JSONObject r7 = com.ironsource.mediationsdk.utils.IronSourceUtils.mergeJsons(r7, r10)     // Catch:{ Exception -> 0x05c4 }
            r12 = 0
            boolean r40 = r7.optBoolean(r4, r12)     // Catch:{ Exception -> 0x05c4 }
            boolean r41 = r7.optBoolean(r14, r12)     // Catch:{ Exception -> 0x05c4 }
            r4 = -1
            int r42 = r7.optInt(r2, r4)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r43 = r7.optString(r8, r11)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r44 = r7.optString(r9, r11)     // Catch:{ Exception -> 0x05c4 }
            r8 = r76
            int r45 = r7.optInt(r8, r4)     // Catch:{ Exception -> 0x05c4 }
            r8 = r75
            int r46 = r7.optInt(r8, r4)     // Catch:{ Exception -> 0x05c4 }
            r4 = r36
            r8 = 5000(0x1388, float:7.006E-42)
            int r47 = r7.optInt(r4, r8)     // Catch:{ Exception -> 0x05c4 }
            r4 = r30
            org.json.JSONArray r8 = r7.optJSONArray(r4)     // Catch:{ Exception -> 0x05c4 }
            if (r8 == 0) goto L_0x0aba
            int r9 = r8.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r9 = new int[r9]     // Catch:{ Exception -> 0x05c4 }
            r12 = 0
        L_0x0aa8:
            int r13 = r8.length()     // Catch:{ Exception -> 0x05c4 }
            if (r12 >= r13) goto L_0x0ab7
            int r13 = r8.optInt(r12)     // Catch:{ Exception -> 0x05c4 }
            r9[r12] = r13     // Catch:{ Exception -> 0x05c4 }
            int r12 = r12 + 1
            goto L_0x0aa8
        L_0x0ab7:
            r48 = r9
            goto L_0x0abc
        L_0x0aba:
            r48 = r32
        L_0x0abc:
            r8 = r33
            org.json.JSONArray r9 = r7.optJSONArray(r8)     // Catch:{ Exception -> 0x05c4 }
            if (r9 == 0) goto L_0x0add
            int r12 = r9.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r12 = new int[r12]     // Catch:{ Exception -> 0x05c4 }
            r13 = 0
        L_0x0acb:
            int r15 = r9.length()     // Catch:{ Exception -> 0x05c4 }
            if (r13 >= r15) goto L_0x0ada
            int r15 = r9.optInt(r13)     // Catch:{ Exception -> 0x05c4 }
            r12[r13] = r15     // Catch:{ Exception -> 0x05c4 }
            int r13 = r13 + 1
            goto L_0x0acb
        L_0x0ada:
            r49 = r12
            goto L_0x0adf
        L_0x0add:
            r49 = r32
        L_0x0adf:
            r9 = r31
            org.json.JSONArray r9 = r7.optJSONArray(r9)     // Catch:{ Exception -> 0x05c4 }
            if (r9 == 0) goto L_0x0b00
            int r12 = r9.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r12 = new int[r12]     // Catch:{ Exception -> 0x05c4 }
            r13 = 0
        L_0x0aee:
            int r15 = r9.length()     // Catch:{ Exception -> 0x05c4 }
            if (r13 >= r15) goto L_0x0afd
            int r15 = r9.optInt(r13)     // Catch:{ Exception -> 0x05c4 }
            r12[r13] = r15     // Catch:{ Exception -> 0x05c4 }
            int r13 = r13 + 1
            goto L_0x0aee
        L_0x0afd:
            r50 = r12
            goto L_0x0b02
        L_0x0b00:
            r50 = r32
        L_0x0b02:
            java.lang.String r9 = "nonConnectivityEvents"
            org.json.JSONArray r7 = r7.optJSONArray(r9)     // Catch:{ Exception -> 0x05c4 }
            if (r7 == 0) goto L_0x0b23
            int r9 = r7.length()     // Catch:{ Exception -> 0x05c4 }
            int[] r9 = new int[r9]     // Catch:{ Exception -> 0x05c4 }
            r12 = 0
        L_0x0b11:
            int r13 = r7.length()     // Catch:{ Exception -> 0x05c4 }
            if (r12 >= r13) goto L_0x0b20
            int r13 = r7.optInt(r12)     // Catch:{ Exception -> 0x05c4 }
            r9[r12] = r13     // Catch:{ Exception -> 0x05c4 }
            int r12 = r12 + 1
            goto L_0x0b11
        L_0x0b20:
            r51 = r9
            goto L_0x0b25
        L_0x0b23:
            r51 = r32
        L_0x0b25:
            com.ironsource.sdk.controller.x r7 = new com.ironsource.sdk.controller.x     // Catch:{ Exception -> 0x05c4 }
            r39 = 0
            r38 = r7
            r38.<init>(r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.k r9 = new com.ironsource.mediationsdk.model.k     // Catch:{ Exception -> 0x05c4 }
            r9.<init>(r7)     // Catch:{ Exception -> 0x05c4 }
            r9.d = r3     // Catch:{ Exception -> 0x05c4 }
            r7 = r34
            org.json.JSONArray r3 = r3.optJSONArray(r7)     // Catch:{ Exception -> 0x05c4 }
            if (r3 == 0) goto L_0x0b95
            r7 = 0
        L_0x0b3e:
            int r12 = r3.length()     // Catch:{ Exception -> 0x05c4 }
            if (r7 >= r12) goto L_0x0b95
            org.json.JSONObject r12 = r3.optJSONObject(r7)     // Catch:{ Exception -> 0x05c4 }
            if (r12 == 0) goto L_0x0b70
            java.lang.String r13 = "placementId"
            r15 = -1
            int r13 = r12.optInt(r13, r15)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r15 = "placementName"
            java.lang.String r15 = r12.optString(r15, r11)     // Catch:{ Exception -> 0x05c4 }
            r24 = r3
            java.lang.String r3 = "isDefault"
            r35 = r5
            r5 = 0
            boolean r3 = r12.optBoolean(r3, r5)     // Catch:{ Exception -> 0x05c4 }
            if (r13 < 0) goto L_0x0b74
            boolean r5 = android.text.TextUtils.isEmpty(r15)     // Catch:{ Exception -> 0x05c4 }
            if (r5 != 0) goto L_0x0b74
            com.ironsource.mediationsdk.model.l r5 = new com.ironsource.mediationsdk.model.l     // Catch:{ Exception -> 0x05c4 }
            r5.<init>(r13, r15, r3)     // Catch:{ Exception -> 0x05c4 }
            goto L_0x0b76
        L_0x0b70:
            r24 = r3
            r35 = r5
        L_0x0b74:
            r5 = r32
        L_0x0b76:
            if (r5 == 0) goto L_0x0b8e
            if (r5 == 0) goto L_0x0b8e
            java.util.ArrayList<com.ironsource.mediationsdk.model.l> r3 = r9.a     // Catch:{ Exception -> 0x05c4 }
            r3.add(r5)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.l r3 = r9.b     // Catch:{ Exception -> 0x05c4 }
            if (r3 != 0) goto L_0x0b86
        L_0x0b83:
            r9.b = r5     // Catch:{ Exception -> 0x05c4 }
            goto L_0x0b8e
        L_0x0b86:
            r3 = 0
            boolean r12 = r5.isPlacementId(r3)     // Catch:{ Exception -> 0x05c4 }
            if (r12 == 0) goto L_0x0b8e
            goto L_0x0b83
        L_0x0b8e:
            int r7 = r7 + 1
            r3 = r24
            r5 = r35
            goto L_0x0b3e
        L_0x0b95:
            r35 = r5
            goto L_0x0b9e
        L_0x0b98:
            r4 = r30
            r8 = r33
            r9 = r32
        L_0x0b9e:
            com.ironsource.mediationsdk.utils.n r3 = new com.ironsource.mediationsdk.utils.n     // Catch:{ Exception -> 0x05c4 }
            r3.<init>()     // Catch:{ Exception -> 0x05c4 }
            if (r23 == 0) goto L_0x0be5
            java.lang.String r5 = "optInKeys"
            r7 = r23
            org.json.JSONArray r5 = r7.optJSONArray(r5)     // Catch:{ Exception -> 0x05c4 }
            if (r5 == 0) goto L_0x0bc8
            r12 = 0
        L_0x0bb0:
            int r13 = r5.length()     // Catch:{ Exception -> 0x05c4 }
            if (r12 >= r13) goto L_0x0bc8
            java.lang.String r13 = r5.optString(r12)     // Catch:{ Exception -> 0x05c4 }
            boolean r15 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x05c4 }
            if (r15 != 0) goto L_0x0bc5
            java.util.ArrayList<java.lang.String> r15 = r3.a     // Catch:{ Exception -> 0x05c4 }
            r15.add(r13)     // Catch:{ Exception -> 0x05c4 }
        L_0x0bc5:
            int r12 = r12 + 1
            goto L_0x0bb0
        L_0x0bc8:
            java.lang.String r5 = "tokenGenericParams"
            org.json.JSONObject r5 = r7.optJSONObject(r5)     // Catch:{ Exception -> 0x05c4 }
            if (r5 == 0) goto L_0x0bd3
            r3.c = r5     // Catch:{ Exception -> 0x05c4 }
        L_0x0bd3:
            java.lang.String r5 = "oneToken"
            r12 = 0
            boolean r5 = r7.optBoolean(r5, r12)     // Catch:{ Exception -> 0x05c4 }
            r3.d = r5     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "compressToken"
            r12 = 1
            boolean r5 = r7.optBoolean(r5, r12)     // Catch:{ Exception -> 0x05c4 }
            r3.e = r5     // Catch:{ Exception -> 0x05c4 }
        L_0x0be5:
            com.ironsource.mediationsdk.utils.i r5 = new com.ironsource.mediationsdk.utils.i     // Catch:{ Exception -> 0x05c4 }
            r5.<init>()     // Catch:{ Exception -> 0x05c4 }
            if (r22 == 0) goto L_0x0c01
            java.lang.String r7 = "pixelEventsUrl"
            java.lang.String r12 = "https://outcome-ssp.supersonicads.com/mediation?adUnit=3"
            r13 = r22
            java.lang.String r7 = r13.optString(r7, r12)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r12 = "pixelEventsEnabled"
            r15 = 1
            boolean r13 = r13.optBoolean(r12, r15)     // Catch:{ Exception -> 0x05c4 }
            r5.a((java.lang.String) r7)     // Catch:{ Exception -> 0x05c4 }
            goto L_0x0c03
        L_0x0c01:
            r15 = 1
            r13 = 1
        L_0x0c03:
            r5.a((boolean) r13)     // Catch:{ Exception -> 0x05c4 }
            if (r13 == 0) goto L_0x0c26
            int[] r4 = a(r10, r4)     // Catch:{ Exception -> 0x05c4 }
            r5.a((int[]) r4)     // Catch:{ Exception -> 0x05c4 }
            int[] r4 = a(r10, r8)     // Catch:{ Exception -> 0x05c4 }
            r5.b((int[]) r4)     // Catch:{ Exception -> 0x05c4 }
            r4 = 0
            boolean r7 = r10.optBoolean(r14, r4)     // Catch:{ Exception -> 0x05c4 }
            r5.b((boolean) r7)     // Catch:{ Exception -> 0x05c4 }
            r4 = -1
            int r2 = r10.optInt(r2, r4)     // Catch:{ Exception -> 0x05c4 }
            r5.a((int) r2)     // Catch:{ Exception -> 0x05c4 }
        L_0x0c26:
            java.lang.String r2 = "server"
            r4 = r21
            r7 = 3
            int r2 = r4.optInt(r2, r7)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r8 = "publisher"
            int r8 = r4.optInt(r8, r7)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r12 = "console"
            int r7 = r4.optInt(r12, r7)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r12 = "shouldSendPublisherLogsOnUIThread"
            r13 = 0
            boolean r4 = r4.optBoolean(r12, r13)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.sdk.g.d r12 = new com.ironsource.sdk.g.d     // Catch:{ Exception -> 0x05c4 }
            r12.<init>(r2, r8, r7, r4)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.sdk.f.a r2 = new com.ironsource.sdk.f.a     // Catch:{ Exception -> 0x05c4 }
            r2.<init>()     // Catch:{ Exception -> 0x05c4 }
            if (r20 == 0) goto L_0x0ca5
            java.lang.String r4 = "enabled"
            r7 = r20
            r8 = 0
            boolean r4 = r7.optBoolean(r4, r8)     // Catch:{ Exception -> 0x05c4 }
            r2.a((boolean) r4)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r4 = "reporterURL"
            java.lang.String r4 = r7.optString(r4, r11)     // Catch:{ Exception -> 0x05c4 }
            r2.b((java.lang.String) r4)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r4 = "reporterKeyword"
            java.lang.String r4 = r7.optString(r4, r11)     // Catch:{ Exception -> 0x05c4 }
            r2.c((java.lang.String) r4)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r4 = "includeANR"
            r8 = 0
            boolean r4 = r7.optBoolean(r4, r8)     // Catch:{ Exception -> 0x05c4 }
            r2.b((boolean) r4)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r4 = "timeout"
            r8 = 5000(0x1388, float:7.006E-42)
            int r4 = r7.optInt(r4, r8)     // Catch:{ Exception -> 0x05c4 }
            r2.a((int) r4)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r4 = "setIgnoreDebugger"
            r8 = 0
            boolean r4 = r7.optBoolean(r4, r8)     // Catch:{ Exception -> 0x05c4 }
            r2.c((boolean) r4)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r4 = "keysToInclude"
            org.json.JSONArray r4 = r7.optJSONArray(r4)     // Catch:{ Exception -> 0x05c4 }
            if (r4 == 0) goto L_0x0ca5
            r7 = 0
        L_0x0c95:
            int r8 = r4.length()     // Catch:{ Exception -> 0x05c4 }
            if (r7 >= r8) goto L_0x0ca5
            java.lang.String r8 = r4.optString(r7)     // Catch:{ Exception -> 0x05c4 }
            r2.a((java.lang.String) r8)     // Catch:{ Exception -> 0x05c4 }
            int r7 = r7 + 1
            goto L_0x0c95
        L_0x0ca5:
            if (r19 == 0) goto L_0x0cc5
            java.lang.String r4 = "name"
            r7 = r19
            java.lang.String r4 = r7.optString(r4, r11)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r8 = "id"
            java.lang.String r11 = "-1"
            java.lang.String r8 = r7.optString(r8, r11)     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r11 = "custom"
            org.json.JSONObject r7 = r7.optJSONObject(r11)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.r r11 = new com.ironsource.mediationsdk.model.r     // Catch:{ Exception -> 0x05c4 }
            r11.<init>(r4, r8, r7)     // Catch:{ Exception -> 0x05c4 }
            r40 = r11
            goto L_0x0cc7
        L_0x0cc5:
            r40 = r32
        L_0x0cc7:
            com.ironsource.mediationsdk.utils.b r4 = new com.ironsource.mediationsdk.utils.b     // Catch:{ Exception -> 0x05c4 }
            if (r17 == 0) goto L_0x0cce
            r7 = r17
            goto L_0x0cd3
        L_0x0cce:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x05c4 }
            r7.<init>()     // Catch:{ Exception -> 0x05c4 }
        L_0x0cd3:
            r4.<init>(r7)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.c r7 = new com.ironsource.mediationsdk.model.c     // Catch:{ Exception -> 0x05c4 }
            r7.<init>()     // Catch:{ Exception -> 0x05c4 }
            if (r18 == 0) goto L_0x0cf5
            java.lang.String r7 = "mediationTypes"
            r8 = r18
            org.json.JSONObject r7 = r8.optJSONObject(r7)     // Catch:{ Exception -> 0x05c4 }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ Exception -> 0x05c4 }
            r8.<init>()     // Catch:{ Exception -> 0x05c4 }
            if (r7 == 0) goto L_0x0cf0
            java.util.Map r8 = com.ironsource.mediationsdk.utils.IronSourceUtils.parseJsonToStringMap(r7)     // Catch:{ Exception -> 0x05c4 }
        L_0x0cf0:
            com.ironsource.mediationsdk.model.c r7 = new com.ironsource.mediationsdk.model.c     // Catch:{ Exception -> 0x05c4 }
            r7.<init>(r8)     // Catch:{ Exception -> 0x05c4 }
        L_0x0cf5:
            r45 = r7
            com.ironsource.mediationsdk.model.b r7 = new com.ironsource.mediationsdk.model.b     // Catch:{ Exception -> 0x05c4 }
            r7.<init>()     // Catch:{ Exception -> 0x05c4 }
            if (r37 == 0) goto L_0x0d0e
            java.lang.String r7 = "auctionData"
            r8 = r37
            java.lang.String r7 = r8.optString(r7)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.b r8 = new com.ironsource.mediationsdk.model.b     // Catch:{ Exception -> 0x05c4 }
            r8.<init>(r7)     // Catch:{ Exception -> 0x05c4 }
            r47 = r8
            goto L_0x0d10
        L_0x0d0e:
            r47 = r7
        L_0x0d10:
            java.lang.String r7 = "integration"
            r8 = r29
            r11 = 0
            boolean r42 = r8.optBoolean(r7, r11)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.sdk.a.g r7 = new com.ironsource.sdk.a.g     // Catch:{ Exception -> 0x05c4 }
            r38 = r7
            r39 = r12
            r41 = r3
            r43 = r2
            r44 = r4
            r46 = r5
            r38.<init>(r39, r40, r41, r42, r43, r44, r45, r46, r47)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.s r2 = new com.ironsource.mediationsdk.model.s     // Catch:{ Exception -> 0x05c4 }
            r2.<init>()     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r3 = "testSuite"
            r4 = r16
            org.json.JSONObject r3 = b(r4, r3)     // Catch:{ Exception -> 0x05c4 }
            if (r3 == 0) goto L_0x0d43
            java.lang.String r5 = "controllerUrl"
            java.lang.String r3 = r3.optString(r5)     // Catch:{ Exception -> 0x05c4 }
            r2.a(r3)     // Catch:{ Exception -> 0x05c4 }
        L_0x0d43:
            com.ironsource.mediationsdk.utils.g r3 = new com.ironsource.mediationsdk.utils.g     // Catch:{ Exception -> 0x05c4 }
            r3.<init>()     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r5 = "AdQuality"
            org.json.JSONObject r4 = b(r4, r5)     // Catch:{ Exception -> 0x05c4 }
            if (r4 == 0) goto L_0x0d59
            java.lang.String r5 = "initSDK"
            boolean r4 = r4.optBoolean(r5)     // Catch:{ Exception -> 0x05c4 }
            r3.a((boolean) r4)     // Catch:{ Exception -> 0x05c4 }
        L_0x0d59:
            com.ironsource.mediationsdk.model.f$a r4 = new com.ironsource.mediationsdk.model.f$a     // Catch:{ Exception -> 0x05c4 }
            r4.<init>()     // Catch:{ Exception -> 0x05c4 }
            r5 = r27
            r4.a((com.ironsource.mediationsdk.model.q) r5)     // Catch:{ Exception -> 0x05c4 }
            r5 = r26
            r4.a((com.ironsource.mediationsdk.model.h) r5)     // Catch:{ Exception -> 0x05c4 }
            r4.a((com.ironsource.mediationsdk.model.k) r9)     // Catch:{ Exception -> 0x05c4 }
            r5 = r25
            r4.a((com.ironsource.mediationsdk.model.d) r5)     // Catch:{ Exception -> 0x05c4 }
            r4.a((com.ironsource.mediationsdk.model.i) r1)     // Catch:{ Exception -> 0x05c4 }
            r4.a((com.ironsource.sdk.a.g) r7)     // Catch:{ Exception -> 0x05c4 }
            r4.a((com.ironsource.mediationsdk.model.s) r2)     // Catch:{ Exception -> 0x05c4 }
            r4.a((com.ironsource.mediationsdk.utils.g) r3)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.model.f r1 = r4.a()     // Catch:{ Exception -> 0x05c4 }
            r6.c = r1     // Catch:{ Exception -> 0x05c4 }
            java.lang.String r1 = "genericParams"
            org.json.JSONObject r1 = b(r10, r1)     // Catch:{ Exception -> 0x05c4 }
            if (r1 == 0) goto L_0x0da7
            r2 = r35
            org.json.JSONObject r3 = b(r1, r2)     // Catch:{ Exception -> 0x05c4 }
            if (r3 == 0) goto L_0x0da7
            r1.remove(r2)     // Catch:{ Exception -> 0x05c4 }
            java.util.Map r2 = com.ironsource.mediationsdk.utils.IronSourceUtils.parseJsonToStringMap(r3)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.events.i r3 = com.ironsource.mediationsdk.events.i.d()     // Catch:{ Exception -> 0x05c4 }
            r3.b((java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.events.e r3 = com.ironsource.mediationsdk.events.e.d()     // Catch:{ Exception -> 0x05c4 }
            r3.b((java.util.Map<java.lang.String, java.lang.String>) r2)     // Catch:{ Exception -> 0x05c4 }
        L_0x0da7:
            if (r1 == 0) goto L_0x0dbb
            java.util.Map r1 = com.ironsource.mediationsdk.utils.IronSourceUtils.parseJsonToStringMap(r1)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.events.i r2 = com.ironsource.mediationsdk.events.i.d()     // Catch:{ Exception -> 0x05c4 }
            r2.a((java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{ Exception -> 0x05c4 }
            com.ironsource.mediationsdk.events.e r2 = com.ironsource.mediationsdk.events.e.d()     // Catch:{ Exception -> 0x05c4 }
            r2.a((java.util.Map<java.lang.String, java.lang.String>) r1)     // Catch:{ Exception -> 0x05c4 }
        L_0x0dbb:
            return
        L_0x0dbc:
            r0 = move-exception
            r6 = r1
        L_0x0dbe:
            r1 = r0
            r1.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.k.i():void");
    }

    public final C0232v a() {
        return new C0232v(this.bL, this.bM);
    }

    public final boolean b() {
        JSONObject jSONObject = this.d;
        return (((((jSONObject != null) && !jSONObject.has("error")) && this.a != null) && this.b != null) && this.c != null) && f();
    }

    public final boolean c() {
        return !TextUtils.isEmpty(this.c.g().a());
    }

    public final boolean d() {
        return this.c.f().c().d;
    }

    public final String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appKey", this.bL);
            jSONObject.put(DataKeys.USER_ID, this.bM);
            jSONObject.put("response", this.d);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
