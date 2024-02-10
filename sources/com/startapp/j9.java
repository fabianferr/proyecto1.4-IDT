package com.startapp;

import android.webkit.WebView;

/* compiled from: Sta */
public class j9 implements Runnable {
    public final /* synthetic */ WebView a;

    public j9(WebView webView) {
        this.a = webView;
    }

    public void run() {
        try {
            this.a.destroy();
        } catch (Throwable unused) {
        }
    }
}
