package com.cellrebel.sdk.workers;

import com.cellrebel.sdk.networking.beans.request.PageLoadMetric;
import com.cellrebel.sdk.workers.CollectPageLoadMetricsWorker;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectPageLoadMetricsWorker$a$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ CollectPageLoadMetricsWorker.a f$0;
    public final /* synthetic */ PageLoadMetric f$1;

    public /* synthetic */ CollectPageLoadMetricsWorker$a$$ExternalSyntheticLambda0(CollectPageLoadMetricsWorker.a aVar, PageLoadMetric pageLoadMetric) {
        this.f$0 = aVar;
        this.f$1 = pageLoadMetric;
    }

    public final Object call() {
        return this.f$0.a(this.f$1);
    }
}
