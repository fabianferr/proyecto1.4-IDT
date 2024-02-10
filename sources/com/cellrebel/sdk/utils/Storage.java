package com.cellrebel.sdk.utils;

import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.database.Timestamps;
import com.cellrebel.sdk.database.dao.TimestampsDAO;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.List;

public class Storage {
    private static volatile Storage c;
    private TimestampsDAO a;
    private volatile Timestamps b;

    private Storage() {
        if (c == null) {
            try {
                if (DatabaseClient.a() != null) {
                    TimestampsDAO q = DatabaseClient.a().q();
                    this.a = q;
                    if (q != null) {
                        List<Timestamps> all = q.getAll();
                        if (CollectionUtils.isEmpty(all)) {
                            this.a.a(new Timestamps());
                        } else {
                            this.b = all.get(0);
                        }
                    }
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        } else {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static Storage J() {
        if (c == null) {
            synchronized (Storage.class) {
                if (c == null) {
                    c = new Storage();
                }
            }
        }
        return c;
    }

    public long A() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.S;
    }

    public void A(long j) {
        this.b = O();
        if (this.b == null) {
            this.b = new Timestamps();
        }
        this.b.N = j;
        this.a.a();
        this.a.a(this.b);
    }

    public long B() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.B;
    }

    public void B(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.I = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long C() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.I;
    }

    public void C(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.U = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long D() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.U;
    }

    public void D(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.H = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long E() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.H;
    }

    public void E(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.T = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long F() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.T;
    }

    public void F(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.A = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long G() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.A;
    }

    public void G(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.M = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long H() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.M;
    }

    public void H(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.j = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long I() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.j;
    }

    public void I(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.u = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void J(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.b = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long K() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.u;
    }

    public void K(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.p = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long L() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.b;
    }

    public void L(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.v = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long M() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.p;
    }

    public void M(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.k = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long N() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.v;
    }

    public void N(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.m = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public Timestamps O() {
        try {
            if (this.b == null) {
                List<Timestamps> all = this.a.getAll();
                this.b = CollectionUtils.isEmpty(all) ? new Timestamps() : all.get(0);
            }
            return this.b;
        } catch (Exception | OutOfMemoryError unused) {
            this.b = new Timestamps();
            return this.b;
        }
    }

    public void O(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.l = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long P() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.k;
    }

    public void P(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.e = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long Q() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.m;
    }

    public long R() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.l;
    }

    public long S() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.e;
    }

    public void a() {
        try {
            this.b = null;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void a(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.t = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long b() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.t;
    }

    public void b(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.d = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long c() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.d;
    }

    public void c(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.h = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long d() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.h;
    }

    public void d(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.i = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long e() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.i;
    }

    public void e(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.f = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long f() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.f;
    }

    public void f(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.g = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long g() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.n;
    }

    public void g(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.c = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long h() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.c;
    }

    public void h(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.z = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long i() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.z;
    }

    public void i(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.L = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long j() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.L;
    }

    public void j(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.C = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long k() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.C;
    }

    public void k(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.O = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long l() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.O;
    }

    public void l(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.F = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long m() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.F;
    }

    public void m(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.Q = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long n() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.Q;
    }

    public void n(long j) {
        this.b = O();
        if (this.b == null) {
            this.b = new Timestamps();
        }
        this.b.x = j;
        this.a.a();
        this.a.a(this.b);
    }

    public long o() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.x;
    }

    public void o(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.y = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long p() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.y;
    }

    public void p(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.K = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long q() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.K;
    }

    public void q(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.D = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long r() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.D;
    }

    public void r(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.P = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long s() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.P;
    }

    public void s(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.r = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long t() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.r;
    }

    public void t(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.s = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long u() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.s;
    }

    public void u(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.E = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long v() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.E;
    }

    public void v(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.w = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long w() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.R;
    }

    public void w(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.J = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long x() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.w;
    }

    public void x(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.G = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long y() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.J;
    }

    public void y(long j) {
        try {
            this.b = O();
            if (this.b == null) {
                this.b = new Timestamps();
            }
            this.b.S = j;
            TimestampsDAO timestampsDAO = this.a;
            if (timestampsDAO != null) {
                timestampsDAO.a();
                this.a.a(this.b);
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long z() {
        Timestamps O = O();
        if (O == null) {
            O = new Timestamps();
        }
        return O.G;
    }

    public void z(long j) {
        this.b = O();
        if (this.b == null) {
            this.b = new Timestamps();
        }
        this.b.B = j;
        this.a.a();
        this.a.a(this.b);
    }
}
