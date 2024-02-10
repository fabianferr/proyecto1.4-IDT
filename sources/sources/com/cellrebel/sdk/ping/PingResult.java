package com.cellrebel.sdk.ping;

import java.net.InetAddress;

public class PingResult {
    public final InetAddress a;
    public boolean b;
    public String c = null;
    public float d;
    public String e;
    public String f;

    public PingResult(InetAddress inetAddress) {
        this.a = inetAddress;
    }

    public float a() {
        return this.d;
    }

    public String toString() {
        return "PingResult{ia=" + this.a + ", isReachable=" + this.b + ", error='" + this.c + "', timeTaken=" + this.d + ", fullString='" + this.e + "', result='" + this.f + "'}";
    }
}
