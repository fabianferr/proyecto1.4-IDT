package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.a.c.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.video.a.b;
import com.bytedance.sdk.openadsdk.utils.ab;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MaterialMeta */
public abstract class q {
    private long a = 0;

    public static int a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static long a(String str) {
        return e(c(str));
    }

    public static b a(String str, q qVar) {
        qVar.F(0);
        int aS = qVar.aS();
        return new b(str, qVar.aM(), qVar.aN(), qVar.aK(), qVar.aL(), aS != 3 ? aS != 7 ? aS != 8 ? 3 : 2 : 1 : 4);
    }

    public static boolean a(q qVar) {
        return (qVar == null || qVar.K() == null || qVar.K().d() == 0) ? false : true;
    }

    public static boolean a(q qVar, boolean z, boolean z2, boolean z3) {
        if (a(qVar) || z3 || qVar == null || qVar.K() == null || TextUtils.isEmpty(qVar.K().l())) {
            return false;
        }
        if (qVar.K() == null || qVar.K().a() != 1) {
            l.b("MaterialMeta", "can show end card follow js WebViewClient");
            return z;
        }
        l.b("MaterialMeta", "can show end card follow js");
        return z2;
    }

    public static double b(String str) {
        return f(c(str));
    }

    public static q b() {
        return new u();
    }

    public static boolean b(q qVar) {
        return (qVar == null || qVar.K() == null || qVar.K().a() != 1) ? false : true;
    }

