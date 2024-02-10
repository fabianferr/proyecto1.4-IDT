package com.teragence.library;

import java.util.Hashtable;

public class b7 implements h8 {
    public String a;
    public n6 b;
    public String c;
    public int d;
    public boolean e;
    public t6 f;
    public x6 g;
    public String h;
    public int i;
    public boolean j;
    public w6 k;
    public String l;

    public b7() {
    }

    public b7(String str, n6 n6Var, String str2, int i2, boolean z, t6 t6Var, x6 x6Var, String str3, int i3, boolean z2, w6 w6Var, String str4) {
        this.a = str;
        this.b = n6Var;
        this.c = str2;
        this.d = i2;
        this.e = z;
        this.f = t6Var;
        this.g = x6Var;
        this.h = str3;
        this.i = i3;
        this.j = z2;
        this.k = w6Var;
        this.l = str4;
    }

    public Object a(int i2) {
        switch (i2) {
            case 0:
                return this.a;
            case 1:
                return this.b;
            case 2:
                return this.c;
            case 3:
                return Integer.valueOf(this.d);
            case 4:
                return Boolean.valueOf(this.e);
            case 5:
                return this.f;
            case 6:
                return this.g;
            case 7:
                return this.h;
            case 8:
                return Integer.valueOf(this.i);
            case 9:
                return Boolean.valueOf(this.j);
            case 10:
                return this.k;
            case 11:
                return this.l;
            default:
                return null;
        }
    }

    public void a(int i2, Object obj) {
    }

    public void a(int i2, Hashtable hashtable, k8 k8Var) {
        String str;
        k8Var.c = "https://control.teragence.net/service2/data";
        switch (i2) {
            case 0:
                k8Var.f = k8.j;
                str = "BurstId";
                break;
            case 1:
                k8Var.f = n6.class;
                str = "DeviceInfoExtend";
                break;
            case 2:
                k8Var.f = k8.j;
                str = "ExtraData";
                break;
            case 3:
                k8Var.f = k8.k;
                str = "InitialDelay";
                break;
            case 4:
                k8Var.f = k8.m;
                str = "InitialDelaySpecified";
                break;
            case 5:
                k8Var.f = t6.class;
                str = "LocationStatus";
                break;
            case 6:
                k8Var.f = x6.class;
                str = "NetworkStatus";
                break;
            case 7:
                k8Var.f = k8.j;
                str = "OwnerKey";
                break;
            case 8:
                k8Var.f = k8.k;
                str = "Port";
                break;
            case 9:
                k8Var.f = k8.m;
                str = "PortSpecified";
                break;
            case 10:
                k8Var.f = w6.class;
                str = "SimOperatorInfo";
                break;
            case 11:
                k8Var.f = k8.j;
                str = "TestId";
                break;
            default:
                return;
        }
        k8Var.b = str;
    }

    public int m() {
        return 12;
    }

    public String toString() {
        return "ReportBurstRequest{burstId='" + this.a + "', deviceInfoExtend=" + this.b + ", extraData='" + this.c + "', initialDelay=" + this.d + ", initialDelaySpecified=" + this.e + ", locationStatus=" + this.f + ", networkStatus=" + this.g + ", ownerKey='" + this.h + "', port=" + this.i + ", portSpecified=" + this.j + ", simOperatorInfo=" + this.k + ", testId='" + this.l + "'}";
    }
}
