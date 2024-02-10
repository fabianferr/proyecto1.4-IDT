package com.bytedance.sdk.component.adexpress.dynamic.b;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DynamicLayoutBrickValue */
public class f {
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private boolean F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private double L;
    private int M;
    private boolean N;
    private int O;
    private boolean P;
    private int Q;
    private String R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private String W;
    private int X;
    private boolean Y;
    private int Z;
    private float a;
    private boolean aA;
    private JSONObject aB;
    private int aC;
    private int aD;
    private int aE;
    private int aF;
    private int aG;
    private String aH;
    private String aI;
    private int aa;
    private int ab;
    private int ac;
    private int ad;
    private int ae;
    private String af;
    private String ag;
    private boolean ah;
    private int ai;
    private int aj;
    private int ak;
    private List<a> al;
    private int am;
    private int an;
    private int ao;
    private int ap;
    private boolean aq;
    private boolean ar;
    private boolean as;
    private int at;
    private boolean au;
    private double av;
    private JSONObject aw;
    private JSONObject ax;
    private int ay;
    private String az;
    private float b;
    private float c;
    private float d;
    private boolean e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private double k;
    private double l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private boolean y;
    private int z;

    public static f a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        f fVar = new f();
        fVar.b(jSONObject.optString("adType", "embeded"));
        fVar.o(jSONObject.optString("clickArea", "creative"));
        fVar.p(jSONObject.optString("clickTigger", CampaignEx.JSON_NATIVE_VIDEO_CLICK));
        fVar.c(jSONObject.optString("fontFamily", "PingFangSC"));
        fVar.d(jSONObject.optString("textAlign", "left"));
        fVar.e(jSONObject.optString("color", "#999999"));
        fVar.f(jSONObject.optString("bgColor", "transparent"));
        fVar.g(jSONObject.optString("bgImgUrl", ""));
        fVar.h(jSONObject.optString("borderColor", "#000000"));
        fVar.i(jSONObject.optString("borderStyle", "solid"));
        fVar.j(jSONObject.optString("heightMode", "auto"));
        fVar.k(jSONObject.optString("widthMode", "fixed"));
        fVar.l(jSONObject.optString("interactText", ""));
        fVar.c(jSONObject.optBoolean("isShowBgControl", false));
        fVar.m(jSONObject.optString("interactBgColor", ""));
        JSONObject optJSONObject = jSONObject.optJSONObject("interactPosition");
        if (optJSONObject != null) {
            fVar.g(optJSONObject.optInt("translateY", 0));
        }
        fVar.n(jSONObject.optString("interactType", ""));
        fVar.e(jSONObject.optInt("interactSlideDirection", -1));
        fVar.q(jSONObject.optString("justifyHorizontal", "space-around"));
        fVar.r(jSONObject.optString("justifyVertical", "flex-start"));
        fVar.b(jSONObject.optDouble("timingStart"));
        fVar.c(jSONObject.optDouble("timingEnd"));
        fVar.d((float) jSONObject.optDouble(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 0.0d));
        fVar.c((float) jSONObject.optDouble(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 0.0d));
        fVar.a((float) jSONObject.optDouble("borderRadius", 0.0d));
        fVar.b((float) jSONObject.optDouble("borderSize", 0.0d));
        fVar.b(jSONObject.optBoolean("interactValidate", false));
        fVar.i((float) jSONObject.optDouble("fontSize", 0.0d));
        fVar.e((float) jSONObject.optDouble("paddingBottom", 0.0d));
        fVar.f((float) jSONObject.optDouble("paddingLeft", 0.0d));
        fVar.g((float) jSONObject.optDouble("paddingRight", 0.0d));
        fVar.h((float) jSONObject.optDouble("paddingTop", 0.0d));
        fVar.d(jSONObject.optBoolean("lineFeed", false));
        fVar.h(jSONObject.optInt("lineCount", 0));
        fVar.d(jSONObject.optDouble("lineHeight", 1.2d));
        fVar.m(jSONObject.optInt("letterSpacing", 0));
        fVar.e(jSONObject.optBoolean("isDataFixed", false));
        fVar.n(jSONObject.optInt("fontWeight"));
        fVar.f(jSONObject.optBoolean("lineLimit"));
        fVar.o(jSONObject.optInt("position"));
        fVar.s(jSONObject.optString("align"));
        fVar.g(jSONObject.optBoolean("useLeft"));
        fVar.h(jSONObject.optBoolean("useRight"));
        fVar.i(jSONObject.optBoolean("useTop"));
        fVar.j(jSONObject.optBoolean("useBottom"));
        fVar.t(jSONObject.optString("data"));
        fVar.k(jSONObject.optInt("marginLeft"));
        fVar.l(jSONObject.optInt("marginRight"));
        fVar.i(jSONObject.optInt("marginTop"));
        fVar.j(jSONObject.optInt("marginBottom"));
        fVar.p(jSONObject.optInt("tagMaxCount"));
        fVar.k(jSONObject.optBoolean("allowTextFlow"));
        fVar.q(jSONObject.optInt("textFlowType"));
        fVar.r(jSONObject.optInt("textFlowDuration"));
        fVar.s(jSONObject.optInt("left"));
        fVar.t(jSONObject.optInt("right"));
        fVar.u(jSONObject.optInt(ViewHierarchyConstants.DIMENSION_TOP_KEY));
        fVar.v(jSONObject.optInt("bottom"));
        fVar.u(jSONObject.optString("alignItems", "flex-start"));
        fVar.v(jSONObject.optString("direction", ""));
        fVar.a(jSONObject.optBoolean("loop", false));
        fVar.w(jSONObject.optInt("zIndex"));
        fVar.y(jSONObject.optInt("interactVisibleTime"));
        fVar.x(jSONObject.optInt("interactHiddenTime"));
        fVar.a(jSONObject.optString("bgGradient"));
        fVar.z(jSONObject.optInt("areaType"));
        fVar.A(jSONObject.optInt("interactSlideThreshold", 0));
        fVar.D(jSONObject.optInt("interactBottomDistance", 0));
        fVar.o(jSONObject.optBoolean("openPlayableLandingPage", false));
        fVar.b(jSONObject.optJSONObject("video"));
        fVar.c(jSONObject.optJSONObject("image"));
        fVar.B(jSONObject.optInt("borderShadowExtent"));
        fVar.l(jSONObject.optBoolean("bgGauseBlur"));
        fVar.C(jSONObject.optInt("bgGauseBlurRadius"));
        fVar.m(jSONObject.optBoolean("showTimeProgress", false));
        fVar.n(jSONObject.optBoolean("showPlayButton", false));
        fVar.a(jSONObject.optDouble("bgColorCg", 0.0d));
        fVar.f(jSONObject.optInt("bgMaterialCenterCalcColor", 0));
        fVar.b(jSONObject.optInt("borderTopLeftRadius", 0));
        fVar.a(jSONObject.optInt("borderTopRightRadius", 0));
        fVar.d(jSONObject.optInt("borderBottomLeftRadius", 0));
        fVar.c(jSONObject.optInt("borderBottomRightRadius", 0));
        fVar.d(jSONObject.optJSONObject("interactI18n"));
        fVar.w(jSONObject.optString("imageObjectFit"));
        try {
            JSONArray optJSONArray = jSONObject.optJSONArray("animations");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    a aVar = new a();
                    aVar.d(jSONObject2.optString("animationType"));
                    aVar.a(jSONObject2.optDouble("animationDuration"));
                    aVar.b(jSONObject2.optDouble("animationScaleX"));
                    aVar.c(jSONObject2.optDouble("animationScaleY"));
                    aVar.e(jSONObject2.optString("animationTimeFunction"));
                    aVar.d(jSONObject2.optDouble("animationDelay"));
                    aVar.f(jSONObject2.optInt("animationIterationCount"));
                    aVar.f(jSONObject2.optString("animationDirection"));
                    aVar.e(jSONObject2.optDouble("animationInterval"));
                    aVar.a(jSONObject2.optInt("animationBorderWidth"));
                    aVar.a(jSONObject2.optLong("key"));
                    aVar.b(jSONObject2.optInt("animationEffectWidth"));
                    aVar.c(jSONObject2.optInt("animationSwing", 1));
                    aVar.d(jSONObject2.optInt("animationTranslateX"));
                    aVar.e(jSONObject2.optInt("animationTranslateY"));
                    aVar.c(jSONObject2.optString("animationRippleBackgroundColor"));
                    aVar.b(jSONObject2.optString("animationScaleDirection"));
                    aVar.g(jSONObject2.optInt("animationFadeStart"));
                    aVar.h(jSONObject2.optInt("animationFadeEnd"));
                    aVar.a(jSONObject2.optString("animationRubInDirection"));
                    if (fVar.s() > 0.0d) {
                        aVar.d(aVar.n() + fVar.s());
                    }
                    arrayList.add(aVar);
                }
                fVar.a((List<a>) arrayList);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return fVar;
    }

    public boolean a() {
        return this.ah;
    }

    public void a(boolean z2) {
        this.ah = z2;
    }

    public int b() {
        return this.aD;
    }

    public void a(int i2) {
        this.aD = i2;
    }

    public int c() {
        return this.aE;
    }

    public void b(int i2) {
        this.aE = i2;
    }

    public int d() {
        return this.aF;
    }

    public void c(int i2) {
        this.aF = i2;
    }

    public int e() {
        return this.aG;
    }

    public void d(int i2) {
        this.aG = i2;
    }

    public JSONObject f() {
        return this.aB;
    }

    public int g() {
        return this.ay;
    }

    public void e(int i2) {
        this.ay = i2;
    }

    public double h() {
        return this.av;
    }

    public void a(double d2) {
        this.av = d2;
    }

    public int i() {
        return this.aC;
    }

    public void f(int i2) {
        this.aC = i2;
    }

    public String j() {
        return this.aI;
    }

    public void a(String str) {
        this.aI = str;
    }

    public float k() {
        return this.a;
    }

    public void a(float f2) {
        this.a = f2;
    }

    public float l() {
        return this.b;
    }

    public void b(float f2) {
        this.b = f2;
    }

    public void c(float f2) {
        this.c = f2;
    }

    public void d(float f2) {
        this.d = f2;
    }

    public boolean m() {
        return this.e;
    }

    public void b(boolean z2) {
        this.e = z2;
    }

    public float n() {
        return this.f;
    }

    public void e(float f2) {
        this.f = f2;
    }

    public float o() {
        return this.g;
    }

    public void f(float f2) {
        this.g = f2;
    }

    public float p() {
        return this.h;
    }

    public void g(float f2) {
        this.h = f2;
    }

    public float q() {
        return this.i;
    }

    public void h(float f2) {
        this.i = f2;
    }

    public float r() {
        return this.j;
    }

    public void i(float f2) {
        this.j = f2;
    }

    public double s() {
        return this.k;
    }

    public void b(double d2) {
        this.k = d2;
    }

    public double t() {
        return this.l;
    }

    public void c(double d2) {
        this.l = d2;
    }

    public void b(String str) {
        this.m = str;
    }

    public void c(String str) {
        this.n = str;
    }

    public String u() {
        return this.o;
    }

    public void d(String str) {
        this.o = str;
    }

    public String v() {
        return this.p;
    }

    public void e(String str) {
        this.p = str;
    }

    public String w() {
        return this.q;
    }

    public void f(String str) {
        this.q = str;
    }

    public void g(String str) {
        this.r = str;
    }

    public String x() {
        return this.r;
    }

    public String y() {
        return this.s;
    }

    public void h(String str) {
        this.s = str;
    }

    public void i(String str) {
        this.t = str;
    }

    public String z() {
        return this.u;
    }

    public void j(String str) {
        this.u = str;
    }

    public String A() {
        return this.v;
    }

    public void k(String str) {
        this.v = str;
    }

    public String B() {
        return this.w;
    }

    public void l(String str) {
        this.w = str;
    }

    public String C() {
        return this.x;
    }

    public void m(String str) {
        this.x = str;
    }

    public boolean D() {
        return this.y;
    }

    public void c(boolean z2) {
        this.y = z2;
    }

    public int E() {
        return this.z;
    }

    public void g(int i2) {
        this.z = i2;
    }

    public String F() {
        return this.A;
    }

    public void n(String str) {
        this.A = str;
    }

    public String G() {
        return this.B;
    }

    public void o(String str) {
        this.B = str;
    }

    public String H() {
        return this.C;
    }

    public void p(String str) {
        this.C = str;
    }

    public String I() {
        return this.D;
    }

    public void q(String str) {
        this.D = str;
    }

    public String J() {
        return this.E;
    }

    public void r(String str) {
        this.E = str;
    }

    public boolean K() {
        return this.F;
    }

    public void d(boolean z2) {
        this.F = z2;
    }

    public void h(int i2) {
        this.G = i2;
    }

    public int L() {
        return this.G;
    }

    public int M() {
        return this.H;
    }

    public void i(int i2) {
        this.H = i2;
    }

    public int N() {
        return this.I;
    }

    public void j(int i2) {
        this.I = i2;
    }

    public int O() {
        return this.J;
    }

    public void k(int i2) {
        this.J = i2;
    }

    public int P() {
        return this.K;
    }

    public void l(int i2) {
        this.K = i2;
    }

    public double Q() {
        return this.L;
    }

    public void d(double d2) {
        this.L = d2;
    }

    public int R() {
        return this.M;
    }

    public void m(int i2) {
        this.M = i2;
    }

    public boolean S() {
        return this.N;
    }

    public void e(boolean z2) {
        this.N = z2;
    }

    public int T() {
        return this.O;
    }

    public void n(int i2) {
        this.O = i2;
    }

    public boolean U() {
        return this.P;
    }

    public void f(boolean z2) {
        this.P = z2;
    }

    public int V() {
        return this.Q;
    }

    public void o(int i2) {
        this.Q = i2;
    }

    public String W() {
        return this.R;
    }

    public void s(String str) {
        this.R = str;
    }

    public boolean X() {
        return this.S;
    }

    public void g(boolean z2) {
        this.S = z2;
    }

    public boolean Y() {
        return this.T;
    }

    public void h(boolean z2) {
        this.T = z2;
    }

    public boolean Z() {
        return this.U;
    }

    public void i(boolean z2) {
        this.U = z2;
    }

    public boolean aa() {
        return this.V;
    }

    public void j(boolean z2) {
        this.V = z2;
    }

    public String ab() {
        return this.W;
    }

    public void t(String str) {
        this.W = str;
    }

    public int ac() {
        return this.X;
    }

    public void p(int i2) {
        this.X = i2;
    }

    public boolean ad() {
        return this.Y;
    }

    public void k(boolean z2) {
        this.Y = z2;
    }

    public int ae() {
        return this.Z;
    }

    public void q(int i2) {
        this.Z = i2;
    }

    public int af() {
        return this.aa;
    }

    public void r(int i2) {
        this.aa = i2;
    }

    public int ag() {
        return this.ab;
    }

    public void s(int i2) {
        this.ab = i2;
    }

    public int ah() {
        return this.ac;
    }

    public void t(int i2) {
        this.ac = i2;
    }

    public int ai() {
        return this.ad;
    }

    public void u(int i2) {
        this.ad = i2;
    }

    public int aj() {
        return this.ae;
    }

    public void v(int i2) {
        this.ae = i2;
    }

    public String ak() {
        return this.af;
    }

    public void u(String str) {
        this.af = str;
    }

    public String al() {
        return this.ag;
    }

    public void v(String str) {
        this.ag = str;
    }

    public int am() {
        return this.ai;
    }

    public void w(int i2) {
        this.ai = i2;
    }

    public int an() {
        return this.aj;
    }

    public void x(int i2) {
        this.aj = i2;
    }

    public int ao() {
        return this.ak;
    }

    public void y(int i2) {
        this.ak = i2;
    }

    public boolean ap() {
        return this.aA;
    }

    public void w(String str) {
        this.aH = str;
    }

    public String aq() {
        return this.aH;
    }

    public List<a> ar() {
        return this.al;
    }

    public int as() {
        List<a> list = this.al;
        if (list == null) {
            return 0;
        }
        for (a next : list) {
            if ("translate".equals(next.i()) && next.g() < 0) {
                return -next.g();
            }
        }
        return 0;
    }

    public void a(List<a> list) {
        this.al = list;
    }

    public int at() {
        return this.am;
    }

    public void z(int i2) {
        this.am = i2;
    }

    public int au() {
        return this.an;
    }

    public void A(int i2) {
        this.an = i2;
    }

    public int av() {
        return this.ao;
    }

    public void B(int i2) {
        this.ao = i2;
    }

    public boolean aw() {
        return this.aq;
    }

    public void l(boolean z2) {
        this.aq = z2;
    }

    public int ax() {
        return this.ap;
    }

    public void C(int i2) {
        this.ap = i2;
    }

    public boolean ay() {
        return this.ar;
    }

    public void m(boolean z2) {
        this.ar = z2;
    }

    public boolean az() {
        return this.as;
    }

    public void n(boolean z2) {
        this.as = z2;
    }

    public int aA() {
        return this.at;
    }

    public void D(int i2) {
        this.at = i2;
    }

    public String aB() {
        return this.az;
    }

    public boolean aC() {
        return this.au;
    }

    public void o(boolean z2) {
        this.au = z2;
    }

    public void b(JSONObject jSONObject) {
        this.aw = jSONObject;
    }

    public void c(JSONObject jSONObject) {
        this.ax = jSONObject;
    }

    public void d(JSONObject jSONObject) {
        this.aB = jSONObject;
    }

    public void aD() {
        a(this, this.aw);
    }

    public void aE() {
        a(this, this.ax);
    }

    private void a(f fVar, JSONObject jSONObject) {
        if (fVar != null && jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                next.hashCode();
                char c2 = 65535;
                switch (next.hashCode()) {
                    case -2067713583:
                        if (next.equals("isShowBgControl")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1965619659:
                        if (next.equals("clickArea")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -1885934767:
                        if (next.equals("bgImgUrl")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -1822062213:
                        if (next.equals("lineCount")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -1821293778:
                        if (next.equals("openPlayableLandingPage")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -1813937113:
                        if (next.equals("lineLimit")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -1578250488:
                        if (next.equals("interactBgColor")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -1501175880:
                        if (next.equals("paddingLeft")) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case -1422965251:
                        if (next.equals("adType")) {
                            c2 = 8;
                            break;
                        }
                        break;
                    case -1383228885:
                        if (next.equals("bottom")) {
                            c2 = 9;
                            break;
                        }
                        break;
                    case -1224696685:
                        if (next.equals("fontFamily")) {
                            c2 = 10;
                            break;
                        }
                        break;
                    case -1221029593:
                        if (next.equals(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
                            c2 = 11;
                            break;
                        }
                        break;
                    case -1065511464:
                        if (next.equals("textAlign")) {
                            c2 = 12;
                            break;
                        }
                        break;
                    case -1063257157:
                        if (next.equals("alignItems")) {
                            c2 = 13;
                            break;
                        }
                        break;
                    case -1046708884:
                        if (next.equals("interactValidate")) {
                            c2 = 14;
                            break;
                        }
                        break;
                    case -1044792121:
                        if (next.equals("marginTop")) {
                            c2 = 15;
                            break;
                        }
                        break;
                    case -1019884910:
                        if (next.equals("useBottom")) {
                            c2 = 16;
                            break;
                        }
                        break;
                    case -962590849:
                        if (next.equals("direction")) {
                            c2 = 17;
                            break;
                        }
                        break;
                    case -912366651:
                        if (next.equals("tagMaxCount")) {
                            c2 = 18;
                            break;
                        }
                        break;
                    case -848877971:
                        if (next.equals("interactHiddenTime")) {
                            c2 = 19;
                            break;
                        }
                        break;
                    case -836058546:
                        if (next.equals("useTop")) {
                            c2 = 20;
                            break;
                        }
                        break;
                    case -734428249:
                        if (next.equals("fontWeight")) {
                            c2 = 21;
                            break;
                        }
                        break;
                    case -731417480:
                        if (next.equals("zIndex")) {
                            c2 = 22;
                            break;
                        }
                        break;
                    case -709393864:
                        if (next.equals("timingStart")) {
                            c2 = 23;
                            break;
                        }
                        break;
                    case -515807685:
                        if (next.equals("lineHeight")) {
                            c2 = 24;
                            break;
                        }
                        break;
                    case -321658193:
                        if (next.equals("textFlowDuration")) {
                            c2 = 25;
                            break;
                        }
                        break;
                    case -295409451:
                        if (next.equals("useRight")) {
                            c2 = 26;
                            break;
                        }
                        break;
                    case -289173127:
                        if (next.equals("marginBottom")) {
                            c2 = 27;
                            break;
                        }
                        break;
                    case -204859874:
                        if (next.equals("bgColor")) {
                            c2 = 28;
                            break;
                        }
                        break;
                    case -148259282:
                        if (next.equals("useLeft")) {
                            c2 = 29;
                            break;
                        }
                        break;
                    case -51738487:
                        if (next.equals("widthMode")) {
                            c2 = 30;
                            break;
                        }
                        break;
                    case 115029:
                        if (next.equals(ViewHierarchyConstants.DIMENSION_TOP_KEY)) {
                            c2 = 31;
                            break;
                        }
                        break;
                    case 3076010:
                        if (next.equals("data")) {
                            c2 = ' ';
                            break;
                        }
                        break;
                    case 3317767:
                        if (next.equals("left")) {
                            c2 = '!';
                            break;
                        }
                        break;
                    case 3327652:
                        if (next.equals("loop")) {
                            c2 = '\"';
                            break;
                        }
                        break;
                    case 90130308:
                        if (next.equals("paddingTop")) {
                            c2 = '#';
                            break;
                        }
                        break;
                    case 92903173:
                        if (next.equals("align")) {
                            c2 = Typography.dollar;
                            break;
                        }
                        break;
                    case 94842723:
                        if (next.equals("color")) {
                            c2 = '%';
                            break;
                        }
                        break;
                    case 108511772:
                        if (next.equals("right")) {
                            c2 = Typography.amp;
                            break;
                        }
                        break;
                    case 113126854:
                        if (next.equals(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
                            c2 = '\'';
                            break;
                        }
                        break;
                    case 164611121:
                        if (next.equals("timingEnd")) {
                            c2 = '(';
                            break;
                        }
                        break;
                    case 202355100:
                        if (next.equals("paddingBottom")) {
                            c2 = ')';
                            break;
                        }
                        break;
                    case 247204452:
                        if (next.equals("allowTextFlow")) {
                            c2 = '*';
                            break;
                        }
                        break;
                    case 365601008:
                        if (next.equals("fontSize")) {
                            c2 = '+';
                            break;
                        }
                        break;
                    case 428975654:
                        if (next.equals("justifyVertical")) {
                            c2 = AbstractJsonLexerKt.COMMA;
                            break;
                        }
                        break;
                    case 439444041:
                        if (next.equals("interactVisibleTime")) {
                            c2 = '-';
                            break;
                        }
                        break;
                    case 713848971:
                        if (next.equals("paddingRight")) {
                            c2 = '.';
                            break;
                        }
                        break;
                    case 722830999:
                        if (next.equals("borderColor")) {
                            c2 = '/';
                            break;
                        }
                        break;
                    case 737768677:
                        if (next.equals("borderStyle")) {
                            c2 = '0';
                            break;
                        }
                        break;
                    case 747804969:
                        if (next.equals("position")) {
                            c2 = '1';
                            break;
                        }
                        break;
                    case 791643104:
                        if (next.equals("isDataFixed")) {
                            c2 = '2';
                            break;
                        }
                        break;
                    case 975087886:
                        if (next.equals("marginRight")) {
                            c2 = '3';
                            break;
                        }
                        break;
                    case 1110826708:
                        if (next.equals("justifyHorizontal")) {
                            c2 = '4';
                            break;
                        }
                        break;
                    case 1122368895:
                        if (next.equals("interactPosition")) {
                            c2 = '5';
                            break;
                        }
                        break;
                    case 1188229042:
                        if (next.equals("lineFeed")) {
                            c2 = '6';
                            break;
                        }
                        break;
                    case 1332036739:
                        if (next.equals("interactText")) {
                            c2 = '7';
                            break;
                        }
                        break;
                    case 1332055696:
                        if (next.equals("interactType")) {
                            c2 = '8';
                            break;
                        }
                        break;
                    case 1349188574:
                        if (next.equals("borderRadius")) {
                            c2 = '9';
                            break;
                        }
                        break;
                    case 1360828714:
                        if (next.equals("clickTigger")) {
                            c2 = AbstractJsonLexerKt.COLON;
                            break;
                        }
                        break;
                    case 1490178922:
                        if (next.equals("heightMode")) {
                            c2 = ';';
                            break;
                        }
                        break;
                    case 1761274325:
                        if (next.equals("textFlowType")) {
                            c2 = Typography.less;
                            break;
                        }
                        break;
                    case 1824903757:
                        if (next.equals("borderSize")) {
                            c2 = '=';
                            break;
                        }
                        break;
                    case 1970934485:
                        if (next.equals("marginLeft")) {
                            c2 = Typography.greater;
                            break;
                        }
                        break;
                    case 2111078717:
                        if (next.equals("letterSpacing")) {
                            c2 = '?';
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        fVar.c(jSONObject.optBoolean(next, false));
                        break;
                    case 1:
                        fVar.o(jSONObject.optString(next));
                        break;
                    case 2:
                        fVar.g(jSONObject.optString(next));
                        break;
                    case 3:
                        fVar.h(jSONObject.optInt(next));
                        break;
                    case 4:
                        fVar.o(jSONObject.optBoolean(next));
                        break;
                    case 5:
                        fVar.f(jSONObject.optBoolean(next));
                        break;
                    case 6:
                        fVar.m(jSONObject.optString(next));
                        break;
                    case 7:
                        fVar.f((float) jSONObject.optDouble(next));
                        break;
                    case 8:
                        fVar.b(jSONObject.optString(next));
                        break;
                    case 9:
                        fVar.v(jSONObject.optInt(next));
                        break;
                    case 10:
                        fVar.c(jSONObject.optString(next));
                        break;
                    case 11:
                        fVar.c((float) jSONObject.optDouble(next));
                        break;
                    case 12:
                        fVar.d(jSONObject.optString(next));
                        break;
                    case 13:
                        fVar.u(jSONObject.optString(next));
                        break;
                    case 14:
                        fVar.b(jSONObject.optBoolean(next));
                        break;
                    case 15:
                        fVar.i(jSONObject.optInt(next));
                        break;
                    case 16:
                        fVar.j(jSONObject.optBoolean(next));
                        break;
                    case 17:
                        fVar.v(jSONObject.optString(next));
                        break;
                    case 18:
                        fVar.p(jSONObject.optInt(next));
                        break;
                    case 19:
                        fVar.x(jSONObject.optInt(next));
                        break;
                    case 20:
                        fVar.i(jSONObject.optBoolean(next));
                        break;
                    case 21:
                        fVar.n(jSONObject.optInt(next));
                        break;
                    case 22:
                        fVar.w(jSONObject.optInt(next));
                        break;
                    case 23:
                        fVar.b(jSONObject.optDouble(next));
                        break;
                    case 24:
                        fVar.d(jSONObject.optDouble(next));
                        break;
                    case 25:
                        fVar.r(jSONObject.optInt(next));
                        break;
                    case 26:
                        fVar.h(jSONObject.optBoolean(next));
                        break;
                    case 27:
                        fVar.j(jSONObject.optInt(next));
                        break;
                    case 28:
                        fVar.f(jSONObject.optString(next));
                        break;
                    case 29:
                        fVar.g(jSONObject.optBoolean(next));
                        break;
                    case 30:
                        fVar.k(jSONObject.optString(next));
                        break;
                    case 31:
                        fVar.u(jSONObject.optInt(next));
                        break;
                    case ' ':
                        fVar.t(jSONObject.optString(next));
                        break;
                    case '!':
                        fVar.s(jSONObject.optInt(next));
                        break;
                    case '\"':
                        fVar.a(jSONObject.optBoolean(next));
                        break;
                    case '#':
                        fVar.h((float) jSONObject.optDouble(next));
                        break;
                    case '$':
                        fVar.s(jSONObject.optString(next));
                        break;
                    case '%':
                        fVar.e(jSONObject.optString(next));
                        break;
                    case '&':
                        fVar.t(jSONObject.optInt(next));
                        break;
                    case '\'':
                        fVar.d((float) jSONObject.optDouble(next));
                        break;
                    case '(':
                        fVar.c(jSONObject.optDouble(next));
                        break;
                    case ')':
                        fVar.e((float) jSONObject.optDouble(next));
                        break;
                    case '*':
                        fVar.k(jSONObject.optBoolean(next));
                        break;
                    case '+':
                        fVar.i((float) jSONObject.optDouble(next));
                        break;
                    case ',':
                        fVar.r(jSONObject.optString(next));
                        break;
                    case '-':
                        fVar.y(jSONObject.optInt(next));
                        break;
                    case '.':
                        fVar.g((float) jSONObject.optDouble(next));
                        break;
                    case '/':
                        fVar.h(jSONObject.optString(next));
                        break;
                    case '0':
                        fVar.i(jSONObject.optString(next));
                        break;
                    case '1':
                        fVar.o(jSONObject.optInt(next));
                        break;
                    case '2':
                        fVar.e(jSONObject.optBoolean(next));
                        break;
                    case '3':
                        fVar.l(jSONObject.optInt(next));
                        break;
                    case '4':
                        fVar.q(jSONObject.optString(next));
                        break;
                    case '5':
                        JSONObject optJSONObject = jSONObject.optJSONObject(next);
                        if (optJSONObject == null) {
                            break;
                        } else {
                            fVar.g(optJSONObject.optInt("translateY", 0));
                            break;
                        }
                    case '6':
                        fVar.d(jSONObject.optBoolean(next));
                        break;
                    case '7':
                        fVar.l(jSONObject.optString(next));
                        break;
                    case '8':
                        fVar.n(jSONObject.optString(next));
                        break;
                    case '9':
                        fVar.a((float) jSONObject.optDouble(next));
                        break;
                    case ':':
                        fVar.p(jSONObject.optString(next));
                        break;
                    case ';':
                        fVar.j(jSONObject.optString(next));
                        break;
                    case '<':
                        fVar.q(jSONObject.optInt(next));
                        break;
                    case '=':
                        fVar.b((float) jSONObject.optDouble(next));
                        break;
                    case '>':
                        fVar.k(jSONObject.optInt(next));
                        break;
                    case '?':
                        fVar.m(jSONObject.optInt(next));
                        break;
                }
            }
        }
    }
}
