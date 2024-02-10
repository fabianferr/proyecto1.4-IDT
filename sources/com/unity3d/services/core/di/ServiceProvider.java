package com.unity3d.services.core.di;

import com.unity3d.services.SDKErrorHandler;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.configuration.IExperiments;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.SDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.core.LegacyHttpClient;
import com.unity3d.services.core.network.core.OkHttp3Client;
import com.unity3d.services.core.request.metrics.SDKMetrics;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/unity3d/services/core/di/ServiceProvider;", "Lcom/unity3d/services/core/di/IServiceProvider;", "()V", "NAMED_SDK", "", "serviceRegistry", "Lcom/unity3d/services/core/di/IServicesRegistry;", "getRegistry", "initialize", "provideHttpClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "dispatchers", "Lcom/unity3d/services/core/domain/ISDKDispatchers;", "configFileFromLocalStorage", "Lcom/unity3d/services/core/domain/task/ConfigFileFromLocalStorage;", "provideSDKDispatchers", "provideSDKErrorHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "sdkMetricsSender", "Lcom/unity3d/services/core/request/metrics/SDKMetricsSender;", "provideSDKMetricSender", "provideSDKScope", "Lkotlinx/coroutines/CoroutineScope;", "errorHandler", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceProvider.kt */
public final class ServiceProvider implements IServiceProvider {
    public static final ServiceProvider INSTANCE;
    public static final String NAMED_SDK = "sdk";
    private static final IServicesRegistry serviceRegistry;

    private ServiceProvider() {
    }

    static {
        ServiceProvider serviceProvider = new ServiceProvider();
        INSTANCE = serviceProvider;
        serviceRegistry = serviceProvider.initialize();
    }

    public IServicesRegistry initialize() {
        return ServicesRegistryKt.registry(ServiceProvider$initialize$1.INSTANCE);
    }

    public IServicesRegistry getRegistry() {
        return serviceRegistry;
    }

    /* access modifiers changed from: private */
    public final ISDKDispatchers provideSDKDispatchers() {
        return new SDKDispatchers();
    }

    /* access modifiers changed from: private */
    public final CoroutineExceptionHandler provideSDKErrorHandler(ISDKDispatchers iSDKDispatchers, SDKMetricsSender sDKMetricsSender) {
        return new SDKErrorHandler(iSDKDispatchers, sDKMetricsSender);
    }

    /* access modifiers changed from: private */
    public final CoroutineScope provideSDKScope(ISDKDispatchers iSDKDispatchers, CoroutineExceptionHandler coroutineExceptionHandler) {
        return CoroutineScopeKt.CoroutineScope(iSDKDispatchers.getDefault().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(coroutineExceptionHandler));
    }

    /* access modifiers changed from: private */
    public final SDKMetricsSender provideSDKMetricSender() {
        SDKMetricsSender instance = SDKMetrics.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
        return instance;
    }

    /* access modifiers changed from: private */
    public final HttpClient provideHttpClient(ISDKDispatchers iSDKDispatchers, ConfigFileFromLocalStorage configFileFromLocalStorage) {
        IExperiments experiments;
        boolean z = true;
        Configuration configuration = (Configuration) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new ServiceProvider$provideHttpClient$config$1(configFileFromLocalStorage, (Continuation<? super ServiceProvider$provideHttpClient$config$1>) null), 1, (Object) null);
        if (configuration == null || (experiments = configuration.getExperiments()) == null || !experiments.isOkHttpEnabled()) {
            z = false;
        }
        if (z) {
            return new OkHttp3Client(iSDKDispatchers, new OkHttpClient());
        }
        return new LegacyHttpClient(iSDKDispatchers);
    }
}
