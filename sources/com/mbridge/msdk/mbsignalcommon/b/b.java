package com.mbridge.msdk.mbsignalcommon.b;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.mbsignalcommon.windvane.d;

/* compiled from: DefaultWebViewListener */
public class b implements d {
    public void a(WebView webView, String str, Bitmap bitmap) {
        aa.a("WindVaneWebView", "onPageStarted");
    }

    public boolean b(WebView webView, String str) {
        aa.a("WindVaneWebView", "shouldOverrideUrlLoading");
        return true;
    }

    public void a(WebView webView, int i, String str, String str2) {
        aa.a("WindVaneWebView", "onReceivedError");
    }

    public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        aa.a("WindVaneWebView", "onReceivedSslError");
    }

    public void a(WebView webView, String str) {
        aa.a("WindVaneWebView", "onPageFinished");
    }

    public void b(WebView webView, int i) {
        aa.a("WindVaneWebView", "onProgressChanged");
    }

    public void a(WebView webView, int i) {
        aa.a("WindVaneWebView", "readyState");
    }

    public void c(WebView webView, int i) {
        aa.a("WindVaneWebView", "loadingResourceStatus");
    }

    public void a(WebView webView) {
        aa.a("WindVaneWebView", "onRenderProcessGone");
    }
}
