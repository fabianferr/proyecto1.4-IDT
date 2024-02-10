package com.cellrebel.sdk.database;

public class VideoLoadScore {
    public long a;
    public long b;
    public double c;
    public double d;
    public double e;

    public long a() {
        return this.a;
    }

    public VideoLoadScore a(double d2) {
        this.d = d2;
        return this;
    }

    public VideoLoadScore a(long j) {
        this.b = j;
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean a(Object obj) {
        return obj instanceof VideoLoadScore;
    }

    public double b() {
        return this.d;
    }

    public VideoLoadScore b(double d2) {
        this.e = d2;
        return this;
    }

    public double c() {
        return this.e;
    }

    public VideoLoadScore c(double d2) {
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
        if (!(obj instanceof VideoLoadScore)) {
            return false;
        }
        VideoLoadScore videoLoadScore = (VideoLoadScore) obj;
        return videoLoadScore.a((Object) this) && a() == videoLoadScore.a() && e() == videoLoadScore.e() && Double.compare(d(), videoLoadScore.d()) == 0 && Double.compare(b(), videoLoadScore.b()) == 0 && Double.compare(c(), videoLoadScore.c()) == 0;
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
        return "VideoLoadScore(id=" + a() + ", timestamp=" + e() + ", score=" + d() + ", latitude=" + b() + ", longitude=" + c() + ")";
    }
}
