package com.teragence.library;

import com.teragence.library.s4;

public class r4 implements s4 {
    private final h0 a;
    private final r5 b;

    public r4(h0 h0Var, r5 r5Var) {
        this.a = h0Var;
        this.b = r5Var;
    }

    private void a(v5[] v5VarArr, s4.a aVar) {
        boolean z = false;
        for (v5 v5Var : v5VarArr) {
            if (!this.b.a(v5Var)) {
                this.a.a(v5Var);
                z = true;
            }
        }
        if (z) {
            aVar.b();
        } else {
            aVar.a();
        }
    }

    public void a(s4.a aVar) {
        v5[] a2 = this.a.a();
        if (a2.length > 0) {
            a(a2, aVar);
        } else {
            aVar.a();
        }
    }
}