    public static JSONObject c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return new JSONObject(str);
            } catch (JSONException e) {
                JSONException jSONException = e;
                l.e("MaterialMeta", e.getMessage());
            }
        }
        return null;
    }

    public static boolean c(q qVar) {
        if (qVar == null) {
            return false;
        }
        int ad = qVar.ad();
        return qVar.at() || ad == 5 || ad == 15 || ad == 50;
    }

    public static int d(String str) {
        return a(c(str));
    }

    private static long e(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong("uid", 0);
        }
        return 0;
    }

    private static double f(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public abstract int A();

    public abstract void A(int i);

    public abstract int B();

    public abstract void B(int i);

    public abstract h C();

    public abstract void C(int i);

    public abstract AdSlot D();

    public abstract void D(int i);

    public abstract int E();

    public abstract void E(int i);

    public abstract String F();

    public abstract void F(int i);

    public abstract void G(int i);

    public abstract boolean G();

    public abstract int H();

    public abstract void H(int i);

    public abstract a I();

    public abstract void I(int i);

    public abstract int J();

    public abstract void J(int i);

    public abstract com.bykv.vk.openvk.component.video.api.c.b K();

    public abstract String L();

    public abstract int M();

    public abstract n N();

    public abstract n O();

    public abstract String P();

    public abstract List<n> Q();

    public abstract String R();

    public abstract List<String> S();

    public abstract List<String> T();

    public abstract List<String> U();

    public abstract String V();

    public abstract String W();

    public abstract String X();

    public abstract String Y();

    public abstract String Z();

    public long a() {
        return this.a;
    }

    public abstract void a(double d);

    public abstract void a(float f);

    public abstract void a(int i);

    public abstract void a(int i, int i2);

    public void a(long j) {
        this.a = j;
    }

    public abstract void a(com.bykv.vk.openvk.component.video.api.c.b bVar);

    public abstract void a(AdSlot adSlot);

    public abstract void a(FilterWord filterWord);

    public abstract void a(com.bytedance.sdk.openadsdk.core.g.a aVar);

    public abstract void a(c cVar);

    public abstract void a(d dVar);

    public abstract void a(h hVar);

    public abstract void a(j jVar);

    public abstract void a(k kVar);

    public abstract void a(l lVar);

    public abstract void a(n nVar);

    public abstract void a(p pVar);

    public abstract void a(a aVar);

    public abstract void a(t tVar);

    public abstract void a(Map<String, Object> map);

    public abstract void a(boolean z);

    public abstract void a(String[] strArr);

    public abstract void aA();

    public abstract boolean aB();

    public abstract int aC();

    public abstract int aD();

    public abstract int aE();

    public abstract String aF();

    public abstract String[] aG();

    public abstract l aH();

    public abstract int aI();

    public abstract com.bytedance.sdk.component.widget.b.a aJ();

    public abstract int aK();

    public abstract int aL();

    public abstract com.bykv.vk.openvk.component.video.api.c.b aM();

    public abstract com.bykv.vk.openvk.component.video.api.c.b aN();

    public abstract String aO();

    public abstract int aP();

    public abstract boolean aQ();

    public abstract JSONObject aR();

    public abstract int aS();

    public abstract int aT();

    public abstract long aU();

    public abstract boolean aV();

    public abstract boolean aW();

    public abstract boolean aX();

    public abstract boolean aY();

    public abstract int aZ();

    public abstract c aa();

    public abstract j ab();

    public abstract String ac();

    public abstract int ad();

    public abstract List<FilterWord> ae();

    public abstract String af();

    public abstract long ag();

    public abstract boolean ah();

    public abstract Map<String, Object> ai();

    public abstract JSONObject aj();

    public abstract int ak();

    public abstract float al();

    public abstract boolean am();

    public abstract boolean an();

    public abstract JSONObject ao();

    public abstract int ap();

    public abstract int aq();

    public abstract int ar();

    public abstract int as();

    public abstract boolean at();

    public abstract com.bytedance.sdk.openadsdk.core.g.a au();

    public abstract boolean av();

    public abstract String aw();

    public abstract int ax();

    public abstract JSONObject ay();

    public abstract boolean az();

    public abstract void b(double d);

    public abstract void b(int i);

    public abstract void b(long j);

    public abstract void b(com.bykv.vk.openvk.component.video.api.c.b bVar);

    public abstract void b(n nVar);

    public abstract void b(JSONObject jSONObject);

    public abstract void b(boolean z);

    public abstract double ba();

    public abstract String bb();

    public abstract String bc();

    public abstract boolean bd();

    public abstract int be();

    public abstract boolean bf();

    public abstract boolean bg();

    public abstract boolean bh();

    public abstract boolean bi();

    public abstract boolean bj();

    public abstract ab bk();

    public abstract void bl();

    public abstract long bm();

    public abstract boolean bn();

    public abstract boolean bo();

    public abstract String bp();

    public abstract String bq();

    public abstract boolean br();

    public abstract String bs();

    public abstract void bt();

    public abstract boolean bu();

    public abstract void c(int i);

    public abstract void c(long j);

    public abstract void c(com.bykv.vk.openvk.component.video.api.c.b bVar);

    public abstract void c(n nVar);

    public abstract void c(JSONObject jSONObject);

    public abstract void c(boolean z);

    public abstract boolean c();

    public abstract void d(int i);

    public abstract void d(JSONObject jSONObject);

    public abstract void d(boolean z);

    public abstract boolean d();

    public abstract void e(int i);

    public abstract void e(String str);

    public abstract void e(boolean z);

    public abstract boolean e();

    public abstract String f();

    public abstract void f(int i);

    public abstract void f(String str);

    public abstract void f(boolean z);

    public abstract String g();

    public abstract void g(int i);

    public abstract void g(String str);

    public abstract void h(int i);

    public abstract void h(String str);

    public boolean h() {
        return !TextUtils.isEmpty(f()) && !TextUtils.isEmpty(g());
    }

    public abstract p i();

    public abstract void i(int i);

    public abstract void i(String str);

    public abstract d j();

    public abstract void j(int i);

    public abstract void j(String str);

    public abstract int k();

    public abstract void k(int i);

    public abstract void k(String str);

    public abstract int l();

    public abstract void l(int i);

    public abstract void l(String str);

    public abstract long m();

    public abstract void m(int i);

    public abstract void m(String str);

    public abstract t n();

    public abstract void n(int i);

    public abstract void n(String str);

    public abstract int o();

    public abstract void o(int i);

    public abstract void o(String str);

    public abstract int p();

    public abstract void p(int i);

    public abstract void p(String str);

    public abstract int q();

    public abstract void q(int i);

    public abstract void q(String str);

    public abstract int r();

    public abstract void r(int i);

    public abstract void r(String str);

    public abstract String s();

    public abstract void s(int i);

    public abstract void s(String str);

    public abstract int t();

    public abstract void t(int i);

    public abstract void t(String str);

    public abstract int u();

    public abstract void u(int i);

    public abstract void u(String str);

    public abstract void v(int i);

    public abstract void v(String str);

    public abstract boolean v();

    public abstract int w();

    public abstract void w(int i);

    public abstract void w(String str);

    public abstract int x();

    public abstract String x(String str);

    public abstract void x(int i);

    public abstract int y();

    public abstract void y(int i);

    public abstract void y(String str);

    public abstract String z();

    public abstract void z(int i);

    public abstract void z(String str);

    /* compiled from: MaterialMeta */
    public static class a {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private List<Integer> h;
        private String i;

        public static c a(a aVar, String str) {
            return c.a().a(aVar.e()).b(aVar.f()).c(aVar.g()).d(aVar.h()).e(aVar.d()).f(str);
        }

        public List<Integer> c() {
            return this.h;
        }

        public void a(List<Integer> list) {
            this.h = list;
        }

        public String d() {
            return this.f;
        }

        public void a(String str) {
            this.f = str;
        }

        public String e() {
            return this.a;
        }

        public void b(String str) {
            this.a = str;
        }

        public String f() {
            return this.b;
        }

        public void c(String str) {
            this.b = str;
        }

        public String g() {
            return this.c;
        }

        public void d(String str) {
            this.c = str;
        }

        public String h() {
            return this.d;
        }

        public void e(String str) {
            this.d = str;
        }

        public String i() {
            return this.e;
        }

        public void f(String str) {
            this.e = str;
        }

        public String j() {
            return this.g;
        }

        public void g(String str) {
            this.g = str;
        }

        public String k() {
            return this.i;
        }

        public void h(String str) {
            this.i = str;
        }
    }
}
