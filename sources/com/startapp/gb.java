package com.startapp;

import android.webkit.WebView;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;

/* compiled from: Sta */
public class gb extends AdSessionStatePublisher {
    public gb(WebView webView) {
        if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        a(webView);
    }
}
