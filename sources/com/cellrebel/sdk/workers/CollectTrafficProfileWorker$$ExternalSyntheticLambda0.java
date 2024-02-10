package com.cellrebel.sdk.workers;

import java.util.concurrent.CountDownLatch;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectTrafficProfileWorker$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ CountDownLatch f$0;

    public /* synthetic */ CollectTrafficProfileWorker$$ExternalSyntheticLambda0(CountDownLatch countDownLatch) {
        this.f$0 = countDownLatch;
    }

    public final void run() {
        CollectTrafficProfileWorker.a(this.f$0);
    }
}
