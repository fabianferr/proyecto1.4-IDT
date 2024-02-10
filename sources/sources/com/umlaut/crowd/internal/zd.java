package com.umlaut.crowd.internal;

import android.webkit.WebView;

public interface zd {

    public enum a {
        Start,
        End,
        Error,
        Cancel
    }

    void a(int i);

    void a(WebView webView, a aVar);

    void a(String str);
}
