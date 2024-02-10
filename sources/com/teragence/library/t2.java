package com.teragence.library;

import com.teragence.client.i;

public class t2 {
    private final l2 a;
    private final m b;
    private final m0 c;
    private final int d;

    public t2(l2 l2Var, m mVar, m0 m0Var, int i) {
        this.a = l2Var;
        this.b = mVar;
        this.c = m0Var;
        this.d = i;
    }

    public void a() {
        try {
            this.a.a(this.b.b().g());
        } catch (l e) {
            i.a("SetUpSchedulerUseCase", "execute: ", (Throwable) e);
            this.c.a(this.d);
            this.a.a(this.c.c());
        }
    }
}
