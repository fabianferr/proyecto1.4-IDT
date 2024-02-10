package com.umlaut.crowd.internal;

import java.util.ArrayList;

public class r2 {
    private ArrayList<Long> a = new ArrayList<>();
    private long b = 0;
    private long c = Long.MAX_VALUE;
    private long d;
    private long e = 0;
    private boolean f;
    private final long g;
    private long h;

    public r2(long j) {
        this.g = j;
    }

    private void a(boolean z) {
        if (this.f) {
            while (true) {
                long j = this.h;
                long j2 = this.c;
                long j3 = j - j2;
                long j4 = this.g;
                if (j3 > j4 || (z && j3 == j4)) {
                    this.d = j2;
                    this.c = j2 + j4;
                    this.a.add(Long.valueOf(this.e - this.b));
                    this.b = this.e;
                } else {
                    return;
                }
            }
        }
    }

    public void b(long j) {
        this.a.clear();
        this.c = this.g + j;
        this.f = true;
        this.e = 0;
        this.b = 0;
        this.d = j;
    }

    public void c(long j) {
        this.h = j;
    }

    public int c() {
        a(false);
        return this.a.size() - 1;
    }

    public synchronized long b() {
        return this.e - this.b;
    }

    public synchronized void a(long j) {
        if (j >= 0) {
            if (!this.f || this.h - this.c <= 0) {
                this.e += j;
            } else {
                a(false);
                long j2 = this.c;
                long j3 = this.d;
                long j4 = j2 - j3;
                long j5 = this.h - j3;
                if (j5 == 0) {
                    j5 = 1;
                }
                long j6 = (j4 * j) / j5;
                if (j6 >= 0) {
                    this.a.add(Long.valueOf((this.e - this.b) + j6));
                    long j7 = this.e + j6;
                    this.b = j7;
                    this.e = j7 + (j - j6);
                    this.c += this.g;
                } else {
                    throw new RuntimeException("Number of bytes has to be positive(2)");
                }
            }
            this.d = this.h;
        } else {
            throw new RuntimeException("Number of bytes has to be positive: " + j);
        }
    }

    public synchronized long a(int i) {
        a(true);
        return this.a.get(i).longValue();
    }

    public synchronized long a() {
        return this.e;
    }
}
