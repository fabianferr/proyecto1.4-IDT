package com.bytedance.sdk.openadsdk.core.model;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import com.bykv.vk.openvk.component.video.api.c.b;
import com.bytedance.sdk.component.adexpress.a.c.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.g.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SingleMaterialMeta */
public class u extends q {
    private String A;
    private String B = "";
    private int C = 0;
    private int D = 2;
    private int E = 0;
    private long F;
    private int G;
    private int H;
    private b I;
    private b J;
    private b K;
    private boolean L;
    private boolean M;
    private boolean N;
    private int O;
    private boolean P;
    private int Q;
    private Map<String, Object> R;
    private q.a S;
    private String T;
    private JSONObject U;
    private int V = 0;
    private int W = 1;
    private h X = new h();
    private int Y = AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES;
    private int Z = 0;
    public boolean a = false;
    private a aA;
    private String aB;
    private JSONObject aC;
    private int aD;
    private boolean aE;
    private int aF = -1;
    private long aG = -1;
    private String aH;
    private int aI;
    private int aJ;
    private int aK = 0;
    private String[] aL;
    private l aM;
    private String aN;
    private String aO;
    private d aP;
    private boolean aQ;
    private String aR;
    private int aS = 0;
    private int aT;
    private String aU;
    private String aV;
    private boolean aW;
    private AdSlot aa;
    private int ab;
    private int ac = 1;
    private String ad;
    private int ae = 0;
    private int af = 0;
    private int ag = 0;
    private JSONObject ah;
    private int ai = 1;
    private int aj;
    private String ak;
    private String al;
    private k am;
    private int an = 1;
    private float ao = 100.0f;
    private String ap;
    private int aq;
    private int ar;
    private int as;
    private int at;
    private int au = 2;
    private int av = 1;
    private int aw = 0;
    private int ax;
    private p ay;
    private t az;
    public long b;
    private final List<n> c = new ArrayList();
    private final List<String> d = new ArrayList();
    private final List<FilterWord> e = new ArrayList();
    private final ab f = ab.b();
    private int g;
    private int h;
    private int i;
    private n j;
    private n k;
    private String l;
    private String m;
    private List<String> n = new ArrayList();
    private List<String> o = new ArrayList();
    private String p;
    private String q;
    private String r;
    private String s;
    private int t;
    private String u = "0";
    private c v;
    private j w;
    private int x;
    private String y;
    private String z;

    private static double e(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        q qVar = (q) obj;
        if (!this.u.equals(qVar.Y()) || !this.A.equals(qVar.ac())) {
            return false;
        }
        return true;
    }

    public boolean c() {
        return this.L;
    }

    public void a(boolean z2) {
        this.L = z2;
    }

    public boolean d() {
        return this.M;
    }

    public void b(boolean z2) {
        this.M = z2;
    }

    public boolean e() {
        return this.N;
    }

    public void c(boolean z2) {
        this.N = z2;
    }

    public String f() {
        return this.aN;
    }

    public void e(String str) {
        this.aN = str;
    }

    public String g() {
        return this.aO;
    }

    public void f(String str) {
        this.aO = str;
    }

    public boolean h() {
        return !TextUtils.isEmpty(f()) && !TextUtils.isEmpty(g());
    }

    public p i() {
        return this.ay;
    }

    public void a(p pVar) {
        this.ay = pVar;
    }

    public boolean bo() {
        return this.aQ;
    }

    public void f(boolean z2) {
        this.aQ = z2;
    }

    public void y(String str) {
        this.aR = str;
    }

    public String bp() {
        return this.aR;
    }

    public void J(int i2) {
        this.aT = i2;
    }

    public void z(String str) {
        this.aU = str;
    }

