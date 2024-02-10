package com.teragence.library;

public class y0 implements Comparable<y0> {
    public int b;
    public int c;

    public y0(int i, int i2) {
        this.b = i;
        this.c = i2;
    }

    /* renamed from: a */
    public int compareTo(y0 y0Var) {
        return this.c - y0Var.c;
    }
}
