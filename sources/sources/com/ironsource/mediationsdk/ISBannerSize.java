package com.ironsource.mediationsdk;

import com.startapp.sdk.adsbase.model.AdPreferences;

public class ISBannerSize {
    public static final ISBannerSize BANNER = C0224n.a(AdPreferences.TYPE_BANNER, 320, 50);
    public static final ISBannerSize LARGE = C0224n.a("LARGE", 320, 90);
    public static final ISBannerSize RECTANGLE = C0224n.a("RECTANGLE", 300, 250);
    public static final ISBannerSize SMART = C0224n.a("SMART", 0, 0);
    protected static final ISBannerSize a = C0224n.a();
    private final int b;
    private final int c;
    private final String d;
    private boolean e;

    public ISBannerSize(int i, int i2) {
        this("CUSTOM", i, i2);
    }

    public ISBannerSize(String str, int i, int i2) {
        this.d = str;
        this.b = i;
        this.c = i2;
    }

    public String getDescription() {
        return this.d;
    }

    public int getHeight() {
        return this.c;
    }

    public int getWidth() {
        return this.b;
    }

    public boolean isAdaptive() {
        return this.e;
    }

    public boolean isSmart() {
        return this.d.equals("SMART");
    }

    public void setAdaptive(boolean z) {
        this.e = z;
    }
}
