package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.ListenerSet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AnalyticsCollector$$ExternalSyntheticLambda5 implements ListenerSet.Event {
    public final /* synthetic */ AnalyticsListener.EventTime f$0;
    public final /* synthetic */ Format f$1;
    public final /* synthetic */ DecoderReuseEvaluation f$2;

    public /* synthetic */ AnalyticsCollector$$ExternalSyntheticLambda5(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.f$0 = eventTime;
        this.f$1 = format;
        this.f$2 = decoderReuseEvaluation;
    }

    public final void invoke(Object obj) {
        AnalyticsCollector.lambda$onVideoInputFormatChanged$20(this.f$0, this.f$1, this.f$2, (AnalyticsListener) obj);
    }
}