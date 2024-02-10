package com.bytedance.sdk.openadsdk.core;

import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: WebViewTweaker */
public class aa {
    public static void a(WebView webView) {
        if (webView != null) {
            webView.setWebChromeClient((WebChromeClient) null);
            webView.setWebViewClient((WebViewClient) null);
            ViewParent parent = webView.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(webView);
            }
            webView.removeAllViews();
            webView.destroy();
        }
    }
}
