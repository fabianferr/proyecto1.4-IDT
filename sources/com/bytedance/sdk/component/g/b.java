package com.bytedance.sdk.component.g;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.l;

/* compiled from: DelegateRunnable */
class b implements Comparable, Runnable {
    private h a;
    private a b;
    private long c = 0;
    private Thread d = null;

    public b(h hVar, a aVar) {
        this.a = hVar;
        this.b = aVar;
        this.c = SystemClock.uptimeMillis();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b3, code lost:
        if (r0.equals("ad") == false) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r11 = this;
            long r0 = android.os.SystemClock.uptimeMillis()
            long r2 = r11.c
            long r2 = r0 - r2
            java.lang.Thread r4 = java.lang.Thread.currentThread()
            r11.d = r4
            com.bytedance.sdk.component.g.h r4 = r11.a
            if (r4 == 0) goto L_0x0015
            r4.run()
        L_0x0015:
            long r4 = android.os.SystemClock.uptimeMillis()
            long r4 = r4 - r0
            com.bytedance.sdk.component.g.a r0 = r11.b
            if (r0 == 0) goto L_0x0021
            com.bytedance.sdk.component.g.d.a()
        L_0x0021:
            boolean r0 = com.bytedance.sdk.component.utils.l.a()
            if (r0 == 0) goto L_0x012a
            r0 = 8
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "run: pool  = "
            r6 = 0
            r0[r6] = r1
            com.bytedance.sdk.component.g.a r1 = r11.b
            java.lang.String r7 = "null"
            if (r1 == 0) goto L_0x003b
            java.lang.String r1 = r1.a()
            goto L_0x003c
        L_0x003b:
            r1 = r7
        L_0x003c:
            r8 = 1
            r0[r8] = r1
            java.lang.String r1 = " waitTime ="
            r9 = 2
            r0[r9] = r1
            java.lang.Long r1 = java.lang.Long.valueOf(r2)
            r2 = 3
            r0[r2] = r1
            java.lang.String r1 = " taskCost = "
            r3 = 4
            r0[r3] = r1
            r1 = 5
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            r0[r1] = r10
            r1 = 6
            java.lang.String r10 = " name="
            r0[r1] = r10
            com.bytedance.sdk.component.g.h r1 = r11.a
            if (r1 == 0) goto L_0x0065
            java.lang.String r1 = r1.getName()
            goto L_0x0066
        L_0x0065:
            r1 = r7
        L_0x0066:
            r10 = 7
            r0[r10] = r1
            java.lang.String r1 = "DelegateRunnable"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.Object[]) r0)
            com.bytedance.sdk.component.g.a r0 = r11.b
            java.lang.String r0 = r0.a()
            r0.hashCode()
            int r1 = r0.hashCode()
            r10 = -1
            switch(r1) {
                case 3107: goto L_0x00ad;
                case 3366: goto L_0x00a2;
                case 107332: goto L_0x0097;
                case 3237136: goto L_0x008c;
                case 212371911: goto L_0x0081;
                default: goto L_0x007f;
            }
        L_0x007f:
            r6 = -1
            goto L_0x00b6
        L_0x0081:
            java.lang.String r1 = "computation"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x008a
            goto L_0x007f
        L_0x008a:
            r6 = 4
            goto L_0x00b6
        L_0x008c:
            java.lang.String r1 = "init"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0095
            goto L_0x007f
        L_0x0095:
            r6 = 3
            goto L_0x00b6
        L_0x0097:
            java.lang.String r1 = "log"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00a0
            goto L_0x007f
        L_0x00a0:
            r6 = 2
            goto L_0x00b6
        L_0x00a2:
            java.lang.String r1 = "io"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ab
            goto L_0x007f
        L_0x00ab:
            r6 = 1
            goto L_0x00b6
        L_0x00ad:
            java.lang.String r1 = "ad"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b6
            goto L_0x007f
        L_0x00b6:
            switch(r6) {
                case 0: goto L_0x010f;
                case 1: goto L_0x00f3;
                case 2: goto L_0x00d7;
                case 3: goto L_0x010f;
                case 4: goto L_0x00bb;
                default: goto L_0x00b9;
            }
        L_0x00b9:
            goto L_0x012a
        L_0x00bb:
            r0 = 1000(0x3e8, double:4.94E-321)
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x012a
            com.bytedance.sdk.component.g.a r0 = r11.b
            if (r0 == 0) goto L_0x00ca
            java.lang.String r0 = r0.a()
            goto L_0x00cb
        L_0x00ca:
            r0 = r7
        L_0x00cb:
            com.bytedance.sdk.component.g.h r1 = r11.a
            if (r1 == 0) goto L_0x00d3
            java.lang.String r7 = r1.getName()
        L_0x00d3:
            r11.a(r0, r7, r4)
            goto L_0x012a
        L_0x00d7:
            r0 = 3000(0xbb8, double:1.482E-320)
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x012a
            com.bytedance.sdk.component.g.a r0 = r11.b
            if (r0 == 0) goto L_0x00e6
            java.lang.String r0 = r0.a()
            goto L_0x00e7
        L_0x00e6:
            r0 = r7
        L_0x00e7:
            com.bytedance.sdk.component.g.h r1 = r11.a
            if (r1 == 0) goto L_0x00ef
            java.lang.String r7 = r1.getName()
        L_0x00ef:
            r11.a(r0, r7, r4)
            goto L_0x012a
        L_0x00f3:
            r0 = 5000(0x1388, double:2.4703E-320)
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x012a
            com.bytedance.sdk.component.g.a r0 = r11.b
            if (r0 == 0) goto L_0x0102
            java.lang.String r0 = r0.a()
            goto L_0x0103
        L_0x0102:
            r0 = r7
        L_0x0103:
            com.bytedance.sdk.component.g.h r1 = r11.a
            if (r1 == 0) goto L_0x010b
            java.lang.String r7 = r1.getName()
        L_0x010b:
            r11.a(r0, r7, r4)
            goto L_0x012a
        L_0x010f:
            r0 = 2000(0x7d0, double:9.88E-321)
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x012a
            com.bytedance.sdk.component.g.a r0 = r11.b
            if (r0 == 0) goto L_0x011e
            java.lang.String r0 = r0.a()
            goto L_0x011f
        L_0x011e:
            r0 = r7
        L_0x011f:
            com.bytedance.sdk.component.g.h r1 = r11.a
            if (r1 == 0) goto L_0x0127
            java.lang.String r7 = r1.getName()
        L_0x0127:
            r11.a(r0, r7, r4)
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.g.b.run():void");
    }

    private void a(String str, String str2, long j) {
        l.e("DelegateRunnable", "pool is " + str + "  name is " + str2 + "is timeout,cost " + j);
    }

    public h a() {
        return this.a;
    }

    public int compareTo(Object obj) {
        if (obj instanceof b) {
            return this.a.compareTo(((b) obj).a());
        }
        return 0;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r2) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof com.bytedance.sdk.component.g.b
            if (r0 == 0) goto L_0x0016
            com.bytedance.sdk.component.g.h r0 = r1.a
            if (r0 == 0) goto L_0x0016
            com.bytedance.sdk.component.g.b r2 = (com.bytedance.sdk.component.g.b) r2
            com.bytedance.sdk.component.g.h r2 = r2.a()
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x0016
            r2 = 1
            goto L_0x0017
        L_0x0016:
            r2 = 0
        L_0x0017:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.g.b.equals(java.lang.Object):boolean");
    }
}
