package com.cellrebel.sdk.networking;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Handshake;

public class RequestEventListener extends EventListener {
    public int a;
    public int b;
    public int c;
    public int d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;
    private long j;

    private void a(String str) {
        long nanoTime = System.nanoTime();
        if (str.equals("callStart")) {
            this.e = nanoTime;
        }
        long j2 = nanoTime - this.e;
        if (str.equals("dnsStart")) {
            this.f = j2;
        }
        if (str.equals("dnsEnd")) {
            this.g = j2;
            double d2 = (double) (j2 - this.f);
            Double.isNaN(d2);
            this.a = (int) (d2 / 1000000.0d);
        }
        if (str.equals("connectStart")) {
            this.h = j2;
        }
        if (str.equals("secureConnectStart")) {
            this.i = j2;
            double d3 = (double) (j2 - this.h);
            Double.isNaN(d3);
            int i2 = (int) (d3 / 1000000.0d);
            this.b = i2;
            this.d = i2;
        }
        if (str.equals("secureConnectEnd")) {
            this.j = j2;
            double d4 = (double) (j2 - this.i);
            Double.isNaN(d4);
            this.c = (int) (d4 / 1000000.0d);
        }
    }

    public void callStart(Call call) {
        a("callStart");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        a("connectStart");
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        a("dnsEnd");
    }

    public void dnsStart(Call call, String str) {
        a("dnsStart");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        a("secureConnectEnd");
    }

    public void secureConnectStart(Call call) {
        a("secureConnectStart");
    }
}
