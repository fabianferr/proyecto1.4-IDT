package com.unity3d.services.core.domain.task;

import com.facebook.login.LoginLogger;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.task.BaseParams;
import com.unity3d.services.core.domain.task.BaseTask;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b&\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0015\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\n\u0010\u0018\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\r2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0014\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u001fH\u0002J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020#H\u0002J\u0019\u0010$\u001a\u00028\u00012\u0006\u0010%\u001a\u00028\u0000HBø\u0001\u0000¢\u0006\u0002\u0010&J\b\u0010'\u001a\u00020\u0013H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lcom/unity3d/services/core/domain/task/MetricTask;", "P", "Lcom/unity3d/services/core/domain/task/BaseParams;", "R", "Lcom/unity3d/services/core/domain/task/BaseTask;", "()V", "duration", "", "getDuration", "()J", "setDuration", "(J)V", "taskStatus", "", "getTaskStatus", "()Ljava/lang/String;", "setTaskStatus", "(Ljava/lang/String;)V", "captureMetric", "", "result", "(Ljava/lang/Object;)V", "getMetric", "Lcom/unity3d/services/core/request/metrics/Metric;", "getMetricName", "getMetricNameForInitializeTask", "name", "getMetricNameForTask", "task", "", "getMetricTagsForState", "", "getSDKMetrics", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "getStatePrefixLength", "", "invoke", "params", "(Lcom/unity3d/services/core/domain/task/BaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMetric", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MetricTask.kt */
public abstract class MetricTask<P extends BaseParams, R> implements BaseTask<P, R> {
    private long duration;
    private String taskStatus = "unknown";

    private final int getStatePrefixLength() {
        return 15;
    }

    public String getMetricName() {
        return null;
    }

    public Object invoke(P p, Continuation<? super R> continuation) {
        return invoke$suspendImpl(this, p, continuation);
    }

    public IServiceProvider getServiceProvider() {
        return BaseTask.DefaultImpls.getServiceProvider(this);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final void setDuration(long j) {
        this.duration = j;
    }

    public final String getTaskStatus() {
        return this.taskStatus;
    }

    public final void setTaskStatus(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.taskStatus = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object invoke$suspendImpl(com.unity3d.services.core.domain.task.MetricTask<? super P, R> r8, P r9, kotlin.coroutines.Continuation<? super R> r10) {
        /*
            boolean r0 = r10 instanceof com.unity3d.services.core.domain.task.MetricTask$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.unity3d.services.core.domain.task.MetricTask$invoke$1 r0 = (com.unity3d.services.core.domain.task.MetricTask$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.unity3d.services.core.domain.task.MetricTask$invoke$1 r0 = new com.unity3d.services.core.domain.task.MetricTask$invoke$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 != r3) goto L_0x0044
            long r8 = r0.J$0
            java.lang.Object r1 = r0.L$4
            java.util.concurrent.TimeUnit r1 = (java.util.concurrent.TimeUnit) r1
            java.lang.Object r2 = r0.L$3
            com.unity3d.services.core.domain.task.MetricTask r2 = (com.unity3d.services.core.domain.task.MetricTask) r2
            java.lang.Object r3 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r4 = r0.L$1
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r0 = r0.L$0
            com.unity3d.services.core.domain.task.MetricTask r0 = (com.unity3d.services.core.domain.task.MetricTask) r0
            kotlin.ResultKt.throwOnFailure(r10)
            r6 = r8
            r8 = r2
            r9 = r4
            r4 = r6
            goto L_0x0074
        L_0x0044:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef
            r10.<init>()
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r4 = java.lang.System.nanoTime()
            r0.L$0 = r8
            r0.L$1 = r10
            r0.L$2 = r10
            r0.L$3 = r8
            r0.L$4 = r2
            r0.J$0 = r4
            r0.label = r3
            java.lang.Object r9 = com.unity3d.services.core.domain.task.BaseTask.DefaultImpls.invoke(r8, r9, r0)
            if (r9 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r0 = r8
            r3 = r10
            r1 = r2
            r10 = r9
            r9 = r3
        L_0x0074:
            r3.element = r10
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            long r2 = java.lang.System.nanoTime()
            long r2 = r2 - r4
            long r1 = r1.toMillis(r2)
            r8.duration = r1
            T r8 = r9.element
            r0.captureMetric(r8)
            T r8 = r9.element
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.MetricTask.invoke$suspendImpl(com.unity3d.services.core.domain.task.MetricTask, com.unity3d.services.core.domain.task.BaseParams, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void captureMetric(R r) {
        String str = "success";
        if ((r instanceof Result) && !Result.m2351isSuccessimpl(((Result) r).m2353unboximpl())) {
            str = LoginLogger.EVENT_EXTRAS_FAILURE;
        }
        this.taskStatus = str;
        sendMetric();
    }

    private final void sendMetric() {
        CharSequence metricName = getMetricName();
        if (!(metricName == null || metricName.length() == 0)) {
            getSDKMetrics().sendMetric(getMetric());
        }
    }

    private final Metric getMetric() {
        return new Metric(getMetricName(), Long.valueOf(this.duration), getMetricTagsForState());
    }

    private final Map<String, String> getMetricTagsForState() {
        Map<String, String> retryTags = InitializeEventsMetricSender.getInstance().getRetryTags();
        Intrinsics.checkNotNullExpressionValue(retryTags, "getInstance().retryTags");
        return retryTags;
    }

    private final SDKMetricsSender getSDKMetrics() {
        return (SDKMetricsSender) getServiceProvider().getRegistry().getService("", Reflection.getOrCreateKotlinClass(SDKMetricsSender.class));
    }

    public final String getMetricNameForTask(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "task");
        String simpleName = obj.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "className");
        if (simpleName.length() == 0) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(simpleName, "className");
        String substring = simpleName.substring(getStatePrefixLength());
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        String lowerCase = substring.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        StringBuilder sb = new StringBuilder(7 + lowerCase.length() + 6);
        sb.append("native_");
        sb.append(lowerCase);
        sb.append("_state");
        return sb.toString();
    }

    public final String getMetricNameForInitializeTask(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return "native_" + str + "_task_" + this.taskStatus + "_time";
    }
}
