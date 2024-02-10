package com.umlaut.crowd.timeserver;

class a {
    private static final String c = "a";
    private static final int d = 32;
    private static final int e = 40;
    private static final int f = 48;
    private static final int g = 123;
    private static final int h = 3;
    private static final int i = 3;
    private static final long j = 2208988800L;
    private long a;
    private long b;

    a() {
    }

    private void c(byte[] bArr, int i2) {
        for (int i3 = i2; i3 < i2 + 8; i3++) {
            bArr[i3] = 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r7, int r8) {
        /*
            r6 = this;
            java.lang.String r0 = "request time failed: "
            r1 = 0
            r2 = 0
            java.net.DatagramSocket r3 = new java.net.DatagramSocket     // Catch:{ Exception -> 0x004c }
            r3.<init>()     // Catch:{ Exception -> 0x004c }
            r3.setSoTimeout(r8)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            java.net.InetAddress r7 = java.net.InetAddress.getByName(r7)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r8 = 48
            byte[] r2 = new byte[r8]     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            java.net.DatagramPacket r4 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r5 = 123(0x7b, float:1.72E-43)
            r4.<init>(r2, r8, r7, r5)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r7 = 27
            r2[r1] = r7     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r7 = 40
            r6.c(r2, r7)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r3.send(r4)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            java.net.DatagramPacket r7 = new java.net.DatagramPacket     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r7.<init>(r2, r8)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r3.receive(r7)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r3.close()     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            long r7 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r6.b = r7     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r7 = 32
            long r7 = r6.b(r2, r7)     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r6.a = r7     // Catch:{ Exception -> 0x0047, all -> 0x0045 }
            r3.close()
            r7 = 1
            return r7
        L_0x0045:
            r7 = move-exception
            goto L_0x0065
        L_0x0047:
            r7 = move-exception
            r2 = r3
            goto L_0x004d
        L_0x004a:
            r7 = move-exception
            goto L_0x0064
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            java.lang.String r8 = c     // Catch:{ all -> 0x004a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x004a }
            r3.<init>(r0)     // Catch:{ all -> 0x004a }
            r3.append(r7)     // Catch:{ all -> 0x004a }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x004a }
            android.util.Log.d(r8, r7)     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0063
            r2.close()
        L_0x0063:
            return r1
        L_0x0064:
            r3 = r2
        L_0x0065:
            if (r3 == 0) goto L_0x006a
            r3.close()
        L_0x006a:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.timeserver.a.a(java.lang.String, int):boolean");
    }

    public long b() {
        return this.b;
    }

    private long b(byte[] bArr, int i2) {
        return ((a(bArr, i2) - j) * 1000) + ((a(bArr, i2 + 4) * 1000) / 4294967296L);
    }

    public long a() {
        return this.a;
    }

    private long a(byte[] bArr, int i2) {
        byte b2 = bArr[i2];
        byte b3 = bArr[i2 + 1];
        byte b4 = bArr[i2 + 2];
        byte b5 = bArr[i2 + 3];
        byte b6 = b2 & true;
        int i3 = b2;
        if (b6 == true) {
            i3 = (b2 & Byte.MAX_VALUE) + 128;
        }
        byte b7 = b3 & true;
        int i4 = b3;
        if (b7 == true) {
            i4 = (b3 & Byte.MAX_VALUE) + 128;
        }
        byte b8 = b4 & true;
        int i5 = b4;
        if (b8 == true) {
            i5 = (b4 & Byte.MAX_VALUE) + 128;
        }
        byte b9 = b5 & true;
        int i6 = b5;
        if (b9 == true) {
            i6 = (b5 & Byte.MAX_VALUE) + 128;
        }
        return (((long) i3) << 24) + (((long) i4) << 16) + (((long) i5) << 8) + ((long) i6);
    }
}
