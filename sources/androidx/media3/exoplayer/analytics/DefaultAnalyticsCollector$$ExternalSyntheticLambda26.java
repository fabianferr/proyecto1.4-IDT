package androidx.media3.exoplayer.analytics;

import androidx.media3.common.util.ListenerSet;
import androidx.media3.exoplayer.analytics.AnalyticsListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAnalyticsCollector$$ExternalSyntheticLambda26 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ Exception f$1;

    public /* synthetic */ DefaultAnalyticsCollector$$ExternalSyntheticLambda26(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.f$0 = eventTime;
        this.f$1 = exc;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onAudioCodecError(this.f$0, this.f$1);
    }
}
