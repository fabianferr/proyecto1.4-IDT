package com.ironsource.mediationsdk.testSuite.e;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import com.ironsource.mediationsdk.testSuite.d;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\tJ\u0006\u0010\u0019\u001a\u00020\fJ\u001e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u000e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dJ\b\u0010\u001f\u001a\u0004\u0018\u00010\fJ(\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020#2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dH\u0016J\"\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0003R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/webView/TestSuiteWebViewWrapper;", "Lcom/ironsource/mediationsdk/testSuite/listeners/TestSuiteJavaScriptEvaluatorListener;", "activity", "Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;", "uiLifeCycleListener", "Lcom/ironsource/mediationsdk/testSuite/listeners/ITestSuiteUILifeCycleListener;", "jsonData", "Lorg/json/JSONObject;", "controllerUrl", "", "(Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;Lcom/ironsource/mediationsdk/testSuite/listeners/ITestSuiteUILifeCycleListener;Lorg/json/JSONObject;Ljava/lang/String;)V", "mAppWebView", "Landroid/webkit/WebView;", "mHandler", "Landroid/os/Handler;", "mInjectData", "", "mJsonData", "mLoadingScreenMinimumTimeExceeded", "mLoadingScreenWebView", "destroy", "", "destroyLoadingScreenWebView", "evalScript", "script", "getAppWebView", "getJsEvalScript", "methodName", "methodArgs", "", "", "getLoadingScreenWebView", "onAdCallbackReceived", "callbackName", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "args", "setupWebView", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b implements com.ironsource.mediationsdk.testSuite.c.b {
    final Handler a;
    public WebView b;
    public final WebView c;
    final JSONObject d;
    boolean e;
    boolean f;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J \u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/ironsource/mediationsdk/testSuite/webView/TestSuiteWebViewWrapper$setupWebView$1", "Landroid/webkit/WebViewClient;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a extends WebViewClient {
        private /* synthetic */ b a;
        private /* synthetic */ String b;

        a(b bVar, String str) {
            this.a = bVar;
            this.b = str;
        }

        public final void onPageFinished(WebView webView, String str) {
            if (!this.a.e && str != null && StringsKt.startsWith$default(str, String.valueOf(this.b), false, 2, (Object) null)) {
                b bVar = this.a;
                List listOf = CollectionsKt.listOf(bVar.d);
                Intrinsics.checkNotNull(listOf, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
                bVar.a(b.a("onDataReady", (List<? extends Object>) listOf));
                com.ironsource.mediationsdk.testSuite.b.a.a.a(73, (Integer) null, (String) null);
                this.a.e = true;
            }
            super.onPageFinished(webView, str);
        }

        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            Intrinsics.checkNotNullParameter(webView, "view");
            Intrinsics.checkNotNullParameter(webResourceRequest, "request");
            Intrinsics.checkNotNullParameter(webResourceError, "error");
            com.ironsource.mediationsdk.testSuite.b.a aVar = com.ironsource.mediationsdk.testSuite.b.a.a;
            String webResourceError2 = webResourceError.toString();
            Intrinsics.checkNotNullParameter(webResourceError2, "errorReason");
            aVar.a(74, Integer.valueOf(IronSourceConstants.errorCode_TEST_SUITE_WEB_CONTROLLER_NOT_LOADED), webResourceError2);
            d dVar = d.a;
            d.a("got error during TestSuite web controller loading " + webResourceError);
            super.onReceivedError(webView, webResourceRequest, webResourceError);
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/ironsource/mediationsdk/testSuite/webView/TestSuiteWebViewWrapper$setupWebView$webViewWrapperListener$1", "Lcom/ironsource/mediationsdk/testSuite/listeners/ITestSuiteUILifeCycleListener;", "onClosed", "", "onUIReady", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.ironsource.mediationsdk.testSuite.e.b$b  reason: collision with other inner class name */
    public static final class C0116b implements com.ironsource.mediationsdk.testSuite.c.a {
        private /* synthetic */ b a;
        private /* synthetic */ com.ironsource.mediationsdk.testSuite.c.a b;

        C0116b(b bVar, com.ironsource.mediationsdk.testSuite.c.a aVar) {
            this.a = bVar;
            this.b = aVar;
        }

        /* access modifiers changed from: private */
        public static final void a(C0116b bVar) {
            Intrinsics.checkNotNullParameter(bVar, "this$0");
            bVar.onUIReady();
        }

        public final void onClosed() {
            this.b.onClosed();
        }

        public final void onUIReady() {
            if (this.a.f) {
                this.b.onUIReady();
            } else {
                this.a.a.postDelayed(new b$b$$ExternalSyntheticLambda0(this), 500);
            }
        }
    }

    public b(TestSuiteActivity testSuiteActivity, com.ironsource.mediationsdk.testSuite.c.a aVar, JSONObject jSONObject, String str) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "activity");
        Intrinsics.checkNotNullParameter(aVar, "uiLifeCycleListener");
        Intrinsics.checkNotNullParameter(jSONObject, "jsonData");
        Handler handler = new Handler(testSuiteActivity.getMainLooper());
        this.a = handler;
        Context context = testSuiteActivity;
        this.b = new WebView(context);
        WebView webView = new WebView(context);
        this.c = webView;
        this.d = jSONObject;
        WebView webView2 = this.b;
        WebSettings settings = webView2 != null ? webView2.getSettings() : null;
        boolean z = true;
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new a(new com.ironsource.mediationsdk.testSuite.a(testSuiteActivity, handler), new C0116b(this, aVar), this), "TestSuiteBridge");
        webView.setWebViewClient(new a(this, str));
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z) {
            webView.loadUrl(str);
        }
        WebView webView3 = this.b;
        if (webView3 != null) {
            webView3.loadUrl("javascript:document.write(atob('PGh0bWw+PGhlYWQ+CiAgICA8bWV0YSBuYW1lPSJ2aWV3cG9ydCIgY29udGVudD0id2lkdGg9ZGV2aWNlLXdpZHRoLCBpbml0aWFsLXNjYWxlPTEiPgogICAgPHN0eWxlPgogICAgICAgIC5jb250YWluZXIgewogICAgICAgICAgICBmbGV4LWRpcmVjdGlvbjogY29sdW1uOwogICAgICAgIH0KCiAgICAgICAgLmZsZXgtY29udGFpbmVyIHsKICAgICAgICAgICAgZGlzcGxheTogZmxleDsKICAgICAgICAgICAgYWxpZ24taXRlbXM6IGNlbnRlcjsKICAgICAgICAgICAgZmxleC1kaXJlY3Rpb246IGNvbHVtbjsKICAgICAgICAgICAganVzdGlmeS1jb250ZW50OiBmbGV4LWVuZDsKICAgICAgICB9CgogICAgICAgIC5sb2FkaW5nIHsKICAgICAgICAgICAganVzdGlmeS1jb250ZW50OiBzdGFydDsKICAgICAgICB9CgogICAgICAgIC5sZHMtZWxsaXBzaXMgewogICAgICAgICAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7CiAgICAgICAgICAgIHBvc2l0aW9uOiByZWxhdGl2ZTsKICAgICAgICAgICAgd2lkdGg6IDgwcHg7CiAgICAgICAgICAgIGhlaWdodDogODBweDsKICAgICAgICB9CgogICAgICAgIC5sZHMtZWxsaXBzaXMgZGl2IHsKICAgICAgICAgICAgcG9zaXRpb246IGFic29sdXRlOwogICAgICAgICAgICB0b3A6IDMzcHg7CiAgICAgICAgICAgIHdpZHRoOiAxM3B4OwogICAgICAgICAgICBoZWlnaHQ6IDEzcHg7CiAgICAgICAgICAgIGJvcmRlci1yYWRpdXM6IDUwJTsKICAgICAgICAgICAgYmFja2dyb3VuZDogI0E3QTdBNzsKICAgICAgICAgICAgYW5pbWF0aW9uLXRpbWluZy1mdW5jdGlvbjogY3ViaWMtYmV6aWVyKDAsIDEsIDEsIDApOwogICAgICAgIH0KCiAgICAgICAgLmxkcy1lbGxpcHNpcyBkaXY6bnRoLWNoaWxkKDEpIHsKICAgICAgICAgICAgbGVmdDogOHB4OwogICAgICAgICAgICBhbmltYXRpb246IGxkcy1lbGxpcHNpczEgMC42cyBpbmZpbml0ZTsKICAgICAgICB9CgogICAgICAgIC5sZHMtZWxsaXBzaXMgZGl2Om50aC1jaGlsZCgyKSB7CiAgICAgICAgICAgIGxlZnQ6IDhweDsKICAgICAgICAgICAgYW5pbWF0aW9uOiBsZHMtZWxsaXBzaXMyIDAuNnMgaW5maW5pdGU7CiAgICAgICAgfQoKICAgICAgICAubGRzLWVsbGlwc2lzIGRpdjpudGgtY2hpbGQoMykgewogICAgICAgICAgICBsZWZ0OiAzMnB4OwogICAgICAgICAgICBhbmltYXRpb246IGxkcy1lbGxpcHNpczIgMC42cyBpbmZpbml0ZTsKICAgICAgICB9CgogICAgICAgIC5sZHMtZWxsaXBzaXMgZGl2Om50aC1jaGlsZCg0KSB7CiAgICAgICAgICAgIGxlZnQ6IDU2cHg7CiAgICAgICAgICAgIGFuaW1hdGlvbjogbGRzLWVsbGlwc2lzMyAwLjZzIGluZmluaXRlOwogICAgICAgIH0KCiAgICAgICAgQGtleWZyYW1lcyBsZHMtZWxsaXBzaXMxIHsKICAgICAgICAgICAgMCUgewogICAgICAgICAgICAgICAgdHJhbnNmb3JtOiBzY2FsZSgwKTsKICAgICAgICAgICAgfQoKICAgICAgICAgICAgMTAwJSB7CiAgICAgICAgICAgICAgICB0cmFuc2Zvcm06IHNjYWxlKDEpOwogICAgICAgICAgICB9CiAgICAgICAgfQoKICAgICAgICBAa2V5ZnJhbWVzIGxkcy1lbGxpcHNpczMgewogICAgICAgICAgICAwJSB7CiAgICAgICAgICAgICAgICB0cmFuc2Zvcm06IHNjYWxlKDEpOwogICAgICAgICAgICB9CgogICAgICAgICAgICAxMDAlIHsKICAgICAgICAgICAgICAgIHRyYW5zZm9ybTogc2NhbGUoMCk7CiAgICAgICAgICAgIH0KICAgICAgICB9CgogICAgICAgIEBrZXlmcmFtZXMgbGRzLWVsbGlwc2lzMiB7CiAgICAgICAgICAgIDAlIHsKICAgICAgICAgICAgICAgIHRyYW5zZm9ybTogdHJhbnNsYXRlKDAsIDApOwogICAgICAgICAgICB9CgogICAgICAgICAgICAxMDAlIHsKICAgICAgICAgICAgICAgIHRyYW5zZm9ybTogdHJhbnNsYXRlKDI0cHgsIDApOwogICAgICAgICAgICB9CiAgICAgICAgfQogICAgPC9zdHlsZT4KPC9oZWFkPgoKPGJvZHk+CiAgICA8ZGl2IGlkPSJsb2FkaW5nX3dyYXBwZXIiIHN0eWxlPSJkaXNwbGF5OiBmbGV4O2ZsZXgtZGlyZWN0aW9uOiBjb2x1bW47anVzdGlmeS1jb250ZW50OiBzcGFjZS1iZXR3ZWVuO2hlaWdodDogMTAwJTsiPgo8ZGl2IGNsYXNzPSJjb250YWluZXIgZmxleC1jb250YWluZXIiIHN0eWxlPSIKICAgIGZsZXg6IDE7CiI+CiAgICAgICAgPGRpdiBjbGFzcz0iZmxleC1jb250YWluZXIiIHN0eWxlPSIKICAgIGZsZXg6IDE7CiI+CiAgICAgICAgICAgIDxzdmcgd2lkdGg9IjIzNiIgaGVpZ2h0PSI0NCIgdmlld0JveD0iMCAwIDIzNiA0NCIgZmlsbD0ibm9uZSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIj4KICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0zNy44MDYzIDMwLjI4NTRWMTAuNDI4NUwyMC42MTI5IDAuNVY4LjExNjM2TDI3LjM1MDggMTIuMDA5NUMyNy41OTQ1IDEyLjE0NTUgMjcuNjAwMiAxMi41MjUyIDI3LjM1MDggMTIuNjYxMkwxOS4zNDM1IDE3LjI4NTVDMTkuMDk5OCAxNy40MjcxIDE4LjgxNjQgMTcuNDE1OCAxOC41ODk4IDE3LjI4NTVMMTAuNTc2OCAxMi42NjEyQzEwLjMzMzEgMTIuNTI1MiAxMC4zMjc0IDEyLjE0NTUgMTAuNTc2OCAxMi4wMDk1TDE3LjMxNDcgOC4xMjIwMlYwLjUwNTY2OEwwLjExNTY0NiAxMC40Mjg1VjMwLjI4NTRWMzAuMTk0N1YzMC4yODU0TDYuNzExOTMgMjYuNDc3MlYxOC42OTY1QzYuNzA2MjYgMTguNDE4OCA3LjAzNDk0IDE4LjIyMDUgNy4yNzg2MiAxOC4zNzM1TDE1LjI4NiAyMi45OTc3QzE1LjUyOTYgMjMuMTM5NCAxNS42NjU2IDIzLjM4ODcgMTUuNjY1NiAyMy42NDk0VjMyLjg5NzlDMTUuNjcxMyAzMy4xNzU1IDE1LjM0ODMgMzMuMzczOSAxNS4xMDQ2IDMzLjIyNjVMOC4zNjY2NyAyOS4zMzM0TDEuNzcwMzggMzMuMTQxNUwxOC45Njk1IDQzLjA3TDM2LjE2ODUgMzMuMTQxNUwyOS41NjA5IDI5LjMzMzRMMjIuODIyOSAzMy4yMjY1QzIyLjU4NDkgMzMuMzY4MiAyMi4yNTA2IDMzLjE4NjkgMjIuMjU2MyAzMi44OTc5VjIzLjY0OTRDMjIuMjU2MyAyMy4zNzE3IDIyLjQwOTMgMjMuMTI4MSAyMi42MzU5IDIyLjk5NzdMMzAuNjQzMyAxOC4zNzM1QzMwLjg4MTMgMTguMjI2MiAzMS4yMTU2IDE4LjQxMzIgMzEuMjEgMTguNzAyMlYyNi40ODI5TDM3LjgwNjMgMzAuMjg1NFoiIGZpbGw9IiM0RDRENEQiPjwvcGF0aD4KICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xNS4wOTkgMzMuMjI2Mkw4LjM2MTA2IDI5LjMzM0wxLjc2NDc4IDMzLjE0MTJMMTguOTYzOCA0My4wNjk2VjIxLjMwODZMMC4xMTU3MDcgMTAuNDI4MVYzMC4yODVWMzAuMTk0NFYzMC4yODVMNi43MTE5OSAyNi40NzY5VjE4LjY5NjJDNi43MDYzMiAxOC40MTg1IDcuMDM1IDE4LjIyMDEgNy4yNzg2OCAxOC4zNzMxTDE1LjI4NiAyMi45OTc0QzE1LjUyOTcgMjMuMTM5IDE1LjY2NTcgMjMuMzg4NCAxNS42NjU3IDIzLjY0OTFWMzIuODk3NUMxNS42NzE0IDMzLjE3NTIgMTUuMzQyNyAzMy4zNzM1IDE1LjA5OSAzMy4yMjYyWiIgZmlsbD0iIzRDNEM0QyI+PC9wYXRoPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTE4Ljk2MzcgNDMuMDY5NkwzNi4xNjI4IDMzLjE0MTJMMjkuNTYwOSAyOS4zMzNMMjIuODIyOSAzMy4yMjYyQzIyLjU4NDkgMzMuMzY3OCAyMi4yNTA1IDMzLjE4NjUgMjIuMjU2MiAzMi44OTc1VjIzLjY0OTFDMjIuMjU2MiAyMy4zNzE0IDIyLjQwOTIgMjMuMTI3NyAyMi42MzU5IDIyLjk5NzRMMzAuNjQzMiAxOC4zNzMxQzMwLjg4MTIgMTguMjI1OCAzMS4yMTU2IDE4LjQxMjggMzEuMjA5OSAxOC43MDE4VjI2LjQ4MjVMMzcuODA2MiAzMC4yOTA3VjEwLjQyODFMMTguOTYzNyAyMS4zMDg2VjQzLjA2OTZaIiBmaWxsPSJibGFjayI+PC9wYXRoPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTIwLjYxMjkgMC41VjguMTE2MzZMMjcuMzUwOCAxMi4wMDk1QzI3LjU5NDUgMTIuMTQ1NSAyNy42MDAyIDEyLjUyNTIgMjcuMzUwOCAxMi42NjEyTDE5LjM0MzUgMTcuMjg1NUMxOS4wOTk4IDE3LjQyNzEgMTguODE2NCAxNy40MTU4IDE4LjU4OTggMTcuMjg1NUwxMC41NzY4IDEyLjY2MTJDMTAuMzMzMSAxMi41MjUyIDEwLjMyNzQgMTIuMTQ1NSAxMC41NzY4IDEyLjAwOTVMMTcuMzE0NyA4LjEyMjAyVjAuNTA1NjY4TDAuMTE1NjQ2IDEwLjQyODVMMTguOTYzOCAyMS4zMDlMMzcuODExOSAxMC40Mjg1TDIwLjYxMjkgMC41WiIgZmlsbD0iIzgwODA4MCI+PC9wYXRoPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTU5LjY3NDYgMjMuODUyN0M1OS42NzQ2IDI1Ljg1MzIgNTguNTU4MiAyNy4yODEyIDU2LjIxNzggMjcuMjgxMkM1My43MyAyNy4yODEyIDUyLjcwNDMgMjUuOTM4MiA1Mi43MDQzIDIzLjkzNzdWMTEuNzA4NUg0Ny42NDk0VjIzLjc2NzdDNDcuNjQ5NCAyOC41MzkzIDUwLjUwNTUgMzEuMzM4NyA1Ni4yMjM0IDMxLjMzODdDNjEuOTA3NCAzMS4zMzg3IDY0Ljc0MDggMjguNDgyNiA2NC43NDA4IDIzLjc2NzdWMTEuNzA4NUg1OS42ODU5VjIzLjg1MjdINTkuNjc0NloiIGZpbGw9ImJsYWNrIj48L3BhdGg+CiAgICAgICAgICAgICAgICA8cGF0aCBkPSJNNzYuNDcxOSAxNS45MDc4Qzc0LjQ0MzIgMTUuOTA3OCA3My4wNDM1IDE2Ljc2MzUgNzEuOTU1NCAxOC4zMzlINzEuODcwNFYxNi4zMzg1SDY3LjM4MjJWMzAuOTY0OUg3Mi4wNDA0VjIyLjg3ODJDNzIuMDQwNCAyMS4wNzYxIDczLjA3MTggMTkuNzg5NyA3NC42MTMyIDE5Ljc4OTdDNzYuMTI2MyAxOS43ODk3IDc2Ljg5NyAyMC44NDk0IDc2Ljg5NyAyMi4zOTA4VjMwLjk2NDlIODEuNTU1MlYyMS40NTAxQzgxLjU2MDggMTguMTkxNiA3OS42NzM3IDE1LjkwNzggNzYuNDcxOSAxNS45MDc4WiIgZmlsbD0iYmxhY2siPjwvcGF0aD4KICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik04OC42MjE2IDEwLjUzNjlIODMuOTYzNFYxNC4zMTFIODguNjIxNlYxMC41MzY5WiIgZmlsbD0iYmxhY2siPjwvcGF0aD4KICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik04OC42MjE1IDE2LjMzOTVIODMuOTYzM1YzMC45NzE1SDg4LjYyMTVWMTYuMzM5NVoiIGZpbGw9ImJsYWNrIj48L3BhdGg+CiAgICAgICAgICAgICAgICA8cGF0aCBkPSJNOTYuODIxNyAxMS43MDg1SDkyLjI3NjhWMTYuMzM4NEg5MC4zMzNWMjAuMTEyNkg5Mi4yNzY4VjI3LjExMTJDOTIuMjc2OCAzMC4yNTY0IDk0LjIyMDYgMzEuMTQwNCA5Ni45MzUgMzEuMTQwNEM5OC4xOTMxIDMxLjE0MDQgOTkuMDc3MSAzMS4wMjcxIDk5LjQ3OTQgMzAuOTEzN1YyNy41MTM2Qzk5LjMwOTQgMjcuNTEzNiA5OC44NTA0IDI3LjU0MTkgOTguNDQ4MSAyNy41NDE5Qzk3LjQ1MDcgMjcuNTQxOSA5Ni44MjE3IDI3LjI1ODYgOTYuODIxNyAyNi4xMTM4VjIwLjExMjZIOTkuNDc5NFYxNi4zMzg0SDk2LjgyMTdWMTEuNzA4NVoiIGZpbGw9ImJsYWNrIj48L3BhdGg+CiAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTA5LjM5MSAyMi41NjY1QzEwOC45MzIgMjMuOTk0NiAxMDguNTM1IDI1LjkzODMgMTA4LjUzNSAyNS45MzgzSDEwOC40NzlDMTA4LjQ3OSAyNS45MzgzIDEwOC4wMTkgMjMuOTk0NiAxMDcuNTY2IDIyLjU2NjVMMTA1LjU5NCAxNi4zMzg2SDEwMC42ODFMMTA0Ljk5MyAyNy41OTg4QzEwNS41OTQgMjkuMTQwMiAxMDUuODc3IDMwLjAwMTUgMTA1Ljg3NyAzMC42MjQ5QzEwNS44NzcgMzEuNjIyMyAxMDUuMzMzIDMyLjE2NjMgMTAzLjk2MiAzMi4xNjYzSDEwMi4zNjRWMzUuNzkzMUgxMDUuMzlDMTA4LjMzMSAzNS43OTMxIDEwOS43MzEgMzQuNTkxNyAxMTAuOTA0IDMxLjE2MzNMMTE1Ljk1OSAxNi4zMzI5SDExMS4zMDFMMTA5LjM5MSAyMi41NjY1WiIgZmlsbD0iYmxhY2siPjwvcGF0aD4KICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xMjIuNzI1IDMxLjE4MDZWMTIuNjA0MUgxMjUuNTI4VjI4Ljc2NzhIMTMzLjk0NVYzMS4xODA2SDEyMi43MjVaIiBmaWxsPSJibGFjayI+PC9wYXRoPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTE0Mi45MyAzMS40NjE4QzE0MS41NTcgMzEuNDYxOCAxNDAuMzc1IDMxLjE2ODUgMTM5LjM4MyAzMC41ODE5QzEzOC4zOTcgMjkuOTg5MyAxMzcuNjM1IDI5LjE1NzkgMTM3LjA5NyAyOC4wODc1QzEzNi41NjUgMjcuMDExMiAxMzYuMjk5IDI1Ljc1MDQgMTM2LjI5OSAyNC4zMDUxQzEzNi4yOTkgMjIuODc4IDEzNi41NjUgMjEuNjIwMiAxMzcuMDk3IDIwLjUzMThDMTM3LjYzNSAxOS40NDMzIDEzOC4zODUgMTguNTkzNyAxMzkuMzQ3IDE3Ljk4M0MxNDAuMzE0IDE3LjM3MjIgMTQxLjQ0NSAxNy4wNjY4IDE0Mi43MzkgMTcuMDY2OEMxNDMuNTI1IDE3LjA2NjggMTQ0LjI4NyAxNy4xOTY4IDE0NS4wMjUgMTcuNDU2OUMxNDUuNzYzIDE3LjcxNjkgMTQ2LjQyNSAxOC4xMjUxIDE0Ny4wMTEgMTguNjgxNEMxNDcuNTk4IDE5LjIzNzcgMTQ4LjA2MSAxOS45NjAzIDE0OC4zOTkgMjAuODQ5M0MxNDguNzM4IDIxLjczMjEgMTQ4LjkwNyAyMi44MDU1IDE0OC45MDcgMjQuMDY5M1YyNS4wMzA4SDEzNy44MzJWMjIuOTk5SDE0Ni4yNDlDMTQ2LjI0OSAyMi4yODU0IDE0Ni4xMDQgMjEuNjUzNSAxNDUuODE0IDIxLjEwMzJDMTQ1LjUyNCAyMC41NDY5IDE0NS4xMTYgMjAuMTA4NSAxNDQuNTkgMTkuNzg4QzE0NC4wNjkgMTkuNDY3NSAxNDMuNDU5IDE5LjMwNzMgMTQyLjc1NyAxOS4zMDczQzE0MS45OTUgMTkuMzA3MyAxNDEuMzMgMTkuNDk0NyAxNDAuNzYyIDE5Ljg2OTZDMTQwLjE5OSAyMC4yMzg1IDEzOS43NjQgMjAuNzIyMyAxMzkuNDU2IDIxLjMyMDlDMTM5LjE1MyAyMS45MTM1IDEzOS4wMDIgMjIuNTU3NSAxMzkuMDAyIDIzLjI1MjlWMjQuODQwM0MxMzkuMDAyIDI1Ljc3MTUgMTM5LjE2NSAyNi41NjM3IDEzOS40OTIgMjcuMjE2OEMxMzkuODI0IDI3Ljg2OTkgMTQwLjI4NyAyOC4zNjg3IDE0MC44OCAyOC43MTM0QzE0MS40NzIgMjkuMDUyIDE0Mi4xNjUgMjkuMjIxNCAxNDIuOTU3IDI5LjIyMTRDMTQzLjQ3MSAyOS4yMjE0IDE0My45MzkgMjkuMTQ4OCAxNDQuMzYzIDI5LjAwMzdDMTQ0Ljc4NiAyOC44NTI1IDE0NS4xNTIgMjguNjI4OCAxNDUuNDYgMjguMzMyNUMxNDUuNzY5IDI4LjAzNjEgMTQ2LjAwNSAyNy42NzAzIDE0Ni4xNjggMjcuMjM0OUwxNDguNzM1IDI3LjY5NzVDMTQ4LjUyOSAyOC40NTM0IDE0OC4xNiAyOS4xMTU1IDE0Ny42MjggMjkuNjg0QzE0Ny4xMDIgMzAuMjQ2MyAxNDYuNDQgMzAuNjg0NyAxNDUuNjQyIDMwLjk5OTJDMTQ0Ljg1IDMxLjMwNzYgMTQzLjk0NiAzMS40NjE4IDE0Mi45MyAzMS40NjE4WiIgZmlsbD0iYmxhY2siPjwvcGF0aD4KICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xNjMuNDM2IDE3LjI0ODJMMTU4LjM4MyAzMS4xODA2SDE1NS40ODFMMTUwLjQyIDE3LjI0ODJIMTUzLjMzMUwxNTYuODYgMjcuOTY5NkgxNTcuMDA1TDE2MC41MjQgMTcuMjQ4MkgxNjMuNDM2WiIgZmlsbD0iYmxhY2siPjwvcGF0aD4KICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xNzEuNTE1IDMxLjQ2MThDMTcwLjE0MyAzMS40NjE4IDE2OC45NiAzMS4xNjg1IDE2Ny45NjkgMzAuNTgxOUMxNjYuOTgzIDI5Ljk4OTMgMTY2LjIyMSAyOS4xNTc5IDE2NS42ODMgMjguMDg3NUMxNjUuMTUxIDI3LjAxMTIgMTY0Ljg4NSAyNS43NTA0IDE2NC44ODUgMjQuMzA1MUMxNjQuODg1IDIyLjg3OCAxNjUuMTUxIDIxLjYyMDIgMTY1LjY4MyAyMC41MzE4QzE2Ni4yMjEgMTkuNDQzMyAxNjYuOTcxIDE4LjU5MzcgMTY3LjkzMiAxNy45ODNDMTY4LjkgMTcuMzcyMiAxNzAuMDMxIDE3LjA2NjggMTcxLjMyNSAxNy4wNjY4QzE3Mi4xMTEgMTcuMDY2OCAxNzIuODczIDE3LjE5NjggMTczLjYxMSAxNy40NTY5QzE3NC4zNDggMTcuNzE2OSAxNzUuMDEgMTguMTI1MSAxNzUuNTk3IDE4LjY4MTRDMTc2LjE4NCAxOS4yMzc3IDE3Ni42NDYgMTkuOTYwMyAxNzYuOTg1IDIwLjg0OTNDMTc3LjMyMyAyMS43MzIxIDE3Ny40OTMgMjIuODA1NSAxNzcuNDkzIDI0LjA2OTNWMjUuMDMwOEgxNjYuNDE4VjIyLjk5OUgxNzQuODM1QzE3NC44MzUgMjIuMjg1NCAxNzQuNjkgMjEuNjUzNSAxNzQuNCAyMS4xMDMyQzE3NC4xMDkgMjAuNTQ2OSAxNzMuNzAxIDIwLjEwODUgMTczLjE3NSAxOS43ODhDMTcyLjY1NSAxOS40Njc1IDE3Mi4wNDQgMTkuMzA3MyAxNzEuMzQzIDE5LjMwNzNDMTcwLjU4MSAxOS4zMDczIDE2OS45MTYgMTkuNDk0NyAxNjkuMzQ3IDE5Ljg2OTZDMTY4Ljc4NSAyMC4yMzg1IDE2OC4zNSAyMC43MjIzIDE2OC4wNDEgMjEuMzIwOUMxNjcuNzM5IDIxLjkxMzUgMTY3LjU4OCAyMi41NTc1IDE2Ny41ODggMjMuMjUyOVYyNC44NDAzQzE2Ny41ODggMjUuNzcxNSAxNjcuNzUxIDI2LjU2MzcgMTY4LjA3OCAyNy4yMTY4QzE2OC40MSAyNy44Njk5IDE2OC44NzMgMjguMzY4NyAxNjkuNDY1IDI4LjcxMzRDMTcwLjA1OCAyOS4wNTIgMTcwLjc1IDI5LjIyMTQgMTcxLjU0MyAyOS4yMjE0QzE3Mi4wNTcgMjkuMjIxNCAxNzIuNTI1IDI5LjE0ODggMTcyLjk0OCAyOS4wMDM3QzE3My4zNzIgMjguODUyNSAxNzMuNzM4IDI4LjYyODggMTc0LjA0NiAyOC4zMzI1QzE3NC4zNTQgMjguMDM2MSAxNzQuNTkgMjcuNjcwMyAxNzQuNzUzIDI3LjIzNDlMMTc3LjMyIDI3LjY5NzVDMTc3LjExNSAyOC40NTM0IDE3Ni43NDYgMjkuMTE1NSAxNzYuMjE0IDI5LjY4NEMxNzUuNjg4IDMwLjI0NjMgMTc1LjAyNiAzMC42ODQ3IDE3NC4yMjcgMzAuOTk5MkMxNzMuNDM1IDMxLjMwNzYgMTcyLjUzMSAzMS40NjE4IDE3MS41MTUgMzEuNDYxOFoiIGZpbGw9ImJsYWNrIj48L3BhdGg+CiAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTgzLjIxNCAxMi42MDQxVjMxLjE4MDZIMTgwLjUwMlYxMi42MDQxSDE4My4yMTRaIiBmaWxsPSJibGFjayI+PC9wYXRoPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTE4Ny4wOCAzMS4xODA2VjEyLjYwNDFIMTkzLjcwMkMxOTUuMTQ3IDEyLjYwNDEgMTk2LjM0NCAxMi44NjcyIDE5Ny4yOTQgMTMuMzkzM0MxOTguMjQzIDEzLjkxOTQgMTk4Ljk1NCAxNC42MzkgMTk5LjQyNSAxNS41NTIxQzE5OS44OTcgMTYuNDU5MSAyMDAuMTMzIDE3LjQ4MTEgMjAwLjEzMyAxOC42MTc5QzIwMC4xMzMgMTkuNzYwOCAxOTkuODk0IDIwLjc4ODggMTk5LjQxNiAyMS43MDE5QzE5OC45NDUgMjIuNjA4OSAxOTguMjMxIDIzLjMyODUgMTk3LjI3NiAyMy44NjA3QzE5Ni4zMjYgMjQuMzg2OCAxOTUuMTMyIDI0LjY0OTggMTkzLjY5MyAyNC42NDk4SDE4OS4xMzlWMjIuMjczM0gxOTMuNDM5QzE5NC4zNTIgMjIuMjczMyAxOTUuMDkzIDIyLjExNjEgMTk1LjY2MSAyMS44MDE3QzE5Ni4yMjkgMjEuNDgxMiAxOTYuNjQ3IDIxLjA0NTggMTk2LjkxMyAyMC40OTU1QzE5Ny4xNzkgMTkuOTQ1MiAxOTcuMzEyIDE5LjMxOTQgMTk3LjMxMiAxOC42MTc5QzE5Ny4zMTIgMTcuOTE2NCAxOTcuMTc5IDE3LjI5MzYgMTk2LjkxMyAxNi43NDk0QzE5Ni42NDcgMTYuMjA1MSAxOTYuMjI2IDE1Ljc3ODggMTk1LjY1MiAxNS40NzA0QzE5NS4wODQgMTUuMTYyIDE5NC4zMzQgMTUuMDA3OCAxOTMuNDAyIDE1LjAwNzhIMTg5Ljg4M1YzMS4xODA2SDE4Ny4wOFoiIGZpbGw9ImJsYWNrIj48L3BhdGg+CiAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMjA1LjkxMyAxMi42MDQxVjMxLjE4MDZIMjAzLjIwMVYxMi42MDQxSDIwNS45MTNaIiBmaWxsPSJibGFjayI+PC9wYXRoPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTIxMy42MTYgMzEuNDg5QzIxMi43MzMgMzEuNDg5IDIxMS45MzUgMzEuMzI1NyAyMTEuMjIxIDMwLjk5OTJDMjEwLjUwOCAzMC42NjY2IDIwOS45NDMgMzAuMTg1OSAyMDkuNTI1IDI5LjU1N0MyMDkuMTE0IDI4LjkyODEgMjA4LjkwOSAyOC4xNTcxIDIwOC45MDkgMjcuMjQ0QzIwOC45MDkgMjYuNDU3OSAyMDkuMDYgMjUuODEwOCAyMDkuMzYyIDI1LjMwMjlDMjA5LjY2NCAyNC43OTQ5IDIxMC4wNzMgMjQuMzkyOCAyMTAuNTg3IDI0LjA5NjVDMjExLjEwMSAyMy44MDAyIDIxMS42NzUgMjMuNTc2NSAyMTIuMzEgMjMuNDI1M0MyMTIuOTQ1IDIzLjI3NDEgMjEzLjU5MiAyMy4xNTkyIDIxNC4yNTEgMjMuMDgwNkMyMTUuMDg2IDIyLjk4MzkgMjE1Ljc2MyAyMi45MDUyIDIxNi4yODMgMjIuODQ0OEMyMTYuODAzIDIyLjc3ODMgMjE3LjE4MSAyMi42NzI0IDIxNy40MTcgMjIuNTI3M0MyMTcuNjUyIDIyLjM4MjIgMjE3Ljc3IDIyLjE0NjMgMjE3Ljc3IDIxLjgxOThWMjEuNzU2M0MyMTcuNzcgMjAuOTY0MSAyMTcuNTQ3IDIwLjM1MDQgMjE3LjA5OSAxOS45MTVDMjE2LjY1OCAxOS40Nzk2IDIxNS45OTkgMTkuMjYxOSAyMTUuMTIyIDE5LjI2MTlDMjE0LjIwOSAxOS4yNjE5IDIxMy40ODkgMTkuNDY0NSAyMTIuOTYzIDE5Ljg2OTZDMjEyLjQ0MyAyMC4yNjg3IDIxMi4wODMgMjAuNzEzMiAyMTEuODg0IDIxLjIwM0wyMDkuMzM1IDIwLjYyMjVDMjA5LjYzNyAxOS43NzU5IDIxMC4wNzkgMTkuMDkyNiAyMTAuNjU5IDE4LjU3MjVDMjExLjI0NiAxOC4wNDY1IDIxMS45MiAxNy42NjU1IDIxMi42ODIgMTcuNDI5N0MyMTMuNDQ0IDE3LjE4NzggMjE0LjI0NSAxNy4wNjY4IDIxNS4wODYgMTcuMDY2OEMyMTUuNjQyIDE3LjA2NjggMjE2LjIzMSAxNy4xMzM0IDIxNi44NTQgMTcuMjY2NEMyMTcuNDgzIDE3LjM5MzQgMjE4LjA3IDE3LjYyOTIgMjE4LjYxNCAxNy45NzM5QzIxOS4xNjQgMTguMzE4NiAyMTkuNjE1IDE4LjgxMTQgMjE5Ljk2NSAxOS40NTI0QzIyMC4zMTYgMjAuMDg3MyAyMjAuNDkyIDIwLjkxMjcgMjIwLjQ5MiAyMS45Mjg2VjMxLjE4MDZIMjE3Ljg0M1YyOS4yNzU4SDIxNy43MzRDMjE3LjU1OSAyOS42MjY1IDIxNy4yOTYgMjkuOTcxMiAyMTYuOTQ1IDMwLjMwOThDMjE2LjU5NCAzMC42NDg1IDIxNi4xNDQgMzAuOTI5NyAyMTUuNTkzIDMxLjE1MzRDMjE1LjA0MyAzMS4zNzcxIDIxNC4zODQgMzEuNDg5IDIxMy42MTYgMzEuNDg5Wk0yMTQuMjA2IDI5LjMxMjFDMjE0Ljk1NiAyOS4zMTIxIDIxNS41OTYgMjkuMTYzOSAyMTYuMTI5IDI4Ljg2NzZDMjE2LjY2NyAyOC41NzEzIDIxNy4wNzUgMjguMTg0MyAyMTcuMzUzIDI3LjcwNjZDMjE3LjYzNyAyNy4yMjI4IDIxNy43NzkgMjYuNzA1OCAyMTcuNzc5IDI2LjE1NTVWMjQuMzU5NkMyMTcuNjgzIDI0LjQ1NjMgMjE3LjQ5NSAyNC41NDcgMjE3LjIxNyAyNC42MzE3QzIxNi45NDUgMjQuNzEwMyAyMTYuNjM0IDI0Ljc3OTggMjE2LjI4MyAyNC44NDAzQzIxNS45MzIgMjQuODk0NyAyMTUuNTkgMjQuOTQ2MSAyMTUuMjU4IDI0Ljk5NDVDMjE0LjkyNSAyNS4wMzY4IDIxNC42NDcgMjUuMDczMSAyMTQuNDIzIDI1LjEwMzNDMjEzLjg5NyAyNS4xNjk5IDIxMy40MTcgMjUuMjgxNyAyMTIuOTgxIDI1LjQzODlDMjEyLjU1MiAyNS41OTYyIDIxMi4yMDcgMjUuODIyOSAyMTEuOTQ3IDI2LjExOTJDMjExLjY5MyAyNi40MDk1IDIxMS41NjYgMjYuNzk2NSAyMTEuNTY2IDI3LjI4MDNDMjExLjU2NiAyNy45NTE1IDIxMS44MTQgMjguNDU5NCAyMTIuMzEgMjguODA0MUMyMTIuODA2IDI5LjE0MjggMjEzLjQzOCAyOS4zMTIxIDIxNC4yMDYgMjkuMzEyMVoiIGZpbGw9ImJsYWNrIj48L3BhdGg+CiAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMjI1LjMxOSAzNi40MDUyQzIyNC45MTQgMzYuNDA1MiAyMjQuNTQ1IDM2LjM3MiAyMjQuMjEzIDM2LjMwNTVDMjIzLjg4IDM2LjI0NSAyMjMuNjMyIDM2LjE3ODUgMjIzLjQ2OSAzNi4xMDU5TDIyNC4xMjIgMzMuODgzNkMyMjQuNjE4IDM0LjAxNjcgMjI1LjA1OSAzNC4wNzQxIDIyNS40NDYgMzQuMDU2QzIyNS44MzMgMzQuMDM3OCAyMjYuMTc1IDMzLjg5MjcgMjI2LjQ3MSAzMy42MjA2QzIyNi43NzQgMzMuMzQ4NSAyMjcuMDQgMzIuOTA0IDIyNy4yNjkgMzIuMjg3MkwyMjcuNjA1IDMxLjM2MkwyMjIuNTA3IDE3LjI0ODJIMjI1LjQxTDIyOC45MzggMjguMDYwM0gyMjkuMDg0TDIzMi42MTIgMTcuMjQ4MkgyMzUuNTI0TDIyOS43ODIgMzMuMDQwMUMyMjkuNTE2IDMzLjc2NTcgMjI5LjE3NyAzNC4zNzk1IDIyOC43NjYgMzQuODgxNEMyMjguMzU1IDM1LjM4OTMgMjI3Ljg2NSAzNS43NzAzIDIyNy4yOTcgMzYuMDI0M0MyMjYuNzI4IDM2LjI3ODMgMjI2LjA2OSAzNi40MDUyIDIyNS4zMTkgMzYuNDA1MloiIGZpbGw9ImJsYWNrIj48L3BhdGg+CiAgICAgICAgICAgIDwvc3ZnPgogICAgICAgIDwvZGl2PgogICAgICAgIDxkaXYgY2xhc3M9ImZsZXgtY29udGFpbmVyIGxvYWRpbmciIHN0eWxlPSIKICAgIGZsZXg6IDE7CiI+CiAgICAgICAgICAgIDxkaXYgY2xhc3M9Imxkcy1lbGxpcHNpcyI+CiAgICAgICAgICAgICAgICA8ZGl2PjwvZGl2PgogICAgICAgICAgICAgICAgPGRpdj48L2Rpdj4KICAgICAgICAgICAgICAgIDxkaXY+PC9kaXY+CiAgICAgICAgICAgICAgICA8ZGl2PjwvZGl2PgogICAgICAgICAgICA8L2Rpdj4KICAgICAgICA8L2Rpdj4KICAgIDwvZGl2Pgo8L2Rpdj4KCgo8L2JvZHk+PC9odG1sPg=='))");
        }
        handler.postDelayed(new b$$ExternalSyntheticLambda0(this), 2000);
        handler.postDelayed(new b$$ExternalSyntheticLambda1(aVar), 5000);
    }

    public static String a(String str, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(str, "methodName");
        Intrinsics.checkNotNullParameter(list, "methodArgs");
        String str2 = "TestSuiteJs." + str;
        com.ironsource.mediationsdk.testSuite.d.a aVar = com.ironsource.mediationsdk.testSuite.d.a.a;
        String a2 = com.ironsource.mediationsdk.testSuite.d.a.a(list);
        if (a2.length() > 0) {
            return str2 + '(' + a2 + ')';
        }
        return str2 + "()";
    }

    /* access modifiers changed from: private */
    public static final void a(com.ironsource.mediationsdk.testSuite.c.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "$uiLifeCycleListener");
        aVar.onUIReady();
    }

    /* access modifiers changed from: private */
    public static final void a(b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "this$0");
        bVar.f = true;
    }

    /* access modifiers changed from: private */
    public static final void a(b bVar, String str) {
        Intrinsics.checkNotNullParameter(bVar, "this$0");
        Intrinsics.checkNotNullParameter(str, "$script");
        WebView webView = bVar.c;
        webView.loadUrl("javascript:" + str);
    }

    public final void a() {
        WebView webView = this.b;
        if (webView != null) {
            if (webView != null) {
                webView.destroy();
            }
            this.b = null;
        }
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "script");
        this.a.post(new b$$ExternalSyntheticLambda2(this, str));
    }

    public final void a(String str, IronSource.AD_UNIT ad_unit, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(str, "callbackName");
        Intrinsics.checkNotNullParameter(ad_unit, "adUnit");
        Intrinsics.checkNotNullParameter(list, "args");
        if (this.e) {
            String ad_unit2 = ad_unit.toString();
            Intrinsics.checkNotNullExpressionValue(ad_unit2, "adUnit.toString()");
            a(a("onCallbackReceived", (List<? extends Object>) CollectionsKt.listOf(str, ad_unit2, list)));
        }
    }
}
