package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda45 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda45(AnalyticsListener.EventTime eventTime, boolean z) {
        this.f$0 = eventTime;
        this.f$1 = z;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onIsPlayingChanged(this.f$0, this.f$1);
    }
}
