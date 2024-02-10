package com.teragence.library;

import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class t7 implements d6 {
    private final x5 a;
    private final u5 b;
    private final String c;
    private final int d;
    private final int e;
    private final int f;
    private final UUID g;
    private final q5 h;
    private final f6 i;

    public t7(x5 x5Var, u5 u5Var, String str, int i2, int i3, int i4, UUID uuid, q5 q5Var, f6 f6Var) {
        this.a = x5Var;
        this.b = u5Var;
        this.c = str;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = uuid;
        this.h = q5Var;
        this.i = f6Var;
    }

    public f6 a() {
        return this.i;
    }

    public String b() {
        return this.c;
    }

    public UUID c() {
        return this.g;
    }

    public x5 d() {
        return this.a;
    }

    public u5 e() {
        return this.b;
    }

    public q5 f() {
        return this.h;
    }

    public int g() {
        return this.d;
    }

    public int h() {
        return this.f;
    }

    public int i() {
        return this.e;
    }

    public String toString() {
        return "ReportDownloadRequest{networkStatus=" + this.a + ", locationStatus=" + this.b + ", ownerKey='" + this.c + "', size=" + this.d + ", timeToBody=" + this.e + ", timeToComplete=" + this.f + ", testId=" + this.g + ", deviceInfo=" + this.h + ", simOperatorInfo=" + this.i + AbstractJsonLexerKt.END_OBJ;
    }
}
