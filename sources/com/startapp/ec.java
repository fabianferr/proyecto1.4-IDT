package com.startapp;

import android.webkit.WebView;

/* compiled from: Sta */
public class ec implements Runnable {
    public final /* synthetic */ WebView a;
    public final /* synthetic */ String b;

    public ec(WebView webView, String str) {
        this.a = webView;
        this.b = str;
    }

    public void run() {
        this.a.loadUrl(this.b);
    }
}
