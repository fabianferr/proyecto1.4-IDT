package com.bytedance.sdk.openadsdk.j.a;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.JProtect;
import com.bytedance.sdk.component.f.c.d;
import com.bytedance.sdk.component.f.c.e;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.j.a.b;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.com.bytedance.overseas.sdk.b.a;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* compiled from: LogStatsBase */
public class b<T extends b> implements a {
    private String a;
    private String b;
    private String c;
    private final String d = k.k1699434667889dc("5/7-4+?");
    private long e = (System.currentTimeMillis() / 1000);
    private int f = 0;
    private String g;
    private int h = 0;
    private String i;
    private String j;
    private String k;
    private String l;

    public static b<b> b() {
        return new b<>();
    }

    @JProtect
    private JSONObject o() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(d.d1699434667873dc("or"), 1);
            jSONObject.put(d.d1699434667873dc("mnffh"), Build.MODEL);
            jSONObject.put(d.d1699434667873dc("vdlgkw"), Build.MANUFACTURER);
            jSONObject.put(d.d1699434667873dc("p`ahebcXfhgn"), ac.e());
            jSONObject.put(d.d1699434667873dc("u`"), ac.c());
            jSONObject.put(d.d1699434667873dc("g`kg"), a.a().b());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private T p() {
        return this;
    }

    public T a(int i2) {
        this.f = i2;
        return p();
    }

    public T a(String str) {
        this.a = str;
        return p();
    }

    @JProtect
    public JSONObject a() {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(k.k1699434667889dc("ae]p`nYqm{ybcc"), g());
            jSONObject2.put(k.k1699434667889dc("aqr\\r`ttafd"), ac.g());
            jSONObject2.put(k.k1699434667889dc("thofwqgjx"), h());
            jSONObject2.put(k.k1699434667889dc("cnlm[qwm"), o.b(com.bytedance.sdk.openadsdk.core.o.a()));
            jSONObject2.put(k.k1699434667889dc("aqrj`"), TextUtils.isEmpty(h.b().d()) ? "" : h.b().d());
            jSONObject2.put(k.k1699434667889dc("ddtjg`Ynfoe"), o());
            if (!TextUtils.isEmpty(c())) {
                jSONObject2.put(j.j1699434667891dc("txrf"), c());
            }
            jSONObject2.put(k.k1699434667889dc("esplvZehll"), k());
            if (!TextUtils.isEmpty(l())) {
                jSONObject2.put(j.j1699434667891dc("esplvZkto"), l());
            }
            if (!TextUtils.isEmpty(e())) {
                jSONObject2.put(j.j1699434667891dc("rhv"), e());
            }
            if (!TextUtils.isEmpty(f())) {
                jSONObject2.put(j.j1699434667891dc("csgbplpbW`n"), f());
            }
            if (i() > 0) {
                jSONObject2.put(j.j1699434667891dc("aevzt`"), i());
            }
            if (!TextUtils.isEmpty(j())) {
                jSONObject2.put(j.j1699434667891dc("rds\\ma"), j());
            }
            if (!TextUtils.isEmpty(m())) {
                jSONObject2.put(k.k1699434667889dc("eyvqe"), m());
            }
            String d2 = d();
            if (TextUtils.isEmpty(d2)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(d2);
                } catch (Exception unused) {
                    jSONObject = null;
                }
            }
            if (jSONObject != null) {
                jSONObject.put(k.k1699434667889dc("or]uawunggUbby"), Build.VERSION.SDK_INT);
                jSONObject2.put(k.k1699434667889dc("ewgmpZc|{k"), jSONObject.toString());
            } else if (!TextUtils.isEmpty(d2)) {
                jSONObject2.put(k.k1699434667889dc("ewgmpZc|{k"), d2);
            }
            if (!TextUtils.isEmpty(n())) {
                jSONObject2.put(k.k1699434667889dc("dtpbplii"), n());
            }
        } catch (Throwable th) {
            l.e(j.j1699434667891dc("LnePpdrtJhyn"), th.getMessage());
        }
        return jSONObject2;
    }

    public T b(int i2) {
        this.h = i2;
        return p();
    }

    public T b(String str) {
        this.k = str;
        return p();
    }

    public T c(String str) {
        this.b = str;
        return p();
    }

    public String c() {
        return this.a;
    }

    public T d(String str) {
        this.c = str;
        return p();
    }

    public String d() {
        return this.k;
    }

    public T e(String str) {
        this.g = str;
        return p();
    }

    public String e() {
        return this.b;
    }

    public T f(String str) {
        this.i = str;
        return p();
    }

    public String f() {
        return this.c;
    }

    public T g(String str) {
        this.j = str;
        return p();
    }

    public String g() {
        return TextUtils.isEmpty(e.e1699434667871dc("5/7-4+?")) ? "" : e.e1699434667871dc("5/7-4+?");
    }

    public long h() {
        long j2 = this.e;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                break;
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        break;
                    case '^':
                        break;
                }
                c3 = AbstractJsonLexerKt.END_LIST;
                c2 = AbstractJsonLexerKt.END_LIST;
            }
            while (true) {
                switch (c3) {
                    case '[':
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = AbstractJsonLexerKt.BEGIN_LIST;
                }
            }
        }
        return j2;
    }

    public T h(String str) {
        this.l = str;
        return p();
    }

    public int i() {
        int i2 = this.f;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                break;
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        break;
                    case '^':
                        break;
                }
                c3 = AbstractJsonLexerKt.END_LIST;
                c2 = AbstractJsonLexerKt.END_LIST;
            }
            while (true) {
                switch (c3) {
                    case '[':
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = AbstractJsonLexerKt.BEGIN_LIST;
                }
            }
        }
        return i2;
    }

    public String j() {
        return this.g;
    }

    public int k() {
        int i2 = this.h;
        while (true) {
            char c2 = '^';
            char c3 = 'K';
            while (true) {
                switch (c2) {
                    case '\\':
                        switch (c3) {
                            case 21:
                                break;
                            case 22:
                            case 23:
                                break;
                        }
                    case ']':
                        break;
                    case '^':
                        break;
                }
                c3 = AbstractJsonLexerKt.END_LIST;
                c2 = AbstractJsonLexerKt.END_LIST;
            }
            while (true) {
                switch (c3) {
                    case '[':
                    case '\\':
                    case ']':
                        break;
                    default:
                        c3 = AbstractJsonLexerKt.BEGIN_LIST;
                }
            }
        }
        return i2;
    }

    public String l() {
        return this.i;
    }

    public String m() {
        return this.j;
    }

    public String n() {
        return this.l;
    }
}
