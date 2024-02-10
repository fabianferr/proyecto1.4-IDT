package com.bytedance.sdk.openadsdk.core.nativeexpress.a;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.a;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.r;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TemplateUtils */
public class b {
    public static boolean a() {
        return true;
    }

    public static JSONObject a(float f, float f2, boolean z, q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("platform", "android");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, (double) f);
            jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, (double) f2);
            if (z) {
                jSONObject2.put("isLandscape", true);
            }
            jSONObject.put("AdSize", jSONObject2);
            if (qVar instanceof r) {
                if (((r) qVar).bw()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject.put("choose_ui_data", jSONObject3);
                    a.C0067a bx = ((r) qVar).bx();
                    JSONObject b = bx.b();
                    if (TextUtils.isEmpty(bx.h())) {
                        b.put("data", b(bx));
                    }
                    jSONObject3.put("tpl_info", b);
                    JSONArray jSONArray = new JSONArray();
                    jSONObject.put("creatives", jSONArray);
                    for (q next : ((r) qVar).by()) {
                        JSONObject a = a(false, next);
                        if (a != null) {
                            a.put("template_Plugin", b(next.I()));
                            a.put("diff_template_Plugin", a(next.I()));
                            jSONArray.put(a);
                        }
                    }
                    return jSONObject;
                }
            }
            jSONObject.put("creative", a(false, qVar));
            jSONObject.put("template_Plugin", b(qVar.I()));
            jSONObject.put("diff_template_Plugin", a(qVar.I()));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(q.a aVar) {
        return aVar != null ? aVar.i() : "";
    }

    private static String b(q.a aVar) {
        if (aVar == null) {
            return "";
        }
        String h = aVar.h();
        return (!TextUtils.isEmpty(h) || com.bytedance.sdk.component.adexpress.a.b.a.c(aVar.e()) == null) ? h : com.bytedance.sdk.component.adexpress.a.b.a.c(aVar.e()).e();
    }

    public static JSONObject a(boolean z, q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("button_text", qVar.X());
            if (qVar.N() != null) {
                if (qVar.N() != null) {
                    if (!TextUtils.isEmpty(qVar.N().a())) {
                        jSONObject.put(RewardPlus.ICON, qVar.N().a());
                    }
                }
                jSONObject.put(RewardPlus.ICON, "");
            }
            JSONArray jSONArray = new JSONArray();
            if (qVar.Q() != null) {
                for (int i = 0; i < qVar.Q().size(); i++) {
                    n nVar = qVar.Q().get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, nVar.c());
                    jSONObject2.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, nVar.b());
                    jSONObject2.put("url", nVar.a());
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("image", jSONArray);
            jSONObject.put("image_mode", qVar.ad());
            jSONObject.put("interaction_type", qVar.M());
            jSONObject.put("interaction_method", qVar.p());
            jSONObject.put("is_compliance_template", a());
            jSONObject.put("title", qVar.V());
            jSONObject.put("description", qVar.W());
            jSONObject.put("source", qVar.L());
            if (qVar.aa() != null) {
                jSONObject.put("comment_num", qVar.aa().e());
                jSONObject.put(FirebaseAnalytics.Param.SCORE, qVar.aa().d());
                jSONObject.put(CampaignEx.JSON_KEY_APP_SIZE, qVar.aa().f());
                jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, qVar.aa().g());
            }
            com.bykv.vk.openvk.component.video.api.c.b K = qVar.K();
            if (K != null) {
                JSONObject r = K.r();
                double f = K.f();
                double w = (double) K.w();
                Double.isNaN(w);
                r.put("video_duration", f * w);
                jSONObject.put("video", r);
            }
            if (qVar.I() != null) {
                jSONObject.put("dynamic_creative", qVar.I().j());
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String a(q qVar, String str) {
        List<n> Q;
        if (!(qVar == null || (Q = qVar.Q()) == null || Q.size() <= 0)) {
            for (n next : Q) {
                if (next != null && TextUtils.equals(str, next.a())) {
                    return next.g();
                }
            }
        }
        return null;
    }

    public static Map<String, String> a(q qVar) {
        HashMap hashMap = null;
        if (qVar == null) {
            return null;
        }
        List<n> Q = qVar.Q();
        if (Q != null && Q.size() > 0) {
            hashMap = new HashMap();
            for (n next : Q) {
                if (next != null) {
                    hashMap.put(next.a(), next.g());
                }
            }
        }
        return hashMap;
    }
}
