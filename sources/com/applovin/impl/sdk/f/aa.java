package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.Collections;
import java.util.Map;
import org.json.JSONObject;

public class aa extends ab {
    private final e a;
    private final AppLovinAdRewardListener c;

    public aa(e eVar, AppLovinAdRewardListener appLovinAdRewardListener, m mVar) {
        super("TaskValidateAppLovinReward", mVar);
        this.a = eVar;
        this.c = appLovinAdRewardListener;
    }

    public String a() {
        return "2.0/vr";
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        String str;
        super.a(i);
        if (i < 400 || i >= 500) {
            this.c.validationRequestFailed(this.a, i);
            str = "network_timeout";
        } else {
            this.c.userRewardRejected(this.a, Collections.emptyMap());
            str = "rejected";
        }
        this.a.a(c.a(str));
    }

    /* access modifiers changed from: protected */
    public void a(c cVar) {
        this.a.a(cVar);
        String b = cVar.b();
        Map<String, String> a2 = cVar.a();
        if (b.equals("accepted")) {
            this.c.userRewardVerified(this.a, a2);
        } else if (b.equals("quota_exceeded")) {
            this.c.userOverQuota(this.a, a2);
        } else if (b.equals("rejected")) {
            this.c.userRewardRejected(this.a, a2);
        } else {
            this.c.validationRequestFailed(this.a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public void a(JSONObject jSONObject) {
        JsonUtils.putString(jSONObject, AppLovinUtils.ServerParameterKeys.ZONE_ID, this.a.getAdZone().a());
        String clCode = this.a.getClCode();
        if (!StringUtils.isValidString(clCode)) {
            clCode = "NO_CLCODE";
        }
        JsonUtils.putString(jSONObject, "clcode", clCode);
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return this.a.aE();
    }
}
