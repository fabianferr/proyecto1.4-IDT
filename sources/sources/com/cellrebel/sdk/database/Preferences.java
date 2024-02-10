package com.cellrebel.sdk.database;

public class Preferences {
    public boolean A;
    public boolean B;
    public boolean C;
    public String D;
    public String E;
    public long a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public long h;
    public long i;
    public long j;
    public String k;
    public String l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public double t;
    public double u;
    public double v;
    public String w;
    public String x;
    public boolean y;
    public boolean z;

    public long A() {
        return this.m;
    }

    public String B() {
        return this.b;
    }

    public double C() {
        return this.v;
    }

    public long D() {
        return this.o;
    }

    public long E() {
        return this.n;
    }

    public long a() {
        return this.r;
    }

    public Preferences a(long j2) {
        this.r = j2;
        return this;
    }

    public Preferences a(String str) {
        this.E = str;
        return this;
    }

    public Preferences a(boolean z2) {
        this.z = z2;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        return obj instanceof Preferences;
    }

    public Preferences b(long j2) {
        this.q = j2;
        return this;
    }

    public Preferences b(String str) {
        this.g = str;
        return this;
    }

    public Preferences b(boolean z2) {
        this.y = z2;
        return this;
    }

    public String b() {
        return this.E;
    }

    public Preferences c(long j2) {
        this.p = j2;
        return this;
    }

    public Preferences c(String str) {
        this.D = str;
        return this;
    }

    public String c() {
        return this.x;
    }

    public long d() {
        return this.q;
    }

    public Preferences d(long j2) {
        this.i = j2;
        return this;
    }

    public Preferences d(String str) {
        this.f = str;
        return this;
    }

    public long e() {
        return this.p;
    }

    public Preferences e(long j2) {
        this.s = j2;
        return this;
    }

