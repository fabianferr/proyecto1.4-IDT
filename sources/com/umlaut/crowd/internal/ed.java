package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.yc;

public class ed {
    private long a;
    private long b;
    private long c;
    private long d = 0;
    private long e = 0;
    private yc.a f = new yc.a();

    public void a(wc wcVar, boolean z) {
        if (this.a == 0) {
            yc.a.a(wcVar, this.f);
            this.d = wcVar.a;
        } else {
            long j = wcVar.a;
            this.e = j;
            if (z) {
                yc.a aVar = this.f;
                if (aVar.b == wcVar.c - 1) {
                    this.b += Math.abs((j - aVar.a) - (wcVar.e - aVar.c));
                    this.c++;
                }
            }
        }
        yc.a.a(wcVar, this.f);
        this.a++;
    }

    public yc.a b() {
        return this.f;
    }

    public long c() {
        return this.e;
    }

    public long d() {
        return this.a;
    }

    public j7 e() {
        j7 j7Var = new j7();
        j7Var.jitterPkgCnt = this.c;
        j7Var.jitterSum = this.b;
        j7Var.pkgsReceived = this.a;
        j7Var.firstPkgTime = this.d;
        j7Var.lastPkgTime = this.e;
        return j7Var;
    }

    public long a() {
        return this.d;
    }
}
