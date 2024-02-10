package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.properties.InitializationStatusReader;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\u0017\u001a\u00020\u0018H\u0016J.\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0016J\u0016\u0010\"\u001a\u00020\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020!0$H\u0016J\u0006\u0010%\u001a\u00020\u001aR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\n \u0016*\u0004\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/unity3d/services/core/request/metrics/MetricSender;", "Lcom/unity3d/services/core/request/metrics/MetricSenderBase;", "Lcom/unity3d/services/core/di/IServiceComponent;", "configuration", "Lcom/unity3d/services/core/configuration/Configuration;", "initializationStatusReader", "Lcom/unity3d/services/core/properties/InitializationStatusReader;", "(Lcom/unity3d/services/core/configuration/Configuration;Lcom/unity3d/services/core/properties/InitializationStatusReader;)V", "commonTags", "Lcom/unity3d/services/core/request/metrics/MetricCommonTags;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "httpClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "metricEndPoint", "", "getMetricEndPoint", "()Ljava/lang/String;", "metricSampleRate", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sessionToken", "kotlin.jvm.PlatformType", "areMetricsEnabledForCurrentSession", "", "sendEvent", "", "event", "value", "tags", "", "sendMetric", "metric", "Lcom/unity3d/services/core/request/metrics/Metric;", "sendMetrics", "metrics", "", "shutdown", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MetricSender.kt */
public class MetricSender extends MetricSenderBase implements IServiceComponent {
    /* access modifiers changed from: private */
    public final MetricCommonTags commonTags;
    private final ISDKDispatchers dispatchers;
    /* access modifiers changed from: private */
    public final HttpClient httpClient = ((HttpClient) ServiceProvider.INSTANCE.getRegistry().getService("", Reflection.getOrCreateKotlinClass(HttpClient.class)));
    private final String metricEndPoint;
    /* access modifiers changed from: private */
    public final String metricSampleRate;
    private final CoroutineScope scope;
    /* access modifiers changed from: private */
    public final String sessionToken;

    public boolean areMetricsEnabledForCurrentSession() {
        return true;
    }

    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MetricSender(Configuration configuration, InitializationStatusReader initializationStatusReader) {
        super(initializationStatusReader);
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        Intrinsics.checkNotNullParameter(initializationStatusReader, "initializationStatusReader");
        MetricCommonTags metricCommonTags = new MetricCommonTags();
        metricCommonTags.updateWithConfig(configuration);
        this.commonTags = metricCommonTags;
        this.metricSampleRate = String.valueOf(MathKt.roundToInt(configuration.getMetricSampleRate()));
        this.sessionToken = configuration.getSessionToken();
        ISDKDispatchers iSDKDispatchers = (ISDKDispatchers) ServiceProvider.INSTANCE.getRegistry().getService("", Reflection.getOrCreateKotlinClass(ISDKDispatchers.class));
        this.dispatchers = iSDKDispatchers;
        this.scope = CoroutineScopeKt.CoroutineScope(iSDKDispatchers.getIo());
        this.metricEndPoint = configuration.getMetricsUrl();
    }

    public String getMetricEndPoint() {
        return this.metricEndPoint;
    }

    public void sendEvent(String str, String str2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(map, "tags");
        if (str.length() == 0) {
            DeviceLog.debug("Metric event not sent due to being null or empty: " + str);
            return;
        }
        sendMetrics(CollectionsKt.listOf(new Metric(str, str2, map)));
    }

    public void sendMetric(Metric metric) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        sendMetrics(CollectionsKt.listOf(metric));
    }

    public void sendMetrics(List<Metric> list) {
        Intrinsics.checkNotNullParameter(list, "metrics");
        if (list.isEmpty()) {
            DeviceLog.debug("Metrics event not send due to being empty");
            return;
        }
        CharSequence metricEndPoint2 = getMetricEndPoint();
        if (metricEndPoint2 == null || StringsKt.isBlank(metricEndPoint2)) {
            DeviceLog.debug("Metrics: " + list + " was not sent to null or empty endpoint: " + getMetricEndPoint());
            return;
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, new MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key, list), (CoroutineStart) null, new MetricSender$sendMetrics$1(this, list, (Continuation<? super MetricSender$sendMetrics$1>) null), 2, (Object) null);
    }

    public final void shutdown() {
        this.commonTags.shutdown();
    }
}
