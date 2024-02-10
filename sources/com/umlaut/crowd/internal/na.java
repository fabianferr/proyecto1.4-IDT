package com.umlaut.crowd.internal;

public abstract class na implements sa {
    public a controlEncryption = a.NONE;
    public ka customServer;
    public b dataEncryption = b.NONE;
    public String password = "example@example.com";
    public int reportingInterval = 200;
    public m9 sign;
    public wa testserver;
    public String username = "anonymous";
    public String uuid;

    public enum a {
        NONE,
        EXPLICIT,
        IMPLICIT
    }

    public enum b {
        NONE,
        PRIVATE
    }

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
        return this.testserver;
    }

    public void a(wa waVar) {
        this.testserver = waVar;
    }

    public void a(String str) {
        this.uuid = str;
    }
}
