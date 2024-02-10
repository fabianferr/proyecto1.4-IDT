package com.teragence.library;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class b implements d {
    private final a6 a;
    private final long b;

    public b(a6 a6Var, long j) {
        this.a = a6Var;
        this.b = j;
    }

    public long a() {
        return this.a.a();
    }

    public boolean b() {
        return c.a(this);
    }

    public long c() {
        return this.a.e();
    }

    public long d() {
        return this.b;
    }

    public String toString() {
        return "DeviceFromGdprServerResponse{deviceResponse=" + this.a + ", registeredTimeMillis=" + this.b + AbstractJsonLexerKt.END_OBJ;
    }
}
