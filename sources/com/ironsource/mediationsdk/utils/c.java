package com.ironsource.mediationsdk.utils;

import java.util.ArrayList;

public final class c {
    public boolean a;
    public String b;
    public int c;
    public int d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public boolean j;
    public ArrayList<String> k;
    public boolean l;
    public boolean m;
    public int n;
    public boolean o;
    private boolean p;
    private String q;
    private String r;
    private long s;

    public c() {
        this.b = "";
        this.q = "";
        this.r = "";
        this.p = false;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.s = 0;
        this.j = true;
        this.k = new ArrayList<>();
        this.e = 0;
        this.l = false;
        this.m = false;
        this.n = 1;
    }

    c(String str, String str2, String str3, int i2, int i3, long j2, boolean z, long j3, long j4, long j5, long j6, boolean z2, int i4, boolean z3, boolean z4, boolean z5, int i5, boolean z6) {
        this.b = str;
        this.q = str2;
        this.r = str3;
        this.c = i2;
        this.d = i3;
        this.f = j2;
        this.p = z;
        this.a = z5;
        this.g = j3;
        this.h = j4;
        this.i = j5;
        this.s = j6;
        this.j = z2;
        this.e = i4;
        this.k = new ArrayList<>();
        this.l = z3;
        this.m = z4;
        this.n = i5;
        this.o = z6;
    }

    public final String a(boolean z) {
        return z ? this.r : this.q;
    }
}
