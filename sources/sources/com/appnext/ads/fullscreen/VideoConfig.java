package com.appnext.ads.fullscreen;

import com.appnext.base.a;
import com.appnext.core.Configuration;
import com.appnext.core.SettingsManager;
import java.io.Serializable;

public class VideoConfig extends Configuration implements Serializable {
    public int rollCaptionTime = -2;
    public Boolean showCta;
    public String videoLength = "15";

    public String getVideoLength() {
        return this.videoLength;
    }

    public void setVideoLength(String str) {
        if (str.equals("15") || str.equals("30")) {
            this.videoLength = str;
        } else {
            a.a("VideoConfig$setVideoLength", new Throwable("Wrong video length"));
        }
    }

    /* access modifiers changed from: protected */
    public SettingsManager g() {
        return c.h();
    }

    public int getRollCaptionTime() {
        return this.rollCaptionTime;
    }

    public void setRollCaptionTime(int i) {
        this.rollCaptionTime = i;
    }

    public boolean isShowCta() {
        Boolean bool = this.showCta;
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void setShowCta(boolean z) {
        this.showCta = Boolean.valueOf(z);
    }
}
