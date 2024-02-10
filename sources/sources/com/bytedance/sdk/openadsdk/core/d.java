package com.bytedance.sdk.openadsdk.core;

import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ConvertTracker */
public class d {
    public static void a(q qVar, String str, int i, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i);
        } catch (JSONException unused) {
        }
        c.b(qVar, str, "convert_track", jSONObject);
    }
}
