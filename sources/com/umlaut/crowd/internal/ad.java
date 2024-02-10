package com.umlaut.crowd.internal;

import java.io.IOException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.Selector;
import java.util.ArrayList;

public class ad extends Thread {
    private static final int e = 1000;
    private final bd a;
    private final ArrayList<DatagramChannel> b = new ArrayList<>();
    private boolean c = false;
    private Selector d;

    public ad(bd bdVar, DatagramChannel datagramChannel) throws IOException {
        this.a = bdVar;
        if (bdVar == null) {
            throw new IllegalArgumentException("ReceiveThread handler not set!");
        } else if (datagramChannel != null) {
            this.d = Selector.open();
            a(datagramChannel);
        } else {
            throw new IllegalArgumentException("serverSocket not set!");
        }
    }

    public synchronized void a(DatagramChannel datagramChannel) throws IOException {
        datagramChannel.configureBlocking(false);
        if (datagramChannel.socket().getSoTimeout() == 0) {
            datagramChannel.socket().setSoTimeout(1000);
        }
        datagramChannel.register(this.d, 1);
        this.b.add(datagramChannel);
    }

    public void b() {
        this.c = false;
        try {
            this.d.wakeup();
            join();
        } catch (InterruptedException e2) {
            this.a.a((Throwable) e2);
        }
    }

