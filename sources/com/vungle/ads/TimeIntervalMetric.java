package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/vungle/ads/TimeIntervalMetric;", "Lcom/vungle/ads/DualValueMetric;", "metricType", "Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$SDKMetricType;", "(Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$SDKMetricType;)V", "calculateIntervalDuration", "", "getCurrentTime", "getValue", "markEnd", "", "markStart", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Metrics.kt */
public class TimeIntervalMetric extends DualValueMetric {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType sDKMetricType) {
        super(sDKMetricType);
        Intrinsics.checkNotNullParameter(sDKMetricType, "metricType");
    }

    public void markStart() {
        setValueFirst(Long.valueOf(getCurrentTime()));
    }

    public void markEnd() {
        setValueSecond(Long.valueOf(getCurrentTime()));
    }

    public final long calculateIntervalDuration() {
        Long valueSecond = getValueSecond();
        long longValue = valueSecond != null ? valueSecond.longValue() : System.currentTimeMillis();
        Long valueFirst = getValueFirst();
        return longValue - (valueFirst != null ? valueFirst.longValue() : System.currentTimeMillis());
    }

    private final long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public long getValue() {
        return calculateIntervalDuration();
    }
}
