package com.bytedance.sdk.component.adexpress.dynamic.b;

import android.graphics.Color;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.appnext.ads.fullscreen.RewardedVideo;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.adexpress.dynamic.c.j;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: DynamicLayoutNativeValue */
public class g {
    public int a;
    public String b;
    private f c;
    private e d;
    private String e;

    public g(e eVar) {
        this.d = eVar;
        this.a = eVar.a();
        this.b = eVar.c();
        this.e = eVar.d();
        if (d.c() == 1) {
            this.c = eVar.g();
        } else {
            this.c = eVar.e();
        }
        if (d.b()) {
            this.c = eVar.e();
        }
    }

    public int a() {
        return (int) this.c.n();
    }

    public int b() {
        return (int) this.c.q();
    }

    public int c() {
        return (int) this.c.o();
    }

    public int d() {
        return (int) this.c.p();
    }

    public float e() {
        return this.c.r();
    }

    public String f() {
        return this.a == 0 ? this.b : "";
    }

    public int g() {
        return a(this.c.v());
    }

    public int h() {
        String u = this.c.u();
        if ("left".equals(u)) {
            return 17;
        }
        if ("center".equals(u)) {
            return 4;
        }
        return "right".equals(u) ? 3 : 2;
    }

    public int i() {
        int h = h();
        if (h == 4) {
            return 17;
        }
        if (h == 3) {
            return GravityCompat.END;
        }
        return 8388611;
    }

    public String j() {
        int i = this.a;
        if (i == 2 || i == 13) {
            return this.b;
        }
        return "";
    }

    public String k() {
        return this.a == 1 ? this.b : "";
    }

    public String l() {
        return this.e;
    }

    public double m() {
        if (this.a == 11) {
            try {
                double parseDouble = Double.parseDouble(this.b);
                return !d.b() ? (double) ((int) parseDouble) : parseDouble;
            } catch (NumberFormatException unused) {
            }
        }
        return -1.0d;
    }

    public double n() {
        return this.c.s();
    }

    public float o() {
        return this.c.k();
    }

    public int p() {
        return a(this.c.y());
    }

    public float q() {
        return this.c.l();
    }

    public int r() {
        return this.c.av();
    }

    public int s() {
        return this.c.ax();
    }

    public boolean t() {
        return this.c.aw();
    }

    public String u() {
        return this.c.x();
    }

    public void a(float f) {
        this.c.a(f);
    }

    public boolean v() {
        return this.c.K();
    }

    public int w() {
        return this.c.L();
    }

    public int x() {
        String G = this.c.G();
        if ("skip-with-time-skip-btn".equals(this.d.b()) || "skip".equals(this.d.b()) || TextUtils.equals("skip-with-countdowns-skip-btn", this.d.b())) {
            return 6;
        }
        if (!"skip-with-time-countdown".equals(this.d.b()) && !"skip-with-time".equals(this.d.b())) {
            if (this.a == 10 && TextUtils.equals(this.c.H(), CampaignEx.JSON_NATIVE_VIDEO_CLICK)) {
                return 5;
            }
            if (Y() && Z()) {
                return 0;
            }
            if (Y()) {
                return 7;
            }
            if ("feedback-dislike".equals(this.d.b())) {
                return 3;
            }
            if (!TextUtils.isEmpty(G) && !G.equals("none")) {
                if (G.equals("video") || (this.d.a() == 7 && TextUtils.equals(G, RewardedVideo.VIDEO_MODE_NORMAL))) {
                    return (!d.b() || this.d.e() == null || !this.d.e().az()) ? 4 : 11;
                }
                if (G.equals(RewardedVideo.VIDEO_MODE_NORMAL)) {
                    return 1;
                }
                if (!G.equals("creative") && !"slide".equals(this.c.H())) {
                    return 0;
                }
                return 2;
            }
        }
        return 0;
    }

    private boolean Y() {
        if ((!d.b() || (!this.d.b().contains("logo-union") && !this.d.b().contains("logounion") && !this.d.b().contains("logoad"))) && !"logo-union".equals(this.d.b()) && !"logounion".equals(this.d.b()) && !"logoad".equals(this.d.b())) {
            return false;
        }
        return true;
    }

    public int y() {
        return a(this.c.w());
    }

    public double z() {
        return this.c.h();
    }

    public int A() {
        return this.c.c();
    }

    public int B() {
        return this.c.b();
    }

    public int C() {
        return this.c.e();
    }

    public int D() {
        return this.c.d();
    }

    public int E() {
        return this.c.i();
    }

    public String F() {
        return this.c.j();
    }

    public String G() {
        return this.c.H();
    }

    private boolean Z() {
        if (d.b()) {
            return false;
        }
        if ((TextUtils.isEmpty(this.b) || !this.b.contains("adx:")) && !j.b()) {
            return false;
        }
        return true;
    }

    public static int a(String str) {
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (str.equals("transparent")) {
            return 0;
        }
        if (str.charAt(0) == '#' && str.length() == 7) {
            return Color.parseColor(str);
        }
        if (str.charAt(0) == '#' && str.length() == 9) {
            return Color.parseColor(str);
        }
        if (!str.startsWith("rgba") || (split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",")) == null || split.length != 4) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        return (((int) ((Float.parseFloat(split[3]) * 255.0f) + 0.5f)) << 24) | (((int) Float.parseFloat(split[0])) << 16) | (((int) Float.parseFloat(split[1])) << 8) | ((int) Float.parseFloat(split[2])) | 0;
    }

    public static float[] b(String str) {
        String[] split = str.substring(str.indexOf("(") + 1, str.indexOf(")")).split(",");
        if (split == null || split.length != 4) {
            return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        }
        return new float[]{Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3])};
    }

    public boolean a(int i) {
        e eVar = this.d;
        if (eVar == null) {
            return false;
        }
        if (i == 1) {
            this.c = eVar.g();
        } else {
            this.c = eVar.e();
        }
        if (this.c != null) {
            return true;
        }
        return false;
    }

    public boolean H() {
        return this.c.ad();
    }

    public int I() {
        return this.c.af();
    }

    public int J() {
        return this.c.ae();
    }

    public String K() {
        return this.c.F();
    }

    public int L() {
        return this.c.g();
    }

    public int M() {
        return this.c.au();
    }

    public int N() {
        return this.c.aA();
    }

    public int O() {
        return this.c.ao();
    }

    public int P() {
        return this.c.an();
    }

    public boolean Q() {
        return this.c.ap();
    }

    public String R() {
        return this.c.B();
    }

    public String S() {
        return this.c.aq();
    }

    public String T() {
        return this.c.aB();
    }

    public boolean U() {
        return this.c.m();
    }

    public boolean V() {
        return this.c.D();
    }

    public String W() {
        return this.c.C();
    }

    public int X() {
        return this.c.E();
    }
}
