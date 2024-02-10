package com.cellrebel.sdk.workers;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrackingManager$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ ScheduledExecutorService f$1;
    public final /* synthetic */ Integer[] f$2;

    public /* synthetic */ TrackingManager$$ExternalSyntheticLambda8(Context context, ScheduledExecutorService scheduledExecutorService, Integer[] numArr) {
        this.f$0 = context;
        this.f$1 = scheduledExecutorService;
        this.f$2 = numArr;
    }

    public final void run() {
        TrackingManager.a(this.f$0, this.f$1, this.f$2);
    }
}
