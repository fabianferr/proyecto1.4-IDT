package com.teragence.library;

import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class q7 implements z5 {
    private final String a;
    private final UUID b;
    private final p5 c;
    private final w5 d;
    private final f6 e;

    public q7(String str, UUID uuid, p5 p5Var, w5 w5Var, f6 f6Var) {
        this.a = str;
        this.b = uuid;
        this.c = p5Var;
        this.d = w5Var;
        this.e = f6Var;
    }

    public f6 a() {
        return this.e;
    }

    public UUID b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public w5 d() {
        return this.d;
    }

    public p5 f() {
        return this.c;
    }

    public String toString() {
        return "RegisterDeviceRequest{product='" + this.a + "', deviceInfo=" + this.c + ", networkInfo=" + this.d + ", simOperatorInfo=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
