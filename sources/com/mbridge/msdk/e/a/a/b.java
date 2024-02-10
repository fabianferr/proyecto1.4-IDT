package com.mbridge.msdk.e.a.a;

import com.mbridge.msdk.e.a.h;

/* compiled from: BasicNetwork */
public final class b implements h {
    protected final c a;
    private final a b;

    public b(a aVar) {
        this(aVar, new c(4096));
    }

    private b(a aVar, c cVar) {
        this.b = aVar;
        this.a = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00f2, code lost:
        throw new java.io.IOException();
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0115  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.e.a.k a(com.mbridge.msdk.e.a.m<?> r20) throws com.mbridge.msdk.e.a.u {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            long r3 = android.os.SystemClock.elapsedRealtime()
        L_0x0008:
            java.util.Collections.emptyList()
            r5 = 1
            r6 = 2
            r7 = 0
            r8 = 0
            com.mbridge.msdk.e.a.a$a r0 = r20.k()     // Catch:{ IOException -> 0x00fe }
            if (r0 != 0) goto L_0x001a
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ IOException -> 0x00fe }
            goto L_0x003e
        L_0x001a:
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ IOException -> 0x00fe }
            r9.<init>()     // Catch:{ IOException -> 0x00fe }
            java.lang.String r10 = r0.b     // Catch:{ IOException -> 0x00fe }
            if (r10 == 0) goto L_0x002a
            java.lang.String r10 = "If-None-Match"
            java.lang.String r11 = r0.b     // Catch:{ IOException -> 0x00fe }
            r9.put(r10, r11)     // Catch:{ IOException -> 0x00fe }
        L_0x002a:
            long r10 = r0.d     // Catch:{ IOException -> 0x00fe }
            r12 = 0
            int r14 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r14 <= 0) goto L_0x003d
            java.lang.String r10 = "If-Modified-Since"
            long r11 = r0.d     // Catch:{ IOException -> 0x00fe }
            java.lang.String r0 = com.mbridge.msdk.e.a.a.e.a((long) r11)     // Catch:{ IOException -> 0x00fe }
            r9.put(r10, r0)     // Catch:{ IOException -> 0x00fe }
        L_0x003d:
            r0 = r9
        L_0x003e:
            com.mbridge.msdk.e.a.a.a r9 = r1.b     // Catch:{ IOException -> 0x00fe }
            com.mbridge.msdk.e.a.a.f r9 = r9.a(r2, r0)     // Catch:{ IOException -> 0x00fe }
            int r11 = r9.a()     // Catch:{ IOException -> 0x00fb }
            java.util.List r0 = r9.b()     // Catch:{ IOException -> 0x00fb }
            r10 = 304(0x130, float:4.26E-43)
            if (r11 != r10) goto L_0x007a
            long r10 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00fb }
            long r16 = r10 - r3
            com.mbridge.msdk.e.a.a$a r10 = r20.k()     // Catch:{ IOException -> 0x00fb }
            if (r10 != 0) goto L_0x0069
            com.mbridge.msdk.e.a.k r10 = new com.mbridge.msdk.e.a.k     // Catch:{ IOException -> 0x00fb }
            r13 = 304(0x130, float:4.26E-43)
            r14 = 0
            r15 = 1
            r12 = r10
            r18 = r0
            r12.<init>(r13, r14, r15, r16, r18)     // Catch:{ IOException -> 0x00fb }
            goto L_0x0079
        L_0x0069:
            java.util.List r18 = com.mbridge.msdk.e.a.a.e.a((java.util.List<com.mbridge.msdk.e.a.g>) r0, (com.mbridge.msdk.e.a.a.C0133a) r10)     // Catch:{ IOException -> 0x00fb }
            com.mbridge.msdk.e.a.k r0 = new com.mbridge.msdk.e.a.k     // Catch:{ IOException -> 0x00fb }
            r13 = 304(0x130, float:4.26E-43)
            byte[] r14 = r10.a     // Catch:{ IOException -> 0x00fb }
            r15 = 1
            r12 = r0
            r12.<init>(r13, r14, r15, r16, r18)     // Catch:{ IOException -> 0x00fb }
            r10 = r0
        L_0x0079:
            return r10
        L_0x007a:
            java.io.InputStream r10 = r9.d()     // Catch:{ IOException -> 0x00fb }
            if (r10 == 0) goto L_0x008b
            int r12 = r9.c()     // Catch:{ IOException -> 0x00fb }
            com.mbridge.msdk.e.a.a.c r13 = r1.a     // Catch:{ IOException -> 0x00fb }
            byte[] r10 = com.mbridge.msdk.e.a.a.h.a(r10, r12, r13)     // Catch:{ IOException -> 0x00fb }
            goto L_0x008d
        L_0x008b:
            byte[] r10 = new byte[r7]     // Catch:{ IOException -> 0x00fb }
        L_0x008d:
            r14 = r10
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00f5 }
            long r12 = r12 - r3
            r15 = 3000(0xbb8, double:1.482E-320)
            int r10 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r10 <= 0) goto L_0x00cf
            java.lang.String r10 = "HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]"
            r15 = 5
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ IOException -> 0x00cc }
            r15[r7] = r2     // Catch:{ IOException -> 0x00cc }
            java.lang.Long r12 = java.lang.Long.valueOf(r12)     // Catch:{ IOException -> 0x00cc }
            r15[r5] = r12     // Catch:{ IOException -> 0x00cc }
            if (r14 == 0) goto L_0x00ae
            int r12 = r14.length     // Catch:{ IOException -> 0x00cc }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x00cc }
            goto L_0x00b0
        L_0x00ae:
            java.lang.String r12 = "null"
        L_0x00b0:
            r15[r6] = r12     // Catch:{ IOException -> 0x00cc }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)     // Catch:{ IOException -> 0x00cc }
            r13 = 3
            r15[r13] = r12     // Catch:{ IOException -> 0x00cc }
            com.mbridge.msdk.e.a.r r12 = r20.a()     // Catch:{ IOException -> 0x00cc }
            int r12 = r12.b()     // Catch:{ IOException -> 0x00cc }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ IOException -> 0x00cc }
            r13 = 4
            r15[r13] = r12     // Catch:{ IOException -> 0x00cc }
            com.mbridge.msdk.e.a.v.b(r10, r15)     // Catch:{ IOException -> 0x00cc }
            goto L_0x00cf
        L_0x00cc:
            r0 = move-exception
            r12 = r14
            goto L_0x0101
        L_0x00cf:
            r10 = 200(0xc8, float:2.8E-43)
            if (r11 < r10) goto L_0x00eb
            r10 = 299(0x12b, float:4.19E-43)
            if (r11 > r10) goto L_0x00eb
            com.mbridge.msdk.e.a.k r17 = new com.mbridge.msdk.e.a.k     // Catch:{ IOException -> 0x00f5 }
            r13 = 0
            long r15 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00f5 }
            long r15 = r15 - r3
            r10 = r17
            r12 = r14
            r18 = r14
            r14 = r15
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r16)     // Catch:{ IOException -> 0x00f3 }
            return r17
        L_0x00eb:
            r18 = r14
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x00f3 }
            r0.<init>()     // Catch:{ IOException -> 0x00f3 }
            throw r0     // Catch:{ IOException -> 0x00f3 }
        L_0x00f3:
            r0 = move-exception
            goto L_0x00f8
        L_0x00f5:
            r0 = move-exception
            r18 = r14
        L_0x00f8:
            r12 = r18
            goto L_0x0101
        L_0x00fb:
            r0 = move-exception
            r12 = r8
            goto L_0x0101
        L_0x00fe:
            r0 = move-exception
            r9 = r8
            r12 = r9
        L_0x0101:
            boolean r10 = r0 instanceof java.net.SocketTimeoutException
            if (r10 == 0) goto L_0x0115
            com.mbridge.msdk.e.a.a.h$a r0 = new com.mbridge.msdk.e.a.a.h$a
            com.mbridge.msdk.e.a.t r9 = new com.mbridge.msdk.e.a.t
            r9.<init>()
            java.lang.String r10 = "socket"
            r0.<init>(r10, r9)
        L_0x0112:
            r8 = r0
            goto L_0x0197
        L_0x0115:
            boolean r10 = r0 instanceof java.net.MalformedURLException
            if (r10 != 0) goto L_0x01d6
            if (r9 == 0) goto L_0x0183
            int r0 = r9.a()
            java.lang.Object[] r10 = new java.lang.Object[r6]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r0)
            r10[r7] = r11
            java.lang.String r11 = r20.h()
            r10[r5] = r11
            java.lang.String r11 = "Unexpected response code %d for %s"
            com.mbridge.msdk.e.a.v.c(r11, r10)
            if (r12 == 0) goto L_0x0176
            java.util.List r16 = r9.b()
            com.mbridge.msdk.e.a.k r9 = new com.mbridge.msdk.e.a.k
            r13 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
            long r14 = r10 - r3
            r10 = r9
            r11 = r0
            r10.<init>(r11, r12, r13, r14, r16)
            r10 = 400(0x190, float:5.6E-43)
            if (r0 < r10) goto L_0x0155
            r10 = 499(0x1f3, float:6.99E-43)
            if (r0 <= r10) goto L_0x014f
            goto L_0x0155
        L_0x014f:
            com.mbridge.msdk.e.a.d r0 = new com.mbridge.msdk.e.a.d
            r0.<init>(r9)
            throw r0
        L_0x0155:
            r10 = 500(0x1f4, float:7.0E-43)
            if (r0 < r10) goto L_0x0170
            r10 = 599(0x257, float:8.4E-43)
            if (r0 > r10) goto L_0x0170
            boolean r0 = r20.p()
            if (r0 == 0) goto L_0x0170
            com.mbridge.msdk.e.a.a.h$a r0 = new com.mbridge.msdk.e.a.a.h$a
            com.mbridge.msdk.e.a.s r10 = new com.mbridge.msdk.e.a.s
            r10.<init>(r9)
            java.lang.String r9 = "server"
            r0.<init>(r9, r10)
            goto L_0x0112
        L_0x0170:
            com.mbridge.msdk.e.a.s r0 = new com.mbridge.msdk.e.a.s
            r0.<init>(r9)
            throw r0
        L_0x0176:
            com.mbridge.msdk.e.a.a.h$a r0 = new com.mbridge.msdk.e.a.a.h$a
            com.mbridge.msdk.e.a.j r9 = new com.mbridge.msdk.e.a.j
            r9.<init>()
            java.lang.String r10 = "network"
            r0.<init>(r10, r9)
            goto L_0x0112
        L_0x0183:
            boolean r9 = r20.q()
            if (r9 == 0) goto L_0x01d0
            com.mbridge.msdk.e.a.a.h$a r0 = new com.mbridge.msdk.e.a.a.h$a
            com.mbridge.msdk.e.a.l r9 = new com.mbridge.msdk.e.a.l
            r9.<init>()
            java.lang.String r10 = "connection"
            r0.<init>(r10, r9)
            goto L_0x0112
        L_0x0197:
            com.mbridge.msdk.e.a.r r0 = r20.a()
            int r9 = r20.r()
            com.mbridge.msdk.e.a.u r10 = r8.b     // Catch:{ u -> 0x01bb }
            r0.a(r10)     // Catch:{ u -> 0x01bb }
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.String r6 = r8.a
            r0[r7] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r9)
            r0[r5] = r6
            java.lang.String r5 = "%s-retry [timeout=%s]"
            java.lang.String.format(r5, r0)
            goto L_0x0008
        L_0x01bb:
            r0 = move-exception
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.String r3 = r8.a
            r2[r7] = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r9)
            r2[r5] = r3
            java.lang.String r3 = "%s-timeout-giveup [timeout=%s]"
            java.lang.String.format(r3, r2)
            throw r0
        L_0x01d0:
            com.mbridge.msdk.e.a.l r2 = new com.mbridge.msdk.e.a.l
            r2.<init>(r0)
            throw r2
        L_0x01d6:
            java.lang.RuntimeException r3 = new java.lang.RuntimeException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Bad URL "
            r4.<init>(r5)
            java.lang.String r2 = r20.h()
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2, r0)
            goto L_0x01ef
        L_0x01ee:
            throw r3
        L_0x01ef:
            goto L_0x01ee
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.e.a.a.b.a(com.mbridge.msdk.e.a.m):com.mbridge.msdk.e.a.k");
    }
}
