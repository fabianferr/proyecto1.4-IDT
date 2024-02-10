package com.teragence.library;

import java.util.Vector;

public class w8 {
    protected Vector a;
    protected StringBuffer b;

    public int a() {
        Vector vector = this.a;
        if (vector == null) {
            return 0;
        }
        return vector.size();
    }

    public int a(String str, String str2, int i) {
        int a2 = a();
        while (i < a2) {
            v8 b2 = b(i);
            if (b2 != null && str2.equals(b2.c()) && (str == null || str.equals(b2.d()))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public v8 a(String str, String str2) {
        v8 v8Var = new v8();
        if (str == null) {
            str = "";
        }
        v8Var.c = str;
        v8Var.d = str2;
        return v8Var;
    }

    public Object a(int i) {
        return this.a.elementAt(i);
    }

    public void a(int i, int i2, Object obj) {
        obj.getClass();
        if (this.a == null) {
            this.a = new Vector();
            this.b = new StringBuffer();
        }
        if (i2 == 2) {
            if (obj instanceof v8) {
                ((v8) obj).a(this);
            } else {
                throw new RuntimeException("Element obj expected)");
            }
        } else if (!(obj instanceof String)) {
            throw new RuntimeException("String expected");
        }
        this.a.insertElementAt(obj, i);
        this.b.insert(i, (char) i2);
    }

    public void a(int i, Object obj) {
        a(a(), i, obj);
    }

    public void a(x8 x8Var) {
        boolean z = false;
        do {
            int l = x8Var.l();
            if (l != 1) {
                if (l == 2) {
                    v8 a2 = a(x8Var.k(), x8Var.n());
                    a(2, (Object) a2);
                    a2.a(x8Var);
                    continue;
                } else if (l != 3) {
                    if (x8Var.j() != null) {
                        if (l == 6) {
                            l = 4;
                        }
                        a(l, (Object) x8Var.j());
                    } else if (l == 6 && x8Var.n() != null) {
                        a(6, (Object) x8Var.n());
                    }
                    x8Var.e();
                    continue;
                }
            }
            z = true;
            continue;
        } while (!z);
    }

    public void a(z8 z8Var) {
        Vector vector = this.a;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                int d = d(i);
                Object elementAt = this.a.elementAt(i);
                switch (d) {
                    case 2:
                        ((v8) elementAt).b(z8Var);
                        break;
                    case 4:
                        z8Var.b((String) elementAt);
                        break;
                    case 5:
                        z8Var.e((String) elementAt);
                        break;
                    case 6:
                        z8Var.g((String) elementAt);
                        break;
                    case 7:
                        z8Var.f((String) elementAt);
                        break;
                    case 8:
                        z8Var.a((String) elementAt);
                        break;
                    case 9:
                        z8Var.d((String) elementAt);
                        break;
                    case 10:
                        z8Var.c((String) elementAt);
                        break;
                    default:
                        throw new RuntimeException("Illegal type: " + d);
                }
            }
        }
    }

    public v8 b(int i) {
        Object a2 = a(i);
        if (a2 instanceof v8) {
            return (v8) a2;
        }
        return null;
    }

    public v8 b(String str, String str2) {
        int a2 = a(str, str2, 0);
        int a3 = a(str, str2, a2 + 1);
        if (a2 != -1 && a3 == -1) {
            return b(a2);
        }
        StringBuilder sb = new StringBuilder("Element {");
        sb.append(str);
        sb.append("}");
        sb.append(str2);
        sb.append(a2 == -1 ? " not found in " : " more than once in ");
        sb.append(this);
        throw new RuntimeException(sb.toString());
    }

    public String c(int i) {
        if (e(i)) {
            return (String) a(i);
        }
        return null;
    }

    public int d(int i) {
        return this.b.charAt(i);
    }

    public boolean e(int i) {
        int d = d(i);
        return d == 4 || d == 7 || d == 5;
    }
}
