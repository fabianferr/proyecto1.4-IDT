package com.umlaut.crowd.internal;

import java.util.concurrent.TimeUnit;

public final class q9 {
    private q9() {
    }

    public static boolean a(TimeUnit timeUnit, long j) {
        try {
            timeUnit.sleep(j);
            return true;
        } catch (InterruptedException unused) {
            return false;
        }
    }

    public static boolean b(long j) {
        return a(TimeUnit.NANOSECONDS, j);
    }

    public static boolean a(long j) {
        return a(TimeUnit.MILLISECONDS, j);
    }
}
