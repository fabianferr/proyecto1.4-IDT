package com.mbridge.msdk.foundation.same.net.g;

import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.mbridge.msdk.c.b;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.e.a.a.g;
import com.mbridge.msdk.e.o;
import com.mbridge.msdk.e.v;
import com.mbridge.msdk.e.w;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.same.report.i;
import com.mbridge.msdk.foundation.same.report.t;
import com.mbridge.msdk.foundation.same.report.u;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: RequestUrlUtil */
public final class d {
    public String A;
    public String B;
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public int K;
    public int L;
    public boolean M;
    public ArrayList<String> N;
    public ArrayList<String> O;
    private final String P;
    private boolean Q;
    private int R;
    private String S;
    private String T;
    private String U;
    private String V;
    private String W;
    private String X;
    private String Y;
    private String Z;
    public String a;
    private String aa;
    private String ab;
    private String ac;
    private String ad;
    private String ae;
    private String af;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public int q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    /* compiled from: RequestUrlUtil */
    private static class a {
        /* access modifiers changed from: private */
        public static final d a = new d();
    }

    private d() {
        this.P = "RequestUrlUtil";
        this.Q = true;
        this.R = 0;
        this.S = DomainNameUtils.getInstance().DEFAULT_HB_HOST;
        this.a = DomainNameUtils.getInstance().DEFAULT_HOST_ANALYTICS;
        this.b = DomainNameUtils.getInstance().DEFAULT_HOST_REVENUE_DEFAULT;
        this.c = DomainNameUtils.getInstance().DEFAULT_HOST_MONITOR_DEFAULT;
        this.d = DomainNameUtils.getInstance().DEFAULT_HOST_API;
        this.e = DomainNameUtils.getInstance().DEFAULT_HOST_SETTING;
        this.f = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_SETTING;
        this.g = DomainNameUtils.getInstance().DEFAULT_HOST_APPLETS;
        this.h = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_ANALYTICS;
        this.i = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_REVENUE;
        this.j = DomainNameUtils.getInstance().DEFAULT_HOST_PRIVACY;
        this.k = DomainNameUtils.getInstance().DEFAULT_HOST_TCP_MONITOR;
        this.l = 9377;
        this.m = 9988;
        this.n = 9377;
        this.o = 9377;
        this.p = false;
        this.q = 1;
        this.T = "/bid";
        this.U = "/load";
        this.V = "/openapi/ad/v3";
        this.W = "/openapi/ad/v4";
        this.X = "/openapi/ad/v5";
        this.Y = "/image";
        this.Z = "/mapping";
        this.aa = "/setting";
        this.ab = "/sdk/customid";
        this.ac = "/rewardsetting";
        this.ad = "/appwall/setting";
        this.ae = "/batchPaidEvent";
        this.af = "";
        this.r = this.S + this.T;
        this.s = this.S + this.U;
        this.t = this.d + this.V;
        this.u = this.d + this.W;
        this.v = this.d + this.X;
        this.w = this.d + this.Y;
        this.x = this.e + this.aa;
        this.y = this.e + this.ab;
        this.z = this.e + this.ac;
        this.A = this.e + this.Z;
        this.B = this.e + this.ad;
        this.C = this.f + this.aa;
        this.D = this.f + this.ab;
        this.E = this.f + this.ac;
        this.F = this.f + this.Z;
        this.G = this.f + this.ad;
        this.H = this.b + this.ae;
        this.I = this.b + this.af;
        this.J = DomainNameUtils.getInstance().DEFAULT_CDN_SPARE_SETTING_URL;
        this.K = 0;
        this.L = 0;
        this.M = false;
        this.N = DomainNameUtils.getInstance().SPARE_SETTING_HOST;
        this.O = DomainNameUtils.getInstance().SPARE_TCP_SETTING_HOST;
    }

    public static d a() {
        return a.a;
    }

    public final int b() {
        return this.R;
    }

    public final void a(int i2) {
        this.R = i2;
    }