    public String bq() {
        return this.aU;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = I().c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean br() {
        /*
            r2 = this;
            com.bytedance.sdk.openadsdk.core.model.q$a r0 = r2.I()
            if (r0 == 0) goto L_0x001e
            com.bytedance.sdk.openadsdk.core.model.q$a r0 = r2.I()
            java.util.List r0 = r0.c()
            if (r0 == 0) goto L_0x001e
            r1 = 57
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x001e
            r0 = 1
            return r0
        L_0x001e:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.model.u.br():boolean");
    }

    public String bs() {
        return this.aV;
    }

    public boolean bu() {
        return this.aW;
    }

    public void bt() {
        b bVar = this.I;
        if (bVar != null && !TextUtils.isEmpty(bVar.l())) {
            try {
                if (this.I.l().contains("style_id")) {
                    this.aW = true;
                    this.aV = Uri.parse(this.I.l()).getQueryParameters("style_id").get(0);
                    return;
                }
                this.aW = false;
            } catch (Throwable th) {
                l.d(th.getMessage());
            }
        }
    }

    public d j() {
        return this.aP;
    }

    public void a(d dVar) {
        this.aP = dVar;
    }

    public int k() {
        d dVar = this.aP;
        if (dVar == null) {
            return 2;
        }
        return dVar.a();
    }

    public int l() {
        if (at()) {
            return 2;
        }
        if (av()) {
            return 4;
        }
        d dVar = this.aP;
        if (dVar == null) {
            return 1;
        }
        return dVar.b();
    }

    public long m() {
        d dVar = this.aP;
        if (dVar == null) {
            return 0;
        }
        return dVar.c();
    }

    public t n() {
        return this.az;
    }

    public void a(t tVar) {
        this.az = tVar;
    }

    public int o() {
        return this.h;
    }

    public void a(int i2) {
        a(i2, -1);
    }

    public int p() {
        return this.i;
    }

    public void b(int i2) {
        this.h = i2;
    }

    public void a(int i2, int i3) {
        this.i = i2;
        this.h = i2;
        if (this.aa == null) {
            this.h = 0;
            return;
        }
        if (i3 <= 0) {
            i3 = aS();
        }
        if (this.aa.getNativeAdType() == 3 || this.aa.getDurationSlotType() == 3 || i3 == 3) {
            this.h = 14;
        } else if (this.aa.getNativeAdType() == 7 || this.aa.getNativeAdType() == 8 || this.aa.getDurationSlotType() == 7 || this.aa.getDurationSlotType() == 8 || i3 == 7 || i3 == 8) {
            if (t.k(this)) {
                this.h = 12;
            } else if (t.b(this)) {
                this.h = 9;
            } else {
                if (this.i == 5 && !o.c((q) this)) {
                    this.h = 7;
                }
                if (this.i == 6 && !o.b((q) this)) {
                    this.h = 7;
                }
                if (this.i == 8 && bB() != 100) {
                    this.h = 7;
                }
                if (this.i == 19 && TextUtils.isEmpty(this.l)) {
                    this.h = 7;
                }
                if (this.i == 20 && TextUtils.isEmpty(this.l)) {
                    this.h = 7;
                }
                if (i2 < 5) {
                    this.h = 7;
                }
            }
        } else if (t.b(this)) {
            this.h = 4;
        } else {
            if (this.i == 4 && !t.b(this)) {
                this.h = 0;
            }
            if (i2 >= 5) {
                this.h = 0;
            } else if (this.i == 2 && M() != 3) {
                this.h = 0;
            } else if (i2 == 0 || (i2 == 1 && M() != 3)) {
                this.h = 0;
            }
        }
    }

    public int q() {
        return this.av;
    }

    public void a(double d2) {
        if (d2 == 2.0d || d2 == 1.0d) {
            this.av = (int) d2;
        } else {
            this.av = 1;
        }
    }

    public int r() {
        return this.au;
    }

    public void b(double d2) {
        if (d2 == 2.0d || d2 == 1.0d) {
            this.au = (int) d2;
        } else {
            this.au = 2;
        }
    }

    public String s() {
        return this.B;
    }

    public void g(String str) {
        this.B = str;
    }

    public int t() {
        return this.C;
    }

    public void c(int i2) {
        this.C = i2;
    }

    public int u() {
        int i2 = this.h;
        if (i2 == 5 || i2 == 6) {
            return 1;
        }
        if (bd()) {
            return 2;
        }
        return this.D;
    }

    public void d(int i2) {
        this.D = i2;
    }

    public int bv() {
        return this.ae;
    }

    public void e(int i2) {
        this.ae = i2;
    }

    public String bw() {
        return this.ap;
    }

    public void h(String str) {
        this.ap = str;
    }

    public boolean v() {
        return this.ae == 1;
    }

    public int w() {
        return this.ag;
    }

    public void f(int i2) {
        this.ag = i2;
    }

    public int x() {
        return this.V;
    }

    public void g(int i2) {
        this.V = i2;
    }

    public int y() {
        return this.W;
    }

    public void h(int i2) {
        this.W = i2;
    }

    public String z() {
        return this.ak;
    }

    public void i(String str) {
        this.ak = str;
    }

    public int A() {
        return this.af;
    }

    public void i(int i2) {
        this.af = i2;
    }

    public int bx() {
        return this.ac;
    }

    public void j(int i2) {
        this.ac = i2;
    }

    public int B() {
        if (at()) {
            return 5;
        }
        if (al() != 100.0f || u() == 2) {
            return 0;
        }
        return this.Z;
    }

    public void k(int i2) {
        this.Z = i2;
    }

    public h C() {
        return this.X;
    }

    public void a(h hVar) {
        this.X = hVar;
    }

    public AdSlot D() {
        return this.aa;
    }

    public void a(AdSlot adSlot) {
        this.aa = adSlot;
    }

    public int by() {
        return this.ab;
    }

    public void l(int i2) {
        this.ab = i2;
    }

    public int E() {
        return this.Y;
    }

    public void m(int i2) {
        this.Y = i2;
    }

    public int bz() {
        return this.ai;
    }

    public void n(int i2) {
        this.ai = i2;
    }

    public int bA() {
        return this.aj;
    }

    public void o(int i2) {
        this.aj = i2;
    }

    public int bB() {
        return this.H;
    }

    public void p(int i2) {
        this.H = i2;
    }

    public String F() {
        return this.T;
    }

    public void j(String str) {
        this.T = str;
    }

    public boolean G() {
        return bB() == 100 || this.h == 20;
    }

    public int H() {
        return this.Q;
    }

    public void q(int i2) {
        this.Q = i2;
    }

    public q.a I() {
        return this.S;
    }

    public void a(q.a aVar) {
        this.S = aVar;
        c bC = bC();
        if (bC != null) {
            com.bytedance.sdk.component.adexpress.a.b.a.a(bC);
        }
    }

    public c bC() {
        q.a I2 = I();
        if (I2 == null) {
            return null;
        }
        return q.a.a(I2, String.valueOf(aZ()));
    }

    public int J() {
        k kVar = this.am;
        if (kVar == null) {
            return 0;
        }
        return kVar.a();
    }

    public b K() {
        return this.I;
    }

    public void a(b bVar) {
        this.I = bVar;
    }

    public void a(k kVar) {
        this.am = kVar;
    }

    public String L() {
        return this.y;
    }

    public void k(String str) {
        this.y = str;
    }

    public int M() {
        return this.g;
    }

    public void r(int i2) {
        this.g = i2;
    }

    public n N() {
        return this.j;
    }

    public void a(n nVar) {
        this.j = nVar;
    }

    public n O() {
        return this.k;
    }

    public void b(n nVar) {
        this.k = nVar;
    }

    public String P() {
        return this.l;
    }

    public void l(String str) {
        this.l = str;
    }

    public List<n> Q() {
        return this.c;
    }

    public void c(n nVar) {
        this.c.add(nVar);
    }

    public String R() {
        return this.m;
    }

    public void m(String str) {
        this.m = str;
    }

    public List<String> S() {
        return this.n;
    }

    public List<String> T() {
        return this.o;
    }

    public List<String> U() {
        return this.d;
    }

    public String V() {
        return this.p;
    }

    public void n(String str) {
        this.p = str;
    }

    public String W() {
        return this.q;
    }

    public void o(String str) {
        this.q = str;
    }

    public String X() {
        if (!TextUtils.isEmpty(this.r)) {
            return this.r;
        }
        Context a2 = o.a();
        int M2 = M();
        if (M2 == 2 || M2 == 3) {
            if (a2 != null) {
                return s.a(a2, "tt_video_mobile_go_detail");
            }
            return this.r;
        } else if (M2 != 4) {
            return this.r;
        } else {
            if (a2 != null) {
                return s.a(a2, "tt_video_download_apk");
            }
            return this.r;
        }
    }

    public void p(String str) {
        this.r = str;
    }

    public String Y() {
        return this.u;
    }

    public void q(String str) {
        this.u = str;
    }

    public String Z() {
        return this.z;
    }

    public void r(String str) {
        this.z = str;
    }

    public c aa() {
        return this.v;
    }

    public void a(c cVar) {
        this.v = cVar;
    }

    public j ab() {
        return this.w;
    }

    public void a(j jVar) {
        this.w = jVar;
    }

    public String ac() {
        return this.A;
    }

    public void s(String str) {
        this.A = str;
    }

    public int ad() {
        return this.x;
    }

    public void s(int i2) {
        this.x = i2;
    }

    public List<FilterWord> ae() {
        return this.e;
    }

    public void a(FilterWord filterWord) {
        this.e.add(filterWord);
    }

    public String af() {
        return this.al;
    }

    public void t(String str) {
        this.al = str;
    }

    public long ag() {
        return this.F;
    }

    public void b(long j2) {
        this.F = j2;
    }

    public int bD() {
        return this.G;
    }

    public void t(int i2) {
        this.G = i2;
    }

    public boolean ah() {
        return this.P;
    }

    public void d(boolean z2) {
        this.P = z2;
    }

    public Map<String, Object> ai() {
        return this.R;
    }

    public void a(Map<String, Object> map) {
        this.R = map;
    }

    public JSONObject aj() {
        return this.ah;
    }

    public void b(JSONObject jSONObject) {
        this.ah = jSONObject;
    }

    public String bE() {
        return this.ad;
    }

    public void u(String str) {
        this.ad = str;
    }

    public int ak() {
        if (this.an != 2) {
            this.an = 1;
        }
        return this.an;
    }

    public void u(int i2) {
        this.an = i2;
    }

    public float al() {
        if (this.ao <= 0.0f) {
            this.ao = 100.0f;
        }
        return (this.ao * 1000.0f) / 1000.0f;
    }

    public void a(float f2) {
        this.ao = f2;
    }

    public boolean am() {
        if (this.c.isEmpty()) {
            return false;
        }
        if (this.x == 4 && this.c.size() < 3) {
            return false;
        }
        for (n e2 : this.c) {
            if (!e2.e()) {
                return false;
            }
        }
        return true;
    }

    public boolean an() {
        if (!at() && bF() == 1) {
            return true;
        }
        return false;
    }

    public int bF() {
        return this.E;
    }

    public void v(int i2) {
        this.E = i2;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.g = 4;
            this.u = jSONObject.optString("id");
            this.y = jSONObject.optString("source");
            c cVar = new c();
            this.v = cVar;
            cVar.c(jSONObject.optString("pkg_name"));
            this.v.b(jSONObject.optString("name"));
            this.v.a(jSONObject.optString(DownloadModel.DOWNLOAD_URL));
        }
    }

    public JSONObject ao() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interaction_type", M());
            jSONObject.put("interaction_method", p());
            jSONObject.put("target_url", P());
            jSONObject.put("app_log_url", Z());
            jSONObject.put("gecko_id", af());
            jSONObject.put(ShareConstants.MEDIA_EXTENSION, ay());
            jSONObject.put("ad_id", Y());
            jSONObject.put("source", L());
            jSONObject.put("screenshot", ah());
            jSONObject.put("dislike_control", bF());
            jSONObject.put("play_bar_show_time", E());
            jSONObject.put("play_bar_style", B());
            jSONObject.put("if_block_lp", bv());
            jSONObject.put("cache_sort", bz());
            jSONObject.put("if_sp_cache", bA());
            jSONObject.put("render_control", u());
            jSONObject.put("mrc_report", this.aD);
            jSONObject.put("isMrcReportFinish", this.aE);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("cta", r());
            jSONObject2.put("other", q());
            jSONObject.put("set_click_type", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(CampaignEx.JSON_KEY_REWARD_NAME, s());
            jSONObject3.put(CampaignEx.JSON_KEY_REWARD_AMOUNT, t());
            jSONObject.put("reward_data", jSONObject3);
            if (!TextUtils.isEmpty(f()) && !TextUtils.isEmpty(g())) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("adchoices_icon", f());
                jSONObject4.put("adchoices_url", g());
                jSONObject.put("dsp_adchoices", jSONObject4);
            }
            n N2 = N();
            if (N2 != null) {
                if (!TextUtils.isEmpty(N2.a())) {
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("url", N2.a());
                    jSONObject5.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, N2.c());
                    jSONObject5.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, N2.b());
                    jSONObject.put(RewardPlus.ICON, jSONObject5);
                }
            }
            n O2 = O();
            if (O2 != null && !TextUtils.isEmpty(O2.a())) {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put("url", O2.a());
                jSONObject6.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, O2.c());
                jSONObject6.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, O2.b());
                jSONObject.put("cover_image", jSONObject6);
            }
            JSONObject aj2 = aj();
            if (aj2 != null) {
                jSONObject.put("session_params", aj2);
            }
            h C2 = C();
            if (C2 != null) {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put("click_upper_content_area", C2.a);
                jSONObject7.put("click_upper_non_content_area", C2.b);
                jSONObject7.put("click_lower_content_area", C2.c);
                jSONObject7.put("click_lower_non_content_area", C2.d);
                jSONObject7.put("click_button_area", C2.e);
                jSONObject7.put("click_video_area", C2.f);
                jSONObject.put("click_area", jSONObject7);
            }
            AdSlot D2 = D();
            if (D2 != null) {
                jSONObject.put("adslot", D2.toJsonObj());
            }
            List<n> Q2 = Q();
            if (Q2 != null) {
                JSONArray jSONArray = new JSONArray();
                for (n next : Q2) {
                    JSONObject jSONObject8 = new JSONObject();
                    jSONObject8.put("url", next.a());
                    jSONObject8.put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, next.c());
                    jSONObject8.put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, next.b());
                    jSONObject8.put("image_preview", next.f());
                    jSONObject8.put("image_key", next.g());
                    jSONArray.put(jSONObject8);
                }
                jSONObject.put("image", jSONArray);
            }
            List<String> S2 = S();
            if (S2 != null) {
                JSONArray jSONArray2 = new JSONArray();
                for (String put : S2) {
                    jSONArray2.put(put);
                }
                jSONObject.put("show_url", jSONArray2);
            }
            List<String> T2 = T();
            if (T2 != null) {
                JSONArray jSONArray3 = new JSONArray();
                for (String put2 : T2) {
                    jSONArray3.put(put2);
                }
                jSONObject.put(CampaignEx.JSON_KEY_CLICK_URL, jSONArray3);
            }
            List<String> U2 = U();
            if (U2 != null) {
                JSONArray jSONArray4 = new JSONArray();
                for (String put3 : U2) {
                    jSONArray4.put(put3);
                }
                jSONObject.put("play_start", jSONArray4);
            }
            jSONObject.put("phone_num", R());
            jSONObject.put("title", V());
            jSONObject.put("description", W());
            jSONObject.put("ext", ac());
            jSONObject.put("image_mode", ad());
            jSONObject.put("cover_click_area", bB());
            jSONObject.put("intercept_flag", by());
            jSONObject.put("button_text", X());
            jSONObject.put("ad_logo", bx());
            jSONObject.put("video_adaptation", A());
            jSONObject.put("feed_video_opentype", w());
            jSONObject.put(AdUnitActivity.EXTRA_ORIENTATION, ak());
            jSONObject.put("aspect_ratio", (double) al());
            c aa2 = aa();
            if (aa2 != null) {
                JSONObject jSONObject9 = new JSONObject();
                jSONObject9.put(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING, aa2.b());
                jSONObject9.put(CampaignEx.JSON_KEY_PACKAGE_NAME, aa2.c());
                jSONObject9.put(DownloadModel.DOWNLOAD_URL, aa2.a());
                jSONObject9.put(FirebaseAnalytics.Param.SCORE, aa2.d());
                jSONObject9.put("comment_num", aa2.e());
                jSONObject9.put(CampaignEx.JSON_KEY_APP_SIZE, aa2.f());
                jSONObject.put(MBridgeConstans.DYNAMIC_VIEW_WX_APP, jSONObject9);
            }
            j ab2 = ab();
            if (ab2 != null) {
                JSONObject jSONObject10 = new JSONObject();
                jSONObject10.put("deeplink_url", ab2.a());
                jSONObject10.put("fallback_url", ab2.b());
                jSONObject10.put("fallback_type", ab2.c());
                jSONObject.put(CampaignEx.JSON_KEY_DEEP_LINK_URL, jSONObject10);
            }
            List<FilterWord> ae2 = ae();
            if (ae2 != null) {
                JSONArray jSONArray5 = new JSONArray();
                for (FilterWord b2 : ae2) {
                    JSONObject b3 = b(b2);
                    if (b3 != null) {
                        jSONArray5.put(b3);
                    }
                }
                jSONObject.put("filter_words", jSONArray5);
            }
            n().a(jSONObject);
            jSONObject.put("count_down", bD());
            jSONObject.put("expiration_time", ag());
            b aM2 = aM();
            if (aM2 != null) {
                jSONObject.put("video", aM2.r());
            }
            b aN2 = aN();
            if (aN2 != null) {
                jSONObject.put("h265_video", aN2.r());
            }
            jSONObject.put("video_encode_type", aL());
            JSONObject jSONObject11 = new JSONObject();
            jSONObject11.put("if_send_click", J());
            jSONObject.put("download_conf", jSONObject11);
            if (ai() != null) {
                JSONObject jSONObject12 = new JSONObject();
                Set<Map.Entry<String, Object>> entrySet = ai().entrySet();
                if (!entrySet.isEmpty()) {
                    for (Map.Entry next2 : entrySet) {
                        jSONObject12.put((String) next2.getKey(), next2.getValue());
                    }
                }
                jSONObject.put("media_ext", jSONObject12);
            }
            q.a I2 = I();
            if (I2 != null) {
                JSONObject jSONObject13 = new JSONObject();
                jSONObject13.put("id", I2.e());
                jSONObject13.put("md5", I2.f());
                jSONObject13.put("url", I2.g());
                jSONObject13.put("data", I2.h());
                jSONObject13.put("diff_data", I2.i());
                jSONObject13.put("version", I2.d());
                jSONObject13.put("dynamic_creative", I2.j());
                jSONObject.put("tpl_info", jSONObject13);
            }
            jSONObject.put("creative_extra", F());
            jSONObject.put("market_url", bE());
            jSONObject.put("auction_price", z());
            jSONObject.put("ad_info", bw());
            jSONObject.put("is_package_open", ap());
            jSONObject.put("playable_duration_time", aq());
            jSONObject.put("playable_endcard_close_time", ar());
            jSONObject.put("endcard_close_time", as());
            JSONObject jSONObject14 = new JSONObject();
            jSONObject14.put("render_sequence", x());
            jSONObject14.put("backup_render_control", y());
            jSONObject14.put("reserve_time", aC());
            jSONObject14.put("render_thread", aD());
            jSONObject.put("render", jSONObject14);
            if (this.ay == null) {
                p pVar = new p();
                this.ay = pVar;
                pVar.a("");
                this.ay.a(10);
                this.ay.b(20);
            }
            JSONObject jSONObject15 = new JSONObject();
            jSONObject15.put("onlylp_loading_maxtime", this.ay.a());
            jSONObject15.put("straight_lp_showtime", this.ay.b());
            jSONObject15.put("loading_text", this.ay.c());
            jSONObject.put("interaction_method_params", jSONObject15);
            JSONObject jSONObject16 = new JSONObject();
            jSONObject16.put("splash_clickarea", k());
            jSONObject16.put("splash_layout_id", l());
            jSONObject16.put("load_wait_time", m());
            jSONObject.put("splash_control", jSONObject16);
            if (av()) {
                jSONObject.put("dsp_html", this.aB);
            }
            if (at()) {
                jSONObject.put("vast_json", this.aA.j());
            }
            jSONObject.put("dsp_material_type", be());
            JSONObject jSONObject17 = new JSONObject();
            jSONObject17.put("loading_landingpage_type", aE());
            String[] strArr = this.aL;
            if (strArr != null && strArr.length > 0) {
                JSONArray jSONArray6 = new JSONArray();
                for (String put4 : this.aL) {
                    jSONArray6.put(put4);
                }
                jSONObject17.put("landingpage_text", jSONArray6);
            }
            jSONObject.put("loading_page", jSONObject17);
            jSONObject.put("deep_link_appname", this.s);
            jSONObject.put("landing_page_download_clicktype", this.t);
            l lVar = this.aM;
            if (lVar != null) {
                jSONObject.put("dsp_style", lVar.e());
            }
            jSONObject.put("jump_probability", this.aT);
            jSONObject.put("identificationOverlayContent", this.aU);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private JSONObject b(FilterWord filterWord) {
        if (filterWord == null) {
            return null;
        }
        try {
            if (filterWord.isValid()) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", filterWord.getId());
                jSONObject.put("name", filterWord.getName());
                jSONObject.put("is_selected", filterWord.getIsSelected());
                if (filterWord.hasSecondOptions()) {
                    JSONArray jSONArray = new JSONArray();
                    for (FilterWord b2 : filterWord.getOptions()) {
                        jSONArray.put(b(b2));
                    }
                    if (jSONArray.length() > 0) {
                        jSONObject.put("options", jSONArray);
                    }
                }
                return jSONObject;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public int ap() {
        return this.aq;
    }

    public void w(int i2) {
        this.aq = i2;
    }

    public int aq() {
        int i2 = this.ar;
        if (i2 > 0) {
            return i2;
        }
        return 20;
    }

    public void x(int i2) {
        this.ar = i2;
    }

    public int ar() {
        return this.as;
    }

    public void y(int i2) {
        this.as = i2;
    }

    public int as() {
        return this.at;
    }

    public void z(int i2) {
        this.at = i2;
    }

    public boolean at() {
        int i2 = this.aS;
        if ((i2 == 1 || i2 == 3) && au() != null) {
            return true;
        }
        return false;
    }

    public a au() {
        return this.aA;
    }

    public void a(a aVar) {
        this.aA = aVar;
    }

    public boolean av() {
        return this.aS == 2;
    }

    public String aw() {
        return this.aB;
    }

    public void v(String str) {
        this.aB = str;
    }

    public int ax() {
        JSONObject jSONObject = this.aC;
        if (jSONObject != null) {
            return jSONObject.optInt("easy_playable_skip_duration", 0);
        }
        return 0;
    }

    public JSONObject ay() {
        return this.aC;
    }

    public void d(JSONObject jSONObject) {
        this.aC = jSONObject;
    }

    public boolean az() {
        return this.aD == 1;
    }

    public void A(int i2) {
        this.aD = i2;
    }

    public void aA() {
        this.aE = true;
    }

    public boolean aB() {
        return this.aE;
    }

    public int aC() {
        return this.aI;
    }

    public void B(int i2) {
        this.aI = Math.max(0, i2);
    }

    public int aD() {
        return this.aJ;
    }

    public void C(int i2) {
        this.aJ = i2;
    }

    public int aE() {
        return this.aK;
    }

    public void D(int i2) {
        this.aK = i2;
    }

    public String aF() {
        String V2 = V();
        return (aa() == null || TextUtils.isEmpty(aa().b())) ? V2 : aa().b();
    }

    public String[] aG() {
        String[] strArr = this.aL;
        if ((strArr != null && strArr.length > 0) || TextUtils.isEmpty(V())) {
            return this.aL;
        }
        return new String[]{V()};
    }

    public void a(String[] strArr) {
        this.aL = strArr;
    }

    public void a(l lVar) {
        this.aM = lVar;
    }

    public l aH() {
        return this.aM;
    }

    public void E(int i2) {
        this.O = i2;
    }

    public int aI() {
        return this.O;
    }

    public com.bytedance.sdk.component.widget.b.a aJ() {
        com.bytedance.sdk.component.widget.b.a aVar = new com.bytedance.sdk.component.widget.b.a();
        aVar.a(this.Q);
        aVar.b(this.u);
        aVar.a(ac());
        return aVar;
    }

    public int aK() {
        return this.aw;
    }

    public void F(int i2) {
        this.aw = i2;
    }

    public int aL() {
        return this.ax;
    }

    public void G(int i2) {
        this.ax = i2;
    }

    public b aM() {
        return this.K;
    }

    public void b(b bVar) {
        this.K = bVar;
    }

    public b aN() {
        return this.J;
    }

    public void c(b bVar) {
        this.J = bVar;
    }

    public String aO() {
        return this.s;
    }

    public void w(String str) {
        this.s = str;
    }

    public int aP() {
        return this.t;
    }

    public void H(int i2) {
        this.t = i2;
    }

    public boolean aQ() {
        b bVar = this.I;
        return bVar == null || bVar.s() != 1;
    }

    public JSONObject aR() {
        if (this.U == null) {
            try {
                if (!TextUtils.isEmpty(this.A)) {
                    this.U = new JSONObject(this.A);
                }
            } catch (JSONException e2) {
                l.e("MaterialMeta", e2.getMessage());
            }
        }
        return this.U;
    }

    public int aS() {
        if (this.aF < 0) {
            JSONObject aR2 = aR();
            if (aR2 != null) {
                this.aF = aR2.optInt("ad_slot_type", 0);
            } else {
                this.aF = 0;
            }
        }
        return this.aF;
    }

    public int aT() {
        return this.aF;
    }

    public long aU() {
        if (this.aG < 0) {
            JSONObject aR2 = aR();
            if (aR2 != null) {
                this.aG = aR2.optLong("ad_id", 0);
            } else {
                this.aG = 0;
            }
        }
        return this.aG;
    }

    public boolean aV() {
        return aS() == 3 || aS() == 4;
    }

    public boolean aW() {
        return aS() == 7;
    }

    public boolean aX() {
        return aS() == 8;
    }

    public boolean aY() {
        return aS() == 1;
    }

    public int aZ() {
        JSONObject aR2 = aR();
        if (aR2 != null) {
            return aR2.optInt("rit", 0);
        }
        return 0;
    }

    public double ba() {
        return e(aR());
    }

    public String x(String str) {
        JSONObject aR2 = aR();
        return aR2 != null ? aR2.optString("rit", str) : str;
    }

    public String bb() {
        c aa2 = aa();
        if (aa2 == null || TextUtils.isEmpty(aa2.a())) {
            return null;
        }
        return aa2.a();
    }

    public String bc() {
        JSONObject aR2;
        String str = this.aH;
        if (TextUtils.isEmpty(str) && (aR2 = aR()) != null) {
            str = aR2.optString("req_id", "");
            A(str);
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public void A(String str) {
        this.aH = str;
    }

    public boolean bd() {
        if (D() != null && D().getDurationSlotType() == 8 && av()) {
            return true;
        }
        return false;
    }

    public int be() {
        return this.aS;
    }

    public void I(int i2) {
        this.aS = i2;
    }

    public boolean bf() {
        int i2 = this.h;
        return (i2 == 2 || i2 == 1) && 3 == this.g;
    }

    public boolean bg() {
        l lVar;
        if (!at() || bj() || (lVar = this.aM) == null || lVar.a() != 1) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002d A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean bh() {
        /*
            r3 = this;
            boolean r0 = r3.bj()
            r1 = 0
            if (r0 != 0) goto L_0x002e
            java.util.Random r0 = new java.util.Random
            r0.<init>()
            r2 = 100
            int r0 = r0.nextInt(r2)
            boolean r2 = r3.at()
            if (r2 == 0) goto L_0x0021
            com.bytedance.sdk.openadsdk.core.model.l r2 = r3.aM
            if (r2 == 0) goto L_0x002a
            int r2 = r2.b()
            goto L_0x002b
        L_0x0021:
            boolean r2 = com.bytedance.sdk.openadsdk.core.model.t.b(r3)
            if (r2 != 0) goto L_0x002a
            int r2 = r3.aT
            goto L_0x002b
        L_0x002a:
            r2 = 0
        L_0x002b:
            if (r0 >= r2) goto L_0x002e
            r1 = 1
        L_0x002e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.model.u.bh():boolean");
    }

    public boolean bi() {
        if (!at() || bj()) {
            return false;
        }
        int nextInt = new Random().nextInt(100);
        l lVar = this.aM;
        if (lVar == null || nextInt >= lVar.c()) {
            return false;
        }
        return true;
    }

    public boolean bj() {
        return this.f.a > 0;
    }

    public ab bk() {
        return this.f;
    }

    public void bl() {
        this.f.d();
        f(false);
    }

    public long bm() {
        return this.b;
    }

    public void c(long j2) {
        this.b = j2;
    }

    public boolean bn() {
        return this.a;
    }

    public void e(boolean z2) {
        this.a = z2;
    }
}
