package com.cellrebel.sdk.workers;

import com.cellrebel.sdk.workers.CollectVideoMetricsWorker;
import com.cellrebel.sdk.youtube.player.YouTubePlayer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectVideoMetricsWorker$a$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ CollectVideoMetricsWorker.a f$0;
    public final /* synthetic */ YouTubePlayer f$1;

    public /* synthetic */ CollectVideoMetricsWorker$a$$ExternalSyntheticLambda7(CollectVideoMetricsWorker.a aVar, YouTubePlayer youTubePlayer) {
        this.f$0 = aVar;
        this.f$1 = youTubePlayer;
    }

    public final void run() {
        this.f$0.a(this.f$1);
    }
}
