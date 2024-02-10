package com.teragence.library;

import java.util.concurrent.atomic.AtomicBoolean;

public class c2 implements d2 {
    private final d2 a;
    private final a b;

    public interface a {
        void a();
    }

    public c2(d2 d2Var, a aVar) {
        this.a = d2Var;
        this.b = aVar;
    }

    public AtomicBoolean a() {
        return this.a.a();
    }

    public void b() {
        this.a.b();
        this.b.a();
    }
}
