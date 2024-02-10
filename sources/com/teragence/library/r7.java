package com.teragence.library;

import java.util.Arrays;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class r7 implements b6 {
    private final UUID a;
    private final m5[] b;
    private final int c;
    private final x5 d;
    private final u5 e;
    private final String f;
    private final int g;
    private final UUID h;
    private final q5 i;
    private final f6 j;

    public r7(UUID uuid, m5[] m5VarArr, int i2, x5 x5Var, u5 u5Var, String str, int i3, UUID uuid2, q5 q5Var, f6 f6Var) {
        this.a = uuid;
        this.b = m5VarArr;
        this.c = i2;
        this.d = x5Var;
        this.e = u5Var;
        this.f = str;
        this.g = i3;
        this.h = uuid2;
        this.i = q5Var;
        this.j = f6Var;
    }

    public f6 a() {
        return this.j;
    }

    public String b() {
        return this.f;
    }

    public UUID c() {
        return this.h;
    }

    public x5 d() {
        return this.d;
    }

    public u5 e() {
        return this.e;
    }

    public q5 f() {
        return this.i;
    }

    public m5[] g() {
        return this.b;
    }

    public UUID h() {
        return this.a;
    }

    public int i() {
        return this.c;
    }

    public int j() {
        return this.g;
    }

    public String toString() {
        return "ReportBurstRequest{burstId=" + this.a + ", extraData=" + Arrays.toString(this.b) + ", initialDelay=" + this.c + ", networkStatus=" + this.d + ", locationStatus=" + this.e + ", ownerKey='" + this.f + "', port=" + this.g + ", testId=" + this.h + ", deviceInfo=" + this.i + ", simOperatorInfo=" + this.j + AbstractJsonLexerKt.END_OBJ;
    }
}
