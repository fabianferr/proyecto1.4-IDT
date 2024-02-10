package com.startapp;

import android.content.Context;
import androidx.work.PeriodicWorkRequest;

/* compiled from: Sta */
public abstract class w1<T> {
    public final Context a;
    public volatile T b;
    public volatile long c;
    public final long d;

    public w1(Context context) {
        this(context, PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS);
    }

    public T a() {
        return null;
    }

    public T a(boolean z) {
        return a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
        if ((r8.c + r8.d < android.os.SystemClock.uptimeMillis()) != false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T b() {
        /*
            r8 = this;
            T r0 = r8.b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0018
            long r3 = r8.c
            long r5 = r8.d
            long r3 = r3 + r5
            long r5 = android.os.SystemClock.uptimeMillis()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0015
            r3 = 1
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 == 0) goto L_0x004b
        L_0x0018:
            monitor-enter(r8)
            T r0 = r8.b     // Catch:{ all -> 0x0053 }
            long r3 = r8.c     // Catch:{ all -> 0x0053 }
            long r5 = r8.d     // Catch:{ all -> 0x0053 }
            long r3 = r3 + r5
            long r5 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0053 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x0029
            goto L_0x002a
        L_0x0029:
            r1 = 0
        L_0x002a:
            if (r0 == 0) goto L_0x002e
            if (r1 == 0) goto L_0x004a
        L_0x002e:
            java.lang.Object r0 = r8.a(r1)     // Catch:{ all -> 0x0033 }
            goto L_0x0040
        L_0x0033:
            r1 = move-exception
            java.lang.Class<android.os.RemoteException> r2 = android.os.RemoteException.class
            boolean r2 = com.startapp.k9.a((java.lang.Throwable) r1, (java.lang.Class<? extends java.lang.Throwable>) r2)     // Catch:{ all -> 0x0053 }
            if (r2 == 0) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            com.startapp.i3.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0053 }
        L_0x0040:
            if (r0 == 0) goto L_0x004a
            r8.b = r0     // Catch:{ all -> 0x0053 }
            long r1 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0053 }
            r8.c = r1     // Catch:{ all -> 0x0053 }
        L_0x004a:
            monitor-exit(r8)     // Catch:{ all -> 0x0053 }
        L_0x004b:
            if (r0 == 0) goto L_0x004e
            goto L_0x0052
        L_0x004e:
            java.lang.Object r0 = r8.c()
        L_0x0052:
            return r0
        L_0x0053:
            r0 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0053 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.w1.b():java.lang.Object");
    }

    public abstract T c();

    public w1(Context context, long j) {
        this.a = context;
        this.d = j;
    }
}
