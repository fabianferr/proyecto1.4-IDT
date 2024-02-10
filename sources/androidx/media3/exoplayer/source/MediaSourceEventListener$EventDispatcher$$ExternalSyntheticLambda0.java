package androidx.media3.exoplayer.source;

import androidx.media3.exoplayer.source.MediaSourceEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f$0;
    public final /* synthetic */ MediaSourceEventListener f$1;
    public final /* synthetic */ MediaLoadData f$2;

    public /* synthetic */ MediaSourceEventListener$EventDispatcher$$ExternalSyntheticLambda0(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, MediaLoadData mediaLoadData) {
        this.f$0 = eventDispatcher;
        this.f$1 = mediaSourceEventListener;
        this.f$2 = mediaLoadData;
    }

    public final void run() {
        this.f$0.m1565lambda$downstreamFormatChanged$5$androidxmedia3exoplayersourceMediaSourceEventListener$EventDispatcher(this.f$1, this.f$2);
    }
}
