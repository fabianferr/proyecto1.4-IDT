package com.bytedance.sdk.openadsdk.core.b;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.b.c;
import com.bytedance.sdk.openadsdk.core.o;

/* compiled from: TouchInfoHelper */
public class f {
    public static int j = o.b();
    private static float m = 0.0f;
    private static float n = 0.0f;
    private static float o = 0.0f;
    private static float p = 0.0f;
    private static long q = 0;
    public float a = -1.0f;
    public float b = -1.0f;
    public float c = -1.0f;
    public float d = -1.0f;
    public long e = -1;
    public long f = -1;
    public int g = -1;
    public int h = -1024;
    public int i = -1;
    public boolean k = true;
    public SparseArray<c.a> l = new SparseArray<>();
    private int r = 0;
    private int s = 0;

    static {
        if (o.a() != null) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0071, code lost:
        if (p <= ((float) r3)) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.MotionEvent r14) {
        /*
            r13 = this;
            int r0 = r14.getDeviceId()
            r13.h = r0
            r0 = 0
            int r1 = r14.getToolType(r0)
            r13.g = r1
            int r1 = r14.getSource()
            r13.i = r1
            int r1 = r14.getActionMasked()
            r2 = 1
            if (r1 == 0) goto L_0x00df
            r3 = 3
            if (r1 == r2) goto L_0x00a7
            r4 = 2
            if (r1 == r4) goto L_0x002a
            if (r1 == r3) goto L_0x0026
            r0 = -1
            r6 = -1
            goto L_0x011a
        L_0x0026:
            r0 = 4
            r6 = 4
            goto L_0x011a
        L_0x002a:
            float r1 = o
            float r3 = r14.getX()
            float r5 = m
            float r3 = r3 - r5
            float r3 = java.lang.Math.abs(r3)
            float r1 = r1 + r3
            o = r1
            float r1 = p
            float r3 = r14.getY()
            float r5 = n
            float r3 = r3 - r5
            float r3 = java.lang.Math.abs(r3)
            float r1 = r1 + r3
            p = r1
            float r1 = r14.getX()
            m = r1
            float r1 = r14.getY()
            n = r1
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = q
            long r5 = r5 - r7
            r7 = 200(0xc8, double:9.9E-322)
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0074
            float r1 = o
            int r3 = j
            float r5 = (float) r3
            int r1 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r1 > 0) goto L_0x0075
            float r1 = p
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r2 = 2
        L_0x0075:
            float r1 = r14.getRawX()
            r13.c = r1
            float r1 = r14.getRawY()
            r13.d = r1
            float r1 = r13.c
            int r3 = r13.r
            float r3 = (float) r3
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            int r3 = j
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x00a3
            float r1 = r13.d
            int r3 = r13.s
            float r3 = (float) r3
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            int r3 = j
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x00a5
        L_0x00a3:
            r13.k = r0
        L_0x00a5:
            r6 = r2
            goto L_0x011a
        L_0x00a7:
            float r1 = r14.getRawX()
            r13.c = r1
            float r1 = r14.getRawY()
            r13.d = r1
            long r1 = java.lang.System.currentTimeMillis()
            r13.f = r1
            float r1 = r13.c
            int r2 = r13.r
            float r2 = (float) r2
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            int r2 = j
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x00db
            float r1 = r13.d
            int r2 = r13.s
            float r2 = (float) r2
            float r1 = r1 - r2
            float r1 = java.lang.Math.abs(r1)
            int r2 = j
            float r2 = (float) r2
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x00dd
        L_0x00db:
            r13.k = r0
        L_0x00dd:
            r6 = 3
            goto L_0x011a
        L_0x00df:
            float r1 = r14.getRawX()
            int r1 = (int) r1
            r13.r = r1
            float r1 = r14.getRawY()
            int r1 = (int) r1
            r13.s = r1
            float r1 = r14.getRawX()
            r13.a = r1
            float r1 = r14.getRawY()
            r13.b = r1
            long r3 = java.lang.System.currentTimeMillis()
            r13.e = r3
            int r1 = r14.getToolType(r0)
            r13.g = r1
            int r1 = r14.getDeviceId()
            r13.h = r1
            int r1 = r14.getSource()
            r13.i = r1
            long r3 = java.lang.System.currentTimeMillis()
            q = r3
            r13.k = r2
            r6 = 0
        L_0x011a:
            android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c$a> r0 = r13.l
            int r1 = r14.getActionMasked()
            com.bytedance.sdk.openadsdk.core.b.c$a r2 = new com.bytedance.sdk.openadsdk.core.b.c$a
            float r3 = r14.getSize()
            double r7 = (double) r3
            float r14 = r14.getPressure()
            double r9 = (double) r14
            long r11 = java.lang.System.currentTimeMillis()
            r5 = r2
            r5.<init>(r6, r7, r9, r11)
            r0.put(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.b.f.a(android.view.MotionEvent):void");
    }
}
