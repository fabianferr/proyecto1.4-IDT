package com.umlaut.crowd.internal;

public class wb {
    private a a;
    private String b;
    private wb c;
    private wb d;
    private int e;
    private int f;

    public enum a {
        TOKEN_STRING,
        TOKEN_NUMBER,
        TOKEN_INTEGER,
        TOKEN_QUOTED_STRING,
        TOKEN_COMMA,
        TOKEN_BRACKET_OPEN,
        TOKEN_BRACKET_CLOSE,
        TOKEN_SQUAREBRACKET_OPEN,
        TOKEN_SQUAREBRACKET_CLOSE
    }

    wb(a aVar, String str, int i, int i2) {
        this.a = aVar;
        this.b = str;
        this.e = i;
        this.f = i2;
    }

    /* access modifiers changed from: package-private */
    public void a(wb wbVar) {
        this.d = wbVar;
    }

    /* access modifiers changed from: package-private */
    public void b(wb wbVar) {
        this.c = wbVar;
    }

    public int c() {
        if (this.a.equals(a.TOKEN_INTEGER)) {
            return Integer.parseInt(this.b);
        }
        throw new IllegalStateException("Only natural numbers can be transformed to Numbers, current Token: " + this.a);
    }

    public wb d() {
        return this.d;
    }

    public wb e() {
        return this.c;
    }

    public int f() {
        return this.e;
    }

    public a g() {
        return this.a;
    }

    public String h() {
        return this.b;
    }

    public double a() {
        if (this.a.equals(a.TOKEN_INTEGER) || this.a.equals(a.TOKEN_NUMBER)) {
            return Double.parseDouble(this.b);
        }
        throw new IllegalStateException("Only numbers can be transformed to Numbers, current Token: " + this.a);
    }

    public int b() {
        return this.f;
    }
}
