package com.startapp.sdk.ads.video.tracking;

import com.startapp.p0;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;

/* compiled from: Sta */
public class VideoTrackingParams extends TrackingParams {
    private static final long serialVersionUID = 3395538490475548059L;
    private int completed;
    public boolean internalParamsIndicator;
    private String replayParameter;
    private boolean shouldAppendOffset;
    private String videoPlayingMode;

    public VideoTrackingParams(String str, int i, int i2, String str2) {
        super(str);
        a(i2);
        this.completed = i;
        this.videoPlayingMode = str2;
    }

    public VideoTrackingParams a(boolean z) {
        this.shouldAppendOffset = z;
        return this;
    }

    public String b(String str) {
        if (!this.internalParamsIndicator) {
            return c();
        }
        return super.e() + str;
    }

    public VideoTrackingParams c(String str) {
        this.replayParameter = str;
        return this;
    }

    public String e() {
        return b(g() + h());
    }

    public String g() {
        StringBuilder a = p0.a("&cp=");
        a.append(this.completed);
        return a.toString();
    }

    public String h() {
        StringBuilder a = p0.a("&vpm=");
        a.append(this.videoPlayingMode);
        return a.toString();
    }

    public String c() {
        if (!this.shouldAppendOffset) {
            return "";
        }
        String str = this.replayParameter;
        if (str != null) {
            return str.replace("%startapp_replay_count%", new Integer(b()).toString());
        }
        return super.c();
    }
}
