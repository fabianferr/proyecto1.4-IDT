package com.ironsource.mediationsdk.logger;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronSourceLogger;

public final class b extends IronSourceLogger {
    public LogListener c;
    public boolean d;

    private b() {
        super("publisher");
    }

    public b(LogListener logListener, int i) {
        super("publisher", 1);
        this.c = null;
        this.d = false;
    }

    public final void log(final IronSourceLogger.IronSourceTag ironSourceTag, final String str, final int i) {
        AnonymousClass1 r0 = new Runnable() {
            public final void run() {
                if (b.this.c != null && str != null) {
                    b.this.c.onLog(ironSourceTag, str, i);
                }
            }
        };
        if (this.d) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(r0);
        } else {
            IronSourceThreadManager.INSTANCE.postPublisherCallback(r0);
        }
    }

    public final void logException(IronSourceLogger.IronSourceTag ironSourceTag, String str, Throwable th) {
        if (th != null) {
            log(ironSourceTag, th.getMessage(), 3);
        }
    }
}
