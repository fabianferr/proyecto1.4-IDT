package com.applovin.impl.sdk.f;

import android.text.TextUtils;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.sdk.AppLovinSdk;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.umlaut.crowd.internal.ia;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class b extends a {
    b(m mVar) {
        super("TaskApiSubmitData", mVar);
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        try {
            JSONObject a = h.a(jSONObject);
            this.b.K().a((com.applovin.impl.sdk.d.b<?>) com.applovin.impl.sdk.d.b.V, (Object) a.getString("device_id"));
            this.b.K().a((com.applovin.impl.sdk.d.b<?>) com.applovin.impl.sdk.d.b.X, (Object) a.getString("device_token"));
            this.b.K().a((com.applovin.impl.sdk.d.b<?>) com.applovin.impl.sdk.d.b.Y, (Object) Long.valueOf(a.getLong("publisher_id")));
            h.d(a, this.b);
            h.e(a, this.b);
            String string = JsonUtils.getString(a, "latest_version", "");
            if (!TextUtils.isEmpty(string) && !AppLovinSdk.VERSION.equals(string) && u.a()) {
                String str = "Current SDK version (" + AppLovinSdk.VERSION + ") is outdated. Please integrate the latest version of the AppLovin SDK (" + string + "). Doing so will improve your CPMs and ensure you have access to the latest revenue earning features.";
                if (JsonUtils.valueExists(a, "sdk_update_message")) {
                    str = JsonUtils.getString(a, "sdk_update_message", str);
                }
                u.h("AppLovinSdk", str);
            }
            this.b.T().b();
        } catch (Throwable th) {
            if (u.a()) {
                a("Unable to parse API response", th);
            }
        }
    }

    private void b(JSONObject jSONObject) throws JSONException {
        o V = this.b.V();
        Map<String, Object> d = V.d();
        Utils.renameKeyInObjectMap("platform", "type", d);
        Utils.renameKeyInObjectMap("api_level", "sdk_version", d);
        jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_PARAM, new JSONObject(d));
        Map<String, Object> h = V.h();
        Utils.renameKeyInObjectMap("sdk_version", "applovin_sdk_version", h);
        Utils.renameKeyInObjectMap(ia.j, "installed_at", h);
        jSONObject.put("app_info", new JSONObject(h));
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.ec)).booleanValue()) {
            jSONObject.put("stats", this.b.T().c());
        }
    }

    private void d(JSONObject jSONObject) {
        AnonymousClass1 r0 = new u<JSONObject>(c.a(this.b).a(h.a("2.0/device", this.b)).c(h.b("2.0/device", this.b)).a(h.e(this.b)).b("POST").a(jSONObject).d(((Boolean) this.b.a(com.applovin.impl.sdk.d.b.ez)).booleanValue()).a(new JSONObject()).a(((Integer) this.b.a(com.applovin.impl.sdk.d.b.cW)).intValue()).a(), this.b) {
            public void a(int i, String str, JSONObject jSONObject) {
                h.a(i, this.b);
            }

            public void a(JSONObject jSONObject, int i) {
                b.this.a(jSONObject);
            }
        };
        r0.a(com.applovin.impl.sdk.d.b.aV);
        r0.b(com.applovin.impl.sdk.d.b.aW);
        this.b.S().a((a) r0);
    }

    public void run() {
        try {
            if (u.a()) {
                b("Submitting user data...");
            }
            JSONObject jSONObject = new JSONObject();
            b(jSONObject);
            c(jSONObject);
            d(jSONObject);
        } catch (JSONException e) {
            if (u.a()) {
                a("Unable to build JSON message with collected data", e);
            }
        }
    }
}
