package com.applovin.impl.sdk;

import android.os.Process;
import java.lang.Thread;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppLovinExceptionHandler implements Thread.UncaughtExceptionHandler {
    private static final AppLovinExceptionHandler a = new AppLovinExceptionHandler();
    private final Set<m> b = new HashSet(2);
    private final AtomicBoolean c = new AtomicBoolean();
    private Thread.UncaughtExceptionHandler d;

    public static AppLovinExceptionHandler shared() {
        return a;
    }

    public void addSdk(m mVar) {
        this.b.add(mVar);
    }

    public void enable() {
        if (this.c.compareAndSet(false, true)) {
            this.d = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        for (m next : this.b) {
            if (u.a()) {
                next.A().b("AppLovinExceptionHandler", "Detected unhandled exception");
            }
            ((EventServiceImpl) next.w()).trackEventSynchronously("paused");
            ((EventServiceImpl) next.w()).trackEventSynchronously("crashed");
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException unused) {
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        Process.killProcess(Process.myPid());
        System.exit(1);
    }
}
