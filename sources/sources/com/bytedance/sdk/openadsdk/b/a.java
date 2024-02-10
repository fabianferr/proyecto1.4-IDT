package com.bytedance.sdk.openadsdk.b;

import android.text.TextUtils;
import com.bytedance.sdk.component.e.a.d.a.b;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.b.a.d;
import com.bytedance.sdk.openadsdk.b.b.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.r;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AdEvent */
public class a implements b {
    private static final Set<String> j = new HashSet(Arrays.asList(new String[]{"insight_log"}));
    public final String a;
    protected final JSONObject b;
    private boolean c;
    private long d;
    private long e;
    private final String f = "adiff";
    private int g;
    private int h;
    private int i;
    private final AtomicBoolean k = new AtomicBoolean(false);
    private JSONObject l = new JSONObject();
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private com.bytedance.sdk.openadsdk.b.b.a s;
    private String t;
    private String u;
    private int v;
    private String w;

    a(C0060a aVar) {
        this.a = TextUtils.isEmpty(aVar.b) ? r.a() : aVar.b;
        this.s = aVar.o;
        this.u = aVar.f;
        this.m = aVar.c;
        this.n = aVar.d;
        this.o = TextUtils.isEmpty(aVar.e) ? "app_union" : aVar.e;
        this.t = aVar.k;
        this.p = aVar.h;
        this.r = aVar.i;
        this.q = aVar.g;
        this.v = aVar.l;
        this.w = aVar.m;
        this.l = aVar.j = aVar.j != null ? aVar.j : new JSONObject();
        JSONObject jSONObject = new JSONObject();
        this.b = jSONObject;
        if (!TextUtils.isEmpty(aVar.m)) {
            try {
                jSONObject.put("app_log_url", aVar.m);
            } catch (JSONException e2) {
                JSONException jSONException = e2;
                l.e("AdEvent", e2.getMessage());
            }
        }
        this.g = aVar.q;
        this.h = aVar.r;
        this.i = aVar.a;
        this.c = aVar.s;
        this.e = System.currentTimeMillis();
        f();
    }

    public a(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
    }

    private static void a(JSONObject jSONObject, String str) {
        try {
            Set<String> set = j;
            if (set.contains(str)) {
                return;
            }
            if (!set.contains(jSONObject.get("label"))) {
                jSONObject.putOpt("is_ad_event", "1");
            }
        } catch (Throwable th) {
            l.d("AdEvent", th);
        }
    }

