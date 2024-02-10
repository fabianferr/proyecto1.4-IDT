package com.teragence.library;

import com.teragence.client.i;

public class o1 implements n1 {
    private final n1 a;

    public o1(n1 n1Var) {
        this.a = n1Var;
    }

    public void a(Exception exc) {
        try {
            this.a.a(exc);
        } catch (Exception e) {
            i.a("SafeLogger", e);
        }
    }
}
