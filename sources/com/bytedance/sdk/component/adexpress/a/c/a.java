package com.bytedance.sdk.component.adexpress.a.c;

import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.cast.MediaTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: TempPkgModel */
public class a {
    private String a;
    private String b;
    private String c;
    private List<C0043a> d;
    private b e;

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public String c() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public void a(b bVar) {
        this.e = bVar;
    }

    public b d() {
        return this.e;
    }

    public List<C0043a> e() {
        if (this.d == null) {
            this.d = new ArrayList();
        }
        return this.d;
    }

    public void a(List<C0043a> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.d = list;
    }

    public boolean f() {
        return !TextUtils.isEmpty(c()) && !TextUtils.isEmpty(b()) && !TextUtils.isEmpty(a());
    }

    public String g() {
        if (!f()) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("name", a());
            jSONObject.putOpt("version", b());
            jSONObject.putOpt(MediaTrack.ROLE_MAIN, c());
            JSONArray jSONArray = new JSONArray();
            if (e() != null) {
                for (C0043a next : e()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("url", next.a());
                    jSONObject2.putOpt("md5", next.b());
                    jSONObject2.putOpt("level", Integer.valueOf(next.c()));
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.putOpt("resources", jSONArray);
            b d2 = d();
            if (d2 != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", d2.a);
                jSONObject3.put("md5", d2.b);
                JSONObject jSONObject4 = new JSONObject();
                List<Pair<String, String>> b2 = d2.b();
                if (b2 != null) {
                    for (Pair next2 : b2) {
                        jSONObject4.put((String) next2.first, next2.second);
                    }
                }
                jSONObject3.put("map", jSONObject4);
                jSONObject.putOpt("resources_archive", jSONObject3);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.a.c.a$a  reason: collision with other inner class name */
    /* compiled from: TempPkgModel */
    public static class C0043a {
        private String a;
        private String b;
        private int c;

        public boolean equals(Object obj) {
            if (!(obj instanceof C0043a)) {
                return super.equals(obj);
            }
            String str = this.a;
            return str != null && str.equals(((C0043a) obj).a());
        }

        public String a() {
            return this.a;
        }

        public void a(String str) {
            this.a = str;
        }

        public String b() {
            return this.b;
        }

        public void b(String str) {
            this.b = str;
        }

        public int c() {
            return this.c;
        }

        public void a(int i) {
            this.c = i;
        }
    }

    /* compiled from: TempPkgModel */
    public static class b {
        /* access modifiers changed from: private */
        public String a;
        /* access modifiers changed from: private */
        public String b;
        private List<Pair<String, String>> c;

        public String a() {
            return this.a;
        }

        public void a(String str) {
            this.a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void a(List<Pair<String, String>> list) {
            this.c = list;
        }

        public List<Pair<String, String>> b() {
            return this.c;
        }
    }

    public static a d(String str) {
        if (str == null) {
            return null;
        }
        try {
            return a(new JSONObject(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static a a(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        aVar.a(jSONObject.optString("name"));
        aVar.b(jSONObject.optString("version"));
        aVar.c(jSONObject.optString(MediaTrack.ROLE_MAIN));
        JSONArray optJSONArray = jSONObject.optJSONArray("resources");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                C0043a aVar2 = new C0043a();
                aVar2.a(optJSONObject2.optString("url"));
                aVar2.b(optJSONObject2.optString("md5"));
                aVar2.a(optJSONObject2.optInt("level"));
                arrayList.add(aVar2);
            }
        }
        aVar.a((List<C0043a>) arrayList);
        if (jSONObject.has("resources_archive") && (optJSONObject = jSONObject.optJSONObject("resources_archive")) != null) {
            b bVar = new b();
            bVar.a(optJSONObject.optString("url"));
            bVar.b(optJSONObject.optString("md5"));
            JSONObject optJSONObject3 = optJSONObject.optJSONObject("map");
            if (optJSONObject3 != null) {
                Iterator<String> keys = optJSONObject3.keys();
                ArrayList arrayList2 = new ArrayList();
                while (keys.hasNext()) {
                    String next = keys.next();
                    arrayList2.add(new Pair(next, optJSONObject3.optString(next)));
                }
                bVar.a((List<Pair<String, String>>) arrayList2);
            }
            aVar.a(bVar);
        }
        if (!aVar.f()) {
            return null;
        }
        return aVar;
    }
}
