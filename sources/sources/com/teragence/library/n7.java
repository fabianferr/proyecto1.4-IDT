package com.teragence.library;

public class n7 implements w5 {
    private final String CC;
    private final String MCCMNC;
    private final String networkType;
    private final String operator;

    public n7(String str, String str2, String str3, String str4) {
        this.CC = str;
        this.MCCMNC = str2;
        this.operator = str3;
        this.networkType = str4;
    }

    public String a() {
        return this.operator;
    }

    public String b() {
        return this.networkType;
    }

    public String c() {
        return this.MCCMNC;
    }

    public String d() {
        return this.CC;
    }

    public String toString() {
        return "NetworkInfo{CC='" + this.CC + "', MCCMNC='" + this.MCCMNC + "', operator='" + this.operator + "', networkType='" + this.networkType + "'}";
    }
}
