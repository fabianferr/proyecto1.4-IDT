package com.teragence.library;

import java.util.Hashtable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class d7 implements h8 {
    public n6 a;
    public t6 b;
    public x6 c;
    public String d;
    public w6 e;
    public int f;
    public boolean g;
    public String h;
    public int i;
    public boolean j;
    public int k;
    public boolean l;

    public d7() {
    }

    public d7(n6 n6Var, t6 t6Var, x6 x6Var, String str, w6 w6Var, int i2, boolean z, String str2, int i3, boolean z2, int i4, boolean z3) {
        this.a = n6Var;
        this.b = t6Var;
        this.c = x6Var;
        this.d = str;
        this.e = w6Var;
        this.f = i2;
        this.g = z;
        this.h = str2;
        this.i = i3;
        this.j = z2;
        this.k = i4;
        this.l = z3;
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
                return this.d;
            case 4:
                return this.e;
            case 5:
                return Integer.valueOf(this.f);
            case 6:
                return Boolean.valueOf(this.g);
            case 7:
                return this.h;
            case 8:
                return Integer.valueOf(this.i);
            case 9:
                return Boolean.valueOf(this.j);
            case 10:
                return Integer.valueOf(this.k);
            case 11:
                return Boolean.valueOf(this.l);
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
                k8Var.f = n6.class;
                str = "DeviceInfo";
                break;
            case 1:
                k8Var.f = t6.class;
                str = "LocationStatus";
                break;
            case 2:
                k8Var.f = x6.class;
                str = "NetworkStatus";
                break;
            case 3:
                k8Var.f = k8.j;
                str = "OwnerKey";
                break;
            case 4:
                k8Var.f = w6.class;
                str = "SimOperatorInfo";
                break;
            case 5:
                k8Var.f = k8.k;
                str = "Size";
                break;
            case 6:
                k8Var.f = k8.m;
                str = "SizeSpecified";
                break;
            case 7:
                k8Var.f = k8.j;
                str = "TestId";
                break;
            case 8:
                k8Var.f = k8.k;
                str = "TimeToBody";
                break;
            case 9:
                k8Var.f = k8.m;
                str = "TimeToBodySpecified";
                break;
            case 10:
                k8Var.f = k8.k;
                str = "TimeToComplete";
                break;
            case 11:
                k8Var.f = k8.m;
                str = "TimeToCompleteSpecified";
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
        return "ReportDownloadRequest{deviceInfo=" + this.a + ", locationStatus=" + this.b + ", networkStatus=" + this.c + ", ownerKey='" + this.d + "', simOperatorInfo=" + this.e + ", size=" + this.f + ", sizeSpecified=" + this.g + ", testId='" + this.h + "', timeToBody=" + this.i + ", timeToBodySpecified=" + this.j + ", timeToComplete=" + this.k + ", timeToCompleteSpecified=" + this.l + AbstractJsonLexerKt.END_OBJ;
    }
}
