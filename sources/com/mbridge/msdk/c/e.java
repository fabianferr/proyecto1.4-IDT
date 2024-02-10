package com.mbridge.msdk.c;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.o;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Setting */
public final class e {
    public static int a = 1500;
    private String A = d.a().e;
    private String B = d.a().f;
    private int C = 120;
    private String D = "";
    private String E = "";
    private String F = "1.0";
    private int G = 1;
    private int H = 1;
    private int I = 1;
    private int J = 0;
    private int K = 1;
    private int L = 0;
    private String M;
    private int N = 30;
    private int O = 5;
    private int P = 0;
    private int Q = 0;
    private int R = 9377;
    private int S = 0;
    private int T = 0;
    private int U = 0;
    private int V = 2;
    private int W = 10;
    private String X;
    private boolean Y = false;
    private JSONArray Z = new JSONArray();
    private String aA = "";
    private String aB = "";
    private String aC = "";
    private String aD = "";
    private String aE = "";
    private Map<String, a> aF;
    private int aG = 0;
    private b aH;
    private int aI = 0;
    private String aJ = "";
    private String aK = "";
    private String aL;
    private String aM;
    private int aN = 0;
    private boolean aO = false;
    private int aP = 120;
    private ArrayList<Integer> aQ;
    private HashMap<String, String> aR;
    private int aS = 0;
    private int aT = 0;
    private int aU = 0;
    private int aV = 0;
    private int aW = 0;
    private String aX;
    private int aY = 1;
    private String aZ = "";
    private JSONArray aa = new JSONArray();
    private int ab = 0;
    private int ac = 0;
    private int ad = 0;
    private int ae = 3;
    private int af = 600;
    private int ag = 10;
    private int ah = 8000;
    private int ai = 8000;
    private int aj = IronSourceConstants.RV_AUCTION_REQUEST;
    private int ak = a;
    private int al = 1;
    private a am;
    private b an;
    private String ao = "";
    private JSONObject ap;
    private JSONArray aq;
    private boolean ar = false;
    private List<Integer> as = new ArrayList();
    private long at;
    private int au;
    private String av = "";
    private String aw = "";
    private String ax = "";
    private String ay = "";
    private String az = "";
    private int b = 0;
    private String c;
    private int d;
    private long e = 86400;
    private long f;
    private Map<String, String> g;
    private boolean h;
    private long i;
    private boolean j;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private int o;
    private int p;
    private long q;
    private int r;
    private int s;
    private String t;
    private int u;
    private List<com.mbridge.msdk.foundation.entity.a> v;
    private boolean w = false;
    private int x = 3;
    private boolean y = true;
    private int z;

    public final void a(int i2) {
        this.z = i2;
    }

    public final int a() {
        return this.z;
    }

    public final List<com.mbridge.msdk.foundation.entity.a> b() {
        return this.v;
    }

    public final String c() {
        return this.D;
    }

    public final int d() {
        return this.C;
    }

    public final void b(int i2) {
        this.C = i2;
    }

    public final int e() {
        return this.b;
    }

    public final void c(int i2) {
        this.b = i2;
    }

    public final void a(boolean z2) {
        this.Y = z2;
    }

    public final boolean f() {
        return this.Y;
    }

    public final b g() {
        return this.an;
    }

    public final a h() {
        return this.am;
    }

    public final JSONArray i() {
        return this.aq;
    }

    public final JSONObject j() {
        return this.ap;
    }

    public final String k() {
        return this.E;
    }

    public final String l() {
        return this.F;
    }

    public final int m() {
        return this.aj;
    }

    public final int n() {
        return this.ah;
    }

    public final int o() {
        return this.ai;
    }

    public final void b(boolean z2) {
        this.ar = z2;
    }

    public final boolean p() {
        return this.ar;
    }

    public final int q() {
        return this.ac;
    }

    public final int r() {
        return this.ad;
    }

    public final int s() {
        return this.ae;
    }

    public final int t() {
        return this.af;
    }

    public final int u() {
        return this.ag;
    }

    public final int v() {
        return this.ab;
    }

    public final JSONArray w() {
        return this.Z;
    }

    public final JSONArray x() {
        return this.aa;
    }

    public final String y() {
        return this.X;
    }

    public final void a(String str) {
        this.X = str;
    }

    public final void d(int i2) {
        if (i2 > 0) {
            this.W = i2;
        }
    }

    public final int z() {
        return this.W;
    }

    public final void e(int i2) {
        this.S = i2;
    }

    public final int A() {
        return this.S;
    }

    public final void f(int i2) {
        this.T = i2;
    }

    public final int B() {
        return this.T;
    }

    public final void g(int i2) {
        this.U = i2;
    }

    public final int C() {
        return this.U;
    }

    public final void h(int i2) {
        this.V = i2;
    }

    public final int D() {
        return this.V;
    }

    public final String E() {
        return this.A;
    }

    public final String F() {
        return this.B;
    }

    public final boolean i(int i2) {
        return this.as.contains(Integer.valueOf(i2));
    }

    public final int G() {
        return this.G;
    }

    public final void j(int i2) {
        this.G = i2;
    }

    public final int H() {
        return this.H;
    }

    public final void k(int i2) {
        this.H = i2;
    }

    public final int I() {
        return this.I;
    }

    public final void l(int i2) {
        this.I = i2;
    }

    public final int J() {
        return this.J;
    }

    public final void m(int i2) {
        this.J = i2;
    }

    public final int K() {
        return this.K;
    }

    public final void n(int i2) {
        this.K = i2;
    }

    public final int L() {
        return this.L;
    }

    public final void o(int i2) {
        this.L = i2;
    }

    public final int M() {
        return this.u;
    }

    public final void p(int i2) {
        this.u = i2;
    }

    public final String N() {
        return this.t;
    }

    public final void b(String str) {
        this.t = str;
    }

    public final int O() {
        return this.s;
    }

    public final int P() {
        return this.r;
    }

    public final long Q() {
        if (this.q <= 0) {
            this.q = 7200;
        }
        return this.q;
    }

    public final void a(long j2) {
        this.q = j2;
    }

    public final int R() {
        return this.au;
    }

    public final void q(int i2) {
        this.au = i2;
    }

    public final long S() {
        return this.at;
    }

    public final void b(long j2) {
        this.at = j2;
    }

    public final boolean T() {
        return this.n;
    }

    public final void c(boolean z2) {
        this.n = z2;
    }

    public final long U() {
        return this.m;
    }

    public final boolean V() {
        return this.j;
    }

    public final void d(boolean z2) {
        this.j = z2;
    }

    public final long W() {
        return this.k;
    }

    public final void c(long j2) {
        this.k = j2;
    }

    public final void d(long j2) {
        this.l = j2;
    }

    public final String toString() {
        return " cfc=" + this.d + " getpf=" + this.e + " rurl=" + this.j;
    }

    public final int X() {
        return this.d;
    }

    public final void r(int i2) {
        this.d = i2;
    }

