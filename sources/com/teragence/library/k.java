package com.teragence.library;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class k implements i {
    private final t5 a;
    private final long b;

    public k(t5 t5Var, long j) {
        this.a = t5Var;
        this.b = j;
    }

    public int a() {
        return this.a.a();
    }

    public boolean b() {
        return System.currentTimeMillis() - this.b > ((long) this.a.a()) || System.currentTimeMillis() < this.b;
    }

    public UUID c() {
        return this.a.c();
    }

    public long d() {
        return (long) this.a.d();
    }

    public InetAddress e() {
        try {
            return InetAddress.getByName(this.a.e());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public int f() {
        return this.a.f();
    }

    public int g() {
        return this.a.g();
    }

    public int h() {
        return this.a.h();
    }

    public int i() {
        return this.a.i();
    }

    public int j() {
        return this.a.j();
    }

    public InetAddress k() {
        try {
            return InetAddress.getByName(this.a.k());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean l() {
        return this.a.l();
    }

    public int m() {
        return j() * i();
    }

    public long n() {
        return this.b;
    }

    public int o() {
        return j() * i() * 2;
    }

    public String toString() {
        return "TestConfigFromServerResponse{response=" + this.a + AbstractJsonLexerKt.END_OBJ;
    }
}
