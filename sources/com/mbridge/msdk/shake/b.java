package com.mbridge.msdk.shake;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

/* compiled from: ShakeSensorEventListener */
public abstract class b implements SensorEventListener {
    private int a;
    private int b;
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = 0.0f;
    public long g = 0;

    public abstract void a();

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public b(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        if (java.lang.Math.abs(r10 - r2) > ((float) r9.a)) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSensorChanged(android.hardware.SensorEvent r10) {
        /*
            r9 = this;
            float[] r10 = r10.values
            r0 = 0
            r0 = r10[r0]
            float r0 = -r0
            r1 = 1
            r1 = r10[r1]
            float r1 = -r1
            r2 = 2
            r10 = r10[r2]
            float r10 = -r10
            float r2 = r9.d
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r4 = r9.a
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0048
        L_0x0022:
            float r2 = r9.e
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x0035
            float r2 = r1 - r2
            float r2 = java.lang.Math.abs(r2)
            int r4 = r9.a
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0048
        L_0x0035:
            float r2 = r9.f
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x005c
            float r2 = r10 - r2
            float r2 = java.lang.Math.abs(r2)
            int r3 = r9.a
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x005c
        L_0x0048:
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r9.g
            long r4 = r2 - r4
            int r6 = r9.b
            long r6 = (long) r6
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x005c
            r9.g = r2
            r9.a()
        L_0x005c:
            r9.d = r0
            r9.e = r1
            r9.f = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.shake.b.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
