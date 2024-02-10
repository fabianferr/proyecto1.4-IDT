package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.click.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.foundation.tools.w;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: JSCommon */
public final class j extends c {
    /* access modifiers changed from: private */
    public Activity n;
    private String o;
    private String p;
    /* access modifiers changed from: private */
    public CampaignEx q;
    private List<CampaignEx> r;
    private int s;
    private String t = "";
    private String u = "";
    private boolean v = false;
    private boolean w = false;

    public final void a(CampaignEx campaignEx) {
        this.q = campaignEx;
    }

    public final void a(List<CampaignEx> list) {
        this.r = list;
    }

    public final void c(boolean z) {
        this.v = z;
    }

    public j(Activity activity, CampaignEx campaignEx) {
        this.n = activity;
        this.q = campaignEx;
    }

    public j(Activity activity, CampaignEx campaignEx, List<CampaignEx> list) {
        this.n = activity;
        this.q = campaignEx;
        this.r = list;
    }

    public final void n() {
        this.o = "";
    }

    public final void c(String str) {
        this.t = str;
    }

    public final void d(String str) {
        this.u = str;
    }

    public final int o() {
        return this.s;
    }

    public final void i(int i) {
        this.s = i;
    }

    public final void d(boolean z) {
        this.w = z;
    }

    public final String c() {
        this.l.a();
        this.a = true;
        if (TextUtils.isEmpty(this.o)) {
            this.o = p();
        } else {
            String str = this.o;
            this.o = af.b(str, "tun", w.y() + "");
        }
        return this.o;
    }

