package com.umlaut.crowd.internal;

import com.umlaut.crowd.internal.tc;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.UUID;
import java.util.concurrent.Executors;

public class uc implements ta, bd {
    kb a;
    /* access modifiers changed from: private */
    public h1 b;
    private tc c;
    private long d = 1200;
    private ad e = null;
    private dd f = null;
    private cd g = new cd();
    private mb h = null;
    private lb i = null;
    private nb j = null;
    private vc k;
    private yc l;
    private b m;
    private boolean n = false;

    class a implements tc {
        a() {
        }

        public void a(kb kbVar, long j) {
        }

        public void a(kb kbVar, tc.a aVar, j7 j7Var, int i, j7[] j7VarArr) {
        }

        public void a(sa saVar, ab abVar) {
        }

        public void a(sa saVar, r5 r5Var, String str) {
        }

        public void b(kb kbVar, tc.a aVar, j7 j7Var, int i, j7[] j7VarArr) {
        }
    }

    private class b extends Thread {
        private static final long k = 200000000;
        private boolean a = true;
        private long b;
        i7 c = new i7();
        private long d;
        private long e;
        private long f;
        private int g;
        private int h;
        private long i;

        public b(long j2) {
            this.b = j2;
        }

        public i7 a() {
            return this.c;
        }

        public long b() {
            return this.i;
        }

