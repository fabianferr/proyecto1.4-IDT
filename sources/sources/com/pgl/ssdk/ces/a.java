package com.pgl.ssdk.ces;

import android.content.Context;

public final class a {
    public static native Object meta(int i, Context context, Object obj);

    public static Object njss(int i, Object obj) {
        try {
            d c = d.c();
            if (c != null) {
                return c.a(i, obj);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
