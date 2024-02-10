package com.applovin.impl.mediation.debugger.c;

import com.applovin.impl.mediation.d.c;
import com.applovin.impl.sdk.f.u;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends com.applovin.impl.sdk.f.a {
    /* access modifiers changed from: private */
    public final b.c<JSONObject> a;

    public a(b.c<JSONObject> cVar, m mVar) {
        super("TaskFetchMediationDebuggerInfo", mVar, true);
        this.a = cVar;
    }

    private JSONObject a(m mVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installed_mediation_adapters", c.a(mVar));
        } catch (JSONException e) {
            a("Failed to create mediation debugger request post body", e);
        }
        return jSONObject;
    }

    private JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("installed_mediation_adapters", c.a(this.b));
            Boolean a2 = j.a().a(f());
            if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.dA)).booleanValue() && !Boolean.TRUE.equals(a2)) {
                o.a k = this.b.V().k();
                if (StringUtils.isValidString(k.b)) {
                    jSONObject.put("idfa", k.b);
                }
            }
        } catch (JSONException e) {
            a("Failed to construct JSON body", e);
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        Map<String, String> map = CollectionUtils.map();
        map.put("sdk_version", AppLovinSdk.VERSION);
        if (!((Boolean) this.b.a(com.applovin.impl.sdk.d.b.es)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.b.z());
        }
        Map<String, Object> h = this.b.V().h();
        map.put(CampaignEx.JSON_KEY_PACKAGE_NAME, String.valueOf(h.get(CampaignEx.JSON_KEY_PACKAGE_NAME)));
        map.put("app_version", String.valueOf(h.get("app_version")));
        Map<String, Object> b = this.b.V().b();
        map.put("platform", String.valueOf(b.get("platform")));
        map.put("os", String.valueOf(b.get("os")));
        return map;
    }

    public void run() {
        AnonymousClass1 r1 = new u<JSONObject>(com.applovin.impl.sdk.network.c.a(this.b).b("POST").a(com.applovin.impl.mediation.d.b.c(this.b)).c(com.applovin.impl.mediation.d.b.d(this.b)).a(a()).a(a(this.b)).a(new JSONObject()).b(((Long) this.b.a(com.applovin.impl.sdk.d.a.g)).intValue()).a(b()).a(), this.b, g()) {
            public void a(int i, String str, JSONObject jSONObject) {
                a.this.a.a(i, str, jSONObject);
            }

            public void a(JSONObject jSONObject, int i) {
                a.this.a.a(jSONObject, i);
            }
        };
        r1.a(com.applovin.impl.sdk.d.a.c);
        r1.b(com.applovin.impl.sdk.d.a.d);
        this.b.S().a((com.applovin.impl.sdk.f.a) r1);
    }
}
