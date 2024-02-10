package com.startapp.sdk.adsbase.commontracking;

/* compiled from: Sta */
public class CloseTrackingParams extends TrackingParams {
    private static final long serialVersionUID = -1873434013300932473L;
    private final long duration;

    public CloseTrackingParams(long j, String str) {
        super(str);
        this.duration = j;
    }

    public String e() {
        return super.e() + "&displayDuration=" + Math.max(0, this.duration);
    }
}
