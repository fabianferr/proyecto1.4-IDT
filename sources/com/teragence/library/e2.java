package com.teragence.library;

import com.teragence.client.i;
import java.util.concurrent.atomic.AtomicBoolean;

public class e2 implements d2 {
    private final d2 a;
    private final String b;

    public e2(d2 d2Var) {
        this.a = d2Var;
        this.b = d2Var.toString();
    }

    public AtomicBoolean a() {
        i.a(this.b, "didLockNetwork() called");
        return this.a.a();
    }

    public void b() {
        i.a(this.b, "release() called");
        this.a.b();
    }
}
