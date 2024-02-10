package com.vungle.ads;

import android.os.Build;
import com.facebook.share.internal.ShareConstants;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.executor.VungleThreadPoolExecutor;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.ActivityManager;
import com.vungle.ads.internal.util.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002[\\B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u00106\u001a\u000207H\u0003J\b\u00108\u001a\u000207H\u0003JJ\u00109\u001a\u00020\u00182\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020.2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004H\u0002J<\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00042\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0004H\u0002J-\u0010F\u001a\u0002072\u0006\u0010/\u001a\u0002002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010G\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\bHJA\u0010I\u001a\u0002072\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00042\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\bJJA\u0010I\u001a\u0002072\u0006\u0010K\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u00042\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\bJJ<\u0010L\u001a\u0002072\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020\u00042\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u0004H\u0002JE\u0010M\u001a\u0002072\u0006\u0010N\u001a\u00020O2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\bPJE\u0010M\u001a\u0002072\u0006\u0010Q\u001a\u00020R2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\bPJE\u0010M\u001a\u0002072\u0006\u0010S\u001a\u00020T2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\bPJE\u0010M\u001a\u0002072\u0006\u0010U\u001a\u00020V2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\bPJO\u0010M\u001a\u0002072\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020.2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\bPJJ\u0010W\u001a\u0002072\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020.2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010@\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010X\u001a\u000207J\b\u0010Y\u001a\u000207H\u0002J\u0006\u0010Z\u001a\u000207R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0019\u0010\u0002\u001a\u0004\b\u001a\u0010\nR$\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b$\u0010\u0002\u001a\u0004\b%\u0010\nR\"\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0002\u001a\u0004\b(\u0010\nR$\u0010)\u001a\u00020\u001c8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u0002\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!R\u000e\u0010-\u001a\u00020.XT¢\u0006\u0002\n\u0000R&\u0010/\u001a\u0004\u0018\u0001008\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b1\u0010\u0002\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006]"}, d2 = {"Lcom/vungle/ads/AnalyticsClient;", "", "()V", "TAG", "", "errors", "Ljava/util/concurrent/BlockingQueue;", "Lcom/vungle/ads/internal/protos/Sdk$SDKError$Builder;", "getErrors$vungle_ads_release$annotations", "getErrors$vungle_ads_release", "()Ljava/util/concurrent/BlockingQueue;", "executor", "Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;", "getExecutor$vungle_ads_release$annotations", "getExecutor$vungle_ads_release", "()Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;", "setExecutor$vungle_ads_release", "(Lcom/vungle/ads/internal/executor/VungleThreadPoolExecutor;)V", "logLevel", "Lcom/vungle/ads/AnalyticsClient$LogLevel;", "maxBatchSize", "", "maxErrorLogLevel", "metrics", "Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$Builder;", "getMetrics$vungle_ads_release$annotations", "getMetrics$vungle_ads_release", "metricsEnabled", "", "getMetricsEnabled$vungle_ads_release$annotations", "getMetricsEnabled$vungle_ads_release", "()Z", "setMetricsEnabled$vungle_ads_release", "(Z)V", "paused", "pendingErrors", "getPendingErrors$vungle_ads_release$annotations", "getPendingErrors$vungle_ads_release", "pendingMetrics", "getPendingMetrics$vungle_ads_release$annotations", "getPendingMetrics$vungle_ads_release", "refreshEnabled", "getRefreshEnabled$vungle_ads_release$annotations", "getRefreshEnabled$vungle_ads_release", "setRefreshEnabled$vungle_ads_release", "refreshTimeMillis", "", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "getVungleApiClient$vungle_ads_release$annotations", "getVungleApiClient$vungle_ads_release", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "setVungleApiClient$vungle_ads_release", "(Lcom/vungle/ads/internal/network/VungleApiClient;)V", "flushErrors", "", "flushMetrics", "genMetric", "metricType", "Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$SDKMetricType;", "metricValue", "placementId", "creativeId", "eventId", "metaData", "genSDKError", "reason", "Lcom/vungle/ads/internal/protos/Sdk$SDKError$Reason;", "message", "placementRefId", "init", "errorLogLevel", "init$vungle_ads_release", "logError", "logError$vungle_ads_release", "reasonCode", "logErrorInSameThread", "logMetric", "metric", "Lcom/vungle/ads/Metric;", "logMetric$vungle_ads_release", "oneShotTimeIntervalMetric", "Lcom/vungle/ads/OneShotTimeIntervalMetric;", "singleValueMetric", "Lcom/vungle/ads/SingleValueMetric;", "timeIntervalMetric", "Lcom/vungle/ads/TimeIntervalMetric;", "logMetricInSameThread", "pause", "report", "resume", "LogLevel", "RequestListener", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AnalyticsClient.kt */
public final class AnalyticsClient {
    public static final AnalyticsClient INSTANCE = new AnalyticsClient();
    /* access modifiers changed from: private */
    public static final String TAG = "AnalyticsClient";
    private static final BlockingQueue<Sdk.SDKError.Builder> errors = new LinkedBlockingQueue();
    private static VungleThreadPoolExecutor executor = null;
    private static LogLevel logLevel = LogLevel.ERROR_LOG_LEVEL_ERROR;
    private static final int maxBatchSize = 20;
    private static int maxErrorLogLevel = Integer.MAX_VALUE;
    private static final BlockingQueue<Sdk.SDKMetric.Builder> metrics = new LinkedBlockingQueue();
    private static boolean metricsEnabled = false;
    private static boolean paused = false;
    private static final BlockingQueue<Sdk.SDKError.Builder> pendingErrors = new LinkedBlockingQueue();
    private static final BlockingQueue<Sdk.SDKMetric.Builder> pendingMetrics = new LinkedBlockingQueue();
    private static boolean refreshEnabled = true;
    private static final long refreshTimeMillis = 5000;
    private static VungleApiClient vungleApiClient;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/AnalyticsClient$RequestListener;", "", "onFailure", "", "onSuccess", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AnalyticsClient.kt */
    public interface RequestListener {
        void onFailure();

        void onSuccess();
    }

    public static /* synthetic */ void getErrors$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getExecutor$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMetrics$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMetricsEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getPendingErrors$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getPendingMetrics$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getRefreshEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getVungleApiClient$vungle_ads_release$annotations() {
    }

    private AnalyticsClient() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/vungle/ads/AnalyticsClient$LogLevel;", "", "level", "", "(Ljava/lang/String;II)V", "getLevel", "()I", "ERROR_LOG_LEVEL_OFF", "ERROR_LOG_LEVEL_ERROR", "ERROR_LOG_LEVEL_DEBUG", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AnalyticsClient.kt */
    public enum LogLevel {
        ERROR_LOG_LEVEL_OFF(0),
        ERROR_LOG_LEVEL_ERROR(1),
        ERROR_LOG_LEVEL_DEBUG(2);
        
        public static final Companion Companion = null;
        private final int level;

        private LogLevel(int i) {
            this.level = i;
        }

        public final int getLevel() {
            return this.level;
        }

        static {
            Companion = new Companion((DefaultConstructorMarker) null);
        }

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/vungle/ads/AnalyticsClient$LogLevel$Companion;", "", "()V", "fromValue", "Lcom/vungle/ads/AnalyticsClient$LogLevel;", "logLevel", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: AnalyticsClient.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final LogLevel fromValue(int i) {
                if (i == LogLevel.ERROR_LOG_LEVEL_DEBUG.getLevel()) {
                    return LogLevel.ERROR_LOG_LEVEL_DEBUG;
                }
                if (i == LogLevel.ERROR_LOG_LEVEL_ERROR.getLevel()) {
                    return LogLevel.ERROR_LOG_LEVEL_ERROR;
                }
                if (i == LogLevel.ERROR_LOG_LEVEL_OFF.getLevel()) {
                    return LogLevel.ERROR_LOG_LEVEL_OFF;
                }
                return LogLevel.ERROR_LOG_LEVEL_ERROR;
            }
        }
    }

    static {
        Intrinsics.checkNotNullExpressionValue("AnalyticsClient", "AnalyticsClient::class.java.simpleName");
    }

    public final BlockingQueue<Sdk.SDKError.Builder> getErrors$vungle_ads_release() {
        return errors;
    }

    public final BlockingQueue<Sdk.SDKMetric.Builder> getMetrics$vungle_ads_release() {
        return metrics;
    }

    public final BlockingQueue<Sdk.SDKError.Builder> getPendingErrors$vungle_ads_release() {
        return pendingErrors;
    }

    public final BlockingQueue<Sdk.SDKMetric.Builder> getPendingMetrics$vungle_ads_release() {
        return pendingMetrics;
    }

    public final VungleApiClient getVungleApiClient$vungle_ads_release() {
        return vungleApiClient;
    }

    public final void setVungleApiClient$vungle_ads_release(VungleApiClient vungleApiClient2) {
        vungleApiClient = vungleApiClient2;
    }

    public final VungleThreadPoolExecutor getExecutor$vungle_ads_release() {
        return executor;
    }

    public final void setExecutor$vungle_ads_release(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        executor = vungleThreadPoolExecutor;
    }

    public final boolean getMetricsEnabled$vungle_ads_release() {
        return metricsEnabled;
    }

    public final void setMetricsEnabled$vungle_ads_release(boolean z) {
        metricsEnabled = z;
    }

    public final boolean getRefreshEnabled$vungle_ads_release() {
        return refreshEnabled;
    }

    public final void setRefreshEnabled$vungle_ads_release(boolean z) {
        refreshEnabled = z;
    }

    public final void init$vungle_ads_release(VungleApiClient vungleApiClient2, VungleThreadPoolExecutor vungleThreadPoolExecutor, int i, boolean z) {
        Intrinsics.checkNotNullParameter(vungleApiClient2, "vungleApiClient");
        Intrinsics.checkNotNullParameter(vungleThreadPoolExecutor, "executor");
        executor = vungleThreadPoolExecutor;
        vungleApiClient = vungleApiClient2;
        metricsEnabled = z;
        try {
            BlockingQueue<Sdk.SDKError.Builder> blockingQueue = pendingErrors;
            if (!blockingQueue.isEmpty()) {
                blockingQueue.drainTo(errors);
            }
        } catch (Exception e) {
            Logger.Companion.e(TAG, "Failed to add pendingErrors to errors queue.", e);
        }
        try {
            BlockingQueue<Sdk.SDKMetric.Builder> blockingQueue2 = pendingMetrics;
            if (!blockingQueue2.isEmpty()) {
                blockingQueue2.drainTo(metrics);
            }
        } catch (Exception e2) {
            Logger.Companion.e(TAG, "Failed to add pendingMetrics to metrics queue.", e2);
        }
        if (refreshEnabled) {
            Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(new AnalyticsClient$$ExternalSyntheticLambda1(vungleThreadPoolExecutor), 0, 5000, TimeUnit.MILLISECONDS);
        }
        maxErrorLogLevel = i;
        logLevel = LogLevel.Companion.fromValue(i);
        if (i == LogLevel.ERROR_LOG_LEVEL_DEBUG.getLevel()) {
            Logger.Companion.enable(true);
        } else if (i == LogLevel.ERROR_LOG_LEVEL_ERROR.getLevel()) {
            Logger.Companion.enable(false);
        } else if (i == LogLevel.ERROR_LOG_LEVEL_OFF.getLevel()) {
            Logger.Companion.enable(false);
        }
        ActivityManager.Companion.getInstance().addListener(new AnalyticsClient$init$2());
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-1  reason: not valid java name */
    public static final void m248init$lambda1(VungleThreadPoolExecutor vungleThreadPoolExecutor) {
        Intrinsics.checkNotNullParameter(vungleThreadPoolExecutor, "$executor");
        vungleThreadPoolExecutor.execute(new AnalyticsClient$$ExternalSyntheticLambda0());
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-1$lambda-0  reason: not valid java name */
    public static final void m249init$lambda1$lambda0() {
        INSTANCE.report();
    }

    public static /* synthetic */ void logError$vungle_ads_release$default(AnalyticsClient analyticsClient, Sdk.SDKError.Reason reason, String str, String str2, String str3, String str4, int i, Object obj) {
        analyticsClient.logError$vungle_ads_release(reason, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final synchronized void logError$vungle_ads_release(Sdk.SDKError.Reason reason, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(reason, IronSourceConstants.EVENTS_ERROR_REASON);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        try {
            VungleThreadPoolExecutor vungleThreadPoolExecutor = executor;
            if (vungleThreadPoolExecutor == null) {
                pendingErrors.put(genSDKError(reason, str, str2, str3, str4));
                return;
            } else if (vungleThreadPoolExecutor != null) {
                vungleThreadPoolExecutor.execute(new AnalyticsClient$$ExternalSyntheticLambda2(reason, str, str2, str3, str4));
            }
        } catch (Exception e) {
            Logger.Companion companion = Logger.Companion;
            String str5 = TAG;
            companion.e(str5, "Cannot logError " + reason + ", " + str + ", " + str2 + ", " + str3 + AbstractJsonLexerKt.COMMA + str4, e);
        }
        return;
    }

    /* access modifiers changed from: private */
    /* renamed from: logError$lambda-2  reason: not valid java name */
    public static final void m250logError$lambda2(Sdk.SDKError.Reason reason, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(reason, "$reason");
        Intrinsics.checkNotNullParameter(str, "$message");
        INSTANCE.logErrorInSameThread(reason, str, str2, str3, str4);
    }

    static /* synthetic */ Sdk.SDKError.Builder genSDKError$default(AnalyticsClient analyticsClient, Sdk.SDKError.Reason reason, String str, String str2, String str3, String str4, int i, Object obj) {
        return analyticsClient.genSDKError(reason, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    private final Sdk.SDKError.Builder genSDKError(Sdk.SDKError.Reason reason, String str, String str2, String str3, String str4) {
        Sdk.SDKError.Builder at = Sdk.SDKError.newBuilder().setOs("Android").setOsVersion(String.valueOf(Build.VERSION.SDK_INT)).setMake(Build.MANUFACTURER).setModel(Build.MODEL).setReason(reason).setMessage(str).setAt(System.currentTimeMillis());
        if (str2 == null) {
            str2 = "";
        }
        Sdk.SDKError.Builder placementReferenceId = at.setPlacementReferenceId(str2);
        if (str3 == null) {
            str3 = "";
        }
        Sdk.SDKError.Builder creativeId = placementReferenceId.setCreativeId(str3);
        if (str4 == null) {
            str4 = "";
        }
        Sdk.SDKError.Builder eventId = creativeId.setEventId(str4);
        Intrinsics.checkNotNullExpressionValue(eventId, "newBuilder()\n           …setEventId(eventId ?: \"\")");
        return eventId;
    }

    static /* synthetic */ void logErrorInSameThread$default(AnalyticsClient analyticsClient, Sdk.SDKError.Reason reason, String str, String str2, String str3, String str4, int i, Object obj) {
        analyticsClient.logErrorInSameThread(reason, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    private final synchronized void logErrorInSameThread(Sdk.SDKError.Reason reason, String str, String str2, String str3, String str4) {
        if (logLevel != LogLevel.ERROR_LOG_LEVEL_OFF) {
            try {
                Sdk.SDKError.Builder genSDKError = genSDKError(reason, str, str2, str3, str4);
                BlockingQueue<Sdk.SDKError.Builder> blockingQueue = errors;
                blockingQueue.put(genSDKError);
                if (blockingQueue.size() >= 20) {
                    report();
                }
            } catch (Exception e) {
                Logger.Companion.e(TAG, "Cannot logError", e);
            }
        } else {
            return;
        }
        return;
    }

    public static /* synthetic */ void logError$vungle_ads_release$default(AnalyticsClient analyticsClient, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        analyticsClient.logError$vungle_ads_release(i, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4);
    }

    public final synchronized void logError$vungle_ads_release(int i, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Sdk.SDKError.Reason forNumber = Sdk.SDKError.Reason.forNumber(i);
        Intrinsics.checkNotNullExpressionValue(forNumber, "forNumber(reasonCode)");
        logError$vungle_ads_release(forNumber, str, str2, str3, str4);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, String str, String str2, String str3, String str4, int i, Object obj) {
        long j2 = (i & 2) != 0 ? 0 : j;
        String str5 = null;
        String str6 = (i & 4) != 0 ? null : str;
        String str7 = (i & 8) != 0 ? null : str2;
        String str8 = (i & 16) != 0 ? null : str3;
        if ((i & 32) == 0) {
            str5 = str4;
        }
        analyticsClient.logMetric$vungle_ads_release(sDKMetricType, j2, str6, str7, str8, str5);
    }

    public final synchronized void logMetric$vungle_ads_release(Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, String str, String str2, String str3, String str4) {
        Sdk.SDKMetric.SDKMetricType sDKMetricType2 = sDKMetricType;
        synchronized (this) {
            Intrinsics.checkNotNullParameter(sDKMetricType, "metricType");
            try {
                VungleThreadPoolExecutor vungleThreadPoolExecutor = executor;
                if (vungleThreadPoolExecutor == null) {
                    pendingMetrics.put(genMetric(sDKMetricType, j, str, str2, str3, str4));
                    return;
                } else if (vungleThreadPoolExecutor != null) {
                    vungleThreadPoolExecutor.execute(new AnalyticsClient$$ExternalSyntheticLambda3(sDKMetricType, j, str, str2, str3, str4));
                }
            } catch (Exception e) {
                Logger.Companion companion = Logger.Companion;
                String str5 = TAG;
                StringBuilder sb = new StringBuilder("Cannot logMetric ");
                sb.append(sDKMetricType);
                sb.append(", ");
                long j2 = j;
                sb.append(j);
                sb.append(", ");
                sb.append(str);
                sb.append(", ");
                sb.append(str2);
                sb.append(AbstractJsonLexerKt.COMMA);
                sb.append(str3);
                sb.append(", ");
                sb.append(str4);
                companion.e(str5, sb.toString(), e);
            }
        }
        return;
    }

    /* access modifiers changed from: private */
    /* renamed from: logMetric$lambda-3  reason: not valid java name */
    public static final void m251logMetric$lambda3(Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(sDKMetricType, "$metricType");
        INSTANCE.logMetricInSameThread(sDKMetricType, j, str, str2, str3, str4);
    }

    static /* synthetic */ Sdk.SDKMetric.Builder genMetric$default(AnalyticsClient analyticsClient, Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, String str, String str2, String str3, String str4, int i, Object obj) {
        long j2 = (i & 2) != 0 ? 0 : j;
        String str5 = null;
        String str6 = (i & 4) != 0 ? null : str;
        String str7 = (i & 8) != 0 ? null : str2;
        String str8 = (i & 16) != 0 ? null : str3;
        if ((i & 32) == 0) {
            str5 = str4;
        }
        return analyticsClient.genMetric(sDKMetricType, j2, str6, str7, str8, str5);
    }

    private final Sdk.SDKMetric.Builder genMetric(Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, String str, String str2, String str3, String str4) {
        Sdk.SDKMetric.Builder osVersion = Sdk.SDKMetric.newBuilder().setType(sDKMetricType).setValue(j).setMake(Build.MANUFACTURER).setModel(Build.MODEL).setOs("Android").setOsVersion(String.valueOf(Build.VERSION.SDK_INT));
        if (str == null) {
            str = "";
        }
        Sdk.SDKMetric.Builder placementReferenceId = osVersion.setPlacementReferenceId(str);
        if (str2 == null) {
            str2 = "";
        }
        Sdk.SDKMetric.Builder creativeId = placementReferenceId.setCreativeId(str2);
        if (str3 == null) {
            str3 = "";
        }
        Sdk.SDKMetric.Builder eventId = creativeId.setEventId(str3);
        if (str4 == null) {
            str4 = "";
        }
        Sdk.SDKMetric.Builder meta = eventId.setMeta(str4);
        Intrinsics.checkNotNullExpressionValue(meta, "newBuilder()\n           … .setMeta(metaData ?: \"\")");
        return meta;
    }

    static /* synthetic */ void logMetricInSameThread$default(AnalyticsClient analyticsClient, Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, String str, String str2, String str3, String str4, int i, Object obj) {
        long j2 = (i & 2) != 0 ? 0 : j;
        String str5 = null;
        String str6 = (i & 4) != 0 ? null : str;
        String str7 = (i & 8) != 0 ? null : str2;
        String str8 = (i & 16) != 0 ? null : str3;
        if ((i & 32) == 0) {
            str5 = str4;
        }
        analyticsClient.logMetricInSameThread(sDKMetricType, j2, str6, str7, str8, str5);
    }

    private final synchronized void logMetricInSameThread(Sdk.SDKMetric.SDKMetricType sDKMetricType, long j, String str, String str2, String str3, String str4) {
        if (metricsEnabled) {
            try {
                Sdk.SDKMetric.Builder genMetric = genMetric(sDKMetricType, j, str, str2, str3, str4);
                BlockingQueue<Sdk.SDKMetric.Builder> blockingQueue = metrics;
                blockingQueue.put(genMetric);
                if (blockingQueue.size() >= 20) {
                    report();
                }
            } catch (Exception e) {
                Logger.Companion.e(TAG, "Cannot logMetrics", e);
            }
        } else {
            return;
        }
        return;
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, Metric metric, String str, String str2, String str3, String str4, int i, Object obj) {
        analyticsClient.logMetric$vungle_ads_release(metric, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final synchronized void logMetric$vungle_ads_release(Metric metric, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(metric, "metric");
        Sdk.SDKMetric.SDKMetricType metricType = metric.getMetricType();
        long value = metric.getValue();
        if (str4 == null) {
            str4 = metric.getMeta();
        }
        logMetric$vungle_ads_release(metricType, value, str, str2, str3, str4);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, SingleValueMetric singleValueMetric, String str, String str2, String str3, String str4, int i, Object obj) {
        analyticsClient.logMetric$vungle_ads_release(singleValueMetric, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final synchronized void logMetric$vungle_ads_release(SingleValueMetric singleValueMetric, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(singleValueMetric, "singleValueMetric");
        logMetric$vungle_ads_release((Metric) singleValueMetric, str, str2, str3, str4);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, TimeIntervalMetric timeIntervalMetric, String str, String str2, String str3, String str4, int i, Object obj) {
        String str5 = (i & 2) != 0 ? null : str;
        String str6 = (i & 4) != 0 ? null : str2;
        String str7 = (i & 8) != 0 ? null : str3;
        if ((i & 16) != 0) {
            str4 = timeIntervalMetric.getMeta();
        }
        analyticsClient.logMetric$vungle_ads_release(timeIntervalMetric, str5, str6, str7, str4);
    }

    public final synchronized void logMetric$vungle_ads_release(TimeIntervalMetric timeIntervalMetric, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(timeIntervalMetric, "timeIntervalMetric");
        logMetric$vungle_ads_release((Metric) timeIntervalMetric, str, str2, str3, str4);
    }

    public static /* synthetic */ void logMetric$vungle_ads_release$default(AnalyticsClient analyticsClient, OneShotTimeIntervalMetric oneShotTimeIntervalMetric, String str, String str2, String str3, String str4, int i, Object obj) {
        analyticsClient.logMetric$vungle_ads_release(oneShotTimeIntervalMetric, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4);
    }

    public final synchronized void logMetric$vungle_ads_release(OneShotTimeIntervalMetric oneShotTimeIntervalMetric, String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(oneShotTimeIntervalMetric, "oneShotTimeIntervalMetric");
        if (!oneShotTimeIntervalMetric.isLogged()) {
            logMetric$vungle_ads_release((TimeIntervalMetric) oneShotTimeIntervalMetric, str, str2, str3, str4);
            oneShotTimeIntervalMetric.markLogged();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void report() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = paused     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            com.vungle.ads.AnalyticsClient$LogLevel r0 = logLevel     // Catch:{ all -> 0x0029 }
            com.vungle.ads.AnalyticsClient$LogLevel r1 = com.vungle.ads.AnalyticsClient.LogLevel.ERROR_LOG_LEVEL_OFF     // Catch:{ all -> 0x0029 }
            if (r0 == r1) goto L_0x0018
            java.util.concurrent.BlockingQueue<com.vungle.ads.internal.protos.Sdk$SDKError$Builder> r0 = errors     // Catch:{ all -> 0x0029 }
            int r0 = r0.size()     // Catch:{ all -> 0x0029 }
            if (r0 <= 0) goto L_0x0018
            r2.flushErrors()     // Catch:{ all -> 0x0029 }
        L_0x0018:
            boolean r0 = metricsEnabled     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0027
            java.util.concurrent.BlockingQueue<com.vungle.ads.internal.protos.Sdk$SDKMetric$Builder> r0 = metrics     // Catch:{ all -> 0x0029 }
            int r0 = r0.size()     // Catch:{ all -> 0x0029 }
            if (r0 <= 0) goto L_0x0027
            r2.flushMetrics()     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r2)
            return
        L_0x0029:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.AnalyticsClient.report():void");
    }

    private final void flushMetrics() {
        VungleApiClient vungleApiClient2;
        Logger.Companion companion = Logger.Companion;
        String str = TAG;
        StringBuilder sb = new StringBuilder("Sending ");
        BlockingQueue<Sdk.SDKMetric.Builder> blockingQueue = metrics;
        sb.append(blockingQueue.size());
        sb.append(" metrics");
        companion.d(str, sb.toString());
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        blockingQueue.drainTo(linkedBlockingQueue);
        if (!linkedBlockingQueue.isEmpty() && (vungleApiClient2 = vungleApiClient) != null) {
            vungleApiClient2.reportMetrics(linkedBlockingQueue, new AnalyticsClient$flushMetrics$1(linkedBlockingQueue));
        }
    }

    private final void flushErrors() {
        VungleApiClient vungleApiClient2;
        Logger.Companion companion = Logger.Companion;
        String str = TAG;
        StringBuilder sb = new StringBuilder("Sending ");
        BlockingQueue<Sdk.SDKError.Builder> blockingQueue = errors;
        sb.append(blockingQueue.size());
        sb.append(" errors");
        companion.d(str, sb.toString());
        BlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        blockingQueue.drainTo(linkedBlockingQueue);
        if (!linkedBlockingQueue.isEmpty() && (vungleApiClient2 = vungleApiClient) != null) {
            vungleApiClient2.reportErrors(linkedBlockingQueue, new AnalyticsClient$flushErrors$1(linkedBlockingQueue));
        }
    }

    public final void pause() {
        paused = true;
    }

    public final void resume() {
        paused = false;
    }
}
