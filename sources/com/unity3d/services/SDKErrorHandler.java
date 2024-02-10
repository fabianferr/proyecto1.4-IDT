package com.unity3d.services;

import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.request.metrics.Metric;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/unity3d/services/SDKErrorHandler;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "sdkMetricsSender", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "(Lcom/unity3d/services/core/domain/ISDKDispatchers;Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;)V", "key", "Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "getKey", "()Lkotlinx/coroutines/CoroutineExceptionHandler$Key;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "sendMetric", "metric", "Lcom/unity3d/services/core/request/metrics/Metric;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SDKErrorHandler.kt */
public final class SDKErrorHandler implements CoroutineExceptionHandler {
    private final ISDKDispatchers dispatchers;
    private final CoroutineExceptionHandler.Key key = CoroutineExceptionHandler.Key;
    private final SDKMetricsSender sdkMetricsSender;

    public SDKErrorHandler(ISDKDispatchers iSDKDispatchers, SDKMetricsSender sDKMetricsSender) {
        Intrinsics.checkNotNullParameter(iSDKDispatchers, "dispatchers");
        Intrinsics.checkNotNullParameter(sDKMetricsSender, "sdkMetricsSender");
        this.dispatchers = iSDKDispatchers;
        this.sdkMetricsSender = sDKMetricsSender;
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineExceptionHandler.DefaultImpls.fold(this, r, function2);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key2) {
        return CoroutineExceptionHandler.DefaultImpls.get(this, key2);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key2) {
        return CoroutineExceptionHandler.DefaultImpls.minusKey(this, key2);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineExceptionHandler.DefaultImpls.plus(this, coroutineContext);
    }

    public CoroutineExceptionHandler.Key getKey() {
        return this.key;
    }

    public void handleException(CoroutineContext coroutineContext, Throwable th) {
        String str;
        Intrinsics.checkNotNullParameter(coroutineContext, "context");
        Intrinsics.checkNotNullParameter(th, "exception");
        String fileName = th.getStackTrace()[0].getFileName();
        Intrinsics.checkNotNullExpressionValue(fileName, "exception.stackTrace[0].fileName");
        int lineNumber = th.getStackTrace()[0].getLineNumber();
        if (th instanceof NullPointerException) {
            str = "native_exception_npe";
        } else if (th instanceof OutOfMemoryError) {
            str = "native_exception_oom";
        } else if (th instanceof IllegalStateException) {
            str = "native_exception_ise";
        } else if (th instanceof RuntimeException) {
            str = "native_exception_re";
        } else {
            str = th instanceof SecurityException ? "native_exception_se" : "native_exception";
        }
        String str2 = str;
        sendMetric(new Metric(str2, "{" + fileName + "}_" + lineNumber, (Map) null, 4, (DefaultConstructorMarker) null));
    }

    private final void sendMetric(Metric metric) {
        this.sdkMetricsSender.sendMetric(metric);
    }
}
