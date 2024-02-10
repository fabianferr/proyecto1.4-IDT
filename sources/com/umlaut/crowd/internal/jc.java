package com.umlaut.crowd.internal;

import java.io.IOException;

public class jc implements ta {
    private jb a;
    private ic b;
    private h1 c;

    class a implements ic {
        a() {
        }

        public void a(sa saVar, ab abVar) {
        }

        public void a(sa saVar, fc fcVar) {
        }

        public void a(sa saVar, r5 r5Var, String str) {
        }
    }

    public jc(jb jbVar, ic icVar) {
        this.a = jbVar;
        if (icVar == null) {
            this.b = new a();
        } else {
            this.b = icVar;
        }
    }

    public sa b() {
        return this.a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:2|3|4|5|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r2 = this;
            com.umlaut.crowd.internal.h1 r0 = r2.c
            if (r0 == 0) goto L_0x0019
            com.umlaut.crowd.internal.e0 r1 = new com.umlaut.crowd.internal.e0     // Catch:{ Exception -> 0x000c }
            r1.<init>()     // Catch:{ Exception -> 0x000c }
            r0.a((com.umlaut.crowd.internal.s5) r1)     // Catch:{ Exception -> 0x000c }
        L_0x000c:
            com.umlaut.crowd.internal.h1 r0 = r2.c     // Catch:{ Exception -> 0x0012 }
            r0.close()     // Catch:{ Exception -> 0x0012 }
            goto L_0x0016
        L_0x0012:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0016:
            r0 = 0
            r2.c = r0
        L_0x0019:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.jc.close():void");
    }

    public e3 d() {
        return this.b;
    }

    public boolean f() {
        ec[][] ecVarArr;
        String str;
        this.b.a(this.a, ab.RUNNING);
        try {
            u5 a2 = this.c.a((s5) new w9());
            if (a2 == null || !(a2 instanceof v7) || !((v7) a2).successfull) {
                this.b.a(this.a, r5.CLOSED_BY_PEER, "server rejected the test");
                return false;
            }
            d0 d0Var = new d0();
            h7 h7Var = new h7();
            h7Var.signed = false;
            h7Var.offset = 0;
            d0Var.progress = d7.a((c7) h7Var);
            while (true) {
                if (!q9.a(100)) {
                    System.out.println("WARN: Clould not sleep the whole time");
                }
                try {
                    u5 a3 = this.c.a((s5) d0Var);
                    if (a3 == null) {
                        this.b.a(this.a, r5.CONNECTION_REFUSED, "Connection aborted");
                        return true;
                    } else if (a3.c().equals(v5.MESSAGETYPE_PROGRESS)) {
                        d0 d0Var2 = (d0) a3;
                        if (d0Var2.progress.progressType.equals(a7.PROGRESS_TRACEROUTE)) {
                            h7 h7Var2 = (h7) d0Var2.progress.msg;
                            if (h7Var2.measurepoints != null) {
                                int i = 0;
                                while (true) {
                                    ecVarArr = h7Var2.measurepoints;
                                    if (i >= ecVarArr.length) {
                                        break;
                                    }
                                    dc dcVar = new dc(h7Var.offset + i);
                                    int i2 = 0;
                                    while (true) {
                                        ec[] ecVarArr2 = h7Var2.measurepoints[i];
                                        if (i2 >= ecVarArr2.length) {
                                            break;
                                        }
                                        ec ecVar = ecVarArr2[i2];
                                        m3 m3Var = new m3();
                                        if (ecVar == null || ecVar.host == null || (str = ecVar.ip) == null) {
                                            m3Var.a("*");
                                        } else {
                                            m3Var.a(str);
                                        }
                                        if (ecVar == null || ecVar.measurement.equals("*")) {
                                            m3Var.a(-1.0d);
                                        } else {
                                            m3Var.a(Double.parseDouble(ecVar.measurement));
                                        }
                                        dcVar.a(m3Var);
                                        i2++;
                                    }
                                    this.b.a(this.a, new fc(dcVar));
                                    i++;
                                }
                                h7Var.offset += ecVarArr.length;
                            }
                            int i3 = h7Var2.status;
                            if (i3 != 0) {
                                if (i3 == 2) {
                                    return true;
                                }
                                this.b.a(this.a, r5.UNEXPECTED_ERROR, "Unknown status reported");
                                return true;
                            }
                        } else {
                            this.b.a(this.a, r5.REQUEST_FAILED, "controlserver respond with wrong Message");
                            return true;
                        }
                    } else if (a3.c().equals(v5.MESSAGETYPE_FAIL)) {
                        this.b.a(this.a, r5.REQUEST_FAILED, "Request failed because: " + ((w7) a3).message);
                        return true;
                    }
                } catch (u9 | IOException e) {
                    this.b.a(this.a, r5.CONNECTION_REFUSED, "Connection aborted: " + e.getMessage());
                    return true;
                }
            }
        } catch (u9 | IOException e2) {
            this.b.a(this.a, r5.IOEXCEPTION, "cannot start the Test: " + e2.getMessage());
            return false;
        }
    }

    public boolean a(t6 t6Var) {
        try {
            this.b.a(this.a, ab.CONNECT);
            h1 h1Var = new h1(this.a.e().ips[0], t6Var.g, t6Var.i);
            this.c = h1Var;
            if (!h1Var.g()) {
                this.b.a(this.a, r5.CONNECTION_REFUSED, "cannot connect to SpeedtestServer (control)");
                return false;
            }
            this.b.a(this.a, ab.REGISTER);
            o7 o7Var = new o7();
            o7Var.test = ua.a((sa) this.a);
            u5 a2 = this.c.a((s5) o7Var);
            if (a2 != null && a2.c().equals(v5.MESSAGETYPE_BINARY)) {
                if (((v7) a2).successfull) {
                    return true;
                }
            }
            ic icVar = this.b;
            jb jbVar = this.a;
            r5 r5Var = r5.REQUEST_FAILED;
            icVar.a(jbVar, r5Var, "cannot connect to SpeedtestServer (control): " + a2);
            return false;
        } catch (IOException e) {
            ic icVar2 = this.b;
            jb jbVar2 = this.a;
            r5 r5Var2 = r5.IOEXCEPTION;
            icVar2.a(jbVar2, r5Var2, "Error on starting" + " - " + e.getMessage());
            return false;
        } catch (u9 e2) {
            ic icVar3 = this.b;
            jb jbVar3 = this.a;
            r5 r5Var3 = r5.UNEXPECTED_ERROR;
            icVar3.a(jbVar3, r5Var3, "Error on starting" + " - " + e2.getMessage());
            return false;
        } catch (Exception e3) {
            ic icVar4 = this.b;
            jb jbVar4 = this.a;
            r5 r5Var4 = r5.UNEXPECTED_ERROR;
            icVar4.a(jbVar4, r5Var4, "Error on starting" + " - " + e3.getMessage());
            return false;
        }
    }

    public boolean a() {
        this.b.a(this.a, ab.FINISHED);
        return true;
    }

    public void a(sa saVar) {
        this.a = (jb) saVar;
    }
}
