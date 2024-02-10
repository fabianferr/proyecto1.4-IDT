package com.teragence.library;

import com.teragence.library.n4;

public class p4 implements n4 {
    private final n4 a;
    private final n1 b;

    public p4(n4 n4Var, n1 n1Var) {
        this.a = n4Var;
        this.b = n1Var;
    }

    public void a(n4.a aVar) {
        try {
            this.a.a(aVar);
        } catch (Exception e) {
            this.b.a(e);
            aVar.a(e);
        }
    }
}
