package com.cellrebel.sdk.workers;

import com.cellrebel.sdk.networking.beans.request.VideoMetric;
import com.cellrebel.sdk.workers.CollectVideoMetricsWorker;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectVideoMetricsWorker$a$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ CollectVideoMetricsWorker.a f$0;
    public final /* synthetic */ VideoMetric f$1;

    public /* synthetic */ CollectVideoMetricsWorker$a$$ExternalSyntheticLambda2(CollectVideoMetricsWorker.a aVar, VideoMetric videoMetric) {
        this.f$0 = aVar;
        this.f$1 = videoMetric;
    }

    public final void run() {
        this.f$0.c(this.f$1);
    }
}
