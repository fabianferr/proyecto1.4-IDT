package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnalyticsCollector$$ExternalSyntheticLambda45 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ AnalyticsCollector$$ExternalSyntheticLambda45(AnalyticsListener.EventTime eventTime, boolean z) {
        this.f$0 = eventTime;
        this.f$1 = z;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onIsLoadingChanged$39(this.f$0, this.f$1, (AnalyticsListener) obj);
    }
}