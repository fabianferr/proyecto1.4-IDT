package com.teragence.library;

import com.teragence.client.i;

public class c0 implements q {
    private final q a;

    public c0(q qVar) {
        this.a = qVar;
    }

    public void a(o5... o5VarArr) {
        i.a("LoggableDeadzoneReposit", "queue() called with: deadzones = [" + o5VarArr + "]");
        this.a.a(o5VarArr);
    }

    public o5[] a() {
        i.a("LoggableDeadzoneReposit", "pollAll() called");
        return this.a.a();
    }
}
