package com.teragence.library;

public class z7 extends a8 {
    public w8 f;
    public w8 g;
    public w8 h;
    public w8 i;
    public w8 j;

    public z7(int i2) {
    }

    private void b(x8 x8Var) {
        w8 w8Var;
        x8Var.a(2, "http://www.w3.org/2003/05/soap-envelope", "Fault");
        while (x8Var.i() == 2) {
            String n = x8Var.n();
            String k = x8Var.k();
            x8Var.i();
            if (n.toLowerCase().equals("Code".toLowerCase())) {
                w8Var = new w8();
                this.f = w8Var;
            } else if (n.toLowerCase().equals("Reason".toLowerCase())) {
                w8Var = new w8();
                this.g = w8Var;
            } else if (n.toLowerCase().equals("Node".toLowerCase())) {
                w8Var = new w8();
                this.h = w8Var;
            } else if (n.toLowerCase().equals("Role".toLowerCase())) {
                w8Var = new w8();
                this.i = w8Var;
            } else if (n.toLowerCase().equals("Detail".toLowerCase())) {
                w8Var = new w8();
                this.j = w8Var;
            } else {
                throw new RuntimeException("unexpected tag:" + n);
            }
            w8Var.a(x8Var);
            x8Var.a(3, k, n);
        }
        x8Var.a(3, "http://www.w3.org/2003/05/soap-envelope", "Fault");
        x8Var.i();
    }

    public void a(x8 x8Var) {
        b(x8Var);
        this.b = this.f.b("http://www.w3.org/2003/05/soap-envelope", "Value").c(0);
        this.c = this.g.b("http://www.w3.org/2003/05/soap-envelope", "Text").c(0);
        this.e = this.j;
        this.d = null;
    }

    public String getMessage() {
        return this.g.b("http://www.w3.org/2003/05/soap-envelope", "Text").c(0);
    }

    public String toString() {
        String c = this.g.b("http://www.w3.org/2003/05/soap-envelope", "Text").c(0);
        String c2 = this.f.b("http://www.w3.org/2003/05/soap-envelope", "Value").c(0);
        return "Code: " + c2 + ", Reason: " + c;
    }
}
