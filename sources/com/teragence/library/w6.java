package com.teragence.library;

import java.util.Hashtable;

public class w6 implements h8 {
    public String a;
    public String b;
    public String c;
    public String d;

    public w6() {
    }

    public w6(f6 f6Var) {
        this.b = f6Var.c();
        this.d = f6Var.a();
    }

    public w6(w5 w5Var) {
        this.a = w5Var.d();
        this.b = w5Var.c();
        this.c = w5Var.b();
        this.d = w5Var.a();
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
            str = "CC";
        } else if (i == 1) {
            k8Var.f = k8.j;
            str = "MCCMNC";
        } else if (i == 2) {
            k8Var.f = k8.j;
            str = "NetworkType";
        } else if (i == 3) {
            k8Var.f = k8.j;
            str = "Operator";
        } else {
            return;
        }
        k8Var.b = str;
    }

    public int m() {
        return 4;
    }

    public String toString() {
        return "NetworkInfo{cC='" + this.a + "', mCCMNC='" + this.b + "', networkType='" + this.c + "', operator='" + this.d + "'}";
    }
}
