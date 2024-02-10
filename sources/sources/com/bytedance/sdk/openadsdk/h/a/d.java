package com.bytedance.sdk.openadsdk.h.a;

import com.bytedance.sdk.component.a.e;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.x;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InteractiveFinishMethod */
public class d extends e<JSONObject, JSONObject> {
    private final WeakReference<x> a;

    public static void a(r rVar, x xVar) {
        rVar.a("interactiveFinish", (e<?, ?>) new d(xVar));
    }

    public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<x> weakReference = this.a;
        if (!(weakReference == null || weakReference.get() == null)) {
            x xVar = (x) this.a.get();
            q c = xVar.c();
            boolean z = true;
            try {
                int i = 0;
                if (jSONObject.optInt("finish", 1) != 1) {
                    z = false;
                }
                int optInt = jSONObject.optInt("reduce_duration", -1);
                int ax = c != null ? c.ax() : 0;
                if (optInt >= 0 && ax >= 0) {
                    optInt = Math.min(optInt, ax);
                } else if (optInt < 0) {
                    optInt = ax >= 0 ? ax : 0;
                }
                if (z) {
                    xVar.c(optInt);
                } else {
                    i = -1;
                }
                jSONObject2.put("code", i);
                jSONObject2.put("reduce_duration", optInt);
            } catch (JSONException e) {
                l.e("InteractiveFinishMethod", e.getMessage());
            }
        }
        return jSONObject2;
    }

    public d(x xVar) {
        this.a = new WeakReference<>(xVar);
    }
}
