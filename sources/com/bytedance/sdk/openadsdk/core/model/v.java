package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.utils.ab;

/* compiled from: TTAppOpenAdReportModel */
public class v {
    public boolean a;
    public long b;
    private ab c = ab.b();
    private ab d = ab.b();
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;
    private int k;

    public void a(ab abVar, ab abVar2, int i2, ab abVar3) {
        this.e = abVar.a(this.c);
        this.f = abVar2.a(abVar);
        this.g = (long) i2;
        this.h = abVar3.a(abVar2);
    }

    public void a(ab abVar) {
        this.c = abVar;
    }

    public void b(ab abVar) {
        this.d = abVar;
        this.i = abVar.a(this.c);
    }

    public ab a() {
        return this.c;
    }

    public long b() {
        return this.e;
    }

    public long c() {
        return this.f;
    }

    public long d() {
        return this.g;
    }

    public long e() {
        return this.h;
    }

    public long f() {
        return this.i;
    }

    public long g() {
        return this.j;
    }

    public void a(long j2) {
        this.j = j2;
    }

    public int h() {
        return this.k;
    }

    public void a(int i2) {
        this.k = i2;
    }
}
