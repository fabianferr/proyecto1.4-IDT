package com.teragence.library;

import java.util.Hashtable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class k6 implements h8 {
    public String a;
    public boolean b;
    public t6 c;
    public x6 d;

    public k6() {
    }

    public k6(String str, boolean z, t6 t6Var, x6 x6Var) {
        this.a = str;
        this.b = z;
        this.c = t6Var;
        this.d = x6Var;
    }

    public Object a(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i == 1) {
            return Boolean.valueOf(this.b);
        }
        if (i == 2) {
            return this.c;
        }
        if (i != 3) {
            return null;
        }
        return this.d;
    }

    public void a(int i, Object obj) {
    }

    public void a(int i, Hashtable hashtable, k8 k8Var) {
        String str;
        k8Var.c = "https://control.teragence.net/service2/data";
        if (i == 0) {
            k8Var.f = k8.j;
            str = "Date";
        } else if (i == 1) {
            k8Var.f = k8.m;
            str = "DateSpecified";
        } else if (i == 2) {
            k8Var.f = t6.class;
            str = "LocationStatus";
        } else if (i == 3) {
            k8Var.f = x6.class;
            str = "NetworkStatus";
        } else {
            return;
        }
        k8Var.b = str;
    }

    public int m() {
        return 4;
    }

    public String toString() {
        return "Deadzone{date='" + this.a + "', dateSpecified=" + this.b + ", locationStatus=" + this.c + ", networkStatus=" + this.d + AbstractJsonLexerKt.END_OBJ;
    }
}
