package com.applovin.impl.mediation.c;

import android.content.Context;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d.b;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.j;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c extends a {
    private final String a;
    private final MaxAdFormat c;
    private final Map<String, Object> d;
    private final Map<String, Object> e;
    private final JSONArray f;
    private final Context g;
    private final a.C0011a h;

    public c(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, JSONArray jSONArray, Context context, m mVar, a.C0011a aVar) {
        super("TaskFetchMediatedAd " + str, mVar);
        this.a = str;
        this.c = maxAdFormat;
        this.d = map;
        this.e = map2;
        this.f = jSONArray;
        this.g = context;
        this.h = aVar;
    }

    private String a() {
        return b.a(this.b);
    }

    /* access modifiers changed from: private */
    public void a(int i, String str) {
        if (u.a()) {
            d("Unable to fetch " + this.a + " ad: server returned " + i);
        }
        if (i == -800) {
            this.b.T().a(f.q);
        }
        j.a((MaxAdListener) this.h, this.a, (MaxError) i == -1009 ? new MaxErrorImpl(-1009, str) : i == -1001 ? new MaxErrorImpl(-1001, str) : StringUtils.isValidString(str) ? new MaxErrorImpl(-1000, str) : new MaxErrorImpl(-1));
    }

    private void a(g gVar) {
        long b = gVar.b(f.d);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b > TimeUnit.MINUTES.toMillis((long) ((Integer) this.b.a(com.applovin.impl.sdk.d.b.dl)).intValue())) {
            gVar.b(f.d, currentTimeMillis);
            gVar.c(f.e);
            gVar.c(f.f);
        }
    }

    /* access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        try {
            h.d(jSONObject, this.b);
            h.c(jSONObject, this.b);
            h.e(jSONObject, this.b);
            h.f(jSONObject, this.b);
            b.a(jSONObject, this.b);
            b.b(jSONObject, this.b);
            com.applovin.impl.sdk.f.a(this.b);
            if (this.c != MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, (String) null)) && u.a()) {
                u.i(e(), "Ad format requested does not match ad unit id's format.");
            }
            this.b.S().a((com.applovin.impl.sdk.f.a) b(jSONObject));
        } catch (Throwable th) {
            if (u.a()) {
                a("Unable to process mediated ad response", th);
            }
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    private e b(JSONObject jSONObject) {
        return new e(this.a, this.c, this.d, jSONObject, this.g, this.b, this.h);
    }

    private String b() {
        return b.b(this.b);
    }

    private Map<String, String> c() {
        Map<String, String> map = CollectionUtils.map(2);
        map.put("AppLovin-Ad-Unit-Id", this.a);
        map.put("AppLovin-Ad-Format", this.c.getLabel());
        return map;
    }

    private void c(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray(this.b.C().c()));
            jSONObject2.put("installed", com.applovin.impl.mediation.d.c.a(this.b));
            jSONObject2.put("initialized", this.b.D().c());
            jSONObject2.put("initialized_classnames", new JSONArray(this.b.D().b()));
            jSONObject2.put("loaded_classnames", new JSONArray(this.b.C().a()));
            jSONObject2.put("failed_classnames", new JSONArray(this.b.C().b()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e2) {
            if (u.a()) {
                a("Failed to populate adapter classNames", e2);
            }
            throw new RuntimeException("Failed to populate classNames: " + e2);
        }
    }

    private void d(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.f;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    private void e(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("ad_unit_id", this.a);
        jSONObject2.put(FirebaseAnalytics.Param.AD_FORMAT, this.c.getLabel());
        Map<String, Object> map = CollectionUtils.map(this.e);
        com.applovin.impl.mediation.a.a a2 = this.b.F().a(this.a);
        if (a2 != null) {
            map.put("previous_winning_network", a2.N());
            map.put("previous_winning_network_name", a2.getNetworkName());
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(map));
        jSONObject.put("ad_info", jSONObject2);
    }

    private void f(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.b.E().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData != null && Utils.isDspDemoApp(this.b.L())) {
            JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
        }
    }

    private void g(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.b.p().getExtraParameters()));
    }

    private JSONObject h() throws JSONException {
        JSONObject jSONObject = new JSONObject(this.b.V().a((Map<String, String>) null, false, true));
        e(jSONObject);
        d(jSONObject);
        c(jSONObject);
        f(jSONObject);
        g(jSONObject);
        return jSONObject;
    }

    public void run() {
        if (u.a()) {
            a("Fetching next ad for ad unit id: " + this.a + " and format: " + this.c);
        }
        if (((Boolean) this.b.a(com.applovin.impl.sdk.d.b.dI)).booleanValue() && Utils.isVPNConnected() && u.a()) {
            a("User is connected to a VPN");
        }
        g T = this.b.T();
        T.a(f.p);
        if (T.b(f.d) == 0) {
            T.b(f.d, System.currentTimeMillis());
        }
        try {
            JSONObject h2 = h();
            Map map = CollectionUtils.map();
            map.put("rid", UUID.randomUUID().toString());
            if (!((Boolean) this.b.a(com.applovin.impl.sdk.d.b.es)).booleanValue()) {
                map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.b.z());
            }
            if (this.b.J().a()) {
                map.put("test_mode", "1");
            }
            String c2 = this.b.J().c();
            if (StringUtils.isValidString(c2)) {
                map.put("filter_ad_network", c2);
                if (!this.b.J().a()) {
                    map.put("fhkZsVqYC7", "1");
                }
                if (this.b.J().b()) {
                    map.put("force_ad_network", c2);
                }
            }
            a(T);
            AnonymousClass1 r1 = new com.applovin.impl.sdk.f.u<JSONObject>(com.applovin.impl.sdk.network.c.a(this.b).b("POST").b(c()).a(a()).c(b()).a((Map<String, String>) map).a(h2).d(((Boolean) this.b.a(com.applovin.impl.sdk.d.a.S)).booleanValue()).a(new JSONObject()).b(((Long) this.b.a(com.applovin.impl.sdk.d.a.f)).intValue()).a(((Integer) this.b.a(com.applovin.impl.sdk.d.b.cT)).intValue()).c(((Long) this.b.a(com.applovin.impl.sdk.d.a.e)).intValue()).a(), this.b) {
                public void a(int i, String str, JSONObject jSONObject) {
                    c.this.a(i, str);
                }

                public void a(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.d.a());
                        JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.d.b());
                        c.this.a(jSONObject);
                        return;
                    }
                    c.this.a(i, (String) null);
                }
            };
            r1.a(com.applovin.impl.sdk.d.a.c);
            r1.b(com.applovin.impl.sdk.d.a.d);
            this.b.S().a((com.applovin.impl.sdk.f.a) r1);
        } catch (Throwable th) {
            if (u.a()) {
                a("Unable to fetch ad " + this.a, th);
            }
            throw new RuntimeException("Unable to fetch ad: " + th);
        }
    }
}
