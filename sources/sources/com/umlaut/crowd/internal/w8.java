package com.umlaut.crowd.internal;

import javax.net.ssl.SSLContext;

public class w8 {
    private SSLContext a;
    private boolean b = true;
    private boolean c = false;
    private boolean d = false;
    private boolean e = false;

    public SSLContext a() {
        return this.a;
    }

    public void b(boolean z) {
        if (!this.e) {
            this.b = z;
        }
    }

    public boolean c() {
        return this.b;
    }

    public boolean d() {
        return this.c;
    }

    public void e() {
        this.e = true;
    }

    public void a(SSLContext sSLContext) {
        if (!this.e) {
            this.a = sSLContext;
        }
    }

    public void c(boolean z) {
        if (!this.e) {
            this.c = z;
        }
    }

    public boolean b() {
        return this.d;
    }

    public void a(boolean z) {
        if (!this.e) {
            this.d = z;
        }
    }
}
