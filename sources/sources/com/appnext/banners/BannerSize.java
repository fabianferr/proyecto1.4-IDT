package com.appnext.banners;

import com.startapp.sdk.adsbase.model.AdPreferences;

public class BannerSize {
    public static final BannerSize BANNER = new BannerSize(320, 50, AdPreferences.TYPE_BANNER);
    public static final BannerSize LARGE_BANNER = new BannerSize(320, 100, "LARGE_BANNER");
    public static final BannerSize MEDIUM_RECTANGLE = new BannerSize(300, 250, "MEDIUM_RECTANGLE");
    private int bE;
    private int bF;
    private String bG;

    private BannerSize(int i, int i2, String str) {
        this.bE = i;
        this.bF = i2;
        this.bG = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BannerSize)) {
            return false;
        }
        BannerSize bannerSize = (BannerSize) obj;
        return this.bE == bannerSize.bE && this.bF == bannerSize.bF && this.bG.equals(bannerSize.bG);
    }

    public final int L() {
        return this.bE;
    }

    public final int M() {
        return this.bF;
    }

    public String toString() {
        return this.bG;
    }
}
