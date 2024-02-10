package com.ironsource.mediationsdk.a;

import com.ironsource.mediationsdk.C0214d;
import com.ironsource.mediationsdk.C0216f;
import com.ironsource.sdk.controller.h;
import java.net.URL;
import org.json.JSONObject;

public final class b extends C0216f.a {
    public b(C0214d dVar, URL url, JSONObject jSONObject, boolean z, int i, long j, boolean z2, boolean z3, int i2) {
        super(dVar, url, jSONObject, z, i, j, z2, z3, i2);
    }

    public final void a(boolean z, C0214d dVar, long j) {
        if (z) {
            try {
                ((h) dVar).a(this.a, j, this.g, this.f);
            } catch (Exception e) {
                dVar.a(1000, e.getMessage(), this.d + 1, this.e, j);
            }
        } else {
            dVar.a(this.b, this.c, this.d + 1, this.e, j);
        }
    }
}
