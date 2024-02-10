package com.startapp;

/* compiled from: Sta */
public class y2 implements s9 {
    public final z2 a;
    public final z2 b;
    public final z2 c;
    public double d;

    public y2(z2 z2Var, z2 z2Var2, z2 z2Var3) {
        this.a = z2Var;
        this.b = z2Var2;
        this.c = z2Var3;
    }

    public void a(double d2, double d3, double d4) {
        this.a.a(d2);
        this.b.a(d3);
        this.c.a(d4);
        double d5 = this.a.c;
        double d6 = this.b.c;
        double d7 = (d6 * d6) + (d5 * d5);
        double d8 = this.c.c;
        this.d = Math.sqrt((d8 * d8) + d7);
    }

    public z2 b() {
        return this.a;
    }

    public z2 c() {
        return this.b;
    }

    public z2 d() {
        return this.c;
    }

    public double a() {
        return this.d;
    }
}
