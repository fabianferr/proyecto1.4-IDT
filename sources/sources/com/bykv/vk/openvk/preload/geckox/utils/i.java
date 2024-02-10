package com.bykv.vk.openvk.preload.geckox.utils;

import com.bykv.vk.openvk.preload.geckox.b;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: PiecemealSerialExecutor */
public class i implements Executor {
    private static volatile i a;
    private ExecutorService b = b.a();

    private i() {
    }

    public static i a() {
        if (a == null) {
            synchronized (i.class) {
                if (a == null) {
                    a = new i();
                }
            }
        }
        return a;
    }

    public void execute(Runnable runnable) {
        this.b.execute(runnable);
    }
}
