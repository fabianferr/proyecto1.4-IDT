package com.teragence.library;

public class i7 implements p5 {
    private final String a;
    private final String b;
    private final String c;
    private final int d;
    private final String e;

    public i7(String str, String str2, String str3, int i, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
        this.e = str4;
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

    public String f() {
        return this.c;
    }

    public String g() {
        return this.b;
    }

    public String toString() {
        return "DeviceInfo{manufacturer='" + this.a + "', model='" + this.b + "', operationSystem='" + this.c + "', apiLevel=" + this.d + ", serviceVersion='" + this.e + "'}";
    }
}
