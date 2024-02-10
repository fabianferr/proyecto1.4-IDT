package com.bytedance.sdk.openadsdk.component.d;

import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.v;
import com.bytedance.sdk.openadsdk.j.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: TTAppOpenAdReport */
public class a {
    public static void a(final int i, final int i2) {
        b.a("openad_load_ad_timeout", false, (com.bytedance.sdk.openadsdk.j.a) new com.bytedance.sdk.openadsdk.j.a() {
            public com.bytedance.sdk.openadsdk.j.a.a getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("timeout_type", i);
                jSONObject.put("user_timeout_time", i2);
                return com.bytedance.sdk.openadsdk.j.a.b.b().a("openad_load_ad_timeout").b(jSONObject.toString());
            }
        });
    }

    public static void a(q qVar, int i, int i2, float f) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, qVar);
            jSONObject.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("skip_time", i);
            jSONObject.put("skip_show_time", i2);
            jSONObject.put("total_time", (double) f);
        } catch (JSONException e) {
            l.c("TTAppOpenAdReport", "reportSkip json error", e);
        }
        c.a(qVar, "skip", (long) i, jSONObject);
    }

    public static void a(q qVar, long j, float f, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, qVar);
            jSONObject.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
            if (z) {
                double d = (double) f;
                jSONObject.put("video_duration", d);
                double d2 = (double) j;
                Double.isNaN(d2);
                Double.isNaN(d);
                jSONObject.put("video_percent", (int) (((d2 * 1.0d) / 10.0d) / d));
            } else {
                jSONObject.put("image_duration", (double) f);
            }
        } catch (JSONException e) {
            l.c("TTAppOpenAdReport", "reportDestroy json error", e);
        }
        c.b(qVar, "destroy", jSONObject);
    }

    public static void a(q qVar) {
        c.b(qVar, "cache_expire", (JSONObject) null);
    }

    public static void b(q qVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException e) {
            l.c("TTAppOpenAdReport", "reportCacheLoss json error", e);
        }
        c.b(qVar, "cache_loss", jSONObject);
    }

    public static void a(q qVar, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("order", z ? 1 : 2);
        } catch (JSONException unused) {
        }
        c.a(qVar, "download_image_duration", j, jSONObject);
    }

    public static void b(q qVar, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("size", qVar.K().e());
            jSONObject.put("video_duration", qVar.K().f());
            jSONObject.put("order", z ? 1 : 2);
        } catch (JSONException unused) {
        }
        c.a(qVar, "download_video_duration", j, jSONObject);
    }

    public static void a(q qVar, int i, v vVar) {
        JSONObject jSONObject = new JSONObject();
        long j = 0;
        try {
            jSONObject.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
            jSONObject.put("open_ad_cache_type", i);
            if (vVar != null) {
                vVar.b(ab.a());
                a(jSONObject, qVar);
                jSONObject.put("client_start_time", vVar.b());
                jSONObject.put("sever_time", vVar.d());
                jSONObject.put("network_time", vVar.c());
                jSONObject.put("client_end_time", vVar.e());
                jSONObject.put("download_resource_duration", vVar.g());
                jSONObject.put("resource_source", vVar.h());
                jSONObject.put("is_bidding", vVar.a ? 1 : 0);
                if (vVar.a) {
                    jSONObject.put("load_wait_time", vVar.b);
                }
                j = vVar.f();
            }
        } catch (JSONException e) {
            l.c("TTAppOpenAdReport", "reportLoadNetDuration json error", e);
        }
        c.a(qVar, "load_net_duration", j, jSONObject);
    }

    public static void a(q qVar, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            a(jSONObject, qVar);
            jSONObject.put("openad_creative_type", q.c(qVar) ? "video_normal_ad" : "image_normal_ad");
        } catch (JSONException unused) {
            l.e("TTAppOpenAdReport", "reportLoadCacheDuration json error");
        }
        c.a(qVar, "load_cache_duration", j, jSONObject);
    }

    private static void a(JSONObject jSONObject, q qVar) {
        int i;
        if (qVar != null) {
            try {
                if (qVar.br()) {
                    i = 1;
                    jSONObject.put("is_icon_only", i);
                }
            } catch (JSONException e) {
                l.e("TTAppOpenAdReport", e.getMessage());
                return;
            }
        }
        i = 0;
        jSONObject.put("is_icon_only", i);
    }
}
