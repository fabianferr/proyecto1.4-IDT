package com.umlaut.crowd.internal;

import com.umlaut.crowd.enums.NetworkGenerations;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

class d6 implements Serializable, Cloneable {
    private static final String t = "d6";
    private static final boolean u = false;
    private static final long v = -8914634301232962932L;
    public String a = "";
    public String b = "";
    ArrayList<p0> c = new ArrayList<>();
    ArrayList<p0> d = new ArrayList<>();
    ArrayList<p0> e = new ArrayList<>();
    ArrayList<p0> f = new ArrayList<>();
    ArrayList<p0> g = new ArrayList<>();
    long h = 0;
    long i = 0;
    long j = 0;
    long k = 0;
    long l = 0;
    long m = 0;
    long n = 0;
    long o = 0;
    long p = 0;
    long q = 0;
    long r = 0;
    long s = 0;

    public void a(long j2, long j3, NetworkGenerations networkGenerations, long j4, long j5, DRI dri, DWI dwi, q4 q4Var, ub ubVar, z zVar, n1 n1Var, e4 e4Var) {
        NetworkGenerations networkGenerations2 = networkGenerations;
        if (networkGenerations2 == NetworkGenerations.Gen5NSA) {
            this.p += j4;
            this.q += j5;
            if (j2 > 0 || j3 > 0) {
                this.f.add(new p0(j2, j3, dwi, dri, q4Var, ubVar, zVar, n1Var, e4Var));
            }
        } else if (networkGenerations2 == NetworkGenerations.Gen5SA) {
            this.r += j4;
            this.s += j5;
            if (j2 > 0 || j3 > 0) {
                this.g.add(new p0(j2, j3, dwi, dri, q4Var, ubVar, zVar, n1Var, e4Var));
            }
        } else if (networkGenerations2 == NetworkGenerations.Gen2) {
            this.j += j4;
            this.k += j5;
            if (j2 > 0 || j3 > 0) {
                this.c.add(new p0(j2, j3, dwi, dri, q4Var, ubVar, zVar, n1Var, e4Var));
            }
        } else if (networkGenerations2 == NetworkGenerations.Gen3) {
            this.l += j4;
            this.m += j5;
            if (j2 > 0 || j3 > 0) {
                this.d.add(new p0(j2, j3, dwi, dri, q4Var, ubVar, zVar, n1Var, e4Var));
            }
        } else if (networkGenerations2 == NetworkGenerations.Gen4) {
            this.n += j4;
            this.o += j5;
            if (j2 > 0 || j3 > 0) {
                this.e.add(new p0(j2, j3, dwi, dri, q4Var, ubVar, zVar, n1Var, e4Var));
            }
        }
        this.h += j4;
        this.i += j5;
    }

    /* access modifiers changed from: protected */
    public Object clone() throws CloneNotSupportedException {
        d6 d6Var = (d6) super.clone();
        d6Var.c = new ArrayList<>(this.c.size());
        Iterator<p0> it = this.c.iterator();
        while (it.hasNext()) {
            d6Var.c.add((p0) it.next().clone());
        }
        d6Var.d = new ArrayList<>(this.d.size());
        Iterator<p0> it2 = this.d.iterator();
        while (it2.hasNext()) {
            d6Var.d.add((p0) it2.next().clone());
        }
        d6Var.e = new ArrayList<>(this.e.size());
        Iterator<p0> it3 = this.e.iterator();
        while (it3.hasNext()) {
            d6Var.e.add((p0) it3.next().clone());
        }
        d6Var.f = new ArrayList<>(this.f.size());
        Iterator<p0> it4 = this.f.iterator();
        while (it4.hasNext()) {
            d6Var.f.add((p0) it4.next().clone());
        }
        d6Var.g = new ArrayList<>(this.g.size());
        Iterator<p0> it5 = this.g.iterator();
        while (it5.hasNext()) {
            d6Var.g.add((p0) it5.next().clone());
        }
        return d6Var;
    }
}
