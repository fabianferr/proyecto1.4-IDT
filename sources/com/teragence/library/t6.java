package com.teragence.library;

import java.util.Hashtable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class t6 implements h8 {
    public float a;
    public boolean b;
    public float c;
    public boolean d;
    public double e;
    public boolean f;
    public double g;
    public boolean h;
    public double i;
    public boolean j;

    public t6() {
    }

    public t6(u5 u5Var) {
        this.a = u5Var.c();
        this.b = true;
        this.c = u5Var.a();
        this.d = true;
        this.e = u5Var.e();
        this.f = true;
        this.g = u5Var.b();
        this.h = true;
        this.i = u5Var.d();
        this.j = true;
    }

    public Object a(int i2) {
        switch (i2) {
            case 0:
                return Float.valueOf(this.a);
            case 1:
                return Boolean.valueOf(this.b);
            case 2:
                return Double.valueOf(this.e);
            case 3:
                return Boolean.valueOf(this.f);
            case 4:
                return Double.valueOf(this.g);
            case 5:
                return Boolean.valueOf(this.h);
            case 6:
                return Double.valueOf(this.i);
            case 7:
                return Boolean.valueOf(this.j);
            case 8:
                return Float.valueOf(this.c);
            case 9:
                return Boolean.valueOf(this.d);
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
                k8Var.f = Float.class;
                str = "Accuracy";
                break;
            case 1:
                k8Var.f = k8.m;
                str = "AccuracySpecified";
                break;
            case 2:
                k8Var.f = Double.class;
                str = "Alt";
                break;
            case 3:
                k8Var.f = k8.m;
                str = "AltSpecified";
                break;
            case 4:
                k8Var.f = Double.class;
                str = "Lat";
                break;
            case 5:
                k8Var.f = k8.m;
                str = "LatSpecified";
                break;
            case 6:
                k8Var.f = Double.class;
                str = "Long";
                break;
            case 7:
                k8Var.f = k8.m;
                str = "LongSpecified";
                break;
            case 8:
                k8Var.f = Float.class;
                str = "VerticalAccuracy";
                break;
            case 9:
                k8Var.f = k8.m;
                str = "VerticalAccuracySpecified";
                break;
            default:
                return;
        }
        k8Var.b = str;
    }

    public int m() {
        return 10;
    }

    public String toString() {
        return "LocationStatus{accuracy=" + this.a + ", accuracySpecified=" + this.b + ", alt=" + this.e + ", altSpecified=" + this.f + ", lat=" + this.g + ", latSpecified=" + this.h + ", longitude=" + this.i + ", longSpecified=" + this.j + AbstractJsonLexerKt.END_OBJ;
    }
}
