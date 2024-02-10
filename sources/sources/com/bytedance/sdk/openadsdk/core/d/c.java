package com.bytedance.sdk.openadsdk.core.d;

import com.bytedance.sdk.component.f.a.a;
import com.bytedance.sdk.component.f.b;
import com.bytedance.sdk.component.f.b.d;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FrequentCallEventHelper */
public class c {
    public static void a(String str, long j) {
        JSONObject b = b(str, j);
        d b2 = com.bytedance.sdk.openadsdk.k.c.a().b().b();
        b2.a(ac.d("/api/ad/union/sdk/stats/"));
        b2.c(b.toString());
        b2.a((a) new a() {
            public void a(com.bytedance.sdk.component.f.b.c cVar, b bVar) {
            }

            public void a(com.bytedance.sdk.component.f.b.c cVar, IOException iOException) {
                l.c("uploadFrequentEvent", iOException.getMessage());
            }
        });
    }

    private static JSONObject b(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
