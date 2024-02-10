package com.applovin.impl.sdk.nativeAd;

import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.MaxAdFormat;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class d extends a {
    private final JSONObject a;
    private final AppLovinNativeAdLoadListener c;

    public d(JSONObject jSONObject, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, m mVar) {
        super("TaskProcessNativeAdResponse", mVar);
        this.a = jSONObject;
        this.c = appLovinNativeAdLoadListener;
    }

    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.a, CampaignUnit.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            if (u.a()) {
                a("Processing ad...");
            }
            this.b.S().a((a) new e(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()), this.a, this.c, this.b));
            return;
        }
        if (u.a()) {
            c("No ads were returned from the server");
        }
        Utils.maybeHandleNoFillResponseForPublisher("native_native", MaxAdFormat.NATIVE, this.a, this.b);
        this.c.onNativeAdLoadFailed(204);
    }
}
