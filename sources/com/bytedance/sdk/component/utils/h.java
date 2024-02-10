package com.bytedance.sdk.component.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.component.g.a.a;

/* compiled from: HandlerUtils */
public class h {
    private static volatile Handler a;

    public static Handler a() {
        return a.a().b();
    }

    public static Handler b() {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new Handler(Looper.getMainLooper());
                }
            }
        }
        return a;
    }
}
