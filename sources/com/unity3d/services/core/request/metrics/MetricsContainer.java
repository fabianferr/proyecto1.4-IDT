package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.device.Device;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.Session;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nJ\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \r*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \r*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/unity3d/services/core/request/metrics/MetricsContainer;", "", "metricSampleRate", "", "commonTags", "Lcom/unity3d/services/core/request/metrics/MetricCommonTags;", "metrics", "", "Lcom/unity3d/services/core/request/metrics/Metric;", "sTkn", "(Ljava/lang/String;Lcom/unity3d/services/core/request/metrics/MetricCommonTags;Ljava/util/List;Ljava/lang/String;)V", "apiLevel", "deviceManufacturer", "kotlin.jvm.PlatformType", "deviceModel", "deviceName", "gameId", "shSid", "toMap", "", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MetricsContainer.kt */
public final class MetricsContainer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String METRICS_CONTAINER = "m";
    private static final String METRICS_CONTAINER_TAGS = "t";
    private static final String METRIC_CONTAINER_API_LEVEL = "apil";
    private static final String METRIC_CONTAINER_DEVICE_MAKE = "deviceMake";
    private static final String METRIC_CONTAINER_DEVICE_MODEL = "deviceModel";
    private static final String METRIC_CONTAINER_DEVICE_NAME = "deviceName";
    private static final String METRIC_CONTAINER_GAME_ID = "gameId";
    private static final String METRIC_CONTAINER_SAMPLE_RATE = "msr";
    private static final String METRIC_CONTAINER_SESSION_TOKEN = "sTkn";
    private static final String METRIC_CONTAINER_SHARED_SESSION_ID = "shSid";
    private final String apiLevel = String.valueOf(Device.getApiLevel());
    private final MetricCommonTags commonTags;
    private final String deviceManufacturer = Device.getManufacturer();
    private final String deviceModel = Device.getModel();
    private final String deviceName = Device.getDevice();
    private final String gameId = ClientProperties.getGameId();
    private final String metricSampleRate;
    private final List<Metric> metrics;
    private final String sTkn;
    private final String shSid = Session.Default.getId();

    public MetricsContainer(String str, MetricCommonTags metricCommonTags, List<Metric> list, String str2) {
        Intrinsics.checkNotNullParameter(str, "metricSampleRate");
        Intrinsics.checkNotNullParameter(metricCommonTags, "commonTags");
        Intrinsics.checkNotNullParameter(list, "metrics");
        this.metricSampleRate = str;
        this.commonTags = metricCommonTags;
        this.metrics = list;
        this.sTkn = str2;
    }

    public final Map<String, Object> toMap() {
        Iterable<Metric> iterable = this.metrics;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Metric map : iterable) {
            arrayList.add(map.toMap());
        }
        Map createMapBuilder = MapsKt.createMapBuilder();
        createMapBuilder.put(METRIC_CONTAINER_SAMPLE_RATE, this.metricSampleRate);
        createMapBuilder.put(METRICS_CONTAINER, (List) arrayList);
        createMapBuilder.put(METRICS_CONTAINER_TAGS, this.commonTags.toMap());
        createMapBuilder.put(METRIC_CONTAINER_SHARED_SESSION_ID, this.shSid);
        createMapBuilder.put(METRIC_CONTAINER_API_LEVEL, this.apiLevel);
        String str = this.sTkn;
        if (str != null) {
            createMapBuilder.put(METRIC_CONTAINER_SESSION_TOKEN, str);
        }
        String str2 = this.deviceModel;
        if (str2 != null) {
            Intrinsics.checkNotNullExpressionValue(str2, METRIC_CONTAINER_DEVICE_MODEL);
            createMapBuilder.put(METRIC_CONTAINER_DEVICE_MODEL, str2);
        }
        String str3 = this.deviceName;
        if (str3 != null) {
            Intrinsics.checkNotNullExpressionValue(str3, METRIC_CONTAINER_DEVICE_NAME);
            createMapBuilder.put(METRIC_CONTAINER_DEVICE_NAME, str3);
        }
        String str4 = this.deviceManufacturer;
        if (str4 != null) {
            Intrinsics.checkNotNullExpressionValue(str4, "deviceManufacturer");
            createMapBuilder.put(METRIC_CONTAINER_DEVICE_MAKE, str4);
        }
        String str5 = this.gameId;
        if (str5 != null) {
            Intrinsics.checkNotNullExpressionValue(str5, METRIC_CONTAINER_GAME_ID);
            createMapBuilder.put(METRIC_CONTAINER_GAME_ID, str5);
        }
        return MapsKt.build(createMapBuilder);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/unity3d/services/core/request/metrics/MetricsContainer$Companion;", "", "()V", "METRICS_CONTAINER", "", "METRICS_CONTAINER_TAGS", "METRIC_CONTAINER_API_LEVEL", "METRIC_CONTAINER_DEVICE_MAKE", "METRIC_CONTAINER_DEVICE_MODEL", "METRIC_CONTAINER_DEVICE_NAME", "METRIC_CONTAINER_GAME_ID", "METRIC_CONTAINER_SAMPLE_RATE", "METRIC_CONTAINER_SESSION_TOKEN", "METRIC_CONTAINER_SHARED_SESSION_ID", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: MetricsContainer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
