package com.teragence.client.service;

import android.content.Context;
import com.google.android.gms.common.util.GmsVersion;
import com.teragence.library.a3;
import com.teragence.library.a4;
import com.teragence.library.b0;
import com.teragence.library.b3;
import com.teragence.library.b4;
import com.teragence.library.b5;
import com.teragence.library.c0;
import com.teragence.library.c3;
import com.teragence.library.c4;
import com.teragence.library.d0;
import com.teragence.library.d2;
import com.teragence.library.d3;
import com.teragence.library.d4;
import com.teragence.library.d5;
import com.teragence.library.e0;
import com.teragence.library.e3;
import com.teragence.library.e4;
import com.teragence.library.e5;
import com.teragence.library.f0;
import com.teragence.library.f3;
import com.teragence.library.f4;
import com.teragence.library.f7;
import com.teragence.library.g0;
import com.teragence.library.g3;
import com.teragence.library.g5;
import com.teragence.library.g6;
import com.teragence.library.h0;
import com.teragence.library.h3;
import com.teragence.library.h4;
import com.teragence.library.h5;
import com.teragence.library.h6;
import com.teragence.library.i1;
import com.teragence.library.i3;
import com.teragence.library.i4;
import com.teragence.library.i5;
import com.teragence.library.j0;
import com.teragence.library.j3;
import com.teragence.library.j4;
import com.teragence.library.j5;
import com.teragence.library.k1;
import com.teragence.library.k3;
import com.teragence.library.k4;
import com.teragence.library.k5;
import com.teragence.library.l;
import com.teragence.library.l0;
import com.teragence.library.l2;
import com.teragence.library.l4;
import com.teragence.library.m;
import com.teragence.library.m0;
import com.teragence.library.m1;
import com.teragence.library.m4;
import com.teragence.library.n;
import com.teragence.library.n0;
import com.teragence.library.n4;
import com.teragence.library.o;
import com.teragence.library.o0;
import com.teragence.library.o1;
import com.teragence.library.o4;
import com.teragence.library.p;
import com.teragence.library.p0;
import com.teragence.library.p1;
import com.teragence.library.p4;
import com.teragence.library.q;
import com.teragence.library.q0;
import com.teragence.library.q3;
import com.teragence.library.q4;
import com.teragence.library.r;
import com.teragence.library.r0;
import com.teragence.library.r1;
import com.teragence.library.r2;
import com.teragence.library.r4;
import com.teragence.library.s;
import com.teragence.library.s0;
import com.teragence.library.s4;
import com.teragence.library.s6;
import com.teragence.library.t0;
import com.teragence.library.t2;
import com.teragence.library.t4;
import com.teragence.library.u0;
import com.teragence.library.u2;
import com.teragence.library.u3;
import com.teragence.library.u4;
import com.teragence.library.v;
import com.teragence.library.v2;
import com.teragence.library.v4;
import com.teragence.library.v6;
import com.teragence.library.w1;
import com.teragence.library.w2;
import com.teragence.library.x;
import com.teragence.library.x2;
import com.teragence.library.x4;
import com.teragence.library.y1;
import com.teragence.library.y2;
import com.teragence.library.y3;
import com.teragence.library.z;
import com.teragence.library.z1;
import com.teragence.library.z2;
import com.teragence.library.z3;
import com.teragence.library.z4;
import java.util.concurrent.Executors;

public class i implements f {
    private static final String z = "com.teragence.client.service.i";
    private final Context a;
    private final l2 b;
    private t0 c;
    private m0 d;
    private q e;
    private p0 f;
    private e0 g;
    private m h;
    private r i;
    private h0 j;
    private c4 k;
    private h4 l;
    private n4 m;
    /* access modifiers changed from: private */
    public z4 n;
    /* access modifiers changed from: private */
    public z4 o;
    private w2 p;
    private h3 q;
    /* access modifiers changed from: private */
    public h3 r;
    private i5 s;
    private s4 t;
    private b3 u;
    /* access modifiers changed from: private */
    public Boolean v = false;
    /* access modifiers changed from: private */
    public boolean w;
    /* access modifiers changed from: private */
    public boolean x;
    /* access modifiers changed from: private */
    public boolean y;

    class a implements b3.a {
        final /* synthetic */ d2 a;

        /* renamed from: com.teragence.client.service.i$a$a  reason: collision with other inner class name */
        class C0168a implements h3.a {

            /* renamed from: com.teragence.client.service.i$a$a$a  reason: collision with other inner class name */
            class C0169a implements z4.a {
                C0169a() {
                }

                public void a() {
                    a aVar = a.this;
                    i.this.f(aVar.a);
                }

