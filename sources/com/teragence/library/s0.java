package com.teragence.library;

public class s0 implements t0 {
    private final t0 a;
    private Boolean b;

    public s0(t0 t0Var) {
        this.a = t0Var;
    }

    public boolean a() {
        if (this.b == null) {
            this.b = Boolean.valueOf(this.a.a());
        }
        return this.b.booleanValue();
    }
}
