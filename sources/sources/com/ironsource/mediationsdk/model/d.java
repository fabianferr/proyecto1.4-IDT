package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.c;
import com.ironsource.sdk.controller.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class d {
    public x a;
    public int b;
    public long c;
    public boolean d;
    public ArrayList<e> e;
    public e f;
    public int g;
    public int h;
    public c i;
    public boolean j;
    public boolean k;
    public long l;
    public boolean m;
    public boolean n;

    public d() {
        this.a = new x();
        this.e = new ArrayList<>();
    }

    public d(int i2, long j2, boolean z, x xVar, int i3, c cVar, int i4, boolean z2, boolean z3, long j3, boolean z4, boolean z5) {
        this.e = new ArrayList<>();
        this.b = i2;
        this.c = j2;
        this.d = z;
        this.a = xVar;
        this.g = i3;
        this.h = i4;
        this.i = cVar;
        this.j = z2;
        this.k = z3;
        this.l = j3;
        this.m = z4;
        this.n = z5;
    }

    public final e a() {
        Iterator<e> it = this.e.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.f;
    }

    public final e a(String str) {
        Iterator<e> it = this.e.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }
}
