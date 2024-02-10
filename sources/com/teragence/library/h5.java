package com.teragence.library;

import com.teragence.library.i5;

public class h5 implements i5 {
    private final r5 a;
    private final r b;

    public h5(r5 r5Var, r rVar) {
        this.a = r5Var;
        this.b = rVar;
    }

    public void a(i5.a aVar) {
        e6[] a2 = this.b.a();
        for (int i = 0; i < a2.length; i++) {
            if (!this.a.a(a2[i])) {
                int length = a2.length - i;
                e6[] e6VarArr = new e6[length];
                System.arraycopy(a2, i, e6VarArr, 0, length);
                this.b.a(e6VarArr);
                aVar.a(new Exception("not all reports have sent"));
                return;
            }
        }
        aVar.a();
    }
}
