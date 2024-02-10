package com.appnext.ads.fullscreen;

import com.appnext.core.SettingsManager;
import java.io.Serializable;

public class RewardedConfig extends VideoConfig implements Serializable {
    private String mode = "default";
    private int multiTimerLength = 3;

    public String getMode() {
        return this.mode;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public int getMultiTimerLength() {
        return this.multiTimerLength;
    }

    public void setMultiTimerLength(int i) {
        this.multiTimerLength = i;
    }

    /* access modifiers changed from: protected */
    public final SettingsManager g() {
        return f.o();
    }
}
