package com.teragence.library;

import androidx.exifinterface.media.ExifInterface;
import java.util.Hashtable;

public class m6 implements h8 {
    public int a;
    public boolean b;
    public String c;
    public String d;
    public String e;
    public String f;

    public m6() {
    }

    public m6(p5 p5Var) {
        this.a = p5Var.c();
        this.b = true;
        this.c = p5Var.d();
        this.d = p5Var.g();
        this.e = p5Var.f();
        this.f = p5Var.b();
    }

    public Object a(int i) {
        if (i == 0) {
            return Integer.valueOf(this.a);
        }
        if (i == 1) {
            return Boolean.valueOf(this.b);
        }
        if (i == 2) {
            return this.c;
        }
        if (i == 3) {
            return this.d;
        }
        if (i == 4) {
            return this.e;
        }
        if (i != 5) {
            return null;
        }
        return this.f;
    }

    public void a(int i, Object obj) {
    }

    public void a(int i, Hashtable hashtable, k8 k8Var) {
        String str;
        k8Var.c = "https://control.teragence.net/service2/data";
        if (i == 0) {
            k8Var.f = k8.k;
            str = "ApiLevel";
        } else if (i == 1) {
            k8Var.f = k8.m;
            str = "ApiLevelSpecified";
        } else if (i == 2) {
            k8Var.f = k8.j;
            str = "Manufacturer";
        } else if (i == 3) {
            k8Var.f = k8.j;
            str = ExifInterface.TAG_MODEL;
        } else if (i == 4) {
            k8Var.f = k8.j;
            str = "OperatingSystem";
        } else if (i == 5) {
            k8Var.f = k8.j;
            str = "ServiceVersion";
        } else {
            return;
        }
        k8Var.b = str;
    }

    public int m() {
        return 6;
    }

    public String toString() {
        return "DeviceInfo{apiLevel=" + this.a + ", apiLevelSpecified=" + this.b + ", manufacturer='" + this.c + "', model='" + this.d + "', operatingSystem='" + this.e + "', serviceVersion='" + this.f + "'}";
    }
}
