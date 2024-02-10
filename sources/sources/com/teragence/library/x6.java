package com.teragence.library;

import java.util.Hashtable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class x6 implements h8 {
    public String a;
    public String b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public w6 g;
    public double h;
    public boolean i;
    public String j;
    public double k;
    public boolean l;

    public x6() {
    }

    public x6(x5 x5Var) {
        this.a = x5Var.a();
        this.b = x5Var.g();
        this.c = x5Var.c();
        this.d = true;
        this.e = x5Var.b();
        this.f = true;
        this.g = new w6(x5Var.d());
        this.h = x5Var.e();
        this.i = true;
        this.j = x5Var.h();
        this.k = x5Var.f();
        this.l = true;
    }

    public Object a(int i2) {
        switch (i2) {
            case 0:
                return this.a;
            case 1:
                return this.b;
            case 2:
                return Integer.valueOf(this.c);
            case 3:
                return Boolean.valueOf(this.d);
            case 4:
                return Boolean.valueOf(this.e);
            case 5:
                return Boolean.valueOf(this.f);
            case 6:
                return this.g;
            case 7:
                return Double.valueOf(this.h);
            case 8:
                return Boolean.valueOf(this.i);
            case 9:
                return this.j;
            case 10:
                return Double.valueOf(this.k);
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
                k8Var.f = k8.j;
                str = "Cell";
                break;
            case 1:
                k8Var.f = k8.j;
                str = "CellInfo";
                break;
            case 2:
                k8Var.f = k8.k;
                str = "DBmSignalStrength";
                break;
            case 3:
                k8Var.f = k8.m;
                str = "DBmSignalStrengthSpecified";
                break;
            case 4:
                k8Var.f = k8.m;
                str = "IsNetworkRoaming";
                break;
            case 5:
                k8Var.f = k8.m;
                str = "IsNetworkRoamingSpecified";
                break;
            case 6:
                k8Var.f = w6.class;
                str = "Network";
                break;
            case 7:
                k8Var.f = Double.class;
                str = "RxRate";
                break;
            case 8:
                k8Var.f = k8.m;
                str = "RxRateSpecified";
                break;
            case 9:
                k8Var.f = k8.j;
                str = "SignalStrength";
                break;
            case 10:
                k8Var.f = Double.class;
                str = "TxRate";
                break;
            case 11:
                k8Var.f = k8.m;
                str = "TxRateSpecified";
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
        return "NetworkStatus{cell='" + this.a + "', cellInfo='" + this.b + "', dBmSignalStrength=" + this.c + ", dBmSignalStrengthSpecified=" + this.d + ", isNetworkRoaming=" + this.e + ", isNetworkRoamingSpecified=" + this.f + ", network=" + this.g + ", rxRate=" + this.h + ", rxRateSpecified=" + this.i + ", signalStrength='" + this.j + "', txRate=" + this.k + ", txRateSpecified=" + this.l + AbstractJsonLexerKt.END_OBJ;
    }
}
