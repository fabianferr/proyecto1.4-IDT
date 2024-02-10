package com.startapp;

import com.startapp.sdk.ads.video.d;
import com.startapp.sdk.ads.video.player.VideoPlayerInterface;

/* compiled from: Sta */
public class o6 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ d b;

    public o6(d dVar, int i) {
        this.b = dVar;
        this.a = i;
    }

    public void run() {
        VideoPlayerInterface.a aVar = this.b.b;
        if (aVar != null) {
            ((pa) aVar).a(this.a);
        }
    }
}
