package com.umlaut.crowd.internal;

public class jb implements sa {
    public int maxHops = 30;
    public int queries = 3;
    public wa server;
    public m9 sign;
    public int timeout = -1;
    public int timeoutPerProbe = 5000;
    public String uuid;

    public void a(m9 m9Var) {
        this.sign = m9Var;
    }

    public String b() {
        return this.uuid;
    }

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

    public ja a() {
        return ja.TEST_TRACEROUTE;
    }
}
