package com.startapp;

import android.content.Context;

/* compiled from: Sta */
public class u3 implements h2<i3, k3, n3, t3> {
    public final Context a;
    public final n4<a3> b;
    public final n4<c7> c;

    public u3(Context context, n4<a3> n4Var, n4<c7> n4Var2) {
        this.a = context;
        this.b = n4Var;
        this.c = n4Var2;
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        i3 i3Var = (i3) obj;
        k3 k3Var = (k3) obj2;
        n3 n3Var = (n3) obj3;
        if (i3Var == null || k3Var == null) {
            return null;
        }
        if (j3.k.equals(i3Var.a)) {
            return new v3(this.b, this.c, i3Var, k3Var, n3Var);
        }
        return new s3(this.a, i3Var, k3Var, n3Var);
    }
}
