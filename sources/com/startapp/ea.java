package com.startapp;

/* compiled from: Sta */
public class ea {
    public final b a = new b();
    public final long b;
    public final double c;
    public final s9 d;
    public double e;
    public double f;
    public double g;
    public long h;
    public long i;
    public double j;
    public long k;
    public long l;
    public a m;
    public a n;
    public int o;
    public double p;
    public double q;
    public double r;

    /* compiled from: Sta */
    public static class a {
        public a a;
        public long b;
        public long c;
        public int d;
        public double e;
    }

    /* compiled from: Sta */
    public static class b {
        public a a;
    }

    public ea(double d2, double d3, s9 s9Var) {
        this.b = (long) (d2 * 1.0E9d);
        this.c = d3;
        this.d = s9Var;
    }

    public void a(long j2, double d2) {
        a aVar;
        this.e = this.f;
        this.f = this.g;
        this.g = d2;
        this.h = this.i;
        this.i = j2;
        long j3 = j2 - this.b;
        while (true) {
            a aVar2 = this.m;
            if (aVar2 == null || aVar2.b >= j3 || (aVar = aVar2.a) == null || aVar.b >= j3) {
                b bVar = this.a;
                a aVar3 = bVar.a;
            } else {
                this.m = aVar;
                this.o -= aVar2.d;
                this.r -= aVar2.e;
                b bVar2 = this.a;
                aVar2.a = bVar2.a;
                bVar2.a = aVar2;
            }
        }
        b bVar3 = this.a;
        a aVar32 = bVar3.a;
        if (aVar32 == null) {
            aVar32 = new a();
        } else {
            bVar3.a = aVar32.a;
            aVar32.a = null;
            aVar32.b = 0;
            aVar32.c = 0;
            aVar32.d = 0;
            aVar32.e = 0.0d;
        }
        aVar32.b = this.i;
        aVar32.c = this.l;
        double a2 = this.d.a();
        double d3 = this.e;
        double d4 = this.f;
        if (d3 < d4 && d4 > this.g) {
            double d5 = d4 - a2;
            if (d5 > this.c) {
                this.j = d5;
                this.k = this.h;
            }
        }
        if (d4 > a2 && a2 > this.g && this.k > this.l) {
            this.l = this.i;
            aVar32.d = 1;
            aVar32.e = this.j;
        }
        int i2 = this.o + aVar32.d;
        this.o = i2;
        double d6 = this.r + aVar32.e;
        this.r = d6;
        a aVar4 = this.n;
        if (aVar4 != null) {
            aVar4.a = aVar32;
        }
        this.n = aVar32;
        if (this.m == null) {
            this.m = aVar32;
        }
        long j4 = this.l - this.m.c;
        if (j4 > 0) {
            double d7 = (double) j4;
            Double.isNaN(d7);
            double d8 = (double) i2;
            Double.isNaN(d8);
            this.p = d8 / (d7 / 1.0E9d);
        }
        if (i2 > 0) {
            double d9 = (double) i2;
            Double.isNaN(d9);
            this.q = d6 / d9;
            return;
        }
        this.q = 0.0d;
    }
}
