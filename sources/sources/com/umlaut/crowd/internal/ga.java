package com.umlaut.crowd.internal;

import java.io.IOException;
import org.java_websocket.WebSocketImpl;

public class ga implements ta {
    db a;
    private h1 b;
    /* access modifiers changed from: private */
    public fa c;
    private int d;
    private za e = new a();
    private rb f;
    private xa g;

    class a implements za {
        a() {
        }

        public long a() {
            return ga.this.a.reportingInterval;
        }

        public void b(long j) {
            ga.this.c.b(ga.this.a, j);
        }

        public void a(long j) {
            ga.this.c.a(ga.this.a, j);
        }

        public void a(int i, long j) {
            ga.this.c.a(ga.this.a, i, j);
        }

        public void a(Throwable th) {
            fa a2 = ga.this.c;
            db dbVar = ga.this.a;
            r5 r5Var = r5.UNEXPECTED_ERROR;
            a2.a(dbVar, r5Var, "Error occurred : " + th.getMessage());
        }
    }

    class b implements fa {
        b() {
        }

        public void a(db dbVar, int i, long j) {
        }

        public void a(db dbVar, int i, long j, long j2, long[] jArr) {
        }

        public void a(db dbVar, long j) {
        }

        public void a(sa saVar, ab abVar) {
        }

        public void a(sa saVar, r5 r5Var, String str) {
        }

        public void b(db dbVar, long j) {
        }
    }

    public ga(db dbVar, fa faVar) {
        this.a = dbVar;
        if (faVar == null) {
            this.c = new b();
        } else {
            this.c = faVar;
        }
    }

    public sa b() {
        return this.a;
    }

    public synchronized void close() {
        xa xaVar = this.g;
        if (xaVar != null) {
            xaVar.k();
            this.g.a();
            this.g = null;
        }
        h1 h1Var = this.b;
        if (h1Var != null) {
            try {
                h1Var.close();
                this.b = null;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return;
    }

    public e3 d() {
        return this.c;
    }

    public boolean f() {
        this.c.a(this.a, ab.RUNNING);
        this.g.start();
        try {
            u5 a2 = this.b.a((s5) new w9());
            if (a2 == null || !(a2 instanceof v7) || !((v7) a2).successfull) {
                this.c.a(this.a, r5.CLOSED_BY_PEER, "server rejected starting the test");
                return false;
            }
            try {
                this.g.join();
                return true;
            } catch (InterruptedException unused) {
                return false;
            }
        } catch (u9 | IOException e2) {
            fa faVar = this.c;
            db dbVar = this.a;
            r5 r5Var = r5.IOEXCEPTION;
            faVar.a(dbVar, r5Var, "cannot start the Test: " + e2.getMessage());
            return false;
        }
    }

    public void a(sa saVar) {
        this.a = (db) saVar;
    }

    public boolean a(t6 t6Var) {
        r9[] r9VarArr;
        this.d = t6Var.i;
        try {
            this.c.a(this.a, ab.CONNECT);
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
            if (a2 != null && a2.c().equals(v5.MESSAGETYPE_BINARY)) {
                if (((v7) a2).successfull) {
                    this.g = null;
                    this.c.a(this.a, ab.SETUP_SOCKETS);
                    if (this.a.c()) {
                        this.g = new xa(true);
                    } else {
                        this.g = new xa(false);
                    }
                    this.g.b(this.a.testSockets);
                    this.g.setDaemon(true);
                    this.g.c((long) t6Var.i);
                    db dbVar = this.a;
                    if (dbVar instanceof eb) {
                        this.g.a(((eb) dbVar).measureLength);
                    } else if (dbVar instanceof fb) {
                        this.g.b(((fb) dbVar).payloadsize);
                    }
                    this.g.a(this.e);
                    rb rbVar = new rb();
                    this.f = rbVar;
                    if (t6Var.c) {
                        String str = this.a.e().ips[0];
                        db dbVar2 = this.a;
                        r9VarArr = rbVar.a(str, dbVar2, dbVar2.testSockets, t6Var.i, WebSocketImpl.DEFAULT_WSS_PORT, true);
                    } else {
                        String str2 = this.a.e().ips[0];
                        db dbVar3 = this.a;
                        r9VarArr = rbVar.a(str2, dbVar3, dbVar3.testSockets, t6Var.i, t6Var.g, false);
                    }
                    if (r9VarArr == null) {
                        this.c.a(this.a, r5.CONNECTION_REFUSED, "cannot connect testsockets");
                        return false;
                    }
                    for (r9 a3 : r9VarArr) {
                        this.g.a(a3);
                    }
                    return true;
                }
            }
            this.c.a(this.a, r5.REQUEST_FAILED, "cannot connect to SpeedtestServer (control): " + a2);
            return false;
        } catch (IOException e2) {
            this.c.a(this.a, r5.IOEXCEPTION, "Error on starting" + " - " + e2.getMessage());
            return false;
        } catch (u9 e3) {
            this.c.a(this.a, r5.UNEXPECTED_ERROR, "Error on starting" + " - " + e3.getMessage());
            return false;
        } catch (Exception e4) {
            this.c.a(this.a, r5.UNEXPECTED_ERROR, "Error on starting" + " - " + e4.getMessage());
            return false;
        }
    }

    public boolean a() {
        d0 d0Var = new d0();
        f7 f7Var = new f7();
        f7Var.signed = true;
        f7Var.offset = 0;
        d0Var.progress = d7.a((c7) f7Var);
        try {
            u5 a2 = this.b.a((s5) d0Var);
            if (a2 == null || !(a2 instanceof d0)) {
                this.c.a(this.a, r5.CLOSED_BY_PEER, "server rejected the report");
                return false;
            } else if (a2.c().equals(v5.MESSAGETYPE_PROGRESS)) {
                d0 d0Var2 = (d0) a2;
                if (d0Var2.progress.progressType.equals(a7.PROGRESS_TCP2)) {
                    e7 e7Var = (e7) d0Var2.progress.msg;
                    this.c.a(this.a, 0, e7Var.starttime, e7Var.endtime, e7Var.measurepoints);
                } else if (d0Var2.progress.progressType.equals(a7.PROGRESS_TCP3)) {
                    f7 f7Var2 = (f7) d0Var2.progress.msg;
                    this.c.a(this.a, 0, f7Var2.starttime, f7Var2.endtime, f7Var2.measurepoints);
                    if (f7Var2.error != null) {
                        fa faVar = this.c;
                        db dbVar = this.a;
                        r5 r5Var = r5.SERVER_ERROR;
                        faVar.a(dbVar, r5Var, "Error on Server side: " + f7Var2.error);
                    }
                }
                this.c.a(this.a, ab.FINISHED);
                return true;
            } else {
                fa faVar2 = this.c;
                db dbVar2 = this.a;
                r5 r5Var2 = r5.IOEXCEPTION;
                faVar2.a(dbVar2, r5Var2, "Unknown ProgressType:" + d0Var.progress.progressType);
                return false;
            }
        } catch (u9 | IOException e2) {
            fa faVar3 = this.c;
            db dbVar3 = this.a;
            r5 r5Var3 = r5.IOEXCEPTION;
            faVar3.a(dbVar3, r5Var3, "cannot get progress: " + e2.getMessage());
            return false;
        }
    }
}
