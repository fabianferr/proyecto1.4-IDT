package com.unity3d.services.core.request.metrics;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H\u0016J2\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0012\u001a\u00020\t2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0015"}, d2 = {"Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "", "metricEndPoint", "", "getMetricEndPoint", "()Ljava/lang/String;", "areMetricsEnabledForCurrentSession", "", "sendEvent", "", "event", "value", "tags", "", "sendMetric", "metric", "Lcom/unity3d/services/core/request/metrics/Metric;", "sendMetricWithInitState", "sendMetrics", "metrics", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SDKMetricsSender.kt */
public interface SDKMetricsSender {
    boolean areMetricsEnabledForCurrentSession();

    String getMetricEndPoint();

    void sendEvent(String str);

    void sendEvent(String str, String str2, Map<String, String> map);

    void sendMetric(Metric metric);

    void sendMetricWithInitState(Metric metric);

    void sendMetrics(List<Metric> list);

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: SDKMetricsSender.kt */
    public static final class DefaultImpls {
        public static void sendEvent(SDKMetricsSender sDKMetricsSender, String str) {
            Intrinsics.checkNotNullParameter(str, "event");
            sendEvent$default(sDKMetricsSender, str, (String) null, (Map) null, 4, (Object) null);
        }

        public static /* synthetic */ void sendEvent$default(SDKMetricsSender sDKMetricsSender, String str, String str2, Map map, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    map = MapsKt.emptyMap();
                }
                sDKMetricsSender.sendEvent(str, str2, map);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
    }
}
