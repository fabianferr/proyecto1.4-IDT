package com.startapp.sdk.ads.video.tracking;

import com.startapp.c9;

@c9(extendsClass = true)
/* compiled from: Sta */
public class AbsoluteTrackingLink extends VideoTrackingLink {
    private static final long serialVersionUID = 6710863919461399416L;
    private int videoOffsetMillis;

    public void a(int i) {
        this.videoOffsetMillis = i;
    }

    public int e() {
        return this.videoOffsetMillis;
    }

    public String toString() {
        return super.toString() + ", videoOffsetMillis=" + this.videoOffsetMillis;
    }
}
