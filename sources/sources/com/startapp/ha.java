package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;

/* compiled from: Sta */
public class ha extends j4 {
    public Runnable h;
    public Runnable i;
    public Runnable j;

    public ha(Context context, Runnable runnable, Runnable runnable2, Runnable runnable3, Runnable runnable4, Runnable runnable5, TrackingParams trackingParams, boolean z) {
        super(context, runnable, runnable2, trackingParams);
        this.h = runnable3;
        this.i = runnable4;
        this.j = runnable5;
        this.b = z;
    }

    @JavascriptInterface
    public void replayVideo() {
        if (this.h != null) {
            new Handler(Looper.getMainLooper()).post(this.h);
        }
    }

    @JavascriptInterface
    public void skipVideo() {
        if (this.i != null) {
            new Handler(Looper.getMainLooper()).post(this.i);
        }
    }

    @JavascriptInterface
    public void toggleSound() {
        if (this.j != null) {
            new Handler(Looper.getMainLooper()).post(this.j);
        }
    }
}
