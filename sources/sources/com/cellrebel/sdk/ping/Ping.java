package com.cellrebel.sdk.ping;

import java.net.InetAddress;

public class Ping {
    private String a = null;
    private InetAddress b;
    private final PingOptions c = new PingOptions();
    private int d = 0;
    private int e = 1;
    private boolean f = false;

    public interface PingListener {
    }

    private Ping() {
    }

    public static Ping a(InetAddress inetAddress) {
        Ping ping = new Ping();
        ping.b(inetAddress);
        return ping;
    }

    private void b() {
        String str;
        if (this.b == null && (str = this.a) != null) {
            this.b = InetAddress.getByName(str);
        }
    }

    private void b(InetAddress inetAddress) {
        this.b = inetAddress;
    }

    public Ping a(int i) {
        if (i >= 0) {
            this.c.a(i);
            return this;
        }
        throw new IllegalArgumentException("Times cannot be less than 0");
    }

    public PingResult a() {
        this.f = false;
        b();
        return PingTools.b(this.b, this.c);
    }
}
