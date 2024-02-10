package com.applovin.impl.adview;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;

class c extends WebChromeClient {
    private final u a;
    private final b b;

    public c(b bVar, m mVar) {
        this.a = mVar.A();
        this.b = bVar;
    }

    public void onConsoleMessage(String str, int i, String str2) {
        if (u.a()) {
            u uVar = this.a;
            uVar.d("AdWebView", "console.log[" + i + "] :" + str);
        }
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (!u.a()) {
            return true;
        }
        this.a.b("AdWebView", consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message());
        return true;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        if (!u.a()) {
            return true;
        }
        u uVar = this.a;
        uVar.d("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        if (!u.a()) {
            return true;
        }
        u uVar = this.a;
        uVar.d("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        if (!u.a()) {
            return true;
        }
        u uVar = this.a;
        uVar.d("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }

    public void onProgressChanged(WebView webView, int i) {
        b bVar;
        if (i == 100 && (bVar = this.b) != null) {
            bVar.a(webView);
        }
    }
}
