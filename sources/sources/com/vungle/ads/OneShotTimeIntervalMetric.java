package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\bJ\u0006\u0010\t\u001a\u00020\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/vungle/ads/OneShotTimeIntervalMetric;", "Lcom/vungle/ads/TimeIntervalMetric;", "metricType", "Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$SDKMetricType;", "(Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$SDKMetricType;)V", "alreadyLogged", "", "alreadyMetered", "alreadyMetered$vungle_ads_release", "isLogged", "markEnd", "", "markLogged", "markStart", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Metrics.kt */
public final class OneShotTimeIntervalMetric extends TimeIntervalMetric {
    private boolean alreadyLogged;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneShotTimeIntervalMetric(Sdk.SDKMetric.SDKMetricType sDKMetricType) {
        super(sDKMetricType);
        Intrinsics.checkNotNullParameter(sDKMetricType, "metricType");
    }

    public final boolean alreadyMetered$vungle_ads_release() {
        return (getValueFirst() == null || getValueSecond() == null) ? false : true;
    }

    public void markStart() {
        if (getValueFirst() == null) {
            super.markStart();
        }
    }

    public void markEnd() {
        if (getValueSecond() == null) {
            super.markEnd();
        }
    }

    public final boolean isLogged() {
        return this.alreadyLogged;
    }

    public final void markLogged() {
        this.alreadyLogged = true;
    }
}
