package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.source.MediaLoadData;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda2 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ MediaLoadData f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda2(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        this.f$0 = eventTime;
        this.f$1 = mediaLoadData;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onUpstreamDiscarded(this.f$0, this.f$1);
    }
}