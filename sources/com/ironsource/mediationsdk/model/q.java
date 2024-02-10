package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.c;
import com.ironsource.sdk.controller.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class q {
    public ArrayList<Placement> a;
    public x b;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public int g;
    public boolean h;
    public long i;
    public boolean j;
    public boolean k;
    public Placement l;
    public c m;
    private int n;

    public q() {
        this.a = new ArrayList<>();
        this.b = new x();
    }

    public q(int i2, boolean z, int i3, int i4, int i5, x xVar, c cVar, int i6, boolean z2, long j2, boolean z3, boolean z4) {
        this.a = new ArrayList<>();
        this.c = i2;
        this.d = z;
        this.e = i3;
        this.n = i4;
        this.b = xVar;
        this.f = i5;
        this.m = cVar;
        this.g = i6;
        this.h = z2;
        this.i = j2;
        this.j = z3;
        this.k = z4;
    }

    public final Placement a() {
        Iterator<Placement> it = this.a.iterator();
        while (it.hasNext()) {
            Placement next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.l;
    }
}
