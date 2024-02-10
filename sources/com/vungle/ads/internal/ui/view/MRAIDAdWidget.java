package com.vungle.ads.internal.ui.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Paint;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebViewRenderProcessClient;
import android.widget.RelativeLayout;
import com.vungle.ads.internal.util.HandlerScheduler;
import com.vungle.ads.internal.util.ViewUtility;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\u0018\u0000 92\u00020\u0001:\u00076789:;<B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010#\u001a\u00020\"H\u0003J\u0006\u0010$\u001a\u00020\"J\u000e\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020\"H\u0014J\u0006\u0010,\u001a\u00020\"J\b\u0010-\u001a\u00020\"H\u0002J\u0006\u0010.\u001a\u00020\"J\u000e\u0010/\u001a\u00020\"2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u00100\u001a\u00020\"2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u000e\u00101\u001a\u00020\"2\u0006\u00102\u001a\u000203J\u0010\u00104\u001a\u00020\"2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u00105\u001a\u00020\"2\u0006\u0010\u001b\u001a\u00020\u001cR&\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "closeDelegate", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$CloseDelegate;", "getCloseDelegate$vungle_ads_release$annotations", "()V", "getCloseDelegate$vungle_ads_release", "()Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$CloseDelegate;", "setCloseDelegate$vungle_ads_release", "(Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$CloseDelegate;)V", "onViewTouchListener", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OnViewTouchListener;", "getOnViewTouchListener$vungle_ads_release$annotations", "getOnViewTouchListener$vungle_ads_release", "()Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OnViewTouchListener;", "setOnViewTouchListener$vungle_ads_release", "(Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OnViewTouchListener;)V", "orientationDelegate", "Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OrientationDelegate;", "getOrientationDelegate$vungle_ads_release$annotations", "getOrientationDelegate$vungle_ads_release", "()Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OrientationDelegate;", "setOrientationDelegate$vungle_ads_release", "(Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OrientationDelegate;)V", "url", "", "getUrl", "()Ljava/lang/String;", "webView", "Landroid/webkit/WebView;", "applyDefault", "", "bindListeners", "close", "destroyWebView", "webViewDestroyDelay", "", "linkWebView", "vngWebViewClient", "Landroid/webkit/WebViewClient;", "onAttachedToWindow", "pauseWeb", "prepare", "resumeWeb", "setCloseDelegate", "setOnViewTouchListener", "setOrientation", "requestedOrientation", "", "setOrientationDelegate", "showWebsite", "AdStopReason", "AudioContextWrapper", "CloseDelegate", "Companion", "DestroyRunnable", "OnViewTouchListener", "OrientationDelegate", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MRAIDAdWidget.kt */
public final class MRAIDAdWidget extends RelativeLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "MRAIDAdWidget";
    private CloseDelegate closeDelegate;
    private OnViewTouchListener onViewTouchListener;
    private OrientationDelegate orientationDelegate;
    private WebView webView;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$CloseDelegate;", "", "close", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MRAIDAdWidget.kt */
    public interface CloseDelegate {
        void close();
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OnViewTouchListener;", "", "onTouch", "", "event", "Landroid/view/MotionEvent;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MRAIDAdWidget.kt */
    public interface OnViewTouchListener {
        boolean onTouch(MotionEvent motionEvent);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$OrientationDelegate;", "", "setOrientation", "", "orientation", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MRAIDAdWidget.kt */
    public interface OrientationDelegate {
        void setOrientation(int i);
    }

    public static /* synthetic */ void getCloseDelegate$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getOnViewTouchListener$vungle_ads_release$annotations() {
    }

    public static /* synthetic */ void getOrientationDelegate$vungle_ads_release$annotations() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MRAIDAdWidget(Context context) throws InstantiationException {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        setLayoutParams(layoutParams);
        WebView webView2 = ViewUtility.INSTANCE.getWebView(context);
        this.webView = webView2;
        if (webView2 != null) {
            webView2.setLayoutParams(layoutParams);
        }
        if (webView2 != null) {
            webView2.setTag("VungleWebView");
        }
        addView(webView2, layoutParams);
        bindListeners();
        prepare();
    }

    public final OnViewTouchListener getOnViewTouchListener$vungle_ads_release() {
        return this.onViewTouchListener;
    }

    public final void setOnViewTouchListener$vungle_ads_release(OnViewTouchListener onViewTouchListener2) {
        this.onViewTouchListener = onViewTouchListener2;
    }

    public final CloseDelegate getCloseDelegate$vungle_ads_release() {
        return this.closeDelegate;
    }

    public final void setCloseDelegate$vungle_ads_release(CloseDelegate closeDelegate2) {
        this.closeDelegate = closeDelegate2;
    }

    public final OrientationDelegate getOrientationDelegate$vungle_ads_release() {
        return this.orientationDelegate;
    }

    public final void setOrientationDelegate$vungle_ads_release(OrientationDelegate orientationDelegate2) {
        this.orientationDelegate = orientationDelegate2;
    }

    private final void bindListeners() {
        WebView webView2;
        OnViewTouchListener onViewTouchListener2 = this.onViewTouchListener;
        if (onViewTouchListener2 != null && (webView2 = this.webView) != null) {
            webView2.setOnTouchListener(new MRAIDAdWidget$$ExternalSyntheticLambda0(onViewTouchListener2));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bindListeners$lambda-1$lambda-0  reason: not valid java name */
    public static final boolean m2329bindListeners$lambda1$lambda0(OnViewTouchListener onViewTouchListener2, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(onViewTouchListener2, "$it");
        return onViewTouchListener2.onTouch(motionEvent);
    }

    private final void prepare() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setLayerType(2, (Paint) null);
            webView2.setBackgroundColor(0);
            webView2.getSettings().setMediaPlaybackRequiresUserGesture(false);
            webView2.setVisibility(8);
        }
    }

    public final void setCloseDelegate(CloseDelegate closeDelegate2) {
        Intrinsics.checkNotNullParameter(closeDelegate2, "closeDelegate");
        this.closeDelegate = closeDelegate2;
    }

    public final void setOnViewTouchListener(OnViewTouchListener onViewTouchListener2) {
        this.onViewTouchListener = onViewTouchListener2;
    }

    public final void setOrientationDelegate(OrientationDelegate orientationDelegate2) {
        this.orientationDelegate = orientationDelegate2;
    }

    public final void close() {
        CloseDelegate closeDelegate2 = this.closeDelegate;
        if (closeDelegate2 != null) {
            closeDelegate2.close();
        }
    }

    public final void setOrientation(int i) {
        OrientationDelegate orientationDelegate2 = this.orientationDelegate;
        if (orientationDelegate2 != null) {
            orientationDelegate2.setOrientation(i);
        }
    }

    public final void linkWebView(WebViewClient webViewClient) {
        Intrinsics.checkNotNullParameter(webViewClient, "vngWebViewClient");
        WebView webView2 = this.webView;
        if (webView2 != null) {
            applyDefault(webView2);
            webView2.setWebViewClient(webViewClient);
        }
    }

    public final void showWebsite(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        Log.d(TAG, "loadUrl: " + str);
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setVisibility(0);
            webView2.loadUrl(str);
        }
    }

    private final void applyDefault(WebView webView2) {
        WebSettings settings = webView2.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        settings.setBuiltInZoomControls(false);
        settings.setJavaScriptEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setSaveFormData(true);
        settings.setUseWideViewPort(false);
        settings.setAllowFileAccess(true);
        webView2.setVisibility(4);
        settings.setMediaPlaybackRequiresUserGesture(false);
    }

    public final void pauseWeb() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.onPause();
        }
    }

    public final void resumeWeb() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.onResume();
        }
    }

    public final String getUrl() {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            return webView2.getUrl();
        }
        return null;
    }

    public final void destroyWebView(long j) {
        WebView webView2 = this.webView;
        if (webView2 != null) {
            webView2.setWebChromeClient((WebChromeClient) null);
            removeAllViews();
            if (j <= 0) {
                new DestroyRunnable(webView2).run();
            } else {
                new HandlerScheduler().schedule(new DestroyRunnable(webView2), j);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$DestroyRunnable;", "Ljava/lang/Runnable;", "webView", "Landroid/webkit/WebView;", "(Landroid/webkit/WebView;)V", "run", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MRAIDAdWidget.kt */
    private static final class DestroyRunnable implements Runnable {
        private final WebView webView;

        public DestroyRunnable(WebView webView2) {
            Intrinsics.checkNotNullParameter(webView2, "webView");
            this.webView = webView2;
        }

        public void run() {
            try {
                this.webView.stopLoading();
                if (Build.VERSION.SDK_INT >= 29) {
                    this.webView.setWebViewRenderProcessClient((WebViewRenderProcessClient) null);
                }
                this.webView.loadData("", (String) null, (String) null);
                this.webView.destroy();
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        ViewGroup.LayoutParams layoutParams;
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.height = -1;
            layoutParams2.width = -1;
        }
        WebView webView2 = this.webView;
        if (webView2 != null && (layoutParams = webView2.getLayoutParams()) != null) {
            layoutParams.height = -1;
            layoutParams.width = -1;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$AudioContextWrapper;", "Landroid/content/ContextWrapper;", "base", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getSystemService", "", "name", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MRAIDAdWidget.kt */
    public static final class AudioContextWrapper extends ContextWrapper {
        public AudioContextWrapper(Context context) {
            super(context);
        }

        public Object getSystemService(String str) {
            Object obj;
            Intrinsics.checkNotNullParameter(str, "name");
            if (Intrinsics.areEqual((Object) "audio", (Object) str)) {
                obj = getApplicationContext().getSystemService(str);
            } else {
                obj = super.getSystemService(str);
            }
            Intrinsics.checkNotNullExpressionValue(obj, "if (AUDIO_SERVICE == nam…rvice(name)\n            }");
            return obj;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$Companion;", "", "()V", "TAG", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MRAIDAdWidget.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$AdStopReason;", "", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: MRAIDAdWidget.kt */
    public @interface AdStopReason {
        public static final Companion Companion = Companion.$$INSTANCE;
        public static final int IS_AD_FINISHED_BY_API = 4;
        public static final int IS_AD_FINISHING = 2;
        public static final int IS_CHANGING_CONFIGURATION = 1;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/vungle/ads/internal/ui/view/MRAIDAdWidget$AdStopReason$Companion;", "", "()V", "IS_AD_FINISHED_BY_API", "", "IS_AD_FINISHING", "IS_CHANGING_CONFIGURATION", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: MRAIDAdWidget.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            public static final int IS_AD_FINISHED_BY_API = 4;
            public static final int IS_AD_FINISHING = 2;
            public static final int IS_CHANGING_CONFIGURATION = 1;

            private Companion() {
            }
        }
    }
}
