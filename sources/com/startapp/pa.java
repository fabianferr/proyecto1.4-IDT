package com.startapp;

import com.startapp.sdk.ads.video.VideoMode;
import com.startapp.sdk.ads.video.player.NativeVideoPlayer;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;
import com.startapp.sdk.adsbase.AdsCommonMetaData;

/* compiled from: Sta */
public class pa implements VideoPlayerInterface.a {
    public final /* synthetic */ VideoMode a;

    public pa(VideoMode videoMode) {
        this.a = videoMode;
    }

    public void a(int i) {
        VideoMode videoMode;
        VideoPlayerInterface videoPlayerInterface;
        VideoPlayerInterface videoPlayerInterface2 = this.a.K;
        int duration = videoPlayerInterface2 != null ? ((NativeVideoPlayer) videoPlayerInterface2).h.getDuration() : 0;
        VideoMode videoMode2 = this.a;
        if (videoMode2.X && duration > 0 && videoMode2.F()) {
            VideoMode videoMode3 = this.a;
            videoMode3.W = i;
            int currentPosition = (((NativeVideoPlayer) videoMode3.K).h.getCurrentPosition() * 100) / duration;
            if (this.a.G()) {
                VideoMode videoMode4 = this.a;
                if (videoMode4.Y || !videoMode4.E()) {
                    int i2 = this.a.W;
                    if (i2 == 100 || i2 - currentPosition > AdsCommonMetaData.h.G().h()) {
                        VideoMode videoMode5 = this.a;
                        VideoPlayerInterface videoPlayerInterface3 = videoMode5.K;
                        if (videoPlayerInterface3 != null) {
                            ((NativeVideoPlayer) videoPlayerInterface3).h.start();
                            videoMode5.w.setBackgroundColor(33554431);
                        }
                        videoMode5.N();
                        return;
                    }
                    return;
                }
                this.a.M();
                return;
            }
            int i3 = this.a.W;
            if (i3 < 100 && i3 - currentPosition <= AdsCommonMetaData.h.G().i() && (videoPlayerInterface = videoMode.K) != null) {
                ((NativeVideoPlayer) videoPlayerInterface).h.pause();
                (videoMode = this.a).L();
            }
        }
    }
}
