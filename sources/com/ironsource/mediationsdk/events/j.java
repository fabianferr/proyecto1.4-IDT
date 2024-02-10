package com.ironsource.mediationsdk.events;

import android.os.Handler;
import android.os.HandlerThread;
import com.ironsource.mediationsdk.logger.c;

public final class j extends Thread {
    private static j b;
    private a a;

    class a extends HandlerThread {
        Handler a;

        a(String str) {
            super(str);
            setUncaughtExceptionHandler(new c());
        }
    }

    private j() {
        a aVar = new a(getClass().getSimpleName());
        this.a = aVar;
        aVar.start();
        a aVar2 = this.a;
        aVar2.a = new Handler(aVar2.getLooper());
    }

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (b == null) {
                b = new j();
            }
            jVar = b;
        }
        return jVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x000f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.Runnable r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.ironsource.mediationsdk.events.j$a r0 = r1.a     // Catch:{ all -> 0x0010 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.os.Handler r0 = r0.a     // Catch:{ all -> 0x0010 }
            if (r0 == 0) goto L_0x000e
            r0.post(r2)     // Catch:{ all -> 0x0010 }
        L_0x000e:
            monitor-exit(r1)
            return
        L_0x0010:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.events.j.a(java.lang.Runnable):void");
    }
}
