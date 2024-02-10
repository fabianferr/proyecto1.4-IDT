package com.applovin.impl.mediation.d;

import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.h;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import org.json.JSONObject;

public class b extends h {
    private static final String[] a = {CampaignUnit.JSON_KEY_ADS, "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters"};
    private static final String[] b = {CampaignUnit.JSON_KEY_ADS, "settings", "signal_providers"};

    public static String a(m mVar) {
        return h.a((String) mVar.a(a.c), "1.0/mediate", mVar);
    }

    public static void a(JSONObject jSONObject, m mVar) {
        if (JsonUtils.valueExists(jSONObject, "signal_providers")) {
            JSONObject shallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(shallowCopy, a);
            mVar.a(d.x, shallowCopy.toString());
            if (((Boolean) mVar.a(com.applovin.impl.sdk.d.b.eX)).booleanValue()) {
                com.applovin.impl.mediation.c.b.a(shallowCopy);
            }
        }
    }

    public static String b(m mVar) {
        return h.a((String) mVar.a(a.d), "1.0/mediate", mVar);
    }

    public static void b(JSONObject jSONObject, m mVar) {
        if (jSONObject.length() != 0) {
            if (JsonUtils.valueExists(jSONObject, "auto_init_adapters") || JsonUtils.valueExists(jSONObject, "test_mode_auto_init_adapters")) {
                JSONObject shallowCopy = JsonUtils.shallowCopy(jSONObject);
                JsonUtils.removeObjectsForKeys(shallowCopy, b);
                mVar.a(d.y, shallowCopy.toString());
                return;
            }
            mVar.b(d.y);
        }
    }

    public static String c(m mVar) {
        return h.a((String) mVar.a(a.c), "1.0/mediate_debug", mVar);
    }

    public static String d(m mVar) {
        return h.a((String) mVar.a(a.d), "1.0/mediate_debug", mVar);
    }
}
