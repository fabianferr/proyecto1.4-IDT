package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.ad.b;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class p extends a implements AppLovinAdLoadListener {
    private final JSONObject a;
    private final d c;
    private final b d;
    private final AppLovinAdLoadListener e;

    public p(JSONObject jSONObject, d dVar, b bVar, AppLovinAdLoadListener appLovinAdLoadListener, m mVar) {
        super("TaskProcessAdResponse", mVar);
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (dVar != null) {
            this.a = jSONObject;
            this.c = dVar;
            this.d = bVar;
            this.e = appLovinAdLoadListener;
        } else {
            throw new IllegalArgumentException("No zone specified");
        }
    }

    /* JADX WARNING: type inference failed for: r0v10, types: [com.applovin.impl.sdk.f.a] */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.applovin.impl.sdk.f.q] */
    /* JADX WARNING: type inference failed for: r1v12, types: [com.applovin.impl.sdk.f.s] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(org.json.JSONObject r8) {
        /*
            r7 = this;
            java.lang.String r0 = "type"
            java.lang.String r1 = "undefined"
            java.lang.String r0 = com.applovin.impl.sdk.utils.JsonUtils.getString(r8, r0, r1)
            java.lang.String r1 = "applovin"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x0033
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x001b
            java.lang.String r0 = "Starting task for AppLovin ad..."
            r7.a(r0)
        L_0x001b:
            com.applovin.impl.sdk.f.s r0 = new com.applovin.impl.sdk.f.s
            org.json.JSONObject r3 = r7.a
            com.applovin.impl.sdk.ad.b r4 = r7.d
            com.applovin.impl.sdk.m r6 = r7.b
            r1 = r0
            r2 = r8
            r5 = r7
            r1.<init>(r2, r3, r4, r5, r6)
        L_0x0029:
            com.applovin.impl.sdk.m r8 = r7.b
            com.applovin.impl.sdk.f.o r8 = r8.S()
            r8.a((com.applovin.impl.sdk.f.a) r0)
            goto L_0x0098
        L_0x0033:
            java.lang.String r1 = "vast"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x005a
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x0046
            java.lang.String r0 = "Starting task for VAST ad..."
            r7.a(r0)
        L_0x0046:
            org.json.JSONObject r0 = r7.a
            com.applovin.impl.sdk.ad.b r1 = r7.d
            com.applovin.impl.sdk.m r2 = r7.b
            com.applovin.impl.sdk.f.r r8 = com.applovin.impl.sdk.f.r.a(r8, r0, r1, r7, r2)
            com.applovin.impl.sdk.m r0 = r7.b
            com.applovin.impl.sdk.f.o r0 = r0.S()
            r0.a((com.applovin.impl.sdk.f.a) r8)
            goto L_0x0098
        L_0x005a:
            java.lang.String r1 = "js_tag"
            boolean r1 = r1.equalsIgnoreCase(r0)
            if (r1 == 0) goto L_0x007c
            boolean r0 = com.applovin.impl.sdk.u.a()
            if (r0 == 0) goto L_0x006d
            java.lang.String r0 = "Starting task for JS tag ad..."
            r7.a(r0)
        L_0x006d:
            com.applovin.impl.sdk.f.q r0 = new com.applovin.impl.sdk.f.q
            org.json.JSONObject r3 = r7.a
            com.applovin.impl.sdk.ad.b r4 = r7.d
            com.applovin.impl.sdk.m r6 = r7.b
            r1 = r0
            r2 = r8
            r5 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0029
        L_0x007c:
            boolean r8 = com.applovin.impl.sdk.u.a()
            if (r8 == 0) goto L_0x0093
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r1 = "Unable to process ad of unknown type: "
            r8.<init>(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.c(r8)
        L_0x0093:
            r8 = -800(0xfffffffffffffce0, float:NaN)
            r7.failedToReceiveAd(r8)
        L_0x0098:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.f.p.a(org.json.JSONObject):void");
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.adReceived(appLovinAd);
        }
    }

    public void failedToReceiveAd(int i) {
        AppLovinAdLoadListener appLovinAdLoadListener = this.e;
        if (appLovinAdLoadListener != null) {
            appLovinAdLoadListener.failedToReceiveAd(i);
        }
    }

    public void run() {
        JSONArray jSONArray = JsonUtils.getJSONArray(this.a, CampaignUnit.JSON_KEY_ADS, new JSONArray());
        if (jSONArray.length() > 0) {
            if (u.a()) {
                a("Processing ad...");
            }
            a(JsonUtils.getJSONObject(jSONArray, 0, new JSONObject()));
            return;
        }
        if (u.a()) {
            c("No ads were returned from the server");
        }
        Utils.maybeHandleNoFillResponseForPublisher(this.c.a(), this.c.b(), this.a, this.b);
        failedToReceiveAd(204);
    }
}
