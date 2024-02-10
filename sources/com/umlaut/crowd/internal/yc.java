package com.umlaut.crowd.internal;

import java.net.SocketAddress;
import java.util.ArrayList;

public class yc implements zc {
    private ed a = new ed();
    private ArrayList<ed> b = new ArrayList<>(100);
    private ed c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private SocketAddress g;
    private a h = null;
    private boolean i = true;
    private int j = 0;
    private long k = 0;
    private long l = Long.MAX_VALUE;
    private long m = Long.MAX_VALUE;
    private long n = 0;
    private long o = 0;
    private long p;
    private boolean q = true;
    private long r = Long.MAX_VALUE;
    private long s;

    static class a {
        public long a;
        public long b;
        public long c;

        a() {
        }

        static void a(wc wcVar, a aVar) {
            if (aVar != null) {
                aVar.a = wcVar.a;
                aVar.b = wcVar.c;
                aVar.c = wcVar.e;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00c4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.umlaut.crowd.internal.wc r11) {
        /*
            r10 = this;
            long r0 = r10.r
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x000c
            return
        L_0x000c:
            monitor-enter(r10)
            long r0 = r10.k     // Catch:{ all -> 0x00c5 }
            long r4 = r11.c     // Catch:{ all -> 0x00c5 }
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x0017
            r10.k = r4     // Catch:{ all -> 0x00c5 }
        L_0x0017:
            boolean r0 = r10.f()     // Catch:{ all -> 0x00c5 }
            if (r0 != 0) goto L_0x001f
            monitor-exit(r10)     // Catch:{ all -> 0x00c5 }
            return
        L_0x001f:
            long r0 = r10.p     // Catch:{ all -> 0x00c5 }
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x0038
            long r6 = r11.a     // Catch:{ all -> 0x00c5 }
            com.umlaut.crowd.internal.yc$a r8 = r10.h     // Catch:{ all -> 0x00c5 }
            long r8 = r8.a     // Catch:{ all -> 0x00c5 }
            long r0 = r0 + r8
            long r6 = r6 - r0
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0038
            r10.b()     // Catch:{ all -> 0x00c5 }
            monitor-exit(r10)     // Catch:{ all -> 0x00c5 }
            return
        L_0x0038:
            java.net.SocketAddress r0 = r11.f     // Catch:{ all -> 0x00c5 }
            r10.g = r0     // Catch:{ all -> 0x00c5 }
            com.umlaut.crowd.internal.yc$a r0 = r10.h     // Catch:{ all -> 0x00c5 }
            com.umlaut.crowd.internal.yc.a.a(r11, r0)     // Catch:{ all -> 0x00c5 }
            boolean r0 = r10.i     // Catch:{ all -> 0x00c5 }
            r1 = 0
            if (r0 == 0) goto L_0x0058
            long r4 = r10.m     // Catch:{ all -> 0x00c5 }
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x0051
            long r6 = r11.a     // Catch:{ all -> 0x00c5 }
            long r6 = r6 + r4
            r10.n = r6     // Catch:{ all -> 0x00c5 }
        L_0x0051:
            r10.i = r1     // Catch:{ all -> 0x00c5 }
            long r4 = r11.a     // Catch:{ all -> 0x00c5 }
            r10.o = r4     // Catch:{ all -> 0x00c5 }
            goto L_0x006c
        L_0x0058:
            long r6 = r10.m     // Catch:{ all -> 0x00c5 }
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 == 0) goto L_0x006c
            long r6 = r11.a     // Catch:{ all -> 0x00c5 }
            long r8 = r10.n     // Catch:{ all -> 0x00c5 }
            long r6 = r6 - r8
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x006c
            r10.b()     // Catch:{ all -> 0x00c5 }
            monitor-exit(r10)     // Catch:{ all -> 0x00c5 }
            return
        L_0x006c:
            long r4 = r11.a     // Catch:{ all -> 0x00c5 }
            long r6 = r10.o     // Catch:{ all -> 0x00c5 }
            long r4 = r4 - r6
            long r6 = r10.r     // Catch:{ all -> 0x00c5 }
            long r4 = r4 / r6
            int r0 = (int) r4     // Catch:{ all -> 0x00c5 }
            java.util.ArrayList<com.umlaut.crowd.internal.ed> r4 = r10.b     // Catch:{ all -> 0x00c5 }
            int r5 = r0 + 1
            r4.ensureCapacity(r5)     // Catch:{ all -> 0x00c5 }
        L_0x007c:
            java.util.ArrayList<com.umlaut.crowd.internal.ed> r4 = r10.b     // Catch:{ all -> 0x00c5 }
            int r4 = r4.size()     // Catch:{ all -> 0x00c5 }
            if (r4 > r0) goto L_0x008f
            java.util.ArrayList<com.umlaut.crowd.internal.ed> r4 = r10.b     // Catch:{ all -> 0x00c5 }
            com.umlaut.crowd.internal.ed r5 = new com.umlaut.crowd.internal.ed     // Catch:{ all -> 0x00c5 }
            r5.<init>()     // Catch:{ all -> 0x00c5 }
            r4.add(r5)     // Catch:{ all -> 0x00c5 }
            goto L_0x007c
        L_0x008f:
            java.util.ArrayList<com.umlaut.crowd.internal.ed> r4 = r10.b     // Catch:{ all -> 0x00c5 }
            java.lang.Object r4 = r4.get(r0)     // Catch:{ all -> 0x00c5 }
            com.umlaut.crowd.internal.ed r4 = (com.umlaut.crowd.internal.ed) r4     // Catch:{ all -> 0x00c5 }
            com.umlaut.crowd.internal.ed r5 = r10.c     // Catch:{ all -> 0x00c5 }
            r6 = 1
            if (r4 == r5) goto L_0x009d
            goto L_0x009e
        L_0x009d:
            r1 = 1
        L_0x009e:
            r10.c = r4     // Catch:{ all -> 0x00c5 }
            int r5 = r10.j     // Catch:{ all -> 0x00c5 }
            if (r5 <= r0) goto L_0x00a6
            r10.j = r0     // Catch:{ all -> 0x00c5 }
        L_0x00a6:
            com.umlaut.crowd.internal.ed r0 = r10.a     // Catch:{ all -> 0x00c5 }
            r0.a(r11, r6)     // Catch:{ all -> 0x00c5 }
            r4.a(r11, r1)     // Catch:{ all -> 0x00c5 }
            long r0 = r10.l     // Catch:{ all -> 0x00c5 }
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 == 0) goto L_0x00c3
            com.umlaut.crowd.internal.ed r11 = r10.a     // Catch:{ all -> 0x00c5 }
            long r0 = r11.d()     // Catch:{ all -> 0x00c5 }
            long r2 = r10.l     // Catch:{ all -> 0x00c5 }
            int r11 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r11 < 0) goto L_0x00c3
            r10.b()     // Catch:{ all -> 0x00c5 }
        L_0x00c3:
            monitor-exit(r10)     // Catch:{ all -> 0x00c5 }
            return
        L_0x00c5:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x00c5 }
            goto L_0x00c9
        L_0x00c8:
            throw r11
        L_0x00c9:
            goto L_0x00c8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.yc.a(com.umlaut.crowd.internal.wc):void");
    }

    public void b(wc wcVar) {
        synchronized (this) {
            if (this.g == null) {
                a aVar = new a();
                this.h = aVar;
                a.a(wcVar, aVar);
                this.g = wcVar.f;
                this.s = System.nanoTime() - wcVar.e;
                notify();
            }
        }
    }

    public void c() {
        this.d = true;
    }

    public void d(long j2) {
        this.r = j2 * 1000000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0018, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e(long r3) {
        /*
            r2 = this;
            java.net.SocketAddress r0 = r2.g
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            monitor-enter(r2)
            java.net.SocketAddress r0 = r2.g     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x000d
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            return r1
        L_0x000d:
            r0 = 0
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x0019 }
            java.net.SocketAddress r3 = r2.g     // Catch:{ all -> 0x001b }
            if (r3 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r1 = 0
        L_0x0017:
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            return r1
        L_0x0019:
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            return r0
        L_0x001b:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001b }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.yc.e(long):boolean");
    }

    public boolean f() {
        return this.d;
    }

    public boolean g() {
        return this.g != null;
    }

    public void c(long j2) {
        this.p = j2 * 1000000;
    }

    public SocketAddress d() {
        return this.g;
    }

    public void b() {
        this.d = false;
    }

    public void b(long j2) {
        this.m = j2 * 1000000;
    }

    public long e() {
        return this.s;
    }

    public void a(i7 i7Var) {
        synchronized (this) {
            long nanoTime = System.nanoTime();
            if (this.d) {
                long j2 = this.p;
                if (j2 != 0 && nanoTime - (j2 + this.h.a) > 0) {
                    this.e = true;
                    b();
                }
            }
            i7Var.global = this.a.e();
            ed edVar = this.c;
            if (edVar == null || edVar.b() == null) {
                i7Var.lastSeq = 0;
            } else {
                i7Var.lastSeq = this.k;
            }
            int i2 = this.j;
            if (i2 < i7Var.offset) {
                i7Var.offset = i2;
            }
            int size = this.b.size();
            if (size > 0) {
                this.j = size - 1;
            }
            int i3 = i7Var.offset;
            int i4 = size - i3;
            if (i4 <= 0) {
                i7Var.measurepoints = new j7[0];
            } else {
                i7Var.measurepoints = new j7[i4];
                while (i3 < size) {
                    i7Var.measurepoints[i3 - i7Var.offset] = this.b.get(i3).e();
                    i3++;
                }
            }
            if (this.d) {
                i7Var.teststatus = 0;
            } else if (this.q && this.e) {
                i7Var.teststatus = 3;
            } else if (this.f) {
                i7Var.teststatus = 4;
            } else {
                i7Var.teststatus = 1;
            }
        }
    }

    public void a(long j2) {
        this.l = j2;
    }

    public void a(boolean z) {
        this.q = z;
    }

    public void a() {
        this.f = true;
    }
}
