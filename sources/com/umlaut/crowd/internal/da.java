package com.umlaut.crowd.internal;

import java.io.IOException;
import java.security.KeyManagementException;
import org.java_websocket.WebSocketImpl;

public class da implements ta {
    /* access modifiers changed from: private */
    public gb a;
    private qb b;
    /* access modifiers changed from: private */
    public ca c;
    private h1 d;
    private rb e;

    class a implements ca {
        a() {
        }

        public void a(gb gbVar, int i, long j) {
        }

        public void a(sa saVar, ab abVar) {
        }

        public void a(sa saVar, r5 r5Var, String str) {
        }
    }

    class b implements ya {
        b() {
        }

        public void a(int i, long j) {
            da.this.c.a(da.this.a, i, j);
        }

        public void a(Throwable th) {
            da.this.c.a(da.this.a, r5.UNEXPECTED_ERROR, th.getMessage());
        }
    }

    public da(gb gbVar, ca caVar) {
        this.a = gbVar;
        if (caVar == null) {
            this.c = new a();
        } else {
            this.c = caVar;
        }
    }

    public void close() {
        qb qbVar = this.b;
        if (qbVar != null) {
            qbVar.a();
            this.b = null;
        }
        rb rbVar = this.e;
        if (rbVar != null) {
            rbVar.a();
            this.e = null;
        }
        h1 h1Var = this.d;
        if (h1Var != null) {
            try {
                h1Var.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.d = null;
        }
    }

    public e3 d() {
        return this.c;
    }

    public boolean f() {
        this.c.a(this.a, ab.RUNNING);
        try {
            u5 a2 = this.d.a((s5) new w9());
            if (a2 == null || !(a2 instanceof v7) || !((v7) a2).successfull) {
                this.c.a(this.a, r5.CLOSED_BY_PEER, "server rejected the test");
                return false;
            }
            this.b.start();
            try {
                this.b.join();
                return true;
            } catch (InterruptedException unused) {
                return false;
            }
        } catch (u9 | IOException e2) {
            ca caVar = this.c;
            gb gbVar = this.a;
            r5 r5Var = r5.IOEXCEPTION;
            caVar.a(gbVar, r5Var, "cannot start the Test: " + e2.getMessage());
            return false;
        }
    }

    public sa b() {
        return this.a;
    }

    public boolean a(t6 t6Var) {
        r9[] r9VarArr;
        try {
            this.c.a(this.a, ab.CONNECT);
            h1 h1Var = new h1(this.a.e().ips[0], t6Var.g, t6Var.i);
            this.d = h1Var;
            if (!h1Var.g()) {
                this.c.a(this.a, r5.CONNECTION_REFUSED, "cannot connect to SpeedtestServer (control)");
                return false;
            }
            this.c.a(this.a, ab.REGISTER);
            o7 o7Var = new o7();
            o7Var.test = ua.a((sa) this.a);
            u5 a2 = this.d.a((s5) o7Var);
            if (a2 != null && a2.c().equals(v5.MESSAGETYPE_BINARY)) {
                if (((v7) a2).successfull) {
                    this.c.a(this.a, ab.SETUP_SOCKETS);
                    rb rbVar = new rb();
                    this.e = rbVar;
                    if (t6Var.c) {
                        r9VarArr = rbVar.a(this.a.e().ips[0], this.a, 1, t6Var.i, WebSocketImpl.DEFAULT_WSS_PORT, true);
                    } else {
                        r9VarArr = rbVar.a(this.a.e().ips[0], this.a, 1, t6Var.i, t6Var.g, false);
                    }
                    if (r9VarArr == null) {
                        this.c.a(this.a, r5.CONNECTION_REFUSED, "cannot connect testsockets");
                        return false;
                    }
                    qb qbVar = new qb(true, this.a);
                    this.b = qbVar;
                    qbVar.a((ya) new b());
                    this.b.a(r9VarArr[0]);
                    return true;
                }
            }
            ca caVar = this.c;
            gb gbVar = this.a;
            r5 r5Var = r5.REQUEST_FAILED;
            caVar.a(gbVar, r5Var, "cannot connect to SpeedtestServer (control): " + a2);
            return false;
        } catch (IOException e2) {
            ca caVar2 = this.c;
            gb gbVar2 = this.a;
            r5 r5Var2 = r5.IOEXCEPTION;
            caVar2.a(gbVar2, r5Var2, "Error on starting" + " - " + e2.getMessage());
            return false;
        } catch (u9 e3) {
            ca caVar3 = this.c;
            gb gbVar3 = this.a;
            r5 r5Var3 = r5.UNEXPECTED_ERROR;
            caVar3.a(gbVar3, r5Var3, "Error on starting" + " - " + e3.getMessage());
            return false;
        } catch (KeyManagementException e4) {
            ca caVar4 = this.c;
            gb gbVar4 = this.a;
            r5 r5Var4 = r5.UNEXPECTED_ERROR;
            caVar4.a(gbVar4, r5Var4, "Error on starting" + " - " + e4.getMessage());
            return false;
        } catch (Exception e5) {
            ca caVar5 = this.c;
            gb gbVar5 = this.a;
            r5 r5Var5 = r5.UNEXPECTED_ERROR;
            caVar5.a(gbVar5, r5Var5, "Error on starting" + " - " + e5.getMessage());
            return false;
        }
    }

    public boolean a() {
        this.c.a(this.a, ab.FINISHED);
        return true;
    }

    public void a(sa saVar) {
        this.a = (gb) saVar;
    }
}
