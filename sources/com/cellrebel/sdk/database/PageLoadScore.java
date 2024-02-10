package com.cellrebel.sdk.database;

public class PageLoadScore {
    public long a;
    public long b;
    public double c;
    public double d;
    public double e;

    public long a() {
        return this.a;
    }

    public PageLoadScore a(double d2) {
        this.d = d2;
        return this;
    }

    public PageLoadScore a(long j) {
        this.b = j;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        return obj instanceof PageLoadScore;
    }

    public double b() {
        return this.d;
    }

    public PageLoadScore b(double d2) {
        this.e = d2;
        return this;
    }

    public double c() {
        return this.e;
    }

    public PageLoadScore c(double d2) {
        this.c = d2;
        return this;
    }

    public double d() {
        return this.c;
    }

    public long e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PageLoadScore)) {
            return false;
        }
        PageLoadScore pageLoadScore = (PageLoadScore) obj;
        return pageLoadScore.a((Object) this) && a() == pageLoadScore.a() && e() == pageLoadScore.e() && Double.compare(d(), pageLoadScore.d()) == 0 && Double.compare(b(), pageLoadScore.b()) == 0 && Double.compare(c(), pageLoadScore.c()) == 0;
    }

    public int hashCode() {
        long a2 = a();
        long e2 = e();
        long doubleToLongBits = Double.doubleToLongBits(d());
        long doubleToLongBits2 = Double.doubleToLongBits(b());
        long doubleToLongBits3 = Double.doubleToLongBits(c());
        return ((((((((((int) (a2 ^ (a2 >>> 32))) + 59) * 59) + ((int) (e2 ^ (e2 >>> 32)))) * 59) + ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32)))) * 59) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 59) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)));
    }

    public String toString() {
        return "PageLoadScore(id=" + a() + ", timestamp=" + e() + ", score=" + d() + ", latitude=" + b() + ", longitude=" + c() + ")";
    }
}
