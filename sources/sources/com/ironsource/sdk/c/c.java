package com.ironsource.sdk.c;

import android.webkit.JavascriptInterface;

public final class c {
    private d a;

    c(d dVar) {
        this.a = dVar;
    }

    @JavascriptInterface
    public final void receiveMessageFromExternal(String str) {
        this.a.handleMessageFromAd(str);
    }
}
