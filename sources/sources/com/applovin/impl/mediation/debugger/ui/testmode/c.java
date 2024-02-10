package com.applovin.impl.mediation.debugger.ui.testmode;

import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    private final m a;
    private boolean b;
    private boolean c;
    private String d;

    public c(m mVar) {
        this.a = mVar;
        this.d = (String) mVar.b(d.B, null);
        mVar.b(d.B);
        if (StringUtils.isValidString(this.d)) {
            this.c = true;
        }
        this.b = ((Boolean) mVar.b(d.C, false)).booleanValue();
        mVar.b(d.C);
    }

    public void a(String str) {
        this.d = str;
    }

    public void a(JSONObject jSONObject) {
        if (!this.b) {
            this.b = JsonUtils.containsCaseInsensitiveString(this.a.V().k().b, JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray())) || this.a.V().g() || AppLovinSdkUtils.isEmulator();
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean a() {
        return this.b;
    }

    public boolean b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public void d() {
        this.a.a(d.C, true);
    }
}
