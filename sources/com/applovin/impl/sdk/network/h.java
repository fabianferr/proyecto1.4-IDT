package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

public class h {
    private String a;
    private String b;
    private String c;
    private String d;
    private Map<String, String> e;
    private Map<String, String> f;
    private Map<String, Object> g;
    private boolean h;
    private boolean i;
    private boolean j;
    private String k;
    private int l;

    public static class a {
        /* access modifiers changed from: private */
        public String a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public Map<String, String> e;
        /* access modifiers changed from: private */
        public Map<String, String> f;
        /* access modifiers changed from: private */
        public Map<String, Object> g;
        /* access modifiers changed from: private */
        public boolean h;
        /* access modifiers changed from: private */
        public boolean i;
        /* access modifiers changed from: private */
        public boolean j;

        public a a(String str) {
            this.a = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.e = map;
            return this;
        }

        public a a(boolean z) {
            this.h = z;
            return this;
        }

        public h a() {
            return new h(this);
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a b(Map<String, String> map) {
            this.f = map;
            return this;
        }

        public a b(boolean z) {
            this.i = z;
            return this;
        }

        public a c(String str) {
            this.c = str;
            return this;
        }

        public a c(Map<String, Object> map) {
            this.g = map;
            return this;
        }

        public a c(boolean z) {
            this.j = z;
            return this;
        }

        public a d(String str) {
            this.d = str;
            return this;
        }
    }

    private h(a aVar) {
        this.a = UUID.randomUUID().toString();
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
        this.i = aVar.i;
        this.j = aVar.j;
        this.k = aVar.a;
        this.l = 0;
    }

    h(JSONObject jSONObject, m mVar) throws Exception {
        String string = JsonUtils.getString(jSONObject, "uniqueId", UUID.randomUUID().toString());
        String string2 = JsonUtils.getString(jSONObject, "communicatorRequestId", "");
        JsonUtils.getString(jSONObject, "httpMethod", "");
        String string3 = jSONObject.getString("targetUrl");
        String string4 = JsonUtils.getString(jSONObject, "backupUrl", "");
        int i2 = jSONObject.getInt("attemptNumber");
        Map<String, String> synchronizedMap = JsonUtils.valueExists(jSONObject, "parameters") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("parameters"))) : CollectionUtils.map();
        Map<String, String> synchronizedMap2 = JsonUtils.valueExists(jSONObject, "httpHeaders") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("httpHeaders"))) : CollectionUtils.map();
        Map<String, Object> synchronizedMap3 = JsonUtils.valueExists(jSONObject, "requestBody") ? Collections.synchronizedMap(JsonUtils.toStringObjectMap(jSONObject.getJSONObject("requestBody"))) : CollectionUtils.map();
        this.a = string;
        this.k = string2;
        this.c = string3;
        this.d = string4;
        this.e = synchronizedMap;
        this.f = synchronizedMap2;
        this.g = synchronizedMap3;
        this.h = jSONObject.optBoolean("isEncodingEnabled", false);
        this.i = jSONObject.optBoolean("gzipBodyEncoding", false);
        this.j = jSONObject.optBoolean("shouldFireInWebView", false);
        this.l = i2;
    }

    public static a o() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public String b() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> d() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.a.equals(((h) obj).a);
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> f() {
        return this.g;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.h;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.i;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* access modifiers changed from: package-private */
    public boolean i() {
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public String j() {
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public int k() {
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.l++;
    }

    /* access modifiers changed from: package-private */
    public void m() {
        Map<String, String> map = CollectionUtils.map(this.e);
        map.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.e = map;
    }

    /* access modifiers changed from: package-private */
    public JSONObject n() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uniqueId", this.a);
        jSONObject.put("communicatorRequestId", this.k);
        jSONObject.put("httpMethod", this.b);
        jSONObject.put("targetUrl", this.c);
        jSONObject.put("backupUrl", this.d);
        jSONObject.put("isEncodingEnabled", this.h);
        jSONObject.put("gzipBodyEncoding", this.i);
        jSONObject.put("attemptNumber", this.l);
        if (this.e != null) {
            jSONObject.put("parameters", new JSONObject(this.e));
        }
        if (this.f != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.f));
        }
        if (this.g != null) {
            jSONObject.put("requestBody", new JSONObject(this.g));
        }
        return jSONObject;
    }

    public String toString() {
        return "PostbackRequest{uniqueId='" + this.a + "', communicatorRequestId='" + this.k + "', httpMethod='" + this.b + "', targetUrl='" + this.c + "', backupUrl='" + this.d + "', attemptNumber=" + this.l + ", isEncodingEnabled=" + this.h + ", isGzipBodyEncoding=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }
}
