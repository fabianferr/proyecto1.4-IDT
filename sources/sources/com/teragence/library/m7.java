package com.teragence.library;

import java.util.Date;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class m7 implements v5 {
    private final long b;
    private final String c;
    private final w5 d;
    private final String e;
    private final Date f;
    private final UUID g;

    public m7(long j, String str, w5 w5Var, String str2, Date date, UUID uuid) {
        this.b = j;
        this.c = str;
        this.d = w5Var;
        this.e = str2;
        this.f = date;
        this.g = uuid;
    }

    public Date a() {
        return this.f;
    }

    public String b() {
        return this.c;
    }

    public UUID c() {
        return this.g;
    }

    public w5 d() {
        return this.d;
    }

    public long e() {
        return this.b;
    }

    public String f() {
        return this.e;
    }

    public String toString() {
        return "LogErrorRequest{deviceId=" + this.b + ", ownerKey='" + this.c + "', networkInfo=" + this.d + ", errorMessage='" + this.e + "', dateOccuredUtc=" + this.f + ", testId=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }
}
