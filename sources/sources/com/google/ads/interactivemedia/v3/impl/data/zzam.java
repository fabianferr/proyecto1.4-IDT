package com.google.ads.interactivemedia.v3.impl.data;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzam extends zzbq {
    private final Integer height;
    private final Integer width;

    zzam(Integer num, Integer num2) {
        this.width = num;
        this.height = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbq) {
            zzbq zzbq = (zzbq) obj;
            return this.width.equals(zzbq.width()) && this.height.equals(zzbq.height());
        }
    }

    public int hashCode() {
        return ((this.width.hashCode() ^ 1000003) * 1000003) ^ this.height.hashCode();
    }

    public Integer height() {
        return this.height;
    }

    public String toString() {
        Integer num = this.width;
        Integer num2 = this.height;
        return "SizeData{width=" + num + ", height=" + num2 + "}";
    }

    public Integer width() {
        return this.width;
    }
}
