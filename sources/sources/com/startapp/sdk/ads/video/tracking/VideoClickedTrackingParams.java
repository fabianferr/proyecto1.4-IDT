package com.startapp.sdk.ads.video.tracking;

import com.facebook.share.internal.ShareConstants;
import com.startapp.p0;

/* compiled from: Sta */
public class VideoClickedTrackingParams extends VideoTrackingParams {
    private static final long serialVersionUID = 940417627850369979L;
    private boolean isVideoFinished;

    public VideoClickedTrackingParams(String str, int i, int i2, boolean z, String str2) {
        super(str, i, i2, str2);
        this.isVideoFinished = z;
    }

    public String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(g());
        StringBuilder a = p0.a("&co=");
        a.append(this.isVideoFinished ? "POSTROLL" : ShareConstants.VIDEO_URL);
        sb.append(a.toString());
        sb.append(h());
        return b(sb.toString());
    }
}
