package com.m2catalyst.m2sdk;

import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import java.lang.Thread;

/* compiled from: M2ExceptionHandler */
public final class o2 implements Thread.UncaughtExceptionHandler {
    public final Thread.UncaughtExceptionHandler a = Thread.getDefaultUncaughtExceptionHandler();
    public final M2SDKLogger b = M2SDKLogger.Companion.getLogger();

    public final void uncaughtException(Thread thread, Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        sb.append(th.toString() + "\n");
        for (int i = 0; i < stackTrace.length; i++) {
            sb.append(" at " + stackTrace[i].toString() + "\n");
        }
        Throwable cause = th.getCause();
        if (cause != null) {
            sb.append(cause.toString() + "\n");
            StackTraceElement[] stackTrace2 = cause.getStackTrace();
            for (int i2 = 0; i2 < stackTrace2.length; i2++) {
                sb.append(" at " + stackTrace2[i2].toString() + "\n");
            }
        }
        this.b.e("ExceptionHandler", sb.toString(), new String[0]);
        this.a.uncaughtException(thread, th);
    }
}
