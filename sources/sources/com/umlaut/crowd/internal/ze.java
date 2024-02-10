package com.umlaut.crowd.internal;

import android.webkit.WebView;

public interface ze {

    public enum a {
        Start,
        Change,
        End,
        Error,
        Cancel
    }

    void a(long j, long j2, long j3);

    void a(WebView webView, a aVar, String str);
}
