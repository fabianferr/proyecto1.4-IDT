package com.vungle.ads.internal.ui;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;
import androidx.webkit.ProxyConfig;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.BuildConfig;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.model.Placement;
import com.vungle.ads.internal.omsdk.WebViewObserver;
import com.vungle.ads.internal.ui.view.WebViewAPI;
import java.util.concurrent.ExecutorService;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0002stB\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020\u001a2\u0006\u0010O\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020\u000bH\u0002J\u0010\u0010Q\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u001aH\u0002J\u0010\u0010R\u001a\u00020M2\u0006\u0010S\u001a\u00020\u000bH\u0016J\u001c\u0010T\u001a\u00020M2\b\u0010U\u001a\u0004\u0018\u0001042\b\u0010O\u001a\u0004\u0018\u00010\u001aH\u0016J&\u0010V\u001a\u00020M2\b\u0010U\u001a\u0004\u0018\u0001042\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0016J*\u0010V\u001a\u00020M2\b\u0010U\u001a\u0004\u0018\u0001042\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u001a2\u0006\u0010^\u001a\u00020\u001aH\u0017J&\u0010_\u001a\u00020M2\b\u0010U\u001a\u0004\u0018\u0001042\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010`\u001a\u0004\u0018\u00010aH\u0016J\u001c\u0010b\u001a\u00020\u000b2\b\u0010U\u001a\u0004\u0018\u0001042\b\u0010c\u001a\u0004\u0018\u00010dH\u0017J\u001a\u0010e\u001a\u00020M2\b\u0010f\u001a\u0004\u0018\u0001042\u0006\u0010g\u001a\u00020\u001aH\u0002J\u0010\u0010h\u001a\u00020M2\u0006\u0010,\u001a\u00020\u000bH\u0016J8\u0010i\u001a\u00020M2\u0006\u0010j\u001a\u00020\u000b2\b\u0010k\u001a\u0004\u0018\u00010\u001a2\b\u0010l\u001a\u0004\u0018\u00010\u001a2\b\u0010m\u001a\u0004\u0018\u00010\u001a2\b\u0010n\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010o\u001a\u00020M2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010p\u001a\u00020M2\b\u0010:\u001a\u0004\u0018\u00010;H\u0016J\u0012\u0010q\u001a\u00020M2\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u001c\u0010r\u001a\u00020\u000b2\b\u0010U\u001a\u0004\u0018\u0001042\b\u0010O\u001a\u0004\u0018\u00010\u001aH\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\u000b8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\r\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010 \u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR&\u0010$\u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010\r\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001fR&\u0010(\u001a\u0004\u0018\u00010\u001a8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b)\u0010\r\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR(\u0010,\u001a\u0004\u0018\u00010\u000b8\u0000@\u0000X\u000e¢\u0006\u0016\n\u0002\u00102\u0012\u0004\b-\u0010\r\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R&\u00103\u001a\u0004\u0018\u0001048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b5\u0010\r\u001a\u0004\b6\u00107\"\u0004\b8\u00109R&\u0010:\u001a\u0004\u0018\u00010;8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b<\u0010\r\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010A\u001a\u00020\u000b8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bB\u0010\r\u001a\u0004\bC\u0010\u000f\"\u0004\bD\u0010\u0011R&\u0010E\u001a\u0004\u0018\u00010F8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bG\u0010\r\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006u"}, d2 = {"Lcom/vungle/ads/internal/ui/VungleWebClient;", "Landroid/webkit/WebViewClient;", "Lcom/vungle/ads/internal/ui/view/WebViewAPI;", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "placement", "Lcom/vungle/ads/internal/model/Placement;", "offloadExecutor", "Ljava/util/concurrent/ExecutorService;", "(Lcom/vungle/ads/internal/model/AdPayload;Lcom/vungle/ads/internal/model/Placement;Ljava/util/concurrent/ExecutorService;)V", "collectConsent", "", "getCollectConsent$vungle_ads_release$annotations", "()V", "getCollectConsent$vungle_ads_release", "()Z", "setCollectConsent$vungle_ads_release", "(Z)V", "errorHandler", "Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;", "getErrorHandler$vungle_ads_release$annotations", "getErrorHandler$vungle_ads_release", "()Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;", "setErrorHandler$vungle_ads_release", "(Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;)V", "gdprAccept", "", "getGdprAccept$vungle_ads_release$annotations", "getGdprAccept$vungle_ads_release", "()Ljava/lang/String;", "setGdprAccept$vungle_ads_release", "(Ljava/lang/String;)V", "gdprBody", "getGdprBody$vungle_ads_release$annotations", "getGdprBody$vungle_ads_release", "setGdprBody$vungle_ads_release", "gdprDeny", "getGdprDeny$vungle_ads_release$annotations", "getGdprDeny$vungle_ads_release", "setGdprDeny$vungle_ads_release", "gdprTitle", "getGdprTitle$vungle_ads_release$annotations", "getGdprTitle$vungle_ads_release", "setGdprTitle$vungle_ads_release", "isViewable", "isViewable$vungle_ads_release$annotations", "isViewable$vungle_ads_release", "()Ljava/lang/Boolean;", "setViewable$vungle_ads_release", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "loadedWebView", "Landroid/webkit/WebView;", "getLoadedWebView$vungle_ads_release$annotations", "getLoadedWebView$vungle_ads_release", "()Landroid/webkit/WebView;", "setLoadedWebView$vungle_ads_release", "(Landroid/webkit/WebView;)V", "mraidDelegate", "Lcom/vungle/ads/internal/ui/view/WebViewAPI$MraidDelegate;", "getMraidDelegate$vungle_ads_release$annotations", "getMraidDelegate$vungle_ads_release", "()Lcom/vungle/ads/internal/ui/view/WebViewAPI$MraidDelegate;", "setMraidDelegate$vungle_ads_release", "(Lcom/vungle/ads/internal/ui/view/WebViewAPI$MraidDelegate;)V", "ready", "getReady$vungle_ads_release$annotations", "getReady$vungle_ads_release", "setReady$vungle_ads_release", "webViewObserver", "Lcom/vungle/ads/internal/omsdk/WebViewObserver;", "getWebViewObserver$vungle_ads_release$annotations", "getWebViewObserver$vungle_ads_release", "()Lcom/vungle/ads/internal/omsdk/WebViewObserver;", "setWebViewObserver$vungle_ads_release", "(Lcom/vungle/ads/internal/omsdk/WebViewObserver;)V", "handleWebViewError", "", "errorMsg", "url", "didCrash", "isCriticalAsset", "notifyPropertiesChange", "skipCmdQueue", "onPageFinished", "view", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onRenderProcessGone", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "runJavascriptOnWebView", "webView", "injectJs", "setAdVisibility", "setConsentStatus", "collectedConsent", "title", "message", "accept", "deny", "setErrorHandler", "setMraidDelegate", "setWebViewObserver", "shouldOverrideUrlLoading", "Companion", "VungleWebViewRenderProcessClient", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VungleWebClient.kt */
public final class VungleWebClient extends WebViewClient implements WebViewAPI {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "VungleWebClient";
    private final AdPayload advertisement;
    private boolean collectConsent;
    private WebViewAPI.WebClientErrorHandler errorHandler;
    private String gdprAccept;
    private String gdprBody;
    private String gdprDeny;
    private String gdprTitle;
    private Boolean isViewable;
    private WebView loadedWebView;
    private WebViewAPI.MraidDelegate mraidDelegate;
    private final ExecutorService offloadExecutor;
    private final Placement placement;
    private boolean ready;
    private WebViewObserver webViewObserver;

    public static /* synthetic */ void getCollectConsent$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getErrorHandler$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprAccept$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprBody$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprDeny$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getGdprTitle$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getLoadedWebView$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getMraidDelegate$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getReady$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getWebViewObserver$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void isViewable$vungle_ads_release$annotations() {
    }

    public VungleWebClient(AdPayload adPayload, Placement placement2, ExecutorService executorService) {
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
        Intrinsics.checkNotNullParameter(placement2, "placement");
        Intrinsics.checkNotNullParameter(executorService, "offloadExecutor");
        this.advertisement = adPayload;
        this.placement = placement2;
        this.offloadExecutor = executorService;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/ui/VungleWebClient$Companion;", "", "()V", "TAG", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VungleWebClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final boolean getCollectConsent$vungle_ads_release() {
        return this.collectConsent;
    }

    public final void setCollectConsent$vungle_ads_release(boolean z) {
        this.collectConsent = z;
    }

    public final String getGdprTitle$vungle_ads_release() {
        return this.gdprTitle;
    }

    public final void setGdprTitle$vungle_ads_release(String str) {
        this.gdprTitle = str;
    }

    public final String getGdprBody$vungle_ads_release() {
        return this.gdprBody;
    }

    public final void setGdprBody$vungle_ads_release(String str) {
        this.gdprBody = str;
    }

    public final String getGdprAccept$vungle_ads_release() {
        return this.gdprAccept;
    }

    public final void setGdprAccept$vungle_ads_release(String str) {
        this.gdprAccept = str;
    }

    public final String getGdprDeny$vungle_ads_release() {
        return this.gdprDeny;
    }

    public final void setGdprDeny$vungle_ads_release(String str) {
        this.gdprDeny = str;
    }

    public final WebView getLoadedWebView$vungle_ads_release() {
        return this.loadedWebView;
    }

    public final void setLoadedWebView$vungle_ads_release(WebView webView) {
        this.loadedWebView = webView;
    }

    public final boolean getReady$vungle_ads_release() {
        return this.ready;
    }

    public final void setReady$vungle_ads_release(boolean z) {
        this.ready = z;
    }

    public final WebViewAPI.MraidDelegate getMraidDelegate$vungle_ads_release() {
        return this.mraidDelegate;
    }

    public final void setMraidDelegate$vungle_ads_release(WebViewAPI.MraidDelegate mraidDelegate2) {
        this.mraidDelegate = mraidDelegate2;
    }

    public final WebViewAPI.WebClientErrorHandler getErrorHandler$vungle_ads_release() {
        return this.errorHandler;
    }

    public final void setErrorHandler$vungle_ads_release(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
        this.errorHandler = webClientErrorHandler;
    }

    public final WebViewObserver getWebViewObserver$vungle_ads_release() {
        return this.webViewObserver;
    }

    public final void setWebViewObserver$vungle_ads_release(WebViewObserver webViewObserver2) {
        this.webViewObserver = webViewObserver2;
    }

    public final Boolean isViewable$vungle_ads_release() {
        return this.isViewable;
    }

    public final void setViewable$vungle_ads_release(Boolean bool) {
        this.isViewable = bool;
    }

    public void setConsentStatus(boolean z, String str, String str2, String str3, String str4) {
        this.collectConsent = z;
        this.gdprTitle = str;
        this.gdprBody = str2;
        this.gdprAccept = str3;
        this.gdprDeny = str4;
    }

    public void setMraidDelegate(WebViewAPI.MraidDelegate mraidDelegate2) {
        this.mraidDelegate = mraidDelegate2;
    }

    @Deprecated(message = "Deprecated in Java")
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Log.d(TAG, "MRAID Command " + str);
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            Log.e(TAG, "Invalid URL ");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (parse == null || parse.getScheme() == null) {
            return false;
        }
        String scheme = parse.getScheme();
        if (Intrinsics.areEqual((Object) scheme, (Object) CampaignEx.JSON_KEY_MRAID)) {
            String host = parse.getHost();
            if (host != null) {
                if (!Intrinsics.areEqual((Object) "propertiesChangeCompleted", (Object) host)) {
                    WebViewAPI.MraidDelegate mraidDelegate2 = this.mraidDelegate;
                    if (mraidDelegate2 != null) {
                        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
                        for (String next : parse.getQueryParameterNames()) {
                            Intrinsics.checkNotNullExpressionValue(next, "param");
                            JsonElementBuildersKt.put(jsonObjectBuilder, next, parse.getQueryParameter(next));
                        }
                        this.offloadExecutor.submit(new VungleWebClient$$ExternalSyntheticLambda1(mraidDelegate2, host, jsonObjectBuilder.build(), new Handler(Looper.getMainLooper()), this, webView));
                    }
                } else if (!this.ready) {
                    JsonObject createMRAIDArgs = this.advertisement.createMRAIDArgs();
                    runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyReadyEvent(" + createMRAIDArgs + ')');
                    this.ready = true;
                }
                return true;
            }
        } else if (StringsKt.equals("http", scheme, true) || StringsKt.equals(ProxyConfig.MATCH_HTTPS, scheme, true)) {
            Log.d(TAG, "Open URL" + str);
            WebViewAPI.MraidDelegate mraidDelegate3 = this.mraidDelegate;
            if (mraidDelegate3 != null) {
                JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
                JsonElementBuildersKt.put(jsonObjectBuilder2, "url", str);
                mraidDelegate3.processCommand("openNonMraid", jsonObjectBuilder2.build());
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-4$lambda-3$lambda-2  reason: not valid java name */
    public static final void m270shouldOverrideUrlLoading$lambda4$lambda3$lambda2(WebViewAPI.MraidDelegate mraidDelegate2, String str, JsonObject jsonObject, Handler handler, VungleWebClient vungleWebClient, WebView webView) {
        Intrinsics.checkNotNullParameter(mraidDelegate2, "$it");
        Intrinsics.checkNotNullParameter(str, "$command");
        Intrinsics.checkNotNullParameter(jsonObject, "$args");
        Intrinsics.checkNotNullParameter(handler, "$handler");
        Intrinsics.checkNotNullParameter(vungleWebClient, "this$0");
        if (mraidDelegate2.processCommand(str, jsonObject)) {
            handler.post(new VungleWebClient$$ExternalSyntheticLambda0(vungleWebClient, webView));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: shouldOverrideUrlLoading$lambda-4$lambda-3$lambda-2$lambda-1  reason: not valid java name */
    public static final void m271shouldOverrideUrlLoading$lambda4$lambda3$lambda2$lambda1(VungleWebClient vungleWebClient, WebView webView) {
        Intrinsics.checkNotNullParameter(vungleWebClient, "this$0");
        vungleWebClient.runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyCommandComplete()");
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (webView != null) {
            this.loadedWebView = webView;
            if (webView != null) {
                webView.setVisibility(0);
            }
            notifyPropertiesChange(true);
            if (Build.VERSION.SDK_INT >= 29) {
                webView.setWebViewRenderProcessClient(new VungleWebViewRenderProcessClient(this.errorHandler));
            }
            WebViewObserver webViewObserver2 = this.webViewObserver;
            if (webViewObserver2 != null) {
                webViewObserver2.onPageFinished(webView);
            }
        }
    }

    public void notifyPropertiesChange(boolean z) {
        WebView webView = this.loadedWebView;
        if (webView != null) {
            JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
            JsonObjectBuilder jsonObjectBuilder2 = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder2, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, (Number) Integer.valueOf(webView.getWidth()));
            JsonElementBuildersKt.put(jsonObjectBuilder2, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, (Number) Integer.valueOf(webView.getHeight()));
            JsonObject build = jsonObjectBuilder2.build();
            JsonObjectBuilder jsonObjectBuilder3 = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder3, "x", (Number) 0);
            JsonElementBuildersKt.put(jsonObjectBuilder3, "y", (Number) 0);
            JsonElementBuildersKt.put(jsonObjectBuilder3, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, (Number) Integer.valueOf(webView.getWidth()));
            JsonElementBuildersKt.put(jsonObjectBuilder3, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, (Number) Integer.valueOf(webView.getHeight()));
            JsonObject build2 = jsonObjectBuilder3.build();
            JsonObjectBuilder jsonObjectBuilder4 = new JsonObjectBuilder();
            JsonElementBuildersKt.put(jsonObjectBuilder4, "sms", (Boolean) false);
            JsonElementBuildersKt.put(jsonObjectBuilder4, "tel", (Boolean) false);
            JsonElementBuildersKt.put(jsonObjectBuilder4, "calendar", (Boolean) false);
            JsonElementBuildersKt.put(jsonObjectBuilder4, "storePicture", (Boolean) false);
            JsonElementBuildersKt.put(jsonObjectBuilder4, "inlineVideo", (Boolean) false);
            JsonObject build3 = jsonObjectBuilder4.build();
            JsonElement jsonElement = build;
            jsonObjectBuilder.put("maxSize", jsonElement);
            jsonObjectBuilder.put("screenSize", jsonElement);
            JsonElement jsonElement2 = build2;
            jsonObjectBuilder.put("defaultPosition", jsonElement2);
            jsonObjectBuilder.put("currentPosition", jsonElement2);
            jsonObjectBuilder.put("supports", build3);
            JsonElementBuildersKt.put(jsonObjectBuilder, "placementType", this.advertisement.templateType());
            Boolean bool = this.isViewable;
            if (bool != null) {
                JsonElementBuildersKt.put(jsonObjectBuilder, "isViewable", Boolean.valueOf(bool.booleanValue()));
            }
            JsonElementBuildersKt.put(jsonObjectBuilder, "os", "android");
            JsonElementBuildersKt.put(jsonObjectBuilder, "osVersion", String.valueOf(Build.VERSION.SDK_INT));
            JsonElementBuildersKt.put(jsonObjectBuilder, "incentivized", this.placement.getIncentivized());
            JsonElementBuildersKt.put(jsonObjectBuilder, "enableBackImmediately", (Number) Integer.valueOf(this.advertisement.getShowCloseDelay(this.placement.getIncentivized())));
            JsonElementBuildersKt.put(jsonObjectBuilder, "version", "1.0");
            if (this.collectConsent) {
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentRequired", (Boolean) true);
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentTitleText", this.gdprTitle);
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentBodyText", this.gdprBody);
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentAcceptButtonText", this.gdprAccept);
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentDenyButtonText", this.gdprDeny);
            } else {
                JsonElementBuildersKt.put(jsonObjectBuilder, "consentRequired", (Boolean) false);
            }
            JsonElementBuildersKt.put(jsonObjectBuilder, "sdkVersion", BuildConfig.VERSION_NAME);
            JsonObject build4 = jsonObjectBuilder.build();
            Log.d(TAG, "loadJs->javascript:window.vungle.mraidBridge.notifyPropertiesChange(" + build4 + AbstractJsonLexerKt.COMMA + z + ')');
            runJavascriptOnWebView(webView, "window.vungle.mraidBridge.notifyPropertiesChange(" + build4 + AbstractJsonLexerKt.COMMA + z + ')');
        }
    }

    public void setAdVisibility(boolean z) {
        this.isViewable = Boolean.valueOf(z);
        notifyPropertiesChange(false);
    }

    public void setErrorHandler(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
        Intrinsics.checkNotNullParameter(webClientErrorHandler, "errorHandler");
        this.errorHandler = webClientErrorHandler;
    }

    public void setWebViewObserver(WebViewObserver webViewObserver2) {
        this.webViewObserver = webViewObserver2;
    }

    @Deprecated(message = "Deprecated in Java")
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "description");
        Intrinsics.checkNotNullParameter(str2, "failingUrl");
        super.onReceivedError(webView, i, str, str2);
        if (Build.VERSION.SDK_INT < 23) {
            boolean isCriticalAsset = isCriticalAsset(str2);
            Log.e(TAG, "Error desc " + str + " for URL " + str2);
            handleWebViewError(str, str2, isCriticalAsset);
        }
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (Build.VERSION.SDK_INT >= 21) {
            Uri uri = null;
            String valueOf = String.valueOf(webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null);
            if (webResourceRequest != null) {
                uri = webResourceRequest.getUrl();
            }
            String valueOf2 = String.valueOf(uri);
            boolean z = true;
            boolean z2 = webResourceRequest != null && webResourceRequest.isForMainFrame();
            Log.e(TAG, "Http Error desc " + valueOf + ' ' + z2 + " for URL " + valueOf2);
            if (!isCriticalAsset(valueOf2) || !z2) {
                z = false;
            }
            handleWebViewError(valueOf, valueOf2, z);
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (Build.VERSION.SDK_INT >= 23) {
            Uri uri = null;
            String valueOf = String.valueOf(webResourceError != null ? webResourceError.getDescription() : null);
            if (webResourceRequest != null) {
                uri = webResourceRequest.getUrl();
            }
            String valueOf2 = String.valueOf(uri);
            boolean z = true;
            boolean z2 = webResourceRequest != null && webResourceRequest.isForMainFrame();
            Log.e(TAG, "Error desc " + valueOf + ' ' + z2 + " for URL " + valueOf2);
            if (!isCriticalAsset(valueOf2) || !z2) {
                z = false;
            }
            handleWebViewError(valueOf, valueOf2, z);
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        StringBuilder sb = new StringBuilder("onRenderProcessGone url: ");
        Boolean bool = null;
        sb.append(webView != null ? webView.getUrl() : null);
        sb.append(", did crash: ");
        sb.append(renderProcessGoneDetail != null ? Boolean.valueOf(renderProcessGoneDetail.didCrash()) : null);
        Log.w(TAG, sb.toString());
        this.loadedWebView = null;
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler == null) {
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }
        if (renderProcessGoneDetail != null) {
            bool = Boolean.valueOf(renderProcessGoneDetail.didCrash());
        }
        return webClientErrorHandler.onWebRenderingProcessGone(webView, bool);
    }

    private final void handleWebViewError(String str, String str2, boolean z) {
        String str3 = str2 + ' ' + str;
        WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
        if (webClientErrorHandler != null) {
            webClientErrorHandler.onReceivedError(str3, z);
        }
    }

    private final boolean isCriticalAsset(String str) {
        if (str.length() > 0) {
            return this.advertisement.getDownloadableUrls().containsValue(str);
        }
        return false;
    }

    private final void runJavascriptOnWebView(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.evaluateJavascript(str, (ValueCallback) null);
            } catch (Exception e) {
                AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
                analyticsClient.logError$vungle_ads_release(313, "Evaluate js failed " + e.getLocalizedMessage(), this.placement.getReferenceId(), this.advertisement.getCreativeId(), this.advertisement.eventId());
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/vungle/ads/internal/ui/VungleWebClient$VungleWebViewRenderProcessClient;", "Landroid/webkit/WebViewRenderProcessClient;", "errorHandler", "Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;", "(Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;)V", "getErrorHandler", "()Lcom/vungle/ads/internal/ui/view/WebViewAPI$WebClientErrorHandler;", "setErrorHandler", "onRenderProcessResponsive", "", "webView", "Landroid/webkit/WebView;", "webViewRenderProcess", "Landroid/webkit/WebViewRenderProcess;", "onRenderProcessUnresponsive", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: VungleWebClient.kt */
    public static final class VungleWebViewRenderProcessClient extends WebViewRenderProcessClient {
        private WebViewAPI.WebClientErrorHandler errorHandler;

        public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            Intrinsics.checkNotNullParameter(webView, "webView");
        }

        public final WebViewAPI.WebClientErrorHandler getErrorHandler() {
            return this.errorHandler;
        }

        public final void setErrorHandler(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
            this.errorHandler = webClientErrorHandler;
        }

        public VungleWebViewRenderProcessClient(WebViewAPI.WebClientErrorHandler webClientErrorHandler) {
            this.errorHandler = webClientErrorHandler;
        }

        public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
            Intrinsics.checkNotNullParameter(webView, "webView");
            StringBuilder sb = new StringBuilder("onRenderProcessUnresponsive(Title = ");
            sb.append(webView.getTitle());
            sb.append(", URL = ");
            sb.append(webView.getOriginalUrl());
            sb.append(", (webViewRenderProcess != null) = ");
            sb.append(webViewRenderProcess != null);
            Log.w(VungleWebClient.TAG, sb.toString());
            WebViewAPI.WebClientErrorHandler webClientErrorHandler = this.errorHandler;
            if (webClientErrorHandler != null) {
                webClientErrorHandler.onRenderProcessUnresponsive(webView, webViewRenderProcess);
            }
        }
    }
}
