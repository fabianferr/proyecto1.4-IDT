package com.teragence.library;

import java.util.Arrays;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class l3 implements i3 {
    private final String a;
    private final long b;
    private final i c;
    private final boolean d;
    private final boolean e;
    private final u5 f;
    private final x5 g;
    private final q5 h;
    private final f6 i;
    private final m5[] j;

    public l3(String str, long j2, i iVar, boolean z, boolean z2, u5 u5Var, x5 x5Var, q5 q5Var, f6 f6Var, m5[] m5VarArr) {
        this.a = str;
        this.b = j2;
        this.c = iVar;
        this.d = z;
        this.e = z2;
        this.f = u5Var;
        this.g = x5Var;
        this.h = q5Var;
        this.i = f6Var;
        this.j = m5VarArr;
    }

    public f6 a() {
        return this.i;
    }

    public String b() {
        return this.a;
    }

    public x5 d() {
        return this.g;
    }

    public u5 e() {
        return this.f;
    }

    public m5[] g() {
        return this.j;
    }

    public boolean h() {
        return this.d;
    }

    public q5 i() {
        return this.h;
    }

    public boolean j() {
        return this.e;
    }

    public long k() {
        return this.b;
    }

    public i l() {
        return this.c;
    }

    public String toString() {
        return "TestData{ownerKey='" + this.a + "', registeredDeviceId=" + this.b + ", config=" + this.c + ", allowAnyConnection=" + this.d + ", doDownload=" + this.e + ", locationStatus=" + this.f + ", networkStatus=" + this.g + ", deviceInfoExtend=" + this.h + ", simOperatorInfo=" + this.i + ", extraData=" + Arrays.toString(this.j) + AbstractJsonLexerKt.END_OBJ;
    }
}
