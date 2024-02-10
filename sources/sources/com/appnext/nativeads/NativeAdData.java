package com.appnext.nativeads;

import com.appnext.core.AppnextAd;

public class NativeAdData extends AppnextAd {
    private String selectedVideo = "";

    public NativeAdData(AppnextAd appnextAd) {
        super(appnextAd);
        if (appnextAd instanceof NativeAdData) {
            this.selectedVideo = ((NativeAdData) appnextAd).getSelectedVideo();
        }
    }

    public String getAppURL() {
        return super.getAppURL();
    }

    /* access modifiers changed from: protected */
    public void setAppURL(String str) {
        super.setAppURL(str);
    }

    /* access modifiers changed from: protected */
    public String getButtonText() {
        return super.getButtonText();
    }

    public String getSelectedVideo() {
        return this.selectedVideo;
    }

    /* access modifiers changed from: protected */
    public final void F(String str) {
        this.selectedVideo = str;
    }

    /* access modifiers changed from: protected */
    public String getCampaignGoal() {
        return super.getCampaignGoal();
    }

    /* access modifiers changed from: protected */
    public String getCptList() {
        return super.getCptList();
    }

    /* access modifiers changed from: protected */
    public String getWebview() {
        return super.getWebview();
    }

    /* access modifiers changed from: protected */
    public String getRevenueType() {
        return super.getRevenueType();
    }

    /* access modifiers changed from: protected */
    public String getImpressionURL() {
        return super.getImpressionURL();
    }

    /* access modifiers changed from: protected */
    public void setImpressionURL(String str) {
        super.setImpressionURL(str);
    }

    public String getSessionID() {
        return super.getSessionID();
    }
}