    private boolean a(String str, String str2, String str3) {
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence) || TextUtils.equals(charSequence, "0") || TextUtils.isEmpty(str3)) {
            return false;
        }
        str2.hashCode();
        char c2 = 65535;
        switch (str2.hashCode()) {
            case 111399750:
                if (str2.equals("umeng")) {
                    c2 = 0;
                    break;
                }
                break;
            case 278118976:
                if (str2.equals("event_v1")) {
                    c2 = 1;
                    break;
                }
                break;
            case 278118978:
                if (str2.equals("event_v3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1844205361:
                if (str2.equals("app_union")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    private boolean b(String str) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 111399750:
                if (str.equals("umeng")) {
                    c2 = 0;
                    break;
                }
                break;
            case 278118976:
                if (str.equals("event_v1")) {
                    c2 = 1;
                    break;
                }
                break;
            case 278118978:
                if (str.equals("event_v3")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1844205361:
                if (str.equals("app_union")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    private void f() {
        JSONObject jSONObject = this.l;
        if (jSONObject != null) {
            String optString = jSONObject.optString("value");
            String optString2 = this.l.optString("category");
            String optString3 = this.l.optString("log_extra");
            CharSequence charSequence = optString;
            if (a(this.p, this.o, this.u)) {
                if (!TextUtils.isEmpty(charSequence) && TextUtils.equals(charSequence, "0")) {
                    return;
                }
                if (!TextUtils.isEmpty(optString2) && !b(optString2)) {
                    return;
                }
            } else if ((!TextUtils.isEmpty(charSequence) && !TextUtils.equals(charSequence, "0")) || (!TextUtils.isEmpty(this.p) && !TextUtils.equals(this.p, "0"))) {
                if ((!TextUtils.isEmpty(this.o) && b(this.o)) || (!TextUtils.isEmpty(optString2) && b(optString2))) {
                    if (TextUtils.isEmpty(this.u) && TextUtils.isEmpty(optString3)) {
                        return;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (!a(this.p, this.o, this.u)) {
            return;
        }
        this.d = (long) d.a.incrementAndGet();
    }

    private void g() throws JSONException {
        this.b.putOpt("app_log_url", this.w);
        this.b.putOpt(ViewHierarchyConstants.TAG_KEY, this.m);
        this.b.putOpt("label", this.n);
        this.b.putOpt("category", this.o);
        if (!TextUtils.isEmpty(this.p)) {
            try {
                this.b.putOpt("value", Long.valueOf(Long.parseLong(this.p)));
            } catch (NumberFormatException unused) {
                this.b.putOpt("value", 0L);
            }
        }
        if (!TextUtils.isEmpty(this.r)) {
            try {
                this.b.putOpt("ext_value", Long.valueOf(Long.parseLong(this.r)));
            } catch (Exception unused2) {
            }
        }
        if (!TextUtils.isEmpty(this.u)) {
            this.b.putOpt("log_extra", this.u);
        }
        if (!TextUtils.isEmpty(this.t)) {
            try {
                this.b.putOpt("ua_policy", Integer.valueOf(Integer.parseInt(this.t)));
            } catch (NumberFormatException unused3) {
            }
        }
        a(this.b, this.n);
        try {
            this.b.putOpt("nt", Integer.valueOf(this.v));
        } catch (Exception unused4) {
        }
        Iterator<String> keys = this.l.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            this.b.putOpt(next, this.l.opt(next));
        }
    }

    public long a() {
        return this.e;
    }

    public JSONObject a(String str) {
        return c();
    }

    public JSONObject a(boolean z) {
        JSONObject c2 = c();
        if (z) {
            try {
                JSONObject jSONObject = new JSONObject(c2.toString());
                JSONObject optJSONObject = jSONObject.optJSONObject(NativeProtocol.WEB_DIALOG_PARAMS);
                if (optJSONObject != null) {
                    optJSONObject.remove("app_log_url");
                }
                return jSONObject;
            } catch (JSONException e2) {
                JSONException jSONException = e2;
                l.e("AdEvent", e2.getMessage());
                return c2;
            }
        } else {
            JSONObject jSONObject2 = new JSONObject(c2.toString());
            jSONObject2.remove("app_log_url");
            return jSONObject2;
        }
    }

    public long b() {
        return this.d;
    }

    public JSONObject c() {
        if (this.k.get()) {
            return this.b;
        }
        try {
            g();
            com.bytedance.sdk.openadsdk.b.b.a aVar = this.s;
            if (aVar != null) {
                aVar.a(this.b);
            }
            if (this.b.has("ad_extra_data")) {
                Object opt = this.b.opt("ad_extra_data");
                if (opt != null) {
                    if (opt instanceof JSONObject) {
                        l.e("AdEvent", "ad_extra_data is JSONObject");
                        if (!((JSONObject) opt).has("adiff")) {
                            ((JSONObject) opt).put("adiff", this.a);
                        }
                        if (this.c) {
                            if (!((JSONObject) opt).has("interaction_method")) {
                                ((JSONObject) opt).put("interaction_method", this.g);
                            }
                            if (!((JSONObject) opt).has("real_interaction_method")) {
                                ((JSONObject) opt).put("real_interaction_method", this.h);
                            }
                            if (!((JSONObject) opt).has("image_mode")) {
                                ((JSONObject) opt).put("image_mode", this.i);
                            }
                        }
                        this.b.put("ad_extra_data", opt.toString());
                    } else if (opt instanceof String) {
                        JSONObject jSONObject = new JSONObject((String) opt);
                        if (!jSONObject.has("adiff")) {
                            jSONObject.put("adiff", this.a);
                        }
                        if (this.c) {
                            if (!jSONObject.has("interaction_method")) {
                                jSONObject.put("interaction_method", this.g);
                            }
                            if (!jSONObject.has("real_interaction_method")) {
                                jSONObject.put("real_interaction_method", this.h);
                            }
                            if (!jSONObject.has("image_mode")) {
                                jSONObject.put("image_mode", this.i);
                            }
                        }
                        this.b.put("ad_extra_data", jSONObject.toString());
                    }
                }
            } else {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("adiff", this.a);
                    if (this.c) {
                        jSONObject2.put("interaction_method", this.g);
                        jSONObject2.put("real_interaction_method", this.h);
                        jSONObject2.put("image_mode", this.i);
                    }
                    this.b.put("ad_extra_data", jSONObject2.toString());
                } catch (JSONException e2) {
                    JSONException jSONException = e2;
                    l.d("AdEvent", "json error", e2.getMessage());
                }
            }
        } catch (JSONException e3) {
            JSONException jSONException2 = e3;
            l.d("AdEvent", "json error", e3.getMessage());
        } catch (Throwable th) {
            l.c("AdEvent", th);
        }
        this.k.set(true);
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public boolean e() {
        Set<String> m2;
        if (this.b == null || (m2 = o.d().m()) == null) {
            return false;
        }
        String optString = this.b.optString("label");
        if (!TextUtils.isEmpty(optString)) {
            return m2.contains(optString);
        }
        if (TextUtils.isEmpty(this.n)) {
            return false;
        }
        return m2.contains(this.n);
    }

    /* renamed from: com.bytedance.sdk.openadsdk.b.a$a  reason: collision with other inner class name */
    /* compiled from: AdEvent */
    public static final class C0060a {
        public int a = -1;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public String d;
        /* access modifiers changed from: private */
        public String e;
        /* access modifiers changed from: private */
        public String f;
        /* access modifiers changed from: private */
        public String g;
        /* access modifiers changed from: private */
        public String h;
        /* access modifiers changed from: private */
        public String i;
        /* access modifiers changed from: private */
        public JSONObject j;
        /* access modifiers changed from: private */
        public String k;
        /* access modifiers changed from: private */
        public final int l;
        /* access modifiers changed from: private */
        public String m;
        private com.bytedance.sdk.openadsdk.b.b.b n;
        /* access modifiers changed from: private */
        public com.bytedance.sdk.openadsdk.b.b.a o;
        private final long p;
        /* access modifiers changed from: private */
        public int q = -1;
        /* access modifiers changed from: private */
        public int r = -1;
        /* access modifiers changed from: private */
        public boolean s;

        public C0060a(long j2, q qVar) {
            if (qVar != null) {
                this.s = t.b(qVar);
                this.q = qVar.p();
                this.r = qVar.o();
                this.a = qVar.ad();
            }
            this.p = j2;
            this.l = com.bytedance.sdk.component.utils.o.c(o.a());
        }

        public C0060a a(String str) {
            this.m = str;
            return this;
        }

        public C0060a b(String str) {
            this.c = str;
            return this;
        }

        public C0060a c(String str) {
            this.d = str;
            return this;
        }

        public C0060a d(String str) {
            this.e = str;
            return this;
        }

        public C0060a e(String str) {
            this.f = str;
            return this;
        }

        public C0060a f(String str) {
            this.h = str;
            return this;
        }

        public C0060a g(String str) {
            this.i = str;
            return this;
        }

        public C0060a a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return this;
            }
            this.j = jSONObject;
            return this;
        }

        public C0060a h(String str) {
            this.g = str;
            return this;
        }

        public void a(com.bytedance.sdk.openadsdk.b.b.a aVar) {
            this.o = aVar;
            final a aVar2 = new a(this);
            try {
                com.bytedance.sdk.openadsdk.b.b.b bVar = this.n;
                if (bVar != null) {
                    bVar.a(aVar2.b, this.p);
                } else {
                    new c().a(aVar2.b, this.p);
                }
            } catch (Throwable th) {
                l.c("AdEvent", th);
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                aa.c(new h("dispatchEvent") {
                    public void run() {
                        d.a(aVar2);
                    }
                });
            } else {
                d.a(aVar2);
            }
        }
    }
}
