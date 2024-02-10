package com.applovin.impl.mediation.a;

import android.os.Bundle;
import com.applovin.impl.sdk.d.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

public class f {
    private final JSONObject a;
    protected final m b;
    private final JSONObject c;
    private final Map<String, Object> d;
    private final Object e = new Object();
    private final Object f = new Object();
    private String g;
    private String h;

    public f(Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        } else if (jSONObject != null) {
            this.b = mVar;
            this.a = jSONObject2;
            this.c = jSONObject;
            this.d = map;
        } else {
            throw new IllegalArgumentException("No ad object specified");
        }
    }

    private int a() {
        return b("mute_state", a("mute_state", ((Integer) this.b.a(a.J)).intValue()));
    }

    /* access modifiers changed from: protected */
    public JSONObject K() {
        JSONObject jSONObject;
        synchronized (this.f) {
            jSONObject = this.a;
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public JSONObject L() {
        JSONObject jSONObject;
        synchronized (this.e) {
            jSONObject = this.c;
        }
        return jSONObject;
    }

    public String M() {
        return b("class", (String) null);
    }

    public String N() {
        return b("name", (String) null);
    }

    public String O() {
        return N().split("_")[0];
    }

    public boolean P() {
        return b("is_testing", (Boolean) false).booleanValue();
    }

    public Boolean Q() {
        String str = this.b.p().getExtraParameters().get(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT);
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : c(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT) ? b(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, (Boolean) false) : a(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, (Boolean) null);
    }

    public Boolean R() {
        String str = this.b.p().getExtraParameters().get(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER);
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : c(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER) ? b(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, (Boolean) false) : a(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, (Boolean) null);
    }

    public Boolean S() {
        String str = this.b.p().getExtraParameters().get(AppLovinSdkExtraParameterKey.DO_NOT_SELL);
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : c(AppLovinSdkExtraParameterKey.DO_NOT_SELL) ? b(AppLovinSdkExtraParameterKey.DO_NOT_SELL, (Boolean) false) : a(AppLovinSdkExtraParameterKey.DO_NOT_SELL, (Boolean) null);
    }

    public String T() {
        return c("consent_string") ? b("consent_string", (String) null) : a("consent_string", (String) null);
    }

    public boolean U() {
        return b("run_on_ui_thread", (Boolean) true).booleanValue();
    }

    public Map<String, Object> V() {
        return this.d;
    }

    public Bundle W() {
        Bundle bundle = d("server_parameters") instanceof JSONObject ? JsonUtils.toBundle(a("server_parameters", (JSONObject) null)) : new Bundle();
        int a2 = a();
        if (a2 != -1) {
            bundle.putBoolean("is_muted", a2 == 2 ? this.b.p().isMuted() : a2 == 0);
        }
        if (!bundle.containsKey("amount")) {
            bundle.putLong("amount", a("amount", 0));
        }
        if (!bundle.containsKey("currency")) {
            bundle.putString("currency", a("currency", ""));
        }
        return bundle;
    }

    public Bundle X() {
        return BundleUtils.getBundle("custom_parameters", new Bundle(), W());
    }

    public long Y() {
        return b("adapter_timeout_ms", ((Long) this.b.a(a.k)).longValue());
    }

    public long Z() {
        return b("init_completion_delay_ms", -1);
    }

    /* access modifiers changed from: protected */
    public float a(String str, float f2) {
        float f3;
        synchronized (this.e) {
            f3 = JsonUtils.getFloat(this.c, str, f2);
        }
        return f3;
    }

    /* access modifiers changed from: protected */
    public int a(String str, int i) {
        int i2;
        synchronized (this.f) {
            i2 = JsonUtils.getInt(this.a, str, i);
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public long a(String str, long j) {
        long j2;
        synchronized (this.f) {
            j2 = JsonUtils.getLong(this.a, str, j);
        }
        return j2;
    }

    /* access modifiers changed from: protected */
    public Boolean a(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.f) {
            bool2 = JsonUtils.getBoolean(this.a, str, bool);
        }
        return bool2;
    }

    /* access modifiers changed from: protected */
    public String a(String str, String str2) {
        String string;
        synchronized (this.f) {
            string = JsonUtils.getString(this.a, str, str2);
        }
        return string;
    }

    /* access modifiers changed from: protected */
    public JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.f) {
            jSONArray2 = JsonUtils.getJSONArray(this.a, str, jSONArray);
        }
        return jSONArray2;
    }

    /* access modifiers changed from: protected */
    public JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (this.e) {
            jSONObject2 = JsonUtils.getJSONObject(this.c, str, jSONObject);
        }
        return jSONObject2;
    }

    /* access modifiers changed from: protected */
    public void a(String str, Object obj) {
        synchronized (this.e) {
            JsonUtils.putObject(this.c, str, obj);
        }
    }

    public long aa() {
        return b("auto_init_delay_ms", 0);
    }

    public String ab() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public int b(String str, int i) {
        int i2;
        synchronized (this.e) {
            i2 = JsonUtils.getInt(this.c, str, i);
        }
        return i2;
    }

    /* access modifiers changed from: protected */
    public long b(String str, long j) {
        long j2;
        synchronized (this.e) {
            j2 = JsonUtils.getLong(this.c, str, j);
        }
        return j2;
    }

    /* access modifiers changed from: protected */
    public Boolean b(String str, Boolean bool) {
        Boolean bool2;
        synchronized (this.e) {
            bool2 = JsonUtils.getBoolean(this.c, str, bool);
        }
        return bool2;
    }

    /* access modifiers changed from: protected */
    public String b(String str, String str2) {
        String string;
        synchronized (this.e) {
            string = JsonUtils.getString(this.c, str, str2);
        }
        return string;
    }

    /* access modifiers changed from: protected */
    public JSONArray b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        synchronized (this.e) {
            jSONArray2 = JsonUtils.getJSONArray(this.c, str, jSONArray);
        }
        return jSONArray2;
    }

    /* access modifiers changed from: protected */
    public void c(String str, int i) {
        synchronized (this.e) {
            JsonUtils.putInt(this.c, str, i);
        }
    }

    /* access modifiers changed from: protected */
    public void c(String str, long j) {
        synchronized (this.e) {
            JsonUtils.putLong(this.c, str, j);
        }
    }

    /* access modifiers changed from: protected */
    public void c(String str, String str2) {
        synchronized (this.e) {
            JsonUtils.putString(this.c, str, str2);
        }
    }

    /* access modifiers changed from: protected */
    public boolean c(String str) {
        boolean has;
        synchronized (this.e) {
            has = this.c.has(str);
        }
        return has;
    }

    /* access modifiers changed from: protected */
    public Object d(String str) {
        Object opt;
        synchronized (this.e) {
            opt = this.c.opt(str);
        }
        return opt;
    }

    public void e(String str) {
        this.g = str;
    }

    public void f(String str) {
        this.h = str;
    }

    public List<String> g(String str) {
        if (str != null) {
            List optList = JsonUtils.optList(a(str, new JSONArray()), Collections.EMPTY_LIST);
            List optList2 = JsonUtils.optList(b(str, new JSONArray()), Collections.EMPTY_LIST);
            ArrayList arrayList = new ArrayList(optList.size() + optList2.size());
            arrayList.addAll(optList);
            arrayList.addAll(optList2);
            return arrayList;
        }
        throw new IllegalArgumentException("No key specified");
    }

    public String getAdUnitId() {
        return a("ad_unit_id", "");
    }

    public String getPlacement() {
        return this.g;
    }

    public String h(String str) {
        String b2 = b(str, "");
        return StringUtils.isValidString(b2) ? b2 : a(str, "");
    }

    public String toString() {
        return "MediationAdapterSpec{adapterClass='" + M() + "', adapterName='" + N() + "', isTesting=" + P() + AbstractJsonLexerKt.END_OBJ;
    }
}
