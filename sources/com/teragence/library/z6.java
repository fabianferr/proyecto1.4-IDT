package com.teragence.library;

import java.util.Hashtable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class z6 implements h8 {
    public m6 a;
    public w6 b;
    public String c;
    public String d;
    public w6 e;

    public z6() {
    }

    public z6(m6 m6Var, w6 w6Var, String str, String str2, w6 w6Var2) {
        this.a = m6Var;
        this.b = w6Var;
        this.c = str;
        this.d = str2;
        this.e = w6Var2;
    }

    public Object a(int i) {
        if (i == 0) {
            return this.a;
        }
        if (i == 1) {
            return this.b;
        }
        if (i == 2) {
            return this.c;
        }
        if (i == 3) {
            return this.d;
        }
        if (i != 4) {
            return null;
        }
        return this.e;
    }

    public void a(int i, Object obj) {
    }

    public void a(int i, Hashtable hashtable, k8 k8Var) {
        String str;
        k8Var.c = "https://control.teragence.net/service2/data";
        if (i == 0) {
            k8Var.f = m6.class;
            str = "DeviceInfo";
        } else if (i == 1) {
            k8Var.f = w6.class;
            str = "NetworkInfo";
        } else if (i == 2) {
            k8Var.f = k8.j;
            str = "PersistentId";
        } else if (i == 3) {
            k8Var.f = k8.j;
            str = "Product";
        } else if (i == 4) {
            k8Var.f = w6.class;
            str = "SimOperatorInfo";
        } else {
            return;
        }
        k8Var.b = str;
    }

    public int m() {
        return 5;
    }

    public String toString() {
        return "RegisterDeviceRequest{deviceInfo=" + this.a + ", networkInfo=" + this.b + ", persistentId='" + this.c + "', product='" + this.d + "', simOperatorInfo=" + this.e + AbstractJsonLexerKt.END_OBJ;
    }
}
