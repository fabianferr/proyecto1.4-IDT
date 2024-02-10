package com.bytedance.sdk.openadsdk.core.settings;

import com.bytedance.sdk.openadsdk.core.settings.d;
import org.json.JSONObject;

/* compiled from: MediationInitSettings */
public class i extends n {
    public i() {
        super("tt_set_mediation.prop");
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject.has("mediation_init_conf")) {
            d.a a = a();
            a.a("mediation_init_conf", jSONObject.optString("mediation_init_conf"));
            a.a();
        }
    }
}
