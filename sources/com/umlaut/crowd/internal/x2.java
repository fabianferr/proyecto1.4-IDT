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
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class x2 extends Thread {
    private static final String D = "x2";
    private static final boolean E = false;
    private static final String F = "\r\n";
    private static final int G = 100;
    private static final int H = 4;
    /* access modifiers changed from: private */
    public CountDownLatch A;
    /* access modifiers changed from: private */
    public final int B;
    /* access modifiers changed from: private */
    public final Object C = new Object();
    private final String[] a;
    /* access modifiers changed from: private */
    public final List<String> b;
    private long c;
    /* access modifiers changed from: private */
    public long d;
    /* access modifiers changed from: private */
    public final AtomicLong e = new AtomicLong(0);
    /* access modifiers changed from: private */
    public int f;
    /* access modifiers changed from: private */
    public volatile long g = 0;
    /* access modifiers changed from: private */
    public volatile boolean h;
    /* access modifiers changed from: private */
    public volatile boolean i;
    /* access modifiers changed from: private */
    public volatile boolean j;
    /* access modifiers changed from: private */
    public volatile boolean k;
    /* access modifiers changed from: private */
    public volatile int l;
    /* access modifiers changed from: private */
    public final ra m;
    /* access modifiers changed from: private */
    public final long n;
    /* access modifiers changed from: private */
    public final long o;
    /* access modifiers changed from: private */
    public final int p;
    /* access modifiers changed from: private */
    public final String q;
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
    public long z;

    private class b extends Thread {
        private volatile boolean a;

        private b() {
        }

        private void b() {
            long j = (x2.this.g + (x2.this.t * ((long) (x2.this.f + 1)))) - SystemClock.elapsedRealtime();
            if (j < 0) {
                j = 0;
            }
            try {
                Thread.sleep(j);
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
            if (x2.this.v) {
                long unused = x2.this.z = TrafficStats.getTotalTxBytes();
            } else {
                x2 x2Var = x2.this;
                long unused2 = x2Var.z = TrafficStats.getUidTxBytes(x2Var.B);
            }
            double k = (double) x2.this.n;
            double p = (double) x2.this.t;
            Double.isNaN(k);
            Double.isNaN(p);
            int ceil = (int) Math.ceil(k / p);
            while (!x2.this.h && x2.this.f < ceil && !x2.this.i && !x2.this.j) {
                b();
                long u = x2.this.b();
                x2.this.e.set(u);
                x2 x2Var2 = x2.this;
                x2Var2.a(x2Var2.f, SystemClock.elapsedRealtime(), u);
                x2.r(x2.this);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(boolean z) {
            this.a = z;
        }
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
            printWriter.print(x2.this.r + " ");
            printWriter.print(str2);
            printWriter.print(" HTTP/1.1");
            printWriter.print(x2.F);
            printWriter.print("HOST: ");
            printWriter.print(str);
            printWriter.print(x2.F);
            printWriter.print(x2.this.q);
            printWriter.print(x2.F);
            printWriter.flush();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v32, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v33, resolved type: java.io.OutputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v34, resolved type: java.io.OutputStream} */
        /* JADX WARNING: type inference failed for: r6v0, types: [java.io.OutputStream] */
        /* JADX WARNING: type inference failed for: r6v1 */
        /* JADX WARNING: type inference failed for: r6v2, types: [java.io.OutputStream] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:145:0x02ff  */
        /* JADX WARNING: Removed duplicated region for block: B:147:0x0304 A[SYNTHETIC, Splitter:B:147:0x0304] */
        /* JADX WARNING: Removed duplicated region for block: B:153:0x0310 A[SYNTHETIC, Splitter:B:153:0x0310] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r12 = this;
                java.util.Random r0 = new java.util.Random
                long r1 = java.lang.System.nanoTime()
                r0.<init>(r1)
                com.umlaut.crowd.internal.x2 r1 = com.umlaut.crowd.internal.x2.this
                int r1 = r1.s
                r2 = 2
                int[] r2 = new int[r2]
                r3 = 1
                r2[r3] = r1
                r1 = 0
                r4 = 100
                r2[r1] = r4
                java.lang.Class r4 = java.lang.Byte.TYPE
                java.lang.Object r2 = java.lang.reflect.Array.newInstance(r4, r2)
                byte[][] r2 = (byte[][]) r2
                int r4 = r2.length
                r5 = 0
            L_0x0024:
                if (r5 >= r4) goto L_0x002e
                r6 = r2[r5]
                r0.nextBytes(r6)
                int r5 = r5 + 1
                goto L_0x0024
            L_0x002e:
                java.lang.String r0 = ""
                java.lang.String r4 = ""
                java.net.URL r5 = r12.a     // Catch:{ Exception -> 0x00ff }
                java.lang.String r0 = r5.getHost()     // Catch:{ Exception -> 0x00ff }
                java.net.URL r5 = r12.a     // Catch:{ Exception -> 0x00ff }
                java.lang.String r4 = r5.getPath()     // Catch:{ Exception -> 0x00ff }
                java.net.URL r5 = r12.a     // Catch:{ Exception -> 0x00ff }
                int r5 = r5.getPort()     // Catch:{ Exception -> 0x00ff }
                java.net.URL r6 = r12.a     // Catch:{ Exception -> 0x00ff }
                java.lang.String r6 = r6.toExternalForm()     // Catch:{ Exception -> 0x00ff }
                boolean r6 = android.webkit.URLUtil.isHttpsUrl(r6)     // Catch:{ Exception -> 0x00ff }
                com.umlaut.crowd.internal.x2 r7 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x00ff }
                java.lang.Object r7 = r7.C     // Catch:{ Exception -> 0x00ff }
                monitor-enter(r7)     // Catch:{ Exception -> 0x00ff }
                com.umlaut.crowd.internal.x2 r8 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x00fc }
                boolean r8 = r8.k     // Catch:{ all -> 0x00fc }
                if (r8 != 0) goto L_0x0073
                com.umlaut.crowd.internal.x2 r8 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x00fc }
                com.umlaut.crowd.internal.fa r8 = r8.w     // Catch:{ all -> 0x00fc }
                com.umlaut.crowd.internal.x2 r9 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x00fc }
                com.umlaut.crowd.internal.ra r9 = r9.m     // Catch:{ all -> 0x00fc }
                com.umlaut.crowd.internal.ab r10 = com.umlaut.crowd.internal.ab.SETUP_SOCKETS     // Catch:{ all -> 0x00fc }
                r8.a(r9, r10)     // Catch:{ all -> 0x00fc }
                com.umlaut.crowd.internal.x2 r8 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x00fc }
                boolean unused = r8.k = r3     // Catch:{ all -> 0x00fc }
            L_0x0073:
                monitor-exit(r7)     // Catch:{ all -> 0x00fc }
                r7 = -1
                if (r6 == 0) goto L_0x00ba
                com.umlaut.crowd.internal.x2 r6 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x00ff }
                int r6 = r6.p     // Catch:{ Exception -> 0x00ff }
                javax.net.SocketFactory r6 = android.net.SSLCertificateSocketFactory.getDefault(r6)     // Catch:{ Exception -> 0x00ff }
                android.net.SSLCertificateSocketFactory r6 = (android.net.SSLCertificateSocketFactory) r6     // Catch:{ Exception -> 0x00ff }
                java.net.Socket r8 = r6.createSocket()     // Catch:{ Exception -> 0x00ff }
                r12.c = r8     // Catch:{ Exception -> 0x00ff }
                java.net.InetSocketAddress r8 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x00ff }
                java.lang.String r9 = r12.b     // Catch:{ Exception -> 0x00ff }
                if (r5 != r7) goto L_0x0091
                r5 = 443(0x1bb, float:6.21E-43)
            L_0x0091:
                r8.<init>(r9, r5)     // Catch:{ Exception -> 0x00ff }
                com.umlaut.crowd.internal.x2 r5 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x00ff }
                int r5 = r5.p     // Catch:{ Exception -> 0x00ff }
                if (r5 <= 0) goto L_0x00a8
                java.net.Socket r5 = r12.c     // Catch:{ Exception -> 0x00ff }
                com.umlaut.crowd.internal.x2 r7 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x00ff }
                int r7 = r7.p     // Catch:{ Exception -> 0x00ff }
                r5.connect(r8, r7)     // Catch:{ Exception -> 0x00ff }
                goto L_0x00ad
            L_0x00a8:
                java.net.Socket r5 = r12.c     // Catch:{ Exception -> 0x00ff }
                r5.connect(r8)     // Catch:{ Exception -> 0x00ff }
            L_0x00ad:
                java.net.Socket r5 = r12.c     // Catch:{ Exception -> 0x00ff }
                com.umlaut.crowd.internal.j3.a((android.net.SSLCertificateSocketFactory) r6, (java.net.Socket) r5, (java.lang.String) r0)     // Catch:{ Exception -> 0x00ff }
                java.net.Socket r5 = r12.c     // Catch:{ Exception -> 0x00ff }
                javax.net.ssl.SSLSocket r5 = (javax.net.ssl.SSLSocket) r5     // Catch:{ Exception -> 0x00ff }
                r5.startHandshake()     // Catch:{ Exception -> 0x00ff }
                goto L_0x00e8
            L_0x00ba:
                javax.net.SocketFactory r6 = javax.net.SocketFactory.getDefault()     // Catch:{ Exception -> 0x00ff }
                java.net.Socket r6 = r6.createSocket()     // Catch:{ Exception -> 0x00ff }
                r12.c = r6     // Catch:{ Exception -> 0x00ff }
                java.net.InetSocketAddress r6 = new java.net.InetSocketAddress     // Catch:{ Exception -> 0x00ff }
                java.lang.String r8 = r12.b     // Catch:{ Exception -> 0x00ff }
                if (r5 != r7) goto L_0x00cc
                r5 = 80
            L_0x00cc:
                r6.<init>(r8, r5)     // Catch:{ Exception -> 0x00ff }
                com.umlaut.crowd.internal.x2 r5 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x00ff }
                int r5 = r5.p     // Catch:{ Exception -> 0x00ff }
                if (r5 <= 0) goto L_0x00e3
                java.net.Socket r5 = r12.c     // Catch:{ Exception -> 0x00ff }
                com.umlaut.crowd.internal.x2 r7 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x00ff }
                int r7 = r7.p     // Catch:{ Exception -> 0x00ff }
                r5.connect(r6, r7)     // Catch:{ Exception -> 0x00ff }
                goto L_0x00e8
            L_0x00e3:
                java.net.Socket r5 = r12.c     // Catch:{ Exception -> 0x00ff }
                r5.connect(r6)     // Catch:{ Exception -> 0x00ff }
            L_0x00e8:
                com.umlaut.crowd.internal.x2 r5 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x00ff }
                int r5 = r5.p     // Catch:{ Exception -> 0x00ff }
                if (r5 <= 0) goto L_0x011e
                java.net.Socket r5 = r12.c     // Catch:{ Exception -> 0x00ff }
                com.umlaut.crowd.internal.x2 r6 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x00ff }
                int r6 = r6.p     // Catch:{ Exception -> 0x00ff }
                r5.setSoTimeout(r6)     // Catch:{ Exception -> 0x00ff }
                goto L_0x011e
            L_0x00fc:
                r5 = move-exception
                monitor-exit(r7)     // Catch:{ all -> 0x00fc }
                throw r5     // Catch:{ Exception -> 0x00ff }
            L_0x00ff:
                r5 = move-exception
                com.umlaut.crowd.internal.x2 r6 = com.umlaut.crowd.internal.x2.this
                boolean unused = r6.j = r3
                com.umlaut.crowd.internal.x2 r6 = com.umlaut.crowd.internal.x2.this
                com.umlaut.crowd.internal.r5 r6 = r6.a((java.lang.Exception) r5)
                com.umlaut.crowd.internal.x2 r7 = com.umlaut.crowd.internal.x2.this
                com.umlaut.crowd.internal.fa r7 = r7.w
                com.umlaut.crowd.internal.x2 r8 = com.umlaut.crowd.internal.x2.this
                com.umlaut.crowd.internal.ra r8 = r8.m
                java.lang.String r5 = r5.getMessage()
                r7.a(r8, r6, r5)
            L_0x011e:
                r5 = 0
                com.umlaut.crowd.internal.x2 r6 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                java.lang.Object r6 = r6.C     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                monitor-enter(r6)     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                com.umlaut.crowd.internal.x2 r7 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x02a3 }
                com.umlaut.crowd.internal.x2.c(r7)     // Catch:{ all -> 0x02a3 }
                monitor-exit(r6)     // Catch:{ all -> 0x02a3 }
                com.umlaut.crowd.internal.x2 r6 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                java.util.concurrent.CountDownLatch r6 = r6.A     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                r6.countDown()     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                com.umlaut.crowd.internal.x2 r6 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                java.util.concurrent.CountDownLatch r6 = r6.A     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                r6.await()     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                com.umlaut.crowd.internal.x2 r6 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                boolean r6 = r6.j     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                if (r6 != 0) goto L_0x0296
                com.umlaut.crowd.internal.x2 r6 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                boolean r6 = r6.i     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                if (r6 == 0) goto L_0x0150
                goto L_0x0296
            L_0x0150:
                java.net.Socket r6 = r12.c     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                java.io.OutputStream r6 = r6.getOutputStream()     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
                java.io.PrintWriter r7 = new java.io.PrintWriter     // Catch:{ Exception -> 0x0294 }
                r7.<init>(r6)     // Catch:{ Exception -> 0x0294 }
                r12.a(r0, r4, r7)     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                com.umlaut.crowd.internal.x2 r0 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                java.lang.Object r0 = r0.C     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                monitor-enter(r0)     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                com.umlaut.crowd.internal.x2 r4 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2$b r4 = r4.y     // Catch:{ all -> 0x028b }
                boolean r4 = r4.a()     // Catch:{ all -> 0x028b }
                if (r4 != 0) goto L_0x01e7
                com.umlaut.crowd.internal.ta[] r4 = new com.umlaut.crowd.internal.ta[r3]     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.hb r8 = new com.umlaut.crowd.internal.hb     // Catch:{ all -> 0x028b }
                r8.<init>()     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.wa r9 = new com.umlaut.crowd.internal.wa     // Catch:{ all -> 0x028b }
                r9.<init>()     // Catch:{ all -> 0x028b }
                r8.server = r9     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2 r10 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                java.util.List r10 = r10.b     // Catch:{ all -> 0x028b }
                java.lang.String[] r11 = new java.lang.String[r1]     // Catch:{ all -> 0x028b }
                java.lang.Object[] r10 = r10.toArray(r11)     // Catch:{ all -> 0x028b }
                java.lang.String[] r10 = (java.lang.String[]) r10     // Catch:{ all -> 0x028b }
                r9.ips = r10     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.ga r9 = new com.umlaut.crowd.internal.ga     // Catch:{ all -> 0x028b }
                r9.<init>(r8, r5)     // Catch:{ all -> 0x028b }
                r4[r1] = r9     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2 r5 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.k2 r5 = r5.x     // Catch:{ all -> 0x028b }
                r5.a((com.umlaut.crowd.internal.ta[]) r4)     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2 r4 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.fa r4 = r4.w     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2 r5 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.ra r5 = r5.m     // Catch:{ all -> 0x028b }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x028b }
                r4.a(r5, r8)     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2 r4 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.fa r4 = r4.w     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2 r5 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.ra r5 = r5.m     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.ab r8 = com.umlaut.crowd.internal.ab.RUNNING     // Catch:{ all -> 0x028b }
                r4.a(r5, r8)     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2 r4 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x028b }
                long unused = r4.g = r8     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2 r4 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                long r8 = r4.g     // Catch:{ all -> 0x028b }
                long unused = r4.d = r8     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2 r4 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2$b r4 = r4.y     // Catch:{ all -> 0x028b }
                r4.a(r3)     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2 r4 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x028b }
                com.umlaut.crowd.internal.x2$b r4 = r4.y     // Catch:{ all -> 0x028b }
                r4.start()     // Catch:{ all -> 0x028b }
            L_0x01e7:
                monitor-exit(r0)     // Catch:{ all -> 0x028b }
                r4 = 0
            L_0x01ea:
                com.umlaut.crowd.internal.x2 r0 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                boolean r0 = r0.i     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                if (r0 != 0) goto L_0x0237
                com.umlaut.crowd.internal.x2 r0 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                boolean r0 = r0.j     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                if (r0 != 0) goto L_0x0237
                long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                com.umlaut.crowd.internal.x2 r0 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                long r10 = r0.g     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                long r8 = r8 - r10
                com.umlaut.crowd.internal.x2 r0 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                long r10 = r0.n     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 >= 0) goto L_0x0237
                com.umlaut.crowd.internal.x2 r0 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                java.util.concurrent.atomic.AtomicLong r0 = r0.e     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                long r8 = r0.get()     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                com.umlaut.crowd.internal.x2 r0 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                long r10 = r0.o     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r0 >= 0) goto L_0x0237
                r8 = 1
                long r8 = r8 + r4
                r10 = 100
                long r4 = r4 % r10
                int r0 = (int) r4     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                r0 = r2[r0]     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                com.umlaut.crowd.internal.x2 r4 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                int r4 = r4.s     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                r6.write(r0, r1, r4)     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                r4 = r8
                goto L_0x01ea
            L_0x0237:
                com.umlaut.crowd.internal.x2 r0 = com.umlaut.crowd.internal.x2.this     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                java.lang.Object r0 = r0.C     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                monitor-enter(r0)     // Catch:{ Exception -> 0x0291, all -> 0x028e }
                com.umlaut.crowd.internal.x2 r1 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x0288 }
                com.umlaut.crowd.internal.x2.d(r1)     // Catch:{ all -> 0x0288 }
                com.umlaut.crowd.internal.x2 r1 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x0288 }
                int r1 = r1.l     // Catch:{ all -> 0x0288 }
                if (r1 != 0) goto L_0x0271
                com.umlaut.crowd.internal.x2 r1 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x0288 }
                boolean unused = r1.h = r3     // Catch:{ all -> 0x0288 }
                com.umlaut.crowd.internal.x2 r1 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x0288 }
                com.umlaut.crowd.internal.fa r1 = r1.w     // Catch:{ all -> 0x0288 }
                com.umlaut.crowd.internal.x2 r2 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x0288 }
                com.umlaut.crowd.internal.ra r2 = r2.m     // Catch:{ all -> 0x0288 }
                long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0288 }
                r1.b(r2, r4)     // Catch:{ all -> 0x0288 }
                com.umlaut.crowd.internal.x2 r1 = com.umlaut.crowd.internal.x2.this     // Catch:{ InterruptedException -> 0x026d }
                com.umlaut.crowd.internal.x2$b r1 = r1.y     // Catch:{ InterruptedException -> 0x026d }
                r1.join()     // Catch:{ InterruptedException -> 0x026d }
                goto L_0x0271
            L_0x026d:
                r1 = move-exception
                r1.printStackTrace()     // Catch:{ all -> 0x0288 }
            L_0x0271:
                monitor-exit(r0)     // Catch:{ all -> 0x0288 }
                r7.close()
                if (r6 == 0) goto L_0x027f
                r6.close()     // Catch:{ IOException -> 0x027b }
                goto L_0x027f
            L_0x027b:
                r0 = move-exception
                r0.printStackTrace()
            L_0x027f:
                java.net.Socket r0 = r12.c
                if (r0 == 0) goto L_0x02f7
                r0.close()     // Catch:{ IOException -> 0x02f3 }
                goto L_0x02f7
            L_0x0288:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0288 }
                throw r1     // Catch:{ Exception -> 0x0291, all -> 0x028e }
            L_0x028b:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x028b }
                throw r1     // Catch:{ Exception -> 0x0291, all -> 0x028e }
            L_0x028e:
                r0 = move-exception
                goto L_0x02fd
            L_0x0291:
                r0 = move-exception
                r5 = r7
                goto L_0x02ab
            L_0x0294:
                r0 = move-exception
                goto L_0x02ab
            L_0x0296:
                java.net.Socket r0 = r12.c
                if (r0 == 0) goto L_0x02a2
                r0.close()     // Catch:{ IOException -> 0x029e }
                goto L_0x02a2
            L_0x029e:
                r0 = move-exception
                r0.printStackTrace()
            L_0x02a2:
                return
            L_0x02a3:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x02a3 }
                throw r0     // Catch:{ Exception -> 0x02a9, all -> 0x02a6 }
            L_0x02a6:
                r0 = move-exception
                r1 = r5
                goto L_0x02fb
            L_0x02a9:
                r0 = move-exception
                r6 = r5
            L_0x02ab:
                com.umlaut.crowd.internal.x2 r1 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x02f8 }
                boolean unused = r1.j = r3     // Catch:{ all -> 0x02f8 }
                com.umlaut.crowd.internal.x2 r1 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x02f8 }
                com.umlaut.crowd.internal.r5 r1 = r1.a((java.lang.Exception) r0)     // Catch:{ all -> 0x02f8 }
                com.umlaut.crowd.internal.x2 r2 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x02f8 }
                com.umlaut.crowd.internal.fa r2 = r2.w     // Catch:{ all -> 0x02f8 }
                com.umlaut.crowd.internal.x2 r3 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x02f8 }
                com.umlaut.crowd.internal.ra r3 = r3.m     // Catch:{ all -> 0x02f8 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x02f8 }
                r2.a(r3, r1, r0)     // Catch:{ all -> 0x02f8 }
                com.umlaut.crowd.internal.x2 r0 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x02f8 }
                com.umlaut.crowd.internal.fa r0 = r0.w     // Catch:{ all -> 0x02f8 }
                com.umlaut.crowd.internal.x2 r1 = com.umlaut.crowd.internal.x2.this     // Catch:{ all -> 0x02f8 }
                com.umlaut.crowd.internal.ra r1 = r1.m     // Catch:{ all -> 0x02f8 }
                long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02f8 }
                r0.b(r1, r2)     // Catch:{ all -> 0x02f8 }
                if (r5 == 0) goto L_0x02e1
                r5.close()
            L_0x02e1:
                if (r6 == 0) goto L_0x02eb
                r6.close()     // Catch:{ IOException -> 0x02e7 }
                goto L_0x02eb
            L_0x02e7:
                r0 = move-exception
                r0.printStackTrace()
            L_0x02eb:
                java.net.Socket r0 = r12.c
                if (r0 == 0) goto L_0x02f7
                r0.close()     // Catch:{ IOException -> 0x02f3 }
                goto L_0x02f7
            L_0x02f3:
                r0 = move-exception
                r0.printStackTrace()
            L_0x02f7:
                return
            L_0x02f8:
                r0 = move-exception
                r1 = r5
                r5 = r6
            L_0x02fb:
                r7 = r1
                r6 = r5
            L_0x02fd:
                if (r7 == 0) goto L_0x0302
                r7.close()
            L_0x0302:
                if (r6 == 0) goto L_0x030c
                r6.close()     // Catch:{ IOException -> 0x0308 }
                goto L_0x030c
            L_0x0308:
                r1 = move-exception
                r1.printStackTrace()
            L_0x030c:
                java.net.Socket r1 = r12.c
                if (r1 == 0) goto L_0x0318
                r1.close()     // Catch:{ IOException -> 0x0314 }
                goto L_0x0318
            L_0x0314:
                r1 = move-exception
                r1.printStackTrace()
            L_0x0318:
                goto L_0x031a
            L_0x0319:
                throw r0
            L_0x031a:
                goto L_0x0319
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.x2.c.run():void");
        }
    }

    public x2(ra raVar, int i2, k2 k2Var, fa faVar) {
        this.m = raVar;
        this.a = raVar.e().ips;
        this.p = i2;
        this.s = raVar.d;
        this.q = raVar.c;
        this.r = raVar.e;
        this.t = raVar.reportingInterval;
        this.x = k2Var;
        this.w = faVar;
        this.n = (long) raVar.a;
        this.o = raVar.b;
        this.u = raVar.testSockets;
        this.v = raVar.f;
        this.y = new b();
        this.b = Collections.synchronizedList(new ArrayList());
        this.B = Process.myUid();
    }

    static /* synthetic */ int c(x2 x2Var) {
        int i2 = x2Var.l;
        x2Var.l = i2 + 1;
        return i2;
    }

    static /* synthetic */ int d(x2 x2Var) {
        int i2 = x2Var.l;
        x2Var.l = i2 - 1;
        return i2;
    }

    static /* synthetic */ int r(x2 x2Var) {
        int i2 = x2Var.f;
        x2Var.f = i2 + 1;
        return i2;
    }

    public void run() {
        this.x.a(l2.INIT_TEST);
        this.w.a(this.m, ab.CONNECT);
        ArrayList arrayList = new ArrayList();
        try {
            if (this.a.length > 0) {
                this.A = new CountDownLatch(this.u);
                InetAddress[] d2 = f2.a().a(new URL(this.a[0]).getHost(), this.p, true).d();
                this.w.a(this.m, ab.REGISTER);
                for (int i2 = 0; i2 < this.u; i2++) {
                    URL url = new URL(this.a[0] + "/" + a(4));
                    String hostAddress = d2[i2 % d2.length].getHostAddress();
                    this.b.add(hostAddress);
                    c cVar = new c(url, hostAddress);
                    cVar.start();
                    arrayList.add(cVar);
                }
            } else {
                this.j = true;
            }
        } catch (Exception e2) {
            this.j = true;
            this.w.a(this.m, a(e2), e2.getMessage());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                ((c) it.next()).join();
            } catch (InterruptedException e3) {
                e3.printStackTrace();
            }
        }
        if (!this.j && !this.i) {
            this.w.a(this.m, ab.FINISHED);
        }
        if (this.i) {
            this.x.a(l2.ABORTED);
        } else if (this.j) {
            this.x.a(l2.n);
        } else {
            this.x.a(l2.END);
        }
        this.h = true;
    }

    /* access modifiers changed from: private */
    public long b() {
        long uidTxBytes;
        long j2;
        if (this.v) {
            uidTxBytes = TrafficStats.getTotalTxBytes();
            j2 = this.z;
        } else {
            uidTxBytes = TrafficStats.getUidTxBytes(this.B);
            j2 = this.z;
        }
        return uidTxBytes - j2;
    }

    public boolean c() {
        return this.h;
    }

    public void a() {
        this.i = true;
    }

    private String a(int i2) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        while (sb.length() < i2) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt((int) (random.nextFloat() * ((float) 36))));
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void a(int i2, long j2, long j3) {
        long j4 = j3 - this.c;
        this.c = j3;
        this.w.a(this.m, i2, j4);
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