    public final long Y() {
        return this.e;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:169|170) */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:205|(3:209|210|211)|212|213|(3:217|218|219)) */
    /* JADX WARNING: Code restructure failed: missing block: B:170:?, code lost:
        r9.ar = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:?, code lost:
        r9.Y = r1;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:169:0x054d */
    /* JADX WARNING: Missing exception handler attribute for start block: B:180:0x058a */
    /* JADX WARNING: Missing exception handler attribute for start block: B:192:0x059b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:212:0x05f0 */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x06ac A[Catch:{ Exception -> 0x06ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x06c2 A[Catch:{ Exception -> 0x06ce }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.c.e c(java.lang.String r17) {
        /*
            java.lang.String r1 = "omsdkjs_h5_url"
            java.lang.String r2 = "omsdkjs_url"
            java.lang.String r0 = "plctb"
            java.lang.String r3 = "pcrn"
            java.lang.String r4 = "plct"
            java.lang.String r5 = "H+tU+FeXHM=="
            java.lang.String r6 = ""
            boolean r8 = android.text.TextUtils.isEmpty(r17)     // Catch:{ Exception -> 0x06d3 }
            if (r8 != 0) goto L_0x06d1
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ Exception -> 0x06d3 }
            r9 = r17
            r8.<init>(r9)     // Catch:{ Exception -> 0x06d3 }
            com.mbridge.msdk.c.e r9 = new com.mbridge.msdk.c.e     // Catch:{ Exception -> 0x06d3 }
            r9.<init>()     // Catch:{ Exception -> 0x06d3 }
            r9.ap = r8     // Catch:{ Exception -> 0x06ce }
            java.lang.String r10 = "cc"
            java.lang.String r10 = r8.optString(r10)     // Catch:{ Exception -> 0x06ce }
            r9.c = r10     // Catch:{ Exception -> 0x06ce }
            java.lang.String r10 = "mv_wildcard"
            java.lang.String r11 = "<mvpackage>mbridge</mvpackage>"
            java.lang.String r10 = r8.optString(r10, r11)     // Catch:{ Exception -> 0x06ce }
            r9.t = r10     // Catch:{ Exception -> 0x06ce }
            java.lang.String r10 = "cfc"
            int r10 = r8.optInt(r10)     // Catch:{ Exception -> 0x06ce }
            r9.d = r10     // Catch:{ Exception -> 0x06ce }
            java.lang.String r10 = "getpf"
            long r10 = r8.optLong(r10)     // Catch:{ Exception -> 0x06ce }
            r9.e = r10     // Catch:{ Exception -> 0x06ce }
            java.lang.String r10 = "current_time"
            long r10 = r8.optLong(r10)     // Catch:{ Exception -> 0x06ce }
            r9.i = r10     // Catch:{ Exception -> 0x06ce }
            java.lang.String r10 = "cfb"
            boolean r10 = r8.optBoolean(r10)     // Catch:{ Exception -> 0x06ce }
            r9.h = r10     // Catch:{ Exception -> 0x06ce }
            java.lang.String r10 = "awct"
            long r10 = r8.optLong(r10)     // Catch:{ Exception -> 0x06ce }
            r9.l = r10     // Catch:{ Exception -> 0x06ce }
            long r10 = r8.optLong(r4)     // Catch:{ Exception -> 0x06ce }
            r12 = 0
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 != 0) goto L_0x0069
            r10 = 3600(0xe10, double:1.7786E-320)
            goto L_0x006d
        L_0x0069:
            long r10 = r8.optLong(r4)     // Catch:{ Exception -> 0x06ce }
        L_0x006d:
            r9.k = r10     // Catch:{ Exception -> 0x06ce }
            java.lang.String r4 = "rurl"
            boolean r4 = r8.optBoolean(r4)     // Catch:{ Exception -> 0x06ce }
            r9.j = r4     // Catch:{ Exception -> 0x06ce }
            java.lang.String r4 = "uct"
            long r10 = r8.optLong(r4)     // Catch:{ Exception -> 0x06ce }
            r9.m = r10     // Catch:{ Exception -> 0x06ce }
            java.lang.String r4 = "ujds"
            boolean r4 = r8.optBoolean(r4)     // Catch:{ Exception -> 0x06ce }
            r9.n = r4     // Catch:{ Exception -> 0x06ce }
            java.lang.String r4 = "n2"
            int r4 = r8.optInt(r4)     // Catch:{ Exception -> 0x06ce }
            r9.o = r4     // Catch:{ Exception -> 0x06ce }
            java.lang.String r4 = "n3"
            int r4 = r8.optInt(r4)     // Catch:{ Exception -> 0x06ce }
            r9.p = r4     // Catch:{ Exception -> 0x06ce }
            java.lang.String r4 = "is_startup_crashsystem"
            r10 = 1
            int r4 = r8.optInt(r4, r10)     // Catch:{ Exception -> 0x06ce }
            r9.u = r4     // Catch:{ Exception -> 0x06ce }
            int r4 = r8.optInt(r3)     // Catch:{ Exception -> 0x06ce }
            r9.r = r4     // Catch:{ Exception -> 0x06ce }
            long r14 = r8.optLong(r0)     // Catch:{ Exception -> 0x06ce }
            int r4 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r4 != 0) goto L_0x00b3
            r14 = 7200(0x1c20, double:3.5573E-320)
            goto L_0x00b7
        L_0x00b3:
            long r14 = r8.optLong(r0)     // Catch:{ Exception -> 0x06ce }
        L_0x00b7:
            r9.q = r14     // Catch:{ Exception -> 0x06ce }
            r0 = 100
            int r0 = r8.optInt(r3, r0)     // Catch:{ Exception -> 0x06ce }
            r9.r = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "opent"
            int r0 = r8.optInt(r0, r10)     // Catch:{ Exception -> 0x06ce }
            r9.s = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "sfct"
            r3 = 1800(0x708, double:8.893E-321)
            long r3 = r8.optLong(r0, r3)     // Catch:{ Exception -> 0x06ce }
            r9.at = r3     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "upgd"
            int r0 = r8.optInt(r0, r10)     // Catch:{ Exception -> 0x06ce }
            r9.H = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "upsrl"
            int r0 = r8.optInt(r0, r10)     // Catch:{ Exception -> 0x06ce }
            r9.G = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "updevid"
            int r0 = r8.optInt(r0, r10)     // Catch:{ Exception -> 0x06ce }
            r9.I = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "sc"
            r3 = 0
            int r0 = r8.optInt(r0, r3)     // Catch:{ Exception -> 0x06ce }
            r9.J = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "up_tips"
            int r0 = r8.optInt(r0, r10)     // Catch:{ Exception -> 0x06ce }
            r9.K = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "iseu"
            r4 = -1
            int r0 = r8.optInt(r0, r4)     // Catch:{ Exception -> 0x06ce }
            r9.L = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "jm_unit"
            java.lang.String r0 = r8.optString(r0)     // Catch:{ Exception -> 0x06ce }
            r9.M = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "atf"
            org.json.JSONArray r0 = r8.optJSONArray(r0)     // Catch:{ Exception -> 0x015a }
            if (r0 == 0) goto L_0x0154
            int r11 = r0.length()     // Catch:{ Exception -> 0x015a }
            if (r11 <= 0) goto L_0x0154
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ Exception -> 0x015a }
            r11.<init>()     // Catch:{ Exception -> 0x015a }
            r14 = 0
        L_0x0125:
            int r15 = r0.length()     // Catch:{ Exception -> 0x015a }
            if (r14 >= r15) goto L_0x0155
            java.lang.String r15 = r0.optString(r14)     // Catch:{ Exception -> 0x015a }
            boolean r16 = com.mbridge.msdk.foundation.tools.ak.b(r15)     // Catch:{ Exception -> 0x015a }
            if (r16 == 0) goto L_0x014f
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x015a }
            r7.<init>(r15)     // Catch:{ Exception -> 0x015a }
            com.mbridge.msdk.foundation.entity.a r15 = new com.mbridge.msdk.foundation.entity.a     // Catch:{ Exception -> 0x015a }
            java.lang.String r10 = "adtype"
            int r10 = r7.optInt(r10)     // Catch:{ Exception -> 0x015a }
            java.lang.String r4 = "unitid"
            java.lang.String r4 = r7.optString(r4)     // Catch:{ Exception -> 0x015a }
            r15.<init>(r10, r4)     // Catch:{ Exception -> 0x015a }
            r11.add(r15)     // Catch:{ Exception -> 0x015a }
        L_0x014f:
            int r14 = r14 + 1
            r4 = -1
            r10 = 1
            goto L_0x0125
        L_0x0154:
            r11 = 0
        L_0x0155:
            if (r11 == 0) goto L_0x015e
            r9.v = r11     // Catch:{ Exception -> 0x015a }
            goto L_0x015e
        L_0x015a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x06ce }
        L_0x015e:
            java.lang.String r0 = "adct"
            r4 = 259200(0x3f480, float:3.63217E-40)
            int r0 = r8.optInt(r0, r4)     // Catch:{ Exception -> 0x06ce }
            r9.au = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "confirm_title"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.av = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "confirm_description"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aw = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "confirm_t"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.ax = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "confirm_c_rv"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.ay = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "confirm_c_play"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.az = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "adchoice_icon"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aA = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "adchoice_link"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aC = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "adchoice_size"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aB = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "platform_logo"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aE = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "platform_name"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aD = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "cdnate_cfg"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            java.util.Map r0 = f((java.lang.String) r0)     // Catch:{ Exception -> 0x06ce }
            r9.aF = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "atrqt"
            int r0 = r8.optInt(r0, r3)     // Catch:{ Exception -> 0x06ce }
            r9.b = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "iupdid"
            int r0 = r8.optInt(r0, r3)     // Catch:{ Exception -> 0x06ce }
            r9.aI = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "mcs"
            r4 = 120(0x78, float:1.68E-43)
            int r0 = r8.optInt(r0, r4)     // Catch:{ Exception -> 0x06ce }
            r9.C = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "ab_id"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.D = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "rid"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.E = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "log_rate"
            java.lang.String r7 = "-1"
            java.lang.String r0 = r8.optString(r0, r7)     // Catch:{ Exception -> 0x06ce }
            r9.F = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = r8.optString(r2, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aJ = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = r8.optString(r1, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aK = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "rty_tk_clk"
            int r0 = r8.optInt(r0, r3)     // Catch:{ Exception -> 0x06ce }
            r9.ad = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "rty_tk_imp"
            int r0 = r8.optInt(r0, r3)     // Catch:{ Exception -> 0x06ce }
            r9.ac = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "rty_cnt"
            r7 = 3
            int r0 = r8.optInt(r0, r7)     // Catch:{ Exception -> 0x06ce }
            r9.ae = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "rty_to"
            r10 = 600(0x258, float:8.41E-43)
            int r0 = r8.optInt(r0, r10)     // Catch:{ Exception -> 0x06ce }
            r9.af = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "rty_inr"
            r10 = 10
            int r0 = r8.optInt(r0, r10)     // Catch:{ Exception -> 0x06ce }
            r9.ag = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "dns"
            java.lang.String r0 = r8.optString(r0)     // Catch:{ Exception -> 0x06ce }
            r9.aX = r0     // Catch:{ Exception -> 0x06ce }
            boolean r11 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x06ce }
            if (r11 != 0) goto L_0x024b
            com.mbridge.msdk.c.c r11 = com.mbridge.msdk.c.c.a.a     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.b(r0)     // Catch:{ Exception -> 0x06ce }
            r11.a(r0)     // Catch:{ Exception -> 0x06ce }
        L_0x024b:
            java.lang.String r0 = r8.optString(r2, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aJ = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = r8.optString(r1, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aK = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "tcto"
            long r0 = r8.optLong(r0)     // Catch:{ Exception -> 0x06ce }
            int r2 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0267
            r0 = 10
            r9.f = r0     // Catch:{ Exception -> 0x06ce }
            goto L_0x029b
        L_0x0267:
            r9.f = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "jt"
            org.json.JSONArray r0 = r8.optJSONArray(r0)     // Catch:{ Exception -> 0x06ce }
            if (r0 == 0) goto L_0x029b
            int r1 = r0.length()     // Catch:{ Exception -> 0x06ce }
            if (r1 <= 0) goto L_0x029b
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x06ce }
            r1.<init>()     // Catch:{ Exception -> 0x06ce }
            r2 = 0
        L_0x027d:
            int r11 = r0.length()     // Catch:{ Exception -> 0x06ce }
            if (r2 >= r11) goto L_0x0299
            org.json.JSONObject r11 = r0.optJSONObject(r2)     // Catch:{ Exception -> 0x06ce }
            java.lang.String r12 = "domain"
            java.lang.String r12 = r11.optString(r12)     // Catch:{ Exception -> 0x06ce }
            java.lang.String r13 = "format"
            java.lang.String r11 = r11.optString(r13)     // Catch:{ Exception -> 0x06ce }
            r1.put(r12, r11)     // Catch:{ Exception -> 0x06ce }
            int r2 = r2 + 1
            goto L_0x027d
        L_0x0299:
            r9.g = r1     // Catch:{ Exception -> 0x06ce }
        L_0x029b:
            java.lang.String r0 = "mraid_js"
            java.lang.String r0 = r8.optString(r0)     // Catch:{ Exception -> 0x06ce }
            r9.aM = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "web_env_url"
            java.lang.String r0 = r8.optString(r0)     // Catch:{ Exception -> 0x06ce }
            r9.aL = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "alrbs"
            int r0 = r8.optInt(r0, r3)     // Catch:{ Exception -> 0x06ce }
            r1 = 2
            if (r0 > r1) goto L_0x02b7
            if (r0 >= 0) goto L_0x02b8
        L_0x02b7:
            r0 = 0
        L_0x02b8:
            r9.aN = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "GDPR_area"
            boolean r0 = r8.optBoolean(r0, r3)     // Catch:{ Exception -> 0x06ce }
            r9.aO = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "ct"
            int r0 = r8.optInt(r0, r4)     // Catch:{ Exception -> 0x06ce }
            r9.aP = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "ercd"
            org.json.JSONArray r0 = r8.optJSONArray(r0)     // Catch:{ Exception -> 0x06ce }
            if (r0 == 0) goto L_0x0304
            int r1 = r0.length()     // Catch:{ Exception -> 0x06ce }
            if (r1 <= 0) goto L_0x0304
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x06ce }
            r1.<init>()     // Catch:{ Exception -> 0x06ce }
            r2 = 0
        L_0x02de:
            int r4 = r0.length()     // Catch:{ Exception -> 0x06ce }
            if (r2 >= r4) goto L_0x02f4
            int r4 = r0.optInt(r2)     // Catch:{ Exception -> 0x06ce }
            if (r4 == 0) goto L_0x02f1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x06ce }
            r1.add(r4)     // Catch:{ Exception -> 0x06ce }
        L_0x02f1:
            int r2 = r2 + 1
            goto L_0x02de
        L_0x02f4:
            int r0 = r1.size()     // Catch:{ Exception -> 0x06ce }
            if (r0 <= 0) goto L_0x0304
            r2 = -1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r2)     // Catch:{ Exception -> 0x06ce }
            r1.add(r0)     // Catch:{ Exception -> 0x06ce }
            r9.aQ = r1     // Catch:{ Exception -> 0x06ce }
        L_0x0304:
            java.lang.String r0 = "hst"
            java.lang.String r0 = r8.optString(r0)     // Catch:{ Exception -> 0x06ce }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x06ce }
            if (r1 != 0) goto L_0x0367
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.b(r0)     // Catch:{ Exception -> 0x035d }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x035d }
            r1.<init>(r0)     // Catch:{ Exception -> 0x035d }
            java.util.Iterator r0 = r1.keys()     // Catch:{ Exception -> 0x035d }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x035d }
            r2.<init>()     // Catch:{ Exception -> 0x035d }
        L_0x0322:
            boolean r4 = r0.hasNext()     // Catch:{ Exception -> 0x035d }
            if (r4 == 0) goto L_0x0354
            java.lang.Object r4 = r0.next()     // Catch:{ Exception -> 0x035d }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x035d }
            boolean r11 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x035d }
            if (r11 != 0) goto L_0x0322
            java.lang.String r11 = r1.optString(r4)     // Catch:{ Exception -> 0x035d }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x035d }
            if (r11 != 0) goto L_0x0322
            java.lang.String r11 = r1.optString(r4)     // Catch:{ Exception -> 0x035d }
            java.lang.String r11 = com.mbridge.msdk.foundation.tools.u.b(r11)     // Catch:{ Exception -> 0x035d }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x035d }
            if (r11 != 0) goto L_0x0322
            java.lang.String r11 = r1.optString(r4)     // Catch:{ Exception -> 0x035d }
            r2.put(r4, r11)     // Catch:{ Exception -> 0x035d }
            goto L_0x0322
        L_0x0354:
            int r0 = r2.size()     // Catch:{ Exception -> 0x035d }
            if (r0 <= 0) goto L_0x0367
            r9.aR = r2     // Catch:{ Exception -> 0x035d }
            goto L_0x0367
        L_0x035d:
            r0 = move-exception
            java.lang.String r1 = "SETTING"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06ce }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)     // Catch:{ Exception -> 0x06ce }
        L_0x0367:
            java.lang.String r0 = "refactor_switch"
            org.json.JSONArray r0 = r8.optJSONArray(r0)     // Catch:{ Exception -> 0x06ce }
            if (r0 == 0) goto L_0x03ad
            int r1 = r0.length()     // Catch:{ Exception -> 0x06ce }
            if (r1 <= 0) goto L_0x03ad
            r1 = 0
        L_0x0376:
            int r2 = r0.length()     // Catch:{ Exception -> 0x06ce }
            if (r1 >= r2) goto L_0x03ad
            org.json.JSONObject r2 = r0.getJSONObject(r1)     // Catch:{ Exception -> 0x06ce }
            java.util.Iterator r4 = r2.keys()     // Catch:{ Exception -> 0x06ce }
        L_0x0384:
            boolean r11 = r4.hasNext()     // Catch:{ Exception -> 0x06ce }
            if (r11 == 0) goto L_0x03aa
            java.lang.Object r11 = r4.next()     // Catch:{ Exception -> 0x06ce }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x06ce }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x06ce }
            if (r12 != 0) goto L_0x0384
            boolean r12 = r2.getBoolean(r11)     // Catch:{ Exception -> 0x06ce }
            if (r12 == 0) goto L_0x0384
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ Exception -> 0x06ce }
            java.util.List<java.lang.Integer> r12 = r9.as     // Catch:{ Exception -> 0x06ce }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ Exception -> 0x06ce }
            r12.add(r11)     // Catch:{ Exception -> 0x06ce }
            goto L_0x0384
        L_0x03aa:
            int r1 = r1 + 1
            goto L_0x0376
        L_0x03ad:
            java.lang.String r0 = "lqcnt"
            r1 = 30
            int r0 = r8.optInt(r0, r1)     // Catch:{ Exception -> 0x045c }
            java.lang.String r1 = "lqto"
            r2 = 5
            int r1 = r8.optInt(r1, r2)     // Catch:{ Exception -> 0x045c }
            java.lang.String r2 = "lqswt"
            int r2 = r8.optInt(r2, r3)     // Catch:{ Exception -> 0x045c }
            java.lang.String r4 = "lqtype"
            int r4 = r8.optInt(r4, r3)     // Catch:{ Exception -> 0x045c }
            r9.O = r1     // Catch:{ Exception -> 0x045c }
            r9.N = r0     // Catch:{ Exception -> 0x045c }
            r9.P = r2     // Catch:{ Exception -> 0x045c }
            r9.Q = r4     // Catch:{ Exception -> 0x045c }
            java.lang.String r0 = "lg_bl"
            org.json.JSONArray r0 = r8.optJSONArray(r0)     // Catch:{ Exception -> 0x045c }
            if (r0 != 0) goto L_0x03e2
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x045c }
            r0.<init>()     // Catch:{ Exception -> 0x045c }
            java.lang.String r1 = "2000088"
            r0.put(r1)     // Catch:{ Exception -> 0x045c }
        L_0x03e2:
            r9.aa = r0     // Catch:{ Exception -> 0x045c }
            java.lang.String r0 = "lg_wl"
            org.json.JSONArray r0 = r8.optJSONArray(r0)     // Catch:{ Exception -> 0x045c }
            if (r0 != 0) goto L_0x0405
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ Exception -> 0x045c }
            r0.<init>()     // Catch:{ Exception -> 0x045c }
            java.lang.String r1 = "2000041"
            r0.put(r1)     // Catch:{ Exception -> 0x045c }
            java.lang.String r1 = "2000042"
            r0.put(r1)     // Catch:{ Exception -> 0x045c }
            java.lang.String r1 = "2000032"
            r0.put(r1)     // Catch:{ Exception -> 0x045c }
            java.lang.String r1 = "2000079"
            r0.put(r1)     // Catch:{ Exception -> 0x045c }
        L_0x0405:
            r9.Z = r0     // Catch:{ Exception -> 0x045c }
            java.lang.String r0 = "lg_wl_rt"
            int r0 = r8.optInt(r0)     // Catch:{ Exception -> 0x045c }
            r9.ab = r0     // Catch:{ Exception -> 0x045c }
            java.lang.String r0 = "srml"
            r1 = 8000(0x1f40, float:1.121E-41)
            int r0 = r8.optInt(r0, r1)     // Catch:{ Exception -> 0x045c }
            r9.ah = r0     // Catch:{ Exception -> 0x045c }
            java.lang.String r0 = "lrml"
            int r0 = r8.optInt(r0, r1)     // Catch:{ Exception -> 0x045c }
            r9.ai = r0     // Catch:{ Exception -> 0x045c }
            java.lang.String r0 = "wgl_d_ms"
            r1 = 1300(0x514, float:1.822E-42)
            int r0 = r8.optInt(r0, r1)     // Catch:{ Exception -> 0x045c }
            r9.aj = r0     // Catch:{ Exception -> 0x045c }
            java.lang.String r0 = "dp_ct"
            int r1 = a     // Catch:{ Exception -> 0x045c }
            int r0 = r8.optInt(r0, r1)     // Catch:{ Exception -> 0x045c }
            r9.ak = r0     // Catch:{ Exception -> 0x045c }
            com.mbridge.msdk.click.b.a.c = r0     // Catch:{ Exception -> 0x045c }
            java.lang.String r0 = "lqpt"
            java.lang.String r0 = r8.optString(r0)     // Catch:{ Exception -> 0x045c }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.b(r0)     // Catch:{ Exception -> 0x045c }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x045c }
            if (r0 <= 0) goto L_0x045c
            r1 = 65535(0xffff, float:9.1834E-41)
            if (r0 >= r1) goto L_0x045c
            r9.R = r0     // Catch:{ Exception -> 0x045c }
            com.mbridge.msdk.foundation.same.net.g.d r1 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ Exception -> 0x045c }
            r1.l = r0     // Catch:{ Exception -> 0x045c }
            com.mbridge.msdk.foundation.same.net.g.d r1 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ Exception -> 0x045c }
            r1.n = r0     // Catch:{ Exception -> 0x045c }
        L_0x045c:
            java.lang.String r0 = "wvddt"
            int r0 = r8.optInt(r0, r3)     // Catch:{ Exception -> 0x06ce }
            r9.aS = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "hst_st"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.A = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "hst_st_t"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.B = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "l"
            int r0 = r8.optInt(r0, r7)     // Catch:{ Exception -> 0x0499 }
            java.lang.String r1 = "k"
            int r1 = r8.optInt(r1, r3)     // Catch:{ Exception -> 0x0499 }
            r2 = 1
            if (r1 != r2) goto L_0x0486
            r1 = 1
            goto L_0x0487
        L_0x0486:
            r1 = 0
        L_0x0487:
            java.lang.String r4 = "m"
            int r4 = r8.optInt(r4, r2)     // Catch:{ Exception -> 0x0499 }
            if (r4 != r2) goto L_0x0491
            r2 = 1
            goto L_0x0492
        L_0x0491:
            r2 = 0
        L_0x0492:
            r9.x = r0     // Catch:{ Exception -> 0x0499 }
            r9.w = r1     // Catch:{ Exception -> 0x0499 }
            r9.y = r2     // Catch:{ Exception -> 0x0499 }
            goto L_0x04a3
        L_0x0499:
            r0 = move-exception
            java.lang.String r1 = "Setting"
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x06ce }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r0)     // Catch:{ Exception -> 0x06ce }
        L_0x04a3:
            java.lang.String r0 = "fbk_swt"
            int r0 = r8.optInt(r0, r3)     // Catch:{ Exception -> 0x06ce }
            r9.aG = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "fbk"
            org.json.JSONObject r0 = r8.optJSONObject(r0)     // Catch:{ Exception -> 0x06ce }
            com.mbridge.msdk.c.e$b r0 = com.mbridge.msdk.c.e.b.a(r0)     // Catch:{ Exception -> 0x06ce }
            r9.aH = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "ad_connection_timeout"
            int r1 = com.mbridge.msdk.foundation.same.a.x     // Catch:{ Exception -> 0x0524 }
            int r0 = r8.optInt(r0, r1)     // Catch:{ Exception -> 0x0524 }
            java.lang.String r1 = "ad_read_timeout"
            int r2 = com.mbridge.msdk.foundation.same.a.z     // Catch:{ Exception -> 0x0524 }
            int r1 = r8.optInt(r1, r2)     // Catch:{ Exception -> 0x0524 }
            java.lang.String r2 = "ad_write_timeout"
            int r4 = com.mbridge.msdk.foundation.same.a.A     // Catch:{ Exception -> 0x0524 }
            int r2 = r8.optInt(r2, r4)     // Catch:{ Exception -> 0x0524 }
            java.lang.String r4 = "ad_retry_count"
            int r7 = com.mbridge.msdk.foundation.same.a.B     // Catch:{ Exception -> 0x0524 }
            int r4 = r8.optInt(r4, r7)     // Catch:{ Exception -> 0x0524 }
            if (r0 > 0) goto L_0x04db
            int r0 = com.mbridge.msdk.foundation.same.a.x     // Catch:{ Exception -> 0x0524 }
        L_0x04db:
            r9.U = r0     // Catch:{ Exception -> 0x0524 }
            if (r1 > 0) goto L_0x04e1
            int r1 = com.mbridge.msdk.foundation.same.a.z     // Catch:{ Exception -> 0x0524 }
        L_0x04e1:
            r9.S = r1     // Catch:{ Exception -> 0x0524 }
            if (r2 > 0) goto L_0x04e7
            int r2 = com.mbridge.msdk.foundation.same.a.A     // Catch:{ Exception -> 0x0524 }
        L_0x04e7:
            r9.T = r2     // Catch:{ Exception -> 0x0524 }
            if (r4 >= 0) goto L_0x04ed
            int r4 = com.mbridge.msdk.foundation.same.a.B     // Catch:{ Exception -> 0x0524 }
        L_0x04ed:
            r9.V = r4     // Catch:{ Exception -> 0x0524 }
            java.lang.String r0 = "max_download_task_size"
            int r0 = r8.optInt(r0, r10)     // Catch:{ Exception -> 0x0524 }
            if (r0 > 0) goto L_0x04f9
            r0 = 10
        L_0x04f9:
            r9.z = r0     // Catch:{ Exception -> 0x0524 }
            java.lang.String r0 = "max_bitmap_cache_size"
            int r0 = r8.optInt(r0, r10)     // Catch:{ Exception -> 0x0524 }
            r9.d((int) r0)     // Catch:{ Exception -> 0x0524 }
            java.lang.String r0 = "t_t"
            int r0 = r8.optInt(r0)     // Catch:{ Exception -> 0x0524 }
            r9.aV = r0     // Catch:{ Exception -> 0x0524 }
            java.lang.String r0 = "h_t"
            int r0 = r8.optInt(r0)     // Catch:{ Exception -> 0x0524 }
            r9.aU = r0     // Catch:{ Exception -> 0x0524 }
            java.lang.String r0 = "gtp"
            int r0 = r8.optInt(r0)     // Catch:{ Exception -> 0x0524 }
            r9.aW = r0     // Catch:{ Exception -> 0x0524 }
            com.mbridge.msdk.foundation.same.net.g.d r1 = com.mbridge.msdk.foundation.same.net.g.d.a()     // Catch:{ Exception -> 0x0524 }
            r1.a((int) r0)     // Catch:{ Exception -> 0x0524 }
        L_0x0524:
            java.lang.String r0 = "http_track_url"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x052c }
            r9.X = r0     // Catch:{ Exception -> 0x052c }
        L_0x052c:
            java.lang.String r0 = "st_net"
            r1 = 1
            int r0 = r8.optInt(r0, r1)     // Catch:{ Exception -> 0x06ce }
            r9.aY = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "vtag"
            java.lang.String r0 = r8.optString(r0, r6)     // Catch:{ Exception -> 0x06ce }
            r9.aZ = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "check_webview"
            int r0 = r8.optInt(r0, r3)     // Catch:{ Exception -> 0x054d }
            if (r0 != 0) goto L_0x0549
            r0 = 0
            goto L_0x054a
        L_0x0549:
            r0 = 1
        L_0x054a:
            r9.ar = r0     // Catch:{ Exception -> 0x054d }
            goto L_0x054f
        L_0x054d:
            r9.ar = r3     // Catch:{ Exception -> 0x06ce }
        L_0x054f:
            java.lang.String r0 = "swxid"
            java.lang.String r0 = r8.optString(r0)     // Catch:{ Exception -> 0x06ce }
            java.lang.String r1 = r9.ao     // Catch:{ Exception -> 0x06ce }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x06ce }
            if (r1 != 0) goto L_0x0577
            r9.ao = r0     // Catch:{ Exception -> 0x06ce }
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = r0.i()     // Catch:{ Exception -> 0x06ce }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x06ce }
            if (r0 == 0) goto L_0x0577
            com.mbridge.msdk.foundation.controller.b r0 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x06ce }
            java.lang.String r1 = r9.ao     // Catch:{ Exception -> 0x06ce }
            r0.d(r1)     // Catch:{ Exception -> 0x06ce }
        L_0x0577:
            java.lang.String r0 = "sdk_filters"
            org.json.JSONArray r0 = r8.optJSONArray(r0)     // Catch:{ Exception -> 0x06ce }
            r9.aq = r0     // Catch:{ Exception -> 0x06ce }
            java.lang.String r0 = "ch_nv_im_cb"
            r1 = 1
            int r0 = r8.optInt(r0, r1)     // Catch:{ Exception -> 0x058a }
            r9.al = r0     // Catch:{ Exception -> 0x058a }
            goto L_0x058c
        L_0x0589:
            r1 = 1
        L_0x058a:
            r9.al = r1     // Catch:{ Exception -> 0x06ce }
        L_0x058c:
            java.lang.String r0 = "do_us_fi_re"
            int r0 = r8.optInt(r0, r1)     // Catch:{ Exception -> 0x059b }
            if (r0 == 0) goto L_0x0596
            r2 = 1
            goto L_0x0597
        L_0x0596:
            r2 = 0
        L_0x0597:
            r9.Y = r2     // Catch:{ Exception -> 0x059a }
            goto L_0x059d
        L_0x059a:
            r1 = 1
        L_0x059b:
            r9.Y = r1     // Catch:{ Exception -> 0x06ce }
        L_0x059d:
            com.mbridge.msdk.foundation.controller.c.a()     // Catch:{ Exception -> 0x069c }
            com.mbridge.msdk.foundation.tools.FastKV$Builder r0 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x05b4 }
            com.mbridge.msdk.foundation.same.b.c r1 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x05b4 }
            java.lang.String r1 = com.mbridge.msdk.foundation.same.b.e.b(r1)     // Catch:{ Exception -> 0x05b4 }
            java.lang.String r2 = com.mbridge.msdk.foundation.tools.u.b(r5)     // Catch:{ Exception -> 0x05b4 }
            r0.<init>(r1, r2)     // Catch:{ Exception -> 0x05b4 }
            com.mbridge.msdk.foundation.tools.FastKV r7 = r0.build()     // Catch:{ Exception -> 0x05b4 }
            goto L_0x05b6
        L_0x05b4:
            r7 = 0
        L_0x05b6:
            java.lang.String r0 = "H+tU+Fz8"
            java.lang.String r1 = "H+tU+bfPhM=="
            java.lang.String r2 = "c"
            java.lang.String r4 = "b"
            if (r7 == 0) goto L_0x061e
            com.mbridge.msdk.foundation.controller.b r3 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0618 }
            android.content.Context r3 = r3.g()     // Catch:{ Exception -> 0x0618 }
            if (r3 == 0) goto L_0x06a0
            java.lang.String r3 = r8.optString(r4)     // Catch:{ Exception -> 0x0618 }
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0618 }
            if (r5 != 0) goto L_0x05f0
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0618 }
            boolean r5 = android.text.TextUtils.equals(r5, r3)     // Catch:{ Exception -> 0x0618 }
            if (r5 != 0) goto L_0x05f0
            com.mbridge.msdk.foundation.same.a.l = r3     // Catch:{ Exception -> 0x0618 }
            com.mbridge.msdk.foundation.a.a.a r3 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0618 }
            java.lang.String r5 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0618 }
            r3.a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x0618 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.u.b(r1)     // Catch:{ Exception -> 0x05f0 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x05f0 }
            r7.putString(r1, r3)     // Catch:{ Exception -> 0x05f0 }
        L_0x05f0:
            java.lang.String r1 = r8.optString(r2)     // Catch:{ Exception -> 0x0618 }
            boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0618 }
            if (r3 != 0) goto L_0x06a0
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0618 }
            boolean r3 = android.text.TextUtils.equals(r3, r1)     // Catch:{ Exception -> 0x0618 }
            if (r3 != 0) goto L_0x06a0
            com.mbridge.msdk.foundation.same.a.m = r1     // Catch:{ Exception -> 0x0618 }
            com.mbridge.msdk.foundation.a.a.a r1 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0618 }
            java.lang.String r3 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0618 }
            r1.a((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x0618 }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.b(r0)     // Catch:{ Exception -> 0x06a0 }
            java.lang.String r1 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x06a0 }
            r7.putString(r0, r1)     // Catch:{ Exception -> 0x06a0 }
            goto L_0x06a0
        L_0x0618:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x069c }
            goto L_0x06a0
        L_0x061e:
            com.mbridge.msdk.foundation.controller.b r6 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0697 }
            android.content.Context r6 = r6.g()     // Catch:{ Exception -> 0x0697 }
            if (r6 == 0) goto L_0x06a0
            java.lang.String r7 = r8.optString(r4)     // Catch:{ Exception -> 0x0697 }
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x0697 }
            if (r10 != 0) goto L_0x065f
            java.lang.String r10 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0697 }
            boolean r10 = android.text.TextUtils.equals(r10, r7)     // Catch:{ Exception -> 0x0697 }
            if (r10 != 0) goto L_0x065f
            com.mbridge.msdk.foundation.same.a.l = r7     // Catch:{ Exception -> 0x0697 }
            com.mbridge.msdk.foundation.a.a.a r7 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0697 }
            java.lang.String r10 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0697 }
            r7.a((java.lang.String) r4, (java.lang.String) r10)     // Catch:{ Exception -> 0x0697 }
            java.lang.String r4 = com.mbridge.msdk.foundation.tools.u.b(r5)     // Catch:{ Exception -> 0x0697 }
            android.content.SharedPreferences r4 = r6.getSharedPreferences(r4, r3)     // Catch:{ Exception -> 0x0697 }
            if (r4 == 0) goto L_0x065f
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception -> 0x0697 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.u.b(r1)     // Catch:{ Exception -> 0x0697 }
            java.lang.String r7 = com.mbridge.msdk.foundation.same.a.l     // Catch:{ Exception -> 0x0697 }
            r4.putString(r1, r7)     // Catch:{ Exception -> 0x0697 }
            r4.apply()     // Catch:{ Exception -> 0x0697 }
        L_0x065f:
            java.lang.String r1 = r8.optString(r2)     // Catch:{ Exception -> 0x0697 }
            boolean r4 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0697 }
            if (r4 != 0) goto L_0x06a0
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0697 }
            boolean r4 = android.text.TextUtils.equals(r4, r1)     // Catch:{ Exception -> 0x0697 }
            if (r4 != 0) goto L_0x06a0
            com.mbridge.msdk.foundation.same.a.m = r1     // Catch:{ Exception -> 0x0697 }
            com.mbridge.msdk.foundation.a.a.a r1 = com.mbridge.msdk.foundation.a.a.a.a()     // Catch:{ Exception -> 0x0697 }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0697 }
            r1.a((java.lang.String) r2, (java.lang.String) r4)     // Catch:{ Exception -> 0x0697 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.u.b(r5)     // Catch:{ Exception -> 0x0697 }
            android.content.SharedPreferences r1 = r6.getSharedPreferences(r1, r3)     // Catch:{ Exception -> 0x0697 }
            if (r1 == 0) goto L_0x06a0
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x0697 }
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.b(r0)     // Catch:{ Exception -> 0x0697 }
            java.lang.String r2 = com.mbridge.msdk.foundation.same.a.m     // Catch:{ Exception -> 0x0697 }
            r1.putString(r0, r2)     // Catch:{ Exception -> 0x0697 }
            r1.apply()     // Catch:{ Exception -> 0x0697 }
            goto L_0x06a0
        L_0x0697:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x069c }
            goto L_0x06a0
        L_0x069c:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x06ce }
        L_0x06a0:
            java.lang.String r0 = "bcp"
            java.lang.String r0 = r8.optString(r0)     // Catch:{ Exception -> 0x06ce }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x06ce }
            if (r1 != 0) goto L_0x06b6
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.b(r0)     // Catch:{ Exception -> 0x06ce }
            com.mbridge.msdk.c.a r0 = com.mbridge.msdk.c.a.a(r0)     // Catch:{ Exception -> 0x06ce }
            r9.am = r0     // Catch:{ Exception -> 0x06ce }
        L_0x06b6:
            java.lang.String r0 = "monitor"
            java.lang.String r0 = r8.optString(r0)     // Catch:{ Exception -> 0x06ce }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x06ce }
            if (r1 != 0) goto L_0x06cc
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.u.b(r0)     // Catch:{ Exception -> 0x06ce }
            com.mbridge.msdk.c.b r0 = com.mbridge.msdk.c.b.a(r0)     // Catch:{ Exception -> 0x06ce }
            r9.an = r0     // Catch:{ Exception -> 0x06ce }
        L_0x06cc:
            r7 = r9
            goto L_0x06d8
        L_0x06ce:
            r0 = move-exception
            r7 = r9
            goto L_0x06d5
        L_0x06d1:
            r7 = 0
            goto L_0x06d8
        L_0x06d3:
            r0 = move-exception
            r7 = 0
        L_0x06d5:
            r0.printStackTrace()
        L_0x06d8:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.c.e.c(java.lang.String):com.mbridge.msdk.c.e");
    }

    public final long Z() {
        return this.i;
    }

    public final long aa() {
        return this.f * 1000;
    }

    public final void e(long j2) {
        this.f = j2;
    }

    public static String a(Context context, String str) {
        try {
            e b2 = f.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (b2 == null) {
                return "";
            }
            if (b2.g == null) {
                return "";
            }
            String host = Uri.parse(str).getHost();
            for (Map.Entry<String, String> key : b2.g.entrySet()) {
                String str2 = (String) key.getKey();
                if (!TextUtils.isEmpty(host) && host.contains(str2)) {
                    String str3 = b2.g.get(str2);
                    if (TextUtils.isEmpty(str3)) {
                        return "";
                    }
                    return str3.replace("{gaid}", w.a());
                }
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public final void e(boolean z2) {
        this.h = z2;
    }

    public final int ab() {
        return this.o;
    }

    public final int ac() {
        return this.p;
    }

    public final String ad() {
        return this.av;
    }

    public final String ae() {
        return this.aw;
    }

    public final String af() {
        return this.ax;
    }

    public final String ag() {
        return this.ay;
    }

    public final String ah() {
        return this.az;
    }

    public final void ai() {
        String language = Locale.getDefault().getLanguage();
        boolean z2 = true;
        if (!(!TextUtils.isEmpty(this.av) && !TextUtils.isEmpty(this.aw) && !TextUtils.isEmpty(this.ax) && !TextUtils.isEmpty(this.ay))) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.av = "Confirm to close? ";
                this.aw = "You will not be rewarded after closing the window";
                this.ax = "Close it";
                this.ay = "Continue";
            } else {
                this.av = "确认关闭？";
                this.aw = "关闭后您将不会获得任何奖励噢~ ";
                this.ax = "确认关闭";
                this.ay = "继续观看";
            }
        }
        if (TextUtils.isEmpty(this.av) || TextUtils.isEmpty(this.aw) || TextUtils.isEmpty(this.ax) || TextUtils.isEmpty(this.az)) {
            z2 = false;
        }
        if (z2) {
            return;
        }
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.av = "Confirm to close? ";
            this.aw = "You will not be rewarded after closing the window";
            this.ax = "Close it";
            this.az = "Continue";
            return;
        }
        this.av = "确认关闭？";
        this.aw = "关闭后您将不会获得任何奖励噢~ ";
        this.ax = "确认关闭";
        this.az = "继续试玩";
    }

    public final String aj() {
        return this.aA;
    }

    public final String ak() {
        return this.aB;
    }

    public final String al() {
        return this.aC;
    }

    public final Map<String, a> am() {
        return this.aF;
    }

    private static Map<String, a> f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    aVar.a(optJSONObject);
                }
                hashMap.put(next, aVar);
            }
            return hashMap;
        } catch (JSONException e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            return null;
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    public final int an() {
        return this.N;
    }

    public final int ao() {
        return this.O;
    }

    public final int ap() {
        return this.P;
    }

    public final int aq() {
        return this.Q;
    }

    public final boolean ar() {
        return this.w;
    }

    public final int as() {
        return this.x;
    }

    public final boolean at() {
        return this.y;
    }

    public final b au() {
        return this.aH;
    }

    public final int av() {
        return this.al;
    }

    public final void s(int i2) {
        this.al = i2;
    }

    /* compiled from: Setting */
    public static class b {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private JSONArray f;

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            b bVar = new b();
            Context g = com.mbridge.msdk.foundation.controller.b.d().g();
            bVar.a = jSONObject.optString("title", g.getString(t.a(g, "mbridge_cm_feedback_dialog_title", TypedValues.Custom.S_STRING)));
            bVar.b = jSONObject.optString("cancel", g.getString(t.a(g, "mbridge_cm_feedback_dialog_close_close", TypedValues.Custom.S_STRING)));
            bVar.c = jSONObject.optString("submit", g.getString(t.a(g, "mbridge_cm_feedback_dialog_close_submit", TypedValues.Custom.S_STRING)));
            bVar.d = jSONObject.optString("submit_notice", g.getString(t.a(g, "mbridge_cm_feedback_dialog_submit_notice", TypedValues.Custom.S_STRING)));
            bVar.e = jSONObject.optString(ShareConstants.WEB_DIALOG_PARAM_PRIVACY, g.getString(t.a(g, "mbridge_cm_feedback_dialog_privacy_des", TypedValues.Custom.S_STRING)));
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            bVar.f = optJSONArray;
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                bVar.f = jSONArray;
                jSONArray.put(g.getString(t.a(g, "mbridge_cm_feedback_dialog_content_not_play", TypedValues.Custom.S_STRING)));
                bVar.f.put(g.getString(t.a(g, "mbridge_cm_feedback_dialog_content_sound_problems", TypedValues.Custom.S_STRING)));
                bVar.f.put(g.getString(t.a(g, "mbridge_cm_feedback_dialog_content_misleading", TypedValues.Custom.S_STRING)));
                bVar.f.put(g.getString(t.a(g, "mbridge_cm_feedback_dialog_content_fraud", TypedValues.Custom.S_STRING)));
                bVar.f.put(g.getString(t.a(g, "mbridge_cm_feedback_dialog_content_por_violence", TypedValues.Custom.S_STRING)));
                bVar.f.put(g.getString(t.a(g, "mbridge_cm_feedback_dialog_content_other", TypedValues.Custom.S_STRING)));
            }
            return bVar;
        }

        public final String a() {
            return this.a;
        }

        public final String b() {
            return this.b;
        }

        public final String c() {
            return this.c;
        }

        public final String d() {
            return this.d;
        }

        public final String e() {
            return this.e;
        }

        public final JSONArray f() {
            return this.f;
        }
    }

    /* compiled from: Setting */
    public static class a {
        private List<String> a;
        private List<String> b;
        private List<String> c;
        private List<String> d;

        public final List<String> a() {
            return this.a;
        }

        public final List<String> b() {
            return this.b;
        }

        public final List<String> c() {
            return this.c;
        }

        public final List<String> d() {
            return this.d;
        }

        public final void a(JSONObject jSONObject) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray("x");
                if (optJSONArray != null) {
                    this.a = o.a(optJSONArray);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("y");
                if (optJSONArray2 != null) {
                    this.b = o.a(optJSONArray2);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
                if (optJSONArray3 != null) {
                    this.c = o.a(optJSONArray3);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
                if (optJSONArray4 != null) {
                    this.d = o.a(optJSONArray4);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public final String aw() {
        return this.aK;
    }

    public final void d(String str) {
        this.aK = str;
    }

    public final String ax() {
        return this.aJ;
    }

    public final void e(String str) {
        this.aJ = str;
    }

    public final String ay() {
        return this.aL;
    }

    public final String az() {
        return this.aM;
    }

    public final int aA() {
        return this.aN;
    }

    public final void t(int i2) {
        this.aN = i2;
    }

    public final boolean aB() {
        return this.aO;
    }

    public final void f(boolean z2) {
        this.aO = z2;
    }

    public final int aC() {
        return this.aP;
    }

    public final void u(int i2) {
        this.aP = i2;
    }

    public final ArrayList<Integer> aD() {
        return this.aQ;
    }

    public final HashMap<String, String> aE() {
        return this.aR;
    }

    public final int aF() {
        return this.aS;
    }

    public final int aG() {
        return this.aT;
    }

    public final void v(int i2) {
        this.aT = i2;
    }

    public final String aH() {
        return this.c;
    }

    public final int aI() {
        return this.aU;
    }

    public final void w(int i2) {
        this.aU = i2;
    }

    public final int aJ() {
        return this.aV;
    }

    public final void x(int i2) {
        this.aV = i2;
    }

    public final int aK() {
        return this.aY;
    }

    public final void y(int i2) {
        this.aY = i2;
    }

    public final String aL() {
        return this.aZ;
    }

    public final String aM() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("cc", this.c);
            jSONObject.put("cfc", this.d);
            jSONObject.put("cfb", this.h);
            jSONObject.put(CampaignEx.JSON_KEY_PLCT, this.k);
            jSONObject.put("awct", this.l);
            jSONObject.put("rurl", this.j);
            jSONObject.put("ujds", this.n);
            jSONObject.put(CampaignEx.JSON_KEY_PLCTB, this.q);
            jSONObject.put("tcto", this.f);
            jSONObject.put("mv_wildcard", this.t);
            jSONObject.put("is_startup_crashsystem", this.u);
            jSONObject.put("sfct", this.at);
            jSONObject.put("pcrn", this.r);
            jSONObject.put("adct", this.au);
            jSONObject.put("atrqt", this.b);
            jSONObject.put("omsdkjs_url", this.aJ);
            jSONObject.put("mcs", this.C);
            jSONObject.put("GDPR_area", this.aO);
            jSONObject.put("alrbs", this.aN);
            jSONObject.put(UserDataStore.CITY, this.aP);
            jSONObject.put("isDefault", this.aT);
            jSONObject.put("st_net", this.aY);
            jSONObject.put("vtag", this.aZ);
            return jSONObject.toString();
        } catch (Throwable th) {
            aa.d("Setting", th.getMessage());
            return null;
        }
    }
}
