package com.cellrebel.sdk.workers;

import android.content.Context;
import com.cellrebel.sdk.youtube.player.YouTubePlayer;
import com.cellrebel.sdk.youtube.player.listeners.YouTubePlayerInitListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CollectVideoMetricsWorker$$ExternalSyntheticLambda6 implements YouTubePlayerInitListener {
    public final /* synthetic */ CollectVideoMetricsWorker f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Context f$3;

    public /* synthetic */ CollectVideoMetricsWorker$$ExternalSyntheticLambda6(CollectVideoMetricsWorker collectVideoMetricsWorker, int i, int i2, Context context) {
        this.f$0 = collectVideoMetricsWorker;
        this.f$1 = i;
        this.f$2 = i2;
        this.f$3 = context;
    }

    public final void a(YouTubePlayer youTubePlayer) {
        this.f$0.a(this.f$1, this.f$2, this.f$3, youTubePlayer);
    }
}
