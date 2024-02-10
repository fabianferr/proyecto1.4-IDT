package com.ironsource.mediationsdk.model;

import com.ironsource.mediationsdk.utils.c;
import com.ironsource.sdk.controller.x;
import java.util.ArrayList;
import java.util.Iterator;

public final class h {
    public ArrayList<InterstitialPlacement> a;
    public x b;
    public int c;
    public boolean d;
    public int e;
    public int f;
    public c g;
    public boolean h;
    public boolean i;
    public long j;
    public boolean k;
    public boolean l;
    public InterstitialPlacement m;

    public h() {
        this.a = new ArrayList<>();
        this.b = new x();
    }

    public h(int i2, boolean z, int i3, x xVar, c cVar, int i4, boolean z2, boolean z3, long j2, boolean z4, boolean z5) {
        this.a = new ArrayList<>();
        this.c = i2;
        this.d = z;
        this.e = i3;
        this.b = xVar;
        this.g = cVar;
        this.k = z4;
        this.l = z5;
        this.f = i4;
        this.h = z2;
        this.i = z3;
        this.j = j2;
    }

    public final InterstitialPlacement a() {
        Iterator<InterstitialPlacement> it = this.a.iterator();
        while (it.hasNext()) {
            InterstitialPlacement next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.m;
    }
}
