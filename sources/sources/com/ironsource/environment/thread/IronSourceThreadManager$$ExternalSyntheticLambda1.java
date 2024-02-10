package com.ironsource.environment.thread;

import java.util.concurrent.CountDownLatch;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IronSourceThreadManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Runnable f$0;
    public final /* synthetic */ CountDownLatch f$1;

    public /* synthetic */ IronSourceThreadManager$$ExternalSyntheticLambda1(Runnable runnable, CountDownLatch countDownLatch) {
        this.f$0 = runnable;
        this.f$1 = countDownLatch;
    }

    public final void run() {
        IronSourceThreadManager.a(this.f$0, this.f$1);
    }
}
