package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.f.u;
import com.applovin.impl.sdk.m;
import org.json.JSONObject;

public class a extends com.applovin.impl.sdk.f.a {
    /* access modifiers changed from: private */
    public final String a;
    /* access modifiers changed from: private */
    public final c<JSONObject> c;

    public a(String str, c<JSONObject> cVar, m mVar) {
        super("CommunicatorRequestTask:" + str, mVar);
        this.a = str;
        this.c = cVar;
    }

    public void run() {
        this.b.S().a((com.applovin.impl.sdk.f.a) new u<JSONObject>(this.c, this.b, g()) {
            public void a(int i, String str, JSONObject jSONObject) {
                this.b.ag().a(a.this.a, a.this.c.a(), i, jSONObject, str, false);
            }

            public void a(JSONObject jSONObject, int i) {
                this.b.ag().a(a.this.a, a.this.c.a(), i, jSONObject, (String) null, true);
            }
        });
    }
}
