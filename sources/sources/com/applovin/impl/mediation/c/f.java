package com.applovin.impl.mediation.c;

import com.applovin.impl.mediation.a.c;
import com.applovin.impl.sdk.f.w;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import org.json.JSONObject;

public class f extends w {
    private final c a;

    public f(c cVar, m mVar) {
        super("TaskReportMaxReward", mVar);
        this.a = cVar;
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "2.0/mcr";
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        super.a(i);
        if (u.a()) {
            a("Failed to report reward for mediated ad: " + this.a + " - error code: " + i);
        }
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.a.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.a.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.a.ab());
        String D = this.a.D();
        if (!StringUtils.isValidString(D)) {
            D = "NO_MCODE";
        }
        JsonUtils.putString(jSONObject, "mcode", D);
        String C = this.a.C();
        if (!StringUtils.isValidString(C)) {
            C = "NO_BCODE";
        }
        JsonUtils.putString(jSONObject, "bcode", C);
    }

    /* access modifiers changed from: protected */
    public com.applovin.impl.sdk.c.c b() {
        return this.a.G();
    }

    /* access modifiers changed from: protected */
    public void b(JSONObject jSONObject) {
        a("Reported reward successfully for mediated ad: " + this.a);
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (u.a()) {
            d("No reward result was found for mediated ad: " + this.a);
        }
    }
}