                public void a(Exception exc) {
                    a aVar = a.this;
                    i.this.f(aVar.a);
                }
            }

            C0168a() {
            }

            public void a(i3 i3Var) {
                i.this.o.a(new C0169a(), i3Var);
            }

            public void a(Exception exc) {
                a aVar = a.this;
                i.this.f(aVar.a);
            }
        }

        a(d2 d2Var) {
            this.a = d2Var;
        }

        public void a() {
            i.this.r.a(new C0168a());
        }

        public void a(Exception exc) {
            i.this.e(this.a);
        }
    }

    class b implements h3.a {
        final /* synthetic */ d2 a;

        class a implements z4.a {
            a() {
            }

            public void a() {
                b.this.a.b();
            }

            public void a(Exception exc) {
                b.this.a.b();
            }
        }

        b(d2 d2Var) {
            this.a = d2Var;
        }

        public void a(i3 i3Var) {
            i.this.n.a(new a(), i3Var);
        }

        public void a(Exception exc) {
            this.a.b();
        }
    }

    class c implements h4.a {
        final /* synthetic */ d2 a;

        c(d2 d2Var) {
            this.a = d2Var;
        }

        public void a() {
            Boolean unused = i.this.v = false;
            i.this.g(this.a);
        }

        public void a(Exception exc) {
            Boolean unused = i.this.v = false;
            this.a.b();
        }
    }

    class d implements c4.a {
        final /* synthetic */ d2 a;

        d(d2 d2Var) {
            this.a = d2Var;
        }

        public void a() {
            Boolean unused = i.this.v = false;
            i.this.g(this.a);
        }

        public void a(Exception exc) {
            Boolean unused = i.this.v = false;
            this.a.b();
        }
    }

    class e implements w2.a {
        final /* synthetic */ d2 a;

        e(d2 d2Var) {
            this.a = d2Var;
        }

        public void a() {
            i.this.g(this.a);
        }

        public void a(Exception exc) {
            this.a.b();
        }
    }

    class f implements s4.a {
        final /* synthetic */ d2 a;

        f(d2 d2Var) {
            this.a = d2Var;
        }

        public void a() {
            boolean unused = i.this.y = true;
            i.this.g(this.a);
        }

        public void b() {
            boolean unused = i.this.y = true;
            i.this.g(this.a);
        }
    }

    class g implements i5.a {
        final /* synthetic */ d2 a;

        g(d2 d2Var) {
            this.a = d2Var;
        }

        public void a() {
            boolean unused = i.this.x = true;
            i.this.g(this.a);
        }

        public void a(Exception exc) {
            boolean unused = i.this.x = true;
            i.this.g(this.a);
        }
    }

    class h implements n4.a {
        final /* synthetic */ d2 a;

        h(d2 d2Var) {
            this.a = d2Var;
        }

        public void a() {
            boolean unused = i.this.w = true;
            i.this.g(this.a);
        }

        public void a(Exception exc) {
            boolean unused = i.this.w = true;
            i.this.g(this.a);
        }
    }

    public i(Context context, l2 l2Var) {
        this.a = context;
        this.b = l2Var;
    }

    private void a(com.teragence.library.f fVar) {
        f7 f7Var = new f7(new g6(new s6(new h6(new v6(), "https://control.teragence.net/Api/v2/Service.svc"))));
        o1 o1Var = new o1(new m1(new p1(f7Var, this.h, this.g, new y3(this.a), fVar, this.j)));
        this.k = new a4(new d4(new b4(this.d, this.g, this.h, f7Var, this.b, new y3(this.a), new z3(this.a)), o1Var), Executors.newCachedThreadPool());
        f7 f7Var2 = f7Var;
        this.l = new f4(new k4(new i4(new j4(f7Var2, this.g, new e4(this.a), new y3(this.a), new z3(this.a))), o1Var), Executors.newCachedThreadPool());
        this.m = new l4(new p4(new o4(new m4(f7Var2, this.e, this.g, this.i, new z3(this.a), new u3(this.a), fVar)), o1Var), Executors.newCachedThreadPool());
        this.t = new q4(new u4(new t4(new r4(this.j, f7Var))), Executors.newCachedThreadPool());
        this.s = new g5(new k5(new j5(new h5(f7Var, this.i)), o1Var), Executors.newCachedThreadPool());
        this.n = new v4(new e5(new b5(new d5(this.d, this.f, this.e, this.i, new x4(f7Var, new i1(this.a)))), o1Var), Executors.newCachedThreadPool());
        this.o = new v4(new e5(new b5(new d5(this.d, this.f, this.e, this.i, new x4(f7Var, new k1(this.a)))), o1Var), Executors.newCachedThreadPool());
        m0 m0Var = this.d;
        e0 e0Var = this.g;
        m mVar = this.h;
        y1 y1Var = new y1(new r1(new w1(this.a)), 30000);
        y3 y3Var = new y3(this.a);
        u3 u3Var = new u3(this.a);
        this.q = new e3(new k3(new j3(new f3(fVar, m0Var, e0Var, mVar, y1Var, y3Var, u3Var, new z3(this.a), q3.a(this.a))), o1Var), Executors.newCachedThreadPool());
        e3 e3Var = new e3(new k3(new j3(new g3(new y3(this.a), this.d, fVar, this.g, this.h, new u3(this.a), new z1(this.a), new y1(new r1(new w1(this.a)), 10000))), o1Var), Executors.newCachedThreadPool());
        this.r = e3Var;
        this.p = new u2(new y2(new x2(new v2(this.a, 86400000)), o1Var), Executors.newCachedThreadPool());
        this.u = new z2(new d3(new c3(new a3(this.a)), o1Var), Executors.newCachedThreadPool());
    }

