package com.ironsource.environment.thread;

import java.util.concurrent.CountDownLatch;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IronSourceThreadManager$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ CountDownLatch f$0;

    public /* synthetic */ IronSourceThreadManager$$ExternalSyntheticLambda0(CountDownLatch countDownLatch) {
        this.f$0 = countDownLatch;
    }

    public final void run() {
        IronSourceThreadManager.a(this.f$0);
    }
}
