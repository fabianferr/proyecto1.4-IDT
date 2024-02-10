package com.cellrebel.sdk.workers;

import com.cellrebel.sdk.networking.beans.request.TimeToInteractionMetric;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectTtiMetricsWorker$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ CollectTtiMetricsWorker f$0;
    public final /* synthetic */ TimeToInteractionMetric f$1;

    public /* synthetic */ CollectTtiMetricsWorker$$ExternalSyntheticLambda1(CollectTtiMetricsWorker collectTtiMetricsWorker, TimeToInteractionMetric timeToInteractionMetric) {
        this.f$0 = collectTtiMetricsWorker;
        this.f$1 = timeToInteractionMetric;
    }

    public final void run() {
        this.f$0.b(this.f$1);
    }
}
