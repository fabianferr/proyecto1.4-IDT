package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import org.json.JSONObject;

public abstract class y extends a {
    protected y(String str, m mVar) {
        super(str, mVar);
    }

    /* access modifiers changed from: protected */
    public abstract String a();

    /* access modifiers changed from: protected */
    public void a(int i) {
        h.a(i, this.b);
    }

    /* access modifiers changed from: protected */
    public abstract void a(JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject, final b.c<JSONObject> cVar) {
        AnonymousClass1 r0 = new u<JSONObject>(c.a(this.b).a(h.a(a(), this.b)).c(h.b(a(), this.b)).a(h.e(this.b)).b("POST").a(jSONObject).d(((Boolean) this.b.a(com.applovin.impl.sdk.d.b.eD)).booleanValue()).a(new JSONObject()).a(h()).a(), this.b) {
            public void a(int i, String str, JSONObject jSONObject) {
                cVar.a(i, str, jSONObject);
            }

            public void a(JSONObject jSONObject, int i) {
                cVar.a(jSONObject, i);
            }
        };
        r0.a(com.applovin.impl.sdk.d.b.aV);
        r0.b(com.applovin.impl.sdk.d.b.aW);
        this.b.S().a((a) r0);
    }

    /* access modifiers changed from: protected */
    public abstract int h();

    /* access modifiers changed from: protected */
    public JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        String m = this.b.m();
        if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.dt)).booleanValue() && StringUtils.isValidString(m)) {
            JsonUtils.putString(jSONObject, "cuid", m);
        }
        if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.dv)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.b.n());
        }
        if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.dx)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.b.o());
        }
        a(jSONObject);
        return jSONObject;
    }
}
