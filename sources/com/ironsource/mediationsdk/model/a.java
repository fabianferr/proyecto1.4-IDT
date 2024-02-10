package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

public final class a {
    public NetworkSettings a;
    public JSONObject b;
    public IronSource.AD_UNIT c;
    public boolean d;
    public boolean e;
    public int f;
    public int g;

    public a(NetworkSettings networkSettings, JSONObject jSONObject, IronSource.AD_UNIT ad_unit) {
        this.a = networkSettings;
        this.b = jSONObject;
        int optInt = jSONObject.optInt("instanceType");
        this.f = optInt;
        this.d = optInt == 2;
        this.e = jSONObject.optBoolean(IronSourceConstants.EARLY_INIT_FIELD);
        this.g = jSONObject.optInt("maxAdsPerSession", 99);
        this.c = ad_unit;
    }
}
