package com.teragence.library;

import android.os.Build;
import com.teragence.client.i;
import com.teragence.client.service.CoreInfo;
import com.teragence.client.service.k;
import com.teragence.library.h3;
import com.teragence.library.o3;

public class f3 implements h3 {
    private final f a;
    private final m0 b;
    private final e0 c;
    private final m d;
    private final q1 e;
    private final w3 f;
    private final v3 g;
    private final x3 h;
    /* access modifiers changed from: private */
    public final o3 i;

    class a extends com.teragence.client.a<k> {
        final /* synthetic */ h3.a a;

        /* renamed from: com.teragence.library.f3$a$a  reason: collision with other inner class name */
        class C0170a implements o3.a {
            final /* synthetic */ k a;

            C0170a(k kVar) {
                this.a = kVar;
            }

            public void a() {
                a aVar = a.this;
                f3.this.a(this.a, aVar.a);
            }

            public void a(float f) {
                this.a.p.put("ExtraDataBarometerPressure", String.valueOf(f));
                a aVar = a.this;
                f3.this.a(this.a, aVar.a);
            }
        }

        a(h3.a aVar) {
            this.a = aVar;
        }

        public void a(k kVar) {
            f3.this.i.a(new p3(new C0170a(kVar)));
        }
    }

    public f3(f fVar, m0 m0Var, e0 e0Var, m mVar, q1 q1Var, w3 w3Var, v3 v3Var, x3 x3Var, o3 o3Var) {
        this.a = fVar;
        this.b = m0Var;
        this.c = e0Var;
        this.d = mVar;
        this.e = q1Var;
        this.f = w3Var;
        this.g = v3Var;
        this.h = x3Var;
        this.i = o3Var;
    }

    /* access modifiers changed from: private */
    public void a(k kVar, h3.a aVar) {
        k kVar2 = kVar;
        h3.a aVar2 = aVar;
        try {
            g1 g1Var = new g1(new h1(this.f.a(this.b.d(), 5000)));
            String fVar = this.a.toString();
            long c2 = this.c.b().c();
            i b2 = this.d.b();
            boolean d2 = this.b.d();
            boolean a2 = a(kVar2.f);
            boolean z = d2;
            boolean z2 = a2;
            long j = c2;
            try {
                l7 l7Var = new l7(kVar2.a, kVar2.b, kVar2.c, kVar2.d, kVar2.e);
                n7 n7Var = new n7(kVar2.m, kVar2.n, kVar2.o, kVar2.f);
                String str = kVar2.j;
                String str2 = kVar2.h;
                o7 o7Var = new o7(n7Var, str, str2, kVar2.i, this.f.d(), g1Var.a(), g1Var.b(), kVar2.k);
                String str3 = Build.MANUFACTURER;
                String str4 = Build.MODEL;
                j7 j7Var = new j7(str3, str4, "Android " + Build.VERSION.RELEASE, Build.VERSION.SDK_INT, CoreInfo.VERSION, Double.toString(this.g.b()), this.g.a());
                aVar2 = aVar;
                aVar2.a((i3) new l3(fVar, j, b2, z, z2, l7Var, o7Var, j7Var, new v7(this.h.a(), this.h.b()), o6.a(kVar2.p)));
            } catch (l | Exception e2) {
                e = e2;
                aVar2 = aVar;
                i.a("CollectTestDataUseCase", "onAsyncResult: ", e);
                aVar2.a(e);
            }
        } catch (l | Exception e3) {
            e = e3;
        }
    }

    private boolean a(String str) {
        return System.currentTimeMillis() - this.b.b(str) > this.d.b().d();
    }

    public void a(h3.a aVar) {
        this.e.a(new a(aVar), this.d.b().l());
    }
}
