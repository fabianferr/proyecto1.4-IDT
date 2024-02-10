package com.umlaut.crowd.internal;

import java.io.IOException;

public class t2 implements ta {
    /* access modifiers changed from: private */
    public na a;
    private h1 b;
    /* access modifiers changed from: private */
    public s2 c;
    private m2 d;

    class a implements s2 {
        a() {
        }

        public void a(na naVar, int i, long j) {
        }

        public void a(na naVar, int i, long j, long j2, long[] jArr) {
        }

        public void a(na naVar, long j) {
        }

        public void a(sa saVar, ab abVar) {
        }

        public void a(sa saVar, r5 r5Var, String str) {
        }

        public void b(na naVar, long j) {
        }

        public void c(na naVar, long j) {
        }
    }

    class b implements q2 {
        b() {
        }

        public void a(long j) {
            t2.this.c.c(t2.this.a, j);
        }

        public void b(long j) {
            t2.this.c.a(t2.this.a, j);
        }

        public void a(Throwable th) {
            t2.this.c.a(t2.this.a, r5.UNKNOWN, th.getMessage());
        }

        public void a(int i, long j) {
            t2.this.c.a(t2.this.a, i, j);
        }
    }

    public t2(na naVar, s2 s2Var) {
        this.a = naVar;
        if (s2Var == null) {
            this.c = new a();
        } else {
            this.c = s2Var;
        }
    }

    public void close() {
        m2 m2Var = this.d;
        if (m2Var != null) {
            try {
                m2Var.close();
            } catch (IOException unused) {
            }
            this.d = null;
        }
        h1 h1Var = this.b;
        if (h1Var != null) {
            try {
                h1Var.close();
            } catch (Exception unused2) {
            }
            this.b = null;
        }
    }

    public e3 d() {
        return this.c;
    }

    public boolean f() {
        this.c.a(this.a, ab.RUNNING);
        long nanoTime = System.nanoTime();
        try {
            this.d.h();
            this.c.b(this.a, System.nanoTime() - nanoTime);
            if (this.a.customServer == null) {
                try {
                    u5 a2 = this.b.a((s5) new w9());
                    if (a2 == null || !(a2 instanceof v7) || !((v7) a2).successfull) {
                        this.c.a(this.a, r5.CLOSED_BY_PEER, "server rejected starting the test");
                        return false;
                    }
                } catch (u9 | IOException e) {
                    s2 s2Var = this.c;
                    na naVar = this.a;
                    r5 r5Var = r5.IOEXCEPTION;
                    s2Var.a(naVar, r5Var, "cannot start the Test: " + e.getMessage());
                    return false;
                }
            }
            try {
                this.d.i();
                return true;
            } catch (IOException e2) {
                s2 s2Var2 = this.c;
                na naVar2 = this.a;
                r5 r5Var2 = r5.IOEXCEPTION;
                s2Var2.a(naVar2, r5Var2, "error during transfer data: " + e2.getMessage());
                return false;
            }
        } catch (IOException e3) {
            s2 s2Var3 = this.c;
            na naVar3 = this.a;
            r5 r5Var3 = r5.IOEXCEPTION;
            s2Var3.a(naVar3, r5Var3, "error during NOOP: " + e3.getMessage());
            return false;
        }
    }

    public void a(sa saVar) {
        this.a = (na) saVar;
    }

    public sa b() {
        return this.a;
    }

    public boolean a(t6 t6Var) {
        try {
            na naVar = this.a;
            if (naVar.customServer == null) {
                this.c.a(naVar, ab.CONNECT);
                h1 h1Var = new h1(this.a.e().ips[0], t6Var.g, t6Var.i);
                this.b = h1Var;
                if (!h1Var.g()) {
                    this.c.a(this.a, r5.CONNECTION_REFUSED, "cannot connect to SpeedtestServer (control)");
                    return false;
                }
                this.c.a(this.a, ab.REGISTER);
                o7 o7Var = new o7();
                o7Var.test = ua.a((sa) this.a);
                u5 a2 = this.b.a((s5) o7Var);
                if (a2 == null || !a2.c().equals(v5.MESSAGETYPE_BINARY) || !((v7) a2).successfull) {
                    s2 s2Var = this.c;
                    na naVar2 = this.a;
                    r5 r5Var = r5.REQUEST_FAILED;
                    s2Var.a(naVar2, r5Var, "cannot connect to SpeedtestServer (control): " + a2);
                    return false;
                }
            }
            this.c.a(this.a, ab.SETUP_SOCKETS);
            m2 m2Var = new m2(this.a);
            this.d = m2Var;
            m2Var.a((q2) new b());
            this.d.g();
            return true;
        } catch (IOException e) {
            s2 s2Var2 = this.c;
            na naVar3 = this.a;
            r5 r5Var2 = r5.IOEXCEPTION;
            s2Var2.a(naVar3, r5Var2, "Error on starting" + " - " + e.getMessage());
            return false;
        } catch (u9 e2) {
            s2 s2Var3 = this.c;
            na naVar4 = this.a;
            r5 r5Var3 = r5.UNEXPECTED_ERROR;
            s2Var3.a(naVar4, r5Var3, "Error on starting" + " - " + e2.getMessage());
            return false;
        } catch (Exception e3) {
            s2 s2Var4 = this.c;
            na naVar5 = this.a;
            r5 r5Var4 = r5.UNEXPECTED_ERROR;
            s2Var4.a(naVar5, r5Var4, "Error on starting" + " - " + e3.getMessage());
            return false;
        }
    }

    public boolean a() {
        if (this.a.customServer != null) {
            return true;
        }
        b7 b7Var = new b7();
        b7Var.offset = 0;
        try {
            b7 b7Var2 = (b7) a(b7Var, this.b);
            if (b7Var2 == null) {
                return true;
            }
            this.c.a(this.a, 0, b7Var2.starttime, b7Var2.endtime, b7Var2.measurepoints);
            this.c.a(this.a, ab.FINISHED);
            return true;
        } catch (u9 | IOException e) {
            s2 s2Var = this.c;
            na naVar = this.a;
            r5 r5Var = r5.IOEXCEPTION;
            s2Var.a(naVar, r5Var, "cannot get Process from remote host : " + e.getMessage());
            return false;
        }
    }

    private static c7 a(c7 c7Var, h1 h1Var) throws IOException, u9 {
        d0 d0Var = new d0();
        d0Var.progress = d7.a(c7Var);
        u5 a2 = h1Var.a((s5) d0Var);
        if (a2 == null || !a2.c().equals(v5.MESSAGETYPE_PROGRESS)) {
            return null;
        }
        d0 d0Var2 = (d0) a2;
        if (d0Var2.progress.progressType.equals(c7Var.a())) {
            return d0Var2.progress.msg;
        }
        return null;
    }
}
