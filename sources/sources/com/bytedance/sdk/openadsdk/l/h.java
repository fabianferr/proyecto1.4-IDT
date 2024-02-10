package com.bytedance.sdk.openadsdk.l;

import android.graphics.Paint;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

/* compiled from: PlayableWebSettings */
public class h {
    private static void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            f.a("WebViewSettings", "removeJavascriptInterfacesSafe error", th);
        }
    }

    private static void a(WebSettings webSettings) {
        try {
            webSettings.setMediaPlaybackRequiresUserGesture(false);
        } catch (Throwable th) {
            f.a("WebViewSettings", "allowMediaPlayWithoutUserGesture error", th);
        }
    }

    public static void a(WebView webView) {
        b(webView);
        WebSettings settings = webView.getSettings();
        a(settings);
        if (settings != null) {
            boolean z = true;
            try {
                settings.setJavaScriptEnabled(true);
            } catch (Throwable th) {
                f.a("WebViewSettings", "setJavaScriptEnabled error", th);
            }
            try {
                settings.setSupportZoom(false);
            } catch (Throwable th2) {
                f.a("WebViewSettings", "setSupportZoom error", th2);
            }
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setDomStorageEnabled(true);
            settings.setAllowFileAccess(false);
            settings.setBlockNetworkImage(false);
            settings.setDisplayZoomControls(false);
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
            settings.setSavePassword(false);
            if (Build.VERSION.SDK_INT < 28) {
                z = false;
            }
            if (!z) {
                try {
                    webView.setLayerType(0, (Paint) null);
                } catch (Throwable th3) {
                    f.a("WebViewSettings", "setLayerType error", th3);
                }
            } else if (z) {
                webView.setLayerType(2, (Paint) null);
            }
            if (Build.VERSION.SDK_INT >= 21) {
                webView.getSettings().setMixedContentMode(0);
            }
        }
    }
}
