package com.startapp.sdk.ads.video;

import com.startapp.sdk.ads.video.VideoMode;
import com.startapp.sdk.ads.video.player.NativeVideoPlayer;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;

/* compiled from: Sta */
public class i implements VideoPlayerInterface.b {
    public final /* synthetic */ VideoMode a;

    public i(VideoMode videoMode) {
        this.a = videoMode;
    }

    public void a() {
        VideoMode videoMode = this.a;
        if (!videoMode.d0) {
            videoMode.a(VideoMode.VideoFinishedReason.COMPLETE);
        }
        VideoPlayerInterface videoPlayerInterface = this.a.K;
        if (videoPlayerInterface != null) {
            ((NativeVideoPlayer) videoPlayerInterface).h.stopPlayback();
        }
    }
}
