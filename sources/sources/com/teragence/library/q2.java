package com.teragence.library;

public class q2 extends q8 {
    private r8 h;

    public q2(String str, int i) {
        super(str, i);
    }

    public r8 a() {
        r8 r8Var = this.h;
        if (r8Var != null) {
            return r8Var;
        }
        p2 p2Var = new p2(this.a, this.b, this.c);
        this.h = p2Var;
        return p2Var;
    }
}
