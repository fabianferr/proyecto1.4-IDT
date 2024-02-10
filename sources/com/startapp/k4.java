package com.startapp;

import android.content.Context;
import android.webkit.JavascriptInterface;

/* compiled from: Sta */
public class k4 {
    public boolean a = false;
    public Runnable b;

    public k4(Context context, Runnable runnable) {
        this.b = runnable;
    }

    @JavascriptInterface
    public void closeSplash() {
        if (!this.a) {
            this.a = true;
            this.b.run();
        }
    }
}
