package com.applovin.impl.mediation.debugger.b.a;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

public class e {
    private final String a;
    private final String b;

    public e(JSONObject jSONObject, m mVar) {
        this.a = JsonUtils.getString(jSONObject, "id", "");
        this.b = JsonUtils.getString(jSONObject, "price", (String) null);
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }
}
