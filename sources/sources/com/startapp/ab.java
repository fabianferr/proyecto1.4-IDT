package com.startapp;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: Sta */
public class ab implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ WebView b;
    public final /* synthetic */ wa c;

    public ab(wa waVar, String str, WebView webView) {
        this.c = waVar;
        this.a = str;
        this.b = webView;
    }

    public void run() {
        wa waVar = this.c;
        waVar.f = this.a;
        WebView webView = this.b;
        try {
            webView.setWebViewClient((WebViewClient) null);
            waVar.e.addLast(webView);
        } catch (Throwable th) {
            if (waVar.a(4)) {
                i3.a(th);
            }
        }
    }
}