    public final String a(String str, int i2) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.split("_");
                if (split.length > 1) {
                    return a(true, split[1]);
                }
                return a(true, "");
            }
        } catch (Exception e2) {
            aa.d("RequestUrlUtil", e2.getMessage());
        }
        return i2 % 2 == 0 ? this.v : this.t;
    }

    public final String a(boolean z2, String str) {
        if (!z2) {
            return this.r.replace(JsonUtils.EMPTY_JSON, "");
        }
        if (!this.s.contains(JsonUtils.EMPTY_JSON) || TextUtils.isEmpty(str)) {
            return this.s.replace(JsonUtils.EMPTY_JSON, "");
        }
        String str2 = this.s;
        return str2.replace(JsonUtils.EMPTY_JSON, str + "-");
    }

    public final void c() {
        HashMap<String, String> aE;
        b g2;
        o oVar;
        e b2 = f.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
        if (b2 != null) {
            com.mbridge.msdk.c.a h2 = b2.h();
            if (h2 != null) {
                this.i = h2.c();
                this.m = h2.d();
                this.b = h2.b();
                this.H = this.b + this.ae;
            }
            b g3 = b2.g();
            if (g3 != null) {
                this.k = g3.b();
                this.o = g3.c();
                this.c = g3.a();
                this.I = this.c + this.af;
                if (!(b2 == null || (g2 = b2.g()) == null || g2.e() == 1)) {
                    int a2 = ac.a().a("monitor", "type", ac.a().a("t_r_t", 0));
                    if (!(a2 == 0 || a2 == 1)) {
                        a2 = 0;
                    }
                    w.a a3 = new w.a().a((com.mbridge.msdk.e.d) new i()).a((v) new u());
                    if (a2 == 1) {
                        oVar = new o(new t((byte) 2), a.a.k, a.a.o);
                    } else {
                        oVar = new o(new g(), a.a.I, 0);
                    }
                    com.mbridge.msdk.e.t.a().a(com.mbridge.msdk.foundation.controller.b.d().g(), a3.a(a2, oVar).e(ac.a().a("t_m_e_t", 604800000)).a(ac.a().a("t_m_e_s", 50)).d(ac.a().a("t_m_r_c", 50)).b(ac.a().a("t_m_t", (int) DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).c(ac.a().a("t_m_r_t_s", 2)).a(), g2.d() * 1000, h.c());
                }
            }
            this.p = b2.aK() == 2;
            this.q = b2.aK();
            this.Q = !b2.i(2);
            if (b2.aE() != null && b2.aE().size() > 0 && (aE = b2.aE()) != null && aE.size() > 0) {
                if (aE.containsKey("v") && !TextUtils.isEmpty(aE.get("v")) && a(aE.get("v"))) {
                    this.d = aE.get("v");
                    this.t = this.d + this.V;
                    this.u = this.d + this.W;
                    this.v = this.d + this.X;
                    this.w = this.d + this.Y;
                }
                if (aE.containsKey(CampaignEx.JSON_KEY_HB) && !TextUtils.isEmpty(aE.get(CampaignEx.JSON_KEY_HB)) && a(aE.get(CampaignEx.JSON_KEY_HB))) {
                    this.S = aE.get(CampaignEx.JSON_KEY_HB);
                    this.r = this.S + this.T;
                    this.s = this.S + this.U;
                }
                if (aE.containsKey("lg") && !TextUtils.isEmpty(aE.get("lg"))) {
                    String str = aE.get("lg");
                    if (a(str)) {
                        this.a = str;
                    } else {
                        this.h = str;
                    }
                }
                if (aE.containsKey("lgt") && !TextUtils.isEmpty(aE.get("lgt"))) {
                    String str2 = aE.get("lgt");
                    if (a(str2)) {
                        String b3 = b(str2);
                        if (!TextUtils.isEmpty(b3)) {
                            this.h = b3;
                        }
                    } else {
                        this.h = str2;
                    }
                }
            }
            String E2 = b2.E();
            if (!TextUtils.isEmpty(E2)) {
                this.e = E2;
                e();
                this.N.add(0, E2);
            }
            String F2 = b2.F();
            if (!TextUtils.isEmpty(F2)) {
                this.f = F2;
                f();
                this.O.add(0, F2);
            }
        }
    }

    public final boolean d() {
        try {
            if (!this.p) {
                ArrayList<String> arrayList = this.N;
                if (arrayList != null && this.K <= arrayList.size() - 1) {
                    this.e = this.N.get(this.K);
                    e();
                    return true;
                }
            } else {
                ArrayList<String> arrayList2 = this.O;
                if (arrayList2 != null && this.L <= arrayList2.size() - 1) {
                    if (!a(this.O.get(this.L))) {
                        this.f = this.O.get(this.L);
                        f();
                    }
                    return true;
                }
            }
            if (this.M) {
                this.K = 0;
                this.L = 0;
            }
            return false;
        } catch (Throwable th) {
            aa.a("RequestUrlUtil", th.getMessage());
            return false;
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("(https|http)://[-A-Za-z0-9{}+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str.trim()).matches();
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return Uri.parse(str).getHost();
        } catch (Throwable th) {
            aa.d("RequestUrlUtil", th.getMessage());
            return "";
        }
    }

    public final void e() {
        this.x = this.e + this.aa;
        this.y = this.e + this.ab;
        this.z = this.e + this.ac;
        this.A = this.e + this.Z;
        this.B = this.e + this.ad;
    }

    public final void f() {
        this.C = this.f + this.aa;
        this.D = this.f + this.ab;
        this.E = this.f + this.ac;
        this.F = this.f + this.Z;
        this.G = this.f + this.ad;
    }
}
