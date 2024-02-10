package com.startapp;

/* compiled from: Sta */
public class z2 implements s9 {
    public final double a;
    public final double b;
    public double c;

    public z2(double d) {
        double d2 = d + 1.0d;
        this.a = d / d2;
        this.b = 1.0d / d2;
    }

    public void a(double d) {
        this.c = (d * this.b) + (this.a * this.c);
    }

    public double a() {
        return this.c;
    }
}
