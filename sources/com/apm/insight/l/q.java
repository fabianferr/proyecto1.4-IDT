package com.apm.insight.l;

import android.util.Log;
import com.apm.insight.i;

public final class q {
    public static void a(Object obj) {
        if (i.i().isDebugMode()) {
            Log.i("npth", String.valueOf(obj));
        }
    }

    public static void a(String str) {
        if (i.i().isDebugMode()) {
            Log.w("npth", str);
        }
    }

    public static void a(String str, Object obj) {
        if (i.i().isDebugMode()) {
            Log.i("npth", str + " " + obj);
        }
    }

    public static void a(String str, Object obj, Throwable th) {
        if (i.i().isDebugMode()) {
            Log.e("npth", str + " " + obj, th);
        }
    }

    public static void a(String str, Throwable th) {
        if (i.i().isDebugMode()) {
            Log.e("npth", str + " NPTH Catch Error", th);
        }
    }

    public static void a(Throwable th) {
        if (i.i().isDebugMode()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    public static void b(Object obj) {
        if (i.i().isDebugMode()) {
            Log.d("npth", String.valueOf(obj));
        }
    }

    public static void b(Throwable th) {
        if (i.i().isDebugMode()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }
}
