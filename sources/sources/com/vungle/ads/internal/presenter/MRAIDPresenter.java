package com.vungle.ads.internal.presenter;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import com.vungle.ads.AdConfig;
import com.vungle.ads.AdNotLoadedCantPlay;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.InternalError;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.SingleValueMetric;
import com.vungle.ads.VungleError;
import com.vungle.ads.internal.ClickCoordinateTracker;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.BidPayload;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.network.Call;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMTracker;
import com.vungle.ads.internal.omsdk.WebViewObserver;
import com.vungle.ads.internal.privacy.PrivacyManager;
import com.vungle.ads.internal.protos.Sdk;
import com.vungle.ads.internal.ui.VungleWebClient;
import com.vungle.ads.internal.ui.view.MRAIDAdWidget;
import com.vungle.ads.internal.ui.view.WebViewAPI;
import com.vungle.ads.internal.util.HandlerScheduler;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.SuspendableTimer;
import java.io.File;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0002\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\b\u0010_\u001a\u00020`H\u0002J\u0010\u0010a\u001a\u00020`2\b\b\u0001\u0010b\u001a\u00020cJ\u0006\u0010d\u001a\u00020`J$\u0010e\u001a\u00020`2\u0006\u0010f\u001a\u00020g2\u0006\u0010h\u001a\u00020\u001c2\n\b\u0002\u0010i\u001a\u0004\u0018\u00010SH\u0002J\u0010\u0010j\u001a\u00020\u001c2\u0006\u0010k\u001a\u00020lH\u0002J\u0010\u0010m\u001a\u00020`2\u0006\u0010f\u001a\u00020gH\u0002J\u0018\u0010n\u001a\u00020`2\u0006\u0010o\u001a\u00020S2\u0006\u0010p\u001a\u00020\u001cH\u0016J\u001c\u0010q\u001a\u00020`2\b\u0010r\u001a\u0004\u0018\u00010s2\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\u0006\u0010v\u001a\u00020`J\u0010\u0010w\u001a\u00020`2\b\u0010x\u001a\u0004\u0018\u00010yJ!\u0010z\u001a\u00020\u001c2\b\u0010{\u001a\u0004\u0018\u00010s2\b\u0010p\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0002\u0010|J\u0006\u0010}\u001a\u00020`J\u001a\u0010~\u001a\u00020\u001c2\u0006\u0010\u001a\u00020S2\b\u0010\u0001\u001a\u00030\u0001H\u0016J\t\u0010\u0001\u001a\u00020`H\u0002J\u0011\u0010\u0001\u001a\u00020`2\u0006\u0010f\u001a\u00020gH\u0002J\u0010\u0010\u0001\u001a\u00020`2\u0007\u0010\u0001\u001a\u00020\u001cJ\u0012\u0010\u0001\u001a\u00020`2\t\u0010\u0001\u001a\u0004\u0018\u00010$J\u0019\u0010\u0001\u001a\u00020`2\b\u0010D\u001a\u0004\u0018\u00010EH\u0000¢\u0006\u0003\b\u0001J\u0007\u0010\u0001\u001a\u00020`J\u0007\u0010\u0001\u001a\u00020`R(\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u0010\u001a\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u001c8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\u0002\n\u0000R&\u0010#\u001a\u0004\u0018\u00010$8\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\u0015\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R!\u0010*\u001a\u00020+8@X\u0002¢\u0006\u0012\n\u0004\b/\u00100\u0012\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010.R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u00101\u001a\u0002028BX\u0002¢\u0006\f\n\u0004\b5\u00100\u001a\u0004\b3\u00104R$\u00106\u001a\u00020\u001c8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b7\u0010\u0015\u001a\u0004\b8\u0010 \"\u0004\b9\u0010\"R\u001c\u0010:\u001a\u00020;8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u0015\u001a\u0004\b=\u0010>R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0002¢\u0006\f\n\u0004\bC\u00100\u001a\u0004\bA\u0010BR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010F\u001a\u00020G8BX\u0002¢\u0006\f\n\u0004\bJ\u00100\u001a\u0004\bH\u0010IR\u000e\u0010K\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R!\u0010L\u001a\u00020M8@X\u0002¢\u0006\u0012\n\u0004\bQ\u00100\u0012\u0004\bN\u0010\u0015\u001a\u0004\bO\u0010PR&\u0010R\u001a\u0004\u0018\u00010S8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bT\u0010\u0015\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR!\u0010Y\u001a\u00020Z8@X\u0002¢\u0006\u0012\n\u0004\b^\u00100\u0012\u0004\b[\u0010\u0015\u001a\u0004\b\\\u0010]R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/vungle/ads/internal/presenter/MRAIDPresenter;", "Lcom/vungle/ads/internal/ui/view/WebViewAPI$MraidDelegate;", "Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;", "adWidget", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget;", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "placement", "Lcom/vungle/ads/internal/model/Placement;", "vungleWebClient", "Lcom/vungle/ads/internal/ui/VungleWebClient;", "executor", "Ljava/util/concurrent/Executor;", "omTracker", "Lcom/vungle/ads/internal/omsdk/OMTracker;", "bidPayload", "Lcom/vungle/ads/internal/model/BidPayload;", "(Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget;Lcom/vungle/ads/internal/model/AdPayload;Lcom/vungle/ads/internal/model/Placement;Lcom/vungle/ads/internal/ui/VungleWebClient;Ljava/util/concurrent/Executor;Lcom/vungle/ads/internal/omsdk/OMTracker;Lcom/vungle/ads/internal/model/BidPayload;)V", "adStartTime", "", "getAdStartTime$vungle_ads_release$annotations", "()V", "getAdStartTime$vungle_ads_release", "()Ljava/lang/Long;", "setAdStartTime$vungle_ads_release", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "adViewed", "", "backEnabled", "getBackEnabled$vungle_ads_release$annotations", "getBackEnabled$vungle_ads_release", "()Z", "setBackEnabled$vungle_ads_release", "(Z)V", "bus", "Lcom/vungle/ads/internal/presenter/AdEventListener;", "getBus$annotations", "getBus", "()Lcom/vungle/ads/internal/presenter/AdEventListener;", "setBus", "(Lcom/vungle/ads/internal/presenter/AdEventListener;)V", "clickCoordinateTracker", "Lcom/vungle/ads/internal/ClickCoordinateTracker;", "getClickCoordinateTracker$vungle_ads_release$annotations", "getClickCoordinateTracker$vungle_ads_release", "()Lcom/vungle/ads/internal/ClickCoordinateTracker;", "clickCoordinateTracker$delegate", "Lkotlin/Lazy;", "executors", "Lcom/vungle/ads/internal/executor/Executors;", "getExecutors", "()Lcom/vungle/ads/internal/executor/Executors;", "executors$delegate", "heartbeatEnabled", "getHeartbeatEnabled$vungle_ads_release$annotations", "getHeartbeatEnabled$vungle_ads_release", "setHeartbeatEnabled$vungle_ads_release", "isDestroying", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isDestroying$vungle_ads_release$annotations", "isDestroying$vungle_ads_release", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "getPathProvider", "()Lcom/vungle/ads/internal/util/PathProvider;", "pathProvider$delegate", "presenterDelegate", "Lcom/vungle/ads/internal/presenter/PresenterDelegate;", "scheduler", "Lcom/vungle/ads/internal/util/HandlerScheduler;", "getScheduler", "()Lcom/vungle/ads/internal/util/HandlerScheduler;", "scheduler$delegate", "sendReportIncentivized", "suspendableTimer", "Lcom/vungle/ads/internal/util/SuspendableTimer;", "getSuspendableTimer$vungle_ads_release$annotations", "getSuspendableTimer$vungle_ads_release", "()Lcom/vungle/ads/internal/util/SuspendableTimer;", "suspendableTimer$delegate", "userId", "", "getUserId$vungle_ads_release$annotations", "getUserId$vungle_ads_release", "()Ljava/lang/String;", "setUserId$vungle_ads_release", "(Ljava/lang/String;)V", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "getVungleApiClient$vungle_ads_release$annotations", "getVungleApiClient$vungle_ads_release", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "vungleApiClient$delegate", "closeView", "", "detach", "stopReason", "", "handleExit", "handleWebViewException", "reason", "Lcom/vungle/ads/VungleError;", "fatal", "errorMessage", "loadMraid", "template", "Ljava/io/File;", "makeBusError", "onReceivedError", "errorDesc", "didCrash", "onRenderProcessUnresponsive", "webView", "Landroid/webkit/WebView;", "webViewRenderProcess", "Landroid/webkit/WebViewRenderProcess;", "onViewConfigurationChanged", "onViewTouched", "event", "Landroid/view/MotionEvent;", "onWebRenderingProcessGone", "view", "(Landroid/webkit/WebView;Ljava/lang/Boolean;)Z", "prepare", "processCommand", "command", "arguments", "Lkotlinx/serialization/json/JsonObject;", "recordPlayAssetMetric", "reportErrorAndCloseAd", "setAdVisibility", "isViewable", "setEventListener", "listener", "setPresenterDelegate", "setPresenterDelegate$vungle_ads_release", "start", "stop", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MRAIDPresenter.kt */
public final class MRAIDPresenter implements WebViewAPI.MraidDelegate, WebViewAPI.WebClientErrorHandler {
    private static final String ACTION = "action";
    public static final String ACTION_WITH_VALUE = "actionWithValue";
    public static final String CLOSE = "close";
    public static final String CONSENT_ACTION = "consentAction";
    public static final String CREATIVE_HEARTBEAT = "creativeHeartbeat";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR = "error";
    private static final double HEARTBEAT_INTERVAL = 6.0d;
    public static final String OPEN = "open";
    private static final String OPEN_NON_MRAID = "openNonMraid";
    public static final String OPEN_PRIVACY = "openPrivacy";
    public static final String SET_ORIENTATION_PROPERTIES = "setOrientationProperties";
    public static final String SUCCESSFUL_VIEW = "successfulView";
    private static final String TAG = "MRAIDPresenter";
    public static final String TPAT = "tpat";
    private static final String USE_CUSTOM_CLOSE = "useCustomClose";
    private static final String USE_CUSTOM_PRIVACY = "useCustomPrivacy";
    public static final String VIDEO_LENGTH = "videoLength";
    public static final String VIDEO_VIEWED = "videoViewed";
    private Long adStartTime;
    private boolean adViewed;
    /* access modifiers changed from: private */
    public final MRAIDAdWidget adWidget;
    /* access modifiers changed from: private */
    public final AdPayload advertisement;
    private boolean backEnabled;
    private final BidPayload bidPayload;
    private AdEventListener bus;
    private final Lazy clickCoordinateTracker$delegate;
    /* access modifiers changed from: private */
    public Executor executor;
    private final Lazy executors$delegate;
    private boolean heartbeatEnabled;
    private final AtomicBoolean isDestroying = new AtomicBoolean(false);
    private final OMTracker omTracker;
    private final Lazy pathProvider$delegate;
    /* access modifiers changed from: private */
    public final Placement placement;
    private PresenterDelegate presenterDelegate;
    private final Lazy scheduler$delegate;
    private final AtomicBoolean sendReportIncentivized = new AtomicBoolean(false);
    private final Lazy suspendableTimer$delegate;
    private String userId;
    private final Lazy vungleApiClient$delegate;
    private final VungleWebClient vungleWebClient;

    public static /* synthetic */ void getAdStartTime$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getBackEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getBus$annotations() {
    }

    public static /* synthetic */ void getClickCoordinateTracker$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getHeartbeatEnabled$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getSuspendableTimer$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getUserId$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getVungleApiClient$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void isDestroying$vungle_ads_release$annotations() {
    }

    public MRAIDPresenter(MRAIDAdWidget mRAIDAdWidget, AdPayload adPayload, Placement placement2, VungleWebClient vungleWebClient2, Executor executor2, OMTracker oMTracker, BidPayload bidPayload2) {
        Intrinsics.checkNotNullParameter(mRAIDAdWidget, "adWidget");
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
        Intrinsics.checkNotNullParameter(placement2, "placement");
        Intrinsics.checkNotNullParameter(vungleWebClient2, "vungleWebClient");
        Intrinsics.checkNotNullParameter(executor2, "executor");
        Intrinsics.checkNotNullParameter(oMTracker, "omTracker");
        this.adWidget = mRAIDAdWidget;
        this.advertisement = adPayload;
        this.placement = placement2;
        this.vungleWebClient = vungleWebClient2;
        this.executor = executor2;
        this.omTracker = oMTracker;
        this.bidPayload = bidPayload2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Context context = mRAIDAdWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "adWidget.context");
        this.vungleApiClient$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new MRAIDPresenter$special$$inlined$inject$1(context));
        ServiceLocator.Companion companion2 = ServiceLocator.Companion;
        Context context2 = mRAIDAdWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "adWidget.context");
        this.executors$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new MRAIDPresenter$special$$inlined$inject$2(context2));
        ServiceLocator.Companion companion3 = ServiceLocator.Companion;
        Context context3 = mRAIDAdWidget.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "adWidget.context");
        this.pathProvider$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new MRAIDPresenter$special$$inlined$inject$3(context3));
        this.scheduler$delegate = LazyKt.lazy(MRAIDPresenter$scheduler$2.INSTANCE);
        this.suspendableTimer$delegate = LazyKt.lazy(new MRAIDPresenter$suspendableTimer$2(this));
        this.clickCoordinateTracker$delegate = LazyKt.lazy(new MRAIDPresenter$clickCoordinateTracker$2(this));
    }

    public final AdEventListener getBus() {
        return this.bus;
    }

    public final void setBus(AdEventListener adEventListener) {
        this.bus = adEventListener;
    }

    public final AtomicBoolean isDestroying$vungle_ads_release() {
        return this.isDestroying;
    }

    public final Long getAdStartTime$vungle_ads_release() {
        return this.adStartTime;
    }

    public final void setAdStartTime$vungle_ads_release(Long l) {
        this.adStartTime = l;
    }

    public final String getUserId$vungle_ads_release() {
        return this.userId;
    }

    public final void setUserId$vungle_ads_release(String str) {
        this.userId = str;
    }

    public final VungleApiClient getVungleApiClient$vungle_ads_release() {
        return (VungleApiClient) this.vungleApiClient$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Executors getExecutors() {
        return (Executors) this.executors$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final PathProvider getPathProvider() {
        return (PathProvider) this.pathProvider$delegate.getValue();
    }

    private final HandlerScheduler getScheduler() {
        return (HandlerScheduler) this.scheduler$delegate.getValue();
    }

    public final boolean getHeartbeatEnabled$vungle_ads_release() {
        return this.heartbeatEnabled;
    }

    public final void setHeartbeatEnabled$vungle_ads_release(boolean z) {
        this.heartbeatEnabled = z;
    }

    public final SuspendableTimer getSuspendableTimer$vungle_ads_release() {
        return (SuspendableTimer) this.suspendableTimer$delegate.getValue();
    }

    public final boolean getBackEnabled$vungle_ads_release() {
        return this.backEnabled;
    }

    public final void setBackEnabled$vungle_ads_release(boolean z) {
        this.backEnabled = z;
    }

    public final ClickCoordinateTracker getClickCoordinateTracker$vungle_ads_release() {
        return (ClickCoordinateTracker) this.clickCoordinateTracker$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0013\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u0016\u0010\u0007\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0002R\u0016\u0010\t\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002R\u0016\u0010\u000b\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\u0002R\u0016\u0010\r\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u0002R\u000e\u0010\u000f\u001a\u00020\u0010XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0002R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0002R\u0016\u0010\u0016\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0017\u0010\u0002R\u0016\u0010\u0018\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\u0002R\u000e\u0010\u001a\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u001b\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u001c\u0010\u0002R\u000e\u0010\u001d\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u001f\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b \u0010\u0002R\u0016\u0010!\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\"\u0010\u0002¨\u0006#"}, d2 = {"Lcom/vungle/ads/internal/presenter/MRAIDPresenter$Companion;", "", "()V", "ACTION", "", "ACTION_WITH_VALUE", "getACTION_WITH_VALUE$vungle_ads_release$annotations", "CLOSE", "getCLOSE$vungle_ads_release$annotations", "CONSENT_ACTION", "getCONSENT_ACTION$vungle_ads_release$annotations", "CREATIVE_HEARTBEAT", "getCREATIVE_HEARTBEAT$vungle_ads_release$annotations", "ERROR", "getERROR$vungle_ads_release$annotations", "HEARTBEAT_INTERVAL", "", "OPEN", "getOPEN$vungle_ads_release$annotations", "OPEN_NON_MRAID", "OPEN_PRIVACY", "getOPEN_PRIVACY$vungle_ads_release$annotations", "SET_ORIENTATION_PROPERTIES", "getSET_ORIENTATION_PROPERTIES$vungle_ads_release$annotations", "SUCCESSFUL_VIEW", "getSUCCESSFUL_VIEW$vungle_ads_release$annotations", "TAG", "TPAT", "getTPAT$vungle_ads_release$annotations", "USE_CUSTOM_CLOSE", "USE_CUSTOM_PRIVACY", "VIDEO_LENGTH", "getVIDEO_LENGTH$vungle_ads_release$annotations", "VIDEO_VIEWED", "getVIDEO_VIEWED$vungle_ads_release$annotations", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MRAIDPresenter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getACTION_WITH_VALUE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCLOSE$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCONSENT_ACTION$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getCREATIVE_HEARTBEAT$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getERROR$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getOPEN$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getOPEN_PRIVACY$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getSET_ORIENTATION_PROPERTIES$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getSUCCESSFUL_VIEW$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getTPAT$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getVIDEO_LENGTH$vungle_ads_release$annotations() {
        }

        public static /* synthetic */ void getVIDEO_VIEWED$vungle_ads_release$annotations() {
        }

        private Companion() {
        }
    }

    public final void setEventListener(AdEventListener adEventListener) {
        this.bus = adEventListener;
    }

    public final void setPresenterDelegate$vungle_ads_release(PresenterDelegate presenterDelegate2) {
        this.presenterDelegate = presenterDelegate2;
    }

    public final void onViewConfigurationChanged() {
        this.vungleWebClient.notifyPropertiesChange(true);
    }

    public final void start() {
        Log.d(TAG, "start()");
        this.adWidget.resumeWeb();
        setAdVisibility(true);
        if (ConfigManager.INSTANCE.adLoadOptimizationEnabled()) {
            recordPlayAssetMetric();
        }
    }

    public final void stop() {
        Log.d(TAG, "stop()");
        this.adWidget.pauseWeb();
        setAdVisibility(false);
    }

    public final void detach(@MRAIDAdWidget.AdStopReason int i) {
        AdEventListener adEventListener;
        Log.d(TAG, "detach()");
        boolean z = false;
        boolean z2 = (i & 1) != 0;
        if ((i & 2) != 0) {
            z = true;
        }
        this.vungleWebClient.setWebViewObserver((WebViewObserver) null);
        this.vungleWebClient.setMraidDelegate((WebViewAPI.MraidDelegate) null);
        if (!z2 && z && !this.isDestroying.getAndSet(true) && (adEventListener = this.bus) != null) {
            adEventListener.onNext("end", (String) null, this.placement.getReferenceId());
        }
        this.adWidget.destroyWebView(this.omTracker.stop());
        if (this.heartbeatEnabled) {
            getSuspendableTimer$vungle_ads_release().cancel();
        }
    }

    public final void setAdVisibility(boolean z) {
        this.vungleWebClient.setAdVisibility(z);
    }

    public final void onViewTouched(MotionEvent motionEvent) {
        if (motionEvent != null) {
            getClickCoordinateTracker$vungle_ads_release().trackCoordinate(motionEvent);
        }
    }

    private final void closeView() {
        this.adWidget.close();
    }

    public final void handleExit() {
        if (this.backEnabled) {
            this.adWidget.showWebsite("javascript:window.vungle.mraidBridgeExt.requestMRAIDClose()");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:160:0x03d4, code lost:
        r3 = com.vungle.ads.AnalyticsClient.INSTANCE;
        r3.logError$vungle_ads_release(311, "Unknown MRAID Command: " + r1, r0.placement.getReferenceId(), r0.advertisement.getCreativeId(), r0.advertisement.eventId());
        android.util.Log.w(TAG, "processCommand# Unknown MRAID Command: " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x040c, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01a4, code lost:
        if (r1.equals("open") == false) goto L_0x03d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01ba, code lost:
        if (r1.equals(OPEN_NON_MRAID) == false) goto L_0x03d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01be, code lost:
        r1 = r0.advertisement.adUnit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01c4, code lost:
        if (r1 == null) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01c6, code lost:
        r11 = r1.getDeeplinkUrl();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01ca, code lost:
        r13 = r11;
        r14 = com.vungle.ads.internal.util.JsonUtil.INSTANCE.getContentStringValue(r2, "url");
        r1 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01d4, code lost:
        if (r1 == null) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01da, code lost:
        if (r1.length() != 0) goto L_0x01dd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01dd, code lost:
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01df, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01e0, code lost:
        if (r1 == false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01e2, code lost:
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01e5, code lost:
        if (r1 == null) goto L_0x01ed;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01eb, code lost:
        if (r1.length() != 0) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01ed, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01ee, code lost:
        if (r10 == false) goto L_0x01f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01f0, code lost:
        android.util.Log.e(TAG, "CTA destination URL is not configured properly");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01f6, code lost:
        r15 = r0.adWidget.getContext();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, "adWidget.context");
        com.vungle.ads.internal.util.ExternalRouter.launch(r13, r14, r15, true, new com.vungle.ads.internal.ui.PresenterAppLeftCallback(r0.bus, r0.placement.getReferenceId()), new com.vungle.ads.internal.presenter.MRAIDPresenter$processCommand$5(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x021e, code lost:
        r1 = r0.bus;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0220, code lost:
        if (r1 == null) goto L_0x022d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0222, code lost:
        r1.onNext("open", "adClick", r0.placement.getReferenceId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x022d, code lost:
        return true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x031e  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x032d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean processCommand(java.lang.String r21, kotlinx.serialization.json.JsonObject r22) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            java.lang.String r3 = "command"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "arguments"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            android.os.Handler r3 = new android.os.Handler
            android.os.Looper r4 = android.os.Looper.getMainLooper()
            r3.<init>(r4)
            int r4 = r21.hashCode()
            java.lang.String r5 = "adWidget.context"
            java.lang.String r6 = "url"
            java.lang.String r7 = "open"
            java.lang.String r8 = "event"
            java.lang.String r9 = "MRAIDPresenter"
            r10 = 0
            r11 = 0
            r12 = 1
            switch(r4) {
                case -1912374177: goto L_0x039a;
                case -1422950858: goto L_0x0390;
                case -735200587: goto L_0x02dd;
                case -660787472: goto L_0x02af;
                case -511324706: goto L_0x022e;
                case -418575596: goto L_0x01b4;
                case -348095344: goto L_0x01a8;
                case 3417674: goto L_0x01a0;
                case 3566511: goto L_0x0117;
                case 94756344: goto L_0x0109;
                case 96784904: goto L_0x00a2;
                case 133423073: goto L_0x0053;
                case 1614272768: goto L_0x0047;
                case 1850430989: goto L_0x0030;
                default: goto L_0x002e;
            }
        L_0x002e:
            goto L_0x03d4
        L_0x0030:
            java.lang.String r2 = "creativeHeartbeat"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x003a
            goto L_0x03d4
        L_0x003a:
            boolean r1 = r0.heartbeatEnabled
            if (r1 == 0) goto L_0x0046
            com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda5 r1 = new com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda5
            r1.<init>(r0)
            r3.post(r1)
        L_0x0046:
            return r12
        L_0x0047:
            java.lang.String r2 = "useCustomClose"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0052
            goto L_0x03d4
        L_0x0052:
            return r12
        L_0x0053:
            java.lang.String r3 = "setOrientationProperties"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x005d
            goto L_0x03d4
        L_0x005d:
            com.vungle.ads.internal.util.JsonUtil r1 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r3 = "forceOrientation"
            java.lang.String r1 = r1.getContentStringValue(r2, r3)
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0070
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0071
        L_0x0070:
            r10 = 1
        L_0x0071:
            if (r10 != 0) goto L_0x00a1
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r3 = "ENGLISH"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r1 = r1.toLowerCase(r2)
            java.lang.String r2 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.String r2 = "landscape"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0093
            com.vungle.ads.internal.ui.view.MRAIDAdWidget r1 = r0.adWidget
            r2 = 6
            r1.setOrientation(r2)
            goto L_0x00a1
        L_0x0093:
            java.lang.String r2 = "portrait"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x00a1
            com.vungle.ads.internal.ui.view.MRAIDAdWidget r1 = r0.adWidget
            r2 = 7
            r1.setOrientation(r2)
        L_0x00a1:
            return r12
        L_0x00a2:
            java.lang.String r3 = "error"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x00ac
            goto L_0x03d4
        L_0x00ac:
            com.vungle.ads.internal.util.JsonUtil r1 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r3 = "code"
            java.lang.String r1 = r1.getContentStringValue(r2, r3)
            com.vungle.ads.internal.util.JsonUtil r3 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r4 = "fatal"
            java.lang.String r3 = r3.getContentStringValue(r2, r4)
            boolean r3 = java.lang.Boolean.parseBoolean(r3)
            com.vungle.ads.internal.util.JsonUtil r4 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r5 = "errorMessage"
            java.lang.String r2 = r4.getContentStringValue(r2, r5)
            if (r3 == 0) goto L_0x00cf
            r4 = 317(0x13d, float:4.44E-43)
            r6 = 317(0x13d, float:4.44E-43)
            goto L_0x00d3
        L_0x00cf:
            r4 = 301(0x12d, float:4.22E-43)
            r6 = 301(0x12d, float:4.22E-43)
        L_0x00d3:
            com.vungle.ads.AnalyticsClient r5 = com.vungle.ads.AnalyticsClient.INSTANCE
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            java.lang.String r7 = " : "
            r4.append(r7)
            r4.append(r2)
            java.lang.String r7 = r4.toString()
            com.vungle.ads.internal.model.Placement r4 = r0.placement
            java.lang.String r8 = r4.getReferenceId()
            com.vungle.ads.internal.model.AdPayload r4 = r0.advertisement
            java.lang.String r9 = r4.getCreativeId()
            com.vungle.ads.internal.model.AdPayload r4 = r0.advertisement
            java.lang.String r10 = r4.eventId()
            r5.logError$vungle_ads_release((int) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10)
            com.vungle.ads.internal.util.ThreadUtil r4 = com.vungle.ads.internal.util.ThreadUtil.INSTANCE
            com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda4 r5 = new com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda4
            r5.<init>(r0, r3, r1, r2)
            r4.runOnUiThread(r5)
            return r12
        L_0x0109:
            java.lang.String r2 = "close"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0113
            goto L_0x03d4
        L_0x0113:
            r20.closeView()
            return r12
        L_0x0117:
            java.lang.String r3 = "tpat"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0122
            goto L_0x03d4
        L_0x0122:
            com.vungle.ads.internal.util.JsonUtil r1 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r1 = r1.getContentStringValue(r2, r8)
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0133
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0134
        L_0x0133:
            r10 = 1
        L_0x0134:
            if (r10 == 0) goto L_0x0152
            com.vungle.ads.AnalyticsClient r2 = com.vungle.ads.AnalyticsClient.INSTANCE
            r3 = 129(0x81, float:1.81E-43)
            java.lang.String r4 = "Empty tpat key"
            com.vungle.ads.internal.model.Placement r1 = r0.placement
            java.lang.String r5 = r1.getReferenceId()
            com.vungle.ads.internal.model.AdPayload r1 = r0.advertisement
            java.lang.String r6 = r1.getCreativeId()
            com.vungle.ads.internal.model.AdPayload r1 = r0.advertisement
            java.lang.String r7 = r1.eventId()
            r2.logError$vungle_ads_release((int) r3, (java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7)
            return r12
        L_0x0152:
            com.vungle.ads.internal.network.TpatSender r2 = new com.vungle.ads.internal.network.TpatSender
            com.vungle.ads.internal.network.VungleApiClient r14 = r20.getVungleApiClient$vungle_ads_release()
            com.vungle.ads.internal.model.Placement r3 = r0.placement
            java.lang.String r15 = r3.getReferenceId()
            com.vungle.ads.internal.model.AdPayload r3 = r0.advertisement
            java.lang.String r16 = r3.getCreativeId()
            com.vungle.ads.internal.model.AdPayload r3 = r0.advertisement
            java.lang.String r17 = r3.eventId()
            com.vungle.ads.internal.executor.Executors r3 = r20.getExecutors()
            com.vungle.ads.internal.executor.VungleThreadPoolExecutor r3 = r3.getIoExecutor()
            r18 = r3
            java.util.concurrent.Executor r18 = (java.util.concurrent.Executor) r18
            com.vungle.ads.internal.util.PathProvider r19 = r20.getPathProvider()
            r13 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19)
            com.vungle.ads.internal.model.AdPayload r3 = r0.advertisement
            r4 = 2
            java.util.List r1 = com.vungle.ads.internal.model.AdPayload.getTpatUrls$default(r3, r1, r11, r4, r11)
            if (r1 == 0) goto L_0x019f
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x018d:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x019f
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            java.util.concurrent.Executor r4 = r0.executor
            r2.sendTpat(r3, r4)
            goto L_0x018d
        L_0x019f:
            return r12
        L_0x01a0:
            boolean r3 = r1.equals(r7)
            if (r3 != 0) goto L_0x01be
            goto L_0x03d4
        L_0x01a8:
            java.lang.String r2 = "useCustomPrivacy"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x01b3
            goto L_0x03d4
        L_0x01b3:
            return r12
        L_0x01b4:
            java.lang.String r3 = "openNonMraid"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x01be
            goto L_0x03d4
        L_0x01be:
            com.vungle.ads.internal.model.AdPayload r1 = r0.advertisement
            com.vungle.ads.internal.model.AdPayload$AdUnit r1 = r1.adUnit()
            if (r1 == 0) goto L_0x01ca
            java.lang.String r11 = r1.getDeeplinkUrl()
        L_0x01ca:
            r13 = r11
            com.vungle.ads.internal.util.JsonUtil r1 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r14 = r1.getContentStringValue(r2, r6)
            r1 = r13
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x01df
            int r1 = r1.length()
            if (r1 != 0) goto L_0x01dd
            goto L_0x01df
        L_0x01dd:
            r1 = 0
            goto L_0x01e0
        L_0x01df:
            r1 = 1
        L_0x01e0:
            if (r1 == 0) goto L_0x01f6
            r1 = r14
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x01ed
            int r1 = r1.length()
            if (r1 != 0) goto L_0x01ee
        L_0x01ed:
            r10 = 1
        L_0x01ee:
            if (r10 == 0) goto L_0x01f6
            java.lang.String r1 = "CTA destination URL is not configured properly"
            android.util.Log.e(r9, r1)
            goto L_0x021e
        L_0x01f6:
            com.vungle.ads.internal.ui.view.MRAIDAdWidget r1 = r0.adWidget
            android.content.Context r15 = r1.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r5)
            r16 = 1
            com.vungle.ads.internal.ui.PresenterAppLeftCallback r1 = new com.vungle.ads.internal.ui.PresenterAppLeftCallback
            com.vungle.ads.internal.presenter.AdEventListener r2 = r0.bus
            com.vungle.ads.internal.model.Placement r3 = r0.placement
            java.lang.String r3 = r3.getReferenceId()
            r1.<init>(r2, r3)
            r17 = r1
            com.vungle.ads.internal.util.ActivityManager$LeftApplicationCallback r17 = (com.vungle.ads.internal.util.ActivityManager.LeftApplicationCallback) r17
            com.vungle.ads.internal.presenter.MRAIDPresenter$processCommand$5 r1 = new com.vungle.ads.internal.presenter.MRAIDPresenter$processCommand$5
            r1.<init>(r0)
            r18 = r1
            com.vungle.ads.internal.ui.PresenterAdOpenCallback r18 = (com.vungle.ads.internal.ui.PresenterAdOpenCallback) r18
            com.vungle.ads.internal.util.ExternalRouter.launch(r13, r14, r15, r16, r17, r18)
        L_0x021e:
            com.vungle.ads.internal.presenter.AdEventListener r1 = r0.bus
            if (r1 == 0) goto L_0x022d
            com.vungle.ads.internal.model.Placement r2 = r0.placement
            java.lang.String r2 = r2.getReferenceId()
            java.lang.String r3 = "adClick"
            r1.onNext(r7, r3, r2)
        L_0x022d:
            return r12
        L_0x022e:
            java.lang.String r3 = "openPrivacy"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0238
            goto L_0x03d4
        L_0x0238:
            com.vungle.ads.internal.util.JsonUtil r1 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r1 = r1.getContentStringValue(r2, r6)
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0249
            int r2 = r2.length()
            if (r2 != 0) goto L_0x024a
        L_0x0249:
            r10 = 1
        L_0x024a:
            if (r10 != 0) goto L_0x0284
            com.vungle.ads.internal.util.FileUtility r2 = com.vungle.ads.internal.util.FileUtility.INSTANCE
            boolean r2 = r2.isValidUrl(r1)
            if (r2 != 0) goto L_0x0255
            goto L_0x0284
        L_0x0255:
            r13 = 0
            com.vungle.ads.internal.ui.view.MRAIDAdWidget r2 = r0.adWidget
            android.content.Context r15 = r2.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r5)
            r16 = 1
            com.vungle.ads.internal.ui.PresenterAppLeftCallback r2 = new com.vungle.ads.internal.ui.PresenterAppLeftCallback
            com.vungle.ads.internal.presenter.AdEventListener r3 = r0.bus
            com.vungle.ads.internal.model.Placement r4 = r0.placement
            java.lang.String r4 = r4.getReferenceId()
            r2.<init>(r3, r4)
            r17 = r2
            com.vungle.ads.internal.util.ActivityManager$LeftApplicationCallback r17 = (com.vungle.ads.internal.util.ActivityManager.LeftApplicationCallback) r17
            r18 = 0
            r14 = r1
            boolean r2 = com.vungle.ads.internal.util.ExternalRouter.launch(r13, r14, r15, r16, r17, r18)
            if (r2 != 0) goto L_0x0283
            com.vungle.ads.PrivacyUrlError r2 = new com.vungle.ads.PrivacyUrlError
            r2.<init>(r1)
            r2.logErrorNoReturnValue$vungle_ads_release()
        L_0x0283:
            return r12
        L_0x0284:
            com.vungle.ads.PrivacyUrlError r2 = new com.vungle.ads.PrivacyUrlError
            if (r1 != 0) goto L_0x028a
            java.lang.String r1 = "nonePrivacyUrl"
        L_0x028a:
            r2.<init>(r1)
            com.vungle.ads.internal.model.Placement r1 = r0.placement
            java.lang.String r1 = r1.getReferenceId()
            com.vungle.ads.VungleError r1 = r2.setPlacementId$vungle_ads_release(r1)
            com.vungle.ads.internal.model.AdPayload r2 = r0.advertisement
            java.lang.String r2 = r2.getCreativeId()
            com.vungle.ads.VungleError r1 = r1.setCreativeId$vungle_ads_release(r2)
            com.vungle.ads.internal.model.AdPayload r2 = r0.advertisement
            java.lang.String r2 = r2.eventId()
            com.vungle.ads.VungleError r1 = r1.setEventId$vungle_ads_release(r2)
            r1.logErrorNoReturnValue$vungle_ads_release()
            return r12
        L_0x02af:
            java.lang.String r3 = "consentAction"
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x02b9
            goto L_0x03d4
        L_0x02b9:
            com.vungle.ads.internal.util.JsonUtil r1 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r1 = r1.getContentStringValue(r2, r8)
            com.vungle.ads.internal.privacy.PrivacyConsent r2 = com.vungle.ads.internal.privacy.PrivacyConsent.OPT_OUT
            java.lang.String r2 = r2.getValue()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x02ce
            com.vungle.ads.internal.privacy.PrivacyConsent r1 = com.vungle.ads.internal.privacy.PrivacyConsent.OPT_OUT
            goto L_0x02d0
        L_0x02ce:
            com.vungle.ads.internal.privacy.PrivacyConsent r1 = com.vungle.ads.internal.privacy.PrivacyConsent.OPT_IN
        L_0x02d0:
            java.lang.String r1 = r1.getValue()
            com.vungle.ads.internal.privacy.PrivacyManager r2 = com.vungle.ads.internal.privacy.PrivacyManager.INSTANCE
            java.lang.String r3 = "vungle_modal"
            r2.updateGdprConsent(r1, r3, r11)
            return r12
        L_0x02dd:
            java.lang.String r4 = "actionWithValue"
            boolean r4 = r1.equals(r4)
            if (r4 != 0) goto L_0x02e7
            goto L_0x03d4
        L_0x02e7:
            com.vungle.ads.internal.util.JsonUtil r1 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r1 = r1.getContentStringValue(r2, r8)
            com.vungle.ads.internal.util.JsonUtil r4 = com.vungle.ads.internal.util.JsonUtil.INSTANCE
            java.lang.String r5 = "value"
            java.lang.String r2 = r4.getContentStringValue(r2, r5)
            java.lang.String r4 = "videoViewed"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x0376
            r4 = 0
            if (r2 == 0) goto L_0x030d
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x0307 }
            goto L_0x030e
        L_0x0307:
            java.lang.String r2 = "value for videoViewed is null !"
            android.util.Log.e(r9, r2)
        L_0x030d:
            r2 = 0
        L_0x030e:
            com.vungle.ads.internal.presenter.AdEventListener r5 = r0.bus
            if (r5 == 0) goto L_0x0376
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0376
            boolean r2 = r0.adViewed
            if (r2 != 0) goto L_0x0376
            r0.adViewed = r12
            if (r5 == 0) goto L_0x0329
            com.vungle.ads.internal.model.Placement r2 = r0.placement
            java.lang.String r2 = r2.getReferenceId()
            java.lang.String r4 = "adViewed"
            r5.onNext(r4, r11, r2)
        L_0x0329:
            com.vungle.ads.internal.model.BidPayload r2 = r0.bidPayload
            if (r2 == 0) goto L_0x0376
            com.vungle.ads.internal.network.TpatSender r11 = new com.vungle.ads.internal.network.TpatSender
            com.vungle.ads.internal.network.VungleApiClient r5 = r20.getVungleApiClient$vungle_ads_release()
            com.vungle.ads.internal.model.Placement r4 = r0.placement
            java.lang.String r6 = r4.getReferenceId()
            com.vungle.ads.internal.model.AdPayload r4 = r0.advertisement
            java.lang.String r7 = r4.getCreativeId()
            com.vungle.ads.internal.model.AdPayload r4 = r0.advertisement
            java.lang.String r8 = r4.eventId()
            com.vungle.ads.internal.executor.Executors r4 = r20.getExecutors()
            com.vungle.ads.internal.executor.VungleThreadPoolExecutor r4 = r4.getIoExecutor()
            r9 = r4
            java.util.concurrent.Executor r9 = (java.util.concurrent.Executor) r9
            com.vungle.ads.internal.util.PathProvider r10 = r20.getPathProvider()
            r4 = r11
            r4.<init>(r5, r6, r7, r8, r9, r10)
            java.util.List r2 = r2.getImpression()
            if (r2 == 0) goto L_0x0376
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x0364:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0376
            java.lang.Object r4 = r2.next()
            java.lang.String r4 = (java.lang.String) r4
            java.util.concurrent.Executor r5 = r0.executor
            r11.sendTpat(r4, r5)
            goto L_0x0364
        L_0x0376:
            java.lang.String r2 = "videoLength"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 == 0) goto L_0x0387
            com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda1 r1 = new com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda1
            r1.<init>(r0)
            r3.post(r1)
        L_0x0387:
            com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda2 r1 = new com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda2
            r1.<init>(r0)
            r3.post(r1)
            return r12
        L_0x0390:
            java.lang.String r2 = "action"
            boolean r2 = r1.equals(r2)
            if (r2 != 0) goto L_0x0399
            goto L_0x03d4
        L_0x0399:
            return r12
        L_0x039a:
            java.lang.String r2 = "successfulView"
            boolean r3 = r1.equals(r2)
            if (r3 != 0) goto L_0x03a4
            goto L_0x03d4
        L_0x03a4:
            com.vungle.ads.internal.presenter.AdEventListener r1 = r0.bus
            if (r1 == 0) goto L_0x03b1
            com.vungle.ads.internal.model.Placement r3 = r0.placement
            java.lang.String r3 = r3.getReferenceId()
            r1.onNext(r2, r11, r3)
        L_0x03b1:
            com.vungle.ads.internal.model.Placement r1 = r0.placement
            boolean r1 = r1.isIncentivized()
            if (r1 == 0) goto L_0x03d3
            com.vungle.ads.internal.ConfigManager r1 = com.vungle.ads.internal.ConfigManager.INSTANCE
            boolean r1 = r1.isReportIncentivizedEnabled()
            if (r1 == 0) goto L_0x03d3
            java.util.concurrent.atomic.AtomicBoolean r1 = r0.sendReportIncentivized
            boolean r1 = r1.getAndSet(r12)
            if (r1 != 0) goto L_0x03d3
            java.util.concurrent.Executor r1 = r0.executor
            com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda3 r2 = new com.vungle.ads.internal.presenter.MRAIDPresenter$$ExternalSyntheticLambda3
            r2.<init>(r0)
            r1.execute(r2)
        L_0x03d3:
            return r12
        L_0x03d4:
            com.vungle.ads.AnalyticsClient r3 = com.vungle.ads.AnalyticsClient.INSTANCE
            r4 = 311(0x137, float:4.36E-43)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "Unknown MRAID Command: "
            r2.<init>(r5)
            r2.append(r1)
            java.lang.String r5 = r2.toString()
            com.vungle.ads.internal.model.Placement r2 = r0.placement
            java.lang.String r6 = r2.getReferenceId()
            com.vungle.ads.internal.model.AdPayload r2 = r0.advertisement
            java.lang.String r7 = r2.getCreativeId()
            com.vungle.ads.internal.model.AdPayload r2 = r0.advertisement
            java.lang.String r8 = r2.eventId()
            r3.logError$vungle_ads_release((int) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "processCommand# Unknown MRAID Command: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            android.util.Log.w(r9, r1)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.presenter.MRAIDPresenter.processCommand(java.lang.String, kotlinx.serialization.json.JsonObject):boolean");
    }

    /* access modifiers changed from: private */
    /* renamed from: processCommand$lambda-3  reason: not valid java name */
    public static final void m2316processCommand$lambda3(MRAIDPresenter mRAIDPresenter) {
        Intrinsics.checkNotNullParameter(mRAIDPresenter, "this$0");
        mRAIDPresenter.vungleWebClient.notifyPropertiesChange(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: processCommand$lambda-4  reason: not valid java name */
    public static final void m2317processCommand$lambda4(MRAIDPresenter mRAIDPresenter) {
        Intrinsics.checkNotNullParameter(mRAIDPresenter, "this$0");
        mRAIDPresenter.adWidget.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: processCommand$lambda-6  reason: not valid java name */
    public static final void m2318processCommand$lambda6(MRAIDPresenter mRAIDPresenter) {
        Intrinsics.checkNotNullParameter(mRAIDPresenter, "this$0");
        String referenceId = mRAIDPresenter.placement.getReferenceId();
        Call<Void> ri = mRAIDPresenter.getVungleApiClient$vungle_ads_release().ri(new CommonRequestBody.RequestParam((List) null, (Boolean) null, (String) null, mRAIDPresenter.adStartTime, mRAIDPresenter.advertisement.appId(), referenceId, mRAIDPresenter.userId, 7, (DefaultConstructorMarker) null));
        if (ri == null) {
            Log.e(TAG, "Invalid ri call.");
        } else {
            ri.enqueue(new MRAIDPresenter$processCommand$6$1());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: processCommand$lambda-7  reason: not valid java name */
    public static final void m2319processCommand$lambda7(MRAIDPresenter mRAIDPresenter, boolean z, String str, String str2) {
        Intrinsics.checkNotNullParameter(mRAIDPresenter, "this$0");
        mRAIDPresenter.handleWebViewException(new InternalError(VungleError.CREATIVE_ERROR, (String) null, 2, (DefaultConstructorMarker) null), z, str + " : " + str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: processCommand$lambda-8  reason: not valid java name */
    public static final void m2320processCommand$lambda8(MRAIDPresenter mRAIDPresenter) {
        Intrinsics.checkNotNullParameter(mRAIDPresenter, "this$0");
        mRAIDPresenter.getSuspendableTimer$vungle_ads_release().reset();
    }

    private final void makeBusError(VungleError vungleError) {
        AdEventListener adEventListener = this.bus;
        if (adEventListener != null) {
            adEventListener.onError(vungleError, this.placement.getReferenceId());
        }
    }

    /* access modifiers changed from: private */
    public final void reportErrorAndCloseAd(VungleError vungleError) {
        makeBusError(vungleError);
        closeView();
    }

    public void onReceivedError(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "errorDesc");
        if (z) {
            reportErrorAndCloseAd(new InternalError(VungleError.AD_RENDER_NETWORK_ERROR, (String) null, 2, (DefaultConstructorMarker) null));
        }
    }

    public boolean onWebRenderingProcessGone(WebView webView, Boolean bool) {
        handleWebViewException$default(this, new InternalError(VungleError.WEB_CRASH, (String) null, 2, (DefaultConstructorMarker) null), true, (String) null, 4, (Object) null);
        return true;
    }

    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        handleWebViewException$default(this, new InternalError(VungleError.WEBVIEW_RENDER_UNRESPONSIVE, (String) null, 2, (DefaultConstructorMarker) null), true, (String) null, 4, (Object) null);
    }

    static /* synthetic */ void handleWebViewException$default(MRAIDPresenter mRAIDPresenter, VungleError vungleError, boolean z, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        mRAIDPresenter.handleWebViewException(vungleError, z, str);
    }

    private final void handleWebViewException(VungleError vungleError, boolean z, String str) {
        Log.e(TAG, "handleWebViewException: " + vungleError.getLocalizedMessage() + ", fatal: " + z + ", errorMsg: " + str);
        if (z) {
            makeBusError(vungleError);
            closeView();
        }
    }

    private final boolean loadMraid(File file) {
        String parent = file.getParent();
        String str = null;
        File file2 = parent != null ? new File(parent) : null;
        StringBuilder sb = new StringBuilder();
        if (file2 != null) {
            str = file2.getPath();
        }
        sb.append(str);
        sb.append(File.separator);
        sb.append("index.html");
        File file3 = new File(sb.toString());
        if (!file3.exists()) {
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            analyticsClient.logError$vungle_ads_release(310, "Fail to load html " + file3.getPath(), this.placement.getReferenceId(), this.advertisement.getCreativeId(), this.advertisement.eventId());
            return false;
        }
        MRAIDAdWidget mRAIDAdWidget = this.adWidget;
        mRAIDAdWidget.showWebsite(AdPayload.FILE_SCHEME + file3.getPath());
        return true;
    }

    public final void prepare() {
        int i;
        String str;
        String str2;
        String str3;
        String str4;
        int settings;
        boolean z = false;
        this.isDestroying.set(false);
        this.adWidget.linkWebView(this.vungleWebClient);
        AdConfig adConfig = this.advertisement.getAdConfig();
        if (adConfig != null && (settings = adConfig.getSettings()) > 0) {
            this.backEnabled = (settings & 2) == 2;
        }
        this.heartbeatEnabled = ConfigManager.INSTANCE.heartbeatEnabled();
        AdConfig adConfig2 = this.advertisement.getAdConfig();
        Integer valueOf = adConfig2 != null ? Integer.valueOf(adConfig2.getAdOrientation()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            i = 7;
        } else {
            i = (valueOf != null && valueOf.intValue() == 1) ? 6 : 4;
        }
        this.adWidget.setOrientation(i);
        this.omTracker.start();
        this.vungleWebClient.setMraidDelegate(this);
        this.vungleWebClient.setErrorHandler(this);
        File assetDirectory = this.advertisement.getAssetDirectory();
        if (assetDirectory == null || !assetDirectory.exists()) {
            reportErrorAndCloseAd(new AdNotLoadedCantPlay());
            return;
        }
        if (!loadMraid(new File(assetDirectory.getPath() + File.separator + "template"))) {
            reportErrorAndCloseAd(new AdNotLoadedCantPlay());
            return;
        }
        this.adStartTime = Long.valueOf(System.currentTimeMillis());
        PresenterDelegate presenterDelegate2 = this.presenterDelegate;
        this.userId = presenterDelegate2 != null ? presenterDelegate2.getUserId() : null;
        PresenterDelegate presenterDelegate3 = this.presenterDelegate;
        if (presenterDelegate3 == null || (str = presenterDelegate3.getAlertTitleText()) == null) {
            str = "";
        }
        PresenterDelegate presenterDelegate4 = this.presenterDelegate;
        if (presenterDelegate4 == null || (str2 = presenterDelegate4.getAlertBodyText()) == null) {
            str2 = "";
        }
        PresenterDelegate presenterDelegate5 = this.presenterDelegate;
        if (presenterDelegate5 == null || (str3 = presenterDelegate5.getAlertContinueButtonText()) == null) {
            str3 = "";
        }
        PresenterDelegate presenterDelegate6 = this.presenterDelegate;
        if (presenterDelegate6 == null || (str4 = presenterDelegate6.getAlertCloseButtonText()) == null) {
            str4 = "";
        }
        this.advertisement.setIncentivizedText(str, str2, str3, str4);
        if (ConfigManager.INSTANCE.getGDPRIsCountryDataProtected() && Intrinsics.areEqual((Object) "unknown", (Object) PrivacyManager.INSTANCE.getConsentStatus())) {
            z = true;
        }
        this.vungleWebClient.setConsentStatus(z, ConfigManager.INSTANCE.getGDPRConsentTitle(), ConfigManager.INSTANCE.getGDPRConsentMessage(), ConfigManager.INSTANCE.getGDPRButtonAccept(), ConfigManager.INSTANCE.getGDPRButtonDeny());
        if (z) {
            PrivacyManager.INSTANCE.updateGdprConsent("opted_out_by_timeout", "vungle_modal", "");
        }
        int showCloseDelay = this.advertisement.getShowCloseDelay(Boolean.valueOf(this.placement.isIncentivized()));
        if (showCloseDelay > 0) {
            getScheduler().schedule(new MRAIDPresenter$$ExternalSyntheticLambda0(this), (long) showCloseDelay);
        } else {
            this.backEnabled = true;
        }
        AdEventListener adEventListener = this.bus;
        if (adEventListener != null) {
            adEventListener.onNext("start", (String) null, this.placement.getReferenceId());
        }
        if (this.heartbeatEnabled) {
            getSuspendableTimer$vungle_ads_release().start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: prepare$lambda-11  reason: not valid java name */
    public static final void m2315prepare$lambda11(MRAIDPresenter mRAIDPresenter) {
        Intrinsics.checkNotNullParameter(mRAIDPresenter, "this$0");
        mRAIDPresenter.backEnabled = true;
    }

    private final void recordPlayAssetMetric() {
        Sdk.SDKMetric.SDKMetricType sDKMetricType;
        if (this.advertisement.getAssetsFullyDownloaded()) {
            sDKMetricType = Sdk.SDKMetric.SDKMetricType.LOCAL_ASSETS_USED;
        } else {
            sDKMetricType = Sdk.SDKMetric.SDKMetricType.REMOTE_ASSETS_USED;
        }
        AnalyticsClient.logMetric$vungle_ads_release$default(AnalyticsClient.INSTANCE, new SingleValueMetric(sDKMetricType), this.placement.getReferenceId(), this.advertisement.getCreativeId(), this.advertisement.eventId(), (String) null, 16, (Object) null);
    }
}
