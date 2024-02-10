package com.bytedance.sdk.openadsdk.utils;

import android.os.Looper;
import com.bytedance.sdk.component.g.f;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.openadsdk.core.l;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: ThreadUtils */
public class aa {
    public static ScheduledExecutorService a() {
        return f.f();
    }

    public static ExecutorService b() {
        return f.j();
    }

    public static ExecutorService c() {
        return f.d();
    }

    public static ExecutorService d() {
        return f.b();
    }

    public static boolean e() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static boolean f() {
        return "csj_log".equals(Thread.currentThread().getName());
    }

    public static void a(Runnable runnable) {
        if (runnable != null) {
            if (e()) {
                runnable.run();
            } else {
                l.c().post(runnable);
            }
        }
    }

    public static void a(h hVar) {
        f.a(hVar);
    }

    public static ExecutorService g() {
        return f.c();
    }

    public static void b(h hVar) {
        f.b(hVar);
    }

    public static void a(h hVar, int i) {
        if (hVar != null) {
            f.a(hVar, 5, i);
        }
    }

    public static void c(h hVar) {
        if (hVar != null) {
            f.c(hVar);
        }
    }

    public static void b(h hVar, int i) {
        if (hVar != null) {
            f.b(hVar, i);
        }
    }

    public static void d(h hVar) {
        if (hVar != null) {
            f.e(hVar);
        }
    }

    public static void c(h hVar, int i) {
        if (hVar != null) {
            f.c(hVar, i);
        }
    }
}
