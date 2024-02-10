package com.cellrebel.sdk.workers;

import android.os.Handler;
import com.cellrebel.sdk.workers.SentTraceRouteWorker;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SentTraceRouteWorker$a$$ExternalSyntheticLambda1 implements Callable {
    public final /* synthetic */ SentTraceRouteWorker.a f$0;
    public final /* synthetic */ Handler f$1;
    public final /* synthetic */ Throwable f$2;
    public final /* synthetic */ List f$3;

    public /* synthetic */ SentTraceRouteWorker$a$$ExternalSyntheticLambda1(SentTraceRouteWorker.a aVar, Handler handler, Throwable th, List list) {
        this.f$0 = aVar;
        this.f$1 = handler;
        this.f$2 = th;
        this.f$3 = list;
    }

    public final Object call() {
        return this.f$0.a(this.f$1, this.f$2, this.f$3);
    }
}
