package com.teragence.library;

import com.teragence.client.b;
import com.teragence.library.a5;
import com.teragence.library.z4;
import java.io.IOException;
import java.util.Date;

public class d5 implements z4 {
    /* access modifiers changed from: private */
    public final m0 a;
    /* access modifiers changed from: private */
    public final p0 b;
    private final q c;
    private final r d;
    private final a5 e;

    class a implements a5.a {
        final /* synthetic */ i3 a;

        a(i3 i3Var) {
            this.a = i3Var;
        }

        public void a(b bVar) {
            d5.this.b.a(bVar);
            d5.this.a.a(this.a.d().d().b(), System.currentTimeMillis());
        }

        public void b(b bVar) {
            d5.this.b.a(bVar);
        }

        public void c(b bVar) {
            d5.this.b.b(bVar);
        }
    }

    public d5(m0 m0Var, p0 p0Var, q qVar, r rVar, a5 a5Var) {
        this.a = m0Var;
        this.b = p0Var;
        this.c = qVar;
        this.d = rVar;
        this.e = a5Var;
    }

    public void a(z4.a aVar, i3 i3Var) {
        c5 c5Var;
        try {
            this.e.a(i3Var, new a(i3Var));
            aVar.a();
            return;
        } catch (a1 | IOException e2) {
            this.c.a(new h7(i3Var.e(), i3Var.d(), new Date()));
            c5Var = e2;
        } catch (c5 e3) {
            this.c.a(new h7(i3Var.e(), i3Var.d(), new Date()));
            this.d.a(e3.a());
            c5Var = e3;
        } catch (l e4) {
            aVar.a(e4);
            return;
        }
        aVar.a(c5Var);
    }
}
