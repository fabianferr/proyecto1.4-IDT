package com.appnext.ads.fullscreen;

import com.appnext.core.SettingsManager;
import java.io.Serializable;

public class FullscreenConfig extends VideoConfig implements Serializable {
    public Boolean backButtonCanClose;
    public long closeDelay;
    public Boolean showClose;

    public FullscreenConfig() {
        this.backButtonCanClose = Boolean.TRUE;
        this.closeDelay = 2000;
        this.closeDelay = (long) Integer.parseInt(c.h().t("show_close_time"));
    }

    public boolean isBackButtonCanClose() {
        Boolean bool = this.backButtonCanClose;
        return bool == null ? Boolean.parseBoolean(c.h().t("can_close")) : bool.booleanValue();
    }

    public void setBackButtonCanClose(boolean z) {
        this.backButtonCanClose = Boolean.valueOf(z);
    }

    public boolean isShowClose() {
        Boolean bool = this.showClose;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void setShowClose(Boolean bool) {
        this.showClose = bool;
    }

    public void setShowClose(boolean z, long j) {
        this.showClose = Boolean.valueOf(z);
        if (j >= 100 && j <= 7500) {
            this.closeDelay = j;
        }
    }

    /* access modifiers changed from: protected */
    public final SettingsManager g() {
        return c.h();
    }
}
