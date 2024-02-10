package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnalyticsCollector$$ExternalSyntheticLambda9 implements ListenerSet.IterationFinishedEvent {
    public final /* synthetic */ AnalyticsCollector f$0;
    public final /* synthetic */ Player f$1;

    public /* synthetic */ AnalyticsCollector$$ExternalSyntheticLambda9(AnalyticsCollector analyticsCollector, Player player) {
        this.f$0 = analyticsCollector;
        this.f$1 = player;
    }

    public final void invoke(Object obj, FlagSet flagSet) {
        this.f$0.m2022lambda$setPlayer$1$comgoogleandroidexoplayer2analyticsAnalyticsCollector(this.f$1, (AnalyticsListener) obj, flagSet);
    }
}
