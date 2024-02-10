package com.bytedance.sdk.component.e.a.g;

import android.os.Handler;
import android.os.HandlerThread;

/* compiled from: TimerUtils */
public class a {
    private static volatile HandlerThread a = new HandlerThread("csj_ad_log", 10);
    private static volatile Handler b = null;
    private static int c = 3000;

    static {
        a.start();
    }

    public static Handler a() {
        if (a == null || !a.isAlive()) {
            synchronized (a.class) {
                if (a == null || !a.isAlive()) {
                    a = new HandlerThread("csj_init_handle", -1);
                    a.start();
                    b = new Handler(a.getLooper());
                }
            }
        } else if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new Handler(a.getLooper());
                }
            }
        }
        return b;
    }

    public static int b() {
        if (c <= 0) {
            c = 3000;
        }
        return c;
    }
}
