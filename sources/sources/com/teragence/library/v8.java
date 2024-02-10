package com.teragence.library;

import java.util.Vector;

public class v8 extends w8 {
    protected String c;
    protected String d;
    protected Vector e;
    protected w8 f;
    protected Vector g;

    public v8 a(String str, String str2) {
        w8 w8Var = this.f;
        return w8Var == null ? super.a(str, str2) : w8Var.a(str, str2);
    }

    /* access modifiers changed from: protected */
    public void a(w8 w8Var) {
        this.f = w8Var;
    }

    public void a(x8 x8Var) {
        for (int c2 = x8Var.c(x8Var.c() - 1); c2 < x8Var.c(x8Var.c()); c2++) {
            c(x8Var.d(c2), x8Var.a(c2));
        }
        for (int i = 0; i < x8Var.a(); i++) {
            a(x8Var.g(i), x8Var.b(i), x8Var.f(i));
        }
        e();
        boolean g2 = x8Var.g();
        x8Var.e();
        if (!g2) {
            super.a(x8Var);
            if (a() == 0) {
                a(7, (Object) "");
            }
        }
        x8Var.a(3, d(), c());
        x8Var.e();
    }

    public void a(String str, String str2, String str3) {
        if (this.e == null) {
            this.e = new Vector();
        }
        if (str == null) {
            str = "";
        }
        int size = this.e.size() - 1;
        while (size >= 0) {
            String[] strArr = (String[]) this.e.elementAt(size);
            if (!strArr[0].equals(str) || !strArr[1].equals(str2)) {
                size--;
            } else if (str3 == null) {
                this.e.removeElementAt(size);
                return;
            } else {
                strArr[2] = str3;
                return;
            }
        }
        this.e.addElement(new String[]{str, str2, str3});
    }

    public int b() {
        Vector vector = this.e;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public void b(z8 z8Var) {
        if (this.g != null) {
            for (int i = 0; i < this.g.size(); i++) {
                z8Var.a(i(i), j(i));
            }
        }
        z8Var.b(d(), c());
        int b = b();
        for (int i2 = 0; i2 < b; i2++) {
            z8Var.a(g(i2), f(i2), h(i2));
        }
        a(z8Var);
        z8Var.c(d(), c());
    }

    public String c() {
        return this.d;
    }

    public void c(String str, String str2) {
        if (this.g == null) {
            this.g = new Vector();
        }
        this.g.addElement(new String[]{str, str2});
    }

    public String d() {
        return this.c;
    }

    public void e() {
    }

    public String f(int i) {
        return ((String[]) this.e.elementAt(i))[1];
    }

    public String g(int i) {
        return ((String[]) this.e.elementAt(i))[0];
    }

    public String h(int i) {
        return ((String[]) this.e.elementAt(i))[2];
    }

    public String i(int i) {
        return ((String[]) this.g.elementAt(i))[0];
    }

    public String j(int i) {
        return ((String[]) this.g.elementAt(i))[1];
    }
}