    public void c() throws InterruptedException {
        if (!isAlive()) {
            synchronized (this) {
                if (!isAlive()) {
                    wait(10000);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:116:0x010f A[EDGE_INSN: B:116:0x010f->B:70:0x010f ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0108 A[Catch:{ IOException -> 0x0113 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0125 A[Catch:{ Error | Exception -> 0x013c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r17 = this;
            r1 = r17
            r2 = 1
            r1.c = r2
            int r0 = com.umlaut.crowd.internal.wc.i     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
            com.umlaut.crowd.internal.bd r0 = r1.a     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
            r0.c()     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
            monitor-enter(r17)     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
            r17.notify()     // Catch:{ all -> 0x0137 }
            monitor-exit(r17)     // Catch:{ all -> 0x0137 }
            com.umlaut.crowd.internal.wc r4 = new com.umlaut.crowd.internal.wc     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
            r4.<init>()     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
            r5 = 0
            r0 = 0
        L_0x001c:
            boolean r6 = r1.c     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
            if (r6 == 0) goto L_0x012c
            if (r0 == 0) goto L_0x0031
            java.io.PrintStream r0 = java.lang.System.out     // Catch:{ IOException -> 0x002b }
            java.lang.String r6 = "WARN: TOO much Load on receiver Interface - normalizing"
            r0.println(r6)     // Catch:{ IOException -> 0x002b }
            r6 = 0
            goto L_0x0032
        L_0x002b:
            r0 = move-exception
            r2 = r0
            r15 = r3
            r0 = 0
            goto L_0x0121
        L_0x0031:
            r6 = r0
        L_0x0032:
            java.nio.channels.Selector r0 = r1.d     // Catch:{ IOException -> 0x011d }
            r0.select()     // Catch:{ IOException -> 0x011d }
            boolean r0 = r1.c     // Catch:{ IOException -> 0x011d }
            if (r0 != 0) goto L_0x003d
            goto L_0x012c
        L_0x003d:
            java.nio.channels.Selector r0 = r1.d     // Catch:{ IOException -> 0x011d }
            java.util.Set r0 = r0.selectedKeys()     // Catch:{ IOException -> 0x011d }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IOException -> 0x011d }
        L_0x0047:
            boolean r7 = r0.hasNext()     // Catch:{ IOException -> 0x011d }
            if (r7 == 0) goto L_0x011a
            java.lang.Object r7 = r0.next()     // Catch:{ IOException -> 0x011d }
            java.nio.channels.SelectionKey r7 = (java.nio.channels.SelectionKey) r7     // Catch:{ IOException -> 0x011d }
            boolean r8 = r7.isValid()     // Catch:{ IOException -> 0x011d }
            if (r8 == 0) goto L_0x0115
            boolean r8 = r7.isReadable()     // Catch:{ IOException -> 0x011d }
            if (r8 == 0) goto L_0x0115
            r3.clear()     // Catch:{ IOException -> 0x011d }
            java.nio.channels.SelectableChannel r7 = r7.channel()     // Catch:{ IOException -> 0x011d }
            java.nio.channels.DatagramChannel r7 = (java.nio.channels.DatagramChannel) r7     // Catch:{ IOException -> 0x011d }
            long r8 = java.lang.System.nanoTime()     // Catch:{ IOException -> 0x011d }
            r10 = 1000000000(0x3b9aca00, double:4.94065646E-315)
            long r8 = r8 + r10
        L_0x0070:
            java.net.SocketAddress r10 = r7.receive(r3)     // Catch:{ IOException -> 0x011d }
            r11 = 0
            if (r10 == 0) goto L_0x00ef
            int r13 = r3.position()     // Catch:{ IOException -> 0x011d }
            int r14 = com.umlaut.crowd.internal.wc.h     // Catch:{ IOException -> 0x011d }
            if (r13 < r14) goto L_0x00e6
            r3.flip()     // Catch:{ IOException -> 0x011d }
            r4.a(r3, r10, r7)     // Catch:{ IOException -> 0x011d }
            r3.clear()     // Catch:{ IOException -> 0x011d }
            com.umlaut.crowd.internal.bd r13 = r1.a     // Catch:{ IOException -> 0x011d }
            com.umlaut.crowd.internal.cd r13 = r13.a((com.umlaut.crowd.internal.wc) r4)     // Catch:{ IOException -> 0x011d }
            if (r13 != 0) goto L_0x00b7
            com.umlaut.crowd.internal.bd r11 = r1.a     // Catch:{ IOException -> 0x00b2 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b2 }
            r12.<init>()     // Catch:{ IOException -> 0x00b2 }
            java.lang.String r13 = "No receiver for pkg with UUID: "
            r12.append(r13)     // Catch:{ IOException -> 0x00b2 }
            com.umlaut.crowd.internal.q0 r13 = r4.b     // Catch:{ IOException -> 0x00b2 }
            byte[] r13 = r13.a()     // Catch:{ IOException -> 0x00b2 }
            java.util.UUID r13 = java.util.UUID.nameUUIDFromBytes(r13)     // Catch:{ IOException -> 0x00b2 }
            r12.append(r13)     // Catch:{ IOException -> 0x00b2 }
            java.lang.String r12 = r12.toString()     // Catch:{ IOException -> 0x00b2 }
            r11.a((java.lang.String) r12)     // Catch:{ IOException -> 0x00b2 }
            goto L_0x00c2
        L_0x00b2:
            r0 = move-exception
            r2 = r0
            r15 = r3
            goto L_0x0120
        L_0x00b7:
            java.util.concurrent.ExecutorService r14 = r13.b     // Catch:{ IOException -> 0x011d }
            if (r14 != 0) goto L_0x00c4
            com.umlaut.crowd.internal.bd r11 = r1.a     // Catch:{ IOException -> 0x00b2 }
            java.lang.String r12 = "No receiver returned (executor is null)!"
            r11.a((java.lang.String) r12)     // Catch:{ IOException -> 0x00b2 }
        L_0x00c2:
            r15 = r3
            goto L_0x0104
        L_0x00c4:
            com.umlaut.crowd.internal.zc r14 = r13.a     // Catch:{ IOException -> 0x011d }
            if (r14 != 0) goto L_0x00d0
            com.umlaut.crowd.internal.bd r11 = r1.a     // Catch:{ IOException -> 0x00b2 }
            java.lang.String r12 = "No receiver returned (receiver is null)!"
            r11.a((java.lang.String) r12)     // Catch:{ IOException -> 0x00b2 }
            goto L_0x00c2
        L_0x00d0:
            r15 = r3
            long r2 = r4.c     // Catch:{ IOException -> 0x0113 }
            int r16 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r16 != 0) goto L_0x00db
            r14.b(r4)     // Catch:{ IOException -> 0x0113 }
            goto L_0x00f0
        L_0x00db:
            r14.a(r4)     // Catch:{ IOException -> 0x0113 }
            if (r6 == 0) goto L_0x00f0
            com.umlaut.crowd.internal.zc r2 = r13.a     // Catch:{ IOException -> 0x0113 }
            r2.a()     // Catch:{ IOException -> 0x0113 }
            goto L_0x00f0
        L_0x00e6:
            r15 = r3
            com.umlaut.crowd.internal.bd r2 = r1.a     // Catch:{ IOException -> 0x0113 }
            java.lang.String r3 = "dismiss UDP package: (too small)"
            r2.a((java.lang.String) r3)     // Catch:{ IOException -> 0x0113 }
            goto L_0x00f0
        L_0x00ef:
            r15 = r3
        L_0x00f0:
            if (r6 != 0) goto L_0x0104
            long r2 = java.lang.System.nanoTime()     // Catch:{ IOException -> 0x0113 }
            long r2 = r8 - r2
            int r13 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0104
            java.io.PrintStream r2 = java.lang.System.out     // Catch:{ IOException -> 0x0113 }
            java.lang.String r3 = "WARN: TOO much Load on receiver Interface!"
            r2.println(r3)     // Catch:{ IOException -> 0x0113 }
            r6 = 1
        L_0x0104:
            boolean r2 = r1.c     // Catch:{ IOException -> 0x0113 }
            if (r2 == 0) goto L_0x010f
            if (r10 != 0) goto L_0x010b
            goto L_0x010f
        L_0x010b:
            r3 = r15
            r2 = 1
            goto L_0x0070
        L_0x010f:
            r0.remove()     // Catch:{ IOException -> 0x0113 }
            goto L_0x0116
        L_0x0113:
            r0 = move-exception
            goto L_0x011f
        L_0x0115:
            r15 = r3
        L_0x0116:
            r3 = r15
            r2 = 1
            goto L_0x0047
        L_0x011a:
            r0 = r6
            goto L_0x001c
        L_0x011d:
            r0 = move-exception
            r15 = r3
        L_0x011f:
            r2 = r0
        L_0x0120:
            r0 = r6
        L_0x0121:
            com.umlaut.crowd.internal.bd r3 = r1.a     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
            if (r3 == 0) goto L_0x0128
            r3.a((java.lang.Throwable) r2)     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
        L_0x0128:
            r3 = r15
            r2 = 1
            goto L_0x001c
        L_0x012c:
            com.umlaut.crowd.internal.bd r0 = r1.a
            r0.e()
            java.nio.channels.Selector r0 = r1.d     // Catch:{ IOException -> 0x0136 }
            r0.close()     // Catch:{ IOException -> 0x0136 }
        L_0x0136:
            return
        L_0x0137:
            r0 = move-exception
            monitor-exit(r17)     // Catch:{ all -> 0x0137 }
            throw r0     // Catch:{ Error -> 0x013e, Exception -> 0x013c }
        L_0x013a:
            r0 = move-exception
            goto L_0x0151
        L_0x013c:
            r0 = move-exception
            goto L_0x013f
        L_0x013e:
            r0 = move-exception
        L_0x013f:
            com.umlaut.crowd.internal.bd r2 = r1.a     // Catch:{ all -> 0x013a }
            if (r2 == 0) goto L_0x0146
            r2.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x013a }
        L_0x0146:
            com.umlaut.crowd.internal.bd r0 = r1.a
            r0.e()
            java.nio.channels.Selector r0 = r1.d     // Catch:{ IOException -> 0x0150 }
            r0.close()     // Catch:{ IOException -> 0x0150 }
        L_0x0150:
            return
        L_0x0151:
            com.umlaut.crowd.internal.bd r2 = r1.a
            r2.e()
            java.nio.channels.Selector r2 = r1.d     // Catch:{ IOException -> 0x015b }
            r2.close()     // Catch:{ IOException -> 0x015b }
        L_0x015b:
            goto L_0x015d
        L_0x015c:
            throw r0
        L_0x015d:
            goto L_0x015c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.ad.run():void");
    }

    public boolean a() {
        return this.c;
    }
}
