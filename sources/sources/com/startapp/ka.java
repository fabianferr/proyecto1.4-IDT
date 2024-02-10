package com.startapp;

import com.startapp.sdk.ads.video.VideoMode;

/* compiled from: Sta */
public class ka implements Runnable {
    public final /* synthetic */ VideoMode a;

    public ka(VideoMode videoMode) {
        this.a = videoMode;
    }

    public void run() {
        VideoMode videoMode = this.a;
        if (videoMode.K != null) {
            boolean unused = videoMode.P = !videoMode.P;
            this.a.J();
            VideoMode videoMode2 = this.a;
            videoMode2.a(videoMode2.P);
        }
    }
}
