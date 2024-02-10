package com.bytedance.sdk.openadsdk.api.banner;

public final class PAGBannerSize {
    public static final PAGBannerSize BANNER_W_300_H_250 = new PAGBannerSize(300, 250);
    public static final PAGBannerSize BANNER_W_320_H_50 = new PAGBannerSize(320, 50);
    public static final PAGBannerSize BANNER_W_728_H_90 = new PAGBannerSize(728, 90);
    private final int a;
    private final int b;

    public PAGBannerSize(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public int getWidth() {
        return this.a;
    }

    public int getHeight() {
        return this.b;
    }
}
