package com.ironsource.sdk;

import com.ironsource.sdk.j.a;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class c {
    public boolean a = false;
    public boolean b = false;
    public a c = null;
    public Map<String, String> d;
    public boolean e;
    private String f;
    private final a g;

    public c(String str, a aVar) {
        this.f = SDKUtils.requireNonEmptyOrNull(str, "Instance name can't be null");
        this.g = (a) SDKUtils.requireNonNull(aVar, "AdListener name can't be null");
    }

    public final b a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f);
            jSONObject.put("rewarded", this.a);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new b((this.b || this.e) ? d.a() : d.a(jSONObject), this.f, this.a, this.b, this.e, this.d, this.g, this.c);
    }
}
