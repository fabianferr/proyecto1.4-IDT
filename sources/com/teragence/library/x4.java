package com.teragence.library;

import com.teragence.client.b;
import com.teragence.library.a5;
import com.teragence.library.w4;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class x4 implements a5 {
    private static final String c = "com.teragence.library.x4";
    private final r5 a;
    private final j1 b;

    public x4(r5 r5Var, j1 j1Var) {
        this.a = r5Var;
        this.b = j1Var;
    }

    private int a(Socket socket, i3 i3Var) {
        w4.a a2 = new w4(socket, i3Var.l().e()).a();
        if (this.a.a((d6) new t7(i3Var.d(), i3Var.e(), i3Var.b(), a2.c(), (int) a2.a(), (int) a2.b(), i3Var.l().c(), i3Var.i(), i3Var.a()))) {
            long k = i3Var.k();
            Date date = new Date();
            String b2 = i3Var.b();
            w5 d = i3Var.d().d();
            n5 n5Var = n5.Download;
            boolean a3 = s2.a(i3Var.e());
            boolean z = false;
            boolean z2 = i3Var.d().a().length() > 0;
            if (i3Var.d().g().length() > 0) {
                z = true;
            }
            u7 u7Var = new u7(k, date, b2, d, n5Var, a3, z2, z);
            if (this.a.a((e6) u7Var)) {
                return a2.c();
            }
            throw new c5(u7Var);
        }
        throw new a1("report download failed");
    }

    private b a(DatagramSocket datagramSocket, i3 i3Var, UUID uuid) {
        DatagramSocket datagramSocket2 = datagramSocket;
        int a2 = w0.a(i3Var.l().k(), i3Var.l().f(), datagramSocket, 1000);
        l5[] b2 = b(datagramSocket, i3Var, uuid);
        if (this.a.a((y5) new p7(uuid, b2, a2, i3Var.d(), i3Var.e(), i3Var.l().c(), i3Var.b(), i3Var.i(), i3Var.a()))) {
            long k = i3Var.k();
            Date date = new Date();
            String b3 = i3Var.b();
            w5 d = i3Var.d().d();
            n5 n5Var = n5.BurstDown;
            boolean a3 = s2.a(i3Var.e());
            boolean z = false;
            boolean z2 = i3Var.d().a().length() > 0;
            if (i3Var.d().g().length() > 0) {
                z = true;
            }
            u7 u7Var = new u7(k, date, b3, d, n5Var, a3, z2, z);
            if (this.a.a((e6) u7Var)) {
                return new b(b2.length, b2.length * i3Var.l().h());
            }
            throw new c5(u7Var);
        }
        throw new a1("Measurement report failed");
    }

    private b a(DatagramSocket datagramSocket, i3 i3Var, m5[] m5VarArr, UUID uuid) {
        DatagramSocket datagramSocket2 = datagramSocket;
        int a2 = w0.a(i3Var.l().k(), i3Var.l().f(), datagramSocket2, 1000);
        c(datagramSocket2, i3Var, uuid);
        r5 r5Var = this.a;
        r7 r7Var = r5;
        r7 r7Var2 = new r7(uuid, m5VarArr, a2, i3Var.d(), i3Var.e(), i3Var.b(), datagramSocket.getLocalPort(), i3Var.l().c(), i3Var.i(), i3Var.a());
        if (r5Var.a((b6) r7Var)) {
            long k = i3Var.k();
            Date date = new Date();
            String b2 = i3Var.b();
            w5 d = i3Var.d().d();
            n5 n5Var = n5.BurstUp;
            boolean a3 = s2.a(i3Var.e());
            boolean z = false;
            boolean z2 = i3Var.d().a().length() > 0;
            if (i3Var.d().g().length() > 0) {
                z = true;
            }
            u7 u7Var = new u7(k, date, b2, d, n5Var, a3, z2, z);
            if (this.a.a((e6) u7Var)) {
                return new b(i3Var.l().j(), i3Var.l().j() * i3Var.l().h());
            }
            throw new c5(u7Var);
        }
        throw new a1("Measurement report failed");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.net.DatagramSocket] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.net.Socket] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.teragence.client.g r7, com.teragence.library.i3 r8, com.teragence.library.m5[] r9, com.teragence.library.a5.a r10) {
        /*
            r6 = this;
            java.lang.String r0 = "Sending updated received counts"
            r1 = 0
            com.teragence.library.i r2 = r8.l()     // Catch:{ all -> 0x007e }
            int r2 = r2.f()     // Catch:{ all -> 0x007e }
            java.net.DatagramSocket r2 = r7.a(r2)     // Catch:{ all -> 0x007e }
            if (r2 == 0) goto L_0x0073
            r3 = 1
            r2.setReuseAddress(r3)     // Catch:{ all -> 0x007b }
            java.util.UUID r3 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x007b }
            java.lang.String r4 = c     // Catch:{ all -> 0x007b }
            java.lang.String r5 = "Sending updated transmitted counts"
            com.teragence.client.i.a((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x007b }
            com.teragence.client.b r9 = r6.a((java.net.DatagramSocket) r2, (com.teragence.library.i3) r8, (com.teragence.library.m5[]) r9, (java.util.UUID) r3)     // Catch:{ all -> 0x007b }
            r10.c(r9)     // Catch:{ all -> 0x007b }
            com.teragence.client.i.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x007b }
            com.teragence.client.b r9 = r6.a(r2, r8, r3)     // Catch:{ all -> 0x007b }
            r10.b(r9)     // Catch:{ all -> 0x007b }
            if (r2 == 0) goto L_0x0036
            r2.close()
        L_0x0036:
            boolean r9 = r8.j()
            if (r9 == 0) goto L_0x0072
            com.teragence.library.i r9 = r8.l()     // Catch:{ all -> 0x006b }
            java.net.InetAddress r9 = r9.e()     // Catch:{ all -> 0x006b }
            r2 = 80
            java.net.Socket r1 = r7.a(r9, r2)     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0062
            com.teragence.client.b r7 = new com.teragence.client.b     // Catch:{ all -> 0x006b }
            int r8 = r6.a((java.net.Socket) r1, (com.teragence.library.i3) r8)     // Catch:{ all -> 0x006b }
            r9 = 0
            r7.<init>(r9, r8)     // Catch:{ all -> 0x006b }
            r10.a(r7)     // Catch:{ all -> 0x006b }
            com.teragence.client.i.a((java.lang.String) r4, (java.lang.String) r0)     // Catch:{ all -> 0x006b }
            if (r1 == 0) goto L_0x0072
            r1.close()     // Catch:{ Exception -> 0x0072 }
            goto L_0x0072
        L_0x0062:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x006b }
            java.lang.String r8 = "tcpSocket == null"
            r7.<init>(r8)     // Catch:{ all -> 0x006b }
            throw r7     // Catch:{ all -> 0x006b }
        L_0x006b:
            r7 = move-exception
            if (r1 == 0) goto L_0x0071
            r1.close()     // Catch:{ Exception -> 0x0071 }
        L_0x0071:
            throw r7
        L_0x0072:
            return
        L_0x0073:
            java.io.IOException r7 = new java.io.IOException     // Catch:{ all -> 0x007b }
            java.lang.String r8 = "DatagramSocket == null"
            r7.<init>(r8)     // Catch:{ all -> 0x007b }
            throw r7     // Catch:{ all -> 0x007b }
        L_0x007b:
            r7 = move-exception
            r1 = r2
            goto L_0x007f
        L_0x007e:
            r7 = move-exception
        L_0x007f:
            if (r1 == 0) goto L_0x0084
            r1.close()
        L_0x0084:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.teragence.library.x4.a(com.teragence.client.g, com.teragence.library.i3, com.teragence.library.m5[], com.teragence.library.a5$a):void");
    }

    private l5[] b(DatagramSocket datagramSocket, i3 i3Var, UUID uuid) {
        List<y0> a2 = x0.a(i3Var.l().k(), i3Var.l().f(), uuid, i3Var.l().j(), i3Var.l().h(), i3Var.l().o(), datagramSocket);
        l5[] l5VarArr = new l5[a2.size()];
        for (int i = 0; i < a2.size(); i++) {
            y0 y0Var = a2.get(i);
            l5VarArr[i] = new l5(y0Var.b, y0Var.c);
        }
        return l5VarArr;
    }

    private void c(DatagramSocket datagramSocket, i3 i3Var, UUID uuid) {
        w0.a(new y4(i3Var.l().j(), i3Var.l().h(), i3Var.l().k(), i3Var.l().f(), uuid).a(), i3Var.l().i(), datagramSocket);
        try {
            Thread.sleep((long) i3Var.l().m());
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public void a(i3 i3Var, a5.a aVar) {
        a(this.b.a(i3Var.l().k(), i3Var.h()), i3Var, i3Var.g(), aVar);
    }
}
