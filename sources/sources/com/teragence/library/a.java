package com.teragence.library;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class a implements d {
    private final long a;
    private final long b;
    private final long c;

    public a(long j, long j2, long j3) {
        this.a = j;
        this.b = j2;
        this.c = j3;
    }

    public long a() {
        return this.b;
    }

    public boolean b() {
        return c.a(this);
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.c;
    }

    public String toString() {
        return "Device{registeredId=" + this.a + ", maxAge=" + this.b + ", registeredTimeMillis=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }
}
