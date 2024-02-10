package com.teragence.library;

public class h1 implements f1 {
    private final f1 a;

    public h1(f1 f1Var) {
        this.a = f1Var;
    }

    public double a() {
        double a2 = this.a.a();
        if (String.valueOf(a2).equals("NaN")) {
            return 0.0d;
        }
        return a2;
    }

    public double b() {
        double b = this.a.b();
        if (String.valueOf(b).equals("NaN")) {
            return 0.0d;
        }
        return b;
    }
}
