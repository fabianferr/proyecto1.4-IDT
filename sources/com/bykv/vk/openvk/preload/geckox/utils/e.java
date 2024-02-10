package com.bykv.vk.openvk.preload.geckox.utils;

import com.bykv.vk.openvk.preload.geckox.b;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: IOSerialExecutor */
public class e implements Executor {
    private static volatile e a;
    private ExecutorService b = b.a();

    private e() {
    }

    public static e a() {
        if (a == null) {
            synchronized (e.class) {
                if (a == null) {
                    a = new e();
                }
            }
        }
        return a;
    }

    public void execute(Runnable runnable) {
        this.b.execute(runnable);
    }
}
