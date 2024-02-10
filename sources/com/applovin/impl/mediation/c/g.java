package com.applovin.impl.mediation.c;

import com.applovin.impl.mediation.a.c;
import com.applovin.impl.sdk.f.ab;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONObject;

public class g extends ab {
    private final c a;

    public g(c cVar, m mVar) {
        super("TaskValidateMaxReward", mVar);
        this.a = cVar;
    }

    /* access modifiers changed from: protected */
    public String a() {
        return "2.0/mvr";
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        super.a(i);
        this.a.a(com.applovin.impl.sdk.c.c.a((i < 400 || i >= 500) ? "network_timeout" : "rejected"));
    }

    /* access modifiers changed from: protected */
    public void a(com.applovin.impl.sdk.c.c cVar) {
        this.a.a(cVar);
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, "ad_unit_id", this.a.getAdUnitId());
        JsonUtils.putString(jSONObject, "placement", this.a.getPlacement());
        JsonUtils.putString(jSONObject, "custom_data", this.a.ab());
        JsonUtils.putString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, this.a.getFormat().getLabel());
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
    public boolean b() {
        return this.a.E();
    }
}
