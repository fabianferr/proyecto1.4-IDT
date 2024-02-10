package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzn extends zzau {
    private final int height;
    private final int left;
    private final int top;
    private final int width;

    private zzn(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.height = i3;
        this.width = i4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzau) {
            zzau zzau = (zzau) obj;
            return this.left == zzau.left() && this.top == zzau.top() && this.height == zzau.height() && this.width == zzau.width();
        }
    }

    public int hashCode() {
        return ((((((this.left ^ 1000003) * 1000003) ^ this.top) * 1000003) ^ this.height) * 1000003) ^ this.width;
    }

    public int height() {
        return this.height;
    }

    public int left() {
        return this.left;
    }

    public String toString() {
        int i = this.left;
        int i2 = this.top;
        int i3 = this.height;
        int i4 = this.width;
        return "BoundingRectData{left=" + i + ", top=" + i2 + ", height=" + i3 + ", width=" + i4 + "}";
    }

    public int top() {
        return this.top;
    }

    public int width() {
        return this.width;
    }
}
