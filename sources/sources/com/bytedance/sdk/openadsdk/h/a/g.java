package com.bytedance.sdk.openadsdk.h.a;

import com.bytedance.sdk.component.a.e;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.component.widget.SSWebView;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: PreventTouchEventMethod */
public class g extends e<JSONObject, JSONObject> {
    private WeakReference<SSWebView> a;

    public static void a(r rVar, SSWebView sSWebView) {
        rVar.a("preventTouchEvent", (e<?, ?>) new g(sSWebView));
    }

    public g(SSWebView sSWebView) {
        this.a = new WeakReference<>(sSWebView);
    }

    public JSONObject a(JSONObject jSONObject, f fVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            boolean optBoolean = jSONObject.optBoolean("isPrevent", false);
            SSWebView sSWebView = (SSWebView) this.a.get();
            if (sSWebView != null) {
                sSWebView.setIsPreventTouchEvent(optBoolean);
                jSONObject2.put("success", true);
            } else {
                jSONObject2.put("success", false);
            }
        } catch (Throwable unused) {
            jSONObject2.put("success", false);
        }
        return jSONObject2;
    }
}
