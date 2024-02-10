package com.umlaut.crowd.internal;

import org.java_websocket.WebSocketImpl;

public abstract class kb implements sa {
    public int initRetries = 100;
    public int initRetryTimeout = 100;
    public xc pkgDown = new xc();
    public xc pkgUp = new xc();
    public wa server;
    public int serverPort = WebSocketImpl.DEFAULT_WSS_PORT;
    public m9 sign;
    public int timeout = 5000;
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
}
