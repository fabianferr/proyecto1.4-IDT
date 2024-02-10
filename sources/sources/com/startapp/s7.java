package com.startapp;

/* compiled from: Sta */
public class s7 {
    public final d8 a = new d8();

    /* JADX WARNING: Removed duplicated region for block: B:34:0x0077 A[SYNTHETIC, Splitter:B:34:0x0077] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(com.startapp.simple.bloomfilter.algo.OpenBitSet r12) {
        /*
            r11 = this;
            int r0 = r12.a()
            int r1 = r12.b()
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x006b }
            r3.<init>()     // Catch:{ Exception -> 0x006b }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r4 = 0
            r5 = 0
        L_0x0015:
            if (r5 >= r1) goto L_0x0031
            long[] r6 = r12.a((int) r5)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r7 = 0
        L_0x001c:
            r8 = 4096(0x1000, float:5.74E-42)
            if (r7 >= r8) goto L_0x002e
            int r8 = r0 + -1
            if (r0 <= 0) goto L_0x002d
            r9 = r6[r7]     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r2.writeLong(r9)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            int r7 = r7 + 1
            r0 = r8
            goto L_0x001c
        L_0x002d:
            r0 = r8
        L_0x002e:
            int r5 = r5 + 1
            goto L_0x0015
        L_0x0031:
            r3.close()     // Catch:{ IOException -> 0x0034 }
        L_0x0034:
            com.startapp.d8 r12 = r11.a
            byte[] r0 = r3.toByteArray()
            r12.getClass()
            int r12 = r0.length
            int r12 = r12 * 2
            char[] r12 = new char[r12]
        L_0x0042:
            int r1 = r0.length
            if (r4 >= r1) goto L_0x005e
            int r1 = r4 * 2
            char[] r2 = com.startapp.d8.a
            byte r3 = r0[r4]
            r5 = r3 & 240(0xf0, float:3.36E-43)
            int r5 = r5 >>> 4
            char r5 = r2[r5]
            r12[r1] = r5
            int r1 = r1 + 1
            r3 = r3 & 15
            char r2 = r2[r3]
            r12[r1] = r2
            int r4 = r4 + 1
            goto L_0x0042
        L_0x005e:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r12)
            return r0
        L_0x0064:
            r12 = move-exception
            goto L_0x0075
        L_0x0066:
            r12 = move-exception
            r2 = r3
            goto L_0x006c
        L_0x0069:
            r12 = move-exception
            goto L_0x0074
        L_0x006b:
            r12 = move-exception
        L_0x006c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ all -> 0x0069 }
            java.lang.String r1 = "problem serializing bitSet"
            r0.<init>(r1, r12)     // Catch:{ all -> 0x0069 }
            throw r0     // Catch:{ all -> 0x0069 }
        L_0x0074:
            r3 = r2
        L_0x0075:
            if (r3 == 0) goto L_0x007a
            r3.close()     // Catch:{ IOException -> 0x007a }
        L_0x007a:
            goto L_0x007c
        L_0x007b:
            throw r12
        L_0x007c:
            goto L_0x007b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.s7.a(com.startapp.simple.bloomfilter.algo.OpenBitSet):java.lang.String");
    }
}
