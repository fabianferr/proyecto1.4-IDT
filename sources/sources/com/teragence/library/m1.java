package com.teragence.library;

import com.teragence.client.i;

public class m1 implements n1 {
    private final n1 a;

    public m1(n1 n1Var) {
        this.a = n1Var;
    }

    public void a(Exception exc) {
        i.b("ExceptionLogger", exc.getMessage());
        this.a.a(exc);
    }
}
