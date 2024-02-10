package com.mbridge.msdk.dycreator.bus;

import android.util.Log;

final class BackgroundPoster implements Runnable {
    private final PendingPostQueue a = new PendingPostQueue();
    private volatile boolean b;
    private final EventBus c;

    BackgroundPoster(EventBus eventBus) {
        this.c = eventBus;
    }

    public final void enqueue(Subscription subscription, Object obj) {
        PendingPost a2 = PendingPost.a(subscription, obj);
        synchronized (this) {
            this.a.a(a2);
            if (!this.b) {
                this.b = true;
                EventBus.a.execute(this);
            }
        }
    }

    public final void run() {
        while (true) {
            try {
                PendingPost a2 = this.a.a(1000);
                if (a2 == null) {
                    synchronized (this) {
                        a2 = this.a.a();
                        if (a2 == null) {
                            this.b = false;
                            this.b = false;
                            return;
                        }
                    }
                }
                this.c.a(a2);
            } catch (InterruptedException e) {
                try {
                    Log.w("Event", Thread.currentThread().getName() + " was interruppted", e);
                    return;
                } finally {
                    this.b = false;
                }
            }
        }
    }
}
