package com.mbridge.msdk.mbsignalcommon.communication;

import android.text.TextUtils;
import android.util.Base64;
import com.facebook.share.internal.ShareConstants;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONObject;

/* compiled from: CommonSignalCommunicatioImpUtils */
public class b {
    public static final String a = "b";
    public static int b = 0;
    public static int c = 1;

    public static void a(Object obj, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null) {
                a(obj, "data is empty");
                return;
            }
            final CampaignEx parseCampaignWithBackData = CampaignEx.parseCampaignWithBackData(optJSONObject);
            if (parseCampaignWithBackData == null) {
                a(obj, "data camapign is empty");
                return;
            }
            new Thread(new Runnable() {
                public final void run() {
                    try {
                        k a2 = k.a((g) h.a(com.mbridge.msdk.foundation.controller.b.d().g()));
                        if (a2 != null) {
                            if (!a2.a(parseCampaignWithBackData.getId())) {
                                com.mbridge.msdk.foundation.entity.g gVar = new com.mbridge.msdk.foundation.entity.g();
                                gVar.a(parseCampaignWithBackData.getId());
                                gVar.a(parseCampaignWithBackData.getFca());
                                gVar.b(parseCampaignWithBackData.getFcb());
                                gVar.d(0);
                                gVar.c(1);
                                gVar.a(System.currentTimeMillis());
                                a2.a(gVar);
                            } else {
                                a2.b(parseCampaignWithBackData.getId());
                            }
                        }
                        b.a(parseCampaignWithBackData.getCampaignUnitId(), parseCampaignWithBackData);
                    } catch (Throwable th) {
                        aa.b(b.a, th.getMessage(), th);
                    }
                }
            }).start();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", b);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", "");
            jSONObject2.put("data", jSONObject3);
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e) {
            a(obj, e.getMessage());
            aa.a(a, e.getMessage());
        } catch (Throwable th) {
            a(obj, th.getMessage());
        }
    }

    public static String a(float f, float f2) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(a.f, af.a(com.mbridge.msdk.foundation.controller.b.d().g(), f));
            jSONObject2.put(a.g, af.a(com.mbridge.msdk.foundation.controller.b.d().g(), f2));
            jSONObject2.put(a.i, 0);
            jSONObject2.put(a.j, com.mbridge.msdk.foundation.controller.b.d().g().getResources().getConfiguration().orientation);
            jSONObject2.put(a.k, (double) af.e(com.mbridge.msdk.foundation.controller.b.d().g()));
            jSONObject.put(a.h, jSONObject2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject.toString();
    }

    public static String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                return Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            return "";
        } catch (Throwable unused) {
            aa.d(a, "code to string is error");
            return "";
        }
    }

    public static void a(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", c);
            jSONObject.put(ShareConstants.WEB_DIALOG_PARAM_MESSAGE, str);
            jSONObject.put("data", new JSONObject());
            com.mbridge.msdk.mbsignalcommon.windvane.g.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            aa.a(a, e.getMessage());
        }
    }

    static /* synthetic */ void a(String str, CampaignEx campaignEx) {
        if (d.g != null && !TextUtils.isEmpty(campaignEx.getId())) {
            d.a(str, campaignEx, "banner");
        }
    }
}
