package com.teragence.library;

import java.util.Vector;

public class b8 implements f8 {
    protected Vector a = new Vector();

    private Integer c(String str) {
        for (int i = 0; i < this.a.size(); i++) {
            if (str.equals(((c8) this.a.elementAt(i)).b())) {
                return new Integer(i);
            }
        }
        return null;
    }

    public int a() {
        return this.a.size();
    }

    public Object a(String str) {
        Integer c = c(str);
        if (c != null) {
            return b(c.intValue());
        }
        return null;
    }

    public void a(int i, c8 c8Var) {
        c8 c8Var2 = (c8) this.a.elementAt(i);
        c8Var.b = c8Var2.b;
        c8Var.c = c8Var2.c;
        c8Var.d = c8Var2.d;
        c8Var.f = c8Var2.f;
        c8Var.h = c8Var2.h;
        c8Var.e = c8Var2.d();
    }

    public void a(c8 c8Var) {
    }

    public void a(String str, Object obj) {
        a((String) null, str, obj);
    }

    public void a(String str, String str2, Object obj) {
        c8 c8Var = new c8();
        c8Var.b = str2;
        c8Var.c = str;
        c8Var.f = obj == null ? k8.i : obj.getClass();
        c8Var.e = obj;
        b(c8Var);
    }

    /* access modifiers changed from: protected */
    public boolean a(b8 b8Var) {
        int a2 = a();
        if (a2 != b8Var.a()) {
            return false;
        }
        for (int i = 0; i < a2; i++) {
            c8 c8Var = (c8) this.a.elementAt(i);
            Object d = c8Var.d();
            if (!b8Var.b(c8Var.b()) || !d.equals(b8Var.a(c8Var.b()))) {
                return false;
            }
        }
        return true;
    }

    public Object b(int i) {
        return ((c8) this.a.elementAt(i)).d();
    }

    public void b(int i, c8 c8Var) {
    }

    public void b(c8 c8Var) {
        this.a.addElement(c8Var);
    }

    public boolean b(String str) {
        return c(str) != null;
    }
}
