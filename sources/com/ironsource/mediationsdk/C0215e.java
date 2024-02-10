package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.ironsource.environment.c.a;
import com.ironsource.environment.h;
import com.ironsource.environment.m;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.a.a;
import com.ironsource.mediationsdk.events.i;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.e;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.cookie.ClientCookie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.mediationsdk.e  reason: case insensitive filesystem */
public final class C0215e {
    private static C0215e b = new C0215e();
    private final AtomicBoolean a = new AtomicBoolean(false);

    /* renamed from: com.ironsource.mediationsdk.e$a */
    public static class a {
        public String a;
        public List<com.ironsource.mediationsdk.adunit.a.a> b;
        com.ironsource.mediationsdk.adunit.a.a c;
        public JSONObject d;
        JSONObject e;
        int f;
        String g;
        public com.ironsource.mediationsdk.a.a h;

        public a(String str) {
            this.a = str;
        }
    }

    /* renamed from: com.ironsource.mediationsdk.e$b */
    static class b implements Runnable {
        private String a;
        private String b;
        private String c;

        public b(String str, String str2, String str3) {
            this.a = str;
            this.b = str2;
            this.c = str3;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0057 A[Catch:{ Exception -> 0x0087 }] */
        /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r8 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = r8.a
                r0.append(r1)
                java.lang.String r1 = ";"
                r0.append(r1)
                java.lang.String r2 = r8.b
                r0.append(r2)
                r0.append(r1)
                java.lang.String r2 = r8.c
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                java.net.URL r2 = new java.net.URL     // Catch:{ Exception -> 0x0087 }
                java.lang.String r3 = r8.c     // Catch:{ Exception -> 0x0087 }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0087 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ Exception -> 0x0087 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x0087 }
                java.lang.String r3 = "GET"
                r2.setRequestMethod(r3)     // Catch:{ Exception -> 0x0087 }
                r3 = 15000(0x3a98, float:2.102E-41)
                r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x0087 }
                r2.setConnectTimeout(r3)     // Catch:{ Exception -> 0x0087 }
                r2.connect()     // Catch:{ Exception -> 0x0087 }
                int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x0087 }
                java.lang.String r4 = r2.getResponseMessage()     // Catch:{ Exception -> 0x0087 }
                r2.disconnect()     // Catch:{ Exception -> 0x0087 }
                r2 = 200(0xc8, float:2.8E-43)
                r5 = 1
                if (r3 == r2) goto L_0x0054
                r2 = 204(0xcc, float:2.86E-43)
                if (r3 != r2) goto L_0x0052
                goto L_0x0054
            L_0x0052:
                r2 = 0
                goto L_0x0055
            L_0x0054:
                r2 = 1
            L_0x0055:
                if (r2 != 0) goto L_0x0086
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x0087 }
                r2.<init>()     // Catch:{ Exception -> 0x0087 }
                java.lang.String r6 = "provider"
                java.lang.String r7 = "Mediation"
                r2.put(r6, r7)     // Catch:{ Exception -> 0x0087 }
                java.lang.String r6 = "programmatic"
                r2.put(r6, r5)     // Catch:{ Exception -> 0x0087 }
                java.lang.String r5 = "ext1"
                r2.put(r5, r0)     // Catch:{ Exception -> 0x0087 }
                java.lang.String r5 = "errorCode"
                r2.put(r5, r3)     // Catch:{ Exception -> 0x0087 }
                java.lang.String r3 = "reason"
                r2.put(r3, r4)     // Catch:{ Exception -> 0x0087 }
                com.ironsource.environment.c.a r3 = new com.ironsource.environment.c.a     // Catch:{ Exception -> 0x0087 }
                r4 = 81320(0x13da8, float:1.13954E-40)
                r3.<init>(r4, r2)     // Catch:{ Exception -> 0x0087 }
                com.ironsource.mediationsdk.events.i r2 = com.ironsource.mediationsdk.events.i.d()     // Catch:{ Exception -> 0x0087 }
                r2.a((com.ironsource.environment.c.a) r3)     // Catch:{ Exception -> 0x0087 }
            L_0x0086:
                return
            L_0x0087:
                r2 = move-exception
                r2.printStackTrace()
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "Send auction url failed with params - "
                r3.<init>(r4)
                r3.append(r0)
                r3.append(r1)
                java.lang.String r0 = r2.getMessage()
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
                r1.error(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0215e.b.run():void");
        }
    }

    /* renamed from: com.ironsource.mediationsdk.e$c */
    enum c {
        ;
        
        public static final int a = 1;
        public static final int b = 2;

        static {
            c = new int[]{1, 2};
        }
    }

    public static com.ironsource.mediationsdk.adunit.a.a a(String str, List<com.ironsource.mediationsdk.adunit.a.a> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).a().equals(str)) {
                return list.get(i);
            }
        }
        return null;
    }

    public static a a(JSONObject jSONObject) {
        String optString = jSONObject.optString("auctionId");
        if (!TextUtils.isEmpty(optString)) {
            a aVar = new a(optString);
            JSONObject jSONObject2 = null;
            if (jSONObject.has("settings")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("settings");
                aVar.c = new com.ironsource.mediationsdk.adunit.a.a(jSONObject3);
                if (jSONObject3.has("armData")) {
                    jSONObject2 = jSONObject3.optJSONObject("armData");
                }
                if (jSONObject3.has(IronSourceConstants.EVENTS_GENERIC_PARAMS)) {
                    aVar.d = jSONObject3.optJSONObject(IronSourceConstants.EVENTS_GENERIC_PARAMS);
                }
                if (jSONObject3.has("configurations")) {
                    aVar.e = jSONObject3.optJSONObject("configurations");
                }
                if (jSONObject3.has("instances")) {
                    aVar.h = new a.C0107a(jSONObject3.optJSONObject("instances"));
                }
            }
            aVar.b = new ArrayList();
            if (jSONObject.has("waterfall")) {
                JSONArray jSONArray = jSONObject.getJSONArray("waterfall");
                int i = 0;
                while (i < jSONArray.length()) {
                    com.ironsource.mediationsdk.adunit.a.a aVar2 = new com.ironsource.mediationsdk.adunit.a.a(jSONArray.getJSONObject(i), i, jSONObject2);
                    if (aVar2.j()) {
                        aVar.b.add(aVar2);
                        i++;
                    } else {
                        aVar.f = 1002;
                        aVar.g = "waterfall " + i;
                        IronLog ironLog = IronLog.INTERNAL;
                        ironLog.verbose("AuctionResponseItem " + i + " not valid - parsing error");
                        throw new JSONException("invalid response");
                    }
                }
            }
            return aVar;
        }
        throw new JSONException("Invalid auction response - auction id is missing");
    }

    public static C0215e a() {
        return b;
    }

    public static String a(String str, String str2, int i, String str3, String str4, String str5, String str6, String str7) {
        return str.replace("${AUCTION_PRICE}", str4).replace("${AUCTION_LOSS}", str6).replace("${AUCTION_MBR}", str5).replace("${INSTANCE}", str2).replace("${INSTANCE_TYPE}", Integer.toString(i)).replace("${DYNAMIC_DEMAND_SOURCE}", str3).replace("${PLACEMENT_NAME}", str7);
    }

    public static JSONObject a(String str) {
        try {
            return new JSONObject(IronSourceAES.decode(e.a().b(), str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static JSONObject a(JSONObject jSONObject, List<String> list) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    if (list.contains(next)) {
                        jSONObject2.put(next, jSONObject.opt(next));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject2;
    }

    public static void a(String str, String str2, String str3) {
        IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b(str, str2, str3));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        if (((com.ironsource.environment.ContextProvider.getInstance().getApplicationContext().getApplicationInfo().flags & androidx.media3.common.C.BUFFER_FLAG_FIRST_SAMPLE) != 0) != false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        if (android.security.NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() != false) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int b() {
        /*
            int r0 = com.ironsource.mediationsdk.C0215e.c.b
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L_0x0016
            android.security.NetworkSecurityPolicy r0 = android.security.NetworkSecurityPolicy.getInstance()
            boolean r0 = r0.isCleartextTrafficPermitted()
            if (r0 == 0) goto L_0x0013
            goto L_0x0034
        L_0x0013:
            int r0 = com.ironsource.mediationsdk.C0215e.c.b
            goto L_0x0036
        L_0x0016:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 23
            if (r0 < r1) goto L_0x0034
            com.ironsource.environment.ContextProvider r0 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r0 = r0.getApplicationContext()
            android.content.pm.ApplicationInfo r0 = r0.getApplicationInfo()
            int r0 = r0.flags
            r1 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0031
            r0 = 1
            goto L_0x0032
        L_0x0031:
            r0 = 0
        L_0x0032:
            if (r0 == 0) goto L_0x0013
        L_0x0034:
            int r0 = com.ironsource.mediationsdk.C0215e.c.a
        L_0x0036:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0215e.b():int");
    }

    public static Map<String, String> b(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(NativeProtocol.WEB_DIALOG_PARAMS)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object obj = jSONObject2.get(next);
                    if (obj instanceof String) {
                        hashMap.put(next, (String) obj);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception " + e.getMessage());
        }
        return hashMap;
    }

    public static String c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            JSONObject jSONObject = new JSONObject(str);
            return jSONObject.has("adMarkup") ? jSONObject.getString("adMarkup") : str;
        } catch (JSONException e) {
            e.printStackTrace();
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("exception " + e.getMessage());
            return str;
        }
    }

    public static String d(String str) {
        try {
            if (TextUtils.isEmpty(str) || !com.ironsource.mediationsdk.d.c.a(str)) {
                return "";
            }
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has(NativeProtocol.WEB_DIALOG_PARAMS)) {
                return "";
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("parameters = " + jSONObject2);
            if (!jSONObject2.has(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID)) {
                return "";
            }
            String string = jSONObject2.getString(IronSourceConstants.EVENTS_DYNAMIC_DEMAND_SOURCE_ID);
            IronLog ironLog2 = IronLog.INTERNAL;
            ironLog2.verbose("demand source = " + string);
            return string;
        } catch (JSONException e) {
            e.printStackTrace();
            IronLog ironLog3 = IronLog.INTERNAL;
            ironLog3.error("exception " + e.getMessage());
            return "";
        }
    }

    public final String a(String str, int i, com.ironsource.mediationsdk.adunit.a.a aVar, String str2, String str3, String str4) {
        String str5;
        String d = aVar.d();
        if (!TextUtils.isEmpty(d) && !TextUtils.isEmpty(str2)) {
            double parseDouble = Double.parseDouble(d);
            double parseDouble2 = Double.parseDouble(str2);
            if (parseDouble2 != 0.0d) {
                double round = (double) Math.round((parseDouble / parseDouble2) * 1000.0d);
                Double.isNaN(round);
                str5 = String.valueOf(round / 1000.0d);
                return a(str, aVar.a(), i, d(aVar.b()), d, str5, str3, str4);
            }
        }
        str5 = "";
        return a(str, aVar.a(), i, d(aVar.b()), d, str5, str3, str4);
    }

    /* access modifiers changed from: package-private */
    public final JSONObject a(Context context, Map<String, Object> map, List<String> list, C0218h hVar, int i, String str, com.ironsource.mediationsdk.utils.c cVar, ISBannerSize iSBannerSize, JSONObject jSONObject, boolean z, boolean z2) {
        String str2;
        C0218h hVar2 = hVar;
        JSONObject jSONObject2 = jSONObject;
        JSONObject jSONObject3 = new JSONObject();
        Iterator<String> it = map.keySet().iterator();
        while (true) {
            str2 = "";
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("instanceType", 2);
            Map<String, Object> map2 = map;
            jSONObject4.put("biddingAdditionalData", new JSONObject((Map) map.get(next)));
            if (hVar2 != null) {
                str2 = hVar2.a(next);
            }
            jSONObject4.put("performance", str2);
            if (z2) {
                jSONObject4.put("test", 1);
            }
            jSONObject3.put(next, jSONObject4);
        }
        if (list != null) {
            for (String next2 : list) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("instanceType", 1);
                jSONObject5.put("performance", hVar2 != null ? hVar2.a(next2) : str2);
                jSONObject3.put(next2, jSONObject5);
            }
        }
        ConcurrentHashMap<String, List<String>> concurrentHashMap = C0213c.a().d;
        concurrentHashMap.putAll(com.ironsource.mediationsdk.d.c.a().c());
        JSONObject jSONObject6 = new JSONObject();
        for (Map.Entry next3 : concurrentHashMap.entrySet()) {
            jSONObject6.put((String) next3.getKey(), TextUtils.join(",", (Iterable) next3.getValue()));
        }
        a(new com.ironsource.environment.a.b((a.C0105a) null).a(), false);
        JSONObject jSONObject7 = new JSONObject();
        String str3 = z.a().h;
        if (!TextUtils.isEmpty(str3)) {
            jSONObject7.put("applicationUserId", str3);
        }
        Boolean bool = z.a().w;
        if (bool != null) {
            jSONObject7.put("consent", bool.booleanValue() ? 1 : 0);
        }
        jSONObject7.put("mobileCarrier", h.i(context));
        jSONObject7.put("connectionType", IronSourceUtils.getConnectionType(context));
        jSONObject7.put("deviceOS", "android");
        jSONObject7.put("deviceWidth", context.getResources().getConfiguration().screenWidthDp);
        jSONObject7.put("deviceHeight", context.getResources().getConfiguration().screenHeightDp);
        jSONObject7.put("deviceOSVersion", Build.VERSION.SDK_INT + "(" + Build.VERSION.RELEASE + ")");
        jSONObject7.put("deviceModel", Build.MODEL);
        jSONObject7.put("deviceMake", Build.MANUFACTURER);
        jSONObject7.put("bundleId", context.getPackageName());
        Context context2 = context;
        jSONObject7.put("appVersion", com.ironsource.environment.c.c(context, context.getPackageName()));
        jSONObject7.put("clientTimestamp", new Date().getTime());
        jSONObject7.put("fs", IronSourceUtils.getFirstSession(context) ? 1 : 0);
        jSONObject7.put("browserUserAgent", h.q());
        jSONObject7.put("deviceType", IronSourceUtils.getDeviceType(context));
        jSONObject7.put("deviceLang", Locale.getDefault().getLanguage());
        jSONObject7.put(ClientCookie.SECURE_ATTR, b() - 1);
        if (iSBannerSize != null) {
            jSONObject7.put("bannerSize", iSBannerSize.getDescription());
            jSONObject7.put("bannerWidth", iSBannerSize.getWidth());
            jSONObject7.put("bannerHeight", iSBannerSize.getHeight());
        }
        String C = h.C(context);
        if (!TextUtils.isEmpty(C)) {
            str2 = IronSourceConstants.TYPE_GAID;
        } else {
            C = h.x(context);
            if (!TextUtils.isEmpty(C)) {
                str2 = IronSourceConstants.TYPE_UUID;
            }
        }
        if (!TextUtils.isEmpty(C)) {
            jSONObject7.put("advId", C);
            jSONObject7.put("advIdType", str2);
        }
        String D = h.D(context);
        if (!TextUtils.isEmpty(D)) {
            jSONObject7.put("isLimitAdTrackingEnabled", D);
        }
        String B = h.B(context);
        if (!TextUtils.isEmpty(B)) {
            jSONObject7.put("asid", B);
        }
        String y = h.y(context);
        if (!TextUtils.isEmpty(y)) {
            jSONObject7.put(JsonStorageKeyNames.AUID_ID_KEY, y);
        }
        JSONObject jSONObject8 = new JSONObject();
        jSONObject8.put("applicationKey", z.a().g);
        jSONObject8.put("SDKVersion", IronSourceUtils.getSDKVersion());
        jSONObject8.put("clientParams", jSONObject7);
        jSONObject8.put(IronSourceConstants.KEY_SESSION_DEPTH, i);
        jSONObject8.put(JsonStorageKeyNames.SESSION_ID_KEY, str);
        jSONObject8.put("instances", jSONObject3);
        jSONObject8.put("auctionData", cVar.b);
        jSONObject8.put("metaData", jSONObject6);
        if (jSONObject2 != null) {
            jSONObject8.put("sg", jSONObject2);
        }
        if (z) {
            jSONObject8.put("testSuite", 1);
        }
        return jSONObject8;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject a(C0221k kVar) {
        boolean z;
        boolean z2;
        String str;
        ISBannerSize iSBannerSize;
        IronSource.AD_UNIT a2 = kVar.a();
        boolean d = kVar.d();
        Map<String, Object> e = kVar.e();
        List<String> f = kVar.f();
        C0218h h = kVar.h();
        int g = kVar.g();
        ISBannerSize k = kVar.k();
        IronSourceSegment i = kVar.i();
        boolean m = kVar.m();
        boolean n = kVar.n();
        ArrayList<C0219i> b2 = kVar.b();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> it = e.keySet().iterator();
        while (true) {
            z = m;
            z2 = d;
            str = "";
            iSBannerSize = k;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            Iterator<String> it2 = it;
            JSONObject jSONObject3 = new JSONObject();
            IronSourceSegment ironSourceSegment = i;
            jSONObject3.put("instp", 2);
            jSONObject3.put("badt", new JSONObject((Map) e.get(next)));
            if (h != null) {
                str = h.a(next);
            }
            jSONObject3.put("prfm", str);
            jSONObject3.put("ts", n);
            jSONObject2.put(next, jSONObject3);
            m = z;
            d = z2;
            k = iSBannerSize;
            it = it2;
            i = ironSourceSegment;
        }
        IronSourceSegment ironSourceSegment2 = i;
        for (String next2 : f) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("instp", 1);
            jSONObject4.put("prfm", h != null ? h.a(next2) : str);
            jSONObject2.put(next2, jSONObject4);
        }
        Iterator<C0219i> it3 = b2.iterator();
        while (it3.hasNext()) {
            C0219i next3 = it3.next();
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("instp", next3.b() ? 2 : 1);
            Map<String, Object> d2 = next3.d();
            if (!d2.isEmpty()) {
                jSONObject5.put("badt", new JSONObject(d2));
            }
            jSONObject5.put("prfm", h != null ? h.a(next3.a()) : str);
            jSONObject5.put("ts", n ? 1 : 0);
            if (!next3.c().isEmpty()) {
                jSONObject5.put("dlpl", next3.c());
            }
            jSONObject2.put(next3.a(), jSONObject5);
        }
        jSONObject.put("inst", jSONObject2);
        if (kVar.c()) {
            jSONObject.put("eof", 1);
        }
        if (kVar.l()) {
            jSONObject.put(CampaignUnit.JSON_KEY_DO, 1);
        }
        JSONObject a3 = new com.ironsource.environment.a.b(com.ironsource.mediationsdk.d.a.a(a2)).a();
        a(a3, false);
        a3.put("sd", g);
        a3.put("scr", b() - 1);
        if (ironSourceSegment2 != null) {
            a3.put("sg", ironSourceSegment2.toJson());
        }
        jSONObject.put("ctdt", a3);
        if (iSBannerSize != null) {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("bns", iSBannerSize.getDescription());
            jSONObject6.put("bnw", iSBannerSize.getWidth());
            jSONObject6.put("bnh", iSBannerSize.getHeight());
            jSONObject.put("bndt", jSONObject6);
        }
        jSONObject.put("adu", a2.toString());
        jSONObject.put("dner", z2 ^ true ? 1 : 0);
        Object remove = a3.remove("infp");
        if (remove != null) {
            jSONObject.put("infp", remove);
        }
        if (z) {
            jSONObject.put("tss", 1);
        }
        return jSONObject;
    }

    public final void a(JSONObject jSONObject, JSONObject jSONObject2) {
        String str;
        if (jSONObject2 != null) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (jSONObject.has(next)) {
                    int i = 0;
                    str = next;
                    while (jSONObject.has(str)) {
                        i++;
                        str = next + "_" + i;
                    }
                } else {
                    str = next;
                }
                try {
                    jSONObject.put(str, jSONObject2.opt(next));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final void a(JSONObject jSONObject, boolean z) {
        if (jSONObject != null && jSONObject.length() > 0 && !TextUtils.isEmpty(jSONObject.optString("tcs")) && this.a.compareAndSet(false, true)) {
            i.d().a(new com.ironsource.environment.c.a(IronSourceConstants.TROUBLESHOOTING_MEDIATION_TCS_CALCULATED, IronSourceUtils.getMediationAdditionalData(z, true, -1)));
        }
    }

    public JSONObject b(JSONObject jSONObject, List<String> list) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    HashMap<String, String> hashMap = m.b;
                    String str = hashMap.containsKey(next) ? hashMap.get(next) : next;
                    if ((list.isEmpty() && !m.a.contains(str) && !str.startsWith("metadata_")) || list.contains(str)) {
                        jSONObject2.put(str, jSONObject.opt(next));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return jSONObject2;
    }
}
