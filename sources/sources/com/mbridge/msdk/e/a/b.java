package com.mbridge.msdk.e.a;

import java.util.concurrent.BlockingQueue;

/* compiled from: CacheDispatcher */
public final class b extends Thread {
    private final BlockingQueue<m<?>> a;
    /* access modifiers changed from: private */
    public final BlockingQueue<m<?>> b;
    private final a c;
    private final q d;
    private volatile boolean e = false;
    private final w f;

    public b(BlockingQueue<m<?>> blockingQueue, BlockingQueue<m<?>> blockingQueue2, a aVar, q qVar) {
        this.a = blockingQueue;
        this.b = blockingQueue2;
        this.c = aVar;
        this.d = qVar;
        this.f = new w(this, blockingQueue2, qVar);
    }

    public final void a() {
        this.e = true;
        interrupt();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0082 A[Catch:{ all -> 0x00ef, InterruptedException -> 0x00f4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009c A[Catch:{ all -> 0x00ef, InterruptedException -> 0x00f4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r15 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
            com.mbridge.msdk.e.a.a r0 = r15.c
            r0.a()
        L_0x000a:
            r0 = 0
            java.util.concurrent.BlockingQueue<com.mbridge.msdk.e.a.m<?>> r1 = r15.a     // Catch:{ InterruptedException -> 0x00f4 }
            java.lang.Object r1 = r1.take()     // Catch:{ InterruptedException -> 0x00f4 }
            com.mbridge.msdk.e.a.m r1 = (com.mbridge.msdk.e.a.m) r1     // Catch:{ InterruptedException -> 0x00f4 }
            r2 = 1
            r1.a((int) r2)     // Catch:{ InterruptedException -> 0x00f4 }
            r3 = 2
            boolean r4 = r1.l()     // Catch:{ all -> 0x00ef }
            if (r4 == 0) goto L_0x0027
            java.lang.String r2 = "cache-discard-canceled"
            r1.a((java.lang.String) r2)     // Catch:{ all -> 0x00ef }
        L_0x0023:
            r1.a((int) r3)     // Catch:{ InterruptedException -> 0x00f4 }
            goto L_0x000a
        L_0x0027:
            com.mbridge.msdk.e.a.a r4 = r15.c     // Catch:{ all -> 0x00ef }
            java.lang.String r5 = r1.i()     // Catch:{ all -> 0x00ef }
            com.mbridge.msdk.e.a.a$a r4 = r4.a(r5)     // Catch:{ all -> 0x00ef }
            if (r4 != 0) goto L_0x0041
            com.mbridge.msdk.e.a.w r2 = r15.f     // Catch:{ all -> 0x00ef }
            boolean r2 = r2.b(r1)     // Catch:{ all -> 0x00ef }
            if (r2 != 0) goto L_0x0023
            java.util.concurrent.BlockingQueue<com.mbridge.msdk.e.a.m<?>> r2 = r15.b     // Catch:{ all -> 0x00ef }
            r2.put(r1)     // Catch:{ all -> 0x00ef }
            goto L_0x0023
        L_0x0041:
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x00ef }
            boolean r7 = r4.a(r5)     // Catch:{ all -> 0x00ef }
            if (r7 == 0) goto L_0x005c
            r1.a((com.mbridge.msdk.e.a.a.C0133a) r4)     // Catch:{ all -> 0x00ef }
            com.mbridge.msdk.e.a.w r2 = r15.f     // Catch:{ all -> 0x00ef }
            boolean r2 = r2.b(r1)     // Catch:{ all -> 0x00ef }
            if (r2 != 0) goto L_0x0023
            java.util.concurrent.BlockingQueue<com.mbridge.msdk.e.a.m<?>> r2 = r15.b     // Catch:{ all -> 0x00ef }
            r2.put(r1)     // Catch:{ all -> 0x00ef }
            goto L_0x0023
        L_0x005c:
            com.mbridge.msdk.e.a.k r14 = new com.mbridge.msdk.e.a.k     // Catch:{ all -> 0x00ef }
            r8 = 200(0xc8, float:2.8E-43)
            byte[] r9 = r4.a     // Catch:{ all -> 0x00ef }
            r10 = 0
            r11 = 0
            java.util.List<com.mbridge.msdk.e.a.g> r13 = r4.h     // Catch:{ all -> 0x00ef }
            r7 = r14
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x00ef }
            com.mbridge.msdk.e.a.o r7 = r1.a((com.mbridge.msdk.e.a.k) r14)     // Catch:{ all -> 0x00ef }
            com.mbridge.msdk.e.a.p r8 = r1.j()     // Catch:{ all -> 0x00ef }
            if (r8 == 0) goto L_0x007e
            boolean r8 = r8.a(r7, r1)     // Catch:{ all -> 0x00ef }
            if (r8 == 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r8 = 0
            goto L_0x007f
        L_0x007e:
            r8 = 1
        L_0x007f:
            r9 = 0
            if (r8 != 0) goto L_0x009c
            com.mbridge.msdk.e.a.a r4 = r15.c     // Catch:{ all -> 0x00ef }
            java.lang.String r5 = r1.i()     // Catch:{ all -> 0x00ef }
            r4.a((java.lang.String) r5, (boolean) r2)     // Catch:{ all -> 0x00ef }
            r1.a((com.mbridge.msdk.e.a.a.C0133a) r9)     // Catch:{ all -> 0x00ef }
            com.mbridge.msdk.e.a.w r2 = r15.f     // Catch:{ all -> 0x00ef }
            boolean r2 = r2.b(r1)     // Catch:{ all -> 0x00ef }
            if (r2 != 0) goto L_0x0023
            java.util.concurrent.BlockingQueue<com.mbridge.msdk.e.a.m<?>> r2 = r15.b     // Catch:{ all -> 0x00ef }
            r2.put(r1)     // Catch:{ all -> 0x00ef }
            goto L_0x0023
        L_0x009c:
            boolean r8 = r7.a()     // Catch:{ all -> 0x00ef }
            if (r8 != 0) goto L_0x00bd
            com.mbridge.msdk.e.a.a r4 = r15.c     // Catch:{ all -> 0x00ef }
            java.lang.String r5 = r1.i()     // Catch:{ all -> 0x00ef }
            r4.a((java.lang.String) r5, (boolean) r2)     // Catch:{ all -> 0x00ef }
            r1.a((com.mbridge.msdk.e.a.a.C0133a) r9)     // Catch:{ all -> 0x00ef }
            com.mbridge.msdk.e.a.w r2 = r15.f     // Catch:{ all -> 0x00ef }
            boolean r2 = r2.b(r1)     // Catch:{ all -> 0x00ef }
            if (r2 != 0) goto L_0x0023
            java.util.concurrent.BlockingQueue<com.mbridge.msdk.e.a.m<?>> r2 = r15.b     // Catch:{ all -> 0x00ef }
            r2.put(r1)     // Catch:{ all -> 0x00ef }
            goto L_0x0023
        L_0x00bd:
            long r8 = r4.f     // Catch:{ all -> 0x00ef }
            int r10 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r10 >= 0) goto L_0x00c5
            r5 = 1
            goto L_0x00c6
        L_0x00c5:
            r5 = 0
        L_0x00c6:
            if (r5 != 0) goto L_0x00cf
            com.mbridge.msdk.e.a.q r2 = r15.d     // Catch:{ all -> 0x00ef }
            r2.a((com.mbridge.msdk.e.a.m<?>) r1, (com.mbridge.msdk.e.a.o<?>) r7)     // Catch:{ all -> 0x00ef }
            goto L_0x0023
        L_0x00cf:
            r1.a((com.mbridge.msdk.e.a.a.C0133a) r4)     // Catch:{ all -> 0x00ef }
            r7.d = r2     // Catch:{ all -> 0x00ef }
            com.mbridge.msdk.e.a.w r2 = r15.f     // Catch:{ all -> 0x00ef }
            boolean r2 = r2.b(r1)     // Catch:{ all -> 0x00ef }
            if (r2 != 0) goto L_0x00e8
            com.mbridge.msdk.e.a.q r2 = r15.d     // Catch:{ all -> 0x00ef }
            com.mbridge.msdk.e.a.b$1 r4 = new com.mbridge.msdk.e.a.b$1     // Catch:{ all -> 0x00ef }
            r4.<init>(r1)     // Catch:{ all -> 0x00ef }
            r2.a(r1, r7, r4)     // Catch:{ all -> 0x00ef }
            goto L_0x0023
        L_0x00e8:
            com.mbridge.msdk.e.a.q r2 = r15.d     // Catch:{ all -> 0x00ef }
            r2.a((com.mbridge.msdk.e.a.m<?>) r1, (com.mbridge.msdk.e.a.o<?>) r7)     // Catch:{ all -> 0x00ef }
            goto L_0x0023
        L_0x00ef:
            r2 = move-exception
            r1.a((int) r3)     // Catch:{ InterruptedException -> 0x00f4 }
            throw r2     // Catch:{ InterruptedException -> 0x00f4 }
        L_0x00f4:
            boolean r1 = r15.e
            if (r1 == 0) goto L_0x0101
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            return
        L_0x0101:
            java.lang.String r1 = "Ignoring spurious interrupt of CacheDispatcher thread; use quit() to terminate it"
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.mbridge.msdk.e.a.v.c(r1, r0)
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.e.a.b.run():void");
    }
}
