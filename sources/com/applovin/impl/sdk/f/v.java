package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import org.json.JSONObject;

public class v extends w {
    private final e a;

    public v(e eVar, m mVar) {
        super("TaskReportAppLovinReward", mVar);
        this.a = eVar;
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "2.0/cr";
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        super.a(i);
        if (u.a()) {
            d("Failed to report reward for ad: " + this.a + " - error code: " + i);
        }
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, this.a.getAdZone().a());
        JsonUtils.putInt(jSONObject, "fire_percent", this.a.ae());
        String clCode = this.a.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    /* access modifiers changed from: protected */
    public c b() {
        return this.a.aG();
    }

    /* access modifiers changed from: protected */
    public void b(JSONObject jSONObject) {
        if (u.a()) {
            a("Reported reward successfully for ad: " + this.a);
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (u.a()) {
            d("No reward result was found for ad: " + this.a);
        }
    }
}
