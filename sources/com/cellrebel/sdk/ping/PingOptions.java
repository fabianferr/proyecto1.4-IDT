package com.cellrebel.sdk.ping;

public class PingOptions {
    private int a = 1000;
    private int b = 128;

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.a = Math.max(i, 1000);
    }

    public int b() {
        return this.a;
    }
}
