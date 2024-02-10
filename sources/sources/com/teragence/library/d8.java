package com.teragence.library;

import androidx.constraintlayout.core.motion.utils.TypedValues;

class d8 implements i8 {
    d8() {
    }

    public Object a(x8 x8Var, String str, String str2, k8 k8Var) {
        String d = x8Var.d();
        char charAt = str2.charAt(0);
        if (charAt == 'b') {
            return new Boolean(y7.a(d));
        }
        if (charAt == 'i') {
            return new Integer(Integer.parseInt(d));
        }
        if (charAt == 'l') {
            return new Long(Long.parseLong(d));
        }
        if (charAt == 's') {
            return d;
        }
        throw new RuntimeException();
    }

    public void a(n8 n8Var) {
        n8Var.a(n8Var.i, "int", k8.k, (i8) this);
        n8Var.a(n8Var.i, "long", k8.l, (i8) this);
        n8Var.a(n8Var.i, TypedValues.Custom.S_STRING, k8.j, (i8) this);
        n8Var.a(n8Var.i, TypedValues.Custom.S_BOOLEAN, k8.m, (i8) this);
    }

    public void a(z8 z8Var, Object obj) {
        int i = 0;
        if (obj instanceof b8) {
            b8 b8Var = (b8) obj;
            int a = b8Var.a();
            while (i < a) {
                c8 c8Var = new c8();
                b8Var.a(i, c8Var);
                try {
                    b8Var.b(i, c8Var);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (c8Var.d() != null) {
                    z8Var.a(c8Var.c(), c8Var.b(), c8Var.d() != null ? c8Var.d().toString() : "");
                }
                i++;
            }
        } else if (obj instanceof f8) {
            f8 f8Var = (f8) obj;
            int a2 = f8Var.a();
            while (i < a2) {
                c8 c8Var2 = new c8();
                f8Var.a(i, c8Var2);
                try {
                    f8Var.b(i, c8Var2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (c8Var2.d() != null) {
                    z8Var.a(c8Var2.c(), c8Var2.b(), c8Var2.d() != null ? c8Var2.d().toString() : "");
                }
                i++;
            }
        }
        if (obj instanceof o8) {
            ((o8) obj).a(z8Var);
        } else {
            z8Var.b(obj.toString());
        }
    }
}
