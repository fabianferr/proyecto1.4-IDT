package com.bytedance.sdk.openadsdk.h.a;

import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.i.c;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: DoGetAdsFromNetworkAsyncMethod */
public class a extends d<JSONObject, JSONObject> {
    private final WeakReference<x> a;

    /* access modifiers changed from: protected */
    public void d() {
    }

    public static void a(r rVar, final x xVar) {
        rVar.a("getNetworkData", (d.b) new d.b() {
            public d a() {
                return new a(xVar);
            }
        });
    }

    public a(x xVar) {
        this.a = new WeakReference<>(xVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, f fVar) throws Exception {
        x xVar = (x) this.a.get();
        if (xVar == null) {
            c();
        } else {
            xVar.a(jSONObject, (c) new c() {
            });
        }
    }
}
