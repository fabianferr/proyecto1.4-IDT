package androidx.room;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class InvalidationTracker$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ InvalidationTracker f$0;

    public /* synthetic */ InvalidationTracker$$ExternalSyntheticLambda0(InvalidationTracker invalidationTracker) {
        this.f$0 = invalidationTracker;
    }

    public final void run() {
        this.f$0.onAutoCloseCallback$room_runtime_release();
    }
}
