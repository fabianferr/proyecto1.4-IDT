package com.teragence.library;

import java.util.Hashtable;

public class u6 implements h8 {
    public String a;
    public boolean b;
    public long c;
    public boolean d;
    public String e;
    public w6 f;
    public String g;
    public String h;

    public u6() {
    }

    public u6(String str, boolean z, long j, boolean z2, String str2, w6 w6Var, String str3, String str4) {
        this.a = str;
        this.b = z;
        this.c = j;
        this.d = z2;
        this.e = str2;
        this.f = w6Var;
        this.g = str3;
        this.h = str4;
    }

    public Object a(int i) {
        switch (i) {
            case 0:
                return this.a;
            case 1:
                return Boolean.valueOf(this.b);
            case 2:
                return Long.valueOf(this.c);
            case 3:
                return Boolean.valueOf(this.d);
            case 4:
                return this.e;
            case 5:
                return this.f;
            case 6:
                return this.g;
            case 7:
                return this.h;
            default:
                return null;
        }
    }

    public void a(int i, Object obj) {
    }

    public void a(int i, Hashtable hashtable, k8 k8Var) {
        String str;
        k8Var.c = "https://control.teragence.net/service2/data";
        switch (i) {
            case 0:
                k8Var.f = k8.j;
                str = "DateOccuredUtc";
                break;
            case 1:
                k8Var.f = k8.m;
                str = "DateOccuredUtcSpecified";
                break;
            case 2:
                k8Var.f = Long.class;
                str = "DeviceId";
                break;
            case 3:
                k8Var.f = k8.m;
                str = "DeviceIdSpecified";
                break;
            case 4:
                k8Var.f = k8.j;
                str = "ErrorMessage";
                break;
            case 5:
                k8Var.f = w6.class;
                str = "Network";
                break;
            case 6:
                k8Var.f = k8.j;
                str = "OwnerKey";
                break;
            case 7:
                k8Var.f = k8.j;
                str = "TestId";
                break;
            default:
                return;
        }
        k8Var.b = str;
    }

    public int m() {
        return 8;
    }
}
