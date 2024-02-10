package com.appnext.ads.fullscreen;

import android.content.Context;
import com.appnext.base.a;

public class FullScreenVideo extends Video {
    private long closeDelay;
    private boolean showClose;

    public String getAUID() {
        return "700";
    }

    protected FullScreenVideo(Context context, FullScreenVideo fullScreenVideo) {
        super(context, fullScreenVideo);
        this.showClose = true;
        setShowClose(fullScreenVideo.isShowClose());
        setCloseDelay(fullScreenVideo.getCloseDelay());
        setBackButtonCanClose(fullScreenVideo.isBackButtonCanClose());
    }

    public FullScreenVideo(Context context, String str) {
        super(context, 1, str);
        this.showClose = true;
        this.closeDelay = (long) Integer.parseInt(getConfig().t("show_close_time"));
    }

    public FullScreenVideo(Context context, String str, FullscreenConfig fullscreenConfig) {
        super(context, 1, str, fullscreenConfig);
        this.showClose = true;
        if (fullscreenConfig != null) {
            try {
                setBackButtonCanClose(fullscreenConfig.isBackButtonCanClose());
                if (fullscreenConfig.showClose != null) {
                    setShowClose(fullscreenConfig.isShowClose());
                }
                setCloseDelay(fullscreenConfig.closeDelay);
            } catch (Throwable th) {
                a.a("FullScreenVideo$FullScreenVideo", th);
            }
        }
    }

    public boolean isShowClose() {
        return this.showClose;
    }

    public void setShowClose(boolean z) {
        this.showClose = z;
    }

    public void setShowClose(boolean z, long j) {
        this.showClose = z;
        if (j >= 100 && j <= 7500) {
            this.closeDelay = j;
        }
    }

    public long getCloseDelay() {
        return this.closeDelay;
    }

    /* access modifiers changed from: protected */
    public c getConfig() {
        return c.h();
    }

    /* access modifiers changed from: protected */
    public void setCloseDelay(long j) {
        this.closeDelay = j;
    }
}
