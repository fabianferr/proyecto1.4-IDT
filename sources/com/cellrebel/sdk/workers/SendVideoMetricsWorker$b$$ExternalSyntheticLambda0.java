package com.cellrebel.sdk.workers;

import android.os.Handler;
import com.cellrebel.sdk.workers.SendVideoMetricsWorker;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SendVideoMetricsWorker$b$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ SendVideoMetricsWorker.b f$0;
    public final /* synthetic */ Handler f$1;
    public final /* synthetic */ Throwable f$2;
    public final /* synthetic */ List f$3;

    public /* synthetic */ SendVideoMetricsWorker$b$$ExternalSyntheticLambda0(SendVideoMetricsWorker.b bVar, Handler handler, Throwable th, List list) {
        this.f$0 = bVar;
        this.f$1 = handler;
        this.f$2 = th;
        this.f$3 = list;
    }

    public final Object call() {
        return this.f$0.a(this.f$1, this.f$2, this.f$3);
    }
}
