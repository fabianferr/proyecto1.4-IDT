package com.teragence.library;

import java.util.Hashtable;

public class p6 implements h8 {
    public int a;
    public boolean b;
    public long c;
    public boolean d;
    public w6 e;
    public String f;
    public String g;
    public w6 h;

    public p6() {
    }

    public p6(int i, boolean z, long j, boolean z2, w6 w6Var, String str, String str2, w6 w6Var2) {
        this.a = i;
        this.b = z;
        this.c = j;
        this.d = z2;
        this.e = w6Var;
        this.f = str;
        this.g = str2;
        this.h = w6Var2;
    }

    public Object a(int i) {
        switch (i) {
            case 0:
                return Integer.valueOf(this.a);
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
                k8Var.f = k8.k;
                str = "ApiLevel";
                break;
            case 1:
                k8Var.f = k8.m;
                str = "ApiLevelSpecified";
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
                k8Var.f = w6.class;
                str = "NetworkInfo";
                break;
            case 5:
                k8Var.f = k8.j;
                str = "OperatingSystem";
                break;
            case 6:
                k8Var.f = k8.j;
                str = "ServiceVersion";
                break;
            case 7:
                k8Var.f = w6.class;
                str = "SimOperatorInfo";
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