        public void c() {
            this.a = false;
            try {
                join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:24|25|26|27) */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            r10.c = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
            r10.a = false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
            return;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x006c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r10 = this;
                long r0 = java.lang.System.nanoTime()
                com.umlaut.crowd.internal.i7 r2 = new com.umlaut.crowd.internal.i7
                r2.<init>()
            L_0x0009:
                r3 = 0
                boolean r4 = r10.a     // Catch:{ all -> 0x0095 }
                if (r4 == 0) goto L_0x0092
                long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0095 }
                long r4 = r0 - r4
                r6 = 0
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 > 0) goto L_0x0074
                long r0 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0095 }
                monitor-enter(r10)     // Catch:{ all -> 0x0095 }
                long r4 = r10.d     // Catch:{ all -> 0x0071 }
                r2.timeFirstPkg = r4     // Catch:{ all -> 0x0071 }
                long r4 = r10.e     // Catch:{ all -> 0x0071 }
                r2.timeLastPkg = r4     // Catch:{ all -> 0x0071 }
                long r4 = r10.f     // Catch:{ all -> 0x0071 }
                r2.lastSeq = r4     // Catch:{ all -> 0x0071 }
                int r4 = r10.g     // Catch:{ all -> 0x0071 }
                r2.teststatus = r4     // Catch:{ all -> 0x0071 }
                int r4 = r10.h     // Catch:{ all -> 0x0071 }
                r2.offset = r4     // Catch:{ all -> 0x0071 }
                monitor-exit(r10)     // Catch:{ all -> 0x0071 }
                r4 = 0
                com.umlaut.crowd.internal.uc r5 = com.umlaut.crowd.internal.uc.this     // Catch:{ u9 | IOException -> 0x006c }
                com.umlaut.crowd.internal.h1 r5 = r5.b     // Catch:{ u9 | IOException -> 0x006c }
                com.umlaut.crowd.internal.c7 r5 = com.umlaut.crowd.internal.uc.b(r2, r5)     // Catch:{ u9 | IOException -> 0x006c }
                if (r5 == 0) goto L_0x0067
                com.umlaut.crowd.internal.a7 r6 = r5.a()     // Catch:{ all -> 0x0095 }
                com.umlaut.crowd.internal.a7 r7 = com.umlaut.crowd.internal.a7.PROGRESS_UDP_RECEIVE_STATUS     // Catch:{ all -> 0x0095 }
                boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0095 }
                if (r6 != 0) goto L_0x004e
                goto L_0x0067
            L_0x004e:
                com.umlaut.crowd.internal.i7 r5 = (com.umlaut.crowd.internal.i7) r5     // Catch:{ all -> 0x0095 }
                r10.c = r5     // Catch:{ all -> 0x0095 }
                long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0095 }
                long r6 = r10.b     // Catch:{ all -> 0x0095 }
                long r8 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0095 }
                long r8 = r8 - r0
                long r6 = r6 - r8
                long r4 = r4 + r6
                long r0 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0095 }
                r10.i = r0     // Catch:{ all -> 0x0095 }
                r0 = r4
                goto L_0x0074
            L_0x0067:
                r10.c = r4     // Catch:{ all -> 0x0095 }
                r10.a = r3
                return
            L_0x006c:
                r10.c = r4     // Catch:{ all -> 0x0095 }
                r10.a = r3
                return
            L_0x0071:
                r0 = move-exception
                monitor-exit(r10)     // Catch:{ all -> 0x0071 }
                throw r0     // Catch:{ all -> 0x0095 }
            L_0x0074:
                long r4 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0095 }
                long r4 = r0 - r4
                long r6 = r10.b     // Catch:{ all -> 0x0095 }
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 >= 0) goto L_0x0009
                r6 = 200000000(0xbebc200, double:9.8813129E-316)
                int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r8 <= 0) goto L_0x0088
                r4 = r6
            L_0x0088:
                boolean r4 = com.umlaut.crowd.internal.q9.b(r4)     // Catch:{ all -> 0x0095 }
                if (r4 != 0) goto L_0x0009
                r10.a = r3     // Catch:{ all -> 0x0095 }
                goto L_0x0009
            L_0x0092:
                r10.a = r3
                return
            L_0x0095:
                r0 = move-exception
                r10.a = r3
                goto L_0x009a
            L_0x0099:
                throw r0
            L_0x009a:
                goto L_0x0099
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.uc.b.run():void");
        }

        public void a(i7 i7Var) {
            synchronized (this) {
                this.d = i7Var.timeFirstPkg;
                this.e = i7Var.timeLastPkg;
                this.f = i7Var.lastSeq;
                this.g = i7Var.teststatus;
                this.h = i7Var.offset;
            }
        }
    }

    public uc(kb kbVar, tc tcVar) {
        if (kbVar != null) {
            this.a = kbVar;
            if (tcVar == null) {
                this.c = new a();
            } else {
                this.c = tcVar;
            }
            if (kbVar.a().equals(ja.TEST_UDP_FIXEDTIMEFRAME)) {
                this.j = (nb) kbVar;
            } else if (kbVar.a().equals(ja.TEST_UDP_FIXEDSENDDATA)) {
                this.h = (mb) kbVar;
            } else if (kbVar.a().equals(ja.TEST_UDP_FIXEDRECEIVEDATA)) {
                this.i = (lb) kbVar;
            } else {
                throw new IllegalArgumentException("Test is not supported!");
            }
        } else {
            throw new IllegalArgumentException("given test is null!");
        }
    }

    public void a(String str) {
    }

    public void a(Throwable th) {
    }

    public sa b() {
        return this.a;
    }

    public void c() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:19|20|21|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0032 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void close() {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = 1
            r2.n = r0     // Catch:{ all -> 0x0036 }
            com.umlaut.crowd.internal.uc$b r0 = r2.m     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x000b
            r0.c()     // Catch:{ all -> 0x0036 }
        L_0x000b:
            com.umlaut.crowd.internal.ad r0 = r2.e     // Catch:{ all -> 0x0036 }
            r1 = 0
            if (r0 == 0) goto L_0x0015
            r0.b()     // Catch:{ all -> 0x0036 }
            r2.e = r1     // Catch:{ all -> 0x0036 }
        L_0x0015:
            com.umlaut.crowd.internal.dd r0 = r2.f     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x001e
            r0.b()     // Catch:{ all -> 0x0036 }
            r2.f = r1     // Catch:{ all -> 0x0036 }
        L_0x001e:
            com.umlaut.crowd.internal.cd r0 = r2.g     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x002b
            java.util.concurrent.ExecutorService r0 = r0.b     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x002b
            r0.shutdown()     // Catch:{ all -> 0x0036 }
            r2.g = r1     // Catch:{ all -> 0x0036 }
        L_0x002b:
            com.umlaut.crowd.internal.h1 r0 = r2.b     // Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0034
            r0.close()     // Catch:{ Exception -> 0x0032 }
        L_0x0032:
            r2.b = r1     // Catch:{ all -> 0x0036 }
        L_0x0034:
            monitor-exit(r2)
            return
        L_0x0036:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.uc.close():void");
    }

    public e3 d() {
        return this.c;
    }

    public void e() {
    }

    public boolean f() {
        this.c.a(this.a, ab.RUNNING);
        this.l.c((long) this.a.timeout);
        if (this.a.pkgDown != null) {
            this.l.c();
        }
        boolean z = false;
        try {
            if (!a(this.b)) {
                this.c.a(this.a, r5.REQUEST_FAILED, "Cannot start the test");
                return false;
            }
            dd ddVar = this.f;
            if (ddVar != null) {
                ddVar.start();
            }
            long nanoTime = System.nanoTime();
            i7 i7Var = new i7();
            i7 i7Var2 = new i7();
            new i7();
            long j2 = 1000000;
            b bVar = new b(this.d * 1000000);
            this.m = bVar;
            bVar.start();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                try {
                    long nanoTime2 = this.d - ((System.nanoTime() - nanoTime) / j2);
                    if (nanoTime2 > 0 && !q9.a(nanoTime2)) {
                        System.out.println("WARNING: cannot sleep the whole time");
                    }
                    long j3 = this.d;
                    Long.signum(j3);
                    nanoTime += j3 * j2;
                    if (this.a.pkgDown != null) {
                        i7Var.offset = i2;
                        i7Var2.timeFirstPkg = i7Var.timeFirstPkg;
                        i7Var2.timeLastPkg = i7Var.timeLastPkg;
                        i7Var2.lastSeq = i7Var.lastSeq;
                        this.l.a(i7Var);
                    } else {
                        i7Var.teststatus = 1;
                        i7Var2.teststatus = 1;
                    }
                    i7Var2.offset = i3;
                    this.m.a(i7Var2);
                    i7 a2 = this.m.a();
                    if (a2 == null) {
                        this.c.a(this.a, r5.REQUEST_FAILED, "Cannot get Progress from server");
                        this.m.c();
                        this.m = null;
                        return z;
                    }
                    kb kbVar = this.a;
                    if (kbVar.pkgDown != null) {
                        this.c.a(kbVar, tc.a.a(i7Var.teststatus), i7Var.global, i7Var.offset, i7Var.measurepoints);
                        i2 = i7Var.measurepoints.length + i7Var.offset;
                    }
                    if (!(this.a.pkgUp == null || this.m.b() == 0)) {
                        this.c.b(this.a, tc.a.a(a2.teststatus), a2.global, a2.offset, a2.measurepoints);
                        i3 = a2.measurepoints.length + a2.offset;
                    }
                    if (!this.n && (a2.teststatus == 0 || i7Var.teststatus == 0)) {
                        z = false;
                        j2 = 1000000;
                    }
                } finally {
                    this.m.c();
                    this.m = null;
                }
            }
            return true;
        } catch (u9 | IOException e2) {
            tc tcVar = this.c;
            kb kbVar2 = this.a;
            r5 r5Var = r5.UNEXPECTED_ERROR;
            tcVar.a(kbVar2, r5Var, "Cannot start the test: " + e2.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    public static c7 b(c7 c7Var, h1 h1Var) throws IOException, u9 {
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

    public void a(sa saVar) {
        if (saVar != null) {
            this.a = (kb) saVar;
            return;
        }
        throw new IllegalArgumentException("given test is null!");
    }

    private static boolean a(h1 h1Var) throws IOException, u9 {
        u5 a2 = h1Var.a((s5) new w9());
        return a2.c().equals(v5.MESSAGETYPE_BINARY) && ((v7) a2).successfull;
    }

    public boolean a(t6 t6Var) {
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
                    this.c.a(this.a, ab.SETUP_SOCKETS);
                    DatagramChannel open = DatagramChannel.open();
                    open.socket().bind(new InetSocketAddress(0));
                    this.l = new yc();
                    kb kbVar = this.a;
                    if (kbVar.pkgUp != null) {
                        this.k = new vc(UUID.fromString(kbVar.uuid), open, new InetSocketAddress(this.a.e().ips[0], this.a.serverPort), this.a.pkgUp.pkgSize);
                    } else {
                        this.k = new vc(UUID.fromString(kbVar.uuid), open, new InetSocketAddress(this.a.e().ips[0], this.a.serverPort));
                    }
                    xc xcVar = this.a.pkgDown;
                    if (xcVar != null) {
                        this.l.d((long) xcVar.pkgInterval);
                    }
                    cd cdVar = new cd();
                    this.g = cdVar;
                    cdVar.b = Executors.newSingleThreadExecutor();
                    this.g.a = this.l;
                    this.e = new ad(this, open);
                    if (this.a.pkgUp != null) {
                        this.f = new dd(this.a.pkgUp, this.k);
                    }
                    this.e.start();
                    this.e.c();
                    if (!a(this.b, this.a, this.k, this.l)) {
                        this.c.a(this.a, r5.TIMEOUT, "Could not receive Welcome package");
                        return false;
                    }
                    nb nbVar = this.j;
                    if (nbVar != null) {
                        this.l.b(nbVar.timeframeDown);
                    }
                    lb lbVar = this.i;
                    if (lbVar != null) {
                        this.l.a((long) lbVar.packageCntUp);
                    }
                    mb mbVar = this.h;
                    if (mbVar != null) {
                        dd ddVar = this.f;
                        if (ddVar != null) {
                            ddVar.a((long) mbVar.packageCntUp);
                        }
                        this.l.a((long) this.h.packageCntDown);
                    }
                    if (this.h != null) {
                        this.l.a(false);
                    } else {
                        this.l.a(true);
                    }
                    this.l.c((long) this.a.timeout);
                    this.c.a(this.a, this.l.e());
                    return true;
                }
            }
            tc tcVar = this.c;
            kb kbVar2 = this.a;
            r5 r5Var = r5.REQUEST_FAILED;
            tcVar.a(kbVar2, r5Var, "cannot connect to SpeedtestServer (control): " + a2);
            return false;
        } catch (IOException e2) {
            tc tcVar2 = this.c;
            kb kbVar3 = this.a;
            r5 r5Var2 = r5.IOEXCEPTION;
            tcVar2.a(kbVar3, r5Var2, "Error on starting" + " - " + e2.getMessage());
            return false;
        } catch (u9 e3) {
            tc tcVar3 = this.c;
            kb kbVar4 = this.a;
            r5 r5Var3 = r5.UNEXPECTED_ERROR;
            tcVar3.a(kbVar4, r5Var3, "Error on starting" + " - " + e3.getMessage());
            return false;
        } catch (Exception e4) {
            tc tcVar4 = this.c;
            kb kbVar5 = this.a;
            r5 r5Var4 = r5.UNEXPECTED_ERROR;
            tcVar4.a(kbVar5, r5Var4, "Error on starting" + " - " + e4.getMessage());
            return false;
        }
    }

    public boolean a() {
        i7 i7Var = new i7();
        i7 i7Var2 = new i7();
        new i7();
        i7Var.offset = 0;
        this.l.a(i7Var);
        i7Var2.offset = 0;
        i7Var2.teststatus = i7Var.teststatus;
        i7Var2.timeFirstPkg = i7Var.timeFirstPkg;
        i7Var2.timeLastPkg = i7Var.timeLastPkg;
        i7Var2.lastSeq = i7Var.lastSeq;
        if (this.a.pkgUp != null) {
            try {
                c7 b2 = b(i7Var, this.b);
                if (b2 == null || !b2.a().equals(i7Var.a())) {
                    this.c.a(this.a, r5.REQUEST_FAILED, "Cannot get Progress from server (wrong type or null)");
                    return false;
                }
                i7 i7Var3 = (i7) b2;
                this.c.b(this.a, tc.a.a(i7Var3.teststatus), i7Var3.global, i7Var3.offset, i7Var3.measurepoints);
            } catch (u9 | IOException unused) {
                this.c.a(this.a, r5.REQUEST_FAILED, "Cannot get Progress from server");
                return false;
            }
        }
        kb kbVar = this.a;
        if (kbVar.pkgDown != null) {
            this.c.a(kbVar, tc.a.a(i7Var.teststatus), i7Var.global, i7Var.offset, i7Var.measurepoints);
        }
        this.c.a(this.a, ab.FINISHED);
        return true;
    }

    public cd a(wc wcVar) {
        return this.g;
    }

    private static boolean a(h1 h1Var, kb kbVar, vc vcVar, yc ycVar) throws IOException, u9 {
        int i2 = 0;
        while (i2 <= kbVar.initRetries) {
            i2++;
            vcVar.c();
            if (ycVar.e((long) kbVar.initRetryTimeout)) {
                break;
            }
        }
        if (i2 > kbVar.initRetries) {
            return false;
        }
        return true;
    }

    public void a(long j2) {
        this.d = j2;
    }
}
