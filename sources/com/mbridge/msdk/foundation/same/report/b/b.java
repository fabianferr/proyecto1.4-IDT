package com.mbridge.msdk.foundation.same.report.b;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;

/* compiled from: AnrMonitor */
public class b extends Thread {
    private static volatile b b;
    /* access modifiers changed from: private */
    public int a = 5000;
    /* access modifiers changed from: private */
    public final Handler c = new Handler(Looper.getMainLooper());
    private volatile a d;
    private a e;

    /* compiled from: AnrMonitor */
    private class a implements Runnable {
        /* access modifiers changed from: private */
        public boolean b;
        private long c;
        private long d;

        private a() {
            this.d = SystemClock.uptimeMillis();
        }

        public final void run() {
            synchronized (b.this) {
                Log.d("ANRMonitorActivity", "check task done");
                this.b = true;
                this.d = SystemClock.uptimeMillis();
            }
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.b = false;
            this.c = SystemClock.uptimeMillis();
            b.this.c.postAtFrontOfQueue(this);
        }

        /* access modifiers changed from: package-private */
        public final boolean b() {
            return !this.b || this.d - this.c >= ((long) b.this.a);
        }
    }

    public final b a(int i, a aVar) {
        this.a = i;
        this.e = aVar;
        return this;
    }

    public static b a() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b();
                }
            }
        }
        return b;
    }

    private b() {
        super("AnrMonitor-Thread");
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            if (isInterrupted() || (this.d != null && !this.d.b)) {
                try {
                    sleep((long) this.a);
                } catch (Exception unused) {
                }
            } else {
                synchronized (this) {
                    if (this.d == null) {
                        this.d = new a();
                    }
                    this.d.a();
                    long j = (long) this.a;
                    long uptimeMillis = SystemClock.uptimeMillis();
                    while (j > 0) {
                        try {
                            wait(j);
                        } catch (InterruptedException e2) {
                            Log.w("AnrMonitor", e2.toString());
                        }
                        j = ((long) this.a) - (SystemClock.uptimeMillis() - uptimeMillis);
                    }
                    if (!this.d.b()) {
                        a aVar = this.e;
                        if (aVar != null) {
                            aVar.a();
                        }
                    } else if (!Debug.isDebuggerConnected() && !Debug.waitingForDebugger() && this.e != null) {
                        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                        this.e.a(c.b(stackTrace), stackTrace);
                    }
                }
            }
        }
    }
}
