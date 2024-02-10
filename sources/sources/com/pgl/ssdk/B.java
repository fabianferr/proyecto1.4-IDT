package com.pgl.ssdk;

import android.content.Context;

public class B implements Runnable {
    private final D a;
    private final Context b;
    private A c;

    B(Context context, D d) {
        this.a = d;
        this.b = context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        com.pgl.ssdk.y.a = 501;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x008a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            java.lang.String r0 = "&platform=android&ver=1.0.0.1-rc.6&mode=1"
            java.lang.String r1 = "/ssdk/sd/token?os=android&app_id="
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String.valueOf(r2)
            int r2 = com.pgl.ssdk.j.a
            r3 = 1
            if (r2 == 0) goto L_0x0018
            if (r2 == r3) goto L_0x0015
            java.lang.String r2 = ""
            goto L_0x001a
        L_0x0015:
            java.lang.String r2 = "https://ssdk-va.pangle.io"
            goto L_0x001a
        L_0x0018:
            java.lang.String r2 = "https://ssdk-sg.pangle.io"
        L_0x001a:
            r4 = 501(0x1f5, float:7.02E-43)
            android.content.Context r5 = r8.b     // Catch:{ all -> 0x008a }
            r6 = 0
            r7 = 301(0x12d, float:4.22E-43)
            java.lang.Object r5 = com.pgl.ssdk.ces.a.meta(r7, r5, r6)     // Catch:{ all -> 0x008a }
            byte[] r5 = (byte[]) r5     // Catch:{ all -> 0x008a }
            if (r5 == 0) goto L_0x0087
            int r6 = r5.length     // Catch:{ all -> 0x008a }
            if (r6 > 0) goto L_0x002d
            goto L_0x0087
        L_0x002d:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x008a }
            r6.<init>()     // Catch:{ all -> 0x008a }
            r6.append(r2)     // Catch:{ all -> 0x008a }
            r6.append(r1)     // Catch:{ all -> 0x008a }
            java.lang.String r1 = com.pgl.ssdk.y.b     // Catch:{ all -> 0x008a }
            r6.append(r1)     // Catch:{ all -> 0x008a }
            java.lang.String r1 = "&did="
            r6.append(r1)     // Catch:{ all -> 0x008a }
            java.lang.String r1 = com.pgl.ssdk.ces.d.b()     // Catch:{ all -> 0x008a }
            r6.append(r1)     // Catch:{ all -> 0x008a }
            java.lang.String r1 = "&app_ver="
            r6.append(r1)     // Catch:{ all -> 0x008a }
            android.content.Context r1 = r8.b     // Catch:{ all -> 0x008a }
            int r1 = com.pgl.ssdk.C0237a.a((android.content.Context) r1)     // Catch:{ all -> 0x008a }
            r6.append(r1)     // Catch:{ all -> 0x008a }
            r6.append(r0)     // Catch:{ all -> 0x008a }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x008a }
            com.pgl.ssdk.A r1 = new com.pgl.ssdk.A     // Catch:{ all -> 0x008a }
            java.lang.String r2 = "request"
            android.content.Context r6 = r8.b     // Catch:{ all -> 0x008a }
            r1.<init>(r2, r6, r0, r5)     // Catch:{ all -> 0x008a }
            r8.c = r1     // Catch:{ all -> 0x008a }
            r1.start()     // Catch:{ all -> 0x008a }
            com.pgl.ssdk.A r0 = r8.c     // Catch:{ all -> 0x008a }
            android.os.Handler r1 = new android.os.Handler     // Catch:{ all -> 0x008a }
            com.pgl.ssdk.A r2 = r8.c     // Catch:{ all -> 0x008a }
            android.os.Looper r2 = r2.getLooper()     // Catch:{ all -> 0x008a }
            com.pgl.ssdk.A r5 = r8.c     // Catch:{ all -> 0x008a }
            android.os.Handler$Callback r5 = r5.h     // Catch:{ all -> 0x008a }
            r1.<init>(r2, r5)     // Catch:{ all -> 0x008a }
            r0.g = r1     // Catch:{ all -> 0x008a }
            com.pgl.ssdk.A r0 = r8.c     // Catch:{ all -> 0x008a }
            android.os.Handler r0 = r0.g     // Catch:{ all -> 0x008a }
            r0.sendEmptyMessage(r3)     // Catch:{ all -> 0x008a }
            goto L_0x008c
        L_0x0087:
            com.pgl.ssdk.y.a = r4     // Catch:{ all -> 0x008a }
            return
        L_0x008a:
            com.pgl.ssdk.y.a = r4     // Catch:{ all -> 0x0098 }
        L_0x008c:
            com.pgl.ssdk.D r0 = r8.a
            if (r0 == 0) goto L_0x0097
            java.lang.String r1 = com.pgl.ssdk.y.a()
            r0.a(r1)
        L_0x0097:
            return
        L_0x0098:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.B.run():void");
    }
}
