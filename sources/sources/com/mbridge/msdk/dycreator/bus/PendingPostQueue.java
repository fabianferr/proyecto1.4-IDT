package com.mbridge.msdk.dycreator.bus;

final class PendingPostQueue {
    private PendingPost a;
    private PendingPost b;

    PendingPostQueue() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(PendingPost pendingPost) {
        if (pendingPost != null) {
            try {
                PendingPost pendingPost2 = this.b;
                if (pendingPost2 != null) {
                    pendingPost2.c = pendingPost;
                    this.b = pendingPost;
                } else if (this.a == null) {
                    this.b = pendingPost;
                    this.a = pendingPost;
                } else {
                    throw new IllegalStateException("Head present, but no tail");
                }
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("null cannot be enqueued");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized PendingPost a() {
        PendingPost pendingPost;
        pendingPost = this.a;
        if (pendingPost != null) {
            PendingPost pendingPost2 = pendingPost.c;
            this.a = pendingPost2;
            if (pendingPost2 == null) {
                this.b = null;
            }
        }
        return pendingPost;
    }

    /* access modifiers changed from: package-private */
    public final synchronized PendingPost a(int i) throws InterruptedException {
        if (this.a == null) {
            wait((long) i);
        }
        return a();
    }
}
