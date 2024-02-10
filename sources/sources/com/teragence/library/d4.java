package com.teragence.library;

import com.teragence.library.c4;

public class d4 implements c4 {
    private final c4 a;
    private final n1 b;

    public d4(c4 c4Var, n1 n1Var) {
        this.a = c4Var;
        this.b = n1Var;
    }

    public void a(c4.a aVar) {
        try {
            this.a.a(aVar);
        } catch (Exception e) {
            this.b.a(e);
            aVar.a(e);
        }
    }
}
