package com.teragence.library;

import java.util.Hashtable;

public class e7 implements h8 {
    public g7 a;
    public boolean b;
    public long c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public String k;
    public boolean l;
    public w6 m;
    public String n;

    public e7() {
    }

    public e7(g7 g7Var, boolean z, long j2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, String str, boolean z9, w6 w6Var, String str2) {
        this.a = g7Var;
        this.b = z;
        this.c = j2;
        this.d = z2;
        this.e = z3;
        this.f = z4;
        this.g = z5;
        this.h = z6;
        this.i = z7;
        this.j = z8;
        this.k = str;
        this.l = z9;
        this.m = w6Var;
        this.n = str2;
    }

    public Object a(int i2) {
        switch (i2) {
            case 0:
                return this.a.toString();
            case 1:
                return Boolean.valueOf(this.b);
            case 2:
                return Long.valueOf(this.c);
            case 3:
                return Boolean.valueOf(this.d);
            case 4:
                return Boolean.valueOf(this.e);
            case 5:
                return Boolean.valueOf(this.f);
            case 6:
                return Boolean.valueOf(this.g);
            case 7:
                return Boolean.valueOf(this.h);
            case 8:
                return Boolean.valueOf(this.i);
            case 9:
                return Boolean.valueOf(this.j);
            case 10:
                return this.k;
            case 11:
                return Boolean.valueOf(this.l);
            case 12:
                return this.m;
            case 13:
                return this.n;
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
                str = "ActivityTypeId";
                break;
            case 1:
                k8Var.f = k8.m;
                str = "ActivityTypeIdSpecified";
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
                k8Var.f = k8.m;
                str = "HasAvailableCellInfo";
                break;
            case 5:
                k8Var.f = k8.m;
                str = "HasAvailableCellInfoSpecified";
                break;
            case 6:
                k8Var.f = k8.m;
                str = "HasCellInfo";
                break;
            case 7:
                k8Var.f = k8.m;
                str = "HasCellInfoSpecified";
                break;
            case 8:
                k8Var.f = k8.m;
                str = "HasLocation";
                break;
            case 9:
                k8Var.f = k8.m;
                str = "HasLocationSpecified";
                break;
            case 10:
                k8Var.f = k8.j;
                str = "MeasurementDate";
                break;
            case 11:
                k8Var.f = k8.m;
                str = "MeasurementDateSpecified";
                break;
            case 12:
                k8Var.f = w6.class;
                str = "Network";
                break;
            case 13:
                k8Var.f = k8.j;
                str = "OwnerKey";
                break;
            default:
                return;
        }
        k8Var.b = str;
    }

    public int m() {
        return 14;
    }

    public String toString() {
        return "ReportMeasurementRequest{activityTypeId=" + this.a + ", activityTypeIdSpecified=" + this.b + ", deviceId=" + this.c + ", deviceIdSpecified=" + this.d + ", hasAvailableCellInfo=" + this.e + ", hasAvailableCellInfoSpecified=" + this.f + ", hasCellInfo=" + this.g + ", hasCellInfoSpecified=" + this.h + ", hasLocation=" + this.i + ", hasLocationSpecified=" + this.j + ", measurementDate='" + this.k + "', measurementDateSpecified=" + this.l + ", network=" + this.m + ", ownerKey='" + this.n + "'}";
    }
}
