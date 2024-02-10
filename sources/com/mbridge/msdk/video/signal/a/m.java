package com.mbridge.msdk.video.signal.a;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.appnext.core.Ad;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.e;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.d.c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: JSRewardVideoV1 */
public final class m extends f {
    private Activity a;
    private MBridgeContainerView b;

    public m(Activity activity, MBridgeContainerView mBridgeContainerView) {
        this.a = activity;
        this.b = mBridgeContainerView;
    }

    public final String a() {
        c cVar;
        if (this.b == null) {
            super.a();
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.b.getCampaign());
                String unitID = this.b.getUnitID();
                if (b.a() == null) {
                    cVar = null;
                } else {
                    cVar = b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), unitID);
                }
                JSONObject jSONObject = new JSONObject();
                if (cVar != null) {
                    jSONObject = cVar.F();
                }
                aa.a("JSRewardVideoV1", "getEndScreenInfo success campaign = " + this.b.getCampaign());
                return a(arrayList, unitID, "MAL_16.5.91,3.0.1", jSONObject);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.a();
    }

    public final void toggleCloseBtn(int i) {
        super.toggleCloseBtn(i);
        MBridgeContainerView mBridgeContainerView = this.b;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.toggleCloseBtn(i);
        }
    }

    public final void a(String str) {
        MBridgeContainerView mBridgeContainerView;
        super.a(str);
        try {
            if (this.a != null && !TextUtils.isEmpty(str) && str.equals(CampaignEx.JSON_NATIVE_VIDEO_CLICK) && (mBridgeContainerView = this.b) != null) {
                mBridgeContainerView.triggerCloseBtn(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void notifyCloseBtn(int i) {
        super.notifyCloseBtn(i);
        MBridgeContainerView mBridgeContainerView = this.b;
        if (mBridgeContainerView != null) {
            mBridgeContainerView.notifyCloseBtn(i);
        }
    }

    public final void c(String str) {
        MBridgeContainerView mBridgeContainerView;
        super.c(str);
        try {
            if (this.a != null && !TextUtils.isEmpty(str) && (mBridgeContainerView = this.b) != null) {
                mBridgeContainerView.handlerPlayableException(str);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void b(String str) {
        super.b(str);
        try {
            if (this.a != null && !TextUtils.isEmpty(str)) {
                if (str.equals(Ad.ORIENTATION_LANDSCAPE)) {
                    this.a.setRequestedOrientation(0);
                } else if (str.equals(Ad.ORIENTATION_PORTRAIT)) {
                    this.a.setRequestedOrientation(1);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private String a(List<CampaignEx> list, String str, String str2, JSONObject jSONObject) {
        if (list == null) {
            return null;
        }
        try {
            if (list.size() <= 0) {
                return null;
            }
            e eVar = new e(com.mbridge.msdk.foundation.controller.b.d().g());
            JSONArray parseCamplistToJson = CampaignEx.parseCamplistToJson(list);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("campaignList", parseCamplistToJson);
            jSONObject2.put("device", eVar.a());
            jSONObject2.put(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            jSONObject2.put("sdk_info", str2);
            jSONObject2.put("unitSetting", jSONObject);
            if (f.a() != null) {
                String c = f.a().c(com.mbridge.msdk.foundation.controller.b.d().h());
                if (!TextUtils.isEmpty(c)) {
                    JSONObject jSONObject3 = new JSONObject(c);
                    try {
                        Context g = com.mbridge.msdk.foundation.controller.b.d().g();
                        String obj = ai.b(g, "MBridge_ConfirmTitle" + str, "").toString();
                        String obj2 = ai.b(g, "MBridge_ConfirmContent" + str, "").toString();
                        String obj3 = ai.b(g, "MBridge_CancelText" + str, "").toString();
                        String obj4 = ai.b(g, "MBridge_ConfirmText" + str, "").toString();
                        if (!TextUtils.isEmpty(obj)) {
                            jSONObject3.put("confirm_title", obj);
                        }
                        if (!TextUtils.isEmpty(obj2)) {
                            jSONObject3.put("confirm_description", obj2);
                        }
                        if (!TextUtils.isEmpty(obj3)) {
                            jSONObject3.put("confirm_t", obj3);
                        }
                        if (!TextUtils.isEmpty(obj4)) {
                            jSONObject3.put("confirm_c_play", obj4);
                        }
                        if (!TextUtils.isEmpty(obj4)) {
                            jSONObject3.put("confirm_c_rv", obj4);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    String d = f.a().d(str);
                    if (!TextUtils.isEmpty(d)) {
                        jSONObject3.put("ivreward", new JSONObject(d));
                    }
                    jSONObject2.put("appSetting", jSONObject3);
                }
            }
            return jSONObject2.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
