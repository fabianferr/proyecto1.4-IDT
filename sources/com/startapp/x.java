package com.startapp;

/* compiled from: Sta */
public class x implements s9 {
    public final double a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;
    public double g;
    public long h;
    public double i;

    public x(double d2, double d3, double d4, double d5, double d6) {
        double d7 = d2 + d3;
        this.a = d2 / d7;
        this.b = d3 / d7;
        this.c = d4;
        this.d = d5;
        this.e = d6;
        this.f = l9.a(0.0d, d5, d6);
    }

    public static double a(long j, long j2, double d2, double d3, double d4, double d5) {
        double max = (double) Math.max(0, j - j2);
        Double.isNaN(max);
        double d6 = max / d2;
        if (d4 > 0.0d) {
            return l9.a(d6, d3, d4, d5);
        }
        if (d4 < 0.0d) {
            return l9.a(d6, d3, d4) / d5;
        }
        return l9.a(d6, d3, d4);
    }

    public void a(long j, double d2) {
        double a2 = this.g * a(j, this.h, this.c, this.d, this.e, this.f);
        double d3 = (this.b * d2) + (this.a * a2);
        this.i = d3;
        if (a2 < d3) {
            this.g = d3;
            this.h = j;
        }
    }

    public double a() {
        return this.i;
    }
}
