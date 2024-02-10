package com.teragence.library;

import java.io.IOException;

public class a8 extends IOException {
    public String b;
    public String c;
    public String d;
    public w8 e;

    public a8() {
    }

    public a8(int i) {
    }

    public void a(x8 x8Var) {
        x8Var.a(2, "http://schemas.xmlsoap.org/soap/envelope/", "Fault");
        while (x8Var.i() == 2) {
            String n = x8Var.n();
            if (n.equals("detail")) {
                w8 w8Var = new w8();
                this.e = w8Var;
                w8Var.a(x8Var);
                if (x8Var.k().equals("http://schemas.xmlsoap.org/soap/envelope/") && x8Var.n().equals("Fault")) {
                    break;
                }
            } else {
                if (n.equals("faultcode")) {
                    this.b = x8Var.d();
                } else if (n.equals("faultstring")) {
                    this.c = x8Var.d();
                } else if (n.equals("faultactor")) {
                    this.d = x8Var.d();
                } else {
                    throw new RuntimeException("unexpected tag:" + n);
                }
                x8Var.a(3, (String) null, n);
            }
        }
        x8Var.a(3, "http://schemas.xmlsoap.org/soap/envelope/", "Fault");
        x8Var.i();
    }

    public String getMessage() {
        return this.c;
    }

    public String toString() {
        return "SoapFault - faultcode: '" + this.b + "' faultstring: '" + this.c + "' faultactor: '" + this.d + "' detail: " + this.e;
    }
}
