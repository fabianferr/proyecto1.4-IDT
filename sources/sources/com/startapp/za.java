package com.startapp;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Map;

/* compiled from: Sta */
public class za extends WebViewClient {
    public final /* synthetic */ wa a;

    public za(wa waVar) {
        this.a = waVar;
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        String str;
        wa waVar = this.a;
        waVar.getClass();
        if (webResourceRequest != null) {
            try {
                Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
                if (requestHeaders != null) {
                    str = k9.d(requestHeaders.get("User-Agent"));
                    waVar.c.a().execute(new ab(waVar, str, webView));
                    return null;
                }
            } catch (Throwable th) {
                if (waVar.a(64)) {
                    i3.a(th);
                }
            }
        }
        str = null;
        waVar.c.a().execute(new ab(waVar, str, webView));
        return null;
    }
}
