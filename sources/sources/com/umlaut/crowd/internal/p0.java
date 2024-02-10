package com.umlaut.crowd.internal;

import java.io.Serializable;

class p0 implements Serializable, Cloneable {
    private static final long j = -4587231491969966453L;
    long a;
    long b;
    DWI c;
    DRI d;
    q4 e;
    z f;
    n1 g;
    ub h;
    e4 i;

    p0() {
        this.c = new DWI();
        this.d = new DRI();
        this.e = new q4();
        this.h = new ub();
        this.f = new z();
        this.g = new n1();
        this.i = new e4();
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        p0 p0Var = (p0) super.clone();
        p0Var.c = (DWI) this.c.clone();
        p0Var.d = (DRI) this.d.clone();
        p0Var.e = (q4) this.e.clone();
        p0Var.h = (ub) this.h.clone();
        p0Var.f = (z) this.f.clone();
        p0Var.g = (n1) this.g.clone();
        p0Var.i = (e4) this.i.clone();
        return p0Var;
    }

    p0(long j2, long j3, DWI dwi, DRI dri, q4 q4Var, ub ubVar, z zVar, n1 n1Var, e4 e4Var) {
        this.a = j2;
        this.b = j3;
        this.c = dwi;
        this.d = dri;
        this.e = q4Var;
        this.h = ubVar;
        this.f = zVar;
        this.g = n1Var;
        this.i = e4Var;
    }
}
