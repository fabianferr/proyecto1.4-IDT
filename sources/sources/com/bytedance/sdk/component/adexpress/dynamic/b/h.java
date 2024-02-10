package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DynamicLayoutUnit */
public class h {
    private String a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private e i;
    private List<h> j;
    private h k;
    private List<List<h>> l;
    private String m;
    private Map<Integer, String> n = new HashMap();

    public String a() {
        return this.m;
    }

    public void a(String str) {
        this.m = str;
    }

    public Map<Integer, String> b() {
        return this.n;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() != 0) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        this.n.put(Integer.valueOf(optJSONObject.optInt("id")), optJSONObject.optString("value"));
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public String c() {
        return this.a;
    }

    public void b(String str) {
        this.a = str;
    }

    public float d() {
        return this.d;
    }

    public void a(float f2) {
        this.d = f2;
    }

    public float e() {
        return this.e;
    }

    public void b(float f2) {
        this.e = f2;
    }

    public float f() {
        return this.b;
    }

    public void c(float f2) {
        this.b = f2;
    }

    public float g() {
        return this.c;
    }

    public void d(float f2) {
        this.c = f2;
    }

    public float h() {
        return this.f;
    }

    public void e(float f2) {
        this.f = f2;
    }

    public float i() {
        return this.g;
    }

    public void f(float f2) {
        this.g = f2;
    }

    public void g(float f2) {
        this.h = f2;
    }

    public e j() {
        return this.i;
    }

    public void a(e eVar) {
        this.i = eVar;
    }

    public List<h> k() {
        return this.j;
    }

    public void a(List<h> list) {
        this.j = list;
    }

    public void a(h hVar) {
        this.k = hVar;
    }

    public h l() {
        return this.k;
    }

    public int m() {
        f e2 = this.i.e();
        return e2.O() + e2.P();
    }

    public int n() {
        f e2 = this.i.e();
        return e2.M() + e2.N();
    }

    public float o() {
        f e2 = this.i.e();
        return ((float) m()) + e2.o() + e2.p() + (e2.l() * 2.0f);
    }

    public float p() {
        f e2 = this.i.e();
        return ((float) n()) + e2.q() + e2.n() + (e2.l() * 2.0f);
    }

    public void b(List<List<h>> list) {
        this.l = list;
    }

    public List<List<h>> q() {
        return this.l;
    }

    public boolean r() {
        List<h> list = this.j;
        return list == null || list.size() <= 0;
    }

    public void s() {
        List<List<h>> list = this.l;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (List next : this.l) {
                if (next != null && next.size() > 0) {
                    arrayList.add(next);
                }
            }
            this.l = arrayList;
        }
    }

    public boolean t() {
        return TextUtils.equals(this.i.e().A(), "flex");
    }

    public String u() {
        return this.i.e().w();
    }

    public void c(String str) {
        this.i.e().f(str);
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.a + "', x=" + this.b + ", y=" + this.c + ", width=" + this.f + ", height=" + this.g + ", remainWidth=" + this.h + ", rootBrick=" + this.i + ", childrenBrickUnits=" + this.j + AbstractJsonLexerKt.END_OBJ;
    }

    public boolean v() {
        return this.i.e().ai() < 0 || this.i.e().aj() < 0 || this.i.e().ag() < 0 || this.i.e().ah() < 0;
    }

    public String a(int i2) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.i.b());
        sb.append(CertificateUtil.DELIMITER);
        sb.append(this.a);
        if (this.i.e() != null) {
            sb.append(CertificateUtil.DELIMITER);
            sb.append(this.i.e().at());
        }
        sb.append(CertificateUtil.DELIMITER);
        sb.append(i2);
        return sb.toString();
    }
}
