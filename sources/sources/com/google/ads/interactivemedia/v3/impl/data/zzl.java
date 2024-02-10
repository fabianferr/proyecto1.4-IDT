package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzl extends zzat {
    private int height;
    private int left;
    private byte set$0;
    private int top;
    private int width;

    zzl() {
    }

    public zzau build() {
        if (this.set$0 == 15) {
            return new zzn(this.left, this.top, this.height, this.width);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.set$0 & 1) == 0) {
            sb.append(" left");
        }
        if ((this.set$0 & 2) == 0) {
            sb.append(" top");
        }
        if ((this.set$0 & 4) == 0) {
            sb.append(" height");
        }
        if ((this.set$0 & 8) == 0) {
            sb.append(" width");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    public zzat height(int i) {
        this.height = i;
        this.set$0 = (byte) (this.set$0 | 4);
        return this;
    }

    public zzat left(int i) {
        this.left = i;
        this.set$0 = (byte) (this.set$0 | 1);
        return this;
    }

    public zzat top(int i) {
        this.top = i;
        this.set$0 = (byte) (this.set$0 | 2);
        return this;
    }

    public zzat width(int i) {
        this.width = i;
        this.set$0 = (byte) (this.set$0 | 8);
        return this;
    }
}
