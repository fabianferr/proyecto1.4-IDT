package com.startapp.sdk.ads.nativead;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.startapp.p0;
import com.startapp.sdk.adsbase.model.AdPreferences;

/* compiled from: Sta */
public class NativeAdPreferences extends AdPreferences {
    private static final long serialVersionUID = 4908967312868830516L;
    private int adsNumber = 1;
    private boolean autoBitmapDownload = false;
    private NativeAdBitmapSize bitmapSize;
    private boolean isContentAd = false;
    private int moreImage = -1;
    private int primaryImage = -1;
    private boolean useSimpleToken = true;

    /* compiled from: Sta */
    public enum NativeAdBitmapSize {
        SIZE72X72(72, 72),
        SIZE100X100(100, 100),
        SIZE150X150(IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED, IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED),
        SIZE340X340(340, 340);
        
        public int height;
        public int width;

        private NativeAdBitmapSize(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public int getHeight() {
            return this.height;
        }

        public int getWidth() {
            return this.width;
        }
    }

    public NativeAdPreferences() {
    }

    public int getAdsNumber() {
        return this.adsNumber;
    }

    public NativeAdBitmapSize getImageSize() {
        return this.bitmapSize;
    }

    public int getPrimaryImageSize() {
        return this.primaryImage;
    }

    public int getSecondaryImageSize() {
        return this.moreImage;
    }

    public boolean isAutoBitmapDownload() {
        return this.autoBitmapDownload;
    }

    public boolean isContentAd() {
        return this.isContentAd;
    }

    public boolean isSimpleToken() {
        return this.useSimpleToken;
    }

    public NativeAdPreferences setAdsNumber(int i) {
        if (i > 0) {
            this.adsNumber = i;
            return this;
        }
        throw new IllegalArgumentException(String.valueOf(i));
    }

    public NativeAdPreferences setAutoBitmapDownload(boolean z) {
        this.autoBitmapDownload = z;
        return this;
    }

    public NativeAdPreferences setContentAd(boolean z) {
        this.isContentAd = z;
        return this;
    }

    public NativeAdPreferences setImageSize(NativeAdBitmapSize nativeAdBitmapSize) {
        this.bitmapSize = nativeAdBitmapSize;
        return this;
    }

    public NativeAdPreferences setPrimaryImageSize(int i) {
        this.primaryImage = i;
        return this;
    }

    public NativeAdPreferences setSecondaryImageSize(int i) {
        this.moreImage = i;
        return this;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("\n===== NativeAdConfig =====\n");
        StringBuilder a = p0.a("    adsNumber: [");
        a.append(getAdsNumber());
        a.append("]\n");
        stringBuffer.append(a.toString());
        stringBuffer.append("    autoBitmapDownload: [" + isAutoBitmapDownload() + "]\n");
        stringBuffer.append("    useSimpleToken: [" + isSimpleToken() + "]\n");
        stringBuffer.append("===== End NativeAdConfig =====");
        return stringBuffer.toString();
    }

    public NativeAdPreferences useSimpleToken(boolean z) {
        this.useSimpleToken = z;
        return this;
    }

    public NativeAdPreferences(NativeAdPreferences nativeAdPreferences) {
        super(nativeAdPreferences);
        this.adsNumber = nativeAdPreferences.adsNumber;
        this.autoBitmapDownload = nativeAdPreferences.autoBitmapDownload;
        this.bitmapSize = nativeAdPreferences.bitmapSize;
        this.primaryImage = nativeAdPreferences.primaryImage;
        this.moreImage = nativeAdPreferences.moreImage;
        this.isContentAd = nativeAdPreferences.isContentAd;
        this.useSimpleToken = nativeAdPreferences.useSimpleToken;
    }
}
