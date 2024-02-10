package com.umlaut.crowd.internal;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class v2 extends Thread {
    private static final String E = "v2";
    private static final boolean F = false;
    private static final String G = "\r\n";
    /* access modifiers changed from: private */
    public long A;
    /* access modifiers changed from: private */
    public CountDownLatch B;
    /* access modifiers changed from: private */
    public final int C;
    /* access modifiers changed from: private */
    public final Object D = new Object();
    private final String[] a;
    /* access modifiers changed from: private */
    public final List<String> b;
    /* access modifiers changed from: private */
    public final List<x7> c;
    private long d;
    /* access modifiers changed from: private */
    public long e;
    /* access modifiers changed from: private */
    public final AtomicLong f = new AtomicLong(0);
    /* access modifiers changed from: private */
    public int g;
    /* access modifiers changed from: private */
    public volatile long h = 0;
    /* access modifiers changed from: private */
    public volatile boolean i;
    /* access modifiers changed from: private */
    public volatile boolean j;
    /* access modifiers changed from: private */
    public volatile boolean k;
    /* access modifiers changed from: private */
    public volatile boolean l;
    /* access modifiers changed from: private */
    public volatile int m;
    /* access modifiers changed from: private */
    public final qa n;
    /* access modifiers changed from: private */
    public final long o;
    /* access modifiers changed from: private */
    public final long p;
    /* access modifiers changed from: private */
    public final int q;
    /* access modifiers changed from: private */
    public final String r;
    /* access modifiers changed from: private */
    public final int s;
    /* access modifiers changed from: private */
    public final long t;
    private final int u;
    /* access modifiers changed from: private */
    public final boolean v;
    /* access modifiers changed from: private */
    public final fa w;
    /* access modifiers changed from: private */
    public final k2 x;
    /* access modifiers changed from: private */
    public final b y;
    /* access modifiers changed from: private */
    public final t3 z;

    private class b extends Thread {
        private volatile boolean a;

        private b() {
        }

        private void b() {
            long d = (v2.this.h + (v2.this.t * ((long) (v2.this.g + 1)))) - SystemClock.elapsedRealtime();
            if (d < 0) {
                d = 0;
            }
            try {
                Thread.sleep(d);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return this.a;
        }

        public void run() {
            this.a = true;
            if (v2.this.v) {
                long unused = v2.this.A = TrafficStats.getTotalRxBytes();
            } else {
                v2 v2Var = v2.this;
                long unused2 = v2Var.A = TrafficStats.getUidRxBytes(v2Var.C);
            }
            double g = (double) v2.this.o;
            double p = (double) v2.this.t;
            Double.isNaN(g);
            Double.isNaN(p);
            int ceil = (int) Math.ceil(g / p);
            while (!v2.this.i && v2.this.g < ceil && !v2.this.j && !v2.this.k) {
                b();
                long u = v2.this.b();
                v2.this.f.set(u);
                v2 v2Var2 = v2.this;
                v2Var2.a(v2Var2.g, SystemClock.elapsedRealtime(), u);
                v2.r(v2.this);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.a = z;
        }
    }

    public v2(qa qaVar, int i2, k2 k2Var, fa faVar, t3 t3Var) {
        this.n = qaVar;
        this.a = qaVar.e().ips;
        this.q = i2;
        this.s = qaVar.d;
        this.r = qaVar.c;
        this.t = qaVar.reportingInterval;
        this.x = k2Var;
        this.w = faVar;
        this.z = t3Var;
        this.o = (long) qaVar.a;
        this.p = qaVar.b;
        this.u = qaVar.testSockets;
        this.v = qaVar.e;
        this.y = new b();
        this.b = Collections.synchronizedList(new ArrayList());
        this.c = Collections.synchronizedList(new ArrayList());
        this.C = Process.myUid();
    }

    static /* synthetic */ int B(v2 v2Var) {
        int i2 = v2Var.m;
        v2Var.m = i2 + 1;
        return i2;
    }

    static /* synthetic */ int C(v2 v2Var) {
        int i2 = v2Var.m;
        v2Var.m = i2 - 1;
        return i2;
    }

    static /* synthetic */ int r(v2 v2Var) {
        int i2 = v2Var.g;
        v2Var.g = i2 + 1;
        return i2;
    }

    public void run() {
        this.x.a(l2.INIT_TEST);
        this.w.a(this.n, ab.CONNECT);
        ArrayList arrayList = new ArrayList();
        try {
            String[] strArr = this.a;
            int i2 = 0;
            if (strArr.length > 1) {
                this.B = new CountDownLatch(this.a.length);
                String[] strArr2 = this.a;
                int length = strArr2.length;
                while (i2 < length) {
                    URL url = new URL(strArr2[i2]);
                    String b2 = f2.a().b(url.getHost(), this.q);
                    this.b.add(b2);
                    this.w.a(this.n, ab.REGISTER);
                    c cVar = new c(url, b2);
                    cVar.start();
                    arrayList.add(cVar);
                    i2++;
                }
            } else if (strArr.length == 1) {
                this.B = new CountDownLatch(this.u);
                URL url2 = new URL(this.a[0]);
                InetAddress[] d2 = f2.a().a(url2.getHost(), this.q, true).d();
                this.w.a(this.n, ab.REGISTER);
                while (i2 < this.u) {
                    String hostAddress = d2[i2 % d2.length].getHostAddress();
                    this.b.add(hostAddress);
                    c cVar2 = new c(url2, hostAddress);
                    cVar2.start();
                    arrayList.add(cVar2);
                    i2++;
                }
            } else {
                this.k = true;
            }
        } catch (Exception e2) {
            this.k = true;
            this.w.a(this.n, a(e2), e2.getMessage());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((c) it.next()).join();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        if (!this.k && !this.j) {
            this.w.a(this.n, ab.FINISHED);
        }
        if (this.j) {
            this.x.a(l2.ABORTED);
        } else if (this.k) {
            this.x.a(l2.n);
        } else {
            this.x.a(l2.END);
        }
        this.i = true;
    }

    /* access modifiers changed from: private */
    public long b() {
        long uidRxBytes;
        long j2;
        if (this.v) {
            uidRxBytes = TrafficStats.getTotalRxBytes();
            j2 = this.A;
        } else {
            uidRxBytes = TrafficStats.getUidRxBytes(this.C);
            j2 = this.A;
        }
        return uidRxBytes - j2;
    }

    public boolean c() {
        return this.i;
    }

    private class c extends Thread {
        private final URL a;
        private final String b;
        private Socket c;

        c(URL url, String str) {
            this.a = url;
            this.b = str;
        }

        private void a(String str, String str2, PrintWriter printWriter) {
            printWriter.print("GET ");
            printWriter.print(str2);
            printWriter.print(" HTTP/1.1");
            printWriter.print(v2.G);
            printWriter.print("HOST: ");
            printWriter.print(str);
            printWriter.print(v2.G);
            printWriter.print(v2.this.r);
            printWriter.print(v2.G);
            printWriter.flush();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:103:0x02ad, code lost:
            r0.HeaderItem = (com.umlaut.crowd.internal.l3[]) r1.toArray(new com.umlaut.crowd.internal.l3[0]);
            com.umlaut.crowd.internal.v2.i(r13.d).add(r0);
         */
        /* JADX WARNING: Removed duplicated region for block: B:175:0x03eb  */
        /* JADX WARNING: Removed duplicated region for block: B:178:0x03f2 A[SYNTHETIC, Splitter:B:178:0x03f2] */
        /* JADX WARNING: Removed duplicated region for block: B:183:0x03fd A[SYNTHETIC, Splitter:B:183:0x03fd] */
        /* JADX WARNING: Removed duplicated region for block: B:188:0x0407  */
        /* JADX WARNING: Removed duplicated region for block: B:191:0x040e A[SYNTHETIC, Splitter:B:191:0x040e] */
        /* JADX WARNING: Removed duplicated region for block: B:229:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r13 = this;
                java.lang.String r0 = ""
                java.lang.String r1 = ""
                r2 = -1
                r3 = 1
                java.net.URL r4 = r13.a     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r0 = r4.getHost()     // Catch:{ Exception -> 0x00d2 }
                java.net.URL r4 = r13.a     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r1 = r4.getPath()     // Catch:{ Exception -> 0x00d2 }
                java.net.URL r4 = r13.a     // Catch:{ Exception -> 0x00d2 }
                int r4 = r4.getPort()     // Catch:{ Exception -> 0x00d2 }
                java.net.URL r5 = r13.a     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r5 = r5.toExternalForm()     // Catch:{ Exception -> 0x00d2 }
                boolean r5 = android.webkit.URLUtil.isHttpsUrl(r5)     // Catch:{ Exception -> 0x00d2 }
                com.umlaut.crowd.internal.v2 r6 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x00d2 }
                java.lang.Object r6 = r6.D     // Catch:{ Exception -> 0x00d2 }
                monitor-enter(r6)     // Catch:{ Exception -> 0x00d2 }
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x00cf }
                boolean r7 = r7.l     // Catch:{ all -> 0x00cf }
                if (r7 != 0) goto L_0x0047
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x00cf }
                com.umlaut.crowd.internal.fa r7 = r7.w     // Catch:{ all -> 0x00cf }
                com.umlaut.crowd.internal.v2 r8 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x00cf }
                com.umlaut.crowd.internal.qa r8 = r8.n     // Catch:{ all -> 0x00cf }
                com.umlaut.crowd.internal.ab r9 = com.umlaut.crowd.internal.ab.SETUP_SOCKETS     // Catch:{ all -> 0x00cf }
                r7.a(r8, r9)     // Catch:{ all -> 0x00cf }
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x00cf }
                boolean unused = r7.l = r3     // Catch:{ all -> 0x00cf }
            L_0x0047:
                monitor-exit(r6)     // Catch:{ all -> 0x00cf }
                if (r5 == 0) goto L_0x008d
                com.umlaut.crowd.internal.v2 r5 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x00d2 }
                int r5 = r5.q     // Catch:{ Exception -> 0x00d2 }
                javax.net.SocketFactory r5 = android.net.SSLCertificateSocketFactory.getDefault(r5)     // Catch:{ Exception -> 0x00d2 }
                android.net.SSLCertificateSocketFactory r5 = (android.net.SSLCertificateSocketFactory) r5     // Catch:{ Exception -> 0x00d2 }
                java.net.Socket r6 = r5.createSocket()     // Catch:{ Exception -> 0x00d2 }
                r13.c = r6     // Catch:{ Exception -> 0x00d2 }
                java.net.InetSocketAddress r6 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r7 = r13.b     // Catch:{ Exception -> 0x00d2 }
                if (r4 != r2) goto L_0x0064
                r4 = 443(0x1bb, float:6.21E-43)
            L_0x0064:
                r6.<init>(r7, r4)     // Catch:{ Exception -> 0x00d2 }
                com.umlaut.crowd.internal.v2 r4 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x00d2 }
                int r4 = r4.q     // Catch:{ Exception -> 0x00d2 }
                if (r4 <= 0) goto L_0x007b
                java.net.Socket r4 = r13.c     // Catch:{ Exception -> 0x00d2 }
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x00d2 }
                int r7 = r7.q     // Catch:{ Exception -> 0x00d2 }
                r4.connect(r6, r7)     // Catch:{ Exception -> 0x00d2 }
                goto L_0x0080
            L_0x007b:
                java.net.Socket r4 = r13.c     // Catch:{ Exception -> 0x00d2 }
                r4.connect(r6)     // Catch:{ Exception -> 0x00d2 }
            L_0x0080:
                java.net.Socket r4 = r13.c     // Catch:{ Exception -> 0x00d2 }
                com.umlaut.crowd.internal.j3.a((android.net.SSLCertificateSocketFactory) r5, (java.net.Socket) r4, (java.lang.String) r0)     // Catch:{ Exception -> 0x00d2 }
                java.net.Socket r4 = r13.c     // Catch:{ Exception -> 0x00d2 }
                javax.net.ssl.SSLSocket r4 = (javax.net.ssl.SSLSocket) r4     // Catch:{ Exception -> 0x00d2 }
                r4.startHandshake()     // Catch:{ Exception -> 0x00d2 }
                goto L_0x00bb
            L_0x008d:
                javax.net.SocketFactory r5 = javax.net.SocketFactory.getDefault()     // Catch:{ Exception -> 0x00d2 }
                java.net.Socket r5 = r5.createSocket()     // Catch:{ Exception -> 0x00d2 }
                r13.c = r5     // Catch:{ Exception -> 0x00d2 }
                java.net.InetSocketAddress r5 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x00d2 }
                java.lang.String r6 = r13.b     // Catch:{ Exception -> 0x00d2 }
                if (r4 != r2) goto L_0x009f
                r4 = 80
            L_0x009f:
                r5.<init>(r6, r4)     // Catch:{ Exception -> 0x00d2 }
                com.umlaut.crowd.internal.v2 r4 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x00d2 }
                int r4 = r4.q     // Catch:{ Exception -> 0x00d2 }
                if (r4 <= 0) goto L_0x00b6
                java.net.Socket r4 = r13.c     // Catch:{ Exception -> 0x00d2 }
                com.umlaut.crowd.internal.v2 r6 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x00d2 }
                int r6 = r6.q     // Catch:{ Exception -> 0x00d2 }
                r4.connect(r5, r6)     // Catch:{ Exception -> 0x00d2 }
                goto L_0x00bb
            L_0x00b6:
                java.net.Socket r4 = r13.c     // Catch:{ Exception -> 0x00d2 }
                r4.connect(r5)     // Catch:{ Exception -> 0x00d2 }
            L_0x00bb:
                com.umlaut.crowd.internal.v2 r4 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x00d2 }
                int r4 = r4.q     // Catch:{ Exception -> 0x00d2 }
                if (r4 <= 0) goto L_0x00f1
                java.net.Socket r4 = r13.c     // Catch:{ Exception -> 0x00d2 }
                com.umlaut.crowd.internal.v2 r5 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x00d2 }
                int r5 = r5.q     // Catch:{ Exception -> 0x00d2 }
                r4.setSoTimeout(r5)     // Catch:{ Exception -> 0x00d2 }
                goto L_0x00f1
            L_0x00cf:
                r4 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x00cf }
                throw r4     // Catch:{ Exception -> 0x00d2 }
            L_0x00d2:
                r4 = move-exception
                com.umlaut.crowd.internal.v2 r5 = com.umlaut.crowd.internal.v2.this
                boolean unused = r5.k = r3
                com.umlaut.crowd.internal.v2 r5 = com.umlaut.crowd.internal.v2.this
                com.umlaut.crowd.internal.r5 r5 = r5.a((java.lang.Exception) r4)
                com.umlaut.crowd.internal.v2 r6 = com.umlaut.crowd.internal.v2.this
                com.umlaut.crowd.internal.fa r6 = r6.w
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this
                com.umlaut.crowd.internal.qa r7 = r7.n
                java.lang.String r4 = r4.getMessage()
                r6.a(r7, r5, r4)
            L_0x00f1:
                r4 = 0
                com.umlaut.crowd.internal.v2 r5 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                java.lang.Object r5 = r5.D     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                monitor-enter(r5)     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                com.umlaut.crowd.internal.v2 r6 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x03a6 }
                com.umlaut.crowd.internal.v2.B(r6)     // Catch:{ all -> 0x03a6 }
                monitor-exit(r5)     // Catch:{ all -> 0x03a6 }
                com.umlaut.crowd.internal.v2 r5 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                java.util.concurrent.CountDownLatch r5 = r5.B     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                r5.countDown()     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                com.umlaut.crowd.internal.v2 r5 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                java.util.concurrent.CountDownLatch r5 = r5.B     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                r5.await()     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                com.umlaut.crowd.internal.v2 r5 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                boolean r5 = r5.k     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                if (r5 != 0) goto L_0x0399
                com.umlaut.crowd.internal.v2 r5 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                boolean r5 = r5.j     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                if (r5 == 0) goto L_0x0123
                goto L_0x0399
            L_0x0123:
                com.umlaut.crowd.internal.v2 r5 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                java.lang.Object r5 = r5.D     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                monitor-enter(r5)     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                com.umlaut.crowd.internal.v2 r6 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x0396 }
                long r6 = r6.h     // Catch:{ all -> 0x0396 }
                r8 = 0
                r10 = 0
                int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r11 != 0) goto L_0x016e
                com.umlaut.crowd.internal.v2 r6 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x0396 }
                long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0396 }
                long unused = r6.h = r7     // Catch:{ all -> 0x0396 }
                com.umlaut.crowd.internal.ta[] r6 = new com.umlaut.crowd.internal.ta[r3]     // Catch:{ all -> 0x0396 }
                com.umlaut.crowd.internal.bb r7 = new com.umlaut.crowd.internal.bb     // Catch:{ all -> 0x0396 }
                r7.<init>()     // Catch:{ all -> 0x0396 }
                com.umlaut.crowd.internal.wa r8 = new com.umlaut.crowd.internal.wa     // Catch:{ all -> 0x0396 }
                r8.<init>()     // Catch:{ all -> 0x0396 }
                r7.server = r8     // Catch:{ all -> 0x0396 }
                com.umlaut.crowd.internal.v2 r9 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x0396 }
                java.util.List r9 = r9.b     // Catch:{ all -> 0x0396 }
                java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ all -> 0x0396 }
                java.lang.Object[] r9 = r9.toArray(r11)     // Catch:{ all -> 0x0396 }
                java.lang.String[] r9 = (java.lang.String[]) r9     // Catch:{ all -> 0x0396 }
                r8.ips = r9     // Catch:{ all -> 0x0396 }
                com.umlaut.crowd.internal.ga r8 = new com.umlaut.crowd.internal.ga     // Catch:{ all -> 0x0396 }
                r8.<init>(r7, r4)     // Catch:{ all -> 0x0396 }
                r6[r10] = r8     // Catch:{ all -> 0x0396 }
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x0396 }
                com.umlaut.crowd.internal.k2 r7 = r7.x     // Catch:{ all -> 0x0396 }
                r7.a((com.umlaut.crowd.internal.ta[]) r6)     // Catch:{ all -> 0x0396 }
            L_0x016e:
                monitor-exit(r5)     // Catch:{ all -> 0x0396 }
                java.io.PrintWriter r5 = new java.io.PrintWriter     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                java.net.Socket r6 = r13.c     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                java.io.OutputStream r6 = r6.getOutputStream()     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                r5.<init>(r6)     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
                r13.a(r0, r1, r5)     // Catch:{ Exception -> 0x0394 }
                java.net.Socket r0 = r13.c     // Catch:{ Exception -> 0x0394 }
                java.io.InputStream r4 = r0.getInputStream()     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.x7 r0 = new com.umlaut.crowd.internal.x7     // Catch:{ Exception -> 0x0394 }
                r0.<init>()     // Catch:{ Exception -> 0x0394 }
                java.lang.String r1 = r13.b     // Catch:{ Exception -> 0x0394 }
                r0.IP = r1     // Catch:{ Exception -> 0x0394 }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ Exception -> 0x0394 }
                r1.<init>()     // Catch:{ Exception -> 0x0394 }
            L_0x0191:
                com.umlaut.crowd.internal.z9$a r6 = com.umlaut.crowd.internal.z9.a.a(r4)     // Catch:{ Exception -> 0x0394 }
                if (r6 == 0) goto L_0x02c0
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                boolean r7 = r7.j     // Catch:{ Exception -> 0x0394 }
                if (r7 != 0) goto L_0x02c0
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                boolean r7 = r7.k     // Catch:{ Exception -> 0x0394 }
                if (r7 != 0) goto L_0x02c0
                long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.v2 r9 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                long r11 = r9.h     // Catch:{ Exception -> 0x0394 }
                long r7 = r7 - r11
                com.umlaut.crowd.internal.v2 r9 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                long r11 = r9.o     // Catch:{ Exception -> 0x0394 }
                int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r9 >= 0) goto L_0x02c0
                java.lang.String r7 = r6.b     // Catch:{ Exception -> 0x0394 }
                java.lang.String r7 = r7.toUpperCase()     // Catch:{ Exception -> 0x0394 }
                java.lang.String r8 = "HTTP"
                boolean r7 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0394 }
                if (r7 == 0) goto L_0x0280
                java.lang.String r6 = r6.b     // Catch:{ Exception -> 0x0394 }
                java.lang.String r7 = " "
                java.lang.String[] r6 = r6.split(r7)     // Catch:{ Exception -> 0x0394 }
                r6 = r6[r3]     // Catch:{ Exception -> 0x0394 }
                int r6 = java.lang.Integer.parseInt(r6)     // Catch:{ Exception -> 0x0394 }
                r0.ResponseCode = r6     // Catch:{ Exception -> 0x0394 }
                r7 = 200(0xc8, float:2.8E-43)
                if (r6 == r7) goto L_0x021f
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0394 }
                r0.<init>()     // Catch:{ Exception -> 0x0394 }
                java.lang.String r1 = "HTTP connection failed. Error code: "
                r0.append(r1)     // Catch:{ Exception -> 0x0394 }
                r0.append(r6)     // Catch:{ Exception -> 0x0394 }
                java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                boolean unused = r1.k = r3     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.fa r1 = r1.w     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.v2 r2 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.qa r2 = r2.n     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.r5 r6 = com.umlaut.crowd.internal.r5.CONNECTION_REFUSED     // Catch:{ Exception -> 0x0394 }
                r1.a(r2, r6, r0)     // Catch:{ Exception -> 0x0394 }
                if (r4 == 0) goto L_0x020f
                r4.close()     // Catch:{ IOException -> 0x020b }
                goto L_0x020f
            L_0x020b:
                r0 = move-exception
                r0.printStackTrace()
            L_0x020f:
                r5.close()
                java.net.Socket r0 = r13.c
                if (r0 == 0) goto L_0x021e
                r0.close()     // Catch:{ IOException -> 0x021a }
                goto L_0x021e
            L_0x021a:
                r0 = move-exception
                r0.printStackTrace()
            L_0x021e:
                return
            L_0x021f:
                com.umlaut.crowd.internal.v2 r6 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                java.lang.Object r6 = r6.D     // Catch:{ Exception -> 0x0394 }
                monitor-enter(r6)     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.v2$b r7 = r7.y     // Catch:{ all -> 0x027d }
                boolean r7 = r7.a()     // Catch:{ all -> 0x027d }
                if (r7 != 0) goto L_0x027a
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.fa r7 = r7.w     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.v2 r8 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.qa r8 = r8.n     // Catch:{ all -> 0x027d }
                long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x027d }
                r7.a(r8, r11)     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.fa r7 = r7.w     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.v2 r8 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.qa r8 = r8.n     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.ab r9 = com.umlaut.crowd.internal.ab.RUNNING     // Catch:{ all -> 0x027d }
                r7.a(r8, r9)     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x027d }
                long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x027d }
                long unused = r7.h = r8     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x027d }
                long r8 = r7.h     // Catch:{ all -> 0x027d }
                long unused = r7.e = r8     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.v2$b r7 = r7.y     // Catch:{ all -> 0x027d }
                r7.a(r3)     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.v2 r7 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x027d }
                com.umlaut.crowd.internal.v2$b r7 = r7.y     // Catch:{ all -> 0x027d }
                r7.start()     // Catch:{ all -> 0x027d }
            L_0x027a:
                monitor-exit(r6)     // Catch:{ all -> 0x027d }
                goto L_0x0191
            L_0x027d:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x027d }
                throw r0     // Catch:{ Exception -> 0x0394 }
            L_0x0280:
                boolean r7 = r6.c     // Catch:{ Exception -> 0x0394 }
                if (r7 != 0) goto L_0x02ad
                java.lang.String r7 = r6.b     // Catch:{ Exception -> 0x0394 }
                java.lang.String r8 = ""
                boolean r7 = r7.equals(r8)     // Catch:{ Exception -> 0x0394 }
                if (r7 == 0) goto L_0x028f
                goto L_0x02ad
            L_0x028f:
                java.lang.String r6 = r6.b     // Catch:{ Exception -> 0x0394 }
                java.lang.String r7 = " +"
                java.lang.String r8 = ""
                java.lang.String r6 = r6.replaceAll(r7, r8)     // Catch:{ Exception -> 0x0394 }
                java.lang.String r7 = ":"
                java.lang.String[] r6 = r6.split(r7)     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.l3 r7 = new com.umlaut.crowd.internal.l3     // Catch:{ Exception -> 0x0394 }
                r8 = r6[r10]     // Catch:{ Exception -> 0x0394 }
                r6 = r6[r3]     // Catch:{ Exception -> 0x0394 }
                r7.<init>(r8, r6)     // Catch:{ Exception -> 0x0394 }
                r1.add(r7)     // Catch:{ Exception -> 0x0394 }
                goto L_0x0191
            L_0x02ad:
                com.umlaut.crowd.internal.l3[] r6 = new com.umlaut.crowd.internal.l3[r10]     // Catch:{ Exception -> 0x0394 }
                java.lang.Object[] r1 = r1.toArray(r6)     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.l3[] r1 = (com.umlaut.crowd.internal.l3[]) r1     // Catch:{ Exception -> 0x0394 }
                r0.HeaderItem = r1     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                java.util.List r1 = r1.c     // Catch:{ Exception -> 0x0394 }
                r1.add(r0)     // Catch:{ Exception -> 0x0394 }
            L_0x02c0:
                com.umlaut.crowd.internal.v2 r0 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                int r0 = r0.s     // Catch:{ Exception -> 0x0394 }
                byte[] r0 = new byte[r0]     // Catch:{ Exception -> 0x0394 }
                r1 = 0
            L_0x02c9:
                if (r1 == r2) goto L_0x0309
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                boolean r1 = r1.j     // Catch:{ Exception -> 0x0394 }
                if (r1 != 0) goto L_0x0309
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                boolean r1 = r1.k     // Catch:{ Exception -> 0x0394 }
                if (r1 != 0) goto L_0x0309
                long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                long r8 = r1.h     // Catch:{ Exception -> 0x0394 }
                long r6 = r6 - r8
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                long r8 = r1.o     // Catch:{ Exception -> 0x0394 }
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0309
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                java.util.concurrent.atomic.AtomicLong r1 = r1.f     // Catch:{ Exception -> 0x0394 }
                long r6 = r1.get()     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                long r8 = r1.p     // Catch:{ Exception -> 0x0394 }
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0309
                int r1 = r4.read(r0)     // Catch:{ Exception -> 0x0394 }
                goto L_0x02c9
            L_0x0309:
                com.umlaut.crowd.internal.v2 r0 = com.umlaut.crowd.internal.v2.this     // Catch:{ Exception -> 0x0394 }
                java.lang.Object r0 = r0.D     // Catch:{ Exception -> 0x0394 }
                monitor-enter(r0)     // Catch:{ Exception -> 0x0394 }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.v2.C(r1)     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x038f }
                int r1 = r1.m     // Catch:{ all -> 0x038f }
                if (r1 != 0) goto L_0x0378
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x038f }
                boolean unused = r1.i = r3     // Catch:{ all -> 0x038f }
                r1 = 0
            L_0x0323:
                com.umlaut.crowd.internal.v2 r2 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x038f }
                java.util.List r2 = r2.c     // Catch:{ all -> 0x038f }
                int r2 = r2.size()     // Catch:{ all -> 0x038f }
                if (r1 >= r2) goto L_0x0340
                com.umlaut.crowd.internal.v2 r2 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x038f }
                java.util.List r2 = r2.c     // Catch:{ all -> 0x038f }
                java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.x7 r2 = (com.umlaut.crowd.internal.x7) r2     // Catch:{ all -> 0x038f }
                int r1 = r1 + 1
                r2.Socket = r1     // Catch:{ all -> 0x038f }
                goto L_0x0323
            L_0x0340:
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.t3 r1 = r1.z     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.v2 r2 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x038f }
                java.util.List r2 = r2.c     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.x7[] r6 = new com.umlaut.crowd.internal.x7[r10]     // Catch:{ all -> 0x038f }
                java.lang.Object[] r2 = r2.toArray(r6)     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.x7[] r2 = (com.umlaut.crowd.internal.x7[]) r2     // Catch:{ all -> 0x038f }
                r1.a(r2)     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.fa r1 = r1.w     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.v2 r2 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.qa r2 = r2.n     // Catch:{ all -> 0x038f }
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x038f }
                r1.b(r2, r6)     // Catch:{ all -> 0x038f }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ InterruptedException -> 0x0374 }
                com.umlaut.crowd.internal.v2$b r1 = r1.y     // Catch:{ InterruptedException -> 0x0374 }
                r1.join()     // Catch:{ InterruptedException -> 0x0374 }
                goto L_0x0378
            L_0x0374:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ all -> 0x038f }
            L_0x0378:
                monitor-exit(r0)     // Catch:{ all -> 0x038f }
                if (r4 == 0) goto L_0x0383
                r4.close()     // Catch:{ IOException -> 0x037f }
                goto L_0x0383
            L_0x037f:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0383:
                r5.close()
                java.net.Socket r0 = r13.c
                if (r0 == 0) goto L_0x03fa
                r0.close()     // Catch:{ IOException -> 0x03f6 }
                goto L_0x03fa
            L_0x038f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x038f }
                throw r1     // Catch:{ Exception -> 0x0394 }
            L_0x0392:
                r0 = move-exception
                goto L_0x03fb
            L_0x0394:
                r0 = move-exception
                goto L_0x03ae
            L_0x0396:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0396 }
                throw r0     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
            L_0x0399:
                java.net.Socket r0 = r13.c
                if (r0 == 0) goto L_0x03a5
                r0.close()     // Catch:{ IOException -> 0x03a1 }
                goto L_0x03a5
            L_0x03a1:
                r0 = move-exception
                r0.printStackTrace()
            L_0x03a5:
                return
            L_0x03a6:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x03a6 }
                throw r0     // Catch:{ Exception -> 0x03ac, all -> 0x03a9 }
            L_0x03a9:
                r0 = move-exception
                r5 = r4
                goto L_0x03fb
            L_0x03ac:
                r0 = move-exception
                r5 = r4
            L_0x03ae:
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x0392 }
                boolean unused = r1.k = r3     // Catch:{ all -> 0x0392 }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x0392 }
                com.umlaut.crowd.internal.r5 r1 = r1.a((java.lang.Exception) r0)     // Catch:{ all -> 0x0392 }
                com.umlaut.crowd.internal.v2 r2 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x0392 }
                com.umlaut.crowd.internal.fa r2 = r2.w     // Catch:{ all -> 0x0392 }
                com.umlaut.crowd.internal.v2 r3 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x0392 }
                com.umlaut.crowd.internal.qa r3 = r3.n     // Catch:{ all -> 0x0392 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0392 }
                r2.a(r3, r1, r0)     // Catch:{ all -> 0x0392 }
                com.umlaut.crowd.internal.v2 r0 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x0392 }
                com.umlaut.crowd.internal.fa r0 = r0.w     // Catch:{ all -> 0x0392 }
                com.umlaut.crowd.internal.v2 r1 = com.umlaut.crowd.internal.v2.this     // Catch:{ all -> 0x0392 }
                com.umlaut.crowd.internal.qa r1 = r1.n     // Catch:{ all -> 0x0392 }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0392 }
                r0.b(r1, r2)     // Catch:{ all -> 0x0392 }
                if (r4 == 0) goto L_0x03e9
                r4.close()     // Catch:{ IOException -> 0x03e5 }
                goto L_0x03e9
            L_0x03e5:
                r0 = move-exception
                r0.printStackTrace()
            L_0x03e9:
                if (r5 == 0) goto L_0x03ee
                r5.close()
            L_0x03ee:
                java.net.Socket r0 = r13.c
                if (r0 == 0) goto L_0x03fa
                r0.close()     // Catch:{ IOException -> 0x03f6 }
                goto L_0x03fa
            L_0x03f6:
                r0 = move-exception
                r0.printStackTrace()
            L_0x03fa:
                return
            L_0x03fb:
                if (r4 == 0) goto L_0x0405
                r4.close()     // Catch:{ IOException -> 0x0401 }
                goto L_0x0405
            L_0x0401:
                r1 = move-exception
                r1.printStackTrace()
            L_0x0405:
                if (r5 == 0) goto L_0x040a
                r5.close()
            L_0x040a:
                java.net.Socket r1 = r13.c
                if (r1 == 0) goto L_0x0416
                r1.close()     // Catch:{ IOException -> 0x0412 }
                goto L_0x0416
            L_0x0412:
                r1 = move-exception
                r1.printStackTrace()
            L_0x0416:
                goto L_0x0418
            L_0x0417:
                throw r0
            L_0x0418:
                goto L_0x0417
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.v2.c.run():void");
        }
    }

    public void a() {
        this.j = true;
    }

    /* access modifiers changed from: private */
    public void a(int i2, long j2, long j3) {
        long j4 = j3 - this.d;
        this.d = j3;
        this.w.a(this.n, i2, j4);
    }

    /* access modifiers changed from: private */
    public r5 a(Exception exc) {
        r5 r5Var = r5.UNEXPECTED_ERROR;
        if (!(exc instanceof IOException)) {
            return exc instanceof IllegalArgumentException ? r5.INVALID_PARAMETER : r5Var;
        }
        r5 r5Var2 = r5.IOEXCEPTION;
        if (exc instanceof UnknownHostException) {
            return r5.UNKNOWN_HOST;
        }
        return r5Var2;
    }
}
