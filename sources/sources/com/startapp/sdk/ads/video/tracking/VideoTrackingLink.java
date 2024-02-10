package com.startapp.sdk.ads.video.tracking;

import com.startapp.d9;
import com.startapp.p0;
import java.io.Serializable;

/* compiled from: Sta */
public abstract class VideoTrackingLink implements Serializable {
    private static final long serialVersionUID = 734821160635474852L;
    private boolean appendReplayParameter;
    private String replayParameter;
    @d9(type = TrackingSource.class)
    private TrackingSource trackingSource;
    private String trackingUrl;

    /* compiled from: Sta */
    public enum TrackingSource {
        STARTAPP,
        EXTERNAL
    }

    public void a(boolean z) {
        this.appendReplayParameter = z;
    }

    public void b(String str) {
        this.trackingUrl = str;
    }

    public String c() {
        return this.trackingUrl;
    }

    public boolean d() {
        return this.appendReplayParameter;
    }

    public String toString() {
        StringBuilder a = p0.a("trackingSource=");
        a.append(this.trackingSource);
        a.append(", trackingUrl=");
        a.append(this.trackingUrl);
        a.append(", replayParameter=");
        a.append(this.replayParameter);
        a.append(", appendReplayParameter=");
        a.append(this.appendReplayParameter);
        return a.toString();
    }

    public String a() {
        return this.replayParameter;
    }

    public TrackingSource b() {
        return this.trackingSource;
    }

    public void a(String str) {
        this.replayParameter = str;
    }
}
