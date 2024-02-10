package com.applovin.impl.sdk.f;

import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.d.b;
import com.applovin.impl.sdk.e.f;
import com.applovin.impl.sdk.e.g;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public abstract class h extends a {
    protected final d a;

    public h(d dVar, String str, m mVar) {
        super(str, mVar);
        this.a = dVar;
    }

    private void a(g gVar) {
        long b = gVar.b(f.d);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b > TimeUnit.MINUTES.toMillis((long) ((Integer) this.b.a(b.dl)).intValue())) {
            gVar.b(f.d, currentTimeMillis);
            gVar.c(f.e);
            gVar.c(f.f);
        }
    }

    private Map<String, String> i() {
        Map<String, String> map = CollectionUtils.map(3);
        map.put("AppLovin-Zone-Id", this.a.a());
        if (this.a.c() != null) {
            map.put("AppLovin-Ad-Size", this.a.c().getLabel());
        }
        if (this.a.d() != null) {
            map.put("AppLovin-Ad-Type", this.a.d().getLabel());
        }
        return map;
    }

    /* access modifiers changed from: protected */
    public abstract a a(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public Map<String, String> a() {
        Map<String, String> map = CollectionUtils.map(4);
        map.put(AppLovinUtils.ServerParameterKeys.ZONE_ID, this.a.a());
        if (this.a.c() != null) {
            map.put("size", this.a.c().getLabel());
        }
        if (this.a.d() != null) {
            map.put("require", this.a.d().getLabel());
        }
        return map;
    }

    /* access modifiers changed from: protected */
    public void a(int i) {
        if (u.a()) {
            d("Unable to fetch " + this.a + " ad: server returned " + i);
        }
        if (i == -800) {
            this.b.T().a(f.j);
        }
    }

    /* access modifiers changed from: protected */
    public abstract String b();

    /* access modifiers changed from: protected */
    public void b(JSONObject jSONObject) {
        com.applovin.impl.sdk.utils.h.d(jSONObject, this.b);
        com.applovin.impl.sdk.utils.h.c(jSONObject, this.b);
        com.applovin.impl.sdk.utils.h.e(jSONObject, this.b);
        d.a(jSONObject);
        this.b.S().a(a(jSONObject));
    }

    /* access modifiers changed from: protected */
    public abstract String c();

    /* access modifiers changed from: protected */
    public com.applovin.impl.sdk.ad.b h() {
        return this.a.e() ? com.applovin.impl.sdk.ad.b.APPLOVIN_PRIMARY_ZONE : com.applovin.impl.sdk.ad.b.APPLOVIN_CUSTOM_ZONE;
    }

    public void run() {
        Map<String, String> map;
        if (u.a()) {
            a("Fetching next ad of zone: " + this.a);
        }
        if (((Boolean) this.b.a(b.dI)).booleanValue() && Utils.isVPNConnected() && u.a()) {
            a("User is connected to a VPN");
        }
        g T = this.b.T();
        T.a(f.a);
        if (T.b(f.d) == 0) {
            T.b(f.d, System.currentTimeMillis());
        }
        try {
            JSONObject andResetCustomPostBody = this.b.u().getAndResetCustomPostBody();
            String str = "POST";
            if (((Boolean) this.b.a(b.df)).booleanValue()) {
                JSONObject jSONObject = new JSONObject(this.b.V().a(a(), false, true));
                map = CollectionUtils.map();
                map.put("rid", UUID.randomUUID().toString());
                if (!((Boolean) this.b.a(b.es)).booleanValue()) {
                    map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.b.z());
                }
                if (andResetCustomPostBody != null) {
                    JsonUtils.putAll(jSONObject, andResetCustomPostBody);
                }
                andResetCustomPostBody = jSONObject;
            } else {
                Map<String, String> stringifyObjectMap = Utils.stringifyObjectMap(this.b.V().a(a(), false, false));
                if (andResetCustomPostBody == null) {
                    andResetCustomPostBody = null;
                    str = "GET";
                }
                map = stringifyObjectMap;
            }
            if (Utils.isDspDemoApp(f())) {
                map.putAll(this.b.u().getAndResetCustomQueryParams());
            }
            a(T);
            c.a<T> b = c.a(this.b).a(b()).c(c()).a(map).b(str).b(i()).a(new JSONObject()).a(((Integer) this.b.a(b.cT)).intValue()).a(((Boolean) this.b.a(b.cU)).booleanValue()).b(((Boolean) this.b.a(b.cV)).booleanValue()).b(((Integer) this.b.a(b.cS)).intValue());
            if (andResetCustomPostBody != null) {
                b.a(andResetCustomPostBody);
                b.d(((Boolean) this.b.a(b.eA)).booleanValue());
            }
            AnonymousClass1 r2 = new u<JSONObject>(b.a(), this.b) {
                public void a(int i, String str, JSONObject jSONObject) {
                    h.this.a(i);
                }

                public void a(JSONObject jSONObject, int i) {
                    if (i == 200) {
                        JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.d.a());
                        JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.d.b());
                        h.this.b(jSONObject);
                        return;
                    }
                    h.this.a(i);
                }
            };
            r2.a(b.aT);
            r2.b(b.aU);
            this.b.S().a((a) r2);
        } catch (Throwable th) {
            if (u.a()) {
                a("Unable to fetch ad " + this.a, th);
            }
            a(0);
        }
    }
}
