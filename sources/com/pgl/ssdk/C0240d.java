package com.pgl.ssdk;

import android.content.Context;
import java.lang.reflect.Method;

/* renamed from: com.pgl.ssdk.d  reason: case insensitive filesystem */
public class C0240d {
    private static double a = -1.0d;

    public static String a(Context context) {
        int i;
        double d = a;
        double d2 = 0.0d;
        if (d >= 0.0d) {
            i = (int) d;
        } else {
            try {
                Class<?> cls = Class.forName("com.android.internal.os.PowerProfile");
                Object newInstance = cls.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
                Method declaredMethod = cls.getDeclaredMethod("getAveragePower", new Class[]{String.class});
                declaredMethod.setAccessible(true);
                d2 = ((Double) declaredMethod.invoke(newInstance, new Object[]{"battery.capacity"})).doubleValue();
            } catch (Throwable unused) {
            }
            a = d2;
            i = (int) d2;
        }
        return Integer.toString(i);
    }
}
