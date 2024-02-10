package com.umlaut.crowd.internal;

import android.content.Context;

public class ha extends x6 {
    public static final String j = "ha";
    private static final boolean k = false;
    private final int h;
    private final String i;

    public ha(Context context, w6 w6Var, String str, int i2, int i3, int i4, int i5, String str2) {
        this.a = context;
        this.b = w6Var;
        this.c = str;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.h = i5;
        this.i = str2;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:40|39|41|42|(2:44|45)|46|47|48|62|49) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0067, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0087, code lost:
        r17 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ac, code lost:
        r0 = th;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x008e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:46:0x00a1 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00b3 */
    /* JADX WARNING: Removed duplicated region for block: B:37:? A[ExcHandler: IOException (unused java.io.IOException), SYNTHETIC, Splitter:B:16:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x009e A[SYNTHETIC, Splitter:B:44:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b0 A[SYNTHETIC, Splitter:B:53:0x00b0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.umlaut.crowd.internal.p4 r19) {
        /*
            r18 = this;
            r1 = r18
            int r0 = r1.h
            r2 = 443(0x1bb, float:6.21E-43)
            r3 = 0
            r4 = 1
            if (r0 != r2) goto L_0x000c
            r0 = 1
            goto L_0x000d
        L_0x000c:
            r0 = 0
        L_0x000d:
            javax.net.SocketFactory r2 = javax.net.SocketFactory.getDefault()
            int r5 = r1.f
            javax.net.SocketFactory r5 = android.net.SSLCertificateSocketFactory.getDefault(r5)
            android.net.SSLCertificateSocketFactory r5 = (android.net.SSLCertificateSocketFactory) r5
            java.net.InetSocketAddress r6 = new java.net.InetSocketAddress
            java.lang.String r7 = r1.c
            int r8 = r1.h
            r6.<init>(r7, r8)
            com.umlaut.crowd.internal.w6 r7 = r1.b
            r7.a()
            long r7 = android.os.SystemClock.elapsedRealtime()
            r15 = 0
        L_0x002c:
            int r9 = r1.d
            if (r15 >= r9) goto L_0x00ba
            boolean r9 = r1.g
            if (r9 == 0) goto L_0x0035
            return r3
        L_0x0035:
            r9 = 0
            if (r0 == 0) goto L_0x0042
            java.net.Socket r9 = r5.createSocket()     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            java.lang.String r10 = r1.i     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            com.umlaut.crowd.internal.j3.a((android.net.SSLCertificateSocketFactory) r5, (java.net.Socket) r9, (java.lang.String) r10)     // Catch:{ IOException -> 0x008c, all -> 0x008a }
            goto L_0x0046
        L_0x0042:
            java.net.Socket r9 = r2.createSocket()     // Catch:{ IOException -> 0x008c, all -> 0x008a }
        L_0x0046:
            r13 = r9
            r13.setTcpNoDelay(r4)     // Catch:{ IOException -> 0x0087, all -> 0x0081 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0087, all -> 0x0081 }
            long r11 = r9 - r7
            com.umlaut.crowd.internal.w6 r9 = r1.b     // Catch:{ IOException -> 0x0087, all -> 0x0081 }
            r9.a(r15, r11)     // Catch:{ IOException -> 0x0087, all -> 0x0081 }
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0087, all -> 0x0081 }
            int r14 = r1.f     // Catch:{ IOException -> 0x0087, all -> 0x0081 }
            r13.connect(r6, r14)     // Catch:{ IOException -> 0x0087, all -> 0x0081 }
            if (r0 == 0) goto L_0x006a
            r14 = r13
            javax.net.ssl.SSLSocket r14 = (javax.net.ssl.SSLSocket) r14     // Catch:{ IOException -> 0x0087, all -> 0x0067 }
            r14.startHandshake()     // Catch:{ IOException -> 0x0087, all -> 0x0067 }
            goto L_0x006a
        L_0x0067:
            r0 = move-exception
            r9 = r13
            goto L_0x00ae
        L_0x006a:
            long r16 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x0087, all -> 0x0081 }
            long r9 = r16 - r9
            int r10 = (int) r9     // Catch:{ IOException -> 0x0087, all -> 0x0081 }
            com.umlaut.crowd.internal.w6 r9 = r1.b     // Catch:{ IOException -> 0x0087, all -> 0x0081 }
            long r3 = (long) r10
            r10 = r15
            r17 = r13
            r13 = r3
            r9.b(r10, r11, r13)     // Catch:{ IOException -> 0x008e }
            r17.close()     // Catch:{ Exception -> 0x007e }
        L_0x007e:
            int r3 = r1.e     // Catch:{ InterruptedException -> 0x00a7 }
            goto L_0x00a3
        L_0x0081:
            r0 = move-exception
            r17 = r13
        L_0x0084:
            r9 = r17
            goto L_0x00ae
        L_0x0087:
            r17 = r13
            goto L_0x008e
        L_0x008a:
            r0 = move-exception
            goto L_0x00ae
        L_0x008c:
            r17 = r9
        L_0x008e:
            com.umlaut.crowd.internal.w6 r9 = r1.b     // Catch:{ all -> 0x00ac }
            long r3 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00ac }
            long r11 = r3 - r7
            r13 = -1
            r10 = r15
            r9.b(r10, r11, r13)     // Catch:{ all -> 0x00ac }
            if (r17 == 0) goto L_0x00a1
            r17.close()     // Catch:{ Exception -> 0x00a1 }
        L_0x00a1:
            int r3 = r1.e     // Catch:{ InterruptedException -> 0x00a7 }
        L_0x00a3:
            long r3 = (long) r3     // Catch:{ InterruptedException -> 0x00a7 }
            java.lang.Thread.sleep(r3)     // Catch:{ InterruptedException -> 0x00a7 }
        L_0x00a7:
            int r15 = r15 + 1
            r3 = 0
            r4 = 1
            goto L_0x002c
        L_0x00ac:
            r0 = move-exception
            goto L_0x0084
        L_0x00ae:
            if (r9 == 0) goto L_0x00b3
            r9.close()     // Catch:{ Exception -> 0x00b3 }
        L_0x00b3:
            int r2 = r1.e     // Catch:{ InterruptedException -> 0x00b9 }
            long r2 = (long) r2     // Catch:{ InterruptedException -> 0x00b9 }
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x00b9 }
        L_0x00b9:
            throw r0
        L_0x00ba:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.ha.a(com.umlaut.crowd.internal.p4):boolean");
    }

    public void a() {
        this.g = true;
    }
}
