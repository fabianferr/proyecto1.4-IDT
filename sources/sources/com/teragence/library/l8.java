package com.teragence.library;

import java.util.Hashtable;
import java.util.Vector;

public class l8 extends b8 implements h8, g8 {
    protected String b;
    protected String c;
    protected Vector d;
    protected Object e;

    public l8() {
        this("", "");
    }

    public l8(String str, String str2) {
        this.d = new Vector();
        this.b = str;
        this.c = str2;
    }

    private Integer e(String str) {
        if (str == null) {
            return null;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if (str.equals(((k8) this.d.elementAt(i)).b())) {
                return new Integer(i);
            }
        }
        return null;
    }

    public l8 a(k8 k8Var) {
        this.d.addElement(k8Var);
        return this;
    }

    public l8 a(l8 l8Var) {
        this.d.addElement(l8Var);
        return this;
    }

    public Object a(int i) {
        Object elementAt = this.d.elementAt(i);
        return elementAt instanceof k8 ? ((k8) elementAt).d() : (l8) elementAt;
    }

    public void a(int i, k8 k8Var) {
        Object elementAt = this.d.elementAt(i);
        if (elementAt instanceof k8) {
            k8 k8Var2 = (k8) elementAt;
            k8Var.b = k8Var2.b;
            k8Var.c = k8Var2.c;
            k8Var.d = k8Var2.d;
            k8Var.f = k8Var2.f;
            k8Var.h = k8Var2.h;
            k8Var.e = k8Var2.e;
            k8Var.g = k8Var2.g;
            return;
        }
        k8Var.b = null;
        k8Var.c = null;
        k8Var.d = 0;
        k8Var.f = null;
        k8Var.h = null;
        k8Var.e = elementAt;
        k8Var.g = false;
    }

    public void a(int i, Object obj) {
        Object elementAt = this.d.elementAt(i);
        if (elementAt instanceof k8) {
            ((k8) elementAt).b(obj);
        }
    }

    public void a(int i, Hashtable hashtable, k8 k8Var) {
        a(i, k8Var);
    }

    public void a(Object obj) {
        this.e = obj;
    }

    public boolean a(Object obj, int i) {
        if (i >= m()) {
            return false;
        }
        Object elementAt = this.d.elementAt(i);
        if ((obj instanceof k8) && (elementAt instanceof k8)) {
            k8 k8Var = (k8) obj;
            k8 k8Var2 = (k8) elementAt;
            return k8Var.b().equals(k8Var2.b()) && k8Var.d().equals(k8Var2.d());
        } else if (!(obj instanceof l8) || !(elementAt instanceof l8)) {
            return false;
        } else {
            return ((l8) obj).equals((l8) elementAt);
        }
    }

    public l8 b(String str, Object obj) {
        k8 k8Var = new k8();
        k8Var.b = str;
        k8Var.f = obj == null ? k8.i : obj.getClass();
        k8Var.e = obj;
        return a(k8Var);
    }

    public l8 b(String str, String str2, Object obj) {
        k8 k8Var = new k8();
        k8Var.b = str2;
        k8Var.c = str;
        k8Var.f = obj == null ? k8.i : obj.getClass();
        k8Var.e = obj;
        return a(k8Var);
    }

    public Object b() {
        return this.e;
    }

    public Object c(String str) {
        Integer e2 = e(str);
        if (e2 != null) {
            return a(e2.intValue());
        }
        throw new RuntimeException("illegal property: " + str);
    }

    public String c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public boolean d(String str) {
        return e(str) != null;
    }

    public l8 e() {
        l8 l8Var = new l8(this.b, this.c);
        for (int i = 0; i < this.d.size(); i++) {
            Object elementAt = this.d.elementAt(i);
            if (elementAt instanceof k8) {
                l8Var.a((k8) ((k8) this.d.elementAt(i)).clone());
            } else if (elementAt instanceof l8) {
                l8Var.a(((l8) elementAt).e());
            }
        }
        for (int i2 = 0; i2 < a(); i2++) {
            c8 c8Var = new c8();
            a(i2, c8Var);
            l8Var.b(c8Var);
        }
        return l8Var;
    }

    public boolean equals(Object obj) {
        int size;
        if (!(obj instanceof l8)) {
            return false;
        }
        l8 l8Var = (l8) obj;
        if (!this.c.equals(l8Var.c) || !this.b.equals(l8Var.b) || (size = this.d.size()) != l8Var.d.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!l8Var.a(this.d.elementAt(i), i)) {
                return false;
            }
        }
        return a((b8) l8Var);
    }

    public int m() {
        return this.d.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("" + this.c + "{");
        for (int i = 0; i < m(); i++) {
            Object elementAt = this.d.elementAt(i);
            if (elementAt instanceof k8) {
                stringBuffer.append("").append(((k8) elementAt).b()).append("=").append(a(i)).append("; ");
            } else {
                stringBuffer.append(((l8) elementAt).toString());
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}
