package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnalyticsCollector$$ExternalSyntheticLambda46 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ int f$1;

    public /* synthetic */ AnalyticsCollector$$ExternalSyntheticLambda46(AnalyticsListener.EventTime eventTime, int i) {
        this.f$0 = eventTime;
        this.f$1 = i;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onMaxSeekToPreviousPositionChanged(this.f$0, this.f$1);
    }
}
