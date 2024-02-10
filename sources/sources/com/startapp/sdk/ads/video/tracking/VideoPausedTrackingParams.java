package com.startapp.sdk.ads.video.tracking;

import com.startapp.p0;

/* compiled from: Sta */
public class VideoPausedTrackingParams extends VideoTrackingParams {
    private static final long serialVersionUID = 4019115021800482057L;
    private int pauseNum;
    private PauseOrigin pauseOrigin;

    /* compiled from: Sta */
    public enum PauseOrigin {
        INAPP,
        EXTERNAL
    }

    public VideoPausedTrackingParams(String str, int i, int i2, int i3, PauseOrigin pauseOrigin2, String str2) {
        super(str, i, i2, str2);
        this.pauseNum = i3;
        this.pauseOrigin = pauseOrigin2;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(g());
        StringBuilder a = p0.a("&po=");
        a.append(this.pauseOrigin.toString());
        sb.append(a.toString());
        StringBuilder a2 = p0.a("&pn=");
        a2.append(this.pauseNum);
        sb.append(a2.toString());
        sb.append(h());
        return b(sb.toString());
    }
}
