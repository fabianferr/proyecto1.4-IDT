package com.startapp;

import android.widget.VideoView;
import com.startapp.sdk.ads.video.VideoMode;

/* compiled from: Sta */
public class ma implements Runnable {
    public final /* synthetic */ VideoMode a;

    public ma(VideoMode videoMode) {
        this.a = videoMode;
    }

    public void run() {
        VideoView videoView;
        VideoMode videoMode = this.a;
        if (videoMode.K != null && (videoView = videoMode.L) != null) {
            videoMode.D++;
            videoView.setVisibility(0);
            boolean unused = this.a.d0 = false;
            VideoMode videoMode2 = this.a;
            videoMode2.getClass();
            k9.a(videoMode2.w, true, "videoApi.setVideoCurrentPosition", 0);
            k9.a(videoMode2.w, true, "videoApi.setSkipTimer", 0);
            this.a.K();
        }
    }
}
