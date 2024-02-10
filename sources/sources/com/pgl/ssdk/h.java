package com.pgl.ssdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.List;

public final class h implements SensorEventListener {
    private static h f;
    private SensorManager a = null;
    private int b;
    private int c = 0;
    private float[] d = new float[3];
    private List e = new ArrayList();

    private h(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.a = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable unused) {
            }
        }
    }

    public static h a(Context context) {
        if (f == null) {
            synchronized (h.class) {
                if (f == null) {
                    f = new h(context);
                }
            }
        }
        return f;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void c() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.hardware.SensorManager r0 = r2.a     // Catch:{ Exception -> 0x0014, all -> 0x0011 }
            if (r0 == 0) goto L_0x0014
            int r1 = r2.b     // Catch:{ Exception -> 0x0014, all -> 0x0011 }
            int r1 = r1 + -1
            r2.b = r1     // Catch:{ Exception -> 0x0014, all -> 0x0011 }
            if (r1 != 0) goto L_0x0014
            r0.unregisterListener(r2)     // Catch:{ Exception -> 0x0014, all -> 0x0011 }
            goto L_0x0014
        L_0x0011:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0014:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.h.c():void");
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0075 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a() {
        /*
            r7 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            monitor-enter(r7)     // Catch:{ all -> 0x0075 }
            android.hardware.SensorManager r3 = r7.a     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            if (r3 == 0) goto L_0x0023
            int r4 = r7.b     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            if (r4 != 0) goto L_0x001a
            android.hardware.Sensor r3 = r3.getDefaultSensor(r2)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            android.hardware.SensorManager r4 = r7.a     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            r5 = 3
            boolean r3 = r4.registerListener(r7, r3, r5)     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            if (r3 != 0) goto L_0x001a
            goto L_0x0023
        L_0x001a:
            int r3 = r7.b     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            int r3 = r3 + r2
            r7.b = r3     // Catch:{ Exception -> 0x0023, all -> 0x0020 }
            goto L_0x0023
        L_0x0020:
            r3 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0075 }
            throw r3     // Catch:{ all -> 0x0075 }
        L_0x0023:
            monitor-exit(r7)     // Catch:{ all -> 0x0075 }
            monitor-enter(r7)     // Catch:{ all -> 0x0075 }
            r3 = 0
        L_0x0026:
            int r4 = r7.c     // Catch:{ all -> 0x0072 }
            if (r4 != 0) goto L_0x0036
            r4 = 10
            if (r3 >= r4) goto L_0x0036
            int r3 = r3 + 1
            r4 = 100
            r7.wait(r4)     // Catch:{ all -> 0x0072 }
            goto L_0x0026
        L_0x0036:
            monitor-exit(r7)     // Catch:{ all -> 0x0072 }
            java.text.DecimalFormat r3 = new java.text.DecimalFormat     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = "0.0"
            r3.<init>(r4)     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r4.<init>()     // Catch:{ all -> 0x00ae }
            float[] r5 = r7.d     // Catch:{ all -> 0x00ae }
            r5 = r5[r1]     // Catch:{ all -> 0x00ae }
            double r5 = (double) r5     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = r3.format(r5)     // Catch:{ all -> 0x00ae }
            r4.append(r5)     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = ","
            r4.append(r5)     // Catch:{ all -> 0x00ae }
            float[] r5 = r7.d     // Catch:{ all -> 0x00ae }
            r2 = r5[r2]     // Catch:{ all -> 0x00ae }
            double r5 = (double) r2     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = r3.format(r5)     // Catch:{ all -> 0x00ae }
            r4.append(r2)     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = ","
            r4.append(r2)     // Catch:{ all -> 0x00ae }
            float[] r2 = r7.d     // Catch:{ all -> 0x00ae }
            r0 = r2[r0]     // Catch:{ all -> 0x00ae }
            double r5 = (double) r0     // Catch:{ all -> 0x00ae }
        L_0x006a:
            java.lang.String r0 = r3.format(r5)     // Catch:{ all -> 0x00ae }
            r4.append(r0)     // Catch:{ all -> 0x00ae }
            goto L_0x00a9
        L_0x0072:
            r3 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0072 }
            throw r3     // Catch:{ all -> 0x0075 }
        L_0x0075:
            java.text.DecimalFormat r3 = new java.text.DecimalFormat     // Catch:{ all -> 0x00ae }
            java.lang.String r4 = "0.0"
            r3.<init>(r4)     // Catch:{ all -> 0x00ae }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ae }
            r4.<init>()     // Catch:{ all -> 0x00ae }
            float[] r5 = r7.d     // Catch:{ all -> 0x00ae }
            r5 = r5[r1]     // Catch:{ all -> 0x00ae }
            double r5 = (double) r5     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = r3.format(r5)     // Catch:{ all -> 0x00ae }
            r4.append(r5)     // Catch:{ all -> 0x00ae }
            java.lang.String r5 = ","
            r4.append(r5)     // Catch:{ all -> 0x00ae }
            float[] r5 = r7.d     // Catch:{ all -> 0x00ae }
            r2 = r5[r2]     // Catch:{ all -> 0x00ae }
            double r5 = (double) r2     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = r3.format(r5)     // Catch:{ all -> 0x00ae }
            r4.append(r2)     // Catch:{ all -> 0x00ae }
            java.lang.String r2 = ","
            r4.append(r2)     // Catch:{ all -> 0x00ae }
            float[] r2 = r7.d     // Catch:{ all -> 0x00ae }
            r0 = r2[r0]     // Catch:{ all -> 0x00ae }
            double r5 = (double) r0     // Catch:{ all -> 0x00ae }
            goto L_0x006a
        L_0x00a9:
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x00ae }
            goto L_0x00af
        L_0x00ae:
            r0 = 0
        L_0x00af:
            r7.c()
            r7.c = r1
            if (r0 != 0) goto L_0x00b7
            return
        L_0x00b7:
            java.util.List r1 = r7.e
            r1.add(r0)
            java.util.List r0 = r7.e     // Catch:{ all -> 0x00da }
            int r0 = r0.size()     // Catch:{ all -> 0x00da }
            r1 = 20
            if (r0 <= r1) goto L_0x00da
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x00da }
            java.util.List r2 = r7.e     // Catch:{ all -> 0x00da }
            int r3 = r0 + -10
            java.util.List r0 = r2.subList(r3, r0)     // Catch:{ all -> 0x00da }
            r1.<init>(r0)     // Catch:{ all -> 0x00da }
            java.util.List r0 = r7.e     // Catch:{ all -> 0x00da }
            r0.clear()     // Catch:{ all -> 0x00da }
            r7.e = r1     // Catch:{ all -> 0x00da }
        L_0x00da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pgl.ssdk.h.a():void");
    }

    public synchronized String b() {
        String str;
        str = "";
        int size = this.e.size();
        if (size <= 0) {
            return str;
        }
        if (size == 1) {
            return (String) this.e.get(0);
        }
        try {
            List list = this.e;
            int i = size - 10;
            if (i <= 0) {
                i = 0;
            }
            List subList = list.subList(i, size);
            for (int i2 = 0; i2 < subList.size(); i2++) {
                str = str + ((String) subList.get(i2)) + "|";
            }
            str = str.substring(0, str.length() - 1);
        } catch (Throwable unused) {
        }
        return str;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        this.d = sensorEvent.values;
        this.c = 1;
    }
}
