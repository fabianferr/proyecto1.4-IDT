package com.teragence.library;

import java.util.Date;
import java.util.UUID;

public class p1 implements n1 {
    private final r5 a;
    private final m b;
    private final e0 c;
    private final w3 d;
    private final f e;
    private final h0 f;

    public p1(r5 r5Var, m mVar, e0 e0Var, w3 w3Var, f fVar, h0 h0Var) {
        this.a = r5Var;
        this.b = mVar;
        this.c = e0Var;
        this.d = w3Var;
        this.e = fVar;
        this.f = h0Var;
    }

    private long a() {
        try {
            return this.c.b().c();
        } catch (Exception unused) {
            return 0;
        }
    }

    private UUID b() {
        try {
            return this.b.b().c();
        } catch (Exception unused) {
            return new UUID(0, 0);
        }
    }

    public void a(Exception exc) {
        m7 m7Var = new m7(a(), this.e.toString(), new n7(this.d.e(), this.d.c(), this.d.a(), this.d.b()), new l1(exc).toString(), new Date(), b());
        if (!this.a.a((v5) m7Var)) {
            this.f.a(m7Var);
        }
    }
}
