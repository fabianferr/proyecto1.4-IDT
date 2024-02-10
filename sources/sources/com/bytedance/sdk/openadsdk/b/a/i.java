package com.bytedance.sdk.openadsdk.b.a;

import com.bytedance.sdk.component.e.a.e.d;
import com.bytedance.sdk.component.f.b;

/* compiled from: NetResponseWrapper */
class i implements d {
    private final b a;

    public i(b bVar) {
        this.a = bVar;
    }

    public boolean a() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.f();
        }
        return false;
    }

    public int b() {
        b bVar = this.a;
        if (bVar != null) {
            return bVar.a();
        }
        return -1;
    }

    public String c() {
        b bVar = this.a;
        return bVar != null ? bVar.b() : "";
    }
}
