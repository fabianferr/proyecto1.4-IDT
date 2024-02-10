package com.mbridge.msdk.dycreator.bus;

class AsyncPoster implements Runnable {
    private final PendingPostQueue a = new PendingPostQueue();
    private final EventBus b;

    AsyncPoster(EventBus eventBus) {
        this.b = eventBus;
    }

    public void enqueue(Subscription subscription, Object obj) {
        this.a.a(PendingPost.a(subscription, obj));
        EventBus.a.execute(this);
    }

    public void run() {
        PendingPost a2 = this.a.a();
        if (a2 != null) {
            this.b.a(a2);
            return;
        }
        throw new IllegalStateException("No pending post available");
    }
}
