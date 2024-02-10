package com.umlaut.crowd.internal;

public abstract class db implements sa {
    public long reportingInterval = 1000;
    public wa server;
    public m9 sign;
    public int testSockets = 3;
    public String uuid;

    public void a(m9 m9Var) {
        this.sign = m9Var;
    }

    public String b() {
        return this.uuid;
    }

    public abstract boolean c();

    public m9 d() {
        return this.sign;
    }

    public wa e() {
        return this.server;
    }

    public void a(wa waVar) {
        this.server = waVar;
    }

    public void a(String str) {
        this.uuid = str;
    }
}
