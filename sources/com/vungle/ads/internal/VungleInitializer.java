package com.vungle.ads.internal;

import android.content.Context;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.ConfigurationError;
import com.vungle.ads.ConfigurationResponseError;
import com.vungle.ads.InitializationListener;
import com.vungle.ads.InvalidAppId;
import com.vungle.ads.Metric;
import com.vungle.ads.NetworkPermissionsNotGranted;
import com.vungle.ads.NetworkUnreachable;
import com.vungle.ads.OutOfMemory;
import com.vungle.ads.SdkAlreadyInitialized;
import com.vungle.ads.SdkInitializationInProgress;
import com.vungle.ads.SdkNotInitialized;
import com.vungle.ads.SdkVersionTooLow;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.UnknownConfigurationError;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.load.MraidJsLoader;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.model.Cookie;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.Response;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.task.CleanupJob;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.task.ResendTpatJob;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.ThreadUtil;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\r\u0010\u0019\u001a\u00020\u0014H\u0000¢\u0006\u0002\b\u001aJ3\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00140\u001dH\u0002J\u001e\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010$\u001a\u00020\u0018J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\u00020\r8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006,²\u0006\n\u0010-\u001a\u00020.X\u0002²\u0006\n\u0010/\u001a\u000200X\u0002²\u0006\n\u00101\u001a\u000202X\u0002²\u0006\n\u00101\u001a\u000202X\u0002²\u0006\n\u0010/\u001a\u000200X\u0002²\u0006\n\u00103\u001a\u000204X\u0002²\u0006\n\u00105\u001a\u000206X\u0002²\u0006\n\u00107\u001a\u000208X\u0002²\u0006\n\u00109\u001a\u00020:X\u0002²\u0006\n\u0010;\u001a\u00020<X\u0002"}, d2 = {"Lcom/vungle/ads/internal/VungleInitializer;", "", "()V", "initRequestToResponseMetric", "Lcom/vungle/ads/TimeIntervalMetric;", "isInitialized", "", "isInitialized$vungle_ads_release$annotations", "isInitialized$vungle_ads_release", "()Z", "setInitialized$vungle_ads_release", "(Z)V", "isInitializing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isInitializing$vungle_ads_release$annotations", "isInitializing$vungle_ads_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setInitializing$vungle_ads_release", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "configure", "", "context", "Landroid/content/Context;", "callback", "Lcom/vungle/ads/InitializationListener;", "deInit", "deInit$vungle_ads_release", "downloadJs", "downloadListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "downloaded", "init", "appId", "", "initializationCallback", "isAppIdInvalid", "onInitError", "initCallback", "exception", "Lcom/vungle/ads/VungleError;", "onInitSuccess", "Companion", "vungle-ads_release", "platform", "Lcom/vungle/ads/internal/platform/Platform;", "sdkExecutors", "Lcom/vungle/ads/internal/executor/Executors;", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "filePreferences", "Lcom/vungle/ads/internal/persistence/FilePreferences;", "omInjector", "Lcom/vungle/ads/internal/omsdk/OMInjector;", "jobRunner", "Lcom/vungle/ads/internal/task/JobRunner;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "downloader", "Lcom/vungle/ads/internal/downloader/Downloader;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleInitializer.kt */
public final class VungleInitializer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "VungleInitializer";
    private TimeIntervalMetric initRequestToResponseMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.INIT_REQUEST_TO_RESPONSE_DURATION_MS);
    private boolean isInitialized;
    private AtomicBoolean isInitializing = new AtomicBoolean(false);

    public static /* synthetic */ void isInitialized$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void isInitializing$vungle_ads_release$annotations() {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/VungleInitializer$Companion;", "", "()V", "TAG", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VungleInitializer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean isInitialized$vungle_ads_release() {
        return this.isInitialized;
    }

    public final void setInitialized$vungle_ads_release(boolean z) {
        this.isInitialized = z;
    }

    public final AtomicBoolean isInitializing$vungle_ads_release() {
        return this.isInitializing;
    }

    public final void setInitializing$vungle_ads_release(AtomicBoolean atomicBoolean) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "<set-?>");
        this.isInitializing = atomicBoolean;
    }

    public final void init(String str, Context context, InitializationListener initializationListener) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(initializationListener, "initializationCallback");
        if (isAppIdInvalid(str)) {
            onInitError(initializationListener, new InvalidAppId().logError$vungle_ads_release());
            return;
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        if (!m2282init$lambda0(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInitializer$init$$inlined$inject$1(context))).isAtLeastMinimumSDK()) {
            Log.e(TAG, "SDK is supported only for API versions 21 and above");
            onInitError(initializationListener, new SdkVersionTooLow().logError$vungle_ads_release());
        } else if (isInitialized()) {
            Log.d(TAG, "init already complete");
            new SdkAlreadyInitialized().logErrorNoReturnValue$vungle_ads_release();
            onInitSuccess(initializationListener);
        } else if (this.isInitializing.getAndSet(true)) {
            Log.d(TAG, "init ongoing");
            onInitError(initializationListener, new SdkInitializationInProgress().logError$vungle_ads_release());
        } else if (PermissionChecker.checkCallingOrSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0 && PermissionChecker.checkCallingOrSelfPermission(context, "android.permission.INTERNET") == 0) {
            ServiceLocator.Companion companion2 = ServiceLocator.Companion;
            Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInitializer$init$$inlined$inject$2(context));
            ServiceLocator.Companion companion3 = ServiceLocator.Companion;
            m2283init$lambda1(lazy).getBackgroundExecutor().execute(new VungleInitializer$$ExternalSyntheticLambda1(context, str, this, initializationListener, LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInitializer$init$$inlined$inject$3(context))), new VungleInitializer$$ExternalSyntheticLambda2(this, initializationListener));
        } else {
            Log.e(TAG, "Network permissions not granted");
            onInitError(initializationListener, new NetworkPermissionsNotGranted());
        }
    }

    /* renamed from: init$lambda-0  reason: not valid java name */
    private static final Platform m2282init$lambda0(Lazy<? extends Platform> lazy) {
        return (Platform) lazy.getValue();
    }

    /* renamed from: init$lambda-1  reason: not valid java name */
    private static final Executors m2283init$lambda1(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    /* renamed from: init$lambda-2  reason: not valid java name */
    private static final VungleApiClient m2284init$lambda2(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-3  reason: not valid java name */
    public static final void m2285init$lambda3(Context context, String str, VungleInitializer vungleInitializer, InitializationListener initializationListener, Lazy lazy) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "$appId");
        Intrinsics.checkNotNullParameter(vungleInitializer, "this$0");
        Intrinsics.checkNotNullParameter(initializationListener, "$initializationCallback");
        Intrinsics.checkNotNullParameter(lazy, "$vungleApiClient$delegate");
        PrivacyManager.INSTANCE.init(context);
        m2284init$lambda2(lazy).initialize(str);
        vungleInitializer.configure(context, initializationListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: init$lambda-4  reason: not valid java name */
    public static final void m2286init$lambda4(VungleInitializer vungleInitializer, InitializationListener initializationListener) {
        Intrinsics.checkNotNullParameter(vungleInitializer, "this$0");
        Intrinsics.checkNotNullParameter(initializationListener, "$initializationCallback");
        vungleInitializer.onInitError(initializationListener, new OutOfMemory().logError$vungle_ads_release());
    }

    private final boolean isAppIdInvalid(String str) {
        return StringsKt.isBlank(str);
    }

    private final void configure(Context context, InitializationListener initializationListener) {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInitializer$configure$$inlined$inject$1(context));
        boolean z = true;
        try {
            this.initRequestToResponseMetric.markStart();
            Call<ConfigPayload> config = m2276configure$lambda5(lazy).config();
            Response<ConfigPayload> execute = config != null ? config.execute() : null;
            if (execute == null) {
                onInitError(initializationListener, new SdkNotInitialized().logError$vungle_ads_release());
            } else if (!execute.isSuccessful()) {
                onInitError(initializationListener, new ConfigurationError().logError$vungle_ads_release());
            } else {
                this.initRequestToResponseMetric.markEnd();
                ConfigPayload body = execute.body();
                if ((body != null ? body.getEndpoints() : null) == null) {
                    onInitError(initializationListener, new ConfigurationResponseError().logError$vungle_ads_release());
                    return;
                }
                ConfigManager.INSTANCE.initWithConfig(body);
                ServiceLocator.Companion companion2 = ServiceLocator.Companion;
                AnalyticsClient.INSTANCE.init$vungle_ads_release(m2276configure$lambda5(lazy), m2277configure$lambda6(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInitializer$configure$$inlined$inject$2(context))).getLoggerExecutor(), ConfigManager.INSTANCE.getLogLevel(), ConfigManager.INSTANCE.getMetricsEnabled());
                if (!ConfigManager.INSTANCE.validateEndpoints$vungle_ads_release()) {
                    onInitError(initializationListener, new ConfigurationError());
                    return;
                }
                ServiceLocator.Companion companion3 = ServiceLocator.Companion;
                Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInitializer$configure$$inlined$inject$3(context));
                String configExtension = body.getConfigExtension();
                CharSequence charSequence = configExtension;
                if (charSequence == null || charSequence.length() == 0) {
                    m2278configure$lambda7(lazy2).remove(Cookie.CONFIG_EXTENSION).apply();
                } else {
                    m2278configure$lambda7(lazy2).put(Cookie.CONFIG_EXTENSION, configExtension).apply();
                }
                if (ConfigManager.INSTANCE.omEnabled()) {
                    ServiceLocator.Companion companion4 = ServiceLocator.Companion;
                    m2279configure$lambda9(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInitializer$configure$$inlined$inject$4(context))).init();
                }
                if (ConfigManager.INSTANCE.placements() == null) {
                    onInitError(initializationListener, new ConfigurationError());
                    return;
                }
                PrivacyManager.INSTANCE.updateDisableAdId(ConfigManager.INSTANCE.shouldDisableAdId());
                ServiceLocator.Companion companion5 = ServiceLocator.Companion;
                Lazy lazy3 = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInitializer$configure$$inlined$inject$5(context));
                m2275configure$lambda10(lazy3).execute(CleanupJob.Companion.makeJobInfo$default(CleanupJob.Companion, (String) null, 1, (Object) null));
                m2275configure$lambda10(lazy3).execute(ResendTpatJob.Companion.makeJobInfo());
                downloadJs(context, new VungleInitializer$configure$2(this, initializationListener));
            }
        } catch (Throwable th) {
            this.isInitialized = false;
            Log.e(TAG, Log.getStackTraceString(th));
            if (!(th instanceof UnknownHostException)) {
                z = th instanceof SecurityException;
            }
            if (z) {
                onInitError(initializationListener, new NetworkUnreachable().logError$vungle_ads_release());
            } else if (th instanceof VungleError) {
                onInitError(initializationListener, th);
            } else {
                onInitError(initializationListener, new UnknownConfigurationError().logError$vungle_ads_release());
            }
        }
    }

    /* renamed from: configure$lambda-5  reason: not valid java name */
    private static final VungleApiClient m2276configure$lambda5(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    /* renamed from: configure$lambda-6  reason: not valid java name */
    private static final Executors m2277configure$lambda6(Lazy<? extends Executors> lazy) {
        return (Executors) lazy.getValue();
    }

    /* renamed from: configure$lambda-7  reason: not valid java name */
    private static final FilePreferences m2278configure$lambda7(Lazy<FilePreferences> lazy) {
        return lazy.getValue();
    }

    /* renamed from: configure$lambda-9  reason: not valid java name */
    private static final OMInjector m2279configure$lambda9(Lazy<OMInjector> lazy) {
        return lazy.getValue();
    }

    /* renamed from: configure$lambda-10  reason: not valid java name */
    private static final JobRunner m2275configure$lambda10(Lazy<? extends JobRunner> lazy) {
        return (JobRunner) lazy.getValue();
    }

    /* access modifiers changed from: private */
    public final void onInitError(InitializationListener initializationListener, VungleError vungleError) {
        this.isInitializing.set(false);
        ThreadUtil.INSTANCE.runOnUiThread(new VungleInitializer$$ExternalSyntheticLambda0(initializationListener, vungleError));
        String localizedMessage = vungleError.getLocalizedMessage();
        if (localizedMessage == null) {
            localizedMessage = "Exception code is " + vungleError.getCode();
        }
        Log.e(TAG, localizedMessage);
    }

    /* access modifiers changed from: private */
    /* renamed from: onInitError$lambda-11  reason: not valid java name */
    public static final void m2287onInitError$lambda11(InitializationListener initializationListener, VungleError vungleError) {
        Intrinsics.checkNotNullParameter(initializationListener, "$initCallback");
        Intrinsics.checkNotNullParameter(vungleError, "$exception");
        initializationListener.onError(vungleError);
    }

    /* access modifiers changed from: private */
    public final void onInitSuccess(InitializationListener initializationListener) {
        this.isInitializing.set(false);
        ThreadUtil.INSTANCE.runOnUiThread(new VungleInitializer$$ExternalSyntheticLambda3(initializationListener, this));
    }

    /* access modifiers changed from: private */
    /* renamed from: onInitSuccess$lambda-12  reason: not valid java name */
    public static final void m2288onInitSuccess$lambda12(InitializationListener initializationListener, VungleInitializer vungleInitializer) {
        Intrinsics.checkNotNullParameter(initializationListener, "$initCallback");
        Intrinsics.checkNotNullParameter(vungleInitializer, "this$0");
        initializationListener.onSuccess();
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, (Metric) vungleInitializer.initRequestToResponseMetric, (String) null, (String) null, (String) null, VungleApiClient.Companion.getBASE_URL$vungle_ads_release(), 14, (Object) null);
    }

    public final boolean isInitialized() {
        return this.isInitialized;
    }

    private final void downloadJs(Context context, Function1<? super Boolean, Unit> function1) {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInitializer$downloadJs$$inlined$inject$1(context));
        ServiceLocator.Companion companion2 = ServiceLocator.Companion;
        MraidJsLoader.INSTANCE.downloadJs(m2280downloadJs$lambda13(lazy), m2281downloadJs$lambda14(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new VungleInitializer$downloadJs$$inlined$inject$2(context))), new VungleInitializer$downloadJs$1(function1));
    }

    /* renamed from: downloadJs$lambda-13  reason: not valid java name */
    private static final PathProvider m2280downloadJs$lambda13(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    /* renamed from: downloadJs$lambda-14  reason: not valid java name */
    private static final Downloader m2281downloadJs$lambda14(Lazy<? extends Downloader> lazy) {
        return (Downloader) lazy.getValue();
    }

    public final void deInit$vungle_ads_release() {
        ServiceLocator.Companion.deInit();
        VungleApiClient.Companion.reset$vungle_ads_release();
        this.isInitialized = false;
        this.isInitializing.set(false);
    }
}
