package com.startapp;

/* compiled from: Sta */
public class v8 {
    public final y2 a;
    public final y2 b;
    public final z2 c;
    public final da d;
    public final v9 e = new v9();
    public final z2 f;
    public final x g;
    public final u9 h;
    public final x i;
    public final s6 j;
    public final x k;
    public long l;
    public long m;

    public v8(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17) {
        double d18 = d2;
        double d19 = d3;
        y2 y2Var = new y2(new z2(d2), new z2(d2), new z2(d2));
        this.a = y2Var;
        this.b = new y2(new z2(d3), new z2(d3), new z2(d3));
        double d20 = d4;
        this.c = new z2(d4);
        double d21 = d6;
        double d22 = d7;
        this.d = new da(new ea(d21, d22, y2Var.b()), new ea(d21, d22, y2Var.c()), new ea(d21, d22, y2Var.d()));
        this.f = new z2(d5);
        double d23 = d13;
        double d24 = d14;
        double d25 = d15;
        double d26 = d16;
        double d27 = d17;
        this.g = new x(d23, d24, d25, d26, d27);
        this.h = new u9();
        this.i = new x(d23, d24, d25, d26, d27);
        this.j = new s6(5.0d, false);
        this.k = new x(d8, d9, d10, d11, d12);
    }

    public void a(double d2, long j2) {
        this.k.g = Math.min(Math.max(0.0d, d2), 1.0d);
        this.k.h = j2;
    }

    public void a(long j2, long j3, double d2, double d3, double d4) {
        double d5;
        double d6;
        double d7;
        double d8;
        double exp;
        long j4 = j2;
        long j5 = j3;
        double d9 = d2;
        double d10 = d3;
        double d11 = d4;
        if (this.m < j5) {
            if (this.l <= 0) {
                this.l = j5;
            }
            y2 y2Var = this.a;
            double d12 = y2Var.a.c;
            double d13 = y2Var.b.c;
            double d14 = y2Var.c.c;
            double d15 = d11;
            y2Var.a(d2, d3, d4);
            y2 y2Var2 = this.a;
            double d16 = y2Var2.a.c - d12;
            double d17 = y2Var2.b.c - d13;
            double d18 = y2Var2.c.c - d14;
            double d19 = d18 * d18;
            double d20 = d19 + (d17 * d17) + (d16 * d16);
            this.g.a(j4, l9.a(d20, 1.5d, 4.0d));
            this.i.a(j4, l9.a(d20, 0.01d, 1000.0d));
            y2 y2Var3 = this.b;
            y2 y2Var4 = this.a;
            y2Var3.a(d9 - y2Var4.a.c, d10 - y2Var4.b.c, d15 - y2Var4.c.c);
            this.c.a(this.b.d);
            da daVar = this.d;
            double d21 = d15;
            long j6 = j3;
            daVar.a.a(j6, d9);
            daVar.b.a(j6, d10);
            daVar.c.a(j6, d21);
            ea eaVar = daVar.a;
            double d22 = eaVar.q;
            ea eaVar2 = daVar.b;
            double d23 = eaVar2.q;
            ea eaVar3 = daVar.c;
            double d24 = eaVar3.q;
            double d25 = d22 + d23 + d24;
            double d26 = 1.0d - this.g.i;
            if (d25 > 0.0d) {
                daVar.d = ((eaVar.p * d22) / d25) + ((eaVar2.p * d23) / d25) + ((eaVar3.p * d24) / d25);
                daVar.e = d25 / 3.0d;
            } else {
                daVar.d = 0.0d;
                daVar.e = 0.0d;
            }
            double d27 = (double) (j6 - this.l);
            Double.isNaN(d27);
            double a2 = l9.a(d27 / 1.0E9d, 10.0d, 1.0d);
            v9 v9Var = this.e;
            da daVar2 = this.d;
            double d28 = daVar2.d;
            double d29 = daVar2.e;
            double d30 = this.c.c;
            v9Var.a = (Math.min(Math.exp((-Math.pow(d28 - 7.0d, 2.0d)) / 1.0d) * 2.0d, 1.0d) * 1.0d) + (v9Var.a * 0.0d);
            double d31 = v9Var.b * 0.0d;
            if (d29 < 0.0d) {
                d6 = 1.0d;
                d5 = 0.0d;
            } else {
                if (d29 < 0.5d) {
                    d5 = Math.pow(d29 * 2.0d, 4.0d);
                } else if (d29 > 2.0d) {
                    d5 = Math.exp((2.0d - d29) * 6.0d);
                } else {
                    d6 = 1.0d;
                    d5 = 1.0d;
                }
                d6 = 1.0d;
            }
            v9Var.b = (d5 * d6) + d31;
            double d32 = v9Var.c * 0.0d;
            if (d30 < 0.0d) {
                d8 = 1.0d;
                d7 = 0.0d;
            } else {
                if (d30 < 0.5d) {
                    exp = Math.pow(d30 * 2.0d, 4.0d);
                } else if (d30 > 5.0d) {
                    exp = Math.exp((5.0d - d30) * 4.0d);
                } else {
                    d8 = 1.0d;
                    d7 = 1.0d;
                }
                d7 = exp;
                d8 = 1.0d;
            }
            double d33 = (d7 * d8) + d32;
            v9Var.c = d33;
            double d34 = (d33 * 100.0d) / 270.0d;
            v9Var.d = d34 + ((v9Var.b * 70.0d) / 270.0d) + ((v9Var.a * 100.0d) / 270.0d);
            this.f.a(a2 * d26 * this.e.d);
            double d35 = this.f.c;
            u9 u9Var = this.h;
            da daVar3 = this.d;
            double d36 = daVar3.d;
            double d37 = daVar3.e;
            this.j.getClass();
            this.j.getClass();
            u9Var.a = (d36 * 0.050000000000000044d) + (u9Var.a * 0.95d);
            u9Var.b = (d37 * 0.050000000000000044d) + (u9Var.b * 0.95d);
            u9Var.c = (Math.abs(0.0d) * 0.0050000000000000044d) + (u9Var.c * 0.995d);
            u9Var.d = (Math.abs(0.0d) * 0.0050000000000000044d) + (u9Var.d * 0.995d);
            u9Var.e = ((((l9.a(u9Var.d, 0.4d, 5.0d, u9.i) * 1000.0d) / 5000.0d) + ((l9.a(u9Var.c, 0.2d, 6.0d, u9.h) * 1000.0d) / 5000.0d) + ((l9.a(u9Var.b, 0.2d, 20.0d, u9.g) * 1000.0d) / 5000.0d) + ((l9.a(u9Var.a, 8.0d, 2.0d, u9.f) * 2000.0d) / 5000.0d)) * 4.999999999999449E-4d) + (u9Var.e * 0.9995d);
            x xVar = this.k;
            double d38 = this.i.i;
            double d39 = (1.0d - d38) * a2 * this.h.e;
            xVar.a(j2, d39 + (d35 * d38));
            this.m = j3;
        }
    }
}
