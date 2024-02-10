package com.teragence.library;

import android.os.Build;
import com.teragence.client.service.CoreInfo;
import com.teragence.library.n4;
import java.util.Date;

public class m4 implements n4 {
    private final r5 a;
    private final q b;
    private final e0 c;
    private final r d;
    private final x3 e;
    private final v3 f;
    private final f g;

    private class a extends RuntimeException {
        a(m4 m4Var, String str) {
            super(str);
        }
    }

    public m4(r5 r5Var, q qVar, e0 e0Var, r rVar, x3 x3Var, v3 v3Var, f fVar) {
        this.a = r5Var;
        this.b = qVar;
        this.c = e0Var;
        this.d = rVar;
        this.e = x3Var;
        this.f = v3Var;
        this.g = fVar;
    }

    private void a(o5[] o5VarArr) {
        r5 r5Var = this.a;
        String fVar = this.g.toString();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (!r5Var.a((c6) new s7(o5VarArr, fVar, new j7(str, str2, "Android " + Build.VERSION.RELEASE, Build.VERSION.SDK_INT, CoreInfo.VERSION, Double.toString(this.f.b()), this.f.a()), new v7(this.e.a(), this.e.b())))) {
            throw new a(this, "some problem with a server or connection");
        }
    }

    private void b(o5[] o5VarArr) {
        Date date = new Date();
        for (o5 o5Var : o5VarArr) {
            u7 u7Var = r2;
            u7 u7Var2 = new u7(this.c.b().c(), date, this.g.toString(), o5Var.d().d(), n5.Failed, s2.a(o5Var.e()), o5Var.d().a().length() > 0, o5Var.d().g().length() > 0);
            if (!this.a.a((e6) u7Var)) {
                this.d.a(u7Var);
            }
        }
    }

    public void a(n4.a aVar) {
        o5[] a2 = this.b.a();
        try {
            if (a2.length > 0) {
                a(a2);
                b(a2);
            }
            aVar.a();
        } catch (l | a e2) {
            this.b.a(a2);
            aVar.a(e2);
        }
    }
}
