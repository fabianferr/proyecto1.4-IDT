package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;

final class v {
    private w a;
    private boolean b = false;

    v(w wVar) {
        this.a = wVar;
    }

    @JavascriptInterface
    public final String getTokenForMessaging() {
        if (this.b) {
            return "";
        }
        this.b = true;
        return this.a.a;
    }
}
