package com.bytedance.sdk.openadsdk.h.a;

import com.bytedance.sdk.component.a.e;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.x;
import org.json.JSONObject;

/* compiled from: SendCommerceLandingPageMeta */
public class h extends e<JSONObject, JSONObject> {
    private final x a;

    public h(x xVar) {
        this.a = xVar;
    }

    public static void a(r rVar, x xVar) {
        rVar.a("commonConvert", (e<?, ?>) new h(xVar));
    }

    public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
        this.a.d(jSONObject);
        return null;
    }
}
