package com.teragence.library;

import java.util.Arrays;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class p7 implements y5 {
    private final UUID a;
    private final l5[] b;
    private final int c;
    private final x5 d;
    private final u5 e;
    private final UUID f;
    private final String g;
    private final q5 h;
    private final f6 i;

    public p7(UUID uuid, l5[] l5VarArr, int i2, x5 x5Var, u5 u5Var, UUID uuid2, String str, q5 q5Var, f6 f6Var) {
        this.a = uuid;
        this.b = l5VarArr;
        this.c = i2;
        this.d = x5Var;
        this.e = u5Var;
        this.f = uuid2;
        this.g = str;
        this.h = q5Var;
        this.i = f6Var;
    }

    public f6 a() {
        return this.i;
    }

    public String b() {
        return this.g;
    }

    public UUID c() {
        return this.f;
    }

    public x5 d() {
        return this.d;
    }

    public u5 e() {
        return this.e;
    }

    public q5 f() {
        return this.h;
    }

    public UUID h() {
        return this.a;
    }

    public int i() {
        return this.c;
    }

    public l5[] j() {
        return this.b;
    }

    public String toString() {
        return "ReceivedBurstRequest{burstId=" + this.a + ", datagrams=" + Arrays.toString(this.b) + ", initialDelay=" + this.c + ", networkStatus=" + this.d + ", locationStatus=" + this.e + ", testId=" + this.f + ", ownerKey='" + this.g + "', deviceInfo=" + this.h + ", simOperatorInfo=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }
}
