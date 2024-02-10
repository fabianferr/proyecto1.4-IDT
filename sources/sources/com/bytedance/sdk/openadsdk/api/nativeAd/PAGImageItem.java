package com.bytedance.sdk.openadsdk.api.nativeAd;

public class PAGImageItem {
    private final int a;
    private final int b;
    private final String c;
    private float d;

    public PAGImageItem(int i, int i2, String str, float f) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = f;
    }

    public PAGImageItem(int i, int i2, String str) {
        this(i, i2, str, 0.0f);
    }

    public int getHeight() {
        return this.a;
    }

    public int getWidth() {
        return this.b;
    }

    public String getImageUrl() {
        return this.c;
    }

    public float getDuration() {
        return this.d;
    }
}
