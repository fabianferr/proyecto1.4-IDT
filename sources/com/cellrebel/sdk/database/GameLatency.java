package com.cellrebel.sdk.database;

public class GameLatency {
    public long a;
    public long b;
    public String c;
    public String d;
    public Float e = Float.valueOf(0.0f);
    public double f;
    public double g;

    public String a() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        return obj instanceof GameLatency;
    }

    public long b() {
        return this.a;
    }

    public Float c() {
        return this.e;
    }

    public double d() {
        return this.f;
    }

    public double e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GameLatency)) {
            return false;
        }
        GameLatency gameLatency = (GameLatency) obj;
        if (!gameLatency.a(this) || b() != gameLatency.b() || g() != gameLatency.g()) {
            return false;
        }
        String a2 = a();
        String a3 = gameLatency.a();
        if (a2 != null ? !a2.equals(a3) : a3 != null) {
            return false;
        }
        String f2 = f();
        String f3 = gameLatency.f();
        if (f2 != null ? !f2.equals(f3) : f3 != null) {
            return false;
        }
        Float c2 = c();
        Float c3 = gameLatency.c();
        if (c2 != null ? c2.equals(c3) : c3 == null) {
            return Double.compare(d(), gameLatency.d()) == 0 && Double.compare(e(), gameLatency.e()) == 0;
        }
        return false;
    }

    public String f() {
        return this.d;
    }

    public long g() {
        return this.b;
    }

    public int hashCode() {
        long b2 = b();
        long g2 = g();
        int i = ((((int) (b2 ^ (b2 >>> 32))) + 59) * 59) + ((int) (g2 ^ (g2 >>> 32)));
        String a2 = a();
        int i2 = 43;
        int hashCode = (i * 59) + (a2 == null ? 43 : a2.hashCode());
        String f2 = f();
        int hashCode2 = (hashCode * 59) + (f2 == null ? 43 : f2.hashCode());
        Float c2 = c();
        int i3 = hashCode2 * 59;
        if (c2 != null) {
            i2 = c2.hashCode();
        }
        int i4 = i3 + i2;
        long doubleToLongBits = Double.doubleToLongBits(d());
        long doubleToLongBits2 = Double.doubleToLongBits(e());
        return (((i4 * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "GameLatency(id=" + b() + ", timestamp=" + g() + ", gameName=" + a() + ", serverName=" + f() + ", latency=" + c() + ", latitude=" + d() + ", longitude=" + e() + ")";
    }
}
