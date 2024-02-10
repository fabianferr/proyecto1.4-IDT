package com.umlaut.crowd.internal;

import java.net.InetAddress;

public class g2 {
    private long a;
    private InetAddress[] b = new InetAddress[0];
    private InetAddress[] c = new InetAddress[0];
    private tb d = tb.Unknown;
    private int e = 0;
    private String f = "";
    private String g = "";
    private boolean h = false;

    public String a() {
        return this.f;
    }

    public String b() {
        return this.g;
    }

    public String c() {
        return h() ? d()[0].getHostAddress() : "";
    }

    public InetAddress[] d() {
        return (InetAddress[]) q.a(this.c, this.b);
    }

    public int e() {
        return this.e;
    }

    public long f() {
        return this.a;
    }

    public tb g() {
        return this.d;
    }

    public boolean h() {
        return d().length > 0;
    }

    public boolean i() {
        return this.h;
    }

    public void a(long j) {
        this.a = j;
    }

    public void b(InetAddress[] inetAddressArr) {
        this.c = inetAddressArr;
    }

    public void a(InetAddress[] inetAddressArr) {
        this.b = inetAddressArr;
    }

    public void b(String str) {
        this.g = str;
    }

    public void a(tb tbVar) {
        this.d = tbVar;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(String str) {
        this.f = str;
    }

    public void a(boolean z) {
        this.h = z;
    }
}
