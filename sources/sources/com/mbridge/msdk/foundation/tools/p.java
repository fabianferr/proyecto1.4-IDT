package com.mbridge.msdk.foundation.tools;

import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.Executor;

/* compiled from: LimitExecutor */
public final class p implements Executor {
    private Runnable a;
    private Runnable b;

    public final synchronized void execute(Runnable runnable) {
        if (this.a == null) {
            this.a = a(runnable);
            n.a().execute(this.a);
        } else if (this.b == null) {
            this.b = a(runnable);
        }
    }

    private Runnable a(final Runnable runnable) {
        return new Runnable() {
            public final void run() {
                try {
                    runnable.run();
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("LimitExecutor", e.getMessage());
                    }
                } catch (Throwable th) {
                    p.this.a();
                    throw th;
                }
                p.this.a();
            }
        };
    }

    /* access modifiers changed from: private */
    public synchronized void a() {
        Runnable runnable = this.b;
        this.a = runnable;
        this.b = null;
        if (runnable != null) {
            n.a().execute(this.a);
        }
    }
}
