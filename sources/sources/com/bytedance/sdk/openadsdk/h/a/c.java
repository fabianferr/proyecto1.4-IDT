package com.bytedance.sdk.openadsdk.h.a;

import com.bytedance.sdk.component.a.d;
import com.bytedance.sdk.component.a.f;
import com.bytedance.sdk.component.a.r;
import com.bytedance.sdk.openadsdk.core.x;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: DoNewClickEventMethod */
public class c extends d<JSONObject, JSONObject> {
    private final WeakReference<x> a;

    /* access modifiers changed from: protected */
    public void d() {
    }

    public static void a(r rVar, final x xVar) {
        rVar.a("newClickEvent", (d.b) new d.b() {
            public d a() {
                return new c(xVar);
            }
        });
    }

    public c(x xVar) {
        this.a = new WeakReference<>(xVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject, f fVar) throws Exception {
        x xVar = (x) this.a.get();
        if (xVar == null) {
            c();
        } else {
            xVar.c(jSONObject);
        }
    }
}
