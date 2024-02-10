package com.startapp;

import com.startapp.sdk.ads.video.VideoMode;

/* compiled from: Sta */
public class la implements Runnable {
    public final /* synthetic */ VideoMode a;

    public la(VideoMode videoMode) {
        this.a = videoMode;
    }

    public void run() {
        VideoMode videoMode = this.a;
        if (videoMode.K != null) {
            videoMode.O();
        }
    }
}
