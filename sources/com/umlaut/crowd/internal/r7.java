package com.umlaut.crowd.internal;

public class r7 implements s5, j9 {
    public String[] ips;
    public String name;
    public boolean publicPool = true;
    public m9 sign;

    public void a(m9 m9Var) {
        this.sign = m9Var;
    }

    public v5 c() {
        return v5.MESSAGETYPE_ADDTESTSERVER;
    }

    public m9 d() {
        return this.sign;
    }
}
