package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnalyticsCollector$$ExternalSyntheticLambda39 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ float f$1;

    public /* synthetic */ AnalyticsCollector$$ExternalSyntheticLambda39(AnalyticsListener.EventTime eventTime, float f) {
        this.f$0 = eventTime;
        this.f$1 = f;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onVolumeChanged(this.f$0, this.f$1);
    }
}
