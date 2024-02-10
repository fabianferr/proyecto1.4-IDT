package com.cellrebel.sdk.workers;

import com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectTtiMetricsWorker$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ CollectTtiMetricsWorker f$0;
    public final /* synthetic */ TimeToInteractionMetric f$1;

    public /* synthetic */ CollectTtiMetricsWorker$$ExternalSyntheticLambda2(CollectTtiMetricsWorker collectTtiMetricsWorker, TimeToInteractionMetric timeToInteractionMetric) {
        this.f$0 = collectTtiMetricsWorker;
        this.f$1 = timeToInteractionMetric;
    }

    public final Object call() {
        return this.f$0.a(this.f$1);
    }
}
