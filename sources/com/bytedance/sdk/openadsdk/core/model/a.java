package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.b;
import com.bytedance.sdk.openadsdk.core.model.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdInfo */
public class a {
    private String a;
    private int b;
    private String c;
    private C0067a d;
    private boolean e;
    private List<q> f = new ArrayList();
    private List<g> g = new ArrayList();
    private String h;
    private long i;
    private boolean j;
    private volatile boolean k = false;

    public String a() {
        q e2 = e();
        return e2 != null ? e2.bc() : "";
    }

    public void a(String str) {
        this.a = str;
    }

    public int b() {
        return this.b;
    }

    public void a(int i2) {
        this.b = i2;
    }

    public void b(String str) {
        this.c = str;
    }

    public List<q> c() {
        return this.f;
    }

    public void a(q qVar) {
        this.f.add(qVar);
    }

    public void a(List<q> list) {
        this.f = list;
    }

    public void a(g gVar) {
        this.g.add(gVar);
    }

    public void c(String str) {
        this.h = str;
    }

    public void a(long j2) {
        this.i = j2;
    }

    public static Map<String, q> a(a aVar) {
        if (aVar == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (q next : aVar.c()) {
            if (!TextUtils.isEmpty(next.af())) {
                hashMap.put(next.af(), next);
            }
        }
        if (hashMap.size() != 0) {
            return hashMap;
        }
        return null;
    }

    public boolean d() {
        List<q> list = this.f;
        return list != null && list.size() > 0;
    }

    public q e() {
        if (this.f.size() > 0) {
            return this.f.get(0);
        }
        return null;
    }

    public boolean f() {
        if (h() == null || c() == null || c().size() <= 1) {
            this.e = false;
            a((C0067a) null);
        } else {
            this.e = true;
        }
        return this.e;
    }

    public boolean g() {
        return this.j;
    }

    public void a(boolean z) {
        this.j = z;
    }

    public C0067a h() {
        return this.d;
    }

    public void a(C0067a aVar) {
        this.d = aVar;
        if (aVar != null) {
            com.bytedance.sdk.component.adexpress.a.b.a.a(q.a.a(aVar, ""));
        }
    }

    public boolean i() {
        return this.k;
    }

    public void j() {
        this.k = false;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            a(C0067a.a(jSONObject.optJSONObject("tpl_info")));
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.model.a$a  reason: collision with other inner class name */
    /* compiled from: AdInfo */
    public static class C0067a extends q.a {
        private int a;

        public void a(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }

        public JSONObject b() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", e());
                jSONObject.put("md5", f());
                jSONObject.put("url", g());
                jSONObject.put("data", h());
                jSONObject.put("diff_data", i());
                jSONObject.put("version", d());
                jSONObject.put("dynamic_creative", j());
                jSONObject.put("count_down_time", a());
                return jSONObject;
            } catch (Throwable unused) {
                return null;
            }
        }

        public static C0067a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            C0067a aVar = new C0067a();
            aVar.b(jSONObject.optString("id"));
            aVar.c(jSONObject.optString("md5"));
            aVar.d(jSONObject.optString("url"));
            aVar.e(jSONObject.optString("data"));
            aVar.f(jSONObject.optString("diff_data"));
            aVar.a(jSONObject.optString("version"));
            aVar.g(jSONObject.optString("dynamic_creative"));
            aVar.a(jSONObject.optInt("count_down_time"));
            if (a(aVar)) {
                return aVar;
            }
            return null;
        }

        private static boolean a(C0067a aVar) {
            if (aVar != null && !TextUtils.isEmpty(aVar.e())) {
                return !TextUtils.isEmpty(aVar.g());
            }
            return false;
        }
    }

    public JSONObject k() {
        try {
            JSONObject jSONObject = new JSONObject();
            C0067a h2 = h();
            if (h2 != null) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject b2 = h2.b();
                if (b2 != null) {
                    jSONObject2.put("tpl_info", b2);
                    jSONObject.put("choose_ui_data", jSONObject2);
                }
            }
            List<q> list = this.f;
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f.size(); i2++) {
                    jSONArray.put(this.f.get(i2).ao());
                }
                jSONObject.put("creatives", jSONArray);
            }
            jSONObject.put("is_choose_ad_original", this.j);
            return jSONObject;
        } catch (Throwable th) {
            l.c("AdInfo", "toJsonObj: ", th);
            return null;
        }
    }

    public static a b(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            a aVar = new a();
            JSONObject optJSONObject = jSONObject.optJSONObject("choose_ui_data");
            if (optJSONObject != null) {
                aVar.a(optJSONObject);
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("creatives");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    arrayList.add(b.a(optJSONArray.optJSONObject(i2)));
                }
                aVar.a((List<q>) arrayList);
            }
            aVar.a(jSONObject.optBoolean("is_choose_ad_original", false));
            return aVar;
        } catch (Throwable th) {
            l.c("AdInfo", "fromJson: ", th);
            return null;
        }
    }
}
