package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f$0;
    public final /* synthetic */ MediaSourceEventListener f$1;
    public final /* synthetic */ MediaSource.MediaPeriodId f$2;
    public final /* synthetic */ MediaLoadData f$3;

    public /* synthetic */ MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda3(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        this.f$0 = eventDispatcher;
        this.f$1 = mediaSourceEventListener;
        this.f$2 = mediaPeriodId;
        this.f$3 = mediaLoadData;
    }

    public final void run() {
        this.f$0.m1570lambda$upstreamDiscarded$4$androidxmedia3exoplayersourceMediaSourceEventListener$EventDispatcher(this.f$1, this.f$2, this.f$3);
    }
}
