package com.m2catalyst.m2sdk;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataUsageState.kt */
public final class z3 {
    public final v6 a;
    public y3 b;
    public y3 c;
    public long d = v6.b();
    public long e = v6.a();
    public long f = v6.d();
    public long g = v6.c();
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();

    public z3(v6 v6Var) {
        Intrinsics.checkNotNullParameter(v6Var, "trafficStatsWrapper");
        this.a = v6Var;
        v6Var.getClass();
    }

    public static y3 a(z3 z3Var) {
        z3Var.getClass();
        try {
            z3Var.a();
            y3 y3Var = new y3(0, 0, 0);
            ArrayList arrayList = z3Var.h;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (((y3) next).a == 0) {
                    arrayList2.add(next);
                }
            }
            for (y3 y3Var2 : CollectionsKt.toMutableList(arrayList2)) {
                y3Var.c += y3Var2.c;
                y3Var.b += y3Var2.b;
            }
            z3Var.h.clear();
            return y3Var;
        } catch (Exception unused) {
            return new y3(0, 0, 0);
        }
    }

    public final void b() {
        this.a.getClass();
        long d2 = v6.d();
        this.a.getClass();
        long c2 = v6.c();
        long j = this.f;
        long j2 = this.g;
        y3 y3Var = new y3(1, d2 - j, c2 - j2);
        if ((j2 == 0 || j == 0) && c2 > 0 && d2 > 0) {
            this.g = c2;
            this.f = d2;
        } else if (c2 < 0 || d2 < 0) {
            this.g = 0;
            this.f = 0;
        } else {
            long j3 = y3Var.b;
            if (j3 < 0 || y3Var.c < 0) {
                this.c = y3Var;
                this.g = c2;
                this.f = d2;
                return;
            }
            y3 y3Var2 = this.c;
            if (y3Var2 != null && j3 > Math.abs(y3Var2.b) && y3Var.c > Math.abs(y3Var2.c)) {
                y3Var.b += y3Var2.b;
                y3Var.c += y3Var2.c;
                this.c = null;
            }
            this.i.add(y3Var);
            this.f = d2;
            this.g = c2;
        }
    }

    public final void a() {
        this.a.getClass();
        long b2 = v6.b();
        this.a.getClass();
        long a2 = v6.a();
        long j = this.d;
        long j2 = this.e;
        y3 y3Var = new y3(0, b2 - j, a2 - j2);
        if ((j2 == 0 || j == 0) && a2 > 0 && b2 > 0) {
            this.e = a2;
            this.d = b2;
        } else if (a2 < 0 || b2 < 0) {
            this.e = 0;
            this.d = 0;
        } else {
            long j3 = y3Var.b;
            if (j3 < 0 || y3Var.c < 0) {
                this.b = y3Var;
                this.e = a2;
                this.d = b2;
                return;
            }
            y3 y3Var2 = this.b;
            if (y3Var2 != null && j3 > Math.abs(y3Var2.b) && y3Var.c > Math.abs(y3Var2.c)) {
                y3Var.b += y3Var2.b;
                y3Var.c += y3Var2.c;
                this.b = null;
            }
            this.h.add(y3Var);
            this.d = b2;
            this.e = a2;
        }
    }
}
