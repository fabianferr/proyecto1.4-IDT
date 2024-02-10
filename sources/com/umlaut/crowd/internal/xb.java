package com.umlaut.crowd.internal;

public class xb extends Exception {
    private static final long b = 7483892021901156666L;
    private int a;

    public xb(int i, String str) {
        super("Error parsing Token at index " + i + ": " + str);
        this.a = i;
    }

    public int a() {
        return this.a;
    }
}
