package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda5 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda5(AnalyticsListener.EventTime eventTime, String str) {
        this.f$0 = eventTime;
        this.f$1 = str;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onVideoDecoderReleased(this.f$0, this.f$1);
    }
}
