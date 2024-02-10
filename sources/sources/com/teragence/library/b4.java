package com.teragence.library;

import android.os.Build;
import com.teragence.client.service.CoreInfo;
import com.teragence.library.c4;

public class b4 implements c4 {
    private final m0 a;
    private final e0 b;
    private final m c;
    private final r5 d;
    private final l2 e;
    private final w3 f;
    private final x3 g;

    public b4(m0 m0Var, e0 e0Var, m mVar, r5 r5Var, l2 l2Var, w3 w3Var, x3 x3Var) {
        this.a = m0Var;
        this.b = e0Var;
        this.c = mVar;
        this.d = r5Var;
        this.e = l2Var;
        this.f = w3Var;
        this.g = x3Var;
    }

    public void a(c4.a aVar) {
        r5 r5Var = this.d;
        int i = Build.VERSION.SDK_INT;
        long c2 = this.b.b().c();
        n7 n7Var = new n7(this.f.e(), this.f.c(), this.f.a(), this.f.b());
        t5 a2 = r5Var.a((s5) new k7(i, c2, n7Var, "Android " + Build.VERSION.RELEASE, new v7(this.g.a(), this.g.b()), CoreInfo.VERSION));
        if (a2 != null) {
            i a3 = this.c.a(new k(a2, System.currentTimeMillis()));
            if (this.a.c() != a3.g()) {
                this.a.a(a3.g());
                this.e.b(a3.g());
            }
            aVar.a();
            return;
        }
        this.c.a();
        aVar.a(new Exception("GetTestConfigResponse == null"));
    }
}