    private String p() {
        JSONObject jSONObject = new JSONObject();
        e eVar = new e(b.d().g());
        try {
            jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.i);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_ID, this.t);
            jSONObject2.put("rootViewInstanceId", this.u);
            jSONObject2.put("isRootTemplateWebView", this.v);
            jSONObject.put("sdk_info", "MAL_16.5.91,3.0.1");
            jSONObject2.put("playVideoMute", this.m);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", eVar.a());
            JSONArray jSONArray = new JSONArray();
            List<CampaignEx> list = this.r;
            if (list == null || list.size() <= 0) {
                jSONArray.put(CampaignEx.campaignToJsonObject(this.q));
            } else {
                for (CampaignEx next : this.r) {
                    jSONArray.put(CampaignEx.campaignToJsonObject(next, next.isReady(), b(next)));
                }
            }
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", y());
            String c = f.a().c(b.d().h());
            if (!TextUtils.isEmpty(c)) {
                JSONObject jSONObject3 = new JSONObject(c);
                a(jSONObject3);
                String d = f.a().d(this.i);
                if (!TextUtils.isEmpty(d)) {
                    jSONObject3.put("ivreward", new JSONObject(d));
                }
                jSONObject.put("appSetting", jSONObject3);
            }
            jSONObject.put("rewardSetting", z());
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.i);
            }
            jSONObject.put("rw_plus", this.w ? "1" : "0");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject.toString();
    }

    private void a(JSONObject jSONObject) {
        try {
            Context g = b.d().g();
            String obj = ai.b(g, "MBridge_ConfirmTitle" + this.i, "").toString();
            String obj2 = ai.b(g, "MBridge_ConfirmContent" + this.i, "").toString();
            String obj3 = ai.b(g, "MBridge_CancelText" + this.i, "").toString();
            String obj4 = ai.b(g, "MBridge_ConfirmText" + this.i, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                jSONObject.put("confirm_title", obj);
            }
            if (!TextUtils.isEmpty(obj2)) {
                jSONObject.put("confirm_description", obj2);
            }
            if (!TextUtils.isEmpty(obj3)) {
                jSONObject.put("confirm_t", obj3);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put("confirm_c_play", obj4);
            }
            if (!TextUtils.isEmpty(obj4)) {
                jSONObject.put("confirm_c_rv", obj4);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:37|38|39|40|(1:42)|43|44|(2:47|45)|55|48|49|60) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x0104 */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010e A[Catch:{ JSONException -> 0x0125 }, LOOP:1: B:45:0x0108->B:47:0x010e, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mbridge.msdk.foundation.entity.CampaignEx a(java.lang.String r8, com.mbridge.msdk.foundation.entity.CampaignEx r9) {
        /*
            r7 = this;
            java.lang.String r0 = "deep_link"
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x0009
            return r9
        L_0x0009:
            boolean r1 = android.text.TextUtils.isEmpty(r8)
            if (r1 == 0) goto L_0x0015
            if (r9 == 0) goto L_0x0012
            goto L_0x0015
        L_0x0012:
            r9 = 0
            goto L_0x0129
        L_0x0015:
            java.lang.String r1 = "notice"
            boolean r1 = r8.contains(r1)
            if (r1 != 0) goto L_0x00f0
            org.json.JSONObject r0 = com.mbridge.msdk.foundation.entity.CampaignEx.campaignToJsonObject(r9)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r0)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r1 != 0) goto L_0x0028
            r1 = r9
        L_0x0028:
            boolean r2 = android.text.TextUtils.isEmpty(r8)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r2 != 0) goto L_0x00e4
            r7.a((org.json.JSONObject) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r1)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r0.<init>(r8)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r8 = com.mbridge.msdk.foundation.same.a.h     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            org.json.JSONObject r8 = r0.optJSONObject(r8)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r8 == 0) goto L_0x0071
            android.app.Activity r0 = r7.n     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.f     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r2 = r8.getString(r2)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r2 = r2.intValue()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            float r2 = (float) r2     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r0 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r0, (float) r2)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            android.app.Activity r2 = r7.n     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.g     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r3 = r8.getString(r3)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r3 = r3.intValue()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            float r3 = (float) r3     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r2 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r2, (float) r3)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            goto L_0x0074
        L_0x0071:
            java.lang.String r0 = "-999"
            r2 = r0
        L_0x0074:
            java.lang.String r3 = r1.getClickURL()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r0 = com.mbridge.msdk.click.b.a((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r2)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r1.setClickURL(r0)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r0 = r1.getNoticeUrl()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r8 == 0) goto L_0x00e4
            java.util.Iterator r2 = r8.keys()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r3.<init>()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
        L_0x008e:
            boolean r4 = r2.hasNext()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r4 == 0) goto L_0x00d2
            java.lang.String r4 = "&"
            r3.append(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.Object r4 = r2.next()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r5 = r8.optString(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.f     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            boolean r6 = r6.equals(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r6 != 0) goto L_0x00b3
            java.lang.String r6 = com.mbridge.msdk.foundation.same.a.g     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            boolean r6 = r6.equals(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            if (r6 == 0) goto L_0x00c6
        L_0x00b3:
            android.app.Activity r6 = r7.n     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r5 = r5.intValue()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            float r5 = (float) r5     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            int r5 = com.mbridge.msdk.foundation.tools.af.b((android.content.Context) r6, (float) r5)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
        L_0x00c6:
            r3.append(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r4 = "="
            r3.append(r4)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r3.append(r5)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            goto L_0x008e
        L_0x00d2:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r8.<init>()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r8.append(r0)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r8.append(r3)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            java.lang.String r8 = r8.toString()     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
            r1.setNoticeUrl(r8)     // Catch:{ JSONException -> 0x00eb, all -> 0x00e6 }
        L_0x00e4:
            r9 = r1
            goto L_0x0129
        L_0x00e6:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x0129
        L_0x00eb:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x0129
        L_0x00f0:
            org.json.JSONObject r1 = com.mbridge.msdk.foundation.entity.CampaignEx.campaignToJsonObject(r9)     // Catch:{ JSONException -> 0x0125 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0125 }
            r2.<init>(r8)     // Catch:{ JSONException -> 0x0125 }
            boolean r8 = r2.has(r0)     // Catch:{ Exception -> 0x0104 }
            if (r8 != 0) goto L_0x0104
            java.lang.String r8 = ""
            r1.put(r0, r8)     // Catch:{ Exception -> 0x0104 }
        L_0x0104:
            java.util.Iterator r8 = r2.keys()     // Catch:{ JSONException -> 0x0125 }
        L_0x0108:
            boolean r0 = r8.hasNext()     // Catch:{ JSONException -> 0x0125 }
            if (r0 == 0) goto L_0x011c
            java.lang.Object r0 = r8.next()     // Catch:{ JSONException -> 0x0125 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ JSONException -> 0x0125 }
            java.lang.String r3 = r2.getString(r0)     // Catch:{ JSONException -> 0x0125 }
            r1.put(r0, r3)     // Catch:{ JSONException -> 0x0125 }
            goto L_0x0108
        L_0x011c:
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = com.mbridge.msdk.foundation.entity.CampaignEx.parseCampaignWithBackData(r1)     // Catch:{ JSONException -> 0x0125 }
            r7.a((org.json.JSONObject) r1, (com.mbridge.msdk.foundation.entity.CampaignEx) r8)     // Catch:{ JSONException -> 0x0125 }
            r9 = r8
            goto L_0x0129
        L_0x0125:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0129:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.a.j.a(java.lang.String, com.mbridge.msdk.foundation.entity.CampaignEx):com.mbridge.msdk.foundation.entity.CampaignEx");
    }

    private void a(JSONObject jSONObject, CampaignEx campaignEx) {
        try {
            String optString = jSONObject.optString(CampaignEx.JSON_KEY_CAMPAIGN_UNITID);
            if (!TextUtils.isEmpty(optString)) {
                campaignEx.setCampaignUnitId(optString);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ca, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        com.mbridge.msdk.foundation.tools.aa.b("DefaultJSCommon", "INSTALL", r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f7, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00f8, code lost:
        com.mbridge.msdk.foundation.tools.aa.b("DefaultJSCommon", r6.getMessage(), r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:20:0x0049, B:50:0x00b5] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00d6 A[Catch:{ all -> 0x00ca, all -> 0x00f7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d7 A[Catch:{ all -> 0x00ca, all -> 0x00f7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void click(int r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "camp_position"
            super.click(r6, r7)
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.q
            if (r1 == 0) goto L_0x003f
            int r1 = r1.getDynamicTempCode()
            r2 = 5
            if (r1 != r2) goto L_0x003f
            com.mbridge.msdk.foundation.entity.CampaignEx r1 = r5.q
            if (r1 != 0) goto L_0x0015
            goto L_0x003f
        L_0x0015:
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r5.r
            if (r1 != 0) goto L_0x001a
            goto L_0x003f
        L_0x001a:
            int r1 = r1.size()
            if (r1 != 0) goto L_0x0021
            goto L_0x003f
        L_0x0021:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003b }
            r1.<init>(r7)     // Catch:{ JSONException -> 0x003b }
            boolean r2 = r1.has(r0)     // Catch:{ JSONException -> 0x003b }
            if (r2 == 0) goto L_0x003f
            int r0 = r1.getInt(r0)     // Catch:{ JSONException -> 0x003b }
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r1 = r5.r     // Catch:{ JSONException -> 0x003b }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ JSONException -> 0x003b }
            com.mbridge.msdk.foundation.entity.CampaignEx r0 = (com.mbridge.msdk.foundation.entity.CampaignEx) r0     // Catch:{ JSONException -> 0x003b }
            r5.q = r0     // Catch:{ JSONException -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003f:
            java.lang.String r0 = "DefaultJSCommon"
            r1 = 1
            if (r6 == r1) goto L_0x0079
            r2 = 3
            if (r6 == r2) goto L_0x0049
            goto L_0x00ff
        L_0x0049:
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.q     // Catch:{ all -> 0x00f7 }
            if (r6 == 0) goto L_0x005b
            int r6 = r6.getCbd()     // Catch:{ all -> 0x00f7 }
            r2 = -2
            if (r6 <= r2) goto L_0x005b
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.q     // Catch:{ all -> 0x00f7 }
            int r6 = r6.getCbd()     // Catch:{ all -> 0x00f7 }
            goto L_0x0067
        L_0x005b:
            com.mbridge.msdk.videocommon.d.c r6 = r5.j     // Catch:{ all -> 0x00f7 }
            if (r6 == 0) goto L_0x0066
            com.mbridge.msdk.videocommon.d.c r6 = r5.j     // Catch:{ all -> 0x00f7 }
            int r6 = r6.p()     // Catch:{ all -> 0x00f7 }
            goto L_0x0067
        L_0x0066:
            r6 = 1
        L_0x0067:
            r2 = -1
            if (r6 != r2) goto L_0x0074
            com.mbridge.msdk.video.signal.a.c$b r6 = new com.mbridge.msdk.video.signal.a.c$b     // Catch:{ all -> 0x00f7 }
            com.mbridge.msdk.video.signal.c$a r2 = r5.l     // Catch:{ all -> 0x00f7 }
            r6.<init>(r5, r2)     // Catch:{ all -> 0x00f7 }
            r5.a((com.mbridge.msdk.video.signal.c.a) r6)     // Catch:{ all -> 0x00f7 }
        L_0x0074:
            r5.click(r1, r7)     // Catch:{ all -> 0x00f7 }
            goto L_0x00ff
        L_0x0079:
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.q     // Catch:{ all -> 0x00f7 }
            r2 = 0
            if (r6 != 0) goto L_0x0092
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r6 = r5.r     // Catch:{ all -> 0x00f7 }
            if (r6 == 0) goto L_0x0092
            int r6 = r6.size()     // Catch:{ all -> 0x00f7 }
            if (r6 <= 0) goto L_0x0092
            java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r6 = r5.r     // Catch:{ all -> 0x00f7 }
            java.lang.Object r6 = r6.get(r2)     // Catch:{ all -> 0x00f7 }
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = (com.mbridge.msdk.foundation.entity.CampaignEx) r6     // Catch:{ all -> 0x00f7 }
            r5.q = r6     // Catch:{ all -> 0x00f7 }
        L_0x0092:
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.q     // Catch:{ all -> 0x00f7 }
            if (r6 != 0) goto L_0x0097
            return
        L_0x0097:
            com.mbridge.msdk.foundation.entity.CampaignEx r6 = r5.a((java.lang.String) r7, (com.mbridge.msdk.foundation.entity.CampaignEx) r6)     // Catch:{ all -> 0x00f7 }
            if (r6 == 0) goto L_0x00b1
            com.mbridge.msdk.scheme.applet.AppletModelManager r7 = com.mbridge.msdk.scheme.applet.AppletModelManager.getInstance()     // Catch:{ all -> 0x00f7 }
            com.mbridge.msdk.scheme.applet.AppletsModel r7 = r7.get(r6)     // Catch:{ all -> 0x00f7 }
            if (r7 == 0) goto L_0x00b1
            r7.setUserClick(r1)     // Catch:{ all -> 0x00f7 }
            com.mbridge.msdk.scheme.applet.AppletModelManager r3 = com.mbridge.msdk.scheme.applet.AppletModelManager.getInstance()     // Catch:{ all -> 0x00f7 }
            r3.replace(r7, r6)     // Catch:{ all -> 0x00f7 }
        L_0x00b1:
            java.lang.String r7 = r6.getNoticeUrl()     // Catch:{ all -> 0x00f7 }
            android.net.Uri r7 = android.net.Uri.parse(r7)     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.i     // Catch:{ all -> 0x00ca }
            java.lang.String r7 = r7.getQueryParameter(r3)     // Catch:{ all -> 0x00ca }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x00ca }
            if (r3 != 0) goto L_0x00d0
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ all -> 0x00ca }
            goto L_0x00d1
        L_0x00ca:
            r7 = move-exception
            java.lang.String r3 = "INSTALL"
            com.mbridge.msdk.foundation.tools.aa.b(r0, r3, r7)     // Catch:{ all -> 0x00f7 }
        L_0x00d0:
            r7 = 0
        L_0x00d1:
            com.mbridge.msdk.video.signal.c$a r3 = r5.l     // Catch:{ all -> 0x00f7 }
            r4 = 2
            if (r7 != r4) goto L_0x00d7
            goto L_0x00d8
        L_0x00d7:
            r1 = 0
        L_0x00d8:
            r3.a(r1)     // Catch:{ all -> 0x00f7 }
            com.mbridge.msdk.click.a r7 = r5.q()     // Catch:{ all -> 0x00f7 }
            com.mbridge.msdk.video.signal.c$a r1 = r5.l     // Catch:{ all -> 0x00f7 }
            r7.a((com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r1)     // Catch:{ all -> 0x00f7 }
            com.mbridge.msdk.click.a r7 = r5.q()     // Catch:{ all -> 0x00f7 }
            r7.a((com.mbridge.msdk.foundation.entity.CampaignEx) r6)     // Catch:{ all -> 0x00f7 }
            com.mbridge.msdk.foundation.controller.b r7 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x00f7 }
            android.content.Context r7 = r7.g()     // Catch:{ all -> 0x00f7 }
            com.mbridge.msdk.video.module.b.b.d(r7, r6)     // Catch:{ all -> 0x00f7 }
            goto L_0x00ff
        L_0x00f7:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r0, r7, r6)
        L_0x00ff:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.a.j.click(int, java.lang.String):void");
    }

    public final void handlerH5Exception(int i, String str) {
        super.handlerH5Exception(i, str);
        try {
            this.l.a(i, str);
        } catch (Throwable th) {
            aa.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    public final void a(int i, String str) {
        super.a(i, str);
        if (i == 2) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                final String optString = jSONObject.optString("event", "event");
                final String optString2 = jSONObject.optString("template", "-1");
                final String optString3 = jSONObject.optString("layout", "-1");
                final String optString4 = jSONObject.optString(MBridgeConstans.PROPERTIES_UNIT_ID, this.i);
                final int r2 = w.r(this.n.getApplication());
                AnonymousClass1 r22 = new Runnable() {
                    public final void run() {
                        q.a((g) h.a((Context) j.this.n.getApplication())).a(new n("2000039", optString, optString2, optString3, optString4, j.this.q.getId(), r2, w.a((Context) j.this.n.getApplication(), r2)));
                    }
                };
                c.a();
                com.mbridge.msdk.foundation.same.f.b.a().execute(r22);
            } catch (Throwable th) {
                aa.b("DefaultJSCommon", th.getMessage(), th);
            }
        }
    }

    public final void f() {
        super.f();
        if (this.l != null) {
            this.l.b();
        }
    }

    public final void d() {
        super.d();
        try {
            Activity activity = this.n;
            if (activity != null) {
                activity.finish();
            }
        } catch (Throwable th) {
            aa.b("DefaultJSCommon", th.getMessage(), th);
        }
    }

    private a q() {
        if (this.k == null) {
            this.k = new a(b.d().g(), this.i);
        }
        return this.k;
    }

    public final String g(int i) {
        switch (i) {
            case 1:
                return s().toString();
            case 2:
                return t().toString();
            case 3:
                return u().toString();
            case 4:
                return v().toString();
            case 5:
                return w().toString();
            case 6:
                return x().toString();
            default:
                return r().toString();
        }
    }

    private JSONObject r() {
        JSONObject jSONObject = new JSONObject();
        e eVar = new e(b.d().g());
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.m);
            jSONObject.put("sdkSetting", jSONObject2);
            jSONObject.put("device", eVar.a());
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(CampaignEx.campaignToJsonObject(this.q));
            jSONObject.put("campaignList", jSONArray);
            jSONObject.put("unitSetting", y());
            String c = f.a().c(b.d().h());
            if (!TextUtils.isEmpty(c)) {
                JSONObject jSONObject3 = new JSONObject(c);
                a(jSONObject3);
                String d = f.a().d(this.i);
                if (!TextUtils.isEmpty(d)) {
                    jSONObject3.put("ivreward", d);
                }
                jSONObject.put("appSetting", jSONObject3.toString());
            }
            jSONObject.put("rewardSetting", z());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject s() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_info", "MAL_16.5.91,3.0.1");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.i)) {
                jSONObject.put(MBridgeConstans.PROPERTIES_UNIT_ID, this.i);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject u() {
        JSONObject jSONObject = new JSONObject();
        try {
            String c = f.a().c(b.d().h());
            if (!TextUtils.isEmpty(c)) {
                jSONObject.put("appSetting", new JSONObject(c));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private JSONObject v() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.j != null) {
                jSONObject.put("unitSetting", this.j.F());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject w() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("device", new e(b.d().g()).a());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("playVideoMute", this.m);
            jSONObject2.put(ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_ID, this.t);
            jSONObject.put("sdkSetting", jSONObject2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private JSONObject y() {
        return this.j != null ? this.j.F() : new JSONObject();
    }

    private JSONObject z() {
        JSONObject jSONObject = new JSONObject();
        com.mbridge.msdk.videocommon.d.a b = com.mbridge.msdk.videocommon.d.b.a().b();
        return b != null ? b.l() : jSONObject;
    }

    public final void a(Activity activity) {
        this.n = activity;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r0 = com.mbridge.msdk.c.f.a().b(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(com.mbridge.msdk.foundation.entity.CampaignEx r7) {
        /*
            r6 = this;
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r0 = r0.h()     // Catch:{ Exception -> 0x0039 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0039 }
            r2 = 0
            if (r1 != 0) goto L_0x0023
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x0039 }
            com.mbridge.msdk.c.e r0 = r1.b(r0)     // Catch:{ Exception -> 0x0039 }
            if (r0 == 0) goto L_0x0023
            long r0 = r0.Q()     // Catch:{ Exception -> 0x0039 }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 * r4
            goto L_0x0024
        L_0x0023:
            r0 = r2
        L_0x0024:
            com.mbridge.msdk.videocommon.d.b r4 = com.mbridge.msdk.videocommon.d.b.a()     // Catch:{ Exception -> 0x0039 }
            com.mbridge.msdk.videocommon.d.a r4 = r4.b()     // Catch:{ Exception -> 0x0039 }
            if (r4 == 0) goto L_0x0032
            long r2 = r4.f()     // Catch:{ Exception -> 0x0039 }
        L_0x0032:
            if (r7 == 0) goto L_0x0039
            boolean r7 = r7.isSpareOffer(r2, r0)     // Catch:{ Exception -> 0x0039 }
            return r7
        L_0x0039:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.signal.a.j.b(com.mbridge.msdk.foundation.entity.CampaignEx):boolean");
    }

    public final void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.p = str;
        }
    }

    public final String i() {
        aa.a("DefaultJSCommon", "getNotchArea");
        return this.p;
    }
}
