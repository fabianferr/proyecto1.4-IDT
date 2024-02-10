package com.teragence.library;

public class k7 implements s5 {
    private final int a;
    private final long b;
    private final w5 c;
    private final String d;
    private final f6 e;
    private final String f;

    public k7(int i, long j, w5 w5Var, String str, f6 f6Var, String str2) {
        this.a = i;
        this.b = j;
        this.c = w5Var;
        this.d = str;
        this.e = f6Var;
        this.f = str2;
    }

    public f6 a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }

    public int c() {
        return this.a;
    }

    public w5 d() {
        return this.c;
    }

    public long e() {
        return this.b;
    }

    public String f() {
        return this.d;
    }

    public String toString() {
        return "GetTestConfigRequest{apiLevel=" + this.a + ", deviceId=" + this.b + ", networkInfo=" + this.c + ", operatingSystem='" + this.d + "', simOperatorInfo=" + this.e + ", serviceVersion='" + this.f + "'}";
    }
}
