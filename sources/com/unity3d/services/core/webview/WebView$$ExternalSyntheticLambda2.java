package com.unity3d.services.core.webview;

import android.webkit.ValueCallback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WebView$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ WebView f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ ValueCallback f$2;

    public /* synthetic */ WebView$$ExternalSyntheticLambda2(WebView webView, String str, ValueCallback valueCallback) {
        this.f$0 = webView;
        this.f$1 = str;
        this.f$2 = valueCallback;
    }

    public final void run() {
        WebView.evaluateJavascript$lambda$1(this.f$0, this.f$1, this.f$2);
    }
}