    private void b(d2 d2Var) {
        if (!this.v.booleanValue()) {
            this.v = true;
            this.l.a(new c(d2Var));
            return;
        }
        d2Var.b();
    }

    private void c() {
        this.d = new n0(new o0(this.a.getSharedPreferences("MetricsService", 0)));
        this.g = new f0(new g0(this.a.getSharedPreferences("DeviceRepository", 0)));
        this.h = new n(new p(new o(this.a.getSharedPreferences("TestConfigSP", 0)), GmsVersion.VERSION_PARMESAN));
        this.e = new c0(new x(new s(this.a, 0, "deadzones.txt"), new v()));
        this.i = new d0(new b0(new s(this.a, 0, "FailedReports.txt"), new z()));
        this.f = new q0(new r0(this.a.getSharedPreferences("MetricsServiceStats", 0)));
        this.j = new l0(new s(this.a, 0, "log_errors.txt"), new j0());
    }

    private void c(d2 d2Var) {
        this.m.a(new h(d2Var));
    }

    private void d(d2 d2Var) {
        if (!this.v.booleanValue()) {
            this.v = true;
            this.k.a(new d(d2Var));
            return;
        }
        d2Var.b();
    }

    /* access modifiers changed from: private */
    public void e(d2 d2Var) {
        this.q.a(new b(d2Var));
    }

    /* access modifiers changed from: private */
    public void f(d2 d2Var) {
        if (this.c.a()) {
            e(d2Var);
        } else {
            d2Var.b();
        }
    }

    /* access modifiers changed from: private */
    public void g(d2 d2Var) {
        try {
            com.teragence.library.d b2 = this.g.b();
            if (b2.b()) {
                String str = z;
                com.teragence.client.i.a(str, String.format("registration expired: %d, %d, %d", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(b2.d()), Long.valueOf(b2.a())}));
                this.g.a();
                b(d2Var);
                return;
            }
            try {
                com.teragence.library.i b3 = this.h.b();
                if (b3 != null && b3.b()) {
                    String str2 = z;
                    com.teragence.client.i.a(str2, String.format("config expired: %d, %d, %d", new Object[]{Long.valueOf(System.currentTimeMillis()), Long.valueOf(b3.n()), Integer.valueOf(b3.a())}));
                    this.h.a();
                    d(d2Var);
                } else if (!this.w) {
                    c(d2Var);
                } else if (!this.x) {
                    j(d2Var);
                } else if (!this.y) {
                    i(d2Var);
                } else {
                    h(d2Var);
                }
            } catch (l e2) {
                com.teragence.client.i.a(z, "runNext: ", (Exception) e2);
                d(d2Var);
            }
        } catch (l e3) {
            com.teragence.client.i.a(z, "runNext: ", (Exception) e3);
            b(d2Var);
        }
    }

    private void h(d2 d2Var) {
        this.u.a(new a(d2Var));
    }

    private void i(d2 d2Var) {
        this.t.a(new f(d2Var));
    }

    private void j(d2 d2Var) {
        this.s.a(new g(d2Var));
    }

    public void a() {
        this.c = new s0(new u0(this.a));
        c();
        a((com.teragence.library.f) new com.teragence.library.e(new com.teragence.library.g(this.a)));
        new r2(this.d, this.g, this.h, CoreInfo.VERSION).a();
        new t2(this.b, this.h, this.d, 900000).a();
    }

    public void a(d2 d2Var) {
        this.w = false;
        this.x = false;
        this.p.a(new e(d2Var), d2Var);
    }

    public void b() {
        this.b.a();
    }
}
