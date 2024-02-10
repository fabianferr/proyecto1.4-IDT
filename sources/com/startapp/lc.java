package com.startapp;

import com.startapp.ob;

/* compiled from: Sta */
public class lc implements ob.a, zb {
    public static lc f;
    public float a = 0.0f;
    public final ic b;
    public final ub c;
    public dc d;
    public db e;

    public lc(ic icVar, ub ubVar) {
        this.b = icVar;
        this.c = ubVar;
    }

    public static lc a() {
        if (f == null) {
            f = new lc(new ic(), new ub());
        }
        return f;
    }
}
