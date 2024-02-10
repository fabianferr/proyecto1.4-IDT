package com.bytedance.sdk.openadsdk.h.a;

import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.x;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: DoInterstitialWebViewCloseMethod */
public class b extends d<JSONObject, JSONObject> {
    private final WeakReference<x> a;

    /* access modifiers changed from: protected */
    public void d() {
    }

    public static void a(r rVar, final x xVar) {
        rVar.a("interstitial_webview_close", (d.b) new d.b() {
            public d a() {
                return new b(xVar);
            }
        });
    }

    public b(x xVar) {
        this.a = new WeakReference<>(xVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, f fVar) throws Exception {
        h.b().q();
        x xVar = (x) this.a.get();
        if (xVar == null) {
            l.e("DoInterstitialWebViewCloseMethod", "invoke error");
            c();
            return;
        }
        xVar.g();
    }
}
