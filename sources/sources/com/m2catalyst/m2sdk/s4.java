package com.m2catalyst.m2sdk;

/* compiled from: Pinger */
public abstract class s4 extends Thread {
    public final w0 a;
    public final String b;
    public boolean c = false;

    public s4(w0 w0Var, String str) {
        this.a = w0Var;
        this.b = str;
        start();
    }

    public abstract boolean a(long j);

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x000c */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x000c A[LOOP:0: B:4:0x000c->B:30:0x006f, LOOP_START, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r8 = this;
            java.lang.String r0 = r8.b     // Catch:{ all -> 0x0080 }
            com.m2catalyst.m2sdk.w0 r1 = r8.a     // Catch:{ all -> 0x0080 }
            r1.getClass()     // Catch:{ all -> 0x0080 }
            java.net.Socket r1 = r1.a     // Catch:{ all -> 0x000c }
            r1.getInputStream()     // Catch:{ all -> 0x000c }
        L_0x000c:
            boolean r1 = r8.c     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x0011
            goto L_0x0071
        L_0x0011:
            com.m2catalyst.m2sdk.w0 r1 = r8.a     // Catch:{ all -> 0x0080 }
            r1.a(r0)     // Catch:{ all -> 0x0080 }
            boolean r1 = r8.c     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x001b
            goto L_0x0071
        L_0x001b:
            long r1 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0080 }
            r3 = 0
            r4 = 0
        L_0x0021:
            com.m2catalyst.m2sdk.w0 r5 = r8.a     // Catch:{ all -> 0x0080 }
            java.lang.String r5 = r5.c()     // Catch:{ all -> 0x0080 }
            if (r5 != 0) goto L_0x002a
            goto L_0x005c
        L_0x002a:
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x0080 }
            java.lang.String r5 = r5.toLowerCase()     // Catch:{ all -> 0x0080 }
            java.lang.String r6 = "transfer-encoding: chunked"
            boolean r6 = r5.equals(r6)     // Catch:{ all -> 0x0080 }
            r7 = 1
            if (r6 == 0) goto L_0x003d
            r3 = 1
        L_0x003d:
            java.lang.String r6 = "200 ok"
            boolean r6 = r5.contains(r6)     // Catch:{ all -> 0x0080 }
            if (r6 == 0) goto L_0x0046
            r4 = 1
        L_0x0046:
            java.lang.String r5 = r5.trim()     // Catch:{ all -> 0x0080 }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x0080 }
            if (r5 == 0) goto L_0x0021
            if (r3 == 0) goto L_0x005c
            com.m2catalyst.m2sdk.w0 r3 = r8.a     // Catch:{ all -> 0x0080 }
            r3.c()     // Catch:{ all -> 0x0080 }
            com.m2catalyst.m2sdk.w0 r3 = r8.a     // Catch:{ all -> 0x0080 }
            r3.c()     // Catch:{ all -> 0x0080 }
        L_0x005c:
            if (r4 == 0) goto L_0x0078
            long r3 = java.lang.System.nanoTime()     // Catch:{ all -> 0x0080 }
            long r3 = r3 - r1
            boolean r1 = r8.c     // Catch:{ all -> 0x0080 }
            if (r1 == 0) goto L_0x0068
            goto L_0x0071
        L_0x0068:
            r1 = 2
            long r3 = r3 / r1
            boolean r1 = r8.a(r3)     // Catch:{ all -> 0x0080 }
            if (r1 != 0) goto L_0x000c
        L_0x0071:
            com.m2catalyst.m2sdk.w0 r0 = r8.a     // Catch:{ all -> 0x0080 }
            r0.a()     // Catch:{ all -> 0x0080 }
            goto L_0x0104
        L_0x0078:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x0080 }
            java.lang.String r1 = "Did not get a 200"
            r0.<init>(r1)     // Catch:{ all -> 0x0080 }
            throw r0     // Catch:{ all -> 0x0080 }
        L_0x0080:
            r0 = move-exception
            com.m2catalyst.m2sdk.w0 r1 = r8.a     // Catch:{ all -> 0x0087 }
            r1.a()     // Catch:{ all -> 0x0087 }
            goto L_0x0088
        L_0x0087:
        L_0x0088:
            java.lang.String r0 = r0.toString()
            r1 = r8
            com.m2catalyst.m2sdk.r4$a$a r1 = (com.m2catalyst.m2sdk.r4.a.C0126a) r1
            com.m2catalyst.m2sdk.r4$a r2 = com.m2catalyst.m2sdk.r4.a.this
            com.m2catalyst.m2sdk.r4 r2 = com.m2catalyst.m2sdk.r4.this
            com.m2catalyst.m2sdk.i2 r2 = r2.k
            if (r2 == 0) goto L_0x009c
            java.lang.String r3 = "A pinger died"
            r2.a(r3)
        L_0x009c:
            com.m2catalyst.m2sdk.r4$a r2 = com.m2catalyst.m2sdk.r4.a.this
            com.m2catalyst.m2sdk.r4 r2 = com.m2catalyst.m2sdk.r4.this
            java.lang.String r2 = r2.j
            java.lang.String r3 = "fail"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00dc
            com.m2catalyst.m2sdk.r4$a r1 = com.m2catalyst.m2sdk.r4.a.this
            com.m2catalyst.m2sdk.r4 r1 = com.m2catalyst.m2sdk.r4.this
            com.m2catalyst.m2sdk.l6$d r1 = (com.m2catalyst.m2sdk.l6.d) r1
            com.m2catalyst.m2sdk.l6 r2 = r1.p
            com.m2catalyst.m2sdk.i2 r2 = r2.j
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Ping: FAILED (took "
            r3.<init>(r4)
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r1.o
            long r4 = r4 - r6
            r3.append(r4)
            java.lang.String r4 = "ms)"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.a(r3)
            com.m2catalyst.m2sdk.l6 r2 = r1.p
            r2.a()
            com.m2catalyst.m2sdk.l6 r1 = r1.p
            r1.a(r0)
            goto L_0x0104
        L_0x00dc:
            com.m2catalyst.m2sdk.r4$a r0 = com.m2catalyst.m2sdk.r4.a.this
            com.m2catalyst.m2sdk.r4 r0 = com.m2catalyst.m2sdk.r4.this
            java.lang.String r0 = r0.j
            java.lang.String r2 = "attempt-restart"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x00f8
            com.m2catalyst.m2sdk.r4$a r0 = com.m2catalyst.m2sdk.r4.a.this
            com.m2catalyst.m2sdk.r4 r0 = com.m2catalyst.m2sdk.r4.this
            java.lang.String r0 = r0.j
            java.lang.String r2 = "must-restart"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x0104
        L_0x00f8:
            r2 = 100
            java.lang.Thread.sleep(r2)     // Catch:{ all -> 0x00fd }
        L_0x00fd:
            com.m2catalyst.m2sdk.r4$a r0 = com.m2catalyst.m2sdk.r4.a.this
            com.m2catalyst.m2sdk.r4 r0 = com.m2catalyst.m2sdk.r4.this
            r0.a()
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.s4.run():void");
    }
}
