package com.teragence.library;

import com.teragence.client.i;
import java.util.concurrent.atomic.AtomicBoolean;

public class i2 implements d2 {
    private final d2 a;

    public i2(d2 d2Var) {
        this.a = d2Var;
    }

    public AtomicBoolean a() {
        return this.a.a();
    }

    public void b() {
        try {
            this.a.b();
        } catch (Exception e) {
            i.b("SafeResourceLock", e.getMessage());
        }
    }
}
