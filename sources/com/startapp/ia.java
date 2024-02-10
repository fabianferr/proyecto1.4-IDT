package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.adlisteners.VideoListener;

/* compiled from: Sta */
public class ia implements Runnable {
    public final /* synthetic */ VideoListener a;

    public ia(VideoListener videoListener, Context context) {
        this.a = videoListener;
    }

    public void run() {
        try {
            this.a.onVideoCompleted();
        } catch (Throwable th) {
            k9.a((Object) this.a, th);
        }
    }
}
