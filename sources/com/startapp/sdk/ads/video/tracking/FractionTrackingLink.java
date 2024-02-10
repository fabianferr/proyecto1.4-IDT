package com.startapp.sdk.ads.video.tracking;

import com.startapp.c9;

@c9(extendsClass = true)
/* compiled from: Sta */
public class FractionTrackingLink extends VideoTrackingLink {
    private static final long serialVersionUID = 1389232981938306043L;
    private int fraction;

    public void a(int i) {
        this.fraction = i;
    }

    public int e() {
        return this.fraction;
    }

    public String toString() {
        return super.toString() + ", fraction=" + this.fraction;
    }
}
