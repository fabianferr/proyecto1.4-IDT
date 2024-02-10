package com.teragence.library;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class j7 implements q5 {
    private final String a;
    private final String b;
    private final String c;
    private final int d;
    private final String e;
    private final String f;
    private final boolean g;

    public j7(String str, String str2, String str3, int i, String str4, String str5, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = str4;
        this.f = str5;
        this.g = z;
    }

    public boolean a() {
        return this.g;
    }

    public String b() {
        return this.e;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.f;
    }

    public String f() {
        return this.c;
    }

    public String g() {
        return this.b;
    }

    public String toString() {
        return "DeviceInfoExtend{manufacturer='" + this.a + "', model='" + this.b + "', operationSystem='" + this.c + "', apiLevel=" + this.d + ", serviceVersion='" + this.e + "', batteryLevel='" + this.f + "', screenOn=" + this.g + AbstractJsonLexerKt.END_OBJ;
    }
}
