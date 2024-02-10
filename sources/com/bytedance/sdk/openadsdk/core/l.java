package com.bytedance.sdk.openadsdk.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.openadsdk.core.settings.o;
import com.bytedance.sdk.openadsdk.utils.aa;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: InitHelper */
public class l {
    public static volatile boolean a = false;
    public static AtomicBoolean b = new AtomicBoolean(false);
    public static long c = 0;
    public static float d = 1.0f;
    public static long e = System.currentTimeMillis();
    private static volatile int f = 0;
    private static volatile HandlerThread g = new HandlerThread("csj_init_handle", 10);
    private static volatile Handler h = null;

    static {
        g.start();
    }

    public static void a(long j) {
        e = j;
    }

    public static long a() {
        return e;
    }

    public static Handler b() {
        if (g == null || !g.isAlive()) {
            synchronized (l.class) {
                if (g == null || !g.isAlive()) {
                    g = new HandlerThread("csj_init_handle", -1);
                    g.start();
                    h = new Handler(g.getLooper());
                }
            }
        } else if (h == null) {
            synchronized (l.class) {
                if (h == null) {
                    h = new Handler(g.getLooper());
                }
            }
        }
        return h;
    }

    public static Handler c() {
        return new Handler(Looper.getMainLooper());
    }

    public static int d() {
        return f;
    }

    public static void a(int i) {
        f = i;
    }

    public static boolean e() {
        return d() == 1;
    }

    public static void f() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - c > 10000) {
            c = elapsedRealtime;
            aa.a((h) new h("onSharedPreferenceChanged") {
                public void run() {
                    String c = o.c(o.a());
                    if (!TextUtils.equals(c, o.a)) {
                        o.ai().a(6, true);
                        o.a = c;
                    }
                }
            });
        }
    }
}
