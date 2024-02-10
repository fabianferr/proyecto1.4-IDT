package com.appnext.ads.interstitial;

import android.graphics.Color;
import com.appnext.base.a;
import com.appnext.core.Configuration;
import com.appnext.core.SettingsManager;
import java.io.Serializable;

public class InterstitialConfig extends Configuration implements Serializable {
    protected boolean aK = false;
    public Boolean autoPlay;
    public String buttonColor = "";
    public String creativeType = Interstitial.TYPE_MANAGED;
    public String skipText = "";

    @Deprecated
    public void setOrientation(String str) {
    }

    public void setCreativeType(String str) {
        if (str.equals(Interstitial.TYPE_MANAGED) || str.equals("static") || str.equals("video")) {
            this.creativeType = str;
        } else {
            a.a("InterstitialConfig$setCreativeType", new Throwable("Wrong creative type"));
        }
    }

    public String getCreativeType() {
        return this.creativeType;
    }

    /* access modifiers changed from: protected */
    public final SettingsManager g() {
        return c.E();
    }

    public boolean isAutoPlay() {
        try {
            Boolean bool = this.autoPlay;
            return bool == null ? Boolean.parseBoolean(c.E().t("auto_play")) : bool.booleanValue();
        } catch (Throwable th) {
            a.a("InterstitialConfig$isAutoPlay", th);
            return false;
        }
    }

    public void setAutoPlay(boolean z) {
        this.autoPlay = Boolean.valueOf(z);
    }

    public void setSkipText(String str) {
        if (str == null) {
            str = "";
        }
        this.skipText = str;
    }

    public String getSkipText() {
        return this.skipText;
    }

    public void setButtonColor(String str) {
        if (str == null) {
            this.buttonColor = "";
            return;
        }
        if (!str.startsWith("#")) {
            str = "#" + str;
        }
        try {
            Color.parseColor(str);
            this.buttonColor = str;
            this.aK = true;
        } catch (Throwable unused) {
            throw new IllegalArgumentException("Unknown color");
        }
    }

    public String getButtonColor() {
        return this.buttonColor;
    }

    @Deprecated
    public void setBackButtonCanClose(boolean z) {
        this.backButtonCanClose = Boolean.valueOf(z);
    }
}
