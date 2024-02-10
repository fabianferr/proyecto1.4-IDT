package com.umlaut.crowd.internal;

import java.io.IOException;

public class qb extends Thread {
    r9 a;
    gb b;
    ya c;
    b9 d;
    private long e = 10000;
    boolean f;
    private boolean g;

    public qb(boolean z, gb gbVar) {
        this.f = z;
        this.b = gbVar;
    }

    public void a(ya yaVar) {
        this.c = yaVar;
    }

    public long b() {
        return this.e;
    }

    public boolean c() {
        r9 r9Var = this.a;
        return r9Var != null && r9Var.isOpen();
    }

    public void d() {
        this.g = true;
        interrupt();
        b9 b9Var = this.d;
        if (b9Var != null) {
            b9Var.m();
        }
        try {
            join();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        a();
        super.finalize();
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [com.umlaut.crowd.internal.b9, com.umlaut.crowd.internal.r9] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x0180 A[SYNTHETIC, Splitter:B:117:0x0180] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0114 A[Catch:{ all -> 0x0134 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r20 = this;
            r1 = r20
            com.umlaut.crowd.internal.b9 r3 = new com.umlaut.crowd.internal.b9     // Catch:{ IOException -> 0x015d, TimeoutException -> 0x015b }
            r3.<init>()     // Catch:{ IOException -> 0x015d, TimeoutException -> 0x015b }
            r1.d = r3     // Catch:{ all -> 0x0147 }
            com.umlaut.crowd.internal.r9 r0 = r1.a     // Catch:{ all -> 0x0147 }
            java.nio.channels.SocketChannel r0 = r0.c()     // Catch:{ all -> 0x0147 }
            java.net.Socket r0 = r0.socket()     // Catch:{ all -> 0x0147 }
            r4 = 1
            r0.setTcpNoDelay(r4)     // Catch:{ all -> 0x0147 }
            com.umlaut.crowd.internal.r9 r0 = r1.a     // Catch:{ all -> 0x0147 }
            java.nio.channels.SocketChannel r0 = r0.c()     // Catch:{ all -> 0x0147 }
            r5 = 0
            r0.configureBlocking(r5)     // Catch:{ all -> 0x0147 }
            boolean r0 = r1.f     // Catch:{ all -> 0x0147 }
            r6 = 5
            if (r0 == 0) goto L_0x0032
            com.umlaut.crowd.internal.r9 r0 = r1.a     // Catch:{ all -> 0x002d }
            r0.a(r3, r6, r0)     // Catch:{ all -> 0x002d }
            r0 = 1
            goto L_0x0038
        L_0x002d:
            r0 = move-exception
            r2 = r0
            r4 = r3
            goto L_0x014a
        L_0x0032:
            com.umlaut.crowd.internal.r9 r0 = r1.a     // Catch:{ all -> 0x0147 }
            r0.a(r3, r4, r0)     // Catch:{ all -> 0x0147 }
            r0 = 0
        L_0x0038:
            com.umlaut.crowd.internal.gb r7 = r1.b     // Catch:{ all -> 0x0147 }
            int r8 = r7.count     // Catch:{ all -> 0x0147 }
            int r7 = r7.sleep     // Catch:{ all -> 0x0147 }
            java.lang.String r9 = "ping"
            java.lang.String r10 = "UTF8"
            byte[] r9 = r9.getBytes(r10)     // Catch:{ all -> 0x0147 }
            r1.g = r5     // Catch:{ all -> 0x0147 }
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.wrap(r9)     // Catch:{ all -> 0x0147 }
            r10.clear()     // Catch:{ all -> 0x0147 }
            r10.put(r9)     // Catch:{ all -> 0x0147 }
            r10.flip()     // Catch:{ all -> 0x0147 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0147 }
            long r13 = r1.e     // Catch:{ all -> 0x0147 }
            long r11 = r11 + r13
            r13 = 0
            r15 = 0
        L_0x005f:
            boolean r2 = r1.g     // Catch:{ all -> 0x0147 }
            if (r2 != 0) goto L_0x0136
            if (r8 <= 0) goto L_0x0136
            long r5 = r1.e     // Catch:{ all -> 0x0147 }
            int r5 = r3.b((long) r5)     // Catch:{ all -> 0x0147 }
            java.lang.String r6 = "Ping is timed out"
            if (r5 == 0) goto L_0x012d
            long r17 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0147 }
            int r5 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r5 < 0) goto L_0x0126
            java.util.Set r5 = r3.k()     // Catch:{ all -> 0x0147 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x0147 }
        L_0x007f:
            boolean r6 = r5.hasNext()     // Catch:{ all -> 0x0147 }
            if (r6 == 0) goto L_0x0122
            java.lang.Object r6 = r5.next()     // Catch:{ all -> 0x0147 }
            com.umlaut.crowd.internal.a9 r6 = (com.umlaut.crowd.internal.a9) r6     // Catch:{ all -> 0x0147 }
            boolean r17 = r6.i()     // Catch:{ all -> 0x0147 }
            if (r17 != 0) goto L_0x0092
            goto L_0x007f
        L_0x0092:
            boolean r17 = r6.h()     // Catch:{ all -> 0x0147 }
            if (r17 == 0) goto L_0x00ee
            com.umlaut.crowd.internal.r9 r2 = r1.a     // Catch:{ all -> 0x0147 }
            int r2 = r2.b(r4)     // Catch:{ all -> 0x0147 }
            com.umlaut.crowd.internal.r9 r4 = r1.a     // Catch:{ all -> 0x0147 }
            r4.e()     // Catch:{ all -> 0x0147 }
            r4 = -1
            if (r2 != r4) goto L_0x00a9
            r4 = 1
            r1.g = r4     // Catch:{ all -> 0x002d }
        L_0x00a9:
            int r4 = r9.length     // Catch:{ all -> 0x0147 }
            if (r2 != r4) goto L_0x00ee
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0147 }
            r4 = r3
            long r2 = r1.e     // Catch:{ all -> 0x0134 }
            long r11 = r11 + r2
            r2 = 5
            r6.a((int) r2)     // Catch:{ all -> 0x0134 }
            r3 = 0
            r10.position(r3)     // Catch:{ all -> 0x0134 }
            boolean r0 = r1.f     // Catch:{ all -> 0x0134 }
            if (r0 == 0) goto L_0x00ec
            long r16 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0134 }
            com.umlaut.crowd.internal.ya r0 = r1.c     // Catch:{ all -> 0x0134 }
            if (r0 == 0) goto L_0x00e0
            int r19 = r15 + 1
            long r2 = r16 - r13
            double r2 = (double) r2
            r16 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            java.lang.Double.isNaN(r2)
            double r2 = r2 / r16
            long r2 = java.lang.Math.round(r2)     // Catch:{ all -> 0x0134 }
            r0.a(r15, r2)     // Catch:{ all -> 0x0134 }
            r15 = r19
        L_0x00e0:
            long r2 = (long) r7     // Catch:{ all -> 0x0134 }
            boolean r0 = com.umlaut.crowd.internal.q9.a(r2)     // Catch:{ all -> 0x0134 }
            if (r0 != 0) goto L_0x00ea
            r0 = 1
            r1.g = r0     // Catch:{ all -> 0x0134 }
        L_0x00ea:
            int r8 = r8 + -1
        L_0x00ec:
            r0 = 1
            goto L_0x00ef
        L_0x00ee:
            r4 = r3
        L_0x00ef:
            if (r0 == 0) goto L_0x011a
            boolean r2 = r6.j()     // Catch:{ all -> 0x0134 }
            if (r2 == 0) goto L_0x011a
            boolean r2 = r1.f     // Catch:{ all -> 0x0134 }
            if (r2 == 0) goto L_0x0105
            int r2 = r10.position()     // Catch:{ all -> 0x0134 }
            if (r2 != 0) goto L_0x0105
            long r13 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0134 }
        L_0x0105:
            com.umlaut.crowd.internal.r9 r2 = r1.a     // Catch:{ all -> 0x0134 }
            r2.write(r10)     // Catch:{ all -> 0x0134 }
            int r2 = r10.position()     // Catch:{ all -> 0x0134 }
            int r3 = r10.limit()     // Catch:{ all -> 0x0134 }
            if (r2 != r3) goto L_0x011a
            r2 = 1
            r6.a((int) r2)     // Catch:{ all -> 0x0134 }
            r0 = 0
            goto L_0x011b
        L_0x011a:
            r2 = 1
        L_0x011b:
            r5.remove()     // Catch:{ all -> 0x0134 }
            r3 = r4
            r4 = 1
            goto L_0x007f
        L_0x0122:
            r5 = 0
            r6 = 5
            goto L_0x005f
        L_0x0126:
            r4 = r3
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0134 }
            r0.<init>(r6)     // Catch:{ all -> 0x0134 }
            throw r0     // Catch:{ all -> 0x0134 }
        L_0x012d:
            r4 = r3
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0134 }
            r0.<init>(r6)     // Catch:{ all -> 0x0134 }
            throw r0     // Catch:{ all -> 0x0134 }
        L_0x0134:
            r0 = move-exception
            goto L_0x0149
        L_0x0136:
            r4 = r3
            r4.close()     // Catch:{ IOException -> 0x015d, TimeoutException -> 0x015b }
            com.umlaut.crowd.internal.r9 r0 = r1.a
            if (r0 == 0) goto L_0x0175
            r0.close()     // Catch:{ IOException -> 0x0145 }
            r2 = 0
            r1.a = r2     // Catch:{ IOException -> 0x0145 }
            goto L_0x0175
        L_0x0145:
            r0 = move-exception
            goto L_0x0170
        L_0x0147:
            r0 = move-exception
            r4 = r3
        L_0x0149:
            r2 = r0
        L_0x014a:
            throw r2     // Catch:{ all -> 0x014b }
        L_0x014b:
            r0 = move-exception
            r3 = r0
            r4.close()     // Catch:{ all -> 0x0151 }
            goto L_0x0156
        L_0x0151:
            r0 = move-exception
            r4 = r0
            r2.addSuppressed(r4)     // Catch:{ IOException -> 0x015d, TimeoutException -> 0x015b }
        L_0x0156:
            throw r3     // Catch:{ IOException -> 0x015d, TimeoutException -> 0x015b }
        L_0x0157:
            r0 = move-exception
            r3 = r0
            r2 = 0
            goto L_0x017c
        L_0x015b:
            r0 = move-exception
            goto L_0x015e
        L_0x015d:
            r0 = move-exception
        L_0x015e:
            com.umlaut.crowd.internal.ya r2 = r1.c     // Catch:{ all -> 0x0179 }
            if (r2 == 0) goto L_0x0165
            r2.a(r0)     // Catch:{ all -> 0x0157 }
        L_0x0165:
            com.umlaut.crowd.internal.r9 r0 = r1.a
            if (r0 == 0) goto L_0x0175
            r0.close()     // Catch:{ IOException -> 0x0145 }
            r2 = 0
            r1.a = r2     // Catch:{ IOException -> 0x0145 }
            goto L_0x0175
        L_0x0170:
            com.umlaut.crowd.internal.ya r2 = r1.c
            r2.a(r0)
        L_0x0175:
            r2 = 0
            r1.d = r2
            return
        L_0x0179:
            r0 = move-exception
            r2 = 0
            r3 = r0
        L_0x017c:
            com.umlaut.crowd.internal.r9 r0 = r1.a
            if (r0 == 0) goto L_0x018c
            r0.close()     // Catch:{ IOException -> 0x0186 }
            r1.a = r2     // Catch:{ IOException -> 0x0186 }
            goto L_0x018c
        L_0x0186:
            r0 = move-exception
            com.umlaut.crowd.internal.ya r4 = r1.c
            r4.a(r0)
        L_0x018c:
            r1.d = r2
            goto L_0x0190
        L_0x018f:
            throw r3
        L_0x0190:
            goto L_0x018f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.qb.run():void");
    }

    public boolean a(r9 r9Var) {
        this.a = r9Var;
        return true;
    }

    public void a(long j) {
        this.e = j;
    }

    public void a() {
        d();
        r9 r9Var = this.a;
        if (r9Var != null && r9Var.isOpen()) {
            try {
                this.a.close();
            } catch (IOException e2) {
                this.c.a(e2);
            }
        }
    }
}
