package com.mbridge.msdk.e.a.a;

import com.mbridge.msdk.e.a.u;

/* compiled from: NetworkUtility */
final class h {
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0035 A[SYNTHETIC, Splitter:B:19:0x0035] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] a(java.io.InputStream r5, int r6, com.mbridge.msdk.e.a.a.c r7) throws java.io.IOException {
        /*
            java.lang.String r0 = "Error occurred when closing InputStream"
            com.mbridge.msdk.e.a.a.j r1 = new com.mbridge.msdk.e.a.a.j
            r1.<init>(r7, r6)
            r6 = 1024(0x400, float:1.435E-42)
            r2 = 0
            byte[] r6 = r7.a((int) r6)     // Catch:{ all -> 0x0031 }
        L_0x000e:
            int r3 = r5.read(r6)     // Catch:{ all -> 0x002f }
            r4 = -1
            if (r3 == r4) goto L_0x0019
            r1.write(r6, r2, r3)     // Catch:{ all -> 0x002f }
            goto L_0x000e
        L_0x0019:
            byte[] r3 = r1.toByteArray()     // Catch:{ all -> 0x002f }
            if (r5 == 0) goto L_0x0028
            r5.close()     // Catch:{ IOException -> 0x0023 }
            goto L_0x0028
        L_0x0023:
            java.lang.Object[] r5 = new java.lang.Object[r2]
            com.mbridge.msdk.e.a.v.a(r0, r5)
        L_0x0028:
            r7.a((byte[]) r6)
            r1.close()
            return r3
        L_0x002f:
            r3 = move-exception
            goto L_0x0033
        L_0x0031:
            r3 = move-exception
            r6 = 0
        L_0x0033:
            if (r5 == 0) goto L_0x003e
            r5.close()     // Catch:{ IOException -> 0x0039 }
            goto L_0x003e
        L_0x0039:
            java.lang.Object[] r5 = new java.lang.Object[r2]
            com.mbridge.msdk.e.a.v.a(r0, r5)
        L_0x003e:
            r7.a((byte[]) r6)
            r1.close()
            goto L_0x0046
        L_0x0045:
            throw r3
        L_0x0046:
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.e.a.a.h.a(java.io.InputStream, int, com.mbridge.msdk.e.a.a.c):byte[]");
    }

    /* compiled from: NetworkUtility */
    static class a {
        /* access modifiers changed from: private */
        public final String a;
        /* access modifiers changed from: private */
        public final u b;

        private a(String str, u uVar) {
            this.a = str;
            this.b = uVar;
        }
    }
}
