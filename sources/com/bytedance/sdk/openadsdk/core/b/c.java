package com.bytedance.sdk.openadsdk.core.b;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.k;

/* compiled from: InteractionListener */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    protected static int C = o.b();
    private static float a = 0.0f;
    private static float b = 0.0f;
    private static float c = 0.0f;
    private static float d = 0.0f;
    private static long e = 0;
    protected int A = -1024;
    protected int B = -1;
    protected boolean D = true;
    protected View E;
    public SparseArray<a> F = new SparseArray<>();
    private int f = 0;
    private int g = 0;
    protected float t = -1.0f;
    protected float u = -1.0f;
    protected float v = -1.0f;
    protected float w = -1.0f;
    protected long x = -1;
    protected long y = -1;
    protected int z = -1;

    /* access modifiers changed from: protected */
    public abstract void a(View view, float f2, float f3, float f4, float f5, SparseArray<a> sparseArray, boolean z2);

    static {
        if (o.a() != null) {
        }
    }

    public void onClick(View view) {
        if (k.a()) {
            a(view, this.t, this.u, this.v, this.w, this.F, this.D);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0071, code lost:
        if (d <= ((float) r3)) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouch(android.view.View r14, android.view.MotionEvent r15) {
        /*
            r13 = this;
            int r0 = r15.getDeviceId()
            r13.A = r0
            r0 = 0
            int r1 = r15.getToolType(r0)
            r13.z = r1
            int r1 = r15.getSource()
            r13.B = r1
            int r1 = r15.getActionMasked()
            r2 = 1
            if (r1 == 0) goto L_0x0103
            r3 = 3
            if (r1 == r2) goto L_0x00a8
            r14 = 2
            if (r1 == r14) goto L_0x002a
            if (r1 == r3) goto L_0x0026
            r3 = -1
            r6 = -1
            goto L_0x0140
        L_0x0026:
            r3 = 4
            r6 = 4
            goto L_0x0140
        L_0x002a:
            float r1 = c
            float r3 = r15.getX()
            float r4 = a
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            float r1 = r1 + r3
            c = r1
            float r1 = d
            float r3 = r15.getY()
            float r4 = b
            float r3 = r3 - r4
            float r3 = java.lang.Math.abs(r3)
            float r1 = r1 + r3
            d = r1
            float r1 = r15.getX()
            a = r1
            float r1 = r15.getY()
            b = r1
            long r3 = java.lang.System.currentTimeMillis()
            long r5 = e
            long r3 = r3 - r5
            r5 = 200(0xc8, double:9.9E-322)
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x0074
            float r1 = c
            int r3 = C
            float r4 = (float) r3
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x0075
            float r1 = d
            float r3 = (float) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r2 = 2
        L_0x0075:
            float r14 = r15.getRawX()
            r13.v = r14
            float r14 = r15.getRawY()
            r13.w = r14
            float r14 = r13.v
            int r1 = r13.f
            float r1 = (float) r1
            float r14 = r14 - r1
            float r14 = java.lang.Math.abs(r14)
            int r1 = C
            float r1 = (float) r1
            int r14 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r14 >= 0) goto L_0x00a3
            float r14 = r13.w
            int r1 = r13.g
            float r1 = (float) r1
            float r14 = r14 - r1
            float r14 = java.lang.Math.abs(r14)
            int r1 = C
            float r1 = (float) r1
            int r14 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r14 < 0) goto L_0x00a5
        L_0x00a3:
            r13.D = r0
        L_0x00a5:
            r6 = r2
            goto L_0x0140
        L_0x00a8:
            float r1 = r15.getRawX()
            r13.v = r1
            float r1 = r15.getRawY()
            r13.w = r1
            long r4 = java.lang.System.currentTimeMillis()
            r13.y = r4
            float r1 = r13.v
            int r4 = r13.f
            float r4 = (float) r4
            float r1 = r1 - r4
            float r1 = java.lang.Math.abs(r1)
            int r4 = C
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x00dc
            float r1 = r13.w
            int r4 = r13.g
            float r4 = (float) r4
            float r1 = r1 - r4
            float r1 = java.lang.Math.abs(r1)
            int r4 = C
            float r4 = (float) r4
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 < 0) goto L_0x00de
        L_0x00dc:
            r13.D = r0
        L_0x00de:
            android.graphics.Point r1 = new android.graphics.Point
            float r4 = r13.v
            int r4 = (int) r4
            float r5 = r13.w
            int r5 = (int) r5
            r1.<init>(r4, r5)
            if (r14 == 0) goto L_0x0101
            boolean r4 = com.bytedance.sdk.openadsdk.core.b.b.c((android.view.View) r14)
            if (r4 != 0) goto L_0x0101
            android.view.ViewParent r14 = r14.getParent()
            android.view.View r14 = (android.view.View) r14
            r4 = r14
            android.view.View r4 = (android.view.View) r4
            boolean r14 = r13.a(r14, r1)
            if (r14 == 0) goto L_0x0101
            return r2
        L_0x0101:
            r6 = 3
            goto L_0x0140
        L_0x0103:
            float r1 = r15.getRawX()
            int r1 = (int) r1
            r13.f = r1
            float r1 = r15.getRawY()
            int r1 = (int) r1
            r13.g = r1
            float r1 = r15.getRawX()
            r13.t = r1
            float r1 = r15.getRawY()
            r13.u = r1
            long r3 = java.lang.System.currentTimeMillis()
            r13.x = r3
            int r1 = r15.getToolType(r0)
            r13.z = r1
            int r1 = r15.getDeviceId()
            r13.A = r1
            int r1 = r15.getSource()
            r13.B = r1
            long r3 = java.lang.System.currentTimeMillis()
            e = r3
            r13.D = r2
            r13.E = r14
            r6 = 0
        L_0x0140:
            android.util.SparseArray<com.bytedance.sdk.openadsdk.core.b.c$a> r14 = r13.F
            int r1 = r15.getActionMasked()
            com.bytedance.sdk.openadsdk.core.b.c$a r2 = new com.bytedance.sdk.openadsdk.core.b.c$a
            float r3 = r15.getSize()
            double r7 = (double) r3
            float r15 = r15.getPressure()
            double r9 = (double) r15
            long r11 = java.lang.System.currentTimeMillis()
            r5 = r2
            r5.<init>(r6, r7, r9, r11)
            r14.put(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.b.c.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private boolean a(View view, Point point) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            while (i < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i);
                if (b.c(childAt)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    if (!view.isShown() || point.x < iArr[0] || point.x > iArr[0] + childAt.getWidth() || point.y < iArr[1] || point.y > iArr[1] + childAt.getHeight()) {
                        return false;
                    }
                    return true;
                } else if (a(childAt, point)) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    /* compiled from: InteractionListener */
    public static class a {
        public int a;
        public double b;
        public double c;
        public long d;

        public a(int i, double d2, double d3, long j) {
            this.a = i;
            this.b = d2;
            this.c = d3;
            this.d = j;
        }
    }

    public boolean g() {
        return this.D;
    }
}
