package com.m2catalyst.m2sdk;

import java.util.Random;

/* compiled from: Uploader */
public abstract class a7 extends Thread {
    public final w0 a;
    public final String b;
    public boolean c = false;
    public boolean d = false;
    public long e = 0;
    public final byte[] f;

    public a7(w0 w0Var, String str, int i) {
        this.a = w0Var;
        this.b = str;
        byte[] bArr = new byte[(i * 1048576)];
        this.f = bArr;
        new Random(System.nanoTime()).nextBytes(bArr);
        start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a A[Catch:{ all -> 0x008d, all -> 0x0094, all -> 0x0115 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0019 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            java.lang.String r6 = r11.b     // Catch:{ all -> 0x008d }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008d }
            com.m2catalyst.m2sdk.w0 r2 = r11.a     // Catch:{ all -> 0x008d }
            r2.getClass()     // Catch:{ all -> 0x008d }
            java.net.Socket r2 = r2.a     // Catch:{ all -> 0x0012 }
            java.io.OutputStream r2 = r2.getOutputStream()     // Catch:{ all -> 0x0012 }
            goto L_0x0013
        L_0x0012:
            r2 = 0
        L_0x0013:
            r7 = r0
            r9 = r2
        L_0x0015:
            boolean r0 = r11.c     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x001a
            goto L_0x0075
        L_0x001a:
            com.m2catalyst.m2sdk.w0 r0 = r11.a     // Catch:{ all -> 0x008d }
            r2 = 1
            java.lang.String r3 = "application/octet-stream"
            byte[] r1 = r11.f     // Catch:{ all -> 0x008d }
            int r1 = r1.length     // Catch:{ all -> 0x008d }
            long r4 = (long) r1     // Catch:{ all -> 0x008d }
            r1 = r6
            r0.a(r1, r2, r3, r4)     // Catch:{ all -> 0x008d }
            r0 = 0
            r1 = 0
        L_0x0029:
            byte[] r2 = r11.f     // Catch:{ all -> 0x008d }
            int r3 = r2.length     // Catch:{ all -> 0x008d }
            if (r1 >= r3) goto L_0x0071
            boolean r3 = r11.c     // Catch:{ all -> 0x008d }
            if (r3 == 0) goto L_0x0033
            goto L_0x0071
        L_0x0033:
            int r3 = r1 + 16384
            int r4 = r2.length     // Catch:{ all -> 0x008d }
            if (r3 < r4) goto L_0x003b
            int r4 = r2.length     // Catch:{ all -> 0x008d }
            int r4 = r4 - r1
            goto L_0x003d
        L_0x003b:
            r4 = 16384(0x4000, float:2.2959E-41)
        L_0x003d:
            r9.write(r2, r1, r4)     // Catch:{ all -> 0x008d }
            boolean r1 = r11.c     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0045
            goto L_0x0071
        L_0x0045:
            boolean r1 = r11.d     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x004f
            r1 = 0
            r11.e = r1     // Catch:{ all -> 0x008d }
            r11.d = r0     // Catch:{ all -> 0x008d }
        L_0x004f:
            long r1 = r11.e     // Catch:{ all -> 0x008d }
            long r4 = (long) r4     // Catch:{ all -> 0x008d }
            long r1 = r1 + r4
            r11.e = r1     // Catch:{ all -> 0x008d }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008d }
            long r1 = r1 - r7
            r4 = 200(0xc8, double:9.9E-322)
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 <= 0) goto L_0x006f
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x008d }
            long r1 = r11.e     // Catch:{ all -> 0x008d }
            r4 = r11
            com.m2catalyst.m2sdk.z6$a$a r4 = (com.m2catalyst.m2sdk.z6.a.C0128a) r4     // Catch:{ all -> 0x008d }
            com.m2catalyst.m2sdk.z6$a r4 = com.m2catalyst.m2sdk.z6.a.this     // Catch:{ all -> 0x008d }
            com.m2catalyst.m2sdk.z6 r4 = com.m2catalyst.m2sdk.z6.this     // Catch:{ all -> 0x008d }
            r4.k = r1     // Catch:{ all -> 0x008d }
        L_0x006f:
            r1 = r3
            goto L_0x0029
        L_0x0071:
            boolean r0 = r11.c     // Catch:{ all -> 0x008d }
            if (r0 == 0) goto L_0x007c
        L_0x0075:
            com.m2catalyst.m2sdk.w0 r0 = r11.a     // Catch:{ all -> 0x008d }
            r0.a()     // Catch:{ all -> 0x008d }
            goto L_0x011c
        L_0x007c:
            com.m2catalyst.m2sdk.w0 r0 = r11.a     // Catch:{ all -> 0x008d }
            java.lang.String r0 = r0.c()     // Catch:{ all -> 0x008d }
            java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x008d }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x008d }
            if (r0 != 0) goto L_0x0015
            goto L_0x007c
        L_0x008d:
            r0 = move-exception
            com.m2catalyst.m2sdk.w0 r1 = r11.a     // Catch:{ all -> 0x0094 }
            r1.a()     // Catch:{ all -> 0x0094 }
            goto L_0x0095
        L_0x0094:
        L_0x0095:
            java.lang.String r0 = r0.toString()
            r1 = r11
            com.m2catalyst.m2sdk.z6$a$a r1 = (com.m2catalyst.m2sdk.z6.a.C0128a) r1
            com.m2catalyst.m2sdk.z6$a r2 = com.m2catalyst.m2sdk.z6.a.this
            com.m2catalyst.m2sdk.z6 r2 = com.m2catalyst.m2sdk.z6.this
            com.m2catalyst.m2sdk.i2 r2 = r2.n
            if (r2 == 0) goto L_0x00a9
            java.lang.String r3 = "An uploader died"
            r2.a(r3)
        L_0x00a9:
            com.m2catalyst.m2sdk.z6$a r2 = com.m2catalyst.m2sdk.z6.a.this
            com.m2catalyst.m2sdk.z6 r2 = com.m2catalyst.m2sdk.z6.this
            java.lang.String r2 = r2.j
            java.lang.String r3 = "fail"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00e9
            com.m2catalyst.m2sdk.z6$a r1 = com.m2catalyst.m2sdk.z6.a.this
            com.m2catalyst.m2sdk.z6 r1 = com.m2catalyst.m2sdk.z6.this
            com.m2catalyst.m2sdk.l6$c r1 = (com.m2catalyst.m2sdk.l6.c) r1
            com.m2catalyst.m2sdk.l6 r2 = r1.p
            com.m2catalyst.m2sdk.i2 r2 = r2.j
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Upload: FAILED (took "
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
            goto L_0x011c
        L_0x00e9:
            com.m2catalyst.m2sdk.z6$a r0 = com.m2catalyst.m2sdk.z6.a.this
            com.m2catalyst.m2sdk.z6 r0 = com.m2catalyst.m2sdk.z6.this
            java.lang.String r0 = r0.j
            java.lang.String r2 = "attempt-restart"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0105
            com.m2catalyst.m2sdk.z6$a r0 = com.m2catalyst.m2sdk.z6.a.this
            com.m2catalyst.m2sdk.z6 r0 = com.m2catalyst.m2sdk.z6.this
            java.lang.String r0 = r0.j
            java.lang.String r2 = "must-restart"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L_0x011c
        L_0x0105:
            com.m2catalyst.m2sdk.z6$a r0 = com.m2catalyst.m2sdk.z6.a.this
            com.m2catalyst.m2sdk.z6 r0 = com.m2catalyst.m2sdk.z6.this
            long r2 = r0.k
            long r4 = r0.l
            long r4 = r4 + r2
            r0.l = r4
            r2 = 100
            java.lang.Thread.sleep(r2)     // Catch:{ all -> 0x0115 }
        L_0x0115:
            com.m2catalyst.m2sdk.z6$a r0 = com.m2catalyst.m2sdk.z6.a.this
            com.m2catalyst.m2sdk.z6 r0 = com.m2catalyst.m2sdk.z6.this
            r0.a()
        L_0x011c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.a7.run():void");
    }
}
