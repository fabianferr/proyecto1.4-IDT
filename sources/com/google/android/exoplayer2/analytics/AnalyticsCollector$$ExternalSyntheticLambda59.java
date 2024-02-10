package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnalyticsCollector$$ExternalSyntheticLambda59 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ TrackGroupArray f$1;
    public final /* synthetic */ TrackSelectionArray f$2;

    public /* synthetic */ AnalyticsCollector$$ExternalSyntheticLambda59(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        this.f$0 = eventTime;
        this.f$1 = trackGroupArray;
        this.f$2 = trackSelectionArray;
    }

    public final void invoke(Object obj) {
        ((AnalyticsListener) obj).onTracksChanged(this.f$0, this.f$1, this.f$2);
    }
}
