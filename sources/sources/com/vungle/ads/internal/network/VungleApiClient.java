package com.vungle.ads.internal.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.security.NetworkSecurityPolicy;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.URLUtil;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.TimeIntervalMetric;
import com.vungle.ads.VungleAds;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.load.BaseAdLoader;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.AppNode;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.ConfigPayload;
import com.vungle.ads.internal.model.Cookie;
import com.vungle.ads.internal.model.DeviceNode;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.privacy.COPPA;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.util.FileUtility;
import java.io.IOException;
import java.lang.annotation.RetentionPolicy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;
import okio.Sink;

@Metadata(d1 = {"\u0000Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 j2\u00020\u0001:\u0003jklB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u001eH\u0007J\u0012\u00103\u001a\u00020\u00142\b\u00104\u001a\u0004\u0018\u000105H\u0002J\u000e\u00106\u001a\u00020\u001e2\u0006\u00107\u001a\u00020\u0014J\u000e\u00108\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000109J\u0010\u0010;\u001a\u00020<2\u0006\u00104\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020\u00162\u0006\u0010?\u001a\u00020\u0003H\u0002J\n\u0010@\u001a\u0004\u0018\u00010\u0014H\u0002J\n\u0010A\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020CH\u0002J\b\u0010D\u001a\u00020\u0016H\u0002J\u0015\u0010D\u001a\u00020\u00162\u0006\u0010E\u001a\u00020\u001eH\u0001¢\u0006\u0002\bFJ\n\u0010G\u001a\u0004\u0018\u00010HH\u0002J\u0012\u0010I\u001a\u00020\u00142\b\u0010J\u001a\u0004\u0018\u000105H\u0002J\u000f\u0010K\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010LJ\u000f\u0010M\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010LJ\u000e\u0010N\u001a\u00020)2\u0006\u00107\u001a\u00020\u0014J\b\u0010O\u001a\u00020PH\u0002J\b\u0010Q\u001a\u000201H\u0002J\u000e\u0010R\u001a\u0002012\u0006\u0010S\u001a\u00020\u0014J\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0002\u0010LJ\u0010\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020\u0014J\u001c\u0010W\u001a\u0002012\f\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0Y2\u0006\u0010[\u001a\u00020\\J\u001c\u0010]\u001a\u0002012\f\u0010^\u001a\b\u0012\u0004\u0012\u00020_0Y2\u0006\u0010[\u001a\u00020\\J(\u0010`\u001a\n\u0012\u0004\u0012\u00020a\u0018\u0001092\u0006\u0010b\u001a\u00020\u00142\b\u0010c\u001a\u0004\u0018\u00010\u00142\u0006\u0010d\u001a\u00020\u001eJ\u0006\u0010e\u001a\u00020fJ\u0016\u0010g\u001a\n\u0012\u0004\u0012\u00020h\u0018\u0001092\u0006\u00104\u001a\u00020iR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R&\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\n8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0004\n\u0002\u0010\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R$\u0010 \u001a\u00020!8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u000e\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R0\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020)0(8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b*\u0010\u000e\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0010\u0010/\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000¨\u0006m"}, d2 = {"Lcom/vungle/ads/internal/network/VungleApiClient;", "", "applicationContext", "Landroid/content/Context;", "platform", "Lcom/vungle/ads/internal/platform/Platform;", "filePreferences", "Lcom/vungle/ads/internal/persistence/FilePreferences;", "(Landroid/content/Context;Lcom/vungle/ads/internal/platform/Platform;Lcom/vungle/ads/internal/persistence/FilePreferences;)V", "api", "Lcom/vungle/ads/internal/network/VungleApi;", "appBody", "Lcom/vungle/ads/internal/model/AppNode;", "getAppBody$vungle_ads_release$annotations", "()V", "getAppBody$vungle_ads_release", "()Lcom/vungle/ads/internal/model/AppNode;", "setAppBody$vungle_ads_release", "(Lcom/vungle/ads/internal/model/AppNode;)V", "appSetId", "", "baseDeviceInfo", "Lcom/vungle/ads/internal/model/DeviceNode;", "gzipApi", "getGzipApi$vungle_ads_release$annotations", "getGzipApi$vungle_ads_release", "()Lcom/vungle/ads/internal/network/VungleApi;", "setGzipApi$vungle_ads_release", "(Lcom/vungle/ads/internal/network/VungleApi;)V", "isGooglePlayServicesAvailable", "", "Ljava/lang/Boolean;", "responseInterceptor", "Lokhttp3/Interceptor;", "getResponseInterceptor$vungle_ads_release$annotations", "getResponseInterceptor$vungle_ads_release", "()Lokhttp3/Interceptor;", "setResponseInterceptor$vungle_ads_release", "(Lokhttp3/Interceptor;)V", "retryAfterDataMap", "", "", "getRetryAfterDataMap$vungle_ads_release$annotations", "getRetryAfterDataMap$vungle_ads_release", "()Ljava/util/Map;", "setRetryAfterDataMap$vungle_ads_release", "(Ljava/util/Map;)V", "uaString", "addPlaySvcAvailabilityInCookie", "", "isPlaySvcAvailable", "bodyToString", "request", "Lokhttp3/RequestBody;", "checkIsRetryAfterActive", "placementID", "config", "Lcom/vungle/ads/internal/network/Call;", "Lcom/vungle/ads/internal/model/ConfigPayload;", "defaultErrorResponse", "Lokhttp3/Response;", "Lokhttp3/Request;", "getBasicDeviceBody", "context", "getConnectionType", "getConnectionTypeDetail", "type", "", "getDeviceBody", "explicitBlock", "getDeviceBody$vungle_ads_release", "getExtBody", "Lcom/vungle/ads/internal/model/CommonRequestBody$RequestExt;", "getPlacementID", "body", "getPlayServicesAvailabilityFromAPI", "()Ljava/lang/Boolean;", "getPlayServicesAvailabilityFromCookie", "getRetryAfterHeaderValue", "getUserBody", "Lcom/vungle/ads/internal/model/CommonRequestBody$User;", "initUserAgentLazy", "initialize", "appId", "pingTPAT", "Lcom/vungle/ads/internal/load/BaseAdLoader$ErrorInfo;", "url", "reportErrors", "errors", "Ljava/util/concurrent/BlockingQueue;", "Lcom/vungle/ads/internal/protos/Sdk$SDKError$Builder;", "requestListener", "Lcom/vungle/ads/AnalyticsClient$RequestListener;", "reportMetrics", "metrics", "Lcom/vungle/ads/internal/protos/Sdk$SDKMetric$Builder;", "requestAd", "Lcom/vungle/ads/internal/model/AdPayload;", "placement", "adSize", "isHeaderBiddingEnable", "requestBody", "Lcom/vungle/ads/internal/model/CommonRequestBody;", "ri", "Ljava/lang/Void;", "Lcom/vungle/ads/internal/model/CommonRequestBody$RequestParam;", "Companion", "ConnectionTypeDetail", "GzipRequestInterceptor", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleApiClient.kt */
public final class VungleApiClient {
    /* access modifiers changed from: private */
    public static final String BASE_URL = "https://config.ads.vungle.com/";
    public static final Companion Companion;
    private static final String MANUFACTURER_AMAZON = "Amazon";
    private static final String TAG = "VungleApiClient";
    /* access modifiers changed from: private */
    public static VungleAds.WrapperFramework WRAPPER_FRAMEWORK_SELECTED;
    /* access modifiers changed from: private */
    public static String headerUa;
    private static final Json json = JsonKt.Json$default((Json) null, VungleApiClient$Companion$json$1.INSTANCE, 1, (Object) null);
    private static final Set<Interceptor> logInterceptors = new HashSet();
    private static final Set<Interceptor> networkInterceptors = new HashSet();
    private VungleApi api;
    private AppNode appBody;
    private String appSetId = "";
    private final Context applicationContext;
    private DeviceNode baseDeviceInfo;
    private final FilePreferences filePreferences;
    private VungleApi gzipApi;
    private Boolean isGooglePlayServicesAvailable;
    private final Platform platform;
    private Interceptor responseInterceptor = new VungleApiClient$$ExternalSyntheticLambda0(this);
    private Map<String, Long> retryAfterDataMap = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public String uaString = System.getProperty("http.agent");

    public static /* synthetic */ void getAppBody$vungle_ads_release$annotations() {
    }

    private final String getConnectionTypeDetail(int i) {
        if (i == 0) {
            return "unknown";
        }
        if (i == 1) {
            return "gprs";
        }
        if (i == 2) {
            return "edge";
        }
        if (i == 20) {
            return "unknown";
        }
        switch (i) {
            case 4:
                return "wcdma";
            case 5:
                return "cdma_evdo_0";
            case 6:
                return "cdma_evdo_a";
            case 7:
                return "cdma_1xrtt";
            case 8:
                return "hsdpa";
            case 9:
                return "hsupa";
            default:
                switch (i) {
                    case 12:
                        return "cdma_evdo_b";
                    case 13:
                        return "LTE";
                    case 14:
                        return "hrpd";
                    default:
                        return "unknown";
                }
        }
    }

    public static /* synthetic */ void getGzipApi$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getResponseInterceptor$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getRetryAfterDataMap$vungle_ads_release$annotations() {
    }

    public VungleApiClient(Context context, Platform platform2, FilePreferences filePreferences2) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(platform2, "platform");
        Intrinsics.checkNotNullParameter(filePreferences2, "filePreferences");
        this.applicationContext = context;
        this.platform = platform2;
        this.filePreferences = filePreferences2;
        OkHttpClient.Builder proxySelector = new OkHttpClient.Builder().addInterceptor(this.responseInterceptor).proxySelector(new VungleApiClient$builder$1());
        OkHttpClient build = proxySelector.build();
        OkHttpClient build2 = proxySelector.addInterceptor(new GzipRequestInterceptor()).build();
        this.api = new VungleApiImpl(build);
        this.gzipApi = new VungleApiImpl(build2);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0002J\r\u0010\u001a\u001a\u00020\u001bH\u0000¢\u0006\u0002\b\u001cR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/vungle/ads/internal/network/VungleApiClient$Companion;", "", "()V", "BASE_URL", "", "getBASE_URL$vungle_ads_release", "()Ljava/lang/String;", "MANUFACTURER_AMAZON", "TAG", "WRAPPER_FRAMEWORK_SELECTED", "Lcom/vungle/ads/VungleAds$WrapperFramework;", "getWRAPPER_FRAMEWORK_SELECTED$vungle_ads_release", "()Lcom/vungle/ads/VungleAds$WrapperFramework;", "setWRAPPER_FRAMEWORK_SELECTED$vungle_ads_release", "(Lcom/vungle/ads/VungleAds$WrapperFramework;)V", "headerUa", "getHeaderUa", "setHeaderUa", "(Ljava/lang/String;)V", "json", "Lkotlinx/serialization/json/Json;", "logInterceptors", "", "Lokhttp3/Interceptor;", "networkInterceptors", "defaultHeader", "reset", "", "reset$vungle_ads_release", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VungleApiClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getBASE_URL$vungle_ads_release() {
            return VungleApiClient.BASE_URL;
        }

        public final VungleAds.WrapperFramework getWRAPPER_FRAMEWORK_SELECTED$vungle_ads_release() {
            return VungleApiClient.WRAPPER_FRAMEWORK_SELECTED;
        }

        public final void setWRAPPER_FRAMEWORK_SELECTED$vungle_ads_release(VungleAds.WrapperFramework wrapperFramework) {
            VungleApiClient.WRAPPER_FRAMEWORK_SELECTED = wrapperFramework;
        }

        public final String getHeaderUa() {
            return VungleApiClient.headerUa;
        }

        public final void setHeaderUa(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            VungleApiClient.headerUa = str;
        }

        /* access modifiers changed from: private */
        public final String defaultHeader() {
            return (Intrinsics.areEqual((Object) "Amazon", (Object) Build.MANUFACTURER) ? "VungleAmazon/" : "VungleDroid/").concat(BuildConfig.VERSION_NAME);
        }

        public final void reset$vungle_ads_release() {
            setWRAPPER_FRAMEWORK_SELECTED$vungle_ads_release((VungleAds.WrapperFramework) null);
            setHeaderUa(defaultHeader());
        }
    }

    static {
        Companion companion = new Companion((DefaultConstructorMarker) null);
        Companion = companion;
        headerUa = companion.defaultHeader();
    }

    public final VungleApi getGzipApi$vungle_ads_release() {
        return this.gzipApi;
    }

    public final void setGzipApi$vungle_ads_release(VungleApi vungleApi) {
        Intrinsics.checkNotNullParameter(vungleApi, "<set-?>");
        this.gzipApi = vungleApi;
    }

    public final AppNode getAppBody$vungle_ads_release() {
        return this.appBody;
    }

    public final void setAppBody$vungle_ads_release(AppNode appNode) {
        this.appBody = appNode;
    }

    public final Map<String, Long> getRetryAfterDataMap$vungle_ads_release() {
        return this.retryAfterDataMap;
    }

    public final void setRetryAfterDataMap$vungle_ads_release(Map<String, Long> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.retryAfterDataMap = map;
    }

    public final Interceptor getResponseInterceptor$vungle_ads_release() {
        return this.responseInterceptor;
    }

    public final void setResponseInterceptor$vungle_ads_release(Interceptor interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "<set-?>");
        this.responseInterceptor = interceptor;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        android.util.Log.d(TAG, "Retry-After value is not an valid value");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a6, code lost:
        r11 = com.vungle.ads.internal.util.Logger.Companion;
        r11.e(TAG, "OOM for " + r1.url());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return r10.defaultErrorResponse(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return r11;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:27:? A[ExcHandler: OutOfMemoryError (unused java.lang.OutOfMemoryError), SYNTHETIC, Splitter:B:1:0x0011] */
    /* renamed from: responseInterceptor$lambda-0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okhttp3.Response m2307responseInterceptor$lambda0(com.vungle.ads.internal.network.VungleApiClient r10, okhttp3.Interceptor.Chain r11) {
        /*
            java.lang.String r0 = "VungleApiClient"
            java.lang.String r1 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r1)
            java.lang.String r1 = "chain"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r1)
            okhttp3.Request r1 = r11.request()
            okhttp3.Response r11 = r11.proceed(r1)     // Catch:{ OutOfMemoryError -> 0x00a6, Exception -> 0x007d }
            okhttp3.Headers r2 = r11.headers()     // Catch:{ OutOfMemoryError -> 0x00a6, Exception -> 0x007d }
            java.lang.String r3 = "Retry-After"
            java.lang.String r2 = r2.get(r3)     // Catch:{ OutOfMemoryError -> 0x00a6, Exception -> 0x007d }
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ OutOfMemoryError -> 0x00a6, Exception -> 0x007d }
            r4 = 1
            r5 = 0
            if (r3 == 0) goto L_0x002f
            int r3 = r3.length()     // Catch:{ OutOfMemoryError -> 0x00a6, Exception -> 0x007d }
            if (r3 != 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r3 = 0
            goto L_0x0030
        L_0x002f:
            r3 = 1
        L_0x0030:
            if (r3 != 0) goto L_0x00c1
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            r6 = 0
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x00c1
            okhttp3.HttpUrl r6 = r1.url()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            java.lang.String r6 = r6.encodedPath()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            r7 = 1000(0x3e8, float:1.401E-42)
            long r7 = (long) r7     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            long r2 = r2 * r7
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            long r2 = r2 + r7
            java.lang.String r7 = "ads"
            r8 = 2
            r9 = 0
            boolean r6 = kotlin.text.StringsKt.endsWith$default(r6, r7, r5, r8, r9)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            if (r6 == 0) goto L_0x00c1
            okhttp3.RequestBody r6 = r1.body()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            java.lang.String r6 = r10.getPlacementID(r6)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            int r7 = r7.length()     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            if (r7 <= 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r4 = 0
        L_0x006b:
            if (r4 == 0) goto L_0x00c1
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            java.util.Map<java.lang.String, java.lang.Long> r3 = r10.retryAfterDataMap     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            r3.put(r6, r2)     // Catch:{ Exception -> 0x0077, OutOfMemoryError -> 0x00a6 }
            goto L_0x00c1
        L_0x0077:
            java.lang.String r2 = "Retry-After value is not an valid value"
            android.util.Log.d(r0, r2)     // Catch:{ OutOfMemoryError -> 0x00a6, Exception -> 0x007d }
            goto L_0x00c1
        L_0x007d:
            r11 = move-exception
            com.vungle.ads.internal.util.Logger$Companion r2 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "Exception: "
            r3.<init>(r4)
            java.lang.String r11 = r11.getMessage()
            r3.append(r11)
            java.lang.String r11 = " for "
            r3.append(r11)
            okhttp3.HttpUrl r11 = r1.url()
            r3.append(r11)
            java.lang.String r11 = r3.toString()
            r2.e(r0, r11)
            okhttp3.Response r11 = r10.defaultErrorResponse(r1)
            goto L_0x00c1
        L_0x00a6:
            com.vungle.ads.internal.util.Logger$Companion r11 = com.vungle.ads.internal.util.Logger.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "OOM for "
            r2.<init>(r3)
            okhttp3.HttpUrl r3 = r1.url()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r11.e(r0, r2)
            okhttp3.Response r11 = r10.defaultErrorResponse(r1)
        L_0x00c1:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.VungleApiClient.m2307responseInterceptor$lambda0(com.vungle.ads.internal.network.VungleApiClient, okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private final Response defaultErrorResponse(Request request) {
        return new Response.Builder().request(request).code(500).protocol(Protocol.HTTP_1_1).message("Server is busy").body(ResponseBody.Companion.create("{\"Error\":\"Server is busy\"}", MediaType.Companion.parse("application/json; charset=utf-8"))).build();
    }

    private final String getPlacementID(RequestBody requestBody) {
        List<String> placements;
        String str;
        try {
            StringFormat stringFormat = json;
            String bodyToString = bodyToString(requestBody);
            KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(CommonRequestBody.class));
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            CommonRequestBody.RequestParam request = ((CommonRequestBody) stringFormat.decodeFromString(serializer, bodyToString)).getRequest();
            if (request == null || (placements = request.getPlacements()) == null || (str = placements.get(0)) == null) {
                return "";
            }
            return str;
        } catch (Exception unused) {
            return "";
        }
    }

    private final String bodyToString(RequestBody requestBody) {
        try {
            Buffer buffer = new Buffer();
            if (requestBody == null) {
                return "";
            }
            requestBody.writeTo(buffer);
            return buffer.readUtf8();
        } catch (Exception unused) {
            return "";
        }
    }

    public final boolean checkIsRetryAfterActive(String str) {
        Intrinsics.checkNotNullParameter(str, "placementID");
        Long l = this.retryAfterDataMap.get(str);
        if ((l != null ? l.longValue() : 0) > System.currentTimeMillis()) {
            return true;
        }
        this.retryAfterDataMap.remove(str);
        return false;
    }

    public final long getRetryAfterHeaderValue(String str) {
        Intrinsics.checkNotNullParameter(str, "placementID");
        Long l = this.retryAfterDataMap.get(str);
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lcom/vungle/ads/internal/network/VungleApiClient$GzipRequestInterceptor;", "Lokhttp3/Interceptor;", "()V", "gzip", "Lokhttp3/RequestBody;", "requestBody", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VungleApiClient.kt */
    public static final class GzipRequestInterceptor implements Interceptor {
        private static final String CONTENT_ENCODING = "Content-Encoding";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final String GZIP = "gzip";

        public Response intercept(Interceptor.Chain chain) throws IOException {
            Intrinsics.checkNotNullParameter(chain, "chain");
            Request request = chain.request();
            RequestBody body = request.body();
            if (body == null || request.header("Content-Encoding") != null) {
                return chain.proceed(request);
            }
            return chain.proceed(request.newBuilder().header("Content-Encoding", GZIP).method(request.method(), gzip(body)).build());
        }

        private final RequestBody gzip(RequestBody requestBody) throws IOException {
            Buffer buffer = new Buffer();
            BufferedSink buffer2 = Okio.buffer((Sink) new GzipSink(buffer));
            requestBody.writeTo(buffer2);
            buffer2.close();
            return new VungleApiClient$GzipRequestInterceptor$gzip$1(requestBody, buffer);
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/network/VungleApiClient$GzipRequestInterceptor$Companion;", "", "()V", "CONTENT_ENCODING", "", "GZIP", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: VungleApiClient.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:1|2|3|4|5|(1:7)(1:8)|9|10|11|12|13) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0054 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void initialize(java.lang.String r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "appId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)     // Catch:{ all -> 0x0076 }
            com.vungle.ads.internal.network.VungleApi r0 = r5.api     // Catch:{ all -> 0x0076 }
            r0.setAppId(r6)     // Catch:{ all -> 0x0076 }
            com.vungle.ads.internal.network.VungleApi r0 = r5.gzipApi     // Catch:{ all -> 0x0076 }
            r0.setAppId(r6)     // Catch:{ all -> 0x0076 }
            java.lang.String r0 = "1.0"
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0054 }
            r2 = 33
            if (r1 < r2) goto L_0x0035
            android.content.Context r1 = r5.applicationContext     // Catch:{ Exception -> 0x0054 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ Exception -> 0x0054 }
            android.content.Context r2 = r5.applicationContext     // Catch:{ Exception -> 0x0054 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0054 }
            r3 = 0
            android.content.pm.PackageManager$PackageInfoFlags r3 = android.content.pm.PackageManager.PackageInfoFlags.of(r3)     // Catch:{ Exception -> 0x0054 }
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r3)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r2 = "{\n                    ap…      )\n                }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Exception -> 0x0054 }
            goto L_0x004c
        L_0x0035:
            android.content.Context r1 = r5.applicationContext     // Catch:{ Exception -> 0x0054 }
            android.content.pm.PackageManager r1 = r1.getPackageManager()     // Catch:{ Exception -> 0x0054 }
            android.content.Context r2 = r5.applicationContext     // Catch:{ Exception -> 0x0054 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ Exception -> 0x0054 }
            r3 = 0
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r2, r3)     // Catch:{ Exception -> 0x0054 }
            java.lang.String r2 = "{\n                    ap…      )\n                }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Exception -> 0x0054 }
        L_0x004c:
            java.lang.String r1 = r1.versionName     // Catch:{ Exception -> 0x0054 }
            java.lang.String r2 = "packageInfo.versionName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ Exception -> 0x0054 }
            r0 = r1
        L_0x0054:
            android.content.Context r1 = r5.applicationContext     // Catch:{ all -> 0x0076 }
            com.vungle.ads.internal.model.DeviceNode r1 = r5.getBasicDeviceBody(r1)     // Catch:{ all -> 0x0076 }
            r5.baseDeviceInfo = r1     // Catch:{ all -> 0x0076 }
            com.vungle.ads.internal.model.AppNode r1 = new com.vungle.ads.internal.model.AppNode     // Catch:{ all -> 0x0076 }
            android.content.Context r2 = r5.applicationContext     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = "applicationContext.packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ all -> 0x0076 }
            r1.<init>(r2, r0, r6)     // Catch:{ all -> 0x0076 }
            r5.appBody = r1     // Catch:{ all -> 0x0076 }
            java.lang.Boolean r6 = r5.getPlayServicesAvailabilityFromAPI()     // Catch:{ all -> 0x0076 }
            r5.isGooglePlayServicesAvailable = r6     // Catch:{ all -> 0x0076 }
            monitor-exit(r5)
            return
        L_0x0076:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.VungleApiClient.initialize(java.lang.String):void");
    }

    public final Call<ConfigPayload> config() throws IOException {
        AppNode appNode = this.appBody;
        if (appNode == null) {
            return null;
        }
        CommonRequestBody commonRequestBody = new CommonRequestBody(getDeviceBody$vungle_ads_release(true), appNode, getUserBody(), (CommonRequestBody.RequestExt) null, (CommonRequestBody.RequestParam) null, 24, (DefaultConstructorMarker) null);
        CommonRequestBody.RequestExt extBody = getExtBody();
        if (extBody != null) {
            commonRequestBody.setExt(extBody);
        }
        FileUtility fileUtility = FileUtility.INSTANCE;
        String str = BASE_URL;
        if (!fileUtility.isValidUrl(str)) {
            str = "https://config.ads.vungle.com/";
        }
        if (!StringsKt.endsWith$default(str, "/", false, 2, (Object) null)) {
            str = str + '/';
        }
        return this.api.config(headerUa, str + "config", commonRequestBody);
    }

    public final Call<AdPayload> requestAd(String str, String str2, boolean z) throws IllegalStateException {
        String str3 = str2;
        Intrinsics.checkNotNullParameter(str, "placement");
        String adsEndpoint = ConfigManager.INSTANCE.getAdsEndpoint();
        CharSequence charSequence = adsEndpoint;
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        CommonRequestBody requestBody = requestBody();
        CommonRequestBody.RequestParam requestParam = r6;
        CommonRequestBody.RequestParam requestParam2 = new CommonRequestBody.RequestParam(CollectionsKt.listOf(str), Boolean.valueOf(z), (String) null, (Long) null, (String) null, (String) null, (String) null, 124, (DefaultConstructorMarker) null);
        CharSequence charSequence2 = str3;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            requestParam.setAdSize(str3);
        }
        requestBody.setRequest(requestParam);
        return this.gzipApi.ads(headerUa, adsEndpoint, requestBody);
    }

    public final Call<Void> ri(CommonRequestBody.RequestParam requestParam) {
        AppNode appNode;
        Intrinsics.checkNotNullParameter(requestParam, "request");
        String riEndpoint = ConfigManager.INSTANCE.getRiEndpoint();
        CharSequence charSequence = riEndpoint;
        if ((charSequence == null || charSequence.length() == 0) || (appNode = this.appBody) == null) {
            return null;
        }
        CommonRequestBody commonRequestBody = new CommonRequestBody(getDeviceBody(), appNode, getUserBody(), (CommonRequestBody.RequestExt) null, (CommonRequestBody.RequestParam) null, 24, (DefaultConstructorMarker) null);
        commonRequestBody.setRequest(requestParam);
        CommonRequestBody.RequestExt extBody = getExtBody();
        if (extBody != null) {
            commonRequestBody.setExt(extBody);
        }
        return this.api.ri(headerUa, riEndpoint, commonRequestBody);
    }

    public final BaseAdLoader.ErrorInfo pingTPAT(String str) {
        boolean z;
        Response raw;
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "url");
        if ((str2.length() == 0) || HttpUrl.Companion.parse(str2) == null) {
            return new BaseAdLoader.ErrorInfo(121, "Invalid URL : " + str2, (String) null, true, 4, (DefaultConstructorMarker) null);
        }
        try {
            String host = new URL(str2).getHost();
            if (Build.VERSION.SDK_INT >= 24) {
                z = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(host);
            } else {
                z = Build.VERSION.SDK_INT >= 23 ? NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted() : true;
            }
            if (!z && URLUtil.isHttpUrl(str)) {
                return new BaseAdLoader.ErrorInfo(121, "Clear Text Traffic is blocked", (String) null, false, 12, (DefaultConstructorMarker) null);
            }
            try {
                String str3 = this.uaString;
                if (str3 == null) {
                    str3 = "";
                }
                Response<Void> execute = this.api.pingTPAT(str3, str2).execute();
                Integer num = null;
                if (execute != null) {
                    if (execute.isSuccessful()) {
                        return null;
                    }
                }
                if (!(execute == null || (raw = execute.raw()) == null)) {
                    num = Integer.valueOf(raw.code());
                }
                if (!CollectionsKt.contains(CollectionsKt.listOf(301, 302, 307, 308), num)) {
                    return new BaseAdLoader.ErrorInfo(121, "Tpat ping was not successful", (String) null, false, 12, (DefaultConstructorMarker) null);
                }
                return new BaseAdLoader.ErrorInfo(29, "Tpat ping was redirected with code " + num, (String) null, false, 12, (DefaultConstructorMarker) null);
            } catch (Exception e) {
                String localizedMessage = e.getLocalizedMessage();
                if (localizedMessage == null) {
                    localizedMessage = "IOException";
                }
                return new BaseAdLoader.ErrorInfo(121, localizedMessage, (String) null, false, 12, (DefaultConstructorMarker) null);
            }
        } catch (MalformedURLException e2) {
            String localizedMessage2 = e2.getLocalizedMessage();
            if (localizedMessage2 == null) {
                localizedMessage2 = "MalformedURLException";
            }
            return new BaseAdLoader.ErrorInfo(121, localizedMessage2, (String) null, true, 4, (DefaultConstructorMarker) null);
        }
    }

    public final void reportMetrics(BlockingQueue<Sdk.SDKMetric.Builder> blockingQueue, AnalyticsClient.RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(blockingQueue, "metrics");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        String metricsEndpoint = ConfigManager.INSTANCE.getMetricsEndpoint();
        CharSequence charSequence = metricsEndpoint;
        if (charSequence == null || charSequence.length() == 0) {
            requestListener.onFailure();
            return;
        }
        for (Sdk.SDKMetric.Builder builder : blockingQueue) {
            String connectionType = getConnectionType();
            if (connectionType != null) {
                builder.setConnectionType(connectionType);
            }
            String connectionTypeDetail = getConnectionTypeDetail();
            if (connectionTypeDetail != null) {
                builder.setConnectionTypeDetail(connectionTypeDetail);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Sdk.SDKMetric.Builder build : blockingQueue) {
            arrayList.add(build.build());
        }
        RequestBody.Companion companion = RequestBody.Companion;
        MediaType parse = MediaType.Companion.parse("application/x-protobuf");
        byte[] byteArray = ((Sdk.MetricBatch) Sdk.MetricBatch.newBuilder().addAllMetrics(arrayList).build()).toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "batch.toByteArray()");
        this.api.sendMetrics(headerUa, metricsEndpoint, RequestBody.Companion.create$default(companion, parse, byteArray, 0, 0, 12, (Object) null)).enqueue(new VungleApiClient$reportMetrics$3(requestListener));
    }

    public final void reportErrors(BlockingQueue<Sdk.SDKError.Builder> blockingQueue, AnalyticsClient.RequestListener requestListener) {
        Intrinsics.checkNotNullParameter(blockingQueue, "errors");
        Intrinsics.checkNotNullParameter(requestListener, "requestListener");
        String errorLoggingEndpoint = ConfigManager.INSTANCE.getErrorLoggingEndpoint();
        CharSequence charSequence = errorLoggingEndpoint;
        if (charSequence == null || charSequence.length() == 0) {
            requestListener.onFailure();
            return;
        }
        for (Sdk.SDKError.Builder builder : blockingQueue) {
            String connectionType = getConnectionType();
            if (connectionType != null) {
                builder.setConnectionType(connectionType);
            }
            String connectionTypeDetail = getConnectionTypeDetail();
            if (connectionTypeDetail != null) {
                builder.setConnectionTypeDetail(connectionTypeDetail);
                builder.setConnectionTypeDetailAndroid(connectionTypeDetail);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Sdk.SDKError.Builder build : blockingQueue) {
            arrayList.add(build.build());
        }
        Sdk.SDKErrorBatch sDKErrorBatch = (Sdk.SDKErrorBatch) Sdk.SDKErrorBatch.newBuilder().addAllErrors(arrayList).build();
        RequestBody.Companion companion = RequestBody.Companion;
        byte[] byteArray = sDKErrorBatch.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "batch.toByteArray()");
        this.api.sendErrors(headerUa, errorLoggingEndpoint, companion.create(byteArray, MediaType.Companion.parse("application/x-protobuf"), 0, sDKErrorBatch.toByteArray().length)).enqueue(new VungleApiClient$reportErrors$3(requestListener));
    }

    private final void initUserAgentLazy() {
        TimeIntervalMetric timeIntervalMetric = new TimeIntervalMetric(Sdk.SDKMetric.SDKMetricType.USER_AGENT_LOAD_DURATION_MS);
        timeIntervalMetric.markStart();
        this.platform.getUserAgentLazy(new VungleApiClient$initUserAgentLazy$1(timeIntervalMetric, this));
    }

    public final void addPlaySvcAvailabilityInCookie(boolean z) {
        this.filePreferences.put(Cookie.IS_PLAY_SERVICE_AVAILABLE, z).apply();
    }

    public final Boolean getPlayServicesAvailabilityFromCookie() {
        return this.filePreferences.getBoolean(Cookie.IS_PLAY_SERVICE_AVAILABLE);
    }

    public final Boolean getPlayServicesAvailabilityFromAPI() {
        try {
            GoogleApiAvailabilityLight instance = GoogleApiAvailabilityLight.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
            Boolean valueOf = Boolean.valueOf(instance.isGooglePlayServicesAvailable(this.applicationContext) == 0);
            addPlaySvcAvailabilityInCookie(valueOf.booleanValue());
            return valueOf;
        } catch (NoClassDefFoundError unused) {
            Log.w(TAG, "Play services Not available");
            Boolean bool = false;
            try {
                addPlaySvcAvailabilityInCookie(bool.booleanValue());
                return bool;
            } catch (Exception unused2) {
                Log.w(TAG, "Failure to write GPS availability to DB");
                return bool;
            }
        } catch (Exception unused3) {
            Log.w(TAG, "Unexpected exception from Play services lib.");
            return null;
        }
    }

    private final DeviceNode getBasicDeviceBody(Context context) {
        Context context2 = context;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context2.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
        }
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        String str2 = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str2, "MODEL");
        String str3 = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str3, "RELEASE");
        Object systemService2 = context2.getSystemService("phone");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        DeviceNode deviceNode = new DeviceNode(str, str2, str3, ((TelephonyManager) systemService2).getNetworkOperatorName(), Intrinsics.areEqual((Object) "Amazon", (Object) Build.MANUFACTURER) ? "amazon" : "android", displayMetrics.widthPixels, displayMetrics.heightPixels, this.uaString, (String) null, (Integer) null, (DeviceNode.DeviceExt) null, 1792, (DefaultConstructorMarker) null);
        try {
            String userAgent = this.platform.getUserAgent();
            this.uaString = userAgent;
            deviceNode.setUa(userAgent);
            initUserAgentLazy();
        } catch (Exception e) {
            Log.e(TAG, "Cannot Get UserAgent. Setting Default Device UserAgent." + e.getLocalizedMessage());
        }
        return deviceNode;
    }

    public final CommonRequestBody requestBody() throws IllegalStateException {
        CommonRequestBody commonRequestBody = new CommonRequestBody(getDeviceBody(), this.appBody, getUserBody(), (CommonRequestBody.RequestExt) null, (CommonRequestBody.RequestParam) null, 24, (DefaultConstructorMarker) null);
        CommonRequestBody.RequestExt extBody = getExtBody();
        if (extBody != null) {
            commonRequestBody.setExt(extBody);
        }
        return commonRequestBody;
    }

    private final DeviceNode getDeviceBody() throws IllegalStateException {
        return getDeviceBody$vungle_ads_release(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01df, code lost:
        if (r14.applicationContext.getPackageManager().hasSystemFeature("android.hardware.touchscreen") != false) goto L_0x01c3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x020e  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0214  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0199  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.vungle.ads.internal.model.DeviceNode getDeviceBody$vungle_ads_release(boolean r15) throws java.lang.IllegalStateException {
        /*
            r14 = this;
            monitor-enter(r14)
            com.vungle.ads.internal.model.DeviceNode r0 = r14.baseDeviceInfo     // Catch:{ all -> 0x0223 }
            if (r0 != 0) goto L_0x000d
            android.content.Context r0 = r14.applicationContext     // Catch:{ all -> 0x0223 }
            com.vungle.ads.internal.model.DeviceNode r0 = r14.getBasicDeviceBody(r0)     // Catch:{ all -> 0x0223 }
            r14.baseDeviceInfo = r0     // Catch:{ all -> 0x0223 }
        L_0x000d:
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 2047(0x7ff, float:2.868E-42)
            r13 = 0
            com.vungle.ads.internal.model.DeviceNode r0 = com.vungle.ads.internal.model.DeviceNode.copy$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0223 }
            com.vungle.ads.internal.model.DeviceNode$AndroidAmazonExt r1 = new com.vungle.ads.internal.model.DeviceNode$AndroidAmazonExt     // Catch:{ all -> 0x0223 }
            r2 = 3
            r3 = 0
            r1.<init>(r3, r3, r2, r3)     // Catch:{ all -> 0x0223 }
            com.vungle.ads.internal.platform.Platform r2 = r14.platform     // Catch:{ all -> 0x0223 }
            com.vungle.ads.internal.model.AdvertisingInfo r2 = r2.getAdvertisingInfo()     // Catch:{ all -> 0x0223 }
            if (r2 == 0) goto L_0x0033
            java.lang.String r4 = r2.getAdvertisingId()     // Catch:{ all -> 0x0223 }
            goto L_0x0034
        L_0x0033:
            r4 = r3
        L_0x0034:
            if (r2 == 0) goto L_0x003f
            boolean r2 = r2.getLimitAdTracking()     // Catch:{ all -> 0x0223 }
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0223 }
            goto L_0x0040
        L_0x003f:
            r2 = r3
        L_0x0040:
            com.vungle.ads.internal.privacy.PrivacyManager r5 = com.vungle.ads.internal.privacy.PrivacyManager.INSTANCE     // Catch:{ all -> 0x0223 }
            boolean r5 = r5.shouldSendAdIds()     // Catch:{ all -> 0x0223 }
            if (r5 == 0) goto L_0x0073
            if (r4 == 0) goto L_0x005f
            java.lang.String r5 = "Amazon"
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0223 }
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x0223 }
            if (r5 == 0) goto L_0x0058
            r1.setAmazonAdvertisingId(r4)     // Catch:{ all -> 0x0223 }
            goto L_0x005b
        L_0x0058:
            r1.setGaid(r4)     // Catch:{ all -> 0x0223 }
        L_0x005b:
            r0.setIfa(r4)     // Catch:{ all -> 0x0223 }
            goto L_0x0073
        L_0x005f:
            com.vungle.ads.internal.platform.Platform r4 = r14.platform     // Catch:{ all -> 0x0223 }
            java.lang.String r4 = r4.getAndroidId()     // Catch:{ all -> 0x0223 }
            if (r4 != 0) goto L_0x006a
            java.lang.String r5 = ""
            goto L_0x006b
        L_0x006a:
            r5 = r4
        L_0x006b:
            r0.setIfa(r5)     // Catch:{ all -> 0x0223 }
            if (r4 == 0) goto L_0x0073
            r1.setAndroidId(r4)     // Catch:{ all -> 0x0223 }
        L_0x0073:
            com.vungle.ads.internal.privacy.PrivacyManager r4 = com.vungle.ads.internal.privacy.PrivacyManager.INSTANCE     // Catch:{ all -> 0x0223 }
            boolean r4 = r4.shouldSendAdIds()     // Catch:{ all -> 0x0223 }
            if (r4 == 0) goto L_0x007d
            if (r15 == 0) goto L_0x0089
        L_0x007d:
            r0.setIfa(r3)     // Catch:{ all -> 0x0223 }
            r1.setAndroidId(r3)     // Catch:{ all -> 0x0223 }
            r1.setGaid(r3)     // Catch:{ all -> 0x0223 }
            r1.setAmazonAdvertisingId(r3)     // Catch:{ all -> 0x0223 }
        L_0x0089:
            r15 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r15)     // Catch:{ all -> 0x0223 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x0223 }
            r4 = 0
            if (r2 == 0) goto L_0x009a
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)     // Catch:{ all -> 0x0223 }
            goto L_0x009e
        L_0x009a:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0223 }
        L_0x009e:
            r0.setLmt(r2)     // Catch:{ all -> 0x0223 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0223 }
            java.lang.Boolean r5 = r14.isGooglePlayServicesAvailable()     // Catch:{ all -> 0x0223 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r5)     // Catch:{ all -> 0x0223 }
            r1.setGooglePlayServicesAvailable(r2)     // Catch:{ all -> 0x0223 }
            com.vungle.ads.internal.platform.Platform r2 = r14.platform     // Catch:{ all -> 0x0223 }
            java.lang.String r2 = r2.getAppSetId()     // Catch:{ all -> 0x0223 }
            r14.appSetId = r2     // Catch:{ all -> 0x0223 }
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ all -> 0x0223 }
            if (r2 == 0) goto L_0x00c3
            int r2 = r2.length()     // Catch:{ all -> 0x0223 }
            if (r2 != 0) goto L_0x00c1
            goto L_0x00c3
        L_0x00c1:
            r2 = 0
            goto L_0x00c4
        L_0x00c3:
            r2 = 1
        L_0x00c4:
            if (r2 != 0) goto L_0x00cb
            java.lang.String r2 = r14.appSetId     // Catch:{ all -> 0x0223 }
            r1.setAppSetId(r2)     // Catch:{ all -> 0x0223 }
        L_0x00cb:
            android.content.Context r2 = r14.applicationContext     // Catch:{ all -> 0x0223 }
            android.content.IntentFilter r5 = new android.content.IntentFilter     // Catch:{ all -> 0x0223 }
            java.lang.String r6 = "android.intent.action.BATTERY_CHANGED"
            r5.<init>(r6)     // Catch:{ all -> 0x0223 }
            android.content.Intent r2 = r2.registerReceiver(r3, r5)     // Catch:{ all -> 0x0223 }
            r5 = 4
            r6 = 2
            if (r2 == 0) goto L_0x011f
            java.lang.String r7 = "level"
            r8 = -1
            int r7 = r2.getIntExtra(r7, r8)     // Catch:{ all -> 0x0223 }
            java.lang.String r9 = "scale"
            int r9 = r2.getIntExtra(r9, r8)     // Catch:{ all -> 0x0223 }
            if (r7 <= 0) goto L_0x00f3
            if (r9 <= 0) goto L_0x00f3
            float r7 = (float) r7     // Catch:{ all -> 0x0223 }
            float r9 = (float) r9     // Catch:{ all -> 0x0223 }
            float r7 = r7 / r9
            r1.setBatteryLevel(r7)     // Catch:{ all -> 0x0223 }
        L_0x00f3:
            java.lang.String r7 = "status"
            int r7 = r2.getIntExtra(r7, r8)     // Catch:{ all -> 0x0223 }
            if (r7 == r8) goto L_0x011c
            if (r7 == r6) goto L_0x0104
            r9 = 5
            if (r7 == r9) goto L_0x0104
            java.lang.String r2 = "NOT_CHARGING"
            goto L_0x0121
        L_0x0104:
            java.lang.String r7 = "plugged"
            int r2 = r2.getIntExtra(r7, r8)     // Catch:{ all -> 0x0223 }
            if (r2 == r15) goto L_0x0119
            if (r2 == r6) goto L_0x0116
            if (r2 == r5) goto L_0x0113
            java.lang.String r2 = "BATTERY_PLUGGED_OTHERS"
            goto L_0x0121
        L_0x0113:
            java.lang.String r2 = "BATTERY_PLUGGED_WIRELESS"
            goto L_0x0121
        L_0x0116:
            java.lang.String r2 = "BATTERY_PLUGGED_USB"
            goto L_0x0121
        L_0x0119:
            java.lang.String r2 = "BATTERY_PLUGGED_AC"
            goto L_0x0121
        L_0x011c:
            java.lang.String r2 = "UNKNOWN"
            goto L_0x0121
        L_0x011f:
            java.lang.String r2 = "UNKNOWN"
        L_0x0121:
            r1.setBatteryState(r2)     // Catch:{ all -> 0x0223 }
            android.content.Context r2 = r14.applicationContext     // Catch:{ all -> 0x0223 }
            java.lang.String r7 = "power"
            java.lang.Object r2 = r2.getSystemService(r7)     // Catch:{ all -> 0x0223 }
            java.lang.String r7 = "null cannot be cast to non-null type android.os.PowerManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r7)     // Catch:{ all -> 0x0223 }
            android.os.PowerManager r2 = (android.os.PowerManager) r2     // Catch:{ all -> 0x0223 }
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0223 }
            r8 = 21
            if (r7 < r8) goto L_0x0141
            boolean r2 = r2.isPowerSaveMode()     // Catch:{ all -> 0x0223 }
            if (r2 == 0) goto L_0x0141
            r2 = 1
            goto L_0x0142
        L_0x0141:
            r2 = 0
        L_0x0142:
            r1.setBatterySaverEnabled(r2)     // Catch:{ all -> 0x0223 }
            java.lang.String r2 = r14.getConnectionType()     // Catch:{ all -> 0x0223 }
            if (r2 == 0) goto L_0x014e
            r1.setConnectionType(r2)     // Catch:{ all -> 0x0223 }
        L_0x014e:
            java.lang.String r2 = r14.getConnectionTypeDetail()     // Catch:{ all -> 0x0223 }
            if (r2 == 0) goto L_0x0157
            r1.setConnectionTypeDetail(r2)     // Catch:{ all -> 0x0223 }
        L_0x0157:
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0223 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0223 }
            r1.setLocale(r2)     // Catch:{ all -> 0x0223 }
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ all -> 0x0223 }
            java.lang.String r2 = r2.getLanguage()     // Catch:{ all -> 0x0223 }
            r1.setLanguage(r2)     // Catch:{ all -> 0x0223 }
            java.util.TimeZone r2 = java.util.TimeZone.getDefault()     // Catch:{ all -> 0x0223 }
            java.lang.String r2 = r2.getID()     // Catch:{ all -> 0x0223 }
            r1.setTimeZone(r2)     // Catch:{ all -> 0x0223 }
            com.vungle.ads.internal.platform.Platform r2 = r14.platform     // Catch:{ all -> 0x0223 }
            float r2 = r2.getVolumeLevel()     // Catch:{ all -> 0x0223 }
            r1.setVolumeLevel(r2)     // Catch:{ all -> 0x0223 }
            com.vungle.ads.internal.platform.Platform r2 = r14.platform     // Catch:{ all -> 0x0223 }
            boolean r2 = r2.isSoundEnabled()     // Catch:{ all -> 0x0223 }
            if (r2 == 0) goto L_0x018b
            r2 = 1
            goto L_0x018c
        L_0x018b:
            r2 = 0
        L_0x018c:
            r1.setSoundEnabled(r2)     // Catch:{ all -> 0x0223 }
            java.lang.String r2 = "Amazon"
            java.lang.String r7 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0223 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r7)     // Catch:{ all -> 0x0223 }
            if (r2 == 0) goto L_0x01a6
            android.content.Context r2 = r14.applicationContext     // Catch:{ all -> 0x0223 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ all -> 0x0223 }
            java.lang.String r5 = "amazon.hardware.fire_tv"
            boolean r2 = r2.hasSystemFeature(r5)     // Catch:{ all -> 0x0223 }
            goto L_0x01e2
        L_0x01a6:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0223 }
            r7 = 23
            if (r2 < r7) goto L_0x01c5
            android.content.Context r2 = r14.applicationContext     // Catch:{ all -> 0x0223 }
            java.lang.String r7 = "uimode"
            java.lang.Object r2 = r2.getSystemService(r7)     // Catch:{ all -> 0x0223 }
            java.lang.String r7 = "null cannot be cast to non-null type android.app.UiModeManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2, r7)     // Catch:{ all -> 0x0223 }
            android.app.UiModeManager r2 = (android.app.UiModeManager) r2     // Catch:{ all -> 0x0223 }
            int r2 = r2.getCurrentModeType()     // Catch:{ all -> 0x0223 }
            if (r2 != r5) goto L_0x01c3
            goto L_0x01e1
        L_0x01c3:
            r2 = 0
            goto L_0x01e2
        L_0x01c5:
            android.content.Context r2 = r14.applicationContext     // Catch:{ all -> 0x0223 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ all -> 0x0223 }
            java.lang.String r5 = "com.google.android.tv"
            boolean r2 = r2.hasSystemFeature(r5)     // Catch:{ all -> 0x0223 }
            if (r2 != 0) goto L_0x01e1
            android.content.Context r2 = r14.applicationContext     // Catch:{ all -> 0x0223 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ all -> 0x0223 }
            java.lang.String r5 = "android.hardware.touchscreen"
            boolean r2 = r2.hasSystemFeature(r5)     // Catch:{ all -> 0x0223 }
            if (r2 != 0) goto L_0x01c3
        L_0x01e1:
            r2 = 1
        L_0x01e2:
            r1.setTv(r2)     // Catch:{ all -> 0x0223 }
            com.vungle.ads.internal.platform.Platform r2 = r14.platform     // Catch:{ all -> 0x0223 }
            boolean r2 = r2.isSideLoaded()     // Catch:{ all -> 0x0223 }
            r1.setSideloadEnabled(r2)     // Catch:{ all -> 0x0223 }
            com.vungle.ads.internal.platform.Platform r2 = r14.platform     // Catch:{ all -> 0x0223 }
            boolean r2 = r2.isSdCardPresent()     // Catch:{ all -> 0x0223 }
            if (r2 == 0) goto L_0x01f7
            r4 = 1
        L_0x01f7:
            r1.setSdCardAvailable(r4)     // Catch:{ all -> 0x0223 }
            java.lang.String r2 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x0223 }
            r1.setOsName(r2)     // Catch:{ all -> 0x0223 }
            java.lang.String r2 = r14.uaString     // Catch:{ all -> 0x0223 }
            r0.setUa(r2)     // Catch:{ all -> 0x0223 }
            java.lang.String r2 = "Amazon"
            java.lang.String r4 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0223 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x0223 }
            if (r2 == 0) goto L_0x0214
            com.vungle.ads.internal.model.DeviceNode$VungleExt r2 = new com.vungle.ads.internal.model.DeviceNode$VungleExt     // Catch:{ all -> 0x0223 }
            r2.<init>((com.vungle.ads.internal.model.DeviceNode.AndroidAmazonExt) r3, (com.vungle.ads.internal.model.DeviceNode.AndroidAmazonExt) r1, (int) r15, (kotlin.jvm.internal.DefaultConstructorMarker) r3)     // Catch:{ all -> 0x0223 }
            goto L_0x0219
        L_0x0214:
            com.vungle.ads.internal.model.DeviceNode$VungleExt r2 = new com.vungle.ads.internal.model.DeviceNode$VungleExt     // Catch:{ all -> 0x0223 }
            r2.<init>((com.vungle.ads.internal.model.DeviceNode.AndroidAmazonExt) r1, (com.vungle.ads.internal.model.DeviceNode.AndroidAmazonExt) r3, (int) r6, (kotlin.jvm.internal.DefaultConstructorMarker) r3)     // Catch:{ all -> 0x0223 }
        L_0x0219:
            com.vungle.ads.internal.model.DeviceNode$DeviceExt r15 = new com.vungle.ads.internal.model.DeviceNode$DeviceExt     // Catch:{ all -> 0x0223 }
            r15.<init>(r2)     // Catch:{ all -> 0x0223 }
            r0.setExt(r15)     // Catch:{ all -> 0x0223 }
            monitor-exit(r14)
            return r0
        L_0x0223:
            r15 = move-exception
            monitor-exit(r14)
            goto L_0x0227
        L_0x0226:
            throw r15
        L_0x0227:
            goto L_0x0226
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.VungleApiClient.getDeviceBody$vungle_ads_release(boolean):com.vungle.ads.internal.model.DeviceNode");
    }

    private final CommonRequestBody.User getUserBody() {
        CommonRequestBody.User user = new CommonRequestBody.User((CommonRequestBody.GDPR) null, (CommonRequestBody.CCPA) null, (CommonRequestBody.COPPA) null, 7, (DefaultConstructorMarker) null);
        user.setGdpr(new CommonRequestBody.GDPR(PrivacyManager.INSTANCE.getConsentStatus(), PrivacyManager.INSTANCE.getConsentSource(), PrivacyManager.INSTANCE.getConsentTimestamp(), PrivacyManager.INSTANCE.getConsentMessageVersion()));
        user.setCcpa(new CommonRequestBody.CCPA(PrivacyManager.INSTANCE.getCcpaStatus()));
        if (PrivacyManager.INSTANCE.getCoppaStatus() != COPPA.COPPA_NOTSET) {
            user.setCoppa(new CommonRequestBody.COPPA(PrivacyManager.INSTANCE.getCoppaStatus().getValue()));
        }
        return user;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.vungle.ads.internal.model.CommonRequestBody.RequestExt getExtBody() {
        /*
            r5 = this;
            com.vungle.ads.internal.ConfigManager r0 = com.vungle.ads.internal.ConfigManager.INSTANCE
            java.lang.String r0 = r0.getConfigExtension()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001a
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0015
            r3 = 1
            goto L_0x0016
        L_0x0015:
            r3 = 0
        L_0x0016:
            if (r3 != r1) goto L_0x001a
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            if (r3 == 0) goto L_0x0025
            com.vungle.ads.internal.persistence.FilePreferences r0 = r5.filePreferences
            java.lang.String r3 = "config_extension"
            java.lang.String r0 = r0.getString(r3)
        L_0x0025:
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0033
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            goto L_0x0034
        L_0x0033:
            r3 = 1
        L_0x0034:
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0047
            r3 = r4
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r1 = 0
        L_0x0043:
            if (r1 == 0) goto L_0x0047
            r0 = 0
            return r0
        L_0x0047:
            com.vungle.ads.internal.model.CommonRequestBody$RequestExt r1 = new com.vungle.ads.internal.model.CommonRequestBody$RequestExt
            r1.<init>(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.network.VungleApiClient.getExtBody():com.vungle.ads.internal.model.CommonRequestBody$RequestExt");
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/vungle/ads/internal/network/VungleApiClient$ConnectionTypeDetail;", "", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    /* compiled from: VungleApiClient.kt */
    public @interface ConnectionTypeDetail {
        public static final String CDMA_1XRTT = "cdma_1xrtt";
        public static final String CDMA_EVDO_0 = "cdma_evdo_0";
        public static final String CDMA_EVDO_A = "cdma_evdo_a";
        public static final String CDMA_EVDO_B = "cdma_evdo_b";
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final String EDGE = "edge";
        public static final String GPRS = "gprs";
        public static final String HRPD = "hrpd";
        public static final String HSDPA = "hsdpa";
        public static final String HSUPA = "hsupa";
        public static final String LTE = "LTE";
        public static final String UNKNOWN = "unknown";
        public static final String WCDMA = "wcdma";

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/vungle/ads/internal/network/VungleApiClient$ConnectionTypeDetail$Companion;", "", "()V", "CDMA_1XRTT", "", "CDMA_EVDO_0", "CDMA_EVDO_A", "CDMA_EVDO_B", "EDGE", "GPRS", "HRPD", "HSDPA", "HSUPA", "LTE", "UNKNOWN", "WCDMA", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: VungleApiClient.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final String CDMA_1XRTT = "cdma_1xrtt";
            public static final String CDMA_EVDO_0 = "cdma_evdo_0";
            public static final String CDMA_EVDO_A = "cdma_evdo_a";
            public static final String CDMA_EVDO_B = "cdma_evdo_b";
            public static final String EDGE = "edge";
            public static final String GPRS = "gprs";
            public static final String HRPD = "hrpd";
            public static final String HSDPA = "hsdpa";
            public static final String HSUPA = "hsupa";
            public static final String LTE = "LTE";
            public static final String UNKNOWN = "unknown";
            public static final String WCDMA = "wcdma";

            private Companion() {
            }
        }
    }

    public final Boolean isGooglePlayServicesAvailable() {
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromCookie();
        }
        if (this.isGooglePlayServicesAvailable == null) {
            this.isGooglePlayServicesAvailable = getPlayServicesAvailabilityFromAPI();
        }
        return this.isGooglePlayServicesAvailable;
    }

    private final String getConnectionType() {
        if (PermissionChecker.checkCallingOrSelfPermission(this.applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        Object systemService = this.applicationContext.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "NONE";
        }
        int type = activeNetworkInfo.getType();
        if (type == 0) {
            return "MOBILE";
        }
        if (type == 1 || type == 6) {
            return "WIFI";
        }
        if (type != 7) {
            return type != 9 ? "UNKNOWN" : "ETHERNET";
        }
        return "BLUETOOTH";
    }

    private final String getConnectionTypeDetail() {
        if (PermissionChecker.checkCallingOrSelfPermission(this.applicationContext, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        Object systemService = this.applicationContext.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
        return activeNetworkInfo != null ? getConnectionTypeDetail(activeNetworkInfo.getSubtype()) : "unknown";
    }
}
