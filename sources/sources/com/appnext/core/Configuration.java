package com.appnext.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public abstract class Configuration implements Serializable {
    public Boolean backButtonCanClose;
    private String categories = "";
    public String language = "";
    private String mSpecificCategories = "";
    public int maxVideoLength = 0;
    public int minVideoLength = 0;
    public Boolean mute;
    public String orientation = Ad.ORIENTATION_DEFAULT;
    public String postback = "";

    /* access modifiers changed from: protected */
    public abstract SettingsManager g();

    public void setCategories(String str) {
        this.categories = s(str);
    }

    public void setSpecificCategories(String str) {
        this.mSpecificCategories = s(str);
    }

    public void setPostback(String str) {
        this.postback = s(str);
    }

    public void setMute(boolean z) {
        this.mute = Boolean.valueOf(z);
    }

    public String getCategories() {
        return this.categories;
    }

    public String getSpecificCategories() {
        return this.mSpecificCategories;
    }

    public String getPostback() {
        return this.postback;
    }

    public boolean getMute() {
        Boolean bool = this.mute;
        return bool == null ? Boolean.parseBoolean(g().t(CampaignEx.JSON_NATIVE_VIDEO_MUTE)) : bool.booleanValue();
    }

    public String getOrientation() {
        return this.orientation;
    }

    public void setOrientation(String str) {
        if (str == null) {
            throw new IllegalArgumentException("orientation type");
        } else if (str.equals("automatic") || str.equals(Ad.ORIENTATION_DEFAULT) || str.equals(Ad.ORIENTATION_LANDSCAPE) || str.equals(Ad.ORIENTATION_PORTRAIT)) {
            this.orientation = str;
        } else {
            throw new IllegalArgumentException("Wrong orientation type");
        }
    }

    public int getMaxVideoLength() {
        return this.maxVideoLength;
    }

    public void setMaxVideoLength(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Max Length must be higher than 0");
        } else if (i <= 0 || getMinVideoLength() <= 0 || i >= getMinVideoLength()) {
            this.maxVideoLength = i;
        } else {
            throw new IllegalArgumentException("Max Length cannot be lower than min length");
        }
    }

    public int getMinVideoLength() {
        return this.minVideoLength;
    }

    public void setMinVideoLength(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Min Length must be higher than 0");
        } else if (i <= 0 || getMaxVideoLength() <= 0 || i <= getMaxVideoLength()) {
            this.minVideoLength = i;
        } else {
            throw new IllegalArgumentException("Min Length cannot be higher than max length");
        }
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    private static String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            if (str.equals(URLDecoder.decode(str, "UTF-8"))) {
                return URLEncoder.encode(str, "UTF-8");
            }
        } catch (UnsupportedEncodingException unused) {
        }
        return "";
    }

    @Deprecated
    public boolean isBackButtonCanClose() {
        Boolean bool = this.backButtonCanClose;
        return bool == null ? Boolean.parseBoolean(g().t("can_close")) : bool.booleanValue();
    }
}
