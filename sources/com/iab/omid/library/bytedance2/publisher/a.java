package com.iab.omid.library.bytedance2.publisher;

import android.webkit.WebView;

public class a extends AdSessionStatePublisher {
    public a(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