    public Preferences e(String str) {
        this.b = str;
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Preferences)) {
            return false;
        }
        Preferences preferences = (Preferences) obj;
        if (!preferences.a((Object) this) || n() != preferences.n()) {
            return false;
        }
        String B2 = B();
        String B3 = preferences.B();
        if (B2 != null ? !B2.equals(B3) : B3 != null) {
            return false;
        }
        String u2 = u();
        String u3 = preferences.u();
        if (u2 != null ? !u2.equals(u3) : u3 != null) {
            return false;
        }
        String v2 = v();
        String v3 = preferences.v();
        if (v2 != null ? !v2.equals(v3) : v3 != null) {
            return false;
        }
        String g2 = g();
        String g3 = preferences.g();
        if (g2 != null ? !g2.equals(g3) : g3 != null) {
            return false;
        }
        String w2 = w();
        String w3 = preferences.w();
        if (w2 != null ? !w2.equals(w3) : w3 != null) {
            return false;
        }
        String f2 = f();
        String f3 = preferences.f();
        if (f2 != null ? !f2.equals(f3) : f3 != null) {
            return false;
        }
        if (m() != preferences.m() || i() != preferences.i() || x() != preferences.x()) {
            return false;
        }
        String z2 = z();
        String z3 = preferences.z();
        if (z2 != null ? !z2.equals(z3) : z3 != null) {
            return false;
        }
        String h2 = h();
        String h3 = preferences.h();
        if (h2 != null ? !h2.equals(h3) : h3 != null) {
            return false;
        }
        if (A() != preferences.A() || E() != preferences.E() || D() != preferences.D() || e() != preferences.e() || d() != preferences.d() || a() != preferences.a() || j() != preferences.j() || Double.compare(y(), preferences.y()) != 0 || Double.compare(k(), preferences.k()) != 0 || Double.compare(C(), preferences.C()) != 0) {
            return false;
        }
        String t2 = t();
        String t3 = preferences.t();
        if (t2 != null ? !t2.equals(t3) : t3 != null) {
            return false;
        }
        String c2 = c();
        String c3 = preferences.c();
        if (c2 != null ? !c2.equals(c3) : c3 != null) {
            return false;
        }
        if (q() != preferences.q() || o() != preferences.o() || p() != preferences.p() || r() != preferences.r() || s() != preferences.s()) {
            return false;
        }
        String l2 = l();
        String l3 = preferences.l();
        if (l2 != null ? !l2.equals(l3) : l3 != null) {
            return false;
        }
        String b2 = b();
        String b3 = preferences.b();
        return b2 != null ? b2.equals(b3) : b3 == null;
    }

    public Preferences f(long j2) {
        this.h = j2;
        return this;
    }

    public String f() {
        return this.g;
    }

    public Preferences g(long j2) {
        this.j = j2;
        return this;
    }

    public String g() {
        return this.e;
    }

    public Preferences h(long j2) {
        this.o = j2;
        return this;
    }

    public String h() {
        return this.l;
    }

    public int hashCode() {
        long n2 = n();
        String B2 = B();
        int i2 = 43;
        int hashCode = ((((int) (n2 ^ (n2 >>> 32))) + 59) * 59) + (B2 == null ? 43 : B2.hashCode());
        String u2 = u();
        int hashCode2 = (hashCode * 59) + (u2 == null ? 43 : u2.hashCode());
        String v2 = v();
        int hashCode3 = (hashCode2 * 59) + (v2 == null ? 43 : v2.hashCode());
        String g2 = g();
        int hashCode4 = (hashCode3 * 59) + (g2 == null ? 43 : g2.hashCode());
        String w2 = w();
        int hashCode5 = (hashCode4 * 59) + (w2 == null ? 43 : w2.hashCode());
        String f2 = f();
        int i3 = hashCode5 * 59;
        int hashCode6 = f2 == null ? 43 : f2.hashCode();
        long m2 = m();
        long i4 = i();
        long x2 = x();
        int i5 = ((((((i3 + hashCode6) * 59) + ((int) (m2 ^ (m2 >>> 32)))) * 59) + ((int) (i4 ^ (i4 >>> 32)))) * 59) + ((int) (x2 ^ (x2 >>> 32)));
        String z2 = z();
        int hashCode7 = (i5 * 59) + (z2 == null ? 43 : z2.hashCode());
        String h2 = h();
        int i6 = hashCode7 * 59;
        int hashCode8 = h2 == null ? 43 : h2.hashCode();
        long A2 = A();
        long E2 = E();
        long D2 = D();
        long e2 = e();
        long d2 = d();
        long a2 = a();
        long j2 = j();
        long doubleToLongBits = Double.doubleToLongBits(y());
        long doubleToLongBits2 = Double.doubleToLongBits(k());
        long doubleToLongBits3 = Double.doubleToLongBits(C());
        int i7 = ((((((((((((((((((((i6 + hashCode8) * 59) + ((int) (A2 ^ (A2 >>> 32)))) * 59) + ((int) (E2 ^ (E2 >>> 32)))) * 59) + ((int) (D2 ^ (D2 >>> 32)))) * 59) + ((int) (e2 ^ (e2 >>> 32)))) * 59) + ((int) (d2 ^ (d2 >>> 32)))) * 59) + ((int) (a2 ^ (a2 >>> 32)))) * 59) + ((int) (j2 ^ (j2 >>> 32)))) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
        String t2 = t();
        int hashCode9 = (i7 * 59) + (t2 == null ? 43 : t2.hashCode());
        String c2 = c();
        int i8 = 79;
        int hashCode10 = ((((((((((hashCode9 * 59) + (c2 == null ? 43 : c2.hashCode())) * 59) + (q() ? 79 : 97)) * 59) + (o() ? 79 : 97)) * 59) + (p() ? 79 : 97)) * 59) + (r() ? 79 : 97)) * 59;
        if (!s()) {
            i8 = 97;
        }
        String l2 = l();
        int hashCode11 = ((hashCode10 + i8) * 59) + (l2 == null ? 43 : l2.hashCode());
        String b2 = b();
        int i9 = hashCode11 * 59;
        if (b2 != null) {
            i2 = b2.hashCode();
        }
        return i9 + i2;
    }

    public long i() {
        return this.i;
    }

    public Preferences i(long j2) {
        this.n = j2;
        return this;
    }

    public long j() {
        return this.s;
    }

    public double k() {
        return this.u;
    }

    public String l() {
        return this.D;
    }

    public long m() {
        return this.h;
    }

    public long n() {
        return this.a;
    }

    public boolean o() {
        return this.z;
    }

    public boolean p() {
        return this.A;
    }

    public boolean q() {
        return this.y;
    }

    public boolean r() {
        return this.B;
    }

    public boolean s() {
        return this.C;
    }

    public String t() {
        return this.w;
    }

    public String toString() {
        return "Preferences(id=" + n() + ", token=" + B() + ", manufacturer=" + u() + ", marketName=" + v() + ", codename=" + g() + ", mobileClientId=" + w() + ", clientKey=" + f() + ", fileTransferTimeout=" + m() + ", currentRefreshCache=" + i() + ", onLoadRefreshCache=" + x() + ", ranksJson=" + z() + ", countriesJson=" + h() + ", ranksTimestamp=" + A() + ", wiFiSentUsage=" + E() + ", wiFiReceivedUsage=" + D() + ", cellularSentUsage=" + e() + ", cellularReceivedUsage=" + d() + ", callStartTime=" + a() + ", dataUsageMeasurementTimestamp=" + j() + ", pageLoadTimestamp=" + y() + ", fileLoadTimestamp=" + k() + ", videoLoadTimestamp=" + C() + ", locationDebug=" + t() + ", cellInfoDebug=" + c() + ", isMeasurementsStopped=" + q() + ", isBackgroundMeasurementEnabled=" + o() + ", isCallEnded=" + p() + ", isOnCall=" + r() + ", isRinging=" + s() + ", fileTransferAccessTechs=" + l() + ", cdnDownloadAccessTechs=" + b() + ")";
    }

    public String u() {
        return this.c;
    }

    public String v() {
        return this.d;
    }

    public String w() {
        return this.f;
    }

    public long x() {
        return this.j;
    }

    public double y() {
        return this.t;
    }

    public String z() {
        return this.k;
    }
}
