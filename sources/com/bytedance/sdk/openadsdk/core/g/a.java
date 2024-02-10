package com.bytedance.sdk.openadsdk.core.g;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VastAdConfig */
public class a {
    d a = new d(this);
    b b;
    c c;
    private String d;
    private String e;
    private String f;
    private String g;
    private double h;
    private int i;
    private int j;
    private String k;
    private final Set<j> l = new HashSet();
    private String m = "VAST_ACTION_BUTTON";
    private boolean n = false;
    private String o;

    public d a() {
        return this.a;
    }

    public b b() {
        return this.b;
    }

    public c c() {
        return this.c;
    }

    public String d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }

    public String f() {
        return this.f;
    }

    public String g() {
        return this.g;
    }

    public void a(b bVar) {
        if (bVar != null) {
            bVar.a(this.g);
        }
        this.b = bVar;
    }

    public void a(c cVar) {
        if (cVar != null) {
            cVar.a(this.g);
        }
        this.c = cVar;
    }

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.e = str;
    }

    public void c(String str) {
        this.f = str;
    }

    public void d(String str) {
        this.g = str;
    }

    public double h() {
        return this.h;
    }

    public void a(double d2) {
        this.h = d2;
    }

    public String i() {
        c cVar;
        String str = this.f;
        if (!TextUtils.isEmpty(this.o)) {
            String str2 = this.o;
            this.o = null;
            return str2;
        }
        String str3 = this.m;
        str3.hashCode();
        if (str3.equals("VAST_ICON")) {
            b bVar = this.b;
            if (bVar != null && !TextUtils.isEmpty(bVar.h)) {
                str = this.b.h;
            }
        } else if (str3.equals("VAST_END_CARD") && (cVar = this.c) != null && !TextUtils.isEmpty(cVar.h)) {
            str = this.c.h;
        }
        this.m = "VAST_ACTION_BUTTON";
        return str;
    }

    public void e(String str) {
        this.m = str;
    }

    public JSONObject j() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("videoTrackers", this.a.a());
        b bVar = this.b;
        if (bVar != null) {
            jSONObject.put("vastIcon", bVar.a());
        }
        c cVar = this.c;
        if (cVar != null) {
            jSONObject.put("endCard", cVar.a());
        }
        jSONObject.put("title", this.d);
        jSONObject.put("description", this.e);
        jSONObject.put("clickThroughUrl", this.f);
        jSONObject.put("videoUrl", this.g);
        jSONObject.put("videDuration", this.h);
        jSONObject.put(ViewHierarchyConstants.TAG_KEY, this.k);
        jSONObject.put("videoWidth", this.i);
        jSONObject.put("videoHeight", this.j);
        jSONObject.put("viewabilityVendor", p());
        return jSONObject;
    }

    private JSONArray p() {
        JSONArray jSONArray = new JSONArray();
        for (j next : this.l) {
            if (next != null) {
                jSONArray.put(next.d());
            }
        }
        return jSONArray;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.a.a(jSONObject.optJSONObject("videoTrackers"));
        aVar.b = b.a(jSONObject.optJSONObject("vastIcon"));
        aVar.c = c.b(jSONObject.optJSONObject("endCard"));
        aVar.d = jSONObject.optString("title");
        aVar.e = jSONObject.optString("description");
        aVar.f = jSONObject.optString("clickThroughUrl");
        aVar.g = jSONObject.optString("videoUrl");
        aVar.h = jSONObject.optDouble("videDuration");
        aVar.k = jSONObject.optString(ViewHierarchyConstants.TAG_KEY);
        aVar.i = jSONObject.optInt("videoWidth");
        aVar.i = jSONObject.optInt("videoHeight");
        aVar.l.addAll(j.a(jSONObject.optJSONArray("viewabilityVendor")));
        return aVar;
    }

    public void a(q qVar) {
        this.a.a(qVar);
        b bVar = this.b;
        if (bVar != null) {
            bVar.a(qVar);
        }
        c cVar = this.c;
        if (cVar != null) {
            cVar.a(qVar);
        }
    }

    public String k() {
        return this.k;
    }

    public void f(String str) {
        this.k = str;
        this.a.a(str);
    }

    public void a(int i2) {
        this.i = i2;
    }

    public void b(int i2) {
        this.j = i2;
    }

    public int l() {
        return this.i;
    }

    public int m() {
        return this.j;
    }

    public void a(Set<j> set) {
        if (set != null && set.size() > 0) {
            this.l.addAll(set);
        }
    }

    public Set<j> n() {
        return this.l;
    }

    public void g(String str) {
        this.o = str;
    }

    public void o() {
        this.n = true;
    }
}
