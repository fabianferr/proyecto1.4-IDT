package com.pgl.ssdk;

import java.lang.Thread;

public class m implements Thread.UncaughtExceptionHandler {
    private static volatile m c;
    private final Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    private volatile boolean b = false;

    private m() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static m b() {
        if (c == null) {
            synchronized (m.class) {
                if (c == null) {
                    c = new m();
                }
            }
        }
        return c;
    }

    public boolean a() {
        return this.b;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.b = true;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.a;
        if (uncaughtExceptionHandler != null && uncaughtExceptionHandler != this) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
