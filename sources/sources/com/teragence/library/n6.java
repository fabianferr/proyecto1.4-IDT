package com.teragence.library;

import androidx.exifinterface.media.ExifInterface;
import java.util.Hashtable;

public class n6 implements h8 {
    public int a;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public boolean h;
    public boolean i;

    public n6() {
    }

    public n6(q5 q5Var) {
        this.a = q5Var.c();
        this.b = true;
        this.c = q5Var.d();
        this.d = q5Var.g();
        this.e = q5Var.f();
        this.f = q5Var.b();
        this.g = q5Var.e();
        this.h = q5Var.a();
        this.i = true;
    }

    public Object a(int i2) {
        switch (i2) {
            case 0:
                return Integer.valueOf(this.a);
            case 1:
                return Boolean.valueOf(this.b);
            case 2:
                return this.c;
            case 3:
                return this.d;
            case 4:
                return this.e;
            case 5:
                return this.f;
            case 6:
                return this.g;
            case 7:
                return Boolean.valueOf(this.h);
            case 8:
                return Boolean.valueOf(this.i);
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
                k8Var.f = k8.k;
                str = "ApiLevel";
                break;
            case 1:
                k8Var.f = k8.m;
                str = "ApiLevelSpecified";
                break;
            case 2:
                k8Var.f = k8.j;
                str = "Manufacturer";
                break;
            case 3:
                k8Var.f = k8.j;
                str = ExifInterface.TAG_MODEL;
                break;
            case 4:
                k8Var.f = k8.j;
                str = "OperatingSystem";
                break;
            case 5:
                k8Var.f = k8.j;
                str = "ServiceVersion";
                break;
            case 6:
                k8Var.f = k8.j;
                str = "BatteryLevel";
                break;
            case 7:
                k8Var.f = k8.m;
                str = "ScreenOn";
                break;
            case 8:
                k8Var.f = k8.m;
                str = "ScreenOnSpecified";
                break;
            default:
                return;
        }
        k8Var.b = str;
    }

    public int m() {
        return 9;
    }

    public String toString() {
        return "DeviceInfoExtend{batteryLevel='" + this.g + "', screenOn=" + this.h + ", screenOnSpecified=" + this.i + ", apiLevel=" + this.a + ", apiLevelSpecified=" + this.b + ", manufacturer='" + this.c + "', model='" + this.d + "', operatingSystem='" + this.e + "', serviceVersion='" + this.f + "'}";
    }
}
