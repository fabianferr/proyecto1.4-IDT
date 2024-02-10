package com.ironsource.mediationsdk.adunit.a;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d.c;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class a {
    private String a;
    private String b;
    private JSONObject c;
    private String d;
    private int e;
    private int f;
    private int g;
    private final List<String> h;
    private final List<String> i;
    private final List<String> j;
    private ImpressionData k;
    private boolean l;

    public a(String str) {
        this.a = null;
        this.b = "";
        this.c = null;
        this.d = "";
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = null;
        this.l = true;
        this.a = str;
    }

    public a(JSONObject jSONObject) {
        this(jSONObject, -1, (JSONObject) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0078 A[Catch:{ Exception -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00b1 A[Catch:{ Exception -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(org.json.JSONObject r12, int r13, org.json.JSONObject r14) {
        /*
            r11 = this;
            java.lang.String r0 = "notifications"
            java.lang.String r1 = "price"
            java.lang.String r2 = "serverData"
            java.lang.String r3 = "adMarkup"
            java.lang.String r4 = "instance"
            r11.<init>()
            r5 = 0
            r11.a = r5
            java.lang.String r6 = ""
            r11.b = r6
            r11.c = r5
            r11.d = r6
            r6 = -1
            r11.e = r6
            r11.f = r6
            r11.g = r6
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            r11.h = r6
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r11.i = r7
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r11.j = r8
            r11.k = r5
            r5 = 1
            r11.l = r5
            r9 = 0
            boolean r10 = r12.has(r4)     // Catch:{ Exception -> 0x00c0 }
            if (r10 == 0) goto L_0x0046
            java.lang.String r4 = r12.getString(r4)     // Catch:{ Exception -> 0x00c0 }
            r11.a = r4     // Catch:{ Exception -> 0x00c0 }
        L_0x0046:
            boolean r4 = r12.has(r3)     // Catch:{ Exception -> 0x00c0 }
            if (r4 == 0) goto L_0x0053
            java.lang.String r2 = r12.getString(r3)     // Catch:{ Exception -> 0x00c0 }
        L_0x0050:
            r11.b = r2     // Catch:{ Exception -> 0x00c0 }
            goto L_0x0062
        L_0x0053:
            boolean r3 = r12.has(r2)     // Catch:{ Exception -> 0x00c0 }
            if (r3 == 0) goto L_0x0062
            org.json.JSONObject r2 = r12.getJSONObject(r2)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00c0 }
            goto L_0x0050
        L_0x0062:
            java.lang.String r2 = "adData"
            org.json.JSONObject r2 = r12.optJSONObject(r2)     // Catch:{ Exception -> 0x00c0 }
            r11.c = r2     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r2 = "0"
            java.lang.String r2 = r12.optString(r1, r2)     // Catch:{ Exception -> 0x00c0 }
            r11.d = r2     // Catch:{ Exception -> 0x00c0 }
            boolean r2 = r12.has(r0)     // Catch:{ Exception -> 0x00c0 }
            if (r2 == 0) goto L_0x008b
            org.json.JSONObject r0 = r12.getJSONObject(r0)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r2 = "burl"
            a(r0, r2, r6)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r2 = "lurl"
            a(r0, r2, r7)     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r2 = "nurl"
            a(r0, r2, r8)     // Catch:{ Exception -> 0x00c0 }
        L_0x008b:
            java.lang.String r0 = "armData"
            org.json.JSONObject r0 = r12.optJSONObject(r0)     // Catch:{ Exception -> 0x00c0 }
            com.ironsource.mediationsdk.impressionData.ImpressionData r2 = new com.ironsource.mediationsdk.impressionData.ImpressionData     // Catch:{ Exception -> 0x00c0 }
            r3 = 2
            org.json.JSONObject[] r3 = new org.json.JSONObject[r3]     // Catch:{ Exception -> 0x00c0 }
            r3[r9] = r14     // Catch:{ Exception -> 0x00c0 }
            r3[r5] = r0     // Catch:{ Exception -> 0x00c0 }
            org.json.JSONObject r14 = com.ironsource.mediationsdk.d.c.a((org.json.JSONObject[]) r3)     // Catch:{ Exception -> 0x00c0 }
            r2.<init>((org.json.JSONObject) r14)     // Catch:{ Exception -> 0x00c0 }
            r11.k = r2     // Catch:{ Exception -> 0x00c0 }
            java.lang.String r14 = "order"
            org.json.JSONObject r12 = r12.optJSONObject(r14)     // Catch:{ Exception -> 0x00c0 }
            r11.e = r13     // Catch:{ Exception -> 0x00c0 }
            r11.f = r13     // Catch:{ Exception -> 0x00c0 }
            r11.g = r13     // Catch:{ Exception -> 0x00c0 }
            if (r12 == 0) goto L_0x00bf
            java.lang.String r14 = "show"
            int r13 = r12.optInt(r14, r13)     // Catch:{ Exception -> 0x00c0 }
            r11.f = r13     // Catch:{ Exception -> 0x00c0 }
            int r12 = r12.optInt(r1, r13)     // Catch:{ Exception -> 0x00c0 }
            r11.g = r12     // Catch:{ Exception -> 0x00c0 }
        L_0x00bf:
            return
        L_0x00c0:
            r12 = move-exception
            r11.l = r9
            com.ironsource.mediationsdk.logger.IronLog r13 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            java.lang.String r0 = "exception "
            r14.<init>(r0)
            java.lang.String r12 = r12.getMessage()
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            r13.error(r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.adunit.a.a.<init>(org.json.JSONObject, int, org.json.JSONObject):void");
    }

    public static int a(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return IronSourceError.ERROR_RV_INSTANCE_INIT_EXCEPTION;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return IronSourceError.ERROR_IS_INSTANCE_INIT_EXCEPTION;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return 612;
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return IronSourceError.ERROR_NT_INSTANCE_INIT_EXCEPTION;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + ad_unit);
        return 510;
    }

    private static void a(JSONObject jSONObject, String str, List<String> list) {
        if (jSONObject.has(str)) {
            list.addAll(c.a(jSONObject.getJSONArray(str)));
        }
    }

    public static int b(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return 1021;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return 1020;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return 1019;
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return 1018;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + ad_unit);
        return 510;
    }

    public static int c(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return 1027;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return 1037;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + ad_unit);
        return 510;
    }

    public static int d(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return 1024;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return 1035;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return IronSourceError.ERROR_BN_LOAD_FAILED_NO_CANDIDATES;
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return IronSourceError.ERROR_NT_LOAD_FAILED_NO_CANDIDATES;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + ad_unit);
        return 510;
    }

    public static int e(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return IronSourceError.ERROR_RV_ALL_SMASHES_SESSION_CAPPED;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return IronSourceError.ERROR_IS_ALL_SMASHES_SESSION_CAPPED;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + ad_unit);
        return 510;
    }

    public static int f(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL || ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return IronSourceError.ERROR_REACHED_CAP_LIMIT_PER_PLACEMENT;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return 604;
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return 704;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.warning("ad unit not supported - " + ad_unit);
        return 510;
    }

    public ImpressionData a(String str) {
        ImpressionData impressionData = this.k;
        if (impressionData == null) {
            return null;
        }
        ImpressionData impressionData2 = new ImpressionData(impressionData);
        impressionData2.replaceMacroForPlacementWithValue("${PLACEMENT_NAME}", str);
        return impressionData2;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public JSONObject c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public int e() {
        return this.f;
    }

    public int f() {
        return this.g;
    }

    public List<String> g() {
        return this.h;
    }

    public List<String> h() {
        return this.i;
    }

    public List<String> i() {
        return this.j;
    }

    public boolean j() {
        return this.l;
    }
}
