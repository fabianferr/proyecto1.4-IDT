package com.teragence.library;

import com.teragence.library.z4;

public class e5 implements z4 {
    private final z4 a;
    private final n1 b;

    public e5(z4 z4Var, n1 n1Var) {
        this.a = z4Var;
        this.b = n1Var;
    }

    public void a(z4.a aVar, i3 i3Var) {
        try {
            this.a.a(aVar, i3Var);
        } catch (Exception e) {
            this.b.a(e);
            aVar.a(e);
        }
    }
}
